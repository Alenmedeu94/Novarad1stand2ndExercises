package com.DS.step_definitions;

import com.DS.pages.HomePage;
import com.DS.utilities.ConfigurationReader;
import com.DS.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Arrays;
import java.util.List;


public class RegionsStep_Def extends HomePage {
    private WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);


    @Given("user in on the main page")
    public void user_in_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Driver.getDriver().manage().window().maximize();
    }

    @When("user navigates to Personal tab")
    public void verify_controls_displayed() {
        wait.until(ExpectedConditions.elementToBeClickable(acceptCookies)).click();
        wait.until(ExpectedConditions.visibilityOf(PersonalTab)).click();
    }

    @Then("user navigates to Online & Mobile Banking tab")
    public void user_login_to_main_page() {
        OnlineMobileBankingTab.click();
    }

    @Then("user clicks on Mobile banking")
    public void user_verifies_correct_url() {
        wait.until(ExpectedConditions.elementToBeClickable(MobileTab)).click();

    }

    @And("user scrolls down to More Resources")
    public void user_validates_controls_on_main_page() {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", moreResources);

    }

    @Then("user validates additional modules under More Resources")
    public void user_searches_loans_by_status_approved() {

        List<String> expectedModules = Arrays.asList("Digital Banking", "Online Banking", "Transfer Money and Pay", "Digital Services");

        for (WebElement eachModule : additionalModules) {
            System.out.println("eachModule.getText() = " + eachModule.getText());

            Assert.assertTrue(expectedModules.contains(eachModule.getText()));
        }


    }


}





