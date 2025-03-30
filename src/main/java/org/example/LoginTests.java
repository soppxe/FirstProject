package org.example;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;


public class LoginTests {
    private LoginPage loginPage;

    @Before
    public void setUp() {
        loginPage = new LoginPage();
        loginPage.openPage();
    }

    @Test
    public void testValidLogin() {
        loginPage.setLogin("technopol40");
        loginPage.setPassword("technopolisPassword");
        loginPage.clickLoginButton();
        assertTrue("Вход выполнен, testValidLogin прошел успешно", loginPage.isLoggedIn());;
    }

    @Test
    public void testInvalidLogin() {
        loginPage.setLogin("invalidLogin");
        loginPage.setPassword("invalidPassword");
        loginPage.clickLoginButton();
        assertTrue("Вход не выполнен, testInvalidLogin прошел успешно", loginPage.isErrorMessageVisible());
    }

    @Test
    public void testEmptyLogin() {
        loginPage.setLogin("");
        loginPage.setPassword("technopolisPassword");
        loginPage.clickLoginButton();
        assertTrue("Вход не выполнен, testEmptyLogin прошел успешно", loginPage.isErrorMessageVisible());
    }

    @Test
    public void testEmptyPassword() {
        loginPage.setLogin("technopol40");
        loginPage.setPassword("");
        loginPage.clickLoginButton();
        assertTrue("Вход не выполнен,testEmptyPassword прошел успешно", loginPage.isErrorMessageVisible());
    }

    @Test
    public void testEmptyFields() {
        loginPage.setLogin("");
        loginPage.setPassword("");
        loginPage.clickLoginButton();
        assertTrue("Вход не выполнен, testEmptyFields прошел успешно", loginPage.isErrorMessageVisible());
    }
}
