package com.gid.stepdefinitions.steps;

import com.gid.pages.AdministrationPage;
import com.gid.pages.DashBoardPage;
import net.serenitybdd.annotations.Step;

public class AdministrationSteps {

    AdministrationPage administrationPage;

    @Step("Navigate to administration page")
    public void navigateToAdministrationPage(String page) {
        administrationPage.clickOnAdministrationHeaderLink();
        if(!page.equalsIgnoreCase("Administration")) {
            administrationPage.navigateToAdministrationPage(page);
            if (page.equalsIgnoreCase("Territories"))
                page = "Territory/Handover Points";
            else if (page.equalsIgnoreCase("Company")) {
                page = "All Companies";
            }
            administrationPage.waitForAdministrationPage(page);
            administrationPage.verifyAdministratorL1MenuView();
        }
    }

}