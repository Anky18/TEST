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

public class DuesoonPage extends BasePage {
    public WebDriverWait wait;
    public JavascriptExecutor js;
    public Actions action;


    // Constructor

    public DuesoonPage(WebDriver driver) {
        super(driver);
    }

    // Capture Duesoon tab
    @FindBy(xpath = "//p[text()='Due Soon'][@class='_1rvopwa']")
    public WebElement dueSoon;

    // Cature No.of due soon Course on Dashboad
    @FindBy(xpath = "//p[@class='_78mc9p']")
    public List<WebElement> noOfCourse;

    // Capture no.of course displayed inside the Duesoon course
    //div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-sm-6 MuiGrid-grid-md-4 MuiGrid-grid-lg-3']
    @FindBy(xpath = "//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-sm-6 MuiGrid-grid-md-4 MuiGrid-grid-lg-3']")
    public List<WebElement> dueSoonContainer;

    //capture left arrow
    @FindBy(xpath = "//img[@alt='Arrow left icon alt']")
    public WebElement backArrow;

    // Capture Dashboard button
    @FindBy(xpath = "//p[text()='Dashboard']")
    public WebElement dashButton;

    // Capture Welcome message
    @FindBy(xpath = "//h1[@class='_k8siqs']")
    public WebElement welCome;

    // getting text in the due soon page
    @FindBy(xpath = "//h1[@class='_1itr65sf']")
    public WebElement dueSoonTitle;


    //capture no items message
    @FindBy(xpath ="//p[@class='_fal0ns']")
     public WebElement noItemMessage;


    /* -----------------------------Action methods-------------------------------------------------*/
//   click duesoon tab
    public void dueSoonTabClick() throws TimeoutException {
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(dueSoon));
        dueSoon.click();
    }

    //click back arrow on duesoon page

    public void backArrowClick() throws TimeoutException {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(backArrow));
        backArrow.click();
        System.out.println("Back arrow clicked");
    }
    // Number of due soon courses displayed on dashboard

    public String numOfCoursesOnDash() throws TimeoutException
    {
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfAllElements(noOfCourse));
        String numOfCourse=noOfCourse.get(3).getText();
        return numOfCourse;
    }

    // Number of Courses displayed inside due soon page
    public int numOfCoursesOnDueSoon() throws TimeoutException
    {
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfAllElements(dueSoonContainer));
        int numOfDueSoonCourse=dueSoonContainer.size();
        return numOfDueSoonCourse;
    }

    /*-------------------------- Validation---------------*/

    public boolean checkDueSoonTitle() throws TimeoutException
    {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(dueSoonTitle));
        return dueSoonTitle.isDisplayed();
    }

    public boolean checkDashBoardPage() throws TimeoutException
    {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(welCome));
        return welCome.isDisplayed();
    }

    public boolean checkNoItemMessage() throws TimeoutException {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(noItemMessage));
        return noItemMessage.isDisplayed();
    }


}