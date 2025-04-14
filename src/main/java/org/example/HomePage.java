package org.example;

// HomePage - класс, ведущий нас к открытию домашней страницы после успешного входа

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Condition.visible;

public class HomePage {
    private static final String loggedInElementLocator = "//a[contains(@href, '/dk?cmd')]";

    private final SelenideElement loggedInElement = $x(loggedInElementLocator).shouldBe(visible.because("Система не видит локатор домашней страницы"));

    //В LoginPage и HomePage добавлены проверки видимости элементов, реализуем паттерн Loadable Component.

    public boolean isLoggedIn() { // Метод, проверяющий, смогли ли мы зайти на домашнюю страницу
        return loggedInElement.exists();
    }
}
