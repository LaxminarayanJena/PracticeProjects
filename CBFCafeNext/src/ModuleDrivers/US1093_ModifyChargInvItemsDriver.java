/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 12/15/2017 3:41:04 AM
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
public class US1093_ModifyChargInvItemsDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;

	public US1093_ModifyChargInvItemsDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}

	public void SRpermTomoveTheInvoiceitems(DataRow input, DataRow output) {

		// 1. Click on Charges WebElement
		uiDriver.click("SRpermTomoveTheInvoiceitems.eltCharges");

		// 2. Select check box correspending text
		//String Search = input.get("ColumnNum@Installment");
		//String sText = input.get("ColumnNum@Installment");
		//uiDriver.th.findRelativeCellAndClickSelectedCell("SRpermTomoveTheInvoiceitems.tblId","48108", 5, sText, "");
		//uiDriver.th.findRelativeCellAndClickSelectedCell("SRpermTomoveTheInvoiceitems.tblId", Search, 1, sText, "");
		uiDriver.th.findRelativeCellAndClickfirstCell("SRpermTomoveTheInvoiceitems.tblId", "48108", 5, "48108");
		SleepUtils.sleep(5);

		// 3. Click on Move_Invoice_Items button
		uiDriver.click("SRpermTomoveTheInvoiceitems.btnMove_Invoice_Items");
		SleepUtils.sleep(3);

		// 4.Select check box correspending text
		String Search1 = input.get("ColumnNum1@Installment");
		String sText1 = input.get("ColumnNum1@Installment");
		uiDriver.th.findRelativeCellAndClickSelectedCell("SRpermTomoveTheInvoiceitems.tblId1", Search1, 1, sText1,
				"Select");
		uiDriver.click("SRpermTomoveTheInvoiceitems.btnSelct");
		SleepUtils.sleep(3);

		// 5. Click on Cancel button
		uiDriver.click("SRpermTomoveTheInvoiceitems.btnCancel");

		// 6.Select check box correspending text
		//String Search3 = input.get("ColumnNum@Installment");
		uiDriver.th.findRelativeCellAndClickfirstCell("SRpermTomoveTheInvoiceitems.tblId", "48108", 5, "48108");
		SleepUtils.sleep(5);

		// 7. Click on Move_Invoice_Items button
		uiDriver.click("SRpermTomoveTheInvoiceitems.btnMove_Invoice_Items");
		SleepUtils.sleep(3);

		// 8.Select check box correspending text
		String Search4 = input.get("ColumnNum2@Installment");
		String sText4 = input.get("ColumnNum2@Installment");

		uiDriver.th.findRelativeCellAndClickSelectedCell("SRpermTomoveTheInvoiceitems.tblId1", Search4, 1, sText4,
				"Select");
		uiDriver.click("SRpermTomoveTheInvoiceitems.btnSelct1");
		SleepUtils.sleep(5);

		// 9. Click on Update button
		uiDriver.click("SRpermTomoveTheInvoiceitems.btnUpdate");

	}

	public void VerfyHistInvItemMovAnotInv(DataRow input, DataRow output) {
		// 1. Click on Charges WebElement
		uiDriver.click("VerfyHistInvItemMovAnotInv.eltCharges");

		// 2. Click on Statment_Date WebElement
		SleepUtils.sleep(5);
		// uiDriver.click("VerfyHistInvItemMovAnotInv.eltStatment_Date");

		// 3. Select the Check_Box ?checkbox
		uiDriver.click("VerfyHistInvItemMovAnotInv.chkCheck_Box");

		// 4. Click on Move_Invoice_Item button
		SleepUtils.sleep(5);
		uiDriver.click("VerfyHistInvItemMovAnotInv.btnMove_Invoice_Item");

		// 5. Click on Status WebElement
		uiDriver.click("VerfyHistInvItemMovAnotInv.eltStatus");
		SleepUtils.sleep(3);
		uiDriver.click("VerfyHistInvItemMovAnotInv.eltStatus");

		// 6. Click on Select button
		uiDriver.click("VerfyHistInvItemMovAnotInv.btnSelect");
		SleepUtils.sleep(5);

		// 7. Click on Update button
		uiDriver.click("VerfyHistInvItemMovAnotInv.btnUpdate");

		// 8. Click on Histroy WebElement
		SleepUtils.sleep(3);
		uiDriver.click("VerfyHistInvItemMovAnotInv.eltHistroy");

		// 9. Click on Date WebElement
		SleepUtils.sleep(3);
		uiDriver.click("VerfyHistInvItemMovAnotInv.eltDate");

	}

	/**
	 * Overriding toString() method of object class to print ModifyChargInvItems
	 * format string
	 **/
	public String toString() {
		return "ModifyChargInvItemsDriver";
	}
}
