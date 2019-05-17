/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 12/26/2017 5:51:54 AM
Module part of 'Guidewire_BillingCenter'
Module created using Cafenext Selenium Builder
******************************************************************************/
package ModuleDrivers;
import static cbf.engine.TestResultLogger.*;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;

import cbf.engine.TestResult.ResultType;
import cbf.harness.ParameterAccess;
import cbf.utils.DataRow;
import cbf.utils.SleepUtils;
import cbf.utils.SleepUtils.TimeSlab;
import cbfx.selenium.BaseWebModuleDriver;
import sun.util.calendar.BaseCalendar.Date;

/**
Extends BaseModuleDriver class and performs application specific operations
*/
public class Manage_Collateral_RequirementsDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public Manage_Collateral_RequirementsDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void TC_020304_Close_Newly_Add_Fieds(DataRow input, DataRow output) {
		
		//1. Click on Collateral WebElement
		SleepUtils.sleep(8);
		uiDriver.click("TC_020304_Close_Newly_Add_Fieds.eltCollateral");
		
		//2. Click on Add button
		uiDriver.click("TC_020304_Close_Newly_Add_Fieds.btnAdd");
		SleepUtils.sleep(4);

		//3. Type $data In Name
		uiDriver.setValue("TC_020304_Close_Newly_Add_Fieds.txtName", input.get("Type@Name"));
		SleepUtils.sleep(4);
		
		//4. Type $data In Requirement
		uiDriver.setValue("TC_020304_Close_Newly_Add_Fieds.txtRequirment", input.get("Type@Requirement"));
		SleepUtils.sleep(4);
		
		//5. select Type list value
		uiDriver.click("TC_020304_Close_Newly_Add_Fieds.lstType");
		SleepUtils.sleep(4);
		uiDriver.setValue("TC_020304_Close_Newly_Add_Fieds.lstType", input.get("Selct@Type"));
		SleepUtils.sleep(2);
		uiDriver.sendKey("enter");
		SleepUtils.sleep(4);
		
		//6. select Level list value
		uiDriver.click("TC_020304_Close_Newly_Add_Fieds.lstLevel");
		SleepUtils.sleep(4);
		uiDriver.setValue("TC_020304_Close_Newly_Add_Fieds.lstLevel", input.get("Selct@Level"));
		SleepUtils.sleep(2);
		uiDriver.sendKey("enter");
		SleepUtils.sleep(4);
		
		//7. Click on update button
		uiDriver.click("TC_020304_Close_Newly_Add_Fieds.btnUpdate");
		SleepUtils.sleep(4);
		
		//8. Verify whether the Select element is present
		if (uiDriver.checkElementPresent("TC_020304_Close_Newly_Add_Fieds.eltCashHeldbyRequirment")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		
		//9. Verify whether the Select element is present
		if (uiDriver.checkElementPresent("TC_020304_Close_Newly_Add_Fieds.eltcash")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
				
		//10. Verify whether the Select element is present
		if (uiDriver.checkElementPresent("TC_020304_Close_Newly_Add_Fieds.eltSegregateCash")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		
		//11. Verify whether the Select element is present
		if (uiDriver.checkElementPresent("TC_020304_Close_Newly_Add_Fieds.eltUnSegregateCash")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		
		//12. Verify whether the Select element is present
		if (uiDriver.checkElementPresent("TC_020304_Close_Newly_Add_Fieds.eltUnSegregateCash")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		
		//13. Verify whether the Select element is present
		if (uiDriver.checkElementPresent("TC_020304_Close_Newly_Add_Fieds.eltChargedAmounts")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		
		//14.Select Check box corresponding Column
		uiDriver.th.findRelativeCellAndClickfirstCell("TC_020304_Close_Newly_Add_Fieds.tblCollateral", input.get("Selct@Type"), 2, input.get("Selct@Type"));
		SleepUtils.sleep(4);
	
		
		//15. Click on Edit Requirement button
		uiDriver.click("TC_020304_Close_Newly_Add_Fieds.btnEditRequirment");
		SleepUtils.sleep(4);
		
		//16.verify edit collateral page
		uiDriver.verifyTextforWebEdit("TC_020304_Close_Newly_Add_Fieds.textEditname", input.get("Type@Name"));
		SleepUtils.sleep(4);
		
		//17.Click on edit collateralRquirment
		uiDriver.click("TC_020304_Close_Newly_Add_Fieds.lnkEditCollateralRequi");
		SleepUtils.sleep(4);
		
		//18. Click on OK button
		uiDriver.click("TC_020304_Close_Newly_Add_Fieds.btnOk");
		SleepUtils.sleep(4);
		
		//19.Select Check box corresponding Column
		uiDriver.th.findRelativeCellAndClickfirstCell("TC_020304_Close_Newly_Add_Fieds.tblCollateral", input.get("Selct@Type"), 2, input.get("Selct@Type"));
		SleepUtils.sleep(4);
		
		//20. Click on Close button
		uiDriver.click("TC_020304_Close_Newly_Add_Fieds.btnClose");
		SleepUtils.sleep(4);
		
		//21. Click on OK button
		uiDriver.click("TC_020304_Close_Newly_Add_Fieds.btnOk");
		SleepUtils.sleep(4);
		
	}
	
	/**
	*Overriding toString() method of object class to print TC_020304_Close_Newly_Add_Fieds
	*format string
	**/
	public String toString(){
		return "Manage_Collateral_RequirementsDriver";
	}
}
