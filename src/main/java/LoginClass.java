import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.rmi.runtime.Log;

public class LoginClass{

    WebDriver driver;
    WebDriverWait wait;

    public LoginClass(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    //Selectors - Page Objects
    public static By username = By.cssSelector("input[formcontrolname='username']");
    public static By password = By.cssSelector("input[formcontrolname='password']");
    public static By loginButton = By.cssSelector("form > button > span.mat-button-wrapper");

    //Methods
    public void login(){
        driver.findElement(username).sendKeys("daulet2030@gmail.com");
        driver.findElement(password).sendKeys("TechnoStudy123@");
        driver.findElement(loginButton).click();
    }
}
