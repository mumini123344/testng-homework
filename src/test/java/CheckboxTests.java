import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.testng.ScreenShooter;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;


public class CheckboxTests extends ConfigTests implements IRetryAnalyzer {

    private int retryCount = 0;
    private static final int MAX_RETRY_COUNT = 5;

    @BeforeTest
    @Override
    public void setUp() {
        super.setUp();
    }

    @BeforeTest
    public static void config() {
        String baseUrl = "http://the-internet.herokuapp.com/checkboxes";
        open(baseUrl);
    }


    @Test(groups = "FrontEnd", priority = 1)
    public void uncheck() {
        config();
        SoftAssert softAssert = new SoftAssert();
//
        ElementsCollection checkBox = $$(byXpath("(//input[@type='checkbox'])"));
//        boolean isChecked = checkBox.isSelected();
//        if (isChecked) {
//            checkBox.setSelected(false);
//        }
//        softAssert.assertAll();
        checkBox.forEach(element -> {
            if (element.isSelected()) {
                element.click();
                softAssert.assertTrue(element.isSelected());
            }
        });
        softAssert.assertAll();
        screenshotCheckbox();

    }


    @Test
    public void check() {
        config();
        SoftAssert softAssert = new SoftAssert();

        SelenideElement checkBox = $(byXpath("(//input[@type='checkbox'])"));
        boolean isChecked = checkBox.isSelected();

        if (!isChecked) {
            checkBox.setSelected(true);
        }

        softAssert.assertAll();
        screenshotCheckbox();
    }

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (retryCount < MAX_RETRY_COUNT) {
            retryCount++;
            return true;
        }
        return false;
    }


//    @AfterTest
//    @Override
//    public void tearDown() {
//        super.tearDown();
//    }
}
