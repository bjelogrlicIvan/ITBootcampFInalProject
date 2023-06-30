package Demoqa.Pages;

import Demoqa.Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BaseTest {

    @FindBy(css = "#app > div > div > div.home-body > div > div:nth-child(1)")
    WebElement element;

    @FindBy(css = "#app > div > div > div.home-body > div > div:nth-child(2)")
    WebElement forms;

    @FindBy(css = "#app > div > div > div.home-body > div > div:nth-child(3)")
    WebElement alertsFrameWindows;

    @FindBy(css = "#app > div > div > div.home-body > div > div:nth-child(4)")
    WebElement widgets;

    @FindBy(css = "#app > div > div > div.home-body > div > div:nth-child(5)")
    WebElement interactions;

    @FindBy(css = "#app > div > div > div.home-body > div > div:nth-child(6)")
    WebElement booksStoreApplication;

    public void goToElement() {
        element.click();
    }

    public void goToForms() {
        forms.click();
    }

    public void goToAlertsFrameWindows() {
        alertsFrameWindows.click();
    }

    public void goToWidgets() {
        widgets.click();
    }

    public void goToInteractions() {
        interactions.click();
    }

    public void goToBooksStoreApplication() {
        booksStoreApplication.click();
    }
}
