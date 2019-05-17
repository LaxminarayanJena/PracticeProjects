/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 4/3/2018 5:43:41 AM
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
public class US970_UpdateAgencybillExecutedPaymentsDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;

	public US970_UpdateAgencybillExecutedPaymentsDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}

	public void TC01_UpdateAgencyBillExecutedP(DataRow input, DataRow output) {
		//1. Click on Producer WebElement
		uiDriver.click("TC01_UpdateAgencyBillExecutedP.eltProducer");
		SleepUtils.sleep(3);

		//2. Type $data in Producer_Code field
		uiDriver.setValue("TC01_UpdateAgencyBillExecutedP.txtProducer_Name", input.get("Type@Producer_Name"));
		SleepUtils.sleep(3);

		//3. Click on Search button
		uiDriver.click("TC01_UpdateAgencyBillExecutedP.btnSearch");
		SleepUtils.sleep(3);

		//4. Verify whether the Name link is present
		if (uiDriver.checkElementPresent("TC01_UpdateAgencyBillExecutedP.lnkName")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(6);

		//5. Click on Name_ Link
		uiDriver.click("TC01_UpdateAgencyBillExecutedP.lnkName_");
		SleepUtils.sleep(6);

		//6. Click on Agency_Bill_Payments WebElement
		uiDriver.click("TC01_UpdateAgencyBillExecutedP.eltAgency_Bill_Payments");
		SleepUtils.sleep(10);

		//7. Click on Executed_Payments WebElement
		uiDriver.click("TC01_UpdateAgencyBillExecutedP.eltExecuted_Payments");
		SleepUtils.sleep(10);

		//8. Click on Payment_Received WebElement
		uiDriver.click("TC01_UpdateAgencyBillExecutedP.eltPayment_Received");
		SleepUtils.sleep(3);

		//9. Select $data from the Payment_Received list
		uiDriver.setValue("TC01_UpdateAgencyBillExecutedP.lstPayment_Received", input.get("Select@Payment_Received"));
		uiDriver.sendKey("Enter");
		SleepUtils.sleep(10);

		//10. Click on the CheckBox
		uiDriver.th.findRelativeCellAndClickfirstCell("TC01_UpdateAgencyBillExecutedP.tblExecuted_Payments","No", 8 ,"No");
		SleepUtils.sleep(6);

		//11. Click on Edit button
		uiDriver.click("TC01_UpdateAgencyBillExecutedP.btnEdit");
		SleepUtils.sleep(6);

		//12. Type $data in Payment_Description field
		uiDriver.setValue("TC01_UpdateAgencyBillExecutedP.txtPayment_Description", input.get("Type@Payment_Description"));
		SleepUtils.sleep(6);

		//13. Click on AddStatements button
		uiDriver.click("TC03_Editanddiscardagencybillp.btnAddStatements");
		SleepUtils.sleep(6);

		//14. Click on Search_1 button
		uiDriver.click("TC03_Editanddiscardagencybillp.btnSearch_1");
		SleepUtils.sleep(6);

		//15. Click on the CheckBox
		uiDriver.th.findRelativeCellAndClickfirstCell("TC03_Editanddiscardagencybillp.tblAgencyDistribution","Open", 2 ,"Open");
		SleepUtils.sleep(6);

		//16. Click on AddStatements_1 button
		uiDriver.click("TC03_Editanddiscardagencybillp.btnAddStatements_1");
		SleepUtils.sleep(3);

		//17. Click on Next button
		uiDriver.click("TC03_Editanddiscardagencybillp.btnNext");
		SleepUtils.sleep(6);

		//18. Click on Nettoapply WebElement
		uiDriver.click("TC01_UpdateAgencyBillExecutedP.eltNettoapply");
		SleepUtils.sleep(4);

		//19. Type $data in Nettoapply field
		uiDriver.setValue("TC01_UpdateAgencyBillExecutedP.txtNettoapply_edit", input.get("Type@Nettoapply_edit"));
		SleepUtils.sleep(4);
		
		//20. Click on Next button
		uiDriver.click("TC01_UpdateAgencyBillExecutedP.btnNext_1");
		SleepUtils.sleep(3);

		//21. Click on Finish button
		uiDriver.click("TC01_UpdateAgencyBillExecutedP.btnFinish");
		SleepUtils.sleep(18);

		//22. Click on History WebElement
		uiDriver.click("TC01_UpdateAgencyBillExecutedP.eltHistory");
		SleepUtils.sleep(3);

		//23. Click Filter_by_Date
		uiDriver.click("TC01_UpdateAgencyBillExecutedP.txtFilter_by_Date");
		SleepUtils.sleep(3);

		//24. Select $data from the Filter_by_Date list
		uiDriver.setValue("TC01_UpdateAgencyBillExecutedP.lstFilter_by_Date", input.get("Select@Filter_by_Date"));
		SleepUtils.sleep(3);

		//25. Click Filter_by_Type
		uiDriver.click("TC01_UpdateAgencyBillExecutedP.txtFilter_by_Type");
		SleepUtils.sleep(3);

		//26. Select $data from the Filter_by_Type list
		uiDriver.setValue("TC01_UpdateAgencyBillExecutedP.lstFilter_by_Type", input.get("Select@Filter_by_Type"));
		SleepUtils.sleep(3);
	}

	public void TC02_UpdateAgencyBillPayment(DataRow input, DataRow output) {
		//1. Click on Producer WebElement
		SleepUtils.sleep(3);
		uiDriver.click("TC02_UpdateAgencyBillPayment.eltProducer");
		SleepUtils.sleep(3);

		//2. Type $data in Producer_Code field
		uiDriver.setValue("TC02_UpdateAgencyBillPayment.txtProducer_Name", input.get("Type@Producer_Name"));
		SleepUtils.sleep(3);

		//3. Click on Search button
		uiDriver.click("TC02_UpdateAgencyBillPayment.btnSearch");
		SleepUtils.sleep(3);

		//4. Verify whether the Name link is present
		if (uiDriver.checkElementPresent("TC02_UpdateAgencyBillPayment.lnkName")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(6);

		//5. Click on Name_ Link
		uiDriver.click("TC02_UpdateAgencyBillPayment.lnkName_");
		SleepUtils.sleep(6);

		//6. Click on Agency_Bill_Payments WebElement
		uiDriver.click("TC02_UpdateAgencyBillPayment.eltAgency_Bill_Payments");
		SleepUtils.sleep(9);
		
		//7. Verify whether the Name link is present
				if (uiDriver.checkElementPresent("TC02_UpdateAgencyBillPayment.eltExecuted_Payments")) {
					passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
				} else {
					failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
				}

		//8. Click on Executed_Payments WebElement
		uiDriver.click("TC02_UpdateAgencyBillPayment.eltExecuted_Payments_");
		SleepUtils.sleep(6);

		//9. Click on Payment_Received WebElement
		uiDriver.click("TC02_UpdateAgencyBillPayment.eltPayment_Received");
		SleepUtils.sleep(3);

		//10. Select $data from the Payment_Received list
		uiDriver.setValue("TC02_UpdateAgencyBillPayment.lstPayment_Received", input.get("Select@Payment_Received"));
		uiDriver.sendKey("Enter");
		SleepUtils.sleep(8);

		//11. Click on the CheckBox
		uiDriver.th.findRelativeCellAndClickfirstCell("TC02_UpdateAgencyBillPayment.tblExecuted_Payments","No", 8 ,"No");
		SleepUtils.sleep(3);
	}


	/**
	 *Overriding toString() method of object class to print US970_UpdateAgencybillExecutedPayments
	 *format string
	 **/
	public String toString(){
		return "US970_UpdateAgencybillExecutedPaymentsDriver";
	}
}
