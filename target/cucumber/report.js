$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/feature/board.feature");
formatter.feature({
  "name": "Acceptance test of \"board\", CRUD\u0027s(Create, Read, Update and Delete)",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Read a board by id",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "I set up a GET request to \"/boards/9reOdft6\" endpoint",
  "keyword": "Given "
});
formatter.match({
  "location": "BoardStepDef.iSetUpRequestToEndpoint(String)"
});
formatter.result({
  "status": "passed"
});
});