package API.steps;

import API.model.request.CreateUserRequest;
import API.model.request.UpdateUserRequest;
import API.model.response.CreateUserResponse;
import API.model.response.GetUserResponse;
import API.model.response.UpdateUserResponse;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;

import static API.data.Constants.BASE_URL;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class UserSteps {

    public UserSteps() {
        RestAssured.baseURI = BASE_URL;
    }

    public CreateUserResponse createUser(CreateUserRequest createUserRequest) {
        ValidatableResponse validatableResponse = given()
                .contentType("application/json")
                .body(createUserRequest)
                .when()
                .post("/users")
                .then()
                .statusCode(201)
                .header("Content-Type", "application/json; charset=utf-8")
                .header("Server", notNullValue());
        System.out.println(validatableResponse.extract().asPrettyString());
        return validatableResponse.extract().as(CreateUserResponse.class);
    }

    public GetUserResponse getUser(int userId,int statuscode) {
        ValidatableResponse validatableResponse = given()
                .when()
                .get("/users/" + userId)
                .then()
                .statusCode(statuscode)
                .header("Content-Type", "application/json; charset=utf-8")
                .header("Cache-Control", notNullValue());
        System.out.println(validatableResponse.extract().asPrettyString());
        return validatableResponse.extract().as(GetUserResponse.class);
    }

    public UpdateUserResponse updateUser(int userId, UpdateUserRequest updateUserRequest) {
        ValidatableResponse validatableResponse = given()
                .contentType("application/json")
                .body(updateUserRequest)
                .when()
                .put("/users/" + userId)
                .then()
                .statusCode(200)
                .header("Content-Type", "application/json; charset=utf-8")
                .header("X-Powered-By", notNullValue());
        System.out.println(validatableResponse.extract().asPrettyString());
        return validatableResponse.extract().as(UpdateUserResponse.class);
    }

    public int deleteUser(int userId) {
        return   given()
                .when()
                .delete("/users/" + userId)
                .then()
                .statusCode(204)
                .header("Content-Length", "0")
                .extract().statusCode();
    }
}
