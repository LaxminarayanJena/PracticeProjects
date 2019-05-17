/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 12/26/2017 5:51:54 AM
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
public class Maintain_Producer_DisbursementsDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public Maintain_Producer_DisbursementsDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void TC03_4_CheckStub_Det_Funds_Tran(DataRow input, DataRow output) {
		
		//1. Click on Actions WebElement
		SleepUtils.sleep(4);
		uiDriver.click("VerifyField_ProdLevel.eltActions");
		
		//2. Click on Disbursement WebElement
		uiDriver.click("TC03_4_CheckStub_Det_Funds_Tran.eltDisbursement");
		SleepUtils.sleep(4);
		
		//3. Type $data In Amount
		uiDriver.setValue("TC03_4_CheckStub_Det_Funds_Tran.txtAmount", input.get("Type@Amount"));
		SleepUtils.sleep(4);
		
		//4. verify list value in Reason for Disbursement
		uiDriver.click("TC03_4_CheckStub_Det_Funds_Tran.lstReasonforDisbursment");
		SleepUtils.sleep(4);
		uiDriver.setValue("TC03_4_CheckStub_Det_Funds_Tran.lstReasonforDisbursment", input.get("Select@Reason_for_Disbursement"));
		SleepUtils.sleep(2);
		uiDriver.sendKey("enter");
		SleepUtils.sleep(4);
		
		//5. Type $data In Amount
		uiDriver.setValue("TC03_4_CheckStub_Det_Funds_Tran.txtInternalCommet", input.get("Type@Internal_Comment"));
		SleepUtils.sleep(4);
		
		//6.Click on Next button
		uiDriver.click("TC01_Create_Credit_Item_Disbur.btnNext");
		SleepUtils.sleep(8);
		
		//7.Click on Finish button
		uiDriver.click("TC01_Create_Credit_Item_Disbur.btnFinish");
		SleepUtils.sleep(8);
		
		//8.Click on Next button
		uiDriver.click("TC03_4_CheckStub_Det_Funds_Tran.eltAgencyBillDisbursements");
		SleepUtils.sleep(3);
		
		//9.find related value and click on corresponding cell
		String amnt="$"+input.get("Type@Amount")+".00";
		uiDriver.th.findRelativeCellAndClickSelectedCellInlink("TC01_Create_Credit_Item_Disbur.tblPay_To",amnt , 7, 2, amnt);
		
		//10. Verify whether the Select element is present
		if (uiDriver.checkElementPresent("TC03_4_CheckStub_Det_Funds_Tran.eleCheckstubDetails")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		
		//11.verify not present funds transfer value in list
		uiDriver.click("Account_Disbursement.lstReason_for_Disbursement1");
		SleepUtils.sleep(3);
		boolean sflag=uiDriver.getElementNameUsingTag("li", "Funds Transfer");
		if(!sflag) {
			passed("checkElementnotPresent","checknotElemenotPresent should pass","checkElementnotPresent passed");
		} else {
			failed("checkElementnotPresent","checkElementnotPresent should pass","checkElementPresent failed");
		}
	}
	

	/**
	*Overriding toString() method of object class to print TC02_Transfer_Funds_Collateral
	*format string
	**/
	public String toString(){
		return "Maintain_Producer_DisbursementsDriver";
	}
}
