package pages;

import dto.ContactDto;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class AddNewContactPage extends BasePage {
    public AddNewContactPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy (id = "com.sheygam.contactapp:id/inputName")
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
    @FindBy (id = "com.sheygam.contactapp:id/createBtn")
    MobileElement createBtn;

    public AddNewContactPage fillContactForm(ContactDto contactDto){
        wait(createBtn,5);
        type(inputName,contactDto.getName());
        type(inputLastName,contactDto.getLastName());
        type(inputEmail,contactDto.getEmail());
        type(inputPhone,contactDto.getPhone());
        type(inputAddress,contactDto.getAddress());
        type(inputDescription,contactDto.getDescription());
        return this;

    }
public ContactListPage submitContact(){
        createBtn.click();
        return  new ContactListPage(driver);

}








}
