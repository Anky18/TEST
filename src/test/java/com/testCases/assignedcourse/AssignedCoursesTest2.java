package com.testCases.assignedcourse;

import com.base.BaseClass;
import com.pageObjects.AssignedCoursesPage;
import com.pageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeoutException;

public class AssignedCoursesTest2 extends BaseClass {

    SoftAssert softAssert = new SoftAssert();
    AssignedCoursesPage learnerAssigned;
    boolean result;

    @BeforeClass
    public void verifyAssignedPage2() throws TimeoutException {

        LoginPage logPage = new LoginPage(driver);
        logPage.sincxLogin(domainname, username1, password);
        learnerAssigned = new AssignedCoursesPage(driver);
    }

    @Test
    //verify course opens on clicking view course
    public void tc001_verifyCourseOpen() {
        learnerAssigned.getAssignedPage();
        result = learnerAssigned.checkCourseOpen();
        Assert.assertTrue(result);
    }

    @Test
    //verify Start Course button is enabled
    public void tc002_verifyCourseStart() {
        result = learnerAssigned.checkCourseStart();
        Assert.assertTrue(result);
    }

    @Test
    //verify Description is displayed
    public void tc003_verifyDescriptionDisplayed() {
        result=learnerAssigned.checkDescription();
        Assert.assertTrue(result);}

    @Test
    //verify FAQ section  is displayed
    public void tc004_verifyFAQDisplayed(){
        result=learnerAssigned.checkFAQ();
        Assert.assertTrue(result);}

    @Test
    //verify Resources are displayed
    public void tc005_verifyResourcesDisplayed(){
        result=learnerAssigned.checkResources();
        Assert.assertTrue(result);}

    @Test
    //verify Resources are displayed
    public void tc006_verifyCourseContentDisplayed(){
        result=learnerAssigned.checkCourseContent();
        Assert.assertTrue(result);}

    @Test
    //verify Resources are displayed
    public void tc007_verifyContentLocked(){
        result=learnerAssigned.checkContentLocked();
        Assert.assertTrue(result);}


}



