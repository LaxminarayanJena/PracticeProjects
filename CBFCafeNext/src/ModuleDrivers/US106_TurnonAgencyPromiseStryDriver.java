/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 12/12/2017 9:59:35 AM
Module part of 'Guidewire Billing Center'
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
public class US106_TurnonAgencyPromiseStryDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;

	public US106_TurnonAgencyPromiseStryDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}

	public void US106_TurnonAgencyPromiseStry(DataRow input, DataRow output) {
		// 1. Click on ProducerTab WebElement
		uiDriver.click("US106_TurnonAgencyPromiseStry.eltProducerTab");

		// 2. Type $data in ProducerCode field
		uiDriver.setValue("US106_TurnonAgencyPromiseStry.txtProducerCode", input.get("Type@ProducerCode#1"));

		// 3. Click on Search button
		uiDriver.click("US106_TurnonAgencyPromiseStry.btnSearch");

		// 4. Click on ProducerName Link
		uiDriver.click("US106_TurnonAgencyPromiseStry.lnkProducerName");

		// 5. Click on Actions button
		uiDriver.click("US106_TurnonAgencyPromiseStry.btnActions");

		// 6. Click on NewAgencyBillPromise WebElement

		if (uiDriver.checkElementPresent("US106_TurnonAgencyPromiseStry.eltNewAgencyBillPromise")) {
			uiDriver.click("US106_TurnonAgencyPromiseStry.eltNewAgencyBillPromise");
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 7. Verify Title
		if (uiDriver.checkElementPresent("US106_TurnonAgencyPromiseStry.ttlAgencyBillPromise")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 8. Click on ProducerTab WebElement
		uiDriver.click("US106_TurnonAgencyPromiseStry.eltProducerTab");

		// 9. Click on ProducerName Link
		uiDriver.click("US106_TurnonAgencyPromiseStry.lnkProducerName");

		// 10. Click on Agency_Bill_Promises_tab WebElement
		uiDriver.click("US106_TurnonAgencyPromiseStry.eltAgency_Bill_Promises_tab");

		// 11. Click on Executed_Promises_hyperlink Link
		uiDriver.click("US106_TurnonAgencyPromiseStry.lnkExecuted_Promises_hyperlink");

		// 12. Verify Executed_Promises
		if (uiDriver.checkElementPresent("US106_TurnonAgencyPromiseStry.ttlAgencyBillExecutedPromises")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 13. Click on Saved_Promises_hyperlink Link
		uiDriver.click("US106_TurnonAgencyPromiseStry.lnkSaved_Promises_hyperlink");

		// 14. Verify Saved_Promises
		if (uiDriver.checkElementPresent("US106_TurnonAgencyPromiseStry.ttlSaved_Promises")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 15. Click on Agency_Bill_Exceptions Link
		uiDriver.click("US106_TurnonAgencyPromiseStry.lnkAgency_Bill_Exceptions");

		// 16. Verify Payment_Mismatch_Exceptions_tab
		if (uiDriver.checkElementPresent("US106_TurnonAgencyPromiseStry.eltPayment_Mismatch_Exceptions_tab")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 17. Verify Late_Promises_tab
		if (uiDriver.checkElementPresent("US106_TurnonAgencyPromiseStry.eltLate_Promises_tab")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 18. Click on Agency_Bill_Suspense_Items Link
		uiDriver.click("US106_TurnonAgencyPromiseStry.lnkAgency_Bill_Suspense_Items");

		// 19. Verify Promise_Items_tab
		if (uiDriver.checkElementPresent("US106_TurnonAgencyPromiseStry.eltPromise_Items_tab")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 20. Click on Desktop_tab WebElement
		uiDriver.click("US106_TurnonAgencyPromiseStry.eltDesktop_tab");

		// 21. Click on My_Agency_Items_tab WebElement
		uiDriver.click("US106_TurnonAgencyPromiseStry.eltMy_Agency_Items_tab");

		// 22. Verify Promise_Exceptions_tab
		if (uiDriver.checkElementPresent("US106_TurnonAgencyPromiseStry.eltPromise_Exceptions_tab")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		
		// 23. Verify Late_Promises_tab
		if (uiDriver.checkElementPresent("US106_TurnonAgencyPromiseStry.eltLate_Promises_tab1")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		
		// 24. Verify Suspense_Promises_tab
		if (uiDriver.checkElementPresent("US106_TurnonAgencyPromiseStry.eltSuspense_Promises_tab")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
	}

	/**
	 * Overriding toString() method of object class to print
	 * US106_TurnonAgencyPromiseStry format string
	 **/
	public String toString() {
		return "US106_TurnonAgencyPromiseStryDriver";
	}
}
