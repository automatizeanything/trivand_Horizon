Feature: Login : Validate Login Functionality

  @Login @ValidCredentials @All
  Scenario: Login with valid credentials
    Given I am in the login page of GID application
    When I login into GID application as "Admin"
    Then I can navigate to admin dashboard page

  @Login @InValidCredentials @All
  Scenario: Login with invalid credentials
    Given I am in the login page of GID application
    When I login into GID application as "Admin"
    Then Login should be failed for invalid credentials
