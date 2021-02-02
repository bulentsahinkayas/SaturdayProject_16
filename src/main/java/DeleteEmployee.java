import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DeleteEmployee {
    WebDriver driver;
    WebDriverWait wait;

    public DeleteEmployee(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }


    /*
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ms-delete-button[class='ng-star-inserted'] button svg"))).click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(""))).click();
         */
    public static By enterDeleteButton = By.cssSelector("button[color='warn'] span fa-icon svg");
    public static By enterYesForDelete = By.cssSelector("div[class='mat-dialog-actionbar'] div span");
    public void delete(){

        WebElement deleteEmployeeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(enterDeleteButton));
        deleteEmployeeButton.click();
        WebElement enterYesForDeleteButton = wait.until(ExpectedConditions.visibilityOfElementLocated(enterYesForDelete));
        enterYesForDeleteButton.click();
    }
}
