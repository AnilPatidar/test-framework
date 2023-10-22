package framework.pages.web.searchengine;

import framework.enums.SearchEngine;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BingHomePage  extends SearchEnginePage {

    @Override
    public SearchEnginePage openSearchEngine() {
        driver.get(properties.getProperty("bing.search.url"));
        return this;
    }

    public BingHomePage(WebDriver driverObj) {
        super(driverObj);
        searchResults= By.tagName("h2");
    }
}
