package stepdefinitions.core;

import framework.driver.WebDriverFactory;
import framework.model.BrowserType;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.IOException;
import java.util.HashMap;

public class Hooks {

    private static HashMap<Integer,Scenario> scenarios;

    public Hooks(){
        if(scenarios == null)
            scenarios = new HashMap<Integer,Scenario>();
    }

    @Before
    public void beforeHook(Scenario scenario) {
        addScenario(scenario);
        WebDriverFactory.initDriver(BrowserType.CHROME);
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


    private void addScenario(Scenario scenario){
        Thread currentThread = Thread.currentThread();
        int threadID = currentThread.hashCode();
        scenarios.put(threadID,scenario);
    }

    public synchronized Scenario getScenario(){
        Thread currentThread = Thread.currentThread();
        int threadID = currentThread.hashCode();
        return scenarios.get(threadID);
    }


}
