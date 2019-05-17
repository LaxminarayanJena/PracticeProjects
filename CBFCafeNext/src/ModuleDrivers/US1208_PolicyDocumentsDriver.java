/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 12/26/2017 3:03:08 PM
Module part of 'Guidewire Billing Center'
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
public class US1208_PolicyDocumentsDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public US1208_PolicyDocumentsDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void US1208_PolicyDocuments(DataRow input, DataRow output) {
		//1. Click on Policies_Tab WebElement
		uiDriver.click("US1208_PolicyDocuments.eltPolicies_Tab");
		
		//2. Click on Policy_link WebElement
		uiDriver.click("US1208_PolicyDocuments.eltPolicy_link");
		
		//3. Click on Actions WebElement
		uiDriver.click("US1208_PolicyDocuments.eltActions");
		
		//4. Click on Create_New_Document_from_Template WebElement
		uiDriver.click("US1208_PolicyDocuments.eltCreate_New_Document_from_Template");
		
		//5. Double Click on Document_Template in the list
		uiDriver.doubleclick("US1208_PolicyDocuments.lstDocument_Template");
		
		//6. Type $data in Document_Template field
		uiDriver.setValue("US1208_PolicyDocuments.txtDocument_Template", input.get("Type@Document_Template"));
		
		//7. Click on Create_Document button
		uiDriver.click("US1208_PolicyDocuments.btnCreate_Document");
		SleepUtils.sleep(10);
		
		//8. Click on History WebElement
		uiDriver.click("US1208_PolicyDocuments.eltHistory");
		
		//9. Double Click on Filter_by_Type in the list
		uiDriver.doubleclick("US1208_PolicyDocuments.lstFilter_by_Type");
		uiDriver.sendKey("entner");
		SleepUtils.sleep(3);
		
		//10. Type $data in Filter_by_Type field
		uiDriver.setValue("US1208_PolicyDocuments.txtFilter_by_Type", input.get("Type@Filter_by_Type"));
		SleepUtils.sleep(5);
		
		//11. Click on Documents WebElement
		uiDriver.click("US1208_PolicyDocuments.eltDocuments");
		uiDriver.click("US1208_PolicyDocuments.eltDocuments");
		
		//12. Double Click on Search_Start_Date in the list
		uiDriver.doubleclick("US1208_PolicyDocuments.lstSearch_Start_Date");
		
		//13. Type $data in search_Start_Date field
		uiDriver.setValue("US1208_PolicyDocuments.txtsearch_Start_Date", input.get("Type@search_Start_Date"));
		
		//14. Double Click on Document_Type in the list
		uiDriver.doubleclick("US1208_PolicyDocuments.lstDocument_Type");
		
		//15. Type $data in Document_Type field
		uiDriver.setValue("US1208_PolicyDocuments.txtDocument_Type", input.get("Type@Document_Type"));
		
		//16. Click on Search button
		uiDriver.click("US1208_PolicyDocuments.btnSearch");
		
		//17. Click on view button
		uiDriver.click("US1208_PolicyDocuments.btnview");
		
	}
	

	/**
	*Overriding toString() method of object class to print US1208_PolicyDocuments
	*format string
	**/
	public String toString(){
		return "US1208_PolicyDocumentsDriver";
	}
}
