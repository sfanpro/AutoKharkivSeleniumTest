package ua.autokharkiv.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class MainClass {
    public static void main( String[] args ) {
        //  initialize the chrome driver
        WebDriver driver = new ChromeDriver();
        // set implicit expectations
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // maximize the window
        driver.manage().window().maximize();

        // connect to the site
        driver.get("https://auto.kharkiv.ua/");

        // initialize the main page, registration page and login page
//        MainPage mainPage = new MainPage(driver);
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class); // используем Page Factory
        RegisterPage registerPage = new RegisterPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        // try to register with incorrect data
        mainPage.clickRegister();
        registerPage.registerWithInvalidInput("qwer", "qwe", "qwe@123", "qwe");

        // try to login with incorrect data
        mainPage.clickLogin();
        loginPage.loginWithInvalidInput("asd", "asd");
    }
}
