package com.testCases.favorites;

import com.base.BaseClass;
import com.pageObjects.LoginPage;
import com.pageObjects.ResourcePage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.util.concurrent.TimeoutException;

public class SLM_favoritesTest extends BaseClass
{

    ResourcePage resourcePage;

    @BeforeClass
    public void favoritesBefore() throws TimeoutException {

        LoginPage logPage = new LoginPage(driver);
        logPage.sincxLogin(domainname, username1, password);

        resourcePage = new ResourcePage(driver);
        resourcePage.courseName2Click();     // course on dash board clicked

        resourcePage.favoriteIconSetup();  // clicked on the favorite icon inside course page.

        resourcePage.resourceTabClick();
        resourcePage.favoritesImgClick();
    }
    @Test
    public void tc001_verifyFavoriteTitle() throws TimeoutException
    {
        Assert.assertTrue(resourcePage.checkFavoritePageTitle(),"Tc001 Failed. Not landed on Favorite page");
        System.out.println("Landed on favorite Page: "+resourcePage.favoritesPageTitle.getText());

    }
    @Test
    public void tc002_verifyCourseName2() throws TimeoutException
    {
        Assert.assertTrue(resourcePage.checkFavoriteCourse(),"Tc002 Failed. Favorite course not displayed");

    }



}
