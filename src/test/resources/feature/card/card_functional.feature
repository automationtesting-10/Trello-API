Feature: Functional test for "card"

#  @create-board @create-list @create-card @delete-card @delete-board
#  Scenario: Get a specific property of a card
#    Given I create a GET request to /cards/{idCard}/dateLastActivity endpoint
#    When I send the request
#    Then I get a 200 status code as response

  @create-board @create-list @create-card @delete-board
  Scenario: List the actions on a card
    Given I create a GET request to /cards/{idCard}/actions endpoint
    When I send the request
    Then I get a 200 status code as response

  @create-board @create-list @create-card @delete-board
  Scenario: List the attachments on a card
    Given I create a GET request to /cards/{idCard}/attachments endpoint
    When I send the request
    Then I get a 200 status code as response

#  Scenario: Get a specific attachment on a card
#    Given I create a GET request to /cards/{id}/attachments/{idAttachment} endpoint
#    When I send the request
#    Then I get a 200 status code as response
#
#  Scenario: Get the board a card is on
#    Given I create a GET request to /cards/{id}/board endpoint
#    When I send the request
#    Then I get a 200 status code as response
#
#  Scenario: Get the completed checklist items on a card
#    Given I create a GET request to /cards/{id}/checkItemStates endpoint
#    When I send the request
#    Then I get a 200 status code as response
#
#  Scenario: Get the checklists on a card
#    Given I create a GET request to /cards/{id}/checklists endpoint
#    When I send the request
#    Then I get a 200 status code as response
#
#  Scenario: Get a specific checkItem on a card
#    Given I create a GET request to /cards/{id}/checkItem/{idCheckItem} endpoint
#    When I send the request
#    Then I get a 200 status code as response
#
#  Scenario: Get the custom field items for a card
#    Given I create a GET request to /cards/{id}/customFieldItems endpoint
#    When I send the request
#    Then I get a 200 status code as response
#
#  Scenario: Get the list a card is in
#    Given I create a GET request to /cards/{id}/list endpoint
#    When I send the request
#    Then I get a 200 status code as response
#
#  Scenario: Get the members on a card
#    Given I create a GET request to /cards/{id}/members endpoint
#    When I send the request
#    Then I get a 200 status code as response
#
#  Scenario: Get the members who have voted on a card
#    Given I create a GET request to /cards/{id}/membersVoted endpoint
#    When I send the request
#    Then I get a 200 status code as response
#
#  Scenario: Get any shared pluginData on a card
#    Given I create a GET request to /cards/{id}/pluginData endpoint
#    When I send the request
#    Then I get a 200 status code as response
#
#  Scenario: Get the stickers on a card
#    Given I create a GET request to /cards/{id}/stickers endpoint
#    When I send the request
#    Then I get a 200 status code as response
#
#  Scenario: Get a specific sticker on a card
#    Given I create a GET request to /cards/{id}/stickers/{idSticker} endpoint
#    When I send the request
#    Then I get a 200 status code as response
#
## PUT FOR CARD
#  Scenario: Update a card
#    Given I create a PUT request to https://api.trello.com/1/cards/{idCard} endpoint
#      And I set up the data:
#        """
#          {
#            "name":"[New card with the new name]"
#          }
#        """
#    When I send the request
#    Then I get a 200 status code as response
#      And I verify the response schema with Card
#
  @create-board @create-list @create-card @create-action @delete-action @delete-board
  Scenario: Update an existing comment
    Given I create a PUT request to /cards/{idCard}/actions/{idAction}/comments endpoint
      And I set up the data:
        """
          {
            "text":"New commentary"
          }
        """
    When I send the request
    Then I get a 200 status code as response

#  Scenario: Update an item in a checklist on a card.
#    Given I create a PUT request to /cards/{id}/checkItem/{idCheckItem} endpoint
#      And I set up the data:
#          """
#            {
#              "name":"New commentary"
#            }
#          """
#    When I send the request
#    Then I get a 200 status code as response
#
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
#
##POST OF CARD
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

#   Scenario: Add an attachment to a card
#     Given I create a POST request to /cards/{id}/attachments endpoint
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
#
#  Scenario: Create a new checklist on a card
#    Given I create a POST request to /cards/{id}/checklists endpoint
#      And I set up the data:
#                  """
#                    {
#                      "name":"New name CheckList"
#                    }
#                  """
#    When I send the request
#    Then I get a 200 status code as response
#
#  Scenario: Add a label to a card
#    Given I create a POST request to /cards/{id}/idLabels endpoint
#      And I set up the data:
#                    """
#                      {
#                        "value":"New value label"
#                      }
#                    """
#    When I send the request
#    Then I get a 200 status code as response
#
#  Scenario: Add a member to a card
#    Given I create a POST request to /cards/{id}/idMembers endpoint
#    And I set up the data:
#                    """
#                      {
#                        "value":"New value member"
#                      }
#                    """
#    When I send the request
#    Then I get a 200 status code as response
#
#  Scenario: Add a new label to a card
#    Given I create a POST request to /cards/{id}/idMembers endpoint
#      And I set up the data:
#                      """
#                        {
#                          "color":"red",
#                          "name":"name label"
#                        }
#                      """
#    When I send the request
#    Then I get a 200 status code as response
#
#  Scenario: Mark notifications about this card as read
#    Given I create a POST request to /cards/{id}/markAssociatedNotificationsRead endpoint
#    When I send the request
#    Then I get a 200 status code as response
#
#    Scenario: Vote on the card
#      Given I create a POST request to /cards/{id}/membersVoted endpoint
#      And I set up the data:
#                      """
#                        {
#                          "value":"yes"
#                        }
#                      """
#      When I set up the data:
#      Then I get a 200 status code as response
#
#  Scenario: Add a sticker to a card
#    Given I create a POST request to /cards/{id}/stickers endpoint
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
#
## DELETE OF CARD
#
#  Scenario: Delete a comment
#    Given I create a DELETE request to /cards/{id}/actions/{idAction}/comments endpoint
#    When I set up the data:
#    Then I get a 200 status code as response
#
#  Scenario: Delete an attachment
#    Given I create a DELETE request to /cards/{id}/attachments/{idAttachment} endpoint
#    When I set up the data:
#    Then I get a 200 status code as response
#
#  Scenario: Delete a checklist item
#    Given I create a DELETE request to /cards/{id}/checkItem/{idCheckItem} endpoint
#    When I set up the data:
#    Then I get a 200 status code as response
#
#  Scenario: Delete a checklist from a card
#    Given I create a DELETE request to /cards/{id}/checklists/{idChecklist} endpoint
#    When I set up the data:
#    Then I get a 200 status code as response
#
#  Scenario: Remove a label from a card
#    Given I create a DELETE request to /cards/{id}/idLabels/{idLabel} endpoint
#    When I set up the data:
#    Then I get a 200 status code as response
#
#  Scenario: Remove a member from a card
#    Given I create a DELETE request to /cards/{id}/idMembers/{idMember} endpoint
#    When I set up the data:
#    Then I get a 200 status code as response
#
#  Scenario: Remove a member's vote from a card
#    Given I create a DELETE request to /cards/{id}/membersVoted/{idMember} endpoint
#    When I set up the data:
#    Then I get a 200 status code as response
#
#  Scenario: Remove a sticker from the card
#    Given I create a DELETE request to /cards/{id}/stickers/{idSticker} endpoint
#    When I set up the data:
#    Then I get a 200 status code as response