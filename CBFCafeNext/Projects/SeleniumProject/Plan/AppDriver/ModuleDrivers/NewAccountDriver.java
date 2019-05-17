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
public class NewAccountDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public NewAccountDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void CreateNewAcc(DataRow input, DataRow output) {
		//1. Click on Account WebElement
		uiDriver.click("CreateNewAcc.eltAccount");
		
		//2. Click on Actions WebElement
		uiDriver.click("CreateNewAcc.eltActions");
		
		//3. Click on NewAccount WebElement
		uiDriver.click("CreateNewAcc.eltNewAccount");
		
		//4. Type $data in AccountName field
		uiDriver.setValue("CreateNewAcc.txtAccountName", input.get("Type@AccountName"));
		
		//5. Select $data from the InsuredType list
		uiDriver.setValue("CreateNewAcc.lstInsuredType", input.get("Select@InsuredType"));
		
		//6. Select $data from the BillingPlan list
		uiDriver.setValue("CreateNewAcc.lstBillingPlan", input.get("Select@BillingPlan"));
		
		//7. Select $data from the DelinquencyPlan list
		uiDriver.setValue("CreateNewAcc.lstDelinquencyPlan", input.get("Select@DelinquencyPlan"));
		
		//8. Click on AddContact WebElement
		uiDriver.click("CreateNewAcc.eltAddContact");
		
		//9. Click on AddNewCompany WebElement
		uiDriver.click("CreateNewAcc.eltAddNewCompany");
		
		//10. Verify AddAccountContact
		uiDriver.Verify("CreateNewAcc.eltAddAccountContact");
		
		//11. Type $data in Name field
		uiDriver.setValue("CreateNewAcc.txtName", input.get("Type@Name"));
		
		//12. Type $data in Phone field
		uiDriver.setValue("CreateNewAcc.txtPhone", input.get("Type@Phone"));
		
		//13. Type $data in Email field
		uiDriver.setValue("CreateNewAcc.txtEmail", input.get("Type@Email"));
		
		//14. Click on AddRole WebElement
		uiDriver.click("CreateNewAcc.eltAddRole");
		
		//15. Select $value from PrimaryPayer Radio Button from the list
		uiDriver.setValue("CreateNewAcc.rdgPrimaryPayer", input.get("Select@PrimaryPayer"));
		
		//16. Type $data in Addressline1 field
		uiDriver.setValue("CreateNewAcc.txtAddressline1", input.get("Type@Addressline1"));
		
		//17. Type $data in City field
		uiDriver.setValue("CreateNewAcc.txtCity", input.get("Type@City"));
		
		//18. Select $data from the State list
		uiDriver.setValue("CreateNewAcc.lstState", input.get("Select@State"));
		
		//19. Type $data in ZIPcode field
		uiDriver.setValue("CreateNewAcc.txtZIPcode", input.get("Type@ZIPcode"));
		
		//20. Click on Standardize WebElement
		uiDriver.click("CreateNewAcc.eltStandardize");
		
	}
	

	/**
	*Overriding toString() method of object class to print NewAccount
	*format string
	**/
	public String toString(){
		return "NewAccountDriver";
	}
}
