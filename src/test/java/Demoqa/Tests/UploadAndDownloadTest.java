package Demoqa.Tests;

import Demoqa.Base.BaseTest;
import Demoqa.Pages.UploadAndDownload;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UploadAndDownloadTest extends BaseTest {
    public BaseTest baseTest;

    public UploadAndDownload uploadAndDownload;

    @BeforeMethod
    public void pageSetUp() {
        baseTest = new BaseTest();
        uploadAndDownload = new UploadAndDownload();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/upload-download");
    }

    @Test
    public void uploadFile() {
        uploadAndDownload.uploadFile();
        //Pronalazenje elementa koji je potrebno da se uploaduje
        WebElement fileInputElement = driver.findElement(By.cssSelector("input[type='file']"));
        //Slanje putanje do fajla koji treba da se uploaduje u element
        fileInputElement.sendKeys("C:\\Users\\SShock\\Downloads\\dog.jpg");
        //Ocekivana putanja fajla
        String expectedFilePath = "C:\\fakepath\\dog.jpg";
        //Stvarna putanja
        String actualFilePath = fileInputElement.getAttribute("value");
        Assert.assertEquals(actualFilePath, expectedFilePath);
    }

    @Test
    public void downloadFile() {
        uploadAndDownload.downloadFile();
        String filePath = "C:\\Users\\SShock\\Downloads\\sampleFile.jpeg";
        //Kreiranje objekta Path koji predstavlja putanju do fajla koji treba da se preuzme
        Path downloadedFile = Paths.get(filePath);
        assert Files.exists(downloadedFile);
    }

    //-----------------------------Negativni testovi------------------------------------

    @Test
    public void uploadInvalidFileTypeTest() {
        uploadAndDownload.uploadFile();
        WebElement fileInputElement = driver.findElement(By.cssSelector("input[type='file']"));
        fileInputElement.sendKeys("C:\\Users\\SShock\\Downloads\\dog.txt");
        String expectedFilePath = "C:\\fakepath\\dog.txt";
        String actualFilePath = fileInputElement.getAttribute("value");
        Assert.assertEquals(actualFilePath, expectedFilePath);
    }

    @Test
    public void downloadNonexistentFileTest() {
        uploadAndDownload.downloadFile();
        String filePath = "C:\\Users\\SShock\\Downloads\\sampleFile.txt";
        Path downloadedFile = Paths.get(filePath);
        assert Files.exists(downloadedFile);
    }


    @AfterClass
    public void tearDown() {
        //driver.quit();
    }
}
