package Demoqa.Pages;

import Demoqa.Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DynamicPropertiesPage extends BaseTest {
    public DynamicPropertiesPage() {
        PageFactory.initElements(driver, this);
    }
    WebElement willEnable5SecondsButton;
    WebElement colorChangeButton;
    WebElement visibleAfter5SecondsButton;

    public WebElement getWillEnable5SecondsButton() {
        return driver.findElement(By.cssSelector("#enableAfter"));
    }

    public WebElement getColorChangeButton() {
        return driver.findElement(By.cssSelector("colorChange"));
    }

    public WebElement getVisibleAfter5SecondsButton() {
        return driver.findElement(By.cssSelector("visibleAfter"));
    }

    public void assertElementText(String xpath, String expectedText) {
        WebElement element = driver.findElement(By.xpath(xpath));
        String actualText = element.getText();
        Assert.assertEquals(actualText, expectedText);
    }

    public void assertElementTextAndColor(WebElement element, String expectedText, String expectedColor) {
        String actualText = element.getText();
        String actualColor = element.getCssValue("color");
        Assert.assertEquals(actualText, expectedText);
        Assert.assertEquals(actualColor, expectedColor);
    }

    public void assertElementInvisibility(String xpath) {
        WebElement element = driver.findElement(By.xpath(xpath));
        Assert.assertFalse(element.isDisplayed(), "Element je vidljiv, iako bi trebao biti nevidljiv.");
    }

    public void assertElementColor(WebElement element, String expectedColor) {
        String actualColor = element.getCssValue("color");
        Assert.assertEquals(actualColor, expectedColor, "Boja elementa se promijenila, iako ne bi trebala biti promijenjena.");
    }
}
