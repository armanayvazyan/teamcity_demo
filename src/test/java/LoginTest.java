import config.Configurations;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    void successfulLogin() {
        var overViewPage = new LoginPage().open()
                .setUsername(Configurations.TC_USERNAME)
                .setPassword(Configurations.TC_PASSWORD)
                .clickLoginButton()
                .getOverViewPage();
        assertEquals(overViewPage.getCurrentUrl(), overViewPage.getPageUrl());
    }

    @Test
    void tryToLoginWithEmptyPassword() {
        var loginPage = new LoginPage().open()
                .setUsername(Configurations.TC_USERNAME)
                .clickLoginButton();

        assertTrue(loginPage.isErrorTextDisplayed(), "Error text is missing");
        assertTrue(loginPage.isUsernameFieldRedBordered(), "Red border is missing from username field");
        assertTrue(loginPage.isPasswordFieldRedBordered(), "Red border is missing from password field");
        assertEquals(loginPage.getErrorText(), "Incorrect username or password.", "Error text is wrong");
    }

    @Test
    void tryToLoginWithEmptyUsername() {
        var loginPage = new LoginPage().open()
                .setPassword(Configurations.TC_PASSWORD)
                .clickLoginButton();

        assertTrue(loginPage.isErrorTextDisplayed(), "Error text is missing");
        assertTrue(loginPage.isUsernameFieldRedBordered(), "Red border is missing from username field");
        assertTrue(loginPage.isPasswordFieldRedBordered(), "Red border is missing from password field");
        assertEquals(loginPage.getErrorText(), "Incorrect username or password.", "Error text is wrong");
    }
}
