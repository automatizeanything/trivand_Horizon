package com.gid.stepdefinitions.steps;

import com.gid.pages.HomePage;
import net.serenitybdd.annotations.Step;

public class LoginSteps {

    HomePage homePage;

    @Step("Open the GID login page")
    public void loadLoginPage() {
        homePage.open();
    }

    @Step("I login into GID application")
    public void loginToGIDApp(String userType) {
        homePage.loginToGID(userType);
    }
    @Step("login with invalid credentials")
    public void loginInvalidCredentials() {
        homePage.validateInvalidLogin();

    }
}