package Demoqa.Pages;

import Demoqa.Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WebTablesPage extends BaseTest {
    public WebTablesPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#addNewRecordButton")
    public WebElement addButton;
    @FindBy(css = "#searchBox")
    private WebElement searchTextBox;
    @FindBy(css = "#basic-addon2")
    private WebElement searchButton;

    @FindBy(css = "#firstName")
    private WebElement firstName;
    @FindBy(css = "#lastName")
    private WebElement lastName;
    @FindBy(css = "#userEmail")
    private WebElement userEmail;
    @FindBy(css = "#age")
    private WebElement age;
    @FindBy(css = "#salary")
    private WebElement salary;
    @FindBy(css = "#department")
    private WebElement department;
    @FindBy(css = "#submit")
    private WebElement submitButton;
    @FindBy(css = "#edit-record-1")
    private WebElement editButton;
    @FindBy(css = "[id^='delete-record-']")
    private WebElement deleteButton;

    public void enterTextInSearchBox(String text) {
        searchTextBox.clear();
        searchTextBox.sendKeys(text);
    }
    public void clickOnAddButton() {
        addButton.click();
    }
    public void enterTextInFirstName(String text) {
        firstName.clear();
        firstName.sendKeys(text);
    }
    public void enterTextInLastName(String text) {
        lastName.clear();
        lastName.sendKeys(text);
    }
    public void enterEmail(String text) {
        userEmail.clear();
        userEmail.sendKeys(text);
    }
    public void enterAge(String text) {
        age.clear();
        age.sendKeys(text);
    }
    public void enterSalary(String text) {
        salary.clear();
        salary.sendKeys(text);
    }
    public void enterDepartment(String text) {
        department.clear();
        department.sendKeys(text);
    }
    public void clickOnSubmitButton() {
        submitButton.click();
    }
    public void clickOnEditButton() {
        editButton.click();
    }
    public void clickOnDeleteButton() {
        deleteButton.click();
    }
    public void clickOnSearchButton() {
        searchButton.click();
    }

    public void selectUserByEmail(String email) {
        enterTextInSearchBox(email);
        clickOnSearchButton();
    }
}