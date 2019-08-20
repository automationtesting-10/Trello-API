Feature: Acceptance test of "board", CRUD's(Create, Read, Update and Delete)

  @delete-board
  Scenario: Create new board with a name
    Given I create a "POST" request to "/boards/" endpoint
    And I set up the data:
      """
        {
         "name":"New board test RAUL"
        }
      """
    When I send the request
    Then I get a 200 status code as response