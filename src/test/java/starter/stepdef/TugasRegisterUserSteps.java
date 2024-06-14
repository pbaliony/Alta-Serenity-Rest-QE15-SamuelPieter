package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.utils.Constants;

import java.io.File;

public class TugasRegisterUserSteps {
    @Steps
    ReqresAPI reqresAPI;
    @Given("Register user with file json {string}")
    public void registerUserWithFileJson(String fileName) {
        File FileJson = new File(Constants.REQ_BODY + fileName);
        reqresAPI.registerUser (FileJson);
    }

    @When("Send request post Register User")
    public void sendRequestPostRegisterUser() {
        SerenityRest.when().post(ReqresAPI.REGISTER_USER);
    }
}
