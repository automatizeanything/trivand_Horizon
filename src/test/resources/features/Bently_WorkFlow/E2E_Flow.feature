Feature: Bentley : E2E Flows

  @Bentley @EndToEnd
  Scenario: As a User, I need to validate E2E flows of Bentley
    Given I am in the login page of Horizon application
    When I login into Horizon application as a "Bentley" "Dealer"
    Then I can navigate to dealer dashboard page
    And I verify details in dealer dashboard page
    And I have added vehicle details for "Bentley"
    And I have added damage item details
      | damageItemsDetails |
      | yes                |
    And I save damage item estimate details as draft
      | damageItemsEstimateDetails | noOfDamageItemsToBeAdded | estimateDaysDifference | noOfLabourHrs | labourAmountPerHr | noOfPaintLabourHrs | paintLaboursAmountPerHrs | partsCost | paint/MaterialsCost | miscellaneousCost |
      | yes                        | 1                        | 3                      | 6             | 5                 | 6                  | 4                        | 10        | 5                   | 2                 |
    And I navigate Documents Upload page and upload documents
    And I submit the claim
    Then I have validated "Claims Awaiting Authorisation" fitter details in Dashboard
    And I navigate to My Claims page and validated the claims details with status "Awaiting acceptance from Sevatas"





