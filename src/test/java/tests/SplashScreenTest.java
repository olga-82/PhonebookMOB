package tests;

import config.AppiumConfig;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SplashPage;

public class SplashScreenTest extends AppiumConfig {

    @Test
    public void splashTest(){
        String version =new SplashPage(driver).getCurrentVersion();
        Assert.assertTrue(version.contains("1.0.0"));
        Assert.assertTrue(new SplashPage(driver).validateVersionCorrect());
    }

}