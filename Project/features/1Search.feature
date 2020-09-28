#Author: bSalisbury@deloitte.com

Feature: Test the search functionality on Amazon website
 
	Scenario: the user should be able to search for an item
    Given user is on search page
    When user enters search item
    Then user gets search results

		
		