import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;


public class Project16DataProviderExercise {

    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor jse;


    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        jse = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);

        // Navigate to https://test.campus.techno.study/
        driver.get("https://test.campus.techno.study");
        driver.manage().window().maximize();

        // Dismiss the cookie message by clicking on "Got it!" button
        driver.findElement(By.cssSelector("a[aria-label=\"dismiss cookie message\"]")).click();

        // Login by the credentials (username = "daulet2030@gmail.com" and password = "TechnoStudy123@")
        String username = "daulet2030@gmail.com";
        String password = "TechnoStudy123@";
        driver.findElement(By.cssSelector("input[formcontrolname=\"username\"]")).sendKeys(username);
        driver.findElement(By.cssSelector("input[formcontrolname=\"password\"]")).sendKeys(password);
        driver.findElement(By.cssSelector("button[aria-label=\"LOGIN\"]")).click();
    }

    @DataProvider
    public Object[][] employeeProvider() {
        return new Object[][]{
                {"", "LastNameOne", "EmployeeId1", "DocumentNo1"}, //  Test 10: Verify that an employee without entering a first name cannot be created --> (passes)
                {"FirstNameTwo", "", "EmployeeId2", "DocumentNo2"}, //  Test 11: Verify that an employee without entering a last name cannot be created --> (passes)
                {"FirstNameThree", "LastNameThree", "", "DocumentNo3"},  //  Test 12: Verify that an employee without entering an Employee ID cannot be created --> (passes)
                {"FirstNameFour", "LastNameFour", "EmployeeId4", ""}, //  Test 15: Add your own test data for the data provider for a negative testing of creating an employee (feel free to add more than one case)
                {"123456", "LastNameFive", "EmployeeId5", "DocumentNo5"}, //  Test 13: Verify that an employee cannot be created if you enter just numerical values for the First Name --> (fails!!!)
                {"@#%^-/", "LastNameSix", "EmployeeId5", "DocumentNo6"}, //  Test 14: Verify that an employee cannot be created if you enter just special characters like @,!,#, ,%,^,... for the name --> (fails!!!)
        };
    }

    @Test(dataProvider = "employeeProvider")
    public void createEmployeeTest(String firstName, String lastName, String employeeId, String documentNo) {
        openEmployeesPage();
        attemptToCreateEmployee(firstName, lastName, employeeId, documentNo);
        openEmployeesPage();
        if (lastName.equals("")) {
            searchEmployeeByFirstName(firstName);
        } else {
            searchEmployeeByLastName(lastName);
        }

        Assert.assertTrue(driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]")).getText().contains("No data to show"));
    }

    @AfterMethod
    public void takeScreenshotWhenTastFails(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss-nn");
            String time = LocalDateTime.now().format(formatter);

            File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String folderPath = "C:\\Users\\BULENT\\IdeaProjects\\SaturdayProject_16\\src\\main\\resources\\Screenshots";
            String fileName = result.getMethod().getMethodName() + "_" + time + ".png";

            File destinationFile = new File(folderPath + fileName);

            try {
                FileUtils.copyFile(sourceFile, destinationFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @AfterClass
    public void cleanUp() {
        driver.quit();
    }

    /////////////////////// My helping methods go here ///////////////////////////////////////////

    public void openEmployeesPage() {
        //  Navigate to HumanResources > Employees through the left menu
        driver.findElement(By.cssSelector("div.group-items>fuse-nav-vertical-collapsable:nth-child(5)")).click();
        driver.findElement(By.cssSelector("fuse-nav-vertical-collapsable:nth-child(5)>div.children>fuse-nav-vertical-item:nth-child(2)")).click();
    }

    public void attemptToCreateEmployee(String firstName, String lastName, String employeeId, String documentNo) {
        // Click on + icon to open New Employee Page
        driver.findElement(By.cssSelector("ms-add-button[tooltip=\"EMPLOYEE.TITLE.ADD\"]")).click();

        // Fill in the form
        driver.findElement(By.cssSelector("ms-text-field[formcontrolname='firstName']>input")).sendKeys(firstName);
        driver.findElement(By.cssSelector("ms-text-field[formcontrolname=\"lastName\"]>input")).sendKeys(lastName);
        driver.findElement(By.cssSelector("input[formcontrolname=\"employeeId\"]")).sendKeys(employeeId);

        driver.findElement(By.cssSelector("mat-card >div:nth-child(2)>:nth-child(1)")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("mat-option:nth-child(1)"))).click();

        driver.findElement(By.cssSelector("input[formcontrolname=\"documentNumber\"]")).sendKeys(documentNo);

        //Click on Save button
        driver.findElement(By.cssSelector("ms-save-button > button")).click();
    }

    public void waitFor(long duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void searchEmployeeByFirstName(String firstName) {
        wait.until(ExpectedConditions
                .elementToBeClickable(By.cssSelector("ms-text-field[placeholder='GENERAL.FIELD.FIRST_NAME'] input")))
                .clear();

        wait.until(ExpectedConditions
                .elementToBeClickable(By.cssSelector("ms-text-field[placeholder='GENERAL.FIELD.LAST_NAME'] input")))
                .clear();

        driver.findElement(By.cssSelector("ms-text-field[placeholder='GENERAL.FIELD.FIRST_NAME'] input")).sendKeys(firstName);

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector("button[class=\"mat-focus-indicator mat-raised-button mat-button-base mat-accent\"]")))
                .click();
//        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
//            @Override
//            public Boolean apply(WebDriver driver) {
//                return jse.executeScript("return document.readyState").toString().equals("complete");
//            }
//        };
//        wait.until(jsLoad);
//
//        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
//            @Override
//            public Boolean apply(WebDriver driver) {
//                try {
//                    return ((Long)jse.executeScript("return jQuery.active") == 0);
//                }
//                catch (Exception e) {
//                    return true;
//                }
//            }
//        };
//
//        wait.until(jQueryLoad);
        waitFor(1000);

    }

    public void searchEmployeeByLastName(String lastName) {

        wait.until(ExpectedConditions
                .elementToBeClickable(By.cssSelector("ms-text-field[placeholder='GENERAL.FIELD.LAST_NAME'] input")))
                .clear();

        wait.until(ExpectedConditions
                .elementToBeClickable(By.cssSelector("ms-text-field[placeholder='GENERAL.FIELD.FIRST_NAME'] input")))
                .clear();

        driver.findElement(By.cssSelector("ms-text-field[placeholder='GENERAL.FIELD.LAST_NAME'] input")).sendKeys(lastName);

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector("button[class=\"mat-focus-indicator mat-raised-button mat-button-base mat-accent\"]")))
                .click();
//        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
//            @Override
//            public Boolean apply(WebDriver driver) {
//                return jse.executeScript("return document.readyState").toString().equals("complete");
//            }
//        };
//        wait.until(jsLoad);
//
//        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
//            @Override
//            public Boolean apply(WebDriver driver) {
//                try {
//                    return ((Long)jse.executeScript("return jQuery.active") == 0);
//                }
//                catch (Exception e) {
//                    return true;
//                }
//            }
//        };
//
//        wait.until(jQueryLoad);
        waitFor(1000);

    }
}

//  Use a data provider to do the Tests 10-15






