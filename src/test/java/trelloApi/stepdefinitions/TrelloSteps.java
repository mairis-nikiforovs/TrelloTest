package trelloApi.stepdefinitions;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import trelloApi.domain.Board;
import trelloApi.domain.List;
import trelloApi.helpers.TestCaseContext;

import static trelloApi.clients.TrelloClient.*;
import static trelloApi.constants.ProjectConstants.BOARD_ID;


public class TrelloSteps {

    @Given("The test board exists and contains the correct information")
    public void getBoardAndCheckInfo(){
        Response resp = gedBoardInfo();
        Board defaultBoard = resp.as(Board.class);

        Assertions.assertThat(defaultBoard.getId())
                .as("We assert that the default board id is correct")
                .isEqualTo(BOARD_ID);

        Assertions.assertThat(defaultBoard.getName())
                .as("I check that the board name is correct")
                .isEqualTo("Default"); //Here provide your board name

        TestCaseContext.setBoard(defaultBoard);
    }

    @When("I change the board title to {string}")
    public void changeBoardTitle(String name){
        Response resp = changeBoardName(name);
        Board board = resp.as(Board.class);
        TestCaseContext.setBoard(board);
        Scenario scenario = TestCaseContext.getScenario();
        scenario.log("We are changing the name to " + name );
    }

    @When("I check that the board name was updated to {string}")
    public void checkBoardTitle(String name){
        Board testBoard = TestCaseContext.getBoard();

        Assertions.assertThat(testBoard.getName())
                .as("Checking if the Board name was updated!")
                .isEqualTo(name);
    }

    @Then("I add a list with title {string} to the board")
    public void addNewList(String name){
        Response resp = createList(name);
        List myList = resp.as(List.class);
        TestCaseContext.setList(myList);
    }

}
