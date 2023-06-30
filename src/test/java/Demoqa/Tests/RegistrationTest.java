package Demoqa.Tests;

import Demoqa.Base.BaseTest;
import Demoqa.Pages.BookStoreLoginPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest {

    BookStoreLoginPage bookStoreLoginPage;

    @BeforeMethod
    public void pageSetUp(){
        bookStoreLoginPage = new BookStoreLoginPage();
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/login");
    }

    @Test
    public void userCanRegister() {
        bookStoreLoginPage.clickNewUserButton();
        bookStoreLoginPage.sendFirstName("John");
        bookStoreLoginPage.sendLastName("Doe");
        bookStoreLoginPage.sendUserName("johndoe");
        bookStoreLoginPage.sendPassword("password");
        bookStoreLoginPage.reCaptcha();
        bookStoreLoginPage.clickRegisterButton();
    }

    @AfterClass
    public void tearDown() {
        //driver.quit();
    }
}
