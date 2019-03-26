package ua.autokharkiv.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *Здесь используется selenium класс Page Factory
 */
public class MainPage {
    // создаем драйвер
    private WebDriver driver;

    // создаем конструктор
    public MainPage( WebDriver driver ) {
        this.driver = driver;
    }

    // инициализируем стриницу входа
    @FindBy(xpath = "//a[@href='/login']")
    private WebElement login;

    // инициализируем стриницу регисрации
    @FindBy(xpath = "//a[text()='Регистрация']")
    private WebElement register;

    // переходим на страницу входа
    public LoginPage clickLogin() {
        login.click();
        return new LoginPage(driver);
    }

    // переходим на страницу регистрации
    public RegisterPage clickRegister() {
        register.click();
        return new RegisterPage(driver);
    }


}
