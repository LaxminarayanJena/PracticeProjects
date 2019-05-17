/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 12/11/2017 7:17:09 AM
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
 * Extends BaseModuleDriver class and performs application specific operations
 */
public class US1087_Accounts_View_HistoryDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;

	public US1087_Accounts_View_HistoryDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}

	public void Accounts_View_History(DataRow input, DataRow output) {

		// 1. Click on History WebElement
		uiDriver.click("Accounts_View_History.eltHistory");

		// 2. Select $data from the Filter_by_Date list
		uiDriver.setValue("Accounts_View_History.lstFilter_by_Date", input.get("Select@Filter_by_Date"));
	}

	/**
	 * Overriding toString() method of object class to print Accounts_View_History
	 * format string
	 **/
	public String toString() {
		return "Accounts_View_HistoryDriver";
	}
}