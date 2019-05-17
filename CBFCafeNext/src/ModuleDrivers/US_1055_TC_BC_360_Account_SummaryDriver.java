/******************************************************************************
Created by : CapGemini Automation Team
Created\Updated on : 2/23/2018 12:51:41 AM
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
public class US_1055_TC_BC_360_Account_SummaryDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;

	public US_1055_TC_BC_360_Account_SummaryDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}

	public void Account_WriteOff_UI_Fields(DataRow input, DataRow output) {
		// 1. Click on Actions WebElement
		uiDriver.click("Account_WriteOff_UI_Fields.eltActions");

		// 2. Click on New_Transaction WebElement
		uiDriver.mouseOver("Account_WriteOff_UI_Fields.eltNew_Transaction");

		// 3. Click on Recharge_Fee WebElement
		SleepUtils.sleep(3);
		uiDriver.click("Account_WriteOff_UI_Fields.eltRecharge_Fee");

		// 4. Click on Recharge_Next button
		SleepUtils.sleep(2);
		uiDriver.click("Account_WriteOff_UI_Fields.btnRecharge_Next");

		// 5. Type $data in Amount field
		uiDriver.setValue("Account_WriteOff_UI_Fields.txtAmount", input.get("Type@Amount#1"));

		// 6. Click on Finish WebElement
		uiDriver.click("Account_WriteOff_UI_Fields.eltFinish");

		// 7. Click on Actions WebElement
		SleepUtils.sleep(3);
		uiDriver.click("Account_WriteOff_UI_Fields.eltActions");

		// 8. Click on New_Transaction WebElement
		uiDriver.mouseOver("Account_WriteOff_UI_Fields.eltNew_Transaction");

		// 9. Click on Write_Off WebElement
		SleepUtils.sleep(2);
		uiDriver.click("Account_WriteOff_UI_Fields.eltWrite_Off");

		// 10. Verify whether the Cancel button is present
		SleepUtils.sleep(2);
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.btnCancel")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 11. Verify whether the Next button is present
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.btnNext")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(2);

		// 12. Verify whether the Selected_Account element present
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.eltSelected_Account")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(2);

		// 13. Verify whether the Selected_Policy element present
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.eltSelected_Policy")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 14. Verify whether the Open_Policies element present
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.eltOpen_Policies")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 15. Verify whether the Set_Account_As_Target_of_Write_Off button is present
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.btnSet_Account_As_Target_of_Write_Off")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 16. Verify whether the Select element present
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.eltSelect")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 17. Verify whether the Policy_ element present
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.eltPolicy_")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 18. Verify whether the Effective_Date element present
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.eltEffective_Date")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 19. Verify whether the Expiration_Date element present
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.eltExpiration_Date")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 20. Click on Next button
		uiDriver.click("Account_WriteOff_UI_Fields.btnNext");
		SleepUtils.sleep(5);
		if (!uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.btnCancel")) {
			uiDriver.click("Account_WriteOff_UI_Fields.btnNext");
		}

		// 21. Verify whether the Cancel button is present
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.btnCancel")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 22. Verify whether the Back button is present
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.btnBack")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 23. Verify whether the Next button is present
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.btnNext")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 24. Verify whether the Target_Details element present
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.eltTarget_Details")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 25. Verify whether the Account element present
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.eltAccount")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 26. Verify whether the Name element present
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.eltName")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 27. Verify whether the Balances element present
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.eltBalances")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 28. Verify whether the Current element present
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.eltCurrent")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 29. Verify whether the Past_Due element present
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.eltPast_Due")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 30. Verify whether the Outstanding element present
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.eltOutstanding")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 31. Verify whether the Unbilled element present
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.eltUnbilled")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 32. Verify whether the Unpaid element present
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.eltUnpaid")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 33. Verify whether the Unapplied element present
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.eltUnapplied")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 34. Verify whether the Write_Off_Details element present
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.eltWrite_Off_Details")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 35. Verify whether the Collections element present
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.eltCollections")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 36. Verify whether the Charge_Pattern element present
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.eltCharge_Pattern")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(3);

		// 38. Verify whether the Amount element present
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.eltAmount")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 39. Verify whether the Reason element present
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.eltReason")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 40. Type Amount $Parama1
		uiDriver.setValue("Account_WriteOff_UI_Fields.eltAmount1", input.get("Type@Amount#2"));

		// 41. Select $data from the Reason list
		uiDriver.click("Account_WriteOff_UI_Fields.lstReason");
		SleepUtils.sleep(3);
		uiDriver.setValue("Account_WriteOff_UI_Fields.lstReason", input.get("Select@Reason#1"));
		SleepUtils.sleep(2);
		uiDriver.sendKey("tab");
		SleepUtils.sleep(2);

		// 42. Click on Next button
		uiDriver.click("Account_WriteOff_UI_Fields.btnNext");
		SleepUtils.sleep(10);
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.lstReason")) {
			String lstReason = uiDriver.getControl("Account_WriteOff_UI_Fields.lstReason").getAttribute("value");
			if (lstReason.equalsIgnoreCase("<none>")) {
				uiDriver.click("Account_WriteOff_UI_Fields.lstReason");
				SleepUtils.sleep(3);
				uiDriver.setValue("Account_WriteOff_UI_Fields.lstReason", input.get("Select@Reason#1"));
				SleepUtils.sleep(2);
				uiDriver.sendKey("tab");
				SleepUtils.sleep(2);
				uiDriver.click("Account_WriteOff_UI_Fields.btnNext");
			}
		}
		SleepUtils.sleep(3);

		// 43. Verify whether the Cancel button is present
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.btnCancel")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 44. Verify whether the Back button is present
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.btnBack")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(3);

		// 45. Verify whether the Finish button is present
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.btnFinish")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 46. Click on Finish button
		uiDriver.click("Account_WriteOff_UI_Fields.btnFinish");
		SleepUtils.sleep(10);

		// 47. Click on Actions WebElement
		uiDriver.click("Account_WriteOff_UI_Fields.eltActions");

		// 48. Click on New_Transaction WebElement
		uiDriver.mouseOver("Account_WriteOff_UI_Fields.eltNew_Transaction");
		SleepUtils.sleep(3);

		// 49. Click on Write_Off_Reversal WebElement
		uiDriver.click("Account_WriteOff_UI_Fields.eltWrite_Off_Reversal");
		SleepUtils.sleep(8);

		// 50. Verify whether the Cancel button is present
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.btnCancel")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(3);

		// 51. Verify whether the Next button is present
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.btnNext")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(3);

		// 52. Verify whether the Selected_Write_Off element present
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.eltSelected_Write_Off")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 53. Verify whether the Write_Offs element present
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.eltWrite_Offs1")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 54. Verify whether the Write_Off_Basics element present
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.eltWrite_Off_Basics")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 55. Verify whether the Collections element present
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.eltCollections")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 56. Verify whether the Reason element present
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.eltReason")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 57. Verify whether the Minimum_Amount element present
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.eltMinimum_Amount")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 58. Verify whether the Maximum_Amount element present
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.eltMaximum_Amount")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 59. Verify whether the Dates element present
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.eltDates")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 60. Verify whether the Earliest_Date element present
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.eltEarliest_Date")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(3);

		// 61. Verify whether the Latest_Date element present
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.eltLatest_Date")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 62. Verify whether the Related_Items element present
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.eltRelated_Items")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 63. Verify whether the Charge_Pattern element present
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.eltCharge_Pattern")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 64. Verify whether the Account_ element present
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.eltAccount_")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 65. Verify whether the Policy_ element present
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.eltPolicy_")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(3);

		// 66. Verify whether the Search button is present
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.btnSearch_Reversal")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(4);

		// 67. Verify whether the Reset button is present
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.btnReset_Reversal")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 68. Verify whether the Select element present
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.eltSelect")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 69. Verify whether the Date element present
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.eltDate1")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 70. Verify whether the Collections element present
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.eltCollections")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 71. Verify whether the Description element present
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.eltDescription")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 72. Verify whether the Owner element present
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.eltOwner")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 73. Verify whether the Amount element present
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.eltAmount")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 74. Click on Search button
		uiDriver.click("Account_WriteOff_UI_Fields.btnSearch_Reversal");
		SleepUtils.sleep(8);

		// 75. Verify whether the Select element present
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.btnSelect_Reversal")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(4);

		// 76. Click on Select button
		uiDriver.click("Account_WriteOff_UI_Fields.btnSelect_Reversal");
		SleepUtils.sleep(3);

		// 77. Verify whether the Cancel button is present
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.btnCancel")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 78. Verify whether the Back button is present
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.btnBack")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 79. Verify whether the Finish button is present
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.btnFinish")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 80. Verify whether the Date element present
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.eltDate")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 81. Verify whether the Write_Off element present
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.eltWrite_Off_Reversal2")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 82. Verify whether the Line_Items element present
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.eltLine_Items")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 83. Verify whether the Name element present
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.eltName")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 84. Verify whether the Date_ element present
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.eltDate_")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 85. Verify whether the Amount element present
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.eltAmount")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 86. Verify whether the Write_Off_Reversal element present
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.eltWrite_Off_Reversal1")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 87. Verify whether the Write_Off_Reason element present
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.eltWrite_Off_Reason")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(3);

		// 88. Verify whether the Reason element present
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.eltReason")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 89. Select $data from the Reason list
		uiDriver.click("Account_WriteOff_UI_Fields.lstReason1");
		SleepUtils.sleep(3);
		uiDriver.setValue("Account_WriteOff_UI_Fields.lstReason1", input.get("Select@Reason#2"));
		SleepUtils.sleep(2);
		uiDriver.sendKey("tab");
		SleepUtils.sleep(5);

		// 90. Click on Finish button
		uiDriver.click("Account_WriteOff_UI_Fields.eltFinish_WRW");
		SleepUtils.sleep(10);

		// 91. Click on Desktop WebElement
		uiDriver.click("Account_WriteOff_UI_Fields.eltDesktop");
		SleepUtils.sleep(4);

		// 92. Click on Actions WebElement
		uiDriver.click("Account_WriteOff_UI_Fields.eltActions_Desktop");
		SleepUtils.sleep(4);

		// 93. Click on New_Transaction WebElement
		uiDriver.mouseOver("Account_WriteOff_UI_Fields.eltNew_Transaction_Desktop");

		// 94. Click on Write_Off WebElement
		SleepUtils.sleep(3);
		uiDriver.click("Account_WriteOff_UI_Fields.eltWrite_Off_desktop");
		SleepUtils.sleep(5);

		// 95. Verify whether the Cancel button is present
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.btnCancel")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 96. Verify whether the Next button is present
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.btnNext")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 97. Verify whether the Type_of_Source element present
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.eltType_of_Source")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 98. Verify whether the Account element present
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.eltAccount")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 99. Verify whether the PolicyPeriod element present
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.eltPolicyPeriod")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 100. Click on Account_rdo WebElement
		uiDriver.click("Account_WriteOff_UI_Fields.eltAccount_rdo");

		// 101. Verify whether the Accounts element present
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.eltAccounts")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 102. Verify whether the Search_Criteria element present
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.eltSearch_Criteria")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 103. Verify whether the Account_ element present
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.eltAccount_")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 104. Verify whether the Account_Name element present
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.eltAccount_Name")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 105. Verify whether the Policy_ element present
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.eltPolicy_")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 106. Verify whether the Account_Segment element present
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.eltAccount_Segment")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 107. Verify whether the Status element present
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.eltStatus")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 108. Verify whether the Type element present
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.eltType")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 109. Verify whether the In_Collections element present
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.eltIn_Collections")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 110. Type $data in Account_Name field
		uiDriver.setValue("Account_WriteOff_UI_Fields.txtAccount_Name", input.get("Type@Account_Name"));

		// 111. Click on Search button
		uiDriver.click("Account_WriteOff_UI_Fields.btnSearch1");
		SleepUtils.sleep(5);

		// 112. Verify whether the Select_Dsktop button is present
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.btnSelect_Dsktop")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 113. Click on Select_Dsktop button
		uiDriver.click("Account_WriteOff_UI_Fields.btnSelect_Dsktop");

		// 114. Type $data in Amount_Desktop field
		uiDriver.click("Account_WriteOff_UI_Fields.lstReason3");
		SleepUtils.sleep(2);
		uiDriver.setValue("Account_WriteOff_UI_Fields.lstReason2", input.get("Select@Reason#3"));
		SleepUtils.sleep(4);
		uiDriver.sendKey("tab");
		SleepUtils.sleep(2);

		// 115. Select $data from the Reason list
		uiDriver.setValue("Account_WriteOff_UI_Fields.txtAmount_Desktop", input.get("Type@Amount_Desktop"));
		SleepUtils.sleep(4);

		// 116. Click on Next button
		uiDriver.click("Account_WriteOff_UI_Fields.btnNext");
		SleepUtils.sleep(4);
		if (uiDriver.checkElementPresent("Account_WriteOff_UI_Fields.eltReasonmsg")) {
			uiDriver.click("Account_WriteOff_UI_Fields.lstReason2");
			SleepUtils.sleep(2);
			uiDriver.setValue("Account_WriteOff_UI_Fields.lstReason2", input.get("Select@Reason#3"));
			SleepUtils.sleep(2);
			uiDriver.sendKey("tab");
			SleepUtils.sleep(2);
			uiDriver.click("Account_WriteOff_UI_Fields.btnNext");
		}
		SleepUtils.sleep(4);

		// 117. Click on Finish button
		uiDriver.click("Account_WriteOff_UI_Fields.btnFinish");
		SleepUtils.sleep(4);

	}

	public void Verify_Acc_Poli_History(DataRow input, DataRow output) {
		// 1. Click on Actions WebElement
		uiDriver.click("Verify_Acc_Poli_History.eltActions");

		// 2. Click on New_Transaction WebElement
		uiDriver.mouseOver("Verify_Acc_Poli_History.eltNew_Transaction");

		// 3. Click on Recharge_Fee WebElement
		SleepUtils.sleep(3);
		uiDriver.click("Verify_Acc_Poli_History.eltRecharge_Fee");

		// 4. Click on Next_ WebElement
		SleepUtils.sleep(2);
		uiDriver.click("Verify_Acc_Poli_History.eltNext_");

		// 5. Type $data in Amount field
		uiDriver.setValue("Verify_Acc_Poli_History.txtAmount", input.get("Type@Amount#1"));

		// 6. Click on Finish button
		uiDriver.click("Verify_Acc_Poli_History.btnFinish");

		// 7. Click on Actions WebElement
		SleepUtils.sleep(1);
		uiDriver.click("Verify_Acc_Poli_History.eltActions");

		// 8. Click on New_Transaction WebElement
		uiDriver.mouseOver("Verify_Acc_Poli_History.eltNew_Transaction");

		// 9. Click on Write_Off WebElement
		SleepUtils.sleep(2);
		uiDriver.click("Verify_Acc_Poli_History.eltWrite_Off");

		// 10. Click on Next_ button
		SleepUtils.sleep(2);
		uiDriver.click("Verify_Acc_Poli_History.btnNext_");

		// 11. Select $data from the Charge_Pattern list
		uiDriver.click("Verify_Acc_Poli_History.lstCharge_Pattern");
		SleepUtils.sleep(2);
		uiDriver.setValue("Verify_Acc_Poli_History.lstCharge_Pattern", input.get("Select@Charge_Pattern#1"));
		SleepUtils.sleep(2);
		uiDriver.sendKey("tab");
		SleepUtils.sleep(2);

		// 12. Type $data in Amount field
		uiDriver.setValue("Verify_Acc_Poli_History.txtAmount_Acclevel", input.get("Type@Amount#2"));

		// 13. Select $data from the Reason list
		uiDriver.click("Verify_Acc_Poli_History.lstReason");
		SleepUtils.sleep(2);
		uiDriver.setValue("Verify_Acc_Poli_History.lstReason", input.get("Select@Reason#1"));
		SleepUtils.sleep(2);
		uiDriver.sendKey("tab");
		SleepUtils.sleep(2);

		// 14. Click on Finish button
		uiDriver.click("Verify_Acc_Poli_History.btnNext_");
		if (uiDriver.checkElementPresent("Verify_Acc_Poli_History.eltAccount_errormsg")) {
			uiDriver.setValue("Verify_Acc_Poli_History.lstReason", input.get("Select@Reason#1"));
			SleepUtils.sleep(2);
			uiDriver.sendKey("tab");
			SleepUtils.sleep(2);
			uiDriver.click("Verify_Acc_Poli_History.btnNext_");
		}
		SleepUtils.sleep(5);
		uiDriver.click("Verify_Acc_Poli_History.btnFinish_Acclevel");

		// 15. Click on History WebElement
		uiDriver.click("Verify_Acc_Poli_History.eltHistory");

		// 16. Select $data from the Filter_by_Type list
		uiDriver.click("Verify_Acc_Poli_History.lstFilter_by_Type");
		SleepUtils.sleep(2);
		uiDriver.setValue("Verify_Acc_Poli_History.lstFilter_by_Type", input.get("Select@Filter_by_Type#1"));
		SleepUtils.sleep(2);
		uiDriver.sendKey("tab");
		SleepUtils.sleep(2);
		uiDriver.sendKey("tab");
		SleepUtils.sleep(4);

		// 17. Verify Description
		uiDriver.th.getCellDataOfCol("Verify_Acc_Poli_History.tblDescription", input.get("Verify@AccLevelHistroy"), 1);

		// 18. Click on Desktop WebElement
		uiDriver.click("US1086NonITAdmNotAbleTocloseAn.eltAccount");
		SleepUtils.sleep(5);

		// 19. Type $data in Account_Name field
		uiDriver.setValue("AddPolicy.txtAccountNo", input.get("Type@Account_Name#1"));

		// 20. Click on Desktop WebElement
		uiDriver.click("AddPolicy.btnsearch");
		SleepUtils.sleep(3);

		// 21. Verify whether the Policy_Select button is present
		if (uiDriver.checkElementPresent("AddPolicy.lnkaccount")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 22. Click on Policy_Select button
		uiDriver.click("AddPolicy.lnkaccount");
		SleepUtils.sleep(5);

		// 23. Verify whether the Policy_Select button is present
		if (!uiDriver.checkElementPresent("Verify_Acc_Poli_History.eltLatefee")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		// 24. Verify whether the Policy_Select button is present
		if (!uiDriver.checkElementPresent("New_Edited_Fiedls_Account_360_.elt360_Direct_Bill_View")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

	}

	/**
	 * Overriding toString() method of object class to print
	 * US_1055_TC_BC_360_Account_Summary format string
	 **/
	public String toString() {
		return "US_1055_TC_BC_360_Account_SummaryDriver";
	}
}
