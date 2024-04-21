package com.testCases.profile;

import com.pageObjects.LoginPage;
import com.pageObjects.LogoutPage;
import org.testng.annotations.Test;

import java.util.concurrent.TimeoutException;

//import org.apache.log4j.Logger;

import org.testng.Assert;

import com.base.BaseClass;

public class SLM_logout extends BaseClass {

    @Test
    public void sincxLogout() throws TimeoutException {
        //Log in to syncx app
        LoginPage logPage=new LoginPage(driver);
        logPage.sincxLogin(domainname,username1,password);

        // Assertions for Logging out SyncX.
        LogoutPage logoutPage=new LogoutPage(driver);
        logoutPage.logout();

        Assert.assertTrue(logoutPage.checkLogoutSuccessful());
    }

}
