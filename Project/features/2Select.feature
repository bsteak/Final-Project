#Author: bSalisbury@deloitte.com

Feature: Test the select item functionality on Amazon website
 
		Scenario: the user should be able to select an item amd print out ratings
		Given user is on results page
		And  user finds item
		When user prints item rating
		Then user selects item
		
		
