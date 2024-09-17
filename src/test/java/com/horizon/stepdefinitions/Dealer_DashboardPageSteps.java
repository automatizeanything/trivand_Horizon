package com.horizon.stepdefinitions;

import com.horizon.stepdefinitions.steps.Dealer_DashBoardSteps;
import com.horizon.stepdefinitions.steps.LoginSteps;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.annotations.Steps;

public class Dealer_DashboardPageSteps {

    @Steps
    Dealer_DashBoardSteps dashBoardSteps;

    @Steps
    LoginSteps loginSteps;

    @Then("I can navigate to dealer dashboard page")
    public void navigateToDealerDashBoard() {
        dashBoardSteps.waitForAdminDashBoard();
    }
    @And("I navigate to {string} page")
    public void navigateToSpecificPage(String pageName) {
        dashBoardSteps.navigateToPage(pageName);
    }
    @Then("System should display all the details based on the {string} search")
    public void systemShouldDisplayAllTheDetailsBasedOnTheSearch(String SearchType) {
        dashBoardSteps.systemShouldDisplayAllTheDetailsBasedOnTheSearch(SearchType);
    }
    @And("I perform a {string} Search with value {string} from Home page")
    public void iPerformASearchWithValueFromHomePage(String SearchType, String value) {
        dashBoardSteps.iPerformASearchFromHomePage(SearchType,value);
    }
    @And("I verify the details on the dealer dashboard page")
    public void iVerifyDetailsInDealerDashboardPage() {
        dashBoardSteps.IVerifyDealerDashboardPage();
    }
    @And("I validate the {string} fitter details in Dashboard")
    public void iHaveValidatedFitterDetailsInDashboard(String filterType) {
        dashBoardSteps.validateFilterDetails(filterType);
    }
    @And("I select the claimID {string} from {string} page")
    public void selectClaimIDFromFilter(String claimID, String filterType) {
        dashBoardSteps.selectClaimIDFromFilter(claimID, filterType);
    }
}