package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class SplashPage extends BasePage {
    public SplashPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/version_text']")
    MobileElement versionText;

    public String getCurrentVersion() {
        return versionText.getText();
    }
    public boolean validateVersionCorrect(){
        return isTextEqual(versionText, "Version 1.0.0");
    }

public AuthenticationPage gotoAuthenticationPage() {
    return new AuthenticationPage(driver);
    }

}
//resource-id="com.sheygam.contactapp:id/version_text"