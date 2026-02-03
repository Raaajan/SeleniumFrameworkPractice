package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pagelibrary.AddToCartPage;

public class AddToCartTest extends BaseTest{

    AddToCartPage addCart;

    @BeforeMethod
    public void initPage(){
        addCart = new AddToCartPage(driver);
    }

    @Test
    public void enterValueInSearchBox(){
        addCart.enterValueInSearchBox("Automation");
        addCart.clickOnFirstAddToCartButton();
        String cartAddedSuccessMsg = addCart.getProductAddedToCartMsg();
        Assert.assertEquals(cartAddedSuccessMsg,"Product Added To Cart");

    }

    @Test(dependsOnMethods  = "enterValueInSearchBox")
    public void addToCart(){
        addCart.clickOnCart();
    }


}
