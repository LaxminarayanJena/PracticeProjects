/******************************************************************************
Created by :Cap Gemini Automation Team
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
public class Manage_Agency_Bill_Suspense_ItemsDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public Manage_Agency_Bill_Suspense_ItemsDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void TC_02_Executed_Payments_01(DataRow input, DataRow output) {
				
		//1. Click on Agency Bill Payments WebElement
		SleepUtils.sleep(8);
		uiDriver.click("TC01_Validate_Newly_Added_Feat.eltAgency_Bill_Payments");
		SleepUtils.sleep(10);
		
		//2. Click on Executed Payments WebElement
		uiDriver.click("TC01_Validate_Newly_Added_Feat.eltExecuted_Payments");
		SleepUtils.sleep(4);	
		uiDriver.click("TC01_Validate_Newly_Added_Feat.lstPaymentRecived");
		SleepUtils.sleep(4);
		uiDriver.setValue("TC01_Validate_Newly_Added_Feat.lstPaymentRecived", "All");
		SleepUtils.sleep(4);
		uiDriver.sendKey("enter");
		SleepUtils.sleep(5);

		//3. Select the Executed  Payment ?checkbox 
		SleepUtils.sleep(4);
		uiDriver.th.findRelativeCellAndClickfirstCell("TC01_Validate_Newly_Added_Feat.chkReversed_No1", "No", 8, "No");
		SleepUtils.sleep(4);
		
		//4. Click on Edit Web Button
		uiDriver.click("TC01_Validate_Newly_Added_Feat.btnEdit");
		SleepUtils.sleep(4);
		
		//5. Click on AddStatements button
		uiDriver.click("TC03_Editanddiscardagencybillp.btnAddStatements");
		SleepUtils.sleep(3);

		//6. Click on Search_1 button
		uiDriver.click("TC03_Editanddiscardagencybillp.btnSearch_1");
		SleepUtils.sleep(3);

		//7. Click on the CheckBox
		uiDriver.th.findRelativeCellAndClickfirstCell("TC03_Editanddiscardagencybillp.tblAgencyDistribution","Open", 2 ,"Open");
		SleepUtils.sleep(3);

		//8. Click on AddStatements_1 button
		uiDriver.click("TC03_Editanddiscardagencybillp.btnAddStatements_1");
		SleepUtils.sleep(3);

		//9. Click on Next button
		uiDriver.click("TC03_Editanddiscardagencybillp.btnNext");
		SleepUtils.sleep(3);
		
		//10. Click on Next Web Button
		uiDriver.click("TC_02_AGency_Bill_Exe_Promises.btnNext");
		SleepUtils.sleep(8);

		//11. Click on Suspense items Web Button
		uiDriver.click("TC_02_Executed_Payments_01.btnSusenseItems");
		SleepUtils.sleep(4);		
		
		//12. Click on Policy element
		uiDriver.click("TC_02_Executed_Payments_01.tblSuspenseItems_Policy");
		SleepUtils.sleep(4);
		uiDriver.setValue("TC_02_Executed_Payments_01.tblSuspenseItems_Policy_1", input.get("Type@PolicyNumber"));
		SleepUtils.sleep(4);
		
		//13. set value Grass element
		uiDriver.sendKey("tab");
		uiDriver.sendKey("tab");
		uiDriver.sendKey("tab");
		uiDriver.setValue("TC_02_Executed_Payments_01.tblGrossAmnt", input.get("Type@Gross"));
		SleepUtils.sleep(4);
		
		//14. Set value Commission element
		uiDriver.sendKey("tab");
		uiDriver.setValue("TC_02_Executed_Payments_01.tblCommissionAmnt", input.get("Type@Commission"));
		SleepUtils.sleep(4);
		
		//15. Click on OK Button
		uiDriver.click("TC_02_Executed_Payments_01.btnOK");
		
		//16. Click on Next Web Button
		uiDriver.click("TC_02_AGency_Bill_Exe_Promises.btnNext");
		SleepUtils.sleep(4);
		
		//17. Click on Finish Web Button
		uiDriver.click("TC_02_AGency_Bill_Exe_Promises.btnFinish");
		SleepUtils.sleep(4);
		
		//18. Click on Agency Bill Payments WebElement
		uiDriver.click("TC01_Validate_Newly_Added_Feat.eltAgency_Bill_Payments");
		SleepUtils.sleep(10);
		
		//19.Click on Executed Payments WebElement
		uiDriver.click("TC01_Validate_Newly_Added_Feat.eltExecuted_Payments");
		SleepUtils.sleep(4);
		
		//20. Select the Executed  Payment ?checkbox
		uiDriver.th.findRelativeCellAndClickfirstCell("TC01_Validate_Newly_Added_Feat.chkReversed_No1", "No", 8, "No");
		SleepUtils.sleep(4);
		
		//21.Click on Executed Payments WebElement
		if (uiDriver.checkElementPresent("TC_02_Executed_Payments_01.btnViewSuspenseItems")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(4);
		uiDriver.click("TC_02_Executed_Payments_01.btnViewSuspenseItems");
		SleepUtils.sleep(4);
		
		//22.Click on Executed Payments WebElement
		String GrAmnt="$"+input.get("Type@Gross")+".00";
		uiDriver.th.getCellDataOfCol("TC_02_Executed_Payments_01.tblSuspendItemele",GrAmnt, 4);
		SleepUtils.sleep(4);
		
		//23.Click on Executed Payments WebElement
		uiDriver.click("TC_02_Executed_Payments_01.lnkAgencySuspenseItems");
		SleepUtils.sleep(4);
	}
	
	public void TC02_Agency_Bill_Sus_Items(DataRow input, DataRow output) {
		SleepUtils.sleep(8);
		//1. Click on Actions WebElement
		uiDriver.click("TC_02_AGency_Bill_Exe_Promises.eltActions");
		SleepUtils.sleep(4);
		
		//2. Click on New_Agency_Bill_Promise WebElement
		uiDriver.click("TC02_AgencyBill_ExistingFunds.eltNewAgencyCreditDistribution");
		SleepUtils.sleep(4);
		
		//3. Click on Add_Statements WebElement
		uiDriver.click("TC_02_AGency_Bill_Exe_Promises.eltAdd_Statements");
		SleepUtils.sleep(4);
		
		//4. Click on Search WebElement
		uiDriver.click("TC_02_AGency_Bill_Exe_Promises.eltSearch");
		SleepUtils.sleep(8);
		
		//5. Select the Planned ?checkbox
		uiDriver.click("TC_02_AGency_Bill_Exe_Promises.chkPlanned1");
		SleepUtils.sleep(4);

		//6. Click on Add_Statements_1 button
		uiDriver.click("TC_02_AGency_Bill_Exe_Promises.btnAdd_Statements_1");
		SleepUtils.sleep(4);
		
		//7. Click on Next button
		uiDriver.click("TC_02_AGency_Bill_Exe_Promises.btnNext");
		SleepUtils.sleep(4);
		
		//8. Click on Suspense button
		uiDriver.click("TC_02_Executed_Payments_01.btnSusenseItems");
		SleepUtils.sleep(4);
			
		//9. Click on OK button
		uiDriver.click("TC_02_Executed_Payments_01.tblAcPolicy");
		SleepUtils.sleep(4);
		uiDriver.setValue("TC_02_Executed_Payments_01.tblAcPolicy_1", input.get("Type@PolicyNumber"));
		SleepUtils.sleep(4);
		
		//10. set value Grass element
		uiDriver.sendKey("tab");
		uiDriver.sendKey("tab");
		uiDriver.sendKey("tab");
		uiDriver.setValue("TC_02_Executed_Payments_01.tblGrossAmnt", input.get("Type@Gross"));
		SleepUtils.sleep(4);
		
		//11. Set value Commission element
		uiDriver.sendKey("tab");
		uiDriver.setValue("TC_02_Executed_Payments_01.tblCommissionAmnt", input.get("Type@Commission"));
		SleepUtils.sleep(4);
		
		//12. Click on OK Button
		uiDriver.click("TC_02_Executed_Payments_01.btnOK");
		
		//13. Click on Save Button
		uiDriver.click("TC_02_AGency_Bill_Exe_Promises.btnSave");
		SleepUtils.sleep(8);
		uiDriver.setValue("TC_02_Executed_Payments_01.txtName", input.get("Type@Name"));
		uiDriver.sendKey("enter");
		SleepUtils.sleep(4);
		uiDriver.click("TC_02_AGency_Bill_Exe_Promises.btnOk");
		SleepUtils.sleep(4);
		
		//14. Click on Agency Bill Payments WebElement
		uiDriver.click("TC01_Validate_Newly_Added_Feat.eltAgency_Bill_Payments");
		SleepUtils.sleep(10);
		
		uiDriver.click("TC_02_Executed_Payments_01.eltSavedPayments");
		SleepUtils.sleep(4);
		
		//15. Select saved payment 
		uiDriver.th.findRelativeCellAndClickfirstCell("TC_02_Executed_Payments_01.tblSavedPayments", input.get("Type@Name"), 4, input.get("Type@Name"));
		SleepUtils.sleep(4);
		
		//16. Click on Edit/Continue With Saved Payment Button
		uiDriver.click("TC_02_Executed_Payments_01.btnEditSaved");
		SleepUtils.sleep(4);
		
		//17. Click on Next button
		uiDriver.click("TC_02_AGency_Bill_Exe_Promises.btnNext");
		SleepUtils.sleep(4);
		
		//18. Click on Next button
		uiDriver.click("TC_02_AGency_Bill_Exe_Promises.btnNext");
		SleepUtils.sleep(4);
		
		//19. Click on Next button
		uiDriver.click("TC_02_AGency_Bill_Exe_Promises.btnFinish");
		SleepUtils.sleep(4);
		
		//20. Click on Agency Bill Payments WebElement
		uiDriver.click("TC01_Validate_Newly_Added_Feat.eltAgency_Bill_Payments");
		SleepUtils.sleep(10);
		uiDriver.click("TC01_Validate_Newly_Added_Feat.eltCredit_Distributions");
		SleepUtils.sleep(4);
		
		//21. Select saved payment '''input.get("Type@Commission")
		uiDriver.th.findRelativeCellAndClickfirstCell("TC01_Validate_Newly_Added_Feat.chkReversed_No", "No", 2, "No");
		SleepUtils.sleep(6);
        
		//22. Click on ViewEdit button
		uiDriver.click("TC_02_Executed_Payments_01.btnViewSupensItem");
		SleepUtils.sleep(4);
		
		//23.Click on Executed Payments WebElement
		uiDriver.th.getCellDataOfCol("TC_02_Executed_Payments_01.tblAcSupnedIt", input.get("Type@Gross"), 4);
		SleepUtils.sleep(4);
		
		//24.Click on Executed Payments WebElement
		uiDriver.click("TC_02_Executed_Payments_01.lnkAgencySuspenseItems");
		SleepUtils.sleep(4);

	}
	
	public void TC03_NotHav_Agency_Bill_Sus_Ite(DataRow input, DataRow output) {
		
		//1. Click on Actions WebElement
		uiDriver.click("TC_02_AGency_Bill_Exe_Promises.eltActions");
		SleepUtils.sleep(4);
		
		//2. Verify whether the Request_for_Direct_Bill_Team element present
		if (!uiDriver.checkElementPresent("TC02_AgencyBill_ExistingFunds.eltNewAgencyCreditDistribution")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		uiDriver.click("TC_02_AGency_Bill_Exe_Promises.eltActions");
		SleepUtils.sleep(4);
		
		//3. Click on Agency Bill Payments WebElement
		uiDriver.click("TC01_Validate_Newly_Added_Feat.eltAgency_Bill_Payments");
		SleepUtils.sleep(9);
		
		//4.Click on Executed Payments WebElement
		uiDriver.click("TC01_Validate_Newly_Added_Feat.eltExecuted_Payments");
		SleepUtils.sleep(4);
		
		//5.Click on Executed Payments WebElement
		uiDriver.setValue("TC01_Validate_Newly_Added_Feat.lstPaymentRecived", "All");
		uiDriver.sendKey("enter");
		SleepUtils.sleep(4);
		
		//6. Select the Executed  Payment ?checkbox 
		uiDriver.th.findRelativeCellAndClickfirstCell("TC01_Validate_Newly_Added_Feat.chkReversed_No1", "No",8, "No");
		SleepUtils.sleep(8);
		
		//7.verify edit is in disabled status
		if (uiDriver.checkElementPresent("TC01_Validate_Newly_Added_Feat.btnEdit")) {
			passed("Edit button", "EditButton Is dissabled should pass", "EditButton Is dissabled passed");
		} else {
			failed("Edit button", "EditButton Is dissabled should pass", "EditButton Is not dissabled failed");
		}
		uiDriver.click("TC01_Validate_Newly_Added_Feat.btnEdit");
		SleepUtils.sleep(5);
		
		
	}

	/**
	*Overriding toString() method of object class to print Update_Agency_Bill_Executed_Promises
	*format string
	**/
	public String toString(){
		return "Manage_Agency_Bill_Suspense_ItemsDriver";
	}
}
