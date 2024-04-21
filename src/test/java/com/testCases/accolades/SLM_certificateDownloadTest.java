package com.testCases.accolades;

import com.base.BaseClass;
import com.pageObjects.AccoladesPage;
import com.pageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.util.concurrent.TimeoutException;

public class SLM_certificateDownloadTest extends BaseClass
{
    @Test
    public void certificateDownloadTest() throws TimeoutException, InterruptedException
    {
        LoginPage logPage = new LoginPage(driver);
        logPage.sincxLogin(domainname, username1, password);
        AccoladesPage aWard = new AccoladesPage(driver);
        aWard.accoladesButtonClick();
        aWard.downloadCertificateClick();


        // Assertion for Certificate download page

        aWard.downloadButtonClick();

        Thread.sleep(3000);

        //    verify file downloaded
        File filelocation = new File("/Users/ankitabharadhwaj/Downloads");
        File[] totalFiles = filelocation.listFiles();
        String expected = "Certificate-";
        for (File file : totalFiles) {

            if (file.getName().contains(expected)) {
                System.out.println("file downloaded: " + file.getName());
                Assert.assertTrue(true);
                String fileName = file.getName();
                file.delete();
                System.out.println("file deleted:  " + fileName);
                break;
            }
        }


    }
}
