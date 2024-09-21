package com.horizon.pages.handler;


import com.horizon.utility.CommonMethods;
import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("page:webdriver.base.url")
public class Handler_DashBoardPage extends PageObject {

    CommonMethods commonMethods;
    private @FindBy(xpath = "//div[text()='My New Claims to be Submitted']")
    WebElementFacade MyNewClaimstobeSubmitted;
    private @FindBy(xpath = "//i[@class='icon-home']/parent::a")
    WebElementFacade Home_Btn;

    public void NavigateToAnySubtabs(String subTab, String tab) {
        commonMethods.waitAndClick(Home_Btn);
        commonMethods.waitUntilWebElementIsVisible( getDriver().findElement
                (By.xpath("//a[text()='Administration']/parent::li[@class='active']")));
        getDriver().findElement(By.xpath("//a[text()='"+subTab+"']")).click();
        commonMethods.waitUntilWebElementIsVisible( getDriver().findElement
                (By.xpath("//a[text()='"+subTab+"']/parent::li[@class='active']")));

        //commonMethods.waitAndClick(MyNewClaimstobeSubmitted);
        System.out.println();

    }

    public void ChooseTheWidget(String widget) {
        waitABit(2000);
        commonMethods.scrollIntoTheViewAndClick( getDriver().findElement(By.xpath("//div[contains(text(),'"+widget+"')]")));

    }
}
