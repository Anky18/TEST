package com.testCases.selfassigned;

import com.base.BaseClass;
import com.pageObjects.LearnerSelfEnrolledPage;
import com.testCases.signIn.SLM_001loginApp;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeoutException;

public class SLM_SelfEnrolledTab extends BaseClass {

    LearnerSelfEnrolledPage selfEnrollTab;

    @BeforeClass

    public void selfEnrolled() throws TimeoutException, InterruptedException {

            SLM_001loginApp   signInPage  = new SLM_001loginApp();
            signInPage.sincxloginTest();

            selfEnrollTab = new LearnerSelfEnrolledPage(driver);

    }
    @Test

    public void tc001_ClickSelfEnrollTab() throws InterruptedException {

        selfEnrollTab.clickSelfEnrollPage();
        String headerSelfEnrol = selfEnrollTab.getHeaderSelfEnrol();
        Assert.assertEquals(headerSelfEnrol, "Self-Enrolled");
    }
    @Test
    public void tc002_CheckCourseCount() throws InterruptedException {

        selfEnrollTab.checkCoursesCount();
    }
    @Test
    public void tc003_CheckCourseDetails(){

        selfEnrollTab.getCourseNameStatusDate();
    }

    @Test
    public void tc004_ClickBackHome(){

        selfEnrollTab.clickBack();
        String homePage = selfEnrollTab.getHomePageName();
        Assert.assertEquals(homePage,"Welcome, Automation!");
    }



}
