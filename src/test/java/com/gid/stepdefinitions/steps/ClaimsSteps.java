package com.gid.stepdefinitions.steps;

import com.gid.pages.ClaimsPage;
import io.cucumber.java.en.And;
import net.serenitybdd.annotations.Step;

public class ClaimsSteps {

    ClaimsPage claimsPage;

    @Step("I perform the Claim Authorisation")
    public void iPerformTheClaimAuthorisation() {
        claimsPage.PerformTheClaimAuthorisation();
    }
}
