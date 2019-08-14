@acceptance
Feature: Acceptance test of Create, Read, Update and Delete Boards

  @delete_project
  Scenario: Create a new empty Board
    Given I set up a "POST" request to "/1/boards" endpoint
    And I set up the data:
    """
      {
        "name":"Board Test"
      }
      """
    When I send the request
    Then I get a "200" status code as response
    And I verify the project schema
    And Sent Data should be the same info of the response


  @create_board @delete_board
  Scenario: Read the content of a specific Board
    Given I set up a "GET" request to "/boards/{id}" endpoint
    When I send the request
    Then I get a "200" status code as response
    And I verify the project schema
    And Sent Data should contain the same info, id and '{id}'


  @create_board @delete_board
  Scenario: Update the specific Board
    Given I set up a "PUT" request to "/boards/{id}" endpoint
    And I set up the data:
    """
      {
        "name":"Change Board Name"
      }
      """
    When I send the request
    Then I get a "200" status code as response
    And I verify the project schema
    And Sent Data should be the same info of the response


  @create_board
  Scenario: Delete a specific Board
#    Given I count all the projects which exist in a account
    Given I set up a "DELETE" request to "/boards/{id}" endpoint
    When I send the request
    Then I get a "204" status code as response
    And The board is not exist in the account