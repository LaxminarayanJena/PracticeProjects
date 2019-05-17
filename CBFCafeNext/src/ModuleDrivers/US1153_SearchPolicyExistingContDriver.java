/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 12/21/2017 9:15:41 AM
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
public class US1153_SearchPolicyExistingContDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public US1153_SearchPolicyExistingContDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void US1153SearchPolicyExistingCont(DataRow input, DataRow output) {
		//1. Click on Policy WebElement
		uiDriver.click("US1153SearchPolicyExistingCont.eltPolicy");
		
		//2. Click on Search button
		uiDriver.click("US1153SearchPolicyExistingCont.btnSearch");
		
		//3. Type $data in First_Name field
		uiDriver.setValue("US1153SearchPolicyExistingCont.txtFirst_Name", input.get("Type@First_Name"));
		
		//4. Type $data in Last_Name field
		uiDriver.setValue("US1153SearchPolicyExistingCont.txtLast_Name", input.get("Type@Last_Name"));
		
		//5. Select $data from the Country list
		uiDriver.setValue("US1153SearchPolicyExistingCont.lstCountry", input.get("Select@Country"));
		SleepUtils.sleep(3);
		
		//6. Type $data in City field
		uiDriver.setValue("US1153SearchPolicyExistingCont.txtCity", input.get("Type@City"));
		SleepUtils.sleep(3);
		
		//7. Select $data from the State list
		uiDriver.setValue("US1153SearchPolicyExistingCont.lstState", input.get("Select@State"));
		SleepUtils.sleep(3);
		
		//8. Type $data in ZIP_Code field
		SleepUtils.sleep(3);
		uiDriver.setValue("US1153SearchPolicyExistingCont.txtZIP_Code", input.get("Type@ZIP_Code"));
		
		//9. Click on Search_1 button
		uiDriver.click("US1153SearchPolicyExistingCont.btnSearch_1");
		
	}
	

	/**
	*Overriding toString() method of object class to print US1153SearchPolicyExistingCont
	*format string
	**/
	public String toString(){
		return "US1153SearchPolicyExistingContDriver";
	}
}
