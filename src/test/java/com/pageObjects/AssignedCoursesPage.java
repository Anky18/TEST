package com.pageObjects;

import com.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class AssignedCoursesPage extends BasePage {

    public WebDriverWait wait; boolean res;

    public AssignedCoursesPage(WebDriver driver) {
        super(driver);
        // ldriver = rdriver;
        // PageFactory.initElements(ldriver, this);
    }

    // capture Assigned Tab
    @FindBy(xpath = "//p[@class='_1rvopwa'] [.='Assigned']")
    public WebElement tabAssigned;

    // capture total courses on Assigned tab
    @FindBy(xpath = "(//p[@class='_78mc9p'])[1]")
    public WebElement totalAssignedTab;

    // capture total courses in Assigned page
    @FindBy(xpath = "//div[@class='_jro6t0'] //p[@class='_1h5yqey']")
    public List<WebElement> totalAssignedPage;

    // capture header of Assigned page
    @FindBy(xpath = "//h1[@class='_1itr65sf']")
    public WebElement headerPage;

    @FindBy(xpath = "//div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-2']")
    public WebElement assignedFrame;

    // capture the total of started courses
    @FindBy(xpath = "//p[.='STARTED']")
    public List<WebElement> coursesStartedTotal;

    // capture the total of courses started
    @FindBy(xpath = "//p[.='STARTED']/ancestor::div[@class='_41hxjm']/div")
    public List<WebElement> coursesStarted;

    // capture the total of Completed courses
    @FindBy(xpath = "//p[.='COMPLETED']")
    public List<WebElement> coursesCompletedTotal;

    //capture details of first completed course
    @FindBy(xpath = "//p[.='COMPLETED']/ancestor::div[@class='_41hxjm']/div")
    public List<WebElement> coursesCompleted;

    // capture the total of Assigned courses
    @FindBy(xpath = "//p[.='ASSIGNED']")
    public List<WebElement> coursesAssignedTotal;

    //capture details of first assigned course
    @FindBy(xpath = "//p[.='ASSIGNED']/ancestor::div[@class='_41hxjm']/div")
    public List<WebElement> coursesAssigned;

    //capture view course button
    @FindBy(xpath="//p[.='Being a First-Time Manager']")
    public WebElement viewCourse;

    //capture the header of the course page
    @FindBy(xpath="//h1[@class='_1fe5yjd']")
    public WebElement courseTitle;

    //capture start course button
    @FindBy(xpath="//p[.='Start course']")
    public WebElement courseStart;

    //capture Description tab
    @FindBy(xpath="//p[.='Description']")
    public WebElement tabDescription;

    //capture the description text
    @FindBy(xpath = "//p[@class='_1kn6xuj']")
    public WebElement textDescription;

    //capture FAQ tab
    @FindBy(xpath = "//p[.='FAQ']")
    public WebElement tabFAQ;

    //capture FAQ text
    @FindBy(xpath = "//div[@class='_1f8piof']")
    public WebElement textFAQ;

    //capture Resources tab
    @FindBy(xpath="//p[@class='_13q9s6t'] [.='Resources']")
    public WebElement tabResources;

    //capture  all Resources
    @FindBy(css = ".MuiGrid-root.MuiGrid-container.MuiGrid-spacing-xs-2")
    public WebElement allResources;

    //capture course content section
    @FindBy(xpath = "//p[.='Course content']")
    public WebElement courseContent;

    @FindBy(xpath = "//img[@src='/static/media/lock_icon.481b2fd9.svg']")
    public WebElement imgLock;

    //==================Action Methods===========================================//

    // get total courses in the Assigned Tab
    public int getTotalAssignedTab() {
       waitVisibility(totalAssignedTab);
        int total = Integer.parseInt(totalAssignedTab.getText());
        System.out.println("total courses in Assigned Tab of dashboard = " + total);
        return total;}

    // open Assigned courses page
    public void getAssignedPage() {
        waitClickability(tabAssigned);
        tabAssigned.click();}

    // get Total of Assigned page
    public int getTotalAssignedPage()  {
        wait = new WebDriverWait(driver, 25);
        wait.until(ExpectedConditions.visibilityOfAllElements(totalAssignedPage));
        System.out.println("total of Assigned Page is " + totalAssignedPage.size());
        return totalAssignedPage.size();}

    // get Header od Assigned Page
    public String getHeader() {
        waitVisibility(headerPage);
        System.out.println("title of the page is " + headerPage.getText());
        return headerPage.getText();}

    //get all courses in Assigned page
    public boolean getAssignedFrame() {
        waitVisibility(assignedFrame);
        System.out.println("All ccourses are displayed on Assigned page");
        return assignedFrame.isDisplayed();}

    // get Started Courses in Assigned Page
    public boolean getInfoStarted() {
        wait = new WebDriverWait(driver, 25);
        wait.until(ExpectedConditions.visibilityOfAllElements(coursesStartedTotal));
        if (coursesStartedTotal.size() == 0) {
            waitClickability(tabAssigned);
            tabAssigned.click();
            System.out.println("No Started courses in Assigned page");
        } else {
            System.out.println("No.of Started courses is " + coursesStartedTotal.size());
            System.out.println("Started Courses details displayed below : ");}
        wait = new WebDriverWait(driver, 25);
        wait.until(ExpectedConditions.visibilityOfAllElements(coursesStarted));
        for (int i = 1; i < coursesStarted.size(); i++) {
            if (coursesStarted.get(i).isDisplayed()) {
                res = true;}
            System.out.println(coursesStarted.get(i).getText());}
        return res;}

    // get completed courses info
    public boolean getInfoCompleted() {

        wait = new WebDriverWait(driver, 25);
        wait.until(ExpectedConditions.visibilityOfAllElements(coursesCompletedTotal));
        if (coursesCompletedTotal.size() == 0) {
            System.out.println("No Completed courses in Assigned page");
        } else {
            System.out.println("No.of Completed courses is " + coursesCompletedTotal.size());
            System.out.println("Completed Courses details displayed below : ");}
        wait = new WebDriverWait(driver, 25);
        wait.until(ExpectedConditions.visibilityOfAllElements(coursesCompleted));
        for (int i = 1; i < coursesCompleted.size()-1; i++) {
            if (coursesCompleted.get(i).isDisplayed()) {
                res = true;}
            System.out.println(coursesCompleted.get(i).getText());}
        return res;}

    // get  Assigned Courses info Assigned
    public boolean getInfoAssigned() {

        wait = new WebDriverWait(driver, 25);
        wait.until(ExpectedConditions.visibilityOfAllElements(coursesAssignedTotal));
        if (coursesAssignedTotal.size() == 0) {
            System.out.println("No Assigned courses in Assigned page");
        } else {
            System.out.println("No.of Assigned courses is " + coursesAssignedTotal.size());
            System.out.println("Assigned Courses details displayed below : ");}
        wait = new WebDriverWait(driver, 25);
        wait.until(ExpectedConditions.visibilityOfAllElements(coursesAssigned));
        for (int i = 1; i < coursesAssigned.size(); i++) {
            if (coursesAssigned.get(i).isDisplayed()) {
                res = true;}
            System.out.println(coursesAssigned.get(i).getText());}
        return res;}

    //check course page opens on clicking on View Course
    public boolean checkCourseOpen(){
        waitVisibility(viewCourse);
        viewCourse.click();
        System.out.println("clicked on view course button of the course");
        waitVisibility(courseTitle);
        System.out.println("title of the course is " + courseTitle.getText());
        return courseTitle.isDisplayed();}

    //check Start Course button is enabled
    public boolean checkCourseStart(){
        waitVisibility(courseStart);
        System.out.println(courseStart.getText() + " button is enabled");
        return  courseStart.isEnabled();}

    //check Description Tab
    public boolean checkDescription(){
        waitClickability(tabDescription);
        tabDescription.click();
        System.out.println("clicked on Description tab of course");
        waitVisibility(textDescription);
        if (textDescription.isDisplayed()){
            res=true;
        System.out.println("Course Description is displayed");}
        else{ res=false;
        System.out.println("Course Description is not available");}
        return res;}

    //check FAQ tab
    public boolean checkFAQ() {
        waitClickability(tabFAQ);
        tabFAQ.click();
        System.out.println("clicked on FAQ tab of course");
        waitVisibility(textFAQ);
        if (textFAQ.isDisplayed()){
            res=true;
            System.out.println("FAQ section is displayed");}
        else{ res=false;
            System.out.println("FAQ section not available");}
        return res;}

    //check Resources tab
    public boolean checkResources(){
        waitClickability(tabResources);
        tabResources.click();
        System.out.println("clicked on Resources tab of course");
        waitVisibility(allResources);
        if (allResources.isDisplayed()){
            res=true;
            System.out.println("All Resources are  displayed");}
        else{ res=false;
            System.out.println("Resources are not  available");}
        return res;}

    //check course content
    public boolean checkCourseContent(){
        waitVisibility(courseContent);
        if (courseContent.isDisplayed()){
            res=true;
            System.out.println("Course content is displayed");}
        else{ res=false;
            System.out.println("Course content is unavailable");}
        return res;}

    public boolean checkContentLocked(){
        waitVisibility(imgLock);
        System.out.println(imgLock.isDisplayed());
        if (imgLock.isDisplayed()){
            res=true;
            System.out.println("Course content is locked");}
        else{ res=false;
            System.out.println("Course content is unlocked");}
        return res;}


    //===============================Wait methods======================================//

    //wait for visibility of webelement
    public void waitVisibility(WebElement element) {
        wait = new WebDriverWait(driver, 25);
        wait.until(ExpectedConditions.visibilityOf(element));}
    //wait for webelement to be clickable
    public void waitClickability(WebElement webElement) {
        wait = new WebDriverWait(driver, 25);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));}


    }













