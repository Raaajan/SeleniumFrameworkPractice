package utility;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utils {

    WebDriver driver;

    public Utils(WebDriver driver){
        this.driver = driver;
    }

    public void waitForVisibilityOfElementLocated(WebElement xpath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(xpath));
    }

    public void waitForElementToBeClickable(WebElement xpath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(xpath));
    }

    public void pause(int milisec){
       try {
           Thread.sleep(milisec);
       }catch(Exception e){
           System.out.println(e.getMessage());
       }
    }

    public String switchToAlertAndGetText(){
        Alert a = driver.switchTo().alert();
        String alertText = a.getText();
        return alertText;
    }

    public void clickUsingJavaScriptExecutor(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    public void sendkeysUsingJavaScriptExecutor(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    public void sendKeysUsingJS(WebElement element, String value) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value=arguments[1];", element, value);
    }
}
