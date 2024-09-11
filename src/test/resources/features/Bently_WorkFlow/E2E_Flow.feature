Feature: Bentley : E2E Flows

  @Bentley @EndToEnd
  Scenario: As a User, I need to validate E2E flows of Bentley
    Given I am in the login page of Horizon application
    When I login into Horizon application as a "Bentley" "Dealer"
    Then I can navigate to dealer dashboard page
    And I verify the details on the dealer dashboard page
    And I have added vehicle details for "Bentley"
    And I add the damage item details
      | damageItemsDetails |
      | yes                |
    And I save the damage item estimate details as a draft
      | damageItemsEstimateDetails | noOfDamageItemsToBeAdded | estimateDaysDifference | noOfLabourHrs | labourAmountPerHr | noOfPaintLabourHrs | paintLaboursAmountPerHrs | partsCost | paint/MaterialsCost | miscellaneousCost |
      | yes                        | 1                        | 3                      | 6             | 5                 | 6                  | 4                        | 10        | 5                   | 2                 |
    And I navigate Documents Upload page and upload documents
    And I submit the claim
    Then I validate the "Claims Awaiting Authorisation" fitter details in Dashboard
    And I navigate to My Claims page and validate the claims details with status "Awaiting acceptance from Sevatas"





