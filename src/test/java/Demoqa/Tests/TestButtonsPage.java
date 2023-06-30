package Demoqa.Tests;

import Demoqa.Base.BaseTest;
import Demoqa.Pages.ButtonsPage;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestButtonsPage extends BaseTest {

    private ButtonsPage buttonsPage;

    @BeforeMethod
    public void pageSetUp() {
        buttonsPage = new ButtonsPage();
        driver.manage().window().maximize();
        driver.get(homeURL);
    }


    @Test
    public void buttonDoubleClickButtonTest() {
        buttonsPage.clickOnElements();
        buttonsPage.doubleClickButton();
        buttonsPage.assertButtonMessageEquals("#doubleClickMessage", "You have done a double click");
    }

    @Test
    public void buttonRightClickButtonTest() {
        buttonsPage.clickOnElements();
        buttonsPage.rightClickButton();
        buttonsPage.assertButtonMessageEquals("#rightClickMessage", "You have done a right click");
    }

    @Test
    public void buttonLeftClickButtonTest() {
        buttonsPage.clickOnElements();
        buttonsPage.leftClickButton();
        buttonsPage.assertButtonMessageEquals("#dynamicClickMessage", "You have done a dynamic click");
    }

    //-----------------------------Negativni testovi------------------------------------

    @Test
    public void buttonDoubleClickButtonInvalidTest() {
        buttonsPage.clickOnElements();
        buttonsPage.doubleClickButton();
        buttonsPage.assertButtonMessageEquals("#doubleClickMessage", "You have done a dynamic click");
    }

    @Test
    public void buttonRightClickButtonInvalidTest() {
        buttonsPage.clickOnElements();
        buttonsPage.rightClickButton();
        buttonsPage.assertButtonMessageEquals("#rightClickMessage", "You have done a double click");
    }

    @Test
    public void buttonLeftClickButtonInvalidTest() {
        buttonsPage.clickOnElements();
        buttonsPage.leftClickButton();
        buttonsPage.assertButtonMessageEquals("#dynamicClickMessage", "You have done a right click");
    }

    @AfterClass
    public void tearDown() {
        //driver.quit();
    }
}
