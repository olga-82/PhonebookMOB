package tests;

import config.AppiumConfig;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.ContactListPage;
import pages.SplashPage;

public class LoginTest extends AppiumConfig {

    @Test
    public void LoginPositive(){
        Assert.assertTrue(
    new SplashPage(driver)
            .gotoAuthenticationPage()
            .fillEmail("cherry27@mail.com")
            .fillPassword("Ch12349$")
            .submitLogin()
            .isContactListActivityPresent()
        );

    }
    @AfterMethod
    public void postcondition(){
       if(new ContactListPage(driver).isContactListActivityPresent()) {
           new ContactListPage(driver).logout();
           new SplashPage(driver);
       }

    }
}
