package com.testCases.completedcourse;

import com.pageObjects.CompletedCoursePage;
import com.pageObjects.LearnerOnGoing;
import com.pageObjects.LoginPage;
import com.pageObjects.LogoutPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeoutException;

//import org.apache.log4j.Logger;

import com.base.BaseClass;
import org.testng.Assert;

public class SLM_CCourse extends BaseClass {
   
   CompletedCoursePage CCP;

   int displayCountFromDashboard;

   @BeforeClass
   public void beforeCompletedCourse() throws TimeoutException {
      //Logging  in to syncx app
      LoginPage logPage = new LoginPage(driver);
      logPage.sincxLogin(domainname, username1, password);
      logger.info("User logged in with valid inputs");

      //-------------Actions-----------//

      // Creating Object as CCP of the Class SLM_CCourse.s
      CCP = new CompletedCoursePage(driver);
      displayCountFromDashboard =  CCP.GetDashboardCompletedCourseCount();

      CCP.ClickCompletedTab();
   }

   @Test
   public void tc001_verifyCourseCompletedHeader() throws TimeoutException {
      // Verifying the Header "Completed" Displayed on Completed Course Page
      Boolean headerDisplayed = CCP.CompletedHeader();
      Assert.assertTrue(headerDisplayed);
   }
   @Test
   public void tc002_verifyCourseCompleted() throws TimeoutException {

      int displayCountFromCoursePage = CCP.GetCoursePageCompletedCourseCount();

      // Verifying the Total Completed course number displayed on Dashboard and Completed Course Page are equal
      Assert.assertEquals(displayCountFromCoursePage, displayCountFromDashboard);
   }

   @Test
   public void tc003_VerifyBackButton() throws TimeoutException {
      // Click was made on Back Button.
      CCP.ClickBack();
      Assert.assertTrue(CCP.checkDashBoardPage());
   }
}





