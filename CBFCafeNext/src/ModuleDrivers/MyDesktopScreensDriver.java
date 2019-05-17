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
public class MyDesktopScreensDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;

	public MyDesktopScreensDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}

	public void TC01_Approve_Pmnt_Desktop(DataRow input, DataRow output) {
			
		// 1. Click on Desktop WebElement
		uiDriver.click("MakePaymentMulAccPoliProd.eltDesktop");
		SleepUtils.sleep(4);
			
		// 2. Click on Payment Approvals WebElement
		uiDriver.click("MyDesktopScreens.eltPaymentApprovals");
		SleepUtils.sleep(4);
			
		// 3. Select value in list
		uiDriver.click("MyDesktopScreens.lstStatus");
		SleepUtils.sleep(4);
		uiDriver.setValue("MyDesktopScreens.lstStatus", input.get("Select@Status"));
		uiDriver.sendKey("enter");
		SleepUtils.sleep(8);
		
			
		// 4.Fetch the data from payment approval data
		String ProducerNumber=uiDriver.th.getCellData("MyDesktopScreens.tblPaymentApprovls", 0, 1);
		SleepUtils.sleep(2);
			
		// 5.  Select the check box in Table
		uiDriver.th.findRelativeCellAndClickfirstCell("MyDesktopScreens.tblPaymentApprovls", ProducerNumber, 1, ProducerNumber);
		SleepUtils.sleep(2);
		
		// 6. Click on Approve button 
		uiDriver.click("MyDesktopScreens.btnApprove");
		SleepUtils.sleep(6);
		
		//7. Select value in list
		uiDriver.click("MyDesktopScreens.lstStatus");
		SleepUtils.sleep(4);
		uiDriver.setValue("MyDesktopScreens.lstStatus", input.get("Select@Status1"));
		uiDriver.sendKey("enter");
		SleepUtils.sleep(4);
		
		//8. Verify the payment is approved
		boolean sflag=uiDriver.th.verfiyDataPresenceInColumn("MyDesktopScreens.tblPaymentApprovls", ProducerNumber, 1);
		if(sflag) {
			passed("CheckDataPresneted", "CheckDataPresneted should pass", "CheckDataPresneted passed");
		} else {
			failed("CheckDataPresneted", "CheckDataPresneted should pass", "CheckDataNotPresneted failed");
		}
	}
	
	public void TC02_AssignBtn_Avail_Supe(DataRow input, DataRow output) {
		
		//1. Click on Administration WebElement
		uiDriver.click("Admin_UserSearch.eltAdministration");
		
		//2. Click on Group WebElement
		uiDriver.click("Create_New_Activity_Pattern.eltGroup");
		
		// 3.get the element data
		String PageEnd=uiDriver.getControl("MyDesktopScreens.eltGroup").getText();
		String num=PageEnd.substring(2).trim();
		int PageLenth=Integer.parseInt(num);
		int i;
		for(i=0;i<=PageLenth-1;i++) {
			if (uiDriver.checkElementPresent("MyDesktopScreens.lnkCommissionsGroup")) {
				uiDriver.click("MyDesktopScreens.lnkCommissionsGroup");
				SleepUtils.sleep(8);
				break;
			}
			uiDriver.click("MyDesktopScreens.btnArrowforward");
			SleepUtils.sleep(4);
			if (uiDriver.checkElementPresent("MyDesktopScreens.lnkCommissionsGroup")) {
				uiDriver.click("MyDesktopScreens.lnkCommissionsGroup");
				SleepUtils.sleep(8);
				break;
			}
		}
		
		//4. Click on Edit button
		uiDriver.click("LoginUserASupervisorforDefault.btnEdit");
		
		//5. Click on Supervisor_Image_Icon image
		uiDriver.click("LoginUserASupervisorforDefault.imgSupervisor_Image_Icon");
		SleepUtils.sleep(2);
		
		//6. Click on Search_for_User WebElement
		uiDriver.click("LoginUserASupervisorforDefault.eltSearch_for_User");
		
		//7. Type $data in User_Name field
		uiDriver.setValue("LoginUserASupervisorforDefault.txtUser_Name", System.getProperty("user.name"));
		
		//8. Click on Search button
		uiDriver.click("LoginUserASupervisorforDefault.btnSearch");
		SleepUtils.sleep(2);
		
		//9. Verify whether the Select button is present
		if (uiDriver.checkElementPresent("LoginUserASupervisorforDefault.btnSelect")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		
		//10. Click on Select button
		uiDriver.click("LoginUserASupervisorforDefault.btnSelect");
		SleepUtils.sleep(3);
		
		//11. Click on Update button
		uiDriver.click("MyDesktopScreens.btnUpdate");
		SleepUtils.sleep(4);
		
		//12. Click on Desktop WebElement
		uiDriver.click("MakePaymentMulAccPoliProd.eltDesktop");
		SleepUtils.sleep(8);
		
		//13. Click on Queues WebElement
		uiDriver.click("MyDesktopScreens.eltQueues");
		SleepUtils.sleep(4);
		
		// 14. Select value in list
		uiDriver.click("MyDesktopScreens.lstQueuedActivites");
		SleepUtils.sleep(4);
		uiDriver.setValue("MyDesktopScreens.lstQueuedActivites", input.get("Select@QueuedValue"));
		uiDriver.sendKey("enter");
		SleepUtils.sleep(4);
			
		//15.Fetch the data from table
		String OpendDate=uiDriver.th.getCellData("MyDesktopScreens.tblMyQueues", 0, 3);
		SleepUtils.sleep(4);
		
		//16.Select Check box in My queue table
		uiDriver.th.findRelativeCellAndClickfirstCell("MyDesktopScreens.tblMyQueues", OpendDate, 3, OpendDate);
		SleepUtils.sleep(4);
		
		//17. Click on Queues WebElement
		uiDriver.click("MyDesktopScreens.btnAssign");
		SleepUtils.sleep(4);
		
		//18.Verify the Assign Activity is presented
		if (uiDriver.checkElementPresent("MyDesktopScreens.lnkReturntoMyqueue")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}

		
	}
		
	public void TC0304_Batch_Pmnt_Delete_Rev(DataRow input, DataRow output) {
		
		//1. Click on Desktop WebElement
		uiDriver.click("MakePaymentMulAccPoliProd.eltDesktop");
		SleepUtils.sleep(8);
		
		//2. Click on Payment Batch WebElement
		uiDriver.click("MakePaymentMulAccPoliProd.eltPaymentbatch");
		SleepUtils.sleep(4);
		uiDriver.click("US1257TC04_ReverseDirectBillPa.lstStatus");
		SleepUtils.sleep(2);
		uiDriver.setValue("US1257TC04_ReverseDirectBillPa.lstStatus", "Posted");
		uiDriver.sendKey("enter");
		SleepUtils.sleep(2);
		uiDriver.click("US1257TC04_ReverseDirectBillPa.btnSearch_1");
		SleepUtils.sleep(5);
		
		//3.Select check box in posted status
		uiDriver.th.findRelativeCellAndClickfirstCell("MyDesktopScreens.tblPaymentBatch", "Posted", 7, "Posted");
		
		//4. Click on Reverse button
		uiDriver.click("US1257TC04_ReverseDirectBillPa.btnReverse");
		SleepUtils.sleep(4);
		
		//5. Click on OK Button
		uiDriver.click("Close_Servicetickets_Account.btnOk");
		SleepUtils.sleep(4);
			
		//6. Click on Desktop WebElement
		uiDriver.click("BatchPayment_Producer.eltDesktop");
		SleepUtils.sleep(2);
		
		//7. Click on Actions button
		uiDriver.click("BatchPayment_Producer.btnActions");
		SleepUtils.sleep(2);
		
		//8. Click on New_Payment WebElement
		uiDriver.click("BatchPayment_Producer.eltNew_Payment");
		SleepUtils.sleep(2);
		
		//9. Click on Batch_Payment_Entry WebElement
		uiDriver.click("BatchPayment_Producer.eltBatch_Payment_Entry");
		SleepUtils.sleep(2);
		
		//10. Type $data in Batch_Amount field
		uiDriver.setValue("BatchPayment_Producer.txtBatch_Amount", input.get("Type@Batch_Amount"));
		SleepUtils.sleep(2);
		
		//11. Click Payment_Source
		uiDriver.click("BatchPayment_Producer.txtPayment_Source");
		SleepUtils.sleep(5);
		
		//12. Select $data from the Payment_Source list
		uiDriver.setValue("BatchPayment_Producer.lstPayment_Source", input.get("Select@Payment_Source"));
		uiDriver.sendKey("tab");
		SleepUtils.sleep(3);
		
		//13. Click Payment_Instrument
		uiDriver.click("BatchPayment_Producer.txtPayment_Instrument");
		SleepUtils.sleep(5);

		//14. Select $data from the Payment_Instrument list
		uiDriver.setValue("BatchPayment_Producer.lstPayment_Instrument", input.get("Select@Payment_Instrument"));
		uiDriver.sendKey("tab");
		SleepUtils.sleep(5);
		
		//15. Click Deposit_Date
		uiDriver.setValue("BatchPayment_Producer.txtDeposit_Date", input.get("Type@Deposit_Date"));
		//uiDriver.click("BatchPayment_Producer.txtDeposit_Date");
		SleepUtils.sleep(3);
		uiDriver.sendKey("tab");
		uiDriver.sendKey("tab");
		uiDriver.sendKey("tab");
		uiDriver.sendKey("tab");
		uiDriver.sendKey("tab");
		uiDriver.sendKey("tab");
		uiDriver.sendKey("tab");
		uiDriver.sendKey("Enter");
		SleepUtils.sleep(4);
		
		//16. Click Check
		uiDriver.click("BatchPayment_Producer.txtCheck");
		SleepUtils.sleep(2);
		
		//17. Type $data in Check field
		uiDriver.setValue("BatchPayment_Producer.txtCheck", input.get("Type@Check"));
		uiDriver.sendKey("tab");
		SleepUtils.sleep(1);
		
		//18. Click Amount
		uiDriver.click("BatchPayment_Producer.txtAmount");
		SleepUtils.sleep(2);
		
		//19. Type $data in Amount field
		uiDriver.setValue("BatchPayment_Producer.txtAmount_1", input.get("Type@Amount"));
		uiDriver.sendKey("tab");
		uiDriver.sendKey("tab");
		uiDriver.sendKey("tab");
		uiDriver.sendKey("tab");
		SleepUtils.sleep(1);
		
		//20. Click Producer
		uiDriver.click("BatchPayment_Producer.txtProducer");
		SleepUtils.sleep(2);
		
		//21. Click on Producer_Search button
		uiDriver.click("BatchPayment_Producer.btnProducer_Search");
		SleepUtils.sleep(2);
		
		//22. Type $data in Producer_Code field
		uiDriver.setValue("BatchPayment_Producer.txtProducer_Name", input.get("Type@Producer_Name"));
		SleepUtils.sleep(2);
		
		//23. Click on Search button
		uiDriver.click("BatchPayment_Producer.btnSearch");
		SleepUtils.sleep(2);
		
		//24. Verify whether the Select button is present
		if (uiDriver.checkElementPresent("BatchPayment_Producer.btnSelect")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(2);
		
		//25. Click on Select button
		uiDriver.click("BatchPayment_Producer.btnSelect_1");
		SleepUtils.sleep(2);
		
		//26. Click on Next button
		uiDriver.click("BatchPayment_Producer.btnNext");
		SleepUtils.sleep(2);
		
		//27. Click on Post_Batch button
		uiDriver.click("MyDesktopScreens.btnSave");
		SleepUtils.sleep(10);
		uiDriver.click("US1257TC04_ReverseDirectBillPa.lstStatus");
		SleepUtils.sleep(2);
		uiDriver.setValue("US1257TC04_ReverseDirectBillPa.lstStatus", "Complete");
		uiDriver.sendKey("enter");
		SleepUtils.sleep(2);
		uiDriver.click("US1257TC04_ReverseDirectBillPa.btnSearch_1");
		SleepUtils.sleep(5);
			

		//28.Select check box in posted status
		uiDriver.th.findRelativeCellAndClickfirstCell("MyDesktopScreens.tblPaymentBatch", "Complete", 7, "Complete");
		
		//29. Click on Post_Batch button
		uiDriver.click("US1257TC04_ReverseDirectBillPa.btnDelete");
		SleepUtils.sleep(20);
		
		//30. Click on OK Button
		uiDriver.click("Close_Servicetickets_Account.btnOk");
		SleepUtils.sleep(6);
		
		//31. Verify whether the Select element present
		if (!uiDriver.checkElementPresent("MyDesktopScreens.eltFundstransfer")) {
			passed("checkElementNotPresent","checkElementNotPresent should pass","checkElementNotPresent passed");
		} else {
			failed("checkElementNotPresent","checkElementNotPresent should pass","checkElementPresent failed");
		}
			

			
	}

	/**
	 * Overriding toString() method of object class to print MyDesktopScreens
	 * format string
	 **/
	public String toString() {
		return "MyDesktopScreens";
	}
}
