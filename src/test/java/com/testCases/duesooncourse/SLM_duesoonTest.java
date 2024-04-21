package com.testCases.duesooncourse;

import com.base.BaseClass;
import com.pageObjects.DuesoonPage;
import com.pageObjects.LoginPage;
import com.pageObjects.LogoutPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeoutException;

public class SLM_duesoonTest extends BaseClass
{

    DuesoonPage duesoonPage;
    String numberOfDueSoonOnDash;
    @BeforeClass
    public void beforeDueSoon() throws TimeoutException {
        LoginPage logPage = new LoginPage(driver);
        logPage.sincxLogin(domainname, username1, password);
        duesoonPage = new DuesoonPage(driver);

        numberOfDueSoonOnDash= duesoonPage.numOfCoursesOnDash();// number displayed on Dashboard
        System.out.println("number displayed on Dashboard : "+numberOfDueSoonOnDash);

        duesoonPage.dueSoonTabClick();
    }
    @Test
   public void tc001_duesoonTest() throws TimeoutException {

        //Assertion for landing on duesoon page after clicking duesoon tab

        Assert.assertTrue(duesoonPage.checkDueSoonTitle());
        System.out.println("Landed on DueSoon Page");
    }
    @Test
    public void tc002_verifyNumberOfCourse() throws TimeoutException {

        if (!numberOfDueSoonOnDash.equals("0")) {
            int numberOfDueSoonOnPage = duesoonPage.numOfCoursesOnDueSoon();// number of courses inside duesoon page
            System.out.println("number displayed inside DueSoon page : " + numberOfDueSoonOnPage);

            // Assertion comparing number of courses
            Assert.assertEquals(numberOfDueSoonOnDash, numberOfDueSoonOnPage);
            System.out.println("Both numbers are same");
        } else {
            Assert.assertTrue(duesoonPage.checkNoItemMessage());
            System.out.println("Message displayed on  Duesoon  Page: " + duesoonPage.noItemMessage.getText());
        }
    }
    @Test
    public void tc003_verifyBackArrow() throws TimeoutException {
            // Assertion for clicking back arrow

            duesoonPage.backArrowClick();
            Assert.assertTrue(duesoonPage.checkDashBoardPage());
            System.out.println("Landed on Dashboard Page");


    }
   @AfterClass
    public void dueSoonAfter() throws TimeoutException {
      LogoutPage logPage = new LogoutPage(driver);
        logPage.profileClick();
        logPage.logoutClick();
    }

}
