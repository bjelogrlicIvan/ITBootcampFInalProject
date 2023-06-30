package Demoqa.Pages;

import Demoqa.Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertEquals;

public class ButtonsPage extends BaseTest {

    public ButtonsPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#item-4 > span")
    public WebElement button;

    @FindBy(css = "#doubleClickBtn")
    public WebElement doubleClickBtn;

    @FindBy(css = "#rightClickBtn")
    public WebElement rightClickBtn;

    @FindBy(css = "#app > div > div > div.row > div.col-12.mt-4.col-md-6 > div:nth-child(2) > div:nth-child(3) button:last-of-type")
    public WebElement leftClickBtn;

    //--------------

    public void doubleClickButton() {
        button.click();
        //Objekat koji omogocuva izvodjenje akcija - u ovom slucaju "dupli klik"
        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClickBtn).perform();
    }

    public void rightClickButton() {
        button.click();
        //Objekat koji omogocuva izvodjenje akcija - u ovom slucaju "desni klik"
        Actions actions = new Actions(driver);
        actions.contextClick(rightClickBtn).build().perform();
    }

    public void leftClickButton() {
        button.click();
        leftClickBtn.click();
    }

    public String getButtonMessage(String selector) {
        return driver.findElement(By.cssSelector(selector)).getText();
    }

    public void assertButtonMessageEquals(String selector, String expectedMessage) {
        String actualMessage = getButtonMessage(selector);
        assertEquals(actualMessage, expectedMessage);
    }


}
