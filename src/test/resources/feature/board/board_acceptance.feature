Feature: Acceptance test of "board", CRUD's(Create, Read, Update and Delete)

  @delete-board
  Scenario: Create new board with a name
    Given I create a POST request to /boards/ endpoint
      And I set up the data:
        """
          {
           "name":"[New board test]"
          }
        """
    When I send the request
    Then I get a 200 status code as response
      And  I verify the response schema with Board

  @create-board @delete-board
  Scenario: Read a board by Id
    Given I create a GET request to /boards/{idBoard} endpoint
    When I send the request
    Then I get a 200 status code as response
      And I verify the response schema with Board

  @create-board @delete-board
  Scenario: Update board's name
    Given I create a PUT request to /boards/{idBoard} endpoint
      And I set up the data:
        """
          {
            "name":"[New board with new name]"
          }
        """
    When I send the request
    Then I get a 200 status code as response
     And I verify the response schema with Board

  @create-board
  Scenario: Delete a board by Id
    Given I create a DELETE request to /boards/{idBoard} endpoint
    When I send the request
    Then I get a 200 status code as response
