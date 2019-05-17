/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 3/26/2018 4:44:28 AM
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
public class Make_Agency_Bill_PaymentDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public Make_Agency_Bill_PaymentDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void TC01_AgencyBill_NewFunds(DataRow input, DataRow output) {
		SleepUtils.sleep(8);
		//1. Click on Actions WebElement
		uiDriver.click("TC01_Create_Credit_Item_Disbur.eltActions");
		SleepUtils.sleep(4);
		
	}
	
	public void TC02_AgencyBill_ExistingFunds(DataRow input, DataRow output) {
		SleepUtils.sleep(8);
		//1. Click on Actions WebElement
		uiDriver.click("TC_02_AGency_Bill_Exe_Promises.eltActions");
		SleepUtils.sleep(4);
		
		//2. Click on New_Agency_Bill_Promise WebElement
		uiDriver.click("TC02_AgencyBill_ExistingFunds.eltNewAgencyCreditDistribution");
		SleepUtils.sleep(4);
		
		//3. Click on Add_Statements WebElement
		uiDriver.click("TC_02_AGency_Bill_Exe_Promises.eltAdd_Statements");
		SleepUtils.sleep(4);
		
		//4. Click on Search WebElement
		uiDriver.click("TC_02_AGency_Bill_Exe_Promises.eltSearch");
		SleepUtils.sleep(8);
		
		//5. Select the Planned ?checkbox ''Planned
		uiDriver.click("TC_02_AGency_Bill_Exe_Promises.chkPlanned1");
		SleepUtils.sleep(4);

		
		//6. Click on Add_Statements_1 button
		uiDriver.click("TC_02_AGency_Bill_Exe_Promises.btnAdd_Statements_1");
		SleepUtils.sleep(4);
		
		//7. Click on Next button
		uiDriver.click("TC_02_AGency_Bill_Exe_Promises.btnNext");
		
		//8. Click on Suspense items Web Button
		uiDriver.click("TC_02_AGency_Bill_Exe_Promises.btnSusenseItems");
		SleepUtils.sleep(4);		

		//9. Click on Policy element
		uiDriver.click("TC_02_AGency_Bill_Exe_Promises.tblSuspenseItems_Policy");
		SleepUtils.sleep(4);
		uiDriver.setValue("TC_02_AGency_Bill_Exe_Promises.tblSuspenseItems_Policy_1", input.get("Type@PolicyNumber"));
		SleepUtils.sleep(4);

		//10. set value Grass element
		uiDriver.sendKey("tab");
		uiDriver.sendKey("tab");
		uiDriver.sendKey("tab");
		uiDriver.setValue("TC_02_AGency_Bill_Exe_Promises.tblGrossAmnt", input.get("Type@Gross"));
		SleepUtils.sleep(4);

		//11. Set value Commission element
		uiDriver.sendKey("tab");
		uiDriver.setValue("TC_02_AGency_Bill_Exe_Promises.tblCommissionAmnt", input.get("Type@Commission"));
		SleepUtils.sleep(4);

		//12. Click on OK Button
		uiDriver.click("TC_02_AGency_Bill_Exe_Promises.btnOK");

		//13. Click on Next_1 button
		uiDriver.click("TC_02_AGency_Bill_Exe_Promises.btnNext_1");
		SleepUtils.sleep(8);
		
		//14. Click on Finish button
		uiDriver.click("TC_02_AGency_Bill_Exe_Promises.btnFinish");
		SleepUtils.sleep(8);
		
		//15. Click on Agency_Bill_Promises WebElement
		if (uiDriver.checkElementPresent("TC01_Validate_Newly_Added_Feat.eltAgency_Bill_Payments")) {
			uiDriver.click("TC01_Validate_Newly_Added_Feat.eltAgency_Bill_Payments");
		}else {
			SleepUtils.sleep(10);
			if (uiDriver.checkElementPresent("TC01_Validate_Newly_Added_Feat.eltAgency_Bill_Payments")) {
				  uiDriver.click("TC01_Validate_Newly_Added_Feat.eltAgency_Bill_Payments");
			}	
		}
		SleepUtils.sleep(4);
		uiDriver.click("TC01_Validate_Newly_Added_Feat.eltCredit_Distributions");
		SleepUtils.sleep(15);
		
		//16. Verify the text ?$data in the Amount field
		uiDriver.th.getCellDataOfCol("TC01_Validate_Newly_Added_Feat.chkReversed_No", "$0.20", 4);
		SleepUtils.sleep(4);
		
		//17. Click on Agency_Bill_Promises WebElement
		uiDriver.click("TC01_Create_Credit_Item_Disbur.eltHistory");
		
		//18. Select $data from the Filter_by_Type list
		uiDriver.click("TC01_Create_Credit_Item_Disbur.lstFilter_by_Type");
		SleepUtils.sleep(3);
		uiDriver.setValue("TC01_Create_Credit_Item_Disbur.lstFilter_by_Type", input.get("Select@Filter_by_Type"));
		uiDriver.sendKey("enter");
		SleepUtils.sleep(8);
		
		//19. Verify History Description
		String CellValue=uiDriver.th.getCellData("Verfiy_Producer_History.eltDescription", 0, 1);
		SleepUtils.sleep(4);
		if(CellValue.contains("Credit Distribution was created for")) {
			passed("Data Presented", "Data Presented should pass", "Data Presented passed");
		} else {
			failed("Data Presented", "Data Presented should pass", "Data not Presented failed");
		}
		
	}
	

	/**
	*Overriding toString() method of object class to print Update_Agency_Bill_Executed_Promises
	*format string
	**/
	public String toString(){
		return "Make_Agency_Bill_PaymentDriver";
	}
}
