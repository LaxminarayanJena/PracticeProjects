/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 3/22/2018 6:45:12 AM
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
public class US1437_ReverseAgencyBillPaymentDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public US1437_ReverseAgencyBillPaymentDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void TC01_ReverseAgencyBillPayment(DataRow input, DataRow output) {
		//1. Click on Producer WebElement
		uiDriver.click("TC01_ReverseAgencyBillPayment.eltProducer");
		SleepUtils.sleep(3);
		
		//2. Type $data in Producer_Code field
		uiDriver.setValue("TC01_ReverseAgencyBillPayment.txtProducer_Name", input.get("Type@Producer_Name"));
		SleepUtils.sleep(3);
		
		//3. Click on Search button
		uiDriver.click("TC01_ReverseAgencyBillPayment.btnSearch");
		SleepUtils.sleep(3);
		
		//4. Verify whether the Name link is present
		if (uiDriver.checkElementPresent("TC01_ReverseAgencyBillPayment.lnkName")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		//5. Click on Name Link
		uiDriver.click("TC01_ReverseAgencyBillPayment.lnkName_");
		SleepUtils.sleep(3);
		
		//6. Click on Agency_Bill_Cycles WebElement
		uiDriver.click("TC01_ReverseAgencyBillPayment.eltAgency_Bill_Cycles");
		SleepUtils.sleep(3);
		
		//7. Click Show
		uiDriver.click("TC01_ReverseAgencyBillPayment.txtShow");
		SleepUtils.sleep(3);
		
		//8. Select $data from the Show list
		uiDriver.setValue("TC01_ReverseAgencyBillPayment.lstShow", input.get("Select@Show"));
		uiDriver.sendKey("tab");
		SleepUtils.sleep(3);
		
		//9. Click on Agency_Bill_Payments WebElement
		uiDriver.click("TC01_ReverseAgencyBillPayment.eltAgency_Bill_Payments");
		SleepUtils.sleep(3);
		
		//11. Click on Payment_Received WebElement
		uiDriver.click("TC01_ReverseAgencyBillPayment.eltPayment_Received");
		SleepUtils.sleep(3);
		
		//12. Select $data from the Payment_Received list
		uiDriver.setValue("TC01_ReverseAgencyBillPayment.lstPayment_Received", input.get("Select@Payment_Received"));
		uiDriver.sendKey("Enter");
		SleepUtils.sleep(8);
		
		//13. Click on the CheckBox
		uiDriver.th.findRelativeCellAndClickfirstCell("TC01_ReverseAgencyBillPayment.tblExecuted_Payments","No", 8 ,"No");
		SleepUtils.sleep(3);
		
		//14. Click on Reverse button
		uiDriver.click("TC01_ReverseAgencyBillPayment.btnReverse");
		SleepUtils.sleep(3);
		
		//15. Click Reversal_Reason
		uiDriver.click("TC01_ReverseAgencyBillPayment.txtReversal_Reason");
		SleepUtils.sleep(3);
		
		//16. Select $data from the Reversal_Reason list
		uiDriver.setValue("TC01_ReverseAgencyBillPayment.lstReversal_Reason", input.get("Select@Reversal_Reason"));
		SleepUtils.sleep(3);
		
		//17. Click on Ok button
		uiDriver.click("TC01_ReverseAgencyBillPayment.btnOk");
		SleepUtils.sleep(10);
		
		//18. Click on History WebElement
		uiDriver.click("TC01_ReverseAgencyBillPayment.eltHistory");
		SleepUtils.sleep(3);
		
		//19. Click Filter_by_Date
		uiDriver.click("TC01_ReverseAgencyBillPayment.txtFilter_by_Date");
		SleepUtils.sleep(3);
		
		//20. Select $data from the Filter_by_Date list
		uiDriver.setValue("TC01_ReverseAgencyBillPayment.lstFilter_by_Date", input.get("Select@Filter_by_Date"));
		SleepUtils.sleep(3);
		
		//21. Click Filter_by_Type
		uiDriver.click("TC01_ReverseAgencyBillPayment.txtFilter_by_Type");
		SleepUtils.sleep(3);
		
		//22. Select $data from the Filter_by_Type list
		uiDriver.setValue("TC01_ReverseAgencyBillPayment.lstFilter_by_Type", input.get("Select@Filter_by_Type"));
		SleepUtils.sleep(3);
	}
	
	public void TC03_ReverseAgencyBillPayment(DataRow input, DataRow output) {
		//1. Click on Producer WebElement
		uiDriver.click("TC03_ReverseAgencyBillPayment.eltProducer");
		SleepUtils.sleep(3);
		
		//2. Type $data in Producer_Code field
		uiDriver.setValue("TC03_ReverseAgencyBillPayment.txtProducer_Name", input.get("Type@Producer_Name"));
		SleepUtils.sleep(3);
		
		//3. Click on Search button
		uiDriver.click("TC03_ReverseAgencyBillPayment.btnSearch");
		SleepUtils.sleep(3);
		
		//4. Verify whether the Name link is present
		if (uiDriver.checkElementPresent("TC03_ReverseAgencyBillPayment.lnkName")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		//5. Click on Name Link
		uiDriver.click("TC03_ReverseAgencyBillPayment.lnkName_");
		SleepUtils.sleep(3);
		
		//6. Click on Agency_Bill_Payments WebElement
		uiDriver.click("TC03_ReverseAgencyBillPayment.eltAgency_Bill_Payments");
		SleepUtils.sleep(3);
		
		//7. Click on Payment_Received WebElement
		uiDriver.click("TC03_ReverseAgencyBillPayment.eltPayment_Received");
		SleepUtils.sleep(3);
		
		//8. Select $data from the Payment_Received list
		uiDriver.setValue("TC03_ReverseAgencyBillPayment.lstPayment_Received", input.get("Select@Payment_Received"));
		uiDriver.sendKey("Enter");
		SleepUtils.sleep(5);
		
		//9. Click on the CheckBox
		uiDriver.th.findRelativeCellAndClickfirstCell("TC03_ReverseAgencyBillPayment.tblExecuted_Payments","No", 8 ,"No");
		SleepUtils.sleep(3);
		
	}
	
	public void TC05_ReverseAgencyBillPayment(DataRow input, DataRow output) {
		//1. Click on Producer WebElement
		uiDriver.click("TC05_ReverseAgencyBillPayment.eltProducer");
		SleepUtils.sleep(3);
		
		//2. Type $data in Producer_Code field
		uiDriver.setValue("TC05_ReverseAgencyBillPayment.txtProducer_Name", input.get("Type@Producer_Name"));
		SleepUtils.sleep(3);
		
		//3. Click on Search button
		uiDriver.click("TC05_ReverseAgencyBillPayment.btnSearch");
		SleepUtils.sleep(3);
		
		//4. Verify whether the Name link is present
		if (uiDriver.checkElementPresent("TC05_ReverseAgencyBillPayment.lnkName")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		//5. Click on Name Link
		uiDriver.click("TC05_ReverseAgencyBillPayment.lnkName_");
		SleepUtils.sleep(3);
		
		//6. Click on Agency_Bill_Payments WebElement
		uiDriver.click("TC05_ReverseAgencyBillPayment.eltAgency_Bill_Payments");
		SleepUtils.sleep(3);
		
		//7. Click on Payment_Received WebElement
		uiDriver.click("TC05_ReverseAgencyBillPayment.eltPayment_Received");
		SleepUtils.sleep(3);
		
		//8. Select $data from the Payment_Received list
		uiDriver.setValue("TC05_ReverseAgencyBillPayment.lstPayment_Received", input.get("Select@Payment_Received"));
		uiDriver.sendKey("Enter");
		SleepUtils.sleep(5);
		
		//9. Click on the CheckBox
		uiDriver.th.findRelativeCellAndClickfirstCell("TC05_ReverseAgencyBillPayment.tblExecuted_Payments","No", 8 ,"No");
		SleepUtils.sleep(3);
		
		//10. Click on Reverse button
		uiDriver.click("TC05_ReverseAgencyBillPayment.btnReverse");
		SleepUtils.sleep(3);
		
		//11. Click Reversal_Reason
		uiDriver.click("TC05_ReverseAgencyBillPayment.txtReversal_Reason");
		SleepUtils.sleep(8);
		
		//12. Click on Cancel button
		uiDriver.click("TC05_ReverseAgencyBillPayment.btnCancel");
		SleepUtils.sleep(8);
	}
		

	/**
	*Overriding toString() method of object class to print US1437_ReverseAgencyBillPayment
	*format string
	**/
	public String toString(){
		return "US1437_ReverseAgencyBillPaymentDriver";
	}
}
