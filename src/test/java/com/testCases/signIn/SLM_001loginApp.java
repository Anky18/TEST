package com.testCases.signIn;

import com.base.BaseClass;
import com.pageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeoutException;

public class SLM_001loginApp extends BaseClass
{
    @Test
    public void sincxloginTest() throws TimeoutException
    {
        LoginPage logPage=new LoginPage(driver);
        logPage.sincxLogin(domainname,username1,password);
        logger.info("User logged in with valid inputs");

        //Assertion to verify that the user landed on  Dashboard page with valid login credentials

        Assert.assertTrue(logPage.checkLoginSuccessful());

    }

}
