package com.gid.pages;

import com.gid.utility.CommonMethods;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DefaultUrl("/#/quicksightDashboard")
public class DashBoardPage extends PageObject {

    private @FindBy(xpath = "//div/app-admin-quicksightdashboard")
    WebElement adminDashBoard;
    private @FindBy(xpath = "//div[@class='p-inputgroup']/descendant::div[@aria-label='dropdown trigger']")
    WebElementFacade global_dropdown_Search;
    private @FindBy(xpath = "//input[@placeholder='Keyword']")
    WebElementFacade global_SearchField;
    private @FindBy(xpath = "//thead[@class='p-datatable-thead']/tr/th")
    List<WebElementFacade> row_Heading;
    private @FindBy(xpath = "//div[@aria-labelledby='LP']")
    WebElementFacade LP_Label;
    private @FindBy(xpath = "//div[@aria-labelledby='All']")
    WebElementFacade ALL_Label;



    CommonMethods commonMethods = new CommonMethods();
    String ItemValue = "";


    public void waitForDashBoard() {
        commonMethods.waitForLoadingSymbolToDisappear();
        waitForCondition().until(
                ExpectedConditions.visibilityOf(adminDashBoard)
        );
    }

    public void performGlobalSearch(String SearchType, String value) {
        ItemValue = value;
        if (!SearchType.equalsIgnoreCase("VIN")) {
            global_dropdown_Search.click();
            getDriver().findElement(By.xpath("//p-dropdownitem/descendant::span[text()='" + SearchType + "']")).click();
        }
        waitABit(5000);
        global_SearchField.sendKeys(value);
        global_SearchField.sendKeys(Keys.ENTER);
        waitABit(5000);


    }

    public void verifyTheDetailsDisplayed(String SearchType) {
        int UsersIndex = 0;
        switch (SearchType) {
            case "COMPANY":
                LP_Label.click();
                waitABit(2000);
                ALL_Label.click();
                waitABit(1000);
                assertThat(getDriver().findElement(By.xpath("//a[contains(text(),'"+ItemValue+"')]")).getText())
                        .as("User Value is Present").isEqualToIgnoringCase(ItemValue);
                break;
            case "USER":
                for (int i = 0; i < row_Heading.size(); i++) {
                    if (row_Heading.get(i).getText().equalsIgnoreCase("Users")) {
                        assertThat(getDriver().findElement(By.xpath(" //tbody[@class='p-element p-datatable-tbody']/tr/td[" + (i + 1) + "]")).getText())
                                .as("User Value is Present").isEqualToIgnoringCase(ItemValue);

                    }

                }

                break;
            case "VIN":
                List<WebElement> elements = new ArrayList<WebElement>();
                for (int i = 0; i < row_Heading.size(); i++) {

                    if (row_Heading.get(i).getText().equalsIgnoreCase(SearchType)) {
                        elements = getDriver().findElements(By.xpath(" //tbody[@class='p-element p-datatable-tbody']/tr/td[" + (i + 1) + "]"));


                    }

                }
                for (WebElement ele : elements) {

                    assertThat(ele.getText())
                            .as("VIN Value is Present").isEqualToIgnoringCase(ItemValue);
                }
                break;
            default:
                System.out.println("Invalid search type.");
        }
    }

}
