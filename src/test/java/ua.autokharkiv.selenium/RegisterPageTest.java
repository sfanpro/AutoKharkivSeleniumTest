package ua.autokharkiv.selenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class RegisterPageTest {
    WebDriver driver;
    RegisterPage registerPage;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://auto.kharkiv.ua/register/");
        registerPage = new RegisterPage(driver);
    }

    @Test
    public void registerWithEmptyNameTest() {
        registerPage.registerWithInvalidInput("", "123", "qwe@qwe.we", "qwe");
        String nameErrorText = registerPage.getNameErrorText();
        Assert.assertEquals("This field is required.", nameErrorText);
    }

    @Test
    public void registerWithEmptyPhoneTest() {
        registerPage.registerWithInvalidInput("123", "", "qwe@qwe.re", "123");
        String nameErrorText = registerPage.getPhoneErrorText();
        Assert.assertEquals("This field is required.", nameErrorText);
    }

    @Test
    public void registerWithEmptyPasswordTest() {
        registerPage.registerWithInvalidInput("123", "123", "qwe@qwe.re", "");
        String nameErrorText = registerPage.getPasswordErrorText();
        Assert.assertEquals("This field is required.", nameErrorText);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
