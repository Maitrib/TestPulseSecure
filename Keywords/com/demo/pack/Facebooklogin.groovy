package com.demo.pack
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords


import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

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


class Facebooklogin {
	/**
	 * Refresh browser
	 */
	@Keyword
	def refreshBrowser() {
		KeywordUtil.logInfo("Refreshing")
		WebDriver webDriver = DriverFactory.getWebDriver()
		webDriver.navigate().refresh()
		KeywordUtil.markPassed("Refresh successfully")
	}


	@Keyword
	def login () {


		//open browser

		//WebUI.openBrowser("www.facebook.com");

		//instantiate webdriver object

		WebDriver driver = DriverFactory.getWebDriver()

		//Locate element and put the value
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("xyz@gmail.com");

		//locate element and put the value

		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("123456");

		driver.findElement(By.xpath("//button[@id='u_0_b']")).click();

	}

	@Keyword
	def static run(String cmd, File cwd = null){

		// update environment with the path to the local binaries
		def env = System.getenv()
		def envArray = []

		for (String key : env.keySet()) {
			if(key != "PATH"){
				envArray.add(key + "=" + env.get(key));
			}
			else{
				/*
				 * forcing Katalon to use all binaries on Macs as default path is
				 * PATH:/usr/bin:/bin:/usr/sbin:/sbin irrespective of system PATH variable
				 */
				envArray.add(key + "=" + env.get(key) + ":/usr/local/bin");
			}
		}


		// executing with the new environment and null for directory to use $pwd
		def sout = new StringBuilder()
		def serr = new StringBuilder()
		// ensure it uses the bash console
		KeywordUtil.logInfo("Running shell command: $cmd")

		// allows running on both jenkins agent and locally
		def proc =  ["bash", "-c", cmd].execute((String[])envArray, cwd);

		proc.consumeProcessOutput(sout, serr)
		proc.waitFor();
		KeywordUtil.logInfo("[STDERR]: " + serr.toString())
		KeywordUtil.logInfo("[STDOUT]: " + sout.toString())

		// exit if there was an execution error
		assert !proc.exitValue(), "[ERROR] " + serr.toString();
		return [
			sout.toString(),
			serr.toString()
		]
	}



	//	@Keyword
	//	def importPython(){
	//
	//		// empty argument will cause issues for the script
	//		//	String subdomainArgument = (tenantSubdomain != null) ? "--tenant-subdomain $tenantSubdomain" : "";
	//		//return run("System.getProperty('user.dir')" + "/gen_and_import_data.py")
	//		return run("/Users/maitri.brahmakshatriya/Downloads/gen_and_import_data.py")
	//	}

	@Keyword
	def static updateEtcHosts(){

		// empty argument will cause issues for the script
		//String subdomainArgument = (tenantSubdomain != null) ? "--tenant-subdomain $tenantSubdomain" : "";
		return run("./AppDynamicsJob.py")
	}
}