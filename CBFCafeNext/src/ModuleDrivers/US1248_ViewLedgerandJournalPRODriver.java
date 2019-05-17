/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 12/22/2017 7:55:02 AM
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
public class US1248_ViewLedgerandJournalPRODriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public US1248_ViewLedgerandJournalPRODriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void US1248ViewLedgerandJournalPRO(DataRow input, DataRow output) {
		//1. Click on Producer WebElement
		uiDriver.click("US1248ViewLedgerandJournalPRO.eltProducer");
		SleepUtils.sleep(3);
		
		//2. Type $data in Producer_Name field
		uiDriver.setValue("US1248ViewLedgerandJournalPRO.txtProducer_Name", input.get("Type@Producer_Name"));
		
		//3. Click on Search button
		uiDriver.click("US1248ViewLedgerandJournalPRO.btnSearch");
		SleepUtils.sleep(3);
		
		//4. Click on Name Link
		uiDriver.click("US1248ViewLedgerandJournalPRO.lnkName");
		
		//5. Click on Ledger WebElement
		uiDriver.click("US1248ViewLedgerandJournalPRO.eltLedger");
		SleepUtils.sleep(5);
		
		//6. Click on Journal WebElement
		uiDriver.click("US1248ViewLedgerandJournalPRO.eltJournal");
		SleepUtils.sleep(5);
		
	}
	

	/**
	*Overriding toString() method of object class to print US1248ViewLedgerandJournalPRO
	*format string
	**/
	public String toString(){
		return "US1248ViewLedgerandJournalPRODriver";
	}
}
