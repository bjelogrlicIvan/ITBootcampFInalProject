package Demoqa.Tests;

import Demoqa.Base.BaseTest;
import Demoqa.Pages.CheckBox;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class CheckBoxTest extends BaseTest {
    public BaseTest baseTest;
    public CheckBox checkBox;

    @BeforeMethod
    public void pageSetUp() {
        baseTest = new BaseTest();
        checkBox = new CheckBox();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/checkbox");
    }
    @Test
    public void homeCheckBoxTest() {
        checkBox.getPlusButton().click();
        Assert.assertTrue(checkBox.getHomeCheckBox().isDisplayed());
        checkBox.getHomeCheckBox().click();
    }
    @Test
    public void desktopCheckBoxTest() {
        checkBox.getPlusButton().click();
        checkBox.getDesktopCheckBox().click();
        Assert.assertTrue(checkBox.getDesktopCheckBox().isDisplayed());
    }

    @Test
    public void documentsCheckBoxTest() {
        checkBox.getPlusButton().click();
        checkBox.getDocumentsCheckBox().click();
        Assert.assertTrue(checkBox.getDocumentsCheckBox().isDisplayed());
    }
    @Test
    public void downloadCheckBoxTest() {
        checkBox.getPlusButton().click();
        scrollIntoView(checkBox.getDownloadCheckBox());
        checkBox.getDownloadCheckBox().click();
        Assert.assertTrue(checkBox.getDownloadCheckBox().isDisplayed());
    }

    @Test
    public void desktopCheckBoxNote() {
        checkBox.getPlusButton().click();
        checkBox.getDesktopToggle().click();
        checkBox.getNotesCheckBox().click();
        Assert.assertTrue(checkBox.getNotesCheckBox().isDisplayed());
    }
    @Test
    public void desktopCheckBoxCommands() {
        checkBox.getPlusButton().click();
        checkBox.getDesktopToggle().click();
        checkBox.getCommandsCheckBox().click();
        Assert.assertTrue(checkBox.getCommandsCheckBox().isDisplayed());
    }
    @Test
    public void downloadCheckBoxWordFile() {
        checkBox.getPlusButton().click();
        scrollIntoView(checkBox.getDownloadCheckBox());
        checkBox.getDesktopToggle().click();
        checkBox.getWordFileCheckBox().click();
        Assert.assertTrue(checkBox.getWordFileCheckBox().isDisplayed());
    }
    @Test
    public void downloadCheckBoxExcelFile() {
        checkBox.getPlusButton().click();
        scrollIntoView(checkBox.getDownloadCheckBox());
        checkBox.getDesktopToggle().click();
        checkBox.getExcelFileCheckBox().click();
        Assert.assertTrue(checkBox.getExcelFileCheckBox().isDisplayed());
    }

    //-----------------------------Negativni testovi------------------------------------


    @Test
    public void uncheckedHomeCheckBoxTest() {
        checkBox.getPlusButton().click();
        Assert.assertFalse(checkBox.getHomeCheckBox().isSelected());
    }

    @Test
    public void unselectedDesktopCheckBoxTest() {
        checkBox.getPlusButton().click();
        Assert.assertFalse(checkBox.getDesktopCheckBox().isSelected());
    }

    @Test
    public void unselectedDocumentsCheckBoxTest() {
        checkBox.getPlusButton().click();
        Assert.assertFalse(checkBox.getDocumentsCheckBox().isSelected());
    }

    @Test
    public void unselectedDownloadCheckBoxTest() {
        checkBox.getPlusButton().click();
        scrollIntoView(checkBox.getDownloadCheckBox());
        Assert.assertFalse(checkBox.getDownloadCheckBox().isSelected());
    }

    @Test
    public void uncheckedNotesCheckBoxTest() {
        checkBox.getPlusButton().click();
        checkBox.getDesktopToggle().click();
        Assert.assertFalse(checkBox.getNotesCheckBox().isSelected());
    }

    @Test
    public void uncheckedCommandsCheckBoxTest() {
        checkBox.getPlusButton().click();
        checkBox.getDesktopToggle().click();
        Assert.assertFalse(checkBox.getCommandsCheckBox().isSelected());
    }

    @Test
    public void uncheckedWordFileCheckBoxTest() {
        checkBox.getPlusButton().click();
        scrollIntoView(checkBox.getDownloadCheckBox());
        checkBox.getDesktopToggle().click();
        Assert.assertFalse(checkBox.getWordFileCheckBox().isSelected());
    }

    @Test
    public void uncheckedExcelFileCheckBoxTest() {
        checkBox.getPlusButton().click();
        scrollIntoView(checkBox.getDownloadCheckBox());
        checkBox.getDesktopToggle().click();
        Assert.assertFalse(checkBox.getExcelFileCheckBox().isSelected());
    }


    @AfterClass
    public void tearDown() {
        //driver.quit();
    }
}
