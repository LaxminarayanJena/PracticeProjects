/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 1/18/2018 9:17:53 AM
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
 * Extends BaseModuleDriver class and performs application specific operations
 */
public class Service_TicketsDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;

	public Service_TicketsDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}

	public void Create_Servicetickets_Desktop(DataRow input, DataRow output) {
		// 1. Click on Desktop WebElement
		uiDriver.click("Create_Servicetickets_Desktop.eltDesktop");

		// 2. Click on My_Service_Tickets WebElement
		uiDriver.click("Create_Servicetickets_Desktop.eltMy_Service_Tickets");
		SleepUtils.sleep(3);

		// 3. Click on New button
		uiDriver.click("Create_Servicetickets_Desktop.btnNew");
		SleepUtils.sleep(3);

		// 4. Click on Type WebElement
		uiDriver.click("Create_Servicetickets_Desktop.eltType");
		SleepUtils.sleep(3);
//		Boolean stflag = uiDriver.checkDropDownOptions("li", "Commission");
//		if (stflag = true) {
//			uiDriver.checkDropDownOptions("li", input.get("VerifyList@Type"));
//		} else {
//			uiDriver.click("Create_Servicetickets_Desktop.eltType");
//			SleepUtils.sleep(2);
//			uiDriver.checkDropDownOptions("li", "Commission");
//		}

		// 5. Select $data from the Type list
		uiDriver.setValue("Create_Servicetickets_Desktop.lstType", input.get("Select@Type"));
		uiDriver.sendKey("Enter");
		uiDriver.sendKey("tab");
		SleepUtils.sleep(3);

		// 6. Type $data in Subject field
		uiDriver.setValue("Create_Servicetickets_Desktop.txtSubject", input.get("Type@Subject"));
		SleepUtils.sleep(3);

		// 7. Type $data in Details field
		uiDriver.setValue("Create_Servicetickets_Desktop.txtDetails", input.get("Type@Details"));
		SleepUtils.sleep(3);

		// 8. Click on Priority WebElement
		uiDriver.click("Create_Servicetickets_Desktop.eltPriority");
		SleepUtils.sleep(3);

		// 9. Select $data from the Priority list
		uiDriver.setValue("Create_Servicetickets_Desktop.lstPriority", input.get("Select@Priority"));
		SleepUtils.sleep(3);

		// 10. Click on Add_Accounts button
		uiDriver.click("Create_Servicetickets_Desktop.btnAdd_Accounts");
		SleepUtils.sleep(3);

		// 11. Type $data in Account_Name field
		uiDriver.setValue("Create_Servicetickets_Desktop.txtAccount_Name", input.get("Type@Account_Name"));
		SleepUtils.sleep(3);

		// 12. Click on Search button
		uiDriver.click("Create_Servicetickets_Desktop.btnSearch");
		SleepUtils.sleep(3);
		
		// 13. Click on Checkbox WebElement
		uiDriver.click("Create_Servicetickets_Desktop.eltCheckbox");
		SleepUtils.sleep(3);

		// 14. Click on Select_Accounts button
		uiDriver.click("Create_Servicetickets_Desktop.btnSelect_Accounts");
		SleepUtils.sleep(3);

		// 15. Click on Next button
		uiDriver.click("Create_Servicetickets_Desktop.btnNext");
		SleepUtils.sleep(3);

		// 16. Click on Next_1 button
		uiDriver.click("Create_Servicetickets_Desktop.btnNext_1");
		SleepUtils.sleep(3);
		
		// 17. Click on Finish button
		uiDriver.click("Create_Servicetickets_Desktop.btnFinish");

	}

	public void Create_Servicetickets_Account(DataRow input, DataRow output) {
		// 1. Click on Account WebElement
		uiDriver.click("Create_Servicetickets_Account.eltAccount");
		SleepUtils.sleep(3);
		
		// 2. Type $data in Account_Name field
		uiDriver.setValue("Create_Servicetickets_Account.txtAccount_Name", input.get("Type@Account_Name"));
		SleepUtils.sleep(3);
		
		// 3. Click on Search button
		uiDriver.click("Create_Servicetickets_Account.btnSearch");
		SleepUtils.sleep(3);
		
		// 4. Click on Account Link
		uiDriver.click("Create_Servicetickets_Account.lnkAccount");
		SleepUtils.sleep(3);
		
		// 5. Click on Service_Tickets WebElement
		uiDriver.click("Create_Servicetickets_Account.eltService_Tickets");
		SleepUtils.sleep(3);
		
		// 6. Click on New button
		uiDriver.click("Create_Servicetickets_Account.btnNew");
		SleepUtils.sleep(3);
		
		// 7. Click on Type WebElement
		uiDriver.click("Create_Servicetickets_Account.eltType");
		SleepUtils.sleep(2);
//		Boolean stflag = uiDriver.checkDropDownOptions("li", "Billing Dispute");
//		if (stflag = true) {
//			uiDriver.checkDropDownOptions("li", input.get("VerifyList@Type"));
//		} else {
//			uiDriver.click("Create_Servicetickets_Account.eltType");
//			SleepUtils.sleep(2);
//			uiDriver.checkDropDownOptions("li", "Billing Dispute");
//		}

		// 8. Select $data from the Type list
		uiDriver.setValue("Create_Servicetickets_Account.lstType", input.get("Select@Type"));
		uiDriver.sendKey("Enter");
		uiDriver.sendKey("tab");
		SleepUtils.sleep(2);

		// 9. Type $data in Subject field
		uiDriver.setValue("Create_Servicetickets_Account.txtSubject", input.get("Type@Subject"));
		SleepUtils.sleep(2);

		// 10. Type $data in Details field
		uiDriver.setValue("Create_Servicetickets_Account.txtDetails", input.get("Type@Details"));
		SleepUtils.sleep(2);

		// 11. Click on Priority WebElement
		uiDriver.click("Create_Servicetickets_Account.eltPriority");
		SleepUtils.sleep(2);

		// 12. Select $data from the Priority list
		uiDriver.setValue("Create_Servicetickets_Account.lstPriority", input.get("Select@Priority"));
		SleepUtils.sleep(2);

		// 13. Click on Next button
		uiDriver.click("Create_Servicetickets_Account.btnNext");
		SleepUtils.sleep(2);

		// 14. Click on Next_1 button
		uiDriver.click("Create_Servicetickets_Account.btnNext_1");
		SleepUtils.sleep(2);

		// 15. Click on Finish button
		uiDriver.click("Create_Servicetickets_Account.btnFinish");
		SleepUtils.sleep(2);

		// 16. Click on History WebElement
		uiDriver.click("Create_Servicetickets_Account.eltHistory");
		SleepUtils.sleep(3);
	}

	public void Create_Servicetickets_Policy(DataRow input, DataRow output) {
		// 1. Click on Policy WebElement
		uiDriver.click("Create_Servicetickets_Policy.eltPolicy");
		SleepUtils.sleep(3);

		// 2. Type $data in First_Name field
		uiDriver.setValue("Create_Servicetickets_Policy.txtCompany_Name", input.get("Type@Company_Name"));
		SleepUtils.sleep(3);

		// 3. Click on Search button
		uiDriver.click("Create_Servicetickets_Policy.btnSearch");
		SleepUtils.sleep(2);

		// 4. Click on Policy Link
		uiDriver.click("Create_Servicetickets_Policy.lnkPolicy");
		SleepUtils.sleep(2);

		// 5. Click on Service_Tickets WebElement
		uiDriver.click("Create_Servicetickets_Policy.eltService_Tickets");
		SleepUtils.sleep(2);

		// 6. Click on New button
		uiDriver.click("Create_Servicetickets_Policy.btnNew");
		SleepUtils.sleep(3);

		// 7. Click on Type WebElement
		uiDriver.click("Create_Servicetickets_Policy.eltType");
		SleepUtils.sleep(2);
//		Boolean stflag = uiDriver.checkDropDownOptions("li", "Commission");
//		if (stflag = true) {
//			uiDriver.checkDropDownOptions("li", input.get("VerifyList@Type"));
//		} else {
//			uiDriver.click("Create_Servicetickets_Policy.eltType");
//			SleepUtils.sleep(2);
//			uiDriver.checkDropDownOptions("li", "Commission");
//		}

		// 8. Select $data from the Type list
		uiDriver.setValue("Create_Servicetickets_Policy.lstType", input.get("Select@Type"));
		uiDriver.sendKey("Enter");
		uiDriver.sendKey("tab");
		SleepUtils.sleep(4);

		// 9. Type $data in Subject field
		uiDriver.setValue("Create_Servicetickets_Policy.txtSubject", input.get("Type@Subject"));
		SleepUtils.sleep(2);

		// 10. Type $data in Details field
		uiDriver.setValue("Create_Servicetickets_Policy.txtDetails", input.get("Type@Details"));
		SleepUtils.sleep(2);

		// 11. Click on Priority WebElement
		uiDriver.click("Create_Servicetickets_Policy.eltPriority");
		SleepUtils.sleep(2);

		// 12. Select $data from the Priority list
		uiDriver.setValue("Create_Servicetickets_Policy.lstPriority", input.get("Select@Priority"));
		SleepUtils.sleep(2);

		// 13. Click on Next button
		uiDriver.click("Create_Servicetickets_Policy.btnNext");
		SleepUtils.sleep(2);

		// 14. Click on Next_1 button
		uiDriver.click("Create_Servicetickets_Policy.btnNext_1");
		SleepUtils.sleep(2);

		// 15. Click on Finish button
		uiDriver.click("Create_Servicetickets_Policy.btnFinish");
		SleepUtils.sleep(2);

		// 16. Click on History WebElement
		uiDriver.click("Create_Servicetickets_Policy.eltHistory");
		SleepUtils.sleep(2);
	}

	public void Create_Servicetickets_Producer(DataRow input, DataRow output) {
		// 1. Click on Producer WebElement
		uiDriver.click("Create_Servicetickets_Producer.eltProducer");
		SleepUtils.sleep(2);
		uiDriver.setValue("Create_Servicetickets_Producer.txtProducerCode", input.get("Type@ProducerCode"));
		SleepUtils.sleep(2);

		// 2. Click on Search button
		uiDriver.click("Create_Servicetickets_Producer.btnSearch");

		// 3. Click on Name Link
		uiDriver.click("Create_Servicetickets_Producer.lnkName");
		SleepUtils.sleep(2);

		// 4. Click on Service_Tickets WebElement
		uiDriver.click("Create_Servicetickets_Producer.eltService_Tickets");
		SleepUtils.sleep(2);

		// 5. Click on New button
		uiDriver.click("Create_Servicetickets_Producer.btnNew");
		SleepUtils.sleep(2);

		// 6. Click on Type WebElement
		uiDriver.click("Create_Servicetickets_Producer.eltType");
		SleepUtils.sleep(2);
//		Boolean stflag = uiDriver.checkDropDownOptions("li", "Billing Dispute");
//		if (stflag = true) {
//			uiDriver.checkDropDownOptions("li", input.get("VerifyList@Type"));
//		} else {
//			uiDriver.click("Create_Servicetickets_Producer.eltType");
//			SleepUtils.sleep(2);
//			uiDriver.checkDropDownOptions("li", "Billing Dispute");
//		}

		// 7. Select $data from the Type list
		uiDriver.setValue("Create_Servicetickets_Producer.lstType", input.get("Select@Type"));
		uiDriver.sendKey("Enter");
		uiDriver.sendKey("tab");
		SleepUtils.sleep(3);

		// 8. Type $data in Subject field
		uiDriver.setValue("Create_Servicetickets_Producer.txtSubject", input.get("Type@Subject"));
		SleepUtils.sleep(3);

		// 9. Type $data in Details field
		uiDriver.setValue("Create_Servicetickets_Producer.txtDetails", input.get("Type@Details"));
		SleepUtils.sleep(3);

		// 10. Click on Priority WebElement
		uiDriver.click("Create_Servicetickets_Producer.eltPriority");
		SleepUtils.sleep(3);

		// 11. Select $data from the Priority list
		uiDriver.setValue("Create_Servicetickets_Producer.lstPriority", input.get("Select@Priority"));
		SleepUtils.sleep(3);

		// 12. Click on Next button
		uiDriver.click("Create_Servicetickets_Producer.btnNext");
		SleepUtils.sleep(2);

		// 13. Click on Next_1 button
		uiDriver.click("Create_Servicetickets_Producer.btnNext_1");
		SleepUtils.sleep(2);

		// 14. Click on Finish button
		uiDriver.click("Create_Servicetickets_Producer.btnFinish");
		SleepUtils.sleep(2);

		// 15. Click on History WebElement
		uiDriver.click("Create_Servicetickets_Producer.eltHistory");
		SleepUtils.sleep(2);
	}

	public void Close_Servicetickets_Account(DataRow input, DataRow output) {
		// 1. Click on Account WebElement
		uiDriver.click("Close_Servicetickets_Account.eltAccount");

		// 2. Type $data in Account_Name field
		uiDriver.setValue("Close_Servicetickets_Account.txtAccount_Name", input.get("Type@Account_Name"));

		// 3. Click on Search button
		uiDriver.click("Close_Servicetickets_Account.btnSearch");

		// 4. Click on Account Link
		uiDriver.click("Close_Servicetickets_Account.lnkAccount");

		// 5. Click on Service_Tickets WebElement
		uiDriver.click("Close_Servicetickets_Account.eltService_Tickets");
		SleepUtils.sleep(2);

		// 6. Click on Ticket WebElement
		uiDriver.click("Close_Servicetickets_Account.eltTicket");
		SleepUtils.sleep(2);

		// 7. Click on Close button
		uiDriver.click("Close_Servicetickets_Account.btnClose");
		SleepUtils.sleep(2);

		// 8. Click on Ok button
		uiDriver.click("Close_Servicetickets_Account.btnOk");
		SleepUtils.sleep(2);

		// 9. Click on History WebElement
		uiDriver.click("Close_Servicetickets_Account.eltHistory");
		SleepUtils.sleep(2);

	}

	public void Close_Servicetickets_Desktop(DataRow input, DataRow output) {
		// 1. Click on Desktop WebElement
		uiDriver.click("Close_Servicetickets_Desktop.eltDesktop");
		SleepUtils.sleep(2);

		// 2. Click on My_Service_Tickets WebElement
		uiDriver.click("Close_Servicetickets_Desktop.eltMy_Service_Tickets");
		SleepUtils.sleep(2);

		// 3. Click on Ticket WebElement
		uiDriver.click("Close_Servicetickets_Desktop.eltTicket");
		SleepUtils.sleep(2);

		// 4. Click on Close button
		uiDriver.click("Close_Servicetickets_Desktop.btnClose");
		SleepUtils.sleep(2);

		// 5. Click on Ok button
		uiDriver.click("Close_Servicetickets_Desktop.btnOk");
		SleepUtils.sleep(2);
	}

	public void Search_Servicetickets(DataRow input, DataRow output) {
		// 1. Click on Search WebElement
		uiDriver.click("Search_Servicetickets.eltSearch");
		SleepUtils.sleep(2);

		// 2. Click on Service_Tickets WebElement
		uiDriver.click("Search_Servicetickets.eltService_Tickets");
		SleepUtils.sleep(2);

		// 3. Verify whether the Search_Service_Tickets element present
		if (uiDriver.checkElementPresent("Search_Servicetickets.eltSearch_Service_Tickets")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 4. Click on Search button
		uiDriver.click("Search_Servicetickets.btnSearch");
		SleepUtils.sleep(2);

		// 5. Click on Reset button
		uiDriver.click("Search_Servicetickets.btnReset");
		SleepUtils.sleep(2);

		// 6. Type $data in Account field
		uiDriver.setValue("Search_Servicetickets.txtAccount", input.get("Type@Account"));
		SleepUtils.sleep(2);

		// 7. Click on Search_1 button
		uiDriver.click("Search_Servicetickets.btnSearch_1");
		SleepUtils.sleep(2);

		// 8. Click Type
		uiDriver.click("Search_Servicetickets.txtType");
		SleepUtils.sleep(2);

		// 9. Select $data from the Type list
		uiDriver.setValue("Search_Servicetickets.lstType", input.get("Select@Type"));
		SleepUtils.sleep(2);

		// 10. Click on Search_2 button
		uiDriver.click("Search_Servicetickets.btnSearch_2");
		SleepUtils.sleep(2);

		// 11. Click on Ticket Link
		uiDriver.click("Search_Servicetickets.lnkTicket");
		SleepUtils.sleep(2);
		uiDriver.click("Search_Servicetickets.eltType");
		SleepUtils.sleep(2);

		// 12. Click on Return_to_Search_Service_Tickets Link
		uiDriver.click("Search_Servicetickets.lnkReturn_to_Search_Service_Tickets");
		SleepUtils.sleep(2);

		// 13. Click Status
		uiDriver.click("Search_Servicetickets.txtStatus");
		SleepUtils.sleep(2);

		// 14. Select $data from the Status list
		uiDriver.setValue("Search_Servicetickets.lstStatus", input.get("Select@Status"));
		SleepUtils.sleep(3);

		// 15. Click on Search_3 button
		uiDriver.click("Search_Servicetickets.btnSearch_3");
		SleepUtils.sleep(2);

		// 16. Select $data from the Status_1 list
		uiDriver.setValue("Search_Servicetickets.lstStatus_1", input.get("Select@Status_1"));
		uiDriver.sendKey("ENTER");
		uiDriver.sendKey("ENTER");
		SleepUtils.sleep(2);

		// 17. Click on Account WebElement
		uiDriver.click("Search_Servicetickets.eltAccount");
		SleepUtils.sleep(2);

		// 18. Type $data in Account_1 field
		uiDriver.setValue("Search_Servicetickets.txtAccount_1", input.get("Type@Account_1"));
		SleepUtils.sleep(2);

		// 19. Click on Search_4 button
		uiDriver.click("Search_Servicetickets.btnSearch_4");
		SleepUtils.sleep(2);

		// 20. Click on Account Link
		uiDriver.click("Search_Servicetickets.lnkAccount");
		SleepUtils.sleep(2);

		// 21. Click on History WebElement
		uiDriver.click("Search_Servicetickets.eltHistory");
		SleepUtils.sleep(2);
	}

	/**
	 * Overriding toString() method of object class to print Service_Tickets format
	 * string
	 **/
	public String toString() {
		return "Service_TicketsDriver";
	}
}