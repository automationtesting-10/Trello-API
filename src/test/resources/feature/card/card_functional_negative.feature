Feature: Functional test for "card"

  @create-board @create-list @create-card @delete-card @delete-board
  Scenario: Get a specific property that no belong of a card
    Given I create a GET request to /cards/{idCard}/fieldInvalid endpoint
    When I send the request
    Then I get a 404 status code as response

  @create-board @create-list @create-card @delete-card @delete-board
  Scenario: Get a specific property that no belong of a card with an incorrect idCard
    Given I create a GET request to /cards/5d64f249f71f770810c3xxd1/dateLastActivity endpoint
    When I send the request
    Then I get a 400 status code as response

  @create-board @create-list @create-card @delete-card @delete-board
  Scenario: List the actions on a card with an incorrect idCard
    Given I create a GET request to /cards/5d64f249f71f770810c3xxd1/actions endpoint
    When I send the request
    Then I get a 400 status code as response

  @create-board @create-list @create-card @delete-board
  Scenario: List attachments on a card with an incorrect idCard
    Given I create a GET request to /cards/5d64f249f71f770810c3xxd1/attachments endpoint
    When I send the request
    Then I get a 400 status code as response

  @create-board @create-list @create-card @delete-card @delete-board
  Scenario: Get the board of a card that doesn't exist
    Given I create a GET request to /cards/5d64f249f71f770810c3xxd1/board endpoint
    When I send the request
    Then I get a 400 status code as response

  @create-board @create-list @create-card @create-checklist @delete-checklist @delete-card @delete-board
  Scenario: Get the checklist of a card that doesn't exist
    Given I create a GET request to /cards/5d64f249f71f770810c3xxd1/checklists endpoint
    When I send the request
    Then I get a 400 status code as response

  @create-board @create-list @create-card @delete-card @delete-board
  Scenario: Get custom field items for a card that doesn't exist
    Given I create a GET request to /cards/5d64f249f71f770810c3xxd1/customFieldItems endpoint
    When I send the request
    Then I get a 400 status code as response

  @create-board @create-list @create-card @delete-card @delete-board
  Scenario: Get the list of a card that doesn't exist
    Given I create a GET request to /cards/5d64f249f71f770810c3xxd1/list endpoint
    When I send the request
    Then I get a 400 status code as response

  @create-board @create-list @create-card @delete-card @delete-board
  Scenario: Get the member of a card that doesn't exist
    Given I create a GET request to /cards/5d64f249f71f770810c3xxd1/members endpoint
    When I send the request
    Then I get a 400 status code as response

  @create-board @create-list @create-card @delete-card @delete-board
  Scenario: Get members who have voted on a card that does not exist
    Given I create a GET request to /cards/5d64f249f71f770810c3xxd1/membersVoted endpoint
    When I send the request
    Then I get a 400 status code as response

  @create-board @create-list @create-card @delete-card @delete-board
  Scenario: Get any shared plugin data on a card that doesn't exist
    Given I create a GET request to /cards/5d64f249f71f770810c3xxd1/pluginData endpoint
    When I send the request
    Then I get a 400 status code as response

  @create-board @create-list @create-card @delete-card @delete-board
  Scenario: Get the stickers of a card that doesn't exist
    Given I create a GET request to /cards/5d64f249f71f770810c3xxd1/stickers endpoint
    When I send the request
    Then I get a 400 status code as response
    