package com.horizon.stepdefinitions;

import com.horizon.pages.dealer.Dealer_DashBoardPage;
import com.horizon.stepdefinitions.steps.Dealer_ClaimsSteps;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.annotations.Steps;

public class Dealer_ClaimsPageSteps {

    @Steps
    Dealer_ClaimsSteps claimsSteps;

    @Steps
    Dealer_DashBoardPage dashBoardPageSteps;

    @And("I save a new claim as draft")
    public void iSaveANewClaimAsDraft(DataTable claimDetails) {
        claimsSteps.ISaveClaimAsDraft(claimDetails);
    }
    @And("I have added vehicle details")
    public void iAddVehicleDetailsForClaim(DataTable claimDetails) {
        claimsSteps.addVehicleDetails(claimDetails);
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
    @And("I try to submit the claim")
    public void iTryToSubmitClaim() {
        claimsSteps.iTryToSubmitClaim();
    }
    @And("I verify that the claim summary table has a status of {string}")
    public void iVerifyClaimSummaryTableHavingStatus(String claimStatus) {
        claimsSteps.verifyClaimSummaryTable(claimStatus);
    }
    @Then("Claim challenge dialog box should be displayed and I select {string} option")
    public void claimChallengeDialogBoxShouldBeDisplayed(String option) {
        claimsSteps.verifyClaimChallengeDialogBoxAndSelectOption(option);
    }
    @And("I add documents to the claim")
    public void addDocumentsToClaim() {
        claimsSteps.addDocumentsToClaim();
    }
    @And("I add invoice for the claim")
    public void addInvoice() {
        claimsSteps.addInvoice();
    }
    @And("I navigate to add invoice page")
    public void navigateToAddInvoice() {
        claimsSteps.navigateToAddInvoice();
    }
    @Then("The invoice creation should be successful")
    public void verifyInvoiceCreation() {
        claimsSteps.verifyInvoiceCreation();
    }
    @And("I verify the claim details in claim summary page")
    public void verifyClaimSummary() {
        claimsSteps.verifyClaimSummary();
    }
    @And("I verify the details in invoice page")
    public void verifyInvoiceDetails() {
        claimsSteps.verifyInvoiceDetails();
    }


}