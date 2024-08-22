package com.gid.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import com.gid.stepdefinitions.steps.LoginSteps;

public class LoginPageSteps {

    @Steps
    LoginSteps loginSteps;


    @Given("I am in the login page of GID application")
    public void loadApplication() {
        loginSteps.loadLoginPage();
    }

    @And("I login into GID application as {string}")
    public void loadApplication(String userType) {
        loginSteps.loginToGIDApp(userType);
    }

    @And("Login should be failed for invalid credentials")
    public void invalidCredentialCheck() {
        loginSteps.loginInvalidCredentials();
    }

}