package step;

import API.model.request.CreateUserRequest;
import API.model.request.UpdateUserRequest;
import API.model.response.CreateUserResponse;
import API.model.response.GetUserResponse;
import API.model.response.UpdateUserResponse;
import API.steps.UserSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class UserStepDefinitions {

    private UserSteps userSteps = new UserSteps();
    private CreateUserResponse createUserResponse;
    private GetUserResponse getUserResponse;
    private UpdateUserResponse updateUserResponse;
    private int deleteStatusCode;

    @Given("I create a new user with name {string} and job {string}")
    public void i_create_a_new_user_with_name_and_job(String name, String job) {
        CreateUserRequest createUserRequest = new CreateUserRequest();
        createUserRequest.setName(name);
        createUserRequest.setJob(job);
        createUserResponse = userSteps.createUser(createUserRequest);
    }

    @Then("the user should be created with name {string} and job {string}")
    public void the_user_should_be_created_with_name_and_job(String name, String job) {
        Assert.assertEquals(createUserResponse.getName(), name);
        Assert.assertEquals(createUserResponse.getJob(), job);
    }

    @Then("the user ID and creation date should not be null")
    public void the_user_id_and_creation_date_should_not_be_null() {
        Assert.assertNotNull(createUserResponse.getId(), "User ID should not be null");
        Assert.assertNotNull(createUserResponse.getCreatedAt(), "Created At should not be null");
    }

    @Given("I request to get the user with valid ID {int}")
    public void i_request_to_get_the_user_with_valid_id(int userId) {
        getUserResponse = userSteps.getUser(userId, 200);
    }

    @Then("the user with ID {int} should be returned with email {string}")
    public void the_user_with_id_should_be_returned_with_email(int userId, String email) {
        Assert.assertEquals(getUserResponse.getData().getId().intValue(), userId);
        Assert.assertEquals(getUserResponse.getData().getEmail(), email);
    }

    @Then("the user's first name should be {string} and last name should be {string}")
    public void the_user_s_first_name_should_be_and_last_name_should_be(String firstName, String lastName) {
        Assert.assertEquals(getUserResponse.getData().getFirst_name(), firstName);
        Assert.assertEquals(getUserResponse.getData().getLast_name(), lastName);
    }

    @Then("the support URL should contain {string}")
    public void the_support_url_should_contain(String url) {
        Assert.assertTrue(getUserResponse.getSupport().getUrl().contains(url));
    }

    @Given("I update the user with ID {int} with name {string} and job {string}")
    public void i_update_the_user_with_id_with_name_and_job(int userId, String name, String job) {
        UpdateUserRequest updateUserRequest = new UpdateUserRequest();
        updateUserRequest.setName(name);
        updateUserRequest.setJob(job);
        updateUserResponse = userSteps.updateUser(userId, updateUserRequest);
    }

    @Then("the user should be updated with name {string} and job {string}")
    public void the_user_should_be_updated_with_name_and_job(String name, String job) {
        Assert.assertEquals(updateUserResponse.getName(), name);
        Assert.assertEquals(updateUserResponse.getJob(), job);
    }

    @Then("the update date should not be null")
    public void the_update_date_should_not_be_null() {
        Assert.assertNotNull(updateUserResponse.getUpdatedAt(), "Updated At should not be null");
    }

    @Given("I delete the user with valid ID {int}")
    public void i_delete_the_user_with_valid_id(int userId) {
        deleteStatusCode = userSteps.deleteUser(userId);
    }

    @Then("the user should be deleted successfully")
    public void the_user_should_be_deleted_successfully() {
        Assert.assertEquals(deleteStatusCode, 204);
    }

    @Given("I create a new user with no name and job")
    public void i_create_a_new_user_with_no_name_and_job() {
        CreateUserRequest createUserRequest = new CreateUserRequest();
        createUserResponse = userSteps.createUser(createUserRequest);
    }

    @Then("the user should not have an ID")
    public void the_user_should_not_have_an_id() {
        Assert.assertNull(createUserResponse.getId(), "User ID should be null");
    }

    @Given("I request to get the non-existent user with ID {int}")
    public void i_request_to_get_the_non_existent_user_with_id(int userId) {
        getUserResponse = userSteps.getUser(userId, 404);
    }

    @Then("no data should be returned for the user")
    public void no_data_should_be_returned_for_the_user() {
        Assert.assertNull(getUserResponse.getData());
    }

    @Then("no support data should be available")
    public void no_support_data_should_be_available() {
        Assert.assertNull(getUserResponse.getSupport());
    }

    @Given("I update the user with ID {int} with empty name and job")
    public void i_update_the_user_with_id_with_empty_name_and_job(int userId) {
        UpdateUserRequest updateUserRequest = new UpdateUserRequest();
        updateUserRequest.setName("");
        updateUserRequest.setJob("");
        updateUserResponse = userSteps.updateUser(userId, updateUserRequest);
    }

    @Then("the user's name and job should not be empty")
    public void the_user_s_name_and_job_should_not_be_empty() {
        Assert.assertNotEquals(updateUserResponse.getName(), "");
        Assert.assertNotEquals(updateUserResponse.getJob(), "");
    }

    @Given("I delete the non-existent user with ID {int}")
    public void i_delete_the_non_existent_user_with_id(int userId) {
        deleteStatusCode = userSteps.deleteUser(userId);
    }

    @Then("I should receive a {int} status code for the deletion")
    public void i_should_receive_a_status_code_for_the_deletion(int expectedStatusCode) {
        Assert.assertEquals(deleteStatusCode, expectedStatusCode);
    }
}
