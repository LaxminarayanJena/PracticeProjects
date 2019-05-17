/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 12/26/2017 5:51:54 AM
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
public class Transfer_Funds_To_CollateralDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public Transfer_Funds_To_CollateralDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void TC02_Transfer_Funds_Collateral(DataRow input, DataRow output) {
		
		//1. Click on Actions WebElement
		SleepUtils.sleep(4);
		uiDriver.click("MaintainNotes.eltActions");
		
		//2. Click on New_Transaction WebElement
		uiDriver.mouseOver("TC05_DirBillPmnt_NewDirtCredit.eltNew_Transaction");
		SleepUtils.sleep(4);
		
		//3. Click on Collateral Funds WebElement
		uiDriver.click("TC02_Transfer_Funds_Collateral.eltCollateralFunds");
		SleepUtils.sleep(4);
		
		//4. Type $data In AmountToTransfer
		uiDriver.setValue("TC02_Transfer_Funds_Collateral.txtAmountToTransfer", input.get("Type@Amount_To_Transfer"));
		SleepUtils.sleep(4);
		
		//5.Click on transfer button
		uiDriver.click("TC02_Transfer_Funds_Collateral.btnTransfer");
		SleepUtils.sleep(8);
		
		//6. Verify whether the Collateral element present
		if (uiDriver.checkElementPresent("TC02_Transfer_Funds_Collateral.eltCollateral")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(2);
		
		//7.Click on transfer button
		uiDriver.click("TC02_Transfer_Funds_Collateral.eltCashHeld");
		SleepUtils.sleep(8);
		
		//8.verify the 
		uiDriver.th.getCellDataOfCol("TC02_Transfer_Funds_Collateral.tblCashHeld", input.get("Type@Amount_To_Transfer"), 2);
		SleepUtils.sleep(2);
	}
	

	/**
	*Overriding toString() method of object class to print TC02_Transfer_Funds_Collateral
	*format string
	**/
	public String toString(){
		return "Transfer_Funds_To_Collateral";
	}
}