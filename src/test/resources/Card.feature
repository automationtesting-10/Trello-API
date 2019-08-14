@acceptance
Feature: Acceptance test of Create, Read, Update and Delete Cards

  @delete_card
  Scenario: Create a new empty Card
    Given I set up a "POST" request to "/cards" endpoint
    And I set up the data:
    """
      {
        "idList":"{idList}"
      }
      """
    When I send the request
    Then I get a "200" status code as response
    And I verify the project schema
    And Sent Data should be the same info of the response


  @create_card @delete_card
  Scenario: Read the content of a specific Card
    Given I set up a "GET" request to "/cards/{id}" endpoint
    When I send the request
    Then I get a "200" status code as response
    And I verify the project schema
    And Sent Data should contain the same info, id and '{id}'


  @create_card @delete_card
  Scenario: Update the specific Card
    Given I set up a "PUT" request to "/cards/{id}" endpoint
    And I set up the data:
    """
      {
        "name":"Change Card Name"
      }
      """
    When I send the request
    Then I get a "200" status code as response
    And I verify the project schema
    And Sent Data should be the same info of the response


  @create_card
  Scenario: Delete a specific Card
#    Given I count all the projects which exist in a account
    Given I set up a "DELETE" request to "/cards/{id}" endpoint
    When I send the request
    Then I get a "204" status code as response
    And The card is not exist in the account