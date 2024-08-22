package com.gid.pages;

import com.gid.utility.CommonMethods;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.assertj.core.api.Assertions.assertThat;

@DefaultUrl("/#/administration/basics/company")
public class AdministrationPage extends PageObject {

    private @FindBy(xpath = "//li/a[contains(@href, '#/administration')]")
    WebElementFacade administrationHeaderLink;
    private @FindBy(linkText = "Company")
    WebElementFacade companyHeaderLink;
    private @FindBy(linkText = "Contract Variable")
    WebElementFacade contractVariableHeaderLink;
    private @FindBy(linkText = "Territories")
    WebElementFacade TerritoriesHeaderLink;
    private @FindBy(xpath = "//button[contains(@class,'p-element p-ripple p-button-rounded')]")
    WebElementFacade button;
    private @FindBy(xpath = "//button[contains(@class,'p-button-primary p-button')]")
    WebElementFacade button_company;

    CommonMethods commonMethods = new CommonMethods();
    public void clickOnAdministrationHeaderLink() {
        waitFor(administrationHeaderLink);
        clickOn(administrationHeaderLink);
    }

    public void navigateToAdministrationPage(String page) {
        commonMethods.waitForLoadingSymbolToDisappear();
        waitABit(5000);
        waitFor(companyHeaderLink);
        commonMethods.waitUntilWebElementIsVisible(companyHeaderLink);
        getDriver().findElement(By.partialLinkText(page)).click();
        commonMethods.waitForPageToLoad(getDriver());
    }

    public void waitForAdministrationPage(String page) {
        waitABit(3000);
        commonMethods.waitForLoadingSymbolToDisappear();
        WebElement pageText = getDriver().findElement(By.xpath("//div/h4[contains(.,'" + page + "')]"));
        waitForCondition().until(
                ExpectedConditions.visibilityOf(pageText)
        );
    }

    public void verifyAdministratorL1MenuView() {
        waitFor(companyHeaderLink);
        waitABit(1000);
        assertThat(companyHeaderLink.isCurrentlyVisible()).as("Administration Menu : Company header is missing")
                .isTrue();
        assertThat(contractVariableHeaderLink.isCurrentlyVisible()).as("Administration Menu : Contract Variable header is missing")
                .isTrue();
        assertThat(TerritoriesHeaderLink.isCurrentlyVisible()).as("Administration Menu : Territories header is missing")
                .isTrue();

    }

}
