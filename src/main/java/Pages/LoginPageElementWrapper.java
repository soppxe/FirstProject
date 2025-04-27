package Pages;

// Класс LoginPageElementWrapper оборачивает элементы страницы для упрощения взаимодействия, реализуем паттерн Wrapper

import com.codeborne.selenide.SelenideElement;

public class LoginPageElementWrapper {
    private final SelenideElement emailField;
    private final SelenideElement passwordField;
    private final SelenideElement loginButton;

    public LoginPageElementWrapper(SelenideElement emailField, SelenideElement passwordField, SelenideElement loginButton) {
        this.emailField = emailField;
        this.passwordField = passwordField;
        this.loginButton = loginButton;
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
}
