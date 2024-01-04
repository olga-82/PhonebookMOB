package tests;

import config.AppiumConfig;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ContactListPage;
import pages.SplashPage;

public class RemoveContactsTests extends AppiumConfig {
    @BeforeClass
    public void precondition() {
        new SplashPage(driver)
                .gotoAuthenticationPage()
                .fillEmail("perry2275@gmail.com")
                .fillPassword("Ch12345$")
                .submitLogin();
    }
    @BeforeMethod
    public void providerContacts() {
   new ContactListPage(driver)
           .provideContacts();

    }
    @Test
    public void removeOneContactsPositive() {
        Assert.assertTrue(
        new ContactListPage(driver)
                .removeOneContact()
                .isContactRemoved()
        );
    }
    @Test
    public void removeAllContactsPositive() {
        Assert.assertTrue(
        new ContactListPage(driver)
           .removeAllContacts()
           .isNotContacts()
        );
    }

}
