package Demoqa.Tests;

import Demoqa.Base.BaseTest;
import Demoqa.Pages.RadioButton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestRadioButton extends BaseTest {

    private RadioButton radioButton;

    @BeforeMethod
    public void pageSetUp() {
        radioButton = new RadioButton();
        driver.manage().window().maximize();
        driver.get(homeURL);
    }



    @Test
    public void radioButtonYesTest() {
        radioButton.clickOnElements();
        radioButton.clickOnYesRadioButton();
        radioButton.assertRadioButtonMessageEquals("Yes");
    }

    @Test
    public void radioButtonImpressiveTest() {
        radioButton.clickOnElements();
        radioButton.clickOnImpressiveRadioButton();
        radioButton.assertRadioButtonMessageEquals("Impressive");
    }

    @Test
    public void radioButtonNoTest() {
        radioButton.clickOnElements();
        radioButton.clickOnNoRadioButton();
        radioButton.assertNoRadioButtonDisabled();
    }

    //-----------------------------Negativni testovi------------------------------------

    @Test
    public void radioButtonYesInvalidTest() {
        radioButton.clickOnElements();
        radioButton.clickOnYesRadioButton();
        radioButton.assertRadioButtonMessageEquals("Impressive");
    }

    @Test
    public void radioButtonImpressiveInvalidTest() {
        radioButton.clickOnElements();
        radioButton.clickOnImpressiveRadioButton();
        radioButton.assertRadioButtonMessageEquals("Invalid option");
    }

    @Test
    public void radioButtonNoInvalidTest() {
        radioButton.clickOnElements();
        radioButton.clickOnNoRadioButton();
        radioButton.assertNoRadioButtonEnabled();
    }

    @AfterClass
    public void tearDown() {
        //driver.quit();
    }
}
