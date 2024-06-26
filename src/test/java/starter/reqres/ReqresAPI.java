package starter.reqres;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class ReqresAPI {
    public static String LIST_USER = Constants.BASE_URL+"/api/users?page={page}";
    public static String CREATE_USER = Constants.BASE_URL+"/api/users";
    public static String USER_WITH_ID =  Constants.BASE_URL+"/api/users/{id}";
    public static String LOGIN_USER = Constants.BASE_URL+"/api/login";
    public static String REGISTER_USER = Constants.BASE_URL+"/api/register";

    @Step ("Get List Users")
    public void getListUsers(int page){
        SerenityRest.given().pathParam("page",page);
    }
    @Step ("Create New User")
    public void postCreateNewUser(File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }

    @Step ("Update User")
    public void putUpdateUser (int id, File json){
        SerenityRest.given().pathParam("id", id).contentType(ContentType.JSON).body(json);
    }

    @Step ("Delete User")
    public void deleteUser (int id){
        SerenityRest.given().pathParam("id",id);
    }

    @Step ("Login User")
    public void loginUser (File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }

    @Step ("Register User")
    public void registerUser (File json) {
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }
}
