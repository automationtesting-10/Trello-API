Feature: Functional test for "card"

  @create-board @create-list @create-card @delete-card @delete-board
  Scenario: Get a specific property that no belong of a card
    Given I create a GET request to /cards/{idCard}/nameEndpoint endpoint
    When I send the request
    Then I get a 404 status code as response

  @create-board @create-list @create-card @delete-card @delete-board
  Scenario: Get a specific property that no belong of a card with incorrect id
    Given I create a GET request to /cards/5d64f249f71f770810c3xxd1/dateLastActivity endpoint
    When I send the request
    Then I get a 400 status code as response

  @create-board @create-list @create-card @delete-card @delete-board
  Scenario: List the actions on a card with incorrect id
    Given I create a GET request to /cards/5d64f249f71f770810c3xxd1/actions endpoint
    When I send the request
    Then I get a 400 status code as response

  @create-board @create-list @create-card @delete-board
  Scenario: List the attachments on a card with incorrect id
    Given I create a GET request to /cards/5d64f249f71f770810c3xxd1/attachments endpoint
    When I send the request
    Then I get a 400 status code as response

  @create-board @create-list @create-card @delete-card @delete-board
  Scenario: Get the board a card is on that not exist.
    Given I create a GET request to /cards/5d64f249f71f770810c3xxd1/board endpoint
    When I send the request
    Then I get a 400 status code as response

  @create-board @create-list @create-card @create-checklist @delete-checklist @delete-card @delete-board
  Scenario: Get the checklists on a card that not exist
    Given I create a GET request to /cards/5d64f249f71f770810c3xxd1/checklists endpoint
    When I send the request
    Then I get a 400 status code as response

  @create-board @create-list @create-card @delete-card @delete-board
  Scenario: Get the custom field items for a card that not exist
    Given I create a GET request to /cards/5d64f249f71f770810c3xxd1/customFieldItems endpoint
    When I send the request
    Then I get a 400 status code as response

  @create-board @create-list @create-card @delete-card @delete-board
  Scenario: Get the list a card is in that not exist
    Given I create a GET request to /cards/5d64f249f71f770810c3xxd1/list endpoint
    When I send the request
    Then I get a 400 status code as response

  @create-board @create-list @create-card @delete-card @delete-board
  Scenario: Get the members on a card that not exist
    Given I create a GET request to /cards/5d64f249f71f770810c3xxd1/members endpoint
    When I send the request
    Then I get a 400 status code as response

  @create-board @create-list @create-card @delete-card @delete-board
  Scenario: Get the members who have voted on a card that not exist
    Given I create a GET request to /cards/5d64f249f71f770810c3xxd1/membersVoted endpoint
    When I send the request
    Then I get a 400 status code as response

  @create-board @create-list @create-card @delete-card @delete-board
  Scenario: Get any shared plugin Data on a card that not exist
    Given I create a GET request to /cards/5d64f249f71f770810c3xxd1/pluginData endpoint
    When I send the request
    Then I get a 400 status code as response

  @create-board @create-list @create-card @delete-card @delete-board
  Scenario: Get the stickers on a card that not exist
    Given I create a GET request to /cards/5d64f249f71f770810c3xxd1/stickers endpoint
    When I send the request
    Then I get a 400 status code as response
    