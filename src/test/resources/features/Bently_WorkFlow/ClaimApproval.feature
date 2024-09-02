Feature: Approval of the claim in sevatas side

  @ClaimApproval @All
  Scenario: Claim approval by approver
    Given I am in the login page of Horizon application
    When I login into Horizon application as "Handler"
    Then I navigate to the "Claims" subtab in "Home" tab
    And I choose the "My New Claims to be Submitted" widget
    And I perform the Claim Authorisation