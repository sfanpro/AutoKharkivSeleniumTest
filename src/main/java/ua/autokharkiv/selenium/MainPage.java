package ua.autokharkiv.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *Здесь используется selenium класс Page Factory
 */
public class MainPage {
    // initialize the driver
    private WebDriver driver;

    // build constructor
    public MainPage( WebDriver driver ) {
        this.driver = driver;
    }

    // initialize login page
    @FindBy(xpath = "//a[@href='/login']")
    private WebElement login;

    // initialize register page
    @FindBy(xpath = "//a[text()='Регистрация']")
    private WebElement register;

    // follow the link to the login page
    public LoginPage clickLogin() {
        login.click();
        return new LoginPage(driver);
    }

    // follow the link to the register page
    public RegisterPage clickRegister() {
        register.click();
        return new RegisterPage(driver);
    }


}
