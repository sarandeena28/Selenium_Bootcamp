Feature: Case Tab in SalesForce Application

Scenario: CreateCase Without mandatory field
When Click on toggle menu  
Then Dropdown is displayed to select view all
When Click view All in dropdown
Then App Launcher window popUp
When click Sales from App Launch
Then Sales Page displayed
When Click on Case
When Click on New button
Then New Window opened
Given Choose Contact Name as 'Naveen Elumalai'
And Select status as None
And Enter Subject as Testing
And Enter Description as Automation testing
When Click Save
Then Get the text of Error message Displayed 
Given Verify the message