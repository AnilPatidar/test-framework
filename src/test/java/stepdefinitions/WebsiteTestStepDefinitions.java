package stepdefinitions;

import businesslogic.GoogleSearchBL;
import businesslogic.GuardianWebsiteBL;
import framework.enums.SearchEngine;
import framework.pages.web.searchengine.SearchEnginePage;
import framework.pages.web.NewsHomePage;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WebsiteTestStepDefinitions {

    private NewsHomePage homePage;
    private SearchEnginePage googleSearch;
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

    @Then("I search {string} for articles with the same title and content")
    public void iSearchGoogleForArticlesWithTheSameTitleAndContent(String search) {
        new GoogleSearchBL(scenario)
                .searchAndGetAllResults(SearchEngine.valueOf(search));
    }

    @Then("I verify that at least {int} similar articles are found")
    public void iVerifyThatAtLeastSimilarArticlesAreFound(Integer noOfArticle) {
        new GoogleSearchBL(scenario)
                .verifyIfSimilarArticlesAreFound(noOfArticle);
    }


    @Given("I have a fake news article from The Guardian")
    public void iHaveAFakeNewsArticleFromTheGuardian() {
          new GuardianWebsiteBL(scenario)
                  .setFakeNews();
    }

    @Then("the system should mark the news article as fake if no matching articles are found")
    public void theSystemShouldMarkTheNewsArticleAsUnverifiedIfNoMatchingArticlesAreFound() {
        new GoogleSearchBL(scenario)
                .verifyIfSimilarArticlesAreNotFound();
    }

}
