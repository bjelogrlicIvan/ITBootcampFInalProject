package Demoqa.Tests;

import Demoqa.Base.BaseTest;
import Demoqa.Base.ExcelReader;
import Demoqa.Pages.BookStoreLoginPage;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.IOException;


public class LoginTest extends BaseTest {

    String username;
    String password;
    String invalidUsername;
    String invalidPassword;
    ExcelReader excelReader;

    BookStoreLoginPage bookStoreLoginPage;

    @BeforeMethod
    public void pageSetUp() throws IOException {
        bookStoreLoginPage = new BookStoreLoginPage();
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/login");
        excelReader = new ExcelReader("src\\test\\java\\Demoqa\\TestDataIvan.xlsx");
        username = excelReader.getStringData("Login", 1, 0);
        password = excelReader.getStringData("Login", 1, 1);
        invalidUsername = excelReader.getStringData("Login", 1, 2);
        invalidPassword = excelReader.getStringData("Login", 1, 3);
    }


    @Test
    public void userCanLogin() {
        String expectedUsername = username;
        bookStoreLoginPage.sendUserName(username);
        bookStoreLoginPage.sendPassword(password);
        bookStoreLoginPage.clickLogin();

        WebElement usernameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("label#userName-value.form-label")));
        String actualUsername = usernameElement.getText();
        Assert.assertEquals(actualUsername, expectedUsername);
    }


    //-----------------------------Negativni testovi------------------------------------


    @Test
    public void userCannotLogInWithInvalidUsername() {
        int lastRow = excelReader.getLastRow("Login");
        for (int i = 1; i <= lastRow; i++) {
            String invalidUsername = excelReader.getStringData("Login", i, 2);
            String invalidPassword = excelReader.getStringData("Login", i, 3);

            if (!invalidUsername.isEmpty() && !invalidPassword.isEmpty()) {
                bookStoreLoginPage.sendUserName(invalidUsername);
                bookStoreLoginPage.sendPassword(invalidPassword);
                bookStoreLoginPage.clickLogin();

                WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > div#app:nth-child(6) > div.body-height:nth-child(2) > div.container.playgound-body > div.row:nth-child(2) > div.col-12.mt-4.col-md-6:nth-child(2) > div.login-wrapper:nth-child(2) > form#userForm > div#output.mt-4.row:nth-child(5) > div.col-md-12.col-sm-12 > p#name.mb-1")));
                String actual_message = element.getText();
                String expected_message = "Invalid username or password!";
                assert actual_message.equals(expected_message);
            }
        }
    }

    @AfterClass
    public void tearDown() {
        //driver.quit();
    }

}
