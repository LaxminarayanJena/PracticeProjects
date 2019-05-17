/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 3/14/2018 5:26:12 AM
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
public class US980_MoveAgencyBillPaymentDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;

	public US980_MoveAgencyBillPaymentDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}

	public void TC02_MoveAgencyBillPayment_Rls(DataRow input, DataRow output) {
		//1. Click on Producer WebElement
		uiDriver.click("TC02_MoveAgencyBillPayment_Rls.eltProducer");
		SleepUtils.sleep(3);

		//2. Click on Reset button
		uiDriver.click("TC02_MoveAgencyBillPayment_Rls.btnReset");
		SleepUtils.sleep(3);

		//3. Type $data in Producer_Code field
		uiDriver.setValue("TC02_MoveAgencyBillPayment_Rls.txtProducer_Name", input.get("Type@Producer_Name#1"));
		SleepUtils.sleep(3);

		//4. Click on Search button
		uiDriver.click("TC02_MoveAgencyBillPayment_Rls.btnSearch");
		SleepUtils.sleep(3);

		//5. Verify whether the Name link is present
		if (uiDriver.checkElementPresent("TC02_MoveAgencyBillPayment_Rls.lnkName")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(3);

		//6. Click on Name_ Link
		uiDriver.click("TC02_MoveAgencyBillPayment_Rls.lnkName_");
		SleepUtils.sleep(3);

		//7. Click on Agency_Bill_Payments WebElement
		uiDriver.click("TC02_MoveAgencyBillPayment_Rls.eltAgency_Bill_Payments");
		SleepUtils.sleep(5);

		//8. Click on Executed_Payments WebElement
		uiDriver.click("TC02_MoveAgencyBillPayment_Rls.eltExecuted_Payments");
		SleepUtils.sleep(3);
		uiDriver.click("TC02_MoveAgencyBillPayment_Rls.eltPayment_Received");
		SleepUtils.sleep(3);

		//9. Select $data from the Payment_Received list
		uiDriver.setValue("TC02_MoveAgencyBillPayment_Rls.eltPayment_Received", input.get("Select@Payment_Received"));
		uiDriver.sendKey("Enter");
		SleepUtils.sleep(3);

		//10. Select the Executed_Payments
		uiDriver.th.findRelativeCellAndClickfirstCell("TC02_MoveAgencyBillPayment_Rls.tblExecuted_Payments","No", 8 ,"No");
		SleepUtils.sleep(3);

		//11. Verify whether Move_To_Different_Producer button exists
		uiDriver.checkElementPresent("TC02_MoveAgencyBillPayment_Rls.btnMove_To_Different_Producer");
		SleepUtils.sleep(3);

		//12. Click on Move_To_Different_Producer button
		uiDriver.click("TC02_MoveAgencyBillPayment_Rls.btnMove_To_Different_Producer");
		SleepUtils.sleep(3);

		//13. Click on Select_Producer Link
		uiDriver.click("TC02_MoveAgencyBillPayment_Rls.lnkSelect_Producer");
		SleepUtils.sleep(3);

		//14. Click on Reset_1 button
		uiDriver.click("TC02_MoveAgencyBillPayment_Rls.btnReset_1");
		SleepUtils.sleep(3);

		//15. Type $data in Producer_Code field
		uiDriver.setValue("TC02_MoveAgencyBillPayment_Rls.txtProducer_Name_1", input.get("Type@Producer_Name#2"));
		SleepUtils.sleep(5);
		uiDriver.click("TC02_MoveAgencyBillPayment_Rls.btnSearch_1");
		
		//16. Verify whether the Select button is present
		if (uiDriver.checkElementPresent("TC02_MoveAgencyBillPayment_Rls.btnSelect")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(3);

		//17. Click on Select_1 button
		uiDriver.click("TC02_MoveAgencyBillPayment_Rls.btnSelect_1");
		SleepUtils.sleep(3);

		//18. Click on Ok button
		uiDriver.click("TC02_MoveAgencyBillPayment_Rls.btnOk");
		SleepUtils.sleep(3);

		//19. Verify whether the Payment_Moved_To element present
		if (uiDriver.checkElementPresent("TC02_MoveAgencyBillPayment_Rls.eltPayment_Moved_To")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(3);

	}

	public void TC03_AgencyBillPayment_ITAdmin(DataRow input, DataRow output) {
		//1. Click on Producer WebElement
		uiDriver.click("TC03_AgencyBillPayment_ITAdmin.eltProducer");
		SleepUtils.sleep(3);

		//2. Type $data in Producer_Code field
		uiDriver.setValue("TC03_AgencyBillPayment_ITAdmin.txtProducer_Name", input.get("Type@Producer_Name"));
		SleepUtils.sleep(3);

		//3. Click on Search button
		uiDriver.click("TC03_AgencyBillPayment_ITAdmin.btnSearch");
		SleepUtils.sleep(3);

		//4. Verify whether the Name link is present
		if (uiDriver.checkElementPresent("TC03_AgencyBillPayment_ITAdmin.lnkName")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(3);

		//5. Click on Name_ Link
		uiDriver.click("TC03_AgencyBillPayment_ITAdmin.lnkName_");
		SleepUtils.sleep(3);

		//6. Click on Agency_Bill_Payments WebElement
		uiDriver.click("TC03_AgencyBillPayment_ITAdmin.eltAgency_Bill_Payments");
		SleepUtils.sleep(3);

		//7. Click on Executed_Payments WebElement
		uiDriver.click("TC03_AgencyBillPayment_ITAdmin.eltExecuted_Payments");
		SleepUtils.sleep(3);
		uiDriver.click("TC03_AgencyBillPayment_ITAdmin.eltPayment_Received");
		SleepUtils.sleep(3);

		//8. Select $data from the Payment_Received list
		uiDriver.setValue("TC03_AgencyBillPayment_ITAdmin.eltPayment_Received", input.get("Select@Payment_Received"));
		uiDriver.sendKey("Enter");
		SleepUtils.sleep(5);


		//9. Select the Executed_Payments
		uiDriver.th.findRelativeCellAndClickfirstCell("TC03_AgencyBillPayment_ITAdmin.tblExecuted_Payments","No", 8 ,"No");
		SleepUtils.sleep(3);

		//10. Verify whether the Move_To_Different_Producer button is present
		uiDriver.VerifyButtonDisabled("TC03_AgencyBillPayment_ITAdmin.btnMove_To_Different_Producer");
		SleepUtils.sleep(3);
	}



	/**
	 *Overriding toString() method of object class to print US980_MoveAgencyBillPayment
	 *format string
	 **/
	public String toString(){
		return "US980_MoveAgencyBillPaymentDriver";
	}
}
