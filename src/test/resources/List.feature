@acceptance
Feature: Acceptance test of Create, Read, and Update Lists

  @delete_list
  Scenario: Create a new empty List
    Given I set up a "POST" request to "/lists" endpoint
    And I set up the data:
    """
      {
        "name":"List Test"
        "idBoard":"{boardId}"
      }
      """
    When I send the request
    Then I get a "200" status code as response
    And I verify the project schema
    And Sent Data should be the same info of the response


  @create_list @delete_list
  Scenario: Read the content of a specific List
    Given I set up a "GET" request to "/lists/{id}" endpoint
    When I send the request
    Then I get a "200" status code as response
    And I verify the project schema
    And Sent Data should contain the same info, id and '{id}'


  @create_list @delete_list
  Scenario: Update the specific List
    Given I set up a "PUT" request to "/lists/{id}" endpoint
    And I set up the data:
    """
      {
        "name":"Change List Name"
      }
      """
    When I send the request
    Then I get a "200" status code as response
    And I verify the project schema
    And Sent Data should be the same info of the response
