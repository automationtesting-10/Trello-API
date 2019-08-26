Feature: Functional test of "checklist"
#  @create-board @create-list @create-card @create-checklist @delete-checklist @delete-card @delete-board
#  Scenario: Read a checklist by Id
#    Given I create a GET request to /checklists/{idChecklist}/board endpoint
#    When I send the request
#    Then I get a 200 status code as response
#    And I verify the response schema with Checklist
#
#  @create-board @create-list @create-card @create-checklist @delete-checklist @delete-card @delete-board
#  Scenario: Read the pos of a checklist by Id
#    Given I create a GET request to /checklists/{idChecklist}/pos endpoint
#    When I send the request
#    Then I get a 200 status code as response
#    And I verify the response schema with Checklist
#
#  @create-board @create-list @create-card @create-checklist @delete-checklist @delete-card @delete-board
#  Scenario: Create new checkItem with a name
#    Given I create a POST request to /checklists/{idChecklist}/checkItems endpoint
#    And I set up the data:
#        """
#          {
#           "name":"[New checkItem test]"
#          }
#        """
#    When I send the request
#    Then I get a 200 status code as response
#    And  I verify the response schema with Checklist

  @create-board @create-list @create-card @create-checklist @create-checkitem @delete-checklist @delete-card @delete-board
  Scenario: Delete a checkitem by Id
    Given I create a GET request to /checklists/{idChecklist}/checkItems/{idCheckItem} endpoint
    When I send the request
    Then I get a 200 status code as response



