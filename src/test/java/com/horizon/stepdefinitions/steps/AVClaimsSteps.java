package com.horizon.stepdefinitions.steps;

import com.horizon.pages.AV.AV_ClaimsPage;
import com.horizon.pages.handler.ClaimsPage_handler;
import io.cucumber.java.en.And;
import net.serenitybdd.annotations.Step;

public class AVClaimsSteps {

    AV_ClaimsPage av_ClaimsPage;
    ClaimsPage_handler claimsPage_handler;

    @Step("AV update the parts value to {string}")
    public void avUpdateThePartsValueTo(String partsvalue) {
        av_ClaimsPage.updateEstimatesByAV(partsvalue);
    }

    @Step("I verify the AV updated value is reflected in the claim")
    public void iVerifyTheAVUpdatedValueIsReflectedInTheClaim() {
        claimsPage_handler.verifyAVUpdatedValue();
    }
}
