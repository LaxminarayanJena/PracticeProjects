/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 10/3/2017 2:42:35 PM
Module part of 'Guidewire_BillingCenter'
Module created using Cafenext Selenium Builder
******************************************************************************/
package ModuleDrivers;

import static cbf.engine.TestResultLogger.*;
import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import cbf.engine.TestResult.ResultType;
import cbf.harness.ParameterAccess;
import cbf.utils.DataRow;
import cbf.utils.SleepUtils;
import cbf.utils.SleepUtils.TimeSlab;
import cbfx.selenium.BaseWebModuleDriver;

/**
 * Extends BaseModuleDriver class and performs application specific operations
 */
public class PolicyDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;

	public PolicyDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}

	public void AddPolicy(DataRow input, DataRow output) {

		// 1. Click on Account tab
		uiDriver.click("AddPolicy.tbaccount");

		// 2. Enter the Account Number
		uiDriver.click("AddPolicy.txtAccountNo");
		uiDriver.setValue("AddPolicy.txtAccountNo", input.get("Type@AccountNumber"));

		// 3. Click on search button
		uiDriver.click("AddPolicy.btnsearch");
		SleepUtils.sleep(3);

		// 4. Sorting the Account number for the latest
		uiDriver.click("Accountsearch.btnsort1");
		uiDriver.click("Accountsearch.btnsort");
		uiDriver.sendKey("keysdown");
		uiDriver.sendKey("keysdown");
		uiDriver.sendKey("enter");
		SleepUtils.sleep(3);

		// 5. Click on searched account
		uiDriver.click("AddPolicy.lnkaccount");
		SleepUtils.sleep(2);

		// 6. Click on Actions WebElement
		uiDriver.click("AddPolicy.eltActions");
		SleepUtils.sleep(2);

		// 7. Click on AddPolicy WebElement
		uiDriver.click("AddPolicy.eltAddPolicy");
		SleepUtils.sleep(2);

		// 8. Verify whether the NewPolicy element present
		if (uiDriver.checkElementPresent("AddPolicy.txtPolicyNumber")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 9. Create the PolicyNumber field randomly
		Random rand = new Random();
		int n = rand.nextInt(1000000) + 100000;
		uiDriver.setValue("AddPolicy.txtPolicyNumber", "EBD" + Integer.toString(n));

		// 10. Type Effect date
		uiDriver.clear("AddPolicy.txteffectdate");
		uiDriver.setValue("AddPolicy.txteffectdate", input.get("Type@Effective Date"));

		// 11. Type Expiration date
		uiDriver.clear("AddPolicy.txtexpirationdate");
		uiDriver.setValue("AddPolicy.txtexpirationdate", input.get("Type@Expiration Date"));

		// 12. Select the product
		uiDriver.click("AddPolicy.txtProcuct");
		uiDriver.clear("AddPolicy.txtProcuct");
		uiDriver.setValue("AddPolicy.txtProcuct", input.get("Select@Product"));

		// 13. Click UWComp
		uiDriver.click("AddPolicy.txtUWComp");

		// 14. Select $data from the UWComp list
		uiDriver.clear("AddPolicy.txtUWComp");
		uiDriver.setValue("AddPolicy.txtUWComp", input.get("Select@UWComp"));

		// 15. Click PaymentPlan
		uiDriver.click("AddPolicy.txtPaymentPlan");

		// 16. Select $data from the PaymentPlan list
		uiDriver.doubleclick("AddPolicy.txtPaymentPlan");
		uiDriver.setValue("AddPolicy.txtPaymentPlan", input.get("Select@PaymentPlan"));

		// 17. Click on Search image
		uiDriver.click("AddPolicy.imgSearch");
		SleepUtils.sleep(3);

		// 18. Type $data in ProducerCode field
		uiDriver.setValue("AddPolicy.txtProducerCode", input.get("Type@ProducerCode"));

		// 19. Click on Search Link
		uiDriver.click("AddPolicy.lnkSearch");
		SleepUtils.sleep(3);

		// 20. Click on Select WebElement
		uiDriver.click("AddPolicy.eltSelect");

		// 21. Select $data from the Rating_Source list
		uiDriver.doubleclick("AddPolicy.lstRating_Source");
		uiDriver.clear("AddPolicy.lstRating_Source");
		uiDriver.setValue("AddPolicy.lstRating_Source", input.get("Select@Rating_Source"));
		uiDriver.sendKey("tab");
		SleepUtils.sleep(3);

		// 22. Select Program list
		uiDriver.doubleclick("AddPolicy.lstProgram");
		uiDriver.clear("AddPolicy.lstProgram");
		uiDriver.setValue("AddPolicy.lstProgram", input.get("Select@Program"));
		uiDriver.sendKey("tab");
		SleepUtils.sleep(3);

		// 23. Select Policy Type list
		uiDriver.doubleclick("AddPolicy.lstPolicyType");
		uiDriver.clear("AddPolicy.lstPolicyType");
		uiDriver.setValue("AddPolicy.lstPolicyType", input.get("Select@PolicyType"));
		uiDriver.sendKey("tab");
		SleepUtils.sleep(3);

		// 24. Select $data from the PolicyStatus list
		uiDriver.doubleclick("AddPolicy.lstPolicyStatus");
		uiDriver.clear("AddPolicy.lstPolicyStatus");
		uiDriver.setValue("AddPolicy.lstPolicyStatus", input.get("Select@PolicyStatus"));
		uiDriver.sendKey("tab");
		SleepUtils.sleep(3);

		// 15. Select $data from the Region list
		uiDriver.doubleclick("AddPolicy.lstRegion");
		uiDriver.clear("AddPolicy.lstRegion");
		uiDriver.setValue("AddPolicy.lstRegion", input.get("Select@Region"));
		uiDriver.sendKey("tab");
		SleepUtils.sleep(3);
	}

	public void SubmitPolicy(DataRow input, DataRow output) {
		// 1. Click on NextButton WebElement
		uiDriver.click("SubmitPolicy.eltNextButton");

		// 2. Click on Add WebElement
		uiDriver.click("SubmitPolicy.eltAdd");

		// 3. Type $data in Amount field
		uiDriver.doubleclick("SubmitPolicy.AddAmountNonEdit");
		uiDriver.clear("SubmitPolicy.AddAmountEditable");
		uiDriver.setValue("SubmitPolicy.AddAmountEditable", input.get("Type@Amount"));
		SleepUtils.sleep(3);

		// 4. Click on NextButtonAmount WebElement
		uiDriver.click("SubmitPolicy.eltNextButtonAmount");
		SleepUtils.sleep(3);

		// 5. Type $data in Write_Percentage field
		uiDriver.clear("SubmitPolicy.txtWrite_Percentage");
		uiDriver.setValue("SubmitPolicy.txtWrite_Percentage", input.get("Type@Write_Percentage"));
		SleepUtils.sleep(3);

		// 6. Click on Finish WebElement
		uiDriver.click("SubmitPolicy.eltFinish");
		SleepUtils.sleep(3);
	}

	public void CreateNewPersonContact(DataRow input, DataRow output) {
		// 1. Click on Add_Button WebElement
		uiDriver.click("CreateNewPersonContact.eltAdd_Button");

		// 2. Click on Add_New_Person WebElement
		uiDriver.click("CreateNewPersonContact.eltAdd_Add New_Company");

		// 3. Type $data in First_Name field
		uiDriver.setValue("CreateNewPersonContact.txtFirst_Name", input.get("Type@First_Name"));

		// 5. Type $data in Address1 field
		uiDriver.setValue("CreateNewPersonContact.txtAddress1", input.get("Type@Address1"));

		// 6. Type $data in City field
		uiDriver.setValue("CreateNewPersonContact.txtCity", input.get("Type@City"));
		SleepUtils.sleep(2);

		// 7. Type $data in City field
		uiDriver.doubleclick("CreateNewPersonContact.txtState");
		uiDriver.setValue("CreateNewPersonContact.txtState", input.get("Select@State"));
		uiDriver.sendKey("keysdown");
		uiDriver.sendKey("enter");
		SleepUtils.sleep(2);

		// 8. Type $data in Zip_Code field
		uiDriver.setValue("CreateNewPersonContact.txtZip_Code", input.get("Type@Zip_Code"));
		SleepUtils.sleep(2);

		// 9. Type $data in Phone field
		uiDriver.setValue("CreateNewPersonContact.txtPhone", input.get("Type@Phone"));
		SleepUtils.sleep(2);

		// 10. Type $data in email field
		uiDriver.setValue("CreateNewPersonContact.txtemail", input.get("Type@email"));
		SleepUtils.sleep(3);

		// 11. Click on Add_Button WebElement
		uiDriver.click("CreateNewPersonContact.eltAdd_Button_Person");
		SleepUtils.sleep(3);

		// 12. Type $data in Role field
		uiDriver.doubleclick("CreateNewPersonContact.txtRole");
		SleepUtils.sleep(3);

		// 13. Type $data in Role field
		uiDriver.setValue("CreateNewPersonContact.txtRole_Edit", input.get("Type@Role"));
		SleepUtils.sleep(3);

		// 14. Click on Standaridsed button
		uiDriver.click("CreateNewPersonContact.btnStandardisedAddress");
		SleepUtils.sleep(3);

		// 15. To handle override button
		Boolean bStatus = uiDriver.getControl("CreateNewPersonContact.btnOverRide").isEnabled();
		if (bStatus == true) {
			uiDriver.ElementPrestnclick("CreateNewPersonContact.btnOverRide");
		}
		SleepUtils.sleep(3);

		// 16. Click on Ok Button
		uiDriver.click("CreateNewPersonContact.eltOK_Button");
		SleepUtils.sleep(3);
		SleepUtils.sleep(3);

		// 17. Click on Select_Link WebElement
		uiDriver.click("CreateNewPersonContact.eltSelect_Link");
		SleepUtils.sleep(3);
	}

	public void Change_Policy(DataRow input, DataRow output) {
		// 1. Click on Click_on_Policy_Tab WebElement
		uiDriver.click("Change_Policy.eltClick_on_Policy_Tab");

		// 2. Type $data in Enter_policy_number field
		uiDriver.setValue("Change_Policy.txtEnter_policy_number", input.get("Type@Enter_policy_number"));

		// 3. Click on Click_on_Search_Link Link
		uiDriver.click("Change_Policy.lnkClick_on_Search_Link");

		// 4. Click on Click_on_Policy WebElement
		uiDriver.click("Change_Policy.eltClick_on_Policy");

		// 5. Click on Click_on_Actions WebElement
		uiDriver.click("Change_Policy.eltClick_on_Actions");

		// 6. Click on Click_on_change_policy WebElement
		uiDriver.click("Change_Policy.eltClick_on_change_policy");

		// 7. Click on Next_Button WebElement
		uiDriver.click("Change_Policy.eltNext_Button");
		SleepUtils.sleep(5);

		// 8. Type $data in Enter_Date field
		uiDriver.setValue("Change_Policy.txtEnter_Date", input.get("Type@Enter_Date"));

		// 9. Click on Click_on_Add_Button WebElement
		uiDriver.click("Change_Policy.eltClick_on_Add_Button");

		// 10. Click on Enter_Amount WebElement
		uiDriver.click("Change_Policy.eltEnter_Amount");
		SleepUtils.sleep(5);

		// 11. Click on Finish WebElement
		uiDriver.click("Change_Policy.eltFinish");
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
		uiDriver.clear("CancelAndReinstatePolicy.eltCancelType_Dropdown");
		uiDriver.setValue("CancelAndReinstatePolicy.eltCancelType_Dropdown", input.get("Type@CancelType_Dropdown"));

		// 8. Click on Next_Button WebElement
		uiDriver.click("CancelAndReinstatePolicy.eltNext_Button");

		// 9. Click on Add_Button WebElement
		uiDriver.click("CancelAndReinstatePolicy.eltAdd_Button");

		// 10. Click on Amount_Nonedit WebElement
		uiDriver.click("CancelAndReinstatePolicy.eltAmount_Nonedit");

		// 11. Type Amount_Field $Parama1
		uiDriver.clear("CancelAndReinstatePolicy.eltAmount_Field");
		uiDriver.setValue("CancelAndReinstatePolicy.eltAmount_Field", input.get("Type@Amount_Field"));

		// 12. Click on Finish_Button WebElement
		uiDriver.click("CancelAndReinstatePolicy.eltFinish_Button");

		// 12-1. Click on Actions_PolicyButton button
		uiDriver.click("CancelAndReinstatePolicy.btnActions_PolicyButton");

		// 13. Click on ReinstatePolicy_Link WebElement
		uiDriver.click("CancelAndReinstatePolicy.eltReinstatePolicy_Link");

		// 14. Type $data in Effective_Date field
		uiDriver.setValue("CancelAndReinstatePolicy.txtEffective_Date", input.get("Type@Effective_Date"));

		// 15. Click on Reinstate_Next_button WebElement
		uiDriver.click("CancelAndReinstatePolicy.eltReinstate_Next_button");

		// 16. Click on Reinstate_Add WebElement
		uiDriver.click("CancelAndReinstatePolicy.eltReinstate_Add");

		// 17. Click on Amount_Unedited WebElement
		SleepUtils.sleep(2);
		uiDriver.click("CancelAndReinstatePolicy.eltAmount_Unedited");
		SleepUtils.sleep(2);
		uiDriver.clear("CancelAndReinstatePolicy.eltAmount_filed");
		SleepUtils.sleep(2);

		// 18. Type Amount_filed $Parama1
		SleepUtils.sleep(2);
		uiDriver.setValue("CancelAndReinstatePolicy.eltAmount_filed", input.get("Type@Amount_filed"));
		SleepUtils.sleep(2);

		// 19. Click on Finish_reinstate button
		SleepUtils.sleep(2);
		uiDriver.click("CancelAndReinstatePolicy.btnFinish_reinstate");
		SleepUtils.sleep(2);

		// 20. Click on Transactions WebElement
		SleepUtils.sleep(2);
		uiDriver.click("CancelAndReinstatePolicy.eltTransactions");
		SleepUtils.sleep(2);
	}

	/**
	 * Overriding toString() method of object class to print Policy format string
	 **/
	public String toString() {
		return "PolicyDriver";
	}
}
