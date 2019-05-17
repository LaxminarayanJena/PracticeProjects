/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 12/22/2017 2:44:07 AM
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
public class US1254_SearchTransactionsDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public US1254_SearchTransactionsDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void US1254SearchTransactions(DataRow input, DataRow output) {
		//1. Click on Administration WebElement
		uiDriver.click("US1254SearchTransactions.eltAdministration");
		
		//2. Click on Users WebElement
		uiDriver.click("US1254SearchTransactions.eltUsers");
		
		//3. Type $data in First_Name field
		uiDriver.setValue("Adminuser_Addrole.txtUser_name",System.getProperty("user.name"));
		
		//4. Type $data in Last_Name field
//		uiDriver.setValue("US1254SearchTransactions.txtLast_Name", input.get("Type@Last_Name"));
		
		//5. Click on Search button
	    uiDriver.click("US1254SearchTransactions.btnSearch");
		
		//5. Click on Display_Name_ Link
		uiDriver.click("US1254SearchTransactions.lnkDisplay_Name_");
		SleepUtils.sleep(3);
		
		//6. Click on Search WebElement
		uiDriver.click("US1254SearchTransactions.eltSearch");
		
		//7. Click on Transactions WebElement
		uiDriver.click("US1254SearchTransactions.eltTransactions");
		
		//8. Click on Search_1 button
		uiDriver.click("US1254SearchTransactions.btnSearch_1");
		SleepUtils.sleep(3);
		
		//9. Select $data from the Transaction_Type list
		uiDriver.setValue("US1254SearchTransactions.lstTransaction_Type", input.get("Select@Transaction_Type"));
		uiDriver.sendKey("Enter");
		uiDriver.sendKey("Enter");
		SleepUtils.sleep(3);
		
		//10. Type $data in Minimum_Amount field
		uiDriver.setValue("US1254SearchTransactions.txtMinimum_Amount", input.get("Type@Minimum_Amount"));
		
		//11. Type $data in Maximum_Amount field
		uiDriver.setValue("US1254SearchTransactions.txtMaximum_Amount", input.get("Type@Maximum_Amount"));
		SleepUtils.sleep(3);
		
		//12. Click on Search_2 button
		uiDriver.doubleclick("US1254SearchTransactions.btnSearch_2");
		SleepUtils.sleep(5);
		
		//13. Click on Earliest_Date button
		uiDriver.click("US1254SearchTransactions.btnEarliest_Date");
		uiDriver.sendKey("Enter");
		SleepUtils.sleep(3);
		
		//14. Click on Latest_Date button
		uiDriver.click("US1254SearchTransactions.btnLatest_Date");
		uiDriver.sendKey("Enter");
        SleepUtils.sleep(3);
		
		//15. Click on Search_3 button
		uiDriver.click("US1254SearchTransactions.btnSearch_3");
		
	}
	

	/**
	*Overriding toString() method of object class to print US1254SearchTransactions
	*format string
	**/
	public String toString(){
		return "US1254SearchTransactionsDriver";
	}
}
