package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasePage  {
    AppiumDriver<MobileElement> driver;
;
    public BasePage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean isTextEqual(MobileElement el, String text){
        return el.getText().equals(text);
    }
    public boolean shouldHave(MobileElement element, String text, int time) {
        return new WebDriverWait(driver, time)
                .until(ExpectedConditions.textToBePresentInElement(element,
                text));
    }
    public void type(MobileElement el, String text){
        el.click();
        el.clear();
        el.sendKeys(text);
        driver.hideKeyboard();
    }

    public void pause(int time){
        try {
            Thread.sleep(time);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void wait(MobileElement element,int time){
        new WebDriverWait(driver,time)
                .until(ExpectedConditions.visibilityOf(element));

    }
    public boolean isAllertPresent(String text){
        Alert alert= new WebDriverWait(driver,10)
                .until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert();
           boolean res =alert.getText().contains(text);
        alert.accept();
        return res;
    }

    }




