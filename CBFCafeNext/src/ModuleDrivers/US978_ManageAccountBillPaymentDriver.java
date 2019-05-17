/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 4/16/2018 5:43:33 AM
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
public class US978_ManageAccountBillPaymentDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public US978_ManageAccountBillPaymentDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void TC03_ManageAccountBillPayment(DataRow input, DataRow output) {
		//1. Click on Actions button
		uiDriver.click("TC03_ManageAccountBillPayment.btnActions");
		SleepUtils.sleep(4);
		
		//2. Click on New_Agency_Credit_Distribution WebElement
		uiDriver.click("TC03_ManageAccountBillPayment.eltNew_Agency_Credit_Distribution");
		SleepUtils.sleep(4);
		
		//3. Click on Add_Statements button
		uiDriver.click("TC03_ManageAccountBillPayment.btnAdd_Statements");
		SleepUtils.sleep(4);
		
		//4. Click on Search button
		uiDriver.click("TC03_ManageAccountBillPayment.btnSearch");
		SleepUtils.sleep(4);
		
		//5. Select the Executed_Payments
		String Status=uiDriver.th.getCellData("TC03_ManageAccountBillPayment.tblAddstatements", 0, 2);
		SleepUtils.sleep(4);
		uiDriver.th.findRelativeCellAndClickfirstCell("TC03_ManageAccountBillPayment.tblAddstatements",Status, 2 ,Status);
		SleepUtils.sleep(3);
		
		//6. Click on Add_Statements_1 button
		uiDriver.click("TC03_ManageAccountBillPayment.btnAdd_Statements_1");
		SleepUtils.sleep(6);
		
		//7. Click on Next button
		uiDriver.click("TC03_ManageAccountBillPayment.btnNext");
		SleepUtils.sleep(4);
		
		//8. Click on Nettoapply WebElement
		uiDriver.click("TC03_ManageAccountBillPayment.eltNettoapply");
		SleepUtils.sleep(4);
		
		//9. Type $data in Nettoapply field
		uiDriver.setValue("TC03_ManageAccountBillPayment.txtNettoapply", input.get("Type@Nettoapply"));
		SleepUtils.sleep(4);
		
		//10. Click on Next_1 button
		uiDriver.click("TC03_ManageAccountBillPayment.btnNext_1");
		SleepUtils.sleep(4);
		
		//11. Verify whether the Warningmessage element present
		if (uiDriver.checkElementPresent("TC03_ManageAccountBillPayment.eltWarningmessage")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(4);
		
		//12. Click on Finish button
		uiDriver.click("TC03_ManageAccountBillPayment.btnFinish");
		SleepUtils.sleep(4);
	}
	
	public void TC08_ManageAccountBillPayment(DataRow input, DataRow output) {
		SleepUtils.sleep(3);
		
		//1. Click on Agency_Bill_Exceptions WebElement
		uiDriver.click("TC08_ManageAccountBillPayment.eltAgency_Bill_Exceptions");
		SleepUtils.sleep(4);
		
		//2. Select the Executed_Payments
		uiDriver.th.findRelativeCellAndClickfirstCell("TC08_ManageAccountBillPayment.tblAgencyExceptions","Gross Mismatch", 5 ,"Gross Mismatch");
		SleepUtils.sleep(3);
		
		//3. Click on Carry_Forward button
		uiDriver.click("TC08_ManageAccountBillPayment.btnCarry_Forward");
		SleepUtils.sleep(4);
		
		//4. Click on Ok button
		uiDriver.click("TC08_ManageAccountBillPayment.btnOk");
		SleepUtils.sleep(4);
		
		//5. Click on History WebElement
		uiDriver.click("TC08_ManageAccountBillPayment.eltHistory");
		SleepUtils.sleep(4);
		
		//6. Click Filter_by_Date
		uiDriver.click("TC08_ManageAccountBillPayment.txtFilter_by_Date");
		SleepUtils.sleep(4);
		
		//7. Select $data from the Filter_by_Date list
		uiDriver.setValue("TC08_ManageAccountBillPayment.lstFilter_by_Date", input.get("Select@Filter_by_Date"));
		SleepUtils.sleep(4);
		
		//8. Click Filter_by_Type
		uiDriver.click("TC08_ManageAccountBillPayment.txtFilter_by_Type");
		SleepUtils.sleep(4);
		
		//9. Select $data from the Filter_by_Type list
		uiDriver.setValue("TC08_ManageAccountBillPayment.lstFilter_by_Type", input.get("Select@Filter_by_Type"));
		uiDriver.sendKey("Enter");
		SleepUtils.sleep(4);
	}
	
	public void TC09_ManageAccountBillPayment(DataRow input, DataRow output) {
				
		//1. Click on Agency_Bill_Exceptions WebElement
		SleepUtils.sleep(3);
		uiDriver.click("TC09_ManageAccountBillPayment.eltAgency_Bill_Exceptions");
		SleepUtils.sleep(4);
		
		//2. Verify whether the Override_Commission button is present
		if (uiDriver.checkElementPresent("TC09_ManageAccountBillPayment.btnOverride_Commission")) {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(6);
	}
	

	/**
	*Overriding toString() method of object class to print US978_ManageAccountBillPayment
	*format string
	**/
	public String toString(){
		return "US978_ManageAccountBillPaymentDriver";
	}
}
