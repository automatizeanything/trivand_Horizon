package com.horizon.stepdefinitions.steps;

import com.horizon.pages.dealer.Dealer_DashBoardPage;
import net.serenitybdd.annotations.Step;

public class Dealer_DashBoardSteps {

    Dealer_DashBoardPage dashBoardPage;

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
    @Step("I select the claimID from filter")
    public void selectClaimIDFromFilter(String claimID, String filterType) {
        dashBoardPage.selectClaimIDFromFilter(claimID, filterType);
    }
}