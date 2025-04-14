package org.example;

// Класс LoginPageElementWrapper оборачивает элементы страницы для упрощения взаимодействия, реализуем паттерн Wrapper

import com.codeborne.selenide.SelenideElement;

public class LoginPageElementWrapper {
    private final SelenideElement element;

    public LoginPageElementWrapper(SelenideElement element) {
        this.element = element;
    }

    public void setValue(String value) {
        element.setValue(value);
    }

    public void click() {
        element.click();
    }

    public boolean isDisplayed() {
        return element.isDisplayed();
    }
}
