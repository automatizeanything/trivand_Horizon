package com.horizon.stepdefinitions;

import com.horizon.pages.dealer.Dealer_DashBoardPage;
import com.horizon.stepdefinitions.steps.Dealer_ClaimsSteps;
import io.cucumber.datatable.DataTable;
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
    @And("I have added vehicle details for {string}")
    public void iAddVehicleDetailsForClaim(String brandName) {
        claimsSteps.addVehicleDetails(brandName);
    }
    @And("I navigate to My Claims page and validate the claims details with status {string}")
    public void iHaveValidatedClaimsDetailsInMyClaimsPage(String claimStatus) {
        claimsSteps.IVerifyClaimStatus(claimStatus);
    }
    @And("I navigate back to Claims Edit page continue the editing")
    public void iNavigateBackToClaimsEditPageContinueTheEditing() {
        claimsSteps.ISelectClaimAndEdit();
    }
    @And("I add the damage item details")
    public void iHaveAddedDamageItemDetails(DataTable damageItems) {
        claimsSteps.IHavAddedDamageItems(damageItems);
    }
    @And("I have added damage item estimate details")
    public void iHaveAddedDamageItemEstimateDetails(DataTable damageItemsEstimateDetails) {
        claimsSteps.IHavAddedDamageItemsEstimateDetails(damageItemsEstimateDetails);
    }
    @And("I save the damage item estimate details as a draft")
    public void iSaveDamageItemEstimateDetailsAsDraft(DataTable damageItemsEstimateDetails) {
        claimsSteps.IHavSaveDamageItemsEstimateDetailsAsDraft(damageItemsEstimateDetails);
    }
    @And("I navigate Documents Upload page and upload documents")
    public void iNavigateDocumentsUpdatePage() {
        claimsSteps.iNavigateDocumentUpdatePage();
    }
    @And("I submit the claim")
    public void iSubmitClaim() {
        claimsSteps.iSubmitClaim();
    }
    @And("I verify that the claim summary table has a status of {string}")
    public void iVerifyClaimSummaryTableHavingStatus(String claimStatus) {
        claimsSteps.verifyClaimSummaryTable(claimStatus);
    }
}