package com.pageObjects;

import com.base.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CompletedCoursePage extends BasePage {
    public WebDriverWait wait;
    public JavascriptExecutor js;
    public Actions action;
    //default Constructor

    public CompletedCoursePage(WebDriver driver) {
        super(driver);
    }

    // Completed Header on Dashboard.
    @FindBy(xpath = "//p[text()='Completed']")
    public WebElement CompletedTab;

    // To get the Completed Course from Completed Course page
    @FindBy(xpath = "//p[text()='COMPLETED']")
    public List<WebElement> totalCompletedCourse;

    @FindBy(xpath = "//h1[text()='Completed']")
    public WebElement CompletedHeader;
    //xpath of the label displaying the  no of courses completed.
    @FindBy(xpath = "(//p[@class='_78mc9p'])[6]")
    public WebElement labelCompleted;
    //xpath of the element Back Button.
    @FindBy(xpath = "//p[text()='Back']")
    WebElement BackButton;

    // Capture Welcome message
    @FindBy(xpath = "//h1[@class='_k8siqs']")
    public WebElement welCome;
//-----------------Writing Actions for Each Elements/Locators-------------//


    // To Click on Completed Tab

    public void ClickCompletedTab() throws TimeoutException {
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(CompletedTab));
        System.out.println("---Completed Tab was Clicked---");
        CompletedTab.click();
    }

    // To Verify the Header is Displayed as "Completed"
    //returntype Boolean
    public Boolean CompletedHeader() throws TimeoutException {
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(CompletedHeader));
        System.out.println("Header Completed on Completed Course Page is displayed.");
        return CompletedHeader.isDisplayed();
    }

    // Click on Back Button
    public void ClickBack() throws TimeoutException {
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(BackButton));
        System.out.println("A Click 0n Back Button was made.");
        BackButton.click();
    }

    public int GetCoursePageCompletedCourseCount() throws TimeoutException {
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfAllElements(totalCompletedCourse));
        int count = totalCompletedCourse.size();
        System.out.println("Number of Course Completed count from completed course page is :" + count);
        return count;
    }

    // verifying the Label count displayed on the Completed tab.
    // initializing "count" of datatype "int"
    // using Parseint to convert String to integer.
    // return type int
    public int GetDashboardCompletedCourseCount() throws TimeoutException {
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(labelCompleted));
        int count = Integer.parseInt(labelCompleted.getText());
        System.out.println("Number of Course Completed count from Dashboard :" + count);
        return count;

    }

    public boolean checkDashBoardPage() throws TimeoutException {
        waitVisibility(welCome);
        return welCome.getText().contains("Welcome,");
    }


}





















