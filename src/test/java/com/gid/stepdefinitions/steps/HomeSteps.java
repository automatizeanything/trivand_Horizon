package com.gid.stepdefinitions.steps;

import com.gid.pages.HomePage;
import io.cucumber.java.en.And;
import net.serenitybdd.annotations.Step;

public class HomeSteps {


    HomePage homePage;

    @Step("I navigate to the claims subtab in Home tab")
    public void NavigateToSubtabs(String SubTab, String Tab) {
        homePage.NavigateToAnySubtabs(SubTab,Tab);
    }

    @Step("I choose the widget")
    public void iChooseTheWidget(String widget) {
        homePage.ChooseTheWidget(widget);
    }
}
