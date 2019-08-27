Feature: Functional test of "list"

  @create-board @create-list @delete-board
  Scenario: Read a field of a list by Id
    Given I create a GET request to /list/{idList}/name endpoint
    When I send the request
    Then I get a 200 status code as response
    And I verify the response schema with List

  @create-board @create-list @delete-board
  Scenario: Read actions of a list by Id
    Given I create a GET request to /list/{idList}/actions endpoint
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
  Scenario: Read cards of a list by Id
    Given I create a GET request to /list/{idList}/cards endpoint
    When I send the request
    Then I get a 200 status code as response
    And I verify the response schema with List

  @create-board @create-list @delete-board
  Scenario: Update a list name
    Given I create a PUT request to /lists/{idList} endpoint
    And I set up the data:
      """
        {
          "name": "[New list with the new name]"
        }
      """
    When I send the request
    Then  I get a 200 status code as response
    And I verify the response schema with List