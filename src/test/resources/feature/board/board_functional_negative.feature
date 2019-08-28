Feature: test Negative of Board

  @create-board @delete-board
  Scenario: Read a board by invalid Id
    Given I create a GET request to /boards/{idBoardNotValid} endpoint
    When I send the request
    Then I get a 404 status code as response

  @create-board @delete-board
  Scenario: Delete a board by invalid Id
    Given I create a DELETE request to /boards/{idBoardNotValid} endpoint
    When I send the request
    Then I get a 404 status code as response