package com.pageObjects;



import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import com.base.BasePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class LearnerExplorePage extends BasePage {

    public WebDriverWait wait; boolean res=false;

    public LearnerExplorePage(WebDriver driver) {
        super(driver);
        // ldriver = rdriver;
        // PageFactory.initElements(ldriver, this);
    }

    //capture Explore tab
    @FindBy(xpath = "(//ul)/div[2] [contains(.,'Explore')]")
    public WebElement tabExplore;

    // capture the header of Explore page
    @FindBy(xpath = "//div/h1")
    public WebElement header;

    //capture knowledge sets
    @FindBy(xpath="(//div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-2'])[1]/div")
    public List<WebElement> ksets;

    //capture the knoeledge sets section
    @FindBy(xpath = "//div[@class='_uc16xo']")
    public WebElement frameKSet;

    //capture header of the knowledge set
    @FindBy(xpath = "//h1[@class='_1itr65sf']")
    public WebElement headerKSet;

    //capture title of course under knowledge sets
    @FindBy(css = "._1fe5yjd")
    public WebElement kSetCourseTitle;

    // capture view course button
    @FindBy(xpath = "//div[.='Automation testing - for due date']")
    public WebElement viewCourse;

    @FindBy(xpath = "//p[@class='_rhr8qd6']")
    public WebElement viewMore;

    @FindBy(xpath = "//div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-2']/div")
    public List<WebElement> coursesTotal;

    @FindBy(xpath = "//div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-2']")
    public WebElement frameCourses;


    // capture search text field
    @FindBy(xpath = "//input[@placeholder='Search courses']")
    public WebElement tBoxSearch;

    // capture search button
    @FindBy(xpath = "//img[@alt='Search image alt']")
    public WebElement btnSearch;

    //capture valid search result
    @FindBy(xpath = "//p[@class='_181rl92']")
    public WebElement resultSearch;

    //capture invalid search result
    @FindBy(css="._fal0ns")
    public WebElement messageSearch;

    //capture list of all courses after search
    @FindBy(xpath = "//div[@class='_41hxjm']/div[2]")
    public List<WebElement> resultList;

    // capture favourites icon
    @FindBy(xpath = "//div[@class='_16599h']/img")
    public WebElement favourites;

    @FindBy(css="._k8siqs")
    public WebElement headerFav;

    // capture back button
    @FindBy(css = "._1tog7ov")
    public WebElement btnBack;

    // ==================Action methods===========================//

    // open Explore page
    public void openExplore()  {
        waitClickability(tabExplore);
        try {
            tabExplore.click();
        }catch (StaleElementReferenceException e){
            tabExplore.click();}
    }

    // get the header of the page
    public String getHeader()  {
        waitVisibility(header);
        try {
            header.getText();
        }catch (StaleElementReferenceException e){
            header.getText();}
        System.out.println("header of explore page is: " + header.getText());
        return header.getText();}

    //get total courses
    public boolean getAllCourses(){
        waitClickability(viewMore);
        viewMore.click();
        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfAllElements(coursesTotal));
        System.out.println("total courses in All Courses section = " + coursesTotal.size());
        if (frameCourses.isDisplayed()){
            System.out.println("all courses are displayed on the Explore page");}
        return frameCourses.isDisplayed();}

    //get  total knowledge sets
    public boolean getTotalKSets()  {
        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfAllElements(ksets));
        System.out.println("total of knowledge sets = " + ksets.size());
        if (frameKSet.isDisplayed()){
            System.out.println("all knowledge sets are displayed on Explore page");}
        return frameKSet.isDisplayed();}

    //method to check accessibility of knowledge sets
    public boolean checkAccess(){
        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfAllElements(ksets));
        for(WebElement kSet:ksets){
            kSet.getText();
            if (kSet.getText().equalsIgnoreCase("Software testing")){
                kSet.click();
                wait = new WebDriverWait(driver, 20);
                wait.until(ExpectedConditions.visibilityOfAllElements(headerKSet));

                if (headerKSet.isDisplayed()){
                    System.out.println("knowledge set " + headerKSet.getText() + " is accessible");}
                break;}}
        btnBack.click();
        return header.isDisplayed();}

    //method to check courses under knowledge sets are accessible
    public boolean checkCourseAccess(){
        wait = new WebDriverWait(driver, 25);
        wait.until(ExpectedConditions.visibilityOfAllElements(ksets));
        for(WebElement kSet:ksets) {
            if (kSet.getText().equalsIgnoreCase("Software testing")) {
                kSet.click();
                waitClickability(viewCourse);
                viewCourse.click();
                waitVisibility(kSetCourseTitle);
                if (kSetCourseTitle.isDisplayed()){
                System.out.println("course under the knowledge sets is accessible");
                System.out.println("title of the course is " + kSetCourseTitle.getText());
                break;}}}
                return kSetCourseTitle.isDisplayed();}



    // navigate to favourites
    public boolean goToFavourites()  {
        btnBack.click();
        waitClickability(favourites);
        favourites.click();
        System.out.println("header of the favourites page is " + headerFav.getText());
        return headerFav.isDisplayed();}


    // search for an open course (valid search)
    public boolean  checkSearch()  {
        waitVisibility(tBoxSearch);
        tBoxSearch.sendKeys("E-mail Etiquettes");
        btnSearch.click();
        // waitVisibility(resultSearch);
        for (WebElement course:resultList){
            System.out.println(course.getText());}
    return tBoxSearch.isDisplayed();}
       // System.out.println("result of the search is --- " + resultSearch.getText());
       // return  resultSearch.isDisplayed();}

    // search for an open course (invalid search)
    public boolean  checkInvSearch()  {
        btnBack.click();
        waitVisibility(tBoxSearch);
        tBoxSearch.sendKeys("cyber security1");
        btnSearch.click();
        waitVisibility(messageSearch);
        System.out.println("result of the invalid search is --- " + messageSearch.getText());
        return  messageSearch.isDisplayed();}

    //======================================================================================//

    //search for Draft/open course
    public boolean checkDraftSearch()  {
        waitVisibility(tBoxSearch);
        tBoxSearch.sendKeys("test123");
        btnSearch.click();
        waitVisibility(resultSearch);
        if  (resultSearch.getText().equalsIgnoreCase("test123")){
            System.out.println("searchfor Draft course success: " + resultSearch.getText() + " is displayed");
            res=true;}
        return res;}

    //search for Restricted course
    public boolean checkRestrictedSearch() throws InterruptedException {
        waitVisibility(tBoxSearch);
        tBoxSearch.sendKeys("Automation testing");
        btnSearch.click();
        wait = new WebDriverWait(driver, 25);
        wait.until(ExpectedConditions.visibilityOfAllElements(resultList));
        for (WebElement course : resultList) {
            String name=course.getText();
             if(name.equalsIgnoreCase("Automation testing")) {
                 res = false;
                 System.out.println("Search failed: Restricted course is displayed");
                 break;
             }else {res=true;}
             System.out.println("Search success: Restricted course is not displayed");
             break;}
        return res;}


    //===============================Wait methods======================================//

    //wait for visibility of WebElement
    public void waitVisibility(WebElement element) {
        wait = new WebDriverWait(driver, 25);
        wait.until(ExpectedConditions.visibilityOf(element));}

    //wait for WebElement to be clickable
    public void waitClickability(WebElement webElement) {
        wait = new WebDriverWait(driver, 25);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));}

}


