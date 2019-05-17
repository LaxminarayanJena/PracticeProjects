/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 2/6/2018 2:06:48 AM
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
public class NEPDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;

	public NEPDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}

	public void CreateAccountShell_NEP(DataRow input, DataRow output) {
		// 1. Click on Administration WebElement
		uiDriver.click("CreateAccountShell_NEP.eltAdministration");
		SleepUtils.sleep(4);

		// 2. Type $data in User_name field
		uiDriver.setValue("CreateAccountShell_NEP.txtUser_name", System.getProperty("user.name"));
		SleepUtils.sleep(4);

		// 3. Click on Search button
		uiDriver.click("CreateAccountShell_NEP.btnSearch");
		SleepUtils.sleep(4);

		// 4. Click on Display_Name Link
		uiDriver.click("CreateAccountShell_NEP.lnkDisplay_Name");
		SleepUtils.sleep(5);

		// 5. Click on Account WebElement
		uiDriver.click("CreateAccountShell_NEP.eltAccount");
		SleepUtils.sleep(4);

		// 6. Type $data in Account_Name field
		uiDriver.setValue("CreateAccountShell_NEP.txtAccount_Name", input.get("Type@Account_Name"));
		SleepUtils.sleep(4);

		// 7. Click on Search_1 button
		uiDriver.click("CreateAccountShell_NEP.btnSearch_1");
		SleepUtils.sleep(4);

		// 8. Click on Account Link
		uiDriver.click("CreateAccountShell_NEP.lnkAccount");
		SleepUtils.sleep(4);

		// 9. Click on Actions button
		uiDriver.click("CreateAccountShell_NEP.btnActions");
		SleepUtils.sleep(3);

		// 10. Click on NEP WebElement
		uiDriver.click("CreateAccountShell_NEP.eltNEP");
		SleepUtils.sleep(3);

		// 11. Click on Create_Account_Shell WebElement
		uiDriver.click("CreateAccountShell_NEP.eltCreate_Account_Shell");
		SleepUtils.sleep(3);

		// 12. Type $data in Account_Name field
		uiDriver.setValue("CreateAccountShell_NEP.txtAccount_Name_1", input.get("Type@Account_Name#2"));
		SleepUtils.sleep(3);

		// 13. Click on Add button
		uiDriver.click("CreateAccountShell_NEP.btnAdd");
		SleepUtils.sleep(3);

		// 14. Verify whether the Add_New_Person element present
		if (uiDriver.checkElementPresent("CreateAccountShell_NEP.eltAdd_New_Person")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(3);

		// 15. Verify whether the Add_New_Company element present
		if (uiDriver.checkElementPresent("CreateAccountShell_NEP.eltAdd_New_Company")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(4);

		// 16. Click on Add_New_Company_1 WebElement
		uiDriver.click("CreateAccountShell_NEP.eltAdd_New_Company_1");
		SleepUtils.sleep(4);

		// 17. Type $data in Name field
		uiDriver.setValue("CreateAccountShell_NEP.txtName", input.get("Type@Name"));
		SleepUtils.sleep(4);

		// 18. Type $data in Address_1 field
		uiDriver.setValue("CreateAccountShell_NEP.txtAddress_1", input.get("Type@Address_1"));
		SleepUtils.sleep(4);

		// 19. Type $data in City field
		uiDriver.setValue("CreateAccountShell_NEP.txtCity", input.get("Type@City"));
		uiDriver.sendKey("TAB");

		// 20. Select $data from the State list
		uiDriver.click("CreateAccountShell_NEP.lstState");
		SleepUtils.sleep(1);
		uiDriver.setValue("CreateAccountShell_NEP.lstState", input.get("Select@State"));
		uiDriver.sendKey("ENTER");

		// 21. Type $data in ZIP_Code field
		uiDriver.setValue("CreateAccountShell_NEP.txtZIP_Code", input.get("Type@ZIP_Code"));
		SleepUtils.sleep(4);

		// 22. Type $data in Phone field
		uiDriver.setValue("CreateAccountShell_NEP.txtPhone", input.get("Type@Phone"));
		SleepUtils.sleep(4);

		// 23. Verify whether the Email field is present
		if (uiDriver.checkElementPresent("CreateAccountShell_NEP.txtEmail")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(4);

		// 24. Type $data in Email_1 field
		uiDriver.setValue("CreateAccountShell_NEP.txtEmail_1", input.get("Type@Email_1"));
		uiDriver.sendKey("Enter");
		uiDriver.sendKey("Pagedown");
		SleepUtils.sleep(2);

		// 25. Verify whether the Insured element present
		if (uiDriver.checkElementPresent("CreateAccountShell_NEP.eltInsured")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(2);

		// 26. Click on Standardize_Address button
		uiDriver.click("CreateAccountShell_NEP.btnStandardize_Address");
		SleepUtils.sleep(2);
		Boolean bStatus = uiDriver.getControl("CreateAccountShell_NEP.btnOverRide").isEnabled();
		if (bStatus == true) {
			uiDriver.ElementPrestnclick("CreateAccountShell_NEP.btnOverRide");
		}
		SleepUtils.sleep(4);

		// 27. Click on Ok button
		uiDriver.click("CreateAccountShell_NEP.btnOk");
		SleepUtils.sleep(2);

		// 28. Click on Create_Account button
		uiDriver.click("CreateAccountShell_NEP.btnCreate_Account");
		SleepUtils.sleep(3);

		// 29. Click on History WebElement
		uiDriver.click("CreateAccountShell_NEP.eltHistory");
		SleepUtils.sleep(3);
	}

	public void CreatePolicyShell_NEP(DataRow input, DataRow output) {
		// 1. Click on Administration WebElement
		uiDriver.click("CreatePolicyShell_NEP.eltAdministration");
		SleepUtils.sleep(2);

		// 2. Type $data in User_name field
		uiDriver.setValue("CreatePolicyShell_NEP.txtUser_name", System.getProperty("user.name"));
		SleepUtils.sleep(2);

		// 3. Click on Search button
		uiDriver.click("CreatePolicyShell_NEP.btnSearch");
		SleepUtils.sleep(2);

		// 4. Click on Display_Name Link
		uiDriver.click("CreatePolicyShell_NEP.lnkDisplay_Name");
		SleepUtils.sleep(2);
		
		// 5. Click on Account WebElement
		uiDriver.click("CreatePolicyShell_NEP.eltAccount");
		SleepUtils.sleep(4);

		// 6. Type $data in Account_Name field
		uiDriver.setValue("CreatePolicyShell_NEP.txtAccount_Name", input.get("Type@Account_Name"));
		SleepUtils.sleep(4);

		// 7. Click on Search_1 button
		uiDriver.click("CreatePolicyShell_NEP.btnSearch_1");
		SleepUtils.sleep(2);

		// 8. Click on Account Link
		uiDriver.click("CreatePolicyShell_NEP.lnkAccount");
		SleepUtils.sleep(2);

		// 9. Click on Actions button
		uiDriver.click("CreatePolicyShell_NEP.btnActions");
		SleepUtils.sleep(2);

		// 10. Click on NEP WebElement
		uiDriver.click("CreatePolicyShell_NEP.eltNEP");
		SleepUtils.sleep(2);

		// 11. Click on Create_Policy_Shell WebElement
		uiDriver.click("CreatePolicyShell_NEP.eltCreate_Policy_Shell");
		SleepUtils.sleep(2);

		// 12. Type $data in Policy field
		uiDriver.setValue("CreatePolicyShell_NEP.txtPolicy", input.get("Type@Policy"));
		SleepUtils.sleep(4);

		// 13. Click Effective_Date
		uiDriver.click("CreatePolicyShell_NEP.txtEffective_Date");
		uiDriver.sendKey("ENTER");
		SleepUtils.sleep(3);

		// 14. Click Expiration_Date
		uiDriver.click("CreatePolicyShell_NEP.txtExpiration_Date");
		uiDriver.sendKey("ENTER");
		SleepUtils.sleep(4);

		// 15. Click Payment_Plan
		uiDriver.click("CreatePolicyShell_NEP.txtPayment_Plan");
		SleepUtils.sleep(2);

		// 16. Select $data from the Payment_Plan list
		uiDriver.setValue("CreatePolicyShell_NEP.lstPayment_Plan", input.get("Select@Payment_Plan"));
		uiDriver.sendKey("TAB");
		SleepUtils.sleep(2);

		// 17. Type $data in Primary field
		uiDriver.setValue("CreatePolicyShell_NEP.txtPrimary", input.get("Type@Primary"));
		SleepUtils.sleep(5);


		// 18. Select $data from the Rating_Source list
		uiDriver.clear("CreatePolicyShell_NEP.lstRating_Source");
		uiDriver.setValue("CreatePolicyShell_NEP.lstRating_Source", input.get("Select@Rating_Source"));
		uiDriver.sendKey("tab");
		SleepUtils.sleep(1);
		
		// 19. Select $data from the Program list
		uiDriver.clear("CreatePolicyShell_NEP.lstProgram");
		uiDriver.setValue("CreatePolicyShell_NEP.lstProgram", input.get("Select@Program"));
		uiDriver.sendKey("tab");
		SleepUtils.sleep(1);

		// 20. Select $data from the Policy_Type list
		uiDriver.clear("CreatePolicyShell_NEP.lstPolicy_Type");
		uiDriver.setValue("CreatePolicyShell_NEP.lstPolicy_Type", input.get("Select@Policy_Type"));
		uiDriver.sendKey("tab");
		SleepUtils.sleep(1);

		// 21. Select $data from the Policy_Status list
		uiDriver.clear("CreatePolicyShell_NEP.lstPolicy_Status");
		uiDriver.setValue("CreatePolicyShell_NEP.lstPolicy_Status", input.get("Select@Policy_Status"));
		uiDriver.sendKey("tab");
		SleepUtils.sleep(1);

		// 22. Select $data from the Region list
		uiDriver.clear("CreatePolicyShell_NEP.lstRegion");
		uiDriver.setValue("CreatePolicyShell_NEP.lstRegion", input.get("Select@Region"));
		uiDriver.sendKey("tab");

		// 23. Click on Add button
		uiDriver.doubleclick("CreatePolicyShell_NEP.btnAdd");

		// 24. Verify whether the Add_New_Person element present
		if (uiDriver.checkElementPresent("CreatePolicyShell_NEP.eltAdd_New_Person")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(2);

		// 25. Verify whether the Add_New_Company element present
		if (uiDriver.checkElementPresent("CreatePolicyShell_NEP.eltAdd_New_Company")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(2);

		// 26. Click on Add_New_Company WebElement
		uiDriver.click("CreatePolicyShell_NEP.eltAdd_New_Company_1");
		SleepUtils.sleep(2);

		// 27. Type $data in Name field
		uiDriver.setValue("CreatePolicyShell_NEP.txtName", input.get("Type@Name"));
		SleepUtils.sleep(2);

		// 28. Type $data in Address_1 field
		uiDriver.setValue("CreatePolicyShell_NEP.txtAddress_1", input.get("Type@Address_1"));
		SleepUtils.sleep(2);
		
		// 29. Type $data in City field
		uiDriver.setValue("CreatePolicyShell_NEP.txtCity", input.get("Type@City"));
		uiDriver.sendKey("tab");
		SleepUtils.sleep(2);

		// 30. Click State
		uiDriver.click("CreatePolicyShell_NEP.txtState");
		SleepUtils.sleep(5);

		// 31. Select $data from the State list
		uiDriver.setValue("CreatePolicyShell_NEP.lstState", input.get("Select@State"));
		uiDriver.sendKey("tab");
		SleepUtils.sleep(5);
		
		// 32. Type $data in Zipcode field
		uiDriver.setValue("CreatePolicyShell_NEP.txtZipcode", input.get("Type@Zipcode"));
		SleepUtils.sleep(5);

		// 33. Type $data in Phone field
		uiDriver.setValue("CreatePolicyShell_NEP.txtPhone", input.get("Type@Phone"));
		SleepUtils.sleep(5);

		// 34. Type $data in Email field
		uiDriver.setValue("CreatePolicyShell_NEP.txtEmail", input.get("Type@Email"));
		SleepUtils.sleep(5);

		// 35. Click on Standardize_Address button
		uiDriver.click("CreatePolicyShell_NEP.btnStandardize_Address");
		SleepUtils.sleep(2);
		Boolean bStatus = uiDriver.getControl("CreatePolicyShell_NEP.btnOverRide").isEnabled();
		if (bStatus == true) {
			uiDriver.ElementPrestnclick("CreatePolicyShell_NEP.btnOverRide");
		}
		SleepUtils.sleep(5);
		
		// 36. Click on Add button
		uiDriver.click("CreatePolicyShell_NEP.btnAdd_1");
		SleepUtils.sleep(5);
		
		// 37. Click Role
		uiDriver.doubleclick("CreatePolicyShell_NEP.txtRole");
		SleepUtils.sleep(5);

		// 38. Type $data in Role field
		SleepUtils.sleep(5);
		uiDriver.setValue("CreatePolicyShell_NEP.txtRole_Edit", input.get("Type@Role"));

		// 39. Click on Ok button
		uiDriver.click("CreatePolicyShell_NEP.btnOk");
		SleepUtils.sleep(5);

		// 40. Click on Next button
		uiDriver.click("CreatePolicyShell_NEP.btnNext");
		SleepUtils.sleep(5);

		// 41. Type $data in Write_percentage field
		uiDriver.setValue("CreatePolicyShell_NEP.txtWrite_percentage", input.get("Type@Write_percentage"));
		SleepUtils.sleep(5);

		// 42. Click on Finish button
		uiDriver.click("CreatePolicyShell_NEP.btnFinish");
		SleepUtils.sleep(5);

		// 43. Click on Details WebElement
		uiDriver.click("CreatePolicyShell_NEP.eltDetails");
		SleepUtils.sleep(5);

		// 44. Click on History WebElement
		uiDriver.click("CreatePolicyShell_NEP.eltHistory");
		SleepUtils.sleep(5);

		// 45. Click on Filter_by_Type WebElement
		uiDriver.click("CreatePolicyShell_NEP.eltFilter_by_Type");
		SleepUtils.sleep(5);
		
		// 46. Select $data from the Filter_by_Type list
		uiDriver.setValue("CreatePolicyShell_NEP.lstFilter_by_Type", input.get("Select@Filter_by_Type"));
		SleepUtils.sleep(5);
	}

	/**
	 * Overriding toString() method of object class to print NEP format string
	 **/
	public String toString() {
		return "NEPDriver";
	}
}
