import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class Base {

    public static WebDriver driver;
    public static WebDriverWait wait;
    public LoginClass loginClass;
    public CreateEmployee createEmployee;
    public  DeleteEmployee deleteEmployee;
    public SearchForAnEmployee searchForAnEmployee;
    public String gotItButton = "#cookieconsent div div a";

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
    }

//    @AfterSuite
//    public void tearDown() throws InterruptedException {
//        if(driver != null){
//            driver.quit();
//        }
//    }

}
