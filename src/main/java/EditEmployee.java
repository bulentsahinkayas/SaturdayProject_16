import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class EditEmployee {

    WebDriver driver;
    protected WebDriverWait wait;

    public EditEmployee(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }
    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public void setWait(WebDriverWait wait) {
        this.wait = wait;
    }
    //Selectors - Page Objects
    public By enterName = By.cssSelector("ms-text-field[formcontrolname='firstName'] input");
    public By enterLastName = By.cssSelector("ms-text-field[formcontrolname=\"lastName\"] input");
    public By enterEmployeeID = By.cssSelector("input[formcontrolname='employeeId']");
    public By enterEditButton = By.xpath("//button[@color='accent']//*[name()='svg']");
    public By enterDocumentType = By.cssSelector("mat-form-field[formgroupname=\"documentInfo\"] span");//div[class='mat-select-arrow ng-tns-c215-509']
    public By selectDocumentType = By.xpath("//span[contains(text(), ' Personal ID ')]");
    public By selectDocumentTypePassport = By.xpath("//span[contains(text(), 'Birth Certificate')]");
    public By enterDocumentNo = By.cssSelector("input[formcontrolname=\"documentNumber\"]");
    public By enterSaveButton = By.cssSelector("button[class=\"mat-focus-indicator mat-tooltip-trigger " +
            "save-button mat-accent mat-button mat-raised-button mat-button-base ng-star-inserted\"]");
    public static By photoButton = By.cssSelector(" div > div > div:nth-child(2) > button:nth-child(2)");
    public static By photoUploadButton = By.cssSelector("button[class=\"mat-focus-indicator mat-mini-fab mat-button-base mat-accent\"]");
    public static By photoYesButton = By.xpath("//span[contains(text(), 'Yes')]");
    public static By photoCloseButton = By.xpath("//span[contains(text(), 'Close')]");
    public static By photoDeleteButton = By.cssSelector("button[class=\"mat-focus-indicator mat-raised-button mat-button-base mat-warn\"]");
    public static By photoDeleteYes = By.cssSelector("button[class=\"mat-focus-indicator mat-button mat-raised-button mat-button-base mat-accent\"]");

    public static By photoUploadPermit = By.xpath("//span[contains(text(), 'Upload')]");
    public void clickEditButton() throws InterruptedException {
        WebElement editButton = wait.until(ExpectedConditions.visibilityOf(driver.findElement(enterEditButton)));
        
        editButton.click();
    }
    public void enterSaveButt(){
        WebElement saveButton = wait.until(ExpectedConditions.visibilityOf(driver.findElement(enterSaveButton)));
        saveButton.click();
    }



    public void editName(String firstName) throws InterruptedException {

        clickEditButton();
        WebElement enterNameInput = wait.until(ExpectedConditions.visibilityOf(driver.findElement(enterName)));
       Thread.sleep(3000);
        enterNameInput.clear();
        
        enterNameInput.sendKeys(firstName);
        enterSaveButt();
    }
    public void editLastname(String lastName) throws InterruptedException {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table/tbody/tr/td[3][contains(text(),'" + lastName + "')]")));
        clickEditButton();
        WebElement enterLastname = wait.until(ExpectedConditions.visibilityOf(driver.findElement(enterLastName)));
        Thread.sleep(3000);
        enterLastname.clear();
        enterLastname.sendKeys(lastName);
        
        enterSaveButt();
    }
    public void editId(String employeeId) throws InterruptedException {
        clickEditButton();
        WebElement enterEmployeeIDInput = wait.until(ExpectedConditions.visibilityOf(driver.findElement(enterEmployeeID)));
        enterEmployeeIDInput.clear();
        enterEmployeeIDInput.sendKeys(employeeId);
        enterSaveButt();
    }

    public void editDocumentNum(String docNumber) throws InterruptedException {
        Thread.sleep(3000);
        clickEditButton();
        WebElement enterDocumentNumber = wait.until(ExpectedConditions.visibilityOf(driver.findElement(enterDocumentNo)));
        Thread.sleep(3000);
        enterDocumentNumber.clear();
        enterDocumentNumber.sendKeys(docNumber);
        
        enterSaveButt();
    }
    public void editDocumentType() throws InterruptedException {
        Thread.sleep(3000);
        clickEditButton();
        Thread.sleep(3000);
        WebElement editDocumentType = wait.until(ExpectedConditions.visibilityOf(driver.findElement(enterDocumentType)));
        Thread.sleep(3000);
        editDocumentType.click();
        WebElement selectDocumentType = wait.until(ExpectedConditions.visibilityOf(driver.findElement(selectDocumentTypePassport)));
        Thread.sleep(3000);
        selectDocumentType.click();
        enterSaveButt();
    }
    public void uploadPhoto() throws InterruptedException, AWTException {
        Thread.sleep(3000);
        clickEditButton();
        Thread.sleep(3000);
        WebElement enterPhoto = wait.until(ExpectedConditions.visibilityOfElementLocated(photoButton));
        enterPhoto.click();
        WebElement enterUploadingButt = wait.until(ExpectedConditions.visibilityOfElementLocated(photoUploadButton));

        String path = "C:\\Users\\BULENT\\Desktop\\Photo\\images.jpg";
        StringSelection stringSelection = new StringSelection(path);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection,null);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-icon='upload']"))).click();
        Thread.sleep(2000);

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        wait.until(ExpectedConditions.visibilityOfElementLocated(photoUploadPermit)).click();


    }
    public  void deletePhoto() throws InterruptedException {
        Thread.sleep(3000);
        clickEditButton();
        Thread.sleep(3000);
        WebElement enterPhoto = wait.until(ExpectedConditions.visibilityOfElementLocated(photoButton));
        enterPhoto.click();
        Thread.sleep(3000);
        WebElement deletePhotoButt = wait.until(ExpectedConditions.visibilityOfElementLocated(photoDeleteButton));
        deletePhotoButt.click();
        Thread.sleep(3000);
        WebElement deleteYesButt = wait.until(ExpectedConditions.visibilityOfElementLocated(photoDeleteYes));
        deleteYesButt.click();
        WebElement enterCloseButt = wait.until(ExpectedConditions.visibilityOfElementLocated(photoCloseButton));
        enterCloseButt.click();
    }
}
