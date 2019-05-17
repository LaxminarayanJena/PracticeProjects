/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 3/8/2018 5:48:47 AM
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
public class DisbursmentunappliedbatchDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;

	public DisbursmentunappliedbatchDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}

	public void Disbursmentunappliedbatch(DataRow input, DataRow output) {
		// 1. Click on Account WebElement
		SleepUtils.sleep(10);
		uiDriver.click("Disbursmentunappliedbatch.eltAccount");
		SleepUtils.sleep(1);

		// 2. Type $data in Account_Name field
		uiDriver.setValue("Disbursmentunappliedbatch.txtAccount_Name", input.get("Type@Account_Name"));
		SleepUtils.sleep(1);

		// 3. Click on Search button
		uiDriver.click("Disbursmentunappliedbatch.btnSearch");
		SleepUtils.sleep(1);

		// 4. Verify whether the Account element present
		if (uiDriver.checkElementPresent("Disbursmentunappliedbatch.eltAccount")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(1);

		// 5. Click on Account Link
		uiDriver.click("Disbursmentunappliedbatch.lnkAccount_");
		SleepUtils.sleep(1);

		// 6. Click on Actions button
		uiDriver.click("Disbursmentunappliedbatch.btnActions");
		SleepUtils.sleep(1);

		// 7. Click on New_Transaction WebElement
		uiDriver.click("Disbursmentunappliedbatch.eltNew_Transaction");
		SleepUtils.sleep(1);

		// 8. Click on Disbursement WebElement
		uiDriver.click("Disbursmentunappliedbatch.eltDisbursement");
		SleepUtils.sleep(1);

		// 9. Type $data in Amount field
		uiDriver.setValue("Disbursmentunappliedbatch.txtAmount", input.get("Type@Amount"));
		SleepUtils.sleep(1);

		// 10. Click Reason_for_Disbursement
		uiDriver.click("Disbursmentunappliedbatch.txtReason_for_Disbursement");
		SleepUtils.sleep(1);

		// 11. Select $data from the Reason_for_Disbursement list
		uiDriver.setValue("Disbursmentunappliedbatch.lstReason_for_Disbursement",
				input.get("Select@Reason_for_Disbursement"));
		SleepUtils.sleep(1);

		// 12. Click on Next button
		uiDriver.click("Disbursmentunappliedbatch.btnNext");
		SleepUtils.sleep(1);

		// 13. Click on Finish button
		uiDriver.click("Disbursmentunappliedbatch.btnFinish");
		SleepUtils.sleep(1);

		// 14. Click on HotKeys
		uiDriver.HotKeys("T");
		SleepUtils.sleep(6);
		uiDriver.th.findRelativeCellAndClickSelectedCellInSubtext("Disbursmentunappliedbatch.tblProcess",
				"Disbursement", 0, "Disbursement", "RunStopDownload History", "Run");
		SleepUtils.sleep(10);

		// 15. Click on Actions button
		uiDriver.click("Disbursmentunappliedbatch.btnActions_1");
		SleepUtils.sleep(5);

		// 16. Click on Return to BillingCenter WebElement
		uiDriver.click("Disbursmentunappliedbatch.eltReturn to BillingCenter");
		SleepUtils.sleep(5);
	}

	/**
	 * Overriding toString() method of object class to print
	 * Disbursmentunappliedbatch format string
	 **/
	public String toString() {
		return "DisbursmentunappliedbatchDriver";
	}
}