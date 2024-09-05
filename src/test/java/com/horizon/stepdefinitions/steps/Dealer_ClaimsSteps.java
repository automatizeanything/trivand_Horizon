package com.horizon.stepdefinitions.steps;

import com.horizon.pages.dealer.Dealer_ClaimsPage;
import net.serenitybdd.annotations.Step;

public class Dealer_ClaimsSteps {

    Dealer_ClaimsPage claimsPage;

    @Step("Save a new claim for {string} as draft")
    public void ISaveClaimAsDraft(String brandName) {
        claimsPage.saveAClaimAsDraft(brandName);
    }
    @Step("Create a new claim for {string}")
    public void ICreateNewClaim(String brandName) {
        claimsPage.createAClaim(brandName);
    }
    @Step("Verify a claim status as {string}")
    public void IVerifyClaimStatus(String claimStatus) {
        claimsPage.verifyClaimStatusInClaimListingPage(claimStatus);
    }
    @Step("Select Claim and Edit")
    public void ISelectClaimAndEdit() {
        claimsPage.selectClaimInDraftAndEdit();
    }
    @Step("Add damage Items")
    public void IHavAddedDamageItems() {
        claimsPage.addDamageItems();
    }
}