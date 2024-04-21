package com.testCases.ongoingcourse;
import com.pageObjects.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeoutException;

//import org.apache.log4j.Logger;

import com.base.BaseClass;
import org.testng.Assert;

public class SLM_OnGoingTest extends BaseClass {

    LearnerOnGoing OGC;

    int displayCountFromDashboard;

    @BeforeClass
    public void beforeOnGoing() throws TimeoutException {
        LoginPage logPage = new LoginPage(driver);
        logPage.sincxLogin(domainname, username1, password);
        logger.info("Logging in with valid inputs");

        //-------------Actions and Assertions-----------//
        // Creating Object as CCP of the Class SLM_CCourse.
        OGC = new LearnerOnGoing(driver);
        displayCountFromDashboard =  OGC.getDashboardOngoingCourseCount();
        //Click on Ongoing Tab
        OGC.ClickOngoingTab();
    }


    @Test
    public void tc001_verifyOnGoingHeader()
    {
        //Check if landed on Ongoing Page after click from Dashboard
        Boolean properHeaderDisplayed =  OGC.VerifyOngoingHeader();
        Assert.assertTrue(properHeaderDisplayed);
    }

    @Test
    public void tc002_verifyOnGoingCourse() {
        // Verify the number of ongoing course is same as the number of manually updated course (Ongoing)
        int displayCountFromCoursePage = OGC.getNumberOfCourseOngoingFromCoursePage();
        Assert.assertEquals(displayCountFromCoursePage, displayCountFromDashboard);
    }

    @Test
    public void tc003_verifyProgressBarCount() {
        // Verify the number of ongoing course is same as the number of manually updated course (Ongoing)
        int noOfProgressBarDisplayed = OGC.getNumberOfProgressBarDisplayed();
        Assert.assertEquals(noOfProgressBarDisplayed, displayCountFromDashboard);
    }

    @Test
    public void tc004_verifyBackButton() {
        //Click on Back Button and Land on Dashboard .
        OGC.clickBack();
        Assert.assertTrue(OGC.checkDashBoardPage());
    }


}

