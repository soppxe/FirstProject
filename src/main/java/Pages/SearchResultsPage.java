package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Condition.visible;

public class SearchResultsPage extends LoadablePage {
    private static final String searchResultsLocator = "//div[starts-with(@class, 'search-content')]";

    private final SelenideElement searchResults;

    public SearchResultsPage() {
        // Инициализация элемента для проверки результатов поиска
        searchResults = $x(searchResultsLocator).shouldBe(visible.because("Система не видит локатор результатов поиска"));
        verifyPageLoaded();
    }

    @Override
    protected void checkPage() {
        System.out.println("Checking if search results page is loaded...");
        if (searchResults == null || !searchResults.exists()) {
            System.out.println("Search results page element not found!");
            throw new IllegalStateException("Search results page is not loaded.");
        }
    }

    public boolean isSearchResultsVisible() {
        // Проверяем, что результаты поиска видимы
        return searchResults.isDisplayed();
    }
}

