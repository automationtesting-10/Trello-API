Feature: Acceptance test of "board", CRUD's(Create, Read, Update and Delete)

  Scenario: Create new board with a name
    Given I create a "POST" request to "/boards/" endpoint
    And I set up the data:
      """
        {
          "name":"New board"
        }
      """
    When I sent the request
    Then I get a 200 status code as response

  Scenario: Read a board by Id
    Given I create a "GET" request to "/boards/{idBoard}" endpoint
    When I sent the request
    Then I get a 200 status code as response

  Scenario: Update board's name
    Given I create a "PUT" request to "/boards/{idBoard}" endpoint
    And I set up the data:
      """
        {
          "name":"New board with new name"
        }
      """
    When I sent the request
    Then I get a 200 status code as response

  Scenario: Delete a board by Id
    Given I create a "DELETE" request to "/boards/{idBoard}" endpoint
    When I sent the request
    Then I get a 200 status code as response
