/******************************************************************************
Created by : CapGemini Automation Team
Created\Updated on : 12/26/2017 5:51:54 AM
Module part of 'Guidewire_BillingCenter'
Module created using Cafenext Selenium Builder
******************************************************************************/
package ModuleDrivers;
import static cbf.engine.TestResultLogger.*;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;

import cbf.engine.TestResult.ResultType;
import cbf.harness.ParameterAccess;
import cbf.utils.DataRow;
import cbf.utils.SleepUtils;
import cbf.utils.SleepUtils.TimeSlab;
import cbfx.selenium.BaseWebModuleDriver;
import sun.util.calendar.BaseCalendar.Date;

/**
Extends BaseModuleDriver class and performs application specific operations
*/
public class PHLY_Specific_Change_Billing_MethodDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public PHLY_Specific_Change_Billing_MethodDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void TC_0234_Validate_Radio_List_Fie(DataRow input, DataRow output) {
			
		//1. Click on Policy WebElement
		SleepUtils.sleep(8);
		uiDriver.click("TC01_Pmnt_Pln_Chan_Error_Mes_2.eltPolicies");
		SleepUtils.sleep(4);
		uiDriver.click("TC01_Pmnt_Pln_Chan_Error_Mes_2.eltPolicies");
		SleepUtils.sleep(4);
		
		//2.Get the cell data of policy column 
		String PolicyNumber=uiDriver.th.getCellData("Validate_Activities_Policy_Lev.lnkPolicies_Link",0,0);
		SleepUtils.sleep(4);
			
		//3. click on policy 
		uiDriver.webDr.findElement(By.xpath("//*[text()='"+PolicyNumber+"']")).click();
		SleepUtils.sleep(4);
		
		//4.Get the Billing method 
		String BillingMethod=uiDriver.getControl("ViewandEditPolicySum.lstBilling_Method").getText();
		SleepUtils.sleep(4);
		if(BillingMethod.equalsIgnoreCase("Direct Bill")) {
			uiDriver.click("TC_0234_Validate_Radio_List_Fie.ImgIcon");
			SleepUtils.sleep(4);
			uiDriver.click("TC_0234_Validate_Radio_List_Fie.eltChangetoAgencyBill");
			SleepUtils.sleep(4);
			uiDriver.click("TC_0234_Validate_Radio_List_Fie.btnOk");
			SleepUtils.sleep(4);
		}

		//5. Click on Policy WebElement
		uiDriver.click("TC_0234_Validate_Radio_List_Fie.ImgIcon");
		SleepUtils.sleep(4);
		
		//6. Click on Change to Direct Bill
		uiDriver.click("TC_0234_Validate_Radio_List_Fie.eltChangetoDirectBill");
		SleepUtils.sleep(4);
		
		//7.Verify the Create Catch-Up Invoice for Past Invoice Items yes is selected
		boolean sflag=uiDriver.getControl("TC_0234_Validate_Radio_List_Fie.rdgCreateCatchUP").isSelected();
		SleepUtils.sleep(4);
		
		//8.verify the drop down value not presented
		uiDriver.click("TC_0234_Validate_Radio_List_Fie.lstReversePayment");
		SleepUtils.sleep(4);
		Boolean sflaglst=uiDriver.getElementNameUsingTag("li", "Only for Non-Planned");
		if(!sflaglst) {
			passed("verifyList", "valuenotPresented should pass", "verifyListnotpresented passed");
		} else {
			failed("verifyList", "valuenotPresented should pass", "verifyListpresented failed");	
		}
		SleepUtils.sleep(4);
		
		//9. Click on OK button
		uiDriver.click("TC_0234_Validate_Radio_List_Fie.btnOk1");
		SleepUtils.sleep(4);
		
		//10. Click on History element
		uiDriver.click("PolicyViewHistory_Validate.eltHistory");
		SleepUtils.sleep(4);
		
		//11.verify the history events 
		uiDriver.click("PolicyViewHistory_Validate.lstFilter_by_Type");
		SleepUtils.sleep(4);
		uiDriver.setValue("PolicyViewHistory_Validate.lstFilter_by_Type", input.get("Select@Filter_by_type"));
		SleepUtils.sleep(4);
		uiDriver.th.verfiygetCellDataOfColumn("PolicyLevelHistory.tbwebelement", input.get("Verify@BillingMethodHistory"), 1);
		SleepUtils.sleep(4);	

	}
	
	public void ITAdmin_Notchan_Billing_Meth(DataRow input, DataRow output) {
		
		//1. Click on Policy WebElement
		SleepUtils.sleep(8);
		uiDriver.click("TC01_Pmnt_Pln_Chan_Error_Mes_2.eltPolicies");
		SleepUtils.sleep(10);
		uiDriver.click("TC01_Pmnt_Pln_Chan_Error_Mes_2.eltPolicies");
		SleepUtils.sleep(4);
		
		//2.Get the cell data of policy column 
		String PolicyNumber=uiDriver.th.getCellData("Validate_Activities_Policy_Lev.lnkPolicies_Link",0,0);
		SleepUtils.sleep(4);
			
		//3. click on policy 
		uiDriver.webDr.findElement(By.xpath("//*[text()='"+PolicyNumber+"']")).click();
		SleepUtils.sleep(4);
		
		//4. Verify whether the Select element is not present
		if (uiDriver.checkElementPresent("TC_0234_Validate_Radio_List_Fie.ImgIcon")) {
			passed("checkElementNotPresent","checkElementNotPresent should pass","checkElementNotPresent passed");
		} else {
			failed("checkElementNotPresent","checkElementNotPresent should pass","checkElementPresent failed");
		}
	
	}
	

	/**
	*Overriding toString() method of object class to print TC02_03_04_ChkStubDet_FundTra
	*format string
	**/
	public String toString(){
		return "PHLY_Specific_Change_Billing_MethodDriver";
	}
}