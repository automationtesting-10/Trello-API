Feature: Negative test of "label"

  Scenario: Create new label with a wrong idBoard.
    Given I create a POST request to /labels endpoint
    And I set up the data:
      """
        {
          "name": "[New list test]",
          "color": "red",
          "idBoard": "123abc"
        }
      """
    When I send the request
    Then I get a 400 status code as response

  Scenario: Read a label by a wrong id
    Given I create a GET request to /labels/123abc endpoint
    When I send the request
    Then I get a 400 status code as response

  Scenario: Update a label name with a wrong idLabel
    Given I create a PUT request to /labels/123abc endpoint
    And I set up the data:
      """
        {
          "name": "[New label with the new name]"
        }
      """
    When I send the request
    Then  I get a 400 status code as response

  Scenario: Delete label by a wrong id
    Given I create a DELETE request to /labels/123abc endpoint
    When I send the request
    Then I get a 400 status code as response

  Scenario: Update a label color with a wrong idLabel
    Given I create a PUT request to /labels/123abc/color endpoint
    And I set up the data:
      """
        {
          "value": "red"
        }
      """
    When I send the request
    Then  I get a 400 status code as response

  Scenario: Update a label name with a wrong idLabel
    Given I create a PUT request to /labels/123abc/name endpoint
    And I set up the data:
      """
        {
          "value": "[New label with the new name]"
        }
      """
    When I send the request
    Then  I get a 400 status code as response

  @create-board @create-label @delete-label @delete-board
  Scenario: Update a label color with a wrong field
    Given I create a PUT request to /labels/{idLabel}/colorse endpoint
    And I set up the data:
      """
        {
          "value": "red"
        }
      """
    When I send the request
    Then  I get a 404 status code as response

  @create-board @create-label @delete-label @delete-board
  Scenario: Update a label name with a wrong field
    Given I create a PUT request to /labels/{idLabel}/names endpoint
    And I set up the data:
      """
        {
          "value": "[New label with the new name]"
        }
      """
    When I send the request
    Then  I get a 404 status code as response

  @create-board @create-label @delete-label @delete-board
  Scenario: Update a label color with a wrong color
    Given I create a PUT request to /labels/{idLabel}/color endpoint
    And I set up the data:
      """
        {
          "value": "calipso"
        }
      """
    When I send the request
    Then  I get a 400 status code as response
    And I verify the response schema with Label
