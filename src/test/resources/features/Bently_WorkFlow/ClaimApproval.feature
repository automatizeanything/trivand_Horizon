Feature: Approval of the claim in sevatas side

  @ClaimApproval @All
  Scenario: Claim approval by approver
    Given I am in the login page of Horizon application
    When I login into Horizon application as "BentleyHandler"
    Then I navigate to the "Claims" subtab in "Home" tab
    And I choose the "My New Claims to be Submitted" widget
    And I perform the Claim Authorisation
    Then I navigate to the "Claims" subtab in "Home" tab
    And I choose the "All Damage Items not Authorised / Awaiting Sending" widget
    And I open the created claim
    And I update the authorization details
