/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 12/28/2017 2:20:12 AM
Module part of 'Guidewire_BillingCenter'
Module created using Cafenext Selenium Builder
******************************************************************************/
package ModuleDrivers;
import static cbf.engine.TestResultLogger.*;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cbf.engine.TestResult.ResultType;
import cbf.harness.ParameterAccess;
import cbf.utils.DataRow;
import cbf.utils.SleepUtils;
import cbf.utils.SleepUtils.TimeSlab;
import cbfx.selenium.BaseWebModuleDriver;

/**
Extends BaseModuleDriver class and performs application specific operations
*/
public class US1247_MoveDirectBilltosusDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public US1247_MoveDirectBilltosusDriver(ParameterAccess paramAccess) {
					this.paramAccess = paramAccess;
	}
	
	public void US1247_TC02MoveDirectBilltosus(DataRow input, DataRow output) {
		
		//1. Click on Account WebElement
		uiDriver.click("US1247_TC02MoveDirectBilltosus.eltAccount");
		SleepUtils.sleep(3);
		
		//2. Type $data in Account_Name field
		uiDriver.setValue("US1247_TC02MoveDirectBilltosus.txtAccount_Name", input.get("Type@Account_Name"));
		SleepUtils.sleep(3);
		
		//3. Click on Search button
		uiDriver.click("US1247_TC02MoveDirectBilltosus.btnSearch");
		SleepUtils.sleep(3);
		
		//4. Click on Account Link
		uiDriver.click("US1247_TC02MoveDirectBilltosus.lnkAccount");
		SleepUtils.sleep(3);
		
		//5. Click on Payments WebElement
		uiDriver.click("US1247_TC02MoveDirectBilltosus.eltPayments");
		SleepUtils.sleep(3);
		
		//6. Click on Actions button
		String PageEnd=uiDriver.getControl("US1247_TC02MoveDirectBilltosus.eltlength").getText();
		SleepUtils.sleep(3);
		if (!PageEnd.equals("")) {
			//String PageEnd=uiDriver.getControl("US1247_TC02MoveDirectBilltosus.eltlength").getText();
	        String num=PageEnd.substring(2).trim();
	        int PageLenth=Integer.parseInt(num);
	        int i;
	        for(i=0;i<=PageLenth-1;i++) {
	        	uiDriver.click("US1247_TC02MoveDirectBilltosus.BtnForwardArrow");
	            if (i==PageLenth) {
	            	uiDriver.click("US1247_TC02MoveDirectBilltosus.BtnForwardArrow");
	                SleepUtils.sleep(8);
	                break;    
	          }
	        }
			uiDriver.th.findRelativeCellAndClickSelectedCellInSubtext("US1247_TC02MoveDirectBilltosus.tblId", "MasterCard", 3,  "MasterCard", "Actions", "Actions");
			SleepUtils.sleep(3);
		}else {
			uiDriver.th.findRelativeCellAndClickSelectedCellInSubtext("US1247_TC02MoveDirectBilltosus.tblId", "MasterCard", 3,  "MasterCard", "Actions", "Actions");
			SleepUtils.sleep(3);
		}
				
		
		//7. Click on Move_To_Unmatched_Suspense WebElement
		uiDriver.click("US1247_TC02MoveDirectBilltosus.eltMove_To_Unmatched_Suspense");
		SleepUtils.sleep(5);
		
		//8. Type $data in Notes field
		uiDriver.setValue("US1247_TC02MoveDirectBilltosus.txtNotes", input.get("Type@Notes"));
		SleepUtils.sleep(3);
		
		//9. Type $data in Account field
		uiDriver.setValue("US1247_TC02MoveDirectBilltosus.txtAccount", input.get("Type@Account"));
		SleepUtils.sleep(3);
		
		//10. Click on Execute button
		uiDriver.click("US1247_TC02MoveDirectBilltosus.btnExecute");
		SleepUtils.sleep(3);
		
		//11. Click on Check_Ref WebElement
		uiDriver.click("US1247_TC02MoveDirectBilltosus.eltCheck_Ref");
		SleepUtils.sleep(5);
		
		//12. Click on Administration WebElement
		uiDriver.click("US1247_TC02MoveDirectBilltosus.eltAdministration");
		SleepUtils.sleep(2);
		
		//13. Click on Users WebElement
		uiDriver.click("US1247_TC02MoveDirectBilltosus.eltUsers");
		
		//14. Type $data in First_Name field
		uiDriver.setValue("Adminuser_Addrole.txtUser_name",System.getProperty("user.name"));
		SleepUtils.sleep(3);
		
		//15. Click on Search_1 button
		uiDriver.click("US1247_TC02MoveDirectBilltosus.btnSearch_1");
		SleepUtils.sleep(3);
		
		//16. Click on Display_Name Link
		uiDriver.click("US1247_TC02MoveDirectBilltosus.lnkDisplay_Name");
		SleepUtils.sleep(3);
	}
	



	/**
	*Overriding toString() method of object class to print US1247_TC02MoveDirectBilltosus
	*format string
	**/
	public String toString(){
					return "US1247_TC02MoveDirectBilltosusDriver";
	}
}
