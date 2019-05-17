/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 12/22/2017 7:20:58 AM
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
public class US1253_ViewLedgerandJournalPoliDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public US1253_ViewLedgerandJournalPoliDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void US1253ViewLedgerandJournalPoli(DataRow input, DataRow output) {
		//1. Click on Policy WebElement
		uiDriver.click("US1253ViewLedgerandJournalPoli.eltPolicy");
		
		//2. Type $data in First_Name field
		uiDriver.setValue("US1253ViewLedgerandJournalPoli.txtCompany_Name", input.get("Type@Company_Name"));
		
		//3. Click on Search button
		uiDriver.click("US1253ViewLedgerandJournalPoli.btnSearch");
		SleepUtils.sleep(3);
		//4. Click on Policy Link
		uiDriver.click("US1253ViewLedgerandJournalPoli.lnkPolicy");
		SleepUtils.sleep(3);
		
		//5. Click on Ledger WebElement
		uiDriver.click("US1253ViewLedgerandJournalPoli.eltLedger");
		SleepUtils.sleep(5);
		
		//6. Click on Journal WebElement
		uiDriver.click("US1253ViewLedgerandJournalPoli.eltJournal");
		SleepUtils.sleep(5);
		
	}
	

	/**
	*Overriding toString() method of object class to print US1253ViewLedgerandJournalPoli
	*format string
	**/
	public String toString(){
		return "US1253ViewLedgerandJournalPoliDriver";
	}
}
