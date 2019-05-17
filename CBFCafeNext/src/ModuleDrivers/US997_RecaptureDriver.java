/******************************************************************************
Created by : Capgemini Automation team
Created\Updated on : 3/8/2018 8:49:04 AM
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
public class US997_RecaptureDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;

	public US997_RecaptureDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}

	public void TC01_Verifythepermissiontocre(DataRow input, DataRow output) {
		// 1. Click on Account WebElement
		uiDriver.click("TC01_Verifythepermissiontocre.eltAccount");
		SleepUtils.sleep(1);

		// 2. Type $data in Account_Name field
		uiDriver.setValue("TC01_Verifythepermissiontocre.txtAccount_Name", input.get("Type@Account_Name"));
		SleepUtils.sleep(1);

		// 3. Click on Search button
		uiDriver.click("TC01_Verifythepermissiontocre.btnSearch");
		SleepUtils.sleep(1);

		// 4. Verify whether the Account link is present
		if (uiDriver.checkElementPresent("TC01_Verifythepermissiontocre.lnkAccount")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 5. Click on Account_ Link
		SleepUtils.sleep(1);
		uiDriver.click("TC01_Verifythepermissiontocre.lnkAccount_");
		SleepUtils.sleep(5);

		// 6. Click on Payments WebElement
		uiDriver.click("TC01_Verifythepermissiontocre.eltPayments");
		SleepUtils.sleep(5);
		uiDriver.setValue("TC02ModifyDistribution.lstPaymentReceived", "All");
		SleepUtils.sleep(3);
		uiDriver.sendKey("tab");
		SleepUtils.sleep(3);

		// 7. Click on Actions button
		SleepUtils.sleep(3);
		uiDriver.th.findRelativeCellAndClickSelectedCellInSubtext("TC01_Verifythepermissiontocre.tblId", "ACH", 3,
				"ACH", "Actions", "Actions");
		SleepUtils.sleep(3);

		// 8. Click on Reverse WebElement
		uiDriver.click("TC01_Verifythepermissiontocre.eltReverse");
		SleepUtils.sleep(2);

		// 9. Click Reason
		uiDriver.click("TC01_Verifythepermissiontocre.txtReason");
		SleepUtils.sleep(1);

		// 10. Select $data from the Reason list
		uiDriver.setValue("TC01_Verifythepermissiontocre.lstReason", input.get("Select@Reason"));
		SleepUtils.sleep(3);
		uiDriver.sendKey("tab");
		SleepUtils.sleep(3);

		// 11. Click on Ok button
		uiDriver.click("TC01_Verifythepermissiontocre.btnOk");
		SleepUtils.sleep(1);

		// 12. Click on Actions button
		uiDriver.click("TC01_Verifythepermissiontocre.btnActions");
		SleepUtils.sleep(1);

		// 13. Click on New_Transaction WebElement
		uiDriver.click("TC01_Verifythepermissiontocre.eltNew_Transaction");
		SleepUtils.sleep(2);

		// 14. Click on Recapture WebElement
		uiDriver.click("TC01_Verifythepermissiontocre.eltRecapture");
		SleepUtils.sleep(1);

		// 15. Type $data in Amount field
		uiDriver.setValue("TC01_Verifythepermissiontocre.txtAmount", input.get("Type@Amount"));
		SleepUtils.sleep(1);

		// 16. Click Reason_1
		uiDriver.click("TC01_Verifythepermissiontocre.txtReason_1");
		SleepUtils.sleep(1);

		// 17. Select $data from the Reason_1 list
		uiDriver.setValue("TC01_Verifythepermissiontocre.lstReason_1", input.get("Select@Reason_1"));
		SleepUtils.sleep(3);
		
		// 18. Click on Finish button
		SleepUtils.sleep(3);
		uiDriver.click("TC01_Verifythepermissiontocre.btnFinish");
		SleepUtils.sleep(6);
				
		// 19. Verify the text ?$data in the Warning_message field
		if (uiDriver.checkElementPresent("TC01_Verifythepermissiontocre.lnkWarning_message")) {
			passed("verifyText", "verifyText should pass", "verifyText passed");
		} else {
			failed("verifyText", "verifyText should pass", "verifyText failed");
		}
		
		// 20. Click on Cancel button
		uiDriver.click("TC03_NewRecapturetransactionui.btnCancel");
		SleepUtils.sleep(4);
		uiDriver.mouseOver("TC01_Validate_Newly_Added_Feat.btnOK");
		SleepUtils.sleep(4);
		uiDriver.click("TC01_Validate_Newly_Added_Feat.btnOK");
		SleepUtils.sleep(4);
		
		// 21. Click on History WebElement
		uiDriver.click("TC01_Verifythepermissiontocre.eltHistory");
		SleepUtils.sleep(4);

		// 22. Click Filter_by_Type
		uiDriver.click("TC01_Verifythepermissiontocre.txtFilter_by_Type");
		SleepUtils.sleep(4);

		// 23. Select $data from the Filter_by_Type list
		uiDriver.setValue("TC01_Verifythepermissiontocre.lstFilter_by_Type", input.get("Select@Filter_by_Type"));
		SleepUtils.sleep(3);
		uiDriver.sendKey("enter");
		SleepUtils.sleep(3);

	}

	public void TC03_NewRecapturetransactionui(DataRow input, DataRow output) {
		// 1. Click on Account WebElement
		uiDriver.click("TC03_NewRecapturetransactionui.eltAccount");
		SleepUtils.sleep(1);

		// 2. Type $data in Account_Name field
		uiDriver.setValue("TC03_NewRecapturetransactionui.txtAccount_Name", input.get("Type@Account_Name"));
		SleepUtils.sleep(1);

		// 3. Click on Search button
		uiDriver.click("TC03_NewRecapturetransactionui.btnSearch");
		SleepUtils.sleep(1);

		// 4. Verify whether the Account link is present
		if (uiDriver.checkElementPresent("TC03_NewRecapturetransactionui.lnkAccount")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		
		// 5. Click on Account_ Link
		SleepUtils.sleep(1);
		uiDriver.click("TC03_NewRecapturetransactionui.lnkAccount_");
		SleepUtils.sleep(1);

		// 6. Click on Actions button
		uiDriver.click("TC03_NewRecapturetransactionui.btnActions");
		SleepUtils.sleep(1);

		// 7. Click on New_Transaction WebElement
		uiDriver.mouseOver("TC03_NewRecapturetransactionui.eltNew_Transaction");
		SleepUtils.sleep(1);

		// 8. Click on Recapture WebElement
		uiDriver.click("TC03_NewRecapturetransactionui.eltRecapture");
		SleepUtils.sleep(3);

		// 9. Type $data in Amount field
		uiDriver.setValue("TC03_NewRecapturetransactionui.txtAmount", input.get("Type@Amount"));
		SleepUtils.sleep(3);

		// 14. Click Reason_1
		uiDriver.click("TC03_NewRecapturetransactionui.txtReason");
		SleepUtils.sleep(2);

		// 15. Select $data from the Reason_1 list
		uiDriver.setValue("TC03_NewRecapturetransactionui.lstReason", input.get("Select@Reason_1"));
		SleepUtils.sleep(3);
		uiDriver.sendKey("tab");
		SleepUtils.sleep(3);

		// 16.Click on Finish Web Button
		uiDriver.click("TC03_NewRecapturetransactionui.btnFinish");
		SleepUtils.sleep(1);

		// 17. Verify whether the Alertmessage link is present
		if (uiDriver.checkElementPresent("TC03_NewRecapturetransactionui.lnkAlertmessage")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		
		// 18. Type $data in Amount_1 field
		SleepUtils.sleep(1);
		uiDriver.setValue("TC03_NewRecapturetransactionui.txtAmount_1", input.get("Type@Amount_1"));
		SleepUtils.sleep(3);

		// 19. Click Reason_1
		uiDriver.click("TC03_NewRecapturetransactionui.txtReason_1");
		SleepUtils.sleep(2);

		// 20. Select $data from the Reason_1 list
		uiDriver.setValue("TC03_NewRecapturetransactionui.lstReason_1", input.get("Select@Reason_2"));
		SleepUtils.sleep(3);
		uiDriver.sendKey("enter");
		SleepUtils.sleep(3);

		// 21.Click on Finish Web Button
		uiDriver.click("TC03_NewRecapturetransactionui.btnFinish_1");
		SleepUtils.sleep(6);

		// 22. Verify whether the Alertmessage_1 link is present
		if (uiDriver.checkElementPresent("TC03_NewRecapturetransactionui.lnkAlertmessage_1")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		
		// 23. Click on Cancel button
		SleepUtils.sleep(1);
		uiDriver.click("TC03_NewRecapturetransactionui.btnCancel");
		SleepUtils.sleep(1);
		uiDriver.mouseOver("TC01_Validate_Newly_Added_Feat.btnOK");
		SleepUtils.sleep(4);
		uiDriver.click("TC01_Validate_Newly_Added_Feat.btnOK");
		SleepUtils.sleep(4);
	}

	/**
	 * Overriding toString() method of object class to print US997_Recapture format
	 * string
	 **/
	public String toString() {
		return "US997_RecaptureDriver";
	}
}