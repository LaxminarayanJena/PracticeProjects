/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 12/28/2017 7:47:58 AM
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
public class US1189_viewandmanagesuspayDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public US1189_viewandmanagesuspayDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void US1189TC04_viewandmanagesuspay(DataRow input, DataRow output) {
		//1. Click on Account WebElement
		uiDriver.click("US1189TC04_viewandmanagesuspay.eltAccount");
	
		//2. Type $data in Account_Name field
		uiDriver.setValue("US1189TC04_viewandmanagesuspay.txtAccount_Name", input.get("Type@Account_Name"));
	
		//3. Click on Search button
		uiDriver.click("US1189TC04_viewandmanagesuspay.btnSearch");
		SleepUtils.sleep(3);
		
		//4. Click on Account Link
		uiDriver.click("US1189TC04_viewandmanagesuspay.lnkAccount");
		SleepUtils.sleep(3);
		
		//5. Click on Payments WebElement
		uiDriver.click("US1189TC04_viewandmanagesuspay.eltPayments");
		SleepUtils.sleep(3);
		
		//6. Click on Payment_Date Link
		uiDriver.click("US1189TC04_viewandmanagesuspay.lnkPayment_Date");
		SleepUtils.sleep(5);
		
		//7. Click on History WebElement
		uiDriver.click("US1189TC04_viewandmanagesuspay.eltHistory");
		SleepUtils.sleep(5);
		
		//8. Click on Desktop WebElement
		uiDriver.click("US1189TC04_viewandmanagesuspay.eltDesktop");
		SleepUtils.sleep(3);
		
		//9. Click on Unmatched_Suspense_payments WebElement
		uiDriver.click("US1189TC04_viewandmanagesuspay.eltUnmatched_Suspense_payments");
		SleepUtils.sleep(3);
		uiDriver.click("US1188Createsuspensepayments.eltpaymentDate");
		SleepUtils.sleep(12);
		uiDriver.click("US1188Createsuspensepayments.eltpaymentDate");
		SleepUtils.sleep(8);
		
		//10. Click on Edit WebElement
		uiDriver.click("US1189TC04_viewandmanagesuspay.lnkUSP_edit");
		SleepUtils.sleep(3);
		
		//11. Type $data in Account field
		uiDriver.setValue("US1189TC04_viewandmanagesuspay.txtAccount", input.get("Type@Account"));
		SleepUtils.sleep(3);
		
		//12. Click on Update button
		uiDriver.click("US1189TC04_viewandmanagesuspay.btnUpdate");
		SleepUtils.sleep(3);
			

		//13. Click on Apply WebElement
		uiDriver.click("US1189TC04_viewandmanagesuspay.lnkUSP_Apply");
		SleepUtils.sleep(3);
		
		//14. Type $data in Account_1 field
		uiDriver.setValue("US1189TC04_viewandmanagesuspay.txtAccount_1", input.get("Type@Account_1"));
		SleepUtils.sleep(3);
		
		//15. Click on Update_1 button
		uiDriver.click("US1189TC04_viewandmanagesuspay.btnUpdate_1");
		SleepUtils.sleep(3);
		
		//16. Click on Account_1 WebElement
		uiDriver.click("US1189TC04_viewandmanagesuspay.eltAccount_1");
		
		//17. Type $data in Account_Name_1 field
		uiDriver.setValue("US1189TC04_viewandmanagesuspay.txtAccount_Name_1", input.get("Type@Account_Name_1"));
		
		//18. Click on Search button
		uiDriver.click("US1189TC04_viewandmanagesuspay.btnSearch");
		
		//19. Click on Account_1_ Link
		uiDriver.click("US1189TC04_viewandmanagesuspay.lnkAccount_1_");
		
		//20. Click on History_1 WebElement
		uiDriver.click("US1189TC04_viewandmanagesuspay.eltHistory_1");
		SleepUtils.sleep(5);
	}
	

	/**
	*Overriding toString() method of object class to print US1189TC04_viewandmanagesuspay
	*format string
	**/
	public String toString(){
		return "US1189TC04_viewandmanagesuspayDriver";
	}
}
