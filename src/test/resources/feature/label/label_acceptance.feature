Feature: Acceptance test of "label", CRUD's(Create, Read, Update and Delete)

  @create-board @delete-label @delete-board
  Scenario: Create new label with name
    Given I create a POST request to /labels endpoint
    And I set up the data:
      """
        {
          "name": "[New list test]",
          "color": "red",
          "idBoard": "{idBoard}"
        }
      """
    When I send the request
    Then I get a 200 status code as response
    And I verify the response schema with Label

  @create-board @create-label @delete-label @delete-board
  Scenario: Read a label by id
    Given I create a GET request to /labels/{idLabel} endpoint
    When I send the request
    Then I get a 200 status code as response
    And I verify the response schema with Label

  @create-board @create-label @delete-label @delete-board
  Scenario: Update a label name
    Given I create a PUT request to /labels/{idLabel} endpoint
    And I set up the data:
      """
        {
          "name": "[New label with the new name]"
        }
      """
    When I send the request
    Then  I get a 200 status code as response
    And I verify the response schema with Label

  @create-board @create-label @delete-board
  Scenario: Delete label by id
    Given I create a DELETE request to /labels/{idLabel} endpoint
    When I send the request
    Then I get a 200 status code as response
    And I verify the response schema with Label
