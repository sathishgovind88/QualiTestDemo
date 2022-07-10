Feature: Validate Free Now UI Test 
	
Scenario: Validate Free Now UI Test
	Given Open Free Now Url
	When Validate Free Now Home page
	Then Validate Free Now Page headers 
	And Validate Taxi Count with Table Count
	And Validate Free Now navigate to Taxi
	When Validate Free Now Footer Options
	Then Validate Footer Navigate to Next,Last,Previous and First page
	
	