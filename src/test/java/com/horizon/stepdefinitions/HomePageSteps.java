package com.horizon.stepdefinitions;

import com.horizon.stepdefinitions.steps.HomeSteps;
import io.cucumber.java.en.And;
import net.serenitybdd.annotations.Steps;

public class HomePageSteps {

    @Steps
    HomeSteps homeSteps;

    @And("I navigate to the {string} subtab in {string} tab")
    public void iNavigateToTheSubtabInTab(String SubTab, String Tab) {
        homeSteps.NavigateToSubtabs(SubTab,Tab);
    }

    @And("I choose the {string} widget")
    public void iChooseTheWidget(String widgetName) {
        homeSteps.iChooseTheWidget(widgetName);
    }

    @And("I performed Logout")
    public void iPerformedLogout() {
        homeSteps.performLogout();
    }
}
