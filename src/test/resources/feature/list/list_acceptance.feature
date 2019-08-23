Feature: Acceptance test of "list", CRUD's(Create, Read, Update and Delete)

  @create-board @delete-board
  Scenario: Create new list with name
    Given I create a POST request to /lists endpoint
      And I set up the data:
      """
        {
          "name": "[New list test]",
          "idBoard": "{idBoard}"
        }
      """
    When I send the request
    Then I get a 200 status code as response
      And I verify the response schema with List

  @create-board @create-list @delete-board
  Scenario: Read a list by id
    Given I create a GET request to /lists/{idList} endpoint
    When I send the request
    Then I get a 200 status code as response
      And I verify the response schema with List

  @create-board @create-list @delete-board
  Scenario: Update a list name
    Given I create a PUT request to /lists/{idList} endpoint
      And I set up the data:
      """
        {
          "name": "[New list with the new name]"
        }
      """
    When I send the request
    Then  I get a 200 status code as response
      And I verify the response schema with List
