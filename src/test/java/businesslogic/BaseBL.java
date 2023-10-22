package businesslogic;

import io.cucumber.java.Scenario;

public class BaseBL {

    protected Scenario scenario ;
    public BaseBL(Scenario scenarioParam) {
        scenario = scenarioParam;
    }
}
