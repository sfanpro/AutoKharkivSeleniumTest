package ua.autokharkiv.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    // initialize the driver
    private WebDriver driver;

    // build constructor
    public LoginPage( WebDriver driver ) {
        this.driver = driver;
    }

    // initialize our variables: fields and page elements
    private By usernameField = By.xpath("//input[@name='_username']");
    private By passwordField = By.xpath("//input[@placeholder='Пароль']");
    private By loginButton = By.xpath("//button[@id='_submit']");
    private By checkboxRememberMe = By.xpath("//input[@type='checkbox']/following-sibling::span");
    private By heading = By.xpath("//h3[@class='form-title']");
    private By error = By.xpath("//div[@class='alert alert-danger']");
    private By createAccountLink = By.xpath("//a[@id='register-btn']");

    // name input method
    public LoginPage typeUsername( String username ) {
        driver.findElement(usernameField).sendKeys(username);
        return this;
    }

    // password input method
    public LoginPage typePassword( String password ) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    // login with invalid data method
    public LoginPage loginWithInvalidInput( String username, String password ) {
        this.typeUsername(username);
        this.typePassword(password);
        if (!driver.findElement(checkboxRememberMe).isSelected()) {
            driver.findElement(checkboxRememberMe).click();
        }
        driver.findElement(loginButton).click();
        return new LoginPage(driver);
    }

    // getting the page header text method
    public String getHeadingText() {
        return driver.findElement(heading).getText();
    }

    // getting text error page method
    public String getErrorText() {
        return driver.findElement(error).getText();
    }

    // click on the link "Create an account" method
    public RegisterPage createAccount() {
        driver.findElement(createAccountLink).click();
        return new RegisterPage(driver);
    }
}
