package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.ReqresResponses;
import starter.utils.Constants;
import sun.security.mscapi.CPublicKey;

import java.io.File;

public class TugasLoginUserSteps {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Login user with file json {string}")
    public void loginUserWithFileJson(String fileName) {
        File FileJson = new File(Constants.REQ_BODY + fileName);
        reqresAPI.loginUser(FileJson);
    }

    @When("Send request post Login User")
    public void sendRequestPostLoginUser() {
        SerenityRest.when().post(ReqresAPI.LOGIN_USER);
    }

}