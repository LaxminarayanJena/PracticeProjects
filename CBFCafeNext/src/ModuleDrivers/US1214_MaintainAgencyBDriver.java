/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 1/3/2018 1:36:29 AM
Module part of 'Guidewire_BillingCenter'
Module created using Cafenext Selenium Builder
******************************************************************************/
package ModuleDrivers;
import static cbf.engine.TestResultLogger.*;
import java.io.IOException;
import java.util.Random;

import cbf.engine.TestResult.ResultType;
import cbf.harness.ParameterAccess;
import cbf.utils.DataRow;
import cbf.utils.SleepUtils;
import cbf.utils.SleepUtils.TimeSlab;
import cbfx.selenium.BaseWebModuleDriver;

/**
Extends BaseModuleDriver class and performs application specific operations
*/
public class US1214_MaintainAgencyBDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public US1214_MaintainAgencyBDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void US1214TC01_TC02MaintainAgencyB(DataRow input, DataRow output) {
		//1. Click on Administration WebElement
		uiDriver.click("US1214TC01_TC02MaintainAgencyB.eltAdministration");
		SleepUtils.sleep(3);
		
		//2. Click on Business_Settings WebElement
		uiDriver.click("US1214TC01_TC02MaintainAgencyB.eltBusiness_Settings");
		SleepUtils.sleep(3);
		
		//3. Click on Agency_Bill_Plans WebElement
		uiDriver.click("US1214TC01_TC02MaintainAgencyB.eltAgency_Bill_Plans");
		SleepUtils.sleep(3);
		
		//4. Click on Name Link
		uiDriver.doubleclick("US1214TC01_TC02MaintainAgencyB.elteffectivedatesort");
		uiDriver.doubleclick("US1214TC01_TC02MaintainAgencyB.elteffectivedatesort");
		SleepUtils.sleep(3);
		uiDriver.click("US1214TC01_TC02MaintainAgencyB.lnkName");
		SleepUtils.sleep(3);
		
		//5. Click on Clone button
		uiDriver.click("US1214TC01_TC02MaintainAgencyB.btnClone");
		SleepUtils.sleep(3);
		Random rnd=new Random();
		int  n = rnd.nextInt(100000) + 10000;		
		uiDriver.setValue("US1214TC01_TC02MaintainAgencyB.txtName_1","Testing"+Integer.toString(n));
		SleepUtils.sleep(3);
		
		//6. Click on Update_1 button
		uiDriver.click("US1214TC01_TC02MaintainAgencyB.btnUpdate_1");
		SleepUtils.sleep(3);
		
		//7. Click on Up_to_Agency_Bill_Plans Link
		//uiDriver.click("US1214TC01_TC02MaintainAgencyB.lnkUp_to_Agency_Bill_Plans");
		SleepUtils.sleep(3);
		
		//8. Click on Edit link
		uiDriver.click("US1214TC01_TC02MaintainAgencyB.btnEdit");
		SleepUtils.sleep(3);
		
		//9. Type $data in Name field
		int  n1 = rnd.nextInt(100000) + 10000;		
		uiDriver.setValue("US1214TC01_TC02MaintainAgencyB.txtName", input.get("Type@Name#1")+Integer.toString(n1));
		SleepUtils.sleep(3);
		
		//10. Type $data in Producer_Write_Off_Threshold field
		uiDriver.setValue("US1214TC01_TC02MaintainAgencyB.txtProducer_Write_Off_Threshold", input.get("Type@Producer_Write_Off_Threshold"));
		SleepUtils.sleep(3);
		
		//11. Click on Update button
		uiDriver.click("US1214TC01_TC02MaintainAgencyB.btnUpdate");
		SleepUtils.sleep(3);
		
		
	}
	

	/**
	*Overriding toString() method of object class to print US1214TC01_TC02MaintainAgencyB
	*format string
	**/
	public String toString(){
		return "US1214TC01_TC02MaintainAgencyBDriver";
	}
}
