/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 1/18/2018 1:27:32 AM
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
 * Extends BaseModuleDriver class and performs application specific operations
 */
public class MaintainBCGroupsDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;

	public MaintainBCGroupsDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}

	public void TC01_ITAdmn_EdtDel_Grup(DataRow input, DataRow output) {
			
		//1. Click on Administration WebElement
		uiDriver.click("Admin_UserSearch.eltAdministration");
		SleepUtils.sleep(4);
			
		// 2. Click on Group WebElement
		uiDriver.click("Create_New_Activity_Pattern.eltGroup");
		SleepUtils.sleep(4);
			
		// 3. Click on New Group Button
		uiDriver.click("MaintainBCGroups.btnNewGroup");
		SleepUtils.sleep(4);
		
		// 4. Type $data in Name field
		uiDriver.setValue("MaintainBCGroups.txtName", input.get("Type@GroupName"));
		SleepUtils.sleep(2);
		
		// 5. Click on Image element
		uiDriver.click("MaintainBCGroups.ImgSearch");
		SleepUtils.sleep(4);
		
		// 6. Click on search for user element
		uiDriver.click("MaintainBCGroups.eltSearchForUser");
		SleepUtils.sleep(4);
		
		// 7. Type $data in User_Name field
		uiDriver.setValue("TC02_AccountBillDiscrepancy.txtUser_name", System.getProperty("user.name"));
		SleepUtils.sleep(4);
		
		// 8. Click on Search button
		uiDriver.click("TC02_AccountBillDiscrepancy.btnSearch");
		SleepUtils.sleep(4);
		
		// 9. Click on Select button
		uiDriver.click("TC02_AccountBillDiscrepancy.btnSelect");
		SleepUtils.sleep(4);
	
		// 10. Click on Select button
		uiDriver.click("MaintainBCGroups.btnAdd");
		SleepUtils.sleep(4);	
		
		// 11. Click on user element
		uiDriver.click("MaintainBCGroups.eltUser");
		SleepUtils.sleep(4);

		// 12. Click on Select user button
		uiDriver.click("MaintainBCGroups.eltUser_1");
		SleepUtils.sleep(4);
		
		// 13. Type $data in User_Name field
		uiDriver.setValue("TC02_AccountBillDiscrepancy.txtUser_name", System.getProperty("user.name"));
		SleepUtils.sleep(4);
		
		// 14. Click on Search button
		uiDriver.click("TC02_AccountBillDiscrepancy.btnSearch");
		SleepUtils.sleep(4);
		
		// 15. Click on Select button
		uiDriver.click("TC02_AccountBillDiscrepancy.btnSelect");
		SleepUtils.sleep(4);
		
		// 16. Click on Update button
		uiDriver.click("MaintainBCGroups.btnUpdate");
		SleepUtils.sleep(4);
		
		// 17. Click on Edit button
		uiDriver.click("MaintainBCGroups.btnEdit");
		SleepUtils.sleep(4);
		
		// 18. Type $data in Name field
		uiDriver.setValue("MaintainBCGroups.txtNameEdit", input.get("Type@GroupName_1"));
		SleepUtils.sleep(2);
		
		// 19.Fetch the data
		String userName=uiDriver.th.getCellData("MaintainBCGroups.tblGroup", 0, 1);
		SleepUtils.sleep(2);
		
		//20.Select the check box
		uiDriver.th.findRelativeCellAndClickfirstCell("MaintainBCGroups.tblGroup", userName, 1, userName);
		SleepUtils.sleep(2);
		
		// 21. Click on Remove button
		uiDriver.click("MaintainBCGroups.btnRemove");
		SleepUtils.sleep(4);
				
		// 22. Click on Update button
		uiDriver.click("MaintainBCGroups.btnUpdateGroup");
		SleepUtils.sleep(4);
		
		// 23. Click on Remove button
		uiDriver.click("MaintainBCGroups.btnDeleteGroup");
		SleepUtils.sleep(6);
		
		// 24. Click on OK button
		uiDriver.click("Close_Servicetickets_Account.btnOk");
		SleepUtils.sleep(6);
			
	}
		
	public void TC04_LoadFact_Added_Group(DataRow input, DataRow output) {
		
		//1. Click on Administration WebElement
		uiDriver.click("Admin_UserSearch.eltAdministration");
		
		// 2. Click on Group WebElement
		uiDriver.click("Create_New_Activity_Pattern.eltGroup");
		SleepUtils.sleep(4);
		
		// 3.Fetch the data
		int i=0;
		for(i=0;i<=5;i++) {
		String userName=uiDriver.th.getCellData("Create_New_Activity_Pattern.tblGroup", i, 1);
		SleepUtils.sleep(2);
		
		// 4.Click the Group 
		uiDriver.th.findRelativeCellAndClickSelectedCellInlink("Create_New_Activity_Pattern.tblGroup", userName, 1, 0, userName);
		SleepUtils.sleep(6);
			
		//5.Verify the Load factor is presented
		if (uiDriver.checkElementPresent("MaintainBCGroups.eltLoadFactor")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}

		// 6. Click on Return to Group WebElement
		uiDriver.click("MaintainBCGroups.lnkReturnstoGroup");
		SleepUtils.sleep(4);
		}
		
	}
		

	/**
	 * Overriding toString() method of object class to print MyDesktopScreens
	 * format string
	 **/
	public String toString() {
		return "MaintainBCGroups";
	}
}
