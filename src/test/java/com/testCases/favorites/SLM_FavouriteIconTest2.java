package com.testCases.favorites;

import com.base.BaseClass;

import com.pageObjects.FavoritesIcon;
import com.testCases.signIn.SLM_001loginApp;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeoutException;

public class SLM_FavouriteIconTest2 extends BaseClass {

    FavoritesIcon favouriteIcon;

    @BeforeClass
    public void FavouriteIConSetUp() throws TimeoutException {

        SLM_001loginApp loginPage = new SLM_001loginApp();
        loginPage.sincxloginTest();

        favouriteIcon = new FavoritesIcon(driver);

    }

    @Test  //Testcase1- Dashboard favourite icon
    public void tc001_VerifyDashboardFavourite() throws InterruptedException {

        boolean dashboardIconDisplay = favouriteIcon.favoriteIconDisplay();
        Assert.assertTrue(dashboardIconDisplay);
        System.out.println(" Is the favourite icon displayed in the Dashboard page?: " +dashboardIconDisplay);
        favouriteIcon.clickDashboardFavourite();
        String headerName = favouriteIcon.getHeaderFavourite();
        Assert.assertEquals(headerName,"Favourites");
        System.out.println("The no.of courses under favourites are: " +favouriteIcon.noOfCoursesFavorites());
        favouriteIcon.nameOfFavouriteCourse();
    }

    @Test
    public void tc002_VerifyExploreFavourite() throws InterruptedException {

        favouriteIcon.clickExploreTab();
        boolean exploreIconDisplay = favouriteIcon.favoriteIconDisplay();
        Assert.assertTrue(exploreIconDisplay);
        System.out.println(" Is the favourite icon displayed in the Explore page?: " +exploreIconDisplay);
        favouriteIcon.clickExploreFavourite();
        String headerName = favouriteIcon.getHeaderFavourite();
        Assert.assertEquals(headerName,"Favourites");
        System.out.println("The no.of courses under favourites are: " +favouriteIcon.noOfCoursesFavorites());
        favouriteIcon.nameOfFavouriteCourse();
    }

}
