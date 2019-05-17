/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 12/22/2017 6:57:38 AM
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
public class US1251_ViewLedgerandJournalAccDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public US1251_ViewLedgerandJournalAccDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void US1251ViewLedgerandJournalAcc(DataRow input, DataRow output) {
			
		//1. Click on Ledger WebElement
		uiDriver.click("US1251ViewLedgerandJournalAcc.eltLedger");
		SleepUtils.sleep(5);
		
		//2. Click on Journal WebElement
		uiDriver.click("US1251ViewLedgerandJournalAcc.eltJournal");
		SleepUtils.sleep(5);
		
	}
	

	/**
	*Overriding toString() method of object class to print US1251ViewLedgerandJournalAcc
	*format string
	**/
	public String toString(){
		return "US1251ViewLedgerandJournalAccDriver";
	}
}
