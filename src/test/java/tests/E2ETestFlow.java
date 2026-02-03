package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pagelibrary.AddToCartPage;
import pagelibrary.CheckoutPage;
import pagelibrary.LoginPage;
import pagelibrary.PaceOrderPage;

public class E2ETestFlow {
    WebDriver driver;

    @Test
    public void E2EFlow() {
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/client/#/auth/login");
        driver.manage().window().maximize();
        LoginPage lp = new LoginPage(driver);
        lp.enterUserName("dubeyrajan9154@gmail.com");
        lp.enterPassword("Rajan@123");
        lp.clickLoginButton();

        AddToCartPage addCart = new AddToCartPage(driver);
        addCart.enterValueInSearchBox("Automation");
        addCart.clickOnFirstAddToCartButton();
        String cartAddedSuccessMsg = addCart.getProductAddedToCartMsg();
        Assert.assertEquals(cartAddedSuccessMsg,"Product Added To Cart");
        addCart.clickOnCart();

        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.clickOnCheckOutButton();

        PaceOrderPage po = new PaceOrderPage(driver);
        po.enterCVV("123");
        po.enterNameOnCard("Ramesh");
        po.clickApplyCoupon();
        po.selectCountry("India");
        po.setSelectCountry("India");
        po.clickPaceOrderButton();
        String text = po.verifyOrderSuccessMsg();
        Assert.assertEquals(text,"Click To Download Order Details in CSV");
    }
}
