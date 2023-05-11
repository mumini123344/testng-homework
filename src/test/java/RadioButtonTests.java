import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class RadioButtonTests extends ConfigTests{

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

    @Test
    public void yes(){
        config();
        SoftAssert softAssert = new SoftAssert();

//        $("yesRadio").selectRadio("Yes");
        SelenideElement yesOption = $(byXpath("//input[@id='yesRadio']"));
        yesOption.parent().click();

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

}
