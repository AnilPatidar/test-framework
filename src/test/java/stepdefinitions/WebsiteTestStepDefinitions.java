package stepdefinitions;

import framework.driver.WebDriverFactory;
import framework.pages.web.GoogleHomePage;
import framework.pages.web.NewsHomePage;
import framework.util.TestStates;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WebsiteTestStepDefinitions {

    private NewsHomePage homePage;
    private GoogleHomePage googleSearch;


    @Given("I am on The Guardian website")
    public void iAmOnTheGuardianWebsite() {
        homePage = new NewsHomePage(WebDriverFactory.initDriver("chrome"));
        homePage.openNewsHome();
    }


    @When("I collect the title and content of the article")
    public void iCollectTheTitleAndContentOfTheArticle() {
        String articleTitle = homePage
                .getFirstHeading()
                .replaceAll("\\n", "");;
        System.out.println("News : "+articleTitle);
        TestStates.getScenarioVariables().put("articleTitle", articleTitle);


    }

    @Then("I search Google for articles with the same title and content")
    public void iSearchGoogleForArticlesWithTheSameTitleAndContent() {
        String articleTitle = String.valueOf(TestStates.getScenarioVariables().get("articleTitle"));
        googleSearch= new GoogleHomePage(WebDriverFactory.getDriver());
        int searchResultCount = googleSearch
                                    .openGoogleSearch()
                                            .search(articleTitle)
                                                .getSearchResults();
        TestStates.getScenarioVariables().put("searchResultCount", searchResultCount);

    }

    @Then("I verify that at least {int} similar articles are found")
    public void iVerifyThatAtLeastSimilarArticlesAreFound(Integer int1) {
        int searchResultCount = (int) TestStates.getScenarioVariables().get("searchResultCount");
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
