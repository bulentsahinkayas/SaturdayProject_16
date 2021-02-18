import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class DeleteEmployee {
    WebDriver driver;
    protected WebDriverWait wait;


    public DeleteEmployee(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
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

    /*
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ms-delete-button[class='ng-star-inserted'] button svg"))).click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(""))).click();
         */
    public static By enterDeleteButton = By.xpath("//button[@color='warn']//*[name()='svg']");
    public static By enterYesForDelete = By.cssSelector("div[class='mat-dialog-actionbar'] div span");

    public void delete(){


//        waitFor(ExpectedConditions.visibilityOfElementLocated(enterDeleteButton),"Save botton is not clikeable");
        wait.until(ExpectedConditions.visibilityOfElementLocated(enterDeleteButton)).click();
//        enterDeleteButton.click();
        WebElement enterYesForDeleteButton = wait.until(ExpectedConditions.visibilityOfElementLocated(enterYesForDelete));
        enterYesForDeleteButton.click();
    }
}
