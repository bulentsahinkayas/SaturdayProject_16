import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateEmployee {

    WebDriver driver;
    WebDriverWait wait;

    public CreateEmployee(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public By humanResMenu = By.xpath("//span[contains(text(), 'Human Resources')]");
    public By employeeMenu = By.xpath("//*[@id=\"container-1\"]/fuse-sidebar/navbar/navbar-vertical-style-1/div[2]/div[1]/div/div/fuse-navigation/div/" +
            "fuse-nav-vertical-group/div/fuse-nav-vertical-collapsable[5]/div/fuse-nav-vertical-item[1]/a/span");
    public By employeeAddButton = By.cssSelector("ms-table-toolbar > div > ms-add-button > div > button");
    public By enterName = By.cssSelector("ms-text-field[formcontrolname='firstName'] input");
    public By enterLastName = By.cssSelector("ms-text-field[formcontrolname=\"lastName\"] input");
    public By enterEmployeeID = By.cssSelector("input[formcontrolname='employeeId']");
    public By enterDocumentType = By.cssSelector("mat-form-field[formgroupname=\"documentInfo\"] span");
    public By selectDocumentType = By.xpath("//span[contains(text(), ' Personal ID ')]");
    public By enterDocumentNo = By.cssSelector("input[formcontrolname=\"documentNumber\"]");
    public By enterSaveButton = By.cssSelector("button[class=\"mat-focus-indicator mat-tooltip-trigger " +
            "save-button mat-accent mat-button mat-raised-button mat-button-base ng-star-inserted\"]");

    public void create(String firstName, String lastName, String employeeId, String docNumber){
        wait.until(ExpectedConditions.visibilityOfElementLocated(humanResMenu)).click();
        WebElement clickEmployees = wait.until(ExpectedConditions.visibilityOfElementLocated(employeeMenu));
        clickEmployees.click();
        WebElement employeesAddSign = wait.until(ExpectedConditions.visibilityOfElementLocated(employeeAddButton));
        employeesAddSign.click();
        WebElement enterNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(enterName));
        enterNameInput.sendKeys(firstName);
        WebElement enterLastname = wait.until(ExpectedConditions.visibilityOfElementLocated(enterLastName));
        enterLastname.sendKeys(lastName);
        WebElement enterEmployeeIDInput = wait.until(ExpectedConditions.visibilityOfElementLocated(enterEmployeeID));
        enterEmployeeIDInput.sendKeys(employeeId);
        WebElement documentType = wait.until(ExpectedConditions.visibilityOfElementLocated(enterDocumentType));
        documentType.click();
        WebElement enterDocumentType = wait.until(ExpectedConditions.visibilityOfElementLocated(selectDocumentType));
        enterDocumentType.click();
        WebElement enterDocumentNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(enterDocumentNo));
        enterDocumentNumber.sendKeys(docNumber);
        WebElement saveButton = wait.until(ExpectedConditions.visibilityOfElementLocated(enterSaveButton));
        saveButton.click();
    }
}
