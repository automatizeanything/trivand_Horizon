package com.horizon.pages.dealer;

import com.horizon.utility.CommonMethods;
import com.horizon.utility.Constant;
import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

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
    private @FindBy(xpath = "//form[@id='new_cached_vehicle']/fieldset/div[5]/div/div/span[2]/i")
    WebElementFacade calenderIcon;
    private @FindBy(xpath = "//div[3]/table/thead/tr/th/i")
    WebElementFacade calenderIconArrowLeft;
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
    private @FindBy(xpath = "//table/tbody/tr/td[2]/a[2]")
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
    public void createAClaim(String brandName) {
        waitFor(createNewClaimBtn);
        createNewClaimBtn.click();
        verifyClaimCreationPageHeaderDetails("Vehicle", "Open");
        verifySideBarVerification("Vehicle");
        updateVehicleDetails();
        dashBoardPage.validateIncompleteClaimsFilterDetails();
    }
    private void updateVehicleDetails() {
        verifyFieldValidations("Vehicle");
        nextBtn.click();
    }
    private void verifyFieldValidations(String vehicle) {
        waitFor(nextBtn);
        typeInto(vinTxtFld, "2FM");
        nextBtn.click();
        commonMethods.verifyValidationMessage(Constant.VIN_VALIDATION_MESSAGE);
        typeInto(vinTxtFld, "VNVF4000570746271");
        Serenity.setSessionVariable("vin").to("VNVF4000570746271");
        vehicleSpecTxtFld.click();
        nextBtn.click();
        commonMethods.verifyValidationMessage(Constant.ARRIVAL_DATE_VALIDATION_MESSAGE);
        selectArrivalDate();
        waitABit(6000);
        vinTxtFld.click();
        commonMethods.clickWithJavaScript(nextBtn);
        commonMethods.verifyValidationMessage(Constant.MODEL_VALIDATION_MESSAGE);
        commonMethods.selectDropdownValueAtRuntime(modalFldDropDown);
        Serenity.setSessionVariable("model").to(modelNameFld.getText().trim());
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
            assertThat(vehicleSideBarLink.findElement(By.xpath(".//a")).getAttribute("href")).as("Vehicle Sidebar link is not active in Vehicle details submission page")
                    .contains("vehicle/edit");
            assertThat(vehicleSideBarLink.findElement(By.xpath(".//a/i[contains(@class,'icon-ok')]")).isDisplayed()).as("Vehicle Sidebar link : Tick Icon is missing")
                    .isTrue();
            assertThat(damageItemsSideBarLink.findElement(By.xpath(".//a")).getAttribute("href")).as("Damage Items Sidebar link is not disabled in Vehicle details submission page")
                    .contains("damage_items");
            assertThat(documentsSideBarLink.findElement(By.xpath("./span")).getAttribute("class")).as("Documents Sidebar link is not disabled in Vehicle details submission page")
                    .contains("disabled");
            assertThat(readyForSubmissionBtn.getAttribute("class")).as("Ready For Submission Button is not disabled in Vehicle details submission page")
                    .contains("disabled");
            assertThat(clientNameFld.getText().trim()).as("Client Name is not correct. Actual : " + clientNameFld.getText().trim() + ". Expected : " + Constant.BENTLEY_MOTORS)
                    .isEqualTo(Constant.BENTLEY_MOTORS);
            assertThat(clientNameFld.getAttribute("autocomplete").equals("off")).as("Client Name is editable. It should be non editable.").isTrue();
            assertThat(dealerBrandFld.getText().trim()).as("Dealer Brand Name is not correct. Actual : " + dealerBrandFld.getText().trim() + ". Expected : " + Serenity.sessionVariableCalled("brandName"))
                    .isEqualTo(Serenity.sessionVariableCalled("brandName"));
            assertThat(dealerBrandFld.getAttribute("autocomplete").equals("off")).as("Dealer Brand Name Field is editable. It should be non editable.").isTrue();
        } else if (subPage.equals("Vehicle_EditMode")) {

        }
    }
    private void verifyClaimCreationPageHeaderDetails(String subPage, String claimsStatus) {
        waitForClaimCreationPage();
        assertThat(createClaimPageTitle.getText().trim().equals("CREATE NEW CLAIM"))
                .as("Create a claim - Page header is missing").isTrue();
        assertThat(createClaimPageBrandName.getText().contains(Serenity.sessionVariableCalled("brandName")))
                .as("Clam Creation | " + subPage + " - Manufacture Name is missing in " + subPage + "page").isTrue();
        assertThat(claimStatus.getText().contains(claimsStatus))
                .as("Clam Creation | " + subPage + " - Claim status is not correct in " + subPage + "page. Current status is " + claimStatus.getText()).isTrue();
        assertThat(claimSourceDetail.getText().contains("Claim Source "))
                .as("Clam Creation | " + subPage + " - Claim source is not correct in " + subPage + "page. Current claim source is " + claimSourceDetail.getText()).isTrue();
    }
    private void selectArrivalDate() {
        waitFor(calenderIcon);
        calenderIcon.click();
        waitFor(calenderIconArrowLeft);
        calenderIconArrowLeft.click();
        waitFor("//tr[3]/td[4]");
        getDriver().findElement(By.xpath("//tr[3]/td[4]")).click();
        waitFor("//div[2]/table/tbody/tr/td/span[10]");
        getDriver().findElement(By.xpath("//div[2]/table/tbody/tr/td/span[10]")).click();
        waitFor("//span[contains(.,'9:25')]");
        getDriver().findElement(By.xpath("//span[contains(.,'9:25')]")).click();
        Serenity.setSessionVariable("arrivalDate").
                to(getDriver().findElement(By.xpath("//div[contains(@class,'datetime-picker')]")).getAttribute("data-date-enddate"));
    }
    public void verifyClaimStatusInClaimListingPage(String claimStatus) {
        searchAClaimInListingPage();
        assertThat(claimIdFld.getText().trim()).as("Claim Id Value is missing").isNotEqualTo("");
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
        assertThat(claimsList.size()).as("Searched claim for vin" + Serenity.sessionVariableCalled("vin").
                toString() + " is not listed in the table").isNotEqualTo(0);

    }
    public void selectClaimInDraftAndEdit() {
        waitFor(claimIdFld);
        clickOn(claimIdFld);
        verifyVehicleDetailsInEditMode();
    }
    private void verifyVehicleDetailsInEditMode() {
        verifyClaimCreationPageHeaderDetails("Vehicle", "Open");
        verifySideBarVerification("Vehicle_EditMode");
        clickOn(nextBtn);
        verifyAlreadyAddedVehicleDetails();
        clickOn(nextBtn);
    }
    private void verifyAlreadyAddedVehicleDetails() {
        assertThat(vinTxtFld.getText().trim()).as("Vin displayed in edit mode is not same as already added. Actual : " + vinTxtFld.getText().trim() + ". Expected : " + Serenity.sessionVariableCalled("vin"))
                .isEqualTo(Serenity.sessionVariableCalled("vin"));
        assertThat(manufactureSelectDrpDwn.getText().trim()).as("Manufacture name displayed in edit mode is not same as already added. Actual : " + manufactureSelectDrpDwn.getText().trim() + ". Expected : " + Serenity.sessionVariableCalled("brandName"))
                .isEqualTo(Serenity.sessionVariableCalled("brandName"));
        assertThat(modelNameFld.getText().trim()).as("Model name displayed in edit mode is not same as already added. Actual : " + modelNameFld.getText().trim() + ". Expected : " + Serenity.sessionVariableCalled("model"))
                .isEqualTo(Serenity.sessionVariableCalled("model"));
        assertThat(arrivalDateTxtFld.getText().trim()).as("Model name displayed in edit mode is not same as already added. Actual : " + modelNameFld.getText().trim() + ". Expected : " + Serenity.sessionVariableCalled("arrivalDate"))
                .isEqualTo(Serenity.sessionVariableCalled("arrivalDate"));
    }
    public void addDamageItems() {
        verifyClaimCreationPageHeaderDetails("Damage Items","Open");
        verifySideBarVerification("Damage Items");

    }
}
