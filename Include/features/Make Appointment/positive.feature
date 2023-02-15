Feature: Make Appointment - without input mandatory field

  Scenario: Make Appointment unsuccess
  When user choose facility 
  And user click check box for apply hospital redmission
	And user choose 'Medicaid' as healthcare program
	And user choose visit date '26/02/2023'
	And user input 'Keren Banget' as comment
	And user click book appointment button
	Then user can see appointment confirmation
	
	