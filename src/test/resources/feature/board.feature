Feature: Acceptance test of "board", CRUD's(Create, Read, Update and Delete)

  Scenario: Read a board by id
    Given   I set up a GET request to "/boards/9reOdft6" endpoint
#    When    I send the request
#    Then    I get a "200" status code as response
#
#  Scenario: Create a board with request data
#    Given   I set up a "POST" request to "/boards/" endpoint
#    When    I send the request
#    Then    I get a "200" status code as response
#
#  Scenario: Update the name a board
#    Given   I set up a "PUT" request to "/boards/" endpoint
#    When    I send the request
#    Then    I get a "200" status code as response
#
#  Scenario: Delete a board by id
#    Given   I set up a "DELETE" request to "/boards/{boards_id}" endpoint
#    When    I send the request
#    Then    I get a "200" status code as response

#  Background: ASD
#    Given I login as "user1" user
#
#  @deleteBoard
#  Scenario: Post Board
#    Given I make a POST request to Boards endpoint with BoardData
#    """
#    {
#      "name": "miboard"
#    }
#    """
#    When I save the response as [Board]
#    Then response status code should be 200
#    And the [Board.name] should be "miboard"
#
#  @createBoard @deleteBoard
#  Scenario: Get board
#    When I make a GET request to "/boards/[Board.id]"
#    Then