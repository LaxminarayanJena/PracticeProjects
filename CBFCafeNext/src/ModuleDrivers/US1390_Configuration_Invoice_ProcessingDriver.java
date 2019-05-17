/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 3/5/2018 5:23:31 AM
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
public class US1390_Configuration_Invoice_ProcessingDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public US1390_Configuration_Invoice_ProcessingDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void Reinstated_Policies_New_InvNum(DataRow input, DataRow output) {
		//1. Click on Policies WebElement
		uiDriver.click("Reinstated_Policies_New_InvNum.eltPolicies");
		
		//2. Click on Activi_Policy WebElement
		uiDriver.th.findRelativeCellWithMultipulTextAndClickfirstCell("Reinstated_Policies_New_InvNum.eltActivi_Policy", "Active|Reinstated",5);
		SleepUtils.sleep(3);
		
		//3. Click on Actions WebElement
		uiDriver.click("Reinstated_Policies_New_InvNum.eltActions");
		
		//4. Click on Cancel_Policy WebElement
		uiDriver.click("Reinstated_Policies_New_InvNum.eltCancel_Policy");
		SleepUtils.sleep(3);
		
		//5. Type $data in Cancel_Reason field
		uiDriver.click("Reinstated_Policies_New_InvNum.txtCancel_Reason");
		SleepUtils.sleep(2);
		uiDriver.setValue("Reinstated_Policies_New_InvNum.txtCancel_Reason", input.get("Type@Cancel_Reason"));
		SleepUtils.sleep(2);
		uiDriver.sendKey("tab");
		SleepUtils.sleep(2);
		
		//6. Select $data from the Cancel_Type list
		uiDriver.click("Reinstated_Policies_New_InvNum.lstCancel_Type");
		SleepUtils.sleep(2);
		uiDriver.setValue("Reinstated_Policies_New_InvNum.lstCancel_Type", input.get("Select@Cancel_Type"));
		SleepUtils.sleep(2);
		uiDriver.sendKey("tab");
	
		//7. Click on Next button
		uiDriver.click("Reinstated_Policies_New_InvNum.btnNext");
		SleepUtils.sleep(2);
		
		//8. Click on Finish button
		uiDriver.click("Reinstated_Policies_New_InvNum.btnFinish");
		SleepUtils.sleep(6);
		
		//9. Click on Actions WebElement
		uiDriver.click("Reinstated_Policies_New_InvNum.eltActions");
		
		//10. Click on Reinstate_Policy WebElement
		uiDriver.click("Reinstated_Policies_New_InvNum.eltReinstate_Policy");
		SleepUtils.sleep(2);
		
		//11. Click on Effective_Date WebElement
		uiDriver.click("Reinstated_Policies_New_InvNum.eltEffective_Date");
		SleepUtils.sleep(1);
		
		//12. Click on Enter_Key WebElement
		uiDriver.sendKey("enter");
		
		//13. Click on Next button
		uiDriver.click("Reinstated_Policies_New_InvNum.btnNext");
		
		//14. Click on Add button
		uiDriver.click("Reinstated_Policies_New_InvNum.btnAdd");
		
		//15. Click on Premium WebElement
		uiDriver.click("Reinstated_Policies_New_InvNum.eltPremium");
		
		//16. Select $data from the Type list
		uiDriver.click("Reinstated_Policies_New_InvNum.lstType");
		SleepUtils.sleep(1);
		uiDriver.setValue("Reinstated_Policies_New_InvNum.lstType", input.get("Select@Type"));
		SleepUtils.sleep(1);
		uiDriver.sendKey("tab");
		SleepUtils.sleep(1);
		
		//17. Click on _ WebElement
		uiDriver.click("Reinstated_Policies_New_InvNum.elt_");
		SleepUtils.sleep(2);
		
		//18. Type $data in Amount field
		uiDriver.setValue("Reinstated_Policies_New_InvNum.txtAmount", input.get("Type@Amount"));
		
		//19. Click on Finish button
		uiDriver.click("Reinstated_Policies_New_InvNum.btnFinish");
		SleepUtils.sleep(6);
		
		//20. Click on Poicy_Account WebElement
		uiDriver.click("Reinstated_Policies_New_InvNum.eltPoicy_Account");
		
		//21. Click on Invoices WebElement
		uiDriver.click("Reinstated_Policies_New_InvNum.eltInvoices");
		
		//22. Verify Invoice_Number
		String SearchString="$"+input.get("Type@Amount")+".00";
		uiDriver.th.getCellDataOfCol("Reinstated_Policies_New_InvNum.tblInvoice_Number", SearchString, 6);
		SleepUtils.sleep(3);
		uiDriver.HotKeys("T");
		SleepUtils.sleep(6);
		String Search=input.get("ColumnNum@Installment");
		String sText=input.get("ColumnNum@Installment");
		uiDriver.th.findRelativeCellAndClickSelectedCellInSubtext("US1212_NewCrditDistribution.tblId1",Search, 0 ,sText,"RunStopDownload History","Run");
		SleepUtils.sleep(6);
		
		//23. Verify whether the Total_Current_Due element present
		if (uiDriver.checkElementPresent("Reinstated_Policies_New_InvNum.eltTotal_Current_Due")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		
		//24. Verify whether the Total_Balance_Due element present
		if (uiDriver.checkElementPresent("Reinstated_Policies_New_InvNum.eltTotal_Balance_Due")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		
		//25. Verify whether the Current_Due element present
		if (uiDriver.checkElementPresent("Reinstated_Policies_New_InvNum.eltCurrent_Due")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		
	}
	

	/**
	*Overriding toString() method of object class to print US1390_Configuration_Invoice_Processing
	*format string
	**/
	public String toString(){
		return "US1390_Configuration_Invoice_ProcessingDriver";
	}
}
