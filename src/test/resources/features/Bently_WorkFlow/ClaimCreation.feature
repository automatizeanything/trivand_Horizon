Feature: Bentley : Validate Claim Creation

  @Bentley @Dealer @ClaimCreation @FieldValidation
  Scenario: As a Bentley Dealer, I need to submit a claim (within 2 days of arrival) and send it for approval
    Given I am in the login page of Horizon application
    When I login into Horizon application as a "Bentley" "Dealer"
    Then I can navigate to dealer dashboard page
    And I verify the details on the dealer dashboard page
    And I save a new claim as draft
      | brandName | arrivalDaysDifference |
      | Bentley   | 3                     |
    And I navigate to "Home" page
    And I validate the "Incomplete Claims" fitter details in Dashboard
    And I navigate to My Claims page and validate the claims details with status "Incomplete"
    And I navigate back to Claims Edit page continue the editing
    And I add the damage item details
      | damageItemsDetails |
      | yes                |
    And I save the damage item estimate details as a draft
      | damageItemsEstimateDetails | noOfDamageItemsToBeAdded | estimateDaysDifference | noOfLabourHrs | labourAmountPerHr | noOfPaintLabourHrs | paintLaboursAmountPerHrs | partsCost | paint/MaterialsCost | miscellaneousCost |
      | yes                        | 1                        | 2                      | 6             | 5                 | 6                  | 4                        | 10        | 5                   | 2                 |
    And I navigate to "Home" page
    And I validate the "Incomplete Claims" fitter details in Dashboard
    And I navigate to My Claims page and validate the claims details with status "Incomplete"
    And I navigate back to Claims Edit page continue the editing
    And I navigate Documents Upload page and upload documents
    And I submit the claim
    Then I validate the "Incomplete Claims" fitter details in Dashboard
    And I validate the "Claims Awaiting Authorisation" fitter details in Dashboard
    And I navigate to My Claims page and validate the claims details with status "Awaiting acceptance from Sevatas"
    And I verify that the claim summary table has a status of "Awaiting authorisation"

  @Bentley @Dealer @ClaimCreation @FieldValidation @AcceptRejection
  Scenario: As a Bentley Dealer, I need to submit a claim (within 10 days of arrival) and accept rejection
    Given I am in the login page of Horizon application
    When I login into Horizon application as a "Bentley" "Dealer"
    Then I can navigate to dealer dashboard page
    And I verify the details on the dealer dashboard page
    And I save a new claim as draft
      | brandName | arrivalDaysDifference |
      | Bentley   | 10                    |
    And I navigate to "Home" page
    And I validate the "Incomplete Claims" fitter details in Dashboard
    And I navigate to My Claims page and validate the claims details with status "Incomplete"
    And I navigate back to Claims Edit page continue the editing
    And I add the damage item details
      | damageItemsDetails |
      | yes                |
    And I save the damage item estimate details as a draft
      | damageItemsEstimateDetails | noOfDamageItemsToBeAdded | estimateDaysDifference | noOfLabourHrs | labourAmountPerHr | noOfPaintLabourHrs | paintLaboursAmountPerHrs | partsCost | paint/MaterialsCost | miscellaneousCost |
      | yes                        | 1                        | 3                      | 6             | 5                 | 6                  | 4                        | 10        | 5                   | 2                 |
    And I navigate to "Home" page
    And I validate the "Incomplete Claims" fitter details in Dashboard
    And I navigate to My Claims page and validate the claims details with status "Incomplete"
    And I navigate back to Claims Edit page continue the editing
    And I navigate Documents Upload page and upload documents
    And I try to submit the claim
    Then Claim challenge dialog box should be displayed and I select "Accept Rejection" option
    And I validate the "Rejected Claims" fitter details in Dashboard
    And I navigate to My Claims page and validate the claims details with status "Closed - Incomplete"
    And I verify that the claim summary table has a status of "Item rejected/ not repaired"

  @Bentley @Dealer @ClaimCreation @FieldValidation @Challenge
  Scenario: As a Bentley Dealer, I need to submit a claim (within 6 days of arrival) and challenge
    Given I am in the login page of Horizon application
    When I login into Horizon application as a "Bentley" "Dealer"
    Then I can navigate to dealer dashboard page
    And I verify the details on the dealer dashboard page
    And I save a new claim as draft
      | brandName | arrivalDaysDifference |
      | Bentley   | 6                     |
    And I navigate to "Home" page
    And I validate the "Incomplete Claims" fitter details in Dashboard
    And I navigate to My Claims page and validate the claims details with status "Incomplete"
    And I navigate back to Claims Edit page continue the editing
    And I add the damage item details
      | damageItemsDetails |
      | yes                |
    And I save the damage item estimate details as a draft
      | damageItemsEstimateDetails | noOfDamageItemsToBeAdded | estimateDaysDifference | noOfLabourHrs | labourAmountPerHr | noOfPaintLabourHrs | paintLaboursAmountPerHrs | partsCost | paint/MaterialsCost | miscellaneousCost |
      | yes                        | 1                        | 3                      | 6             | 5                 | 6                  | 4                        | 10        | 5                   | 2                 |
    And I navigate to "Home" page
    And I validate the "Incomplete Claims" fitter details in Dashboard
    And I navigate to My Claims page and validate the claims details with status "Incomplete"
    And I navigate back to Claims Edit page continue the editing
    And I navigate Documents Upload page and upload documents
    And I try to submit the claim
    Then Claim challenge dialog box should be displayed and I select "Challenge" option
    And I validate the "Claims Awaiting Authorisation" fitter details in Dashboard
    And I navigate to My Claims page and validate the claims details with status "Awaiting acceptance from Sevatas"
    And I verify that the claim summary table has a status of "Awaiting authorisation"





