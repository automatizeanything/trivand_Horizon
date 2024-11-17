Feature: Bentley : E2E Flows

  @Bentley @EndToEnd
  Scenario: As a User, I need to validate E2E flows of Bentley
    Given I am in the login page of Horizon application
    When I login into Horizon application as a "Bentley" "Dealer"
    Then I can navigate to dealer dashboard page
    And I verify the details on the dealer dashboard page
    And I have added vehicle details
      | brandName | arrivalDaysDifference |
      | Bentley   | 3                     |
    And I add the damage item details
      | damageItemsDetails | damagelocation                    | damageType | repairMethod | severityLevel                                  |
      | yes                | Bumper / Cover / Ext. (Rear) (04) | Dented     | Repaint      | Damage 30cm and over in length and/or diameter |
    And I save the damage item estimate details as a draft
      | damageItemsEstimateDetails | noOfDamageItemsToBeAdded | estimateDaysDifference | noOfLabourHrs | labourAmountPerHr | noOfPaintLabourHrs | paintLaboursAmountPerHrs | partsCost | paint/MaterialsCost | miscellaneousCost |
      | yes                        | 1                        | 3                      | 6             | 5                 | 6                  | 4                        | 10        | 5                   | 2                 |
    And I navigate Documents Upload page and upload documents
    And I submit the claim
    Then I validate the "Claims Awaiting Authorisation" fitter details in Dashboard
    And I navigate to My Claims page and validate the claims details with status "Awaiting acceptance from Sevatas"

    And I performed Logout
    When I login into Horizon application as "BentleyHandler"
    Then I navigate to the "Claims" subtab in "Home" tab
    And I choose the "My New Claims to be Submitted" widget
    And I perform the Claim Authorisation
    Then I navigate to the "Claims" subtab in "Home" tab
    And I choose the "All Damage Items not Authorised / Awaiting Sending" widget
    And I open the created claim
    And I update the authorization details
    And I performed Logout
    And I login into Horizon application as a "Bentley" "Dealer"

    #################Claim authorised to invoice sent
    And I select the claimID "Test" from "Claims Authorised; Please Repair" page
    And I add documents to the claim
    And I navigate to add invoice page
    And I add invoice for the claim
    Then The invoice creation should be successful
    And I navigate to "Home" page
    And I validate the "Claims Authorised; Please Repair" fitter details in Dashboard
    And I navigate to "Home" page
    And I validate the "Invoices Sent; Awaiting Payment" fitter details in Dashboard

  @Bentley @EndToEnd @MultipleDamageItems
  Scenario: As a User, I need to validate E2E flows of Bentley with multiple damage items,and need to perform estimate splitting
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
      | damageItemsDetails | damagelocation                    | damageType | repairMethod | severityLevel                                  |
      | yes                | Bumper / Cover / Ext. (Rear) (04) | Dented     | Repaint      | Damage 30cm and over in length and/or diameter |
    And I save the damage item estimate details as a draft
      | damageItemsEstimateDetails | noOfDamageItemsToBeAdded | estimateDaysDifference | noOfLabourHrs | labourAmountPerHr | noOfPaintLabourHrs | paintLaboursAmountPerHrs | partsCost | paint/MaterialsCost | miscellaneousCost |
      | yes                        | 2                        | 3                      | 6             | 5                 | 6                  | 4                        | 10        | 5                   | 2                 |
    And I add the damage item details
      | damageItemsDetails | damagelocation        | damageType | repairMethod   | severityLevel                                |
      | yes                | Door, Left Front (10) | Cracked    | Brush Touch Up | Damage up to 2.5cm in length and/or diameter |
    And I save the damage item estimate details as a draft
      | damageItemsEstimateDetails | noOfDamageItemsToBeAdded | estimateDaysDifference | noOfLabourHrs | labourAmountPerHr | noOfPaintLabourHrs | paintLaboursAmountPerHrs | partsCost | paint/MaterialsCost | miscellaneousCost |
      | yes                        | 1                        | 3                      | 6             | 5                 | 5                  | 4                        | 10        | 5                   | 2                 |
    And I navigate Documents Upload page and upload documents
    And I submit the claim
    Then I validate the "Claims Awaiting Authorisation" fitter details in Dashboard
    And I navigate to My Claims page and validate the claims details with status "Awaiting acceptance from Sevatas"
    And I performed Logout
    When I login into Horizon application as "BentleyHandler"
    Then I navigate to the "Claims" subtab in "Home" tab
    And I choose the "My New Claims to be Submitted" widget

    And I perform the Claim Authorisation
    Then I navigate to the "Claims" subtab in "Home" tab
    And I choose the "All Damage Items not Authorised / Awaiting Sending" widget
    And I open the created claim
    And I update the authorization details
    And I performed Logout
    And I login into Horizon application as a "Bentley" "Dealer"

    #################Claim authorised to invoice sent
    And I select the claimID "Test" from "Claims Authorised; Please Repair" page
    And I add documents to the claim
    And I navigate to add invoice page
    And I add invoice for the claim
    Then The invoice creation should be successful
    And I navigate to "Home" page
    And I validate the "Claims Authorised; Please Repair" fitter details in Dashboard
    And I navigate to "Home" page
    And I validate the "Invoices Sent; Awaiting Payment" fitter details in Dashboard

  @Bentley @EndToEnd @AV
  Scenario: As a User, I need to validate E2E flows of Bentley with validations performed from AV side
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
      | damageItemsDetails | damagelocation        | damageType | repairMethod   | severityLevel                                |
      | yes                | Door, Left Front (10) | Cracked    | Brush Touch Up | Damage up to 2.5cm in length and/or diameter |
    And I save the damage item estimate details as a draft
      | damageItemsEstimateDetails | noOfDamageItemsToBeAdded | estimateDaysDifference | noOfLabourHrs | labourAmountPerHr | noOfPaintLabourHrs | paintLaboursAmountPerHrs | partsCost | paint/MaterialsCost | miscellaneousCost |
      | yes                        | 1                        | 3                      | 6             | 50                | 6                  | 4                        | 10        | 5                   | 2                 |
    And I navigate Documents Upload page and upload documents
    And I submit the claim
    Then I validate the "Claims Awaiting Authorisation" fitter details in Dashboard
    And I navigate to My Claims page and validate the claims details with status "Awaiting acceptance from Sevatas"
    And I performed Logout
    When I login into Horizon application as "BentleyHandler"
    Then I navigate to the "Claims" subtab in "Home" tab
    And I choose the "My New Claims to be Submitted" widget
    And I perform the Claim Authorisation
    And I performed Logout
    When I login into Horizon application as "BentleyAV"
    And I choose the "Jobs due today or overdue" widget
    And I open the created claim
    And AV update the parts value to "5"
    And I performed Logout
    When I login into Horizon application as "BentleyHandler"
    Then I navigate to the "Claims" subtab in "Home" tab
    And I choose the "All Damage Items not Authorised / Awaiting Sending" widget
    And I open the created claim
    And I verify the AV updated value is reflected in the claim
    And I update the authorization details
    And I performed Logout
    And I login into Horizon application as a "Bentley" "Dealer"
    #################Claim authorised to invoice sent
    And I select the claimID "Test" from "Claims Authorised; Please Repair" page
    And I add documents to the claim
    And I navigate to add invoice page
    And I add invoice for the claim
    Then The invoice creation should be successful
    And I navigate to "Home" page
    And I validate the "Claims Authorised; Please Repair" fitter details in Dashboard
    And I navigate to "Home" page
    And I validate the "Invoices Sent; Awaiting Payment" fitter details in Dashboard

  @Bentley @EndToEnd @AVMultipleItems
  Scenario: As a User, I need to validate E2E flows of Bentley with validations performed from AV side
            when the claim has multiple damage items
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
      | damageItemsDetails | damagelocation                    | damageType | repairMethod | severityLevel                                  |
      | yes                | Bumper / Cover / Ext. (Rear) (04) | Dented     | Repaint      | Damage 30cm and over in length and/or diameter |
    And I save the damage item estimate details as a draft
      | damageItemsEstimateDetails | noOfDamageItemsToBeAdded | estimateDaysDifference | noOfLabourHrs | labourAmountPerHr | noOfPaintLabourHrs | paintLaboursAmountPerHrs | partsCost | paint/MaterialsCost | miscellaneousCost |
      | yes                        | 2                        | 3                      | 6             | 5                 | 6                  | 4                        | 10        | 5                   | 2                 |
    And I add the damage item details
      | damageItemsDetails | damagelocation        | damageType | repairMethod   | severityLevel                                |
      | yes                | Door, Left Front (10) | Cracked    | Brush Touch Up | Damage up to 2.5cm in length and/or diameter |
    And I save the damage item estimate details as a draft
      | damageItemsEstimateDetails | noOfDamageItemsToBeAdded | estimateDaysDifference | noOfLabourHrs | labourAmountPerHr | noOfPaintLabourHrs | paintLaboursAmountPerHrs | partsCost | paint/MaterialsCost | miscellaneousCost |
      | yes                        | 1                        | 3                      | 6             | 5                 | 5                  | 4                        | 10        | 5                   | 2                 |
    And I navigate Documents Upload page and upload documents
    And I submit the claim
    Then I validate the "Claims Awaiting Authorisation" fitter details in Dashboard
    And I navigate to My Claims page and validate the claims details with status "Awaiting acceptance from Sevatas"
    And I performed Logout
    When I login into Horizon application as "BentleyHandler"
    Then I navigate to the "Claims" subtab in "Home" tab
    And I choose the "My New Claims to be Submitted" widget
    And I perform the Claim Authorisation
    And I performed Logout
    When I login into Horizon application as "BentleyAV"
    And I choose the "Jobs due today or overdue" widget
    And I open the created claim
    And AV update the parts value to "5"
    And I performed Logout
    When I login into Horizon application as "BentleyHandler"
    Then I navigate to the "Claims" subtab in "Home" tab
    And I choose the "All Damage Items not Authorised / Awaiting Sending" widget
    And I open the created claim
    And I verify the AV updated value is reflected in the claim
    And I update the authorization details
    And I performed Logout
    And I login into Horizon application as a "Bentley" "Dealer"
    #################Claim authorised to invoice sent
    And I select the claimID "Test" from "Claims Authorised; Please Repair" page
    And I add documents to the claim
    And I navigate to add invoice page
    And I add invoice for the claim
    Then The invoice creation should be successful
    And I navigate to "Home" page
    And I validate the "Claims Authorised; Please Repair" fitter details in Dashboard
    And I navigate to "Home" page
    And I validate the "Invoices Sent; Awaiting Payment" fitter details in Dashboard

