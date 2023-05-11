import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.File;

public class ConfigTests {


    // ანოტაციები უნდა დამეტოვა თუარა არვარ დარწმუნებული, რო ვუშლი სქრინშოთის მეთოდებს აღარ უშვებდა როცა ვიყენებდი
    // ამიტო დავტოვე რავი დ ორივენაირად ვცადე და ნუ არვიცი ზუსტად რომელი უნდა იყოს მარა დავტოვებ ასე ახლა როგორც მიწერია ანოტაციებით
    @BeforeTest
    public void setUp() {
        WebDriverRunner.getWebDriver().manage().window().maximize();
        Configuration.timeout = 10000;
        // ეს დაკომენტარებული იმიტორომაქვს რო რაღაც არ გამოდის, ანუ ტესტს უშვებს, ერთი გამოდის და მეორედ როხსნის ბრაუზერს
        // საიტზე აღარ შედის და მეორე გახსნაზე აერორებს და დავტოვე ასე დ შემოწმების დროს სცადეთ მერე და მიხვდებით რასაც ვიძახი
//        WebDriverManager.chromedriver().setup();
//        WebDriverRunner.setWebDriver(new ChromeDriver());
    }


    @Test
    public void screenshotRadioButtons() {
        File reportsFolder = new File("src/main/resources/RadioButtonFailedTests");
        if (!reportsFolder.exists()) {
            reportsFolder.mkdirs();
        }

        Configuration.reportsFolder = "src/main/resources/RadioButtonFailedTests";
        Configuration.screenshots = true;
        Configuration.savePageSource = false;

    }

    @Test
    public void screenshotCheckbox(){
        File reportsFolder = new File("src/main/resources/CheckboxFailedTests");
        if (!reportsFolder.exists()) {
            reportsFolder.mkdirs();
        }

        Configuration.reportsFolder = "src/main/resources/CheckboxFailedTests";
        Configuration.screenshots = true;
        Configuration.savePageSource = false;
    }

//    @AfterTest
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }

//    @AfterTest
//    public void tearDown() {
//        com.codeborne.selenide.WebDriverRunner.getWebDriver().quit();
//    }
}
