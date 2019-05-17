/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 1/3/2018 2:23:21 AM
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
public class US479_FPOAPOCodesForStatesDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public US479_FPOAPOCodesForStatesDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void TC01_VerifyStateTypelistfield(DataRow input, DataRow output) {
		//1. Click on Account WebElement
		uiDriver.click("TC01_VerifyStateTypelistfield.eltAccount");
		
		//2. Click on Account_State WebElement
		uiDriver.click("TC01_VerifyStateTypelistfield.eltAccount_State");
		SleepUtils.sleep(3);
		uiDriver.checkDropDownOptions("li", input.get("VerifyList@State"));
		
		//3. Type $data in Account_Name field
		uiDriver.setValue("TC01_VerifyStateTypelistfield.txtAccount_Name", input.get("Type@Account_Name"));
		
		//4. Click on Search button
		uiDriver.click("TC01_VerifyStateTypelistfield.btnSearch");
		
		//5. Verify whether the Account link is present
		if (uiDriver.checkElementPresent("TC01_VerifyStateTypelistfield.lnkAccount")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		
		//6. Click on Account Link
		uiDriver.click("TC01_VerifyStateTypelistfield.lnkAccount");
		
		//7. Click on Contact WebElement
		SleepUtils.sleep(3);
		uiDriver.click("TC01_VerifyStateTypelistfield.eltContact");
		
		//8. Click on Account_Add button
		uiDriver.click("TC01_VerifyStateTypelistfield.btnAccount_Add");
		
		//9. Click on Add_New_Person WebElement
		SleepUtils.sleep(2);
		uiDriver.click("TC01_VerifyStateTypelistfield.eltAdd_New_Person");
		
		//10. Click on Acc_Cont_State WebElement
		SleepUtils.sleep(2);
		uiDriver.click("TC01_VerifyStateTypelistfield.eltAcc_Cont_State");
		SleepUtils.sleep(2);
		uiDriver.checkDropDownOptions("li", input.get("VerifyList@State"));
		
		//11. Click on Producer WebElement
		SleepUtils.sleep(3);
		uiDriver.click("TC01_VerifyStateTypelistfield.eltProducer");
		
		//12. Click on PRoducer_State WebElement
		SleepUtils.sleep(2);
		uiDriver.click("TC01_VerifyStateTypelistfield.eltPRoducer_State");
		SleepUtils.sleep(2);
		uiDriver.checkDropDownOptions("li", input.get("VerifyList@State"));
		
		
		//13. Type $data in Producer_Code field
		SleepUtils.sleep(2);
		uiDriver.setValue("TC01_VerifyStateTypelistfield.txtProducer_Code", input.get("Type@Producer_Code"));
		
		//14. Click on Search button
		uiDriver.click("TC01_VerifyStateTypelistfield.btnSearch_Producer");
		
		//15. Click on Name WebElement
		SleepUtils.sleep(4);
		uiDriver.click("TC01_VerifyStateTypelistfield.eltName");
		
		//16. Click on Contact WebElement
		SleepUtils.sleep(4);
		uiDriver.click("TC01_VerifyStateTypelistfield.eltContact_producer");
		
		//17. Click on Producer_Contact_Add button
		uiDriver.click("TC01_VerifyStateTypelistfield.btnProducer_Contact_Add");
		
		//18. Click on Producer_Add_NewPerson button
		SleepUtils.sleep(2);
		uiDriver.click("TC01_VerifyStateTypelistfield.btnProducer_Add_NewPerson");
		
		//19. Click on Producer_Contact_State WebElement
		uiDriver.click("TC01_VerifyStateTypelistfield.eltProducer_Contact_State");
		SleepUtils.sleep(2);
		uiDriver.checkDropDownOptions("li", input.get("VerifyList@State"));
		
		//20. Click on Search WebElement
		uiDriver.click("TC01_VerifyStateTypelistfield.eltSearch");
		
		//21. Click on Search_Acc_State WebElement
		uiDriver.click("TC01_VerifyStateTypelistfield.eltSearch_Acc_State");
		SleepUtils.sleep(2);
		uiDriver.checkDropDownOptions("li", input.get("VerifyList@State"));
		
		//22. Click on Search_Policies WebElement
		uiDriver.click("TC01_VerifyStateTypelistfield.eltSearch_Policies");
		
		//23. Click on Search_Policies_State WebElement
		uiDriver.click("TC01_VerifyStateTypelistfield.eltSearch_Policies_State");
		SleepUtils.sleep(2);
		uiDriver.checkDropDownOptions("li", input.get("VerifyList@State"));
		
		//24. Click on Search_contact WebElement
		uiDriver.click("TC01_VerifyStateTypelistfield.eltSearch_contact");
		
		//25. Click on Search_contact_State WebElement
		uiDriver.click("TC01_VerifyStateTypelistfield.eltSearch_contact_State");
		SleepUtils.sleep(2);
		uiDriver.checkDropDownOptions("li", input.get("VerifyList@State"));
		
		//26. Click on Search_Invoices WebElement
		uiDriver.click("TC01_VerifyStateTypelistfield.eltSearch_Invoices");
		
		//27. Click on Search_invoices_State WebElement
		uiDriver.click("TC01_VerifyStateTypelistfield.eltSearch_invoices_State");
		SleepUtils.sleep(2);
		uiDriver.checkDropDownOptions("li", input.get("VerifyList@State"));
		
		//28. Click on Search_Payment WebElement
		uiDriver.click("TC01_VerifyStateTypelistfield.eltSearch_Payment");
		
		//29. Click on Search_Payment_State WebElement
		uiDriver.click("TC01_VerifyStateTypelistfield.eltSearch_Payment_State");
		SleepUtils.sleep(2);
		uiDriver.checkDropDownOptions("li", input.get("VerifyList@State"));
		
		
		//30. Click on Search_Producer WebElement
		uiDriver.click("TC01_VerifyStateTypelistfield.eltSearch_Producer");
		
		//31. Click on Search_Producer_State WebElement
		uiDriver.click("TC01_VerifyStateTypelistfield.eltSearch_Producer_State");
		SleepUtils.sleep(2);
		uiDriver.checkDropDownOptions("li", input.get("VerifyList@State"));
		
		//32. Click on Search_Service_Tickets WebElement
		uiDriver.click("TC01_VerifyStateTypelistfield.eltSearch_Service_Tickets");
		
		//33. Click on Search_Service_Tickets_State WebElement
		uiDriver.click("TC01_VerifyStateTypelistfield.eltSearch_Service_Tickets_State");
		SleepUtils.sleep(2);
		uiDriver.checkDropDownOptions("li", input.get("VerifyList@State"));
		
		//34. Click on Search_Delinquency_Processes_ WebElement
		uiDriver.click("TC01_VerifyStateTypelistfield.eltSearch_Delinquency_Processes_");
		
		//35. Click on Search_Delinquency_Processes_State WebElement
		uiDriver.click("TC01_VerifyStateTypelistfield.eltSearch_Delinquency_Processes_State");
		SleepUtils.sleep(4);
		uiDriver.checkDropDownOptions("li", input.get("VerifyList@State"));
	}
	

	/**
	*Overriding toString() method of object class to print US479_FPOAPOCodesForStates
	*format string
	**/
	public String toString(){
		return "US479_FPOAPOCodesForStatesDriver";
	}
}
