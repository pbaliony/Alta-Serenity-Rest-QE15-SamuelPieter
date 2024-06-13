package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.ReqresResponses;

import static org.hamcrest.Matchers.equalTo;

public class ListUsersSteps {

    @Steps
    ReqresAPI reqresAPI;

    @Given("Get list users with parameter page {int}")
    public void getListUsersWithParameterPage(int page) {
        reqresAPI.getListUsers(page);
    }

    @When("Send request get list users")
    public void sendRequestGetListUsers() {
        SerenityRest.when().get(ReqresAPI.LIST_USER);
    }

    @And("Response body page should be {int}")
    public void responseBdoyPageShouldBe(int page) {
        SerenityRest.and().body(ReqresResponses.Page, equalTo(page));
    }
}
