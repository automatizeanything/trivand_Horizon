package com.horizon.pages.dealer;

import com.horizon.utility.CommonMethods;
import com.horizon.utility.Constant;
import io.cucumber.datatable.DataTable;
import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

@DefaultUrl("/#/vehicle_details")
public class Dealer_ClaimsPage extends PageObject {

    private @FindBy(xpath = "//div/a[contains(text(),'Create New Claim')]")
    WebElementFacade createNewClaimBtn;
    private @FindBy(xpath = "//div[contains(@class,'sidebar-nav')]/ul/li")
    WebElementFacade createClaimPageTitle;
    private @FindBy(xpath = "//h3/span")
    WebElementFacade createClaimPageBrandName;
    private @FindBy(xpath = "//h3/span[2]")
    WebElementFacade claimStatus;
    private @FindBy(xpath = "//h3/span[3]")
    WebElementFacade claimSourceDetail;
    private @FindBy(xpath = "//div[contains(@class,'sidebar')]/ul/li[2]")
    WebElementFacade vehicleSideBarLink;
    private @FindBy(xpath = "//div[contains(@class,'sidebar')]/ul/li[3]")
    WebElementFacade damageItemsSideBarLink;
    private @FindBy(xpath = "//div[contains(@class,'sidebar')]/ul/li[4]")
    WebElementFacade documentsSideBarLink;
    private @FindBy(xpath = "//button[contains(text(),'Ready for Submission')]")
    WebElementFacade readyForSubmissionBtn;
    private @FindBy(xpath = "//a[contains(text(),'Ready for Submission')]")
    WebElementFacade readyForSubmissionBtn_enabled;
    private @FindBy(xpath = "//input[contains(@value,'Next')]")
    WebElementFacade nextBtn;
    private @FindBy(id = "vin")
    WebElementFacade vinTxtFld;
    private @FindBy(xpath = "//select[@id='manufacturer_id']")
    WebElementFacade manufactureSelectDrpDwn;
    private @FindBy(xpath = "//input[@id='model_name']")
    WebElementFacade modelNameFld;
    private @FindBy(id = "cached_vehicle_spec")
    WebElementFacade vehicleSpecTxtFld;
    private @FindBy(css = ".icon-calendar")
    WebElementFacade calenderIcon;
    private @FindBy(xpath = "//div[3]/table/thead/tr/th/i")
    WebElementFacade calenderIconArrowLeft;

    private @FindBy(xpath = "//tbody/tr/td[@class='day']")
    List<WebElementFacade> calendarDaysList;

    private @FindBy(xpath = "//input[@id='cached_vehicle_arrival_date']")
    WebElementFacade arrivalDateTxtFld;
    private @FindBy(xpath = "//a[contains(@class,'open-btn')]")
    WebElementFacade modalFldDropDown;
    private @FindBy(xpath = "//input[contains(@placeholder,'Search Claims')]")
    WebElementFacade claimSearchField;
    private @FindBy(xpath = "//button/i[contains(@class,'icon-search')]")
    WebElementFacade claimSearchBtn;
    private @FindBy(xpath = "//table/tbody/tr")
    List<WebElementFacade> claimsList;
    private @FindBy(xpath = "//table/tbody/tr/td[2]/a[2] | //table/tbody/tr/td[2]/a")
    WebElementFacade claimIdFld;
    private @FindBy(xpath = "//table/tbody/tr/td[3]")
    WebElementFacade brandNameFld;
    private @FindBy(xpath = "//table/tbody/tr/td[4]")
    WebElementFacade vinValueFld;
    private @FindBy(xpath = "//table/tbody/tr/td[5]")
    WebElementFacade claimStatusFld;
    private @FindBy(id = "client_name")
    WebElementFacade clientNameFld;
    private @FindBy(id = "dealer_brand")
    WebElementFacade dealerBrandFld;
    private @FindBy(xpath = "//div/div[contains(@class,'title')]")
    WebElementFacade damageItemsPageHeader;
    private @FindBy(xpath = "//div[contains(@class,'alert-info')]")
    WebElementFacade damageItemsPageInfo;
    private @FindBy(xpath = "//div[@id='damage']/fieldset/div/div/a")
    WebElementFacade damageLocationDropDown;
    private @FindBy(xpath = "//input[@id='damage_location_name']")
    WebElementFacade damageLocationDropDownField;

    private @FindBy(xpath = "//span[@id='damage-location-help-inline']/i")
    WebElementFacade damageLocationDropDownTickIcon;
    private @FindBy(xpath = "//div[@id='damage']/fieldset/div[2]/div/a/i")
    WebElementFacade damageTypeDropDown;
    private @FindBy(xpath = "//input[@id='damage_type_name']")
    WebElementFacade damageTypeDropDownField;

    private @FindBy(xpath = "//span[@id='damage-type-help-inline']/i")
    WebElementFacade damageTypeDropDownTickIcon;
    private @FindBy(xpath = "//div[@id='damage']/fieldset/div[3]/div/a/i")
    WebElementFacade repairMethodDropDown;
    private @FindBy(xpath = "//input[@id='repair_method_label']")
    WebElementFacade repairMethodDropDownField;
    private @FindBy(xpath = "//div[@id='damage']/fieldset/div[4]/div/a/i")
    WebElementFacade severityLevelDropDown;
    private @FindBy(xpath = "//input[@id='severity_level_label']")
    WebElementFacade severityLevelDropDownField;
    private @FindBy(id = "damage_item_estimates_attributes_0_estimate_no")
    WebElementFacade estimateNumberField;
    private @FindBy(xpath = "//input[contains(@id,'damage_item_estimates_attributes_0_estimate_date')]")
    WebElementFacade estimateDateField;
    private @FindBy(id = "damage_item_estimates_attributes_0_estimated_labour_repair_hours")
    WebElementFacade estimatedLabourRepairHoursField;
    private @FindBy(id = "damage_item_estimates_attributes_0_estimated_labour_repair_rate")
    WebElementFacade estimatedLabourRepairRateField;
    private @FindBy(id = "damage_item_estimates_attributes_0_estimated_paint_labour_repair_hours")
    WebElementFacade estimatedPaintLabourRepairHoursField;
    private @FindBy(xpath = "//input[contains(@id,'total_estimated_labour_cost')]")
    WebElementFacade totalEstimatedLabourCostField;
    private @FindBy(id = "damage_item_estimates_attributes_0_estimated_parts_repair_cost")
    WebElementFacade estimatedPartsRepairCostField;
    private @FindBy(id = "damage_item_estimates_attributes_0_estimated_materials_repair_cost")
    WebElementFacade estimatedMaterialsRepairCostField;
    private @FindBy(id = "damage_item_estimates_attributes_0_estimated_other_repair_cost")
    WebElementFacade estimatedOtherRepairCostField;
    private @FindBy(id = "damage_item_estimates_attributes_0_estimated_other_repair_cost_description")
    WebElementFacade estimatedOtherRepairCostDescriptionField;
    private @FindBy(id = "damage_item_estimates_attributes_0_estimated_total_repair_cost")
    WebElementFacade estimatedTotalRepairCostField;
    private @FindBy(id = "submit_bttn")
    WebElementFacade createButton;
    private @FindBy(id = "add-di-dialog")
    WebElementFacade addAnotherDamageItemsConfirmPopup;
    private @FindBy(xpath = "//div[contains(@class,'modal-footer')]/a")
    WebElementFacade yesBtn;
    private @FindBy(xpath = "//div[contains(@class,'modal-footer')]/a[2]")
    WebElementFacade noBtn;
    private @FindBy(xpath = "//div[@id='declarationModal']/div")
    WebElementFacade claimCreationDeclarationPopup;
    private @FindBy(id = "dealer_terms")
    WebElementFacade dealerTermsCheckBox;
    private @FindBy(id = "declaration")
    WebElementFacade dealerTermsPopupSaveBtn;
    private @FindBy(xpath = "//tbody/tr[contains(@id,'claim')]")
    List<WebElementFacade> damageItemsList;
    private @FindBy(xpath = "//span[contains(text(),'Damage ID: ')]/strong")
    WebElementFacade damageIdFld;
    private @FindBy(xpath = "//div[contains(@class,'status-description')]/span")
    WebElementFacade claimStatusDescription;
    private @FindBy(id = "fileupload")
    WebElementFacade documentUploadLink;
    private @FindBy(xpath = "//img[contains(@alt,'pdf')]")
    WebElementFacade uploadedImage;
    private @FindBy(xpath = "//div[contains(@class,'alert-info')]")
    WebElementFacade claimSubmissionConfirmationMessage;
    private @FindBy(xpath = "(//a[contains(text(),'Home')])[2]")
    WebElementFacade backToHomeButton;








    CommonMethods commonMethods = new CommonMethods();
    Dealer_DashBoardPage dashBoardPage = new Dealer_DashBoardPage();


    public void waitForClaimCreationPage() {
        waitForCondition().until(
                ExpectedConditions.visibilityOf(createClaimPageTitle)
        );
    }

    public void saveAClaimAsDraft(String brandName) {
        waitFor(createNewClaimBtn);
        createNewClaimBtn.click();
        verifyClaimCreationPageHeaderDetails("Vehicle", "Open");
        verifySideBarVerification("Vehicle");
        updateVehicleDetails();
    }

    private void updateVehicleDetails() {
        verifyFieldValidationsVehicleDetailsPage();
        nextBtn.click();
    }

    private void verifyFieldValidationsVehicleDetailsPage() {
        waitFor(nextBtn);
        typeInto(vinTxtFld, "2FM");
        nextBtn.click();
        commonMethods.verifyValidationMessage(Constant.VIN_VALIDATION_MESSAGE);
        String vin = commonMethods.randomNumbergenerator(17).toUpperCase();
        typeInto(vinTxtFld, vin);
        Serenity.setSessionVariable("vin").to(vin);
        vehicleSpecTxtFld.click();
        nextBtn.click();
        commonMethods.verifyValidationMessage(Constant.ARRIVAL_DATE_VALIDATION_MESSAGE);
        selectArrivalDate();
        waitABit(4000);
        vinTxtFld.click();
        commonMethods.clickWithJavaScript(nextBtn);
        commonMethods.verifyValidationMessage(Constant.MODEL_VALIDATION_MESSAGE);
        commonMethods.selectDropdownValueAtRuntime(modalFldDropDown);
        Serenity.setSessionVariable("model").to(modelNameFld.getAttribute("value").trim());
    }

    private void verifySideBarVerification(String subPage) {
        if (subPage.equals("Vehicle")) {
            waitFor(vehicleSideBarLink);
            assertThat(vehicleSideBarLink.getAttribute("class")).as("Vehicle Sidebar link is not active in Vehicle details submission page")
                    .isEqualTo("active");
            assertThat(damageItemsSideBarLink.findElement(By.xpath("./span")).getAttribute("class")).as("Damage Items Sidebar link is not disabled in Vehicle details submission page")
                    .contains("disabled");
            assertThat(documentsSideBarLink.findElement(By.xpath("./span")).getAttribute("class")).as("Documents Sidebar link is not disabled in Vehicle details submission page")
                    .contains("disabled");
            assertThat(readyForSubmissionBtn.getAttribute("class")).as("Ready For Submission Button is not disabled in Vehicle details submission page")
                    .contains("disabled");
        } else if (subPage.equals("Vehicle_EditMode")) {
            waitFor(vehicleSideBarLink);
            assertThat(vehicleSideBarLink.findElement(By.xpath(".//a")).getAttribute("href")).as("Vehicle Sidebar link is not active in Damage Items details submission page")
                    .contains("vehicle/edit");
            assertThat(vehicleSideBarLink.findElement(By.xpath(".//a/i[contains(@class,'icon-ok')]")).isDisplayed()).as("Vehicle Sidebar link : Tick Icon is missing")
                    .isTrue();
            assertThat(damageItemsSideBarLink.findElement(By.xpath(".//a")).getAttribute("href")).as("Damage Items Sidebar link is not enabled in Damage Items details submission page")
                    .contains("damage_items");
            assertThat(documentsSideBarLink.findElement(By.xpath("./span")).getAttribute("class")).as("Documents Sidebar link is not disabled in Damage Items details submission page")
                    .contains("disabled");
            assertThat(readyForSubmissionBtn.getAttribute("class")).as("Ready For Submission Button is not disabled in Damage Items details submission page")
                    .contains("disabled");
            assertThat(clientNameFld.getAttribute("value").trim()).as("Client Name is not correct. Actual : " + clientNameFld.getText().trim() + ". Expected : " + Constant.BENTLEY_MOTORS)
                    .isEqualTo(Constant.BENTLEY_MOTORS);
            assertThat(clientNameFld.getAttribute("autocomplete").equals("off")).as("Client Name is editable. It should be non editable.").isTrue();
            assertThat(dealerBrandFld.getAttribute("value").trim()).as("Dealer Brand Name is not correct. Actual : " + dealerBrandFld.getText().trim() + ". Expected : " + Serenity.sessionVariableCalled("brandName"))
                    .isEqualTo(Serenity.sessionVariableCalled("brandName"));
            assertThat(dealerBrandFld.getAttribute("readonly").equals("true")).as("Dealer Brand Name Field is editable. It should be non editable.").isTrue();
        }  else if (subPage.equals("Damage Items")) {
            waitFor(vehicleSideBarLink);
            assertThat(vehicleSideBarLink.findElement(By.xpath(".//a")).getAttribute("href")).as("Vehicle Sidebar link is not active in Damage Items details submission page")
                    .contains("vehicle/edit");
            assertThat(vehicleSideBarLink.findElement(By.xpath(".//a/i[contains(@class,'icon-ok')]")).isDisplayed()).as("Vehicle Sidebar link : Tick Icon is missing")
                    .isTrue();
            assertThat(damageItemsSideBarLink.findElement(By.xpath(".//a")).getAttribute("href")).as("Damage Items Sidebar link is not enabled in Damage Items details submission page")
                    .contains("damage_items");
            assertThat(documentsSideBarLink.findElement(By.xpath("./span")).getAttribute("class")).as("Documents Sidebar link is not disabled in Damage Items details submission page")
                    .contains("disabled");
            assertThat(readyForSubmissionBtn.getAttribute("class")).as("Ready For Submission Button is not disabled in Damage Items details submission page")
                    .contains("disabled");
        } else if (subPage.equals("Damage Items_EditMode") || subPage.equals("Documents")) {
            waitFor(vehicleSideBarLink);
            waitABit(2000);
            assertThat(vehicleSideBarLink.findElement(By.xpath(".//a")).getAttribute("href")).as("Vehicle Sidebar link is not active in Documents details submission page")
                    .contains("vehicle/edit");
            assertThat(vehicleSideBarLink.findElement(By.xpath(".//a/i[contains(@class,'icon-ok')]")).isDisplayed()).as("Vehicle Sidebar link : Tick Icon is missing")
                    .isTrue();
            waitABit(2000);
            assertThat(damageItemsSideBarLink.findElement(By.xpath(".//a")).getAttribute("href")).as("Damage Items Sidebar link is not enabled in Documents details submission page")
                    .contains("damage_items");
            assertThat(damageItemsSideBarLink.findElement(By.xpath(".//a/i[contains(@class,'icon-ok')]")).isDisplayed()).as("Damage Items Sidebar link : Tick Icon is missing")
                    .isTrue();
            waitABit(2000);
            assertThat(documentsSideBarLink.findElement(By.xpath(".//a")).getAttribute("href")).as("Documents Sidebar link is not enabled in Documents details submission page")
                    .contains("documents");
            assertThat(readyForSubmissionBtn.getAttribute("class")).as("Ready For Submission Button is not disabled in Documents details submission page")
                    .contains("disabled");
        } else if (subPage.equals("Documents_Uploaded")) {
            assertThat(documentsSideBarLink.findElement(By.xpath(".//a")).getAttribute("href")).as("Documents Sidebar link is not enabled in Documents details submission page")
                    .contains("documents");
            assertThat(documentsSideBarLink.findElement(By.xpath(".//a/i[contains(@class,'icon-ok')]")).isDisplayed()).as("Documents Sidebar link : Tick Icon is missing")
                    .isTrue();
            assertThat(readyForSubmissionBtn_enabled.getAttribute("class")).as("Ready For Submission Button is not enabled even after submitting the document")
                    .contains("btn-success");
        }
    }

    private void verifyClaimCreationPageHeaderDetails(String subPage, String claimsStatus) {
        waitForClaimCreationPage();
        assertThat(createClaimPageTitle.getText().trim().equals("CREATE NEW CLAIM"))
                .as("Create a claim - Page header is missing").isTrue();
        assertThat(createClaimPageBrandName.getText().contains(Serenity.sessionVariableCalled("brandName").toString()))
                .as("Claim Creation | " + subPage + " - Manufacture Name is missing in " + subPage + "page").isTrue();
        assertThat(claimStatus.getText().contains(claimsStatus))
                .as("Claim Creation | " + subPage + " - Claim status is not correct in " + subPage + "page. Current status is " + claimStatus.getText()).isTrue();
        if (subPage.equals("Vehicles"))
            assertThat(claimSourceDetail.getText().contains("Claim Source "))
                    .as("Clam Creation | " + subPage + " - Claim source is not correct in " + subPage + "page. Current claim source is " + claimSourceDetail.getText()).isTrue();
        if (subPage.equals("Damage Items")) {
            assertThat(createClaimPageBrandName.getText().contains(Serenity.sessionVariableCalled("vin").toString()))
                    .as("Claim Creation | " + subPage + " - VIN detail is not correct in " + subPage + "page.").isTrue();
            assertThat(createClaimPageBrandName.getText().contains(Serenity.sessionVariableCalled("claimId").toString()))
                    .as("Claim Creation | " + subPage + " - Claim ID detail is not correct in " + subPage + "page.").isTrue();
        }
    }

    private void selectArrivalDate() {
        waitFor(calenderIcon);
        calenderIcon.click();
        waitFor(calenderIconArrowLeft);
        selectSpecificDate();
        waitFor("//div[2]/table/tbody/tr/td/span[10]");
        getDriver().findElement(By.xpath("//div[2]/table/tbody/tr/td/span[10]")).click();
        waitFor("//span[contains(.,'9:25')]");
        getDriver().findElement(By.xpath("//span[contains(.,'9:25')]")).click();
        LocalDate currentDate = LocalDate.now();
        LocalDate previousDate = currentDate.minusDays(5);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String newDateOnly = previousDate.format(outputFormatter);
        Serenity.setSessionVariable("arrivalDate").to(newDateOnly+ " 09:25");
    }

    private void selectSpecificDate(){
        LocalDate currentDate = LocalDate.now();
        LocalDate previousDate = currentDate.minusDays(5);
        int dayOfMonth = previousDate.getDayOfMonth();
        for (WebElementFacade day : calendarDaysList) {
             if(Integer.parseInt(day.getText())==dayOfMonth) {
                 clickOn(day);
                 break;
             }
        }
    }
    public void verifyClaimStatusInClaimListingPage(String claimStatus) {
        searchAClaimInListingPage();

        assertThat(claimIdFld.getText().trim()).as("Claim Id Value is missing").isNotEqualTo("");
        if (Objects.nonNull(Serenity.sessionVariableCalled("isDamageItemsSubmitted")))
            assertThat(claimIdFld.getText().trim()).as("Claim Id Value is not same as previous").
                    isEqualTo(Serenity.sessionVariableCalled("claimId").toString());
        Serenity.setSessionVariable("claimId").to(claimIdFld.getText().trim());

        assertThat(brandNameFld.getText().trim()).as("Brand Name Value is not same as " + Serenity.sessionVariableCalled("brandName").toString())
                .isEqualTo(Serenity.sessionVariableCalled("brandName").toString());
        assertThat(vinValueFld.getText().trim()).as("Vin Value is not same as " + Serenity.sessionVariableCalled("vin").toString())
                .isEqualTo(Serenity.sessionVariableCalled("vin").toString());
        assertThat(claimStatusFld.getText().trim()).as("Claim Status is not correct. Actual : " + claimStatusFld.getText().trim() + ". Expected : " + claimStatus)
                .isEqualTo(claimStatus);
    }

    private void searchAClaimInListingPage() {
        waitFor(claimSearchField);
        typeInto(claimSearchField, Serenity.sessionVariableCalled("vin").toString());
        waitFor(claimSearchBtn);
        claimSearchBtn.click();
        assertThat(claimsList.size()).as("Searched claim for vin " + Serenity.sessionVariableCalled("vin").
                toString() + " is not listed in the table").isNotEqualTo(0);

    }

    public void selectClaimInDraftAndEdit() {
        waitFor(claimIdFld);
        clickOn(claimIdFld);
        verifyVehicleDetailsInEditMode();
    }

    private void verifyVehicleDetailsInEditMode() {
        verifyClaimCreationPageHeaderDetails("Vehicle", "Open");
        if (Objects.isNull(Serenity.sessionVariableCalled("isDamageItemsSubmitted")))
            verifySideBarVerification("Vehicle_EditMode");
        clickOn(nextBtn);
        verifyAlreadyAddedVehicleDetails();
        clickOn(nextBtn);
        if (Objects.nonNull(Serenity.sessionVariableCalled("isDamageItemsSubmitted"))) {
            verifySideBarVerification("Damage Items_EditMode");
            verifyClaimCreationPageHeaderDetails("Damage Items", "Open");
            verifyAlreadyAddedDamageItemsListing();
        }
    }

    private void verifyAlreadyAddedDamageItemsListing() {
        assertThat(damageItemsList.size()).as("Added damage item is not listed in Damage Items Table").isNotEqualTo(0);
        for (WebElementFacade damageItem : damageItemsList) {
            assertThat(damageItem.findElement(By.xpath(".//td")).getText().replaceAll("\\(.*?\\)", "").trim()).as("Damage Items List page doesn't contains already added damage location details" +
                            Serenity.sessionVariableCalled("damageLocation").toString())
                    .isEqualTo(Serenity.sessionVariableCalled("damageLocation").toString().replaceAll("\\(.*?\\)", "").trim());
            assertThat(damageItem.findElement(By.xpath(".//td")).getText()).as("Damage Items List page doesn't contains already added damage type details" +
                            Serenity.sessionVariableCalled("damageType").toString())
                    .contains(Serenity.sessionVariableCalled("damageType").toString());
            assertThat(damageItem.findElement(By.xpath(".//td[2]")).getText()).as("Damage Items List page doesn't contains already added damage's estimated total repair cost" +
                            Serenity.sessionVariableCalled("estimatedTotalRepairCost").toString())
                    .contains(Serenity.sessionVariableCalled("estimatedTotalRepairCost").toString());
            clickOn(getDriver().findElement(By.xpath("//tbody/tr/td/a[contains(text(),'" + Serenity.sessionVariableCalled("damageLocation").toString().replaceFirst("\\s*\\([^\\)]*\\)$", "").trim() + "')]")));
            waitFor(damageIdFld);
            Serenity.setSessionVariable("damageId_"+Serenity.sessionVariableCalled("damageLocation")).to(damageIdFld.getText().trim());
            assertThat(claimStatusDescription.getText()).as("Damage Items Edit Page : Claim Status description is not correct. Actual :"+claimStatusDescription.getText()+"Expected : Claim Received; Under Review").
                    isEqualTo("Claim Received; Under Review");
            verifyAlreadyAddedDamageItemsDetails();
            verifyAlreadyAddedDamageItemsEstimateDetails();
        }
    }

    private void verifyAlreadyAddedDamageItemsEstimateDetails() {
        waitFor(estimateNumberField);
        assertThat(estimateNumberField.getValue().trim()).as("").isEqualTo(Serenity.sessionVariableCalled("estimateNumber").toString());
        assertThat(estimateDateField.getValue().trim()).as("Already saved Estimate Date is not present")
                .isEqualTo(Serenity.sessionVariableCalled("estimateDate").toString());


        if (Objects.nonNull(Serenity.sessionVariableCalled("noOfLabourHrs"))) {
            assertThat(Double.parseDouble(estimatedLabourRepairHoursField.getValue())).as("No. of Labour Hrs saved is not present").
                    isEqualTo(Double.parseDouble(Serenity.sessionVariableCalled("noOfLabourHrs").toString()));
        }
        waitFor(estimatedLabourRepairRateField);
        if (Objects.nonNull(Serenity.sessionVariableCalled("labourAmountPerHr"))) {
            assertThat(Double.parseDouble(estimatedLabourRepairRateField.getValue())).as("Labour Amount Per Hr saved is not present").
                    isEqualTo(Double.parseDouble(Serenity.sessionVariableCalled("labourAmountPerHr").toString()));
        }
        waitFor(estimatedPaintLabourRepairHoursField);
        if (Objects.nonNull(Serenity.sessionVariableCalled("noOfPaintLabourHrs"))) {
            assertThat(Double.parseDouble(estimatedPaintLabourRepairHoursField.getValue())).as("No. of Paint Labour Hrs saved is not present").
                    isEqualTo(Double.parseDouble(Serenity.sessionVariableCalled("noOfPaintLabourHrs").toString()));
        }

        waitFor(estimatedPartsRepairCostField);
        if (Objects.nonNull(Serenity.sessionVariableCalled("partsCost"))) {
            assertThat(Double.parseDouble(estimatedPartsRepairCostField.getValue())).as("Parts Cost saved is not present").
                    isEqualTo(Double.parseDouble(Serenity.sessionVariableCalled("partsCost").toString()));
        }
        waitFor(estimatedMaterialsRepairCostField);
        if (Objects.nonNull(Serenity.sessionVariableCalled("paint/MaterialsCost"))) {
            assertThat(Double.parseDouble(estimatedMaterialsRepairCostField.getValue())).as("Paint/Materials Cost saved is not present").
                    isEqualTo(Double.parseDouble(Serenity.sessionVariableCalled("paint/MaterialsCost").toString()));
        }

        waitFor(estimatedOtherRepairCostField);
        if (Objects.nonNull(Serenity.sessionVariableCalled("miscellaneousCost"))) {
            assertThat(Double.parseDouble(estimatedOtherRepairCostField.getValue())).as("Miscellaneous Cost saved is not present").
                    isEqualTo(Double.parseDouble(Serenity.sessionVariableCalled("miscellaneousCost").toString()));
        }

        assertThat(Double.parseDouble(estimatedTotalRepairCostField.getValue().trim())).as("Total Repair cost saved is not present").
                isEqualTo(Double.parseDouble(Serenity.sessionVariableCalled("estimatedTotalRepairCost").toString()));

    }

    private void verifyAlreadyAddedDamageItemsDetails() {
        waitFor(damageLocationDropDownField);
        assertThat(damageLocationDropDownField.getAttribute("value")).as("Already added Damage Location detail is not present").isEqualTo(Serenity.sessionVariableCalled("damageLocation").toString());
        waitFor(damageTypeDropDownField);
        assertThat(damageTypeDropDownField.getAttribute("value")).as("Already added Damage Type detail is not present").isEqualTo(Serenity.sessionVariableCalled("damageType").toString());
        waitFor(repairMethodDropDownField);
        assertThat(repairMethodDropDownField.getAttribute("value")).as("Already added Repair Method detail is not present").isEqualTo(Serenity.sessionVariableCalled("repairMethod").toString());
        waitFor(severityLevelDropDownField);
        assertThat(severityLevelDropDownField.getAttribute("value")).as("Already added Severity Level detail is not present").isEqualTo(Serenity.sessionVariableCalled("severityLevel").toString());

    }

    private void verifyAlreadyAddedVehicleDetails() {
        assertThat(vinTxtFld.getAttribute("value").trim()).as("Vin displayed in edit mode is not same as already added. Actual : " + vinTxtFld.getText().trim() + ". Expected : " + Serenity.sessionVariableCalled("vin"))
                .isEqualTo(Serenity.sessionVariableCalled("vin"));
        assertThat(manufactureSelectDrpDwn.findElement(By.xpath(".//option")).getText().trim()).as("Manufacture name displayed in edit mode is not same as already added. Actual : " + manufactureSelectDrpDwn.getText().trim() + ". Expected : " + Serenity.sessionVariableCalled("brandName"))
                .isEqualTo(Serenity.sessionVariableCalled("brandName"));
        assertThat(modelNameFld.getAttribute("value").trim()).as("Model name displayed in edit mode is not same as already added. Actual : " + modelNameFld.getText().trim() + ". Expected : " + Serenity.sessionVariableCalled("model"))
                .isEqualTo(Serenity.sessionVariableCalled("model"));
        assertThat(arrivalDateTxtFld.getAttribute("value").trim()).as("Model name displayed in edit mode is not same as already added. Actual : " + modelNameFld.getText().trim() + ". Expected : " + Serenity.sessionVariableCalled("arrivalDate"))
                .isEqualTo(Serenity.sessionVariableCalled("arrivalDate"));
    }

    public void addDamageItems(DataTable damageItems) {
        if (commonMethods.isCucumberTagAvailable("FieldValidation", "tag")) {
            verifyClaimCreationPageHeaderDetails("Damage Items", "Open");
            verifySideBarVerification("Damage Items");
            validateDamageItemsPage();
            verifyDamageItemsPageHeader();
        }
        addDamageItemsDetails(damageItems);
    }

    private void validateDamageItemsPage() {
        if (commonMethods.isCucumberTagAvailable("FieldValidation", "tag")) {
            waitFor(createButton);
            commonMethods.clickWithJavaScript(createButton);
            commonMethods.verifyValidationMessage(Constant.REPAIR_METHOD_VALIDATION_MESSAGE);
            commonMethods.verifyValidationMessage(Constant.SEVERITY_LEVEL_VALIDATION_MESSAGE);
        }
    }

    private void addDamageItemsDetails(DataTable damageItems) {
        List<Map<String, String>> damageItemsData = damageItems.asMaps(String.class, String.class);
        if (damageItemsData.get(0).get("damageItemsDetails").equals("yes")) {
            waitFor(damageLocationDropDown);
            commonMethods.selectValueFromDropDown(damageLocationDropDown, "Bumper / Cover / Ext. (Rear) (04)");
            Serenity.setSessionVariable("damageLocation").to("Bumper / Cover / Ext. (Rear)");
            waitABit(2000);
            //assertThat(damageLocationDropDownTickIcon.isDisplayed()).as("Damage Location DropDown Tick Icon is missing").isTrue();
            waitFor(damageTypeDropDown);
            commonMethods.selectValueFromDropDown(damageTypeDropDown, "Dented");
            Serenity.setSessionVariable("damageType").to("Dented");
            waitFor(repairMethodDropDown);
            commonMethods.selectValueFromDropDown(repairMethodDropDown, "Repaint");
            Serenity.setSessionVariable("repairMethod").to("Repaint");
            waitFor(severityLevelDropDown);
            commonMethods.selectValueFromDropDown(severityLevelDropDown, "Damage 30cm and over in length and/or diameter");
            Serenity.setSessionVariable("severityLevel").to("Damage 30cm and over in length and/or diameter");
        }
    }

    public void addDamageItemsEstimate(DataTable damageItemsEstimateDetails) {
        List<Map<String, String>> damageItemsData = damageItemsEstimateDetails.asMaps(String.class, String.class);
        if (damageItemsData.get(0).get("damageItemsEstimateDetails").equals("yes")) {
            waitFor(estimateNumberField);
            typeInto(estimateNumberField, "EstimateNo.1");
            Serenity.setSessionVariable("estimateNumber").to("EstimateNo.1");
            selectEstimateDate(damageItemsData.get(0).get("estimateDaysDifference"));
            enterCoastDetails(damageItemsEstimateDetails);
        }
    }

    private void enterCoastDetails(DataTable damageItemsEstimateDetails) {
        List<Map<String, String>> damageItemsData = damageItemsEstimateDetails.asMaps(String.class, String.class);
        waitFor(estimatedLabourRepairHoursField);
        if (Objects.nonNull(damageItemsData.get(0).get("noOfLabourHrs"))) {
            typeInto(estimatedLabourRepairHoursField, damageItemsData.get(0).get("noOfLabourHrs"));
            Serenity.setSessionVariable("noOfLabourHrs").to(damageItemsData.get(0).get("noOfLabourHrs"));
        }
        waitFor(estimatedLabourRepairRateField);
        if (Objects.nonNull(damageItemsData.get(0).get("labourAmountPerHr"))) {
            typeInto(estimatedLabourRepairRateField, damageItemsData.get(0).get("labourAmountPerHr"));
            Serenity.setSessionVariable("labourAmountPerHr").to(damageItemsData.get(0).get("labourAmountPerHr"));
        }
        waitFor(estimatedPaintLabourRepairHoursField);
        if (Objects.nonNull(damageItemsData.get(0).get("noOfPaintLabourHrs"))) {
            typeInto(estimatedPaintLabourRepairHoursField, damageItemsData.get(0).get("noOfPaintLabourHrs"));
            Serenity.setSessionVariable("noOfPaintLabourHrs").to(damageItemsData.get(0).get("noOfPaintLabourHrs"));
        }
        assertThat(totalEstimatedLabourCostField.getText().trim().equals(Double.parseDouble((Serenity.sessionVariableCalled("noOfLabourHrs").toString())) *
                Integer.parseInt(Serenity.sessionVariableCalled("labourAmountPerHr").toString())));

        waitFor(estimatedPartsRepairCostField);
        if (Objects.nonNull(damageItemsData.get(0).get("partsCost"))) {
            typeInto(estimatedPartsRepairCostField, damageItemsData.get(0).get("partsCost"));
            Serenity.setSessionVariable("partsCost").to(damageItemsData.get(0).get("partsCost"));
        }
        waitFor(estimatedMaterialsRepairCostField);
        if (Objects.nonNull(damageItemsData.get(0).get("paint/MaterialsCost"))) {
            typeInto(estimatedMaterialsRepairCostField, damageItemsData.get(0).get("paint/MaterialsCost"));
            Serenity.setSessionVariable("paint/MaterialsCost").to(damageItemsData.get(0).get("paint/MaterialsCost"));
        }

        waitFor(estimatedOtherRepairCostField);
        if (Objects.nonNull(damageItemsData.get(0).get("miscellaneousCost"))) {
            typeInto(estimatedOtherRepairCostField, damageItemsData.get(0).get("miscellaneousCost"));
            Serenity.setSessionVariable("miscellaneousCost").to(damageItemsData.get(0).get("miscellaneousCost"));
        }

        typeInto(estimatedOtherRepairCostDescriptionField, "Extra Painting");

        assertThat(estimatedTotalRepairCostField.getText().trim()).as("Mismatch in Total Repair cost. Actual :" + estimatedTotalRepairCostField.getText().trim()).
                isEqualTo(Double.parseDouble(estimatedPartsRepairCostField.getText().trim()) +
                        Double.parseDouble(estimatedMaterialsRepairCostField.getText().trim()) +
                        Double.parseDouble(estimatedOtherRepairCostField.getText().trim()));
        Serenity.setSessionVariable("estimatedTotalRepairCost").to(estimatedTotalRepairCostField.getText().trim());

        waitFor(createButton);
        commonMethods.clickWithJavaScript(createButton);
        waitFor(addAnotherDamageItemsConfirmPopup);
        if (damageItemsData.get(0).get("noOfDamageItemsToBeAdded").equals("1")) {
            clickOn(noBtn);
            waitFor(claimCreationDeclarationPopup);
            waitFor(dealerTermsCheckBox);
            clickOn(dealerTermsCheckBox);
            waitFor(dealerTermsPopupSaveBtn);
            clickOn(dealerTermsPopupSaveBtn);
        } else {
            clickOn(yesBtn);

        }
    }

    private void enterCoastDetailsAsDraft(DataTable damageItemsEstimateDetails) {
        List<Map<String, String>> damageItemsData = damageItemsEstimateDetails.asMaps(String.class, String.class);
        waitFor(estimatedLabourRepairHoursField);
        if (Objects.nonNull(damageItemsData.get(0).get("noOfLabourHrs"))) {
            typeInto(estimatedLabourRepairHoursField, damageItemsData.get(0).get("noOfLabourHrs"));
            Serenity.setSessionVariable("noOfLabourHrs").to(damageItemsData.get(0).get("noOfLabourHrs"));
        }
        waitFor(estimatedLabourRepairRateField);
        if (Objects.nonNull(damageItemsData.get(0).get("labourAmountPerHr"))) {
            typeInto(estimatedLabourRepairRateField, damageItemsData.get(0).get("labourAmountPerHr"));
            Serenity.setSessionVariable("labourAmountPerHr").to(damageItemsData.get(0).get("labourAmountPerHr"));
        }
        waitFor(estimatedPaintLabourRepairHoursField);
        if (Objects.nonNull(damageItemsData.get(0).get("noOfPaintLabourHrs"))) {
            typeInto(estimatedPaintLabourRepairHoursField, damageItemsData.get(0).get("noOfPaintLabourHrs"));
            Serenity.setSessionVariable("noOfPaintLabourHrs").to(damageItemsData.get(0).get("noOfPaintLabourHrs"));
        }
        assertThat(Double.parseDouble(totalEstimatedLabourCostField.getValue().trim())).as("").isEqualTo((Double.parseDouble((Serenity.sessionVariableCalled("noOfLabourHrs").toString())) *
                Double.parseDouble(Serenity.sessionVariableCalled("labourAmountPerHr").toString())));
        Serenity.setSessionVariable("totalEstimatedLabourCost").to(Double.parseDouble(totalEstimatedLabourCostField.getValue().trim()));

        waitFor(estimatedPartsRepairCostField);
        if (Objects.nonNull(damageItemsData.get(0).get("partsCost"))) {
            typeInto(estimatedPartsRepairCostField, damageItemsData.get(0).get("partsCost"));
            Serenity.setSessionVariable("partsCost").to(damageItemsData.get(0).get("partsCost"));
        }
        waitFor(estimatedMaterialsRepairCostField);
        if (Objects.nonNull(damageItemsData.get(0).get("paint/MaterialsCost"))) {
            typeInto(estimatedMaterialsRepairCostField, damageItemsData.get(0).get("paint/MaterialsCost"));
            Serenity.setSessionVariable("paint/MaterialsCost").to(damageItemsData.get(0).get("paint/MaterialsCost"));
        }

        waitFor(estimatedOtherRepairCostField);
        if (Objects.nonNull(damageItemsData.get(0).get("miscellaneousCost"))) {
            typeInto(estimatedOtherRepairCostField, damageItemsData.get(0).get("miscellaneousCost"));
            Serenity.setSessionVariable("miscellaneousCost").to(damageItemsData.get(0).get("miscellaneousCost"));
        }

        typeInto(estimatedOtherRepairCostDescriptionField, "Extra Painting");

        assertThat(Double.parseDouble(estimatedTotalRepairCostField.getValue().trim())).as("Mismatch in Total Repair cost. Actual :" + estimatedTotalRepairCostField.getText().trim()).
                isEqualTo(Double.parseDouble(totalEstimatedLabourCostField.getValue().trim()) +
                        Double.parseDouble(estimatedPartsRepairCostField.getValue().trim()) +
                        Double.parseDouble(estimatedMaterialsRepairCostField.getValue().trim()) +
                        Double.parseDouble(estimatedOtherRepairCostField.getValue().trim()));
        Serenity.setSessionVariable("estimatedTotalRepairCost").to(Double.parseDouble(estimatedTotalRepairCostField.getValue().trim()));

        waitFor(createButton);
        commonMethods.clickWithJavaScript(createButton);
        waitFor(addAnotherDamageItemsConfirmPopup);
        if (damageItemsData.get(0).get("noOfDamageItemsToBeAdded").equals("1")) {
            clickOn(noBtn);
            waitFor(claimCreationDeclarationPopup);
            waitFor(dealerTermsCheckBox);
            clickOn(dealerTermsCheckBox);
            waitFor(dealerTermsPopupSaveBtn);
            clickOn(dealerTermsPopupSaveBtn);
            verifySideBarVerification("Documents");
            Serenity.setSessionVariable("isDamageItemsSubmitted").to("yes");
        } else {
            clickOn(yesBtn);

        }
    }
    private void selectEstimateDate(String estimateDaysDifference) {
        waitFor(calenderIcon);
        commonMethods.clickWithJavaScript(calenderIcon);
        selectSpecificEstimateDate(estimateDaysDifference, Serenity.sessionVariableCalled("arrivalDate").toString());
    }
    private void selectSpecificEstimateDate(String estimateDaysDifference, String arrivalDate) {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        LocalDateTime dateTime = LocalDateTime.parse(arrivalDate, inputFormatter);
        LocalDateTime newDateTime = dateTime.plusDays(Long.parseLong(estimateDaysDifference));

        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String newDateOnly = newDateTime.format(outputFormatter);

        for (WebElementFacade day : calendarDaysList) {
            if(Integer.parseInt(day.getText())==Integer.parseInt(newDateOnly.split("/")[0])) {
                clickOn(day);
                break;
            }
        }
        Serenity.setSessionVariable("estimateDate").to(newDateOnly);
    }

    private void verifyDamageItemsPageHeader() {
        assertThat(damageItemsPageHeader.getText()).as("Damage Items Page : Header is missing").
                isEqualTo("CREATE A NEW DAMAGE ITEM");
        assertThat(damageItemsPageInfo.getText()).as("Damage Items Page : Info is missing").
                contains(Constant.DAMAGE_ITEMS_PAGE_INFO);

    }

    public void saveDamageItemsEstimateAsDraft(DataTable damageItemsEstimateDetails) {
        List<Map<String, String>> damageItemsData = damageItemsEstimateDetails.asMaps(String.class, String.class);
        if (damageItemsData.get(0).get("damageItemsEstimateDetails").equals("yes")) {
            waitFor(estimateNumberField);
            typeInto(estimateNumberField, "EstimateNo.1");
            Serenity.setSessionVariable("estimateNumber").to("EstimateNo.1");
            selectEstimateDate(damageItemsData.get(0).get("estimateDaysDifference"));
            enterCoastDetailsAsDraft(damageItemsEstimateDetails);

        }
    }
    public void navigateToDocumentsUploadPageAndUpload() {
        waitFor(documentsSideBarLink);
        clickOn(documentsSideBarLink);
        //waitFor(documentUploadLink);
        uploadClaimSupportedDocuments();
    }

    private void uploadClaimSupportedDocuments() {
        upload("./src/test/resources/Documents/DocumentUpload.pdf").to(getDriver().findElement(By.id("fileupload")));
        waitABit(3000);
        waitFor(uploadedImage);
        assertThat(uploadedImage.isDisplayed()).as("uploaded image is not listed").isTrue();
        verifySideBarVerification("Documents_Uploaded");
    }

    public void submitClaim() {
        waitFor(readyForSubmissionBtn_enabled);
        clickOn(readyForSubmissionBtn_enabled);
        waitFor(claimSubmissionConfirmationMessage);
        assertThat(claimSubmissionConfirmationMessage.getText().trim()).as("Claim Submission Confirmation Message is not correct").
                isEqualTo(Constant.CLAIM_SUBMISSION_CONFIRMATION_MESSAGE);
        waitFor(backToHomeButton);
        clickOn(backToHomeButton);
        Serenity.setSessionVariable("isClaimSubmitted").to("yes");
    }

    public void addVehicleDetails(String brandName) {
        waitFor(createNewClaimBtn);
        createNewClaimBtn.click();
        verifyClaimCreationPageHeaderDetails("Vehicle", "Open");
        verifySideBarVerification("Vehicle");
        updateVehicleDetails();
    }
}
