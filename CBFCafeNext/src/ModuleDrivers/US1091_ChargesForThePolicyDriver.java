/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 11/29/2017 4:13:37 AM
Module part of 'Guidewire_BillingCenter'
Module created using Cafenext Selenium Builder
******************************************************************************/
package ModuleDrivers;
import static cbf.engine.TestResultLogger.*;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;

import com.sun.org.apache.bcel.internal.generic.Select;

import cbf.engine.TestResult.ResultType;
import cbf.harness.ParameterAccess;
import cbf.utils.DataRow;
import cbf.utils.SleepUtils;
import cbf.utils.SleepUtils.TimeSlab;
import cbfx.selenium.BaseWebModuleDriver;

/**
Extends BaseModuleDriver class and performs application specific operations
*/
public class US1091_ChargesForThePolicyDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public US1091_ChargesForThePolicyDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void ChargesForThePolicy(DataRow input, DataRow output) {
		//1. Click on Account WebElement
		uiDriver.click("ChargesForThePolicy.eltAccount");
		
		//2. Type $data in Account field
		uiDriver.setValue("ChargesForThePolicy.txtAccount", input.get("Type@Account"));
		
		//3. Click on Search button
		uiDriver.click("ChargesForThePolicy.btnSearch");
		uiDriver.click("Accountsearch.btnsort1");
		uiDriver.click("Accountsearch.btnsort");
		uiDriver.sendKey("keysdown");
		uiDriver.sendKey("keysdown");
		uiDriver.sendKey("enter");
		SleepUtils.sleep(2);
		
		//4. Click on Account Link
		uiDriver.click("ChargesForThePolicy.lnkAccount");
		
		//5. Click on Charges WebElement
		uiDriver.click("ChargesForThePolicy.eltCharges");
		
		//6. Click on Modify_Invoice_Items button
		uiDriver.click("ChargesForThePolicy.btnModify_Invoice_Items");
		
		//7. Click on Add button
		uiDriver.click("ChargesForThePolicy.btnAdd");
		SleepUtils.sleep(5);
		
		//8. Double Click on Event_Date in the table
		uiDriver.doubleclick("ChargesForThePolicy.tblEvent_Date");
		
		//9. Type $data in Date field
		uiDriver.setValue("ChargesForThePolicy.txtDate", input.get("Type@Date"));
		
		//10. DoubleClick Amount
		SleepUtils.sleep(3);
		uiDriver.doubleclick("ChargesForThePolicy.eltAmount1");
		SleepUtils.sleep(3);
		uiDriver.doubleclick("ChargesForThePolicy.eltAmount1");
		//11. Type $data in Amount field
		SleepUtils.sleep(3);
		uiDriver.setValue("ChargesForThePolicy.txtAmount1", input.get("Type@Amount1"));
		
		//12. DoubleClick Amount
		SleepUtils.sleep(3);
		uiDriver.doubleclick("ChargesForThePolicy.eltAmount2");
		
		//13. Type $data in Amount field
		uiDriver.clear("ChargesForThePolicy.txtAmount2");
		SleepUtils.sleep(3);
		uiDriver.setValue("ChargesForThePolicy.txtAmount2", input.get("Type@Amount2"));
		
		//14. Click on Update button
		SleepUtils.sleep(3);
		uiDriver.click("ChargesForThePolicy.btnUpdate");
		SleepUtils.sleep(8);
	}
	
	/**
	*Overriding toString() method of object class to print ChargesForThePolicy
	*format string
	**/
	public String toString(){
		return "ChargesForThePolicyDriver";
	}
}
