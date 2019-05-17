/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 3/6/2018 12:28:19 AM
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
 * Extends BaseModuleDriver class and performs application specific operations
 */
public class US940_Manage_Account_DisbursementDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;

	public US940_Manage_Account_DisbursementDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}

	public void Account_Disbursement(DataRow input, DataRow output) {

		// 1. Click on Desktop WebElement
		SleepUtils.sleep(10);
		uiDriver.click("MakePaymentMulAccPoliProd.eltDesktop");

		// 2. Click on Actions WebElement
		uiDriver.click("MakePaymentMulAccPoliProd.eltActions");

		// 3. Click on Batch_Payment_Entry WebElement
		uiDriver.mouseOver("MakePaymentMulAccPoliProd.eltNewPayment");
		SleepUtils.sleep(3);
		uiDriver.click("MakePaymentMulAccPoliProd.eltBatch_Payment_Entry");

		// 4. Type $data in Batch_Amount field
		uiDriver.setValue("MakePaymentMulAccPoliProd.txtBatch_Amount", input.get("Type@Batch_Amount"));
		SleepUtils.sleep(2);
		uiDriver.sendKey("tab");
		SleepUtils.sleep(5);

		// 5. Select check box
		uiDriver.click("MakePaymentMulAccPoliProd.lstPaymentInstrument");
		SleepUtils.sleep(2);
		uiDriver.sendKey("keysdown");
		SleepUtils.sleep(2);
		uiDriver.sendKey("enter");
		SleepUtils.sleep(2);

		// 6. Select $data from the Type list
		uiDriver.doubleclick("MakePaymentMulAccPoliProd.eltdatepick");
		SleepUtils.sleep(2);
		uiDriver.sendKey("enter");

		// 7. Select $data from the Type list
		uiDriver.doubleclick("TC02ModifyDistribution.lstPayment_Source");
		SleepUtils.sleep(2);
		uiDriver.sendKey("keysdown");
		SleepUtils.sleep(1);
		uiDriver.sendKey("keysdown");
		SleepUtils.sleep(1);
		uiDriver.sendKey("keysdown");
		SleepUtils.sleep(2);
		uiDriver.sendKey("enter");
		SleepUtils.sleep(2);

		// 8. Type $data in Check_Ref field
		uiDriver.click("MakePaymentMulAccPoliProd.txtCheck_Ref");
		SleepUtils.sleep(2);
		uiDriver.setValue("MakePaymentMulAccPoliProd.txtCheck_Ref1", input.get("Type@Check_Ref"));

		// 9. Type $data in Amount field
		uiDriver.click("MakePaymentMulAccPoliProd.txtAmount");
		SleepUtils.sleep(2);
		uiDriver.setValue("MakePaymentMulAccPoliProd.txtAmount1", input.get("Type@Batch_Amount"));

		// 10. Type $data in Amount field
		uiDriver.click("MakePaymentMulAccPoliProd.eltaAccount");
		uiDriver.click("MakePaymentMulAccPoliProd.eltaAccount");
		SleepUtils.sleep(2);
		uiDriver.click("MakePaymentMulAccPoliProd.eltaAccountimag");
		SleepUtils.sleep(5);

		// 11. Type $data in Amount field
		uiDriver.setValue("Validte_Acti_Acc_Poli_Prod_Lev.txtAccount_Name", input.get("Type@AccountName"));
		SleepUtils.sleep(2);

		// 12. Type $data in Amount field
		uiDriver.click("Validte_Acti_Acc_Poli_Prod_Lev.btnSearch_Account");

		// 13. Type $data in Amount field
		uiDriver.click("Validte_Acti_Acc_Poli_Prod_Lev.btnSelect");
		SleepUtils.sleep(6);

		// 14. Click on Split button
		uiDriver.click("TC02ModifyDistribution.btnConfirm_Payment_Next");

		// 15. Click on Split button
		uiDriver.click("TC02ModifyDistribution.btnPost_Batch");
		SleepUtils.sleep(6);

		// 16. Click on Account_tab WebElement
		uiDriver.click("Account_Search.eltAccount");

		// 17. Click on Account_tab WebElement
		uiDriver.click("Account_Search.txtAccount");

		// 18. Type Account_Name $Parama1
		uiDriver.setValue("Account_Search.txtAccountName", input.get("Type@AccountName"));

		// 19. Click on Search button
		uiDriver.click("Account_Search.btnSearch");
		SleepUtils.sleep(5);

		// 20. Select the account
		uiDriver.click("Account_Search.lnkAccount");
		SleepUtils.sleep(5);
		
		// 21. Click on Actions WebElement
		uiDriver.click("Account_Disbursement.eltActions");

		// 22. Click on New_Transaction WebElement
		uiDriver.mouseOver("Account_Disbursement.eltNew_Transaction");
		SleepUtils.sleep(3);

		// 23. Click on Disbursement WebElement
		uiDriver.click("Account_Disbursement.eltDisbursement");
		SleepUtils.sleep(3);

		// 24. Type $data in Amount field
		uiDriver.setValue("Account_Disbursement.txtAmount", input.get("Type@Amount"));

		// 25. Select $data from the Reason_for_Disbursement list
		uiDriver.click("Account_Disbursement.lstReason_for_Disbursement");
		SleepUtils.sleep(3);
		uiDriver.setValue("Account_Disbursement.lstReason_for_Disbursement",
				input.get("Select@Reason_for_Disbursement#1"));
		SleepUtils.sleep(2);
		uiDriver.sendKey("tab");
		SleepUtils.sleep(2);

		// 26. Click on Next button
		uiDriver.click("Account_Disbursement.btnNext");

		// 27. Click on Finish button
		uiDriver.click("Account_Disbursement.btnFinish");
		SleepUtils.sleep(3);

		// 28. Click on Disbursements WebElement
		uiDriver.click("Account_Disbursement.eltDisbursements_1");
		SleepUtils.sleep(3);

		// 29. Verify Amount_
		String SearchString = "$" + input.get("Type@Amount") + ".00";
		uiDriver.th.getCellDataOfCol("Account_Disbursement.tblAmount_", SearchString, 7);

		// 30. Click on Disbursement_ WebElement
		String searchName = "$" + input.get("Type@Amount") + ".00";
		uiDriver.th.findRelativeCellAndClickSelectedcolumn("Account_Disbursement.eltDisbursements_2", searchName, 7,
				searchName, 2);
		SleepUtils.sleep(3);

//		// 31. Select $data from the Reason_for_Disbursement list
//		uiDriver.click("Account_Disbursement.lstReason_for_Disbursement1");
//		SleepUtils.sleep(3);
//		uiDriver.setValue("Account_Disbursement.lstReason_for_Disbursement1",
//				input.get("Select@Reason_for_Disbursement#2"));
//		SleepUtils.sleep(2);
//		uiDriver.sendKey("tab");
//		SleepUtils.sleep(2);
//
//		// 32. Click on Update button
//		uiDriver.click("Account_Disbursement.btnUpdate");

	}

	/**
	 * Overriding toString() method of object class to print
	 * US940_Manage_Account_Disbursement format string
	 **/
	public String toString() {
		return "US940_Manage_Account_DisbursementDriver";
	}
}
