Feature: Acceptance test of "card", CRUD's(Create, Read, Update and Delete)

  @create-board @create-list @delete-card
  Scenario: create new card with a name
    Given I create a POST request to /cards/ endpoint
      And I set up the data:
      """
        {
          "name":"Here Josue",
          "idList":"{idList}"
        }
      """
    When I send the request
    Then I get a 200 status code as response
      And I verify the response schema with Card

  @create-board @create-list @create-card @delete-card
  Scenario: Read a card by id
    Given I create a GET request to /cards/{idCard} endpoint
    When I send the request
    Then I get a 200 status code as response
      And I verify the response schema with Card

  @create-board @create-list @create-card @delete-card
  Scenario: Update name's card
    Given I create a PUT request to /cards/{idCard} endpoint
      And I set up the data:
      """
        {
          "name":"My new name is Josue"
        }
      """
    When I send the request
    Then I get a 200 status code as response
      And I verify the response schema with Card

  @create-board @create-list @create-card
  Scenario: Delete card by id
    Given I create a DELETE request to /cards/{idCard} endpoint
    When I send the request
    Then I get a 200 status code as response
      And I verify the response schema with Card
