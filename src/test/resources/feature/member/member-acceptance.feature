Feature: Acceptance test of "member", CRUD's(Create, Read, Update and Delete)

  Scenario: Read a member information
    Given I set up a GET request to "/members/maya48725601" endpoint wit id
    When I sent the request
    Then I get a 200 status code as response
#    And I verify the board schema
#    And Sent Data should be the same info of the response

#****PUT SCENARIO****
  Scenario: Put new member with a name
    Given I update a PUT request to "/members/maya48725601" endpoint
    And I set up the data with the new name:
      """
        {
          "bio":"mayita124587holas"
        }
      """
    When I sent the request for update de member name's
    Then I get a 200 status code as response of the upadte.
#    And I verify the board schema
#    And Sent Data should be the same info of the response


#****POST SCENARIO****
  Scenario: Create a new avatar for a member
    Given I set up a POST request to "/members/maya48725601/avatar" endpoint
    And I set up the data with the new file:
      """
        {
          "fullName":"mayita24578"
        }
      """
    When I sent the request for update de member name's
    Then I get a 200 status code as response of the upadte.
#    And I verify the board schema
#    And Sent Data should be the same info of the response
