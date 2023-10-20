package stepdefinitions.core;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.util.HashMap;

public class BaseSteps {

    private static HashMap<Integer,Scenario> scenarios;

    public BaseSteps(){
        if(scenarios == null)
            scenarios = new HashMap<Integer,Scenario>();
    }

    @Before
    public void beforeHook(Scenario scenario) {
        addScenario(scenario);
    }

    private void addScenario(Scenario scenario){
        Thread currentThread = Thread.currentThread();
        int threadID = currentThread.hashCode();
        scenarios.put(threadID,scenario);
    }

    protected synchronized Scenario getScenario(){
        Thread currentThread = Thread.currentThread();
        int threadID = currentThread.hashCode();
        return scenarios.get(threadID);
    }


}
