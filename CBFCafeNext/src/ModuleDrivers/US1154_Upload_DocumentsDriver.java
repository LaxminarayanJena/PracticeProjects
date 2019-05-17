/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 12/27/2017 2:05:44 PM
Module part of 'Guidewire Billing Center'
Module created using Cafenext Selenium Builder
******************************************************************************/
package ModuleDrivers;

import static cbf.engine.TestResultLogger.*;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cbf.engine.TestResult.ResultType;
import cbf.harness.ParameterAccess;
import cbf.utils.DataRow;
import cbf.utils.SleepUtils;
import cbf.utils.SleepUtils.TimeSlab;
import cbfx.selenium.BaseWebModuleDriver;

/**
 * Extends BaseModuleDriver class and performs application specific operations
 */
public class US1154_Upload_DocumentsDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;

	public US1154_Upload_DocumentsDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}

	public void US1154_Upload_Documents_Accoun(DataRow input, DataRow output) {
		// 1. Click on Actions WebElement
		uiDriver.click("US1154_Upload_Documents_Accoun.eltActions");

		// 2. Verify Actions for Upload Documents link
		try {
			uiDriver.webDr.findElement(By.partialLinkText("Upload Documents"));
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		} catch (org.openqa.selenium.NoSuchElementException e) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		}
		
	}

	public void US1154_Upload_Documents_Policy(DataRow input, DataRow output) {

		// 1. Click on Policies_Tab WebElement
		uiDriver.click("US1208_PolicyDocuments.eltPolicies_Tab");

		// 2. Click on Policy_link WebElement
		uiDriver.click("US1208_PolicyDocuments.eltPolicy_link");

		// 3. Click on Actions WebElement
		uiDriver.click("US1208_PolicyDocuments.eltActions");

		// 4. Click on Actions for Upload Documents WebElement
		try {
			uiDriver.webDr.findElement(By.partialLinkText("Upload Documents"));
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		} catch (org.openqa.selenium.NoSuchElementException e) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		}
	}

	public void US1154_Upload_Documents_Produ(DataRow input, DataRow output) {
		//1. Click on Producer_Tab WebElement
		uiDriver.click("US1208_ProducerDocuments.eltProducer_Tab");
				
		//2. Click on Producer_code WebElement
		uiDriver.click("US1208_ProducerDocuments.eltProducer_code");
				
		//3. Type $data in Producer_Code field
		uiDriver.setValue("US1208_ProducerDocuments.txtProducer_Code", input.get("Type@Producer_Code"));
		uiDriver.click("US1208_ProducerDocuments.btnsearch");
				
		//4. Click on Producer_Name Link
		uiDriver.click("US1208_ProducerDocuments.lnkProducer_Name");
				
		//5. Click on Actions WebElement
		uiDriver.click("US1208_ProducerDocuments.eltActions");
					
		// 6. Click on Actions for Upload Documents WebElement
		try
		{
			uiDriver.webDr.findElement(By.partialLinkText("Upload Documents"));
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		catch(org.openqa.selenium.NoSuchElementException e)
		{
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		}
	}
	
	/**
	 * Overriding toString() method of object class to print US1154_Upload_Documents
	 * format string
	 **/
	public String toString() {
		return "US1154_Upload_DocumentsDriver";
	}
}
