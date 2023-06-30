package Demoqa.Pages;

import Demoqa.Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TextBoxPage extends BaseTest {

    @FindBy(css = "#userName")
    private WebElement inputFullName;

    @FindBy(css = "#userEmail")
    private WebElement userEmail;

    @FindBy(css = "#currentAddress")
    private WebElement currentAddress;

    @FindBy(css = "#permanentAddress")
    private WebElement permanentAddress;

    @FindBy(css = "#submit")
    private WebElement buttonSubmit;

    @FindBy(css = "#output > div")
    private WebElement confirmationBox;

    public WebElement getConfirmationBox() {
        return confirmationBox;
    }

    public void sendFullName(String fullName) {
        inputFullName.sendKeys(fullName);
    }

    public void sendEmail(String email) {
        userEmail.sendKeys(email);
    }

    public void sendCurrentAddress(String currentAddress) {
        this.currentAddress.sendKeys(currentAddress);
    }

    public void sendPermanentAddress(String permanentAddress) {
        this.permanentAddress.sendKeys(permanentAddress);
    }

    public void clickSubmit() {
        buttonSubmit.click();
    }
}
