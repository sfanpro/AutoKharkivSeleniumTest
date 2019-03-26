package ua.autokharkiv.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class MainClass {
    public static void main( String[] args ) {
        //  иницилизируем chrome драйвер
        WebDriver driver = new ChromeDriver();
        // задаем неявные ожидания
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // разворачиваем окно на весь экран
        driver.manage().window().maximize();

        // устанавливаем подключение к сайту
        driver.get("https://auto.kharkiv.ua/");

        // инициализируем главную страницу, страницу регистрации и страницу входа
//        MainPage mainPage = new MainPage(driver);
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class); // используем Page Factory
        RegisterPage registerPage = new RegisterPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        // пробуем зарегестрироваться с неверными данными
        mainPage.clickRegister();
        registerPage.registerWithInvalidInput("qwer", "qwe", "qwe@123", "qwe");

        // пробуем залогинитьтся с неверными данными
        mainPage.clickLogin();
        loginPage.loginWithInvalidInput("asd", "asd");
    }
}
