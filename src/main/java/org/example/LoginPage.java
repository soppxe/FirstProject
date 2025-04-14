package org.example;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class LoginPage {
    private static final By emailFieldLocator = By.name("st.email");
    private static final By passwordFieldLocator = By.name("st.password");
    private static final By loginButtonLocator = By.cssSelector(".button-pro.__wide");
    private static final By errorMessageLocator = By.cssSelector(".input-e.login_error");

    private final LoginPageElementWrapper emailField;
    private final LoginPageElementWrapper passwordField;
    private final LoginPageElementWrapper loginButton;
    private final SelenideElement errorMessage;

    public LoginPage() {
        emailField = new LoginPageElementWrapper($(emailFieldLocator).shouldBe(visible));
        passwordField = new LoginPageElementWrapper($(passwordFieldLocator).shouldBe(visible));
        loginButton = new LoginPageElementWrapper($(loginButtonLocator).shouldBe(visible));
        errorMessage = $(errorMessageLocator);
    }

    public void setLogin(String login) {
        emailField.setValue(login);
    }

    public void setPassword(String password) {
        passwordField.setValue(password);
    }

    public void clickLoginButton() {
        loginButton.click();
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
