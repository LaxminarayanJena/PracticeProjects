/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 12/31/2017 7:18:15 AM
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
public class US1153_SearchProducer_TickDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public US1153_SearchProducer_TickDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void US1153TC06_SearchProducer_Tick(DataRow input, DataRow output) {
		//1. Click on Search WebElement
		uiDriver.click("US1153TC06_SearchProducer_Tick.eltSearch");
		SleepUtils.sleep(3);
		
		//2. Click on Producers WebElement
		uiDriver.click("US1153TC06_SearchProducer_Tick.eltProducers");
		SleepUtils.sleep(3);
		
		//3. Click on Search button
		uiDriver.click("US1153TC06_SearchProducer_Tick.btnSearch");
		SleepUtils.sleep(3);
		
		//4. Click on Reset button
		uiDriver.click("US1153TC06_SearchProducer_Tick.btnReset");
		SleepUtils.sleep(3);
		
		//5. Type $data in Producer_Name field
		uiDriver.setValue("US1153TC06_SearchProducer_Tick.txtProducer_Name", input.get("Type@Producer_Name"));
		SleepUtils.sleep(3);
		
		//6. Click on Search_1 button
		uiDriver.click("US1153TC06_SearchProducer_Tick.btnSearch_1");
		SleepUtils.sleep(3);
		
		//7. Click on Name Link
		uiDriver.click("US1153TC06_SearchProducer_Tick.lnkName");
		SleepUtils.sleep(3);
		
		//8. Click on Search_1 WebElement
		uiDriver.click("US1153TC06_SearchProducer_Tick.eltSearch_1");
		SleepUtils.sleep(3);
		
		//9. Click on Service_Tickets WebElement
		uiDriver.click("US1153TC06_SearchProducer_Tick.eltService_Tickets");
		SleepUtils.sleep(3);
		
		//10. Type $data in Producer_Name_2 field
		uiDriver.setValue("US1153TC06_SearchProducer_Tick.txtProducer_Name_2", input.get("Type@Producer_Name_2"));
		SleepUtils.sleep(3);
		
		//11. Click on Search_2 button
		uiDriver.click("US1153TC06_SearchProducer_Tick.btnSearch_2");
		SleepUtils.sleep(3);
		
		//12. Click on Ticket Link
		uiDriver.click("US1153TC06_SearchProducer_Tick.lnkTicket");
		SleepUtils.sleep(3);
	}
	

	/**
	*Overriding toString() method of object class to print US1153TC06_SearchProducer_Tick
	*format string
	**/
	public String toString(){
		return "US1153TC06_SearchProducer_TickDriver";
	}
}
