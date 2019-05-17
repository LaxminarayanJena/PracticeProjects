/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 4/12/2018 9:31:22 AM
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
Extends BaseModuleDriver class and performs application specific operations
*/
public class US1471_DisablingTransactionsDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public US1471_DisablingTransactionsDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void TC01_DisablingTransactions(DataRow input, DataRow output) {
		//1. Click on Account WebElement
		uiDriver.click("TC01_DisablingTransactions.eltAccount");
		SleepUtils.sleep(4);
		
		//2. Verify whether the Actions button is present
		if (uiDriver.checkElementPresent("TC01_DisablingTransactions.btnActions")) {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(4);
		
		//3. Type $data in Account_Name field
		uiDriver.setValue("TC01_DisablingTransactions.txtAccount_Name", input.get("Type@Account_Name"));
		SleepUtils.sleep(4);
		
		//4. Click on Search button
		uiDriver.click("TC01_DisablingTransactions.btnSearch");
		SleepUtils.sleep(4);
		
		//5. Verify whether the Name link is present
		if (uiDriver.checkElementPresent("TC01_DisablingTransactions.lnkAccount")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(4);
		
		//7. Click on Account_ Link
		uiDriver.click("TC01_DisablingTransactions.lnkAccount_");
		SleepUtils.sleep(4);
		
		//8. Click on Policy_ Link
		uiDriver.click("TC01_DisablingTransactions.lnkPolicy_");
		SleepUtils.sleep(4);
		
		//9. Click on Actions button
		uiDriver.click("TC01_DisablingTransactions.btnActions_1");
		SleepUtils.sleep(4);
		
		//10. Verify whether the Add_Policy element present
		if (uiDriver.checkElementPresent("TC01_DisablingTransactions.eltAdd_Policy")) {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(4);
		
		//11. Verify whether the Change_Policy element present
		if (uiDriver.checkElementPresent("TC01_DisablingTransactions.eltChange_Policy")) {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(4);
		
		//12. Verify whether the Cancel_Policy element present
		if (uiDriver.checkElementPresent("TC01_DisablingTransactions.eltCancel_Policy")) {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(4);
		
		//13. Verify whether the Premium_Report_BI element present
		if (uiDriver.checkElementPresent("TC01_DisablingTransactions.eltPremium_Report_BI")) {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(4);
		
		//14. Verify whether the Audit_BI element present
		if (uiDriver.checkElementPresent("TC01_DisablingTransactions.eltAudit_BI")) {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(4);
		
		//15. Verify whether the Renew_policy element present
		if (uiDriver.checkElementPresent("TC01_DisablingTransactions.eltRenew_policy")) {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(4);
		
		//16. Click on Producer WebElement
		uiDriver.click("TC01_DisablingTransactions.eltProducer");
		SleepUtils.sleep(4);
		
		//17. Verify whether the Actions_1 button is present
		if (uiDriver.checkElementPresent("TC01_DisablingTransactions.btnActions_2")) {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(4);
	}
	

	/**
	*Overriding toString() method of object class to print US1471_DisablingTransactions
	*format string
	**/
	public String toString(){
		return "US1471_DisablingTransactionsDriver";
	}
}
