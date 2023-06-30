package Demoqa.Pages;

import Demoqa.Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookStoreLoginPage extends BaseTest {
    @FindBy(id = "userName")
    private WebElement userName;

    @FindBy(css = "#password")
    private WebElement password;

    @FindBy(css = "#login")
    private WebElement loginButton;

    @FindBy(css = "#newUser")
    private WebElement newUserButton;

    @FindBy(css = "#firstname")
    private WebElement firstName;

    @FindBy(css = "#lastname")
    private WebElement lastName;

    @FindBy(css = "#register")
    private WebElement registerButton;

    @FindBy(css = "#gotologin")
    private WebElement backToLogin;

    @FindBy(css = "#rc-anchor-container")
    private WebElement captchaFrame;

    @FindBy(css = "#recaptcha-anchor > div.recaptcha-checkbox-checkmark")
    private WebElement captchaCheckBox;

    public BookStoreLoginPage() {
        PageFactory.initElements(driver, this);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void clickNewUserButton() {
        newUserButton.click();
    }

    public void sendUserName(String userName) {
        this.userName.clear();
        this.userName.sendKeys(userName);
    }

    public void sendPassword(String password) {
        this.password.clear();
        this.password.sendKeys(password);
    }

    public void sendFirstName(String firstName) {
        this.firstName.clear();
        this.firstName.sendKeys(firstName);
    }

    public void sendLastName(String lastName) {
        this.lastName.clear();
        this.lastName.sendKeys(lastName);
    }

    public void clickLogin() {
        loginButton.click();
    }

    public void clickRegisterButton() {
        registerButton.click();
    }

    public void clickBackToLogin() {
        backToLogin.click();
    }


    public void reCaptcha() {
        //Prebacuje izvrsavanje na prvi frem na stranici koji sadrži reCAPTCHA.
        driver.switchTo().frame(0);
        WebElement checkbox = driver.findElement(By.cssSelector("#rc-anchor-container .recaptcha-checkbox-checkmark"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", checkbox);// JavaScript kod za klik na checkbox element reCAPTCHA
        driver.switchTo().defaultContent();
    }
}

