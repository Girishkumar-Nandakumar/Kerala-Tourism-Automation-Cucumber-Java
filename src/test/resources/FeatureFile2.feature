@Login
Feature: Valid Login Functionality

Scenario Outline: User Logs in with Invalid credentials

Given The user is on the login page
When The user enters a username "<username"> and password <"password">
And clicks the login button
Then an error message "<error Message>" should be displayed

username	|password	|errorMessage
wronguser1	|wrongpass1	|Invalid username or password
testUser	|123456		|Invalid username or password
abcd		|xyzz		|Invalid username or password
