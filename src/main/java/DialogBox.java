import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DialogBox {
    WebDriver driver;
    protected WebDriverWait wait;
    public  <T> void waitFor(ExpectedCondition<T> condition) {
        waitFor(condition, condition.toString());
    }

    public  <T> void waitFor(ExpectedCondition<T> condition, String errorMessage) {
        try {
            wait.until(condition);
        } catch (TimeoutException e) {
            Assert.fail(errorMessage);
        }
    }

    public DialogBox(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }
    public static By getDialogBox  = By.cssSelector("div[role='alertdialog']");
    public  void getDTextDialog(){
        WebElement dialogBox = wait.until(ExpectedConditions.visibilityOfElementLocated(getDialogBox));
        dialogBox.getText();

    }
  /*
     public static By enterDeleteButton = By.xpath("//button[@color='warn']//*[name()='svg']");
    public static By enterYesForDelete = By.cssSelector("div[class='mat-dialog-actionbar'] div span");
    public void delete(){

        WebElement deleteEmployeeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(enterDeleteButton));
        deleteEmployeeButton.click();
        WebElement enterYesForDeleteButton = wait.until(ExpectedConditions.visibilityOfElementLocated(enterYesForDelete));
        enterYesForDeleteButton.click();
    }
   */


}
