Feature: Functional tests of "checklist"

  @create-board @create-list @create-card @create-checklist @delete-checklist @delete-card @delete-board
  Scenario Outline: Read a field of a checklist by Id
    Given I create a GET request to /checklists/{idChecklist}/<field> endpoint
    When I send the request
    Then I get a 200 status code as response
    And I verify the response schema with Checklist
    Examples: checklist with valid fields
      | field  |
      | limits |
      | pos    |

  @create-board @create-list @create-card @create-checklist @delete-checklist @delete-card @delete-board
  Scenario Outline: Read a Board of a checklist by Id
    Given I create a GET request to /checklists/{idChecklist}/<item> endpoint
    When I send the request
    Then I get a 200 status code as response
    And I verify the response schema with Checklist
    Examples: checklist with valid items
      | item       |
      | board      |

  @create-board @create-list @create-card @create-checklist @create-checkitem @delete-checklist @delete-card @delete-board
  Scenario: Read a specific checkitem of a checklist by Id
    Given I create a GET request to /checklists/{idChecklist}/checkItems/{idCheckItem} endpoint
    When I send the request
    Then I get a 200 status code as response
    And I verify the response schema with Checklist

  @create-board @create-list @create-card @create-checklist @delete-checklist @delete-card @delete-board
  Scenario Outline: Update checklist's name
    Given I create a PUT request to /checklists/{idChecklist}/name endpoint
    And I set up the data:
        """
          {
            "value":"[<name>]"
          }
        """
    When I send the request
    Then I get a 200 status code as response
    And I verify the response schema with Checklist
    Examples: checklist with valid names
      | name                                        |
      | a                                           |
      | 123                                         |
      | new name for proobe the checklist item name |

  @create-board @create-list @create-card @create-checklist
  Scenario Outline: Create new checkItem with a name, position and state
    Given I create a POST request to /checklists/{idChecklist}/checkItems endpoint
    And I set up the data:
        """
          {
           "name":"[<name_checkitem>]"
          }
        """
    When I send the request
    Then I get a 200 status code as response
    And  I verify the response schema with Checklist
    Examples: checklist with valid names
      | name_checkitem                              |
      | a                                           |
      | 123                                         |
      | new name for proobe the checklist item name |

  @create-board @create-list @create-card @create-checklist @create-checkitem @delete-checklist @delete-card @delete-board
  Scenario: Delete a checkitem by Id
    Given I create a GET request to /checklists/{idChecklist}/checkItems/{idCheckItem} endpoint
    When I send the request
    Then I get a 200 status code as response