/******************************************************************************
Created by : AT1
Created\Updated on : 12/4/2017 4:00:37 AM
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
public class US1091_ViewChargesAccntAndPoliDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public US1091_ViewChargesAccntAndPoliDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void US1091_ViewChargesAccntAndPoli(DataRow input, DataRow output) {
		//1. Click on Account WebElement
		uiDriver.click("US1091_ViewChargesAccntAndPoli.eltAccount");
		
		//2. Type $data in Account field
		uiDriver.setValue("US1091_ViewChargesAccntAndPoli.txtAccount", input.get("Type@Account"));
		
		//3. Click on Search button
		uiDriver.click("US1091_ViewChargesAccntAndPoli.btnSearch");
		
		//4. Click on Account Link
		uiDriver.click("US1091_ViewChargesAccntAndPoli.lnkAccount");
		
		//5. Click on Charges WebElement
		uiDriver.click("US1091_ViewChargesAccntAndPoli.eltCharges");
		
		//6. Verify AccountDetailCharges
		uiDriver.Verify("US1091_ViewChargesAccntAndPoli.tblAccountDetailCharges");
		
		//7. Verify Statment_date_field
		uiDriver.Verify("US1091_ViewChargesAccntAndPoli.eltStatment_date_field");
		
		//8. Click on Policies WebElement
		uiDriver.click("US1091_ViewChargesAccntAndPoli.eltPolicies");
		
		//9. Click on Policy Link
		uiDriver.click("US1091_ViewChargesAccntAndPoli.lnkPolicy");
		
		//10. Click on Charges WebElement
		uiDriver.click("US1091_ViewChargesAccntAndPoli.eltCharges");
		
		//11. Verify PolicyDetailCharges
		uiDriver.Verify("US1091_ViewChargesAccntAndPoli.tblPolicyDetailCharges");
		
		//12. Verify Statment_date
		uiDriver.Verify("US1091_ViewChargesAccntAndPoli.eltStatment_date");
		
	}
	

	/**
	*Overriding toString() method of object class to print US1091_ViewChargesAccntAndPoli
	*format string
	**/
	public String toString(){
		return "US1091_ViewChargesAccntAndPoliDriver";
	}
}
