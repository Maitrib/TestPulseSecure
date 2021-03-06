import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.applitools.eyes.selenium.Eyes as Eyes
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.keyword.applitools.Utils as Utils
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

//-----------------------------------------check eyesOpen/checkWindow/checkRegion/eyesClose ------------------------------------------------------------
//use 'https://applitools.com/helloworld2?diff1' to make changes to page
WebUI.openBrowser('https://analytics.elm.pzt.dev.perfsec.com/login/admin')



//initialize eyesßß
Eyes eyes = CustomKeywords.'com.kms.katalon.keyword.applitools.EyesKeywords.eyesOpen'('uniqueString0', null)

WebDriver driver = Utils.getDriverForEyes()

//driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/form/div/table[2]/tbody/tr[2]/td/input")).sendKeys('admindb')
//
//By locatorBy = By.xpath("/html/body/div/div/div/div/div[1]/form/div/table[2]/tbody/tr[2]/td/input")
//
//eyes.checkRegion(locatorBy, 'check checkRegion by selector keyword')

//driver.findElement(By.id('name')).sendKeys('My Name')
//
//By locatorBy = By.id('name')
//
//eyes.checkRegion(locatorBy, 'check checkRegion by selector keyword')
//
//driver.findElement(By.tagName('button')).click()
//
//WebElement element = driver.findElement(By.xpath('//img[contains(@class,\'diff2\')]'))
//
////check region by web element
//eyes.checkRegion(element, 'check checkRegion by web element keyword')
//check window not including eyes set up
eyes.checkWindow('check checkWindow')

CustomKeywords.'com.kms.katalon.keyword.applitools.EyesKeywords.eyesClose'(eyes)

WebUI.closeBrowser()

