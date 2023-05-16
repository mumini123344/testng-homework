import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DataProviderTest {

    @BeforeTest
    public void setUp(){
        open("https://demoqa.com/automation-practice-form");
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

    @Test(dataProvider = "LoginDataProvider", dataProviderClass = CustomDataProvider.class)
    public void Test(String firstName, String lastName, String gender, String number){
        SelenideElement firstNameValue= $("#firstName");
        firstNameValue.sendKeys(firstName);
        SelenideElement lastNameValue = $("#lastName");
        lastNameValue.sendKeys(lastName);
        SelenideElement male = $("label[for='gender-radio-1']");
        SelenideElement female = $("label[for='gender-radio-2']");

        if (Objects.equals(firstName, "Nino")){
            female.click();
        }else {
            male.click();
        }

        SelenideElement numberValue = $("#userNumber");
        numberValue.sendKeys(number);


        // Clearing inputs after each test
        firstNameValue.clear();
        lastNameValue.clear();
        // ვცადე ანქლიქი ექნა მარა არ შვრება
        SelenideElement maleUncheck = $("label[for='gender-radio-1']");
        maleUncheck.click();
        numberValue.clear();

    }

}
