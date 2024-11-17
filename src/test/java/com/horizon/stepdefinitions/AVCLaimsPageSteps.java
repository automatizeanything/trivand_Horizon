package com.horizon.stepdefinitions;

import com.horizon.stepdefinitions.steps.AVClaimsSteps;
import com.horizon.stepdefinitions.steps.Handler_ClaimsSteps;
import io.cucumber.java.en.And;
import net.serenitybdd.annotations.Steps;

public class AVCLaimsPageSteps {

    @Steps
    AVClaimsSteps avClaimsSteps;

    @And("AV update the parts value to {string}")
    public void avUpdateThePartsValueTo(String partsvalue) {
        avClaimsSteps.avUpdateThePartsValueTo(partsvalue);
    }

    @And("I verify the AV updated value is reflected in the claim")
    public void iVerifyTheAVUpdatedValueIsReflectedInTheClaim() {
        avClaimsSteps.iVerifyTheAVUpdatedValueIsReflectedInTheClaim();
    }
}
