package trelloApi.stepdefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class TrelloSteps {

    @Given("The test board exists and contains the correct information")
    public void getBoardAndCheckInfo(){
        System.out.println("We check the board!");
    }

    @When("I change the board title to {string}")
    public void changeBoardTitle(String name){
        System.out.println("The new name is " + name);
    }

    @When("I check that the board name was updated to {string}")
    public void checkBoardTitle(String name){
        System.out.println("Checking if title is " + name);
    }

    @Then("I add a list with title {string} to the board")
    public void addNewList(String name){
        System.out.println("Creating a new list with name " + name);
    }

}
