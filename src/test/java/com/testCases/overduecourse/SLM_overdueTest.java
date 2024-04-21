package com.testCases.overduecourse;

import com.base.BaseClass;
import com.pageObjects.DuesoonPage;
import com.pageObjects.LoginPage;
import com.pageObjects.LogoutPage;
import com.pageObjects.OverduePage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeoutException;

public class SLM_overdueTest extends BaseClass
{

    OverduePage overduePage;
    String numberOfOverDueOnDash;
    @BeforeClass
    public void beforeOverDue() throws TimeoutException {
        LoginPage logPage = new LoginPage(driver);
        logPage.sincxLogin(domainname, username1, password);
        overduePage = new OverduePage(driver);

        numberOfOverDueOnDash= overduePage.numOfCoursesOnDash();// number displayed on Dashboard
        System.out.println("number displayed on Dashboard : "+numberOfOverDueOnDash);
        overduePage.overDueTabClick();
    }
    @Test
    public void tc001_overDueTest() throws TimeoutException {


        //Assertion for landing on overdue page after clicking overdue tab

        Assert.assertTrue(overduePage.checkOverDueTitle());
        System.out.println("Landed on Overdue Page");
    }
    @Test
    public void tc002_verifyNumberOfCourse() throws TimeoutException {

        if (!numberOfOverDueOnDash.equals("0")) {
            int numOfOverDueOnDash=Integer.parseInt(numberOfOverDueOnDash);
            int numberOfOverDueOnPage = overduePage.numOfCoursesOnOverDue();// number of courses inside Overdue page
            System.out.println("number displayed inside overdue page : " + numberOfOverDueOnPage);

            // Assertion comparing number of courses
            Assert.assertEquals(numOfOverDueOnDash, numberOfOverDueOnPage);
            System.out.println("Both numbers are same");
        } else {
            Assert.assertTrue(overduePage.checkNoItemMessage());
            System.out.println("Message displayed on OverDue  Page: " + overduePage.noItemMessage.getText());

        }
    }
    @Test
    public void tc003_verifyBackArrow() throws TimeoutException {
        // Assertion for clicking back arrow

        overduePage.backArrowClick();
        Assert.assertTrue(overduePage.checkDashBoardPage());
        System.out.println("Landed on Dashboard Page");

    }
   @AfterClass
    public void overDueAfter() throws TimeoutException {

        LogoutPage logPage = new LogoutPage(driver);
        logPage.profileClick();
        logPage.logoutClick();
    }

}
