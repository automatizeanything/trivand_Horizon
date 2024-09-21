package com.horizon.stepdefinitions.steps;

import com.horizon.pages.common.HomePage;
import com.horizon.pages.handler.Handler_DashBoardPage;
import net.serenitybdd.annotations.Step;

public class HomeSteps {
    Handler_DashBoardPage handler_DashBoardPage;

    @Step("I navigate to the claims subtab in Home tab")
    public void NavigateToSubtabs(String SubTab, String Tab) {
        handler_DashBoardPage.NavigateToAnySubtabs(SubTab,Tab);
    }

    @Step("I choose the widget")
    public void iChooseTheWidget(String widget) {
        handler_DashBoardPage.ChooseTheWidget(widget);
    }
}
