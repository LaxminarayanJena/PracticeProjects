/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 12/21/2017 1:29:56 AM
Module part of 'Guidewire_BillingCenter'
Module created using Cafenext Selenium Builder
******************************************************************************/
package ModuleDrivers;
import static cbf.engine.TestResultLogger.*;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import cbf.engine.TestResult.ResultType;
import cbf.harness.ParameterAccess;
import cbf.utils.DataRow;
import cbf.utils.SleepUtils;
import cbf.utils.SleepUtils.TimeSlab;
import cbfx.selenium.BaseWebModuleDriver;

/**
Extends BaseModuleDriver class and performs application specific operations
*/
public class US1256_MultiplePaymentWizard extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public US1256_MultiplePaymentWizard(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void MakePaymentMulAccPoliProd(DataRow input, DataRow output) {
		//1. Click on Desktop WebElement
		uiDriver.click("MakePaymentMulAccPoliProd.eltDesktop");
		SleepUtils.sleep(8);
		
		//2. Click on Unmatched_Suspense_Payments WebElement
		uiDriver.click("MakePaymentMulAccPoliProd.eltUnmatched_Suspense_Payments");
		SleepUtils.sleep(6);
		
		//3. Click on Actions WebElement
		uiDriver.click("MakePaymentMulAccPoliProd.eltActions");
		SleepUtils.sleep(2);
		
		//4. Click on Batch_Payment_Entry WebElement
		uiDriver.mouseOver("MakePaymentMulAccPoliProd.eltNewPayment");
		SleepUtils.sleep(3);
		uiDriver.click("MakePaymentMulAccPoliProd.eltBatch_Payment_Entry");
		SleepUtils.sleep(6);
		
		//5. Type $data in Batch_Amount field
		uiDriver.setValue("MakePaymentMulAccPoliProd.txtBatch_Amount", input.get("Type@Batch_Amount"));
		SleepUtils.sleep(2);
		
		//6. Select check box 
		uiDriver.click("MakePaymentMulAccPoliProd.chkBatchPayment_Entery_wizard");
		SleepUtils.sleep(2);
		
		//7. Select $data from the Type list
		uiDriver.doubleclick("MakePaymentMulAccPoliProd.lstType");
		SleepUtils.sleep(2);
		uiDriver.sendKey("keysdown");
		SleepUtils.sleep(2);
		uiDriver.sendKey("enter");
		SleepUtils.sleep(2);
		
		//8. Type $data in Check_Ref field
		uiDriver.click("MakePaymentMulAccPoliProd.txtCheck_Ref");
		SleepUtils.sleep(2);
		uiDriver.setValue("MakePaymentMulAccPoliProd.txtCheck_Ref1", input.get("Type@Check_Ref"));
		
		//9. Type $data in Amount field
		uiDriver.click("MakePaymentMulAccPoliProd.txtAmount");
		SleepUtils.sleep(2);
		uiDriver.setValue("MakePaymentMulAccPoliProd.txtAmount1", input.get("Type@Amount"));
		
		//10. Click on Split button
		uiDriver.click("MakePaymentMulAccPoliProd.btnSplit");
		
		//11. Verify whether the Print_Export button is present
		if (uiDriver.checkElementPresent("MakePaymentMulAccPoliProd.btnPrint_Export")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		
		//12. Click on PrintExport button
		uiDriver.click("MakePaymentMulAccPoliProd.btnPrintExport");
		
		//13. Click on OK button
		uiDriver.click("MakePaymentMulAccPoliProd.btnOK");
		
		//14. Select $value from Export Radio Button from the list
		SleepUtils.sleep(2);
		uiDriver.click("MakePaymentMulAccPoliProd.rdgExport");
		
		//15. Click on Ok button
		SleepUtils.sleep(3);
		uiDriver.click("MakePaymentMulAccPoliProd.btnOK");
		
		//16. Select $value from Custom_Export Radio Button from the list
		SleepUtils.sleep(2);
		uiDriver.click("MakePaymentMulAccPoliProd.rdgCustom_Export");
		SleepUtils.sleep(2);
		
		//17.Select Type check box 
		uiDriver.mouseOver("MakePaymentMulAccPoliProd.tblType");
		SleepUtils.sleep(2);
		uiDriver.click("MakePaymentMulAccPoliProd.tblType");
		
		//18.Select Amount check box
		SleepUtils.sleep(2);
		uiDriver.mouseOver("MakePaymentMulAccPoliProd.tblAmount");
		SleepUtils.sleep(2);
		uiDriver.click("MakePaymentMulAccPoliProd.tblAmount");
		
		//19.Select Account check box
		SleepUtils.sleep(2);
		uiDriver.mouseOver("MakePaymentMulAccPoliProd.tblAccount");
		SleepUtils.sleep(2);
		uiDriver.click("MakePaymentMulAccPoliProd.tblAccount");
		
		//20.Select Invoice check box
		SleepUtils.sleep(2);
		uiDriver.mouseOver("MakePaymentMulAccPoliProd.tblInvoice");
		SleepUtils.sleep(2);
		uiDriver.click("MakePaymentMulAccPoliProd.tblInvoice");
		uiDriver.sendKey("enter");
		
		//21.Select Policy check box
		SleepUtils.sleep(2);
		uiDriver.mouseOver("MakePaymentMulAccPoliProd.tblPolicy");
		SleepUtils.sleep(2);
		uiDriver.click("MakePaymentMulAccPoliProd.tblPolicy");
		uiDriver.sendKey("enter");
		
		//22.Select Producer check box
		SleepUtils.sleep(2);
		uiDriver.mouseOver("MakePaymentMulAccPoliProd.tblProducer");
		SleepUtils.sleep(2);
		uiDriver.click("MakePaymentMulAccPoliProd.tblProducer");
		
		//23.Select Notes check box
		SleepUtils.sleep(2);
		uiDriver.mouseOver("MakePaymentMulAccPoliProd.tblNotes");
		SleepUtils.sleep(2);
		uiDriver.click("MakePaymentMulAccPoliProd.tblNotes");
		uiDriver.click("MakePaymentMulAccPoliProd.tblNotes");
		SleepUtils.sleep(2);
		
		//24. Click on OK button
		SleepUtils.sleep(2);
		uiDriver.click("MakePaymentMulAccPoliProd.btnOK");
		SleepUtils.sleep(3);
		
		//25. Click on Desktop WebElement
		uiDriver.click("MakePaymentMulAccPoliProd.eltDesktop");

		//26. Click on Actions WebElement
		uiDriver.click("MakePaymentMulAccPoliProd.eltActions");
		
		//27. Click on Batch_Payment_Entry WebElement
		uiDriver.mouseOver("MakePaymentMulAccPoliProd.eltNewPayment");
		SleepUtils.sleep(3);
		uiDriver.click("MakePaymentMulAccPoliProd.eltBatch_Payment_Entry");
		SleepUtils.sleep(2);
		
		//28. Click on Cancel WebElement
		uiDriver.click("MakePaymentMulAccPoliProd.btnPrintoptnCancel");
		SleepUtils.sleep(3);
		uiDriver.click("MakePaymentMulAccPoliProd.btnSpltExtCancel");
		
		//29. Type $data in Batch_Amount field
		uiDriver.setValue("MakePaymentMulAccPoliProd.txtBatch_Amount", input.get("Type@Batch_Amount"));
		SleepUtils.sleep(3);
		
		//30. Payment Instrument fields validation
		uiDriver.drawHighlight("MakePaymentMulAccPoliProd.lstPaymentInstrument");
		uiDriver.click("MakePaymentMulAccPoliProd.lstPaymentInstrument");
		uiDriver.wait(3000);
		
		//31.if Dropdown is not  visible it will re click it again
		boolean verfiyva1l=uiDriver.getElementNameUsingTag("li","MasterCard");	
		if (!verfiyva1l)
		{
		uiDriver.drawHighlight("MakePaymentMulAccPoliProd.lstPaymentInstrument");
		uiDriver.click("MakePaymentMulAccPoliProd.lstPaymentInstrument");
		}
		String[] val=input.get("Verify@Payment_Instrument").split(",");
		uiDriver.wait(3000);
		for(int i=0; i<val.length; i++) {
			boolean verfiyval=uiDriver.getElementNameUsingTag("li",val[i]);	
			if (verfiyval)
			{
				passed( "verify option from the Payment Instrument list",val[i]+ " option should be exist on Payment Instrument" ,val[i]+ " Option has been exist on Payment Instrument");
			}
			else
			{
				failed( "verify option from the Payment Instrument list",val[i]+ " option should be exist on Payment Instrument" ,val[i]+ " Option has been exist on Payment Instrument");
			}
		}
		
		//32.Click on Cancel WebElement
		SleepUtils.sleep(4);
		uiDriver.sendKey("enter");
		SleepUtils.sleep(4);
		uiDriver.click("MakePaymentMulAccPoliProd.btnCancelBatchPaymentEntry");
		SleepUtils.sleep(8);
		
		//33.Click on Cancel WebElement
		uiDriver.click("MakePaymentMulAccPoliProd.eltPaymentbatch");
		SleepUtils.sleep(4);
		
		//34.Verfiy fields exist
		if (uiDriver.checkElementPresent("MakePaymentMulAccPoliProd.tblReversedby")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		
      }
	

	/**
	*Overriding toString() method of object class to print MultiplePaymentsWizard
	*format string
	**/
	public String toString(){
		return "MultiplePaymentsWizardDriver";
	}
}
