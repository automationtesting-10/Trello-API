Feature: Functional tests of "label"
  @create-board @create-label @delete-label @delete-board
  Scenario: Update a label color
    Given I create a PUT request to /labels/{idLabel}/color endpoint
    And I set up the data:
      """
        {
          "value": "red"
        }
      """
    When I send the request
    Then  I get a 200 status code as response
    And I verify the response schema with Label

  @create-board @create-label @delete-label @delete-board
  Scenario: Update a label's name
    Given I create a PUT request to /labels/{idLabel}/name endpoint
    And I set up the data:
      """
        {
          "value": "[New label with the new name]"
        }
      """
    When I send the request
    Then  I get a 200 status code as response
    And I verify the response schema with Label
