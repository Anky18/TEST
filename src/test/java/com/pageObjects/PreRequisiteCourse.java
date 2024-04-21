package com.pageObjects;

import com.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.List;

public class PreRequisiteCourse extends BasePage {

    public WebDriverWait wait;

    public PreRequisiteCourse (WebDriver driver)
    {

        super(driver);
    }

    // Click on assigned tab
    @FindBy(xpath="//p[@class='_1rvopwa'][text()='Assigned']")
    public WebElement assignedMenu;

    // Click on Assigned - Being a first manager course
    @FindBy(xpath = "//p[text()='Being a First-Time Manager']")
    public WebElement selectCourse;

    // verify the header after clicking the course
    @FindBy(xpath = "//h1[@class='_1fe5yjd']")
    public WebElement headerCourse;

    //Click on start the course
    @FindBy(xpath = "//p[@class='_1yanunz']")
    public WebElement startCourse;

    //Capture error message
    @FindBy(xpath= "//div[@class='MuiSnackbarContent-message _1eri0dc']")
    public WebElement errorMessage;

    //Dismiss button for error message
    @FindBy(xpath="//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text _i90ik5']")
    public WebElement dismissButton;

    //Click on the description tab for the course
    @FindBy(xpath = "//p[@class='_1jahjmyz']")
    public WebElement   descriptionTab;

    //Check the content displayed in the description page
    @FindBy(xpath = "//p[@class='_1kn6xuj']")
    public WebElement   contentDescription;

    // Click on the pre-requisite tab
    @FindBy(xpath = "//p[@class='_13q9s6t'][text()='Prerequisite']")
    public WebElement preRequisiteTab;

    // Get the message displayed after the clicking the pre-requisite tab
    @FindBy(xpath= "//p[@class='_qlcigj']")
    public WebElement messagePreRequisite;

    // Number of courses under pre requisite tab
    @FindBy(xpath = "//p[@class='_181rl92']")
    public List<WebElement> countCourses;

    // Click on course 1 on pre-requisite course
    @FindBy(xpath= "//p[@class='_181rl92'][text()='E-mail Etiquettes']")
    public WebElement emailEtiquettes;

    // After clicking , get the header and time of the course
    @FindBy(xpath = "//h1[@class='_1fe5yjd']")
    public WebElement headerEmailCourse;

    @FindBy(xpath="//p[@class='_118tb6l'][text()='Duration']")
    public WebElement courseDuration;

    // Start course for the prerequisite course
    @FindBy(xpath = "//p[@class='_1yanunz']")
    public WebElement startCourseEmailEtiquette;

    // get the heading of the content page
    @FindBy(xpath = "//h1[@class='_1fe5yjd']")
    public WebElement headingContentEmail;

    //Click back button on the email etiquette course page
    @FindBy(xpath = "//p[@class='_1tog7ov']")
    public WebElement backButton;

    // Again after clicking back button , welcome page
    @FindBy(xpath = "//h1[@class='_k8siqs']")
    public WebElement checkHomePageName;

    public void clickAssigned(){
        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(assignedMenu));
        assignedMenu.click();
    }
    public void selectCourseClick(){

        wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(selectCourse));
        selectCourse.click();
    }
    public String getCourseHeader(){
        wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOf(headerCourse));
        String courseName = headerCourse.getText();
        System.out.println("The name of the course clicked is :" +courseName);
        return courseName;
    }
    public void clickStartCourse(){

        wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(startCourse));
        startCourse.click();
    }
    public String getErrorMessage(){

        wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
        String errorMessageCourse = errorMessage.getText();
        System.out.println("The error message when clicked start course is : " +errorMessageCourse);
        return errorMessageCourse;
    }
    public void clickDismiss(){
        wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(dismissButton));
        dismissButton.click();
    }

    public void clickDescriptionTab(){

        wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(descriptionTab));
        descriptionTab.click();

    }

    public boolean descriptionContent(){
        wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(contentDescription));
        boolean contentCheck = contentDescription.isDisplayed();
        System.out.println("Is the content displayed under description: " + contentCheck);
        return contentCheck;

    }
    public void clickPreRequisiteTab(){

        wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(preRequisiteTab));
        preRequisiteTab.click();
    }
    public String getMessagePreRequisite(){
        wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(messagePreRequisite));
        return messagePreRequisite.getText();
    }
    public int noOfCourses(){

        wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfAllElements(countCourses));
        return countCourses.size();
    }
    public void getPreRequisiteCourseNames() {

        for (int i = 0; i < countCourses.size(); i++) {

            String getCourseNames = countCourses.get(i).getText();
            System.out.println("Name of course" + (i + 1) + ":" + getCourseNames);
        }
    }

    public void clickEmailEtiquettes(){
        wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(emailEtiquettes));
        emailEtiquettes.click();
    }

    //Start button on the pre-requisite course-Email etiquette course
    public boolean checkStartButton(){
        wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(startCourseEmailEtiquette));
        boolean startButtonEmail = startCourseEmailEtiquette.isDisplayed();
        System.out.println("Is the Start course displayed in pre-requisite course?: " + startButtonEmail);
        return startButtonEmail;
    }

    //Click on the Start/Resume button on the pre-requisite course-Email etiquette course
    public void clickStartButtonEmailEtiquette(){
        wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(startCourseEmailEtiquette));
        startCourseEmailEtiquette.click();
    }

    public String headingContentEmail(){
        wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(headingContentEmail));
        return headingContentEmail.getText();
    }

    public void backButton(){
        wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(backButton));
        backButton.click();
    }
    public String getHomePageName(){

        wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(checkHomePageName));
        String homePageName = checkHomePageName.getText();
        System.out.println("Again after clicking back button, the name on the homepage is : " +homePageName);
        return homePageName;
    }

    public String getEmailHeader(){
        wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(headerEmailCourse));
        return headerEmailCourse.getText();
    }

    public String getCourseDuration(){
        wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(courseDuration));
        return courseDuration.getText();
    }

    //Testcase1 - error message check

    public void clickAssignedAndCourse() {
        clickAssigned();
        selectCourseClick();
        clickStartCourse();
    }


    //TestCase2 - Click on the description tab and check the content display
    public void descriptionTabCheck(){

        clickDescriptionTab();

    }

    //Testcase3 - Click on the Pre-requisite tab and count the no.of courses displayed
    public void numberOfCourses(){

        clickPreRequisiteTab();
        System.out.println("The Message displayed after clicking prerequisite tab: " +getMessagePreRequisite());
        System.out.println("The no.of courses under pre-requisite tab is: "+ noOfCourses());
        getPreRequisiteCourseNames();

    }

    // TestCase4 - Check whether the start course button is displayed after clicking email etiquette course


    //TestCase5 - Click on the pre-requisite course and check the header/duration of the course

    public void preRequisiteCourseDetails(){
        clickEmailEtiquettes();

        System.out.println("The Duration of the Email Etiquettes course is: "+getCourseDuration());

    }

    // TestCase6 - Click on the start/resume button and check the content displayed
    public void courseContentEmailEtiquette(){

        clickStartButtonEmailEtiquette();
        String questionDisplayed = headingContentEmail();
        System.out.println("The header question displayed for email course is: " +questionDisplayed);
        backButton();


    }


}
