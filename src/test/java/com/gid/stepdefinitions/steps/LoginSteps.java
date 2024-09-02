package com.gid.stepdefinitions.steps;

import com.gid.pages.LoginPage;
import net.serenitybdd.annotations.Step;

public class LoginSteps {

    LoginPage loginPage;

    @Step("Open the Horizon login page")
    public void loadLoginPage() {
        loginPage.open();
    }

    @Step("I login into Horizon application")
    public void loginToHorizonApp(String userType) {
        loginPage.loginToGID(userType);
    }
    @Step("login with invalid credentials")
    public void loginInvalidCredentials() {
        loginPage.validateInvalidLogin();

    }
}