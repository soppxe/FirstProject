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
        loginPage.setLogin("validLogin");
        loginPage.setPassword("validPassword");
        loginPage.clickLoginButton();
        assertTrue("Вход не выполнен", loginPage.isLoggedIn());;
    }

    @Test
    public void testInvalidLogin() {
        loginPage.setLogin("invalidLogin");
        loginPage.setPassword("invalidPassword");
        loginPage.clickLoginButton();
        assertTrue(loginPage.isErrorMessageVisible());
    }

    @Test
    public void testEmptyLogin() {
        loginPage.setLogin("");
        loginPage.setPassword("validPassword");
        loginPage.clickLoginButton();
        assertTrue("Сообщение об ошибке не отображается", loginPage.isErrorMessageVisible());
    }

    @Test
    public void testEmptyPassword() {
        loginPage.setLogin("validLogin");
        loginPage.setPassword("");
        loginPage.clickLoginButton();
        assertTrue("Сообщение об ошибке не отображается", loginPage.isErrorMessageVisible());
    }

    @Test
    public void testEmptyFields() {
        loginPage.setLogin("");
        loginPage.setPassword("");
        loginPage.clickLoginButton();
        assertTrue("Сообщение об ошибке не отображается", loginPage.isErrorMessageVisible());
    }
}
