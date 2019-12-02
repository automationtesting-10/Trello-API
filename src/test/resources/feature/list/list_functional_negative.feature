Feature: Negative test of "list"

  @create-board @create-list @delete-board
  Scenario Outline: Read a incorrect field of a list by Id
    Given I create a GET request to /list/{idList}/<field> endpoint
    When I send the request
    Then I get a 404 status code as response
    Examples: list with valid fields
      | field      |
      | otherName  |
      | id         |

  @create-board @create-list @delete-board
  Scenario: Read a board of a incorrect list by Id
    Given I create a GET request to /list/123456/board endpoint
    When I send the request
    Then I get a 400 status code as response

  @create-board @create-list @delete-board
  Scenario: Archive or unarchive a incorrect list
    Given I create a PUT request to /lists/123456/closed endpoint
    And I set up the data:
      """
        {
          "value": true
        }
      """
    When I send the request
    Then  I get a 400 status code as response

  @create-board @create-board @create-list @delete-board
  Scenario: Move a incorrect list to a new board
    Given I create a PUT request to /lists/123456/idBoard endpoint
    And I set up the data:
      """
        {
          "value": "{idBoard}"
        }
      """
    When I send the request
    Then  I get a 400 status code as response

  @create-board @create-board @create-list @delete-board
  Scenario: Move a list to a incorrect board
    Given I create a PUT request to /lists/{idList}/idBoard endpoint
    And I set up the data:
      """
        {
          "value": "123456"
        }
      """
    When I send the request
    Then  I get a 400 status code as response

  @create-board @create-list @delete-board
  Scenario: Rename a incorrect list
    Given I create a PUT request to /lists/123456/name endpoint
    And I set up the data:
      """
        {
          "value": "[New checklist with new name]"
        }
      """
    When I send the request
    Then  I get a 400 status code as response

  @create-board @create-list @delete-board
  Scenario: Change the position of a incorrect list
    Given I create a PUT request to /lists/123456/name endpoint
    And I set up the data:
      """
        {
          "value": "top"
        }
      """
    When I send the request
    Then  I get a 400 status code as response

  @create-board @create-list @delete-board
  Scenario: Set a soft limit for number of cards in the incorrect list
    Given I create a PUT request to /lists/123456/softLimit endpoint
    And I set up the data:
      """
        {
          "value": 1000
        }
      """
    When I send the request
    Then  I get a 400 status code as response

  @create-board @create-list @delete-board
  Scenario: Set a soft limit for incorrect number of cards in the list
    Given I create a PUT request to /lists/{idList}/softLimit endpoint
    And I set up the data:
      """
        {
          "value": 6000
        }
      """
    When I send the request
    Then  I get a 400 status code as response

  @create-board @create-list @delete-board
  Scenario: Subscribe or unsubscribe from a incorrect list
    Given I create a PUT request to /lists/123456/subscribed endpoint
    And I set up the data:
      """
        {
          "value": "true"
        }
      """
    When I send the request
    Then  I get a 400 status code as response

  @create-board @create-list @create-card @delete-board
  Scenario: Archive all cards in a incorrect list
    Given I create a POST request to /lists/123456/archiveAllCards endpoint
    When I send the request
    Then I get a 400 status code as response