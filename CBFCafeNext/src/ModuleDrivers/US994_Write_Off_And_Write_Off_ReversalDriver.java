/******************************************************************************
Created by : CapGemini Automation Team
Created\Updated on : 3/7/2018 1:45:34 AM
Module part of 'Guidewire_BillingCenter'
Module created using Cafenext Selenium Builder
******************************************************************************/
package ModuleDrivers;

import static cbf.engine.TestResultLogger.*;
import java.io.IOException;

import org.openqa.selenium.By;

import cbf.engine.TestResult.ResultType;
import cbf.harness.ParameterAccess;
import cbf.utils.DataRow;
import cbf.utils.SleepUtils;
import cbf.utils.SleepUtils.TimeSlab;
import cbfx.selenium.BaseWebModuleDriver;

/**
 * Extends BaseModuleDriver class and performs application specific operations
 */
public class US994_Write_Off_And_Write_Off_ReversalDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;

	public US994_Write_Off_And_Write_Off_ReversalDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}

	public void US994_Write_Off_Reversal(DataRow input, DataRow output) {

		// 1. Click on Actions WebElement
		uiDriver.click("US994_Write_Off_Reversal.eltActions");

		// 2. Click on New_Transactions WebElement
		uiDriver.mouseOver("US994_Write_Off_Reversal.eltNew_Transactions");
		SleepUtils.sleep(3);

		// 3. Click on Recharge_Fee WebElement
		uiDriver.click("US994_Write_Off_Reversal.eltRecharge_Fee");
		SleepUtils.sleep(3);

		// 4. Click on Next button
		uiDriver.click("US994_Write_Off_Reversal.btnNext");
		SleepUtils.sleep(2);

		// 5. Type $data in Amount field
		uiDriver.setValue("US994_Write_Off_Reversal.txtAmount", input.get("Type@Amount#1"));

		// 6. Click on Finish WebElement
		uiDriver.click("US994_Write_Off_Reversal.eltFinish");
		SleepUtils.sleep(3);

		// 7. Click on Actions WebElement
		uiDriver.click("US994_Write_Off_Reversal.eltActions");

		// 8. Click on New_Transactions WebElement
		uiDriver.mouseOver("US994_Write_Off_Reversal.eltNew_Transactions");
		SleepUtils.sleep(3);

		// 9. Click on Write_Off WebElement
		uiDriver.click("US994_Write_Off_Reversal.eltWrite_Off");
		SleepUtils.sleep(2);

		// 10. Click on Next button
		uiDriver.click("US994_Write_Off_Reversal.btnNext");

		// 11. Type $data in Amount_Acc field
		uiDriver.setValue("US994_Write_Off_Reversal.txtAmount_Acc", input.get("Type@Amount_Acc"));

		// 12. Select $data from the Reason_Acc list
		SleepUtils.sleep(2);
		uiDriver.setValue("US994_Write_Off_Reversal.lstReason_Acc", input.get("Select@Reason_Acc"));
		SleepUtils.sleep(2);
		uiDriver.sendKey("tab");
		SleepUtils.sleep(2);
		uiDriver.click("US994_Write_Off_Reversal.btnNext");
		SleepUtils.sleep(4);
		if (uiDriver.checkElementPresent("US994_Write_Off_Reversal.elReasonerrMsg")) {
			String Actual = uiDriver.getControl("US994_Write_Off_Reversal.elReasonerrMsg").getText();
			if (Actual.equalsIgnoreCase("Reason : Missing required field \"Reason\"")) {
				uiDriver.setValue("US994_Write_Off_Reversal.lstReason_Acc", input.get("Select@Reason_Acc"));
				SleepUtils.sleep(2);
				uiDriver.sendKey("tab");
				SleepUtils.sleep(2);
				uiDriver.click("US994_Write_Off_Reversal.btnNext");
			}
		}
		SleepUtils.sleep(4);

		// 13. Click on Finish button
		uiDriver.click("US994_Write_Off_Reversal.btnFinish");
		SleepUtils.sleep(10);

		// 14. Click on History WebElement
		uiDriver.click("US994_Write_Off_Reversal.eltHistory");
		SleepUtils.sleep(4);

		// 15. Select $data from the Filter_by_Date list
		uiDriver.setValue("US994_Write_Off_Reversal.lstFilter_by_Date", input.get("Select@Filter_by_Date"));
		SleepUtils.sleep(2);
		uiDriver.sendKey("tab");
		SleepUtils.sleep(2);

		// 16. Select $data from the Filter_by_Type list
		uiDriver.setValue("US994_Write_Off_Reversal.lstFilter_by_Type", input.get("Select@Filter_by_Type"));
		SleepUtils.sleep(2);
		uiDriver.sendKey("tab");
		SleepUtils.sleep(2);

		// 17. Verify the text ?$data in the Description field
		uiDriver.th.getCellDataOfCol("US994_Write_Off_Reversal.eltDescription", input.get("VerifyText@Description_Acc"),
				1);

		// 18. Click on Actions WebElement
		uiDriver.click("US994_Write_Off_Reversal.eltActions");

		// 19. Click on New_Transaction WebElement
		uiDriver.mouseOver("US994_Write_Off_Reversal.eltNew_Transaction");
		SleepUtils.sleep(3);

		// 20. Click on Write_off_Reversal WebElement
		uiDriver.click("US994_Write_Off_Reversal.eltWrite_off_Reversal");

		// 21. Click on Search_WR button
		uiDriver.click("US994_Write_Off_Reversal.btnSearch_WR");
		SleepUtils.sleep(10);

		// 22. Click on Select_WR button
		uiDriver.click("US994_Write_Off_Reversal.btnSelect_WR");
		SleepUtils.sleep(10);
		if (!uiDriver.checkElementPresent("US994_Write_Off_Reversal.lstReason_WR")) {
			if (uiDriver.checkElementPresent("US994_Write_Off_Reversal.btnSelect_WR")) {
				uiDriver.click("US994_Write_Off_Reversal.btnSelect_WR");
			}
		}

		// 23. Select $data from the Reason_WR list
		uiDriver.setValue("US994_Write_Off_Reversal.lstReason_WR", input.get("Select@Reason_WR"));
		SleepUtils.sleep(2);
		uiDriver.sendKey("tab");
		SleepUtils.sleep(2);

		// 24. Click on Finish button
		uiDriver.click("US994_Write_Off_Reversal.btnFinish");
		SleepUtils.sleep(6);

		// 25. Click on History WebElement
		uiDriver.click("US994_Write_Off_Reversal.eltHistory");
		SleepUtils.sleep(6);

		// 26. Select $data from the Filter_by_Date list
		uiDriver.setValue("US994_Write_Off_Reversal.lstFilter_by_Date", input.get("Select@Filter_by_Date"));
		SleepUtils.sleep(2);
		uiDriver.sendKey("tab");
		SleepUtils.sleep(4);

		// 27. Select $data from the Filter_by_Type list
		uiDriver.setValue("US994_Write_Off_Reversal.lstFilter_by_Type", input.get("Select@Filter_by_Type"));
		SleepUtils.sleep(2);
		uiDriver.sendKey("tab");
		SleepUtils.sleep(4);

		// 28. Verify the text ?$data in the Description field
		uiDriver.th.getCellDataOfCol("US994_Write_Off_Reversal.eltDescription",
				input.get("VerifyText@Description_AccRev"), 1);

	}

	public void Not_Have_WriteOff_Rever(DataRow input, DataRow output) {

		// 1. Click on Actions WebElement
		uiDriver.click("US994_Write_Off_Reversal.eltActions");

		// 2. Click on New_Transaction WebElement
		uiDriver.mouseOver("US994_Write_Off_Reversal.eltNew_Transaction");

		// 3. Click on Negative_Write_Off WebElement
		if (!uiDriver.checkElementPresent("Negative_Write_off_Rever_desk.eltNegative_Write_Off")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 4. Click on Negative_Write_Off_Reversal WebElement
		if (!uiDriver.checkElementPresent("Negative_Write_off_Rever_desk.eltNegative_Write_Off_Reversal")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

	}

	public void Write_off_Rever_desk(DataRow input, DataRow output) {
		// 1. Click on Desktop WebElement
		uiDriver.click("Write_off_Rever_desk.eltDesktop");

		// 2. Click on Actions WebElement
		uiDriver.click("Write_off_Rever_desk.eltActions");

		// 3. Click on New_Transactions WebElement
		uiDriver.mouseOver("Write_off_Rever_desk.eltNew_Transactions");
		SleepUtils.sleep(2);

		// 4. Click on Recharge_Fee WebElement
		uiDriver.click("Write_off_Rever_desk.eltRecharge_Fee");
		SleepUtils.sleep(4);

		// 5. Click on Account WebElement
		uiDriver.click("Write_off_Rever_desk.eltAccount");

		// 6. Type $data in Account_Name field
		uiDriver.setValue("Write_off_Rever_desk.txtAccount_Name", input.get("Type@Account_Name"));

		// 7. Click on Search button
		uiDriver.click("Write_off_Rever_desk.btnSearch");
		SleepUtils.sleep(2);

		// 8. Verify whether the Select button is present
		if (uiDriver.checkElementPresent("Write_off_Rever_desk.btnSelect")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 9. Click on Select button
		uiDriver.click("Write_off_Rever_desk.btnSelect");

		// 10. Type $data in Amount_ReFee field
		uiDriver.setValue("Write_off_Rever_desk.txtAmount_ReFee", input.get("Type@Amount_ReFee"));

		// 11. Click on Finish button
		uiDriver.click("Write_off_Rever_desk.btnFinish");
		SleepUtils.sleep(2);

		// 12. Click on Actions WebElement
		uiDriver.click("Write_off_Rever_desk.eltActions");

		// 13. Click on New_Transactions WebElement
		uiDriver.mouseOver("Write_off_Rever_desk.eltNew_Transactions");
		SleepUtils.sleep(2);

		// 14. Click on Write_Off WebElement
		uiDriver.click("Write_off_Rever_desk.eltWrite_Off");
		SleepUtils.sleep(5);

		// 15. Click on Account WebElement
		uiDriver.click("Write_off_Rever_desk.eltAccount1");

		// 16. Type $data in Account_Name field
		uiDriver.setValue("Write_off_Rever_desk.txtAccount_Name1", input.get("Type@Account_Name"));

		// 17. Click on Search button
		uiDriver.click("Write_off_Rever_desk.btnSearch1");
		SleepUtils.sleep(2);

		// 18. Verify whether the Select button is present
		if (uiDriver.checkElementPresent("Write_off_Rever_desk.btnSelect1")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 19. Click on Select button
		uiDriver.click("Write_off_Rever_desk.btnSelect1");
		SleepUtils.sleep(20);
		SleepUtils.sleep(8);

		// 20. Verify whether the Collections checkbox is present
		if (uiDriver.checkElementPresent("Write_off_Rever_desk.chkCollections")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 21. Verify whether the Collections checkbox is present
		uiDriver.click("Write_off_Rever_desk.chkCollections");
		SleepUtils.sleep(4);
		uiDriver.click("Write_off_Rever_desk.lstReason");
		SleepUtils.sleep(2);
		uiDriver.checkDropDownOptions("li", input.get("verfiy@optionsStr"));
		SleepUtils.sleep(2);
		uiDriver.sendKey("tab");
		SleepUtils.sleep(2);
		uiDriver.click("Write_off_Rever_desk.chkCollections");

		// 22. Type $data in Amount_ReFee2 field
		uiDriver.setValue("Write_off_Rever_desk.txtAmount_ReFee2", input.get("Type@Amount_ReFee2"));

		// 23. Select $data from the Reason list
		uiDriver.click("Write_off_Rever_desk.lstReason");
		SleepUtils.sleep(2);
		uiDriver.setValue("Write_off_Rever_desk.lstReason", input.get("Select@Reason"));
		SleepUtils.sleep(2);
		uiDriver.sendKey("tab");
		SleepUtils.sleep(3);

		// 24. Click on Next button
		uiDriver.click("Write_off_Rever_desk.btnNext");
		SleepUtils.sleep(6);

		// 25. Click on Finish button
		uiDriver.click("Write_off_Rever_desk.btnFinish");
		SleepUtils.sleep(6);

		// 26. Click on Actions WebElement
		uiDriver.click("Write_off_Rever_desk.eltActions");
		SleepUtils.sleep(6);

		// 27. Click on New_Transactions WebElement
		uiDriver.mouseOver("Write_off_Rever_desk.eltNew_Transactions");
		SleepUtils.sleep(2);

		// 28. Click on Write_Off_Reversal WebElement
		uiDriver.click("Write_off_Rever_desk.eltWrite_Off_Reversal");
		SleepUtils.sleep(6);

		// 29. Verify the text ?$data in the Desk_Wirte_off_reversal field
		if (uiDriver.verifyTextActAndExp("Write_off_Rever_desk.eltDesk_Wirte_off_reversal",
				input.get("VerifyText@Desk_Wirte_off_reversal"))) {
			passed("verifyText", "verifyText should pass", "verifyText passed");
		} else {
			failed("verifyText", "verifyText should pass", "verifyText failed");
		}

		// 30. Click on Search_Write_off_reversal button
		uiDriver.click("Write_off_Rever_desk.btnSearch_Write_off_reversal");
		SleepUtils.sleep(3);

		// 31. Verify the text ?$data in the Search_Write_off_reversal2 field
		if (uiDriver.verifyTextActAndExp("Write_off_Rever_desk.eltSearch_Write_off_reversal2",
				input.get("VerifyText@Search_Write_off_reversal2"))) {
			passed("verifyText", "verifyText should pass", "verifyText passed");
		} else {
			failed("verifyText", "verifyText should pass", "verifyText failed");
		}

		// 32. Click on Collections_WR WebElement
		uiDriver.click("Write_off_Rever_desk.eltCollections_WR");

		// 33. Verify Reason
		uiDriver.click("Write_off_Rever_desk.lstReason");
		SleepUtils.sleep(2);
		uiDriver.checkDropDownOptions("li", input.get("verfiy@optionsStr"));
		SleepUtils.sleep(2);
		uiDriver.sendKey("tab");
		SleepUtils.sleep(2);
		uiDriver.click("Write_off_Rever_desk.eltCollections_WR");
		SleepUtils.sleep(2);

		// 34. Click on Acc_Image image
		uiDriver.click("Write_off_Rever_desk.imgAcc_Image");
		SleepUtils.sleep(2);

		// 35. Type $data in Account_Name field
		uiDriver.setValue("Write_off_Rever_desk.txtAccount_Name3", input.get("Type@Account_Name"));

		// 36. Click on Search_WR button
		uiDriver.click("Write_off_Rever_desk.btnSearch_WR");
		SleepUtils.sleep(2);

		// 37. Verify whether the Select button is present
		if (uiDriver.checkElementPresent("Write_off_Rever_desk.btnSelect2")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 38. Click on Select button
		uiDriver.click("Write_off_Rever_desk.btnSelect2");
		SleepUtils.sleep(3);

		// 39. Click on Search_WR2 button
		uiDriver.click("Write_off_Rever_desk.btnSearch_WR2");
		SleepUtils.sleep(2);

		// 40. Click on Select_WR2 button
		uiDriver.click("Write_off_Rever_desk.btnSelect_WR2");
		SleepUtils.sleep(2);

		// 41. Select $data from the Reason_WR list
		uiDriver.click("Write_off_Rever_desk.lstReason_WR");
		SleepUtils.sleep(2);
		uiDriver.setValue("Write_off_Rever_desk.lstReason_WR", input.get("Select@Reason_WR"));
		SleepUtils.sleep(2);
		uiDriver.sendKey("tab");
		SleepUtils.sleep(2);

		// 42. Click on Finish button
		uiDriver.click("Write_off_Rever_desk.btnFinish");
		SleepUtils.sleep(6);

		// 43. Click on Account_tab WebElement
		uiDriver.click("Account_Search.eltAccount");
		SleepUtils.sleep(5);

		// 44. Click on Account_tab WebElement
		uiDriver.click("Account_Search.txtAccount");
		SleepUtils.sleep(4);

		// 45. Type Account_Name $Parama1
		uiDriver.setValue("Account_Search.txtAccountName", input.get("Type@Account_Name"));

		// 46. Click on Search button
		uiDriver.click("Account_Search.btnSearch");
		SleepUtils.sleep(5);

		// 47. Select the account
		uiDriver.click("Account_Search.lnkAccount");
		SleepUtils.sleep(4);

		// 48. Click on History WebElement
		uiDriver.click("Write_off_Rever_desk.eltHistory");
		SleepUtils.sleep(4);

		// 49. Select $data from the Filter_by_Date list
		uiDriver.click("Write_off_Rever_desk.lstFilter_by_Date");
		SleepUtils.sleep(2);
		uiDriver.setValue("Write_off_Rever_desk.lstFilter_by_Date", input.get("Select@Filter_by_Date"));
		SleepUtils.sleep(2);
		uiDriver.sendKey("tab");
		SleepUtils.sleep(2);

		// 50. Select $data from the Filter_by_Type list
		uiDriver.click("Write_off_Rever_desk.lstFilter_by_Type");
		SleepUtils.sleep(2);
		uiDriver.setValue("Write_off_Rever_desk.lstFilter_by_Type", input.get("Select@Filter_by_Type"));
		SleepUtils.sleep(2);
		uiDriver.sendKey("tab");
		SleepUtils.sleep(2);

		// 51. Verify Description
		uiDriver.th.getCellDataOfCol("Write_off_Rever_desk.eltDescription", input.get("VerifyText@Description_DW"), 1);

		// 52. Verify Description
		uiDriver.th.getCellDataOfCol("Write_off_Rever_desk.eltDescription", input.get("VerifyText@Description_DWR"), 1);

	}

	public void Write_off_Rever_Alert_Msg(DataRow input, DataRow output) {

		// 1. Click on Desktop WebElement
		uiDriver.click("Write_off_Rever_desk.eltDesktop");

		// 2. Click on Actions WebElement
		uiDriver.click("Write_off_Rever_desk.eltActions");

		// 3. Click on New_Transactions WebElement
		uiDriver.mouseOver("Write_off_Rever_desk.eltNew_Transactions");
		SleepUtils.sleep(2);

		// 4. Click on Write_Off WebElement
		uiDriver.click("Write_off_Rever_desk.eltWrite_Off");
		SleepUtils.sleep(5);

		// 5. Click on Account WebElement
		uiDriver.click("Write_off_Rever_desk.eltAccount1");

		// 6. Type $data in Account_Name field
		uiDriver.setValue("Write_off_Rever_desk.txtAccount_Name1", input.get("Type@Account_Name"));

		// 7. Click on Search button
		uiDriver.click("Write_off_Rever_desk.btnSearch1");
		SleepUtils.sleep(10);

		// 8. Verify whether the Select button is present
		if (uiDriver.checkElementPresent("Write_off_Rever_desk.btnSelect1")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 9. Click on Select button
		uiDriver.click("Write_off_Rever_desk.btnSelect1");
		SleepUtils.sleep(20);

		// 10. Type $data in Amount_ReFee2 field
		uiDriver.setValue("Write_off_Rever_desk.txtAmount_ReFee2", input.get("Type@Amount_ReFee2"));

		// 11. Select $data from the Reason list
		uiDriver.click("Write_off_Rever_desk.lstReason");
		SleepUtils.sleep(2);
		uiDriver.setValue("Write_off_Rever_desk.lstReason", input.get("Select@Reason"));
		SleepUtils.sleep(2);
		uiDriver.sendKey("tab");
		SleepUtils.sleep(2);

		// 12. Click on Next button
		uiDriver.click("Write_off_Rever_desk.btnNext");
		SleepUtils.sleep(2);

		// 13. Click on Finish button
		if (uiDriver.verifyTextActAndExp("Write_off_Rever_desk.eltWriteoffAlertMsg",
				input.get("VerifyText@AlertMsg"))) {
			passed("verifyText", "verifyText should pass", "verifyText passed");
		} else {
			failed("verifyText", "verifyText should pass", "verifyText failed");
		}

	}

	/**
	 * Overriding toString() method of object class to print
	 * US994_Write_Off_And_Write_Off_Reversal format string
	 **/
	public String toString() {
		return "US994_Write_Off_And_Write_Off_ReversalDriver";
	}
}