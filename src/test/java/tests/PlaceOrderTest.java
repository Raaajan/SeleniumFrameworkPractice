package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pagelibrary.PaceOrderPage;

public class PlaceOrderTest extends BaseTest{

    PaceOrderPage po;

    @BeforeMethod
    public void initPage(){
        po = new PaceOrderPage(driver);
    }

    @Test
    public void fillDetailsAndPlaceOrder(){
        po.enterCVV("123");
        po.enterNameOnCard("Ramesh");
        po.clickApplyCoupon();
        po.selectCountry("India");
        po.setSelectCountry("India");
        po.clickPaceOrderButton();

    }

    @Test (dependsOnMethods = "fillDetailsAndPlaceOrder")
    public void verifySuccessMsg(){
        String text = po.verifyOrderSuccessMsg();
        Assert.assertEquals(text,"Click To Download Order Details in CSV");
    }



}
