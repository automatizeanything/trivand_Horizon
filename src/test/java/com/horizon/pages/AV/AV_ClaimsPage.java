package com.horizon.pages.AV;

import com.horizon.utility.CommonMethods;
import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DefaultUrl("/#/advanced_validation")
public class AV_ClaimsPage extends PageObject {

    CommonMethods commonMethods;
    private @FindBy(xpath = "//input[@class='input input-small clear_on_focus av_estimated_hours_part av-parts']")
    List<WebElementFacade> update_Parts_Field;
    private @FindBy(xpath = "//input[@id='total_av_estimate_attributes_parts_cost']")
    WebElementFacade av_EstimatePartCost;
    private @FindBy(xpath = "//input[@value='Ready for Submission']")
    WebElementFacade ReadyForSubmissionBtn;

    int partstotalValue=0;
    public void updateEstimatesByAV(String PartsValue) {

        for(WebElementFacade update_Parts_FieldEle :update_Parts_Field) {
            partstotalValue=partstotalValue+Integer.parseInt(PartsValue);
            commonMethods.scrollIntoTheViewAndClick(update_Parts_FieldEle);

            update_Parts_FieldEle.clear();
            update_Parts_FieldEle.sendKeys(PartsValue);
        }
            av_EstimatePartCost.clear();
            av_EstimatePartCost.sendKeys(String.valueOf(partstotalValue));
            Serenity.setSessionVariable("AV_Parts_Value").to(partstotalValue);
            ReadyForSubmissionBtn.click();
    }
}
