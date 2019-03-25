package ua.autokharkiv.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {
    private WebDriver driver;

    public MainPage( WebDriver driver ) {
        this.driver = driver;
    }

    @FindBy(xpath = "//a[@href='/login']")
    private WebElement login;

    @FindBy(xpath = "//a[text()='Регистрация']")
    private WebElement register;

    public LoginPage clickLogin() {
        login.click();
        return new LoginPage(driver);
    }

    public RegisterPage clickRegister() {
        register.click();
        return new RegisterPage(driver);
    }


}
