Feature: Bentley : Validate Claim Creation

  @Bentley @Dealer @ClaimCreation @FieldValidation
  Scenario: As a Bentley Dealer, I need to submit a claim (within 3 days of arrival) and send it for approval
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
      | damageItemsDetails |
      | yes                |
    And I save damage item estimate details as draft
      | damageItemsEstimateDetails | noOfDamageItemsToBeAdded | estimateDaysDifference | noOfLabourHrs | labourAmountPerHr | noOfPaintLabourHrs | paintLaboursAmountPerHrs | partsCost | paint/MaterialsCost | miscellaneousCost |
      | yes                        | 1                        | 3                      | 6             | 5                 | 6                  | 4                        | 10        | 5                   | 2                 |
    And I navigate to "Home" page
    And I have validated "Incomplete Claims" fitter details in Dashboard
    And I navigate to My Claims page and validated the claims details with status "Incomplete"
    And I navigate back to Claims Edit page continue the editing
    And I navigate Documents Upload page and upload documents
    And I submit the claim
    Then I have validated "Incomplete Claims" fitter details in Dashboard
    And I have validated "Claims Awaiting Authorisation" fitter details in Dashboard
    And I navigate to My Claims page and validated the claims details with status "Awaiting acceptance from Sevatas"
    And I verified that the claim summary table has a status of "Awaiting authorisation"





