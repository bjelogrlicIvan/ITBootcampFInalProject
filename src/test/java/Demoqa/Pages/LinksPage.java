package Demoqa.Pages;

import Demoqa.Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LinksPage extends BaseTest {
    public LinksPage() {
        PageFactory.initElements(driver, this);
    }
    WebElement homeLink;
    WebElement homeB0d7ALink;
    WebElement createLink;
    WebElement noContentLink;
    WebElement movedLink;
    WebElement badRequestLink;
    WebElement unauthorizedLink;
    WebElement forbiddenLink;
    WebElement notFoundLink;

    public WebElement getHomeLink() {
        return driver.findElement(By.cssSelector("#simpleLink"));
    }

    public WebElement getHomeB0d7ALink() {
        return driver.findElement(By.cssSelector("#dynamicLink"));
    }

    public WebElement getCreateLink() {
        return driver.findElement(By.cssSelector("#created"));
    }

    public WebElement getNoContentLink() {
        return driver.findElement(By.cssSelector("#no-content"));
    }

    public WebElement getMovedLink() {
        return driver.findElement(By.cssSelector("#moved"));
    }

    public WebElement getBadRequestLink() {
        return driver.findElement(By.cssSelector("#bad-request"));
    }

    public WebElement getUnauthorizedLink() {
        return driver.findElement(By.cssSelector("#unauthorized"));
    }

    public WebElement getForbiddenLink() {
        return driver.findElement(By.cssSelector("#forbidden"));
    }

    public WebElement getNotFoundLink() {
        return driver.findElement(By.cssSelector("#invalid-url"));
    }
    public void clickHomeLink() {
        getHomeLink().click();
    }
    public void clickHomeB0d7ALink() {
        getHomeB0d7ALink().click();
    }
    public void clickCreateLink() {
        getCreateLink().click();
    }
    public void clickNoContentLink() {
        getNoContentLink().click();
    }
    public void clickMovedLink() {
        getMovedLink().click();
    }
    public void clickBadRequestLink() {
        getBadRequestLink().click();
    }
    public void clickUnauthorizedLink() {
        getUnauthorizedLink().click();
    }
    public void clickForbiddenLink() {
        getForbiddenLink().click();
    }
    public void clickNotFoundLink() {
        getNotFoundLink().click();
    }

    public void waitForElementVisibility(String cssSelector) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By linkResponseLocator = By.cssSelector(cssSelector);
        wait.until(ExpectedConditions.visibilityOfElementLocated(linkResponseLocator));
    }

    public String getLinkResponseText() {
        return driver.findElement(By.cssSelector("p#linkResponse")).getAttribute("innerText");
    }

    public void testLink(WebElement linkElement) {
        scrollIntoView(linkElement);
        linkElement.click();
        waitForElementVisibility("#linkResponse");
        String text = getLinkResponseText();
        System.out.println(text);
    }

    public void verifyLinkResponseText(String expectedText) {
        String text = getLinkResponseText();
        Assert.assertEquals(text, expectedText, "Tekstovi se ne podudaraju.");
    }
}
