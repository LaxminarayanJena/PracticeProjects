/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 12/21/2017 4:09:55 AM
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
public class US1153_SearchContacts_verifytheabilitDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public US1153_SearchContacts_verifytheabilitDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void SearchContacts_Verifytheabilit(DataRow input, DataRow output) {
		//1. Click on Search WebElement
		uiDriver.click("SearchContacts_Verifytheabilit.eltSearch");
		
		//2. Click on Contacts WebElement
		uiDriver.click("SearchContacts_Verifytheabilit.eltContacts");
		
		//3. Click on Search button
		uiDriver.click("SearchContacts_Verifytheabilit.btnSearch");
		
		//4. Type $data in First_Name field
		uiDriver.setValue("SearchContacts_Verifytheabilit.txtFirst_Name", input.get("Type@First_Name"));
		SleepUtils.sleep(2);
		
		//5. Type $data in Last_Name field
		uiDriver.setValue("SearchContacts_Verifytheabilit.txtLast_Name", input.get("Type@Last_Name"));
		SleepUtils.sleep(2);
	
		//6. Click on Search_1 button
		uiDriver.click("SearchContacts_Verifytheabilit.btnSearch_1");
		SleepUtils.sleep(3);
		
		//7. Select $data from the Type list
		uiDriver.setValue("SearchContacts_Verifytheabilit.lstType", input.get("Select@Type"));
		SleepUtils.sleep(3);
		
		//8. Click on Search_2 button
		uiDriver.click("SearchContacts_Verifytheabilit.btnSearch_2");
		
		//9. Type $data in Company_Name field
		uiDriver.setValue("SearchContacts_Verifytheabilit.txtCompany_Name", input.get("Type@Company_Name"));
		SleepUtils.sleep(3);
		
		//10. Click on Search_3 button
		uiDriver.click("SearchContacts_Verifytheabilit.btnSearch_3");
		
	}
	

	/**
	*Overriding toString() method of object class to print SearchContacts_verifytheabilit
	*format string
	**/
	public String toString(){
		return "SearchContacts_verifytheabilitDriver";
	}
}
