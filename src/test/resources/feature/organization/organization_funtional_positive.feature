Feature: Functional positive test of Organization CUD's (Create, Update and Delete)

  @delete-board
  Scenario Outline: Create a new Organization
    Given I create a POST request to /organizations/ endpoint
    And I set up the data:
      """
        {
           "displayName":"<name_organization>"
        }
        """
    When I send the request
    Then I get a 200 status code as response
    And  I verify the response schema with Organization
  Examples: board with valid names
  | name_organization         |
  | o                         |
  | organization with big name|
  | 4$bts                     |

@delete-board
  Scenario Outline: Create a new Board with description and name
    Given I create a POST request to /organization/ endpoint
    And I set up the data:
      """
        {
           "displayName":"[<displayName>]",
           "desc":"<description>"
        }
        """
    When I send the request
    Then I get a 200 status code as response
    And  I verify the response schema with Organization
    Examples: board with label and not
    | displayName       | description  |
    | New organization  | desc1        |
    | New 0r9an1za+i0n  | 2csed        |

  @delete-board
  Scenario Outline: Create a new Board with name and website
    Given I create a POST request to /organization/ endpoint
    And I set up the data:
      """
        {
           "displayName":"[<displayName>]",
           "website":"<website>"
        }
        """
    When I send the request
    Then I get a 200 status code as response
    And  I verify the response schema with Organization
    Examples: board with label and not
    | displayName       | website       |
    | New organization  | www.organ.com |
