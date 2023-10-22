package framework.pages.web.searchengine;

import framework.enums.SearchEngine;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleHomePage extends SearchEnginePage {

    @Override
    public SearchEnginePage openSearchEngine() {
        driver.get(properties.getProperty("google.search.url"));
        return this;
    }

    public GoogleHomePage(WebDriver driverObj) {
        super(driverObj);
        searchResults= By.tagName("h3");

    }
}
