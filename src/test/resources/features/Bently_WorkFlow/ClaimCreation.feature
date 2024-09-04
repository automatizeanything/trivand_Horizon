Feature: Bentley : Validate Claim Creation

  @Bentley @Dealer @ClaimCreation
  Scenario: As a Bentley Dealer, I need to submit a claim and send it for approval
    Given I am in the login page of Horizon application
    When I login into Horizon application as a "Bentley" "Dealer"
    Then I can navigate to dealer dashboard page
    And I verify details in dealer dashboard page
    And I save a new claim for "Bentley" as draft
    And I navigate to "Home" page
    And I have validated "Incomplete Claims" fitter details in Dashboard
    And I navigate to My Claims page and validated the claims details with status "Incomplete"
    And I navigate back to Claims Edit page continue the editing
    And I have added damage item details




