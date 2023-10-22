package businesslogic;

import framework.util.ConfigReader;
import framework.util.TestStates;
import io.cucumber.java.Scenario;

import java.util.*;

public class BaseBL {

    protected Scenario scenario ;
    protected Properties properties;

    public BaseBL(Scenario scenarioParam) {
        scenario = scenarioParam;
        properties= ConfigReader.getInstance().readProperties();
    }

    protected int getNoOfValidResults(String query){
        List<String> searchResults = (List<String>) TestStates.getTestData().get("searchResult");
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
        return validResultsCount;
    }

    protected static int calculateRelevance(String query, String result) {
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
