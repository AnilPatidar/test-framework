package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepdefinitions"},
        tags = "@Functional",
        plugin = {
                "pretty",
                "html:reports/tests/cucumber/cucumber-pretty.html",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "timeline:test-output-thread/"
        }
)
@Test
public class CucumberRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}





