Feature: Search users validate the posts and comments

Scenario: Search users validate the posts and comments
	Given Get API Response "users"
	When Search samantha user and get user id for the response
	Then Verify the status code
	Given Get API Response "posts"
	When Get the user id and search in the Posts Response
	Then Verify the status code
	Given Get API Response "comments"
	When Get the post id and search in the comments Response
	Then Verify the status code and email format in comments section
	