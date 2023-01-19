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
    @FindBy(id = "username")
    public WebElement username;
    @FindBy (id = "password")
    public WebElement password;
    @FindBy(xpath = "//button[.='Login']")
    public WebElement login;
    @FindBy(xpath = "//span[.='Loans'] ")
    public WebElement loans1;
    @FindBy(xpath = "//*[@id=\"loanStatus\"]")
    public WebElement loanStatus;
    @FindBy(xpath = "//*[@id=\"headerSection\"]/div[2]/md-menu/div[1]/a/img[1]")
    public WebElement imageCircle2;
    @FindBy(xpath = "//button[.='New Loan']")
    public  WebElement newLoan3;
    @FindBy(xpath = "(//a[contains(@class,'md-fab md-mini md-accent md-hue-3 md-lptheme-theme')])[1]")
    public  WebElement reportBtn4;
    @FindBy(xpath ="//span[.='QA Testing Tenant']")
    public  WebElement qaTestingTenant5;
    @FindBy(xpath = "//div[.='Approved'] ")
    public WebElement approved;
    @FindBy(xpath = "//td[@class='ng-binding' and .='Approved']")
    public List<WebElement> loansApprovedColumns;
    @FindBy(xpath = "//div[.='6']")
    public WebElement totalLoanResults;


}
