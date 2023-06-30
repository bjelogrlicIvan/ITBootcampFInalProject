package Demoqa.Pages;

import Demoqa.Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BrowserWindowsPage extends BaseTest {
    public BrowserWindowsPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#tabButton")
    private WebElement tabButton;
    @FindBy(css = "#windowButton")
    private WebElement windowButton;
    @FindBy(css = "#messageWindowButton")
    private WebElement messageWindowButton;

    public void clickTabButton() {
        tabButton.click();
    }

    public void clickWindowButton() {
        windowButton.click();
    }

    public void clickMessageWindowButton() {
        messageWindowButton.click();
    }
}
