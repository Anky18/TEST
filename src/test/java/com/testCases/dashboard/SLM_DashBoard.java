package com.testCases.dashboard;

import com.base.BaseClass;
import com.pageObjects.LearnerDashboardPage;
import com.testCases.signIn.SLM_001loginApp;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeoutException;

public  class SLM_DashBoard extends BaseClass {

    LearnerDashboardPage dashboardPage;
    @BeforeClass
    public void beforeDash() throws TimeoutException, InterruptedException {

        // Login page Instance and method
        SLM_001loginApp loginPage = new SLM_001loginApp();
        loginPage.sincxloginTest();

        // Dashboard Instance
        dashboardPage = new LearnerDashboardPage(driver);

    }

    @Test
    public void tc001_VerifyLearnerName(){

       String learnerName= dashboardPage.getHomePageName();
       Assert.assertEquals(learnerName,"Welcome, Automation!");
    }

    @Test
    public void tc002_VerifyDashboardTabs() throws InterruptedException {

        // getting the no.of links(menus) in the dashboard
        System.out.println("The number of tabs in Dashboard page is: " + dashboardPage.countLinks());

    }
    @Test

    public void tc003_VerifyAssigned()  {

        dashboardPage.assignedTab();
        String headerAssigned = dashboardPage.getHeaderAssigned();
        Assert.assertEquals(headerAssigned,"Assigned");
        dashboardPage.clickBackMenus();
    }
    @Test

    public void tc004_VerifySelfAssigned() {

        dashboardPage.selfEnrollTab();
        String headerSelfEnroll = dashboardPage.getHeaderSelfEnrol();
        Assert.assertEquals(headerSelfEnroll,"Self-Enrolled");
        dashboardPage.clickBackMenus();
    }
    @Test
    public void tc005_VerifyOnGoing() {

        dashboardPage.onGoingTab();
        String headerOnGoing = dashboardPage.getHeaderOnGoing();
        Assert.assertEquals(headerOnGoing,"Ongoing");
        dashboardPage.clickBackMenus();
    }
    @Test
    public void tc006_VerifyDueSoon() {

        dashboardPage.dueSoonTab();
        String headerDueSoon = dashboardPage.getHeaderDueSoon();
        Assert.assertEquals(headerDueSoon,"Due Soon");
        dashboardPage.clickBackMenus();
    }
    @Test
    public void tc007_VerifyOverDue() {

        dashboardPage.overDueTab();
        String headerOverDue = dashboardPage.getHeaderOverDue();
        Assert.assertEquals(headerOverDue,"Overdue");
        dashboardPage.clickBackMenus();
    }
    @Test

    public void tc008_VerifyCompleted() {

        dashboardPage.completedTab();
        String headerCompleted = dashboardPage.getHeaderCompleted();
        Assert.assertEquals(headerCompleted,"Completed");
        dashboardPage.clickBackMenus();

    }

}
