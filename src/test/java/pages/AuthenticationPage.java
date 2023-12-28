package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class AuthenticationPage extends BasePage {
    public AuthenticationPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }



    @FindBy(id = "com.sheygam.contactapp:id/inputEmail")
    MobileElement inputEmail;

    @FindBy(id = "com.sheygam.contactapp:id/inputPassword")
    MobileElement inputPassword;
    @FindBy(id  = "com.sheygam.contactapp:id/regBtn")
    MobileElement regButton;

    @FindBy(id = "com.sheygam.contactapp:id/loginBtn")
    MobileElement loginButton;



    public AuthenticationPage fillEmail(String email) {
        wait(inputEmail,5);
        type(inputEmail,email);
        return  this;

    }
    public AuthenticationPage fillPassword(String password) {
        type(inputPassword,password);
        return  this;

    }

    public ContactListPage submitLogin() {
        loginButton.click();
        return new ContactListPage(driver);

    }
}










