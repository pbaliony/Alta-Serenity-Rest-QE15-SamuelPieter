@Tugas
  Feature: Login User

    Scenario Outline: Login With valid Credential
      Given Login user with file json "<fileName>"
      When Send request post Login User
      Then Status code should be 200
      And Response body token should be "<token>"
      And Validate json schema "Tugas_login_user_valid_json_schema.json"
      Examples:
        | fileName               | token             |  |
        | tugas_login_user.json  | QpwL5tke4Pnpja7X4 |  |
        | tugas_login_user1.json | QpwL5tke4Pnpja7X4 |  |


    Scenario: Login With invalid Credential (no password)
      Given Login user with file json "tugas_login_user_invalid.json"
      When Send request post Login User
      Then Status code should be 400
      And Response body should be "Missing password"
      And Validate json schema "Tugas_login_user_invalid_json_schema.json"