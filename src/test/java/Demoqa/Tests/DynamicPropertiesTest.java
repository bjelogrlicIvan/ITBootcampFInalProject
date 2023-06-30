package Demoqa.Tests;

import Demoqa.Base.BaseTest;
import Demoqa.Pages.DynamicPropertiesPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DynamicPropertiesTest extends BaseTest {
    private BaseTest baseTest;
    private DynamicPropertiesPage dynamicProperties;

    @BeforeMethod
    public void pageSetUp() {
        dynamicProperties = new DynamicPropertiesPage();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/dynamic-properties");
    }

    @Test
    public void testDynamicProperties() throws InterruptedException {
        Thread.sleep(6000);
        dynamicProperties.assertElementText("//button[@class='mt-4 btn btn-primary' and contains(text(),'Visible After 5 Seconds')]", "Visible After 5 Seconds");

        WebElement colorChangeElement = driver.findElement(By.xpath("//button[@class='mt-4 text-danger btn btn-primary' and contains(text(),'Color Change')]"));
        dynamicProperties.assertElementTextAndColor(colorChangeElement, "Color Change", "rgba(220, 53, 69, 1)");

        dynamicProperties.assertElementText("//button[@class='mt-4 btn btn-primary' and contains(text(),'Visible After 5 Seconds')]", "Visible After 5 Seconds");
    }

    //-----------------------------Negativni testovi------------------------------------

    @Test
    public void testInvisibleElement() {
        dynamicProperties.assertElementInvisibility("//button[@class='mt-4 btn btn-primary' and contains(text(),'Visible After 5 Seconds')]");
    }

    @Test
    public void testColorChangeNotApplied() {
        WebElement colorChangeElement = driver.findElement(By.xpath("//button[@class='mt-4 text-danger btn btn-primary' and contains(text(),'Color Change')]"));
        dynamicProperties.assertElementColor(colorChangeElement, "rgba(220, 53, 69, 1)");
    }

    @AfterClass
    public void tearDown() {
        //driver.quit();
    }


}
