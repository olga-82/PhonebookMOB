package tests;

import config.AppiumConfig;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ContactListPage;
import pages.SplashPage;

public class EditContactTest extends AppiumConfig {

    int i = (int) (System.currentTimeMillis() / 1000) % 3600;
    @BeforeMethod
    public void precondition() {
        new SplashPage(driver)
                .gotoAuthenticationPage()
                .fillEmail("cherry27@mail.com")
                .fillPassword("Ch12349$")
                .submitLogin();
    }
@Test
    public void editOneContactPositive( ){
String text = "updated_"+i+"@gmail.com";
new ContactListPage(driver)
        .editContact()
        .editEmail(text)
        .submitEditContact()
        .isContactContains(text);

}


}
