@Tugas
Feature: Delete a User
  Scenario: Delete user with valid parameter id
    Given Delete user with id 2
    When Send request delete Delete USer
    Then Status code should be 204

  Scenario: Delete user with invalid parameter id
    Given Delete user with id 9999
    When Send request delete Delete USer
    Then Status code should be 404