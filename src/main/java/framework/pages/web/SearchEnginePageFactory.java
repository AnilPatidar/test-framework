package framework.pages.web;

import framework.enums.SearchEngine;
import framework.pages.web.searchengine.BingHomePage;
import framework.pages.web.searchengine.GoogleHomePage;
import framework.pages.web.searchengine.SearchEnginePage;
import org.openqa.selenium.WebDriver;

public class SearchEnginePageFactory {

    public static SearchEnginePage getSearchEngine(WebDriver driver, SearchEngine engine){
        switch (engine){
            case GOOGLE:
                    return new GoogleHomePage(driver);
            case BING:
                    return new BingHomePage(driver);
            default:
                throw new RuntimeException("Please provide supported search engine :  Google/Bing");
        }
    }

}
