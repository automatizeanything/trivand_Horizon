package com.horizon.stepdefinitions;


import com.horizon.pages.handler.ClaimsPage_handler;
import com.horizon.stepdefinitions.steps.Handler_ClaimsSteps;
import io.cucumber.java.en.And;
import net.serenitybdd.annotations.Steps;

public class Handler_ClaimsPageSteps {

    @Steps
    Handler_ClaimsSteps claimsSteps;

    @And("I perform the Claim Authorisation")
    public void iPerformTheClaimAuthorisation() {
        claimsSteps.iPerformTheClaimAuthorisation();
    }

    @And("I open the created claim")
    public void iOpenTheCreatedClaim() {
        claimsSteps.OpenTheCreatedClaim();
    }

    @And("I update the authorization details")
    public void iUpdateTheAuthorizationDetails() {
        claimsSteps.UpdateTheAuthorizationDetails();
    }
}
