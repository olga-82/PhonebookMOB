package tests;

import config.AppiumConfig;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SplashPage;

public class SplashScreenTest extends AppiumConfig {
    @Test
    public void splashTest(){
        Assert.assertTrue(new SplashPage(driver).validateVersionCorrect());
    }

}