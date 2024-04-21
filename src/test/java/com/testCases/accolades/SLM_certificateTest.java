package com.testCases.accolades;

import com.base.BaseClass;
import com.pageObjects.AccoladesPage;
import com.pageObjects.LoginPage;
import com.pageObjects.LogoutPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.util.concurrent.TimeoutException;

public class SLM_certificateTest extends BaseClass
{
    AccoladesPage aWard;

    @BeforeClass
    public void beforeCertificate() throws TimeoutException {
        LoginPage logPage = new LoginPage(driver);
        logPage.sincxLogin(domainname, username1, password);
        aWard = new AccoladesPage(driver);
        aWard.accoladesButtonClick();
        aWard.downloadCertificateClick();
    }
    @Test
    public void tc001_certificateTest() throws TimeoutException {

        Assert.assertTrue(aWard.checkCertificatePage());
        System.out.println("Landed on Certificate page: " + aWard.checkCertificatePage());

    }
    @Test
    public void tc002_verifyTrophy() throws TimeoutException {

        // Assertion for Certificate page

        Assert.assertTrue(aWard.checkTrophyImage());
        System.out.println("Trophy image displayed: " + aWard.checkTrophyImage());
    }
    @Test
    public void tc003_verifyCertificateTitle() throws TimeoutException {
        Assert.assertTrue(aWard.checkTitle());
        System.out.println("Certificate title displayed: " + aWard.certificateTitle.getText());
    }
    @Test
    public void tc004_verifyLearnerName() throws TimeoutException {
        Assert.assertTrue(aWard.checkLearnerName());
        System.out.println("Learner name displayed: " + aWard.learnerName.getText());
        //  System.out.println("Learner name displayed: "+aWard.learnerName1.getText());
    }
    @Test
    public void tc005_verifyCourseTitle() throws TimeoutException {
        Assert.assertTrue(aWard.checkCourseTitle2());
        System.out.println("Course title on certificate displayed: " + aWard.courseTitle2.getText());
    }
    @Test
    public void tc006_verifyCourseDate() throws TimeoutException {
        String s=aWard.courseDetail.getText();
     //   softAssert.assertTrue(aWard.checkCompletedDate2());
        System.out.println("Completed date displayed: "+s);
    }
    @Test
    public void tc007_verifyDuration() throws TimeoutException {
        Assert.assertTrue(aWard.checkCourseDuration());
        System.out.println("Course duration displayed: " + aWard.courseDuration.getText());
    }
    @Test
    public void tc008_verifyCompanyName() throws TimeoutException {
        Assert.assertTrue(aWard.checkCompanyName());
        System.out.println("Company name displayed: " + aWard.companyName.getText());
    }
    @Test
    public void tc009_verifyDownloadEnabled() throws TimeoutException {
        Assert.assertTrue(aWard.checkDownloadClick());
        System.out.println("Download button Enabled: "+aWard.checkDownloadClick());
    }
    @Test
    public void tc010_verifyBackArrow() throws TimeoutException {
        // verify the functionality of back arrow
        aWard.backArrowClick();

        Assert.assertTrue(aWard.checkBackArrowClick());
        System.out.println("Landed on Accolades page : " + aWard.checkBackArrowClick());

    }

    @AfterClass
    public void certificateAfter() throws TimeoutException {
        LogoutPage logPage = new LogoutPage(driver);
        logPage.profileClick();
        logPage.logoutClick();
    }
}
