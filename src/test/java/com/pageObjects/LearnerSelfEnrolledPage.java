package com.pageObjects;

import com.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.List;

public class LearnerSelfEnrolledPage extends BasePage {

    public WebDriverWait wait;

    public LearnerSelfEnrolledPage(WebDriver driver)
    {

        super(driver);
    }

    // Clicking on the Self-enrolled tab
    @FindBy(xpath="//p[@class='_1rvopwa'][text()='Self-enrolled']")
    public WebElement selfEnroll;

    //getting text in self enroll page
    @FindBy(xpath="//h1[@class='_1itr65sf']")
    public WebElement selfEnrollHeader;

    //Clicking on the back icon
    @FindBy(xpath="//p[@class='_1tog7ov']")
    public WebElement clickBackIcon;

    // After clicking back it lands on the dashboard page and validates the name
    @FindBy(xpath = "//h1[@class='_k8siqs']")
    public WebElement checkHomePageName;

    // getting the number of courses in the self enrolled tab
    @FindBy(xpath = "//p[@class='_1h5yqey']")
    public List<WebElement>  coursesCount;


    // Getting the list of Courses Status in the self-assigned page
    @FindBy(xpath = "//p[@class='_1h5yqey']")
    public List<WebElement>  coursesStatus;

    // Getting the list of course name in the self-assigned page
    @FindBy(xpath = "//p[@class='_181rl92']")
    public List<WebElement>  coursesTitle;

    //Getting the due dates of the courses in the self-assigned page
    @FindBy(xpath = "//p[@class='_bideft'][text()=': ']")
    public List<WebElement>  courseDueDate;


    public void clickSelfEnroll(){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(selfEnroll));
        selfEnroll.click();
    }

    public String getHeaderSelfEnrol(){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(selfEnrollHeader));
        String selfHeader = selfEnrollHeader.getText();
        System.out.println("The header of the page is:" + selfHeader);
        return selfHeader;
    }

    public int countNoOfCourses() throws InterruptedException {
        wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfAllElements(coursesCount));
        return coursesCount.size();

    }

    public void getCourseNameStatusDate() {

        for (int i=0;i<coursesCount.size(); i++){

            String getStatus = coursesStatus.get(i).getText();
            String getCourseName = coursesTitle.get(i).getText();
            String getDueDate = courseDueDate.get(i).getText();
            System.out.println("Name of course"+ (i+1) +":"+ getCourseName);
            System.out.println("Status of course"+ (i+1) +":"+ getStatus);
            System.out.println("Date of the course"+ (i+1) +":"+ getDueDate);

        }

    }
    public void clickBack(){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(clickBackIcon));
        clickBackIcon.click();
    }

    public String getHomePageName(){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(checkHomePageName));
        String homePageName = checkHomePageName.getText();
        System.out.println("After clicking back, the name of the home page is : " +homePageName);
        return homePageName;
    }

    public void clickSelfEnrollPage() throws InterruptedException {

        clickSelfEnroll();
        String currentPageUrl = driver.getCurrentUrl();
        System.out.println("The current URL of the self-enrolled page is :" + currentPageUrl);

    }

    public void checkCoursesCount() throws InterruptedException {
        int count = countNoOfCourses();
        System.out.println("The number of courses in the self-enrolled page is: " + count);
    }


}
