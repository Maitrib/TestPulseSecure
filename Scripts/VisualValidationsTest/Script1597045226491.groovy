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

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.URL)

CustomKeywords.'com.kms.katalon.keyword.applitools.BasicKeywords.checkWindow'('Checkpoint1')

WebUI.setText(findTestObject('Page_Pulse Zero Trust Access/input_Username_username'), GlobalVariable.username)

WebUI.setText(findTestObject('Page_Pulse Zero Trust Access/input_Password_password'), GlobalVariable.password)

WebUI.sendKeys(findTestObject('Object Repository/Page_Pulse Zero Trust Access/input_Password_password'), Keys.chord(Keys.ENTER))

CustomKeywords.'com.kms.katalon.keyword.applitools.BasicKeywords.checkWindow'('Checkpoint2')

WebUI.closeBrowser()

