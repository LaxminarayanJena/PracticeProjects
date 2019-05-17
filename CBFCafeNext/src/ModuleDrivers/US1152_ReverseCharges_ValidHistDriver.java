/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 12/26/2017 3:06:18 AM
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
public class US1152_ReverseCharges_ValidHistDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public US1152_ReverseCharges_ValidHistDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void US1152ReverseCharges_ValidHist(DataRow input, DataRow output) {
		//1. Click on Account WebElement
		uiDriver.click("US1152ReverseCharges_ValidHist.eltAccount");
		
		//2. Type $data in Account field
		uiDriver.setValue("US1152ReverseCharges_ValidHist.txtAccount", input.get("Type@Account"));
		
		//3. Type $data in First_Name field
		//uiDriver.setValue("US1152ReverseCharges_ValidHist.txtFirst_Name", input.get("Type@First_Name"));
		
		//4. Click on Search button
		uiDriver.click("US1152ReverseCharges_ValidHist.btnSearch");
	
		//5. Click on Account Link
		uiDriver.click("US1152ReverseCharges_ValidHist.lnkAccount");
		SleepUtils.sleep(3);
		
		//6. Click on Charges WebElement
		uiDriver.click("US1152ReverseCharges_ValidHist.eltCharges");
		SleepUtils.sleep(5);
		
		//7. Click on History WebElement
		uiDriver.click("US1152ReverseCharges_ValidHist.eltHistory");
		SleepUtils.sleep(3);
		
		//8. Select $data from the Filter_by_Type list
		uiDriver.setValue("US1152ReverseCharges_ValidHist.lstFilter_by_Type", input.get("Select@Filter_by_Type"));
		SleepUtils.sleep(5);
		
		//9. Click on policies WebElement
		uiDriver.click("US1152ReverseCharges_ValidHist.eltpolicies");
		//uiDriver.click("US1152ReverseCharges_ValidHist.eltpolicies");
		SleepUtils.sleep(3);
		
		//10. Click on Policy Link
		uiDriver.click("US1152ReverseCharges_ValidHist.lnkPolicy");
		SleepUtils.sleep(3);
		
		//11. Click on Charges_1 WebElement
		uiDriver.click("US1152ReverseCharges_ValidHist.eltCharges_1");
		SleepUtils.sleep(5);
		
		//12. Click on History_1 WebElement
		uiDriver.click("US1152ReverseCharges_ValidHist.eltHistory_1");
		SleepUtils.sleep(5);
	}
	

	/**
	*Overriding toString() method of object class to print US1152ReverseCharges_ValidHist
	*format string
	**/
	public String toString(){
		return "US1152ReverseCharges_ValidHistDriver";
	}
}
