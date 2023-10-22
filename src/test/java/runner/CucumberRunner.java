package runner;

import framework.enums.BrowserType;
import framework.util.TestStates;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;


@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepdefinitions"},
        tags = "@Functional",
        plugin = {
                "pretty",
                "html:reports/tests/cucumber/cucumber-pretty.html",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "timeline:reports/tests/test-output-thread/"
        },
        monochrome = true,
        dryRun = false
)
public class CucumberRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @BeforeTest
    @Parameters({"browser"})
    public void setBrowserType(BrowserType browserType){
        TestStates.setBrowserType(browserType);
    }
}





