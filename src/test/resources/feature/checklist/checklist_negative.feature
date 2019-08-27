Feature: Negative test of "checklist"

  @create-board @create-list @create-card @create-checklist @delete-checklist @delete-card @delete-board
  Scenario: Read a wrong field of a checklist by Id
    Given I create a GET request to /checklists/{idChecklist}/abc123 endpoint
    When I send the request
    Then I get a 404 status code as response


  Scenario: Create new checklist with a wrong idCard
    Given I create a POST request to /checklists/ endpoint
    And I set up the data:
        """
          {
           "name":"[New checklist test]",
           "idCard":"abc123"
          }
        """
    When I send the request
    Then I get a 400 status code as response

  Scenario: Read a checklist by a wrong idCheckList
    Given I create a GET request to /checklists/abc123 endpoint
    When I send the request
    Then I get a 400 status code as response

  Scenario: Update checklist's name with a wrong idCheckList
    Given I create a PUT request to /checklists/abc123 endpoint
    And I set up the data:
        """
          {
            "name":"[New checklist with new name]"
          }
        """
    When I send the request
    Then I get a 400 status code as response

  Scenario: Delete a checklist by a wrong IdChecklist
    Given I create a DELETE request to /checklists/abc123 endpoint
    When I send the request
    Then I get a 400 status code as response

  Scenario: Update checklist's name with a wrong idCheckList
    Given I create a PUT request to /checklists/123abc/name endpoint
    And I set up the data:
        """
          {
            "value":"[New checklist with new name]"
          }
        """
    When I send the request
    Then I get a 400 status code as response

  Scenario: Create new checkItem with a wrong idCheckList
    Given I create a POST request to /checklists/123abc/checkItems endpoint
    And I set up the data:
        """
          {
           "name":"[New checkItem test]"
          }
        """
    When I send the request
    Then I get a 400 status code as response

  @create-board @create-list @create-card @create-checklist @delete-checklist @delete-card @delete-board
  Scenario: Read a checklist Board by Id with a wrong field
    Given I create a GET request to /checklists/{idChecklist}/boards endpoint
    When I send the request
    Then I get a 404 status code as response

  @create-board @create-list @create-card @create-checklist @delete-checklist @delete-card @delete-board
  Scenario: Read a checklist Card by Id with a wrong field
    Given I create a GET request to /checklists/{idChecklist}/Card endpoint
    When I send the request
    Then I get a 404 status code as response

  @create-board @create-list @create-card @create-checklist @delete-checklist @delete-card @delete-board
  Scenario: Read all the CheckItems of a checkList by Id with a wrong field
    Given I create a GET request to /checklists/{idChecklist}/checkitem endpoint
    When I send the request
    Then I get a 404 status code as response