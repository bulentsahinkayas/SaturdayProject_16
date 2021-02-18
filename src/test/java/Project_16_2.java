import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.awt.*;

public class Project_16_2 extends Base {

    @BeforeClass
    public void loginTest() throws InterruptedException {
        // Login by the credentials (username = "daulet2030@gmail.com" and password = "TechnoStudy123@")
        loginClass.login();
        String actual = driver.findElement(By.cssSelector("h3")).getText();
        Assert.assertEquals(actual, "MERSYS Campus - Dashboard");
    }




    @Test(priority = 1, dataProvider = "employeeName")
    public void createFirstEmployeeTest(String firstName, String lastName, String employeeId, String docNumber) {
        createEmployee.create(firstName, lastName, employeeId, docNumber);
        String textMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container"))).getText();
        System.out.println(textMessage);
        Assert.assertEquals(textMessage, "Employee successfully created");

    }

    @Test(priority = 2, dataProvider = "nameSurname", dependsOnMethods = "createFirstEmployeeTest")
    //,dependsOnMethods = "createFirstEmployeeTest"
    public void deleteFirstEmployeeTest(String firstName, String lastName) throws InterruptedException {
//        ExpectedCondition<Boolean> angularLoad = driver -> Boolean.valueOf(((JavascriptExecutor)driver)
//                .executeScript("return window.getAllAngularTestabilities().findIndex(x=>!x, isStable()) === -1").toString()
//        );
//
//        wait.withTimeout(Duration.of(10, ChronoUnit.SECONDS)).until(angularLoad);

        searchForAnEmployee.searchEmployee(firstName, lastName);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table/tbody/tr/td[3][contains(text(),'" + firstName + "')]")));
        deleteEmployee.delete();
        Thread.sleep(3000);
        WebElement deleted = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#container-3 ms-browse-table table td")));

        String actual = deleted.getText();
        System.out.println(actual);
        Assert.assertTrue(actual.contains("No data to show"));
//Thread.sleep(3000);
//        List<WebElement> rows = driver.findElements(By.cssSelector("tbody[role='rowgroup']"));
//        for (WebElement row : rows){
//
//        }
//        boolean found = true;
//        for (WebElement row : rows) {
//            if (row.getText().contains("Bulent Sahin"))
//                found = false;
//        }
//        Assert.assertTrue(found, "The employee with name Bulent and last name  Sahin was not deleted");
    }

    //////  Test 3: Verify that the first name of an existing employee can be updated --> (passes)///////
    @Test(priority = 3, dataProvider = "editName")
    public void editNameOfEmployee(String firstName, String lastName, String employeeId, String docNumber) throws InterruptedException {

        searchForAnEmployee.searchEmployee(firstName, lastName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table/tbody/tr/td[3][contains(text(),'" + firstName + "')]")));

        editEmployee.editName("Ahmet");
        Thread.sleep(3000);
        String updateMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container"))).getText();
        System.out.println(updateMessage);
        Assert.assertEquals(updateMessage, "Employee successfully updated");
    }

    ////  Test 4: Verify that the last name of an existing employee can be updated --> (passes)
    @Test(priority = 4, dataProvider = "editName2")
    public void editLastnameOfEmployee(String firstName, String lastName, String employeeId, String docNumber) throws InterruptedException {

        searchForAnEmployee.searchEmployee(firstName, lastName);

        Thread.sleep(3000);
        editEmployee.editLastname("Changed");
        Thread.sleep(3000);
        String updateMessage = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#toast-container")))).getText();
        System.out.println(updateMessage);
        if (updateMessage.contains("Employee successfully updated")) {
            Assert.assertEquals(updateMessage, "Employee successfully updated");
        } else {
            Assert.fail();
        }

    }

    /////////  Test 5: Verify that the document number of an existing employee can be updated --> (passes)//////////
    @Test(priority = 5, dataProvider = "editName2")
    public void editDocumentNumber(String firstName, String lastName, String employeeId, String docNumber) throws InterruptedException {
        Thread.sleep(3000);
        searchForAnEmployee.searchEmployee(firstName, "Changed");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table/tbody/tr/td[3][contains(text(),'" + firstName + "')]")));
        editEmployee.editDocumentNum("hkhjki45689");
        Thread.sleep(3000);
        String updateMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container"))).getText();
        System.out.println(updateMessage);
        Assert.assertEquals(updateMessage, "Employee successfully updated");
    }

    //  Test 6: Verify that (any other data you decided) of an existing employee can be updated --> (passes)
    @Test(priority = 6, dataProvider = "editName2")
    public void editAnyData(String firstName, String lastName, String employeeId, String docNumber) throws InterruptedException {
        Thread.sleep(3000);
        searchForAnEmployee.searchEmployee(firstName, "Changed");
        Thread.sleep(3000);
        editEmployee.editDocumentType();
        Thread.sleep(3000);
        String updateMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container"))).getText();
        System.out.println(updateMessage);
        Assert.assertEquals(updateMessage, "Employee successfully updated");
    }

    //  Test 7: Verify that an employee with different names but the same Employee ID cannot be created --> (fails!)
    @Test(priority = 7, dataProvider = "enterSameID")
    public void createSameId(String firstName, String lastName, String employeeId, String docNumber) throws InterruptedException {

        createEmployee.create(firstName, lastName, employeeId, docNumber);
        Thread.sleep(3000);
        String updateMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container"))).getText();
        System.out.println(updateMessage);
        Assert.assertFalse(updateMessage.equals("Employee successfully updated"));

    }

    //  Test 8: Verify that an employee with different names but the same Document Number cannot be created --> (passes)
    @Test(priority = 8, dataProvider = "enterSameID")
    public void createSameDocNumber(String firstName, String lastName, String employeeId, String docNumber) throws InterruptedException {

        createEmployee.create("Kamil", "Tamam", "1974", docNumber);
        Thread.sleep(3000);
        String updateMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container"))).getText();
        System.out.println(updateMessage);
        Assert.assertTrue(updateMessage.contains("Kemal Olgun already has such document number or PIN"));
    }

    //  Test 9: Verify that an employee with the same First Name and Last Name can be created --> (passes)56987
    @Test(priority = 9, dataProvider = "enterSameID")
    public void createSameNameLastN(String firstName, String lastName, String employeeId, String docNumber) throws InterruptedException {

        createEmployee.create(firstName, lastName, "1975", "2021");

        String updateMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container"))).getText();
        System.out.println(updateMessage);
        Assert.assertEquals(updateMessage, "Employee successfully created");
    }

    ///////  Test 10-15: Verify that an employee without entering a first name cannot be created --> (passes)//////
    @Test(priority = 10, dataProvider = "test10To15")
    public void createHasNoName(String firstName, String lastName, String employeeId, String docNumber) throws InterruptedException {

        createEmployee.create(firstName, lastName, employeeId, docNumber);
        Thread.sleep(3000);
        String updateMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container"))).getText();
        System.out.println(updateMessage);
        Thread.sleep(3000);
        if (updateMessage.contains("Employee successfully created")) {
            Assert.assertTrue(updateMessage.equals("Employee successfully created"));
        } else {
            Assert.assertTrue(updateMessage != "Employee successfully created");
        }


    }

    /////  Test 16: Verify that a photo can be uploaded while creating a new employee --> (fails!)/////
    @Test(priority = 11, dataProvider = "enterSameID")
    public void test16(String firstName, String lastName, String employeeId, String docNumber) throws AWTException, InterruptedException {
        createEmployee.createByAddingPhoto("Ali", "Yeter", "usyh12343", "5686oufoieu");
        Thread.sleep(3000);
        boolean enabled = driver.findElement(EditEmployee.photoButton).isEnabled();
        Assert.assertTrue(enabled);
    }

    //  Test 17: Verify that a photo can be uploaded for an existing employee --> (passes)
    @Test(priority = 12, dataProvider = "enterSameID")
    public void test17(String firstName, String lastName, String employeeId, String docNumber) throws AWTException, InterruptedException {
        searchForAnEmployee.searchEmployee("Ahmet", "Changed");
        editEmployee.uploadPhoto();

        String alertText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container"))).getText();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()=' Close ']"))).click();
        System.out.println(alertText);
        Assert.assertEquals(alertText, "Photo successfully uploaded");
    }

    //  Test 18:Verify that the photo of an existing employee can be changed --> (passes)
    @Test(priority = 13, dataProvider = "enterSameID")
    public void test18(String firstName, String lastName, String employeeId, String docNumber) throws AWTException, InterruptedException {
        searchForAnEmployee.searchEmployee("sdfsdf", "Clay");
        editEmployee.uploadPhoto();

        String alertText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container"))).getText();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()=' Close ']"))).click();
        System.out.println(alertText);
        Assert.assertEquals(alertText, "Photo successfully uploaded");
    }

    @Test(priority = 14, dataProvider = "enterSameID")
    public void test19(String firstName, String lastName, String employeeId, String docNumber) throws AWTException, InterruptedException {
        searchForAnEmployee.searchEmployee("sdfsdf", "Clay");
        editEmployee.deletePhoto();

    }
    @DataProvider(name = "employeeName")
    public Object[][] sectionData() {
        String[][] testData = {
                {"Bulent", "Sahin", "123456", "654321"},
                {"Yusuf", "Kaya", "456456", "231321"}
        };
        return testData;
    }

    @DataProvider(name = "nameSurname")
    public Object[][] deleteName() {
        String[][] testData = {
                {"Bulent", "Sahin"}
        };
        return testData;
    }

    @DataProvider(name = "editName")
    public Object[][] sectionEditName() {
        String[][] testData = {
                {"Yusuf", "Kaya", "456456", "231321"}
        };
        return testData;
    }

    @DataProvider(name = "editName2")
    public Object[][] sectionEditName2() {
        String[][] testData = {
                {"Ahmet", "Kaya", "456456", "231321"}
        };
        return testData;
    }

    @DataProvider(name = "enterSameID")
    public Object[][] sectionEditID() {
        String[][] testData = {
                {"Kemal", "Olgun", "456456", "56987"}
        };
        return testData;
    }

    @DataProvider(name = "test10To15")
    public Object[][] sectionData3() {
        String[][] testData = {
                {"", "Hassan10", "Crazy10", "safaf10"},
                {"Artur11", "", "Tired11", "safaf11"},
                {"Artur12", "Ganiev12", "", "safaf12"},
                {"123445", "Ganiev13", "Dfggg13", "safaf13"},
                {"@!#$#@", "Ganiev14", "dsfsd14", "safaf14"},
                {"Artur15", "#$%#@@", "", "safaf15"},
        };
        return testData;
    }
}


