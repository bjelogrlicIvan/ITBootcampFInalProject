package Demoqa.Pages;

import Demoqa.Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class UploadAndDownload extends BaseTest {
    public UploadAndDownload() {
        PageFactory.initElements(driver, this);
    }

    WebElement uploadButton;
    WebElement downloadButton;


    public WebElement getUploadButton() {
        return driver.findElement(By.cssSelector("#app > div > div > div.row > div.col-12.mt-4.col-md-6 > div:nth-child(2) > div.mt-3 > form > div > label"));
    }

    public WebElement getDownloadButton() {
        return driver.findElement(By.cssSelector("#downloadButton"));
    }

    public void uploadFile(){
        getUploadButton().click();
    }
    public void downloadFile(){
        getDownloadButton().click();
    }
}
