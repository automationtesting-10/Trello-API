Feature: Functional positive test of Board CUD's (Create, Update and Delete)

  @delete-board
  Scenario Outline: Create a new Board
    Given I create a POST request to /boards/ endpoint
    And I set up the data:
      """
        {
           "name":"<name_board>"
        }
        """
    When I send the request
    Then I get a 200 status code as response
    And  I verify the response schema with Board
  Examples: board with valid names
  | name_board              |
  | b                       |
  | board with big name     |
  | 4$b                     |

  @delete-board
  Scenario Outline: Create a new Board with and without label
    Given I create a POST request to /boards/ endpoint
    And I set up the data:
      """
        {
           "name":"[<name_board>]",
           "defaultLabels": "<default_labels>"
        }
        """
    When I send the request
    Then I get a 200 status code as response
    And  I verify the response schema with Board
    Examples: board with label and not
    | name_board | default_labels |
    | New board  | true           |
    | New board  | false          |


  @delete-board
  Scenario Outline: Create a new Board with and without list
    Given I create a POST request to /boards/ endpoint
    And I set up the data:
      """
        {
           "name":"[<name_board>]",
           "defaultLists":<default_lists>
        }
        """
    When I send the request
    Then I get a 200 status code as response
    And  I verify the response schema with Board
    Examples: board with list and not
    | name_board | default_lists |
    | New board  | true          |
    | New board  | false         |

  @delete-board
  Scenario Outline: Create a new Board with description
    Given I create a POST request to /boards/ endpoint
    And I set up the data:
      """
        {
           "name":"[<name_board>]",
           "desc":"<description>"
        }
        """
    When I send the request
    Then I get a 200 status code as response
    And  I verify the response schema with Board
    Examples: board with list and not
    | name_board | description      |
    | New board  | text description |

  @create-board @delete-board
  Scenario Outline: Update the name of a Board
    Given I create a PUT request to /boards/{idBoard} endpoint
    And I set up the data:
      """
        {
           "name":"[<name_board>]"
        }
        """
    When I send the request
    Then I get a 200 status code as response
    And  I verify the response schema with Board
    Examples: board with list and not
    | name_board              |
    | b                       |
    | new board with big name |
    | 4$b*                    |

  @create-board @delete-board
  Scenario Outline: Update the defaultLists value of a Board
    Given I create a PUT request to /boards/{idBoard} endpoint
    And I set up the data:
      """
        {
           "defaultLists":"<default_lists>"
        }
        """
    When I send the request
    Then I get a 200 status code as response
    And  I verify the response schema with Board
    Examples: board with defaultLists value updating
    | default_lists |
    | true          |
    | false         |

  @create-board @delete-board
  Scenario Outline: Update the defaultLabels value of a Board
    Given I create a PUT request to /boards/{idBoard} endpoint
    And I set up the data:
      """
        {
           "defaultLabels":"<default_labels>"
        }
        """
    When I send the request
    Then I get a 200 status code as response
    And  I verify the response schema with Board
    Examples: board with defaultLabels value updating
    | default_labels |
    | true           |
    | false          |

  @create-board @delete-board
  Scenario Outline: Update the description value of a Board
    Given I create a PUT request to /boards/{idBoard} endpoint
    And I set up the data:
      """
        {
           "desc":"<description>"
        }
        """
    When I send the request
    Then I get a 200 status code as response
    And  I verify the response schema with Board
    Examples: board with defaultLabels value updating
    | description               |
    | text description updating |

  @create-board @delete-board
  Scenario Outline: Update the closed value of a Board
    Given I create a PUT request to /boards/{idBoard} endpoint
    And I set up the data:
      """
        {
           "closed":"<closed>"
        }
        """
    When I send the request
    Then I get a 200 status code as response
    And  I verify the response schema with Board
    Examples: board with closed value updating
    | closed |
    | true   |
    | false  |

  @create-board @delete-board
  Scenario Outline: Update the subscribed value of a Board
    Given I create a PUT request to /boards/{idBoard} endpoint
    And I set up the data:
      """
        {
           "subscribed":"<subscribed>"
        }
        """
    When I send the request
    Then I get a 200 status code as response
    And  I verify the response schema with Board
    Examples: board with subscribed value updating
    | subscribed |
    | true       |
    | false      |

  @create-board @delete-board
  Scenario Outline: Update the labelNames/green value of a Board
    Given I create a PUT request to /boards/{idBoard} endpoint
    And I set up the data:
      """
        {
           "labelNames/green":"<label_Name_green>"
        }
        """
    When I send the request
    Then I get a 200 status code as response
    And  I verify the response schema with Board
    Examples: board with labelNames/green value updating
    | label_Name_green                   |
    | g                                  |
    | new labelNames/green with big name |
    | 7$b*                               |

  @create-board @delete-board
  Scenario Outline: Update the labelNames/yellow value of a Board
    Given I create a PUT request to /boards/{idBoard} endpoint
    And I set up the data:
      """
        {
           "labelNames/yellow":"<label_Name_yellow>"
        }
        """
    When I send the request
    Then I get a 200 status code as response
    And  I verify the response schema with Board
    Examples: board with labelNames/yellow value updating
    | label_Name_yellow                   |
    | y                                   |
    | new labelNames/yellow with big name |
    | 8$b*                                |

  @create-board @delete-board
  Scenario Outline: Update the labelNames/orange value of a Board
    Given I create a PUT request to /boards/{idBoard} endpoint
    And I set up the data:
      """
        {
           "labelNames/orange":"<label_Name_orange>"
        }
        """
    When I send the request
    Then I get a 200 status code as response
    And  I verify the response schema with Board
    Examples: board with labelNames/orange value updating
    | label_Name_orange                   |
    | o                                   |
    | new labelNames/orange with big name |
    | 9$b*                                |

  @create-board @delete-board
  Scenario Outline: Update the labelNames/red value of a Board
    Given I create a PUT request to /boards/{idBoard} endpoint
    And I set up the data:
      """
        {
           "labelNames/red":"<label_Name_red>"
        }
        """
    When I send the request
    Then I get a 200 status code as response
    And  I verify the response schema with Board
    Examples: board with labelNames/red value updating
    | label_Name_red                   |
    | r                                |
    | new labelNames/red with big name |
    | 3$b*                             |

  @create-board @delete-board
  Scenario Outline: Update the labelNames/purple value of a Board
    Given I create a PUT request to /boards/{idBoard} endpoint
    And I set up the data:
      """
        {
           "labelNames/purple":"<label_Name_purple>"
        }
        """
    When I send the request
    Then I get a 200 status code as response
    And  I verify the response schema with Board
    Examples: board with labelNames/purple value updating
    | label_Name_purple                   |
    | p                                   |
    | new labelNames/purple with big name |
    | 2$b*                                |

  @create-board @delete-board
  Scenario Outline: Update the labelNames/blue value of a Board
    Given I create a PUT request to /boards/{idBoard} endpoint
    And I set up the data:
      """
        {
           "labelNames/blue":"<label_Name_blue>"
        }
        """
    When I send the request
    Then I get a 200 status code as response
    And  I verify the response schema with Board
    Examples: board with labelNames/blue value updating
    | label_Name_blue                   |
    | b                                 |
    | new labelNames/blue with big name |
    | 1$b*                              |

  @create-board @create-list @delete-board
  Scenario: Read the lists from a Board
    Given I create a GET request to /boards/{idBoard}/lists endpoint
    When I send the request
    Then I get a 200 status code as response


  @create-board @create-list @create-card @delete-card @delete-board
  Scenario: Read the cards from a Board
    Given I create a GET request to /boards/{idBoard}/cards endpoint
    When I send the request
    Then I get a 200 status code as response

  @create-board @create-list @create-card @create-label @delete-label @delete-card @delete-board
  Scenario: Read the labels from a Board
    Given I create a GET request to /boards/{idBoard}/labels endpoint
    When I send the request
    Then I get a 200 status code as response

  @create-board @create-list @create-card @create-checklist @delete-checklist @delete-card @delete-board
  Scenario: Read the checklists from a Board
    Given I create a GET request to /boards/{idBoard}/checklists endpoint
    When I send the request
    Then I get a 200 status code as response

  @create-board @create-list @create-card @delete-label @delete-card @delete-board
  Scenario Outline: Create a label from a Board
    Given I create a POST request to /boards/{idBoard}/labels endpoint
      And I set up the data:
      """
        {
           "name":"[<name_label>]",
           "color":"<color_name>"
        }
        """
    When I send the request
    Then I get a 200 status code as response

    Examples: board with labelNames value updating
    | name_label    | color_name |
    | name label    | green      |
    | name label    | yellow     |
    | name label    | orange     |
    | name label    | red        |
    | name label    | purple     |
    | name label    | blue       |

  @create-board @create-list @create-card @delete-label @delete-card @delete-board
  Scenario Outline: Create a list from a Board
    Given I create a POST request to /boards/{idBoard}/lists endpoint
    And I set up the data:
      """
        {
           "name":"[<name_List>]"
        }
        """
    When I send the request
    Then I get a 200 status code as response

    Examples: board with labelNames/blue value updating
      | name_List              |
      | l                      |
      | new list with big name |
      | 7$b*                   |
