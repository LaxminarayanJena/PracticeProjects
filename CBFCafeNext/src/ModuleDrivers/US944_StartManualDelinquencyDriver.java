/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 4/20/2018 2:36:13 AM
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
public class US944_StartManualDelinquencyDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public US944_StartManualDelinquencyDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void TC01_StartManualDelinquency(DataRow input, DataRow output) {
		//1. Click on Start_Delinquency button
		uiDriver.click("TC01_StartManualDelinquency.btnStart_Delinquency");
		SleepUtils.sleep(4);
		
		//2. Verify whether the Reason field is present
		if (uiDriver.checkElementPresent("TC01_StartManualDelinquency.txtReason")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(4);
		
		//3. Click Reason
		uiDriver.click("TC01_StartManualDelinquency.txtReason");
		SleepUtils.sleep(4);
		
		//4. Verify whether the none element present
		if (uiDriver.checkElementPresent("TC01_StartManualDelinquency.eltNone")) {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(4);
		
		//5. Verify whether the Not_Taken element present
		if (uiDriver.checkElementPresent("TC01_StartManualDelinquency.eltNot_Taken")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(4);
		
		//6. Click on Return_to_Account_Summary Link
		uiDriver.click("TC01_StartManualDelinquency.lnkReturn_to_Account_Summary");
		SleepUtils.sleep(4);
		
		//7. Click on Ok button
		uiDriver.click("TC01_StartManualDelinquency.btnOk");
		SleepUtils.sleep(4);
		
		//7. Click on Ok button
		uiDriver.click("TC01_StartManualDelinquency.lnkPolicy");
		SleepUtils.sleep(4);
		
		//8. Click on Start_Delinquency button
		uiDriver.click("TC01_StartManualDelinquency.btnStart_Delinquency_1");
		SleepUtils.sleep(4);
		
		//9. Verify whether the Reason field is present
		if (uiDriver.checkElementPresent("TC01_StartManualDelinquency.txtReason_1")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(4);
		
		//10. Click Reason
		uiDriver.click("TC01_StartManualDelinquency.txtReason");
		SleepUtils.sleep(4);
		
		//11. Verify whether the none element present
		if (uiDriver.checkElementPresent("TC01_StartManualDelinquency.eltNone_1")) {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(4);
		
		//12. Verify whether the Not_Taken element present
		if (uiDriver.checkElementPresent("TC01_StartManualDelinquency.eltNot_Taken_1")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(4);
		
		//13. Click on Return_to_Account_Summary Link
		uiDriver.click("TC01_StartManualDelinquency. lnkReturn to Policy Summary");
		SleepUtils.sleep(4);
		
		//14. Click on Ok button
	    uiDriver.click("TC01_StartManualDelinquency.btnOk_1");
	    SleepUtils.sleep(3);
	    
		//15. Click on Return_to_Account_Summary Link
		uiDriver.click("TC01_StartManualDelinquency.lnkAccount");
		SleepUtils.sleep(4);
		
	}
	
	public void TC05_StartManualDelinquency(DataRow input, DataRow output) {
		//1. Click on Summary WebElement
		uiDriver.click("TC05_StartManualDelinquency.eltSummary");
		SleepUtils.sleep(4);
		
		//2. Click on Start_Delinquency button
		uiDriver.click("TC05_StartManualDelinquency.btnStart_Delinquency");
		SleepUtils.sleep(4);
		uiDriver.th.findRelativeCellAndClickfirstCell("TC05_StartManualDelinquency.tbldelinquency", "Active", 2, "Active");
		SleepUtils.sleep(4);
		
		//3. Click on Execute button
		uiDriver.click("TC05_StartManualDelinquency.btnExecute");
		SleepUtils.sleep(4);
		
		//4. Click on Ok button
		uiDriver.click("TC05_StartManualDelinquency.btnOk");
		SleepUtils.sleep(4);
		
	}

	
	public void TC08_TC09_StartManualDelinqunc(DataRow input, DataRow output) {	
		
		//1. Click on Delinquencies WebElement
		uiDriver.click("TC08_TC09_StartManualDelinqunc.eltDelinquencies");
		SleepUtils.sleep(4);
		
		//2.click on the CheckBox
		uiDriver.th.findRelativeCellAndClickfirstCell("TC08_TC09_StartManualDelinqunc.tblStopdelinquency", "Open", 1, "Open");
		SleepUtils.sleep(4);
		
		//3. Click on Stop_Delinquency button
		uiDriver.click("TC08_TC09_StartManualDelinqunc.btnStop_Delinquency");
		SleepUtils.sleep(4);
		
		//4. Click Reason
		uiDriver.click("TC08_TC09_StartManualDelinqunc.txtReason");
		SleepUtils.sleep(4);
		
		//5. Select $data from the Reason list
		uiDriver.setValue("TC08_TC09_StartManualDelinqunc.lstReason", input.get("Select@Reason"));
		SleepUtils.sleep(4);
		
		//6. Click on Execute button
		uiDriver.click("TC08_TC09_StartManualDelinqunc.btnExecute");
		SleepUtils.sleep(4);
		
		//7.Click on the Web Element Policies
		uiDriver.click("TC08_TC09_StartManualDelinqunc.eltPolicies");
	
		//8. Click on Policy Link
		uiDriver.click("TC08_TC09_StartManualDelinqunc.lnkPolicy");
		SleepUtils.sleep(4);
		
		//9. Click on Details WebElement
		uiDriver.click("TC08_TC09_StartManualDelinqunc.eltDetails");
		SleepUtils.sleep(4);
		
		//10. Verify whether the Written_Premium element present
		if (uiDriver.checkElementPresent("TC08_TC09_StartManualDelinqunc.eltWritten_Premium")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(4);
		
		//11. Click on Delinquency_Plan Link
		uiDriver.click("TC08_TC09_StartManualDelinqunc.lnkDelinquency_Plan");
		SleepUtils.sleep(4);
		
		//12. Verify whether the Enter_Delinquency_Threshold_Policy element present
		if (uiDriver.checkElementPresent("TC08_TC09_StartManualDelinqunc.eltEnter_Delinquency_Threshold_Policy")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(4);
		
		//13. Verify whether the Enter_Delinquency_Threshold_Account_ element present
		if (uiDriver.checkElementPresent("TC08_TC09_StartManualDelinqunc.eltEnter_Delinquency_Threshold_Account_")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(4);
		
		//14. Click on Return_to_Policy_Details Link
		uiDriver.click("TC08_TC09_StartManualDelinqunc.lnkReturn_to_Policy_Details");
		SleepUtils.sleep(4);
	}
	
	/**
	*Overriding toString() method of object class to print US944_StartManualDelinquency
	*format string
	**/
	public String toString(){
		return "US944_StartManualDelinquencyDriver";
	}
}
