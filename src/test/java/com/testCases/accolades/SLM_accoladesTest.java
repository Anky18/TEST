package com.testCases.accolades;

import com.base.BaseClass;
import com.pageObjects.AccoladesPage;
import com.pageObjects.LoginPage;
import com.pageObjects.LogoutPage;
import com.testCases.signIn.SLM_001loginApp;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.util.Objects;
import java.util.concurrent.TimeoutException;

public class SLM_accoladesTest extends BaseClass
{

    AccoladesPage aWard;

    @BeforeClass
    public void accoladesBefore() throws TimeoutException {

       LoginPage logPage = new LoginPage(driver);
        logPage.sincxLogin(domainname, username1, password);

        aWard = new AccoladesPage(driver);
        aWard.accoladesButtonClick();
    }

    @Test
    public void tc001_verifyAccoladesTitle() throws TimeoutException {


        // Assertion to check the Accolades Page elements
        Assert.assertTrue(aWard.checkAccoladesTitle());
        System.out.println("Landed on Accolades Page " + aWard.checkAccoladesTitle());

    }
    @Test
   public void tc002_verifyShield() throws TimeoutException {


        // Assertion to check the Accolades Page elements
        Assert.assertTrue(aWard.checkShield());
        System.out.println("Shield Displayed: " + aWard.checkShield());

    }
    @Test
    public void tc003_verifyMyCertificate() throws TimeoutException {

        Assert.assertTrue(aWard.checkMycertificate());
        System.out.println("Mycertificate Title displayed: " + aWard.myCertificateText.getText());

    }
    @Test
    public void tc004_verifyCourseTitle() throws TimeoutException {

        Assert.assertTrue(aWard.checkCourseTitle());
        System.out.println("Course title Displayed: " + aWard.courseTitle.getText());
    }
    @Test
    public void tc005_verifyCourseStatus() throws TimeoutException {


        Assert.assertTrue(aWard.checkCourseStatus());
        System.out.println("Course status displayed: " + aWard.courseStatus.getText());
    }
    @Test
    public void tc006_verifyCompletedDate() throws TimeoutException {


       Assert.assertTrue(aWard.checkCompletedDate());
        System.out.println("Course completion date displayed: " + aWard.completedDate.getText());
    }
    @Test
    public void tc007_verifyMedal() throws TimeoutException {


        Assert.assertTrue(aWard.checkMedal());
        System.out.println("Course Medal displayed: " + aWard.checkMedal());

    }
    @Test
    public void tc008_verifyDownloadLink() throws TimeoutException {


          Assert.assertTrue(aWard.checkDownloadCertificate());
          System.out.println("Download certificate link displayed: " + aWard.checkDownloadCertificate());


     }
     @AfterClass
    public void accoladesAfter() throws TimeoutException {
         LogoutPage logPage = new LogoutPage(driver);
         logPage.profileClick();
         logPage.logoutClick();


     }
}
