package Tests;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;

import Pages.LoginPage;
import org.example.DataRegistry;
import Pages.HomePage;
import org.example.UserCredentials;
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
        HomePage homePage = new LoginPage()
                .setLogin("technopol40")
                .setPassword("technopolisPassword")
                .clickLoginButton()
                .getHomePage();

        // Проверяем, что пользователь авторизован
        assertTrue(homePage.isLoggedIn(), "Пользователь должен быть авторизован");
    }


    @DisplayName("Проверка входа с некорректными данными")
    @ParameterizedTest // В LoginTests добавлен параметризованный тест с использованием @ParameterizedTest и @CsvSource, реализуем паттерн Data Provider
    @CsvSource({
            "invalidLogin, invalidPassword",
            " , technopolisPassword",
            "technopol40, ", " , "
    })
    public void testInvalidLogin(String login, String password) {
        LoginPage loginPage = new LoginPage()
                .setLogin(login)
                .setPassword(password)
                .clickLoginButton()
                .getLoginPage();

        // Проверяем, что сообщение об ошибке видимо
        assertTrue(loginPage.isErrorMessageVisible(), "Сообщение об ошибке должно быть видимым");
    }
}
