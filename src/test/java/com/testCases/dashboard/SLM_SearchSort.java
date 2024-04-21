package com.testCases.dashboard;

import com.base.BaseClass;
import com.pageObjects.LoginPage;
import com.pageObjects.SearchSortPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeoutException;

public class SLM_SearchSort extends BaseClass {

    String actual; boolean result;
    SearchSortPage myCoursesSearch;

    @BeforeClass
    public void verifySearchTest() throws TimeoutException{

        // Login page Instance and method
        LoginPage logPage = new LoginPage(driver);
        logPage.sincxLogin(domainname, username1, password);
        myCoursesSearch = new SearchSortPage(driver);}

    @Test
    // validate search functionality
    public void tc001_verifySearch()  {
        result = myCoursesSearch.checkSearch();
        Assert.assertTrue(result);}

    @Test
    // validate search with invalid input
    public void tc002_verifyInvalidSearch(){
        actual = myCoursesSearch.checkInvalidSearch();
        Assert.assertEquals(actual, "No items to show");}

    @Test
    // validate sort/filter functionality
    public void tc003_verifySortOption(){
        actual = myCoursesSearch.checkSortOption();
        Assert.assertEquals(actual, "Welcome, Automation!");}

    @Test
    // validate clear(x) option of sort/filter
    public void tc004_verifyClearOption(){
         actual = myCoursesSearch.checkClearSort();
         Assert.assertEquals(actual, "Sort by");}

    @Test
     // verify Reset option of sort/filter
    public void tc005_verifyResetOption() throws InterruptedException {
         actual = myCoursesSearch.checkReset();
         Assert.assertEquals(actual, "Sort by");}

    }