/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 1/18/2018 1:27:32 AM
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
public class MaintainDelinquencyPlansDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;

	public MaintainDelinquencyPlansDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}

	public void TC02_AddEditRem_Del_Plan(DataRow input, DataRow output) {

		// 1. Click on Administration WebElement
		uiDriver.click("SearchBCUsers.eltAdministration");
		SleepUtils.sleep(4);
			
		// 2. Click on Business setting WebElement
		uiDriver.click("US1214TC03_MaintainAgencyBill.eltBusiness_Settings");
		SleepUtils.sleep(4);
		
		// 3. Click on Delinquency plans setting WebElement
		uiDriver.click("MaintainDelinquencyPlans.eltDelinuencyPlans");
		SleepUtils.sleep(4);

		// 4. Click on Plan link
		String planName=uiDriver.th.getCellData("MaintainDelinquencyPlans.tblDelinquencyPlans", 0, 1);
		SleepUtils.sleep(2);
		uiDriver.webDr.findElement(By.xpath("//*[text()='"+planName+"']")).click();
		SleepUtils.sleep(6);
			
		// 5.  Click on Clone  button
		uiDriver.click("MaintainDelinquencyPlans.btnClone");
		SleepUtils.sleep(2);
			
		// 6. Type $data in User_name field
		uiDriver.setValue("MaintainDelinquencyPlans.txtName", input.get("Type@Name"));
		SleepUtils.sleep(2);
		
		// 7. Click on Update  button
		uiDriver.click("MaintainDelinquencyPlans.btnUpdate");
		SleepUtils.sleep(2);
	
		// 8. Click on up to Delinquency plans link
		uiDriver.click("MaintainDelinquencyPlans.lnkUptoDelinquencyPlans");
		SleepUtils.sleep(2);

		// 9. Verify data presented in table
		uiDriver.th.verfiygetCellDataOfColumn("MaintainDelinquencyPlans.tblDelinquencyPlans", input.get("Type@Name"), 1);
		SleepUtils.sleep(4);

		// 10. Click on Plan link
		uiDriver.webDr.findElement(By.xpath("//*[text()='"+input.get("Type@Name")+"']")).click();
		SleepUtils.sleep(6);
			
		// 11. Click on Edit button
		uiDriver.click("MaintainDelinquencyPlans.btnEdit");
		SleepUtils.sleep(2);
		
		// 12. Type $data in User_name field
		uiDriver.setValue("MaintainDelinquencyPlans.txtDelinquencyName", input.get("Type@Name_Edit"));
		SleepUtils.sleep(2);
			
		// 13. Click on work flow element
		uiDriver.click("MaintainDelinquencyPlans.eltWorkflow");
		SleepUtils.sleep(3);
			
		// 14. Click on Add button
		uiDriver.click("MaintainDelinquencyPlans.btnAdd");
		SleepUtils.sleep(4);
		
		// 15. Select $data from the Name list
		uiDriver.setValue("MaintainDelinquencyPlans.txtWorkflowName", input.get("Select@WorkflowName"));
		SleepUtils.sleep(2);
		uiDriver.sendKey("enter");
		SleepUtils.sleep(6);
		
		// 16. Select radio button
		uiDriver.click("MaintainDelinquencyPlans.rdgAutomatic");
		SleepUtils.sleep(4);
		
		// 17. Click on OK Button
		uiDriver.click("MaintainDelinquencyPlans.btnOk");
		SleepUtils.sleep(4);
		
		// 18. Click on General element
		uiDriver.click("MaintainDelinquencyPlans.eltGeneral");
		SleepUtils.sleep(4);

		// 19. Click on Plan link
		String ProgramName=uiDriver.th.getCellData("MaintainDelinquencyPlans.tblDelinquencyPlanDetials", 0, 1);
		SleepUtils.sleep(4);
		
		// 20.Select check box
		uiDriver.th.findRelativeCellAndClickfirstCell("MaintainDelinquencyPlans.tblDelinquencyPlanDetials", ProgramName, 1, ProgramName);
		SleepUtils.sleep(4);
		
		// 21. Click on OK Button
		uiDriver.click("MaintainDelinquencyPlans.btnRemove");
		SleepUtils.sleep(4);
			
		// 22. Click on Update Button
		uiDriver.click("MaintainDelinquencyPlans.btnUpdateDelin");
		SleepUtils.sleep(4);

		// 23. Click on UptoDelinquencyPlans
		uiDriver.click("MaintainDelinquencyPlans.lnkUptoDelinquencyPlans");
		SleepUtils.sleep(4);	
		
		// 24. Verify data presented in table
		uiDriver.th.verfiygetCellDataOfColumn("MaintainDelinquencyPlans.tblDelinquencyPlans", input.get("Type@Name"), 1);
		SleepUtils.sleep(4);

	}


	/**
	 * Overriding toString() method of object class to print Create_Activities
	 * format string
	 **/
	public String toString() {
		return "MaintainDelinquencyPlansDriver";
	}
}