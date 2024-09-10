package com.horizon.stepdefinitions.steps;

import com.horizon.pages.dealer.Dealer_ClaimsPage;
import io.cucumber.datatable.DataTable;
import net.serenitybdd.annotations.Step;

public class Dealer_ClaimsSteps {

    Dealer_ClaimsPage claimsPage;

    @Step("Save a new claim for {string} as draft")
    public void ISaveClaimAsDraft(String brandName) {
        claimsPage.saveAClaimAsDraft(brandName);
    }
    @Step("Add Vehicle details for {string}")
    public void addVehicleDetails(String brandName) {
        claimsPage.addVehicleDetails(brandName);
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
    @Step("I verify claim summary table")
    public void verifyClaimSummaryTable(String claimStatus) {
        claimsPage.verifyClaimSummary(claimStatus);
    }
}