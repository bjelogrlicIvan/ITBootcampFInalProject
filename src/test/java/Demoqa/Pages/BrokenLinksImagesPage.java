package Demoqa.Pages;

import Demoqa.Base.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;

public class BrokenLinksImagesPage extends BaseTest {
    public BrokenLinksImagesPage() {
        PageFactory.initElements(driver, this);
    }
    WebElement validImage;
    WebElement brokenImage;
    WebElement validLink;
    WebElement brokenLink;

    public WebElement getValidImage() {
        return driver.findElement(By.cssSelector("#app > div > div > div.row > div.col-12.mt-4.col-md-6 > div:nth-child(2) > img:nth-child(2)"));
    }

    public WebElement getBrokenImage() {
        return driver.findElement(By.cssSelector("#app > div > div > div.row > div.col-12.mt-4.col-md-6 > div:nth-child(2) > img:nth-child(6)"));
    }

    public WebElement getValidLink() {
        return driver.findElement(By.cssSelector("#app > div > div > div.row > div.col-12.mt-4.col-md-6 > div:nth-child(2) > a:nth-child(10)"));
    }

    public WebElement getBrokenLink() {
        return driver.findElement(By.cssSelector("#app > div > div > div.row > div.col-12.mt-4.col-md-6 > div:nth-child(2) > a:nth-child(14)"));
    }

    public void clickOnValidLink(){
        getValidLink().click();
    }

    public void clickOnBrokenLink(){
        getBrokenLink().click();
    }

    public void captureAndCompareScreenshot(String imagePath) throws IOException {
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File actualImageFile = new File(imagePath);
        FileUtils.copyFile(screenshotFile, actualImageFile);
        File expectedImageFile = new File(imagePath);
        assert FileUtils.contentEquals(actualImageFile, expectedImageFile) : "Slike se ne podudaraju!";
    }
}
