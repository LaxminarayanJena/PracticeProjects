/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 12/12/2017 5:18:21 AM
Module part of 'Guidewire_BillingCenter'
Module created using Cafenext Selenium Builder
******************************************************************************/
package ModuleDrivers;

import static cbf.engine.TestResultLogger.*;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cbf.engine.TestResult.ResultType;
import cbf.harness.ParameterAccess;
import cbf.utils.DataRow;
import cbf.utils.SleepUtils;
import cbf.utils.SleepUtils.TimeSlab;
import cbfx.selenium.BaseWebModuleDriver;
import javafx.scene.input.DataFormat;
import java.util.Date;

/**
 * Extends BaseModuleDriver class and performs application specific operations
 */
public class US1110_ManageInvoiceDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;

	public US1110_ManageInvoiceDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}

	public void AbleTocreateAndviewThenewInvcs(DataRow input, DataRow output) {
		// 1. Click on Invoices WebElement
		uiDriver.click("AbleTocreateAndviewThenewInvcs.eltInvoices");

		// 2. Select $data from the Invoice_Stream list
		uiDriver.setValue("AbleTocreateAndviewThenewInvcs.lstInvoice_Stream", input.get("Select@Invoice_Stream"));

		// 3. Click on Create_New_Invoice button
		uiDriver.click("AbleTocreateAndviewThenewInvcs.btnCreate_New_Invoice");
		SleepUtils.sleep(2);
		uiDriver.click("AbleTocreateAndviewThenewInvcs.btnCreate_New_Invoice");

		// 4. Type $data in Bill_Date field
		SleepUtils.sleep(3);
		uiDriver.sendKey("tab");
		SleepUtils.sleep(3);

		// 5. Click on Update button
		SleepUtils.sleep(3);
		uiDriver.click("AbleTocreateAndviewThenewInvcs.btnUpdate");

		// 6. Click on History WebElement
		uiDriver.click("AbleTocreateAndviewThenewInvcs.eltHistory");

		// 7. Click on Date WebElement
		SleepUtils.sleep(3);
		uiDriver.setValue("AbleTocreateAndviewThenewInvcs.lstFilterbydate", input.get("Select@Filter_by_Date"));
		uiDriver.sendKey("tab");
		SleepUtils.sleep(3);
		uiDriver.click("AbleTocreateAndviewThenewInvcs.eltDate");
		SleepUtils.sleep(4);

		// 8. Click on Invoices WebElement
		uiDriver.click("AbleTocreateAndviewThenewInvcs.eltInvoices");
		SleepUtils.sleep(3);
		uiDriver.click("AbleTocreateAndviewThenewInvcs.eltInvoices");

		// 9.Select check box correspending text 
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		String Search = dateFormat.format(date);
		String sText = dateFormat.format(date);
		System.out.println("search is"+Search);
		uiDriver.th.findRelativeCellAndClickSelectedCell("AbleTocreateAndviewThenewInvcs.tblId", Search, 3, sText, "");
		SleepUtils.sleep(5);

		// 10.click on invoices button
		uiDriver.click("AbleTocreateAndviewThenewInvcs.btnDeleteInvoices");
		SleepUtils.sleep(6);

		// 11.click on popup ok button
		uiDriver.click("AbleTocreateAndviewThenewInvcs.btnPopup");
		SleepUtils.sleep(3);
	}

	public void AbleToChangInvDtsForPlanInvo(DataRow input, DataRow output) {
		
		// 1. Click on Invoice WebElement
		uiDriver.click("AbleToChangInvDtsForPlanInvo.eltInvoice");
		SleepUtils.sleep(2);

		// 2. Select $data from the Invoice_Stream list
		uiDriver.setValue("AbleToChangInvDtsForPlanInvo.lstInvoice_Stream", input.get("Select@Invoice_Stream"));
		SleepUtils.sleep(4);

		// 3. Click on Create_New_Invoice button
		uiDriver.click("AbleToChangInvDtsForPlanInvo.btnCreate_New_Invoice");
		SleepUtils.sleep(2);
		uiDriver.click("AbleToChangInvDtsForPlanInvo.btnCreate_New_Invoice");

		// 4. Click on Update button
		SleepUtils.sleep(3);
		uiDriver.click("AbleToChangInvDtsForPlanInvo.btnUpdate");
		SleepUtils.sleep(2);
		uiDriver.sendKey("enter");
		SleepUtils.sleep(2);

		// 5. Click on CheckBox WebElement
		uiDriver.click("AbleToChangInvDtsForPlanInvo.eltPlanned");

		// 6. Click on Change_Invoice_Dates button
		SleepUtils.sleep(2);
		uiDriver.click("AbleToChangInvDtsForPlanInvo.btnChange_Invoice_Dates");
		SleepUtils.sleep(2);

		// 7. Type $data in Statment_Date field
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date(); 
		uiDriver.setValue("AbleToChangInvDtsForPlanInvo.txtStatment_Date", dateFormat.format(date));

		// 8. Click on Update button
		uiDriver.click("AbleToChangInvDtsForPlanInvo.btnUpdate_Invoice");
		SleepUtils.sleep(5);
		uiDriver.sendKey("enter");
		
		// 9. Click on History WebElement and filter
		uiDriver.click("AbleToChangInvDtsForPlanInvo.eltHistory");
		uiDriver.doubleclick("AbleToChangInvDtsForPlanInvo.lstfilter");
		uiDriver.setValue("AbleToChangInvDtsForPlanInvo.txtfilter", input.get("VerifyText@Event_Type"));
		uiDriver.sendKey("enter");

		// 10. Click on Date WebElement
		uiDriver.click("AbleToChangInvDtsForPlanInvo.eltDate");

		// 11. Verify the text ?$data in the Event_Type field
		SleepUtils.sleep(3);
		String actualEventType = uiDriver.getControl("AbleToChangInvDtsForPlanInvo.eltEvent_Type").getText();
		String expectedEventType = input.get("VerifyText@Event_Type");

		if (actualEventType.equalsIgnoreCase(expectedEventType)) {
			passed("verifyText", "verifyText should pass", "verifyText passed");
		} else {
			failed("verifyText", "verifyText should pass", "verifyText failed");
		}
	}

	/**
	 * Overriding toString() method of object class to print ManageInvoice format
	 * string
	 **/
	public String toString() {
		return "ManageInvoiceDriver";
	}
}
