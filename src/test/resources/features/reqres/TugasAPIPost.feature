Feature: Create user API
  @Tugas
  Scenario Outline: Create new user with valid json
    Given Create new user with file json "<fileName>"
    When Send request post Create User
    Then Status code should be 201
    And Response body name should be "<name>" and job should be "<job>"
    Examples:
      | fileName          | name          | job         |
      | create_user.json  | Samuel Pieter | QA Engineer |
      | create_user1.json | Pieter Samuel | QA Engineer |