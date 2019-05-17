/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 5/15/2018 7:07:42 AM
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
public class US1046_ConfigAgencyBillDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public US1046_ConfigAgencyBillDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void TC01_ConfigAgencyBill(DataRow input, DataRow output) {
		//1. Click on Agency_Bill_Payments WebElement
		uiDriver.click("TC01_ConfigAgencyBill.eltAgency_Bill_Payments");
		SleepUtils.sleep(8);
		
		//2. Click on Executed_Payments WebElement
		uiDriver.click("TC01_ConfigAgencyBill.eltExecuted_Payments");
		SleepUtils.sleep(8);
		//9. Click on Payment_Received WebElement
				uiDriver.click("TC01_ConfigAgencyBill.eltPayment_Received");
				SleepUtils.sleep(3);

				//10. Select $data from the Payment_Received list
				uiDriver.setValue("TC01_ConfigAgencyBill.lstPayment_Received", input.get("Select@Payment_Received"));
				uiDriver.sendKey("Enter");
				SleepUtils.sleep(8);
//		uiDriver.click("TC01_ConfigAgencyBill.txtPaging");
//		uiDriver.setValue("TC01_ConfigAgencyBill.txtPaging_1", input.get("Type@Paging"));
//		uiDriver.sendKey("Enter");
		SleepUtils.sleep(4);	
		uiDriver.th.findRelativeCellAndClickfirstCell("TC01_ConfigAgencyBill.tblExecuted_Payments","$20,000.00", 3 ,"$20,000.00");
		SleepUtils.sleep(3);
		
		//3. Verify whether the Apply_Bulk_Payment element present
		if (uiDriver.checkElementPresent("TC01_ConfigAgencyBill.eltApply_Bulk_Payment")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(5);
		
	}
	public void TC02_ConfigAgencyBill(DataRow input, DataRow output) {
		//1. Click on Agency_Bill_Payments WebElement
		uiDriver.click("TC02_ConfigAgencyBill.eltAgency_Bill_Payments");
		SleepUtils.sleep(8);
		
		//2. Click on Executed_Payments WebElement
		uiDriver.click("TC02_ConfigAgencyBill.eltExecuted_Payments");
		SleepUtils.sleep(8);
		//9. Click on Payment_Received WebElement
		uiDriver.click("TC01_ConfigAgencyBill.eltPayment_Received");
		SleepUtils.sleep(3);

		//10. Select $data from the Payment_Received list
		uiDriver.setValue("TC01_ConfigAgencyBill.lstPayment_Received", input.get("Select@Payment_Received"));
		uiDriver.sendKey("Enter");
		SleepUtils.sleep(4);
		
		uiDriver.th.findRelativeCellAndClickfirstCell("TC02_ConfigAgencyBill.tblExecuted_Payments","$20,000.00", 3 ,"$20,000.00");
		SleepUtils.sleep(3);
		
		//3. Click on Edit button
		uiDriver.click("TC02_ConfigAgencyBill.btnEdit");
		SleepUtils.sleep(4);
		
		//4. Click on Batch_Entry_By_Policy button
		uiDriver.click("TC02_ConfigAgencyBill.btnBatch_Entry_By_Policy");
		SleepUtils.sleep(4);
		
		//5. Click on Next button
		uiDriver.click("TC02_ConfigAgencyBill.btnNext");
		SleepUtils.sleep(5);
		
		//6. Click Policy
		uiDriver.click("TC02_ConfigAgencyBill.txtPolicy");
		SleepUtils.sleep(5);
		
		//7. Type $data in Policy_ field
		uiDriver.setValue("TC02_ConfigAgencyBill.txtPolicy_", input.get("Type@Policy_"));
		SleepUtils.sleep(5);
		uiDriver.sendKey("tab");
		SleepUtils.sleep(5);
			
		//8. Click Net_To_Apply
		uiDriver.click("TC02_ConfigAgencyBill.txtNet_To_Apply_1");
		SleepUtils.sleep(5);
		
		//9. Type $data in Net_To_Apply_1 field
		uiDriver.setValue("TC02_ConfigAgencyBill.txtNet_To_Apply_1", "500");
		SleepUtils.sleep(4);
		
		//10. Click on Next button
		uiDriver.click("TC02_ConfigAgencyBill.btnNext_1");
		SleepUtils.sleep(4);
		
		//11. Click on Finish button
		uiDriver.click("TC02_ConfigAgencyBill.btnFinish");
		SleepUtils.sleep(4);
	}
	
	
	public void TC03_ConfigAgencyBill(DataRow input, DataRow output) {
		
		//1. Click on Agency_Bill_Payments WebElement
		SleepUtils.sleep(6);
		uiDriver.click("TC03_ConfigAgencyBill.eltAgency_Bill_Payments");
		SleepUtils.sleep(8);
		
		//2. Click on Executed_Payments WebElement
		uiDriver.click("TC03_ConfigAgencyBill.eltExecuted_Payments");
		SleepUtils.sleep(4);
		//9. Click on Payment_Received WebElement
				uiDriver.click("TC01_ConfigAgencyBill.eltPayment_Received");
				SleepUtils.sleep(3);

				//10. Select $data from the Payment_Received list
				uiDriver.setValue("TC01_ConfigAgencyBill.lstPayment_Received", input.get("Select@Payment_Received"));
				uiDriver.sendKey("Enter");
				SleepUtils.sleep(8);
//		uiDriver.click("TC03_ConfigAgencyBill.txtPaging");
//		uiDriver.setValue("TC03_ConfigAgencyBill.txtPaging_1", input.get("Type@Paging"));
//		uiDriver.sendKey("Enter");
//		SleepUtils.sleep(4);
		uiDriver.th.findRelativeCellAndClickfirstCell("TC03_ConfigAgencyBill.tblExecuted_Payments","$30,000.00", 3 ,"$30,000.00");
		SleepUtils.sleep(3);
		
		//3. Click on Edit button
		uiDriver.click("TC03_ConfigAgencyBill.btnEdit");
		SleepUtils.sleep(4);
		
		//4. Type $data in Payment_Description field
		uiDriver.setValue("TC03_ConfigAgencyBill.txtPayment_Description", input.get("Type@Payment_Description"));
		SleepUtils.sleep(4);
		
		//5. Click on Add_Statements button
		uiDriver.click("TC03_ConfigAgencyBill.btnAdd_Statements");
		SleepUtils.sleep(4);
		
		
		//6. Click on Search button
		uiDriver.click("TC03_ConfigAgencyBill.btnSearch");
		SleepUtils.sleep(4);
	
		//14. Click on the CheckBox
		uiDriver.th.findRelativeCellAndClickfirstCell("TC03_ConfigAgencyBill.tblAgencyDistribution","Open", 2 ,"Open");
		SleepUtils.sleep(3);
		
		//5. Click on Add_Statements button
		uiDriver.click("TC03_ConfigAgencyBill.btnAdd_Statements_1");
		SleepUtils.sleep(4);
				
		//7. Click on Next button
		uiDriver.click("TC03_ConfigAgencyBill.btnNext");
		SleepUtils.sleep(4);
		
		//8. Click on Suspense_Items button
		uiDriver.click("TC03_ConfigAgencyBill.btnSuspense_Items");
		uiDriver.sendKey("Enter");
		SleepUtils.sleep(4);
		
		//10. Type $data in Policy_1 field
		uiDriver.setValue("TC03_ConfigAgencyBill.txtPolicy_1", input.get("Type@Policy_1"));
		
		uiDriver.sendKey("tab");
		uiDriver.sendKey("tab");
		uiDriver.sendKey("tab");
		uiDriver.sendKey("Enter");
		SleepUtils.sleep(4);
		
		//12. Type $data in Gross_1 field
		uiDriver.setValue("TC03_ConfigAgencyBill.txtGross_1", input.get("Type@Gross_1"));		
		uiDriver.sendKey("tab");
		uiDriver.sendKey("Enter");
		SleepUtils.sleep(4);
				
        //14. Type $data in Comission_1 field
		uiDriver.setValue("TC03_ConfigAgencyBill.txtComission_1", input.get("Type@Comission_1"));
		SleepUtils.sleep(4);
		
		//15. Click on Ok button
		uiDriver.click("TC03_ConfigAgencyBill.btnOk");
		SleepUtils.sleep(4);
		
		//16. Click on Next button
		uiDriver.click("TC03_ConfigAgencyBill.btnNext_1");
		SleepUtils.sleep(4);
		
		//17. Click on Finish button
		uiDriver.click("TC03_ConfigAgencyBill.btnFinish");
		SleepUtils.sleep(4);
		
	}
	
	

	/**
	*Overriding toString() method of object class to print US1046_ConfigAgencyBill
	*format string
	**/
	public String toString(){
		return "US1046_ConfigAgencyBillDriver";
	}
}
