/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 12/26/2017 5:51:54 AM
Module part of 'Guidewire_BillingCenter'
Module created using Cafenext Selenium Builder
******************************************************************************/
package ModuleDrivers;
import static cbf.engine.TestResultLogger.*;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;

import cbf.engine.TestResult.ResultType;
import cbf.harness.ParameterAccess;
import cbf.utils.DataRow;
import cbf.utils.SleepUtils;
import cbf.utils.SleepUtils.TimeSlab;
import cbfx.selenium.BaseWebModuleDriver;
import sun.util.calendar.BaseCalendar.Date;

/**
Extends BaseModuleDriver class and performs application specific operations
*/
public class Commission_Adjustment_PHLY_SpecificDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public Commission_Adjustment_PHLY_SpecificDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void TC02_03_Create_Commi_Adjustment(DataRow input, DataRow output) {
		
		
		//1. Click on Actions WebElement
		SleepUtils.sleep(8);
		uiDriver.click("VerifyField_ProdLevel.eltActions");

		//2. Click on Commission Adjustment WebElement
		uiDriver.click("TC01_NEPCommissionAdjustment.eltCommission_Adjustment");
		SleepUtils.sleep(4);

		//3. Type $data In Amount
		uiDriver.setValue("TC01_NEPCommissionAdjustment.txtAmount", input.get("Type@Amount"));
		SleepUtils.sleep(4);
		
		//4. Verify the list value
		uiDriver.click("TC01_NEPCommissionAdjustment.txtAdjustment_Reason");
		SleepUtils.sleep(4);
		uiDriver.checkDropDownOptions("li", input.get("Verify@AdjustmentReason"));
		SleepUtils.sleep(4);
		uiDriver.setValue("TC01_NEPCommissionAdjustment.txtAdjustment_Reason", input.get("Select@AdjustmentReason"));
		SleepUtils.sleep(2);
		uiDriver.sendKey("enter");
		SleepUtils.sleep(4);
			
		//5. Click on Select link
		uiDriver.click("TC01_NEPCommissionAdjustment.btnNext");
		SleepUtils.sleep(4);
				
		//6. Click on Select link
		uiDriver.click("TC02_03_Create_Commi_Adjustment.tblSelectlink");
		SleepUtils.sleep(4);
		
		//7. Click on Select link
		uiDriver.click("TC02_03_Create_Commi_Adjustment.btnFinish");
		SleepUtils.sleep(4);
			
		//8. Click on History webElemnt
		uiDriver.click("ProducerContacts_Record_Hist.eltHistory");
		SleepUtils.sleep(4);
		
		//9. select filter type
		uiDriver.click("Change_Charge_Commissions.lstFilter_by_Type");
		SleepUtils.sleep(4);
		uiDriver.setValue("Change_Charge_Commissions.lstFilter_by_Type", input.get("Select@FilterType"));
		SleepUtils.sleep(2);
		uiDriver.sendKey("enter");
		SleepUtils.sleep(4);
		
		//10.verify the table description value
		String amnt="$"+input.get("Type@Amount")+".00";
		String SearchString="Commission Adjustment created for"+amnt;
		uiDriver.th.verfiygetCellDataOfColumn("Verfiy_Producer_History.eltDescription", SearchString, 1);
		SleepUtils.sleep(4);
	}
	

	/**
	*Overriding toString() method of object class to print TC02_03_04_ChkStubDet_FundTra
	*format string
	**/
	public String toString(){
		return "Commission_Adjustment_PHLY_SpecificDriver";
	}
}
