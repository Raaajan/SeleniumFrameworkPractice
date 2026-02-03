package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pagelibrary.CheckoutPage;

public class CheckoutTest extends BaseTest {


    CheckoutPage checkout;

    @BeforeMethod
    public void initPage(){
        checkout = new CheckoutPage(driver);
    }

    @Test
    public void clickCheckOutButton(){
        checkout.clickOnCheckOutButton();
    }

}
