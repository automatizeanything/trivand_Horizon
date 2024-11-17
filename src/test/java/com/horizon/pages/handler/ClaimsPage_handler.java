package com.horizon.pages.handler;


import com.horizon.utility.CommonMethods;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ClaimsPage_handler extends PageObject {


    CommonMethods commonMethods;
    private @FindBy(xpath = "//input[@value='Next']")
    WebElementFacade Next_Button;
    private @FindBy(xpath = "//table/descendant::a[contains(@href,'damage_items/')]")
    List<WebElementFacade> firstDamage_Item_Label;
    private @FindBy(xpath = "//table/descendant::a[contains(@href,'damage_items/')][1]")
    WebElementFacade firstDamage_Item_Box;
    private @FindBy(xpath = "//table/descendant::a[contains(@href,'damage_items/')][2]")
    WebElementFacade secondDamage_Item_Box;
    private @FindBy(xpath = "//input[@id='contractor_name']")
    WebElementFacade Contractor_Field;
    private @FindBy(xpath = "//a[contains(text(),'Bentley Motors Ltd')]")
    WebElementFacade Bentley_select;

    private @FindBy(xpath = "//input[@id='autoscan_check']/following-sibling::a")
    WebElementFacade Autoscan_DrpDwn;
    private @FindBy(xpath = "//a[text()='Autoscan requested, awaiting response']")
    WebElementFacade Autoscan_AwaitingResponse;
    private @FindBy(xpath = "//input[@id='carrier_name']")
    WebElementFacade carrier_name_Field;
    private @FindBy(xpath = "(//td[@class='day active'])[4]")
    WebElementFacade Activeday_date;
    private @FindBy(xpath = "//input[@id='damage_item_authorisation_due_date']")
    WebElementFacade Authorisation_due_date;
    private @FindBy(xpath = "//input[@value='Save']")
    WebElementFacade save_btn;

    private @FindBy(xpath = "//a[contains(text(),'Liability')]")
    WebElementFacade Liability_Lbl;
    private @FindBy(xpath = "//a[contains(text(),'Appointed Surveyors')]")
    WebElementFacade AppointedSurveyors_Lbl;
    private @FindBy(xpath = "//input[@id='supplier']")
    WebElementFacade AppointedSurveyors_DrpDown;
    private @FindBy(xpath = "//a[contains(text(),'Contior [')]")
    WebElementFacade AppointedSurveyors_DrpDown_Value;
    private @FindBy(xpath = "//input[@id='claim_validation_due_date']")
    WebElementFacade validation_Due_Date_Lbl;
    private @FindBy(xpath = "(//td[@class='day active'])")
    WebElementFacade validation_Due_Date_ActiveDay;
    private @FindBy(xpath = "//select[@id='claim_mini_suppliers_attributes_0_survey_category']")
    WebElementFacade survey_category_Dropdown;
    private @FindBy(xpath = "//input[@value='Appoint Surveyor']")
    WebElementFacade AppointSurveyorBtn;


    private @FindBy(xpath = "//a[contains(text(),'Documents')]")
    WebElementFacade Documents_Lbl;

    private @FindBy(xpath = "//ul[@id='documents']/descendant::img[@class='img-polaroid']")
    WebElementFacade Documents_Image_Selection;
    private @FindBy(xpath = "//input[contains(@value,'Select one or more tags')]")
    WebElementFacade TagsSelection_Lbl;
    private @FindBy(xpath = "//div[@id='document_tags_chosen']/descendant::li[@class='active-result highlighted']")
    WebElementFacade DamageReportSelection_Lbl;
    private @FindBy(xpath = "//a[@class='btn btn-primary btn-success']")
    WebElementFacade ReadyForSubmission_Btn;
    private @FindBy(xpath = "//input[@value='Proceed to Final Review']")
    WebElementFacade ProceedToFinalReview_Btn;
    private @FindBy(xpath = "//input[@value='Submit Claim & Send Emails']")
    WebElementFacade SubmitClaimSendEmails_Btn;
    private @FindBy(xpath = "//i[@class='icon-home']/parent::a")
    WebElementFacade Home_Btn;
    private @FindBy(xpath = "//input[@id='damage_item_estimates_attributes_0_estimated_labour_repair_cost']")
    WebElementFacade LabourRepairCostEstimate;
    private @FindBy(xpath = "//input[@id='damage_item_estimates_attributes_0_authorised_labour_repair_cost']")
    WebElementFacade LabourRepairSevatasAuthorisedCost;
    private @FindBy(xpath = "//input[@id='damage_item_estimates_attributes_0_estimated_parts_repair_cost']")
    WebElementFacade PartsRepairCostEstimate;
    private @FindBy(xpath = "//input[@id='damage_item_estimates_attributes_0_authorised_parts_repair_cost']")
    WebElementFacade PartsRepairSevatasAuthorisedCost;
    private @FindBy(xpath = "//input[@id='damage_item_estimates_attributes_0_repair_authorised_at']")
    WebElementFacade SavatasAutherizationDate_fld;
    private @FindBy(xpath = "//div[@class='datetimepicker datetimepicker-dropdown-top-left dropdown-menu notranslate' and  contains(@style,'display: block')]/descendant::td[@class='day active']")
    WebElementFacade SavatasAutherizationDate_CurrentDate;

    private @FindBy(xpath = "//input[@id='damage_item_estimates_attributes_0_auth_code']")
    WebElementFacade SavatasAutherizationode_fld;
    private @FindBy(xpath = "//td[@class='checkbox-cell']/child::input[@type='checkbox']")
    WebElementFacade DamageitemSelection_Checkbox;
    private @FindBy(xpath = "//div[@class='btn-group action-buttons']/child::button")
    WebElementFacade Action_Btn;
    private @FindBy(xpath = "//a[@data-action='send_repair_authorisation']")
    WebElementFacade send_repair_authorisation;
    private @FindBy(xpath = "//a[@data-action='send_updated_repair_authorisation']")
    WebElementFacade send_Updated_repair_authorisation;

    private @FindBy(xpath = "//input[@value='Send Email']")
    WebElementFacade sendEmail_Btn;
    private @FindBy(xpath = "//div[text()='An email has been sent to the dealer concerning the selected items being authorised for repairs.']")
    WebElementFacade email_Success_Msg;
    private @FindBy(xpath = "//button[@data-dismiss='alert']")
    WebElementFacade CloseEmailSuccess_Btn;

    private @FindBy(xpath = "//button[text()='Estimate Splitter ']")
    WebElementFacade EstimateSplitterButton;
    private @FindBy(xpath = "//a[text()='Split Estimate']")
    WebElementFacade splitEstimate_Label;
    private @FindBy(xpath = "//a[text()='Assign Automatically']")
    WebElementFacade AssignAutomatically_Btn;
    private @FindBy(xpath = "//input[@value='Save Changes']")
    WebElementFacade Save_Btn;
    private @FindBy(xpath = "//div[@class='input-append date date-picker']/child::input[@id='authorisation_due_at']")
    WebElementFacade Authorisation_DueDate_Field;
    private @FindBy(xpath = "//input[@id='damage_item_estimates_attributes_0_av_authorised_parts_repair_cost']")
    WebElementFacade AvAuthorisedPartsValue;



    public void PerformTheClaimAuthorisation() {
        waitABit(5000);
        //Serenity.setSessionVariable("ClaimID").to("984340");
        NavigateToCreatedClaim(Serenity.sessionVariableCalled("claimId").toString());
        updateClientAndTerritory();
        updateVehicle();
        DamageItemUpdateAndVerification();
        updateLiability();
        updateAppointedSurveyors();
        updateDocuments();
        commonMethods.scrollIntoTheViewAndClick(ReadyForSubmission_Btn);
        commonMethods.waitAndClick(ProceedToFinalReview_Btn);
        commonMethods.waitAndClick(SubmitClaimSendEmails_Btn);
        Home_Btn.click();

        System.out.println();

    }

    private void updateDocuments() {
        Documents_Lbl.click();
        Documents_Image_Selection.click();
        waitABit(4000);
        TagsSelection_Lbl.click();
        TagsSelection_Lbl.sendKeys("Damage");
        DamageReportSelection_Lbl.click();
        waitABit(2000);
        commonMethods.scrollIntoTheViewAndClick(save_btn);
        waitABit(2000);

    }

    private void updateLiability() {
        commonMethods.waitAndClick(Liability_Lbl);
        commonMethods.waitAndClick(save_btn);
    }

    private void updateAppointedSurveyors() {
        commonMethods.waitAndClick(AppointedSurveyors_Lbl);
        waitABit(4000);
        AppointedSurveyors_DrpDown.clear();
        AppointedSurveyors_DrpDown.sendKeys("Contior");
        waitABit(1000);
        commonMethods.waitAndClick(AppointedSurveyors_DrpDown_Value);
        validation_Due_Date_Lbl.click();
        validation_Due_Date_ActiveDay.click();

        survey_category_Dropdown.selectByValue("desktop");

        AppointSurveyorBtn.click();

        //Desktop


    }


    public void NavigateToCreatedClaim(String claimID) {
        waitABit(5000);
        commonMethods.waitAndClick(getDriver().findElement(By.xpath(
                "//a[contains(@href,'claims') and text()='" + claimID + "']")));

    }

    public void DamageItemUpdateAndVerification() {
        String contractor = "Bentley Motors Ltd";
        EstimateSplitterButton.click();
        splitEstimate_Label.click();
        waitABit(3000);
        waitFor(AssignAutomatically_Btn);
        AssignAutomatically_Btn.click();
        Authorisation_DueDate_Field.click();
        Activeday_date.click();
        commonMethods.scrollIntoTheViewAndClick(Save_Btn);

        waitABit(5000);
        //int itemsize=firstDamage_Item_Label.size();
        for (int i = 0; i < firstDamage_Item_Label.size(); i++) {
            waitABit(5000);
            if (i == 0)
                firstDamage_Item_Label.get(0).click();
            else
                secondDamage_Item_Box.click();

            waitABit(3000);
            Contractor_Field.sendKeys("Bentley Motors Ltd");
            getDriver().findElement(By.xpath("//a[contains(text(),'" + contractor + "')]")).click();
            //Bentley_select.click();
            commonMethods.scrollIntoTheViewAndClick(Autoscan_DrpDwn);
            commonMethods.waitAndClick(Autoscan_AwaitingResponse);
            //commonMethods.scrollIntoTheViewAndClick(carrier_name_Field);
            carrier_name_Field.sendKeys("Bentley Dubai - Al Habtoor Motors");
            getDriver().findElement(By.xpath("//a[contains(text(),'Bentley Dubai - Al Habtoor Motors')]")).click();
            Authorisation_due_date.click();
            Activeday_date.click();
            commonMethods.scrollIntoTheViewAndClick(save_btn);
        }

        assertThat(verifytickMarkPresent("Damage Items")).
                as("Damage Items is Selected by default").isGreaterThan(0);


    }

    public void updateClientAndTerritory() {
//        assertThat(verifytickMarkPresent("Client & Territory")).
//                as("Client & Territory is Selected by default").isEqualTo(0);
        commonMethods.scrollIntoTheViewAndClick(Next_Button);
        assertThat(verifytickMarkPresent("Client & Territory")).
                as("Client & Territory is Selected by default").isGreaterThan(0);
    }

    public void updateVehicle() {
        assertThat(verifytickMarkPresent("Vehicle")).
                as("Vehicle is Selected by default").isEqualTo(0);
        commonMethods.scrollIntoTheViewAndClick(Next_Button);
        assertThat(verifytickMarkPresent("Vehicle")).
                as("Client & Territory is Selected by default").isGreaterThan(0);
    }

    public int verifytickMarkPresent(String SectionName) {
        int size = 0;
        try {
            size = getDriver().findElements(
                    By.xpath(
                            "//a[contains(text(),'" + SectionName + "')]/i[@class='icon-ok']")).size();
            return size;
        } catch (Exception e) {
            return size;
        }
    }

    public void openTheCreateClaim() {
        NavigateToCreatedClaim(Serenity.sessionVariableCalled("claimId").toString());
    }

    public void UpdateTheAuthorizationDetails() {
        LabourRepairSevatasAuthorisedCost.sendKeys(LabourRepairCostEstimate.getAttribute("value"));
        PartsRepairSevatasAuthorisedCost.sendKeys(PartsRepairCostEstimate.getAttribute("value"));
        commonMethods.scrollWithJavaScript(SavatasAutherizationDate_fld);
        commonMethods.waitAndClick(SavatasAutherizationDate_fld);
        commonMethods.scrollWithJavaScript(SavatasAutherizationDate_fld);
        SavatasAutherizationDate_CurrentDate.click();
        SavatasAutherizationode_fld.sendKeys("SAVATAS123");
        save_btn.click();
        waitABit(2000);
        commonMethods.scrollIntoTheViewAndClick(DamageitemSelection_Checkbox);
        Action_Btn.click();
        send_repair_authorisation.click();
        Next_Button.click();
        sendEmail_Btn.click();
        assertThat(email_Success_Msg.isDisplayed()).
                as("Confirmation email is not send");
        CloseEmailSuccess_Btn.click();
        System.out.println();


    }

    public void verifyAVUpdatedValue()
    {
        assertThat(AvAuthorisedPartsValue.getAttribute("value").split("\\.")[0].equalsIgnoreCase(Serenity.sessionVariableCalled("AV_Parts_Value").toString())).
                as("AV updated value is not reflected");

    }

    //to be completed
    public void SendTheAuthorizationDetailsAfterAVUpdate() {
        commonMethods.scrollWithJavaScript(save_btn);
        save_btn.click();
        waitABit(2000);
        commonMethods.scrollIntoTheViewAndClick(DamageitemSelection_Checkbox);
        Action_Btn.click();
        send_Updated_repair_authorisation.click();
        Next_Button.click();
        sendEmail_Btn.click();
        assertThat(email_Success_Msg.isDisplayed()).
                as("Confirmation email is not send");
        CloseEmailSuccess_Btn.click();
        System.out.println();




    }
}
