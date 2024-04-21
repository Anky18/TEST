package com.pageObjects;

import com.base.BasePage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.concurrent.TimeoutException;

public class AccoladesPage extends BasePage
{
    public WebDriverWait wait;
    public JavascriptExecutor js;
    public Actions action;

    // Constructor

    public AccoladesPage(WebDriver driver)
    {
        super(driver);
    }

    // Accolades Page objects
    // Capture Accolades button
    @FindBy(xpath = "//p[text()='Accolades']")
    public WebElement accoladesButton;

    //Capture Accolades title
    @FindBy(xpath = "//h1[@class='_k8siqs'][text()='Accolades']")
    public WebElement accoladesTitle;

    // Capture Mycertificates title
    @FindBy(xpath = "//p[text()='My certificates']")
    public WebElement myCertificateText;

    // Capture Shield Image
    @FindBy(xpath = "//p[text()='Shield']")
    public WebElement shieldImage;

    // Capture Course title
    @FindBy(xpath = "//p[text()='Being a First-Time Manager']")
    public WebElement courseTitle;

    // Capture Course status
    @FindBy(xpath = "//p[text()='Completed']")
    public WebElement courseStatus;

    // Capture Completed date
    @FindBy(xpath = "//p[text()='22-Oct-2023']")
    public WebElement completedDate;

    // Capture Download certificate message
    @FindBy(xpath = "//p[text()='Download certificate']")
    public WebElement downloadCertificate;

    // Capture Medal image
    @FindBy(xpath = "//img[@src='/static/media/medal_light_icon.bcfcceb2.svg']")
    public WebElement medalImage;


    //  certificate page

    //Cature certificate page title
    @FindBy(xpath = "//h1[text()='Congrats \uD83C\uDF89 You have passed the course.']")
    public WebElement certificatePage;

    // Capture cerificate title
    @FindBy(xpath = "//h1[@class='title']")
    public WebElement certificateTitle;

    // Capture Congrats message and Learner Name
    @FindBy(xpath = "//p[@class='name']")
    public WebElement learnerName;

    // Capture the learners name
    @FindBy(xpath = "//p[@class='name']/child::*")
    public WebElement learnerName1;

    // Capture Trophy Image
    @FindBy(xpath = "//img[@class='trophyImg']")
    public WebElement trophyImage;

    // Capture Course title2
    @FindBy(xpath = "//p[@class='course']")
    public WebElement courseTitle2;

    // Capture Course duration
    @FindBy(xpath = "//p[text()='Duration: 20 min']")
    public WebElement courseDuration;

    // Capture Completed date2
    @FindBy(xpath = "//p[text()='Course completed on Oct 21,  2023']")
    public WebElement completedDate2;

    // Capture Download button
    @FindBy(xpath = "//p[text()='Download']")
    public WebElement downloadButton;

    // Capture company name
    @FindBy(xpath = "//p[@class='company']")
    public WebElement companyName;


    // Capture Back arrow
    @FindBy(xpath = "//img[@alt='Arrow left icon alt']")
    public WebElement backArrow;

    @FindBy(xpath = "//p[@class='courseDetails']")
    public WebElement courseDetail;



/*----------------------              Action methods  ----------------------------------- */

    //Click on the Accolades button on Dashboard
        public void accoladesButtonClick() throws TimeoutException {
           wait = new WebDriverWait(driver, 20);
           wait.until(ExpectedConditions.elementToBeClickable(accoladesButton));
            accoladesButton.click();
            System.out.println("clicked accolades button");
        }
      //Click on the download certificate on Accolades page
    public void downloadCertificateClick() throws TimeoutException {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(downloadCertificate));
        downloadCertificate.click();
        System.out.println("clicked download certificate");
    }
    //Click on the download Button on Certificate page
    public void downloadButtonClick() throws TimeoutException {
        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(downloadButton));
        downloadButton.click();
        System.out.println("clicked download button");

    }
    //Click on the Back Arrow  on Certificate page
    public void backArrowClick() throws TimeoutException {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(backArrow));
        backArrow.click();
        System.out.println("clicked back arrow");
    }

  /*------------------------------------  Validation methods for Accolades page-------------------------------*/

    public boolean checkAccoladesTitle() throws TimeoutException
    {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(accoladesTitle));
        return accoladesTitle.isDisplayed();
    }

    public boolean checkShield() throws TimeoutException
    {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(shieldImage));
        return shieldImage.isDisplayed();
    }

    public boolean checkMycertificate() throws TimeoutException
    {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(myCertificateText));
        return myCertificateText.isDisplayed();
    }
    public boolean checkCourseTitle() throws TimeoutException
    {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(courseTitle));
        return courseTitle.isDisplayed();
    }

    public boolean checkCourseStatus() throws TimeoutException
    {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(courseStatus));
        return courseStatus.isDisplayed();
    }

    public boolean checkCompletedDate() throws TimeoutException
    {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(completedDate));
        return completedDate.isDisplayed();
    }
    public boolean checkMedal() throws TimeoutException
    {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(medalImage));
        return medalImage.isDisplayed();
    }
    public boolean checkDownloadCertificate() throws TimeoutException
    {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(downloadCertificate));
        return downloadCertificate.isDisplayed();
    }

/*------------------------  Validation methods for Certificate page --------------------*/

    public boolean checkCertificatePage() throws TimeoutException
    {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(certificatePage));
        return certificatePage.isDisplayed();
    }
    public boolean checkTitle() throws TimeoutException
    {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(certificateTitle));
        return certificateTitle.isDisplayed();
    }

    public boolean checkLearnerName() throws TimeoutException
    {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(learnerName));
        return learnerName.isDisplayed();
    }

    public boolean checkCourseTitle2() throws TimeoutException
    {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(courseTitle2));
        return courseTitle2.isDisplayed();
    }

    public boolean checkCompletedDate2() throws TimeoutException
    {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(completedDate2));
        return completedDate2.isDisplayed();
    }
    public boolean checkCourseDuration() throws TimeoutException
    {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(courseDuration));
        return courseDuration.isDisplayed();
    }

    public boolean checkTrophyImage() throws TimeoutException
    {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(trophyImage));
        return trophyImage.isDisplayed();
    }

    public boolean checkCompanyName() throws TimeoutException
    {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(companyName));
        return companyName.isDisplayed();
    }
    public boolean checkDownloadClick() throws TimeoutException
    {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(downloadButton));
        return downloadButton.isEnabled();
    }
    public boolean checkBackArrowClick() throws TimeoutException
    {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(accoladesTitle));
        return accoladesTitle.isDisplayed();
    }

}
