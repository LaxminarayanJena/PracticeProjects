/******************************************************************************
Created by : Capgemini Automation team 
Created\Updated on : 5/10/2018 2:23:32 AM
Module part of 'Guidewire_BillingCenter'
Module created using Cafenext Selenium Builder
******************************************************************************/

package ModuleDrivers;

import cbf.harness.ParameterAccess;
import cbf.utils.DataRow;
import cbf.utils.SleepUtils;
import cbfx.selenium.BaseWebModuleDriver;


	public class US1018_ViewTransactionApprovalDriver extends BaseWebModuleDriver {
		private ParameterAccess paramAccess;
		
		public US1018_ViewTransactionApprovalDriver(ParameterAccess paramAccess) {
			this.paramAccess = paramAccess;
		}
		
		public void TC02_ViewTransactionApproval(DataRow input, DataRow output) {
			//1.Click on Desktop Web Element
			uiDriver.click("TC02_ViewTransactionApproval.eltDesktop");
			SleepUtils.sleep(4);
			
			//2.Click Web Element My_Approval_Statuses
			uiDriver.click("TC02_ViewTransactionApproval.eltMy_Approval_Statuses");
			SleepUtils.sleep(4);
			
			//3.Click Web Element User Desktop
			uiDriver.click("TC02_ViewTransactionApproval.eltUser_Desktop");
			SleepUtils.sleep(4);
			
			//4.Select $data from the User Desktop List
			uiDriver.setValue("TC02_ViewTransactionApproval.txtUser_Desktop", System.getProperty("user.name"));
	        SleepUtils.sleep(6);
	        
	        //5.Select $data from the User Desktop List
	        uiDriver.setValue("TC02_ViewTransactionApproval.txtUser_Desktop_1", input.get("Type@User_Desktop_1"));
	        SleepUtils.sleep(6);
}
		/**
		 * Overriding toString() method of object class to print
		 * US1018_ViewTransactionApprovalStatus format string
		 **/
		public String toString() {
			return "US1018_ViewTransactionApprovalDriver";
		}
	}
