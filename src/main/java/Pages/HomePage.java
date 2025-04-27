package Pages;

// HomePage - класс, ведущий нас к открытию домашней страницы после успешного входа

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Condition.visible;

public class HomePage extends LoadablePage {
    private static final String loggedInElementLocator = "//a[contains(@href, '/dk?cmd')]";
    private final SelenideElement loggedInElement;

    public HomePage() {
        loggedInElement = $x(loggedInElementLocator).shouldBe(visible.because("Система не видит локатор домашней страницы"));
        verifyPageLoaded();
    }

    @Override
    protected void checkPage() {
        System.out.println("Checking if home page is loaded...");
        if (loggedInElement == null || !loggedInElement.exists()) {
            System.out.println("Home page element not found!");
            throw new IllegalStateException("Home page is not loaded or user is not logged in.");
        }
    }

    public boolean isLoggedIn() { // Метод, проверяющий, смогли ли мы зайти на домашнюю страницу
        return loggedInElement.exists();
    }
}
