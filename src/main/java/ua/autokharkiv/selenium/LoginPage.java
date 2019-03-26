package ua.autokharkiv.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    // создаем драйвер
    private WebDriver driver;

    // создаем конструктор
    public LoginPage( WebDriver driver ) {
        this.driver = driver;
    }

    // создаем наши переменные это поля и элементы страницы
    private By usernameField = By.xpath("//input[@name='_username']");
    private By passwordField = By.xpath("//input[@placeholder='Пароль']");
    private By loginButton = By.xpath("//button[@id='_submit']");
    private By checkboxRememberMe = By.xpath("//input[@type='checkbox']/following-sibling::span");
    private By heading = By.xpath("//h3[@class='form-title']");
    private By error = By.xpath("//div[@class='alert alert-danger']");
    private By createAccountLink = By.xpath("//a[@id='register-btn']");

    // метод для ввода имени
    public LoginPage typeUsername( String username ) {
        driver.findElement(usernameField).sendKeys(username);
        return this;
    }

    // метод для ввода пароля
    public LoginPage typePassword( String password ) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    // метод для входа с недействительными данными
    public LoginPage loginWithInvalidInput( String username, String password ) {
        this.typeUsername(username);
        this.typePassword(password);
        if (!driver.findElement(checkboxRememberMe).isSelected()) {
            driver.findElement(checkboxRememberMe).click();
        }
        driver.findElement(loginButton).click();
        return new LoginPage(driver);
    }

    // метод для получения текста заголовка страницы
    public String getHeadingText() {
        return driver.findElement(heading).getText();
    }

    // метод для получения текста ошибки страницы
    public String getErrorText() {
        return driver.findElement(error).getText();
    }

    // метод для перехода по ссылке "Создать аккаунт"
    public RegisterPage createAccount() {
        driver.findElement(createAccountLink).click();
        return new RegisterPage(driver);
    }
}
