@Tugas
Feature: Register User

  Scenario Outline: Register With valid Credential
    Given Register user with file json "<fileName>"
    When Send request post Register User
    Then Status code should be 200
    And Response body token should be "<token>" and id <id>
    And Validate json schema "Tugas_register_user_valid_json_schema.json"
    Examples:
      | fileName                  | token             | id |
      | tugas_register_user.json  | QpwL5tke4Pnpja7X4 | 4  |
      | tugas_register_user1.json | QpwL5tke4Pnpja7X4 | 4  |


  Scenario: Register with invalid Credential (no password)
    Given Register user with file json "tugas_register_user_invalid.json"
    When Send request post Register User
    Then Status code should be 400
    And Response body should be "Missing password"
    And Validate json schema "Tugas_login_user_invalid_json_schema.json"