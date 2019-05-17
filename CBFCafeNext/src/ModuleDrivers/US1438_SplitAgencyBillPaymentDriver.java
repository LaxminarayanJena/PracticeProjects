/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 4/4/2018 3:16:11 AM
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
public class US1438_SplitAgencyBillPaymentDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public US1438_SplitAgencyBillPaymentDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void TC01_SplitAgencyBillPayment_(DataRow input, DataRow output) {
		//1. Click on Producer WebElement
		uiDriver.click("TC01_SplitAgencyBillPayment_.eltProducer");
		SleepUtils.sleep(3);
		
		//2. Type $data in Producer_Code field
		uiDriver.setValue("TC01_SplitAgencyBillPayment_.txtProducer_Name", input.get("Type@Producer_Name"));
		SleepUtils.sleep(3);
		
		//3. Click on Search button
		uiDriver.click("TC01_SplitAgencyBillPayment_.btnSearch");
		SleepUtils.sleep(3);
		
		//4. Verify whether the Name element present
		if (uiDriver.checkElementPresent("TC01_SplitAgencyBillPayment_.eltName")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		//5. Click on Name_ WebElement
		uiDriver.click("TC01_SplitAgencyBillPayment_.eltName_");
		SleepUtils.sleep(3);
		
		//6. Click on Agency_Bill_Payments WebElement
		uiDriver.click("TC01_SplitAgencyBillPayment_.eltAgency_Bill_Payments");
		SleepUtils.sleep(5);
		
		//7. Click Payment_Received
		uiDriver.click("TC01_SplitAgencyBillPayment_.txtPayment_Received");
		SleepUtils.sleep(3);
		
		//8. Select $data from the Payment_Received list
		uiDriver.setValue("TC01_SplitAgencyBillPayment_.lstPayment_Received", input.get("Select@Payment_Received"));
		SleepUtils.sleep(3);
		
		//9. Click on the CheckBox
		uiDriver.th.findRelativeCellAndClickfirstCell("TC01_SplitAgencyBillPayment_.tblExecuted_Payments","$50,000.00", 3 ,"$50,000.00");
		SleepUtils.sleep(3);
			
		//10. Click on Split button
		uiDriver.click("TC01_SplitAgencyBillPayment_.btnSplit");
        SleepUtils.sleep(5);
		if (uiDriver.checkElementPresent("TC01_SplitAgencyBillPayment_.elterrormsg")) {
			uiDriver.th.findRelativeCellAndClickfirstCell("TC01_SplitAgencyBillPayment_.tblExecuted_Payments","$50,000.00", 3 ,"$50,000.00");
			SleepUtils.sleep(5);
			uiDriver.click("TC01_SplitAgencyBillPayment_.btnSplit");
		}
		SleepUtils.sleep(3);
		
		//11. Click Producer
		uiDriver.click("TC01_SplitAgencyBillPayment_.txtProducer");
		SleepUtils.sleep(3);
		
		//12. Click Producer
		uiDriver.click("TC01_SplitAgencyBillPayment_.txtProducer_edit");
		SleepUtils.sleep(3);
		
		//13. Click SelectProducer
		uiDriver.click("TC01_SplitAgencyBillPayment_.txtSelectProducer");
		SleepUtils.sleep(3);
		
		//14. Click on Reset button
		uiDriver.click("TC01_SplitAgencyBillPayment_.btnReset");
		SleepUtils.sleep(3);
		
		//15. Type $data in Producer_Code field
		uiDriver.setValue("TC01_SplitAgencyBillPayment_.txtProducer_Name_1", input.get("Type@Producer_Name_1"));
		SleepUtils.sleep(3);
		
		//16. Click on Search button
		uiDriver.click("TC01_SplitAgencyBillPayment_.btnSearch_1");
		SleepUtils.sleep(3);
		
		//15. Verify whether the Select button is present
		if (uiDriver.checkElementPresent("TC01_SplitAgencyBillPayment_.btnSelect")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		//17. Click on Select_ button
		uiDriver.click("TC01_SplitAgencyBillPayment_.btnSelect_");
		SleepUtils.sleep(3);
		
		//18. Type $data in Amount field
		uiDriver.click("TC01_SplitAgencyBillPayment_.txtAmount");
		SleepUtils.sleep(3);
		
		//19. Type $data in Amount field
		uiDriver.setValue("TC01_SplitAgencyBillPayment_.txtAmount_edit", input.get("Type@Amount"));
		SleepUtils.sleep(3);
		
		//20. Click on Execute button
		uiDriver.click("TC01_SplitAgencyBillPayment_.btnExecute");
		SleepUtils.sleep(6);
		
		//21. Click on History WebElement
		uiDriver.click("TC01_SplitAgencyBillPayment_.eltHistory");
		SleepUtils.sleep(3);
		
		//22. Click Filter_by_Date
		uiDriver.click("TC01_SplitAgencyBillPayment_.txtFilter_by_Date");
		SleepUtils.sleep(3);
		
		//23. Select $data from the Filter_by_Date list
		uiDriver.setValue("TC01_SplitAgencyBillPayment_.lstFilter_by_Date", input.get("Select@Filter_by_Date"));
		SleepUtils.sleep(3);
		
		//24. Click Filter_by_Type
		uiDriver.click("TC01_SplitAgencyBillPayment_.txtFilter_by_Type");
		SleepUtils.sleep(3);
		
		//25. Select $data from the Filter_by_Type list
		uiDriver.setValue("TC01_SplitAgencyBillPayment_.lstFilter_by_Type", input.get("Select@Filter_by_Type"));
		SleepUtils.sleep(3);
	}
	
	public void TC03_SplitAgencyBillPayment(DataRow input, DataRow output) {
		//1. Click on Producer WebElement
		uiDriver.click("TC03_SplitAgencyBillPayment.eltProducer");
		SleepUtils.sleep(3);
		
		//2. Type $data in Producer_Code field
		uiDriver.setValue("TC01_SplitAgencyBillPayment_.txtProducer_Name", input.get("Type@Producer_Name"));
		SleepUtils.sleep(3);
		
		//3. Click on Search button
		uiDriver.click("TC03_SplitAgencyBillPayment.btnSearch");
		SleepUtils.sleep(3);
		
		//4. Verify whether the Name element present
		if (uiDriver.checkElementPresent("TC03_SplitAgencyBillPayment.eltName")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		//5. Click on Name_ WebElement
		uiDriver.click("TC03_SplitAgencyBillPayment.eltName_");
		SleepUtils.sleep(3);
		
		//6. Click on Agency_Bill_Payments WebElement
		uiDriver.click("TC03_SplitAgencyBillPayment.eltAgency_Bill_Payments");
		SleepUtils.sleep(3);
		
		//7. Click Payment_Received
		uiDriver.click("TC03_SplitAgencyBillPayment.txtPayment_Received");
		SleepUtils.sleep(4);
		
		//8. Select $data from the Payment_Received list
		uiDriver.setValue("TC03_SplitAgencyBillPayment.lstPayment_Received", input.get("Select@Payment_Received"));
		SleepUtils.sleep(3);
		
	}
	

	/**
	*Overriding toString() method of object class to print US1438_SplitAgencyBillPayment
	*format string
	**/
	public String toString(){
		return "US1438_SplitAgencyBillPaymentDriver";
	}
}
