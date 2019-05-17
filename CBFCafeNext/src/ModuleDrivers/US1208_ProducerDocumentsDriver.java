/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 12/26/2017 4:43:02 PM
Module part of 'Guidewire Billing Center'
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
public class US1208_ProducerDocumentsDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public US1208_ProducerDocumentsDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void US1208_ProducerDocuments(DataRow input, DataRow output) {
		//1. Click on Producer_Tab WebElement
		uiDriver.click("US1208_ProducerDocuments.eltProducer_Tab");
		
		//2. Click on Producer_code WebElement
		uiDriver.click("US1208_ProducerDocuments.eltProducer_code");
		
		//3. Type $data in Producer_Code field
		uiDriver.setValue("US1208_ProducerDocuments.txtProducer_Code", input.get("Type@Producer_Code"));
		uiDriver.click("US1208_ProducerDocuments.btnsearch");
		SleepUtils.sleep(3);
		
		//4. Click on Producer_Name Link
		uiDriver.click("US1208_ProducerDocuments.lnkProducer_Name");
		SleepUtils.sleep(3);
		
		//5. Click on Actions WebElement
		uiDriver.click("US1208_ProducerDocuments.eltActions");
		
		//6. Click on Create_New_Document_from_Template WebElement
		uiDriver.click("US1208_ProducerDocuments.eltCreate_New_Document_from_Template");
		
		//7. Double Click on Document_Template in the list
		uiDriver.doubleclick("US1208_ProducerDocuments.lstDocument_Template");
		
		//8. Type $data in Document_Template field
		uiDriver.setValue("US1208_ProducerDocuments.txtDocument_Template", input.get("Type@Document_Template"));
		uiDriver.sendKey("enter");
				
		//9. Double Click on Account in the list
		uiDriver.doubleclick("US1208_ProducerDocuments.lstAccount");
		SleepUtils.sleep(2);
		uiDriver.sendKey("keysdown");
		uiDriver.sendKey("enter");
		
		//uiDriver.setValue("US1208_ProducerDocuments.txtAccount", input.get("Type@Account"));
			
		String policy=uiDriver.th.getCellData("US_1208_MaintainDocuments.tblCreateNewDoc", 0, 1);
		SleepUtils.sleep(2);
		uiDriver.th.findRelativeCellAndClickfirstCell("US_1208_MaintainDocuments.tblCreateNewDoc", policy, 1, policy);
//		uiDriver.sendKey("enter");
//		uiDriver.click("US1208_ProducerDocuments.chkbox");
//		uiDriver.sendKey("space");
		SleepUtils.sleep(2);

		//10. Click on Create_Document button
		uiDriver.click("US1208_ProducerDocuments.btnCreate_Document");		
	}
	
	public void US1208_VerifyProducerDocuments(DataRow input, DataRow output)  {

		//1. Click on Producer_tab WebElement
		uiDriver.click("US1208_VerifyProducerDocuments.eltProducer_tab");
		
		//2. Click on Producer_Code WebElement
		uiDriver.click("US1208_VerifyProducerDocuments.eltProducer_Code");
		
		//3. Type $data in Producer_Code field
		uiDriver.setValue("US1208_VerifyProducerDocuments.txtProducer_Code", input.get("Type@Producer_Code"));
		uiDriver.click("US1208_ProducerDocuments.btnsearch");
		SleepUtils.sleep(2);
		uiDriver.click("US1208_ProducerDocuments.lnkProducer_Name");
		SleepUtils.sleep(2);
		
		//4. Click on Documents WebElement
		uiDriver.click("US1208_VerifyProducerDocuments.eltDocuments");
		SleepUtils.sleep(2);
		
		//5. Double Click on Document_Type in the list
		uiDriver.click("US1208_VerifyProducerDocuments.lstDocument_Type");
		SleepUtils.sleep(2);
		
		//5. Double Click on Document_Type in the list
		uiDriver.click("US1208_VerifyProducerDocuments.lnkdocuments");
		SleepUtils.sleep(2);
		
		//6. Type $data in Document_Type field
		//uiDriver.setValue("US1208_VerifyProducerDocuments.txtDocument_Type", input.get("Type@Document_Type"));
		SleepUtils.sleep(2);
		
		//7. Click on Search button
		uiDriver.click("US1208_VerifyProducerDocuments.btnSearch");
		SleepUtils.sleep(2);
		
		//8. Click on view button
		uiDriver.click("US1208_VerifyProducerDocuments.btnview");
		SleepUtils.sleep(2);
		
	}
	
	/**
	*Overriding toString() method of object class to print US1208_ProducerDocuments
	*format string
	**/
	public String toString(){
		return "US1208_ProducerDocumentsDriver";
	}
}
