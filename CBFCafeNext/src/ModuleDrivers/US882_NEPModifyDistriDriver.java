/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 12/29/2017 4:58:37 AM
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
public class US882_NEPModifyDistriDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public US882_NEPModifyDistriDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void US882_NEPModifyDistri(DataRow input, DataRow output) {
		
		//1. Click on Actions WebElement
		SleepUtils.sleep(3);
		uiDriver.click("US882_NEPModifyDistri.eltActions");
		
		//2. Click on NEP WebElement
		SleepUtils.sleep(2);
		uiDriver.mouseOver("US882_NEPModifyDistri.eltNEP");
		
		//3. Click on Modify_Distribution WebElement
		uiDriver.click("US882_NEPModifyDistri.eltModify_Distribution");
		
		//4. Type $data in Payment_Amount field
		SleepUtils.sleep(4);
		uiDriver.setValue("US882_NEPModifyDistri.txtPayment_Amount", input.get("Type@Payment_Amount"));
		
		//5. Click on Payment_date_Picker WebElement
		uiDriver.click("US882_NEPModifyDistri.eltPayment_date_Picker");
		SleepUtils.sleep(2);
		uiDriver.click("US882_NEPModifyDistri.eltPayment_date_Picker");
		SleepUtils.sleep(2);
		uiDriver.sendKey("enter");
		
		//6. Type $data in BatcNumber field
		uiDriver.setValue("US882_NEPModifyDistri.txtBatcNumber", input.get("Type@BatcNumber"));
		
		//7. Type $data in Check_Ref field
		uiDriver.setValue("US882_NEPModifyDistri.txtCheck_Ref", input.get("Type@Check_Ref"));
		SleepUtils.sleep(6);
		
		//8. Type $data in Debit field
		uiDriver.click("US882_NEPModifyDistri.txtDebit");
		SleepUtils.sleep(2);
		uiDriver.setValue("US882_NEPModifyDistri.txtDebit1", input.get("Type@Debit"));
		
		//9. Type $data in Credit field
		uiDriver.click("US882_NEPModifyDistri.txtCredit");
		SleepUtils.sleep(2);
		uiDriver.click("US882_NEPModifyDistri.txtCredit");
		SleepUtils.sleep(2);
		uiDriver.setValue("US882_NEPModifyDistri.txtCredit1", input.get("Type@Credit"));
		
		//10. Click on Next button
		uiDriver.click("US882_NEPModifyDistri.btnNext");
		
		//11. Click on Finish button
		uiDriver.click("US882_NEPModifyDistri.btnFinish");
		
		//12. Verfiy transaction complete status
		if (uiDriver.checkElementPresent("US882_NEPModifyDistri.eltNEPmdTransactionCompl")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		
		//13. Click on Transactions WebElement
		uiDriver.click("US882_NEPModifyDistri.eltTransactions");
		uiDriver.click("Verfiy_Producer_History.eltDate");
		SleepUtils.sleep(2);
		uiDriver.click("NEPOtherTransactions.imageDesArrow");
		SleepUtils.sleep(2);
		uiDriver.click("NEPOtherTransactions.eltTransSortDescending");
		SleepUtils.sleep(2);
		
		//14. Verify NEP_Transaction_Charged
		SleepUtils.sleep(2);
		String Expectedstr=input.get("VerifyText@Transaction");
		String ItemValu=uiDriver.th.getRelativeCellData("US882_NEPModifyDistri.tblNEP_Transaction_Charged", "NEP Transaction Charged", 2);
		if(ItemValu.equalsIgnoreCase(Expectedstr)) {
			passed("Verify ","Actual and expected both string should be equal","both values should equal passed");
		} else {
			failed("Verify ","Actual and expected both string should be equal","both values Not equal failed");
		}
		
		//15. Click on History WebElement
		uiDriver.click("US882_NEPModifyDistri.eltHistory");
		
		//16. Select $data from the Filter_by_Date list
		uiDriver.click("US882_NEPModifyDistri.lstFilter_by_Date");
		SleepUtils.sleep(2);
		uiDriver.setValue("US882_NEPModifyDistri.lstFilter_by_Date", input.get("Select@Filter_by_Date"));
		SleepUtils.sleep(1);
		uiDriver.sendKey("tab");
		
		//17. Click on Charges WebElement
		SleepUtils.sleep(3);
		uiDriver.click("US882_NEPModifyDistri.eltCharges");
		
		//18. Verify NEP_Transaction
		SleepUtils.sleep(3);
		String Str1=input.get("VerifyText@Category");
		uiDriver.th.findRelativeCellAndClick("US882_NEPModifyDistri.eltNEP_Transaction", Str1, 4, Str1);
		
		//19. Click on Invoices WebElement
		SleepUtils.sleep(4);
		uiDriver.click("US882_NEPModifyDistri.eltInvoices");
		SleepUtils.sleep(4);
		uiDriver.click("NEPOtherTransactions.eltInvoiceDate");
		SleepUtils.sleep(2);
		uiDriver.click("TC03_Abilitytowaiveinstallment.btnInvoice_DateSort");
		SleepUtils.sleep(2);
		uiDriver.click("Producer_View_History.eltSortAscending");
		SleepUtils.sleep(2);
		
		//20. Verify the text ?$data in the Category field
		SleepUtils.sleep(3);
		String cAmount=input.get("VerifyText@CategoryAmnt");
		uiDriver.th.findRelativeCellAndClick("US882_NEPModifyDistri.eltCategory", cAmount, 7, cAmount);
		SleepUtils.sleep(2);
		String Expectedstr1=input.get("VerifyText@Category");
		String ItemValu1=uiDriver.th.getRelativeCellData("US882_NEPModifyDistri.tblStatus", "NEP Transaction", 3);
		if(ItemValu1.equalsIgnoreCase(Expectedstr1)) {
			passed("Verify ","Actual and expected both string should be equal","both values should equal passed");
		} else {
			failed("Verify ","Actual and expected both string should be equal","both values Not equal failed");
		}
	}
	

	/**
	*Overriding toString() method of object class to print US882_NEPModifyDistri
	*format string
	**/
	public String toString(){
		return "US882_NEPModifyDistriDriver";
	}
}
