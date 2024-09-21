package com.horizon.stepdefinitions.steps;

import com.horizon.pages.handler.ClaimsPage_handler;
import io.cucumber.java.en.And;
import net.serenitybdd.annotations.Step;

public class Handler_ClaimsSteps {

    ClaimsPage_handler claimsPage;

    @Step("I perform the Claim Authorisation")
    public void iPerformTheClaimAuthorisation() {
        claimsPage.PerformTheClaimAuthorisation();
    }
    @Step("I open the created claim")
    public void OpenTheCreatedClaim() {
        claimsPage.openTheCreateClaim();
    }
    @Step("I Update The Authorization Details")
    public void UpdateTheAuthorizationDetails() {
        claimsPage.UpdateTheAuthorizationDetails();
    }
}
