package pagelibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.Utils;

public class PaceOrderPage extends Utils {
    WebDriver driver;

    @FindBy(xpath="//*[text()='CVV Code ']/parent::div/input")
    public static WebElement cvvCode;

    @FindBy(xpath="//*[text()='Name on Card ']/parent::div/input")
    public static WebElement nameOnCard;

    @FindBy(name = "coupon")
    public static WebElement coupon;

    @FindBy(xpath = "//button[text()='Apply Coupon']")
    public static WebElement applyCouponButton;

    @FindBy(xpath = "//div[@class='form-group']/input")
    public static WebElement selectCountry;

    @FindBy(xpath = "//*[text()=' India']")
    public  static WebElement selectCountryDropdown;

    @FindBy(xpath = "//*[text()='Place Order ']")
    public  static WebElement placeOrderButton;

    @FindBy(xpath = "//table[@class='order-summary']//button")
    public static WebElement downloadCSVOrder;


    public PaceOrderPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void enterCVV(String cvv){
        waitForVisibilityOfElementLocated(cvvCode);
        cvvCode.sendKeys(cvv);
    }

    public void enterNameOnCard(String name){
        nameOnCard.sendKeys(name);
    }

    public void enterCoupon(String coupn){
        coupon.sendKeys(coupn);
    }

    public void clickApplyCoupon(){
        waitForVisibilityOfElementLocated(applyCouponButton);
        applyCouponButton.click();
    }

    public void selectCountry(String country){
        waitForVisibilityOfElementLocated(selectCountry);
        selectCountry.click();
        selectCountry.sendKeys(country);
        //sendKeysUsingJS(selectCountry,country);
    }

    public void setSelectCountry(String countryName){
        waitForVisibilityOfElementLocated(selectCountryDropdown);
        selectCountryDropdown.click();
    }

    public void clickPaceOrderButton(){
        waitForVisibilityOfElementLocated(placeOrderButton);
        placeOrderButton.click();
    }

    public String verifyOrderSuccessMsg(){
        waitForVisibilityOfElementLocated(downloadCSVOrder);
        String actualMsg = downloadCSVOrder.getText();
        return actualMsg;
    }


}
