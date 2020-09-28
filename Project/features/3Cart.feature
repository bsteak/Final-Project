#Author: bSalisbury@deloitte.com

Feature: Test the add to cart item functionality on Amazon website
 
		Scenario: the user should be able to add an item to cart and print out amount of item
		Given user is on selected item page
		And  user selects add to cart
		Then user prints item amount