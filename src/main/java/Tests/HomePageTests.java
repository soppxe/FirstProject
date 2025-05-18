package Tests;

import Pages.CommentPage;
import Pages.HomePage;
import Pages.SearchResultsPage;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class HomePageTests extends BaseTest {

    @BeforeEach
    public void setUp() {
        super.setUp();
        performLogin(); // Выполняем вход перед каждым тестом
    }

    @DisplayName("Проверка успешного входа на домашнюю страницу")
    @Test
    public void testHomePageLoad() {
        // Создаем объект HomePage для проверки успешного входа
        HomePage homePage = new HomePage();
        // Проверяем, что пользователь авторизован
        assertTrue(homePage.isLoggedIn(), "Пользователь должен быть авторизован");
    }

    @DisplayName("Проверка отображения ленты новостей")
    @Test
    public void testNewsFeedDisplay() {
        // Создаем объект HomePage для проверки отображения ленты новостей
        HomePage homePage = new HomePage();
        // Проверяем, что лента новостей видима
        assertTrue(homePage.isNewsFeedVisible(), "Лента новостей должна быть видимой");
    }

    @DisplayName("Проверка отображения кнопки ИГРЫ")
    @Test
    public void testGamesButtonClickability() {
        // Создаем объект HomePage для проверки отображения кнопки ИГРЫ
        HomePage homePage = new HomePage();
        // Проверяем, что кнопка ИГРЫ видима
        assertTrue(homePage.isGamesButtonClickable(), "Кнопка ИГРЫ должна быть видимой");
    }

    @DisplayName("Проверка возможности кликнуть на кнопку ОПУБЛИКОВАТЬ")
    @Test
    public void testPublicationButtonClickability() {
        // Создаем объект HomePage для проверки возможности клика на кнопку ОПУБЛИКОВАТЬ
        HomePage homePage = new HomePage();
        // Проверяем, что кнопка ОПУБЛИКОВАТЬ кликабельна
        assertTrue(homePage.isPublicationButtonClickable(), "Кнопка ОПУБЛИКОВАТЬ должна быть кликабельной");
    }

    @DisplayName("Проверка возможности кликнуть на кнопку СООБЩЕНИЕ")
    @Test
    public void testMessageButtonClickability() {
        // Создаем объект HomePage для проверки возможности клика на кнопку СООБЩЕНИЕ
        HomePage homePage = new HomePage();
        // Проверяем, что кнопка СООБЩЕНИЕ кликабельна
        assertTrue(homePage.isMessageButtonClickable(), "Кнопка СООБЩЕНИЕ должна быть кликабельной");
    }

    @DisplayName("Проверка ввода текста в поле поиска")
    @Test
    public void testSearchTextEntry() {
        // Создаем объект HomePage для проверки ввода текста в поле поиска
        HomePage homePage = new HomePage();
        // Вводим текст в поле поиска
        homePage.enterSearchText("Привет");
        // Создаем объект SearchResultsPage для проверки результатов поиска
        SearchResultsPage searchResultsPage = new SearchResultsPage();
        // Проверяем, что пользователь перенаправлен на страницу поиска
        assertTrue(searchResultsPage.isSearchResultsVisible(), "Пользователь должен быть перенаправлен на страницу поиска");
    }

    @DisplayName("Проверка написания и отправки комментария на первый пост")
    @Test
    public void testCommentPosting() {
        // Создаем объект HomePage для проверки написания и отправки комментария
        HomePage homePage = new HomePage();
        // Нажимаем на кнопку комментариев первого поста
        homePage.clickFirstPostCommentsButton();

        // Создаем объект CommentPage для проверки написания и отправки комментария
        CommentPage commentPage = new CommentPage();
        // Вводим текст комментария
        commentPage.enterComment("Привет");
        // Нажимаем на кнопку отправки комментария
        commentPage.clickSendCommentButton();

        // Проверяем, что комментарий опубликован
        assertTrue(commentPage.isCommentPosted(), "Комментарий должен быть опубликован");
    }
}




