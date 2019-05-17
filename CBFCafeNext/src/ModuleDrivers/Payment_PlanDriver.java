/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 1/29/2018 2:55:49 AM
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
public class Payment_PlanDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;

	public Payment_PlanDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}

	public void Paymentplan_Availability(DataRow input, DataRow output) {
		// 1. Click on Account WebElement
		uiDriver.click("Paymentplan_Availability.eltAccount");

		// 2. Type $data in Account_Name field
		uiDriver.setValue("Paymentplan_Availability.txtAccount_Name", input.get("Type@Account_Name"));

		uiDriver.click("Paymentplan_Availability.btnSearch");

		// 3. Click on Account Link
		uiDriver.click("Paymentplan_Availability.lnkAccount");

		// 4. Click on Actions button
		uiDriver.click("Paymentplan_Availability.btnActions");

		// 5. Click on Add_policy WebElement
		uiDriver.click("Paymentplan_Availability.eltAdd_policy");
		SleepUtils.sleep(3);

		// 6. Click on Add_Button WebElement
		uiDriver.click("Paymentplan_Availability.eltAdd_Button");
		SleepUtils.sleep(3);

		// 7. Click on Add_New_Person WebElement
		uiDriver.click("Paymentplan_Availability.eltAdd_New_Company");
		SleepUtils.sleep(3);

		// 8. Type $data in First_Name field
		uiDriver.setValue("Paymentplan_Availability.txtName", input.get("Type@Name"));
		SleepUtils.sleep(3);

		// 9. Type $data in Address1 field
		uiDriver.setValue("Paymentplan_Availability.txtAddress1", input.get("Type@Address1"));
		SleepUtils.sleep(3);

		// 10. Type $data in City field
		uiDriver.setValue("Paymentplan_Availability.txtCity", input.get("Type@City"));
		SleepUtils.sleep(3);

		// 11. Click on State WebElement
		uiDriver.click("Paymentplan_Availability.txtState");
		SleepUtils.sleep(3);

		// 12. Select $data from the State list
		uiDriver.setValue("Paymentplan_Availability.txtState", input.get("Select@State"));
		uiDriver.sendKey("tab");

		// 13. Type $data in Zip_Code field
		uiDriver.setValue("Paymentplan_Availability.txtZip_Code", input.get("Type@Zip_Code"));

		// 14. Type $data in Phone field
		uiDriver.setValue("Paymentplan_Availability.txtPhone", input.get("Type@Phone"));

		// 15. Type $data in email field
		uiDriver.setValue("Paymentplan_Availability.txtemail", input.get("Type@email"));

		// 16. Click on Add_Button WebElement
		uiDriver.click("Paymentplan_Availability.eltAdd_Button_Person");
		SleepUtils.sleep(3);

		// 17. Type $data in Role field
		uiDriver.doubleclick("Paymentplan_Availability.txtRole");
		SleepUtils.sleep(3);

		// 18. Type $data in Role field
		uiDriver.setValue("Paymentplan_Availability.txtRole_Edit", input.get("Type@Role"));
		SleepUtils.sleep(3);

		// 19. Click on Standardize_Address button
		uiDriver.click("Paymentplan_Availability.btnStandardisedAddress");
		SleepUtils.sleep(2);
		Boolean bStatus = uiDriver.getControl("Paymentplan_Availability.btnOverRide").isEnabled();
		if (bStatus == true) {
			uiDriver.ElementPrestnclick("Paymentplan_Availability.btnOverRide");
		}

		// 20. Click on Ok button
		uiDriver.click("Paymentplan_Availability.eltOK_Button");
		SleepUtils.sleep(2);

		// 21. Type $data in Policy field
		uiDriver.setValue("Paymentplan_Availability.txtPolicy", input.get("Type@Policy"));

		// 22. Click Product
		uiDriver.click("Paymentplan_Availability.txtProduct");

		// 23. Select $data from the Product list
		uiDriver.setValue("Paymentplan_Availability.lstProduct", input.get("Select@Product"));

		// 24. Click Region
		uiDriver.click("Paymentplan_Availability.txtRegion");

		// 25. Select $data from the Region list
		uiDriver.setValue("Paymentplan_Availability.lstRegion", input.get("Select@Region"));

		// 26. Click Program
		uiDriver.click("Paymentplan_Availability.txtProgram");

		// 27. Select $data from the Program list
		uiDriver.setValue("Paymentplan_Availability.lstProgram", input.get("Select@Program"));

		// 28. Click Payment_Plan
		uiDriver.click("Paymentplan_Availability.txtPayment_Plan");
		SleepUtils.sleep(5);

		// 29. Verify the text ?$data in the Payment_Plan list
		uiDriver.setValue("Paymentplan_Availability.lstPayment_Plan", input.get("Select@Payment_Plan"));

		// 30. Verify the text ?$data in the Payment_Plan_1 list
		uiDriver.click("Paymentplan_Availability.txtPayment_Plan_1");
		SleepUtils.sleep(5);
		uiDriver.setValue("Paymentplan_Availability.lstPayment_Plan_1", input.get("Select@Payment_Plan_1"));

		// 31. Click Program_1
		uiDriver.click("Paymentplan_Availability.txtProgram_1");

		// 32. Click Program_2
		uiDriver.click("Paymentplan_Availability.txtProgram_2");

		// 33. Select $data from the Program_2 list
		uiDriver.setValue("Paymentplan_Availability.lstProgram_2", input.get("Select@Program_2"));

		// 34. Select $data from the Program_1 list
		uiDriver.setValue("Paymentplan_Availability.lstProgram_1", input.get("Select@Program_1"));

		// 35. Verify the text ?$data in the Payment_Plan_2 list
		uiDriver.click("Paymentplan_Availability.txtPayment_Plan_2");
		SleepUtils.sleep(5);
		uiDriver.setValue("Paymentplan_Availability.lstPayment_Plan_2", input.get("Select@Payment_Plan_2"));

		// 36. Click Program_3
		uiDriver.click("Paymentplan_Availability.txtProgram_3");

		// 37. Select $data from the Program_3 list
		uiDriver.setValue("Paymentplan_Availability.lstProgram_3", input.get("Select@Program_3"));

		// 38. Verify the text ?$data in the Payment_Plan_3 list
		uiDriver.click("Paymentplan_Availability.txtPayment_Plan_3");
		SleepUtils.sleep(5);
		uiDriver.setValue("Paymentplan_Availability.lstPayment_Plan_3", input.get("Select@Payment_Plan_3"));

		// 39. Click Region_1
		uiDriver.click("Paymentplan_Availability.txtRegion_1");

		// 40. Select $data from the Region_1 list
		uiDriver.setValue("Paymentplan_Availability.lstRegion_1", input.get("Select@Region_1"));

		// 41. Click Program_4
		uiDriver.click("Paymentplan_Availability.txtProgram_4");

		// 42. Select $data from the Program_4 list
		uiDriver.setValue("Paymentplan_Availability.lstProgram_4", input.get("Select@Program_4"));
		uiDriver.sendKey("ENTER");
		SleepUtils.sleep(3);

		// 43. Verify the text ?$data in the Payment_Plan_4 list
		uiDriver.click("Paymentplan_Availability.txtPayment_Plan_4");
		SleepUtils.sleep(5);
		uiDriver.setValue("Paymentplan_Availability.lstPayment_Plan_4", input.get("Select@Payment_Plan_4"));

	}

	/**
	 * Overriding toString() method of object class to print Payment_Plan format
	 * string
	 **/
	public String toString() {
		return "Payment_PlanDriver";
	}
}