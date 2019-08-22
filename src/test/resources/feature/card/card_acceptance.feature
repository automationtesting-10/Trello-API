Feature: Acceptance test of "card", CRUD's(Create, Read, Update and Delete)

  @create-board @create-list @delete-card
  Scenario: create new card with a name
    Given I create a "POST" request to "/cards/" endpoint
      And I set up the data:
      """
        {
          "name":"Here Josue",
          "idList":"{idList}"

        }
      """
    When I send the request
    Then I get a 200 status code as response
      And I verify the response schema with "Card"

  @create-board @create-list @create-card
  Scenario: I get id of a card
    Given I create a "GET" request to "/cards/{id}" endpoint
    When I send the request
    Then I get a 200 status code as response
      And I verify the response schema with "Card"

  @create-board @create-list @create-card
  Scenario: I put name of card
    Given I create a "PUT" request to "/cards/{id}" endpoint
      And I set up the data:
      """
        {
          "name":"My new name is Josue"
        }
      """
    When I send the request
    Then I get a 200 status code as response
      And I verify the response schema with "Card"

  @create-board @create-list @create-card
  Scenario: I delete card for id
    Given I create a "DELETE" request to "/cards/{id}" endpoint
    When I send the request
    Then I get a 200 status code as response
      And I verify the response schema with "Card"
