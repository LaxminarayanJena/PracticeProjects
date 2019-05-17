/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 3/27/2018 3:45:35 AM
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
public class US921_MaintainPolicyPaymentScheduleDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public US921_MaintainPolicyPaymentScheduleDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void TC03_MaintainPaymentschedule(DataRow input, DataRow output) {
		//1. Click on Policy WebElement
		uiDriver.click("TC03_MaintainPaymentschedule.eltPolicy");
		SleepUtils.sleep(3);
		
		//2. Type $data in Policy_ field
		uiDriver.setValue("TC03_MaintainPaymentschedule.txtPolicy_", input.get("Type@Policy_"));
		SleepUtils.sleep(3);
		
		//3. Click on Search button
		uiDriver.click("TC03_MaintainPaymentschedule.btnSearch");
		SleepUtils.sleep(3);
		
		//4. Verify whether the Policy_ link is present
		if (uiDriver.checkElementPresent("TC03_MaintainPaymentschedule.lnkPolicy1")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		//5. Click on Policy_ Link
		uiDriver.click("TC03_MaintainPaymentschedule.lnkPolicy_");
		SleepUtils.sleep(3);
		
		//6. Click on Payment_Schedule WebElement
		uiDriver.click("TC03_MaintainPaymentschedule.eltPayment_Schedule");
		SleepUtils.sleep(3);
		
		//7. Click on Edit_Schedule button
		uiDriver.click("TC03_MaintainPaymentschedule.btnEdit_Schedule");
		SleepUtils.sleep(3);
		
		//8. Verify whether the Planned button is present
		if (uiDriver.checkElementPresent("TC03_MaintainPaymentschedule.btnPlanned")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(3);SleepUtils.sleep(3);
		
		//9. Click New_Payment_Plan
		uiDriver.click("TC03_MaintainPaymentschedule.txtNew_Payment_Plan");
		SleepUtils.sleep(3);
		
		//10. Select $data from the New_Payment_Plan list
		uiDriver.setValue("TC03_MaintainPaymentschedule.lstNew_Payment_Plan", input.get("Select@New_Payment_Plan"));
		uiDriver.sendKey("tab");
		SleepUtils.sleep(3);
		
		//11. Click on Execute button
		uiDriver.click("TC03_MaintainPaymentschedule.btnExecute");
		SleepUtils.sleep(6);	
	}
	
	public void TC03_Paymentschedule_Roles(DataRow input, DataRow output) {
		//1. Click on Policy WebElement
		uiDriver.click("TC03_Paymentschedule_Roles.eltPolicy");
		SleepUtils.sleep(3);
		
		//2. Type $data in Policy_ field
		uiDriver.setValue("TC03_Paymentschedule_Roles.txtPolicy_", input.get("Type@Policy_"));
		SleepUtils.sleep(3);
		
		//3. Click on Search button
		uiDriver.click("TC03_Paymentschedule_Roles.btnSearch");
		SleepUtils.sleep(3);
		
		//4. Verify whether the Policy_ link is present
		if (uiDriver.checkElementPresent("TC03_Paymentschedule_Roles.lnkPolicy_")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		//5. Click on Policy_1 Link
		uiDriver.click("TC03_Paymentschedule_Roles.lnkPolicy_1");
		SleepUtils.sleep(3);
		
		//6. Click on Payment_Schedule WebElement
		uiDriver.click("TC03_Paymentschedule_Roles.eltPayment_Schedule");
		SleepUtils.sleep(3);
		
		//7. Click on Edit_Schedule button
		uiDriver.click("TC03_Paymentschedule_Roles.btnEdit_Schedule");
		SleepUtils.sleep(3);
		
		//8. Click on New_Payment_Plan WebElement
		uiDriver.click("TC03_Paymentschedule_Roles.eltNew_Payment_Plan");
		SleepUtils.sleep(3);
		
		//9. Select $data from the New_Payment_Plan list
		uiDriver.setValue("TC03_Paymentschedule_Roles.lstNew_Payment_Plan", input.get("Select@New_Payment_Plan"));
		uiDriver.sendKey("tab");
		SleepUtils.sleep(3);
		
		//10. Verify whether the Warningmessage element present
		if (uiDriver.checkElementPresent("TC03_Paymentschedule_Roles.eltWarningmessage")) {
					passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
				} else {
					failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
				}
				SleepUtils.sleep(6);
		
		//11. Click on Execute button
		uiDriver.click("TC03_Paymentschedule_Roles.btnExecute");
		SleepUtils.sleep(3);

	}
	
	public void TC03_PaymentSchedule_ITAdmin(DataRow input, DataRow output) {
		//1. Click on Policy WebElement
		uiDriver.click("TC03_PaymentSchedule_ITAdmin.eltPolicy");
		SleepUtils.sleep(3);
		
		//2. Type $data in Policy_ field
		uiDriver.setValue("TC03_PaymentSchedule_ITAdmin.txtPolicy_", input.get("Type@Policy_"));
		SleepUtils.sleep(3);
		
		//3. Click on Search button
		uiDriver.click("TC03_PaymentSchedule_ITAdmin.btnSearch");
		SleepUtils.sleep(3);
		
		//4. Click on Policy Link
		uiDriver.click("TC03_PaymentSchedule_ITAdmin.lnkPolicy");
		SleepUtils.sleep(3);
		
		//5. Verify whether the Payment_Schedule element present
		if (uiDriver.checkElementPresent("TC03_PaymentSchedule_ITAdmin.eltPayment_Schedule")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(3);
	}
	

	/**
	*Overriding toString() method of object class to print US921_MaintainPolicyPaymentSchedule
	*format string
	**/
	public String toString(){
		return "US921_MaintainPolicyPaymentScheduleDriver";
	}
}
