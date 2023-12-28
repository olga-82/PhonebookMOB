package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class ContactListPage extends BasePage{
    public ContactListPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@resource-id= 'com.sheygam.contactapp:id/action_bar']/android.widget.TextView")
    MobileElement activityViewText;

    @FindBy(xpath = "//*[@content-desc='More options']")
    MobileElement MoreOptions;

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/title']")
    MobileElement logoutButton;


    public String getCurrentPage() {
        return activityViewText.getText();
    }
    public boolean validatePageCorrect(){
        return isTextEqual(activityViewText, "Authentication");
    }
    public  boolean isContactListActivityPresent()  {
     return shouldHave(activityViewText, "Contact list",5);

}

public AuthenticationPage logout(){
        MoreOptions.click();
        logoutButton.click();
        return new AuthenticationPage(driver);
}
}
