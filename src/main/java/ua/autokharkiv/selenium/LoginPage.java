package ua.autokharkiv.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    public LoginPage( WebDriver driver ) {
        this.driver = driver;
    }

    private By usernameField = By.xpath("//input[@name='_username']");
    private By passwordField = By.xpath("//input[@placeholder='Пароль']");
    private By loginButton = By.xpath("//button[@id='_submit']");
    private By checkboxRememberMe = By.xpath("//input[@type='checkbox']/following-sibling::span");
    private By heading = By.xpath("//h3[@class='form-title']");
    private By error = By.xpath("//div[@class='alert alert-danger']");
    private By createAccountLink = By.xpath("//a[@id='register-btn']");
    private By forgetPassword = By.xpath("//a[@id='forget-password']");
    private By forgetPasswordText = By.xpath("//form[@class='forget-form']/h3");

    public LoginPage typeUsername( String username ) {
        driver.findElement(usernameField).sendKeys(username);
        return this;
    }

    public LoginPage typePassword( String password ) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public LoginPage loginWithInvalidInput( String username, String password ) {
        this.typeUsername(username);
        this.typePassword(password);
        if (!driver.findElement(checkboxRememberMe).isSelected()) {
            driver.findElement(checkboxRememberMe).click();
        }
        driver.findElement(loginButton).click();
        return new LoginPage(driver);
    }

    public String getHeadingText() {
        return driver.findElement(heading).getText();
    }

    public String getErrorText() {
        return driver.findElement(error).getText();
    }

    public RegisterPage createAccount() {
        driver.findElement(createAccountLink).click();
        return new RegisterPage(driver);
    }
    public LoginPage forgetPasswordClick (){
        driver.findElement(forgetPassword).click();
        return  new LoginPage(driver);
    }
    public  String getForgetPasswordText (){
        return driver.findElement(forgetPasswordText).getText();
    }
}
