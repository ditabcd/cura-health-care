import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



class makeAppointment {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */

	@When("user choose facility")
	def userChooseFacility() {
		WebUI.click(findTestObject('Object Repository/Appointment/dropdownFacility'))
		WebUI.click(findTestObject('Object Repository/Appointment/optionFacility'))
	}

	@When("user click check box for apply hospital redmission")
	def userChecked() {
		WebUI.click(findTestObject('Object Repository/Appointment/checkbox'))
	}

	@When("user choose '(.*)' as healthcare program")
	def userChooseHealthProgram(String program) {
		WebUI.click(findTestObject('Object Repository/Appointment/radioButton'))
	}

	@When("user choose visit date '(.*)'")
	def userChooseDate(String date) {
		WebUI.setText(findTestObject('Object Repository/Appointment/fieldDate'), date)
	}

	@When("user input '(.*)' as comment")
	def userInputComment(String value) {
		WebUI.setText(findTestObject('Object Repository/Appointment/comment'), value)
	}

	@When("user click book appointment button")
	def clickBtnBook() {
		WebUI.click(findTestObject('Object Repository/Appointment/btnBook'))
	}

	@Then("user can see appointment confirmation")
	def seeConfirm() {
		String url = WebUI.getUrl()
		WebUI.verifyEqual(url, 'https://katalon-demo-cura.herokuapp.com/appointment.php#summary')
		WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/summary/facility')), 'Hongkong CURA Healthcare Center')
		WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/summary/hospitalReadmission')), 'Yes')
		WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/summary/program')), 'Medicaid')
		WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/summary/visitDate')), '26/02/2023')
		WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/summary/comment')), 'Keren Banget')
	}

	@Then("user see tooltip has message '(.*)' on visit date")
	def seeTooltip (String message) {
		String tooltip = WebUI.getAttribute(findTestObject('Object Repository/Appointment/fieldDate'), 'validationMessage')
		WebUI.verifyEqual(tooltip, message)
	}
}
