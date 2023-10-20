package stepdefinitions.core;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;


public class CucumberHooks {
    @After
    public final void tearDown(Scenario scenario) throws IOException {
        System.out.println("tear down called");
    }

}
