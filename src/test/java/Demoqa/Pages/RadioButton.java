package Demoqa.Pages;

import Demoqa.Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class RadioButton extends BaseTest {

    public RadioButton() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#item-2")
    public WebElement radioButton;

    @FindBy(css = "#app > div > div > div.row > div.col-12.mt-4.col-md-6 > div:nth-child(2) > div:nth-child(2) > label")
    public WebElement yesRadioButton;

    @FindBy(css = "#app > div > div > div.row > div.col-12.mt-4.col-md-6 > div:nth-child(2) > div:nth-child(3) > label")
    public WebElement impressiveRadioButton;

    @FindBy(css = "#app > div > div > div.row > div.col-12.mt-4.col-md-6 > div:nth-child(2) > div.custom-control.disabled.custom-radio.custom-control-inline > label")
    public WebElement noRadioButton;

    //---------------------

    public void clickOnYesRadioButton() {
        radioButton.click();
        yesRadioButton.click();
    }
    public void clickOnNoRadioButton() {
        radioButton.click();
        noRadioButton.click();
    }
    public void clickOnImpressiveRadioButton() {
        radioButton.click();
        impressiveRadioButton.click();
    }

    public String getRadioButtonMessage() {
        return driver.findElement(By.cssSelector("#app > div > div > div.row > div.col-12.mt-4.col-md-6 > div:nth-child(2) > p > span")).getText();
    }

    public void assertRadioButtonMessageEquals(String expectedMessage) {
        String actualMessage = getRadioButtonMessage();
        assertEquals(actualMessage, expectedMessage);
    }

    public WebElement getNoRadioButton() {
        return driver.findElement(By.cssSelector("#noRadio"));
    }

    public void assertNoRadioButtonDisabled() {
        WebElement element = getNoRadioButton();
        assertTrue(element.getAttribute("disabled") != null);
    }

    public void assertNoRadioButtonEnabled() {
        WebElement element = getNoRadioButton();
        assertTrue(element.isEnabled(), "Dugme 'No' je omogućeno iako bi trebalo da bude onemogućeno.");
    }
}
