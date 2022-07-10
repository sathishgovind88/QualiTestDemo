$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/Feature/FreeNow.feature");
formatter.feature({
  "name": "Validate Free Now UI Test",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Validate Free Now UI Test",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Open Free Now Url",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefinitions.FreeNow.addProducts()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Validate Free Now Home page",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefinitions.FreeNow.verifyHomePage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Validate Free Now Page headers",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.FreeNow.verifyPageHeader()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Validate Taxi Count with Table Count",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinitions.FreeNow.verifyTaxiCount()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Validate Free Now navigate to Taxi",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinitions.FreeNow.verifyPageValues()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Validate Free Now Footer Options",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefinitions.FreeNow.verifyFooter()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Validate Footer Navigate to Next,Last,Previous and First page",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.FreeNow.verifyFooterActions()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});