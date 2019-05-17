/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 3/28/2018 9:43:26 AM
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
public class Create_Credit_Item_DisbursementsDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public Create_Credit_Item_DisbursementsDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void TC01_Create_Credit_Item_Disbur(DataRow input, DataRow output) {
		//1. Click on Actions WebElement
		uiDriver.click("TC01_Create_Credit_Item_Disbur.eltActions");
		SleepUtils.sleep(3);
		
		//2. Click on Disburse_Credit_Items WebElement
		uiDriver.click("TC01_Create_Credit_Item_Disbur.eltDisburse_Credit_Items");
		SleepUtils.sleep(3);
		
		//3. Click on Add_Policies button
		uiDriver.click("TC01_Create_Credit_Item_Disbur.btnAdd_Policies");
		SleepUtils.sleep(3);
		
		//4. Type $data in Policy_ field
		uiDriver.setValue("TC01_Create_Credit_Item_Disbur.txtPolicy_", input.get("Type@Policy_"));
		SleepUtils.sleep(3);
		
		//5. Click on Search button
		uiDriver.click("TC01_Create_Credit_Item_Disbur.btnSearch");
		SleepUtils.sleep(3);
		
		//6. Select the Policy_searched ?checkbox
		uiDriver.th.findRelativeCellAndClickSelectedCell("TC01_Create_Credit_Item_Disbur.chkPolicy_searched", input.get("Type@Policy_"), 2, 2,input.get("Type@Policy_"));
		SleepUtils.sleep(3);
		
		//7. Click on Add_Policies button
		uiDriver.click("TC01_Create_Credit_Item_Disbur.btnAdd_Policies1");
		SleepUtils.sleep(3);
		
		//8. Select the Down_Payment ?checkbox
		uiDriver.th.findRelativeCellAndClickfirstCell("TC01_Create_Credit_Item_Disbur.chkDown_Payment",  input.get("Select@Down_Payment"), 5,  input.get("Select@Down_Payment"));
		SleepUtils.sleep(3);
		
		//9. Click on Create_Disbursement button
		uiDriver.click("TC01_Create_Credit_Item_Disbur.btnCreate_Disbursement");
		SleepUtils.sleep(3);
		
		//10. Select $data from the Reason_for_Disbursement list
		uiDriver.click("TC01_Create_Credit_Item_Disbur.lstReason_for_Disbursement");
		SleepUtils.sleep(3);
		uiDriver.setValue("TC01_Create_Credit_Item_Disbur.lstReason_for_Disbursement", input.get("Select@Reason_for_Disbursement"));
		uiDriver.sendKey("enter");
		SleepUtils.sleep(3);
		
		//11. Click on Next button
		uiDriver.click("TC01_Create_Credit_Item_Disbur.btnNext");
		SleepUtils.sleep(3);
		
		//12. Click on Finish button
		uiDriver.click("TC01_Create_Credit_Item_Disbur.btnFinish");
		SleepUtils.sleep(3);
		
		//13. Click on Agency_Bill_Disbursements WebElement
		uiDriver.click("TC01_Create_Credit_Item_Disbur.eltAgency_Bill_Disbursements");
		SleepUtils.sleep(3);
		
		//14. Verify Pay_To
		uiDriver.th.getCellDataOfCol("TC01_Create_Credit_Item_Disbur.tblPay_To", "Approved", 4);
		
		//15. Click on History WebElement
		uiDriver.click("TC01_Create_Credit_Item_Disbur.eltHistory");
		SleepUtils.sleep(3);
		
		//16. Select $data from the Filter_by_Type list
		uiDriver.click("TC01_Create_Credit_Item_Disbur.lstFilter_by_Type");
		SleepUtils.sleep(3);
		uiDriver.setValue("TC01_Create_Credit_Item_Disbur.lstFilter_by_Type", input.get("Select@Filter_by_Type"));
		SleepUtils.sleep(3);
		uiDriver.sendKey("enter");
		SleepUtils.sleep(8);
		
		//17. Verify History Description
		String CellValue=uiDriver.th.getCellData("Verfiy_Producer_History.eltDescription", 0, 1);
		SleepUtils.sleep(3);
		if(CellValue.contains("Disbursement manually created")) {
			passed("Data Presented", "Data Presented should pass", "Data Presented passed");
		} else {
			failed("Data Presented", "Data Presented should pass", "Data not Presented failed");
		}
		
	}
	
	public void TC_06_Ver_Decline_Hold_FutUr(DataRow input, DataRow output) {
		//1. Click on Actions WebElement
		uiDriver.click("TC01_Create_Credit_Item_Disbur.eltActions");
		SleepUtils.sleep(3);
		
		//2. Click on Disburse_Credit_Items WebElement
		uiDriver.click("TC01_Create_Credit_Item_Disbur.eltDisburse_Credit_Items");
		SleepUtils.sleep(3);
		
		//3. Click on Add_Policies button
		uiDriver.click("TC01_Create_Credit_Item_Disbur.btnAdd_Policies");
		SleepUtils.sleep(3);
		
		//4. Type $data in Policy_ field
		uiDriver.setValue("TC01_Create_Credit_Item_Disbur.txtPolicy_", input.get("Type@Policy_"));
		SleepUtils.sleep(3);
		
		//5. Click on Search button
		uiDriver.click("TC01_Create_Credit_Item_Disbur.btnSearch");
		SleepUtils.sleep(3);
		
		//6. Select the Policy_searched ?checkbox
		uiDriver.th.findRelativeCellAndClickSelectedCell("TC01_Create_Credit_Item_Disbur.chkPolicy_searched", input.get("Type@Policy_"), 2, 2,input.get("Type@Policy_"));
		SleepUtils.sleep(3);
		
		//7. Click on Add_Policies button
		uiDriver.click("TC01_Create_Credit_Item_Disbur.btnAdd_Policies1");
		SleepUtils.sleep(3);
		
		//8. Select the Down_Payment ?checkbox''input.get("Select@Down_Payment")
		uiDriver.th.findRelativeCellAndClickfirstCell("TC01_Create_Credit_Item_Disbur.chkDown_Payment", input.get("Type@Amnt_"), 5,  input.get("Type@Amnt_"));
		SleepUtils.sleep(3);
		
		//9. Click on Create_Disbursement button
		uiDriver.click("TC01_Create_Credit_Item_Disbur.btnCreate_Disbursement");
		SleepUtils.sleep(3);
		
		//10. Select $data from the Reason_for_Disbursement list
		uiDriver.click("TC01_Create_Credit_Item_Disbur.lstReason_for_Disbursement");
		SleepUtils.sleep(3);
		uiDriver.setValue("TC01_Create_Credit_Item_Disbur.lstReason_for_Disbursement", input.get("Select@Reason_for_Disbursement"));
		uiDriver.sendKey("enter");
		SleepUtils.sleep(3);
		
		//11. Click on Next button
		uiDriver.click("TC01_Create_Credit_Item_Disbur.btnNext");
		SleepUtils.sleep(3);
		
		//12. Click on Finish button
		uiDriver.click("TC01_Create_Credit_Item_Disbur.btnFinish");
		SleepUtils.sleep(3);
		
		//13. Click on Activities WebElement
		uiDriver.click("TC01_Create_Credit_Item_Disbur.eleActivities");
		SleepUtils.sleep(3);
		
		//14. Click on Activities WebElement
		uiDriver.click("TC01_Create_Credit_Item_Disbur.eleActivities");
		SleepUtils.sleep(3);
		
		//15. Click on Activities WebElement
		uiDriver.click("TC02_Update_AgeBill_Saved_Prom.btnMenu");
		SleepUtils.sleep(2);
		String uName=uiDriver.getControl("TC02_Update_AgeBill_Saved_Prom.eltUsername").getText();
		SleepUtils.sleep(2);
		uiDriver.sendKey("Esc");
		uiDriver.sendKey("enter");
		SleepUtils.sleep(2);
		uiDriver.click("NEPOtherTransactions.eltOpened");
		SleepUtils.sleep(6);
		uiDriver.th.findRelativeCellAndClickSelectedCell("TC01_Create_Credit_Item_Disbur.tblActivities", uName.substring(7).trim(), 8, 6,uName.substring(7).trim());
		SleepUtils.sleep(8);
		
		//16. Click on Disbursement links
		uiDriver.click("TC01_Create_Credit_Item_Disbur.btnDisbursement");
		SleepUtils.sleep(8);
		
		//17. Click on Desktop Button
		uiDriver.th.findRelativeCellAndClickSelectedCellInlink("TC01_Create_Credit_Item_Disbur.tblProducerDisbursment", "Awaiting Approval", 4, 2,"Awaiting Approval");
		SleepUtils.sleep(8);
		
		//18. Verify Button is disabled status 
		boolean sflag=uiDriver.getControl("TC01_Create_Credit_Item_Disbur.btnDeclineHoldFuture").isEnabled();
		SleepUtils.sleep(3);
		if(sflag) {
			passed("Button is Disabled", "Button is Disabled should pass", "Button is Disabled passed");
		} else {
			failed("Button is Disabled", "Button is Disabled should pass", "Button not Disabled failed");
		}
		
		
	}


	/**
	*Overriding toString() method of object class to print Create_Credit_Item_Disbursements
	*format string
	**/
	public String toString(){
		return "Create_Credit_Item_DisbursementsDriver";
	}
}
