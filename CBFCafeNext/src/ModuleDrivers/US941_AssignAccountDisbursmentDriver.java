/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 5/9/2018 5:57:04 AM
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
public class US941_AssignAccountDisbursmentDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public US941_AssignAccountDisbursmentDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void US941_AssignAccountDisbursment(DataRow input, DataRow output) {
		//1. Click on Administration WebElement
		uiDriver.click("US941_AssignAccountDisbursment.eltAdministration");
		
		//2. Click on Groups WebElement
		uiDriver.click("US941_AssignAccountDisbursment.eltGroups");
		
		//3. Type $data in Paging field
		uiDriver.setValue("US941_AssignAccountDisbursment.txtPaging", input.get("Type@Paging"));
		uiDriver.sendKey("Enter");
		SleepUtils.sleep(4);
		
		//5. Click on CS_Ops Link
		uiDriver.th.findRelativeCellAndClickSelectedCellAndSubtext("US941_AssignAccountDisbursment.lnkCS_Ops", "CS Ops", 0, "CS Ops", "CS Ops", "CS Ops");
		SleepUtils.sleep(4);
		
		// 6. Click on Account WebElement
		uiDriver.click("US941_AssignAccountDisbursment.eltAccount");
		SleepUtils.sleep(4);

		// 7. Type $data in Account_Name field
		uiDriver.setValue("US941_AssignAccountDisbursment.txtAccount", input.get("Type@Account_Number"));
		SleepUtils.sleep(4);

		// 8. Click on Search button
		uiDriver.click("US941_AssignAccountDisbursment.btnSearch");
		SleepUtils.sleep(4);
		
		// 9. Verify whether the Account element present
		if (uiDriver.checkElementPresent("US941_AssignAccountDisbursment.eltAccount")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(4);

		// 10. Click on Account Link
		uiDriver.click("US941_AssignAccountDisbursment.lnkAccount_");
		SleepUtils.sleep(4);

		//11. Click on Actions button
		uiDriver.click("US941_AssignAccountDisbursment.btnActions");
		SleepUtils.sleep(4);

		// 12. Click on New_Transaction WebElement
		uiDriver.click("US941_AssignAccountDisbursment.eltNew_Transaction");
		SleepUtils.sleep(4);

		// 13. Click on Disbursement WebElement
		uiDriver.click("US941_AssignAccountDisbursment.eltDisbursement");
		SleepUtils.sleep(4);

		// 14. Type $data in Amount field
		uiDriver.setValue("US941_AssignAccountDisbursment.txtAmount", input.get("Type@Amount"));
		SleepUtils.sleep(4);

		// 15. Click Reason_for_Disbursement
		uiDriver.click("US941_AssignAccountDisbursment.txtReason_for_Disbursement");
		SleepUtils.sleep(4);

		// 16. Select $data from the Reason_for_Disbursement list
		uiDriver.setValue("US941_AssignAccountDisbursment.lstReason_for_Disbursement",
				input.get("Select@Reason_for_Disbursement"));
		SleepUtils.sleep(4);

		// 17. Click on Next button 
		uiDriver.click("US941_AssignAccountDisbursment.btnNext");
		SleepUtils.sleep(6);

		// 18. Click on Finish button
		uiDriver.click("US941_AssignAccountDisbursment.btnFinish");
		SleepUtils.sleep(5);
		
	}
	

	/**
	*Overriding toString() method of object class to print US941_AssignAccountDisbursment
	*format string
	**/
	public String toString(){
		return "US941_AssignAccountDisbursmentDriver";
	}
}
