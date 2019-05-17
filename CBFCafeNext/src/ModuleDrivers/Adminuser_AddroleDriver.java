/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 2/21/2018 7:11:35 AM
Module part of 'Guidewire_BillingCenter'
Module created using Cafenext Selenium Builder
******************************************************************************/
package ModuleDrivers;
import static cbf.engine.TestResultLogger.*;
import java.io.IOException;

import org.openqa.selenium.By;

import cbf.engine.TestResult.ResultType;
import cbf.harness.ParameterAccess;
import cbf.utils.DataRow;
import cbf.utils.SleepUtils;
import cbf.utils.SleepUtils.TimeSlab;
import cbfx.selenium.BaseWebModuleDriver;

/**
Extends BaseModuleDriver class and performs application specific operations
*/
public class Adminuser_AddroleDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public Adminuser_AddroleDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void Adminuser_Addrole(DataRow input, DataRow output) {
		//1. Click on Administration WebElement
		uiDriver.click("Adminuser_Addrole.eltAdministration");
		SleepUtils.sleep(2);
		if(!uiDriver.checkElementPresent("Adminuser_Addrole.txtUser_name")) {
			uiDriver.click("Adminuser_Addrole.eltAdministration");	
		}
		SleepUtils.sleep(5);
		
		//2. Type $data in User_name field
		uiDriver.setValue("Adminuser_Addrole.txtUser_name",System.getProperty("user.name"));
		
		//3. Click on Search button
		uiDriver.click("Adminuser_Addrole.btnSearch");
		SleepUtils.sleep(5);
		
		//4. Click on Display_Name Link
		uiDriver.click("Adminuser_Addrole.lnkDisplay_Name");
		SleepUtils.sleep(3);
		
		//5. Click on Edit button
		uiDriver.click("Adminuser_Addrole.btnEdit");
		
		//6. Click on Add_User_Role button
		uiDriver.click("Adminuser_Addrole.btnAdd_User_Role");
		
		//7. Click none
		uiDriver.click("Adminuser_Addrole.txtnone");
		
		//8. Select $data from the Role list
		uiDriver.setValue("Adminuser_Addrole.lstRole", input.get("Select@Role"));
		SleepUtils.sleep(2);
		uiDriver.sendKey("enter");
		SleepUtils.sleep(5);
		
		//9. Click on Update button
		uiDriver.click("Adminuser_Addrole.btnUpdate");
		SleepUtils.sleep(6);
		if(uiDriver.checkElementPresent("Adminuser_Addrole.eltwrnmsg")) {
			SleepUtils.sleep(6);
			try {
				Boolean flag=((uiDriver.webDr.findElement(By.id("UserDetailPage:UserDetailScreen:UserDetailToolbarButtonSet:Cancel-btnInnerEl")).isDisplayed()));
				if(flag) {
				 uiDriver.webDr.findElement(By.id("UserDetailPage:UserDetailScreen:UserDetailToolbarButtonSet:Cancel-btnInnerEl")).click();
				 SleepUtils.sleep(4);
				}
			}catch (Exception e) {

			}
			
		}
	}
	/**
	*Overriding toString() method of object class to print Adminuser_Addrole
	*format string
	**/
	public String toString(){
		return "Adminuser_AddroleDriver";
	}
}
