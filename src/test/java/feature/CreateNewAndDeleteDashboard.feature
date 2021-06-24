Feature: Dashboard Tab in SalesForce Application

Scenario: TC001:Create_New_DashBoard
When Click on toggle menu button left corner
Then Dropdown is displayed to select view all
When Click view All in the displayed dropdown
Then App Launcher window poped
When Service Console from App Launch
Then Service Page displayed
Given Select Home from the DropDown
And Select Dashboards from DropDown
When Click on New Dashboard
Then New Dashboard window displayed
Given Enter the Dashboard name as 'SaranyaJ30_Workout'
And  Enter Description as 'Testing'
When Click on Create
Then page to click done loaded
When Click on Done
Then Verify the Dashboard is Created
When Click on Subscribe
Then Subscribe page displayed
Given Select Frequency as 'Daily'
And Time as 10:00 AM
When Click on Save in window
Then Verify 'You started Dashboard Subscription' message displayed or not
When Close the 'SaranyaJ4130_Workout' tab
Then Dasboard page loaded
When Click on Private Dashboards
Then Verify the newly created Dashboard available

Scenario: TC002:Delete DashBoard
When Click on toggle button left corner
Then Dropdown displayed select view all
When Click view dropdown
Then App Launcher popup displayed
When Select Service Console from App Launch
Then Service Page should be displayed
When Click dropdown for the item in left corner
Then Dropdown displayed below
Given Click Delete
Then Confirm the Delete
Then Verify the item is not available under Private Dashboard folder
