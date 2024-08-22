package com.gid.utility;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.steps.StepEventBus;
import net.thucydides.model.domain.TestTag;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Fail.fail;

public class CommonMethods extends PageObject {
    private @FindBy(xpath = "//div[contains(@class,'p-dropdown-items-wrapper')]")
    WebElementFacade dropDownList;
    private @FindBy(xpath = "//input[@role='textbox']")
    WebElementFacade multiSelectDropDown;
    private @FindBy(xpath = " //button[contains(@class,'multiselect-close')]")
    WebElementFacade multiSelectClose;
    private @FindBy(xpath = "//p-toastitem/div/div/div/div[2]")
    WebElementFacade confirmationMessage;
    private @FindBy(xpath = "//img[contains(@src,'profile-image')]")
    WebElementFacade profile_pic_label;
    private @FindBy(xpath = "//span[contains(text(),'Logout')]")
    WebElementFacade logout_label;
    private @FindBy(xpath = "//div[contains(@class,'loading-text')]")
    List<WebElementFacade> loadingPopUp;



    protected JavascriptExecutor jsExecutor=(JavascriptExecutor)getDriver();
    protected WebDriverWait wait=new WebDriverWait(getDriver(),Duration.ofSeconds(100));

    public void selectValueFromDropDown(WebElement dropdown, String value) {
        dropdown.click();
        waitABit(4000);
        waitFor(dropDownList);
        getDriver().findElement(By.xpath("//li[contains(.,'" + value + "')]")).click();
    }

    public void selectFromMultiSelectDropDown(WebElementFacade dropdown, String value) {
        waitFor(dropdown);
        waitABit(4000);
        scrollWithJavaScript(dropdown);
        clickWithJavaScript(dropdown);
        waitFor(multiSelectDropDown);
        multiSelectDropDown.clear();
        waitABit(2000);
        typeInto(multiSelectDropDown, value);
        waitFor(multiSelectDropDown);
        if (getDriver().findElement(By.xpath("//p-multiselectitem/li/span")).getText().contains(value)) {
            getDriver().findElement(By.xpath("//li[contains(.,'" + value + "')]")).click();
            multiSelectClose.click();
        } else
            Assert.assertFalse(value + " value is not available in the dropdown", false);
    }

    public void verifyValidationMessage(String message) {
        waitABit(1000);
        WebElement validationMessage = getDriver().findElement(By.xpath("//label[contains(.,'" + message + "')]"));
        //label[contains(.,'Please Enter Damage Type')]
        waitFor(validationMessage);
        if (validationMessage.isDisplayed())
            assertThat(validationMessage.getText().trim()).
                    as("Validation message Text is not correct. Expected : " + message + " Actual : " + validationMessage.getText())
                    .isEqualToIgnoringCase(message);
        else
            assertThat(validationMessage.isDisplayed()).
                    as("Validation message is missing").isFalse();
        waitABit(1000);
    }

    public void verifyConfirmationMessage(String message) {
        if (!isCucumberTagAvailable("Login", "tag")) {
            waitABit(500);
        }
        waitFor(confirmationMessage);
        if (confirmationMessage.isCurrentlyVisible())
            assertThat(confirmationMessage.getText().trim()).
                    as("Confirmation message Text is not correct. Expected : " + message + " Actual : " + confirmationMessage.getText())
                    .isEqualToIgnoringCase(message);
        else
            assertThat(confirmationMessage.isCurrentlyVisible()).
                    as("Confirmation message is missing").isFalse();
        waitABit(1000);
    }

    public boolean isCucumberTagAvailable(String tageName, String tagType) {
        Set<TestTag> tags = StepEventBus.getEventBus().getBaseStepListener().latestTestOutcome().get().getTags();
        return tags.contains(TestTag.withName(tageName).andType(tagType));
    }

    public String getName(String Value) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMyyHHmm");
        return Value + simpleDateFormat.format(new Date());
    }

    public void enterValueInField(WebElement FieldLoc, String Fieldvalue) {
        waitFor(FieldLoc);
        typeInto(FieldLoc, Fieldvalue);
        waitABit(1000);
    }

    public void waitAndClick(WebElement element) {
        waitFor(element);
        clickOn(element);
    }

    public void performLogout() {
        waitAndClick(profile_pic_label);
        waitAndClick(logout_label);
        waitABit(4000);
    }

    public String randomNumbergenerator(int size) {
        Random rand = new Random();

        String str = rand.ints(48, 123)

                .filter(num -> (num < 58 || num > 64) && (num < 91 || num > 96))

                .limit(size)

                .mapToObj(c -> (char) c).collect(StringBuffer::new, StringBuffer::append, StringBuffer::append)

                .toString();

        return str;
    }

    public void waitForElementVisible(WebElement element, String WeElementname) {
        try {
            waitFor(element);
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            Assert.fail(WeElementname + " is not displayed");
        }
    }

    public void waitForElementVisible(String xpath, String WeElementname) {
        try {
            waitFor(getDriver().findElement(By.xpath(xpath)));
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            Assert.fail(WeElementname + " is not displayed");
        }
    }

    public void waitForElementClickable(WebElement element, String WeElementname) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            Assert.fail(WeElementname + " is not displayed");
        }
    }

    public void clickWithJavaScript(WebElementFacade element) {
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", element);
    }

    public void scrollWithJavaScript(WebElementFacade element) {
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void clickonAnyDate(List<WebElementFacade> date, String day) {
        for (WebElementFacade ele : date) {
            if (ele.getText().equalsIgnoreCase(day)) {
                ele.click();
                break;
            }

        }
    }

    public void assertValuePresentInElements(List<WebElementFacade> elements, String value) {
        boolean valueFound = false;
        for (WebElement element : elements) {
            if (element.getText().contains(value)) {
                valueFound = true;
                break;
            }
        }
        Assert.assertTrue("The value '" + value + "' is not present in the list of elements.", valueFound);
    }

    public String selectDropdownValueAtRuntime(WebElementFacade dropdownEle) {
        waitForElementVisible(dropdownEle, "dropdown element");
        dropdownEle.click();
        waitABit(2000);
        WebElement firstOption = getDriver().findElement(By.xpath("//p-dropdownitem/li/span[1]"));
        String firstOptionValue = firstOption.getText();
        firstOption.click();
        return firstOptionValue;

    }

    public String selectCheckBoxValueAtRuntime(WebElementFacade checkboxEle) {
        waitABit(3000);
        try {
            waitForElementVisible(checkboxEle, "dropdown element");
            //scrollWithJavaScript(checkboxEle);
            waitAndClick(checkboxEle);
        }catch (Exception e) {
            waitABit(2000);
            checkboxEle.click();
        }

        waitABit(3000);
        WebElement firstOption = getDriver().findElement(By.xpath("//p-multiselectitem/li/span[1]"));
        String firstOptionValue = firstOption.getText();
        waitAndClick(firstOption);
        //firstOption.click();
        getDriver().findElement(By.xpath("//span[contains(@class,'p-multiselect-close-icon')]")).click();
        return firstOptionValue;

    }

    public static void waitForPageToLoad(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Adjust timeout as needed
        wait.until(pageLoadCondition);
    }

    public void scrollIntoTheViewAndClick(WebElement element) {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        waitUntilWebElementIsVisible(element);
        element.click();

    }

    public void clickByJS(WebElement element) {
        jsExecutor.executeScript("arguments[0].click();", element);
    }

    public void waitUntilWebElementIsVisible(WebElement element) {
        try {
           this.wait.until(ExpectedConditions.visibilityOf(element));
        } catch (NoSuchElementException | TimeoutException e) {
            fail("WebElement is NOT visible, Exception: " + e.getMessage());
        }
    }
    public void waitForLoadingSymbolToDisappear()
    {
        try{
            for(int i=0;loadingPopUp.size()>0;i++)
            {
                waitABit(1000);
            }
        }catch(Exception e){

        }
    }

    public int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(1000);
    }

}
