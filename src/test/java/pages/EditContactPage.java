package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class EditContactPage extends BasePage{
    public EditContactPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(id = "com.sheygam.contactapp:id/inputName")
    MobileElement inputName;
    @FindBy (id = "com.sheygam.contactapp:id/inputLastName")
    MobileElement inputLastName;
    @FindBy (id = "com.sheygam.contactapp:id/inputEmail")
    MobileElement inputEmail;
    @FindBy (id = "com.sheygam.contactapp:id/inputPhone")
    MobileElement inputPhone;
    @FindBy (id = "com.sheygam.contactapp:id/inputAddress")
    MobileElement inputAddress;
    @FindBy (id = "com.sheygam.contactapp:id/inputDesc")
    MobileElement inputDescription;
    @FindBy (id = "com.sheygam.contactapp:id/updateBtn")
    MobileElement updateBtn;

    public ContactListPage submitEditContact(){
       updateBtn.click();
        return  new ContactListPage(driver);

    }
    public EditContactPage editEmail(String text){
        wait(updateBtn,5);
        type(inputEmail,text);
        return this;

    }

}
