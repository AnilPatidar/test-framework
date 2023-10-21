package framework.pages.web;

import framework.pages.BasePage;
import framework.util.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Properties;

public class GoogleHomePage extends BasePage {

    private WebDriver driver;

    public GoogleHomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(name="q")
    private WebElement searchBox;

    @FindBy(name="h3")
    private List<WebElement> searchResults;

    public GoogleHomePage openGoogleSearch(){
        driver.get(properties.getProperty("google.search.url"));
        return this;
    }

    public GoogleHomePage search(String searchQuery){
        searchBox.sendKeys(searchQuery );
        searchBox.sendKeys(Keys.RETURN);
        return this;
    }

    public int getSearchResults(){
        for(WebElement el:searchResults){
            System.out.println(el.getText());
        }
        int searchResultCount =searchResults.size();
        return searchResultCount;
    }


    }
