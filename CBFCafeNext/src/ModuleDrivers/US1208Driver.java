/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 12/26/2017 10:14:04 AM
Module part of GW Billing Center'
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
public class US1208Driver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	private String Policy;
	
	public US1208Driver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public  void Setpolicy(String Policy){
		this.Policy=Policy;
	}
	
	public String getPolicy() {
		return Policy;
	}
	
	public void US_1208_MaintainDocuments(DataRow input, DataRow output) {
		//1. Click on Actions WebElement
		uiDriver.click("US_1208_MaintainDocuments.eltActions");
		
		//2. Click on Create_New_Document_from_template WebElement
		uiDriver.click("US_1208_MaintainDocuments.eltCreate_New_Document_from_template");
		
		//3. Double Click on Document_Template in the list
		uiDriver.doubleclick("US_1208_MaintainDocuments.lstDocument_Template");
		
		//4. Type $data in Apology_Letter field
		uiDriver.setValue("US_1208_MaintainDocuments.txtApology_Letter", input.get("Type@Apology_Letter"));
		uiDriver.sendKey("enter");
		SleepUtils.sleep(6);

		
		//6. Click on Create_Document button
		String Policy=uiDriver.th.getCellData("US_1208_MaintainDocuments.tblCreateNewDoc", 0, 1);
		SleepUtils.sleep(3);
		uiDriver.th.findRelativeCellAndClickfirstCell("US_1208_MaintainDocuments.tblCreateNewDoc", Policy, 1, Policy);
		SleepUtils.sleep(6);
		uiDriver.click("US_1208_MaintainDocuments.btnCreate_Document");
		SleepUtils.sleep(3);
		
		//7. Click on History_tab WebElement
		uiDriver.click("US_1208_MaintainDocuments.eltHistory_tab");
		
		//8. Click on Date button
		uiDriver.doubleclick("US_1208_MaintainDocuments.eltfilterby");
		
		//9. Click on History_tab WebElement
		uiDriver.setValue("US_1208_MaintainDocuments.txtfilter", input.get("Type@filtertext"));
		uiDriver.sendKey("tab");
		String actualTextName = uiDriver.th.getCellData("US_1208_MaintainDocuments.tbname", 0, 4);
		SleepUtils.sleep(3);
		String expectedTextName = "Apology Letter Sent";

		if (actualTextName.equalsIgnoreCase(expectedTextName)) {
			passed("verifyText", "verifyText should pass", "verifyText passed");
		} else {
			failed("verifyText", "verifyText should pass", "verifyText failed");
		}
		
	}
	
	public void US1208_VerifyDocument(DataRow input, DataRow output) {
		
		//1. Click on Policies
		uiDriver.click("NewEmailVerification.btnpolicies");

		//2. Click on Policy_Number Link
		uiDriver.click("NewEmailVerification.lnkPolicy_Number");
		//uiDriver.webDr.findElement(By.xpath("//*[text()='"+getPolicy()+"']")).click();
		
		//3. Click on Documents WebElement
		uiDriver.click("US1208_VerifyDocument.eltDocuments");
		
		//4. DoubleClick DocumentType
		uiDriver.doubleclick("US1208_VerifyDocument.eltDocumentType");
		
		//5. Type $data in DocumentType field
		uiDriver.setValue("US1208_VerifyDocument.txtDocumentType", input.get("Type@DocumentType"));
		uiDriver.sendKey("enter");
		SleepUtils.sleep(2);
		
		//6. Click on Search button
		uiDriver.click("US1208_VerifyDocument.btnSearch");
		SleepUtils.sleep(3);
		
		//7. Click on DownloadDocument button
		uiDriver.click("US1208_VerifyDocument.btnDownloadDocument");
		SleepUtils.sleep(3);
		
	}
	
	public void US1208_Xpression(DataRow input, DataRow output) {
		
		
		//1. Navigate to $data URL using CHROME browser
		uiDriver.launchApplication(input.get("Navigate@CHROME"));
		
		//2. Type $data in UserName field
		uiDriver.setValue("US1208_Xpression.txtUserName", input.get("Type@UserName"));
		
		//3. Type $data in Password field
		uiDriver.setValue("US1208_Xpression.txtPassword", input.get("Type@Password"));
		
		//4. Click on login button
		uiDriver.click("US1208_Xpression.btnlogin");
		
		//5. Click on WorkInProgressTab WebElement
		uiDriver.click("US1208_Xpression.eltWorkInProgressTab");
		SleepUtils.sleep(2);
		uiDriver.click("US1208_Xpression.eltDatesort");
		uiDriver.click("US1208_Xpression.eltDatesort");
		SleepUtils.sleep(3);
		
		//6. Select the Document ? checkbox
		uiDriver.th.findRelativeCellAndClickSelectedCell("US1208_Xpression.totalrows", "PHLY BC Apology Letter", 1, "PHLY BC Apology Letter", "PHLY BC Apology Letter");
		SleepUtils.sleep(3);
		
		//7. Click on next1 WebElement
		uiDriver.click("US1208_Xpression.eltnext1");
		
		//8. Click on next2 WebElement
		uiDriver.click("US1208_Xpression.eltnext2");
		SleepUtils.sleep(3);
		
		//9. Click on logout WebElement
		uiDriver.click("US1208_Xpression.lnklogout");
		SleepUtils.sleep(3);
	}
	

	/**
	*Overriding toString() method of object class to print US_1208
	*format string
	**/
	public String toString(){
		return "US_1208Driver";
	}
}
