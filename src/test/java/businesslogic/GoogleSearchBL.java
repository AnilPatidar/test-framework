package businesslogic;

import framework.driver.WebDriverFactory;
import framework.pages.web.GoogleHomePage;
import framework.util.TestStates;
import io.cucumber.java.Scenario;
import org.testng.Assert;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GoogleSearchBL extends BaseBL{

    public GoogleSearchBL(Scenario scenarioParam) {
        super(scenarioParam);
    }

    public GoogleSearchBL searchAndGetAllResults(){
        String articleTitle = String.valueOf(TestStates.getTestData().get("articleTitle"));
        GoogleHomePage googleSearch= new GoogleHomePage(WebDriverFactory.getDriver());
        List<String> searchResults = googleSearch
                .openGoogleSearch()
                .search(articleTitle)
                .getSearchResults();
        TestStates.getTestData().put("searchResult", searchResults);
        for (String result : searchResults) {
            scenario.log(String.format("Search results : %s",result));
        }
        return this;
    }

    public GoogleSearchBL verifyIfSimilarArticlesAreFound(Integer noOfArticle) {
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
        return this;
    }


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
