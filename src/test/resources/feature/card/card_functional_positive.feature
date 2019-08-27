Feature: Functional test for "card"

  @create-board @create-list @create-card @delete-card @delete-board
  Scenario: Get a specific property of a card
    Given I create a GET request to /cards/{idCard}/dateLastActivity endpoint
    When I send the request
    Then I get a 200 status code as response
     And  I verify the response schema with Card

  @create-board @create-list @create-card @delete-card @delete-board
  Scenario: Get the board a card is on
    Given I create a GET request to /cards/{idCard}/board endpoint
    When I send the request
    Then I get a 200 status code as response
      And  I verify the response schema with Card

  @create-board @create-list @create-card @delete-card @delete-board
  Scenario: Get the list a card is in
    Given I create a GET request to /cards/{idCard}/list endpoint
    When I send the request
    Then I get a 200 status code as response
    
  @create-board @create-list @create-card @create-action @delete-action @delete-board
  Scenario Outline: Update an existing comment
    Given I create a PUT request to /cards/{idCard}/actions/{idAction}/comments endpoint
      And I set up the data:
        """
          {
            "text":"<text>"
          }
        """
    When I send the request
    Then I get a 200 status code as response
      And  I verify the response schema with Card
    Examples: new text valid for action
    |text          |
    |New commentary|

  @create-board @create-list @create-card @delete-card @delete-board
  Scenario: Add a new comment to a card
    Given I create a POST request to /cards/{idCard}/actions/comments endpoint
      And I set up the data:
              """
                {
                  "text":"this is a comments for card"
                }
              """
    When I send the request
    Then I get a 200 status code as response
      And  I verify the response schema with Card

  @create-board @create-list @create-card @delete-card @delete-board
  Scenario Outline: Create a new checklist on a card
    Given I create a POST request to /cards/{idCard}/checklists endpoint
      And I set up the data:
                  """
                    {
                      "name":"[<name>]"
                    }
                  """
    When I send the request
    Then I get a 200 status code as response
      And  I verify the response schema with Card
    Examples: new name for checklist
    |name               |
    |New name CheckList |

  @create-board @create-list @create-card @create-action @delete-card @delete-board
  Scenario: Delete a comment
    Given I create a DELETE request to /cards/{idCard}/actions/{idAction}/comments endpoint
    When I send the request
    Then I get a 200 status code as response
      And I verify the response schema with Card

  @create-board @create-list @create-card @create-label @delete-card @delete-board
  Scenario: Remove a label from a card
    Given I create a DELETE request to /cards/{idCard}/idLabels/{idLabel} endpoint
    When I send the request
    Then I get a 200 status code as response
      And I verify the response schema with Card
