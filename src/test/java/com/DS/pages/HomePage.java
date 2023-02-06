package com.DS.pages;

import com.DS.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class HomePage {
    public HomePage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "link-menu-personal")
    public WebElement PersonalTab;

    @FindBy(xpath = "(//*[contains(.,'I Understand')])[6]")
    public WebElement acceptCookies;

    @FindBy(xpath = "(//*[contains(.,'Online & Mobile Banking')])[14]")
    public WebElement OnlineMobileBankingTab;

    @FindBy(xpath = "//*[@id=\"main-nav-personal\"]/div/nav[1]/ul/li[3]/a")
    public WebElement MobileTab;

    @FindBy(xpath = "(//*[contains(.,'More Resources')])[9]")
    public  WebElement moreResources;

    @FindBy(xpath = "//*[@id=\"main-content\"]/div[6]/div/div")
    public List<WebElement> additionalModules;

}
