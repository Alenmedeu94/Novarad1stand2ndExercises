package com.DS.step_definitions;

import com.DS.pages.HomePage;
import com.DS.utilities.ConfigurationReader;
import com.DS.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoanProStep_Def extends HomePage {
    private WebDriverWait wait = new WebDriverWait(Driver.getDriver(),30 );



    @Given("user in on the login page")
    public void user_in_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Driver.getDriver().manage().window().maximize();

    }
    @Then("verify controls displayed")
    public void verify_controls_displayed() {
        assert username.isDisplayed();
        assert password.isDisplayed();
        assert login.isDisplayed();

    }
    @When("user login to main page")
    public void user_login_to_main_page() {
        username.sendKeys(ConfigurationReader.getProperty("username"));
        password.sendKeys(ConfigurationReader.getProperty("password"));
        login.click();

    }
    @Then("user verifies correct url")
    public void user_verifies_correct_url() {
        String expectedUrl="https://beta-loanpro.simnang.com/client/app/index.php#/t_/797/loan/menu";
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        String actualUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
        System.out.println("actualUrl = " + actualUrl);

    }
    @Then("user validates controls on main page")
    public void user_validates_controls_on_main_page() {
        wait.until(ExpectedConditions.visibilityOf(reportBtn4));
        loans1.isDisplayed();
        assert imageCircle2.isDisplayed();
        assert newLoan3.isDisplayed();
        assert reportBtn4.isDisplayed();
        assert qaTestingTenant5.isDisplayed();

    }
    @Then("user searches loans by status “Approved”")
    public void user_searches_loans_by_status_approved() {
        loanStatus.click();
        wait.until(ExpectedConditions.elementToBeClickable(approved));
        approved.click();

    }
    @Then("user validates loan count with status approved")
    public void user_validates_loan_count_with_status_approved() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfAllElements(loansApprovedColumns));
        Thread.sleep(10000);//  to give extra time for page to load to give total list size
        System.out.println("loansApprovedColumns.size() = " + loansApprovedColumns.size());
        for (WebElement eachApproved : loansApprovedColumns) {

        }
        int totalLoansApproved=Integer.parseInt(totalLoanResults.getText());
        System.out.println("totalLoansApproved = " + totalLoansApproved);
        Assert.assertEquals(totalLoansApproved,loansApprovedColumns.size());

    }


    }





