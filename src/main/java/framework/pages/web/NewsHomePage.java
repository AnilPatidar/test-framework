package framework.pages.web;

import framework.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class NewsHomePage extends BasePage {

    WebDriver driver;

    public NewsHomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath=".//a[@data-link-name='article']")
    private List<WebElement> newsHeadings;


    public String getFirstHeading(){
        if(newsHeadings.size()>0){
            return newsHeadings.get(0).getText();
        }else{
            return "NoNewsFound";
        }
    }

    public NewsHomePage openNewsHome(){
        driver.get(properties.getProperty("news.website.url"));
        return this;
    }


}
