package Tests;

import Page_Objects.Login_Page_Object;
import Resources_Package.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SwaglabsLoginTest  extends BaseTest {


//    static AppiumDriver driver;
//
//    Login_Page_Object lpg=new Login_Page_Object();
//
//    public SwaglabsLoginTest(AppiumDriver driver) {
//       this.driver=driver;
//       PageFactory.initElements(driver,this);
//    }

//    public SwaglabsLoginTest(){    PageFactory.initElements(BaseTest.driver, this);}
    //SwaglabsLoginTest st=new SwaglabsLoginTest(driver);

    @Test
    public void swaglabs_login_invalid_username()
{
    Login_Page_Object lpg=new Login_Page_Object(driver);
    lpg.enter_user_name("InvalidUser");
    lpg.clikLoginBtn();
    String actual_error_msg=lpg.getErrorMsg();
    String expected_error_msg="Password is required";
    Assert.assertEquals(actual_error_msg,expected_error_msg);
    System.out.println("Test Passed");
}


}
