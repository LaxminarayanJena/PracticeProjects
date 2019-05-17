/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 12/8/2017 4:44:03 AM
Module part of 'Guidewire_BillingCenter'
Module created using Cafenext Selenium Builder
******************************************************************************/
package ModuleDrivers;

import static cbf.engine.TestResultLogger.*;
import java.io.IOException;

import org.openqa.selenium.By;

import cbf.engine.TestResult.ResultType;
import cbf.harness.ParameterAccess;
import cbf.utils.DataRow;
import cbf.utils.SleepUtils;
import cbf.utils.SleepUtils.TimeSlab;
import cbfx.selenium.BaseWebModuleDriver;

/**
 * Extends BaseModuleDriver class and performs application specific operations
 */
public class US1102_MaintainAccntSumryInfDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;

	public US1102_MaintainAccntSumryInfDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}

	public void ViewAndEditAccSumm(DataRow input, DataRow output) {

		// 1. Verify the text ?$data in the Name field
		SleepUtils.sleep(3);
		String actualTextName = uiDriver.getControl("ViewAndEditAccSumm.eltName").getText();
		String expectedTextName = input.get("VerifyText@Name");

		if (actualTextName.equalsIgnoreCase(expectedTextName)) {
			passed("verifyText", "verifyText should pass", "verifyText passed");
		} else {
			failed("verifyText", "verifyText should pass", "verifyText failed");
		}

		// 2. Verify the text ?$data in the Primary_Contact field
		String actualTextPrimary = uiDriver.getControl("ViewAndEditAccSumm.eltPrimary_Contact").getText();
		String expectedTextPrimary = input.get("VerifyText@Primary_Contact");

		if (actualTextPrimary.equalsIgnoreCase(expectedTextPrimary)) {
			passed("verifyText", "verifyText should pass", "verifyText passed");
		} else {
			failed("verifyText", "verifyText should pass", "verifyText failed");
		}

		// 3. Verify whether the Notes element present
		if (uiDriver.checkElementPresent("ViewAndEditAccSumm.eltNotes")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 4. Verify whether the Financials element present
		if (uiDriver.checkElementPresent("ViewAndEditAccSumm.eltFinancials")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

	}

	public void EditAccSummAndCloseAcc(DataRow input, DataRow output) {

		// 1. Click on Edit button
		uiDriver.click("EditAccSummAndCloseAcc.eltDetails");
		SleepUtils.sleep(3);
		uiDriver.click("EditAccSummAndCloseAcc.btnEdit");

		// 2. Click on Parent_Account image
		uiDriver.click("EditAccSummAndCloseAcc.imgParent_Account");

		// 3. Type $data in Account field
		SleepUtils.sleep(2);
		uiDriver.setValue("EditAccSummAndCloseAcc.txtPoPAccount", input.get("Type@Account2"));

		// 4. Click on Search button
		uiDriver.click("EditAccSummAndCloseAcc.btnPopSearch");

		// 5. Click on Select button
		uiDriver.click("EditAccSummAndCloseAcc.btnSelect");

		uiDriver.click("EditAccSummAndCloseAcc.btnVIPAccount");
		
		// 6. Click on Update button
		uiDriver.click("EditAccSummAndCloseAcc.btnUpdate");
		SleepUtils.sleep(2);
		uiDriver.sendKey("enter");
	
		
	}

	/**
	 * Overriding toString() method of object class to print MaintainAccntSumryInf
	 * format string
	 **/
	public String toString() {
		return "MaintainAccntSumryInfDriver";
	}
}
