import org.testng.Assert;
import org.testng.annotations.Test;

public class Project_16_TestNG {
    String word;
    String word1 = "AB";
    String word2 = "A".concat("B");
    @Test
    public void test1(){
        Assert.assertFalse(false);
    }
    @Test
    public void test2(){
        Assert.assertNull(word);
    }
    @Test
    public void test3(){
        Assert.assertSame(word1,word2);
    }
    @Test
    public void test4(){
        Assert.assertEquals(word1,word2);
    }
}
/*
    WebDriver driver;
    WebDriverWait wait;

    public EditAnEmployee(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
    public By enterName = By.cssSelector("ms-text-field[formcontrolname='firstName'] input");
    public By enterLastName = By.cssSelector("ms-text-field[formcontrolname=\"lastName\"] input");
    public By enterEmployeeID = By.cssSelector("input[formcontrolname='employeeId']");
    public By enterEditButton = By.cssSelector("ms-edit-button[class='ng-star-inserted'] button span svg");
    public By enterDocumentNo = By.cssSelector("input[formcontrolname=\"documentNumber\"]");
    public By enterSaveButton = By.cssSelector("button[class=\"mat-focus-indicator mat-tooltip-trigger " +
            "save-button mat-accent mat-button mat-raised-button mat-button-base ng-star-inserted\"]");
    WebElement saveButton = wait.until(ExpectedConditions.visibilityOfElementLocated(enterSaveButton));
    WebElement editButton = wait.until(ExpectedConditions.visibilityOfElementLocated(enterEditButton));

        public void editName(String firstName) {
            editButton.click();
            WebElement enterNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(enterName));
            enterNameInput.clear();
            enterNameInput.sendKeys(firstName);
            saveButton.click();
        }
        public void editLastname(String lastName) {
            editButton.click();
                WebElement enterLastname = wait.until(ExpectedConditions.visibilityOfElementLocated(enterLastName));
                enterLastname.clear();
                enterLastname.sendKeys(lastName);
                saveButton.click();
            }
        public void editId(String employeeId) {
        editButton.click();
        WebElement enterEmployeeIDInput = wait.until(ExpectedConditions.visibilityOfElementLocated(enterEmployeeID));
        enterEmployeeIDInput.clear();
        enterEmployeeIDInput.sendKeys(employeeId);
        saveButton.click();
    }

    public void editDocumentNum(String docNumber){
        editButton.click();
        WebElement enterDocumentNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(enterDocumentNo));
        enterDocumentNumber.clear();
        enterDocumentNumber.sendKeys(docNumber);
        saveButton.click();
    }
 */
/*
     public void editName(String firstName) {

            WebElement enterNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(enterName));
            enterNameInput.clear();
            enterNameInput.sendKeys(firstName);
            saveButton.click();
        }
            public void editLastname(String lastName) {
                WebElement enterLastname = wait.until(ExpectedConditions.visibilityOfElementLocated(enterLastName));
                enterLastname.clear();
                enterLastname.sendKeys(lastName);
                saveButton.click();
            }
    public void editId(String employeeId) {
        WebElement enterEmployeeIDInput = wait.until(ExpectedConditions.visibilityOfElementLocated(enterEmployeeID));
        enterEmployeeIDInput.clear();
        enterEmployeeIDInput.sendKeys(employeeId);
        saveButton.click();
    }

    public void editDocumentNum(String docNumber){
        WebElement enterDocumentNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(enterDocumentNo));
        enterDocumentNumber.clear();
        enterDocumentNumber.sendKeys(docNumber);
        saveButton.click();
 */
