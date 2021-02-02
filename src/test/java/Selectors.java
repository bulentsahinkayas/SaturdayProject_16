import org.openqa.selenium.By;

public class Selectors {



    public static By searchEmployeeName = By.cssSelector("ms-text-field[placeholder='GENERAL.FIELD.FIRST_NAME'] input");
    public static By searchEmployeeLastname = By.cssSelector("ms-text-field[placeholder='GENERAL.FIELD.LAST_NAME'] input");
    public static By searchButton = By.cssSelector("button[class=\"mat-focus-indicator mat-raised-button mat-button-base mat-accent\"]");
    public static By trashIcon = By.cssSelector("button[class ='mat-focus-indicator mat-tooltip-trigger mat-button mat-icon-button mat-button-base mat-warn ng-star-inserted']  svg");

    public static By enterEditButton = By.cssSelector("ms-edit-button[class='ng-star-inserted'] svg");


    public static By departmentRows = By.xpath(" ");
    //


    public static By confirmYes = By.cssSelector("button[type='submit']");
    public static By alert = By.cssSelector("div[role='alertdialog']");
}
