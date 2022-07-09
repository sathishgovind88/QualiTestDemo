$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/Feature/APITest.feature");
formatter.feature({
  "name": "Search users validate the posts and comments",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Search users validate the posts and comments",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "Get API Response \"users\"",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefinitions.SearchUsers.searchUserResponse(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Search samantha user and get user id for the response",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefinitions.SearchUsers.getUserId()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify the status code",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.SearchUsers.verifyStatuscode()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Get API Response \"posts\"",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefinitions.SearchUsers.searchUserResponse(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Get the user id and search in the Posts Response",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefinitions.SearchUsers.verifygetuserPosts()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify the status code",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.SearchUsers.verifyStatuscode()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Get API Response \"comments\"",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefinitions.SearchUsers.searchUserResponse(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Get the post id and search in the comments Response",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefinitions.SearchUsers.verifygetUserComments()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify the status code and email format in comments section",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.SearchUsers.verifyCommentsEmail()"
});
formatter.result({
  "status": "passed"
});
});