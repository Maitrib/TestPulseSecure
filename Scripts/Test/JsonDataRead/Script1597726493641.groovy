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
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import groovy.json.JsonSlurper as JsonSlurper

com.kms.katalon.core.util.internal.JsonUtil

def slurper = new JsonSlurper()


File jsontxt = new File('/Users/maitri.brahmakshatriya/Katalon Studio/TestPulseSecure/data.json')

//def InputJson = new JsonSlurper().parse(jsontxt,'utf-8')
def result = slurper.parse(jsontxt)

//println(result);
def chart_type = result._source.chart_type

String type = chart_type

String id = result._source.unique_id

String max_user_list = result._source.consolidated_snapshot.max_users_list

print(type)

print(id)

println(result)

//assert Mobile.getElementText(findTestObject(‘your/object’)) == yourValue
WebUI.verifyMatch(type, GlobalVariable.type, true)


