package Actions;

import Resources_Package.BaseTest;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;



public class LoginAction extends BaseTest {


//    public LoginAction(AppiumDriver driver) {
//        super(driver);
//    }

    public void waitForWebElement(WebElement element)
    {

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(120)) ;
        wait.until(ExpectedConditions.visibilityOf(element));
      //driver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);
    }

    public void click(WebElement element)
    {
        waitForWebElement(element);
        element.click();
    }

    public void sendKeys(WebElement element,String text)
    {
        waitForWebElement(element);
        element.sendKeys(text);
    }

    public String getText(WebElement element)
    {
        waitForWebElement(element);
        return element.getText();
    }
}
