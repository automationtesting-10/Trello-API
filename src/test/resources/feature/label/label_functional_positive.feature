Feature: Functional tests of "label"

  @create-board @create-label @delete-label @delete-board
  Scenario Outline: Update a label color
    Given I create a PUT request to /labels/{idLabel}/color endpoint
    And I set up the data:
      """
        {
          "value": "<color>"
        }
      """
    When I send the request
    Then  I get a 200 status code as response
    And I verify the response schema with Label
    Examples: labels with valid colors
      | color  |
      | yellow |
      | purple |
      | blue   |
      | red    |
      | green  |
      | orange |
      | black  |
      | sky    |
      | pink   |
      | lime   |
      | null   |

  @create-board @create-label @delete-label @delete-board
  Scenario Outline: Update a label's name
    Given I create a PUT request to /labels/{idLabel}/name endpoint
    And I set up the data:
      """
        {
          "value": "[<name_checkitem>]"
        }
      """
    When I send the request
    Then  I get a 200 status code as response
    And I verify the response schema with Label
    Examples: checklist with valid names
      | name_checkitem                              |
      | a                                           |
      | 123                                         |
      | new name for proobe the checklist item name |
