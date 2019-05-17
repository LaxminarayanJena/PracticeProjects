/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 1/3/2018 7:13:15 AM
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
public class US1215_SendEmailPDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public US1215_SendEmailPDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void US1215TC01_SendEmail(DataRow input, DataRow output) {
		//1. Click on Account WebElement
		uiDriver.click("US1215TC01_SendEmail.eltAccount");
		
		//2. Type $data in Account_Name field
		uiDriver.setValue("US1215TC01_SendEmail.txtAccount_Name", input.get("Type@Account_Name"));
		
		//3. Click on Search button
		uiDriver.click("US1215TC01_SendEmail.btnSearch");
		
		//4. Click on Account Link
		uiDriver.click("US1215TC01_SendEmail.lnkAccount");
		
		//5. Click on Actions button
		uiDriver.click("US1215TC01_SendEmail.btnActions");
		SleepUtils.sleep(4);
		
		//6. Click on New_Email WebElement
		uiDriver.click("US1215TC01_SendEmail.eltNew_Email");
		SleepUtils.sleep(4);
		
		//7. Click on New_Email WebElement
		uiDriver.click("US1215TC01_SendEmail.eltNew_Email_1");
		SleepUtils.sleep(4);
		
		//8. Click on Add_CC_Recipients button
		uiDriver.click("US1215TC01_SendEmail.btnAdd_CC_Recipients");
		SleepUtils.sleep(4);
		
		//9. Click on Add_BCC_Recipients button
		uiDriver.click("US1215TC01_SendEmail.btnAdd_BCC_Recipients");
		SleepUtils.sleep(4);
		
		//10. Click on Find_Contact button
		uiDriver.click("US1215TC01_SendEmail.btnFind_Contact");
		SleepUtils.sleep(4);
		
		//11. Click on Return_to_New_Email Link
		uiDriver.click("US1215TC01_SendEmail.lnkReturn_to_New_Email");
		SleepUtils.sleep(4);
		
		//12. Click on OK button
		uiDriver.click("US1215TC01_SendEmail.btnOK");
		SleepUtils.sleep(4);
		
		//13. Click on Find_Contact_1 button
		uiDriver.click("US1215TC01_SendEmail.btnFind_Contact_1");
		SleepUtils.sleep(4);
		
		//14. Click on Return_to_New_Email_1 Link
		uiDriver.click("US1215TC01_SendEmail.lnkReturn_to_New_Email_1");
		SleepUtils.sleep(4);
		
		//15. Click on OK_1 button
		uiDriver.click("US1215TC01_SendEmail.btnOK_1");
		SleepUtils.sleep(4);
		
		//16. Click on Find_Contact_2 button
		uiDriver.click("US1215TC01_SendEmail.btnFind_Contact_2");
		SleepUtils.sleep(4);
		
		//17. Click on Return_to_New_Email_2 Link
		uiDriver.click("US1215TC01_SendEmail.lnkReturn_to_New_Email_2");
		SleepUtils.sleep(4);
		
		//18. Click on OK_2 button
		uiDriver.click("US1215TC01_SendEmail.btnOK_2");
		SleepUtils.sleep(4);
		
		//19. Click on Add button
		uiDriver.click("US1215TC01_SendEmail.btnAdd");
		SleepUtils.sleep(4);
		
		//20. Click on Add_1 button
		uiDriver.click("US1215TC01_SendEmail.btnAdd_1");
		SleepUtils.sleep(4);
		
		//21. Click on Add_2 button
		uiDriver.click("US1215TC01_SendEmail.btnAdd_2");
		SleepUtils.sleep(4);
		uiDriver.setValue("US1215TC01_SendEmail.txtEmail_Address", input.get("Type@txtEmail_Address"));
		
		//22. Click on Cancel button
		uiDriver.click("US1215TC01_SendEmail.btnCancel");
		SleepUtils.sleep(4);
		
		//23. Click on Policy_Number Link
		uiDriver.click("US1215TC01_SendEmail.lnkPolicy_Number");
		SleepUtils.sleep(4);
		
		//24. Click on Actions_1 button
		uiDriver.click("US1215TC01_SendEmail.btnActions_1");
		SleepUtils.sleep(4);
		
		//25. Click on New_Email_2 WebElement
		uiDriver.click("US1215TC01_SendEmail.eltNew_Email_2");
		SleepUtils.sleep(4);
		
		//26. Click on New_Email_1 WebElement
		uiDriver.click("US1215TC01_SendEmail.eltNew_Email_3");
		SleepUtils.sleep(4);
		
		//27. Click on Add_CC_Recipients_1 button
		uiDriver.click("US1215TC01_SendEmail.btnAdd_CC_Recipients_1");
		SleepUtils.sleep(4);
		
		//28. Click on Add_BCC_Recipients_2 button
		uiDriver.click("US1215TC01_SendEmail.btnAdd_BCC_Recipients_2");
		SleepUtils.sleep(4);
		
		//29. Click on Find_Contact_3 button
		uiDriver.click("US1215TC01_SendEmail.btnFind_Contact_3");
		SleepUtils.sleep(4);
		
		//30. Click on Return_to_New_Email_3 Link
		uiDriver.click("US1215TC01_SendEmail.lnkReturn_to_New_Email_3");
		SleepUtils.sleep(4);
		
		//31. Click on OK_3 button
		uiDriver.click("US1215TC01_SendEmail.btnOK_3");
		SleepUtils.sleep(4);
		
		//32. Click on Send_Email button
		uiDriver.click("US1215TC01_SendEmail.btnSend_Email");
		SleepUtils.sleep(3);
	}
	

	/**
	*Overriding toString() method of object class to print US1215TC01_SendEmail
	*format string
	**/
	public String toString(){
		return "US1215TC01_SendEmailDriver";
	}
}
