/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 12/21/2017 7:30:51 AM
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
public class US1153_SearchContacts_Verifyfiel_Driver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public US1153_SearchContacts_Verifyfiel_Driver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void TC03SearchContacts_Verifyfiel_(DataRow input, DataRow output) {
		//1. Click on Search WebElement
		uiDriver.click("TC03SearchContacts_Verifyfiel_.eltSearch");
		
		//2. Click on Contacts WebElement
		uiDriver.click("TC03SearchContacts_Verifyfiel_.eltContacts");
		
		//3. Click on Search button
		uiDriver.click("TC03SearchContacts_Verifyfiel_.btnSearch");
		SleepUtils.sleep(3);
		
		//4. Type $data in First_Name field
		uiDriver.setValue("TC03SearchContacts_Verifyfiel_.txtFirst_Name", input.get("Type@First_Name"));
		
		//5. Type $data in Last_Name field
		uiDriver.setValue("TC03SearchContacts_Verifyfiel_.txtLast_Name", input.get("Type@Last_Name"));
		
		//6. Type $data in ZIP_Code field
		uiDriver.setValue("TC03SearchContacts_Verifyfiel_.txtZIP_Code", input.get("Type@ZIP_Code"));
		
		//7. Click on Search_1 button
		uiDriver.click("TC03SearchContacts_Verifyfiel_.btnSearch_1");
		SleepUtils.sleep(3);
		
		//8. Click on Reset button
		uiDriver.click("TC03SearchContacts_Verifyfiel_.btnReset");
		
		//9. Select $data from the Type list
		uiDriver.setValue("TC03SearchContacts_Verifyfiel_.lstType", input.get("Select@Type"));
		SleepUtils.sleep(3);
		
		//10. Click on Search_2 button
         uiDriver.click("TC03SearchContacts_Verifyfiel_.btnSearch_2");
				
		//11. Type $data in Company_Name field
		uiDriver.setValue("TC03SearchContacts_Verifyfiel_.txtCompany_Name", input.get("Type@Company_Name"));
		
		
		//12. Click on Search_2 button
		uiDriver.click("TC03SearchContacts_Verifyfiel_.btnSearch_3");
		
	}
	

	/**
	*Overriding toString() method of object class to print TC03SearchContacts_Verifyfiel_
	*format string
	**/
	public String toString(){
		return "TC03SearchContacts_Verifyfiel_Driver";
	}
}
