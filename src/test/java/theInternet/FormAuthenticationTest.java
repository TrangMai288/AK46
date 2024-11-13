package theInternet;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import supports.Browser;
import theInternet.pages.FormAuthenticationPage;

public class FormAuthenticationTest {
    @BeforeClass
    void setup() {
        Browser.openBrowser("chrome");
    }

    @Test
    void shouldBeSuccessfullyWithValidCredentials() {
        FormAuthenticationPage formAuthenticationPage = new FormAuthenticationPage();
        formAuthenticationPage.open();
        formAuthenticationPage.login("tomsmith", "SuperSecretPassword!");

        Assert.assertEquals(Browser.getCurrentUrl(), "https://the-internet.herokuapp.com/secure");
        Assert.assertTrue(formAuthenticationPage.isLoggedIn());
    }

    @AfterClass
    void tearDown() {
        Browser.quit();
    }
}
