package com.testCases.explorer;

import com.pageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.base.BaseClass;
import com.pageObjects.LearnerExplorePage;

import java.util.concurrent.TimeoutException;

public class LearnerExploreTest extends BaseClass {

    public String header;
    boolean result;
    LearnerExplorePage learnerExplore;

    @BeforeClass
    public void verifyExplorePage() throws TimeoutException {
        LoginPage logPage = new LoginPage(driver);
        logPage.sincxLogin(domainname, username1, password);
        learnerExplore = new LearnerExplorePage(driver);}

    @Test
    //validate header of Explore page
    public void tc001_verifyTitleExplore() {
        learnerExplore.openExplore();
        header = learnerExplore.getHeader();
        Assert.assertEquals(header, "Explore");}

    @Test
    //validate all courses are displayed
    public void tc002_verifyAllCourses() {
        result = learnerExplore.getAllCourses();
       Assert.assertTrue(result);}

    @Test
    //validate knowledge sets are displayed
    public void tc003_verifyKnowledgeSets()  {
        learnerExplore.openExplore();
        result = learnerExplore.getTotalKSets();
        Assert.assertTrue(result);}

    @Test
    //validate knowledge sets are accessible
    public void tc004_verifyKSetAccess() {
        result = learnerExplore.checkAccess();
        Assert.assertTrue(result);}

    @Test
    //validate course under knowledge sets is accessible
    public void tc005_verifyKSetCourseAccess() {
        result = learnerExplore.checkCourseAccess();
        Assert.assertTrue(result);}


    @Test
    // validating Search field
    public void tc006_verifySearch() {
        learnerExplore.openExplore();
        result = learnerExplore.checkSearch();
        Assert.assertTrue(result);}

    @Test
    // validating Invalid Search field
    public void tc007_verifyInvalidSearch() {
        result = learnerExplore.checkInvSearch();
        Assert.assertTrue(result);}

    @Test
    //validate favourites icon
    public void tc008_verifyDraftSearch() {
        learnerExplore.openExplore();
        result = learnerExplore.checkDraftSearch();
        Assert.assertTrue(result);}

    @Test
    //validate favourites icon
    public void tc009_verifyRestrictedSearch() throws InterruptedException {
        learnerExplore.openExplore();
        result = learnerExplore.checkRestrictedSearch();
        Assert.assertTrue(result);}

    @Test
    //validate favourites icon
    public void tc010_verifyFavourites() {
        result = learnerExplore.goToFavourites();
        Assert.assertTrue(result);}


}






