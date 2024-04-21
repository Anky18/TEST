package com.pageObjects;

import com.base.BasePage;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class LearnerDashboardPage extends BasePage {

    public WebDriverWait wait;

    public LearnerDashboardPage(WebDriver driver)
    {

        super(driver);
    }

    // dashboard links xpath

    // Clicking on the assigned tab
    @FindBy(xpath="//p[@class='_1rvopwa'][text()='Assigned']")
    public WebElement assignedMenu;

    // After clicking got the text
    @FindBy(xpath="//h1[@class='_1itr65sf']")
    public WebElement assignedTitle;


    // Clicking on the Self-enrolled tab
    @FindBy(xpath="//p[@class='_1rvopwa'][text()='Self-enrolled']")
    public WebElement selfEnrol;

    //getting text in self enroll page
    @FindBy(xpath="//h1[@class='_1itr65sf']")
    public WebElement selfEnrolTitle;


    // clicking on the Ongoing page
    @FindBy(xpath="//p[@class='_1rvopwa'][text()='Ongoing']")
    public WebElement onGoing;

    //getting text in OnGoing  page
    @FindBy(xpath="//h1[@class='_1itr65sf']")
    public WebElement onGoingTitle;

    // Clicking on the Due Soon Menu

    @FindBy(xpath="//p[@class='_1rvopwa'][text()='Due Soon']")
    public WebElement dueSoon;

    // getting text in the due soon page
    @FindBy(xpath="//h1[@class='_1itr65sf']")
    public WebElement dueSoonTitle;

    // Clicking on Over due Menu
    @FindBy(xpath="//p[@class='_1rvopwa'][text()='Overdue']")
    public WebElement overDue;

    // Getting the text on Over due page
    @FindBy(xpath="//h1[@class='_1itr65sf']")
    public WebElement overDueTitle;

    // Clicking on the completed menu
    @FindBy(xpath="//p[@class='_1rvopwa'][text()='Completed']")
    public WebElement completedMenu;

    // getting the text in the completed page
    @FindBy(xpath="//h1[@class='_1itr65sf']")
    public WebElement completedTitle;

    //Clicking on the back icon
    @FindBy(xpath="//p[@class='_1tog7ov']")
    public WebElement clickBackIcon;

    //To find the size of links
    @FindBy(xpath = "//p[@class='_1rvopwa']")
    public List<WebElement> noOfLinks;

    //Check the learner welcome name
    @FindBy(xpath = "//h1[@class='_k8siqs']")
    public WebElement checkHomePageName;


    // Method to check the learner name
    public String getHomePageName(){

        wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(checkHomePageName));
        String homePageName = checkHomePageName.getText();
        System.out.println("The name of the Learner displayed in home page is : " +homePageName);
        return homePageName;

    }

    //method to find the size
    public int countLinks() throws InterruptedException {
        wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfAllElements(noOfLinks));
      return noOfLinks.size();
    }

    // Method that gets webelement locators(dashboard menu) as arguments and click on it
    public void clickDashboardMenus(WebElement menuName){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(menuName));
        menuName.click();
    }

    // Method to click back icon on the dashboard menu (6) pages

    public void clickBackMenus(){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(clickBackIcon));
        clickBackIcon.click();
    }
    // Methods to get header of the dashboard menu pages
    public String getHeaderAssigned(){
        String assignedHeader = assignedTitle.getText();
        System.out.println("The header of the page is:" +assignedHeader);
        return assignedHeader;
    }

    public String getHeaderSelfEnrol(){
        String selfEnrollHeader = selfEnrolTitle.getText();
        System.out.println("The header of the page is:" +selfEnrollHeader);
        return selfEnrollHeader;
    }

    public String getHeaderOnGoing(){
        String onGoingHeader = onGoingTitle.getText();
        System.out.println("The header of the page is:" +onGoingHeader);
        return onGoingHeader;
    }

    public String getHeaderDueSoon(){
        String dueSoonHeader = dueSoonTitle.getText();
        System.out.println("The header of the page is:" +dueSoonHeader);
        return dueSoonHeader;
    }

    public String getHeaderOverDue(){
        String overDueHeader = overDueTitle.getText();
        System.out.println("The header of the page is:" +overDueHeader);
        return overDueHeader;
    }
    public String getHeaderCompleted(){
        String completedHeader = completedTitle.getText();
        System.out.println("The header of the page is:" +completedHeader);
        return completedHeader;
    }

    public void assignedTab(){

        clickDashboardMenus(assignedMenu);
    }
    public void selfEnrollTab(){

        clickDashboardMenus(selfEnrol);

    }

    public void onGoingTab(){

        clickDashboardMenus(onGoing);

    }
    public void dueSoonTab(){

        clickDashboardMenus(dueSoon);

    }

    public void overDueTab(){

        clickDashboardMenus(overDue);

    }

    public void completedTab(){

        clickDashboardMenus(completedMenu);

    }

}
