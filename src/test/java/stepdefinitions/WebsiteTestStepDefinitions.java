package stepdefinitions;

import framework.driver.WebDriverFactory;
import framework.pages.web.GoogleHomePage;
import framework.pages.web.NewsHomePage;
import framework.util.ConfigReader;
import framework.util.TestStates;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import stepdefinitions.core.Hooks;

public class WebsiteTestStepDefinitions {

    private NewsHomePage homePage;
    private GoogleHomePage googleSearch;
    private Hooks hooks= new Hooks();

    @Given("I am on The Guardian website")
    public void iAmOnTheGuardianWebsite() {
        homePage = new NewsHomePage(WebDriverFactory.getDriver());
        Scenario scenario= hooks.getScenario();
        scenario.log("Opening news home page");
        homePage.openNewsHome();
        scenario.log("Running on "+ConfigReader.getBrowserType());
    }


    @When("I collect the title and content of the article")
    public void iCollectTheTitleAndContentOfTheArticle() {
        hooks.getScenario().log("Collecting news heading");
        String articleTitle = homePage
                .getFirstHeading()
                .replaceAll("\\n", "");;
        System.out.println("News : "+articleTitle);
        TestStates.getTestData().put("articleTitle", articleTitle);


    }

    @Then("I search Google for articles with the same title and content")
    public void iSearchGoogleForArticlesWithTheSameTitleAndContent() {
        String articleTitle = String.valueOf(TestStates.getTestData().get("articleTitle"));
        googleSearch= new GoogleHomePage(WebDriverFactory.getDriver());
        int searchResultCount = googleSearch
                                    .openGoogleSearch()
                                            .search(articleTitle)
                                                .getSearchResults();
        TestStates.getTestData().put("searchResultCount", searchResultCount);

    }

    @Then("I verify that at least {int} similar articles are found")
    public void iVerifyThatAtLeastSimilarArticlesAreFound(Integer int1) {
        int searchResultCount = (int) TestStates.getTestData().get("searchResultCount");
        // If two or more similar articles are found, consider the first Guardian news article valid.
        if (searchResultCount >= 2) {
            System.out.println("The first Guardian news article is considered valid.");
        } else {
            System.out.println("The article may not be valid or there are not enough similar articles found.");
        }
    }

    @Then("the first Guardian news article is considered valid")
    public void theFirstGuardianNewsArticleIsConsideredValid() {

    }
}
