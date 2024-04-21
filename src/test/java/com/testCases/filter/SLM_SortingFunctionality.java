package com.testCases.filter;

import com.base.BaseClass;
import com.pageObjects.LoginPage;
import com.pageObjects.SortingFunctionalityPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.util.concurrent.TimeoutException;

public class SLM_SortingFunctionality extends BaseClass {

    SortingFunctionalityPage sf;

    @BeforeClass
    public void beforeSorting() throws TimeoutException {
        //Logging  in to syncx app
        LoginPage logPage = new LoginPage(driver);
        logPage.sincxLogin(domainname, username1, password);
        logger.info("User logged in with valid inputs");

        //-------------Actions-----------//
        // Creating Object as sf of the Class SortingFunctionality.
        sf = new SortingFunctionalityPage(driver);

        //To print default order of the courses listed on dashboard before sorting/filtering
        sf.getAllTittleBeforeSort();
    }

    @Test
    public void tc001_verifyAlphabeticalAtoZDropdownValue() {
        //-------------Actions and Assertions-----------//
        //Click on filter icon to open a sort/filter Modal and print the title of the Modal
        sf.clickFilter();
        //Click on dropdown arrow to display and select a value from the list. Also print the selected value.
        boolean isSortValueSelected = sf.setAlphabeticalAZDropdownValue();
        //validate the input shows the proper selected value.
        Assert.assertTrue(isSortValueSelected);
    }

    @Test
    public void tc002_verifyDashboardReload() {

        //Click on apply button to sort the courses based on the selected value
        sf.clickApply();
        //print the value of the header to verify if the page is landed on Dashboard after click on apply button
        Assert.assertTrue(sf.verifyLandedOnDashboard());
    }

    @Test
    public void tc003_verifyAlphabeticalAtoZCourse() {
        //Get all the title of the courses and verify sorting is applied
        boolean sortedAlphabetically = sf.verifyAllAscendingOrderTittle();
        //Assert true if the all the courses sorted properly
        Assert.assertTrue(sortedAlphabetically);

    }

    @Test
    public void tc004_verifyAlphabeticalZtoADropdownValue() {
        //-------------Actions and Assertions-----------//
        //Click on filter icon to open a sort/filter Modal and print the title of the Modal
        sf.clickFilter();
        //Click on dropdown arrow to display and select a value from the list. Also print the selected value.
        boolean isSortValueSelected = sf.setAlphabeticalZADropdownValue();
        //validate the input shows the proper selected value.
        Assert.assertTrue(isSortValueSelected);
    }

    @Test
    public void tc005_verifyDashboardReload() {

        //Click on apply button to sort the courses based on the selected value
        sf.clickApply();
        //print the value of the header to verify if the page is landed on Dashboard after click on apply button
        Assert.assertTrue(sf.verifyLandedOnDashboard());
    }

    @Test
    public void tc006_verifyAlphabeticalZtoACourse() {
        //Get all the title of the courses and verify sorting is applied
        boolean sortedAlphabetically = sf.verifyAllDescendingOrderTittle();
        //Assert true if the all the courses sorted properly
        Assert.assertTrue(sortedAlphabetically);
    }

    @Test
    public void tc007_verifyDurationLowToHighDropdownValue() {
        //-------------Actions and Assertions-----------//
        //Click on filter icon to open a sort/filter Modal and print the title of the Modal
        sf.clickFilter();
        //Click on dropdown arrow to display and select a value from the list. Also print the selected value.
        boolean isSortValueSelected = sf.setDurationLowHighDropdownValue();
        //validate the input shows the proper selected value.
        Assert.assertTrue(isSortValueSelected);
    }

    @Test
    public void tc008_verifyDashboardReload() {

        //Click on apply button to sort the courses based on the selected value
        sf.clickApply();
        //print the value of the header to verify if the page is landed on Dashboard after click on apply button
        Assert.assertTrue(sf.verifyLandedOnDashboard());
    }

    @Test
    public void tc009_verifyDurationLowToHighCourse() {
        //Get all the title of the courses and verify sorting is applied
        boolean sorted = sf.verifyAllAscendingOrderDuration();
        //Assert true if the all the courses sorted properly
        Assert.assertTrue(sorted);

    }

    @Test
    public void tc010_verifyDurationHighToLowDropdownValue() {
        //-------------Actions and Assertions-----------//
        //Click on filter icon to open a sort/filter Modal and print the title of the Modal
        sf.clickFilter();
        //Click on dropdown arrow to display and select a value from the list. Also print the selected value.
        boolean isSortValueSelected = sf.setDurationHighLowDropdownValue();
        //validate the input shows the proper selected value.
        Assert.assertTrue(isSortValueSelected);
    }

    @Test
    public void tc011_verifyDashboardReload() {

        //Click on apply button to sort the courses based on the selected value
        sf.clickApply();
        //print the value of the header to verify if the page is landed on Dashboard after click on apply button
        Assert.assertTrue(sf.verifyLandedOnDashboard());
    }

    @Test
    public void tc012_verifyDurationHighToLowCourse() {
        //Get all the title of the courses and verify sorting is applied
        boolean sorted = sf.verifyAllDescendingOrderDuration();
        //Assert true if the all the courses sorted properly
        Assert.assertTrue(sorted);
    }


    @Test
    public void tc013_verifyDueDateOldToLatestDropdownValue() {
        //-------------Actions and Assertions-----------//
        //Click on filter icon to open a sort/filter Modal and print the title of the Modal
        sf.clickFilter();
        //Click on dropdown arrow to display and select a value from the list. Also print the selected value.
        boolean isSortValueSelected = sf.setDueDateOldLatestValue();
        //validate the input shows the proper selected value.
        Assert.assertTrue(isSortValueSelected);
    }

    @Test
    public void tc014_verifyDashboardReload() {

        //Click on apply button to sort the courses based on the selected value
        sf.clickApply();
        //print the value of the header to verify if the page is landed on Dashboard after click on apply button
        Assert.assertTrue(sf.verifyLandedOnDashboard());
    }

    @Test
    public void tc015_verifyDueDateOldToLatestCourse() {
        //Get all the title of the courses and verify sorting is applied
        boolean sorted = sf.verifyAllOldToLatestOrderDueDate();
        //Assert true if the all the date is sorted properly
        Assert.assertTrue(sorted);
    }

    @Test
    public void tc016_verifyDueDateLatestToOldDropdownValue() {
        //-------------Actions and Assertions-----------//
        //Click on filter icon to open a sort/filter Modal and print the title of the Modal
        sf.clickFilter();
        //Click on dropdown arrow to display and select a value from the list. Also print the selected value.
        boolean isSortValueSelected = sf.setDueDateLatestOldValue();
        //validate the input shows the proper selected value.
        Assert.assertTrue(isSortValueSelected);
    }

    @Test
    public void tc017_verifyDashboardReload()
    {

        //Click on apply button to sort the courses based on the selected value
        sf.clickApply();
        //print the value of the header to verify if the page is landed on Dashboard after click on apply button
        Assert.assertTrue(sf.verifyLandedOnDashboard());
    }

    @Test
    public void tc018_verifyDueDateLatestToOldCourse() {
        //Get all the title of the courses and verify sorting is applied
        boolean sorted = sf.verifyAllLatestToOldOrderDueDate();
        //Assert true if the all the courses sorted properly
        Assert.assertTrue(sorted);
    }

}
