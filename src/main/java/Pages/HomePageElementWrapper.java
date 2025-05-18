package Pages;

import com.codeborne.selenide.SelenideElement;

public class HomePageElementWrapper {
    private final SelenideElement newsFeed;
    private final SelenideElement publicationButton;
    private final SelenideElement messageButton;
    private final SelenideElement searchButton;
    private final SelenideElement gamesButton;

    public HomePageElementWrapper(SelenideElement newsFeed,
                                  SelenideElement publicationButton,
                                  SelenideElement messageButton, SelenideElement searchButton,
                                  SelenideElement gamesButton) {
        this.newsFeed = newsFeed;
        this.publicationButton = publicationButton;
        this.messageButton = messageButton;
        this.searchButton = searchButton;
        this.gamesButton = gamesButton;

    }

    public boolean isNewsFeedVisible() {
        // Проверяем, что лента новостей видима
        return newsFeed.isDisplayed();
    }

    public boolean isGamesButtonClickable() {
        // Проверяем, что кнопка ИГРЫ видима и кликабельна
        return gamesButton.isDisplayed() && gamesButton.isEnabled();
    }

    public boolean isPublicationButtonClickable() {
        // Проверяем, что кнопка ОПУБЛИКОВАТЬ видима и кликабельна
        return publicationButton.isDisplayed() && publicationButton.isEnabled();
    }

    public boolean isMessageButtonClickable() {
        // Проверяем, что кнопка СООБЩЕНИЕ видима и кликабельна
        return messageButton.isDisplayed() && messageButton.isEnabled();
    }

    public void enterSearchText(String text) {
        // Вводим текст в поле поиска и нажимаем Enter
        searchButton.setValue(text).pressEnter();
    }
}

