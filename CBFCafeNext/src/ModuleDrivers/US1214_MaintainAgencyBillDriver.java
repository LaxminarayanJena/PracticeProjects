/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 1/3/2018 12:55:13 AM
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
public class US1214_MaintainAgencyBillDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public US1214_MaintainAgencyBillDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void US1214TC03_MaintainAgencyBill(DataRow input, DataRow output) {
		//1. Click on Administration WebElement
		uiDriver.click("US1214TC03_MaintainAgencyBill.eltAdministration");
		SleepUtils.sleep(3);
		
		//2. Click on Business_Settings WebElement
		uiDriver.click("US1214TC03_MaintainAgencyBill.eltBusiness_Settings");
		SleepUtils.sleep(3);
		
		//3. Click on Agency_Bill_Plans WebElement
		uiDriver.click("US1214TC03_MaintainAgencyBill.eltAgency_Bill_Plans");
		SleepUtils.sleep(3);
		
		//4. Select $data from the Show list
		uiDriver.setValue("US1214TC03_MaintainAgencyBill.lstShow", input.get("Select@Show"));
		SleepUtils.sleep(3);
		
		//5. Click on Name Link
		uiDriver.click("US1214TC03_MaintainAgencyBill.lnkName");
		SleepUtils.sleep(3);
		
		//6. Click on Up_to_Agency_Bill_Plans Link
		uiDriver.click("US1214TC03_MaintainAgencyBill.lnkUp_to_Agency_Bill_Plans");
		SleepUtils.sleep(3);
		
		//7. Click on Name_1 Link
		uiDriver.click("US1214TC03_MaintainAgencyBill.lnkName_1");
		SleepUtils.sleep(3);
		
		//8. Click on Up_to_Agency_Bill_Plans_1 Link
		uiDriver.click("US1214TC03_MaintainAgencyBill.lnkUp_to_Agency_Bill_Plans_1");
		SleepUtils.sleep(3);
		
		//9. Click on Name_2 Link
		uiDriver.click("US1214TC03_MaintainAgencyBill.lnkName_2");
		SleepUtils.sleep(3);
		
		//10. Click on Up_to_Agency_Bill_Plans_2 Link
		uiDriver.click("US1214TC03_MaintainAgencyBill.lnkUp_to_Agency_Bill_Plans_2");
		SleepUtils.sleep(3);
		
		//11. Click on Name_3 Link
		uiDriver.click("US1214TC03_MaintainAgencyBill.lnkName_3");
		SleepUtils.sleep(3);
		
		//12. Click on Up_to_Agency_Bill_Plans_3 Link
		uiDriver.click("US1214TC03_MaintainAgencyBill.lnkUp_to_Agency_Bill_Plans_3");
		SleepUtils.sleep(3);
		
		//13. Click on Name_4 Link
		uiDriver.click("US1214TC03_MaintainAgencyBill.lnkName_4");
		SleepUtils.sleep(3);
		
		//14. Click on Up_to_Agency_Bill_Plans_4 Link
		uiDriver.click("US1214TC03_MaintainAgencyBill.lnkUp_to_Agency_Bill_Plans_4");
		SleepUtils.sleep(3);
		
		//15. Click on Name_5 Link
		uiDriver.click("US1214TC03_MaintainAgencyBill.lnkName_5");
		SleepUtils.sleep(3);
		
		//16. Click on Up_to_Agency_Bill_Plans_5 Link
		uiDriver.click("US1214TC03_MaintainAgencyBill.lnkUp_to_Agency_Bill_Plans_5");
		SleepUtils.sleep(3);
	}
	

	/**
	*Overriding toString() method of object class to print US1214TC03_MaintainAgencyBill
	*format string
	**/
	public String toString(){
		return "US1214TC03_MaintainAgencyBillDriver";
	}
}
