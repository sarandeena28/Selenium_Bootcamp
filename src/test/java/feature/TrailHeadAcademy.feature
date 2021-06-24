Feature: TrailHeaderAcademy in SalesForce Application

Scenario: Tc001: TrailHeaderAcademy
When Click on Learn More link in Mobile Publisher
Then My salesforce page will be displayed
When MouseHover On Resources
Then List of learnings will be displayed
When Select SalesForce Certification Under Learnings
Then Learning Page will be displayed
Given Choose Your Role as Salesforce Consultant
And Get the List of Certifications Available  
When Click on Community Cloud Consultant
Then Under Related Credentials Check Whether Marketing Cloud Consultant is Available 
When If Available Click on Marketing Cloud Consultant 
Then Marketing Cloud Consultant will be displayed
When MouseOver on Learn 
Then learn list displayed below
When Click on TrailHead Academy
Then Get the Number of Classes Available Before Filtering
Given  Under Role Select all Options Available
And  Under Level Select all Options Available
And Under Product Select all Options Available
And Under Tags Select all Options Available
And Get The Number of Classes Available after Filtering 
And Compare and Check whether the Classes are same Before and After Filtering
And Get the names of all Filter Options Displayed
When Click on Clear Filters 
Then Verify Whether all Filters are Cleared