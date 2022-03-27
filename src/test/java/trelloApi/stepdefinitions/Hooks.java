package trelloApi.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import trelloApi.helpers.TestCaseContext;

import static trelloApi.clients.TrelloClient.changeBoardName;
import static trelloApi.clients.TrelloClient.deleteList;

public class Hooks {

    @Before
    public void beforeEveryScenario(Scenario scenario){
        TestCaseContext.init();
        TestCaseContext.setScenario(scenario);
        System.out.println("THE SCENARIO IS BEGINNING THE EXECUTION!");
    }

    @After
    public void afterEveryScenario(){
        changeBoardName("Default");
        deleteList();
        System.out.println("THE SCENARIO IS FINISHED!");
    }

}
