Feature: Approval of the claim in sevatas side

  @Login @ValidCredentials @All
  Scenario: Claim approval by approver
    Given I am in the login page of Horizon application
    When I login into GID application as "Approver"