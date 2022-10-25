package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utils.TCWebElementActions.*;

public class LoginPage extends BasePage<LoginPage> {

    @FindBy(id = "loginForm")
    private WebElement loginForm;

    @FindBy(id = "username")
    private WebElement usernameInputField;

    @FindBy(id = "password")
    private WebElement passwordInputField;

    @FindBy(id = "errorMessage")
    private WebElement errorText;

    @FindBy(id = "remember")
    private WebElement rememberCheckbox;

    @FindBy(css = "input[class*='loginButton']")
    private WebElement loginButton;

    @Override
    protected WebElement getPageLoadedIndicatorSelector() {
        return loginForm;
    }

    @Step("User writes {input} in username field")
    public LoginPage setUsername(String input) {
        usernameInputField.clear();
        setText(usernameInputField, input);
        return this;
    }

    @Step("User writes {input} in password field")
    public LoginPage setPassword(String input) {
        setText(passwordInputField, input);
        return this;
    }

    @Step("Click on Remember Me")
    public LoginPage checkRememberMe() {
        click(rememberCheckbox);
        return this;
    }

    @Step("Clicks login")
    public LoginPage clickLoginButton() {
        click(loginButton);
        return this;
    }

    public String getErrorText() {
        return getText(errorText);
    }

    public boolean isErrorTextDisplayed() {
        return isElementDisplayed(errorText);
    }

    public boolean isUsernameFieldRedBordered() {
        return usernameInputField.getAttribute("class").contains("errorField");
    }

    public boolean isPasswordFieldRedBordered() {
        return passwordInputField.getAttribute("class").contains("errorField");
    }

    public OverViewPage getOverViewPage() {
        return new OverViewPage().init();
    }

    @Override
    protected String getPath() {
        return "/login.html";
    }
}
