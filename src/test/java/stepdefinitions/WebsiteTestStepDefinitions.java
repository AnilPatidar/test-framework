package stepdefinitions;

import businesslogic.GoogleSearchBL;
import businesslogic.GuardianWebsiteBL;
import framework.driver.WebDriverFactory;
import framework.pages.web.GoogleHomePage;
import framework.pages.web.NewsHomePage;
import framework.util.TestStates;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.*;

public class WebsiteTestStepDefinitions {

    private NewsHomePage homePage;
    private GoogleHomePage googleSearch;
    private Scenario scenario;


    @Before
    public void setup(Scenario scenario) {
        this.scenario = scenario;
    }


    @Given("I am on The Guardian website")
    public void iAmOnTheGuardianWebsite() {
            new GuardianWebsiteBL(scenario)
                    .navigateToNewsHome();
    }

    @When("I collect the title and content of the article")
    public void iCollectTheTitleAndContentOfTheArticle() {
        new GuardianWebsiteBL(scenario)
                .getFirstNewsHeading();
    }

    @Then("I search Google for articles with the same title and content")
    public void iSearchGoogleForArticlesWithTheSameTitleAndContent() {
        new GoogleSearchBL(scenario)
                .searchAndGetAllResults();
    }

    @Then("I verify that at least {int} similar articles are found")
    public void iVerifyThatAtLeastSimilarArticlesAreFound(Integer noOfArticle) {
        new GoogleSearchBL(scenario)
                .verifyIfSimilarArticlesAreFound(noOfArticle);
    }

    @Then("the first Guardian news article is considered valid")
    public void theFirstGuardianNewsArticleIsConsideredValid() {

    }

}
