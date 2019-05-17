/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 1/30/2018 3:49:55 AM
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
public class Create_New_Producer_WizardDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public Create_New_Producer_WizardDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void Create_New_Producer_Wizard(DataRow input, DataRow output) {
		//1. Click on Producer WebElement
		uiDriver.click("Create_New_Producer_Wizard.eltProducer");
		
		//2. Click on Actions WebElement
		uiDriver.click("Create_New_Producer_Wizard.eltActions");
		
		//3. Click on New_Producer WebElement
		uiDriver.click("Create_New_Producer_Wizard.eltNew_Producer");
		
		//4. Type $data in Producer_Name field
		SleepUtils.sleep(2);
		uiDriver.setValue("Create_New_Producer_Wizard.txtProducer_Name", input.get("Type@Producer_Name"));
		
		//5. Select $data from the Agency_Type list
		uiDriver.click("Create_New_Producer_Wizard.lstAgency_Type");
		SleepUtils.sleep(2);
		uiDriver.setValue("Create_New_Producer_Wizard.lstAgency_Type", input.get("Select@Agency_Type"));
		SleepUtils.sleep(1);
		uiDriver.sendKey("tab");
		SleepUtils.sleep(2);
	
		//6. Select $data from the Region list
		SleepUtils.sleep(4);
		uiDriver.click("Create_New_Producer_Wizard.lstRegion");
		SleepUtils.sleep(2);
		uiDriver.setValue("Create_New_Producer_Wizard.lstRegion", input.get("Select@Region"));
		uiDriver.sendKey("tab");
		
		//7. Verify Active_inactive
		uiDriver.click("Create_New_Producer_Wizard.lstActive_inactive");
		SleepUtils.sleep(2);
		uiDriver.checkDropDownOptions("li", input.get("Verify@Status"));
		
		//8. Select $data from the Status list
		uiDriver.setValue("Create_New_Producer_Wizard.lstStatus", input.get("Select@Status"));
		uiDriver.sendKey("tab");
		
		
		//9. Select $data from the Plan list
		uiDriver.click("Create_New_Producer_Wizard.lstPlan");
		SleepUtils.sleep(2);
		uiDriver.setValue("Create_New_Producer_Wizard.lstPlan", input.get("Select@Plan"));
		uiDriver.sendKey("tab");
				
		//10. Click on Account_Rep_Imag image
		uiDriver.click("Create_New_Producer_Wizard.imgAccount_Rep_Imag");
		
		//11. Type $data in Acc_Ser_User_name field
		uiDriver.setValue("Create_New_Producer_Wizard.txtAcc_Ser_User_name", input.get("Type@Acc_Ser_User_name"));
		
		//12. Click on Acc_Search button
		uiDriver.click("Create_New_Producer_Wizard.btnAcc_Search");
		
		//13. Click on Select button
		uiDriver.click("Create_New_Producer_Wizard.btnSelect");
		
		//14. Click on Add button
		uiDriver.click("Create_New_Producer_Wizard.btnAdd");
		
		//15. Click on Add_New_Person WebElement
		uiDriver.click("Create_New_Producer_Wizard.eltAdd_New_Person");
		
		//16. Type $data in First_Name field
		SleepUtils.sleep(3);
		uiDriver.setValue("Create_New_Producer_Wizard.txtFirst_Name", input.get("Type@First_Name"));
		
		//17. Type $data in Last_Name field
		uiDriver.setValue("Create_New_Producer_Wizard.txtLast_Name", input.get("Type@Last_Name"));
		
		//18. Type $data in Address_1 field
		uiDriver.setValue("Create_New_Producer_Wizard.txtAddress_1", input.get("Type@Address_1"));
		
		//19. Type $data in City field
		uiDriver.setValue("Create_New_Producer_Wizard.txtCity", input.get("Type@City"));
		
		//20. Type $data in ZIP_Code field
		uiDriver.setValue("Create_New_Producer_Wizard.txtZIP_Code", input.get("Type@ZIP_Code"));
		
		//21. Type $data in Phone field
		uiDriver.setValue("Create_New_Producer_Wizard.txtPhone", input.get("Type@Phone"));
		
		//22. Type $data in Email_ field
		uiDriver.setValue("Create_New_Producer_Wizard.txtEmail_", input.get("Type@Email_"));
		
		//23. Click on Prod_Contact_Add button
		uiDriver.click("Create_New_Producer_Wizard.btnProd_Contact_Add");
		
		//24. Select $data from the Role list
		uiDriver.click("Create_New_Producer_Wizard.lstRole1");
		SleepUtils.sleep(3);
		uiDriver.setValue("Create_New_Producer_Wizard.lstRole", input.get("Select@Role"));
		uiDriver.sendKey("tab");
		
		//25. Select $data from the State list
		uiDriver.click("Create_New_Producer_Wizard.lstState");
		SleepUtils.sleep(3);
		uiDriver.setValue("Create_New_Producer_Wizard.lstState", input.get("Select@State"));
		uiDriver.sendKey("tab");
		
		//26. Click on standardize button
		uiDriver.click("Create_New_Producer_Wizard.btnstandardize");
		SleepUtils.sleep(3);
		//To handle non standardize address implement below logic
		Boolean bStatus=uiDriver.getControl("Create_New_Producer_Wizard.btnOverRide").isEnabled();
			if (bStatus==true) {
				uiDriver.ElementPrestnclick("Create_New_Producer_Wizard.btnOverRide");
			} 
		SleepUtils.sleep(5);
		
		//27. Click on OK button
		uiDriver.click("Create_New_Producer_Wizard.btnOK");
		
		//28. Click on Next button
		uiDriver.click("Create_New_Producer_Wizard.btnNext");
		
		//29. Click on Finsh button
		uiDriver.click("Create_New_Producer_Wizard.btnFinsh");
        SleepUtils.sleep(4);
		
	}
	

	/**
	*Overriding toString() method of object class to print Create_New_Producer_Wizard
	*format string
	**/
	public String toString(){
		return "Create_New_Producer_WizardDriver";
	}
}
