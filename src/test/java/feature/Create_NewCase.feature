Feature: Test Case tab in SalesForce Application 

Scenario Outline: TC001:Create New Case
When Click on Global Actions SVG icon
Then Dropdown display
When Click on New Case
Then Choose Contact Name as <contactname>
And Select status as Escalated
And Enter Subject as <subject> and description as <description>
When Click save 
Then verify the message

Examples:
|contactname|subject|description|
|'saran'|'Testing'|'Dummy'|
|'saranya'|'Test'|'Dummycase'|