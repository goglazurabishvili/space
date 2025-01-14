Feature: User Management API

  Scenario: Create a new user
    Given I create a new user with name "gogla" and job "engineer"
    Then the user should be created with name "gogla" and job "engineer"
    And the user ID and creation date should not be null

  Scenario: Get an existing user
    Given I request to get the user with valid ID 2
    Then the user with ID 2 should be returned with email "janet.weaver@reqres.in"
    And the user's first name should be "Janet" and last name should be "Weaver"
    And the support URL should contain "contentcaddy.io"

  Scenario: Update an existing user
    Given I update the user with ID 972 with name "algog" and job "engineer"
    Then the user should be updated with name "algog" and job "engineer"
    And the update date should not be null

  Scenario: Delete an existing user
    Given I delete the user with valid ID 12
    Then the user should be deleted successfully

  Scenario: Create a user with missing fields
    Given I create a new user with no name and job
    Then the user should not have an ID

  Scenario: Get a non-existent user
    Given I request to get the non-existent user with ID 9999
    Then no data should be returned for the user
    And no support data should be available

  Scenario: Update a user with invalid data
    Given I update the user with ID 972 with empty name and job
    Then the user's name and job should not be empty

  Scenario: Delete a non-existent user
    Given I delete the non-existent user with ID 9999
    Then I should receive a 404 status code for the deletion
