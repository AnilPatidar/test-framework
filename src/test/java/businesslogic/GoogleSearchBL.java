package businesslogic;

import framework.driver.WebDriverFactory;
import framework.enums.SearchEngine;
import framework.pages.web.SearchEnginePageFactory;
import framework.pages.web.searchengine.SearchEnginePage;
import framework.util.TestStates;
import io.cucumber.java.Scenario;
import org.testng.Assert;

import java.util.List;

public class GoogleSearchBL extends BaseBL{

    public GoogleSearchBL(Scenario scenarioParam) {
        super(scenarioParam);
    }

    public GoogleSearchBL searchAndGetAllResults(SearchEngine searchEngine){
        String articleTitle = String.valueOf(TestStates.getTestData().get("articleTitle"));
        SearchEnginePage googleSearch=SearchEnginePageFactory.getSearchEngine(WebDriverFactory.getDriver(), searchEngine);
        List<String> searchResults = googleSearch
                .openSearchEngine()
                .search(articleTitle)
                .getSearchResults();
        TestStates.getTestData().put("searchResult", searchResults);
        for (String result : searchResults) {
            scenario.log(String.format("Search results : %s",result));
        }
        return this;
    }

    public GoogleSearchBL verifyIfSimilarArticlesAreFound(Integer noOfArticle) {
        String query = (String) TestStates.getTestData().get("articleTitle");
        Assert.assertTrue(getNoOfValidResults(query) >= noOfArticle, String.format("The News %s is a fake news",query));
        return this;
    }


    public GoogleSearchBL verifyIfSimilarArticlesAreNotFound() {
        String query = (String) TestStates.getTestData().get("articleTitle");
        Assert.assertTrue(getNoOfValidResults(query) == 0, String.format("The News %s is a fake news",query));
        return this;
    }


}
