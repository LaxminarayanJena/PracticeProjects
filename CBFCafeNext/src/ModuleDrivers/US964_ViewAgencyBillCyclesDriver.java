/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 3/29/2018 3:46:00 AM
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
public class US964_ViewAgencyBillCyclesDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public US964_ViewAgencyBillCyclesDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void TC04_ViewAgencyBillCycles_Rol(DataRow input, DataRow output) {
		//1. Click on Producer WebElement
		uiDriver.click("TC04_ViewAgencyBillCycles_Rol.eltProducer");
		SleepUtils.sleep(3);
		
		//2. Type $data in Producer_Code field
		uiDriver.setValue("TC04_ViewAgencyBillCycles_Rol.txtProducer_Name", input.get("Type@Producer_Name"));
		SleepUtils.sleep(3);
		
		//3. Click on Search button
		uiDriver.click("TC04_ViewAgencyBillCycles_Rol.btnSearch");
		SleepUtils.sleep(3);
		
		//4. Verify whether the Name link is present
		if (uiDriver.checkElementPresent("TC04_ViewAgencyBillCycles_Rol.lnkName")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		//5. Click on Name_ Link
		uiDriver.click("TC04_ViewAgencyBillCycles_Rol.lnkName_");
		SleepUtils.sleep(3);
		
		//6. Click on Agency_Bill_Cycles WebElement
		uiDriver.click("TC04_ViewAgencyBillCycles_Rol.eltAgency_Bill_Cycles");
		SleepUtils.sleep(3);
		
		//7. Click Show
		uiDriver.click("TC04_ViewAgencyBillCycles_Rol.txtShow");
		SleepUtils.sleep(3);
		
		//8. Select $data from the Show list
		uiDriver.setValue("TC04_ViewAgencyBillCycles_Rol.lstShow", input.get("Select@Show"));
		uiDriver.sendKey("ENTER");
		SleepUtils.sleep(3);
		
		//9. Click on Statment Link
		uiDriver.click("TC04_ViewAgencyBillCycles_Rol.lnkStatment");
		SleepUtils.sleep(3);
		
	}
	
	public void TC08_View_Agency_Bill_Cycles(DataRow input, DataRow output) {
		//1. Click on Producer WebElement
		uiDriver.click("TC08_View_Agency_Bill_Cycles.eltProducer");
		SleepUtils.sleep(3);
		
		//2. Type $data in Producer_Code field
		uiDriver.setValue("TC08_View_Agency_Bill_Cycles.txtProducer_Name", input.get("Type@Producer_Name"));
		SleepUtils.sleep(3);
		
		//3. Click on Search button
		uiDriver.click("TC08_View_Agency_Bill_Cycles.btnSearch");
		SleepUtils.sleep(3);
		
		//4. Verify whether the Name link is present
		if (uiDriver.checkElementPresent("TC08_View_Agency_Bill_Cycles.lnkName")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		//5. Click on Name_ Link
		uiDriver.click("TC08_View_Agency_Bill_Cycles.lnkName_");
		SleepUtils.sleep(3);
		
		//6. Click on Agency_Bill_Cycles WebElement
		uiDriver.click("TC08_View_Agency_Bill_Cycles.eltAgency_Bill_Cycles");
		SleepUtils.sleep(3);
		
		//7. Click Show
		uiDriver.click("TC08_View_Agency_Bill_Cycles.txtShow");
		SleepUtils.sleep(3);
		
		//8. Select $data from the Show list
		uiDriver.setValue("TC08_View_Agency_Bill_Cycles.lstShow", input.get("Select@Show"));
		SleepUtils.sleep(6);
		
		//9. Click on Statement Link
		uiDriver.doubleclick("TC08_View_Agency_Bill_Cycles.lnkStatment");
		SleepUtils.sleep(3);
		
		//10. Click Show_1
		uiDriver.click("TC08_View_Agency_Bill_Cycles.txtShow_1");
		SleepUtils.sleep(3);
		
		//11. Select $data from the Show_1 list
		uiDriver.setValue("TC08_View_Agency_Bill_Cycles.lstShow_1", input.get("Select@Show_1"));
		SleepUtils.sleep(3);
		
		//12. Click Show_2
		uiDriver.click("TC08_View_Agency_Bill_Cycles.txtShow_2");
		SleepUtils.sleep(3);
		
		//13. Select $data from the Show_2 list
		uiDriver.setValue("TC08_View_Agency_Bill_Cycles.lstShow_2", input.get("Select@Show_2"));
		SleepUtils.sleep(3);
		
		//14. Click Show_3
		uiDriver.click("TC08_View_Agency_Bill_Cycles.txtShow_3");
		SleepUtils.sleep(3);
		
		//15. Select $data from the Show_3 list
		uiDriver.setValue("TC08_View_Agency_Bill_Cycles.lstShow_3", input.get("Select@Show_3"));
		uiDriver.sendKey("Enter");
		SleepUtils.sleep(3);
		
		//16. Verify whether the Account_Number element present
		if (uiDriver.checkElementPresent("TC08_View_Agency_Bill_Cycles.eltAccount_Number")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		//17. Verify whether the Policy_ element present
		if (uiDriver.checkElementPresent("TC08_View_Agency_Bill_Cycles.eltPolicy_")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		//18. Verify whether the Insured_Name element present
		if (uiDriver.checkElementPresent("TC08_View_Agency_Bill_Cycles.eltInsured_Name")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		//19. Verify whether the Statement_ element present
		if (uiDriver.checkElementPresent("TC08_View_Agency_Bill_Cycles.eltStatement_")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		//20. Verify whether the Item_Status element present
		if (uiDriver.checkElementPresent("TC08_View_Agency_Bill_Cycles.eltItem_Status")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		//21. Verify whether the Cycle_Close_Date element present
		if (uiDriver.checkElementPresent("TC08_View_Agency_Bill_Cycles.eltCycle_Close_Date")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		//22. Verify whether the Item element present
		if (uiDriver.checkElementPresent("TC08_View_Agency_Bill_Cycles.eltItem")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		//23. Verify whether the Item_Description element present
		if (uiDriver.checkElementPresent("TC08_View_Agency_Bill_Cycles.eltItem_Description")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		//24. Verify whether the Gross element present
		if (uiDriver.checkElementPresent("TC08_View_Agency_Bill_Cycles.eltGross")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		//25. Verify whether the Commission element present
		if (uiDriver.checkElementPresent("TC08_View_Agency_Bill_Cycles.eltCommission")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
	}
	

	/**
	*Overriding toString() method of object class to print US964_ViewAgencyBillCycles
	*format string
	**/
	public String toString(){
		return "US964_ViewAgencyBillCyclesDriver";
	}
}
