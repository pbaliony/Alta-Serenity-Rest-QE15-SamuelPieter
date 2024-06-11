Feature: Create user API
  @Latihan
  Scenario: Create new user with valid json
    Given Create new user with file json "create_user.json"
    When Send request post Create User
    Then Status code should be 201