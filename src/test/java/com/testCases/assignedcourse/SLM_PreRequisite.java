package com.testCases.assignedcourse;

import com.base.BaseClass;
import com.pageObjects.PreRequisiteCourse;
import com.testCases.signIn.SLM_001loginApp;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeoutException;

public class SLM_PreRequisite extends BaseClass {

    PreRequisiteCourse preRequisiteCourse;

    @BeforeClass
    public void preRequisiteTabSetUp() throws TimeoutException {

        SLM_001loginApp loginPage = new SLM_001loginApp();
        loginPage.sincxloginTest();

        preRequisiteCourse = new PreRequisiteCourse(driver);

    }

    @Test
    public void tc001_VerifyErrorMessage(){

        preRequisiteCourse.clickAssignedAndCourse();
        String getCourseName = preRequisiteCourse.getCourseHeader();
        Assert.assertEquals(getCourseName,"Being a First-Time Manager");
        String verifyErrorMessage = preRequisiteCourse.getErrorMessage();
        Assert.assertEquals(verifyErrorMessage, "Please complete the prerequisite courses");
        preRequisiteCourse.clickDismiss();
    }

    @Test
    public void tc002_VerifyDescriptionTab(){
        preRequisiteCourse.descriptionTabCheck();
        boolean contentDisplay= preRequisiteCourse.descriptionContent();
        Assert.assertTrue(contentDisplay);
    }

    @Test
    public void tc003_VerifyPreRequisiteCourses(){

        preRequisiteCourse.numberOfCourses();
        String getPreRequisiteMessage = preRequisiteCourse.getMessagePreRequisite();
        Assert.assertEquals(getPreRequisiteMessage,"Please complete the following courses before enrolling for this course");
    }

    @Test
    public void tc004_VerifyButtonEmailCourse(){
       boolean startResumeButton = preRequisiteCourse.checkStartButton();
        Assert.assertTrue(startResumeButton);
    }

    @Test
    public void tc005_VerifyPreRequisiteDetails(){

        preRequisiteCourse.preRequisiteCourseDetails();
        String headerEmail = preRequisiteCourse.getEmailHeader();
        Assert.assertEquals(headerEmail, "E-mail Etiquettes");
        System.out.println("The header of the email etiquettes page is: "+ headerEmail );
    }

    @Test
    public void tc006_VerifyContentEmailCourse(){

        preRequisiteCourse.courseContentEmailEtiquette();
        String headerEmail = preRequisiteCourse.getEmailHeader();
        Assert.assertEquals(headerEmail, "E-mail Etiquettes");
        System.out.println("After clicking back button, the header of the page is: "+ headerEmail);
        preRequisiteCourse.backButton();
        String headerHome = preRequisiteCourse.getHomePageName();
        Assert.assertEquals(headerHome,"Welcome, Automation!");

    }



}
