/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 3/22/2018 6:00:59 AM
Module part of 'Guidewire_BillingCenter'
Module created using Cafenext Selenium Builder
******************************************************************************/
package ModuleDrivers;
import static cbf.engine.TestResultLogger.*;
import java.io.IOException;

import org.openqa.selenium.By;

import cbf.engine.TestResult.ResultType;
import cbf.harness.ParameterAccess;
import cbf.utils.DataRow;
import cbf.utils.SleepUtils;
import cbf.utils.SleepUtils.TimeSlab;
import cbfx.selenium.BaseWebModuleDriver;

/**
Extends BaseModuleDriver class and performs application specific operations
*/
public class Equity_Warning_Parameters_On_Payment_PlanDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public Equity_Warning_Parameters_On_Payment_PlanDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void TC01_Pmnt_Pln_Chan_Error_Mes_1(DataRow input, DataRow output) {
		//1. Click on Business_Settings WebElement
		uiDriver.click("TC01_Pmnt_Pln_Chan_Error_Mes_1.eltBusiness_Settings");
		SleepUtils.sleep(2);
		
		//2. Click on Payment_Plans WebElement
		uiDriver.click("TC01_Pmnt_Pln_Chan_Error_Mes_1.eltPayment_Plans");
		SleepUtils.sleep(2);
		
		//3. Click on 25_Down_9_Monthly_Installments Link
		uiDriver.th.findRelativeCellAndClick("TC01_Pmnt_Pln_Chan_Error_Mes_1.lnk25_Down_9_Monthly_Installments", input.get("VerifyText@Name_"), 1, input.get("VerifyText@Name_"));
		SleepUtils.sleep(2);
		
		//4. Verify the text ?$data in the Name_ field
		if (uiDriver.verifyTextActAndExp("TC01_Pmnt_Pln_Chan_Error_Mes_1.eltName_", input.get("VerifyText@Name_"))) {
			passed("verifyText","verifyText should pass","verifyText passed");
		} else {
			failed("verifyText","verifyText should pass","verifyText failed");
		}
		SleepUtils.sleep(6);
	}
	
	public void TC01_Pmnt_Pln_Chan_Error_Mes_2(DataRow input, DataRow output) {
		//1. Click on Policies WebElement
		SleepUtils.sleep(8);
		uiDriver.click("TC01_Pmnt_Pln_Chan_Error_Mes_2.eltPolicies");
		SleepUtils.sleep(8);
		
		//2. Click on Policies_ WebElement
		String PoliycNumber=input.get("Text@PolicyNum");
		uiDriver.webDr.findElement(By.xpath("//*[(text()='"+PoliycNumber+"')]")).click();
		SleepUtils.sleep(2);
		
		//3. Click on Payment_Schedule WebElement
		uiDriver.click("TC01_Pmnt_Pln_Chan_Error_Mes_2.eltPayment_Schedule");
		SleepUtils.sleep(2);
		
		//4. Click on Edit_Schedule WebElement
		uiDriver.click("TC01_Pmnt_Pln_Chan_Error_Mes_2.eltEdit_Schedule");
		SleepUtils.sleep(2);
		
		//5. Select $data from the New_Payment_Plan list
		uiDriver.click("TC01_Pmnt_Pln_Chan_Error_Mes_2.lstNew_Payment_Plan");
		SleepUtils.sleep(2);
		uiDriver.setValue("TC01_Pmnt_Pln_Chan_Error_Mes_2.lstNew_Payment_Plan", input.get("Select@New_Payment_Plan"));
		SleepUtils.sleep(2);
		uiDriver.sendKey("enter");
		SleepUtils.sleep(2);
		
		//6. Click on Execute button
		uiDriver.click("TC01_Pmnt_Pln_Chan_Error_Mes_2.btnExecute");
		SleepUtils.sleep(8);
		
		//7. Verify the text ?$data in the Payment_Plan_Error field
		if (uiDriver.verifyTextActAndExp("TC01_Pmnt_Pln_Chan_Error_Mes_2.eltPayment_Plan_Error", input.get("VerifyText@Payment_Plan_Error"))) {
			passed("verifyText","verifyText should pass","verifyText passed");
		} else {
			failed("verifyText","verifyText should pass","verifyText failed");
		}
		SleepUtils.sleep(4);
		
		//8. Click on Execute button
		uiDriver.click("TC01_Pmnt_Pln_Chan_Error_Mes_2.btnCancel");
		SleepUtils.sleep(4);
		
	}
	
	public void TC04_Pmnt_Plan_Equity_violation(DataRow input, DataRow output) {
		
		//1. Click on Policies WebElement
		uiDriver.click("TC01_Pmnt_Pln_Chan_Error_Mes_2.eltPolicies");
		SleepUtils.sleep(8);
		
		//2. Click on Policies_ WebElement
		String PoliycNumber=input.get("Text@PolicyNum");
		uiDriver.webDr.findElement(By.xpath("//*[(text()='"+PoliycNumber+"')]")).click();
		SleepUtils.sleep(2);
		
		//3. Click on Payment_Schedule WebElement
		uiDriver.click("TC01_Pmnt_Pln_Chan_Error_Mes_2.eltPayment_Schedule");
		SleepUtils.sleep(2);
		
		//4. Click on Edit_Schedule WebElement
		uiDriver.click("TC01_Pmnt_Pln_Chan_Error_Mes_2.eltEdit_Schedule");
		SleepUtils.sleep(2);
		
		//5. Select $data from the New_Payment_Plan list
		uiDriver.click("TC01_Pmnt_Pln_Chan_Error_Mes_2.lstNew_Payment_Plan");
		SleepUtils.sleep(2);
		uiDriver.setValue("TC01_Pmnt_Pln_Chan_Error_Mes_2.lstNew_Payment_Plan", input.get("Select@New_Payment_Plan"));
		SleepUtils.sleep(2);
		uiDriver.sendKey("enter");
		SleepUtils.sleep(5);
		
		//6. Click on Execute button
		uiDriver.click("TC01_Pmnt_Pln_Chan_Error_Mes_2.btnExecute");
		SleepUtils.sleep(4);
		
		//7. Verify the text ?$data in the Payment_Plan_Error field
		if (uiDriver.verifyTextActAndExp("TC01_Pmnt_Pln_Chan_Error_Mes_2.eltPayment_Plan_Error", input.get("VerifyText@Payment_Plan_Error"))) {
			passed("verifyText","verifyText should pass","verifyText passed");
		} else {
			failed("verifyText","verifyText should pass","verifyText failed");
		}
		SleepUtils.sleep(5);
		
		//8. Click on Execute button
		uiDriver.click("TC01_Pmnt_Pln_Chan_Error_Mes_2.btnExecute");
		SleepUtils.sleep(4);
		
		//9. Verify the text ?$data in the Payment_Plan_Error field
		if (uiDriver.verifyTextActAndExp("TC01_Pmnt_Pln_Chan_Error_Mes_2.eltPaymentPalnSched", input.get("Select@New_Payment_Plan"))) {
			passed("verifyText","verifyText should pass","verifyText passed");
		} else {
			failed("verifyText","verifyText should pass","verifyText failed");
		}
		SleepUtils.sleep(4);
		
		//10. Click on Charges Element
		uiDriver.click("TC01_Pmnt_Pln_Chan_Error_Mes_2.eltCharges");
		SleepUtils.sleep(4);
		
	}
	public void TC05_NullPoint_Excep_Modify_Inv(DataRow input, DataRow output) {
		
		//1. Click on Charges Element
		uiDriver.click("TC01_Pmnt_Pln_Chan_Error_Mes_2.eltChargesAccount");
		SleepUtils.sleep(10);
		uiDriver.th.findRelativeCellAndClick("TC01_Pmnt_Pln_Chan_Error_Mes_2.eltNEP_Transaction", input.get("Text@PolicyNum"), 9,input.get("Text@PolicyNum"));
		SleepUtils.sleep(3);
		//uiDriver.click("TC01_Pmnt_Pln_Chan_Error_Mes_2.eltCharges1");
		SleepUtils.sleep(6);
		
		//2. Click on Modify Inovices Items Webbutton
		uiDriver.click("TC01_Pmnt_Pln_Chan_Error_Mes_2.btnModifyInovicesItems");
		SleepUtils.sleep(10);
		
		//3. Click on Modify Inovices Items Webbutton
		String Downpayment=uiDriver.th.getCellData("TC01_Pmnt_Pln_Chan_Error_Mes_2.tblInvoiceitems", 1, 7);
		String Downpayment1=Downpayment.substring(0, Downpayment.length()-3);
		String Downpayment2=Downpayment1.replace(",", "");
	    int Amnt1=Integer.parseInt(Downpayment2.substring(1, Downpayment2.length()));
	    int Amnt2=Amnt1-10;
		SleepUtils.sleep(4);
		
		//4. Click on Amount cell in webtable
		uiDriver.doubleclick("TC01_Pmnt_Pln_Chan_Error_Mes_2.tblAmount");
		SleepUtils.sleep(4);
		uiDriver.setValue("TC01_Pmnt_Pln_Chan_Error_Mes_2.tblAmount2", Integer.toString(Amnt2));
		SleepUtils.sleep(3);
		uiDriver.sendKey("tab");
		SleepUtils.sleep(8);
		
		//5. Click on Amount cell in webtable
		String Downpayment3=uiDriver.th.getCellData("TC01_Pmnt_Pln_Chan_Error_Mes_2.tblInvoiceitems", 2, 7);
		String Downpayment4=Downpayment3.substring(0, Downpayment3.length()-3);
		String Downpayment5=Downpayment4.replace(",", "");
	    int Amnt3=Integer.parseInt(Downpayment5.substring(1, Downpayment5.length()));
	    int Amnt4=Amnt3+10;
		SleepUtils.sleep(4);
		
		//6. Click on Amount cell in webtable
		uiDriver.doubleclick("TC01_Pmnt_Pln_Chan_Error_Mes_2.tblAmount1");
		SleepUtils.sleep(4);
		uiDriver.setValue("TC01_Pmnt_Pln_Chan_Error_Mes_2.tblAmount2", Integer.toString(Amnt4));
		SleepUtils.sleep(3);
		uiDriver.sendKey("tab");
		SleepUtils.sleep(3);
		
		//7. Click on update button
		uiDriver.doubleclick("TC01_Pmnt_Pln_Chan_Error_Mes_2.btnUpdate");
		SleepUtils.sleep(4);
	}

	/**
	*Overriding toString() method of object class to print Equity_Warning_Parameters_On_Payment_Plan
	*format string
	**/
	public String toString(){
		return "Equity_Warning_Parameters_On_Payment_PlanDriver";
	}
}