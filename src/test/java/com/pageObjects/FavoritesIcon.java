package com.pageObjects;

import com.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.List;

public class FavoritesIcon extends BasePage {
    public WebDriverWait wait;

    public FavoritesIcon (WebDriver driver)
    {

        super(driver);
    }

    // Favourites icon in the dashboard
    @FindBy(xpath = "//img[@src='/static/media/heart.744423e6.svg']")
    public WebElement dashboardFavouriteIcon;

    // Get the header of the Favourites page
    @FindBy(xpath = "//h1[@class='_k8siqs']")
    public WebElement headerFavourite;

    // get the no.of courses under favourites
    @FindBy(xpath = "//p[@class='_181rl92']")
    public List<WebElement> coursesFavorite;

    // Click on Explore tab
    @FindBy(xpath = "//p[@class='_1hx0zhz'][text()='Explore']")
    public WebElement exploreTab;

    //Favourites icon in Explore

    @FindBy(xpath = "//img[@src='/static/media/heart.744423e6.svg']")
    public WebElement exploreFavouriteIcon;

    // List of course under Favourites
    @FindBy(xpath = "//p[@class='_181rl92']")
    public List<WebElement> CourseNamesFavourite;

    // used this method to check display of favourite icon for both dashboard and explore since they both have same xpath
    public boolean favoriteIconDisplay(){
        wait = new WebDriverWait(driver,25);
        wait.until(ExpectedConditions.visibilityOf(dashboardFavouriteIcon));
        return dashboardFavouriteIcon.isDisplayed();
    }

    // This method is to click on favourite icon on the dashboard
    public void clickDashboardFavourite(){
        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(dashboardFavouriteIcon));
        dashboardFavouriteIcon.click();
    }

    public String getHeaderFavourite(){
        wait = new WebDriverWait(driver,25);
        wait.until(ExpectedConditions.visibilityOf(headerFavourite));
        String headerFavouritePage = headerFavourite.getText();
        System.out.println("The header of the page after clicking heart icon is: "+headerFavouritePage);
        return headerFavouritePage;
    }
    // Get the no.of courses under favourites
    public int noOfCoursesFavorites() throws InterruptedException {
        wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfAllElements(coursesFavorite));
        return coursesFavorite.size();
    }

    // Click on the explore tab
    public void clickExploreTab(){
        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(exploreTab));
        exploreTab.click();
    }

    // Click on the favourite icon in the explore page
    public void clickExploreFavourite(){
        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(exploreFavouriteIcon));
        exploreFavouriteIcon.click();
    }
    public void nameOfFavouriteCourse() {

        for (int i=0;i<coursesFavorite.size(); i++){

            String getCourseNames = CourseNamesFavourite.get(i).getText();
            System.out.println("Name of course "+ (i+1) +":" + getCourseNames);

        }
    }



   }
