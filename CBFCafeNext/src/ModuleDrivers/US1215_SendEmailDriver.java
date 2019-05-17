/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 12/21/2017 11:21:42 AM
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
 * Extends BaseModuleDriver class and performs application specific operations
 */
public class US1215_SendEmailDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;

	public US1215_SendEmailDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}

	public void US1215_SendEmail(DataRow input, DataRow output) {
		// 1. Click on actions WebElement
		uiDriver.click("US1215_SendEmail.eltactions");
		SleepUtils.sleep(3);

		// 2. Click on New_Email WebElement
		uiDriver.click("US1215_SendEmail.eltNew_Email");
		SleepUtils.sleep(3);

		// 3. Click on New_Email WebElement
		uiDriver.click("US1215_SendEmail.eltNew_Email1");
		SleepUtils.sleep(3);

		// 4. Click on Name WebElement
		uiDriver.click("US1215_SendEmail.eltName");
		SleepUtils.sleep(3);

		// 5. Type $data in txtName field
		uiDriver.setValue("US1215_SendEmail.txtName", input.get("Type@txtName"));
		SleepUtils.sleep(3);

		// 6. Click on Email_Address WebElement
		uiDriver.click("US1215_SendEmail.eltEmail_Address");
		SleepUtils.sleep(3);

		// 7. Type $data in txtEmail_Address field
		uiDriver.setValue("US1215_SendEmail.txtEmail_Address", input.get("Type@txtEmail_Address"));
		SleepUtils.sleep(3);

		// 8. Click on Add_CC_Recipients button
		uiDriver.click("US1215_SendEmail.btnAdd_CC_Recipients");
		SleepUtils.sleep(3);

		// 9. Click on ccname WebElement
		uiDriver.click("US1215_SendEmail.eltccname");
		SleepUtils.sleep(3);

		// 10. Type $data in txtccname field
		uiDriver.setValue("US1215_SendEmail.txttxtccname", input.get("Type@txtccname"));
		SleepUtils.sleep(3);

		// 11. Click on Find_Contact button
		uiDriver.click("US1215_SendEmail.btnFind_Contact");
		SleepUtils.sleep(3);

		// 12. DoubleClick Account_Type
		uiDriver.doubleclick("US1215_SendEmail.eltAccount_Type");
		SleepUtils.sleep(3);

		// 13. Click on Select button
		uiDriver.click("US1215_SendEmail.btnSelect");
		SleepUtils.sleep(3);

		// 14. Click on Add_BCC_recipients button
		uiDriver.click("US1215_SendEmail.btnAdd_BCC_recipients");
		SleepUtils.sleep(3);

		// 15. Click on bccname WebElement
		uiDriver.click("US1215_SendEmail.eltbccname");
		SleepUtils.sleep(3);

		// 16. Type $data in txtbccname field
		uiDriver.setValue("US1215_SendEmail.txtbccname", input.get("Type@txtbccname"));
		SleepUtils.sleep(3);

		// 17. Click on Select button
		uiDriver.click("US1215_SendEmail.btnFind_Contact1");
		SleepUtils.sleep(3);

		// 18. DoubleClick Account_Type
		uiDriver.doubleclick("US1215_SendEmail.eltAccount_Type");
		SleepUtils.sleep(3);

		// 19. Type $data in Policy_Period field
		uiDriver.sendKey("keysdown");
		uiDriver.sendKey("enter");
		SleepUtils.sleep(3);
		
		// 20. DoubleClick Policy_Number
		uiDriver.doubleclick("US1215_SendEmail.eltPolicy_Number");
		uiDriver.sendKey("keysdown");
		uiDriver.sendKey("enter");
		SleepUtils.sleep(3);

		// 21. Click on Select button
		uiDriver.click("US1215_SendEmail.btnSelect1");
		SleepUtils.sleep(3);

		// 22. Click on subject WebElement
		uiDriver.click("US1215_SendEmail.eltsubject");
		SleepUtils.sleep(3);

		// 23. Type $data in txtsubject field
		uiDriver.setValue("US1215_SendEmail.txttxtsubject", input.get("Type@txtsubject"));
		SleepUtils.sleep(3);

		// 24. Click on body WebElement
		uiDriver.click("US1215_SendEmail.eltbody");
		SleepUtils.sleep(3);

		// 25. Type $data in txtbody field
		uiDriver.setValue("US1215_SendEmail.txttxtbody", input.get("Type@txtbody"));
		SleepUtils.sleep(3);

		// 26. Click on Send_Email button
		uiDriver.click("US1215_SendEmail.btnSend_Email");
		SleepUtils.sleep(3);

		// ----------------------------------------------Producer email sending-------------------------------------------------------

		// 1. Click on Send_Email button
		uiDriver.click("US1215_SendEmail.tabProducer");
		uiDriver.doubleclick("US1215_SendEmail.eltProducername");
		uiDriver.setValue("US1215_SendEmail.txtProducername", input.get("Type@producername"));
		uiDriver.click("US1215_SendEmail.btnpsearch3");
		uiDriver.click("US1215_SendEmail.lnkProducerName1");
		uiDriver.click("US1215_SendEmail.tbpactions");
		uiDriver.click("US1215_SendEmail.tbnewemail");
		SleepUtils.sleep(5);
		
		// 2. Click on Name WebElement
		uiDriver.click("US1215_SendEmail.eltName");
		SleepUtils.sleep(3);

		// 3. Type $data in txtName field
		uiDriver.setValue("US1215_SendEmail.txtName", input.get("Type@txtName"));
		SleepUtils.sleep(3);

		// 4. Click on Email_Address WebElement
		uiDriver.click("US1215_SendEmail.eltEmail_Address");
		SleepUtils.sleep(3);

		// 5. Type $data in txtEmail_Address field
		uiDriver.setValue("US1215_SendEmail.txtEmail_Address", input.get("Type@txtEmail_Address"));
		SleepUtils.sleep(3);
		
		// 6. Click on subject WebElement
		uiDriver.click("US1215_SendEmail.eltsubject");
		SleepUtils.sleep(3);

		// 7. Type $data in txtsubject field
		uiDriver.setValue("US1215_SendEmail.txttxtsubject", input.get("Type@txtsubject"));
		SleepUtils.sleep(3);

		// 8. Click on body WebElement
		uiDriver.click("US1215_SendEmail.eltbody");
		SleepUtils.sleep(3);

		// 9. Type $data in txtbody field
		uiDriver.setValue("US1215_SendEmail.txttxtbody", input.get("Type@txtbody"));
		SleepUtils.sleep(3);

		// 10. Click on Send_Email button
		uiDriver.click("US1215_SendEmail.btnSend_Email");
		SleepUtils.sleep(6);
	}

	/**
	 * Overriding toString() method of object class to print US1215_SendEmail format
	 * string
	 **/
	public String toString() {
		return "US1215_SendEmailDriver";
	}
}
