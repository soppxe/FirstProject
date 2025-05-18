package Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class CommentPage extends LoadablePage {
    private static final String commentInputLocator = "//div[contains(@data-placeholder, 'Скажите пару слов...')]";
    private static final String sendCommentButtonLocator = "//button[contains(@aria-label, 'Отправить комментарий')]";
    private static final String postedCommentLocator = "//span[contains(text(), text)]";

    private final SelenideElement commentInput;
    private final SelenideElement sendCommentButton;
    private final SelenideElement postedComment;

    public CommentPage() {

        // Ожидание появления текстового поля для комментария
        WebDriverWait wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(commentInputLocator)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sendCommentButtonLocator)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(postedCommentLocator)));

        // Инициализация элементов для написания и отправки комментария
        commentInput = $x(commentInputLocator).shouldBe(visible);
        sendCommentButton = $x(sendCommentButtonLocator).shouldBe(visible);
        postedComment = $x(postedCommentLocator).shouldBe(visible);
    }

    @Override
    protected void checkPage() {
        System.out.println("Checking if comment page is loaded...");
        if (commentInput == null || !commentInput.exists()) {
            System.out.println("Comment page element not found!");
            throw new IllegalStateException("Comment page is not loaded.");
        }
    }

    public void enterComment(String text) {
        // Вводим текст комментария
        commentInput.setValue(text);
    }

    public void clickSendCommentButton() {
        // Нажимаем на кнопку отправки комментария
        sendCommentButton.click();
    }

    public boolean isCommentPosted() {
        // Проверяем, что комментарий опубликован
        return postedComment.isDisplayed();
    }
}

