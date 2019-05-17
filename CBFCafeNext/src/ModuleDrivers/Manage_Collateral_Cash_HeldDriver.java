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
public class Manage_Collateral_Cash_HeldDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public Manage_Collateral_Cash_HeldDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void TC_02345_Draw_Disbu_Coll_Cash(DataRow input, DataRow output) {
		
		//1. Click on Collateral WebElement
		SleepUtils.sleep(8);
		uiDriver.click("TC_020304_Close_Newly_Add_Fieds.eltCollateral");
			
		//2. Verify whether the cash held element is present
		if (uiDriver.checkElementPresent("TC_02345_Draw_Disbu_Coll_Cash.eleCashHeld")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		
		//3. Click on Cash Held Element
		uiDriver.click("TC_02345_Draw_Disbu_Coll_Cash.eleCashHeld");
		SleepUtils.sleep(4);
		
		//4. Verify whether the Draw down button is present
		if (uiDriver.checkElementPresent("TC_02345_Draw_Disbu_Coll_Cash.btnDrawdown")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		
		//5. Click on Draw down element
		uiDriver.click("TC_02345_Draw_Disbu_Coll_Cash.btnDrawdown");
		SleepUtils.sleep(4);
		
		//6. Type $data In Amount
		String AmnCashheld=uiDriver.getControl("TC_02345_Draw_Disbu_Coll_Cash.eltCashHeld").getText();
		SleepUtils.sleep(4);
		uiDriver.setValue("TC_02345_Draw_Disbu_Coll_Cash.txtAmount", input.get("Type@Amount"));
		SleepUtils.sleep(4);
		uiDriver.sendKey("tab");
		SleepUtils.sleep(4);
		
		//7. Click on Next Button
		uiDriver.click("TC_02345_Draw_Disbu_Coll_Cash.btNext");
		SleepUtils.sleep(4);
		
		//8. Click on Finish Button
		uiDriver.click("TC_02345_Draw_Disbu_Coll_Cash.btnFinish");
		SleepUtils.sleep(4);
		
		//9.Verify the cash held presented
		String Amnt="$"+input.get("Type@Amount")+".00";
		uiDriver.th.verfiygetCellDataOfColumn("TC02_Transfer_Funds_Collateral.tblCashHeld", Amnt, 2);
		SleepUtils.sleep(4);
		
		//10. Click on History Button
		uiDriver.click("Accounts_View_History.eltHistory");
		SleepUtils.sleep(4);
			
		//11. Click on History Button
		uiDriver.click("Verfiy_Producer_History.eltDate");
		SleepUtils.sleep(4);
		
		//12.Verify in history event
		String collateralhistory="Collateral was drawn down from"+AmnCashheld;
		SleepUtils.sleep(2);
		uiDriver.th.verfiygetCellDataOfColumn("Verify_Acc_Poli_History.tblDescription", collateralhistory, 1);
		SleepUtils.sleep(4);
			
		//13. Click on Collateral WebElement
		uiDriver.click("TC_020304_Close_Newly_Add_Fieds.eltCollateral");
			
		//14. Click on Cash Held Element
		uiDriver.click("TC_02345_Draw_Disbu_Coll_Cash.eleCashHeld");
		SleepUtils.sleep(4);
		
		//15. Verify whether the Disbursement button is present
		if (uiDriver.checkElementPresent("TC_02345_Draw_Disbu_Coll_Cash.btnDisbursement")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
				
		//16. Click on Cash Held Element
		uiDriver.click("TC_02345_Draw_Disbu_Coll_Cash.btnDisbursement");
		SleepUtils.sleep(4);
		
		//17. Type $data In Amount
		uiDriver.setValue("TC_02345_Draw_Disbu_Coll_Cash.txtDisAmount", input.get("Type@Amount"));
		SleepUtils.sleep(4);
		
		//18. Click on Cash Held Element
		String sDate=uiDriver.getControl("TC_02345_Draw_Disbu_Coll_Cash.eltAppDate").getText();
		SleepUtils.sleep(4);
		String appDate=uiDriver.StringToShortdate("MMM dd, yyyy", "MM/dd/yyyy", sDate);
		SleepUtils.sleep(2);
		uiDriver.setValue("TC_02345_Draw_Disbu_Coll_Cash.eltDatePicker", appDate);
		SleepUtils.sleep(4);
		
		//19. select Reason for Disbursement value
		uiDriver.click("TC_02345_Draw_Disbu_Coll_Cash.lstReasonforDisbursment");
		SleepUtils.sleep(4);
		uiDriver.setValue("TC_02345_Draw_Disbu_Coll_Cash.lstReasonforDisbursment", input.get("Selct@ReasonForDisbursment"));
		uiDriver.sendKey("tab");
		SleepUtils.sleep(4);

		//20. Type $data In Requirement
		uiDriver.setValue("TC_02345_Draw_Disbu_Coll_Cash.txtInternalCommet", input.get("Type@InternalComment"));
		SleepUtils.sleep(4);
			
		//21.Click on next button
		uiDriver.click("TC_02345_Draw_Disbu_Coll_Cash.btnDisNext");
		SleepUtils.sleep(5);
		if (uiDriver.checkElementPresent("TC_02345_Draw_Disbu_Coll_Cash.eltErrmsg")) {
			uiDriver.click("TC_02345_Draw_Disbu_Coll_Cash.lstReasonforDisbursment");
			SleepUtils.sleep(4);
			uiDriver.setValue("TC_02345_Draw_Disbu_Coll_Cash.lstReasonforDisbursment", input.get("Selct@ReasonForDisbursment"));
			SleepUtils.sleep(2);
			uiDriver.sendKey("tab");
			SleepUtils.sleep(4);
			uiDriver.click("TC_02345_Draw_Disbu_Coll_Cash.btnDisNext");
			SleepUtils.sleep(4);
			if (uiDriver.checkElementPresent("TC_02345_Draw_Disbu_Coll_Cash.eltErrmsg")) {
				uiDriver.click("TC_02345_Draw_Disbu_Coll_Cash.lstReasonforDisbursment");
				SleepUtils.sleep(4);
				uiDriver.setValue("TC_02345_Draw_Disbu_Coll_Cash.lstReasonforDisbursment", input.get("Selct@ReasonForDisbursment"));
				SleepUtils.sleep(2);
				uiDriver.sendKey("tab");
				SleepUtils.sleep(4);
				uiDriver.click("TC_02345_Draw_Disbu_Coll_Cash.btnDisNext");
				SleepUtils.sleep(4);
			}
		}
		SleepUtils.sleep(5);
		
		//22.Click on next button
		uiDriver.click("TC_02345_Draw_Disbu_Coll_Cash.btnDisFinish");
		SleepUtils.sleep(5);
		
		//23. Click on History Button
		uiDriver.click("Accounts_View_History.eltHistory");
		SleepUtils.sleep(4);
			
		//24. Click on History Button
		uiDriver.click("Verfiy_Producer_History.eltDate");
		SleepUtils.sleep(4);
		
		//25.Verify in history event
		String collateralhistory1="Collateral was disbursed on"+appDate+".";
		SleepUtils.sleep(2);
		uiDriver.th.verfiygetCellDataOfColumn("Verify_Acc_Poli_History.tblDescription", collateralhistory1, 1);
		SleepUtils.sleep(4);	
	}
	
	/**
	*Overriding toString() method of object class to print TC_02345_Draw_Disbu_Coll_Cash
	*format string
	**/
	public String toString(){
		return "Manage_Collateral_Cash_HeldDriver";
	}
}
