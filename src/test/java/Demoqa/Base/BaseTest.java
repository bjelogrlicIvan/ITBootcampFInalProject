package Demoqa.Base;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class BaseTest {

    public static WebDriver driver;
    public WebDriverWait wait;
    public ExcelReader excelReader;
    public String homeURL;

    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        excelReader = new ExcelReader("C:\\Users\\SShock\\IdeaProjects\\Selenium\\src\\test\\java\\Demoqa\\TestDataIvan.xlsx");
        homeURL = excelReader.getStringData("URL", 1, 0);

    }

    public BaseTest() {
        PageFactory.initElements(driver, this);
    }

    public void scrollIntoView(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void waitForURL(String URL) {
        wait.until(ExpectedConditions.urlToBe(URL));
    }

    public void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForClickability(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public boolean elementIsPresent(WebElement element) {
        boolean nonexistingElement = false;
        try {
            nonexistingElement = element.isDisplayed(); //ako jeste dispayed onda se boolean menja u true
        } catch (Exception e) {
        }
        return nonexistingElement;
    }

    public void openNewTab() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open()");
    }

    public void saveImage(WebElement element) throws IOException {
        wait.until(ExpectedConditions.attributeContains(element, "src", "imgflip.com"));
        String link = element.getAttribute("src");
        URL imageURL = new URL(link);
        BufferedImage saveImage = ImageIO.read(imageURL);
        String location = "C:\\Users\\SShock\\IdeaProjects\\Selenium\\src\\test\\java\\Demoqa";
        ImageIO.write(saveImage, "png", new File(location + System.currentTimeMillis() + ".png"));
    }
    @FindBy(css = "#app > div > div > div.home-body > div > div:nth-child(1) > div > div.card-body")
    public List<WebElement> cards;

    //---------------

    public void clickOnElements() {
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).getText().equals("Elements")) {
                scrollIntoView(cards.get(i));
                cards.get(i).click();
                break;
            }
        }
    }


    @AfterClass
    public void tearDown() {
        //driver.manage().deleteAllCookies();
        //driver.quit();
    }

}
