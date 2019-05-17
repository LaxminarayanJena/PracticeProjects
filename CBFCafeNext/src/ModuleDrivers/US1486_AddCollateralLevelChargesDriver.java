/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 4/16/2018 9:03:52 AM
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
public class US1486_AddCollateralLevelChargesDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public US1486_AddCollateralLevelChargesDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void TC03_Verifynewlyaddedmodifyfld(DataRow input, DataRow output) {
		//1. Click on Collateral WebElement
		uiDriver.click("TC03_Verifynewlyaddedmodifyfld.eltCollateral");
		SleepUtils.sleep(3);
		
		//2. Click on Add button
		uiDriver.click("TC03_Verifynewlyaddedmodifyfld.btnAdd");
		SleepUtils.sleep(3);
		
		//3. Click Type
		uiDriver.click("TC03_Verifynewlyaddedmodifyfld.txtType");
		SleepUtils.sleep(3);
		
		//4. Verify whether the Cash element present
		if (uiDriver.checkElementPresent("TC03_Verifynewlyaddedmodifyfld.eltCash")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		//5. Verify whether the Level element present
		if (uiDriver.checkElementPresent("TC03_Verifynewlyaddedmodifyfld.eltLevel")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		//6. Verify whether the Segregated checkbox is present
		if (uiDriver.checkElementPresent("TC03_Verifynewlyaddedmodifyfld.chkSegregated")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		//7. Verify whether the Create_Collateral_Fulfillment_Charge_If_Needed_For_Compliance checkbox is present
		if (uiDriver.checkElementPresent("TC03_Verifynewlyaddedmodifyfld.chkCreate_Collateral_Fulfillment_Charge_If_Needed_For_Compliance")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		//8. Click on Cancel button
		uiDriver.click("TC03_Verifynewlyaddedmodifyfld.btnCancel");
		SleepUtils.sleep(3);
	}
	


	/**
	*Overriding toString() method of object class to print US1486_AddCollateralLevelCharges
	*format string
	**/
	public String toString(){
		return "US1486_AddCollateralLevelChargesDriver";
	}
}
