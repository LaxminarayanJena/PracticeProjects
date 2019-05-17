/******************************************************************************
Created by : at1
Created\Updated on : 10/3/2017 2:42:35 PM
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
public class PolicyDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public PolicyDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void AddPolicy(DataRow input, DataRow output) {
		//1. Click on Actions WebElement
		uiDriver.click("AddPolicy.eltActions");
		
		//2. Click on AddPolicy WebElement
		uiDriver.click("AddPolicy.eltAddPolicy");
		
		//3. Verify whether the NewPolicy element present
		if (uiDriver.checkElementPresent("AddPolicy.eltNewPolicy", 15000)) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		
		//4. Type $data in PolicyNumber field
		uiDriver.setValue("AddPolicy.txtPolicyNumber", input.get("Type@PolicyNumber"));
		
		//5. Click UWComp
		uiDriver.click("AddPolicy.txtUWComp");
		
		//6. Select $data from the UWComp list
		uiDriver.setValue("AddPolicy.lstUWComp", input.get("Select@UWComp"));
		
		//7. Click PaymentPlan
		uiDriver.click("AddPolicy.txtPaymentPlan");
		
		//8. Select $data from the PaymentPlan list
		uiDriver.setValue("AddPolicy.lstPaymentPlan", input.get("Select@PaymentPlan"));
		
		//9. Click on Search image
		uiDriver.click("AddPolicy.imgSearch");
		
		//10. Verify whether the SearchProducer element present
		if (uiDriver.checkElementPresent("AddPolicy.eltSearchProducer", 15000)) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		
		//11. Type $data in ProducerCode field
		uiDriver.setValue("AddPolicy.txtProducerCode", input.get("Type@ProducerCode"));
		
		//12. Click on Search Link
		uiDriver.click("AddPolicy.lnkSearch");
		
		//13. Click on Select WebElement
		uiDriver.click("AddPolicy.eltSelect");
		
		//14. Select $data from the Rating_Source list
		uiDriver.setValue("AddPolicy.lstRating_Source", input.get("Select@Rating_Source"));
		
		//15. Select $data from the Program list
		uiDriver.setValue("AddPolicy.lstProgram", input.get("Select@Program"));
		
		//16. Select $data from the PolicyType list
		uiDriver.setValue("AddPolicy.lstPolicyType", input.get("Select@PolicyType"));
		
		//17. Select $data from the PolicyStatus list
		uiDriver.setValue("AddPolicy.lstPolicyStatus", input.get("Select@PolicyStatus"));
		
		//18. Select $data from the Region list
		uiDriver.setValue("AddPolicy.lstRegion", input.get("Select@Region"));
		
	}
	
	public void SubmitPolicy(DataRow input, DataRow output) {
		//1. Click on NextButton WebElement
		uiDriver.click("SubmitPolicy.eltNextButton");
		
		//2. Click on Add WebElement
		uiDriver.click("SubmitPolicy.eltAdd");
		
		//3. Type $data in Amount field
		uiDriver.setValue("SubmitPolicy.txtAmount", input.get("Type@Amount"));
		
		//4. Click on NextButtonAmount WebElement
		uiDriver.click("SubmitPolicy.eltNextButtonAmount");
		
		//5. Type $data in Write_Percentage field
		uiDriver.setValue("SubmitPolicy.txtWrite_Percentage", input.get("Type@Write_Percentage"));
		
		//6. Click on Finish WebElement
		uiDriver.click("SubmitPolicy.eltFinish");
		
	}
	
	public void CreateNewPersonContact(DataRow input, DataRow output) {
		//1. Click on Add_Button WebElement
		uiDriver.click("CreateNewPersonContact.eltAdd_Button");
		
		//2. Click on Add_New_Person WebElement
		uiDriver.click("CreateNewPersonContact.eltAdd_New_Person");
		
		//3. Type $data in First_Name field
		uiDriver.setValue("CreateNewPersonContact.txtFirst_Name", input.get("Type@First_Name"));
		
		//4. Type $data in Last_Name field
		uiDriver.setValue("CreateNewPersonContact.txtLast_Name", input.get("Type@Last_Name"));
		
		//5. Type $data in Address1 field
		uiDriver.setValue("CreateNewPersonContact.txtAddress1", input.get("Type@Address1"));
		
		//6. Type $data in City field
		uiDriver.setValue("CreateNewPersonContact.txtCity", input.get("Type@City"));
		
		//7. Type $data in Zip_Code field
		uiDriver.setValue("CreateNewPersonContact.txtZip_Code", input.get("Type@Zip_Code"));
		
		//8. Click on Standardize_Address WebElement
		uiDriver.click("CreateNewPersonContact.eltStandardize_Address");
		
		//9. Click on Select_Link WebElement
		uiDriver.click("CreateNewPersonContact.eltSelect_Link");
		
		//10. Type $data in Phone field
		uiDriver.setValue("CreateNewPersonContact.txtPhone", input.get("Type@Phone"));
		
		//11. Type $data in email field
		uiDriver.setValue("CreateNewPersonContact.txtemail", input.get("Type@email"));
		
		//12. Click on Add_Button WebElement
		uiDriver.click("CreateNewPersonContact.eltAdd_Button");
		
		//13. Select the Select_CheckBox ?checkbox
		uiDriver.setValue("CreateNewPersonContact.chkSelect_CheckBox", input.get("Select@Select_CheckBox"));
		
		//14. Type $data in Role field
		uiDriver.setValue("CreateNewPersonContact.txtRole", input.get("Type@Role"));
		
		//15. Click on OK_Button WebElement
		uiDriver.click("CreateNewPersonContact.eltOK_Button");
		
	}
	
	public void Change_Policy(DataRow input, DataRow output) {
		//1. Click on Click_on_Policy_Tab WebElement
		uiDriver.click("Change_Policy.eltClick_on_Policy_Tab");
		
		//2. Type $data in Enter_policy_number field
		uiDriver.setValue("Change_Policy.txtEnter_policy_number", input.get("Type@Enter_policy_number"));
		
		//3. Click on Click_on_Search_Link Link
		uiDriver.click("Change_Policy.lnkClick_on_Search_Link");
		
		//4. Click on Click_on_Policy WebElement
		uiDriver.click("Change_Policy.eltClick_on_Policy");
		
		//5. Click on Click_on_Actions WebElement
		uiDriver.click("Change_Policy.eltClick_on_Actions");
		
		//6. Click on Click_on_change_policy WebElement
		uiDriver.click("Change_Policy.eltClick_on_change_policy");
		
		//7. Click on Next_Button WebElement
		uiDriver.click("Change_Policy.eltNext_Button");
		
		//8. Type $data in Enter_Date field
		uiDriver.setValue("Change_Policy.txtEnter_Date", input.get("Type@Enter_Date"));
		
		//9. Click on Click_on_Add_Button WebElement
		uiDriver.click("Change_Policy.eltClick_on_Add_Button");
		
		//10. Click on Enter_Amount WebElement
		uiDriver.click("Change_Policy.eltEnter_Amount");
		
		//11. Click on Finish WebElement
		uiDriver.click("Change_Policy.eltFinish");
		
	}
	

	/**
	*Overriding toString() method of object class to print Policy
	*format string
	**/
	public String toString(){
		return "PolicyDriver";
	}
}
