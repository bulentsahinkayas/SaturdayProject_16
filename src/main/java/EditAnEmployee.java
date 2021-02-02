import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditAnEmployee extends SearchForAnEmployee  {

    public EditAnEmployee(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public By enterName = By.cssSelector("ms-text-field[formcontrolname='firstName'] input");
    public By enterLastName = By.cssSelector("ms-text-field[formcontrolname=\"lastName\"] input");
    public By enterEmployeeID = By.cssSelector("input[formcontrolname='employeeId']");
    public By enterDocumentType = By.cssSelector("mat-form-field[formgroupname=\"documentInfo\"] span");
    public By enterDocumentNo = By.cssSelector("input[formcontrolname=\"documentNumber\"]");
    public By enterSaveButton = By.cssSelector("button[class=\"mat-focus-indicator mat-tooltip-trigger " +
            "save-button mat-accent mat-button mat-raised-button mat-button-base ng-star-inserted\"]");
        public void edit(String firstNameEdit, String lastNameEdit, String employeeIdEdit, String docNumberEdit){

        WebElement enterNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(enterName));
        enterNameInput.sendKeys(firstNameEdit);
        WebElement enterLastname = wait.until(ExpectedConditions.visibilityOfElementLocated(enterLastName));
        enterLastname.sendKeys(lastNameEdit);
        WebElement enterEmployeeIDInput = wait.until(ExpectedConditions.visibilityOfElementLocated(enterEmployeeID));
        enterEmployeeIDInput.sendKeys(employeeIdEdit);
        WebElement documentType = wait.until(ExpectedConditions.visibilityOfElementLocated(enterDocumentType));
        documentType.click();
        WebElement enterDocumentNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(enterDocumentNo));
        enterDocumentNumber.sendKeys(docNumberEdit);
        WebElement saveButton = wait.until(ExpectedConditions.visibilityOfElementLocated(enterSaveButton));
        saveButton.click();
    }
}
