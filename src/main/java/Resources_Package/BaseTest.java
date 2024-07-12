package Resources_Package;

import Config_Package.Config;
import Page_Objects.Login_Page_Object;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;


public class BaseTest {

    public static Properties prop;
    public static AppiumDriver driver;

//    Login_Page_Object lpg=new Login_Page_Object();
//    public BaseTest(AppiumDriver driver)
//    {
//        this.driver= driver;
//        PageFactory.initElements(driver,this);
//    }

    @Parameters({"platformName","deviceName"})
    @BeforeTest
    public void init( String platformName,@Optional("TestDevice3") String deviceName) throws IOException, URISyntaxException {

        //BaseTest bs=new BaseTest(driver);

        prop=new Properties();

        FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\config.properties");
        prop.load(fis);

        String AndroidAppPackageName=prop.getProperty("AndroidAppPackageName");
        String AndroidAppActivityName=prop.getProperty("AndroidAppActivityName");
        String AndroidAutomationname=prop.getProperty("AndroidAutomationName");
        String AppiumURL=prop.getProperty("AppiumURL");

        DesiredCapabilities cap=new DesiredCapabilities();
        cap.setCapability("platformName",platformName);
        cap.setCapability("deviceName",deviceName);
        cap.setCapability("automationName",AndroidAutomationname);
        cap.setCapability("appPackage",AndroidAppPackageName);
        cap.setCapability("appActivity",AndroidAppActivityName);

        URI url=new URI(AppiumURL);

        PageFactory.initElements(driver, BaseTest.class);
        driver=new AndroidDriver(url.toURL(),cap);


    }


    @AfterTest
    public void afterTest()
    {
        driver.quit();
    }

    public static WebDriver getDriver()
    {
        return driver;
    }

}
