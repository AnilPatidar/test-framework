package businesslogic;

import framework.driver.WebDriverFactory;
import framework.pages.web.NewsHomePage;
import framework.util.TestStates;
import io.cucumber.java.Scenario;
import org.testng.Assert;

public class GuardianWebsiteBL extends BaseBL{

    public GuardianWebsiteBL(Scenario scenarioParam) {
        super(scenarioParam);
    }

    public GuardianWebsiteBL navigateToNewsHome(){
        NewsHomePage homePage = new NewsHomePage(WebDriverFactory.getDriver());
        scenario.log("Opening news home page");
        homePage.openNewsHome();
        return  this;
    }

    public GuardianWebsiteBL getFirstNewsHeading() {
        scenario.log("Fetching first news titile");
        NewsHomePage homePage = new NewsHomePage(WebDriverFactory.getDriver());
        String articleTitle = homePage
                .getFirstHeading()
                .replaceAll("\\n", "");
        Assert.assertNotEquals(articleTitle, "NoNewsFound" , "No news found on the website");
        scenario.log("News Title: "+articleTitle);
        TestStates.getTestData().put("articleTitle", articleTitle);
        return  this;
    }

    public GuardianWebsiteBL setFakeNews(){
        TestStates.getTestData().put("articleTitle",properties.getProperty("fake.news.title") );
        return  this;
    }
}
