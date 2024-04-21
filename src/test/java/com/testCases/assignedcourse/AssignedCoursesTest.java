package com.testCases.assignedcourse;

import com.base.BaseClass;
import com.pageObjects.AssignedCoursesPage;
import com.pageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.concurrent.TimeoutException;

public class AssignedCoursesTest extends BaseClass {

    AssignedCoursesPage learnerAssigned;
    boolean result; String header;
    int assignedTabTotal; int assignedPageTotal;
    @BeforeClass
    public void verifyAssignedPage() throws TimeoutException {

        LoginPage logPage = new LoginPage(driver);
        logPage.sincxLogin(domainname, username1, password);
        learnerAssigned=new AssignedCoursesPage(driver);}

    @Test
    //validate total of Assigned Tab and Assigned page
    public void tc001_verifyAssignedTotals() {
         assignedTabTotal = learnerAssigned.getTotalAssignedTab();}

    @Test
    //verify Assigned Page total
    public void tc002_verifyAssigned()  {
        learnerAssigned.getAssignedPage();
        assignedPageTotal = learnerAssigned.getTotalAssignedPage();
        Assert.assertEquals(assignedTabTotal, assignedPageTotal);}

    @Test
    //validate header od Assigned Page
    public void tc003_verifyTitle()  {
        header = learnerAssigned.getHeader();
        Assert.assertEquals(header, "Assigned");}

    @Test
    //validate all courses are displayed on Assigned Page
    public void tc004_verifyAssignedFrame()  {
        result = learnerAssigned.getAssignedFrame();
        Assert.assertTrue(result);}

    @Test
    //validate courses Started
    public void tc005_verifyStarted() {
        result = learnerAssigned.getInfoStarted();
        Assert.assertTrue(result);}

    @Test
    //validate  Completed course2
    public void tc006_verifyCompleted() {
       result= learnerAssigned.getInfoCompleted();
        Assert.assertTrue(result);}

    @Test
    public void tc007_verifyAssigned(){
        result=learnerAssigned.getInfoAssigned();
        //result = learnerAssigned.assignedCourse1();
        Assert.assertTrue(result);}

    }








