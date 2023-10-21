package stepdefinitions;

import framework.pages.web.NewsHomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebsiteTestStepDefinitions {

    private WebDriver driver;
    private NewsHomePage homePage;

    @Given("I am on The Guardian website")
    public void iAmOnTheGuardianWebsite() {
        System.out.println( "Thread Id "+ Thread.currentThread().getId());
        driver = new ChromeDriver();
        homePage = new NewsHomePage(driver);
        driver.get("https://www.theguardian.com/tone/news");
        String articleTitle = homePage.getFirstHeading().replaceAll("\\n", "");;
        System.out.println("News : "+articleTitle);
        // Search Google for the article title.
        driver.get("https://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys(articleTitle ); // Replace "example.com" with the site to search

        // Submit the search query.
        searchBox.sendKeys(Keys.RETURN);

        // Wait for search results to load.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("h3")));

        // Find and count the search results.
        for(WebElement el:driver.findElements(By.cssSelector("h3"))){
            System.out.println(el.getText());
        }
        int searchResultCount = driver.findElements(By.cssSelector("h3")).size();

        // If two or more similar articles are found, consider the first Guardian news article valid.
        if (searchResultCount >= 2) {
            System.out.println("The first Guardian news article is considered valid.");
        } else {
            System.out.println("The article may not be valid or there are not enough similar articles found.");
        }

        // Close the browser.
        driver.quit();

    }

    @When("I click on the first news article")
    public void iClickOnTheFirstNewsArticle() {
        throw new io.cucumber.java.PendingException();
    }

    @When("I collect the title and content of the article")
    public void iCollectTheTitleAndContentOfTheArticle() {
        throw new io.cucumber.java.PendingException();
    }

    @Then("I search Google for articles with the same title and content")
    public void iSearchGoogleForArticlesWithTheSameTitleAndContent() {
        throw new io.cucumber.java.PendingException();
    }

    @Then("I verify that at least {int} similar articles are found")
    public void iVerifyThatAtLeastSimilarArticlesAreFound(Integer int1) {
        throw new io.cucumber.java.PendingException();
    }

    @Then("the first Guardian news article is considered valid")
    public void theFirstGuardianNewsArticleIsConsideredValid() {
        throw new io.cucumber.java.PendingException();
    }
}
