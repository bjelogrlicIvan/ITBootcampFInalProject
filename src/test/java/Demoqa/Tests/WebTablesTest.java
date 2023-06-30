package Demoqa.Tests;

import Demoqa.Base.BaseTest;
import Demoqa.Pages.WebTablesPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebTablesTest extends BaseTest {
    public BaseTest baseTest;
    public WebTablesPage webTablesPage;


    @BeforeMethod
    public void pageSetUp() {
        baseTest = new BaseTest();
        webTablesPage = new WebTablesPage();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/webtables");
    }
    @Test
    public void addNewUser() {
        webTablesPage.clickOnAddButton();
        webTablesPage.enterTextInFirstName("Ivan");
        webTablesPage.enterTextInLastName("Ivanovic");
        webTablesPage.enterEmail("ivan@gmail.com");
        webTablesPage.enterAge("20");
        webTablesPage.enterSalary("2000");
        webTablesPage.enterDepartment("IT");
        webTablesPage.clickOnSubmitButton();
    }
    @Test
    public void editUser() {
        webTablesPage.clickOnEditButton();
        webTablesPage.enterTextInFirstName("XXXX");
        webTablesPage.enterTextInLastName("XXXXXXXX");
        webTablesPage.enterEmail("neko@gmail.com");
        webTablesPage.enterAge("20");
        webTablesPage.enterSalary("2000");
        webTablesPage.enterDepartment("IT");
        webTablesPage.clickOnSubmitButton();
    }
    @Test
    public void deleteUser() {
        webTablesPage.selectUserByEmail("alden@");
        webTablesPage.clickOnDeleteButton();
    }

    //-----------------------------Negativni testovi------------------------------------

    @Test
    public void addNewUserWithoutRequiredFields() {
        // Ne unesite nikakve podatke u obavezna polja
        webTablesPage.clickOnAddButton();
        webTablesPage.clickOnSubmitButton();
    }

    @Test
    public void editUserWithInvalidData() {
        // Unos nevalidnih podataka u polje
        webTablesPage.clickOnEditButton();
        webTablesPage.enterTextInFirstName("XXXX");
        webTablesPage.enterTextInLastName("XXXXXXXX");
        webTablesPage.enterEmail("nekomailcom");
        webTablesPage.enterAge("-20");
        webTablesPage.enterSalary("hiljadu");
        webTablesPage.enterDepartment("IT");
        webTablesPage.clickOnSubmitButton();
    }

    @Test
    public void deleteNonExistingUser(){
        webTablesPage.selectUserByEmail("ivan@");
        webTablesPage.clickOnDeleteButton();
    }


    @AfterClass
    public void tearDown() {
        //driver.quit();
    }
}
