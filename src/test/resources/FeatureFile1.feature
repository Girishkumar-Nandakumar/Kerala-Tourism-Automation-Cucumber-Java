@Login
Feature: Login Functionality for Kerala Tourism Website

  As a registered user
  I want to log into the Kerala Tourism portal
  So that I can access my personalized tourism recommendations and features

  # -----------------------------------
  # Scenario 1: Valid login credentials
  # -----------------------------------
  Scenario: User logs in with valid credentials
    Given the user is on the login page
    When the user enters a valid username and password
    And clicks the login button
    Then the user should be redirected to the homepage

  # -----------------------------------
  # Scenario 2: Invalid username and password
  # -----------------------------------
  Scenario: User attempts to login with invalid username and password
    Given the user is on the login page
    When the user enters username "invalid@geemail.com" and password "wrongPass123"
    And clicks the login button
    Then an error message should be displayed

  # -----------------------------------
  # Scenario 3: Valid username and invalid password
  # -----------------------------------
  Scenario: User attempts to login with valid username and invalid password
    Given the user is on the login page
    When the user enters username "admin@geemail.com" and password "incorrect@456"
    And clicks the login button
    Then an error message should be displayed

  # -----------------------------------
  # Scenario 4: Empty credentials
  # -----------------------------------
  Scenario: User attempts to login with empty credentials
    Given the user is on the login page
    When the user enters username "" and password ""
    And clicks the login button
    Then an error message should be displayed
