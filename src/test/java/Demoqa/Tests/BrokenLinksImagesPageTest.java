package Demoqa.Tests;

import Demoqa.Base.BaseTest;
import Demoqa.Pages.BrokenLinksImagesPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.io.IOException;

public class BrokenLinksImagesPageTest extends BaseTest {
    private BrokenLinksImagesPage brokenLinksImagesPage;

    @BeforeMethod
    public void pageSetUp() {
        brokenLinksImagesPage = new BrokenLinksImagesPage();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/broken");
    }

    @Test
    public void validImageTest() throws IOException {
        WebElement element = driver.findElement(By.cssSelector("#app > div > div > div.row > div.col-12.mt-4.col-md-6 > div:nth-child(2) > p:nth-child(1)"));
        String actualText = element.getText();
        String expectedText = "Valid image";
        assert actualText.equals(expectedText);
        brokenLinksImagesPage.captureAndCompareScreenshot("/images/Toolsqa.jpg");
    }

    @Test
    public void brokenImagesTest() throws IOException {
        WebElement element = driver.findElement(By.cssSelector("#app > div > div > div.row > div.col-12.mt-4.col-md-6 > div:nth-child(2) > p:nth-child(9)"));
        String actualText = element.getText();
        String expectedText = "Broken image";
        assert actualText.equals(expectedText);
        brokenLinksImagesPage.captureAndCompareScreenshot("/images/Toolsqa_1.jpg");
    }

    @Test
    public void validLinkTest() {
        scrollIntoView(brokenLinksImagesPage.getValidLink());
        brokenLinksImagesPage.clickOnValidLink();
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://demoqa.com/";
        assert currentUrl.equals(expectedUrl);
    }

    @Test
    public void brokenLinkTest() {
        scrollIntoView(brokenLinksImagesPage.getBrokenLink());
        brokenLinksImagesPage.clickOnBrokenLink();
        WebElement element = driver.findElement(By.cssSelector("#content > div > h3"));
        String actualText = element.getText();
        String expectedText = "Status Codes";
        assert actualText.equals(expectedText);
    }

    //-----------------------------Negativni testovi------------------------------------

    @Test
    public void negativeValidImageTest() throws IOException {
        WebElement element = driver.findElement(By.cssSelector("#app > div > div > div.row > div.col-12.mt-4.col-md-6 > div:nth-child(2) > p:nth-child(1)"));
        String actualText = element.getText();
        String expectedText = "Valid image";
        assert !actualText.equals(expectedText) : "Tekst se podudara!";
        brokenLinksImagesPage.captureAndCompareScreenshot("/images/Toolsqa.jpg");
    }

    @Test
    public void negativeValidLinkTest() {
        scrollIntoView(brokenLinksImagesPage.getValidLink());
        brokenLinksImagesPage.clickOnValidLink();
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://demoqa.com/";
        assert !currentUrl.equals(expectedUrl) : "URL se podudara!";
    }

    @Test
    public void negativeBrokenLinkTest() {
        scrollIntoView(brokenLinksImagesPage.getBrokenLink());
        brokenLinksImagesPage.clickOnBrokenLink();
        WebElement element = driver.findElement(By.cssSelector("#content > div > h3"));
        String actualText = element.getText();
        String expectedText = "Status Codes";
        assert !actualText.equals(expectedText) : "Tekst se podudara!";
    }

    @AfterClass
    public void tearDown() {
        //driver.quit();
    }


}
