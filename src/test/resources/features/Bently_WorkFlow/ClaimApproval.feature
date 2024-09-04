Feature: Approval of the claim in sevatas side

  @ClaimApproval @All
  Scenario: Claim approval by approver
    Given I am in the login page of Horizon application
    When I login into Horizon application as "Handler"
    And I navigate to the "Claims" subtab in "Home" tab




