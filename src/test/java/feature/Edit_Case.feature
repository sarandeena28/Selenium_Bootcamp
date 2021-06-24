Feature: Case Tab in SalesForce Application

Scenario Outline: Tc002:Edit case
When Click on toggle menu button from the left corner
Then Dropdown displayed
When Click view All 
Then App Launcher Displayed
When click Sales from App Launcher
Then Sales Page Loaded Successfully
When Click on Cases
Then Dropdown displayed in case
When Click on the My case from Dropdown 
Then Case with my name Loaded
When Click dropdown icon
When Click Edit
Given Update Status as <status>
And Update Priority to <priority>
And Update SLA violation to <sla>
And Update Case Origin as <caseOrigin>
When Click on Save
Then Verify Status as Working

Examples:
|status|priority|sla|caseOrigin|
|'Working'|'Low'|'No'|'Phone'|
