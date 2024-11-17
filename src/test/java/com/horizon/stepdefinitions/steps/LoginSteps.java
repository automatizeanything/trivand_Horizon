package com.horizon.stepdefinitions.steps;

import com.horizon.pages.common.HomePage;
import com.horizon.pages.common.LoginPage;
import net.serenitybdd.annotations.Step;

public class LoginSteps {

    LoginPage loginPage;
    HomePage homePage;

    @Step("Open the Horizon login page")
    public void loadLoginPage() {
        loginPage.open();
    }
    @Step("I login into Horizon application")
    public void loginToHorizonApp(String userType) {
        loginPage.loginToGID(userType);
    }
    @Step("I login into Horizon application as a {string} {string}")
    public void loginToHorizonApp(String brand, String userType) {
        homePage.loginToHorizon(brand, userType);
    }
    @Step("login with invalid credentials")
    public void loginInvalidCredentials() {
        loginPage.validateInvalidLogin();
    }

    public void ZoomOutThePageToASmallerSize() {
        loginPage.ZoomOutThePageToASmallerSize();

    }
}