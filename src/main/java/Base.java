import javafx.scene.input.DataFormat;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Base {

    public static WebDriver driver;
    protected WebDriverWait wait;
    public LoginClass loginClass;
    public CreateEmployee createEmployee;
    public  DeleteEmployee deleteEmployee;
    public SearchForAnEmployee searchForAnEmployee;
    public EditEmployee editEmployee;

    public DialogBox dialogBox;
    public String gotItButton = "#cookieconsent div div a";
    static int counter = 0;




    @BeforeSuite
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\BULENT\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://test.campus.techno.study/");
        wait = new WebDriverWait(driver,10);
        WebElement gotIt;
        gotIt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(gotItButton)));
        gotIt.click();
        driver.manage().window().maximize();
        loginClass = new LoginClass(driver, wait);
        createEmployee = new CreateEmployee(driver, wait);
        deleteEmployee = new DeleteEmployee(driver, wait);
        searchForAnEmployee = new SearchForAnEmployee(driver,wait);
        editEmployee = new EditEmployee(driver,wait);

    }
    @BeforeMethod
    public void waitTime(){
        wait = new WebDriverWait(driver,5);
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
//    @AfterMethod
//    public void  takeScreenshotIfTestFails(ITestResult result){
//        if(result.getStatus() == ITestResult.FAILURE){
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss-nn");
//            String time = LocalDateTime.now().format(formatter);
//
//            File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//            String folderPath = "C:\\Users\\BULENT\\IdeaProjects\\SaturdayProject_16\\src\\main\\resources\\Screenshots\\";
//            String fileName = result.getMethod() + time + ".png";
//            File destinationFile = new File(folderPath+fileName);
//
//            try {
//                FileUtils.copyFile(sourceFile,destinationFile);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }

    @AfterSuite
    public void tearDown() throws InterruptedException {
        if(driver != null){
            driver.quit();
        }
    }

}

