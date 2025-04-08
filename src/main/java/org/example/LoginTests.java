package org.example;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;


public class LoginTests extends BaseTest {
    private static final String validLogin = "technopol40";
    private static final String validPassword = "technopolisPassword";
    private static final String invalidLogin = "invalidLogin";
    private static final String invalidPassword = "invalidPassword";

    @DisplayName("Проверка успешного входа с корректными данными")
    @Test
    public void testValidLogin() {
        loginPage.setLogin(validLogin);
        loginPage.setPassword(validPassword);
        loginPage.clickLoginButton();
        homePage = new HomePage();
        assertAll("Проверка успешного входа",
                () -> assertTrue(homePage.isLoggedIn(), "Пользователь должен быть авторизован")
        );
    }

    @DisplayName("Проверка входа с некорректными данными")
    @Test
    public void testInvalidLogin() {
        loginPage.setLogin(invalidLogin);
        loginPage.setPassword(invalidPassword);
        loginPage.clickLoginButton();
        assertAll("Проверка неуспешного входа",
                () -> assertTrue(loginPage.isErrorMessageVisible(), "Сообщение об ошибке должно быть видимым")
        );
    }

    @DisplayName("Проверка входа с пустым логином")
    @Test
    public void testEmptyLogin() {
        loginPage.setLogin("");
        loginPage.setPassword(validPassword);
        loginPage.clickLoginButton();
        assertAll("Проверка неуспешного входа",
                () -> assertTrue(loginPage.isErrorMessageVisible(), "Сообщение об ошибке должно быть видимым")
        );
    }

    @DisplayName("Проверка входа с пустым паролем")
    @Test
    public void testEmptyPassword() {
        loginPage.setLogin(validLogin);
        loginPage.setPassword("");
        loginPage.clickLoginButton();
        assertAll("Проверка неуспешного входа",
                () -> assertTrue(loginPage.isErrorMessageVisible(), "Сообщение об ошибке должно быть видимым")
        );
    }

    @DisplayName("Проверка входа с пустыми полями")
    @Test
    public void testEmptyFields() {
        loginPage.setLogin("");
        loginPage.setPassword("");
        loginPage.clickLoginButton();
        assertAll("Проверка неуспешного входа",
                () -> assertTrue(loginPage.isErrorMessageVisible(), "Сообщение об ошибке должно быть видимым")
        );
    }
}
