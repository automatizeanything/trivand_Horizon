package com.gid.stepdefinitions;

import com.gid.stepdefinitions.steps.AdminDashBoardSteps;
import com.gid.stepdefinitions.steps.LoginSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.annotations.Steps;

public class AdminDashboardPageSteps {

    @Steps
    AdminDashBoardSteps adminDashBoardSteps;

    @Steps
    LoginSteps loginSteps;

    @Then("I can navigate to admin dashboard page")
    public void navigateToAdminDashBoard() {
        adminDashBoardSteps.waitForAdminDashBoard();
    }

    @Then("System should display all the details based on the {string} search")
    public void systemShouldDisplayAllTheDetailsBasedOnTheSearch(String SearchType) {
        adminDashBoardSteps.systemShouldDisplayAllTheDetailsBasedOnTheSearch(SearchType);
    }

    @And("I perform a {string} Search with value {string} from Home page")
    public void iPerformASearchWithValueFromHomePage(String SearchType, String value) {
        adminDashBoardSteps.iPerformASearchFromHomePage(SearchType,value);
    }
}