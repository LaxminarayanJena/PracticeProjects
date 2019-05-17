/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 3/12/2018 6:41:04 AM
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
public class US938_ViewAccountDisbursementsDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;

	public US938_ViewAccountDisbursementsDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}

	public void TC06_ViewAccountDisbursement(DataRow input, DataRow output) {
		// 1. Click on Account WebElement
		uiDriver.click("TC06_ViewAccountDisbursement.eltAccount");
		SleepUtils.sleep(1);

		// 2. Type $data in Account_Name field
		uiDriver.setValue("TC06_ViewAccountDisbursement.txtAccount_Name", input.get("Type@Account_Name"));
		SleepUtils.sleep(1);

		// 3. Click on Search button
		uiDriver.click("TC06_ViewAccountDisbursement.btnSearch");
		SleepUtils.sleep(1);

		// 4. Verify whether the Account link is present
		if (uiDriver.checkElementPresent("TC06_ViewAccountDisbursement.lnkAccount")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 5. Click on Account_ Link
		SleepUtils.sleep(1);
		uiDriver.click("TC06_ViewAccountDisbursement.lnkAccount_");
		SleepUtils.sleep(1);

		// 6. Click on Actions button
		uiDriver.click("TC06_ViewAccountDisbursement.btnActions");
		SleepUtils.sleep(1);

		// 7. Click on New_Transaction WebElement
		uiDriver.click("TC06_ViewAccountDisbursement.eltNew_Transaction");
		SleepUtils.sleep(1);

		// 8. Click on Disbursement WebElement
		uiDriver.click("TC06_ViewAccountDisbursement.eltDisbursement");
		SleepUtils.sleep(1);

		// 9. Type $data in Amount field
		uiDriver.setValue("TC06_ViewAccountDisbursement.txtAmount", input.get("Type@Amount"));
		SleepUtils.sleep(1);

		// 10. Click Reason_for_Disbursement
		uiDriver.click("TC06_ViewAccountDisbursement.txtReason_for_Disbursement");
		SleepUtils.sleep(1);

		// 11. Type $data in Reason_for_Disbursement field
		uiDriver.setValue("TC06_ViewAccountDisbursement.txtReason_for_Disbursement",
				input.get("Type@Reason_for_Disbursement"));
		SleepUtils.sleep(1);

		// 12. Click on Next button
		uiDriver.click("TC06_ViewAccountDisbursement.btnNext");
		SleepUtils.sleep(1);

		// 13. Click on Finish button
		uiDriver.click("TC06_ViewAccountDisbursement.btnFinish");
		SleepUtils.sleep(1);

		// 14. Click on Desktop WebElement
		uiDriver.click("TC06_ViewAccountDisbursement.eltDesktop");
		SleepUtils.sleep(1);

		// 15. Click on My_Disbursements WebElement
		uiDriver.click("TC06_ViewAccountDisbursement.eltMy_Disbursements");
		SleepUtils.sleep(1);

		// 16. Click Filter_by_Status
		uiDriver.click("TC06_ViewAccountDisbursement.txtFilter_by_Status");
		SleepUtils.sleep(1);

		// 17. Select $data from the Filter_by_Status list
		uiDriver.setValue("TC06_ViewAccountDisbursement.lstFilter_by_Status", input.get("Select@Filter_by_Status"));
		SleepUtils.sleep(3);
		uiDriver.sendKey("tab");
		SleepUtils.sleep(3);

		// 18. Click on Reason Link
		uiDriver.click("TC06_ViewAccountDisbursement.lnkReason");
		SleepUtils.sleep(1);

		// 19. Click on Decline button
		uiDriver.click("TC06_ViewAccountDisbursement.btnDecline");
		SleepUtils.sleep(1);

		// 20. Click on Ok button
		uiDriver.click("TC06_ViewAccountDisbursement.btnOk");
		SleepUtils.sleep(1);

		// 21. Click Filter_by_Status_1
		uiDriver.click("TC06_ViewAccountDisbursement.txtFilter_by_Status_1");
		SleepUtils.sleep(1);

		// 22. Select $data from the Filter_by_Status_1 list
		uiDriver.setValue("TC06_ViewAccountDisbursement.lstFilter_by_Status_1", input.get("Select@Filter_by_Status_1"));
		SleepUtils.sleep(3);
		uiDriver.sendKey("tab");
		SleepUtils.sleep(3);
	}

	public void TC06_ViewAccountdisbApproved(DataRow input, DataRow output) {
		// 1. Click on Account WebElement
		uiDriver.click("TC06_ViewAccountdisbApproved.eltAccount");
		SleepUtils.sleep(1);

		// 2. Type $data in Account_Name field
		uiDriver.setValue("TC06_ViewAccountdisbApproved.txtAccount_Name", input.get("Type@Account_Name"));
		SleepUtils.sleep(1);

		// 3. Click on Search button
		uiDriver.click("TC06_ViewAccountdisbApproved.btnSearch");
		SleepUtils.sleep(1);

		// 4. Verify whether the Account link is present
		if (uiDriver.checkElementPresent("TC06_ViewAccountdisbApproved.lnkAccount")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 5. Click on Account_ Link
		SleepUtils.sleep(1);
		uiDriver.click("TC06_ViewAccountdisbApproved.lnkAccount_");
		SleepUtils.sleep(1);

		// 6. Click on Actions button
		uiDriver.click("TC06_ViewAccountdisbApproved.btnActions");
		SleepUtils.sleep(1);

		// 7. Click on New_Transaction WebElement
		uiDriver.click("TC06_ViewAccountdisbApproved.eltNew_Transaction");
		SleepUtils.sleep(1);

		// 8. Click on Disbursement WebElement
		uiDriver.click("TC06_ViewAccountdisbApproved.eltDisbursement");
		SleepUtils.sleep(1);

		// 9. Type $data in Amount field
		uiDriver.setValue("TC06_ViewAccountdisbApproved.txtAmount", input.get("Type@Amount"));
		SleepUtils.sleep(1);

		// 10. Click Reason_for_Disbursement
		uiDriver.click("TC06_ViewAccountdisbApproved.txtReason_for_Disbursement");
		SleepUtils.sleep(1);

		// 11. Select $data from the Reason_for_Disbursement list
		uiDriver.setValue("TC06_ViewAccountdisbApproved.lstReason_for_Disbursement",
				input.get("Select@Reason_for_Disbursement"));
		SleepUtils.sleep(3);
		uiDriver.sendKey("tab");
		SleepUtils.sleep(3);

		// 12. Click on Next button
		uiDriver.click("TC06_ViewAccountdisbApproved.btnNext");
		SleepUtils.sleep(1);

		// 13. Click on Finish button
		uiDriver.click("TC06_ViewAccountdisbApproved.btnFinish");
		SleepUtils.sleep(1);

		// 14. Click on Desktop WebElement
		uiDriver.click("TC06_ViewAccountdisbApproved.eltDesktop");
		SleepUtils.sleep(1);

		// 15. Click on My_Disbursements WebElement
		uiDriver.click("TC06_ViewAccountdisbApproved.eltMy_Disbursements");
		SleepUtils.sleep(1);

		// 16. Click Filter_by_Status
		uiDriver.click("TC06_ViewAccountdisbApproved.txtFilter_by_Status");
		SleepUtils.sleep(1);

		// 17. Select $data from the Filter_by_Status list
		uiDriver.setValue("TC06_ViewAccountdisbApproved.lstFilter_by_Status", input.get("Select@Filter_by_Status"));
		SleepUtils.sleep(3);
		uiDriver.sendKey("tab");
		SleepUtils.sleep(3);

		// 18. Click on HotKeys
		uiDriver.HotKeys("T");
		SleepUtils.sleep(6);
		uiDriver.th.findRelativeCellAndClickSelectedCellInSubtext("TC06_ViewAccountdisbApproved.tblProcess",
				"Disbursement", 0, "Disbursement", "RunStopDownload History", "Run");
		SleepUtils.sleep(9);

		// 19. Click on Actions button
		uiDriver.click("TC06_ViewAccountdisbApproved.btnActions_1");
		SleepUtils.sleep(1);

		// 20. Click on Return to BillingCenter WebElement
		uiDriver.click("TC06_ViewAccountdisbApproved.eltReturn to BillingCenter");
		SleepUtils.sleep(1);

		// 21. Click on My_Disbursements WebElement
		uiDriver.click("TC06_ViewAccountdisbApproved.eltMy_Disbursements_1");
		SleepUtils.sleep(1);

		// 22. Click Filter_by_Status_1
		uiDriver.click("TC06_ViewAccountdisbApproved.txtFilter_by_Status_1");
		SleepUtils.sleep(1);

		// 23. Select $data from the Filter_by_Status_1 list
		uiDriver.setValue("TC06_ViewAccountdisbApproved.lstFilter_by_Status_1", input.get("Select@Filter_by_Status_1"));
		SleepUtils.sleep(3);
		uiDriver.sendKey("tab");
		SleepUtils.sleep(3);

		// 24. Click on Reason Link
		uiDriver.click("TC06_ViewAccountdisbApproved.lnkReason");
		SleepUtils.sleep(1);

		// 25. Click Void_Reason
		uiDriver.click("TC06_ViewAccountdisbApproved.txtVoid_Reason");
		SleepUtils.sleep(1);

		// 26. Select $data from the Void_Reason list
		uiDriver.setValue("TC06_ViewAccountdisbApproved.lstVoid_Reason", input.get("Select@Void_Reason"));
		SleepUtils.sleep(3);
		uiDriver.sendKey("tab");
		SleepUtils.sleep(3);

		// 27. Click on void button
		uiDriver.click("TC06_ViewAccountdisbApproved.btnvoid");
		SleepUtils.sleep(1);

		// 28. Click Filter_by_Status_2
		uiDriver.click("TC06_ViewAccountdisbApproved.txtFilter_by_Status_2");
		SleepUtils.sleep(1);

		// 29. Select $data from the Filter_by_Status_2 list
		uiDriver.setValue("TC06_ViewAccountdisbApproved.lstFilter_by_Status_2", input.get("Select@Filter_by_Status_2"));
		SleepUtils.sleep(3);
		uiDriver.sendKey("tab");
		SleepUtils.sleep(3);

	}

	/**
	 * Overriding toString() method of object class to print
	 * US938_ViewAccountDisbursements format string
	 **/
	public String toString() {
		return "US938_ViewAccountDisbursementsDriver";
	}
}
