/******************************************************************************
Created by : Admin
Created\Updated on : 12/5/2017 1:30:15 PM
Module part of 'sample_1'
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
public class PolicyLevelHistoryDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public PolicyLevelHistoryDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void PolicyLevelHistory(DataRow input, DataRow output) {
		//1. Click on Account WebElement
		uiDriver.click("PolicyLevelHistory.eltAccount");
		
		//2. Click on Account_Name WebElement
		uiDriver.click("PolicyLevelHistory.eltAccount_Name");
		
		//3. Type $data in Account_Name field
		uiDriver.setValue("PolicyLevelHistory.txtAccount_Name", input.get("Type@Account_Name"));
		
		//4. Click on Search button
		uiDriver.click("PolicyLevelHistory.btnSearch");
		
		//5. Click on Account_Link Link
		uiDriver.click("PolicyLevelHistory.lnkAccount_Link");
		
		//6. Click on Policy WebElement
		uiDriver.click("PolicyLevelHistory.eltPolicy");
		
		//7. Click on Actions WebElement
		uiDriver.click("PolicyLevelHistory.eltActions");
		
		//8. Click on Create_New_Document_from_Template WebElement
		uiDriver.click("PolicyLevelHistory.eltCreate_New_Document_from_Template");
		
		//9. Click on Document_Template WebElement
		uiDriver.click("PolicyLevelHistory.eltDocument_Template");
		
		//10. Type $data in Document_Template field
		uiDriver.setValue("PolicyLevelHistory.txtDocument_Template", input.get("Type@Document_Template"));
		
		//11. Click on Create_Document button
		uiDriver.click("PolicyLevelHistory.btnCreate_Document");
		
		//12. Click on History_tab WebElement
		uiDriver.click("PolicyLevelHistory.eltHistory_tab");
		
	}
	

	/**
	*Overriding toString() method of object class to print PolicyLevelHistory
	*format string
	**/
	public String toString(){
		return "PolicyLevelHistoryDriver";
	}
}
