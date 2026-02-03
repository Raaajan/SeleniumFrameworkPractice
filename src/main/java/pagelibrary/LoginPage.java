package pagelibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.Utils;

public class LoginPage extends Utils {

    WebDriver driver;

    @FindBy(id="userEmail")
    public static WebElement username;

    @FindBy(id = "userPassword")
    public static WebElement password;

    @FindBy(name = "login")
    public static WebElement loginbtn;

    public LoginPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void enterUserName(String usrname){
        username.sendKeys(usrname);
    }

    public void enterPassword(String passwrd){
        password.sendKeys(passwrd);
    }

    public void clickLoginButton(){
        loginbtn.click();
        pause(3000);
    }


}
