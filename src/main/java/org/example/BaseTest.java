package org.example;

//BaseTest - базовый класс для всех тестов, который будет содержать логику открытия и закрытия браузера.

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {

    protected LoginPage loginPage;
    protected HomePage homePage;

    @BeforeEach
    public void setUp() {
        // Открытие браузера и настройка
        loginPage = new LoginPage();
        System.out.println("Running setUp method...");
        open("https://ok.ru/?ysclid=m8qaqie2it932306182");
    }

    @AfterEach
    public void tearDown() {
        // Закрытие браузера
        System.out.println("Running tearDown method...");
        closeWebDriver();
    }
}
