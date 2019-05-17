/******************************************************************************
Created by : Admin
Created\Updated on : 12/26/2017 10:14:04 AM
Module part of 'sample_1'
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
public class US_1208Driver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public US_1208Driver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
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
		
		//5. Select the Policy_Period ? checkbox
		uiDriver.setValue("US_1208_MaintainDocuments.chkPolicy_Period", input.get("Select@Policy_Period"));
		
		//6. Click on Create_Document button
		uiDriver.click("US_1208_MaintainDocuments.btnCreate_Document");
		
		//7. Click on History_tab WebElement
		uiDriver.click("US_1208_MaintainDocuments.eltHistory_tab");
		
		//8. Click on Date button
		uiDriver.click("US_1208_MaintainDocuments.btnDate");
		
		//9. Read the value from date_time field and store in $data variable
		uiDriver.getValue("US_1208_MaintainDocuments.eltdate_time");
		
		//10. Verify the text $data in the date_time field
		if (uiDriver.verifyText("US_1208_MaintainDocuments.txtdate_time", input.get("VerifyText@date_time"))) {
			passed("verifyText","verifyText should pass","verifyText passed");
		} else {
			failed("verifyText","verifyText should pass","verifyText failed");
		}
		
	}
	
	public void US1208_VerifyDocument(DataRow input, DataRow output) {
		//1. Click on Documents WebElement
		uiDriver.click("US1208_VerifyDocument.eltDocuments");
		
		//2. DoubleClick DocumentType
		uiDriver.doubleclick("US1208_VerifyDocument.eltDocumentType");
		
		//3. Type $data in DocumentType field
		uiDriver.setValue("US1208_VerifyDocument.txtDocumentType", input.get("Type@DocumentType"));
		
		//4. Click on SearchStartDate WebElement
		uiDriver.click("US1208_VerifyDocument.eltSearchStartDate");
		
		//5. Click on Today button
		uiDriver.click("US1208_VerifyDocument.btnToday");
		
		//6. Click on Search button
		uiDriver.click("US1208_VerifyDocument.btnSearch");
		
		//7. Click on DownloadDocument button
		uiDriver.click("US1208_VerifyDocument.btnDownloadDocument");
		
		//8. Click on History WebElement
		uiDriver.click("US1208_VerifyDocument.eltHistory");
		
		//9. Click on Date WebElement
		uiDriver.click("US1208_VerifyDocument.eltDate");
		
		//10. Verify Description
		uiDriver.Verify("US1208_VerifyDocument.eltDescription");
		
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
		
		//6. DoubleClick ActionDate
		uiDriver.doubleclick("US1208_Xpression.eltActionDate");
		
		//7. Select the Document ? checkbox
		uiDriver.setValue("US1208_Xpression.chkDocument", input.get("Select@Document"));
		
		//8. Click on Open WebElement
		uiDriver.click("US1208_Xpression.eltOpen");
		
		//9. Wait for $Seconds seconds
		uiDriver.waitForBrowserStability(15000);
		
		//10. Click on next1 WebElement
		uiDriver.click("US1208_Xpression.eltnext1");
		
		//11. Click on next2 WebElement
		uiDriver.click("US1208_Xpression.eltnext2");
		
		//12. DoubleClick ActionDate
		uiDriver.doubleclick("US1208_Xpression.eltActionDate");
		
	}
	

	/**
	*Overriding toString() method of object class to print US_1208
	*format string
	**/
	public String toString(){
		return "US_1208Driver";
	}
}
