import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class RadioButtonTests extends ConfigTests implements IRetryAnalyzer {

    private int retryCount = 0;
    private static final int MAX_RETRY_COUNT = 5;

    @BeforeTest
    @Override
    public void setUp() {
        super.setUp();
    }

    @BeforeTest
    public void config(){
        String baseUrl = "https://demoqa.com/radio-button";
        open(baseUrl);
    }

    @Test(groups = "BackEnd", priority = 2)
    public void yes(){

        config();
        SoftAssert softAssert = new SoftAssert();

        $(byXpath("//label[@for='yesRadio']")).click();

        softAssert.assertEquals($(".mt-3").getText(), "Yes");
        softAssert.assertAll();

        screenshotRadioButtons();



    }


    @Test
    public void no(){
        // failed case - ამას ვერ მივხვდი რას ნიშნავდა და ასე უნდოდა თუარა არვარ დარწმუნებული
        config();
        SoftAssert softAssert = new SoftAssert();
        boolean noRadio = $("#noRadio").exists();

        softAssert.assertTrue(noRadio);

        screenshotRadioButtons();
    }

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (retryCount < MAX_RETRY_COUNT) {
            retryCount++;
            return true;
        }
        return false;
    }
}
