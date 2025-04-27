package Pages;

// Класс PageFactory используется для создания объектов страниц, реализуем паттерн Page Factory

public class PageFactory {
    public static HomePage getHomePage() {
        return new HomePage();
    }
    public LoginPage getLoginPage() {
        return new LoginPage();
    }
}
