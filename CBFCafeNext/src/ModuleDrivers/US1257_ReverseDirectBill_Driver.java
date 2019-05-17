/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 1/4/2018 4:24:59 AM
Module part of 'Guidewire_BillingCenter'
Module created using Cafenext Selenium Builder
 ******************************************************************************/
package ModuleDrivers;

import static cbf.engine.TestResultLogger.*;
import java.io.IOException;
import java.time.LocalDate;

import cbf.engine.TestResult.ResultType;
import cbf.harness.ParameterAccess;
import cbf.utils.DataRow;
import cbf.utils.SleepUtils;
import cbf.utils.SleepUtils.TimeSlab;
import cbfx.selenium.BaseWebModuleDriver;
import java.util.Date;

/**
 * Extends BaseModuleDriver class and performs application specific operations
 */
public class US1257_ReverseDirectBill_Driver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;

	public US1257_ReverseDirectBill_Driver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}

	public void US1257TC03ReverseDirectBill_(DataRow input, DataRow output) {
		
		//1. Click on Desktop WebElement
		uiDriver.click("US1188Createsuspensepayments.eltDesktop");
				
		//2. Click on Actions button
		uiDriver.doubleclick("US1188Createsuspensepayments.btnActions");
				
		//3. Click on New_Payment WebElement
		uiDriver.click("US1188Createsuspensepayments.eltNew_Payment");
				
		//4. Click on Batch_Payment_Entry WebElement
		uiDriver.click("US1188Createsuspensepayments.eltBatch_Payment_Entry");
				
		//5. Type $data in Batch_Amount field
		uiDriver.setValue("US1188Createsuspensepayments.txtBatch_Amount", input.get("Type@Batch_Amount"));
				
		//6. Click on Payment_Instrument WebElement
		uiDriver.click("US1188Createsuspensepayments.eltPayment_Instrument");
				
		//7. Select $data from the Payment_Instrument list
		uiDriver.setValue("US1188Createsuspensepayments.lstPayment_Instrument", input.get("Select@Payment_Instrument"));
		SleepUtils.sleep(3);
				
		//8. Click on Deposit_Date WebElement
		String tdy=uiDriver.currentdate("");
		uiDriver.setValue("Batchpaymententry.eltDeposit_Date", tdy);
		SleepUtils.sleep(3);
				
		//9. Click on Payment_Source WebElement
		uiDriver.click("US1188Createsuspensepayments.eltPayment_Source");
		SleepUtils.sleep(3);
		uiDriver.sendKey("keysdown");
		uiDriver.sendKey("Enter");
		SleepUtils.sleep(3);
				
		//10. Select $data from the Payment_Source list
		uiDriver.click("MakePaymentMulAccPoliProd.txtCheck_Ref");
		SleepUtils.sleep(2);
		
		//11. Type $data in Check_Ref_ field
		uiDriver.setValue("US1188Createsuspensepayments.txtCheck_Ref_", input.get("Type@Check_Ref_"));
		uiDriver.sendKey("TAB");
		SleepUtils.sleep(4);
		
		//12. Type $data in Amount field
		uiDriver.setValue("US1188Createsuspensepayments.txtAmount", input.get("Type@Amount_BP"));
		uiDriver.sendKey("TAB");
		SleepUtils.sleep(4);
		
		//13. Type $data in Account_ field
		uiDriver.setValue("Batchpaymententry.txtAccount_", input.get("Type@Accnumber"));
		SleepUtils.sleep(4);
	
		//14. Click on Next button
	    uiDriver.click("US1188Createsuspensepayments.btnNext");
	    SleepUtils.sleep(4);
		if(uiDriver.checkElementPresent("Batchpaymententry.txtPayment_Source")) {
			uiDriver.click("Batchpaymententry.txtPayment_Source");
			SleepUtils.sleep(3);
			uiDriver.sendKey("keysdown");
			SleepUtils.sleep(3);
			uiDriver.sendKey("Enter");
			SleepUtils.sleep(3);
			uiDriver.click("US1188Createsuspensepayments.eltPayment_Instrument");
			SleepUtils.sleep(3);
			uiDriver.setValue("US1188Createsuspensepayments.lstPayment_Instrument", input.get("Select@Payment_Instrument"));
			uiDriver.sendKey("Enter");
			SleepUtils.sleep(3);
			uiDriver.click("US1188Createsuspensepayments.btnNext");
			SleepUtils.sleep(3);
		}
		SleepUtils.sleep(3);
				
		//15. Click on Post_Batch button
		uiDriver.click("US1188Createsuspensepayments.btnPost_Batch");
		SleepUtils.sleep(3);
			
		
		// 16. Click on Account WebElement
		uiDriver.click("US1257TC03ReverseDirectBill_.eltAccount");
		SleepUtils.sleep(2);
		
		// 17. Type $data in Account_Name field
		uiDriver.setValue("US1257TC03ReverseDirectBill_.txtAccount_Name", input.get("Type@Account_Name"));
		SleepUtils.sleep(2);
		
		// 18. Click on Search button
		uiDriver.click("US1257TC03ReverseDirectBill_.btnSearch");
		SleepUtils.sleep(2);
		
		// 19. Click on Account Link
		uiDriver.click("US1257TC03ReverseDirectBill_.lnkAccount");
		SleepUtils.sleep(2);

		// 20. Click on Payments WebElement
		uiDriver.click("US1257TC03ReverseDirectBill_.eltPayments");
		SleepUtils.sleep(2);
		
		// 21. Click on History WebElement
		uiDriver.click("US1257TC03ReverseDirectBill_.eltHistory");
		SleepUtils.sleep(3);
		
		// 22. Click on Filter_by_Type WebElement
		uiDriver.click("US1257TC03ReverseDirectBill_.eltFilter_by_Type");
		SleepUtils.sleep(3);
		
		// 23. Select $data from the Filter_by_Type list
		uiDriver.setValue("US1257TC03ReverseDirectBill_.lstFilter_by_Type", input.get("Select@Filter_by_Type"));
		uiDriver.sendKey("ENTER");
		uiDriver.sendKey("ENTER");
		SleepUtils.sleep(3);
		
		// 24. Click on Payments_1 WebElement
		uiDriver.click("US1257TC03ReverseDirectBill_.eltPayments_1");
		SleepUtils.sleep(3);
		if(!uiDriver.checkElementPresent("TC05_DirBillPmnt_NewDirtCredit.eltCreditdistribution")) {
			uiDriver.click("US1257TC03ReverseDirectBill_.eltPayments_1");
			SleepUtils.sleep(3);
		}
		String PageEnd=uiDriver.getControl("US1247_TC02MoveDirectBilltosus.eltlength").getText();
		if(!PageEnd.equals("")) {
			//String PageEnd=uiDriver.getControl("US1247_TC02MoveDirectBilltosus.eltlength").getText();
	        String num=PageEnd.substring(2).trim();
	        int PageLenth=Integer.parseInt(num);
	        int i;
	        for(i=0;i<=PageLenth-1;i++) {
	        	uiDriver.click("US1247_TC02MoveDirectBilltosus.BtnForwardArrow");
	            if (i==PageLenth) {
	            	uiDriver.click("US1247_TC02MoveDirectBilltosus.BtnForwardArrow");
	                SleepUtils.sleep(8);
	                break;    
	          }
	        }
			SleepUtils.sleep(3);
			String today = uiDriver.currentdate(null);
			uiDriver.th.findRelativeCellAndClickSelectedCellInSubtext("US1257TC03ReverseDirectBill_.tblId", today, 1, today,"Actions", "Actions");
			SleepUtils.sleep(3);
		}else {
			// 25. Click on Actions button
			String today = uiDriver.currentdate(null);
			uiDriver.th.findRelativeCellAndClickSelectedCellInSubtext("US1257TC03ReverseDirectBill_.tblId", today, 1, today,"Actions", "Actions");
			SleepUtils.sleep(3);
		}
		
		// 26. Click on Reverse WebElement
		uiDriver.click("US1257TC03ReverseDirectBill_.eltReverse");
		SleepUtils.sleep(3);
		
		// 27. Click on Reason WebElement
		uiDriver.click("US1257TC03ReverseDirectBill_.eltReason");
		SleepUtils.sleep(3);
		
		// 28. Select $data from the Reason list
		uiDriver.setValue("US1257TC03ReverseDirectBill_.lstReason", input.get("Select@Reason"));
		uiDriver.sendKey("ENTER");
		SleepUtils.sleep(3);
		
		// 29. Click on OK button
		uiDriver.click("US1257TC03ReverseDirectBill_.btnOK");
		SleepUtils.sleep(3);
	}

	/**
	 * Overriding toString() method of object class to print
	 * US1257TC03ReverseDirectBill_ format string
	 **/
	public String toString() {
		return "US1257TC03ReverseDirectBill_Driver";
	}
}
