#Author: Aneesh Palliyalil

Feature: search Car Reistration Number & Verification
 
  Scenario: Search Car Reistration number in Application
    Given User Invoke browser
    And User naviate to appliction url
  
    
  Scenario Outline: Find car registration
    Given User enter registration number "<Reg Number>"
    Then Click on the Search button
    Then Verify the car reistration "<verification message>"
     Examples: 
      | Reg Number | verification message |
      | OV12UYY | Result for |
      | RF56JAN | Result for |
      
      