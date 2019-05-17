/******************************************************************************
Created by : AT1
Created\Updated on : 5/17/2018 8:05:55 AM
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
public class US1025_BCPermissionsDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public US1025_BCPermissionsDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void TC01_BCPermissionsbyRole(DataRow input, DataRow output) {
		//1.Click on Desktop Web Element
		uiDriver.click("TC01_BCPermissionsbyRole.eltAdministration");
		SleepUtils.sleep(10);
		
		//2.Click Web Element My_Approval_Statuses
		uiDriver.click("TC01_BCPermissionsbyRole.eltRoles");
		SleepUtils.sleep(4);
		
		//3. Type $data in Paging field
		String PageEnd=uiDriver.getControl("TC01_BCPermissionsbyRole.eltUserRoles").getText();
        String num=PageEnd.substring(2).trim();
        int PageLenth=Integer.parseInt(num);
        int i;
        for(i=0;i<=PageLenth-1;i++) {
            if (uiDriver.checkElementPresent("TC01_BCPermissionsbyRole.eltCS_Ops")) {
                uiDriver.click("TC01_BCPermissionsbyRole.eltCS_Ops");
                SleepUtils.sleep(8);
                break;    
          }

               uiDriver.click("TC01_BCPermissionsbyRole.btnArrowforward");
               SleepUtils.sleep(4);
               if (uiDriver.checkElementPresent("TC01_BCPermissionsbyRole.eltCS_Ops")) {
                     uiDriver.click("TC01_BCPermissionsbyRole.eltCS_Ops");
                     SleepUtils.sleep(8);
                     break;
                     
               }
               
        }
        uiDriver.click("TC01_BCPermissionsbyRole.lnkUp_to_Roles");
        
	}
	
	
	public void TC01_BCPermissionsCo(DataRow input, DataRow output) {
		SleepUtils.sleep(10);
		//1.Click on Desktop Web Element
		uiDriver.click("TC01_BCPermissionsCo.eltAdministration");
		SleepUtils.sleep(10);
		
		//2.Click Web Element My_Approval_Statuses
		uiDriver.click("TC01_BCPermissionsCo.eltRoles");
		SleepUtils.sleep(4);
		
		//3. Type $data in Paging field
		String PageEnd=uiDriver.getControl("TC01_BCPermissionsCo.eltUserRoles").getText();
        String num=PageEnd.substring(2).trim();
        int PageLenth=Integer.parseInt(num);
        int i;
        for(i=0;i<=PageLenth-1;i++) {
            if (uiDriver.checkElementPresent("TC01_BCPermissionsCo.eltCollection")) {
                uiDriver.click("TC01_BCPermissionsCo.eltCollection");
                SleepUtils.sleep(8);
                break;    
          }

               uiDriver.click("TC01_BCPermissionsCo.btnArrowforward");
               SleepUtils.sleep(4);
               if (uiDriver.checkElementPresent("TC01_BCPermissionsCo.eltCollection")) {
                     uiDriver.click("TC01_BCPermissionsCo.eltCollection");
                     SleepUtils.sleep(8);
                     break;
                     
               }
              
        }
        uiDriver.click("TC01_BCPermissionsCo.lnkUp_to_Roles");
	}
	
	public void TC01_BCPermissionsCS(DataRow input, DataRow output) {
		SleepUtils.sleep(10);
		//1.Click on Desktop Web Element
		uiDriver.click("TC01_BCPermissionsCS.eltAdministration");
		SleepUtils.sleep(4);
		
		//2.Click Web Element My_Approval_Statuses
		uiDriver.click("TC01_BCPermissionsCS.eltRoles");
		SleepUtils.sleep(4);
		
		//3. Type $data in Paging field
		String PageEnd=uiDriver.getControl("TC01_BCPermissionsCS.eltUserRoles").getText();
        String num=PageEnd.substring(2).trim();
        int PageLenth=Integer.parseInt(num);
        int i;
        for(i=0;i<=PageLenth-1;i++) {
            if (uiDriver.checkElementPresent("TC01_BCPermissionsCS.eltCustomer_Service_Supervisor")) {
                uiDriver.click("TC01_BCPermissionsCS.eltCustomer_Service_Supervisor");
                SleepUtils.sleep(8);
                break;    
          }

               uiDriver.click("TC01_BCPermissionsCS.btnArrowforward");
               SleepUtils.sleep(4);
               if (uiDriver.checkElementPresent("TC01_BCPermissionsCS.eltCustomer_Service_Supervisor")) {
                     uiDriver.click("TC01_BCPermissionsCS.eltCustomer_Service_Supervisor");
                     SleepUtils.sleep(8);
                     break;
                     
               }
               
        }
        uiDriver.click("TC01_BCPermissionsCS.lnkUp_to_Roles");
	}
	
	public void TC01_BCPermissionsExecutive(DataRow input, DataRow output) {
		SleepUtils.sleep(10);
		//1.Click on Desktop Web Element
		uiDriver.click("TC01_BCPermissionsExecutive.eltAdministration");
		SleepUtils.sleep(10);
		
		//2.Click Web Element My_Approval_Statuses
		uiDriver.click("TC01_BCPermissionsExecutive.eltRoles");
		SleepUtils.sleep(4);
		
		//3. Type $data in Paging field	
		String PageEnd=uiDriver.getControl("TC01_BCPermissionsExecutive.eltUserRoles").getText();
        String num=PageEnd.substring(2).trim();
        int PageLenth=Integer.parseInt(num);
        int i;
        for(i=0;i<=PageLenth-1;i++) {
            if (uiDriver.checkElementPresent("TC01_BCPermissionsExecutive.eltExecutive")) {
                uiDriver.click("TC01_BCPermissionsExecutive.eltExecutive");
                SleepUtils.sleep(8);
                break;    
          }

               uiDriver.click("TC01_BCPermissionsExecutive.btnArrowforward");
               SleepUtils.sleep(4);
               if (uiDriver.checkElementPresent("TC01_BCPermissionsExecutive.eltExecutive")) {
                     uiDriver.click("TC01_BCPermissionsExecutive.eltExecutive");
                     SleepUtils.sleep(8);
                     break;
                     
               }
               
        }
        uiDriver.click("TC01_BCPermissionsExecutive.lnkUp_to_Roles");
	}
	
	public void TC01_BCPermissionsIT(DataRow input, DataRow output) {
		SleepUtils.sleep(10);
		//1.Click on Desktop Web Element
		uiDriver.click("TC01_BCPermissionsIT.eltAdministration");
		SleepUtils.sleep(10);
		
		//2.Click Web Element My_Approval_Statuses
		uiDriver.click("TC01_BCPermissionsIT.eltRoles");
		SleepUtils.sleep(4);
		
		//3. Type $data in Paging field	
		String PageEnd=uiDriver.getControl("TC01_BCPermissionsIT.eltUserRoles").getText();
        String num=PageEnd.substring(2).trim();
        int PageLenth=Integer.parseInt(num);
        int i;
        for(i=0;i<=PageLenth-1;i++) {
            if (uiDriver.checkElementPresent("TC01_BCPermissionsIT.eltIT_Admin")) {
                uiDriver.click("TC01_BCPermissionsIT.eltIT_Admin");
                SleepUtils.sleep(8);
                break;    
          }

               uiDriver.click("TC01_BCPermissionsIT.btnArrowforward");
               SleepUtils.sleep(4);
               if (uiDriver.checkElementPresent("TC01_BCPermissionsIT.eltIT_Admin")) {
                     uiDriver.click("TC01_BCPermissionsIT.eltIT_Admin");
                     SleepUtils.sleep(8);
                     break;
                     
               }
               
        }
        uiDriver.click("TC01_BCPermissionsIT.lnkUp_to_Roles");
	}
	
	public void TC01_BCPermissionsPPA(DataRow input, DataRow output) {
		SleepUtils.sleep(10);
		//1.Click on Desktop Web Element
		uiDriver.click("TC01_BCPermissionsPPA.eltAdministration");
		SleepUtils.sleep(10);
		
		//2.Click Web Element My_Approval_Statuses
		uiDriver.click("TC01_BCPermissionsPPA.eltRoles");
		SleepUtils.sleep(4);
		
		//3. Type $data in Paging field	
		String PageEnd=uiDriver.getControl("TC01_BCPermissionsPPA.eltUserRoles").getText();
        String num=PageEnd.substring(2).trim();
        int PageLenth=Integer.parseInt(num);
        int i;
        for(i=0;i<=PageLenth-1;i++) {
            if (uiDriver.checkElementPresent("TC01_BCPermissionsPPA.eltPremium_Processor_Assistant")) {
                uiDriver.click("TC01_BCPermissionsPPA.eltPremium_Processor_Assistant");
                SleepUtils.sleep(8);
                break;    
          }

               uiDriver.click("TC01_BCPermissionsPPA.btnArrowforward");
               SleepUtils.sleep(4);
               if (uiDriver.checkElementPresent("TC01_BCPermissionsPPA.eltPremium_Processor_Assistant")) {
                     uiDriver.click("TC01_BCPermissionsPPA.eltPremium_Processor_Assistant");
                     SleepUtils.sleep(8);
                     break;
                     
               }
               
        }
        uiDriver.click("TC01_BCPermissionsPPA.lnkUp_to_Roles");
	}
	
	public void TC01_BCPermissionsRo(DataRow input, DataRow output) {
		SleepUtils.sleep(10);
		//1.Click on Desktop Web Element
		uiDriver.click("TC01_BCPermissionsRo.eltAdministration");
		SleepUtils.sleep(10);
		
		//2.Click Web Element My_Approval_Statuses
		uiDriver.click("TC01_BCPermissionsRo.eltRoles");
		SleepUtils.sleep(4);
		
		//3. Type $data in Paging field	
		String PageEnd=uiDriver.getControl("TC01_BCPermissionsRo.eltUserRoles").getText();
        String num=PageEnd.substring(2).trim();
        int PageLenth=Integer.parseInt(num);
        int i;
        for(i=0;i<=PageLenth-1;i++) {
            if (uiDriver.checkElementPresent("TC01TC01_BCPermissionsRo_BCPermissionsbyRole.eltRead_Only")) {
                uiDriver.click("TC01_BCPermissionsRo.eltRead_Only");
                SleepUtils.sleep(8);
                break;    
          }

               uiDriver.click("TC01_BCPermissionsRo.btnArrowforward");
               SleepUtils.sleep(4);
               if (uiDriver.checkElementPresent("TC01_BCPermissionsRo.eltRead_Only")) {
                     uiDriver.click("TC01_BCPermissionsRo.eltRead_Only");
                     SleepUtils.sleep(8);
                     break;
                     
               }
             
        }
        uiDriver.click("TC01_BCPermissionsRo.lnkUp_to_Roles");
	}
	

	/**
	*Overriding toString() method of object class to print US1025_BCPermissions
	*format string
	**/
	public String toString(){
		return "US1025_BCPermissionsDriver";
	}
}
