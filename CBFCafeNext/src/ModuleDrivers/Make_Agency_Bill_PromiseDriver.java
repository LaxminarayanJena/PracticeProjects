/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 3/27/2018 4:23:38 AM
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
public class Make_Agency_Bill_PromiseDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public Make_Agency_Bill_PromiseDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void TC01_Validate_Newly_Added_Feat(DataRow input, DataRow output) {
		
		//1. Click on Actions WebElement
		uiDriver.click("TC01_Validate_Newly_Added_Feat.eltActions");
		SleepUtils.sleep(3);
		
		//2. Click on New_Agency_Bill_Promise WebElement
		uiDriver.click("TC01_Validate_Newly_Added_Feat.eltNew_Agency_Bill_Promise");
		SleepUtils.sleep(3);
		
		//3. Verify Received_Date
		if(uiDriver.getControl("TC01_Validate_Newly_Added_Feat.txtReceived_Date").getAttribute("data-ref").equalsIgnoreCase("inputEl")) {
			passed("checkElement","Element is Editable should pass","Element is Editable passed");
		} else {
			failed("checkElement","Element is Editable should pass","Element is Editable failed");	
		}
		
		//4. Verify Received_Date_as_calendar_field
		if(uiDriver.getControl("TC01_Validate_Newly_Added_Feat.txtReceived_Date_as_calendar_field").getAttribute("data-qtip").equalsIgnoreCase("MM/dd/yyyy")) {
			passed("checkElement","Element is Calender should pass","Element is Calender passed");
		} else {
			failed("checkElement","Element is Calender should pass","Element is Calender failed");	
		}
		
		//5. Verify Promise_Amount
		if(uiDriver.getControl("TC01_Validate_Newly_Added_Feat.txtPromise_Amount").getAttribute("data-ref").equalsIgnoreCase("inputEl")) {
			passed("checkElement","Element is Editable should pass","Element is Editable passed");
		} else {
			failed("checkElement","Element is Editable should pass","Element is Editable failed");	
		}
		
		//6. Verify Promise_Amount_as_textbox
		if(uiDriver.getControl("TC01_Validate_Newly_Added_Feat.txtPromise_Amount_as_textbox").getAttribute("type").equalsIgnoreCase("text")) {
			passed("checkElement","Element is text should pass","Element is text passed");
		} else {
			failed("checkElement","Element is text should pass","Element is text failed");	
		}
		
		//7. Verify whether the Name #targettype# is present
		if (uiDriver.checkElementPresent("TC01_Validate_Newly_Added_Feat.eltName")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		
		//8. Click on Cancel button
		uiDriver.click("TC01_Validate_Newly_Added_Feat.btnCancel");
		SleepUtils.sleep(5);
	
		//9. Click on OK button
		uiDriver.click("TC01_Validate_Newly_Added_Feat.btnOK");
		SleepUtils.sleep(3);
		
		//10. Click on Agency_Bill_Payments WebElement
		uiDriver.click("TC01_Validate_Newly_Added_Feat.eltAgency_Bill_Payments");
		SleepUtils.sleep(6);
		
		//11. Click on Executed_Payments WebElement
		uiDriver.click("TC01_Validate_Newly_Added_Feat.eltExecuted_Payments");
		SleepUtils.sleep(8);
		uiDriver.click("TC01_Validate_Newly_Added_Feat.eltExecuted_Payments");
		SleepUtils.sleep(6);
		uiDriver.click("TC01_Validate_Newly_Added_Feat.lstPaymentRecived");
		SleepUtils.sleep(6);
		uiDriver.setValue("TC01_Validate_Newly_Added_Feat.lstPaymentRecived", input.get("Select@PaymentRecived"));	
		SleepUtils.sleep(6);
		uiDriver.sendKey("enter");
		SleepUtils.sleep(4);
		
		//12. Select the Reversed_No ?checkbox
		uiDriver.th.findRelativeCellAndClickfirstCell("TC01_Validate_Newly_Added_Feat.chkReversed_No1", "$50,000.00", 3, "$50,000.00");
		SleepUtils.sleep(2);
		
		//13. Click on Edit button
		uiDriver.click("TC01_Validate_Newly_Added_Feat.btnEdit");
		SleepUtils.sleep(2);
		
		//14. Verify Name_Not_editable
		if(uiDriver.getControl("TC01_Validate_Newly_Added_Feat.eltName_Not_editable").getAttribute("data-ref").equalsIgnoreCase("labelEl")){
			passed("checkElement Not Editable","checkElement Not Editable should pass","checkElement Not Editable passed");
		} else {
			failed("checkElement Not Editable","checkElement Not Editable should pass","checkElement Not Editable failed");
		}
		
		//15. Click on Cancel button
		uiDriver.click("TC01_Validate_Newly_Added_Feat.btnCancel");
		SleepUtils.sleep(2);
		
		//16. Click on OK button
		uiDriver.click("TC01_Validate_Newly_Added_Feat.btnOK");
		SleepUtils.sleep(2);
		
		//17. Click on Agency_Bill_Payments WebElement
		uiDriver.click("TC01_Validate_Newly_Added_Feat.eltAgency_Bill_Payments");
		SleepUtils.sleep(8);
		
		//18. Click on Credit_Distributions WebElement
		uiDriver.click("TC01_Validate_Newly_Added_Feat.eltCredit_Distributions");
		SleepUtils.sleep(8);
		
		//19. Select the Reversed_No ?checkbox
		uiDriver.th.findRelativeCellAndClickfirstCell("TC01_Validate_Newly_Added_Feat.chkReversed_No", "No", 2, "No");
		SleepUtils.sleep(8);
		
		//20. Click Edit
		uiDriver.click("TC01_Validate_Newly_Added_Feat.txtEdit");
		SleepUtils.sleep(6);
		
		//21. Verify whether the Received_Date element present
		if (uiDriver.checkElementPresent("TC01_Validate_Newly_Added_Feat.eltReceived_Date")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(2);
		
		//22. Click on Cancel button
		uiDriver.click("TC01_Validate_Newly_Added_Feat.btnCancel");
		SleepUtils.sleep(2);
		
		//23. Click on OK button
		uiDriver.click("TC01_Validate_Newly_Added_Feat.btnOK");
		SleepUtils.sleep(2);
		
	}
	
	public void TC03_Validate_User_Roles(DataRow input, DataRow output) {
		
		//1. Click on Actions WebElement
		SleepUtils.sleep(8);
		uiDriver.click("TC_02_AGency_Bill_Exe_Promises.eltActions");
		SleepUtils.sleep(4);
		
		//2. Click on New_Agency_Bill_Promise WebElement
		uiDriver.click("TC_02_AGency_Bill_Exe_Promises.eltNew_Agency_Bill_Promise");
		SleepUtils.sleep(4);
		
		//3. Type $data in Promise_Amount field
		uiDriver.setValue("TC_02_AGency_Bill_Exe_Promises.txtPromise_Amount", input.get("Type@Promise_Amount"));
		SleepUtils.sleep(4);
		
		//4. Click on Add_Statements WebElement
		uiDriver.click("TC_02_AGency_Bill_Exe_Promises.eltAdd_Statements");
		SleepUtils.sleep(4);
		
		//5. Click on Search WebElement
		uiDriver.click("TC_02_AGency_Bill_Exe_Promises.eltSearch");
		SleepUtils.sleep(8);
		
		//6. Select the Planned ?checkbox
		uiDriver.click("TC_02_AGency_Bill_Exe_Promises.chkPlanned1");
		SleepUtils.sleep(4);
		
		//7. Click on Add_Statements_1 button
		uiDriver.click("TC_02_AGency_Bill_Exe_Promises.btnAdd_Statements_1");
		SleepUtils.sleep(4);
		
		//8. Click on Next button
		uiDriver.click("TC_02_AGency_Bill_Exe_Promises.btnNext");
		SleepUtils.sleep(15);
		if (uiDriver.checkElementPresent("TC_02_AGency_Bill_Exe_Promises.btnNext")) {
			uiDriver.click("TC_02_AGency_Bill_Exe_Promises.btnNext");	
		}
		SleepUtils.sleep(5);
		
		//9. Click on Next_1 button
//		uiDriver.click("TC_02_AGency_Bill_Exe_Promises.btnNext_1");
//		SleepUtils.sleep(4);
				
		//10. Click on Finish button
		uiDriver.click("TC_02_AGency_Bill_Exe_Promises.btnFinish");
		SleepUtils.sleep(4);
		
		//11. Click on Agency_Bill_Promises WebElement
		uiDriver.click("TC_02_AGency_Bill_Exe_Promises.eltAgency_Bill_Promises");
		SleepUtils.sleep(4);
		
		//12. Verify the text ?$data in the Amount field
		String eltAmnt="$"+input.get("VerifyText@Amount")+".00";
		if (uiDriver.verifyTextActAndExp("TC_02_AGency_Bill_Exe_Promises.eltAmount", eltAmnt)) {
			passed("verifyText","verifyText should pass","verifyText passed");
		} else {
			failed("verifyText","verifyText should pass","verifyText failed");
		}
		SleepUtils.sleep(4);
		
	}
	
	public void TC03_Validate_User_Roles_IT(DataRow input, DataRow output) {
		SleepUtils.sleep(8);
		//1. Click on Actions WebElement
		uiDriver.click("TC_02_AGency_Bill_Exe_Promises.eltActions");
		SleepUtils.sleep(4);
		
		//2. Verify whether the Name #targettype# is present
		if (!uiDriver.checkElementPresent("TC_02_AGency_Bill_Exe_Promises.eltNew_Agency_Bill_Promise")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}	

	}

	/**
	*Overriding toString() method of object class to print Make_Agency_Bill_Promise
	*format string
	**/
	public String toString(){
		return "Make_Agency_Bill_PromiseDriver";
	}
}