package stepdefinitions;

import framework.driver.WebDriverFactory;
import framework.enums.BrowserType;
import framework.util.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.IOException;
import java.util.Properties;

public class Hooks {

    private static Properties properties
                                = ConfigReader.getInstance().readProperties();

    @Before
    public void setup(Scenario scenario) {
        BrowserType browser= BrowserType.valueOf(System.getProperty("browser"
                                            ,properties.getProperty("browser.name")));
        WebDriverFactory.initDriver(browser);
    }

    @After(order = 0)
    public void tearDown(Scenario scenario) throws IOException {
        WebDriverFactory.quitDriver();
    }


    @After(order = 1)
    public void getScreenshotAs(Scenario scenario) {
        if (scenario.isFailed()) {
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            byte[] sourcePath = ((TakesScreenshot) WebDriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath, "image/png", screenshotName);
        }
    }

}
