//import org.openqa.selenium.By;
//import org.openqa.selenium.TimeoutException;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//
//import java.time.Instant;
//import java.util.concurrent.TimeUnit;
//
//public class Project_16 {
//    public String gotItButton = "#cookieconsent div div a";
//    WebDriverWait wait;
//
//    public static void main(String[] args) {
//        /////////  Open a browser and navigate to https://test.campus.techno.study////////////
//        System.setProperty("webdriver.chrome.driver",MyConstants.DRIVER_PATH);
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://test.campus.techno.study/");
//        WebDriverWait wait = new WebDriverWait(driver,10);
//        ////// Dismiss the cookie message by clicking on "Got it!" button//////////
//        WebElement gotIt;
//        gotIt = wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.gotItButton));
//        gotIt.click();
//
//        driver.manage().window().maximize();
//        // Login by the credentials (username = "daulet2030@gmail.com" and password = "TechnoStudy123@")
//        driver.findElement(Selectors.username).sendKeys("daulet2030@gmail.com");
//        driver.findElement(Selectors.password).sendKeys("TechnoStudy123@");
//        driver.findElement(Selectors.loginButton).click();
//        /////////  Navigate to HumanResources > Employees through the left menu////////////
//        wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.humanResMenu)).click();
////        driver.findElement(By.cssSelector("div>fuse-nav-vertical-collapsable.ng-tns-c103-20.nav-collapsable.nav-item.ng-star-inserted > a > span")).click();
//
//        ////////Test 1: Verify that an employee can be created with a minimum (First Name, Last Name, Employee ID, Document Type and Document Number) data --> (passes)/////////
//        WebElement clickEmployees = wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.employeeMenu));
//        clickEmployees.click();
//        WebElement employeesAddSign = wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.employeeAddButton));
//        employeesAddSign.click();
//        WebElement enterName = wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.enterName));
//        enterName.sendKeys("Bulent");
//        WebElement enterLastname = wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.enterLastName));
//        enterLastname.sendKeys("Sahin");
////        WebElement enterEmployeeType = driver.findElement(By.xpath("\\\\span[contains(text(), ' Employee Type ')]"));
////        enterEmployeeType.click();
//        WebElement enterEmployeeID = wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.enterEmployeeID));
//        enterEmployeeID.sendKeys("123456");
//
//        WebElement documentType = wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.enterDocumentType));
//        documentType.click();
//        WebElement enterDocumentType = wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.selectDocumentType));
//        enterDocumentType.click();
//        WebElement enterDocumentNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.enterDocumentNo));
//        enterDocumentNumber.sendKeys("789654");
//        WebElement saveButton = wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.enterSaveButton));
//        saveButton.click();
/////////Test 2: Verify that an existing employee can be deleted///// use it Later
//        WebElement deleteEmployee = wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.enterDeleteButton));
//
//        /////////////   SECOND EMPLOYEE  //////////
//        wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.humanResMenu)).click();
//        clickEmployees = wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.employeeMenu));
//        clickEmployees.click();
//        employeesAddSign = wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.employeeAddButton));
//        employeesAddSign.click();
//        enterName = wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.enterName));
//        enterName.sendKeys("Yusuf");
//        enterLastname = wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.enterLastName));
//        enterLastname.sendKeys("Sahink");
////        WebElement enterEmployeeType = driver.findElement(By.xpath("\\\\span[contains(text(), ' Employee Type ')]"));
////        enterEmployeeType.click();
//        enterEmployeeID = wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.enterEmployeeID));
//        enterEmployeeID.sendKeys("234567");
//
//        documentType = wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.enterDocumentType));
//        documentType.click();
//        enterDocumentType = wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.selectDocumentType));
//        enterDocumentType.click();
//        enterDocumentNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.enterDocumentNo));
//        enterDocumentNumber.sendKeys("7896564");
//        saveButton = wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.enterSaveButton));
//        saveButton.click();
//
//
////        wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.humanResMenu)).click();
////        clickEmployees = wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.employeeMenu));
////        clickEmployees.click();
////        WebElement searchName = driver.findElement(Selectors.searchEmployeeName);
////        searchName.sendKeys("Bulent");
////        WebElement searchButton = driver.findElement(Selectors.searchButton);
////        searchButton.click();
////
////        WebElement enterTrashIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.trashIcon));
////        enterTrashIcon.click();
////        WebElement deleteEmployeeByYes = wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.enterYesForDelete));
////        deleteEmployeeByYes.click();
//
//        //////  Test 3: Verify that the first name of an existing employee can be updated --> (passes)///////
//
//        /////Test 3: Verify that the first name of an existing employee can be updated --> (passes)/////
//        wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.humanResMenu)).click();
//        clickEmployees = wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.employeeMenu));
//        clickEmployees.click();
//        WebElement searchFirstName = wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.searchEmployeeName));
//        searchFirstName.sendKeys("Yusuf");
//        WebElement searchButton = driver.findElement(Selectors.searchButton);
//        searchButton.click();
//        WebElement clickEditButton = wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.enterEditButton));
//        clickEditButton.click();
//        WebElement editName = wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.enterName));
//
////        waitFor(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[class=\"mat-input-element mat-form-field-autofill-control ng-pristine cdk-" +
////                "text-field-autofill-monitored ng-valid ng-touched")),"Document ID locator is not found");
////        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[class=\"mat-input-element mat-form-field-" +
////                "autofill-control ng-pristine cdk-text-field-autofill-monitored ng-valid ng-touched"))).clear();
////        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[class=\"mat-input-element mat-form-field-autofill-control ng-pristine cdk-" +
////                "text-field-autofill-monitored ng-valid ng-touched"))).sendKeys("Ahmet");
////        enterName.click();
//        editName.clear();
//        editName.sendKeys("Ahmet");
//
//
////  Test 4: Verify that the last name of an existing employee can be updated --> (passes)
////        wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.humanResMenu)).click();
////        clickEmployees = wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.employeeMenu));
////        clickEmployees.click();
////        searchLastName = wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.searchEmployeeLastname));
////        searchLastName.sendKeys("Sahink");
////        searchButton = driver.findElement(Selectors.searchButton);
////        enterLastname.click();
////        enterLastname.clear();
////        enterLastname.sendKeys("Kaya");
//
//    }
//    private <T> void waitFor(ExpectedCondition<T> condition) {
//        waitFor(condition, condition.toString());
//    }
//
//    private <T> void waitFor(ExpectedCondition<T> condition, String errorMessage) {
//        try {
//            wait.until(condition);
//        } catch (TimeoutException e) {
//            Assert.fail(errorMessage);
//        }
//    }
//}
//
////  Note-1: Use TestNG for your tests
////  Note-2: Do not forget to delete whatever you have created manually if needed in order to keep the data clean for other testers please.
////  Setup for your test cases:
//
////  Open a browser and navigate to https://test.campus.techno.study/
////  Dismiss the cookie message by clicking on "Got it!" button
////  Login by the credentials (username = "daulet2030@gmail.com" and password = "TechnoStudy123@")
//
//
////  Test 1: Verify that an employee can be created with a minimum (First Name, Last Name, Employee ID, Document Type and Document Number) data --> (passes)
////  Test 2: Verify that an existing employee can be deleted
////  Test 3: Verify that the first name of an existing employee can be updated --> (passes)
////  Test 4: Verify that the last name of an existing employee can be updated --> (passes)
////  Test 5: Verify that the document number of an existing employee can be updated --> (passes)
////  Test 6: Verify that (any other data you decided) of an existing employee can be updated --> (passes)
////  Test 7: Verify that an employee with different names but the same Employee ID cannot be created --> (fails!)
////  Test 8: Verify that an employee with different names but the same Document Number cannot be created --> (passes)
////  Test 9: Verify that an employee with the same First Name and Last Name can be created --> (passes)
//
////  Use a data provider to do the Tests 10-15
////  Test 10: Verify that an employee without entering a first name cannot be created --> (passes)
////  Test 11: Verify that an employee without entering a last name cannot be created --> (passes)
////  Test 12: Verify that an employee without entering an Employee ID cannot be created --> (passes)
////  Test 13: Verify that an employee cannot be created if you enter just numerical values for the First Name --> (fails!!!)
////  Test 14: Verify that an employee cannot be created if you enter just special characters like @,!,#, ,%,^,... for the name --> (fails!!!)
////  Test 15: Add your own test data for the data provider for a negative testing of creating an employee (feel free to add more than one case)
//
////  Test 16: Verify that a photo can be uploaded while creating a new employee --> (fails!)
////  Test 17: Verify that a photo can be uploaded for an existing employee --> (passes)
////  Test 18:Verify that the photo of an existing employee can be changed --> (passes)
////  Test 19: Verify that the photo of an existing employee can be deleted --> (passes)
//
////  Write at least three different test cases for the search options of your own!
//
////  Close the browser
//
////  Good luck!