/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 12/28/2017 12:40:40 PM
Module part of 'Guidewire Billing Center'
Module created using Cafenext Selenium Builder
******************************************************************************/
package ModuleDrivers;

import static cbf.engine.TestResultLogger.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import cbf.engine.TestResult.ResultType;
import cbf.harness.ParameterAccess;
import cbf.utils.DataRow;
import cbf.utils.SleepUtils;
import cbf.utils.SleepUtils.TimeSlab;
import cbfx.selenium.BaseWebModuleDriver;

/**
 * Extends BaseModuleDriver class and performs application specific operations
 */
public class US1213_DefineAgncyBillPlansDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	private SimpleDateFormat SimpleDateformat;

	public US1213_DefineAgncyBillPlansDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}

	public void US1213_DefineAgncyBillPlans(DataRow input, DataRow output) {
		// 1. Click on Administration WebElement
		uiDriver.click("US1213_DefineAgncyBillPlans.eltAdministration");
		SleepUtils.sleep(3);
		
		// 2. Click on Actions button
		uiDriver.click("US1213_DefineAgncyBillPlans.btnActions");
		SleepUtils.sleep(3);
		
		// 3. Click on New_Agency_Bill_Plan WebElement
		uiDriver.click("US1213_DefineAgncyBillPlans.eltNew_Agency_Bill_Plan");
		SleepUtils.sleep(3);
		
		// 4. Click Name
		uiDriver.click("US1213_DefineAgncyBillPlans.txtName");
		SleepUtils.sleep(3);
		
		// 5. Type $data in Name field
		Random rand = new Random();
		int n = rand.nextInt(100) + 10000;
		uiDriver.setValue("US1213_DefineAgncyBillPlans.txtName", "Test Agency Bill Plans" + Integer.toString(n));
		SleepUtils.sleep(3);
		
		// 6. Double Click on Workflow_Type in the list
		uiDriver.doubleclick("US1213_DefineAgncyBillPlans.lstWorkflow_Type");
		SleepUtils.sleep(3);
		
		// 7. Type $data in Workflow_Type field
		uiDriver.setValue("US1213_DefineAgncyBillPlans.txtWorkflow_Type", input.get("Type@Workflow_Type"));
		SleepUtils.sleep(3);
		
		// 8. Click Expiration_Date
		uiDriver.click("US1213_DefineAgncyBillPlans.txtExpiration_Date");
		SleepUtils.sleep(3);
		
		// 9. Type $data in Expiration_Date field
		String tdy=uiDriver.currentdate(null);
		String sDate=uiDriver.getControl("US1213_DefineAgncyBillPlans.txtExpirationDate_1").getText();
		int strpos=sDate.lastIndexOf(":");
		String sDate1=sDate.substring(strpos+1).trim();
		SimpleDateFormat Dateformat=new SimpleDateFormat("MM/dd/yyyy");
		Calendar calendar = Calendar.getInstance();
		try {
			calendar.setTime(Dateformat.parse(sDate1));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		calendar.add(calendar.DATE, 15);
		String newDate=Dateformat.format(calendar.getTime());
		SleepUtils.sleep(4);
		uiDriver.setValue("US1213_DefineAgncyBillPlans.txtExpiration_Date", newDate);
		SleepUtils.sleep(3);
		
		// 10. Click Days
		uiDriver.click("US1213_DefineAgncyBillPlans.txtDays");
		SleepUtils.sleep(3);
		
		// 11. Type $data in Days field
		uiDriver.setValue("US1213_DefineAgncyBillPlans.txtDays", input.get("Type@Days"));
		SleepUtils.sleep(3);
		
		// 12. Click Producer_Write_Off_Threshold
		uiDriver.click("US1213_DefineAgncyBillPlans.txtProducer_Write_Off_Threshold");
		SleepUtils.sleep(3);
		
		// 13. Type $data in Producer_Write_Off_Threshold field
		uiDriver.setValue("US1213_DefineAgncyBillPlans.txtProducer_Write_Off_Threshold",
				input.get("Type@Producer_Write_Off_Threshold"));
		SleepUtils.sleep(3);
		
		// 14. Click Threshold
		uiDriver.click("US1213_DefineAgncyBillPlans.txtThreshold");
		SleepUtils.sleep(3);
		
		// 15. Type $data in Threshold field
		uiDriver.setValue("US1213_DefineAgncyBillPlans.txtThreshold", input.get("Type@Threshold"));
		SleepUtils.sleep(3);
		
		// 16. Click Threshold1
		uiDriver.click("US1213_DefineAgncyBillPlans.txtThreshold1");
		SleepUtils.sleep(3);
		
		// 17. Type $data in Threshold1 field
		uiDriver.setValue("US1213_DefineAgncyBillPlans.txtThreshold1", input.get("Type@Threshold1"));
		SleepUtils.sleep(3);
		
		// 18. Click on Update button
		uiDriver.click("US1213_DefineAgncyBillPlans.btnUpdate");
		SleepUtils.sleep(6);

		
		// 19. Validating the entry
		String expectedTextName = "Test Agency Bill Plans" + Integer.toString(n);
		uiDriver.th.verfiygetCellDataOfColumn("US1213_DefineAgncyBillPlans.tbname", expectedTextName, 1);
		SleepUtils.sleep(3);
	}
	

	/**
	 * Overriding toString() method of object class to print
	 * US1213_DefineAgncyBillPlans format string
	 **/
	public String toString() {
		return "US1213_DefineAgncyBillPlansDriver";
	}
}
