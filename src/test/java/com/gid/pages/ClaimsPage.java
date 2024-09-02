package com.gid.pages;

import com.gid.utility.CommonMethods;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.Assertions.assertThat;

public class ClaimsPage extends PageObject {


    CommonMethods commonMethods;
    private @FindBy(xpath = "//input[@value='Next']")
    WebElementFacade Next_Button;

    public void PerformTheClaimAuthorisation() {
        NavigateToCreatedClaim("984059");
        updateClientAndTerritory();
        updateVehicle();
        System.out.println();
        //continue from update Damage Items
    }

    public void NavigateToCreatedClaim(String claimID)
    {
        commonMethods.waitAndClick(getDriver().findElement(By.xpath(
                "//a[contains(@href,'claims') and text()='"+claimID+"']")));

    }

    public void updateClientAndTerritory()
    {
//        assertThat(verifytickMarkPresent("Client & Territory")).
//                as("Client & Territory is Selected by default").isEqualTo(0);
        commonMethods.scrollIntoTheViewAndClick(Next_Button);
        assertThat(verifytickMarkPresent("Client & Territory")).
                as("Client & Territory is Selected by default").isGreaterThan(0);
    }

    public void updateVehicle()
    {
        assertThat(verifytickMarkPresent("Vehicle")).
                as("Client & Territory is Selected by default").isEqualTo(0);
        commonMethods.scrollIntoTheViewAndClick(Next_Button);
        assertThat(verifytickMarkPresent("Vehicle")).
                as("Client & Territory is Selected by default").isGreaterThan(0);
    }

    public int verifytickMarkPresent(String SectionName) {
        int size=0;
        try {
              size = getDriver().findElements(
                    By.xpath(
                            "//a[contains(text(),'" + SectionName + "')]/i[@class='icon-ok']")).size();
            return size;
        }catch (Exception e) {
            return size;
        }
    }
}
