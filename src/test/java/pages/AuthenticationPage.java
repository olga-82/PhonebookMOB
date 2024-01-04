package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AuthenticationPage extends BasePage {
    public AuthenticationPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }


    @FindBy(id = "com.sheygam.contactapp:id/inputEmail")
    MobileElement inputEmail;

    @FindBy(id = "com.sheygam.contactapp:id/inputPassword")
    MobileElement inputPassword;
    @FindBy(id = "com.sheygam.contactapp:id/regBtn")
    MobileElement regButton;

    @FindBy(id = "com.sheygam.contactapp:id/loginBtn")
    MobileElement loginButton;
    @FindBy(id = "android:id/message")
    MobileElement errorTextMessage;

    @FindBy(id = "android:id/button1")
    MobileElement okButton;


    public AuthenticationPage fillEmail(String email) {
        wait(inputEmail, 5);
        type(inputEmail, email);
        return this;

    }

    public AuthenticationPage fillPassword(String password) {
        type(inputPassword, password);
        return this;

    }

    public ContactListPage submitLogin() {
        loginButton.click();
        return new ContactListPage(driver);

    }

    public ContactListPage submitRegistration() {
        regButton.click();
        return new ContactListPage(driver);

    }

    public AuthenticationPage submitRegistrationNegative(){
    regButton.click();
    return this;
}
public boolean isErrorMessageContainsText(String message){
        return errorTextMessage.getText().contains(message);
}
    }













