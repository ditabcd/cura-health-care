Feature: Make Appointment - without input mandatory field

  Scenario: Make Appointment unsuccess
  When user choose facility 
  And user click check box for apply hospital redmission
	And user choose 'Medicaid' as healthcare program
	And user input 'Keren banget' as comment
	And user click book appointment button
	Then user see tooltip has message 'Please fill out this field.' on visit date