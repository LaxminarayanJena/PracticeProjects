/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 12/4/2017 4:00:37 AM
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
public class US1091_ViewChargesAccntAndPoliDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;

	public US1091_ViewChargesAccntAndPoliDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}

	public void US1091_ViewChargesAccntAndPoli(DataRow input, DataRow output) {

		// 1. Click on Charges WebElement
		uiDriver.click("US1091_ViewChargesAccntAndPoli.eltCharges_Accountlevel");

		// 2. Verify Statment_date_field
		if (uiDriver.checkElementPresent("US1091_ViewChargesAccntAndPoli.eltStatment_date_field")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 3. Click on Policies WebElement
		uiDriver.click("US1091_ViewChargesAccntAndPoli.eltPolicies");

		// 4. Click on Policy Link
		uiDriver.click("US1091_ViewChargesAccntAndPoli.lnkPolicy");

		// 5. Click on Charges WebElement
		uiDriver.click("US1091_ViewChargesAccntAndPoli.eltCharges");

		//6. Verify Statment_date

		if (uiDriver.checkElementPresent("US1091_ViewChargesAccntAndPoli.eltStatment_date")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

	}

	public void FielValidationInChargScr_Accnt(DataRow input, DataRow output) {

		// 1. Click on Charges WebElement
		uiDriver.click("FielValidationInChargScr_Accnt.eltCharges");

		// 2. Verify whether the Check_box checkbox is present
		if (uiDriver.checkElementPresent("FielValidationInChargScr_Accnt.chkCheck_box")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 3. Verify whether the Installment_ element present
		if (uiDriver.checkElementPresent("FielValidationInChargScr_Accnt.eltInstallment_")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 4. Verify whether the Event_Date element present
		if (uiDriver.checkElementPresent("FielValidationInChargScr_Accnt.eltEvent_Date")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 5. Verify whether the Statement_Date element present
		if (uiDriver.checkElementPresent("FielValidationInChargScr_Accnt.eltStatement_Date")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 6. Verify whether the Invoice_Due_Date element present
		if (uiDriver.checkElementPresent("FielValidationInChargScr_Accnt.eltInvoice_Due_Date")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 7. Verify whether the Owner element present
		if (uiDriver.checkElementPresent("FielValidationInChargScr_Accnt.eltOwner")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 8. Verify whether the Payer element present
		if (uiDriver.checkElementPresent("FielValidationInChargScr_Accnt.eltPayer")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 9. Verify whether the Context element present
		if (uiDriver.checkElementPresent("FielValidationInChargScr_Accnt.eltContext")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 10. Verify whether the Type element present
		if (uiDriver.checkElementPresent("FielValidationInChargScr_Accnt.eltType")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 11. Verify whether the Full_Pay element present
		if (uiDriver.checkElementPresent("FielValidationInChargScr_Accnt.eltFull_Pay")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 12. Verify whether the Amount element present
		if (uiDriver.checkElementPresent("FielValidationInChargScr_Accnt.eltAmount")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 13. Verify whether the Paid_Amount element present
		if (uiDriver.checkElementPresent("FielValidationInChargScr_Accnt.eltPaid_Amount")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 14. Verify whether the Invoice_Stream element present
		if (uiDriver.checkElementPresent("FielValidationInChargScr_Accnt.eltInvoice_Stream")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

	}

	/**
	 * Overriding toString() method of object class to print
	 * US1091_ViewChargesAccntAndPoli format string
	 **/
	public String toString() {
		return "US1091_ViewChargesAccntAndPoliDriver";
	}
}
