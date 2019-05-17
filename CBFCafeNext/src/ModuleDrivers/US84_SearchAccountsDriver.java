/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 12/5/2017 5:20:01 AM
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
public class US84_SearchAccountsDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;

	public US84_SearchAccountsDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}

	public void SearchAccounts(DataRow input, DataRow output) {
		// 1. Click on Search WebElement
		uiDriver.click("SearchAccounts.eltSearch");

		// 2. Type $data in Account field
		uiDriver.setValue("SearchAccounts.txtAccont", input.get("Type@Accont"));

		// 3. Click on Search button
		uiDriver.click("SearchAccounts.btnSearch");

		// 4. Verify whether the Account link is present
		if (uiDriver.checkElementPresent("SearchAccounts.lnkAccount")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 5. Click on Reset button
		uiDriver.click("SearchAccounts.btnReset");

		// 6. Click on Search WebElement
		uiDriver.click("SearchAccounts.eltSearch");

		// 7. Type $data in Account_Name field
		uiDriver.setValue("SearchAccounts.txtAccount_Name", input.get("Type@Account_Name"));

		// 8. Click on Search button
		uiDriver.click("SearchAccounts.btnSearch");

		// 9. Verify whether the Account_Name link is present
		if (uiDriver.checkElementPresent("SearchAccounts.lnkAccount_Name")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 10. Click on Reset button
		uiDriver.click("SearchAccounts.btnReset");

		// 11. Click on Search WebElement
		uiDriver.click("SearchAccounts.eltSearch");

		// 12. Type $data in Policy_ field
		uiDriver.setValue("SearchAccounts.txtPolicy_", input.get("Type@Policy_"));

		// 13. Click on Search button
		uiDriver.click("SearchAccounts.btnSearch");

		// 14. Verify whether the Account link is present
		if (uiDriver.checkElementPresent("SearchAccounts.lnkAccount")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		// 15. Click on Search WebElement
		uiDriver.click("SearchAccounts.eltAccount");

		// 16. Type $data in Accont field
		uiDriver.setValue("SearchAccounts.txtAccont1", input.get("Type@Accont"));

		// 17. Click on Search button
		uiDriver.click("SearchAccounts.btnSearch1");

		// 18. Verify whether the Account link is present
		if (uiDriver.checkElementPresent("SearchAccounts.lnkAccount1")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 19. Click on Reset button
		uiDriver.click("SearchAccounts.btnReset1");

		// 20. Click on Search WebElement
		uiDriver.click("SearchAccounts.eltAccount");

		// 21. Type $data in Account_Name field
		uiDriver.setValue("SearchAccounts.txtAccount_Name1", input.get("Type@Account_Name"));

		// 22. Click on Search button
		uiDriver.click("SearchAccounts.btnSearch1");

		// 23. Verify whether the Account_Name link is present
		if (uiDriver.checkElementPresent("SearchAccounts.lnkAccount_Name1")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 24. Click on Reset button
		uiDriver.click("SearchAccounts.btnReset1");

		// 25. Click on Search WebElement
		uiDriver.click("SearchAccounts.eltAccount");

		// 26. Type $data in Policy_ field
		uiDriver.click("SearchAccounts.imgAccountPolicy");
		SleepUtils.sleep(2);
		uiDriver.setValue("SearchAccounts.txtSearchPolicyin Acc", input.get("Type@Policy_"));
		SleepUtils.sleep(2);
		uiDriver.click("SearchAccounts.btnSearchAcc");
		SleepUtils.sleep(2);
		uiDriver.click("SearchAccounts.btnSelectAcc");
		SleepUtils.sleep(4);
		// uiDriver.setValue("SearchAccounts.txtPolicy_1", input.get("Type@Policy_"));

		// 27. Click on Search button
		uiDriver.click("SearchAccounts.btnSearch1");

		// 28. Verify whether the Account link is present
		if (uiDriver.checkElementPresent("SearchAccounts.lnkAccount1")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

	}

	/**
	 * Overriding toString() method of object class to print SearchAccounts format
	 * string
	 **/
	public String toString() {
		return "SearchAccountsDriver";
	}
}
