package com.testCases.profile;

import com.pageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.base.BaseClass;
import com.pageObjects.LearnerProfilePage;
import java.util.concurrent.TimeoutException;

public class LearnerProfileTest extends BaseClass {
    String header;
    LearnerProfilePage learnerProfile;
    boolean result;


    @BeforeClass
    public void verifyProfilePage() throws TimeoutException {

        LoginPage logPage = new LoginPage(driver);
        logPage.sincxLogin(domainname, username1, password);
        learnerProfile = new LearnerProfilePage(driver);
        learnerProfile.openProfile();}

    @Test
    //verify title of profile page
    public void tc001_verifyTitleProfile(){
        header = learnerProfile.getHeader();
        Assert.assertEquals(header, "Profile");}

    @Test
    //verify learner name
    public void tc002_verifyName() {
        result= learnerProfile.getName();
        Assert.assertTrue(result);}

     @Test
    //verify company name/country
    public void tc003_verifyCompany()  {
         result= learnerProfile.getCompany();
         Assert.assertTrue(result);}

    @Test
    //verify learner email
    public void tc004_verifyEmail() {
        result= learnerProfile.getEmail();
        Assert.assertTrue(result);}

    @Test
    //verify Manager name
    public void tc005_verifyOptionalInfo()  {
        result= learnerProfile.getJobTitle();
        Assert.assertTrue(result);}

    @Test
    // verify terms of use link
    public void tc006_verifyTerms() {
        header = learnerProfile.getLinkTerms();
        Assert.assertEquals(header, "Terms of use");}

    @Test
    // verify privacy policy link
    public void tc007_verifyPrivacy(){
        header = learnerProfile.getLinkPrivacy();
        Assert.assertEquals(header, "Privacy policy");}

    @Test
        // verify terms and cond. link
    public void tc008_verifyTandC() {
        header = learnerProfile.getLinkTandC();
        Assert.assertEquals(header, "Terms & Conditions");}

    @Test
        //verify logout link
        public void tc009_verifyLogout() {
        String actual=learnerProfile.logoutLink();
        Assert.assertEquals(actual, "Domain");}

}


