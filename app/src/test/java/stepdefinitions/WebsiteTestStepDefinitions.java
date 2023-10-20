package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import stepdefinitions.core.BaseSteps;

import java.util.HashMap;

public class WebsiteTestStepDefinitions {


    @Given("I am on The Guardian website")
    public void iAmOnTheGuardianWebsite() {
        throw new io.cucumber.java.PendingException();
    }

    @When("I click on the first news article")
    public void iClickOnTheFirstNewsArticle() {
        throw new io.cucumber.java.PendingException();
    }

    @When("I collect the title and content of the article")
    public void iCollectTheTitleAndContentOfTheArticle() {
        throw new io.cucumber.java.PendingException();
    }

    @Then("I search Google for articles with the same title and content")
    public void iSearchGoogleForArticlesWithTheSameTitleAndContent() {
        throw new io.cucumber.java.PendingException();
    }

    @Then("I verify that at least {int} similar articles are found")
    public void iVerifyThatAtLeastSimilarArticlesAreFound(Integer int1) {
        throw new io.cucumber.java.PendingException();
    }

    @Then("the first Guardian news article is considered valid")
    public void theFirstGuardianNewsArticleIsConsideredValid() {
        throw new io.cucumber.java.PendingException();
    }
}
