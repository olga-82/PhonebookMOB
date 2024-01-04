package tests;

import config.AppiumConfig;
import dto.ContactDto;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ContactListPage;
import pages.SplashPage;

public class AddNewContactTest extends AppiumConfig {
    int i = (int) (System.currentTimeMillis() / 1000) % 3600;
    @BeforeMethod
    public void precondition() {
        new SplashPage(driver)
                .gotoAuthenticationPage()
//                .fillEmail("perry2275@gmail.com")
//                .fillPassword("Ch12345$")
                .fillEmail("cherry27@mail.com")
                .fillPassword("Ch12349$")
                .submitLogin();
    }
        @Test
        public void addNewContactPositive(){

            ContactDto contact = ContactDto.builder()
                    .name("Sara_" + i)
                    .lastName("Braun")
                    .phone("65840033" + i)
                    .email("cher_" + i + "@gmail.com")
                    .address("Tel Aviv")
                    .description("friend")
                    .build();
            Assert.assertTrue(
            new ContactListPage(driver)
                    .openContactForm()
                    .fillContactForm(contact)
                    .submitContact()
                   // .isContactAdded(contact)
                    .isContactAddedScroll(contact)

            );
        }

    }

