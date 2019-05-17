/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 3/26/2018 4:44:28 AM
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
public class Update_Agency_Bill_Executed_PromisesDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;

	public Update_Agency_Bill_Executed_PromisesDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}

	public void TC_02_AGency_Bill_Exe_Promises(DataRow input, DataRow output) {
		
		//1. Click on Actions WebElement
		SleepUtils.sleep(8);
		uiDriver.click("TC_02_AGency_Bill_Exe_Promises.eltActions");
		SleepUtils.sleep(4);

		//2. Click on New_Agency_Bill_Promise WebElement
		uiDriver.click("TC_02_AGency_Bill_Exe_Promises.eltNew_Agency_Bill_Promise");
		SleepUtils.sleep(4);

		//3. Type $data in Promise_Amount field
		uiDriver.setValue("TC_02_AGency_Bill_Exe_Promises.txtPromise_Amount", input.get("Type@Promise_Amount"));
		SleepUtils.sleep(4);

		//4. Click on Add_Statements WebElement
		uiDriver.click("TC_02_AGency_Bill_Exe_Promises.eltAdd_Statements");
		SleepUtils.sleep(4);

		//5. Click on Search WebElement
		uiDriver.click("TC_02_AGency_Bill_Exe_Promises.eltSearch");
		SleepUtils.sleep(8);

		//6. Select the Planned ?checkbox
		uiDriver.click("TC_02_AGency_Bill_Exe_Promises.chkPlanned1");
		SleepUtils.sleep(4);

		//7. Click on Add_Statements_1 button
		uiDriver.click("TC_02_AGency_Bill_Exe_Promises.btnAdd_Statements_1");
		SleepUtils.sleep(4);

		//8. Click on Next button
		uiDriver.click("TC_02_AGency_Bill_Exe_Promises.btnNext");
		SleepUtils.sleep(4);

		//9. Click on Suspense items Web Button
		uiDriver.click("TC_02_AGency_Bill_Exe_Promises.btnSusenseItems");
		SleepUtils.sleep(4);		

		//10. Click on Policy element
		uiDriver.click("TC_02_AGency_Bill_Exe_Promises.tblSuspenseItems_Policy");
		SleepUtils.sleep(4);
		uiDriver.setValue("TC_02_AGency_Bill_Exe_Promises.tblSuspenseItems_Policy_1", input.get("Type@PolicyNumber"));
		SleepUtils.sleep(4);

		//11. set value Grass element
		uiDriver.sendKey("tab");
		uiDriver.sendKey("tab");
		uiDriver.sendKey("tab");
		uiDriver.setValue("TC_02_AGency_Bill_Exe_Promises.tblGrossAmnt", input.get("Type@Gross"));
		SleepUtils.sleep(4);

		//12. Set value Commission element
		uiDriver.sendKey("tab");
		uiDriver.setValue("TC_02_AGency_Bill_Exe_Promises.tblCommissionAmnt", input.get("Type@Commission"));
		SleepUtils.sleep(4);

		//13. Click on OK Button
		uiDriver.click("TC_02_AGency_Bill_Exe_Promises.btnOK");

		//14. Click on Next_1 button
		uiDriver.click("TC_02_AGency_Bill_Exe_Promises.btnNext_1");
		SleepUtils.sleep(4);

		//15. Click on Finish button
		uiDriver.click("TC_02_AGency_Bill_Exe_Promises.btnFinish");
		SleepUtils.sleep(4);

		//16. Click on Agency_Bill_Promises WebElement
		uiDriver.click("TC_02_AGency_Bill_Exe_Promises.eltAgency_Bill_Promises");
		SleepUtils.sleep(4);

		//17. Verify the text ?$data in the Amount field
		String eltAmnt="$"+input.get("VerifyText@Amount")+".00";
		if (uiDriver.verifyTextActAndExp("TC_02_AGency_Bill_Exe_Promises.eltAmount", eltAmnt)) {
			passed("verifyText","verifyText should pass","verifyText passed");
		} else {
			failed("verifyText","verifyText should pass","verifyText failed");
		}
		SleepUtils.sleep(4);

	}


	/**
	 *Overriding toString() method of object class to print Update_Agency_Bill_Executed_Promises
	 *format string
	 **/
	public String toString(){
		return "Update_Agency_Bill_Executed_PromisesDriver";
	}
}
