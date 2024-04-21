package com.pageObjects;

import com.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MyCoursesPage extends BasePage {
    public WebDriverWait wait;

    public MyCoursesPage(WebDriver driver) {
        super(driver);
        // ldriver = rdriver;
        // PageFactory.initElements(ldriver, this);
    }

    //capture completed tab
    @FindBy(xpath = "(//p[@class='_78mc9p'])[6]")
    public WebElement completedTab;

    //capture header of completed tab
    @FindBy(xpath="//p[.='COMPLETED']")
    public List<WebElement> completedTotal;

    //capture status of course 1
    @FindBy(xpath = "//p[.='COMPLETED']")
    public WebElement statusCourse;

    //capture name of course 1
    @FindBy(xpath = "//p[contains(.,'Being a First-Time Manager')]")
    public WebElement nameCourse1;

    //capture duration of course 1
    @FindBy(xpath = "//p[contains(.,'20 mins')]")
    public WebElement durationCourse1;

    //capture completion date of course
    @FindBy(xpath = "//p[.='Completed: 2023-10-21']")
    public WebElement completionDateCourse1;

    //capture name of course
    @FindBy(xpath = "//p[contains(text(),'E-mail Etiquettes')]")
    public WebElement nameCourse2;

    //capture duration of course
    @FindBy(xpath = "//p[contains(.,'10 mins')]")
    public WebElement durationCourse2;

    //capture completion date of course
    @FindBy(xpath = "//p[contains(.,'Completed: 2023-10-23')]")
    public WebElement completionDateCourse2;

    //=======================action methods===================//

    //open completed courses page
    public int getCompletedTotal(){
        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfAllElements(completedTotal));
        int count=completedTotal.size();
        System.out.println("total of completed courses = " + completedTotal.size());
        return count;}


    public int getCompletedTab(){
       waitVisibility(completedTab);
        int total = Integer.parseInt(completedTab.getText());
        System.out.println("total courses in completed Tab of dashboard = " + total);
        return total;
    }


    //get status of course
    public String getStatus() {
       waitVisibility(statusCourse);
        System.out.println("status of first course is " + statusCourse.getText());
        return statusCourse.getText();
    }

    //get name of course
    public String getName() {
        waitVisibility(nameCourse1);
        System.out.println("name of first course is " + nameCourse1.getText());
        return nameCourse1.getText();
    }

    //get duration of course
    public String getDuration() {
        waitVisibility(durationCourse1);
        System.out.println("duration of first course is " + durationCourse1.getText());
        return durationCourse1.getText();
    }

    //get completion date of course
    public String getDate() {
       waitVisibility(completionDateCourse1);
        System.out.println("date  first course  " + completionDateCourse1.getText());
        return completionDateCourse1.getText();
    }

    //get status of course
    public String getStatus2() {
        waitVisibility(statusCourse);
        System.out.println("status of second course is " + statusCourse.getText());
        return statusCourse.getText();
    }

    //get name of course
    public String getName2() {
        waitVisibility(nameCourse2);
        System.out.println("name of second course is " + nameCourse2.getText());
        return nameCourse2.getText();
    }

    //get duration of course
    public String getDuration2() {
        waitVisibility(durationCourse2);
        System.out.println("duration of second course is " + durationCourse2.getText());
        return durationCourse2.getText();
    }

    //get completion date of course
    public String getDate2() {
        waitVisibility(completionDateCourse2);
        System.out.println("date second course  " + completionDateCourse2.getText());
        return completionDateCourse2.getText();}

    //==================================Wait Methods====================================//

    public void waitVisibility(WebElement element)
    {
        wait = new WebDriverWait(driver, 25);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void waitClickability(WebElement webElement)
    {
        wait = new WebDriverWait(driver, 25);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

}
