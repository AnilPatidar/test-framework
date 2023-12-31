package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepdefinitions"},
        tags = "@functional and not @wip",
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
}





