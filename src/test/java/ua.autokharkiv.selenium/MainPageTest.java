package ua.autokharkiv.selenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class MainPageTest {
    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://auto.kharkiv.ua/");
        mainPage = PageFactory.initElements(driver, MainPage.class);
    }

    @Test
    public void logInTest() {
        LoginPage loginPage = mainPage.clickLogin();
        String heading = loginPage.getHeadingText();
        Assert.assertEquals("Вход на сайт", heading);
    }

    @Test
    public void registerTest() {
        RegisterPage registerPage = mainPage.clickRegister();
        String heading = registerPage.getHeadingText();
        System.out.println(heading);
        Assert.assertEquals("Регистрация", heading);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
