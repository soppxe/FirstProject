package Pages;

public abstract class LoadablePage {
    protected LoadablePage() {
    }
    protected abstract void checkPage();

    public void verifyPageLoaded() {
        checkPage();
    }
}
