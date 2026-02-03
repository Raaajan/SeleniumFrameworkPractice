package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pagelibrary.LoginPage;

public class LoginTest extends BaseTest{

    LoginPage lp;

    @BeforeMethod
    public void initPage(){
        lp = new LoginPage(driver);
    }

    @Test
    public void userLogIn() {

        lp.enterUserName("dubeyrajan9154@gmail.com");
        lp.enterPassword("Rajan@123");
        lp.clickLoginButton();
    }


}
