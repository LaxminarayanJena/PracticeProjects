/******************************************************************************
Created by : AT1
Created\Updated on : 12/12/2017 1:23:54 AM
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
Extends BaseModuleDriver class and performs application specific operations
*/
public class PolicyViewHistory_ValidateDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public PolicyViewHistory_ValidateDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void PolicyViewHistory_Validate(DataRow input, DataRow output) {
		//1. Click on Policy WebElement
		uiDriver.click("PolicyViewHistory_Validate.eltPolicy");
		
		//2. Type $data in Policy field
		uiDriver.setValue("PolicyViewHistory_Validate.txtPolicy", input.get("Type@Policy"));
		
		//3. Click on Search button
		uiDriver.click("PolicyViewHistory_Validate.btnSearch");
		
		//4. Click on Policy Link
		uiDriver.click("PolicyViewHistory_Validate.lnkPolicy");
		
		//5. Click on History WebElement
		uiDriver.click("PolicyViewHistory_Validate.eltHistory");
		
		//6. Select $data from the Filter_by_Date list
		uiDriver.setValue("PolicyViewHistory_Validate.lstFilter_by_Type", input.get("Select@Filter_by_Type"));
		
		//7. Select $data from the Filter_by_Date list
		uiDriver.setValue("PolicyViewHistory_Validate.lstFilter_by_Type_1", input.get("Select@Filter_by_Type"));
		
		//8. Select $data from the Filter_by_Date list
		uiDriver.setValue("PolicyViewHistory_Validate.lstFilter_by_Type_2", input.get("Select@Filter_by_Type"));
		
		//9. Click on Print_Export button
		uiDriver.click("PolicyViewHistory_Validate.btnPrint_Export");
		
		//10. Select $value from Select_print_export_options Radio Button from the list
//		uiDriver.setValue("PolicyViewHistory_Validate.rdgSelect_print_export_options", input.get("Select@Select_print_export_options"));
		uiDriver.getControl("PolicyViewHistory_Validate.rdgSelect_print_export_options").click();
		SleepUtils.sleep(2);
		//11. Click on Ok button
		uiDriver.click("PolicyViewHistory_Validate.btnOk");
		
		
		//13. Select $value from Select_print_export_options Radio Button from the list
		SleepUtils.sleep(2);
//		uiDriver.setValue("PolicyViewHistory_Validate.rdgSelect_print_export_options#2", input.get("Select@Select_print_export_options#2"));
		uiDriver.getControl("PolicyViewHistory_Validate.rdgSelect_print_export_options#2").click();
		SleepUtils.sleep(2);
		//14. Click on Ok_2 button
		uiDriver.click("PolicyViewHistory_Validate.btnOk_2");
		
		//15. Click on OK_3 button
		
		//uiDriver.handleAlert("Opening Print.pdf","Ok");
		
		//uiDriver.click("PolicyViewHistory_Validate.btnOK_3");
		
		//16. Select $value from Select_print_export_options Radio Button from the list
		SleepUtils.sleep(2);
//		uiDriver.setValue("PolicyViewHistory_Validate.rdgSelect_print_export_options#3", input.get("Select@Select_print_export_options#3"));
		uiDriver.getControl("PolicyViewHistory_Validate.rdgSelect_print_export_options#3").click();
		SleepUtils.sleep(2);
		//17. Select the Date ?checkbox
		uiDriver.setValue("PolicyViewHistory_Validate.chkDate", input.get("Select@Date"));
		uiDriver.ElementPrestnclick("Date");


	
		//18. Select the Description ?checkbox
		uiDriver.setValue("PolicyViewHistory_Validate.chkDescription", input.get("Select@Description"));
		
		//19. Select the User ?checkbox
		uiDriver.setValue("PolicyViewHistory_Validate.chkUser", input.get("Select@User"));
		
		//20. Click on Ok_4 button
		uiDriver.click("PolicyViewHistory_Validate.btnOk_4");
		
		
	}
	

	/**
	*Overriding toString() method of object class to print PolicyViewHistory_Validate
	*format string
	**/
	public String toString(){
		return "PolicyViewHistory_ValidateDriver";
	}
}
