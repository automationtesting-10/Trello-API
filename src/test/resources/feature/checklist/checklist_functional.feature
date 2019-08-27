Feature: Functional tests of "checklist"

  @create-board @create-list @create-card @create-checklist @delete-checklist @delete-card @delete-board
  Scenario: Read a field of a checklist by Id
    Given I create a GET request to /checklists/{idChecklist}/pos endpoint
    When I send the request
    Then I get a 200 status code as response
    And I verify the response schema with Checklist

  @create-board @create-list @create-card @create-checklist @delete-checklist @delete-card @delete-board
  Scenario: Read a Board of a checklist by Id
    Given I create a GET request to /checklists/{idChecklist}/board endpoint
    When I send the request
    Then I get a 200 status code as response
    And I verify the response schema with Checklist

  @create-board @create-list @create-card @create-checklist @delete-checklist @delete-card @delete-board
  Scenario: Read a card of a checklist by Id
    Given I create a GET request to /checklists/{idChecklist}/cards endpoint
    When I send the request
    Then I get a 200 status code as response
    And I verify the response schema with Checklist

  @create-board @create-list @create-card @create-checklist @delete-checklist @delete-card @delete-board
  Scenario: Read the checkitems of a checklist by Id
    Given I create a GET request to /checklists/{idChecklist}/checkitems endpoint
    When I send the request
    Then I get a 200 status code as response
    And I verify the response schema with Checklist

#  @create-board @create-list @create-card @create-checklist
#  Scenario: Read a specific checkitem of a checklist by Id
#    Given I create a GET request to /checklists/{idChecklist}/checkitems/{idCheckitem} endpoint
#    When I send the request
#    Then I get a 200 status code as response
#    And I verify the response schema with Checklist

  @create-board @create-list @create-card @create-checklist @delete-checklist @delete-card @delete-board
  Scenario: Update checklist's name
    Given I create a PUT request to /checklists/{idChecklist}/name endpoint
    And I set up the data:
        """
          {
            "value":"[New checklist with new name]"
          }
        """
    When I send the request
    Then I get a 200 status code as response
    And I verify the response schema with Checklists

  @create-board @create-list @create-card @create-checklist
  Scenario: Create new checkItem with a name
    Given I create a POST request to /checklists/{idChecklist}/checkItems endpoint
    And I set up the data:
        """
          {
           "name":"[New checkItem test]"
          }
        """
    When I send the request
    Then I get a 200 status code as response
    And  I verify the response schema with Checklist

#  @create-board @create-list @create-card @create-checklist @create-checkitem @delete-checklist @delete-card @delete-board
#  Scenario: Delete a checkitem by Id
#    Given I create a GET request to /checklists/{idChecklist}/checkItems/{id} endpoint
#    When I send the request
#    Then I get a 200 status code as response



