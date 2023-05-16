import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestingParameters {

    @BeforeTest
    public void setUp() {
        open("https://demoqa.com/automation-practice-form");
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

    @Test
    @Parameters({"firstName", "lastName", "gender", "number"})
    public void Test(@Optional("unknown") String firstName, String lastName, String gender, String number) {
        SelenideElement firstNameValue= $("#firstName");
        firstNameValue.sendKeys(firstName);
        SelenideElement lastNameValue = $("#lastName");
        lastNameValue.sendKeys(lastName);
        SelenideElement male = $("label[for='gender-radio-1']");
        male.click();
        SelenideElement numberValue = $("#userNumber");
        numberValue.sendKeys(number);

        Assert.assertEquals(firstNameValue.getValue(), firstName);








    }

}
