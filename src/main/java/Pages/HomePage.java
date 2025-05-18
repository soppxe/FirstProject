package Pages;

// HomePage - класс, ведущий нас к открытию домашней страницы после успешного входа

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class HomePage extends LoadablePage {
    private static final String loggedInElementLocator = "//a[contains(@href, '/dk?cmd')]";
    private static final String newsFeedLocator = "//div[contains(@class, 'feed-w')]";
    private static final String publicationButtonLocator = "//button[contains(@class, 'dropdown-button__qx55h')]";
    private static final String messageButtonLocator = "//button[contains(@id, 'msg_toolbar_button')]";
    private static final String searchButtonLocator = "//input[contains(@name, 'st.query')]";
    private static final String gamesButtonLocator = "//a[contains(@data-l, 't,appsShowcaseHD')]";
    private static final String firstPostCommentsButtonLocator = "(//a[contains(@aria-label, 'Комментарии')])";
    private static final String joinGroupButtonLocator = "//div[contains(@class, 'mp_mm_cont')]";


    private final SelenideElement loggedInElement;
    private final HomePageElementWrapper homePageElementWrapper;
    private final SelenideElement firstPostCommentsButton;

    public HomePage() {
        loggedInElement = $x(loggedInElementLocator).shouldBe(visible.because("Система не видит локатор домашней страницы"));
        verifyPageLoaded();

        // Инициализация других элементов
        SelenideElement newsFeed = $x(newsFeedLocator).shouldBe(visible.because("Система не видит локатор ленты"));
        SelenideElement publicationButton = $x(publicationButtonLocator).shouldBe(visible.because("Система не видит локатор кнопку ОПУБЛИКОВАТЬ"));
        SelenideElement messageButton = $x(messageButtonLocator).shouldBe(visible.because("Система не видит локатор кнопки СООБЩЕНИЯ"));
        SelenideElement searchButton = $x(searchButtonLocator).shouldBe(visible.because("Система не видит локатор кнопки ИСКАТЬ НА САЙТЕ"));
        SelenideElement gamesButton = $x(gamesButtonLocator).shouldBe(visible.because("Система не видит локатор кнопки ИГРЫ"));

        homePageElementWrapper = new HomePageElementWrapper(newsFeed,
                publicationButton, messageButton, searchButton,
                gamesButton);

        firstPostCommentsButton = $x(firstPostCommentsButtonLocator).shouldBe(visible);
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

    public boolean isNewsFeedVisible() {
        return homePageElementWrapper.isNewsFeedVisible();
    }

    public boolean isGamesButtonClickable() {
        return homePageElementWrapper.isGamesButtonClickable();
    }

    public boolean isPublicationButtonClickable() {
        return homePageElementWrapper.isPublicationButtonClickable();
    }

    public boolean isMessageButtonClickable() {
        return homePageElementWrapper.isMessageButtonClickable();
    }

    public void enterSearchText(String text) {
        homePageElementWrapper.enterSearchText(text);
    }

    public void clickFirstPostCommentsButton() {
        firstPostCommentsButton.click();

        // Проверка наличия всплывающего окна
        WebDriverWait wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(5));
        try {
            if (wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(joinGroupButtonLocator))) != null) {
                SelenideElement joinGroupButton = $x(joinGroupButtonLocator).shouldBe(visible);
                joinGroupButton.click();
            }
        } catch (Exception e) {
            // Если всплывающее окно не появилось, просто продолжаем выполнение
            System.out.println("Всплывающее окно не появилось, продолжаем выполнение.");
        }
    }
}
