import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class CheckboxTests extends ConfigTests {

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

    @Test
    public void uncheck() {
        config();
        SoftAssert softAssert = new SoftAssert();

        SelenideElement checkBox = $(byXpath("(//input[@type='checkbox'])"));
        boolean isChecked = checkBox.isSelected();

        if (isChecked) {
            checkBox.setSelected(false);
        }

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

//    @AfterTest
//    @Override
//    public void tearDown() {
//        super.tearDown();
//    }
}