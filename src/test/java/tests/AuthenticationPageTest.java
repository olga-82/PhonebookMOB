package tests;

import config.AppiumConfig;

import io.appium.java_client.MobileElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AuthenticationPage;
import pages.SplashPage;


public class AuthenticationPageTest extends AppiumConfig {
    int i = (int) (System.currentTimeMillis() / 1000) % 3600;
    @Test
    public void RegistrationTestPositive() {
        Assert.assertTrue(
                new SplashPage(driver)
                        .gotoAuthenticationPage()
                        .fillEmail("perry" + i + "@gmail.com")
                        .fillPassword("Ch12345$")
                        .submitRegistration()
                        .isContactListActivityPresent()
        );
    }
    @Test
    public void RegistrationTestNegativeWrongEmail() {
        Assert.assertTrue(
                new SplashPage(driver)
                        .gotoAuthenticationPage()
                        .fillEmail("perry" + i + "gmail.com")
                        .fillPassword("Ch12345$")
                        .submitRegistrationNegative()
                       // .isErrorMessageContainsText("{username=must be a well-formed email address}")
                       .isAllertPresent("{username=must be a well-formed email address}")

        );




    }




}






