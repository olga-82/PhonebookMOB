package pages;

import dto.ContactDto;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class ContactListPage extends BasePage {
    public ContactListPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    String phoneNumber;
    @FindBy(xpath = "//*[@resource-id= 'com.sheygam.contactapp:id/action_bar']/android.widget.TextView")
    MobileElement activityViewText;

    @FindBy(xpath = "//*[@content-desc='More options']")
    MobileElement MoreOptions;

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/title']")
    MobileElement logoutButton;
    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/add_contact_btn']")
    MobileElement addContactBtn;
    @FindBy(xpath = "//*[@resource-id='android:id/button1']")
    MobileElement yesBtn;
    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/emptyTxt']")
    MobileElement emptyTxt;

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/rowContainer']")
    List<MobileElement> contacts;

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/rowName']")
    List<MobileElement> names;

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/rowPhone']")
    List<MobileElement> phones;


    public String getCurrentPage() {
        return activityViewText.getText();
    }

    public boolean validatePageCorrect() {
        return isTextEqual(activityViewText, "Authentication");
    }

    public boolean isContactListActivityPresent() {
        return shouldHave(activityViewText, "Contact list", 5);

    }

    public AuthenticationPage logout() {
        MoreOptions.click();
        logoutButton.click();
        return new AuthenticationPage(driver);
    }

    public AddNewContactPage openContactForm() {
        wait(addContactBtn, 5);
        addContactBtn.click();
        return new AddNewContactPage(driver);
    }

    public boolean isContactAdded(ContactDto contact) {
        boolean checkName = checkContainsText(names, contact.getName() + " " + contact.getLastName());
        boolean checkPhone = checkContainsText(phones, contact.getPhone());
        return checkName && checkPhone;
    }

    public boolean checkContainsText(List<MobileElement> list, String text) {
        for (MobileElement element : list) {
            if (element.getText().contains(text)) return true;
        }
        return false;

    }

    public ContactListPage removeOneContact() {
        wait(addContactBtn, 5);
        MobileElement contact = contacts.get(0);
        phoneNumber = phones.get(0).getText();
        Rectangle rect = contact.getRect();
        int xStart = rect.getX() + rect.getWidth() / 8;
        int xEnd = xStart + rect.getWidth() * 6 / 8;
        int yStart = rect.getY() + rect.getHeight() / 2;

        TouchAction<?> touchAction = new TouchAction<>(driver);
        touchAction.longPress(PointOption.point(xStart, yStart))
                .moveTo(PointOption.point(xEnd, yStart))
                .release()
                .perform();
        pause(2000);
        yesBtn.click();
        pause(3000);
        return this;
    }

    public boolean isContactRemoved() {
        boolean res = phones.contains(phoneNumber);
        return !res;
    }
    public  ContactListPage removeAllContacts( ){
      wait(addContactBtn,5);
      while(contacts.size() > 0){
          removeOneContact();
      }
         return this;
    }
public boolean isNotContacts(){
    return  shouldHave(emptyTxt,"No Contacts. Add One more!",5);
}
public ContactListPage provideContacts() {
    while (contacts.size() < 3) {
        addNewContact();

    }
    return this;
}
public ContactListPage addNewContact() {
    int i = (int) (System.currentTimeMillis() / 1000) % 3600;

    ContactDto contact = ContactDto.builder()
            .name("Sara_" + i)
            .lastName("Braun")
            .phone("65840033" + i)
            .email("cher_" + i + "@gmail.com")
            .address("Tel Aviv")
            .description("friend")
            .build();

    new ContactListPage(driver)
            .openContactForm()
            .fillContactForm(contact)
            .submitContact();

    return this;
}
public EditContactPage editContact(){
    wait(addContactBtn, 5);
    MobileElement contact = contacts.get(0);
    Rectangle rect = contact.getRect();
    int xStart = rect.getX() + rect.getWidth() / 8;
    int xEnd = xStart + rect.getWidth() * 6 / 8;
    int yStart = rect.getY() + rect.getHeight() / 2;

    TouchAction<?> touchAction = new TouchAction<>(driver);
    touchAction.longPress(PointOption.point(xEnd, yStart))
            .moveTo(PointOption.point(xStart, yStart))
            .release()
            .perform();

    pause(2000);
    return new EditContactPage(driver);
}
public boolean isContactContains(String text){
        contacts.get(0).click();
    ContactDto contactDto = new ViewContactPage(driver)
            .viewContactObject();
    driver.navigate().back();
    return contactDto.toString().contains(text);

}
    public ContactListPage scrollContact(){
        wait(addContactBtn, 5);
        MobileElement contact = contacts.get(contacts.size() - 1);
        Rectangle rect = contact.getRect();

        int x = rect.getX() + rect.getWidth() / 2;

        int y = rect.getY() + rect.getHeight() / 2;

        TouchAction<?> touchAction = new TouchAction<>(driver);
        touchAction.longPress(PointOption.point(x, y))
                .moveTo(PointOption.point(x, 0))
                .release()
                .perform();
        return this;
    }
    public boolean isEndOfList(){

        String beforeScroll =names.get(names.size()-1).getText()+
                " " +phones.get(phones.size()-1).getText();
        scrollContact();

        String afterScroll=names.get(names.size()-1).getText()+
                " " +phones.get(phones.size()-1).getText();

        if(beforeScroll.equals(afterScroll))
            return true;

          return false;
    }
public boolean isContactAddedScroll(ContactDto contact){
    boolean res = false;
while (!res) {
    boolean checkName = checkContainsText(names, contact.getName() + " " + contact.getLastName());
    boolean checkPhone = checkContainsText(phones, contact.getPhone());

    res = checkName && checkPhone;
    if(res==false)isEndOfList();

}
    return res;
}



}
