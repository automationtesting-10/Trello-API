Feature: Functional test of "list"

  @create-board @create-list @delete-board
  Scenario: Read a field of a list by Id
    Given I create a GET request to /list/{idList}/name endpoint
    When I send the request
    Then I get a 200 status code as response
    And I verify the response schema with List

  @create-board @create-list @delete-board
  Scenario: Read a board of a list by Id
    Given I create a GET request to /list/{idList}/board endpoint
    When I send the request
    Then I get a 200 status code as response
    And I verify the response schema with List

  @create-board @create-list @delete-board
  Scenario: Archive or unarchive a list
    Given I create a PUT request to /lists/{idList}/closed endpoint
    And I set up the data:
      """
        {
          "value": true
        }
      """
    When I send the request
    Then  I get a 200 status code as response
    And I verify the response schema with List

  @create-board @create-board @create-list @delete-board
  Scenario: Move a list to a new board
    Given I create a PUT request to /lists/{idList}/idBoard endpoint
    And I set up the data:
      """
        {
          "value": "{idBoard}"
        }
      """
    When I send the request
    Then  I get a 200 status code as response
    And I verify the response schema with List

  @create-board @create-list @delete-board
  Scenario: Rename a list
    Given I create a PUT request to /lists/{idList}/name endpoint
    And I set up the data:
      """
        {
          "value": "[New checklist with new name]"
        }
      """
    When I send the request
    Then  I get a 200 status code as response
    And I verify the response schema with List

  @create-board @create-list @delete-board
  Scenario: Change the position of a list
    Given I create a PUT request to /lists/{idList}/name endpoint
    And I set up the data:
      """
        {
          "value": "top"
        }
      """
    When I send the request
    Then  I get a 200 status code as response
    And I verify the response schema with List

  @create-board @create-list @delete-board
  Scenario: Set a soft limit for number of cards in the list
    Given I create a PUT request to /lists/{idList}/softLimit endpoint
    And I set up the data:
      """
        {
          "value": 1000
        }
      """
    When I send the request
    Then  I get a 200 status code as response
    And I verify the response schema with List

  @create-board @create-list @delete-board
  Scenario: Subscribe or unsubscribe from a list
    Given I create a PUT request to /lists/{idList}/subscribed endpoint
    And I set up the data:
      """
        {
          "value": "true"
        }
      """
    When I send the request
    Then  I get a 200 status code as response
    And I verify the response schema with List