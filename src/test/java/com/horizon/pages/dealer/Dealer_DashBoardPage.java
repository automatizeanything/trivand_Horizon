package com.horizon.pages.dealer;

import com.horizon.utility.CommonMethods;
import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

@DefaultUrl("/#/quicksightDashboard")
public class Dealer_DashBoardPage extends PageObject {

    private @FindBy(xpath = "//div[@class='dashboard']/div")
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
    private @FindBy(xpath = "//div[@class='dashboard-header']/img")
    WebElementFacade applicationLogo;
    private @FindBy(xpath = "//div[@class='dashboard']/div/h2")
    WebElementFacade dashBoardHeader;
    private @FindBy(xpath = "//div/a[contains(@href,'vehicle_details')]")
    WebElementFacade createNewClaimBtn;
    private @FindBy(xpath = "//div/fieldset//div[contains(text(),'To Action')]")
    WebElementFacade toActionSection;
    private @FindBy(xpath = "//div/fieldset//div[contains(text(),'For Information')]")
    WebElementFacade forInformationSection;
    private @FindBy(xpath = "//div[contains(text(),'To Action')]/following-sibling::div[contains(@class,'filters')]/a")
    List<WebElementFacade> toActionSectionFilters;
    private @FindBy(xpath = "//div[contains(text(),'For Information')]/following-sibling::div[contains(@class,'filters')]/a")
    List<WebElementFacade> forInformationSectionFilters;


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
                assertThat(getDriver().findElement(By.xpath("//a[contains(text(),'" + ItemValue + "')]")).getText())
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
    public void navigateToSpecificPage(String pageName) {
        waitFor("//ul/li/a[contains(text(),'" + pageName + "')]");
        commonMethods.clickLinkByText("//ul/li/a[contains(text(),'" + pageName + "')]");
    }
    public void verifyDealerDashBoardPage() {
        assertThat(applicationLogo.isCurrentlyVisible()).as("Application Logo is missing").isTrue();
        assertThat(dashBoardHeader.isCurrentlyVisible()).as("Dashboard Header is missing").isTrue();
        assertThat(createNewClaimBtn.isCurrentlyVisible()).
                as("Create New Claim button is missing in Dashboard page").isTrue();
        assertThat(toActionSection.isCurrentlyVisible()).
                as("To Action section is missing in Dashboard page").isTrue();
        assertThat(forInformationSection.isCurrentlyVisible()).
                as("For Information section is missing in Dashboard page").isTrue();
        assertThat(toActionSectionFilters.size()).as("To Action section does not contains any of the filters")
                .isNotEqualTo(0);
        assertThat(forInformationSectionFilters.size()).as("For Information section does not contains any of the filters")
                .isNotEqualTo(0);
        verifyToActionSection();
        verifyForInformationSection();
    }
    private void verifyToActionSection() {
        String manufacture = Serenity.sessionVariableCalled("brandName");
        if (manufacture.equals("Bentley")) {
            assertThat(toActionSectionFilters.size()).as("For " + manufacture + ", To Action section have some missing filters")
                    .isEqualTo(3);
            verifyDamagesReportedViaDVMAppToCompleteFilter();
            verifyIncompleteClaimsFilter();
            verifyClaimsAuthorisedPleaseRepairFilter();
        }

    }
    private void verifyDamagesReportedViaDVMAppToCompleteFilter() {
        boolean isFilterFound = false;
        WebElementFacade damagesReportedViaDVMFilter = null;
        for (WebElementFacade toActionFilter : toActionSectionFilters) {
            if (toActionFilter.getText().contains("Damages reported via DVM app to complete")) {
                damagesReportedViaDVMFilter = toActionFilter;
                //toActionFilter.click();
                isFilterFound = true;
                break;
            }
        }
        assertThat(isFilterFound).as("Damages reported via DVM app to complete - Filter is not found in the dashboard").isTrue();
        assertThat(damagesReportedViaDVMFilter.findElement(By.xpath(".//following-sibling::div")).isDisplayed())
                .as("Damages reported via DVM app to complete - Filter ToolTip is missing").isTrue();
        assertThat(damagesReportedViaDVMFilter.findElement(By.xpath(".//following-sibling::div[contains(@class,'counter')]/span")).isDisplayed())
                .as("Damages reported via DVM app to complete - Filter Counter value is missing").isTrue();
        Serenity.setSessionVariable(Serenity.sessionVariableCalled("brandName") + "_DVMAppCounterValue")
                .to(damagesReportedViaDVMFilter.findElement(By.xpath(".//following-sibling::div[contains(@class,'counter')]/span")).getText().trim());
    }
    private void verifyIncompleteClaimsFilter() {
        boolean isFilterFound = false;
        WebElementFacade incompleteClaimsFilter = null;
        for (WebElementFacade toActionFilter : toActionSectionFilters) {
            if (toActionFilter.getText().contains("Incomplete claims")) {
                incompleteClaimsFilter = toActionFilter;
                isFilterFound = true;
                break;
            }
        }
        assertThat(isFilterFound).as("Incomplete claims - Filter is not found in the dashboard").isTrue();
        assertThat(incompleteClaimsFilter.findElement(By.xpath(".//following-sibling::div")).isDisplayed())
                .as("Incomplete claims - Filter ToolTip is missing").isTrue();
        assertThat(incompleteClaimsFilter.findElement(By.xpath(".//following-sibling::div[contains(@class,'counter')]/span")).isDisplayed())
                .as("Incomplete claims - Filter Counter value is missing").isTrue();
        Serenity.setSessionVariable(Serenity.sessionVariableCalled("brandName").toString() + "_IncompleteClaimsCounterValue")
                .to(incompleteClaimsFilter.findElement(By.xpath(".//following-sibling::div[contains(@class,'counter')]/span")).getText().trim());
    }
    public void validateSpecificFilterDetails(String filterType) {
        switch (filterType) {
            case "Incomplete Claims":
                validateIncompleteClaimsFilterDetails();
                break;
            case "Claims Authorised; Please Repair":
                validateClaimsAuthorisedPleaseRepairFilterDetails();
                break;
            case "Claims Awaiting Authorisation":
                validateClaimsAwaitingAuthorisationFilterDetails();
                break;
            case "Rejected Claims":
                validateRejectedClaimsFilterDetails();
                break;
            case "Invoices Sent; Awaiting Payment":
                validateInvoicesSentAwaitingPaymentFilterDetails();
                break;
        }
    }
    private void validateInvoicesSentAwaitingPaymentFilterDetails() {
        String brandName = Serenity.sessionVariableCalled("brandName").toString();
        boolean isFilterFound = false;
        WebElementFacade invoicesSentAwaitingPaymentFilter = null;
        for (WebElementFacade forInformationFilter : forInformationSectionFilters) {
            if (forInformationFilter.getText().contains("Invoices Sent; Awaiting Payment")) {
                invoicesSentAwaitingPaymentFilter = forInformationFilter;
                isFilterFound = true;
                break;
            }
        }
        assertThat(isFilterFound).as("Invoices Sent; Awaiting Payment - Filter is not found in the dashboard").isTrue();
        assertThat(Serenity.sessionVariableCalled(brandName + "_invoicesSentAwaitingPaymentCounterValue").toString()).
                as("Invoices Sent; Awaiting Payment Filter not updated. Its value is still" + Serenity.sessionVariableCalled(brandName + "_invoicesSentAwaitingPaymentCounterValue").toString())
                .isNotEqualTo(invoicesSentAwaitingPaymentFilter.findElement(By.xpath(".//following-sibling::div[contains(@class,'counter')]/span")).getText().trim());
        waitFor(invoicesSentAwaitingPaymentFilter);
        commonMethods.clickWithJavaScript(invoicesSentAwaitingPaymentFilter);
    }
    private void validateRejectedClaimsFilterDetails() {
        String brandName = Serenity.sessionVariableCalled("brandName").toString();
        boolean isFilterFound = false;
        WebElementFacade rejectedClaimsFilter = null;
        for (WebElementFacade forInformationFilter : forInformationSectionFilters) {
            if (forInformationFilter.getText().contains("Rejected Claims")) {
                rejectedClaimsFilter = forInformationFilter;
                isFilterFound = true;
                break;
            }
        }
        assertThat(isFilterFound).as("Rejected Claims - Filter is not found in the dashboard").isTrue();
        assertThat(Serenity.sessionVariableCalled(brandName + "_rejectedClaimsCounterValue").toString()).
                as("Rejected Claims Filter not updated. Its value is still" + Serenity.sessionVariableCalled(brandName + "_rejectedClaimsCounterValue").toString())
                .isNotEqualTo(rejectedClaimsFilter.findElement(By.xpath(".//following-sibling::div[contains(@class,'counter')]/span")).getText().trim());
        waitFor(rejectedClaimsFilter);
        commonMethods.clickWithJavaScript(rejectedClaimsFilter);
    }
    private void validateClaimsAuthorisedPleaseRepairFilterDetails() {
        String brandName = Serenity.sessionVariableCalled("brandName").toString();
        boolean isFilterFound = false;
        WebElementFacade claimsAuthorisedPleaseRepairFilter = null;
        for (WebElementFacade toActionFilter : toActionSectionFilters) {
            if (toActionFilter.getText().contains("Claims Authorised; Please Repair")) {
                claimsAuthorisedPleaseRepairFilter = toActionFilter;
                isFilterFound = true;
                break;
            }
        }
        assertThat(isFilterFound).as("Claims Authorised; Please Repair - Filter is not found in the dashboard").isTrue();
        assertThat(Serenity.sessionVariableCalled(brandName + "_ClaimsAuthorisedCounterValue").toString()).
                as("Claims Authorised; Please Repair Filter not updated. Its value is still" + Serenity.sessionVariableCalled(brandName + "_ClaimsAuthorisedCounterValue").toString())
                .isNotEqualTo(claimsAuthorisedPleaseRepairFilter.findElement(By.xpath(".//following-sibling::div[contains(@class,'counter')]/span")).getText().trim());
        waitFor(claimsAuthorisedPleaseRepairFilter);
        commonMethods.clickWithJavaScript(claimsAuthorisedPleaseRepairFilter);
    }
    public void validateIncompleteClaimsFilterDetails() {
        String brandName = Serenity.sessionVariableCalled("brandName").toString();
        boolean isFilterFound = false;
        WebElementFacade incompleteClaimsFilter = null;
        for (WebElementFacade toActionFilter : toActionSectionFilters) {
            if (toActionFilter.getText().contains("Incomplete claims")) {
                incompleteClaimsFilter = toActionFilter;
                isFilterFound = true;
                break;
            }
        }
        assertThat(isFilterFound).as("Incomplete claims - Filter is not found in the dashboard").isTrue();
        assertThat(Serenity.sessionVariableCalled(brandName + "_IncompleteClaimsCounterValue").toString()).
                as("Incomplete Claims Filter not updated. Its value is still" + Serenity.sessionVariableCalled(brandName + "_IncompleteClaimsCounterValue").toString())
                .isNotEqualTo(incompleteClaimsFilter.findElement(By.xpath(".//following-sibling::div[contains(@class,'counter')]/span")).getText().trim());

        if (Objects.isNull(Serenity.sessionVariableCalled("isClaimSubmitted"))) {
            waitFor(incompleteClaimsFilter);
            commonMethods.clickWithJavaScript(incompleteClaimsFilter);
        }
    }
    public void validateClaimsAwaitingAuthorisationFilterDetails() {
        String brandName = Serenity.sessionVariableCalled("brandName").toString();
        boolean isFilterFound = false;
        WebElementFacade claimsAwaitingAuthorisationFilter = null;
        for (WebElementFacade forInformationFilter : forInformationSectionFilters) {
            if (forInformationFilter.getText().contains("Claims Awaiting Authorisation")) {
                claimsAwaitingAuthorisationFilter = forInformationFilter;
                isFilterFound = true;
                break;
            }
        }
        assertThat(isFilterFound).as("Incomplete claims - Filter is not found in the dashboard").isTrue();
        assertThat(Serenity.sessionVariableCalled(brandName + "_claimsAwaitingAuthorisationCounterValue").toString()).
                as("Claims Awaiting Authorisation Filter not updated. Its value is still" + Serenity.sessionVariableCalled(brandName + "_claimsAwaitingAuthorisationCounterValue").toString())
                .isNotEqualTo(claimsAwaitingAuthorisationFilter.findElement(By.xpath(".//following-sibling::div[contains(@class,'counter')]/span")).getText().trim());
        waitFor(claimsAwaitingAuthorisationFilter);
        commonMethods.clickWithJavaScript(claimsAwaitingAuthorisationFilter);
    }
    private void verifyClaimsAuthorisedPleaseRepairFilter() {
        boolean isFilterFound = false;
        WebElementFacade claimsAuthorisedFilter = null;
        for (WebElementFacade toActionFilter : toActionSectionFilters) {
            if (toActionFilter.getText().contains("Claims Authorised; Please Repair")) {
                claimsAuthorisedFilter = toActionFilter;
                //toActionFilter.click();
                isFilterFound = true;
                break;
            }
        }
        assertThat(isFilterFound).as("Claims Authorised; Please Repair - Filter is not found in the dashboard").isTrue();
        assertThat(claimsAuthorisedFilter.findElement(By.xpath(".//following-sibling::div")).isDisplayed())
                .as("Claims Authorised; Please Repair - Filter ToolTip is missing").isTrue();
        assertThat(claimsAuthorisedFilter.findElement(By.xpath(".//following-sibling::div[contains(@class,'counter')]/span")).isDisplayed())
                .as("Claims Authorised; Please Repair - Filter Counter value is missing").isTrue();
        Serenity.setSessionVariable(Serenity.sessionVariableCalled("brandName") + "_ClaimsAuthorisedCounterValue")
                .to(claimsAuthorisedFilter.findElement(By.xpath(".//following-sibling::div[contains(@class,'counter')]/span")).getText().trim());
    }
    private void verifyForInformationSection() {
        String manufacture = Serenity.sessionVariableCalled("brandName");
        if (manufacture.equals("Bentley")) {
            assertThat(forInformationSectionFilters.size()).as("For " + manufacture + ", For Information section have some missing filters")
                    .isEqualTo(5);
            verifyClaimsAwaitingAuthorisationFilter();
            verifyRejectedClaimsFilter();
            verifyRejectedClaimsFilter();
            verifyInvoicesSentAwaitingPaymentFilter();
            verifyClaimsPaidFilter();
            verifyInvoicesRejectedFilter();
        }
    }
    private void verifyInvoicesRejectedFilter() {
        boolean isFilterFound = false;
        WebElementFacade invoicesRejectedFilter = null;
        for (WebElementFacade toActionFilter : forInformationSectionFilters) {
            if (toActionFilter.getText().contains("Invoices Rejected")) {
                invoicesRejectedFilter = toActionFilter;
                //invoicesRejectedFilter.click();
                isFilterFound = true;
                break;
            }
        }
        assertThat(isFilterFound).as("Invoices Rejected - Filter is not found in the dashboard").isTrue();
        assertThat(invoicesRejectedFilter.findElement(By.xpath(".//following-sibling::div")).isDisplayed())
                .as("Invoices Rejected - Filter ToolTip is missing").isTrue();
        assertThat(invoicesRejectedFilter.findElement(By.xpath(".//following-sibling::div[contains(@class,'counter')]/span")).isDisplayed())
                .as("Invoices Rejected - Filter Counter value is missing").isTrue();
        Serenity.setSessionVariable(Serenity.sessionVariableCalled("brandName") + "_InvoicesRejectedCounterValue")
                .to(invoicesRejectedFilter.findElement(By.xpath(".//following-sibling::div[contains(@class,'counter')]/span")).getText().trim());
    }
    private void verifyClaimsPaidFilter() {
        boolean isFilterFound = false;
        WebElementFacade claimsPaidFilter = null;
        for (WebElementFacade toActionFilter : forInformationSectionFilters) {
            if (toActionFilter.getText().contains("Claims Paid")) {
                claimsPaidFilter = toActionFilter;
                //claimsPaidFilter.click();
                isFilterFound = true;
                break;
            }
        }
        assertThat(isFilterFound).as("Claims Paid - Filter is not found in the dashboard").isTrue();
        assertThat(claimsPaidFilter.findElement(By.xpath(".//following-sibling::div")).isDisplayed())
                .as("Claims Paid - Filter ToolTip is missing").isTrue();
        assertThat(claimsPaidFilter.findElement(By.xpath(".//following-sibling::div[contains(@class,'counter')]/span")).isDisplayed())
                .as("Claims Paid - Filter Counter value is missing").isTrue();
        Serenity.setSessionVariable(Serenity.sessionVariableCalled("brandName") + "_ClaimsPaidCounterValue")
                .to(claimsPaidFilter.findElement(By.xpath(".//following-sibling::div[contains(@class,'counter')]/span")).getText().trim());
    }
    private void verifyInvoicesSentAwaitingPaymentFilter() {
        boolean isFilterFound = false;
        WebElementFacade invoicesSentAwaitingPaymentFilter = null;
        for (WebElementFacade toActionFilter : forInformationSectionFilters) {
            if (toActionFilter.getText().contains("Claims Paid")) {
                invoicesSentAwaitingPaymentFilter = toActionFilter;
                //invoicesSentAwaitingPaymentFilter.click();
                isFilterFound = true;
                break;
            }
        }
        assertThat(isFilterFound).as("Invoices Sent Awaiting Payment - Filter is not found in the dashboard").isTrue();
        assertThat(invoicesSentAwaitingPaymentFilter.findElement(By.xpath(".//following-sibling::div")).isDisplayed())
                .as("Invoices Sent Awaiting Payment - Filter ToolTip is missing").isTrue();
        assertThat(invoicesSentAwaitingPaymentFilter.findElement(By.xpath(".//following-sibling::div[contains(@class,'counter')]/span")).isDisplayed())
                .as("Invoices Sent Awaiting Payment - Filter Counter value is missing").isTrue();
        Serenity.setSessionVariable(Serenity.sessionVariableCalled("brandName") + "_invoicesSentAwaitingPaymentCounterValue")
                .to(invoicesSentAwaitingPaymentFilter.findElement(By.xpath(".//following-sibling::div[contains(@class,'counter')]/span")).getText().trim());
    }
    private void verifyRejectedClaimsFilter() {
        boolean isFilterFound = false;
        WebElementFacade rejectedClaimsFilter = null;
        for (WebElementFacade toActionFilter : forInformationSectionFilters) {
            if (toActionFilter.getText().contains("Rejected Claims")) {
                rejectedClaimsFilter = toActionFilter;
                //rejectedClaimsFilter.click();
                isFilterFound = true;
                break;
            }
        }
        assertThat(isFilterFound).as("Rejected Claims - Filter is not found in the dashboard").isTrue();
        assertThat(rejectedClaimsFilter.findElement(By.xpath(".//following-sibling::div")).isDisplayed())
                .as("Rejected Claims - Filter ToolTip is missing").isTrue();
        assertThat(rejectedClaimsFilter.findElement(By.xpath(".//following-sibling::div[contains(@class,'counter')]/span")).isDisplayed())
                .as("Rejected Claims - Filter Counter value is missing").isTrue();
        Serenity.setSessionVariable(Serenity.sessionVariableCalled("brandName") + "_rejectedClaimsCounterValue")
                .to(rejectedClaimsFilter.findElement(By.xpath(".//following-sibling::div[contains(@class,'counter')]/span")).getText().trim());
    }
    private void verifyClaimsAwaitingAuthorisationFilter() {
        boolean isFilterFound = false;
        WebElementFacade claimsAwaitingAuthorisationFilter = null;
        for (WebElementFacade toActionFilter : forInformationSectionFilters) {
            if (toActionFilter.getText().contains("Claims Awaiting Authorisation")) {
                claimsAwaitingAuthorisationFilter = toActionFilter;
                //claimsAwaitingAuthorisationFilter.click();
                isFilterFound = true;
                break;
            }
        }
        assertThat(isFilterFound).as("Claims Awaiting Authorisation - Filter is not found in the dashboard").isTrue();
        assertThat(claimsAwaitingAuthorisationFilter.findElement(By.xpath(".//following-sibling::div")).isDisplayed())
                .as("Claims Awaiting Authorisation - Filter ToolTip is missing").isTrue();
        assertThat(claimsAwaitingAuthorisationFilter.findElement(By.xpath(".//following-sibling::div[contains(@class,'counter')]/span")).isDisplayed())
                .as("Claims Awaiting Authorisation - Filter Counter value is missing").isTrue();
        Serenity.setSessionVariable(Serenity.sessionVariableCalled("brandName") + "_claimsAwaitingAuthorisationCounterValue")
                .to(claimsAwaitingAuthorisationFilter.findElement(By.xpath(".//following-sibling::div[contains(@class,'counter')]/span")).getText().trim());
    }
}
