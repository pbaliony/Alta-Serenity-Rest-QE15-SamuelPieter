package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.ReqresResponses;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class ResponsesSteps {

    @Steps
    ReqresAPI reqresAPI;

    @Then("Status code should be {int}")
    public void statusCodeShouldBe(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("Response body name should be {string} and job should be {string}")
    public void responseBodyNameShouldBeAndJobShouldBe(String name, String job) {
        SerenityRest.and().body(ReqresResponses.Name,equalTo(name) ).body(ReqresResponses.Job,equalTo(job));
    }

    @And("Response body email should be {string} and password should be {string}")
    public void responseBodyEmailShouldBeAndPasswordShouldBe(String email, String password) {
        SerenityRest.and().body(ReqresResponses.Email,equalTo(email)).body(ReqresResponses.Password,equalTo(password));
    }

    @And("Validate json schema {string}")
    public void validateJsonSchema(String fileName) {
        File jsonFile = new File(Constants.JSON_SCHEMA+fileName);
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    @And("Response body token should be {string}")
    public void responseBodyEmailShouldBe(String token) {
        SerenityRest.and().body(ReqresResponses.Token, equalTo(token));
    }
    @And("Response body should be {string}")
    public void responseBodyShouldBe(String error) {
        SerenityRest.and().body(ReqresResponses.Error,equalTo(error));
    }

    @And("Response body token should be {string} and id {int}")
    public void responseBodyTokenShouldBeAndId(String token, int id) {
        SerenityRest.and().body(ReqresResponses.Token,equalTo(token)).body(ReqresResponses.Id, equalTo(id));
    }
}
