package org.example;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class LoginTests extends BaseTest {

    @DisplayName("Проверка успешного входа с корректными данными")
    @Test
    public void testValidLogin() {
        String uniqueLogin = DataRegistry.generateUniqueUsername("technopol");
        // Реализация паттерна DataRegistry в LoginTests
        HomePage homePage = loginPage.login(new UserCredentials(uniqueLogin, "technopolisPassword"));
        assertAll("Проверка успешного входа",
                () -> assertTrue(homePage.isLoggedIn(), "Пользователь должен быть авторизован")
        );
    }

    @DisplayName("Проверка входа с некорректными данными")
    @ParameterizedTest // В LoginTests добавлен параметризованный тест с использованием @ParameterizedTest и @CsvSource, реализуем паттерн Data Provider
    @CsvSource({
            "invalidLogin, invalidPassword",
            " , technopolisPassword",
            "technopol40, ", " , "
    })
    public void testInvalidLogin(String login, String password) {
        loginPage.setLogin(login);
        loginPage.setPassword(password);
        loginPage.clickLoginButton();
        assertAll("Проверка неуспешного входа",
                () -> assertTrue(loginPage.isErrorMessageVisible(), "Сообщение об ошибке должно быть видимым")
        );
    }
}
