Feature: This feature is to test the MyTheresa Men's collection page


Scenario Outline: Validate all the links available on webpage and logging into the account

Given Launch mytheresa page and validate page loaded successfully
Then User validates <gender> is selected under gender categories
And User gets all the links available in the web page and validates response codes
When User clicks on my account button
And User enters <email> and <password> to login
Then User validates the <name> and <email> login information

Examples:
|gender |email 						|password  |name	   |
|Men	|reshmaegalapati@maildrop.cc|zipsRules1|Reshma Test|