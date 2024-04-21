package com.pageObjects;

import com.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class SortingFunctionalityPage extends BasePage {
    public WebDriverWait wait;

    public SortingFunctionalityPage(WebDriver driver) {
        super(driver);
        // ldriver = rdriver;
        // PageFactory.initElements(ldriver, this);
    }

    // capture sort/filter image
    @FindBy(css = "img[alt='Filter image alt']")
    public WebElement filterSort;

    // capture title of dashboard
    @FindBy(css = "._k8siqs")
    public WebElement titleDashboard;
    // capture title of sort/filter modal

    @FindBy(css = "._1pe9lxn")
    public WebElement modalHeader;

    // capture textbox of sort option
    @FindBy(xpath = "//input[@placeholder='Sort by']")
    public WebElement tBoxSort;

    // capture drop down button
    @FindBy(xpath = "//div[@class='MuiAutocomplete-endAdornment']/button[2]")
    public WebElement dropDwnArrow;

    @FindBy(xpath = "//p[text()='Apply']")
    public WebElement buttonApply;

    @FindBy(xpath = "//p[@class ='_181rl92']")
    public List<WebElement> courseListTitle;

    @FindBy(xpath = "//div[@class='_1xejhi9q']//p[@class='_bideft']")
    public List<WebElement> courseListDuration;

    @FindBy(xpath = "//div[@class='_11bl42k']//p[@class='_bideft']")
    public List<WebElement> dueDateList;

    //=================Action Methods====================//
    /*
     * public void checkSearch() { wait = new WebDriverWait(driver, 20);
     * wait.until(ExpectedConditions.visibilityOf(tBoxSearch));
     * tBoxSearch.sendKeys("manual testing"); tBoxSearch.sendKeys(Keys.COMMAND +
     * "a"); tBoxSearch.sendKeys(Keys.DELETE); titleCourse.getText();
     * System.out.println("Result of search  is " + titleCourse.getText());}
     */
    // check sort/filter option

    public void clickFilter() {
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(filterSort));
        filterSort.click();
        modalHeader.getText();
        System.out.println("title of the modal is " + modalHeader.getText());
    }

    public boolean setAlphabeticalAZDropdownValue() {
        return clickAndSelectDropDownValue("Alphabetical (A-Z)");
    }

    public boolean setAlphabeticalZADropdownValue() {
        return clickAndSelectDropDownValue("Alphabetical (Z-A)");
    }

    public boolean setDurationLowHighDropdownValue() {
        return clickAndSelectDropDownValue("Duration (Low to High)");
    }

    public boolean setDurationHighLowDropdownValue() {
        return clickAndSelectDropDownValue("Duration (High to Low)");
    }
    public boolean setDueDateOldLatestValue() {
        return clickAndSelectDropDownValue("Due Date (Oldest to Latest)");}
    public boolean setDueDateLatestOldValue() {
        return clickAndSelectDropDownValue("Due Date (Latest to Oldest)");
    }

    public void clickApply() {
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(buttonApply));
        buttonApply.click();
        System.out.println("Clicked on Button 'Apply'");
    }

    public boolean verifyLandedOnDashboard() {
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(titleDashboard));
        System.out.println("Landed on Dashboard Page & the tittle is " + titleDashboard.getText());
        return titleDashboard.getText().contains("Welcome");
    }

    // Verify sorting Title by Alphabetical A-Z order
     public boolean verifyAllAscendingOrderTittle()
     {
         wait = new WebDriverWait(driver, 30);
         wait.until(ExpectedConditions.visibilityOfAllElements(courseListTitle));
         System.out.println("The Alphabetical A-Z Order of the courses are: ");
         return doAscendingCheck(courseListTitle, DataTypeCheck.String);
     }

    // Verify sorting Title by Alphabetical Z-A order
    public boolean verifyAllDescendingOrderTittle()
    {
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfAllElements(courseListTitle));
        System.out.println("The Alphabetical Z-A Order of the courses are: ");
        return doDescendingCheck(courseListTitle, DataTypeCheck.String);
    }

    // Verify sorting by Duration (Low to High) order
    public boolean verifyAllAscendingOrderDuration()
    {
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfAllElements(courseListDuration));
        System.out.println("The Duration (Low to High) Order of the courses are: ");
        return doAscendingCheck(courseListDuration, DataTypeCheck.Int);
    }

    // Verify sorting Title by Duration (High to Low) order
    public boolean verifyAllDescendingOrderDuration()
    {
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfAllElements(courseListDuration));
        System.out.println("The Duration (High to Low) Order of the courses are: ");
        return doDescendingCheck(courseListDuration, DataTypeCheck.Int);
    }

    public boolean verifyAllOldToLatestOrderDueDate()
    {
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfAllElements(dueDateList));
        System.out.println("The Due Date (Oldest to Latest) Order of the courses are: ");
        return doAscendingCheck(dueDateList, DataTypeCheck.Date);
       // return doDescendingCheck(dueDateList, DataTypeCheck.Date);
    }


    public boolean verifyAllLatestToOldOrderDueDate()
    {
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfAllElements(dueDateList));
        System.out.println("The Due Date (Latest to Oldest) Order of the courses are: ");
        return doDescendingCheck(dueDateList, DataTypeCheck.Date);
        //return doAscendingCheck(dueDateList, DataTypeCheck.Date);
    }

    public void getAllTittleBeforeSort()
    {
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfAllElements(courseListTitle));
        System.out.println("-----------------------------");
        System.out.println("The courses before sort are: ");
        for (WebElement tittle  : courseListTitle) {
            System.out.println(tittle.getText());
        }
        System.out.println("-----------------------------");
    }

    private boolean clickAndSelectDropDownValue(String value) {
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(dropDwnArrow));
        System.out.println("Filter dropdown open");
        dropDwnArrow.click();
        WebElement valueElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='"+value+"']")));
        valueElement.click();
        wait.until(ExpectedConditions.attributeToBeNotEmpty(tBoxSort, "value"));
        System.out.println("Selected value is: " + tBoxSort.getAttribute("value"));
        return tBoxSort.getAttribute("value").equals(value);
    }

    private boolean doAscendingCheck(List<WebElement> elements, DataTypeCheck hasDataType) {
        ArrayList<String> sortedList = new ArrayList<String>();
        System.out.println("-----------------------------");
        for (WebElement element  :elements) {
            System.out.println(element.getText());
            sortedList.add(element.getText());
        }
        System.out.println("-----------------------------");

        //Check if the courses from the dashboard are sorted ascending using ArrayList stream method since Java 8 supports it.
        //Other method is to Create a new function and compare list to itself by duplicating and sorting it
        switch (hasDataType){
            case Int:
                return sortedList.stream().sorted(Comparator.comparing(SortingFunctionalityPage::parseDuration))
                        .collect(Collectors.toList()).equals(sortedList);
            case Date:
                return sortedList.stream().sorted(Comparator.comparing(SortingFunctionalityPage::parseDate))
                        .collect(Collectors.toList()).equals(sortedList);
            case String:
                return sortedList.stream().sorted().collect(Collectors.toList()).equals(sortedList);
            default:
                return false;
        }
    }

    private boolean doDescendingCheck(List<WebElement> elements, DataTypeCheck hasDataType) {
        ArrayList<String> sortedList = new ArrayList<String>();
        System.out.println("-----------------------------");
        for (WebElement element  :elements) {
            System.out.println(element.getText());
            sortedList.add(element.getText());
        }
        System.out.println("-----------------------------");

        //Check if the courses from the dashboard are sorted descending using ArrayList stream method since Java 8 supports it.
        switch (hasDataType) {
            case Int:
                return sortedList.stream().sorted(Comparator.comparing(SortingFunctionalityPage::parseDuration).reversed())
                        .collect(Collectors.toList()).equals(sortedList);
            case Date:
                return sortedList.stream().sorted(Comparator.comparing(SortingFunctionalityPage::parseDate).reversed())
                        .collect(Collectors.toList()).equals(sortedList);
            case String:
                return sortedList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()).equals(sortedList);
            default:
                return false;
        }
    }

    private static int parseDuration(String duration) {
        return Integer.parseInt(duration.split(" ")[0]);
    }

    private static Date parseDate(String date) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return df.parse(date.split(" ")[1]);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private enum DataTypeCheck {
        //for Title check
        String,

        //for Duration check
        Int,

        //for Due date check
        Date
    }
}
