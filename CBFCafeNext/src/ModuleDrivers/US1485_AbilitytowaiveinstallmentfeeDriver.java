/******************************************************************************
Created by : Capgemini Automation Team 
Created\Updated on : 4/12/2018 1:36:31 AM
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
public class US1485_AbilitytowaiveinstallmentfeeDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public US1485_AbilitytowaiveinstallmentfeeDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void TC03_Abilitytowaiveinstallment(DataRow input, DataRow output) {
		//1. Click on Invoices WebElement
		uiDriver.click("TC03_Abilitytowaiveinstallment.eltInvoices");
		SleepUtils.sleep(6);
		
		//2. Click on Invoice_Date WebButton
		uiDriver.click("TC03_Abilitytowaiveinstallment.btnInvoice_Date");
		SleepUtils.sleep(4);
		
		//3.Sort the Invoice_Date Web Button
		uiDriver.click("TC03_Abilitytowaiveinstallment.btnInvoice_DateSort");
		SleepUtils.sleep(3);	
		uiDriver.sendKey("keysdown");
		uiDriver.sendKey("Enter");
		
		//4.Click on Due_Date Web Button
		uiDriver.click("TC03_Abilitytowaiveinstallment.btnDue_Date");
		uiDriver.click("TC03_Abilitytowaiveinstallment.btnDue_Date");
		SleepUtils.sleep(5);
		
		//5.Sort the Due_Date Web Button
		uiDriver.click("TC03_Abilitytowaiveinstallment.btnDue_DateSort");
		uiDriver.sendKey("keysdown");
		uiDriver.sendKey("Enter");
		
		//6.Click on the check Box
		uiDriver.th.findRelativeCellAndClickfirstCell("TC03_Abilitytowaiveinstallment.tblInvoices","Planned", 7 ,"Planned");
		SleepUtils.sleep(6);
		
		//7. Click on Waive_Installment_Fee button
		uiDriver.click("TC03_Abilitytowaiveinstallment.btnWaive_Installment_Fee");
		SleepUtils.sleep(4);
		
		//8.Click on the check Box
		uiDriver.th.findRelativeCellAndClickfirstCell("TC03_Abilitytowaiveinstallment.tblInvoices_1","Planned", 7 ,"Planned");
		SleepUtils.sleep(6);
		
		//9. Click on Charge_Installment_Fee button
		uiDriver.click("TC03_Abilitytowaiveinstallment.btnCharge_Installment_Fee");
		SleepUtils.sleep(4);
	}
	
	public void TC04_Abilitytowaiveinstallment(DataRow input, DataRow output) {
		//1. Click on Invoices WebElement
		uiDriver.click("TC04_Abilitytowaiveinstallment.eltInvoices");
		SleepUtils.sleep(6);
		
		//2.Click on the check Box
		uiDriver.th.findRelativeCellAndClickfirstCell("TC04_Abilitytowaiveinstallment.tblInvoices","Planned", 7 ,"Planned");
		SleepUtils.sleep(6);
		
		//3. Click on Waive_Installment_Fee button
		uiDriver.click("TC04_Abilitytowaiveinstallment.btnPrint_Export");
		SleepUtils.sleep(6);
	
		//4. Select Export as radio button and click on Ok button
		uiDriver.click("TC04_Abilitytowaiveinstallment.rdexportas");
		uiDriver.click("TC04_Abilitytowaiveinstallment.btnOk");
		SleepUtils.sleep(4);

		//6.Select custom radio button and clicks on Ok button
		uiDriver.doubleclick("TC04_Abilitytowaiveinstallment.rdcustom");
		SleepUtils.sleep(4);

		//7. Selecting Check boxes for custom reports
		uiDriver.click("TC04_Abilitytowaiveinstallment.chDate");
		uiDriver.click("TC04_Abilitytowaiveinstallment.chDate");
		SleepUtils.sleep(4);
		uiDriver.click("TC04_Abilitytowaiveinstallment.chDescription");
		uiDriver.click("TC04_Abilitytowaiveinstallment.chDescription");
		SleepUtils.sleep(4);
		uiDriver.click("TC04_Abilitytowaiveinstallment.chRef");
		uiDriver.click("TC04_Abilitytowaiveinstallment.chRef");
		SleepUtils.sleep(4);
		uiDriver.click("TC04_Abilitytowaiveinstallment.chRelatedPeriod");
		uiDriver.click("TC04_Abilitytowaiveinstallment.chRelatedPeriod");
		SleepUtils.sleep(4);
		uiDriver.click("TC04_Abilitytowaiveinstallment.chUser");
		uiDriver.click("TC04_Abilitytowaiveinstallment.chUser");
		SleepUtils.sleep(4);
		uiDriver.click("TC04_Abilitytowaiveinstallment.chEverntType");
		uiDriver.click("TC04_Abilitytowaiveinstallment.chEverntType");
		SleepUtils.sleep(4);
		uiDriver.click("TC04_Abilitytowaiveinstallment.btnOk");
		SleepUtils.sleep(4);
		
		//8.Click on Link Return_To_Invoices
		uiDriver.click("TC04_Abilitytowaiveinstallment.lnkReturntoInvoice");
		
	}
	

	/**
	*Overriding toString() method of object class to print US1485_Abilitytowaiveinstallmentfee
	*format string
	**/
	public String toString(){
		return "US1485_AbilitytowaiveinstallmentfeeDriver";
	}
}
