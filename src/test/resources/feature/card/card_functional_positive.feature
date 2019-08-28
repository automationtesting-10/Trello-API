Feature: Functional test for "card"

  @create-board @create-list @create-card @delete-card @delete-board
  Scenario: Get a specific property of a card
    Given I create a GET request to /cards/{idCard}/dateLastActivity endpoint
    When I send the request
    Then I get a 200 status code as response
    And  I verify the response schema with Field

  @create-board @create-list @create-card @delete-card @delete-board
  Scenario: List the actions on a card
    Given I create a GET request to /cards/{idCard}/actions endpoint
    When I send the request
    Then I get a 200 status code as response
    And  I verify the response schema with Actions


  @create-board @create-list @create-card @delete-board
  Scenario: List the attachments on a card
    Given I create a GET request to /cards/{idCard}/attachments endpoint
    When I send the request
    Then I get a 200 status code as response
    And  I verify the response schema with Attachment

#  @create-board @create-list @create-card @create-action @delete-action @delete-card @delete-board
#  Scenario: Get a specific attachment on a card
#    Given I create a GET request to /cards/{idCard}/attachments/{idAttachment} endpoint
#    When I send the request
#    Then I get a 200 status code as response
#      And  I verify the response schema with Card

  @create-board @create-list @create-card @delete-card @delete-board
  Scenario: Get the board a card is on
    Given I create a GET request to /cards/{idCard}/board endpoint
    When I send the request
    Then I get a 200 status code as response
    And  I verify the response schema with Board

#  @create-board @create-list @create-card @delete-card @delete-board
#  Scenario: Get the completed checklist items on a card
#    Given I create a GET request to /cards/{idCard}/checkItemStates endpoint
#    When I send the request
#    Then I get a 200 status code as response
#      And  I verify the response schema with Card

  @create-board @create-list @create-card @create-checklist @delete-checklist @delete-card @delete-board
  Scenario: Get the checklists on a card
    Given I create a GET request to /cards/{idCard}/checklists endpoint
    When I send the request
    Then I get a 200 status code as response
    And  I verify the response schema with Checklist

#  @create-board @create-list @create-card @delete-card @delete-board
#  Scenario: Get a specific checkItem on a card
#    Given I create a GET request to /cards/{idCard}/checkItem/{idCheckItem} endpoint
#    When I send the request
#    Then I get a 200 status code as response
#      And  I verify the response schema with Card

  @create-board @create-list @create-card @delete-card @delete-board
  Scenario: Get the custom field items for a card
    Given I create a GET request to /cards/{idCard}/customFieldItems endpoint
    When I send the request
    Then I get a 200 status code as response

  @create-board @create-list @create-card @delete-card @delete-board
  Scenario: Get the list a card is in
    Given I create a GET request to /cards/{idCard}/list endpoint
    When I send the request
    Then I get a 200 status code as response
    And  I verify the response schema with List

  @create-board @create-list @create-card @delete-card @delete-board
  Scenario: Get the members on a card
    Given I create a GET request to /cards/{idCard}/members endpoint
    When I send the request
    Then I get a 200 status code as response

  @create-board @create-list @create-card @delete-card @delete-board
  Scenario: Get the members who have voted on a card
    Given I create a GET request to /cards/{idCard}/membersVoted endpoint
    When I send the request
    Then I get a 200 status code as response

  @create-board @create-list @create-card @delete-card @delete-board
  Scenario: Get any shared pluginData on a card
    Given I create a GET request to /cards/{idCard}/pluginData endpoint
    When I send the request
    Then I get a 200 status code as response

  @create-board @create-list @create-card @delete-card @delete-board
  Scenario: Get the stickers on a card
    Given I create a GET request to /cards/{idCard}/stickers endpoint
    When I send the request
    Then I get a 200 status code as response

#  @create-board @create-list @create-card @delete-card @delete-board
#  Scenario: Get a specific sticker on a card
#    Given I create a GET request to /cards/{idCard}/stickers/{idSticker} endpoint
#    When I send the request
#    Then I get a 200 status code as response
#      And  I verify the response schema with Card

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
    Examples: new text valid for action
      |text          |
      |New commentary|

#  @create-board @create-list @create-card @delete-card @delete-board
#  Scenario: Update an item in a checklist on a card.
#    Given I create a PUT request to /cards/{idCard}/checkItem/{idCheckItem} endpoint
#      And I set up the data:
#          """
#            {
#              "name":"New commentary"
#            }
#          """
#    When I send the request
#    Then I get a 200 status code as response
#      And  I verify the response schema with Card

#  @create-board @create-list @create-card @delete-card @delete-board
#  Scenario: Update a sticker on a card
#    Given I create a PUT request to /cards/{id}/stickers/{idSticker} endpoint
#      And I set up the data:
#            """
#              {
#                "rotate":60
#              }
#            """
#    When I send the request
#    Then I get a 200 status code as response
#     And  I verify the response schema with Card

#POST OF CARD
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

#  @create-board @create-list @create-card @delete-card @delete-board
#   Scenario: Add an attachment to a card
#     Given I create a POST request to /cards/{idCard}/attachments endpoint
#       And I set up the data:
#                """
#                  {
#                    "name":"New comments"
#                    "file":""
#                    "mimeType":""
#                    "url":""
#                  }
#                """
#     When I send the request
#     Then I get a 200 status code as response
#       And  I verify the response schema with Card

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
    Examples: new name for checklist
      |name               |
      |New name CheckList |

  @create-board @create-list @create-card @delete-card @delete-board
  Scenario: Add a label to a card
    Given I create a POST request to /cards/{idCard}/idLabels endpoint
    When I send the request
    Then I get a 200 status code as response

#  @create-board @create-list @create-card @delete-card @delete-board
#  Scenario: Add a member to a card
#    Given I create a POST request to /cards/{idCard}/idMembers endpoint
#    And I set up the data:
#                    """
#                      {
#                        "value":"New value member"
#                      }
#                    """
#    When I send the request
#    Then I get a 200 status code as response
#      And I verify the response schema with Card

#  @create-board @create-list @create-card @delete-card @delete-board
#  Scenario: Add a new label to a card
#    Given I create a POST request to /cards/{idCard}/idMembers endpoint
#      And I set up the data:
#                      """
#                        {
#                          "color":"red",
#                          "name":"name label"
#                        }
#                      """
#    When I send the request
#    Then I get a 200 status code as response
#      And I verify the response schema with Card

#  @create-board @create-list @create-card @delete-card @delete-board
#  Scenario: Mark notifications about this card as read
#    Given I create a POST request to /cards/{idCard}/markAssociatedNotificationsRead endpoint
#    When I send the request
#    Then I get a 200 status code as response
#      And I verify the response schema with Card
#
#  @create-board @create-list @create-card @delete-card @delete-board
#  Scenario: Vote on the card
#    Given I create a POST request to /cards/{idCard}/membersVoted endpoint
#      And I set up the data:
#                      """
#                        {
#                          "value":"yes"
#                        }
#                      """
#    When I set up the data:
#    Then I get a 200 status code as response
#      And I verify the response schema with Card
#
#  @create-board @create-list @create-card @delete-card @delete-board
#  Scenario: Add a sticker to a card
#    Given I create a POST request to /cards/{idCard}/stickers endpoint
#      And I set up the data:
#                      """
#                      {
#                        "image":"",
#                        "top":"",
#                        "left:"",
#                        "zIndex":"",
#                        "rotate":""
#                      }
#                      """
#    When I set up the data:
#    Then I get a 200 status code as response
#      And I verify the response schema with Card

  @create-board @create-list @create-card @create-action @delete-card @delete-board
  Scenario: Delete a comment
    Given I create a DELETE request to /cards/{idCard}/actions/{idAction}/comments endpoint
    When I send the request
    Then I get a 200 status code as response

#  @create-board @create-list @create-card @create-action @delete-card @delete-board
#  Scenario: Delete an attachment
#    Given I create a DELETE request to /cards/{isCard}/attachments/{idAttachment} endpoint
#    When I set up the data:
#    Then I get a 200 status code as response
#      And I verify the response schema with Card

#  Scenario: Delete a checklist item
#    Given I create a DELETE request to /cards/{isCard}/checkItem/{idCheckItem} endpoint
#    When I set up the data:
#    Then I get a 200 status code as response
#      And I verify the response schema with Card

  @create-board @create-list @create-card @create-checklist @delete-card @delete-board
  Scenario: Delete a checklist from a card
    Given I create a DELETE request to /cards/{isCard}/checklists/{idChecklist} endpoint
    When I set up the data:
    Then I get a 200 status code as response

  @create-board @create-list @create-card @create-label @delete-card @delete-board
  Scenario: Remove a label from a card
    Given I create a DELETE request to /cards/{isCard}/idLabels/{idLabel} endpoint
    When I set up the data:
    Then I get a 200 status code as response

#  Scenario: Remove a member from a card
#    Given I create a DELETE request to /cards/{isCard}/idMembers/{idMember} endpoint
#    When I set up the data:
#    Then I get a 200 status code as response
#      And I verify the response schema with Card
#
#  Scenario: Remove a member's vote from a card
#    Given I create a DELETE request to /cards/{isCard}/membersVoted/{idMember} endpoint
#    When I set up the data:
#    Then I get a 200 status code as response
#      And I verify the response schema with Card
#
#  Scenario: Remove a sticker from the card
#    Given I create a DELETE request to /cards/{isCard}/stickers/{idSticker} endpoint
#    When I set up the data:
#    Then I get a 200 status code as response
#      And I verify the response schema with Card