package Pages;
import com.codeborne.selenide.SelenideElement;
import org.example.UserCredentials;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class LoginPage extends LoadablePage {
    private static final By emailFieldLocator = By.name("st.email");
    private static final By passwordFieldLocator = By.name("st.password");
    private static final By loginButtonLocator = By.xpath("//input[@type='submit']");
    private static final By errorMessageLocator = By.cssSelector(".input-e.login_error");

    private final LoginPageElementWrapper loginFormWrapper;
    private final SelenideElement errorMessage;

    public LoginPage() {
        SelenideElement emailField = $(emailFieldLocator).shouldBe(visible);
        SelenideElement passwordField = $(passwordFieldLocator).shouldBe(visible);
        SelenideElement loginButton = $(loginButtonLocator).shouldBe(visible);

        loginFormWrapper = new LoginPageElementWrapper(emailField, passwordField, loginButton);
        errorMessage = $(errorMessageLocator);
    }

    @Override
    protected void checkPage() {
        $(emailFieldLocator).shouldBe(visible);
        $(passwordFieldLocator).shouldBe(visible);
        $(loginButtonLocator).shouldBe(visible);
    }

    public LoginPage setLogin(String login) {
        loginFormWrapper.setLogin(login);
        return this;
    }

    public LoginPage setPassword(String password) {
        loginFormWrapper.setPassword(password);
        return this;
    }

    public PageFactory clickLoginButton() {
        loginFormWrapper.clickLoginButton();
        return new PageFactory();
    }

    public boolean isErrorMessageVisible() {
        return errorMessage.isDisplayed();
    }

    public HomePage login(UserCredentials credentials) {
        setLogin(credentials.getLogin());
        setPassword(credentials.getPassword());
        clickLoginButton();
        return PageFactory.getHomePage();
    }
    // Метод login возвращает объект HomePage для цепочки вызовов, реализуем паттерн Chain of Invocations
}
