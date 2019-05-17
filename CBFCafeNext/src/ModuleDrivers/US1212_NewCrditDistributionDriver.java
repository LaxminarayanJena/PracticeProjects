/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 12/26/2017 5:51:54 AM
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
public class US1212_NewCrditDistributionDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public US1212_NewCrditDistributionDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void US1212_NewCrditDistribution(DataRow input, DataRow output) {
		
		//1. Click on Actions WebElement
		uiDriver.click("US1212_NewCrditDistribution.eltActions");
		
		//2. Click on New_Transaction WebElement
		SleepUtils.sleep(2);
		uiDriver.click("US1212_NewCrditDistribution.eltNew_Transaction");
		SleepUtils.sleep(2);
		
		//3. Click on Credit WebElement
		uiDriver.click("US1212_NewCrditDistribution.eltCredit");
		
		//4. Select $data from the Credit_type list
		uiDriver.click("US1212_NewCrditDistribution.lstCredit_type");
		SleepUtils.sleep(3);
		uiDriver.setValue("US1212_NewCrditDistribution.lstCredit_type", input.get("Type@Credit_type"));
		//uiDriver.sendKey("tab");
		SleepUtils.sleep(2);
		
		
		//5. Type $data in Amount field
		uiDriver.setValue("US1212_NewCrditDistribution.txtAmount", input.get("Type@Amount"));
		SleepUtils.sleep(4);
		
		//6. Click on Next button
		uiDriver.click("US1212_NewCrditDistribution.btnNext");
		SleepUtils.sleep(3);
		if (uiDriver.checkElementPresent("US1212_NewCrditDistribution.eltNewCreditDistributionError")) {
			uiDriver.setValue("US1212_NewCrditDistribution.lstCredit_type", input.get("Type@Credit_type"));
			uiDriver.sendKey("enter");
			SleepUtils.sleep(2);
			uiDriver.click("US1212_NewCrditDistribution.btnNext");
		}
		SleepUtils.sleep(4);
		
		//7. Click on Finish button
		uiDriver.click("US1212_NewCrditDistribution.btnFinshi");
		SleepUtils.sleep(5);
		uiDriver.click("US1212_NewCrditDistribution.lnkActions");
		SleepUtils.sleep(2);
		uiDriver.mouseOver("US1212_NewCrditDistribution.lnknewpayment");
		SleepUtils.sleep(2);
		uiDriver.click("US1212_NewCrditDistribution.lnknewDirectBillcreditdistribution");
		SleepUtils.sleep(2);
		uiDriver.click("US1212_NewCrditDistribution.chkuseappliedfunds");
		SleepUtils.sleep(2);
		uiDriver.click("US1212_NewCrditDistribution.btnexecute");
		SleepUtils.sleep(2);

		//8. Click on Payment WebElement
		uiDriver.click("US1212_NewCrditDistribution.eltPayment");
		SleepUtils.sleep(5);
		
		//9. Click on Credit_Distributions WebElement
		uiDriver.click("US1212_NewCrditDistribution.eltCredit_Distributions");
		SleepUtils.sleep(3);
		
		//10. Click on Actions button
		SleepUtils.sleep(2);
		uiDriver.th.findRelativeCellAndClickSelectedCellInSubtext("US1212_NewCrditDistribution.tblCreditdist", "Unapplied fund (Account)", 3,  "Unapplied fund (Account)", "Actions", "Actions");
		SleepUtils.sleep(4);
		
		//11. Click on Reverse WebElement
		uiDriver.click("US1212_NewCrditDistribution.eltReverse");
		SleepUtils.sleep(4);
		String RevAmnt=uiDriver.getControl("US1212_NewCrditDistribution.eltConfirmCreditReversal").getText();
		SleepUtils.sleep(2);
		int pos1=RevAmnt.indexOf("$");
		int Pos2=RevAmnt.indexOf(".00");
		String Amnt=RevAmnt.substring(pos1, Pos2);

		
		//12. Verify whether the Confirm_Credit_Reversal element present
		SleepUtils.sleep(2);
		if (uiDriver.checkElementPresent("US1212_NewCrditDistribution.eltConfirm_Credit_Reversal")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		
		//13. Select $data from the Reason list
		uiDriver.click("US1212_NewCrditDistribution.lstReason");
		SleepUtils.sleep(3);
		uiDriver.setValue("US1212_NewCrditDistribution.lstReason", input.get("Select@Reason"));
		
		//14. Click on OK button
		uiDriver.click("US1212_NewCrditDistribution.btnOK");
		
		//15. Click on Histroy WebElement
		SleepUtils.sleep(3);
		uiDriver.click("US1212_NewCrditDistribution.eltHistroy");
		
		//16. Select $data from the Filter_by_Type list
		SleepUtils.sleep(3);
		uiDriver.click("US1212_NewCrditDistribution.lstFilter_by_Type");
		SleepUtils.sleep(3);
		uiDriver.setValue("US1212_NewCrditDistribution.lstFilter_by_Type", input.get("Select@Filter_by_Type"));
		uiDriver.sendKey("enter");
		SleepUtils.sleep(3);
		
		//17. Compare Actual data with expected data
		String actualEventType=uiDriver.getControl("US1212_NewCrditDistribution.eltDescription").getText();
		String expectedEventType="A credit totaling "+Amnt +" has been reversed for Insured Request.";
		
		if (actualEventType.equalsIgnoreCase(expectedEventType)) {
			passed("verifyText","verifyText should pass","verifyText passed");
		} else {
			failed("verifyText","verifyText should pass","verifyText failed");
		}
	}
	

	/**
	*Overriding toString() method of object class to print US1212_NewCrditDistribution
	*format string
	**/
	public String toString(){
		return "US1212_NewCrditDistributionDriver";
	}
}
