Feature: Acceptance test of "board", CRUD's(Create, Read, Update and Delete)

  Scenario: Read a board by id
    Given   I set up a "GET" request to "/my/boards/{boards_id}" endpoint
    When    I send the request
    Then    I get a "200" status code as response

  Scenario: Create a board with request data
    Given   I set up a "POST" request to "/my/boards/" endpoint
    When    I send the request
    Then    I get a "200" status code as response

  Scenario: Update the name a board
    Given   I set up a "PUT" request to "/my/boards/" endpoint
    When    I send the request
    Then    I get a "200" status code as response

  Scenario: Delete a board by id
    Given   I set up a "DELETE" request to "/my/boards/{boards_id}" endpoint
    When    I send the request
    Then    I get a "200" status code as response