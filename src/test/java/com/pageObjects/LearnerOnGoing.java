package com.pageObjects;


import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.base.BasePage;

public class LearnerOnGoing extends BasePage {
    public WebDriverWait wait;
    public JavascriptExecutor js;

    public Actions action;
//	public WebDriver ldriver;


    public LearnerOnGoing(WebDriver driver) {
        super(driver);
    }

    //xpath of the label displaying the  no of courses completed.
    @FindBy(xpath = "(//p[@class='_78mc9p'])[3]")
    public WebElement labelOnGoingCount;

    // Click on label on Going
    @FindBy(xpath = "//p[text()='Ongoing']")
    public WebElement labelOnGoing;

    //After click and landing - get the OnGoing  header
    @FindBy(xpath = "//h1[text()='Ongoing']")
    public WebElement OnGoingHeader;

    @FindBy(xpath = "(//p[text()='STARTED'])")
    public List<WebElement> labelStarted;

    @FindBy(xpath = "(//div[@class='_nyhg16'])")
    public List<WebElement> progressBarCount;

    //click back
    @FindBy(xpath = "//p[text()='Back']")
    WebElement BackButton;

    // Capture Welcome message
    @FindBy(xpath = "//h1[@class='_k8siqs']")
    public WebElement welCome;


// Writing Actions
public int getDashboardOngoingCourseCount() throws TimeoutException {
    wait = new WebDriverWait(driver, 30);
    wait.until(ExpectedConditions.visibilityOf(labelOnGoingCount));
    int count = Integer.parseInt(labelOnGoingCount.getText());
    System.out.println("Number of Course Ongoing count from Dashboard: " + count);
    return count;

}

    public void ClickOngoingTab() throws TimeoutException {
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(labelOnGoing));
        System.out.println("Clicked on Ongoing Tab");
        labelOnGoing.click();
    }

    //To Verify the header After Landing on Ongoing Page
    public Boolean VerifyOngoingHeader() throws TimeoutException {
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(OnGoingHeader));
        System.out.println("Landed on Page: " + OnGoingHeader.getText());
        return OnGoingHeader.isDisplayed();
    }

    // Check number ongoing course count for Verification
    public Integer getNumberOfCourseOngoingFromCoursePage() throws TimeoutException {
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfAllElements(labelStarted));
        System.out.println("The number ongoing course count from Course page: " + labelStarted.size());
        return labelStarted.size();
    }

    public Integer getNumberOfProgressBarDisplayed() throws TimeoutException {
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfAllElements(progressBarCount));
        System.out.println("The number progress bar count: " + progressBarCount.size());
        return progressBarCount.size();
    }

    // click on Back button
    public void clickBack() throws TimeoutException {
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(BackButton));
        System.out.println("A Click 0n Back Button was made.");
        BackButton.click();
    }

    public boolean checkDashBoardPage() throws TimeoutException {
        waitVisibility(welCome);
        return welCome.getText().contains("Welcome,");
    }

}