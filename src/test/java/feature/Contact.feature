Feature: Contact Tab in SalesForce Application

Scenario: Tc001:Update_Contact
When Click on toggle on left corner
Then Dropdown is displayed to click view all
When Click view All from dropdown list
Then App Launcher window opened
When Click on contacts from App Launch
Then Contact Page displayed
Given Get the size of contacts available and print the list
And search for the contact using unique name 'aa'
When Click on the dropdown icon available in the unique contact 
Then Dropdown will be displayed
When Click on edit
Then Edit window will open
Given Update Email with your personal mail id 'sarandeena28@gmail.com'
And Update Lead Source as Partner Referral from bottom
And Update Mailing Address with personal address '1802 sw'
And Update Level as Tertiary
And Update title as Automation Testing
When Click Save in the edit window
Then Verify and print Email 

Scenario: Tc002:Delete_Contact
When Click on toggle left corner of the page
Then Dropdown to view click view all
When Click view All in dropdown list
Then App Launcher window available
When Click on contacts in App Launch window
Then Contact Page loaded
Given print the size of contacts available and print the list
And search for contact using unique name 'peter'
And  Get the text of Contact name and store it
When Click on the dropdown icon in the unique contact 
Then Dropdown will be appear
When Click Delete to delete Contact
Then Verify whether the Contact is Deleted 