package org.example;

// Класс PageFactory используется для создания объектов страниц, реализуем паттерн Page Factory

public class PageFactory {
    public static HomePage getHomePage() {
        return new HomePage();
    }
}
