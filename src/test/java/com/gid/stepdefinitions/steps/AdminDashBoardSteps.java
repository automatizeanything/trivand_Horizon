package com.gid.stepdefinitions.steps;

import com.gid.pages.DashBoardPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.annotations.Step;

public class AdminDashBoardSteps {

    DashBoardPage dashBoardPage;

    @Step("Navigate to dealer dashboard")
    public void waitForAdminDashBoard() {
        dashBoardPage.waitForDashBoard();
    }
    @Step("I perform a {string} Search from Home page")
    public void iPerformASearchFromHomePage(String SearchType,String value) {
        dashBoardPage.performGlobalSearch(SearchType,value);
    }
    @Step("System should display all the details based on the {string} search")
    public void systemShouldDisplayAllTheDetailsBasedOnTheSearch(String SearchType) {
        dashBoardPage.verifyTheDetailsDisplayed(SearchType);
    }
    @Step("Navigate to {string} Page")
    public void navigateToPage(String pageName) {
        dashBoardPage.navigateToSpecificPage(pageName);
    }
    @Step("Verify Dealer Dashboard Page")
    public void IVerifyDealerDashboardPage() {
        dashBoardPage.verifyDealerDashBoardPage();
    }
    @Step("Validate Specific filter details")
    public void validateFilterDetails(String filterType) {
        dashBoardPage.validateSpecificFilterDetails(filterType);
    }
}