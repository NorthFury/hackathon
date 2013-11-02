Feature: An user can have multiple tasks


  Scenario: Get task for a given user

    When I post "/account/myuser/task"
    Then the status should be 202

  Scenario: Get task for a user 

    When I get "/account/myuser/task/1"
    Then the status should be 200

  Scenario: Get task for a user

    When I get "/account/myuser/tasks"
    Then the status should be 200

  Scenario: Get task for a user

    When I get "/account/myuser/tasks/1"
    Then the status should be 200
    