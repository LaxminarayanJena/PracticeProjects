/******************************************************************************
Created by : Capgemini Automation Team 
Created\Updated on : 3/2/2018 4:15:37 AM
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
public class US1402_LoadPlansandChargepatDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;

	public US1402_LoadPlansandChargepatDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}

	public void US1402_LoadPlansandChargepat(DataRow input, DataRow output) {
		// 1. Click on Administration WebElement
		uiDriver.click("US1402_LoadPlansandChargepat.eltAdministration");
		SleepUtils.sleep(2);

		// 2. Click on Business_Settings WebElement
		uiDriver.click("US1402_LoadPlansandChargepat.eltBusiness_Settings");
		SleepUtils.sleep(2);

		// 3. Click on Payment_Plans WebElement
		uiDriver.click("US1402_LoadPlansandChargepat.eltPayment_Plans");
		SleepUtils.sleep(2);

		// 4. Click on PaymentPlans WebElement
		uiDriver.th.findRelativeCellAndClick("US1402_LoadPlansandChargepat.eltPaymentPlans", input.get("Name_1"), 1,
				input.get("Name_1"));
		SleepUtils.sleep(2);

		// 5. Verify whether the First_Installment element present
		if (uiDriver.checkElementPresent("US1402_LoadPlansandChargepat.eltFirst_Installment")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(4);

		// 6. Click on Up_to_Payment_Plans Link
		uiDriver.click("US1402_LoadPlansandChargepat.lnkUp_to_Payment_Plans");
		SleepUtils.sleep(2);

		// 7. Click on PaymentPlans WebElement
		uiDriver.th.findRelativeCellAndClick("US1402_LoadPlansandChargepat.eltPaymentPlans", input.get("Name_2"), 1,
				input.get("Name_2"));
		SleepUtils.sleep(2);

		// 8. Verify whether the First_Installment element present
		if (uiDriver.checkElementPresent("US1402_LoadPlansandChargepat.eltFirst_Installment")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(4);

		// 9. Click on Up_to_Payment_Plans Link
		uiDriver.click("US1402_LoadPlansandChargepat.lnkUp_to_Payment_Plans");
		SleepUtils.sleep(2);

		// 10. Click on PaymentPlans WebElement
		uiDriver.th.findRelativeCellAndClick("US1402_LoadPlansandChargepat.eltPaymentPlans", input.get("Name_3"), 1,
				input.get("Name_3"));
		SleepUtils.sleep(2);

		// 11. Verify whether the First_Installment element present
		if (uiDriver.checkElementPresent("US1402_LoadPlansandChargepat.eltFirst_Installment")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(4);

		// 12. Click on Up_to_Payment_Plans Link
		uiDriver.click("US1402_LoadPlansandChargepat.lnkUp_to_Payment_Plans");
		SleepUtils.sleep(2);

		// 13. Click on PaymentPlans WebElement
		uiDriver.th.findRelativeCellAndClick("US1402_LoadPlansandChargepat.eltPaymentPlans", input.get("Name_4"), 1,
				input.get("Name_4"));
		SleepUtils.sleep(2);

		// 14. Verify whether the First_Installment element present
		if (uiDriver.checkElementPresent("US1402_LoadPlansandChargepat.eltFirst_Installment")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(4);

		// 15. Click on Up_to_Payment_Plans Link
		uiDriver.click("US1402_LoadPlansandChargepat.lnkUp_to_Payment_Plans");
		SleepUtils.sleep(2);

		// 16. Click on PaymentPlans WebElement
		uiDriver.th.findRelativeCellAndClickSelectedCellAndSubtext("US1402_LoadPlansandChargepat.eltPaymentPlans",
				input.get("Name_5"), 1, input.get("Name_5"), input.get("Name_5"), input.get("Name_5"));
		SleepUtils.sleep(2);

		// 17. Verify whether the First_Installment element present
		if (uiDriver.checkElementPresent("US1402_LoadPlansandChargepat.eltFirst_Installment")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(4);

		// 18. Click on Up_to_Payment_Plans Link
		uiDriver.click("US1402_LoadPlansandChargepat.lnkUp_to_Payment_Plans");
		SleepUtils.sleep(2);

		// 19. Click on PaymentPlans WebElement
		uiDriver.th.findRelativeCellAndClick("US1402_LoadPlansandChargepat.eltPaymentPlans", input.get("Name_6"), 1,
				input.get("Name_6"));
		SleepUtils.sleep(2);

		// 20. Verify whether the First_Installment element present
		if (uiDriver.checkElementPresent("US1402_LoadPlansandChargepat.eltFirst_Installment")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(4);

		// 21. Click on Up_to_Payment_Plans Link
		uiDriver.click("US1402_LoadPlansandChargepat.lnkUp_to_Payment_Plans");
		SleepUtils.sleep(2);

		// 22. Click on PaymentPlans WebElement
		uiDriver.th.findRelativeCellAndClick("US1402_LoadPlansandChargepat.eltPaymentPlans", input.get("Name_7"), 1,
				input.get("Name_7"));
		SleepUtils.sleep(2);

		// 23. Verify whether the First_Installment element present
		if (uiDriver.checkElementPresent("US1402_LoadPlansandChargepat.eltFirst_Installment")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(4);

		// 24. Click on Up_to_Payment_Plans Link
		uiDriver.click("US1402_LoadPlansandChargepat.lnkUp_to_Payment_Plans");
		SleepUtils.sleep(2);

		// 25. Click on PaymentPlans WebElement
		uiDriver.th.findRelativeCellAndClick("US1402_LoadPlansandChargepat.eltPaymentPlans", input.get("Name_8"), 1,
				input.get("Name_8"));
		SleepUtils.sleep(2);

		// 26. Verify whether the First_Installment element present
		if (uiDriver.checkElementPresent("US1402_LoadPlansandChargepat.eltFirst_Installment")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(4);

		// 27. Click on Up_to_Payment_Plans Link
		uiDriver.click("US1402_LoadPlansandChargepat.lnkUp_to_Payment_Plans");
		SleepUtils.sleep(2);

		// 28. Click on PaymentPlans WebElement
		uiDriver.th.findRelativeCellAndClick("US1402_LoadPlansandChargepat.eltPaymentPlans", input.get("Name_9"), 1,
				input.get("Name_9"));
		SleepUtils.sleep(2);

		// 29. Verify whether the First_Installment element present
		if (uiDriver.checkElementPresent("US1402_LoadPlansandChargepat.eltFirst_Installment")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(4);

		// 30. Click on Up_to_Payment_Plans Link
		uiDriver.click("US1402_LoadPlansandChargepat.lnkUp_to_Payment_Plans");
		SleepUtils.sleep(2);

		// 31. Click on PaymentPlans WebElement
		uiDriver.th.findRelativeCellAndClickSelectedCellAndSubtext("US1402_LoadPlansandChargepat.eltPaymentPlans",
				input.get("Name_10"), 1, input.get("Name_10"), input.get("Name_10"), input.get("Name_10"));
		SleepUtils.sleep(2);

		// 32. Verify whether the First_Installment element present
		if (uiDriver.checkElementPresent("US1402_LoadPlansandChargepat.eltFirst_Installment")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(4);

		// 33. Click on Up_to_Payment_Plans Link
		uiDriver.click("US1402_LoadPlansandChargepat.lnkUp_to_Payment_Plans");
		SleepUtils.sleep(2);

		// 34. Click on PaymentPlans WebElement
		uiDriver.th.findRelativeCellAndClickSelectedCellAndSubtext("US1402_LoadPlansandChargepat.eltPaymentPlans",
				input.get("Name_11"), 1, input.get("Name_11"), input.get("Name_11"), input.get("Name_11"));
		SleepUtils.sleep(2);

		// 35. Verify whether the First_Installment element present
		if (uiDriver.checkElementPresent("US1402_LoadPlansandChargepat.eltFirst_Installment")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(4);

		// 36. Click on Up_to_Payment_Plans Link
		uiDriver.click("US1402_LoadPlansandChargepat.lnkUp_to_Payment_Plans");
		SleepUtils.sleep(2);

		// 37. Click on PaymentPlans WebElement
		uiDriver.th.findRelativeCellAndClick("US1402_LoadPlansandChargepat.eltPaymentPlans", input.get("Name_12"), 1,
				input.get("Name_12"));
		SleepUtils.sleep(2);

		// 38. Verify whether the First_Installment element present
		if (uiDriver.checkElementPresent("US1402_LoadPlansandChargepat.eltFirst_Installment")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(4);

		// 39. Click on Up_to_Payment_Plans Link
		uiDriver.click("US1402_LoadPlansandChargepat.lnkUp_to_Payment_Plans");
		SleepUtils.sleep(2);

		// 40. Click on PaymentPlans WebElement
		uiDriver.th.findRelativeCellAndClick("US1402_LoadPlansandChargepat.eltPaymentPlans", input.get("Name_13"), 1,
				input.get("Name_13"));
		SleepUtils.sleep(2);

		// 41. Verify whether the First_Installment element present
		if (uiDriver.checkElementPresent("US1402_LoadPlansandChargepat.eltFirst_Installment")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(4);

		// 42. Click on Up_to_Payment_Plans Link
		uiDriver.click("US1402_LoadPlansandChargepat.lnkUp_to_Payment_Plans");
		SleepUtils.sleep(2);

		// 43. Click on PaymentPlans WebElement
		uiDriver.th.findRelativeCellAndClick("US1402_LoadPlansandChargepat.eltPaymentPlans", input.get("Name_14"), 1,
				input.get("Name_14"));
		SleepUtils.sleep(2);

		// 44. Verify whether the First_Installment element present
		if (uiDriver.checkElementPresent("US1402_LoadPlansandChargepat.eltFirst_Installment")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(4);

		// 45. Click on Up_to_Payment_Plans Link
		uiDriver.click("US1402_LoadPlansandChargepat.lnkUp_to_Payment_Plans");
		SleepUtils.sleep(2);

		// 46. Type $data in Page field
		uiDriver.setValue("US1402_LoadPlansandChargepat.txtPage", input.get("Type@Page"));
		SleepUtils.sleep(2);
		uiDriver.sendKey("enter");

		// 47. Click on PaymentPlans WebElement
		uiDriver.th.findRelativeCellAndClick("US1402_LoadPlansandChargepat.eltPaymentPlans", input.get("Name_15"), 1,
				input.get("Name_15"));
		SleepUtils.sleep(2);

		// 48. Verify whether the First_Installment element present
		if (uiDriver.checkElementPresent("US1402_LoadPlansandChargepat.eltFirst_Installment")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(4);

		// 49. Click on Up_to_Payment_Plans Link
		uiDriver.click("US1402_LoadPlansandChargepat.lnkUp_to_Payment_Plans");
		SleepUtils.sleep(2);

		// 50. Type $data in Page field
		uiDriver.setValue("US1402_LoadPlansandChargepat.txtPage", input.get("Type@Page"));
		SleepUtils.sleep(2);
		uiDriver.sendKey("enter");

		// 51. Click on PaymentPlans WebElement
		uiDriver.th.findRelativeCellAndClick("US1402_LoadPlansandChargepat.eltPaymentPlans", input.get("Name_16"), 1,
				input.get("Name_16"));
		SleepUtils.sleep(2);

		// 51. Verify whether the First_Installment element present
		if (uiDriver.checkElementPresent("US1402_LoadPlansandChargepat.eltFirst_Installment")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(4);

		// 51. Click on Up_to_Payment_Plans Link
		uiDriver.click("US1402_LoadPlansandChargepat.lnkUp_to_Payment_Plans");

	}

	/**
	 * Overriding toString() method of object class to print
	 * US1402_LoadPlansandChargepat format string
	 **/
	public String toString() {
		return "US1402_LoadPlansandChargepatDriver";
	}
}