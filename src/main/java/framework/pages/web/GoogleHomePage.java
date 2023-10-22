package framework.pages.web;

import framework.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class GoogleHomePage extends BasePage {

    public GoogleHomePage(WebDriver driverObj){
        super(driverObj);
        PageFactory.initElements(driver, this);
    }

    @FindBy(name="q")
    private WebElement searchBox;

    //@FindBy(tagName="h3")
   // private List<WebElement> searchResults;

    By searchResults= By.tagName("h3");

    public GoogleHomePage openGoogleSearch(){
        driver.get(properties.getProperty("google.search.url"));
        return this;
    }

    public GoogleHomePage search(String searchQuery){
        searchBox.sendKeys(searchQuery );
        searchBox.sendKeys(Keys.RETURN);
        return this;
    }

    public List<String> getSearchResults(){
        waitUtils.wait(10);
        List<String> resultsHeading= new ArrayList<>();
        scrollUtil.scrollToElement(searchResults);
        waitUtils.waitForElementToBeVisible(searchResults,30);
        List<WebElement> results = driver.findElements(searchResults);
        for(WebElement el:results){
            String headline=el.getText();
            System.out.println(headline);
            resultsHeading.add(headline);
        }
        return resultsHeading;
    }

}
