package Demoqa.Tests;

import Demoqa.Base.BaseTest;
import Demoqa.Pages.BrowserWindowsPage;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Set;

public class BrowserWindowsTest extends BaseTest {
    public BaseTest baseTest;
    public BrowserWindowsPage browserWindows;

    @BeforeMethod
    public void pageSetUp() {
        baseTest = new BaseTest();
        browserWindows = new BrowserWindowsPage();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/browser-windows");
    }

    @Test
    public void newTabTest() {
        //Trenutni aktivni tab
        String currentTab = driver.getWindowHandle();
        browserWindows.clickTabButton();
        //Svi otvoreni tabovi
        Set<String> tabs = driver.getWindowHandles();
        for (String tab : tabs) {
            if (!tab.equals(currentTab)) {
                //Prebacivanje na novootvoreno tab
                driver.switchTo().window(tab);
                break;
            }
        }
        String pageText = driver.getPageSource();
        String expectedText = "This is a sample page";
        assert pageText.contains(expectedText) : "Ocekivani tekst se ne nalazi na stranici!";
    }

    @Test
    public void newWindowTest() {
        //Trenutni aktivni window
        String currentWindow = driver.getWindowHandle();
        browserWindows.clickWindowButton();
        //Svi otvoreni window-ovi
        Set<String> windows = driver.getWindowHandles();

        for (String window : windows) {
            if (!window.equals(currentWindow)) {
                //Prebacivanje na novootvoreno window
                driver.switchTo().window(window);
                break;
            }
        }

        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://demoqa.com/sample";
        Assert.assertEquals(currentUrl, expectedUrl, "Adresa se ne poklapa sa ocekivanom");
    }

    @Test
    public void newWindowMessageTest() {
        browserWindows.clickMessageWindowButton();
        String messageText = (String) ((JavascriptExecutor) driver).executeScript(
                "return document.body.innerText;"
        );

        //String expectedText = "Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization.";
        //assert messageText.contains(expectedText);
        System.out.println(messageText);
    }

    @AfterClass
    public void tearDown() {
        //driver.quit();
    }

}