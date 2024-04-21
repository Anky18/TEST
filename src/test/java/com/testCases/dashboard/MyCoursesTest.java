package com.testCases.dashboard;

import com.base.BaseClass;
import com.pageObjects.LoginPage;
import com.pageObjects.MyCoursesPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeoutException;

public class MyCoursesTest extends BaseClass {

    MyCoursesPage myCourses; String name; String title;
    String status; String duration;String completion;
    @BeforeClass
    public void verifyMyCourses() throws TimeoutException {

        // Login page Instance and method
        LoginPage logPage = new LoginPage(driver);
        logPage.sincxLogin(domainname, username1, password);
         myCourses = new MyCoursesPage(driver);}
    @Test
        //validate header of completed courses page
        public void tc001_verifyCompleted() {
        int totalCompleted = myCourses.getCompletedTotal();
        int totalCompletedTab= myCourses.getCompletedTab();
        Assert.assertEquals(totalCompleted, totalCompletedTab);
    }
     @Test
     //validate status of first course
     public void tc002_verifyCourse1Status()  {
        status = myCourses.getStatus();
        Assert.assertEquals(status, "COMPLETED");}

     @Test
        //validate name of first course
        public void  tc003_verifyCourse1Name(){
        name = myCourses.getName();
        Assert.assertEquals(name, "Being a First-Time Manager");}

     @Test
        //validate duration of course 1
        public void tc004_verifyCourse1Duration () {
        duration = myCourses.getDuration();
        Assert.assertEquals(duration, "20 mins");}

     @Test
        //validate completion date of course 1
        public void tc005_verifyCourse1Completion() {
        completion = myCourses.getDate();
        Assert.assertEquals(completion, "Completed: 2023-10-21");}

    @Test
        //validate status of course 2
        public void tc006_verifyCourse2Status(){
        status = myCourses.getStatus2();
        Assert.assertEquals(status, "COMPLETED");}

    @Test
        //validate name of  course 2
        public void  tc007_verifyCourse2Name(){
        name = myCourses.getName2();
        Assert.assertEquals(name, "E-mail Etiquettes");}

    @Test
        //validate duration of course 2
        public void tc008_verifyCourse2Duration () {
        duration = myCourses.getDuration2();
        Assert.assertEquals(duration, "10 mins");}

    @Test
        //validate completion date of course 2
        public void tc009_verifyCourse2Completion() {
        completion = myCourses.getDate2();
        Assert.assertEquals(completion, "Completed: 2023-10-23");}


}
