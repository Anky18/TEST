package com.pageObjects;

import com.base.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeoutException;

public class OverduePage  extends BasePage
{
    public WebDriverWait wait;
    public JavascriptExecutor js;
    public Actions action;


    // Constructor

    public OverduePage(WebDriver driver)
    {
        super(driver);
    }

    // Capture Overdue tab
    @FindBy(xpath="//p[@class='_1rvopwa'][text()='Overdue']")
    public WebElement overDue;

    // Cature No.of Over due Course on Dashboad
    @FindBy(xpath = "//p[@class='_78mc9p']")
    public List<WebElement> noOfCourse;

    // Capture no.of course displayed inside the Overdue course
    @FindBy(xpath = "//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-sm-6 MuiGrid-grid-md-4 MuiGrid-grid-lg-3']")
    public List<WebElement> overDueContainer;

    //capture left arrow
    @FindBy(xpath = "//img[@alt='Arrow left icon alt']")
    public WebElement backArrow;

    // Capture Welcome message
    @FindBy(xpath = "//h1[@class='_k8siqs']")
    public WebElement welCome;

    // getting text in the Over Due page
    @FindBy(xpath = "//h1[@class='_1itr65sf']")
    public WebElement overDueTitle;

    //capture no items message
    @FindBy(xpath ="//p[@class='_fal0ns']")
    public WebElement noItemMessage;

    /* -----------------------------Action methods-------------------------------------------------*/
//   click Overdue tab
    public void overDueTabClick() throws TimeoutException {
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(overDue));
        overDue.click();
        System.out.println("Over due tab clicked");
    }

    //click back arrow on Overdue page

    public void backArrowClick() throws TimeoutException {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(backArrow));
        backArrow.click();
        System.out.println("back arrow on Overdue page clicked");
    }
    // Number of Over due courses displayed on dashboard

    public String numOfCoursesOnDash() throws TimeoutException
    {
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfAllElements(noOfCourse));
        String numOfCourse=noOfCourse.get(4).getText();
        return numOfCourse;
    }

    // Number of Courses displayed inside due soon page
    public int numOfCoursesOnOverDue() throws TimeoutException
    {
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfAllElements(overDueContainer));
        int numOfOverdueCourse = overDueContainer.size();
        return numOfOverdueCourse;
    }

    /*-------------------------- Validation---------------*/

    public boolean checkOverDueTitle() throws TimeoutException
    {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(overDueTitle));
        return overDueTitle.isDisplayed();
    }

    public boolean checkDashBoardPage() throws TimeoutException
    {
      /*  wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(welCome));*/
        waitVisibility(welCome);
        return welCome.getText().contains("Welcome,");
    }

    public boolean checkNoItemMessage() throws TimeoutException {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(noItemMessage));
        return noItemMessage.isDisplayed();
    }

  /*  public void waitVisibility(WebElement webElement)
    {
        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }*/

}
