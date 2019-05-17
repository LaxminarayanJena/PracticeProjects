/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 1/25/2018 12:53:25 AM
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
public class Search_Producer_CodeDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public Search_Producer_CodeDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void Search_Producer_Code(DataRow input, DataRow output) {
		//1. Click on Producer WebElement
		uiDriver.click("Search_Producer_Code.eltProducer");
		
		uiDriver.click("Validate_Producer_Summ_Screen.btnReset");
		SleepUtils.sleep(5);
		
		//2. Type $data in Producer_Code field
		String Producer_Code=input.get("Type@Producer_Code");
		if(!Producer_Code.equals("")) {
			uiDriver.setValue("Search_Producer_Code.txtProducer_Code", input.get("Type@Producer_Code"));
		}
		String Producer_Name=input.get("Type@Producer_Name");
		if(!Producer_Name.equals("")) {
			uiDriver.setValue("Search_Producer_Code.txtProducer_Name", input.get("Type@Producer_Name"));
		}

		//3. Click on Search button
		uiDriver.click("Search_Producer_Code.btnSearch");
		
		//4. Verify whether the Producer_Name element present
		if (uiDriver.checkElementPresent("Search_Producer_Code.eltProducer_Name")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		
		//5. Click on Producer_Name Link
		SleepUtils.sleep(3);
		uiDriver.click("Search_Producer_Code.lnkProducer_Name");
		
	}
	

	/**
	*Overriding toString() method of object class to print Search_Producer_Code
	*format string
	**/
	public String toString(){
		return "Search_Producer_CodeDriver";
	}
}
