package org.example;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class LoginPage {
    private SelenideElement loginField = $("#field_login");
    private SelenideElement passwordField = $("#field_password");
    private SelenideElement loginButton = $(".button-pro");
    private SelenideElement errorMessage = $(".error_box");

    public void openPage() {
        open("https://ok.ru/?ysclid=m8qaqie2it932306182");
    }

    public void setLogin(String login) {
        loginField.setValue(login);
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

    public boolean isLoggedIn() {
        //Проверка, гарантирующая успешный вход (например, наличие элемента профиля)
        return $x("//a[contains(@href, '/profile')]").exists();
    }
}
