package Demoqa.Tests;

import Demoqa.Base.BaseTest;
import Demoqa.Pages.LinksPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LinkPageTest extends BaseTest {
    private LinksPage linkPage;

    @BeforeMethod
    public void pageSetUp() {
        linkPage = new LinksPage();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/links");
    }



    @Test
    public void homePageTest() {
        linkPage.clickHomeLink();
        Assert.assertNotEquals(driver.getCurrentUrl(), "https://demoqa.com");
    }

    @Test
    public void homeB0d7AlinkTest() {
        linkPage.clickHomeB0d7ALink();
        Assert.assertNotEquals(driver.getCurrentUrl(), "https://demoqa.com");
    }

    @Test
    public void currentLinkTest() {
        linkPage.clickCreateLink();
        linkPage.testLink(linkPage.getUnauthorizedLink());
    }

    @Test
    public void noContentLinkTest() {
        linkPage.clickNoContentLink();
        linkPage.testLink(linkPage.getUnauthorizedLink());
    }

    @Test
    public void movedLinkTest() {
        linkPage.clickMovedLink();
        linkPage.testLink(linkPage.getUnauthorizedLink());
    }

    @Test
    public void badRequestLinkTest() {
        linkPage.testLink(linkPage.getBadRequestLink());
    }

    @Test
    public void unauthorizedLinkTest() {
        linkPage.testLink(linkPage.getUnauthorizedLink());
    }

    @Test
    public void forbiddenLinkTest() {
        linkPage.testLink(linkPage.getForbiddenLink());
    }

    @Test
    public void notFoundLinkTest() {
        linkPage.testLink(linkPage.getNotFoundLink());
    }

    //-----------------------------Negativni testovi------------------------------------

    @Test
    public void invalidHomePageTest() {
        linkPage.clickHomeLink();
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/webtables", "Navigacija na pogrešnu stranicu.");
    }

    @Test
    public void invalidCurrentLinkTest() {
        linkPage.clickCreateLink();
        linkPage.testLink(linkPage.getUnauthorizedLink());
        linkPage.verifyLinkResponseText("Očekivani tekst");
    }

    @Test
    public void invalidBadRequestLinkTest() {
        linkPage.testLink(linkPage.getBadRequestLink());
        linkPage.verifyLinkResponseText("Star Wars");
    }

    @Test
    public void invalidNotFoundLinkTest() {
        linkPage.testLink(linkPage.getNotFoundLink());
        linkPage.verifyLinkResponseText("ITBootcamp");
    }

    @AfterClass
    public void tearDown() {
        //driver.quit();
    }
}
