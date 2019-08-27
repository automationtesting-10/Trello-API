Feature: Acceptance test of "organization", CRUD's(Create, Read, Update and Delete)

  @delete-organization
  Scenario: Create new organization with a name
    Given I create a POST request to /organizations/ endpoint
      And I set up the data:
        """
          {
           "displayName":"[New organization]"
          }
        """
    When I send the request
    Then I get a 200 status code as response
      And I verify the response schema with Organization


  @create-organization @delete-organization
  Scenario: Read a organization by Id
    Given I create a GET request to /organizations/{idOrganization} endpoint
    When I send the request
    Then I get a 200 status code as response
      And I verify the response schema with Organization

  @create-organization @delete-organization
  Scenario: Update organization's name
    Given I create a PUT request to /organizations/{idOrganization} endpoint
      And I set up the data:
        """
          {
            "displayName":"[Organization with new name]"
          }
        """
    When I send the request
    Then I get a 200 status code as response
     And I verify the response schema with Organization

  @create-organization
  Scenario: Delete a organization by Id
    Given I create a DELETE request to /organizations/{idOrganization} endpoint
    When I send the request
    Then I get a 200 status code as response