Feature: Acceptance test of "board", CRUD's(Create, Read, Update and Delete)

  Scenario: Create new board with a name
    Given I create a POST request to "/boards/" endpoint
      And I set up the data:
      """
        {
          name:"I am a new Board"
          test:"2"
        }
      """
    When I sent the request
    Then I get a "200" status code as response
      And I verify the board schema
      And Sent Data should be the same info of the response