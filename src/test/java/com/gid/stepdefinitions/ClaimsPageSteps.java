package com.gid.stepdefinitions;

import com.gid.stepdefinitions.steps.ClaimsSteps;
import com.gid.stepdefinitions.steps.HomeSteps;
import io.cucumber.java.en.And;
import net.serenitybdd.annotations.Steps;

public class ClaimsPageSteps {

    @Steps
    ClaimsSteps claimsSteps;

    @And("I perform the Claim Authorisation")
    public void iPerformTheClaimAuthorisation() {
        claimsSteps.iPerformTheClaimAuthorisation();
    }
}
