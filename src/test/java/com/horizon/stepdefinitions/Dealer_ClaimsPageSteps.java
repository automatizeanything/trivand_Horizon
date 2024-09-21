package com.horizon.stepdefinitions;

import com.horizon.pages.dealer.Dealer_DashBoardPage;
import com.horizon.stepdefinitions.steps.Dealer_ClaimsSteps;
import io.cucumber.java.en.And;
import net.serenitybdd.annotations.Steps;

public class Dealer_ClaimsPageSteps {

    @Steps
    Dealer_ClaimsSteps claimsSteps;

    @Steps
    Dealer_DashBoardPage dashBoardPageSteps;

    @And("I save a new claim for {string} as draft")
    public void iSaveANewClaimAsDraft(String brandName) {
        claimsSteps.ISaveClaimAsDraft(brandName);
    }

    @And("I create a new claim for {string} and submit it for approval")
    public void iCreateANewClaimAndSubmitForApproval(String brandName) {
        claimsSteps.ICreateNewClaim(brandName);
    }
    @And("I navigate to My Claims page and validated the claims details with status {string}")
    public void iHaveValidatedClaimsDetailsInMyClaimsPage(String claimStatus) {
        claimsSteps.IVerifyClaimStatus(claimStatus);
    }
    @And("I navigate back to Claims Edit page continue the editing")
    public void iNavigateBackToClaimsEditPageContinueTheEditing() {
        claimsSteps.ISelectClaimAndEdit();
    }
    @And("I have added damage item details")
    public void iHaveAddedDamageItemDetails() {
        claimsSteps.IHavAddedDamageItems();
    }


}