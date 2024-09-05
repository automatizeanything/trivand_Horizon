package com.horizon.pages.common;


import com.horizon.utility.CommonMethods;
import com.horizon.utility.Constant;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.annotations.DefaultUrl;
import net.thucydides.model.util.EnvironmentVariables;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("page:webdriver.base.url")
public class HomePage extends PageObject {

    private @FindBy(xpath = "//input[@id='user_email']")
    WebElementFacade userNameField;
    private @FindBy(xpath = "//input[@id='user_password']")
    WebElement passwordField;
    private @FindBy(xpath = "//div/input[@value='Login']")
    WebElement loginButton;

    CommonMethods commonMethods = new CommonMethods();
    private EnvironmentVariables environmentVariables;

    public void loginToGID(String userType) {
        if(userType.contains("Created"))
            enterRuntimeCreatedUserDetails(userType);
        else {
            Serenity.setSessionVariable("UserName").to(getUserName(userType));
            userNameField.sendKeys(getUserName(userType));
        }
        if(userType.equalsIgnoreCase("Admin"))
            passwordField.sendKeys(getPassword());
        else
            passwordField.sendKeys("Surveyor@123");
        loginButton.click();
        commonMethods.waitForPageToLoad(getDriver());
    }
    public void loginToHorizon(String brand, String userType) {
        Serenity.setSessionVariable("UserName").to(getUserName(brand+userType));
        Serenity.setSessionVariable("brandName").to(brand);
        userNameField.sendKeys(getUserName(brand+userType));
        passwordField.sendKeys(getPassword());
        loginButton.click();
        commonMethods.waitForPageToLoad(getDriver());
    }
    private void enterRuntimeCreatedUserDetails(String userType) {
        String userName=userType.split("Created")[1];
        userNameField.sendKeys(Serenity.sessionVariableCalled(userName+ "EmailId").toString());
        System.out.println("test");
    }
    public void validateInvalidLogin() {
        commonMethods.verifyValidationMessage(Constant.INVALID_LOGIN_VALIDATION_MESSAGE);
    }
    private String getUserName(String userType){
        if(!commonMethods.isCucumberTagAvailable("InValidCredentials","tag"))
            return EnvironmentSpecificConfiguration.from(environmentVariables)
                    .getProperty(userType+".user");
        else
            return EnvironmentSpecificConfiguration.from(environmentVariables)
                    .getProperty(userType+".user")+"test";
    }
    private String getPassword() {
            return System.getProperty("password");
    }
}
