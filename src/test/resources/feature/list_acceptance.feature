Feature: Acceptance test of "list", only Create

  Scenario: Create new list with name
    Given I create a LIST request to "/lists" endpoint
      And I set up the data:
      """
        {
          "id": "5d5a0d89e6a38889fae28c63",
          "name": "List1",
        }
      """
    When I sent the request
    Then I get a 200 status code as response
      And I verify the list schema
      And Sent Data should be the same info of the response