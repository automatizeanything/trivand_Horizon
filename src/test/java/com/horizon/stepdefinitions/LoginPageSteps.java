package com.horizon.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import net.serenitybdd.annotations.Steps;
import com.horizon.stepdefinitions.steps.LoginSteps;

public class LoginPageSteps {

    @Steps
    LoginSteps loginSteps;


    @Given("I am in the login page of Horizon application")
    public void loadApplication() {
        loginSteps.loadLoginPage();
    }
    @And("I login into Horizon application as {string}")
    public void loadApplication(String userType) {
        loginSteps.loginToHorizonApp(userType);
    }
    @And("I login into Horizon application as a {string} {string}")
    public void loginHorizonApplication(String brand, String userType) {
        loginSteps.loginToHorizonApp(brand,userType);
    }
    @And("Login should be failed for invalid credentials")
    public void invalidCredentialCheck() {
        loginSteps.loginInvalidCredentials();
    }


    @And("i zoom out the page to a smaller size")
    public void iZoomOutThePageToASmallerSize() {
        loginSteps.ZoomOutThePageToASmallerSize();
    }
}