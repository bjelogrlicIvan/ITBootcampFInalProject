package Demoqa.Pages;

import Demoqa.Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CheckBox extends BaseTest {
    public CheckBox() {
        PageFactory.initElements(driver, this);
    }
    WebElement plusButton;
    WebElement minusButton;
    WebElement homeToggle;
    WebElement desktopToggle;
    WebElement documentToggle;
    WebElement downloadToggle;
    WebElement homeCheckBox;
    WebElement desktopCheckBox;
    WebElement documentsCheckBox;
    WebElement downloadCheckBox;


    WebElement notesCheckBox;
    WebElement commandsCheckBox;
    WebElement workSpaceCheckBox;
    WebElement officeCheckBox;
    WebElement wordFileCheckBox;
    WebElement excelFileCheckBox;

    public WebElement getPlusButton() {
        return driver.findElement(By.cssSelector("body > div#app:nth-child(6) > div.body-height:nth-child(2) > div.container.playgound-body > div.row:nth-child(2) > div.col-12.mt-4.col-md-6:nth-child(2) > div.check-box-tree-wrapper:nth-child(2) > div#tree-node.react-checkbox-tree.rct-icons-fa4 > div.rct-options:nth-child(1) > button.rct-option.rct-option-expand-all:nth-child(1)"));
    }

    public WebElement getMinusButton() {
        return driver.findElement(By.cssSelector("body > div#app:nth-child(6) > div.body-height:nth-child(2) > div.container.playgound-body > div.row:nth-child(2) > div.col-12.mt-4.col-md-6:nth-child(2) > div.check-box-tree-wrapper:nth-child(2) > div#tree-node.react-checkbox-tree.rct-icons-fa4 > div.rct-options:nth-child(1) > button.rct-option.rct-option-collapse-all:nth-child(2)"));
    }

    public WebElement getHomeToggle() {
        return driver.findElement(By.cssSelector("body > div#app:nth-child(6) > div.body-height:nth-child(2) > div.container.playgound-body > div.row:nth-child(2) > div.col-12.mt-4.col-md-6:nth-child(2) > div.check-box-tree-wrapper:nth-child(2) > div#tree-node.react-checkbox-tree.rct-icons-fa4 > ol:nth-child(2) > li.rct-node.rct-node-parent.rct-node-collapsed > span.rct-text > button.rct-collapse.rct-collapse-btn:nth-child(1)"));
    }

    public WebElement getDesktopToggle() {
        return driver.findElement(By.cssSelector("#tree-node > ol > li > ol > li:nth-child(1)"));
    }

    public WebElement getDocumentToggle() {
        return driver.findElement(By.cssSelector("body > div#app:nth-child(6) > div.body-height:nth-child(2) > div.container.playgound-body > div.row:nth-child(2) > div.col-12.mt-4.col-md-6:nth-child(2) > div.check-box-tree-wrapper:nth-child(2) > div#tree-node.react-checkbox-tree.rct-icons-fa4 > ol:nth-child(2) > li.rct-node.rct-node-parent.rct-node-expanded > ol:nth-child(2) > li.rct-node.rct-node-parent.rct-node-collapsed:nth-child(2) > span.rct-text > label:nth-child(2) > span.rct-checkbox:nth-child(2)"));
    }

    public WebElement getDownloadToggle() {
        return driver.findElement(By.cssSelector("body > div#app:nth-child(6) > div.body-height:nth-child(2) > div.container.playgound-body > div.row:nth-child(2) > div.col-12.mt-4.col-md-6:nth-child(2) > div.check-box-tree-wrapper:nth-child(2) > div#tree-node.react-checkbox-tree.rct-icons-fa4 > ol:nth-child(2) > li.rct-node.rct-node-parent.rct-node-expanded > ol:nth-child(2) > li.rct-node.rct-node-parent.rct-node-collapsed:nth-child(3) > span.rct-text > button.rct-collapse.rct-collapse-btn:nth-child(1)"));
    }

    public WebElement getHomeCheckBox() {
        return driver.findElement(By.cssSelector("body > div#app:nth-child(6) > div.body-height:nth-child(2) > div.container.playgound-body > div.row:nth-child(2) > div.col-12.mt-4.col-md-6:nth-child(2) > div.check-box-tree-wrapper:nth-child(2) > div#tree-node.react-checkbox-tree.rct-icons-fa4 > ol:nth-child(2) > li.rct-node.rct-node-parent.rct-node-expanded > span.rct-text:nth-child(1) > label:nth-child(2) > span.rct-checkbox:nth-child(2)"));
    }

    public WebElement getDesktopCheckBox() {
        return driver.findElement(By.cssSelector("#tree-node > ol > li > ol > li:nth-child(1) > span > label > span.rct-checkbox"));
    }

    public WebElement getDocumentsCheckBox() {
        return driver.findElement(By.cssSelector("#tree-node > ol > li > ol > li:nth-child(2) > span > label > span.rct-checkbox"));
    }

    public WebElement getDownloadCheckBox() {
        return driver.findElement(By.cssSelector("#tree-node > ol > li > ol > li:nth-child(3) > span > label > span.rct-checkbox"));
    }

    public WebElement getNotesCheckBox() {
        return driver.findElement(By.cssSelector("body > div#app:nth-child(6) > div.body-height:nth-child(2) > div.container.playgound-body > div.row:nth-child(2) > div.col-12.mt-4.col-md-6:nth-child(2) > div.check-box-tree-wrapper:nth-child(2) > div#tree-node.react-checkbox-tree.rct-icons-fa4 > ol:nth-child(2) > li.rct-node.rct-node-parent.rct-node-expanded > ol:nth-child(2) > li.rct-node.rct-node-parent.rct-node-expanded:nth-child(1) > ol:nth-child(2) > li.rct-node.rct-node-leaf:nth-child(1) > span.rct-text > label:nth-child(2) > span.rct-checkbox:nth-child(2)"));
    }

    public WebElement getCommandsCheckBox() {
        return driver.findElement(By.cssSelector("#tree-node > ol > li > ol > li:nth-child(1) > ol > li:nth-child(2) > span > label > span.rct-checkbox"));
    }

    public WebElement getWorkSpaceCheckBox() {
        return driver.findElement(By.cssSelector("#tree-node > ol > li > ol > li:nth-child(2) > ol > li:nth-child(1) > span > label > span.rct-checkbox"));
    }

    public WebElement getOfficeCheckBox() {
        return driver.findElement(By.cssSelector("#tree-node > ol > li > ol > li:nth-child(2) > ol > li.rct-node.rct-node-parent.rct-node-expanded > span > label > span.rct-checkbox"));
    }

    public WebElement getWordFileCheckBox() {
        return driver.findElement(By.cssSelector("#tree-node > ol > li > ol > li:nth-child(3) > ol > li:nth-child(1) > span > label > span.rct-checkbox"));
    }

    public WebElement getExcelFileCheckBox() {
        return driver.findElement(By.cssSelector("#tree-node > ol > li > ol > li:nth-child(3) > ol > li:nth-child(2) > span > label > span.rct-checkbox"));
    }
}
