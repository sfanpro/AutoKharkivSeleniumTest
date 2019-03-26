package ua.autokharkiv.selenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginPageTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://auto.kharkiv.ua/login");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void loginWithEmptyCredsTest(){
        LoginPage newLoginPage = loginPage.loginWithInvalidInput("", "");
        String error = newLoginPage.getErrorText();
        Assert.assertEquals("Недействительные аутентификационные данные.", error);
    }

    @Test
    public void loginWithInvalidInputTest(){
        LoginPage newLoginPage = loginPage.loginWithInvalidInput("zxc", "zxc");
        String error = newLoginPage.getErrorText();
        Assert.assertEquals("Недействительные аутентификационные данные.", error);
    }

    @Test
    public void creatAccTest(){
        RegisterPage registerPage = loginPage.createAccount();
        String heading = registerPage.getHeadingText();
        Assert.assertEquals("Регистрация", heading);

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
