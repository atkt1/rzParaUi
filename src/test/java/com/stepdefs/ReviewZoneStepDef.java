package com.stepdefs;


import com.pages.ReviewZoneLandingPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class ReviewZoneStepDef {
    private static ThreadLocal<ReviewZoneLandingPage> rzLP = new ThreadLocal<>();

    @Given("^User launches new Browser$")
    public void launchBrowser(){
        rzLP.set(new ReviewZoneLandingPage());
        rzLP.get().openBrowser();
    }

    @And("User navigates to {string}")
    public void userNavigatesTo(String url) {
        rzLP.get().openUrl(url);
    }

    @And("User logs in with {string}")
    public void userLogsInWith(String user) {
        rzLP.get().loginWithUser(user);
    }

    @Then("User validates if the title of the page is {string}")
    public void userValidatesIfTheTitleOfThePageIs(String title) {
        Assert.assertTrue(rzLP.get().getTitle().equals(title), "Title of the webpage is not matching with:" + title + "!!");
    }
}
