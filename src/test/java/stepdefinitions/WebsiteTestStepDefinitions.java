package stepdefinitions;

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
   // private Hooks hooks= new Hooks();

    private Scenario scenario;

    @Before
    public void setup(Scenario scenario) {
        this.scenario = scenario;
    }


    @Given("I am on The Guardian website")
    public void iAmOnTheGuardianWebsite() {
        homePage = new NewsHomePage(WebDriverFactory.getDriver());
       // Scenario scenario= hooks.getScenario();
        scenario.log("Opening news home page");
        homePage.openNewsHome();
    }


    @When("I collect the title and content of the article")
    public void iCollectTheTitleAndContentOfTheArticle() {
        scenario.log("Collecting news heading");
        String articleTitle = homePage
                .getFirstHeading()
                .replaceAll("\\n", "");
        Assert.assertNotEquals(articleTitle, "NoNewsFound" , "No news found on the website");
        scenario.log("News Title: "+articleTitle);
        TestStates.getTestData().put("articleTitle", articleTitle);


    }

    @Then("I search Google for articles with the same title and content")
    public void iSearchGoogleForArticlesWithTheSameTitleAndContent() {
        String articleTitle = String.valueOf(TestStates.getTestData().get("articleTitle"));
        googleSearch= new GoogleHomePage(WebDriverFactory.getDriver());
        List<String> searchResults = googleSearch
                                    .openGoogleSearch()
                                            .search(articleTitle)
                                                .getSearchResults();
        TestStates.getTestData().put("searchResult", searchResults);
        for (String result : searchResults) {
            scenario.log(String.format("Search results : %s",result));
        }
    }

    @Then("I verify that at least {int} similar articles are found")
    public void iVerifyThatAtLeastSimilarArticlesAreFound(Integer noOfArticle) {
        List<String> searchResults = (List<String>) TestStates.getTestData().get("searchResult");
        String query = (String) TestStates.getTestData().get("articleTitle");
        int validResultsCount=0;
        for (String result : searchResults) {
            int relevanceScore = calculateRelevance(query, result);
            scenario.log(String.format("News '%s', match score : %d",result,relevanceScore));
            if (relevanceScore >= 50) {
                validResultsCount++;
                if(validResultsCount ==2){
                    break;
                }
            }
        }
        scenario.log(String.format("No of valid news found : %d",validResultsCount));
        Assert.assertTrue(validResultsCount >= noOfArticle, String.format("The News %s is a fake news",query));
    }

    @Then("the first Guardian news article is considered valid")
    public void theFirstGuardianNewsArticleIsConsideredValid() {

    }


    // Calculate relevance score based on keyword matching
    public static int calculateRelevance(String query, String result) {
        Set<String> queryKeywords = new HashSet<>(Arrays.asList(query.toLowerCase().split(" ")));
        int totalKeywords = queryKeywords.size();
        Set<String> resultWords = new HashSet<>(Arrays.asList(result.toLowerCase().split(" ")));
        queryKeywords.retainAll(resultWords);
        int matchCount = queryKeywords.size();
        try {
            return (matchCount * 100) / totalKeywords;
        }catch (ArithmeticException e){
            return 0;
        }
    }

}
