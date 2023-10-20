package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import stepdefinitions.core.BaseSteps;

import java.util.HashMap;

public class WebsiteTestStepDefinitions extends BaseSteps {


    @Given("I am on The Guardian website")
    public void i_am_on_the_guardian_website() {
        // TODO - Yet to be implemented
        Scenario scenario = getScenario();// Get a Scenario object
        scenario.log("Running i_am_on_the_guardian_website step");
        scenario.log("Opening the website");

        // Allure.addAttachment();
       // throw new io.cucumber.java.PendingException();

    }
    @When("I click on the first news article")
    public void i_click_on_the_first_news_article() {
        // TODO - Yet to be implemented
       // throw new io.cucumber.java.PendingException();
    }
    @When("I collect the title and content of the article")
    public void i_collect_the_title_and_content_of_the_article() {
        // TODO - Yet to be implemented
       // throw new io.cucumber.java.PendingException();
    }
    @Then("I search Google for articles with the same title and content")
    public void i_search_google_for_articles_with_the_same_title_and_content() {
        // TODO - Yet to be implemented
       // throw new io.cucumber.java.PendingException();
    }
    @Then("I verify that at least {int} similar articles are found")
    public void i_verify_that_at_least_similar_articles_are_found(Integer int1) {
        // TODO - Yet to be implemented
       // throw new io.cucumber.java.PendingException();
    }
    @Then("the first Guardian news article is considered valid")
    public void the_first_guardian_news_article_is_considered_valid() {
        // TODO - Yet to be implemented
        //throw new io.cucumber.java.PendingException();
    }

}
