Feature: Bentley : Validate Invoice Creation

  @Bentley @Dealer @InvoiceCreation
  Scenario: As a Bentley Dealer, I need to submit the invoice for approval
    Given I am in the login page of Horizon application
    When I login into Horizon application as a "Bentley" "Dealer"
    Then I can navigate to dealer dashboard page
    And I verify the details on the dealer dashboard page
    And I select the claimID "984055" from "Claims Authorised; Please Repair" page
    #And I verify the claim details in claim summary page     ------For e2e test case. Correct the serenity variable names while integration
    And I add documents to the claim
    And I navigate to add invoice page
    #And I verify the details in invoice page          ------For e2e test case. Correct the serenity variable names while integration
    And I add invoice for the claim
    Then The invoice creation should be successful
    And I navigate to "Home" page
    And I validate the "Claims Authorised; Please Repair" fitter details in Dashboard
    And I navigate to "Home" page
    And I validate the "Invoices Sent; Awaiting Payment" fitter details in Dashboard