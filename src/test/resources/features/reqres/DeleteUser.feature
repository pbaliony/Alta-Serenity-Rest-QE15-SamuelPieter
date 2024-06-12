Feature: Delete a User
  Scenario: Delete user with valid parameter id
    Given Delete user with id 2
    When Send request delete Delete USer
    Then Status code should be 204