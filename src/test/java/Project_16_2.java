import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Project_16_2 extends Base{

    @BeforeClass
    public void loginTest() throws InterruptedException {
        // Login by the credentials (username = "daulet2030@gmail.com" and password = "TechnoStudy123@")
        loginClass.login();
        String actual = driver.findElement(By.cssSelector("h3")).getText();
        Assert.assertEquals(actual, "MERSYS Campus - Dashboard");
    }

    @DataProvider(name="employeeName")
    public Object[][] sectionData() {
        String[][] testData = {
                {"Bulent", "Sahin","123456","654321"},
                {"Yusuf", "Kaya","456456","231321"}
        };
        return testData;
    }
    @DataProvider(name="nameSurname")
    public Object[][] sectionDelete() {
        String[][] testData = {
                {"Bulent", "Sahin"}
        };
        return testData;
    }


//    @Parameters({"firstName", "lastName", "employeeId", "docNumber"})
    @Test(priority = 1,dataProvider = "employeeName")
    public void createFirstEmployeeTest(String firstName, String lastName, String employeeId, String docNumber){
        createEmployee.create(firstName, lastName, employeeId, docNumber);
        String textMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container"))).getText();
        System.out.println(textMessage);
        Assert.assertEquals(textMessage,"Employee successfully created");
      //  Assert.assertTrue(true);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container-2\"]/footer/employee-form-buttons/button-bar/div/div[1]/ms-delete-button/button/span[1]/span"))).click();
//        searchForAnEmployee.searchEmployee(firstName, lastName);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ms-delete-button[class='ng-star-inserted'] button svg"))).click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class='mat-focus-indicator mat-button mat-raised-button mat-button-base mat-accent']"))).click();
        //button[class='mat-focus-indicator mat-button mat-raised-button mat-button-base mat-accent']
    }

//    @Test(priority = 2)
//    public void deleteFirstEmployeeTest(){
//        deleteEmployee.delete();
//        Assert.assertTrue(true);
//    }


 //   @Parameters({"firstName", "lastName"})
    @Test(priority = 2, dataProvider = "nameSurname")
    public void deleteFirstEmployeeTest(String firstName, String lastName){
        searchForAnEmployee.searchEmployee(firstName, lastName);
        deleteEmployee.delete();
        String deleteMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container"))).getText();
    }


//
//    @Test
//    public void XXX() {
//        /////////  Open a browser and navigate to https://test.campus.techno.study////////////
//
//        ////// Dismiss the cookie message by clicking on "Got it!" button//////////
//
/////////Test 2: Verify that an existing employee can be deleted///// use it Later
//
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
}

//  Note-1: Use TestNG for your tests
//  Note-2: Do not forget to delete whatever you have created manually if needed in order to keep the data clean for other testers please.
//  Setup for your test cases:

//  Open a browser and navigate to https://test.campus.techno.study/
//  Dismiss the cookie message by clicking on "Got it!" button
//  Login by the credentials (username = "daulet2030@gmail.com" and password = "TechnoStudy123@")


//  Test 1: Verify that an employee can be created with a minimum (First Name, Last Name, Employee ID, Document Type and Document Number) data --> (passes)
//  Test 2: Verify that an existing employee can be deleted
//  Test 3: Verify that the first name of an existing employee can be updated --> (passes)
//  Test 4: Verify that the last name of an existing employee can be updated --> (passes)
//  Test 5: Verify that the document number of an existing employee can be updated --> (passes)
//  Test 6: Verify that (any other data you decided) of an existing employee can be updated --> (passes)
//  Test 7: Verify that an employee with different names but the same Employee ID cannot be created --> (fails!)
//  Test 8: Verify that an employee with different names but the same Document Number cannot be created --> (passes)
//  Test 9: Verify that an employee with the same First Name and Last Name can be created --> (passes)

//  Use a data provider to do the Tests 10-15
//  Test 10: Verify that an employee without entering a first name cannot be created --> (passes)
//  Test 11: Verify that an employee without entering a last name cannot be created --> (passes)
//  Test 12: Verify that an employee without entering an Employee ID cannot be created --> (passes)
//  Test 13: Verify that an employee cannot be created if you enter just numerical values for the First Name --> (fails!!!)
//  Test 14: Verify that an employee cannot be created if you enter just special characters like @,!,#, ,%,^,... for the name --> (fails!!!)
//  Test 15: Add your own test data for the data provider for a negative testing of creating an employee (feel free to add more than one case)

//  Test 16: Verify that a photo can be uploaded while creating a new employee --> (fails!)
//  Test 17: Verify that a photo can be uploaded for an existing employee --> (passes)
//  Test 18:Verify that the photo of an existing employee can be changed --> (passes)
//  Test 19: Verify that the photo of an existing employee can be deleted --> (passes)

//  Write at least three different test cases for the search options of your own!

//  Close the browser

//  Good luck!