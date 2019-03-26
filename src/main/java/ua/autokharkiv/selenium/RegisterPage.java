package ua.autokharkiv.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    // initialize the driver
    private WebDriver driver;

    // build constructor
    public RegisterPage( WebDriver driver ) {
        this.driver = driver;
    }

    // initialize our variables: fields and page elements
    private By heading = By.xpath("//h3[text()='Регистрация']");
    private By nameField = By.xpath("//input[@placeholder='Ваше имя']");
    private By phoneField = By.xpath("//input[@placeholder='Телефон']");
    private By mailField = By.xpath("//input[@placeholder='E-mail']");
    private By passwordField = By.xpath("//input[@placeholder='Пароль']");
    private By confirmPasswordField = By.xpath("//input[@placeholder='Подтверждение пароля']");
    private By checkboxAcceptConvention = By.xpath("//input[@type='checkbox']/following-sibling::span");
    private By registerButton = By.xpath("//button[@id='register-submit-btn']");
    private By nameError = By.xpath("//input[@placeholder='Ваше имя']/ancestor::div/following-sibling::span");
    private By phoneError = By.xpath("//input[@placeholder='Телефон']/ancestor::div/following-sibling::span");
    private By mailError = By.xpath("//input[@placeholder='E-mail']/ancestor::div/following-sibling::span");
    private By passwordError = By.xpath("//input[@placeholder='Пароль']/ancestor::div/following-sibling::span");
    private By confirmPasswordError = By.xpath("//input[@placeholder='Подтверждение пароля']/ancestor::div/following-sibling::span");
    private By checkboxRemark = By.xpath("//input[@type='checkbox']/ancestor::label/following-sibling::span");

    // name input method
    public RegisterPage typeName( String name ){
        driver.findElement(nameField).sendKeys(name);
        return this;
    }

    // phone input method
    public RegisterPage typePhone( String phone ){
        driver.findElement(phoneField).sendKeys(phone);
        return this;
    }

    // mail input method
    public RegisterPage typeMail( String mail ){
        driver.findElement(mailField).sendKeys(mail);
        return this;
    }

    // password input method
    public RegisterPage typePassword( String password ){
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(confirmPasswordField).sendKeys(password);
        return this;
    }

    // register with invalid data method
    public RegisterPage registerWithInvalidInput( String name, String phone, String mail, String password){
        this.typeName(name);
        this.typePhone(phone);
        this.typeMail(mail);
        this.typePassword(password);
        // check if user acceptance checkbox is set
        if (driver.findElement(checkboxAcceptConvention).isSelected()){
            driver.findElement(registerButton).click();
        } else {
            driver.findElement(checkboxAcceptConvention).click();
            driver.findElement(registerButton).click();
        }
        return new RegisterPage(driver);
    }

    // getting the page header text method
    public String getHeadingText() {
        return driver.findElement(heading).getText();
    }

    // getting text error page method
    public String getNameErrorText() {
        return driver.findElement(nameError).getText();
    }

    // getting phone number error text method
    public String getPhoneErrorText() {
        return driver.findElement(phoneError).getText();
    }

    // getting email entry error text method
    public String getMailErrorText() {
        return driver.findElement(mailError).getText();
    }

    // getting password error text method
    public String getPasswordErrorText() {
        return driver.findElement(passwordError).getText();
    }

    // getting confirm password error text method
    public String getConfirmPasswordErrorText() {
        return driver.findElement(confirmPasswordError).getText();
    }

    // getting a user acceptance reminder text method
    public String getCheckboxRemarkText() {
        return driver.findElement(checkboxRemark).getText();
    }
}
