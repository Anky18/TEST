package com.pageObjects;

import com.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.concurrent.TimeoutException;

public class ResourcePage extends BasePage
{
    WebDriverWait wait;

    public ResourcePage(WebDriver driver) {
        super(driver);
    }

 /*------------------------- Resource page objects-----------*/
 // Capture Dashboard button
    @FindBy(xpath = "//p[text()='Dashboard']")
    public WebElement dashButton;

    @FindBy(xpath = "//p[text()='Being a First-Time Manager']")
    public WebElement courseName;

    @FindBy(xpath = "//p[text()='Automation testing for overdue course']")
    public WebElement courseName2;

    @FindBy(xpath = "//p[@class='_13q9s6t'][text()='Resources']")
    public WebElement rTab;

    @FindBy(xpath = "//img[@src='/static/media/heart.744423e6.svg'][@alt='Resources list image alt']")
    public WebElement favoriteIcon;

    @FindBy(xpath = "//img[@src='/static/media/heart.744423e6.svg']")
    public List<WebElement> favoriteIconList;


    //Capture Resource tab
    @FindBy(xpath = "//p[text()='Resources']")
    public WebElement resourceTab;

    //capture resource page title
    @FindBy(xpath = "//h1[text()='Resources']")
    public WebElement resourceTitle;

    @FindBy(xpath = "//input[@placeholder='Search resources']")
    public WebElement searchBox;

    @FindBy(xpath = "//img[@alt='Search image alt']")
    public WebElement searchIcon;

    //capture Resource name
    @FindBy(xpath = "//p[@class='_15jb4xr']")
    public List<WebElement> resourceName;

    //capture download icon
    @FindBy(xpath = "//img[@alt='Download image alt']")
     public List<WebElement> downloadIcon;

    // capture heart icon
    @FindBy(xpath ="//img[@src='/static/media/heart_selected_icon.45aa6005.svg']" )
    public List<WebElement> heartIcon;

    // capture Printer icon
    @FindBy(xpath ="//img[@src='/static/media/list_icon.32eac56e.svg']" )
    public WebElement printIcon;

    // Resource list title
    @FindBy(xpath = "//p[text()='Being a First-Time Manager']")
    public WebElement listTitle;

    // Favorites Icon
    @FindBy(xpath = "//img[@alt='Favourite image alt']")
    public WebElement favoritesImg;


    /*  -------------- Document page--------*/
    // capture download button
    @FindBy(xpath ="//p[@class='_1yanunz']" )
    public WebElement downloadButton;
    // Capture resource title
    @FindBy(xpath = "//span[text()='THE FIRST TIME MANAGER TOOLKIT']")
    public WebElement bookTitle;
   // Capture Maximize button
    @FindBy(xpath ="//div[@class='_3hmsj']" )
     public WebElement maximizeButton;
    // Capture Minimize button
    @FindBy(xpath = "//div[@class='_3hmsj']")
    public WebElement minimizeButton;
    // Capture Previous button
    @FindBy(xpath ="//img[@alt='Document arrow image alt'][@src='/static/media/arrow_left.7d7a7578.svg']")
    public WebElement previousButton;
    // Capture Next button
    @FindBy(xpath = "//img[@alt='Document arrow image alt'][@src='/static/media/arrow_right.d7213d7f.svg']")
    public WebElement nextButton;
    @FindBy(xpath = "//div[@class='_f24lbv'][@style='max-height: unset; min-height: unset;']")
    public WebElement frameSizeMax;
    @FindBy(xpath = "//div[@class='_f24lbv'][@style='max-height: 650px; min-height: 650px;']")
    public WebElement frameSizeMin;
    @FindBy(xpath = "//div[@class='react-pdf__Page']")
    public WebElement pdfDocument;
    // Capture Back arrow
    @FindBy(xpath = "//img[@alt='Arrow left icon alt']")
    public WebElement backArrow;

    /*---------------Favorite Page------------*/
    //Favorite page title
    @FindBy(xpath = "//h1[text()='Favourites']")
    public WebElement favoritesPageTitle;

    //List of favorite courses on favorite page
    @FindBy(xpath = "//div[@class='_tk7i7w']")
    public List<WebElement> favoriteCourseList;

    /*---------------------------Resource Action methods-----------*/
// resource tab click
    public void resourceTabClick() throws TimeoutException {
        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(resourceTab));
        resourceTab.click();
        System.out.println("Resource tab clicked:");
    }
// Sending input to Search box
    public void setTxtSearch(String courseName) throws TimeoutException
    {
        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(searchBox));
        searchBox.sendKeys(courseName);
    }
// Search icon click
    public void searchIconClick() throws TimeoutException {
    wait = new WebDriverWait(driver, 20);
    wait.until(ExpectedConditions.visibilityOf(searchIcon));
    searchIcon.click();
    System.out.println("Search Icon clicked:");
}
// resource name  click
    public void resourceNameClick() throws TimeoutException {
    wait = new WebDriverWait(driver, 20);
    wait.until(ExpectedConditions.visibilityOfAllElements(resourceName));
    resourceName.get(0).click();
        System.out.println("Resource name clicked");
}
// download icon click
    public void downloadIconClick() throws TimeoutException {
    wait = new WebDriverWait(driver, 30);
    wait.until(ExpectedConditions.visibilityOfAllElements(downloadIcon));
    for(int i=0;i<downloadIcon.size();i++)
    {
        if(resourceName.get(i).getText().contains("First")) {
            downloadIcon.get(i).click();
            System.out.println("download icon clicked:");
            break;
        }
    }
}
// heart icon click
    public void heartIconClick() throws TimeoutException {
    wait = new WebDriverWait(driver, 30);
    wait.until(ExpectedConditions.visibilityOfAllElements(heartIcon));
        for(int i=0;i<heartIcon.size();i++) {
            if (resourceName.get(i).getText().contains("Document")) {
                heartIcon.get(i).click();
                System.out.println("heart icon clicked:");
                break;
            }
        }
    driver.navigate().refresh();
}
    public void heartIconFinalClick() throws TimeoutException {
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfAllElements(heartIcon));
        for(int i=0;i<heartIcon.size();i++) {

                heartIcon.get(i).click();
                System.out.println("heart icon clicked:");


        }
    }
    // PrinterIcon click--------------  Resource Page
    public void printIconClick() throws TimeoutException {
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(printIcon));
        printIcon.click();
        System.out.println("PrintIcon/ List icon clicked:");
    }
    // Favorites img click on Resource page
    public void favoritesImgClick() throws TimeoutException {
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(favoritesImg));
        favoritesImg.click();
        System.out.println("Favorite img clicked:");
    }
    // course name2 click on dashboard
    public void courseName2Click() throws TimeoutException {
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(courseName2));
        courseName2.click();
        System.out.println("Course name2 clicked:");
    }


// download button click--------------  Document Page
    public void downloadButtonClick() throws TimeoutException {
    wait = new WebDriverWait(driver, 30);
    wait.until(ExpectedConditions.elementToBeClickable(downloadButton));
    downloadButton.click();
        System.out.println("download button clicked:");
}
// Dashboard button click--------------------Dashboard Page
    public void dashBoardClick() throws TimeoutException {
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(dashButton));
        dashButton.click();
        System.out.println("dashboard tab clicked:");
    }
    // course name click
    public void courseNameClick() throws TimeoutException {
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(courseName));
        courseName.click();
        System.out.println("Course name clicked:");
    }
    //  resource tab inside course Page click
    public void rTabClick() throws TimeoutException {
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(rTab));
        rTab.click();
        System.out.println("Resource tab inside course clicked:");
    }
    // FavoriteIcon click
    public void favoriteIconClick() throws TimeoutException {
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(favoriteIcon));
        favoriteIcon.click();
        System.out.println("Favorite icon inside course clicked:");
    }

    public void favoriteIconSetup() throws TimeoutException
    {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfAllElements(favoriteIconList));
        System.out.println("Favorite icon size: "+favoriteIconList.size());
        for(int i=0;i<favoriteIconList.size();i++)
        {

           favoriteIconList.get(i).click();

           System.out.println("Favorite icon inside course clicked:");
        }

    }
 /*---------------------- Action method on Document Page------------------*/
 //Click on the Back Arrow  on Certificate page
 public void backArrowClick() throws TimeoutException {
     wait = new WebDriverWait(driver, 10);
     wait.until(ExpectedConditions.elementToBeClickable(backArrow));
     backArrow.click();
     System.out.println("clicked back arrow");
 }
 public void minimizeClick() throws TimeoutException {
     wait = new WebDriverWait(driver, 30);
     wait.until(ExpectedConditions.elementToBeClickable(minimizeButton));
     minimizeButton.click();
     System.out.println("Minimize Button clicked:");
 }
  public void maximizeClick() throws TimeoutException {
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(maximizeButton));
        maximizeButton.click();
        System.out.println("Maximize Button clicked:");
    }
    public void previousClick() throws TimeoutException {
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(previousButton));
        previousButton.click();
        System.out.println("Previous Button clicked:");
    }
    public void nextClick() throws TimeoutException {
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(nextButton));
        nextButton.click();
        System.out.println("Next Button clicked:");
    }

/* -----------------------Validation on Resource------------------------------------*/
public boolean checkResourceTitle() throws TimeoutException
{
    wait = new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.visibilityOf(resourceTitle));
    return resourceTitle.isDisplayed();
}
    public void checkResourceNameList() throws TimeoutException
    {
        driver.navigate().refresh();
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfAllElements(resourceName));
        for(int i=0;i<resourceName.size();i++)
        {
            SoftAssert softAssert=new SoftAssert();
               softAssert.assertTrue(resourceName.get(i).isDisplayed());
               System.out.println(resourceName.get(i).getText());
        }

    }
    /* Validation on Document page*/
    public boolean checkDownloadButton() throws TimeoutException
    {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(downloadButton));
        return downloadButton.isDisplayed();
    }

    public boolean checkBookTitle() throws TimeoutException
    {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(bookTitle));
        return bookTitle.isDisplayed();
    }
    public boolean checkListTitle() throws TimeoutException {

        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(listTitle));
        return listTitle.isDisplayed();
    }
    /* -----------Validation for Favorites Page-----------*/
    public boolean checkFavoritePageTitle() throws TimeoutException
    {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(favoritesPageTitle));
        return favoritesPageTitle.isDisplayed();
    }
    public boolean checkFavoriteCourse() throws TimeoutException
    {
        driver.navigate().refresh();
         boolean status= false;
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfAllElements(favoriteCourseList));
        for(int i=0;i<favoriteCourseList.size();i++)
        {
            System.out.println(favoriteCourseList.get(i).getText());
            if(favoriteCourseList.get(i).getText().contains("Automation"))
            {
                 status= true;
                 System.out.println("Automation course displayed");
                 favoriteCourseList.get(i).click();
                 heartIconFinalClick();
                break;
            }

        }
       return status;
    }



}
