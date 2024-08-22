package com.gid.stepdefinitions;

import com.gid.stepdefinitions.steps.AdminDashBoardSteps;
import com.gid.stepdefinitions.steps.AdministrationSteps;
import com.gid.stepdefinitions.steps.LoginSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.annotations.Steps;

public class AdministrationPageSteps {

    @Steps
    AdministrationSteps administrationSteps;


    @And("I can navigate to {string} administration page")
    public void navigateToAdministrationPage(String page) {
        administrationSteps.navigateToAdministrationPage(page);
    }
}