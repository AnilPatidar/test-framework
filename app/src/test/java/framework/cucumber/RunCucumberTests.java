package framework.cucumber;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(
        features = "src/test/resources/features",  // Specifying the directory where your feature files are located
        glue = {"stepdefinitions"}, // Specifying the package where your step definitions are located
        plugin = {"pretty","html:target/cucumber-reports.html"} // Specifying reporting options
)
@Test
public class RunCucumberTests extends AbstractTestNGCucumberTests {

}
