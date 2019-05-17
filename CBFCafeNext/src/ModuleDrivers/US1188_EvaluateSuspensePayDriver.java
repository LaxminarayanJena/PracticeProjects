/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 12/27/2017 7:18:47 AM
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
public class US1188_EvaluateSuspensePayDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public US1188_EvaluateSuspensePayDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void US1188TC04_EvaluateSuspensePay(DataRow input, DataRow output) {
		//1. Click on Administration WebElement
		uiDriver.click("US1188TC04_EvaluateSuspensePay.eltAdministration");
		SleepUtils.sleep(3);
		
		//2. Click on Users WebElement
		uiDriver.click("US1188TC04_EvaluateSuspensePay.eltUsers");
		SleepUtils.sleep(3);
		
		//3. Type $data in First_Name field
		//uiDriver.setValue("US1188TC04_EvaluateSuspensePay.txtFirst_Name",input.get("Type@First_Name"));
		uiDriver.setValue("Adminuser_Addrole.txtUser_name",System.getProperty("user.name"));
		SleepUtils.sleep(3);
		
		//4. Click on Search button
		uiDriver.click("US1188TC04_EvaluateSuspensePay.btnSearch");
		SleepUtils.sleep(3);
		
		//5. Click on Display_Name Link
		uiDriver.click("US1188TC04_EvaluateSuspensePay.lnkDisplay_Name");
		SleepUtils.sleep(3);
		
		//6. Click on Desktop WebElement
		uiDriver.click("US1188TC04_EvaluateSuspensePay.eltDesktop");
		
		//7. Click on Unmatched_Suspense_Payments WebElement
		uiDriver.click("US1188TC04_EvaluateSuspensePay.eltUnmatched_Suspense_Payments");
		SleepUtils.sleep(5);
		uiDriver.click("US1188Createsuspensepayments.eltpaymentDate");
		SleepUtils.sleep(12);
		uiDriver.click("US1188Createsuspensepayments.eltpaymentDate");
		SleepUtils.sleep(10);
		
		//8. Click on Edit WebElement
		uiDriver.click("US1189TC04_viewandmanagesuspay.lnkUSP_edit");
		SleepUtils.sleep(5);
		
		//9. Type $data in Account_ field
		uiDriver.setValue("US1188TC04_EvaluateSuspensePay.txtAccount_", input.get("Type@Account_"));
		SleepUtils.sleep(3);
		
		//10. Click on Update button
		uiDriver.click("US1188TC04_EvaluateSuspensePay.btnUpdate");
		SleepUtils.sleep(3);
		
		//11. Click on Apply WebElement
		uiDriver.click("US1189TC04_viewandmanagesuspay.lnkUSP_Apply");
		SleepUtils.sleep(3);
		
		//12. Type $data in Account_1 field
		uiDriver.setValue("US1188TC04_EvaluateSuspensePay.txtAccount_1", input.get("Type@Account_1"));	
		SleepUtils.sleep(3);
		
		//13. Click on Update button
		uiDriver.click("US1188TC04_EvaluateSuspensePay.btnUpdate_1");
		SleepUtils.sleep(3);
		
		//14. Click on Account WebElement
		uiDriver.click("US1188TC04_EvaluateSuspensePay.eltAccount");
		
		//15. Type $data in Account_Name field
		uiDriver.setValue("US1188TC04_EvaluateSuspensePay.txtAccount_Name", input.get("Type@Account_Name"));
		SleepUtils.sleep(3);
		
		//16. Click on Search button
		uiDriver.click("US1188TC04_EvaluateSuspensePay.btnSearch_1");
		SleepUtils.sleep(3);
		
		//17. Click on Account Link
		uiDriver.click("US1188TC04_EvaluateSuspensePay.lnkAccount");
		SleepUtils.sleep(3);
		
		//18. Click on History WebElement
		uiDriver.click("US1188TC04_EvaluateSuspensePay.eltHistory");
		SleepUtils.sleep(5);
		
		//19. Click on Payments WebElement
		uiDriver.click("US1188TC04_EvaluateSuspensePay.eltPayments");
		SleepUtils.sleep(5);
		
		//20. Click on Payment_Date WebElement
		uiDriver.click("US1188TC04_EvaluateSuspensePay.eltPayment_Date");
		SleepUtils.sleep(5);
	}
	

	/**
	*Overriding toString() method of object class to print US1188TC04_EvaluateSuspensePay
	*format string
	**/
	public String toString(){
		return "US1188TC04_EvaluateSuspensePayDriver";
	}
}
