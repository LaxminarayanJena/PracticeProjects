/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 4/18/2018 5:39:59 AM
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
public class US979_ManageAccountBillDiscrepancyDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public US979_ManageAccountBillDiscrepancyDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void TC02_AccountBillDiscrepancy(DataRow input, DataRow output) {
		//1. Click on Summary WebElement
		uiDriver.click("TC02_AccountBillDiscrepancy.eltSummary");
		SleepUtils.sleep(3);
		
		//2. Click on Edit button
		uiDriver.click("TC02_AccountBillDiscrepancy.btnEdit");
		SleepUtils.sleep(3);
		
		//3. Click Account_Rep
		uiDriver.click("TC02_AccountBillDiscrepancy.txtAccount_Rep");
		SleepUtils.sleep(3);
		
		//4. Click on Reset button
		uiDriver.click("TC02_AccountBillDiscrepancy.btnReset");
		SleepUtils.sleep(3);
		
		//5. Type $data in User_name field
		uiDriver.setValue("TC02_AccountBillDiscrepancy.txtUser_name", System.getProperty("user.name"));
		SleepUtils.sleep(3);
		
		//6. Click on Search button
		uiDriver.click("TC02_AccountBillDiscrepancy.btnSearch");
		SleepUtils.sleep(3);
		
		//7. Verify whether the Select button is present
		if (uiDriver.checkElementPresent("TC02_AccountBillDiscrepancy.btnSelect")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		//8. Click on Select_ button
		uiDriver.click("TC02_AccountBillDiscrepancy.btnSelect_");
		SleepUtils.sleep(3);
		
		//9. Click on Select_ button
		uiDriver.click("TC02_AccountBillDiscrepancy.btnUpdate");
		SleepUtils.sleep(7);
		
		//10. Click on Desktop WebElement
		uiDriver.click("TC02_AccountBillDiscrepancy.eltDesktop");
		SleepUtils.sleep(5);
		
		//11. Click on My_Agency_Items WebElement
		uiDriver.click("TC02_AccountBillDiscrepancy.eltMy_Agency_Items");
		SleepUtils.sleep(5);
		
		//12. Click User_Desktop
		uiDriver.click("TC02_AccountBillDiscrepancy.txtUser_Desktop");
		SleepUtils.sleep(5);
		
		//13. Select $data from the User_Desktop list
		uiDriver.setValue("TC02_AccountBillDiscrepancy.lstUser_Desktop", System.getProperty("user.name"));
		SleepUtils.sleep(3);
		
		//14. Click on Unapplied_Payments WebElement
		uiDriver.click("TC02_AccountBillDiscrepancy.eltUnapplied_Payments");
		SleepUtils.sleep(3);
		
		//14. Click User_Desktop_1
		uiDriver.click("TC02_AccountBillDiscrepancy.txtUser_Desktop_1");
		SleepUtils.sleep(3);
		
		//15. Select $data from the User_Desktop_1 list
		uiDriver.setValue("TC02_AccountBillDiscrepancy.lstUser_Desktop_1", input.get("Select@User_Desktop_1")); 
			
		//16. Click on Unapplied_Payments_1 WebElement
		uiDriver.click("TC02_AccountBillDiscrepancy.eltUnapplied_Payments_1");
		SleepUtils.sleep(5);
	}
	
	public void TC04_AccountBillDiscrepancy(DataRow input, DataRow output) {
		//1. Click on Payment_Instrument button
		uiDriver.click("TC04_AccountBillDiscrepancy.btnPayment_Instrument");
		SleepUtils.sleep(3);
	
		//2. Click on Check_Ref_ button
		uiDriver.click("TC04_AccountBillDiscrepancy.btnCheck_Ref_");
		SleepUtils.sleep(3);
		
		//3. Verify whether the Date_Received button is present
		if (uiDriver.checkElementPresent("TC04_AccountBillDiscrepancy.btnDate_Received")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		//4. Verify whether the Producer_Name button is present
		if (uiDriver.checkElementPresent("TC04_AccountBillDiscrepancy.btnProducer_Name")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		//5. Verify whether the Producer_Code button is present
		if (uiDriver.checkElementPresent("TC04_AccountBillDiscrepancy.btnProducer_Code")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		//6. Verify whether the Amount button is present
		if (uiDriver.checkElementPresent("TC04_AccountBillDiscrepancy.btnAmount")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		//7. Verify whether the Payment_Instrument_1 button is present
		if (uiDriver.checkElementPresent("TC04_AccountBillDiscrepancy.btnPayment_Instrument_1")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		//8. Verify whether the Check_Ref_1 button is present
		if (uiDriver.checkElementPresent("TC04_AccountBillDiscrepancy.btnCheck_Ref_1")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(3);
	}
	
	public void TC09_AccountBillDiscrepancy(DataRow input, DataRow output) {
		//1. Click on Desktop WebElement
		uiDriver.click("TC09_AccountBillDiscrepancy.eltDesktop");
		SleepUtils.sleep(3);
		
		//2. Click on My_Agency_Items WebElement
		uiDriver.click("TC09_AccountBillDiscrepancy.eltMy_Agency_Items");
		SleepUtils.sleep(3);
		
		//3. Click User_Desktop
		uiDriver.click("TC09_AccountBillDiscrepancy.txtUser_Desktop");
		SleepUtils.sleep(3);
		
		//4. Select $data from the User_Desktop list
		uiDriver.setValue("TC09_AccountBillDiscrepancy.lstUser_Desktop", System.getProperty("user.name"));
		SleepUtils.sleep(3);
		
		//5. Click on Suspense_Items button
		uiDriver.click("TC09_AccountBillDiscrepancy.btnSuspense_Items");
		SleepUtils.sleep(3);
		
		//6. Click User_Desktop_1
		uiDriver.click("TC09_AccountBillDiscrepancy.txtUser_Desktop_1");
		SleepUtils.sleep(3);
		
		//7. Select $data from the User_Desktop_1 list
		uiDriver.setValue("TC09_AccountBillDiscrepancy.lstUser_Desktop_1", System.getProperty("user.name"));
		SleepUtils.sleep(3);
		
		//8. Click on Suspense_Items_1 button
		uiDriver.click("TC09_AccountBillDiscrepancy.btnSuspense_Items_1");
		SleepUtils.sleep(3);
	}
	
	public void TC11_AccountBillDiscrepancy(DataRow input, DataRow output) {
		//1. Click on Desktop WebElement
		uiDriver.click("TC11_AccountBillDiscrepancy.eltDesktop");
		SleepUtils.sleep(3);
		
		//2. Click on My_Agency_Items WebElement
		uiDriver.click("TC11_AccountBillDiscrepancy.eltMy_Agency_Items");
		SleepUtils.sleep(3);
		
		//3. Click User_Desktop
		uiDriver.click("TC11_AccountBillDiscrepancy.txtUser_Desktop");
		SleepUtils.sleep(3);
		
		//4. Select $data from the User_Desktop list
		uiDriver.setValue("TC11_AccountBillDiscrepancy.lstUser_Desktop", System.getProperty("user.name"));
		SleepUtils.sleep(3);
		
		//5. Click on Suspense_Items button
		uiDriver.click("TC11_AccountBillDiscrepancy.btnSuspense_Items");
		SleepUtils.sleep(3);
		
		//6. Verify whether the Producer_Code element present
		if (uiDriver.checkElementPresent("TC11_AccountBillDiscrepancy.eltProducer_Code")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		//7. Verify whether the Insured_Name element present
		if (uiDriver.checkElementPresent("TC11_AccountBillDiscrepancy.eltInsured_Name")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		//8. Verify whether the Account_ element present
		if (uiDriver.checkElementPresent("TC11_AccountBillDiscrepancy.eltAccount_")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		//9. Verify whether the Agency_Payment_Date element present
		if (uiDriver.checkElementPresent("TC11_AccountBillDiscrepancy.eltAgency_Payment_Date")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		//10. Verify whether the Comments element present
		if (uiDriver.checkElementPresent("TC11_AccountBillDiscrepancy.eltComments")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(3);
	}
	
	public void TC13_AccountBillDiscrepancy(DataRow input, DataRow output) {
		//1. Click on Desktop WebElement
		uiDriver.click("TC13_AccountBillDiscrepancy.eltDesktop");
		SleepUtils.sleep(3);
		
		//2. Click on My_Agency_Items WebElement
		uiDriver.click("TC13_AccountBillDiscrepancy.eltMy_Agency_Items");
		SleepUtils.sleep(3);
		
		//3. Click on Payment_Exceptions button
		uiDriver.click("TC13_AccountBillDiscrepancy.btnPayment_Exceptions");
		SleepUtils.sleep(3);
		
		//4. Verify whether the Producer_Code element present
		if (uiDriver.checkElementPresent("TC13_AccountBillDiscrepancy.eltProducer_Code")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		//5. Verify whether the Producer_Name element present
		if (uiDriver.checkElementPresent("TC13_AccountBillDiscrepancy.eltProducer_Name")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		//6. Click on Promise_Exceptions button
		uiDriver.click("TC13_AccountBillDiscrepancy.btnPromise_Exceptions");
		SleepUtils.sleep(3);
		
		//7. Verify whether the Producer_Code_1 element present
		if (uiDriver.checkElementPresent("TC13_AccountBillDiscrepancy.eltProducer_Code_1")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		//8. Verify whether the Producer_Name_1 element present
		if (uiDriver.checkElementPresent("TC13_AccountBillDiscrepancy.eltProducer_Name_1")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		//9. Click on Unapplied_Payments button
		uiDriver.click("TC13_AccountBillDiscrepancy.btnUnapplied_Payments");
		SleepUtils.sleep(3);
		
		//10. Verify whether the Producer_Code_2 element present
		if (uiDriver.checkElementPresent("TC13_AccountBillDiscrepancy.eltProducer_Code_2")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		//11. Verify whether the Producer_Name_2 element present
		if (uiDriver.checkElementPresent("TC13_AccountBillDiscrepancy.eltProducer_Name_2")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		//12. Click on Late_Payments button
		uiDriver.click("TC13_AccountBillDiscrepancy.btnLate_Payments");
		SleepUtils.sleep(3);
		
		//13. Verify whether the Producer_Code_3 element present
		if (uiDriver.checkElementPresent("TC13_AccountBillDiscrepancy.eltProducer_Code_3")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		//14. Verify whether the Producer_Name_3 element present
		if (uiDriver.checkElementPresent("TC13_AccountBillDiscrepancy.eltProducer_Name_3")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		//15. Click on Late_Promises button
		uiDriver.click("TC13_AccountBillDiscrepancy.btnLate_Promises");
		SleepUtils.sleep(3);
		
		//16. Verify whether the Producer_Code_4 element present
		if (uiDriver.checkElementPresent("TC13_AccountBillDiscrepancy.eltProducer_Code_4")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		//17. Verify whether the Producer_Name_4 element present
		if (uiDriver.checkElementPresent("TC13_AccountBillDiscrepancy.eltProducer_Name_4")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		//18. Click on Suspense_Items button
		uiDriver.click("TC13_AccountBillDiscrepancy.btnSuspense_Items");
		SleepUtils.sleep(3);
		
		//19. Verify whether the Producer_Code_5 element present
		if (uiDriver.checkElementPresent("TC13_AccountBillDiscrepancy.eltProducer_Code_5")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		//20. Verify whether the Producer_Name_5 element present
		if (uiDriver.checkElementPresent("TC13_AccountBillDiscrepancy.eltProducer_Name_5")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		//21. Click on Suspense_Promise button
		uiDriver.click("TC13_AccountBillDiscrepancy.btnSuspense_Promise");
		SleepUtils.sleep(3);
		
		//22. Verify whether the Producer_Code_6 element present
		if (uiDriver.checkElementPresent("TC13_AccountBillDiscrepancy.eltProducer_Code_6")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		//23. Verify whether the Producer_Name_6 element present
		if (uiDriver.checkElementPresent("TC13_AccountBillDiscrepancy.eltProducer_Name_6")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(3);
	}
	public void TC14_AccountBillDiscrepancy(DataRow input, DataRow output) {
		//1. Click on Desktop WebElement
		uiDriver.click("TC14_AccountBillDiscrepancy.eltDesktop");
		SleepUtils.sleep(3);
		
		//2. Click on My_Agency_Items WebElement
		uiDriver.click("TC14_AccountBillDiscrepancy.eltMy_Agency_Items");
		SleepUtils.sleep(3);
		
		//3. Click on Payment_Exception WebElement
		uiDriver.click("TC14_AccountBillDiscrepancy.eltPayment_Exception");
		SleepUtils.sleep(3);
		
		//4. Verify whether the Date_of_Newest_Exception element present
		if (uiDriver.checkElementPresent("TC14_AccountBillDiscrepancy.eltDate_of_Newest_Exception")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		//5. Click on Promises_Exceptions WebElement
		uiDriver.click("TC14_AccountBillDiscrepancy.eltPromises_Exceptions");
		SleepUtils.sleep(3);
		
		//6. Verify whether the Date_of_Newest_Exception_1 element present
		if (uiDriver.checkElementPresent("TC14_AccountBillDiscrepancy.eltDate_of_Newest_Exception_1")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(3);
	}
	
	public void TC15_AccountBillDiscrepancy(DataRow input, DataRow output) {
		//1. Click on Desktop WebElement
		uiDriver.click("TC15_AccountBillDiscrepancy.eltDesktop");
		SleepUtils.sleep(3);
		
		//2. Click on My_Agency_Items WebElement
		uiDriver.click("TC15_AccountBillDiscrepancy.eltMy_Agency_Items");
		SleepUtils.sleep(3);
		
		//3. Click on Payment_Exceptions button
		uiDriver.click("TC15_AccountBillDiscrepancy.btnPayment_Exceptions");
		SleepUtils.sleep(3);
		
		//4. Verify whether the Print_Export button is present
		if (uiDriver.checkElementPresent("TC15_AccountBillDiscrepancy.btnPrint_Export")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		//5. Click on Promise_Exceptions button
		uiDriver.click("TC15_AccountBillDiscrepancy.btnPromise_Exceptions");
		SleepUtils.sleep(3);
		
		//6. Verify whether the Print_Export_1 button is present
		if (uiDriver.checkElementPresent("TC15_AccountBillDiscrepancy.btnPrint_Export_1")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		//7. Click on Unapplied_Payments button
		uiDriver.click("TC15_AccountBillDiscrepancy.btnUnapplied_Payments");
		SleepUtils.sleep(3);
		
		//8. Verify whether the Print_Export_2 button is present
		if (uiDriver.checkElementPresent("TC15_AccountBillDiscrepancy.btnPrint_Export_2")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		//9. Click on Late_Payments button
		uiDriver.click("TC15_AccountBillDiscrepancy.btnLate_Payments");
		SleepUtils.sleep(3);
		
		//10. Verify whether the Print_Export_3 button is present
		if (uiDriver.checkElementPresent("TC15_AccountBillDiscrepancy.btnPrint_Export_3")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		//11. Click on Late_Promises button
		uiDriver.click("TC15_AccountBillDiscrepancy.btnLate_Promises");
		SleepUtils.sleep(3);
		
		//12. Verify whether the Print_Export_4 button is present
		if (uiDriver.checkElementPresent("TC15_AccountBillDiscrepancy.btnPrint_Export_4")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		//13. Click on Suspense_Items button
		uiDriver.click("TC15_AccountBillDiscrepancy.btnSuspense_Items");
		SleepUtils.sleep(3);
		
		uiDriver.th.findRelativeCellAndClickfirstCell("TC15_AccountBillDiscrepancy.tblSuspenseitems", "Truss, LLC", 2, "Truss, LLC");
		
		//14. Verify whether the Edit_Suspense_Item button is present
		if (uiDriver.checkElementPresent("TC15_AccountBillDiscrepancy.btnEdit_Suspense_Item")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		//15. Click on Suspense_Promise button
		uiDriver.click("TC15_AccountBillDiscrepancy.btnSuspense_Promise");
		SleepUtils.sleep(3);
		
		uiDriver.th.findRelativeCellAndClickfirstCell("TC15_AccountBillDiscrepancy.tblSuspenepromise", "Truss, LLC", 2, "Truss, LLC");
		
		//16. Verify whether the Edit_Suspense_Item_1 button is present
		if (uiDriver.checkElementPresent("TC15_AccountBillDiscrepancy.btnEdit_Suspense_Item_1")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(3);
	}
	
	public void TC16_AccountBillDiscrepancy(DataRow input, DataRow output) {
		//1. Click on Desktop WebElement
		uiDriver.click("TC16_AccountBillDiscrepancy.eltDesktop");
		SleepUtils.sleep(3);
		
		//2. Click on My_Agency_Items WebElement
		uiDriver.click("TC16_AccountBillDiscrepancy.eltMy_Agency_Items");
		SleepUtils.sleep(3);
		
		//3. Click on Late_Payments button
		uiDriver.click("TC16_AccountBillDiscrepancy.btnLate_Payments");
		SleepUtils.sleep(3);
		
		//4. Verify whether the Statement_Status element present
		if (uiDriver.checkElementPresent("TC16_AccountBillDiscrepancy.eltStatement_Status")) {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		//5. Verify whether the Cycle_Close_Date element present
		if (uiDriver.checkElementPresent("TC16_AccountBillDiscrepancy.eltCycle_Close_Date")) {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		//6. Click on Late_Promises button
		uiDriver.click("TC16_AccountBillDiscrepancy.btnLate_Promises");
		SleepUtils.sleep(3);
		
		//7. Verify whether the Statement_Status_1 element present
		if (uiDriver.checkElementPresent("TC16_AccountBillDiscrepancy.eltStatement_Status_1")) {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		//8. Verify whether the Cycle_Close_Date_1 element present
		if (uiDriver.checkElementPresent("TC16_AccountBillDiscrepancy.eltCycle_Close_Date_1")) {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(3);
	}
	

	/**
	*Overriding toString() method of object class to print US979_ManageAccountBillDiscrepancy
	*format string
	**/
	public String toString(){
		return "US979_ManageAccountBillDiscrepancyDriver";
	}
}
