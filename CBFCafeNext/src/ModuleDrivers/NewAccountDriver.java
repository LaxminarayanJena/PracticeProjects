/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 10/3/2017 2:42:35 PM
Module part of 'Guidewire_BillingCenter'
Module created using Cafenext Selenium Builder
******************************************************************************/
package ModuleDrivers;

import static cbf.engine.TestResultLogger.*;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import com.sun.glass.events.KeyEvent;

import cbf.engine.TestResult.ResultType;
import cbf.harness.ParameterAccess;
import cbf.utils.DataRow;
import cbf.utils.SleepUtils;
import cbf.utils.SleepUtils.TimeSlab;
import cbfx.selenium.BaseWebModuleDriver;

/**
 * Extends BaseModuleDriver class and performs application specific operations
 */
public class NewAccountDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;

	public NewAccountDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}

	/**
	 * Create new account script
	 */
	public void CreateNewAcc(DataRow input, DataRow output) {
		// 1. Click on Account WebElement
		uiDriver.click("CreateNewAcc.eltAccount");

		// 2. Click on Actions WebElement
		uiDriver.click("CreateNewAcc.eltActions");

		// 3. Click on NewAccount WebElement
		uiDriver.click("CreateNewAcc.eltNewAccount");

		// 4. Type $data in AccountName field
		uiDriver.setValue("CreateNewAcc.txtAccountName", input.get("Type@AccountName"));

		// 5. Select $data from the InsuredType list
		uiDriver.setValue("CreateNewAcc.lstInsuredType", input.get("Select@InsuredType"));

		// 6. Select $data from the BillingPlan list
		uiDriver.doubleclick("CreateNewAcc.lstBillingPlan");
		uiDriver.setValue("CreateNewAcc.lstBillingPlan", input.get("Select@BillingPlan"));
		uiDriver.sendKey("enter");

		// 7. Select $data from the DelinquencyPlan list
		uiDriver.doubleclick("CreateNewAcc.lstDelinquencyPlan");
		uiDriver.setValue("CreateNewAcc.lstDelinquencyPlan", input.get("Select@DelinquencyPlan"));

		// 8. Select $data from the send invoices by list
		uiDriver.doubleclick("CreateNewAcc.lstSendInvoicesBy");
		uiDriver.setValue("CreateNewAcc.lstSendInvoicesBy", input.get("Select@SendInvoicesBy"));

		// 9. Click on AddContact WebElement
		uiDriver.click("CreateNewAcc.eltAddContact");

		// 10. Click on AddNewCompany WebElement
		uiDriver.click("CreateNewAcc.eltAddNewCompany");

		// 11. Type $data in Name field
		uiDriver.setValue("CreateNewAcc.txtFirstName", input.get("Type@FirstName"));

		// 12. Type $data in Name field
		uiDriver.setValue("CreateNewAcc.txtLastName", input.get("Type@LastName"));

		// 13. Type $data in Addressline1 field
		uiDriver.setValue("CreateNewAcc.txtAddressline1", input.get("Type@Addressline1"));

		// 14. Type $data in City field
		uiDriver.doubleclick("CreateNewAcc.txtCity");
		uiDriver.setValue("CreateNewAcc.txtCity", input.get("Type@City"));

		// 15. Select $data from the State list
		uiDriver.doubleclick("CreateNewAcc.lstState");
		uiDriver.setValue("CreateNewAcc.lstState", input.get("Select@State"));

		// 16. Type $data in ZIPcode field
		uiDriver.doubleclick("CreateNewAcc.txtZIPcode");
		uiDriver.setValue("CreateNewAcc.txtZIPcode", input.get("Type@ZIPcode"));

		// 17. Click the button Standardized address
		SleepUtils.sleep(3);
		uiDriver.click("CreateNewAcc.btnStandardisedAddress");
		SleepUtils.sleep(4);
		
		Boolean bStatus=uiDriver.getControl("CreateNewAcc.btnOverRide").isEnabled();
		if (bStatus==true)
		{
			uiDriver.ElementPrestnclick("CreateNewAcc.btnOverRide");
		
		}
		// 18. Type $data in Phone field
		uiDriver.setValue("CreateNewAcc.txtPhone", input.get("Type@Phone"));

		// 19. Type $data in Email field
		uiDriver.setValue("CreateNewAcc.txtEmail", input.get("Type@Email"));

		// 20. Add Primary Payer
		uiDriver.click("CreateNewAcc.rdgPrimaryPayer");
		SleepUtils.sleep(3);

		// 21. Click on Standardize WebElement
		uiDriver.click("CreateNewAcc.eltAddRole");
		SleepUtils.sleep(4);

		// 22. Role selection
		uiDriver.doubleclick("CreateNewAcc.RoleField");
		SleepUtils.sleep(3);
		uiDriver.setValue("CreateNewAcc.RoleFieldInput", input.get("Type@Role"));
		SleepUtils.sleep(3);
		uiDriver.sendKey("enter");
		SleepUtils.sleep(5);
		uiDriver.doubleclick("CreateNewAcc.OKButton");
		SleepUtils.sleep(5);
		uiDriver.doubleclick("CreateNewAcc.CreateAccountButton");
		SleepUtils.sleep(5);
	}

	public void CancelAndReinstatePolicy(DataRow input, DataRow output) {
		// 1. Click on Policy WebElement
		uiDriver.click("CancelAndReinstatePolicy.eltPolicy");

		// 2. Type $data in PolicyNumber_field field
		uiDriver.setValue("CancelAndReinstatePolicy.txtPolicyNumber_field", input.get("Type@PolicyNumber_field"));

		// 3. Click on Search_Button WebElement
		uiDriver.click("CancelAndReinstatePolicy.eltSearch_Button");

		// 4. Click on PolicyLink Link
		uiDriver.click("CancelAndReinstatePolicy.lnkPolicyLink");

		// 5. Click on Actions_PolicyButton button
		uiDriver.click("CancelAndReinstatePolicy.btnActions_PolicyButton");

		// 6. Click on CancelPolicy_Span WebElement
		uiDriver.click("CancelAndReinstatePolicy.eltCancelPolicy_Span");

		// 7. Type CancelType_Dropdown $Parama1
		uiDriver.setValue("CancelAndReinstatePolicy.eltCancelType_Dropdown", input.get("Type@CancelType_Dropdown"));

		// 8. Click on Next_Button WebElement
		uiDriver.click("CancelAndReinstatePolicy.eltNext_Button");

		// 9. Click on Add_Button WebElement
		uiDriver.click("CancelAndReinstatePolicy.eltAdd_Button");

		// 10. Click on Amount_Nonedit WebElement
		uiDriver.click("CancelAndReinstatePolicy.eltAmount_Nonedit");

		// 11. Type Amount_Field $Parama1
		uiDriver.setValue("CancelAndReinstatePolicy.eltAmount_Field", input.get("Type@Amount_Field"));

		// 12. Click on Finish_Button WebElement
		uiDriver.click("CancelAndReinstatePolicy.eltFinish_Button");

		// 13. Click on ReinstatePolicy_Link WebElement
		uiDriver.click("CancelAndReinstatePolicy.eltReinstatePolicy_Link");

		// 14. Type $data in Effective_Date field
		uiDriver.setValue("CancelAndReinstatePolicy.txtEffective_Date", input.get("Type@Effective_Date"));

		// 15. Click on Reinstate_Next_button WebElement
		uiDriver.click("CancelAndReinstatePolicy.eltReinstate_Next_button");

		// 16. Click on Reinstate_Add WebElement
		uiDriver.click("CancelAndReinstatePolicy.eltReinstate_Add");

		// 17. Click on Amount_Unedited WebElement
		uiDriver.click("CancelAndReinstatePolicy.eltAmount_Unedited");

		// 18. Type Amount_filed $Parama1
		uiDriver.setValue("CancelAndReinstatePolicy.eltAmount_filed", input.get("Type@Amount_filed"));

		// 19. Click on Finish_reinstate button
		uiDriver.click("CancelAndReinstatePolicy.btnFinish_reinstate");

		// 20. Click on Transactions WebElement
		uiDriver.click("CancelAndReinstatePolicy.eltTransactions");

		// 21. Verify the text ?$data in the ChargeType_Reinstatement list
		if (uiDriver.verifyText("CancelAndReinstatePolicy.lstChargeType_Reinstatement",
				input.get("VerifyText@ChargeType_Reinstatement"))) {
			passed("verifyText", "verifyText should pass", "verifyText passed");
		} else {
			failed("verifyText", "verifyText should pass", "verifyText failed");
		}
	}

	/**
	 * Overriding toString() method of object class to print NewAccount format
	 * string
	 **/
	public String toString() {
		return "NewAccountDriver";
	}
}
