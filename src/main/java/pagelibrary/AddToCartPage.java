package pagelibrary;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.Utils;

public class AddToCartPage extends Utils {

    @FindBy(xpath="//section[@id='sidebar']//input[@name='search']")
            public static WebElement searchBox;

    @FindBy(xpath = "(//div[@class='card-body']//button[text()=' Add To Cart'])[1]")
        public  static WebElement addToCartButton;

    @FindBy(xpath="//button[@routerlink='/dashboard/cart']")
        public static WebElement cartIcon;

    @FindBy(xpath = "//div[@role='alert' and text()=' Product Added To Cart ']")
            public static WebElement cartAddAlertSuccessMsg;

    WebDriver driver;

    public AddToCartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void enterValueInSearchBox(String value){
        waitForVisibilityOfElementLocated(searchBox);
        searchBox.sendKeys(value);
        searchBox.sendKeys(Keys.ENTER);
        pause(3000);
    }

    public void clickOnFirstAddToCartButton(){
        waitForVisibilityOfElementLocated(addToCartButton);
        addToCartButton.click();
    }

    public String getProductAddedToCartMsg(){
        waitForVisibilityOfElementLocated(cartAddAlertSuccessMsg);
        String cartAddText = cartAddAlertSuccessMsg.getText();
        pause(5000);
        return cartAddText;
    }

    public void clickOnCart(){
        waitForElementToBeClickable(cartIcon);
        cartIcon.click();
    }

}
