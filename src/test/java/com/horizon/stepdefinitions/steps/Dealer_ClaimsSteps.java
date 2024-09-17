package com.horizon.stepdefinitions.steps;

import com.horizon.pages.dealer.Dealer_ClaimsPage;
import io.cucumber.datatable.DataTable;
import net.serenitybdd.annotations.Step;

public class Dealer_ClaimsSteps {

    Dealer_ClaimsPage claimsPage;

    @Step("Save a new claim as draft")
    public void ISaveClaimAsDraft(DataTable claimDetails) {
        claimsPage.saveAClaimAsDraft(claimDetails);
    }
    @Step("Add Vehicle details")
    public void addVehicleDetails(DataTable claimDetails) {
        claimsPage.addVehicleDetails(claimDetails);
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
    public void IHavAddedDamageItems(DataTable damageItems) {
        claimsPage.addDamageItems(damageItems);
    }
    @Step("Add damage Items estimate details")
    public void IHavAddedDamageItemsEstimateDetails(DataTable damageItemsEstimateDetails) {
        claimsPage.addDamageItemsEstimate(damageItemsEstimateDetails);
    }
    @Step("Save damage Items estimate details as draft")
    public void IHavSaveDamageItemsEstimateDetailsAsDraft(DataTable damageItemsEstimateDetails) {
        claimsPage.saveDamageItemsEstimateAsDraft(damageItemsEstimateDetails);
    }
    @Step("Navigate to Document upload page and upload documents")
    public void iNavigateDocumentUpdatePage() {
        claimsPage.navigateToDocumentsUploadPageAndUpload();
    }
    @Step("I submit claim")
    public void iSubmitClaim() {
        claimsPage.submitClaim();
    }
    @Step("I try to submit claim")
    public void iTryToSubmitClaim() {
        claimsPage.tryToSubmitClaim();
    }
    @Step("I verify claim summary table")
    public void verifyClaimSummaryTable(String claimStatus) {
        claimsPage.verifyClaimSummary(claimStatus);
    }
    @Step("I verify claim summary table")
    public void verifyClaimChallengeDialogBoxAndSelectOption(String option) {
        claimsPage.verifyClaimChallengeDialogBoxAndSelectOption(option);
    }
    @Step("Add documents to claim")
    public void addDocumentsToClaim() {
        claimsPage.addDocumentsToClaim();
    }
    @Step("Add invoice to claim")
    public void addInvoice() {
        claimsPage.addInvoice();
    }
    @Step("Navigate to add invoice page")
    public void navigateToAddInvoice() {
        claimsPage.navigateToAddInvoice();
    }
    @Step("Verify invoice creation")
    public void verifyInvoiceCreation() {
        claimsPage.verifyInvoiceCreation();
    }
    @Step("Verify claim summary")
    public void verifyClaimSummary() {
        claimsPage.verifyClaimSummary();
    }
    @Step("Verify invoiced details")
    public void verifyInvoiceDetails() {
        claimsPage.verifyInvoiceDetails();
    }
}