Feature: Login : Validate Login Functionality

  @Login @ValidCredentials @All
  Scenario: Login with valid credentials
    Given I am in the login page of Horizon application
    When I login into Horizon application as "Admin"
    #Then I can navigate to admin dashboard page

