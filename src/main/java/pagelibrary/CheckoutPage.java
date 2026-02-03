package pagelibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.Utils;

public class CheckoutPage extends Utils {

    WebDriver driver;

    @FindBy(xpath="//button[text()='Checkout']")
    public static WebElement checkOutButton;


        public CheckoutPage(WebDriver driver){
            super(driver);
            this.driver = driver;
            PageFactory.initElements(driver,this);
        }

        public void clickOnCheckOutButton(){
            waitForVisibilityOfElementLocated(checkOutButton);
            checkOutButton.click();
    }
}
