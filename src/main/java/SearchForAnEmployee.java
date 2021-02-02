import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchForAnEmployee {


    WebDriver driver;
    WebDriverWait wait;

    public SearchForAnEmployee(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }
    public SearchForAnEmployee() {

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

    public By humanResMenu = By.xpath("//span[contains(text(), 'Human Resources')]");
    public By employeeMenu = By.xpath("//*[@id=\"container-1\"]/fuse-sidebar/navbar/navbar-vertical-style-1/div[2]/div[1]/div/div/fuse-navigation/div/" +
            "fuse-nav-vertical-group/div/fuse-nav-vertical-collapsable[5]/div/fuse-nav-vertical-item[1]/a/span");
    public static By searchEmployeeName = By.cssSelector("ms-text-field[placeholder='GENERAL.FIELD.FIRST_NAME'] input");
    public static By searchEmployeeLastname = By.cssSelector("ms-text-field[placeholder='GENERAL.FIELD.LAST_NAME'] input");
    public static By searchButton = By.cssSelector("button[class=\"mat-focus-indicator mat-raised-button mat-button-base mat-accent\"]");




    public void searchEmployee(String firstName, String lastName){
        wait.until(ExpectedConditions.visibilityOfElementLocated(humanResMenu)).click();
        WebElement clickEmployees = wait.until(ExpectedConditions.visibilityOfElementLocated(employeeMenu));
        clickEmployees.click();

        WebElement enterNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(searchEmployeeName));
        enterNameInput.sendKeys(firstName);
        WebElement enterLastname = wait.until(ExpectedConditions.visibilityOfElementLocated(searchEmployeeLastname));
        enterLastname.sendKeys(lastName);
        WebElement enterSearchButton = wait.until(ExpectedConditions.visibilityOfElementLocated(searchButton));
        enterSearchButton.click();
    }
}
