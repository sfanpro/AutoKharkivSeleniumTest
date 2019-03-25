package ua.autokharkiv.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    private WebDriver driver;

    public RegisterPage( WebDriver driver ) {
        this.driver = driver;
    }

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

    public RegisterPage typeName( String name ){
        driver.findElement(nameField).sendKeys(name);
        return this;
    }

    public RegisterPage typePhone( String phone ){
        driver.findElement(phoneField).sendKeys(phone);
        return this;
    }

    public RegisterPage typeMail( String mail ){
        driver.findElement(mailField).sendKeys(mail);
        return this;
    }

    public RegisterPage typePassword( String password ){
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(confirmPasswordField).sendKeys(password);
        return this;
    }

    public RegisterPage registerWithInvalidInput( String name, String phone, String mail, String password){
        this.typeName(name);
        this.typePhone(phone);
        this.typeMail(mail);
        this.typePassword(password);
        if (driver.findElement(checkboxAcceptConvention).isSelected()){
            driver.findElement(registerButton).click();
        } else {
            driver.findElement(checkboxAcceptConvention).click();
            driver.findElement(registerButton).click();
        }
        return new RegisterPage(driver);
    }

    public String getHeadingText() {
        return driver.findElement(heading).getText();
    }

    public String getNameErrorText() {
        return driver.findElement(nameError).getText();
    }

    public String getPhoneErrorText() {
        return driver.findElement(phoneError).getText();
    }

    public String getMailErrorText() {
        return driver.findElement(mailError).getText();
    }

    public String getPasswordErrorText() {
        return driver.findElement(passwordError).getText();
    }

    public String getConfirmPasswordErrorText() {
        return driver.findElement(confirmPasswordError).getText();
    }

    public String getCheckboxRemarkText() {
        return driver.findElement(checkboxRemark).getText();
    }
}
