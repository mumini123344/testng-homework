import org.testng.annotations.DataProvider;

public class CustomDataProvider {

    @DataProvider(name = "LoginDataProvider")
    public Object[][] StudentRegistration() {
        Object[][] data = {{"Vazha", "Pshavela", "Male", "555555555"},
                {"Ilia", "Chavchavadze", "Male", "111111111"},
                {"Nino", "Sadgobelashvili", "Female", "333333333"}};
        return data;
    }

}

