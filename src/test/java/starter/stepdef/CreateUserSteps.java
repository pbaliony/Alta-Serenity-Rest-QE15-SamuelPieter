package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.utils.Constants;

import java.io.File;

public class CreateUserSteps {
    @Steps
    ReqresAPI reqresAPI;
    @Given("Create new user with file json {string}")
    public void createNewUserWithFileJson(String fileName) {
        File FileJson = new File(Constants.REQ_BODY+fileName);
        reqresAPI.postCreateNewUser(FileJson);
    }

    @When("Send request post Create User")
    public void sendRequestPostCreateUser() {
        SerenityRest.when().post(ReqresAPI.CREATE_USER);
    }
}
