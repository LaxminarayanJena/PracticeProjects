/******************************************************************************
Created by : Capgemini Automation team
Created\Updated on : 3/7/2018 1:34:07 AM
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
public class US1081_IssueandReverseAdHocCreditDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;

	public US1081_IssueandReverseAdHocCreditDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}

	public void TC01_IssueandRevers_Adhoc(DataRow input, DataRow output) {
		// 1. Click on Account WebElement
		uiDriver.click("TC01_IssueandRevers_Adhoc.eltAccount");
		SleepUtils.sleep(4);

		// 2. Type $data in Account_Name field
		uiDriver.setValue("TC01_IssueandRevers_Adhoc.txtAccount_Name", input.get("Type@Account_Name"));
		SleepUtils.sleep(4);

		// 3. Click on Search button
		uiDriver.click("TC01_IssueandRevers_Adhoc.btnSearch");
		SleepUtils.sleep(4);

		// 4. Verify whether the Account link is present
		if (uiDriver.checkElementPresent("TC01_IssueandRevers_Adhoc.lnkAccount")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		
		// 5. Click on Account_ Link
		SleepUtils.sleep(4);
		uiDriver.click("TC01_IssueandRevers_Adhoc.lnkAccount_");
		SleepUtils.sleep(4);

		// 6. Click on Actions button
		uiDriver.click("TC01_IssueandRevers_Adhoc.btnActions");
		SleepUtils.sleep(4);

		// 7. Click on New_Transaction WebElement
		uiDriver.click("TC01_IssueandRevers_Adhoc.eltNew_Transaction");
		SleepUtils.sleep(4);

		// 8. Click on Credit WebElement
		uiDriver.click("TC01_IssueandRevers_Adhoc.eltCredit");
		SleepUtils.sleep(4);

		// 9. Click Credit_Type
		uiDriver.click("TC01_IssueandRevers_Adhoc.txtCredit_Type");
		SleepUtils.sleep(4);

		// 10. Select $data from the Credit_Type list
		uiDriver.setValue("TC01_IssueandRevers_Adhoc.lstCredit_Type", input.get("Select@Credit_Type"));
		uiDriver.sendKey("tab");
		SleepUtils.sleep(4);

		// 11. Type $data in Amount field
		uiDriver.setValue("TC01_IssueandRevers_Adhoc.txtAmount", input.get("Type@Amount"));
		SleepUtils.sleep(4);

		// 12. Click on Next button
		uiDriver.click("TC01_IssueandRevers_Adhoc.btnNext");
		SleepUtils.sleep(4);

		// 13. Click on Finish button
		uiDriver.click("TC01_IssueandRevers_Adhoc.btnFinish");
		SleepUtils.sleep(4);

		// 14. Click on History WebElement
		uiDriver.click("TC01_IssueandRevers_Adhoc.eltHistory");
		SleepUtils.sleep(4);

		// 15. Click Filter_by_Type
		uiDriver.click("TC01_IssueandRevers_Adhoc.txtFilter_by_Type");
		SleepUtils.sleep(3);

		// 16. Select $data from the Filter_by_Type list
		uiDriver.setValue("TC01_IssueandRevers_Adhoc.lstFilter_by_Type", input.get("Select@Filter_by_Type"));
		SleepUtils.sleep(3);

		// 17. Click on Actions_1 button
		uiDriver.click("TC01_IssueandRevers_Adhoc.btnActions_1");
		SleepUtils.sleep(4);

		// 18. Click on New_Transaction_1 WebElement
		uiDriver.click("TC01_IssueandRevers_Adhoc.eltNew_Transaction_1");
		SleepUtils.sleep(2);

		// 19. Click on Credit_Reversal WebElement
		uiDriver.click("TC01_IssueandRevers_Adhoc.eltCredit_Reversal");
		SleepUtils.sleep(4);

		// 20. Click Reason
		uiDriver.click("TC01_IssueandRevers_Adhoc.txtReason");
		SleepUtils.sleep(4);

		// 21. Select $data from the Reason list
		uiDriver.setValue("TC01_IssueandRevers_Adhoc.lstReason", input.get("Select@Reason"));
		SleepUtils.sleep(4);

		// 22. Click on Search button
		uiDriver.click("TC01_IssueandRevers_Adhoc.btnSearch_1");
		SleepUtils.sleep(10);

		// 23. Click on Select button
		uiDriver.th.findRelativeCellAndClickSelectedCell("TC01_IssueandRevers_Adhoc.tblcreditreversal", "Collections",
				3, "Collections", "Select");
		// uiDriver.click("TC01_IssueandRevers_Adhoc.btnSelect");
		SleepUtils.sleep(8);

		// 24. Click on Finish_1 button
		uiDriver.click("TC01_IssueandRevers_Adhoc.btnFinish_1");
		SleepUtils.sleep(4);

		// 25. Click on History_1 WebElement
		uiDriver.click("TC01_IssueandRevers_Adhoc.eltHistory_1");
		SleepUtils.sleep(4);

		// 26. Click Filter_by_Type_1
		uiDriver.click("TC01_IssueandRevers_Adhoc.txtFilter_by_Type_1");
		SleepUtils.sleep(3);

		// 27. Select $data from the Filter_by_Type_1 list
		uiDriver.setValue("TC01_IssueandRevers_Adhoc.lstFilter_by_Type_1", input.get("Select@Filter_by_Type_1"));
		SleepUtils.sleep(3);
	}

	public void TC01_IssueandRevers_ITAdmin(DataRow input, DataRow output) {
		// 1. Click on Account WebElement
		uiDriver.click("TC01_IssueandRevers_ITAdmin.eltAccount");
		SleepUtils.sleep(4);

		// 2. Type $data in Account_Name field
		uiDriver.setValue("TC01_IssueandRevers_ITAdmin.txtAccount_Name", input.get("Type@Account_Name"));
		SleepUtils.sleep(4);

		// 3. Click on Search button
		uiDriver.click("TC01_IssueandRevers_ITAdmin.btnSearch");
		SleepUtils.sleep(4);

		// 4. Verify whether the Account link is present
		if (uiDriver.checkElementPresent("TC01_IssueandRevers_ITAdmin.lnkAccount")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		
		// 5. Click on Account_ Link
		uiDriver.click("TC01_IssueandRevers_ITAdmin.lnkAccount_");
		SleepUtils.sleep(8);

		// 6. Click on Actions button
		uiDriver.click("TC01_IssueandRevers_ITAdmin.btnActions");
		SleepUtils.sleep(4);

		// 7. Click on New_Transaction WebElement
		uiDriver.mouseOver("TC01_IssueandRevers_ITAdmin.eltNew_Transaction");
		SleepUtils.sleep(8);

		// 8. Verify whether the Credit element present
		if (uiDriver.checkElementPresent("TC01_IssueandRevers_ITAdmin.eltCredit")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");

		}
		SleepUtils.sleep(4);

	}

	public void TC03_IssueandReverseAdhoc(DataRow input, DataRow output) {
		// 1. Click on Account WebElement
		uiDriver.click("TC03_IssueandReverseAdhoc.eltAccount");
		SleepUtils.sleep(4);

		// 2. Type $data in Account_Name field
		uiDriver.setValue("TC03_IssueandReverseAdhoc.txtAccount_Name", input.get("Type@Account_Name"));
		SleepUtils.sleep(4);

		// 3. Click on Search button
		uiDriver.click("TC03_IssueandReverseAdhoc.btnSearch");
		SleepUtils.sleep(4);

		// 4. Verify whether the Account link is present
		if (uiDriver.checkElementPresent("TC03_IssueandReverseAdhoc.lnkAccount")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		
		// 5. Click on Account_ Link
		SleepUtils.sleep(4);
		uiDriver.click("TC03_IssueandReverseAdhoc.lnkAccount_");
		SleepUtils.sleep(4);

		// 6. Click on Actions button
		uiDriver.click("TC03_IssueandReverseAdhoc.btnActions");
		SleepUtils.sleep(4);

		// 7. Click on New_Transaction WebElement
		uiDriver.click("TC03_IssueandReverseAdhoc.eltNew_Transaction");
		SleepUtils.sleep(4);

		// 8. Click on Credit WebElement
		uiDriver.click("TC03_IssueandReverseAdhoc.eltCredit");
		SleepUtils.sleep(4);

		// 9. Click Credit_Type
		uiDriver.click("TC03_IssueandReverseAdhoc.txtCredit_Type");
		SleepUtils.sleep(4);

		// 10. Type $data in Amount field
		uiDriver.setValue("TC01_IssueandRevers_Adhoc.txtAmount", input.get("Type@Amount"));
		SleepUtils.sleep(4);

		// 11. Verify whether the Other element present
		if (uiDriver.checkElementPresent("TC03_IssueandReverseAdhoc.eltOther")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(4);

		// 12. Select $data from the Credit_Type list
		uiDriver.setValue("TC03_IssueandReverseAdhoc.lstCredit_Type", input.get("Select@Credit_Type"));
		SleepUtils.sleep(4);

		// 13. Click on Next button
		uiDriver.click("TC03_IssueandReverseAdhoc.btnNext");
		SleepUtils.sleep(4);

		// 14. Click on Finish button
		uiDriver.click("TC03_IssueandReverseAdhoc.btnFinish");
		SleepUtils.sleep(4);

		// 15. Click on Actions_1 button
		uiDriver.click("TC03_IssueandReverseAdhoc.btnActions_1");
		SleepUtils.sleep(4);

		// 16. Click on New_Transaction_1 WebElement
		uiDriver.click("TC03_IssueandReverseAdhoc.eltNew_Transaction_1");
		SleepUtils.sleep(4);

		// 17. Click on Credit_Reversal WebElement
		uiDriver.click("TC03_IssueandReverseAdhoc.eltCredit_Reversal");
		SleepUtils.sleep(4);

		// 18. Click Reason
		uiDriver.click("TC03_IssueandReverseAdhoc.txtReason");
		SleepUtils.sleep(4);

		// 19. Verify whether the Other field is present
		if (uiDriver.checkElementPresent("TC03_IssueandReverseAdhoc.txtOther")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(4);

		// 20. Select $data from the Reason list
		uiDriver.setValue("TC03_IssueandReverseAdhoc.lstReason", input.get("Select@Reason"));
		SleepUtils.sleep(4);

		// 21. Verify whether the Account_ element present
		if (uiDriver.checkElementPresent("TC03_IssueandReverseAdhoc.eltAccount_")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		
		// 22. Click on Search_1 button
		SleepUtils.sleep(4);
		uiDriver.click("TC03_IssueandReverseAdhoc.btnSearch_1");
		SleepUtils.sleep(4);

		// 23. Click on Select button
		uiDriver.th.findRelativeCellAndClickSelectedCell("TC01_IssueandRevers_Adhoc.tblcreditreversal", "Collections",
				3, "Collections", "Select");

		// 24. Click on Finish_1 button
		uiDriver.click("TC03_IssueandReverseAdhoc.btnFinish_1");
		SleepUtils.sleep(4);
	}

	public void TC04_Credit_ReversalHistoryeve(DataRow input, DataRow output) {
		// 1. Click on Account WebElement
		uiDriver.click("TC04_Credit_ReversalHistoryeve.eltAccount");
		SleepUtils.sleep(4);

		// 2. Type $data in Account_Name field
		uiDriver.setValue("TC04_Credit_ReversalHistoryeve.txtAccount_Name", input.get("Type@Account_Name"));
		SleepUtils.sleep(4);

		// 3. Click on Search button
		uiDriver.click("TC04_Credit_ReversalHistoryeve.btnSearch");
		SleepUtils.sleep(4);

		// 4. Verify whether the Account link is present
		if (uiDriver.checkElementPresent("TC04_Credit_ReversalHistoryeve.lnkAccount")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		
		// 5. Click on Account_ Link
		SleepUtils.sleep(4);
		uiDriver.click("TC04_Credit_ReversalHistoryeve.lnkAccount_");
		SleepUtils.sleep(4);

		// 6. Click on Actions button
		uiDriver.click("TC04_Credit_ReversalHistoryeve.btnActions");
		SleepUtils.sleep(4);

		// 7. Click on New_Transaction WebElement
		uiDriver.click("TC04_Credit_ReversalHistoryeve.eltNew_Transaction");
		SleepUtils.sleep(4);

		// 8. Click on Credit_Reversal WebElement
		uiDriver.click("TC04_Credit_ReversalHistoryeve.eltCredit_Reversal");
		SleepUtils.sleep(4);

		// 9. Click on Reason WebElement
		uiDriver.click("TC04_Credit_ReversalHistoryeve.eltReason");
		SleepUtils.sleep(4);

		// 10. Select $data from the Reason list
		uiDriver.setValue("TC04_Credit_ReversalHistoryeve.lstReason", input.get("Select@Reason"));
		SleepUtils.sleep(4);

		// 11. Click on Search_1 button
		uiDriver.click("TC04_Credit_ReversalHistoryeve.btnSearch_1");
		SleepUtils.sleep(4);

		// 12. Click on Select button
		uiDriver.th.findRelativeCellAndClickSelectedCell("TC01_IssueandRevers_Adhoc.tblcreditreversal", "Goodwill", 3,
				"Goodwill", "Select");
		SleepUtils.sleep(4);

		// 13. Click on Finish button
		uiDriver.click("TC04_Credit_ReversalHistoryeve.btnFinish");
		SleepUtils.sleep(4);

		// 14. Click on History WebElement
		uiDriver.click("TC04_Credit_ReversalHistoryeve.eltHistory");
		SleepUtils.sleep(4);

		// 15. Click Filter_by_Type
		uiDriver.click("TC04_Credit_ReversalHistoryeve.txtFilter_by_Type");
		SleepUtils.sleep(3);

		// 16. Select $data from the Filter_by_Type list
		uiDriver.setValue("TC04_Credit_ReversalHistoryeve.lstFilter_by_Type", input.get("Select@Filter_by_Type"));
		SleepUtils.sleep(3);
	}

	public void TC05_CreditHisEvent(DataRow input, DataRow output) {
		// 1. Click on Account WebElement
		uiDriver.click("TC05_CreditHisEvent.eltAccount");
		SleepUtils.sleep(4);

		// 2. Type $data in Account_Name field
		uiDriver.setValue("TC05_CreditHisEvent.txtAccount_Name", input.get("Type@Account_Name"));
		SleepUtils.sleep(4);

		// 3. Click on Search button
		uiDriver.click("TC05_CreditHisEvent.btnSearch");
		SleepUtils.sleep(4);

		// 4. Verify whether the Account link is present
		if (uiDriver.checkElementPresent("TC05_CreditHisEvent.lnkAccount")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(4);

		// 5. Click on Account_ Link
		uiDriver.click("TC05_CreditHisEvent.lnkAccount_");
		SleepUtils.sleep(4);

		// 6. Click on Actions button
		uiDriver.click("TC05_CreditHisEvent.btnActions");
		SleepUtils.sleep(4);

		// 7. Click on New_Transaction WebElement
		uiDriver.click("TC05_CreditHisEvent.eltNew_Transaction");
		SleepUtils.sleep(4);

		// 8. Click on Credit WebElement
		uiDriver.click("TC05_CreditHisEvent.eltCredit");
		SleepUtils.sleep(4);
		
		// 9. Click Credit_Type
		uiDriver.click("TC05_CreditHisEvent.txtCredit_Type");
		SleepUtils.sleep(4);

		// 10. Select $data from the Credit_Type list
		uiDriver.setValue("TC05_CreditHisEvent.lstCredit_Type", input.get("Select@Credit_Type"));
		uiDriver.sendKey("tab");
		SleepUtils.sleep(2);

		// 11. Type $data in Amount field
		uiDriver.setValue("TC05_CreditHisEvent.txtAmount", input.get("Type@Amount"));
		SleepUtils.sleep(4);

		// 12. Click on Next button
		uiDriver.click("TC05_CreditHisEvent.btnNext");
		SleepUtils.sleep(4);

		// 13. Click on Finish button
		uiDriver.click("TC05_CreditHisEvent.btnFinish");
		SleepUtils.sleep(4);

		// 14. Click on History WebElement
		uiDriver.click("TC05_CreditHisEvent.eltHistory");
		SleepUtils.sleep(4);

		// 15. Click Filter_by_Type
		uiDriver.click("TC05_CreditHisEvent.txtFilter_by_Type");
		SleepUtils.sleep(3);

		// 16. Select $data from the Filter_by_Type list
		uiDriver.setValue("TC05_CreditHisEvent.lstFilter_by_Type", input.get("Select@Filter_by_Type"));
		SleepUtils.sleep(3);
	}

	/**
	 * Overriding toString() method of object class to print
	 * US1081_IssueandReverseAdHocCredit format string
	 **/
	public String toString() {
		return "US1081_IssueandReverseAdHocCreditDriver";
	}
}
