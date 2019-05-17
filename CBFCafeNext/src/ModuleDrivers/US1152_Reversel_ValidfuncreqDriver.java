/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 12/26/2017 5:01:11 AM
Module part of 'Guidewire_BillingCenter'
Module created using Cafenext Selenium Builder
******************************************************************************/
package ModuleDrivers;
import static cbf.engine.TestResultLogger.*;
import java.io.IOException;
import cbf.engine.TestResult.ResultType;
import cbf.harness.ParameterAccess;
import cbf.utils.DataRow;
import cbf.utils.SleepUtils;
import cbf.utils.SleepUtils.TimeSlab;
import cbfx.selenium.BaseWebModuleDriver;

/**
Extends BaseModuleDriver class and performs application specific operations
*/
public class US1152_Reversel_ValidfuncreqDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public US1152_Reversel_ValidfuncreqDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void US1152Reversel_Validfuncreq(DataRow input, DataRow output) {
		SleepUtils.sleep(8);
		//1. Click on Actions button
		uiDriver.click("US1152Reversel_Validfuncreq.btnActions");
		
		//2. Click on New_Transaction WebElement
		uiDriver.click("US1152Reversel_Validfuncreq.eltNew_Transaction");
		SleepUtils.sleep(3);
		
		//3. Click on Charge_Reversal WebElement
		uiDriver.click("US1152Reversel_Validfuncreq.eltCharge_Reversal");
		SleepUtils.sleep(3);
		
		//4. Click on Search button
		uiDriver.click("US1152Reversel_Validfuncreq.btnSearch");
		SleepUtils.sleep(5);
		
		//5. Click on Account WebElement
		uiDriver.click("US1152Reversel_Validfuncreq.eltAccount");
		SleepUtils.sleep(3);
		
		//6. Type $data in Account_Name field
		uiDriver.setValue("US1152Reversel_Validfuncreq.txtAccount_Name", input.get("Type@Account_Name"));
		SleepUtils.sleep(3);
		
		//7. Click on Search_1 button
		uiDriver.click("US1152Reversel_Validfuncreq.btnSearch_1");
		SleepUtils.sleep(6);
		
		//8. Click on Account Link
		uiDriver.click("US1152Reversel_Validfuncreq.eltAccount");
		SleepUtils.sleep(3);
		uiDriver.click("US1152Reversel_Validfuncreq.eltAccount");
		SleepUtils.sleep(8);
		uiDriver.click("US1152Reversel_Validfuncreq.lnkAccount");
		SleepUtils.sleep(3);
		
		//9. Click on History WebElement
		uiDriver.click("US1152Reversel_Validfuncreq.eltHistory");
		SleepUtils.sleep(3);
		
		//10. Select $data from the Filter_by_Date list
		uiDriver.click("US1152Reversel_Validfuncreq.lstFilter_by_Date");
		SleepUtils.sleep(2);
		uiDriver.setValue("US1152Reversel_Validfuncreq.lstFilter_by_Date", input.get("Select@Filter_by_Date"));
		SleepUtils.sleep(5);
		
		//11. Select $data from the Filter_by_Type list
		uiDriver.click("US1152Reversel_Validfuncreq.lstFilter_by_Type");
		SleepUtils.sleep(2);
		uiDriver.setValue("US1152Reversel_Validfuncreq.lstFilter_by_Type", input.get("Select@Filter_by_Type"));
		uiDriver.sendKey("ENTER");
		SleepUtils.sleep(5);
		
		//12. Click on Actions_1 button
		uiDriver.click("US1152Reversel_Validfuncreq.btnActions_1");
		SleepUtils.sleep(5);
		
		//13. Click on New_Transaction_1 WebElement
		uiDriver.click("US1152Reversel_Validfuncreq.eltNew_Transaction_1");
		SleepUtils.sleep(3);
		
		//14. Click on Charge_Reversal_1 WebElement
		uiDriver.click("US1152Reversel_Validfuncreq.eltCharge_Reversal_1");
		SleepUtils.sleep(3);
		
		//15. Select $data from the Type list	
		uiDriver.click("US1152Reversel_Validfuncreq.lstType");
		SleepUtils.sleep(2);
		uiDriver.setValue("US1152Reversel_Validfuncreq.lstType", input.get("Select@Type"));
		SleepUtils.sleep(5);
		
		//16. Click on Search_2 button
		uiDriver.click("US1152Reversel_Validfuncreq.btnSearch_2");
		SleepUtils.sleep(3);
		
		//17. Click on Select button
		uiDriver.click("US1152Reversel_Validfuncreq.btnSelect");
		SleepUtils.sleep(3);
		
		//18. Select $data from the Reversal_Reason list
		uiDriver.click("US1152Reversel_Validfuncreq.lstReversal_Reason");
		SleepUtils.sleep(2);
		uiDriver.setValue("US1152Reversel_Validfuncreq.lstReversal_Reason", input.get("Select@Reversal_Reason"));
		SleepUtils.sleep(2);
		
		//19. Click on Finish button
		uiDriver.click("US1152Reversel_Validfuncreq.btnFinish");
		SleepUtils.sleep(3);
		
		//20. Click on Transactions WebElement
		uiDriver.click("US1152Reversel_Validfuncreq.eltTransactions");
		SleepUtils.sleep(3);	
		
		//21. Click on charges WebElement
		uiDriver.click("US1152Reversel_Validfuncreq.eltcharges");
		SleepUtils.sleep(3);
		
		//22. Click on History_1 WebElement
		uiDriver.click("US1152Reversel_Validfuncreq.eltHistory_1");
		SleepUtils.sleep(3);
		
		//23. Select $data from the Filter_by_Date list
		uiDriver.click("US1152Reversel_Validfuncreq.lstFilter_by_Date_1");
		SleepUtils.sleep(2);
		uiDriver.setValue("US1152Reversel_Validfuncreq.lstFilter_by_Date_1", input.get("Select@Filter_by_Date_1"));
		SleepUtils.sleep(3);
		
		//24. Select $data from the Filter_by_Type list
		uiDriver.click("US1152Reversel_Validfuncreq.lstFilter_by_Type_1");
		SleepUtils.sleep(2);
		uiDriver.setValue("US1152Reversel_Validfuncreq.lstFilter_by_Type_1", input.get("Select@Filter_by_Type_1"));
		SleepUtils.sleep(3);
	}
	

	/**
	*Overriding toString() method of object class to print US1152Reversel_Validfuncreq
	*format string
	**/
	public String toString(){
		return "US1152Reversel_ValidfuncreqDriver";
	}
}
