Feature: Automating Salesforce Web Application	

Background:
When Enter the UserName as 'dilip@testleaf.com'
And Enter the Password as 'leaf@2024'
And Click on Login button
And Click on the toggle menu button in the left corner
And Click on View All
And Select Sales from the App Launcher
And Click on Opportunity tab


@Sanity
Scenario Outline: Salesforce Login and Create Leads
When Click on the new button
And Enter the Opportunity name as 'Salesforce Automation by  Diwan'
And Enter Amount as <Amount>
And Choose the close date as Today
And Select Stage as Need Analysis
And Click on save button
Then Verify the opportunity Name as 'Salesforce Automation by Diwan'

Examples:
|Amount|
|'50,000'|
|'75,000'|


@Smoke
Scenario: Salesforce Login and Edit Leads
When Search for the Opportunity 'Salesforce Automation by  Diwan'
And Click on DropDown Icon
And Select Edit button
And Choose the close date as Tomorrow date
And Select Stage as Perception Analysis
And Select Delivery/Installation Status as In Progress
And Enter Description as SalesForce
And Click on Save
Then verify the Stage as Perception Analysis
