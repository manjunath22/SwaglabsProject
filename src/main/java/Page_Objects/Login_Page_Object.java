package Page_Objects;

import Actions.LoginAction;
//import Resources_Package.BaseTest;
import Config_Package.Config;
import Resources_Package.BaseTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;


public class Login_Page_Object extends BaseTest {

    //static AppiumDriver driver;

    public Login_Page_Object(AppiumDriver driver)
    {
        this.driver= driver;
//        PageFactory.initElements(driver,this);
        PageFactory.initElements(new AppiumFieldDecorator(BaseTest.getDriver()), this);
    }

    LoginAction action=new LoginAction();
    @CacheLookup
    @AndroidFindBy(xpath="//android.widget.EditText[@content-desc=\"test-Username\"]")
    public WebElement userName;


    public Login_Page_Object enter_user_name(String username)
    {
        action.sendKeys(userName,username);
        return this;
    }

    @AndroidFindBy(accessibility = "test-LOGIN")
    private WebElement login_Button;

    public Login_Page_Object clikLoginBtn()
    {
        action.click(login_Button);
        return this;
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Password is required\"]")
    private WebElement actual_error_msg;

    public String getErrorMsg()
    {
        return action.getText(actual_error_msg);

    }

}
