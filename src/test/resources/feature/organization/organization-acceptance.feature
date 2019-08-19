@Acceptance
Feature: Acceptance test of "board", CRUD's(Create, Read, Update and Delete)

  @AcceptanceReadById
  Scenario: Read a board by id
    Given   I set up a GET request to "/boards/9reOdft6" endpoint
