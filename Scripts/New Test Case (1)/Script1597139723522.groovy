import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.applitools.eyes.RectangleSize
import com.applitools.eyes.TestResults as TestResults
import com.applitools.eyes.selenium.Eyes as Eyes
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

Eyes createEyes() {
	URI serverURL
	try {
		serverURL = new URI(GlobalVariable.serverURLstr)
	} catch (URISyntaxException e) {
		println("URI Exception")
		return
	}
	Eyes eyes = new Eyes(serverURL)
	String apiKey = System.getenv("APPLITOOLS_API_KEY")
	println "apiKey=${apiKey}"
	eyes.setApiKey(apiKey)
	if (GlobalVariable.runAsBatch) {
		BatchInfo batchInfo = new BatchInfo("Hello World 2 Batch")
		eyes.setBatch(batchInfo)
	}
	
	// kazurayam needed to set PROXY to the Eyes
	def pi = RunConfiguration.getProxyInformation()
	if (pi.proxyOption == 'MANUAL_CONFIG' && pi.proxyServerType == 'HTTP' &&
		pi.proxyServerAddress.length() > 0 && pi.proxyServerPort > 0) {
		eyes.setProxy(new ProxySettings("http://${pi.proxyServerAddress}:${pi.proxyServerPort}"))
	}
	
	return eyes
}

/**
 * 
 */
void handleResult(TestResults result) {
	String resultStr
	String url
	if (result == null) {
		resultStr = "Test aborted"
		url = "undefined"
	} else {
		url = result.getUrl()
		int totalSteps = result.getSteps()
		if (result.isNew()) {
			resultStr = "New Baseline created: ${totalSteps} steps"
		} else if (result.isPassed()) {
			resultStr = "All steps passed:     ${totalSteps} steps"
		} else {
			StringBuilder sb = new StringBuilder()
			sb.append(  "Test Failed     :     ${totalSteps} steps\n")
			sb.append(" matches=   ${result.getMatches()}\n")
			sb.append(" missing=   ${result.getMissing()}\n")
			sb.append(" mismatches=${result.getMismatches()}\n")
			resultStr = sb.toString()
		}
		resultStr += "\n" + "results at " + url
		WebUI.comment(resultStr)
	}
}

// --------------------------------------------------------------------

RectangleSize viewportSize = new RectangleSize(
    GlobalVariable.viewportSizeLandscapeWidth,
    GlobalVariable.viewportSizeLandscapeHeight)

WebUI.comment("now we open browser")
WebUI.openBrowser('')
 instanciate Eyes object based on the WebDriver object managed by Katalon Studio
WebDriver innerDriver = DF.getWebDriver()

Eyes eyes = createEyes()

eyes.open(innerDriver, GlobalVariable.appName, GlobalVariable.testName, viewportSize)

WebUI.navigateToUrl('https://analytics.elm.pzt.dev.perfsec.com/login/admin')

eyes.checkWindow('Before enter name')

WebUI.setText(findTestObject('Page_Pulse Zero Trust Access/input_Username_username'), 'My Name')

eyes.checkWindow('After enter name')

WebUI.setText(findTestObject('Page_Pulse Zero Trust Access/input_Password_password'), '')

eyes.checkWindow('After Click')

TestResults result = eyes.close(false)

WebUI.closeBrowser()

