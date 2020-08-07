import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.navigateToUrl('https://analytics.elm.pzt.dev.perfsec.com/login/admin')

WebUI.maximizeWindow()

WebUI.setText(findTestObject('Page_Pulse Zero Trust Access/input_Username_username'), Username)

WebUI.setText(findTestObject('Page_Pulse Zero Trust Access/input_Password_password'), Password)

WebUI.sendKeys(findTestObject('Object Repository/Pulse Secure/Page_Pulse Zero Trust Access/input_Password_password'), Keys.chord(
        Keys.ENTER))

not_run: WebUI.click(findTestObject('Object Repository/Pulse Secure/Page_Pulse Zero Trust Access/span_Close Menu_icon-menu'))

not_run: WebUI.click(findTestObject('Object Repository/Pulse Secure/Page_Pulse Zero Trust Access/button_Insights'))

not_run: WebUI.click(findTestObject('Object Repository/Pulse Secure/Page_Pulse Zero Trust Access/a_All Users'))

not_run: WebUI.click(findTestObject('Object Repository/Pulse Secure/Page_Pulse Zero Trust Access/rect_JavaScript chart by amCharts_amcharts-_c75ca6'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.closeBrowser()

