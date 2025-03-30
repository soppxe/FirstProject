package org.example;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class LoginPage {
    private SelenideElement emailField = $(By.name("st.email"));
    private SelenideElement passwordField = $(By.name("st.password"));
    private SelenideElement loginButton = $(".button-pro.__wide");
    private SelenideElement errorMessage = $(".input-e.login_error");

    public void openPage() {
        open("https://ok.ru/?ysclid=m8qaqie2it932306182");
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

    public boolean isLoggedIn() {
        return $x("//a[contains(@href, '/dk?cmd')]").exists();
    }
}
