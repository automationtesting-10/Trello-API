Feature: Acceptance test of "checklist", CRUD's(Create, Read, Update and Delete)

  @create-board @create-list @create-card @delete-card @delete-board
  Scenario: Create new checklist with a name
    Given I create a POST request to /checklists/ endpoint
    And I set up the data:
        """
          {
           "name":"[New checklist test]",
           "idCard":"{idCard}"
          }
        """
    When I send the request
    Then I get a 200 status code as response
    And  I verify the response schema with Checklist

  @create-board @create-list @create-card @create-checklist @delete-checklist @delete-card @delete-board
  Scenario: Read a checklist by Id
    Given I create a GET request to /checklists/{idChecklist} endpoint
    When I send the request
    Then I get a 200 status code as response
    And I verify the response schema with Checklist

  @create-board @create-list @create-card @create-checklist @delete-checklist @delete-card @delete-board
  Scenario: Update a checklist
    Given I create a PUT request to /checklists/{idChecklist} endpoint
    And I set up the data:
        """
          {
            "name":"[New checklist with new name]"
          }
        """
    When I send the request
    Then I get a 200 status code as response
    And I verify the response schema with Checklists

  @create-board @create-list @create-card @create-checklist @delete-card @delete-board
  Scenario: Delete a checklist by Id
    Given I create a DELETE request to /checklists/{idChecklist} endpoint
    When I send the request
    Then I get a 200 status code as response