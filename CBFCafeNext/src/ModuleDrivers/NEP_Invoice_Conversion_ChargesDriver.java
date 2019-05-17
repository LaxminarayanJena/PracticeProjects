/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 2/6/2018 2:06:48 AM
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
 * Extends BaseModuleDriver class and performs application specific operations
 */
public class NEP_Invoice_Conversion_ChargesDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;

	public NEP_Invoice_Conversion_ChargesDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}

	public void NEP_CreatPolicyShell(DataRow input, DataRow output) {

		// 1. Click on Actions button
		uiDriver.click("CreatePolicyShell_NEP.btnActions");
		SleepUtils.sleep(2);

		// 2. Click on NEP WebElement
		uiDriver.click("CreatePolicyShell_NEP.eltNEP");
		SleepUtils.sleep(2);

		//3. Click on Create_Policy_Shell WebElement
		uiDriver.click("CreatePolicyShell_NEP.eltCreate_Policy_Shell");
		SleepUtils.sleep(2);

		//4. Type $data in Policy field
		uiDriver.setValue("CreatePolicyShell_NEP.txtPolicy", input.get("Type@Policy"));
		SleepUtils.sleep(2);

		//5. Click Effective_Date
		uiDriver.click("CreatePolicyShell_NEP.txtEffective_Date");
		uiDriver.sendKey("ENTER");
		SleepUtils.sleep(2);

		//6. Click Expiration_Date
		uiDriver.click("CreatePolicyShell_NEP.txtExpiration_Date");
		uiDriver.sendKey("enter");
		SleepUtils.sleep(2);
		uiDriver.click("NEP_Invoice_Conversion_Charges.lstBillingmethod");
		SleepUtils.sleep(2);
		uiDriver.setValue("NEP_Invoice_Conversion_Charges.lstBillingmethod", input.get("Select@BillingMethod"));
		SleepUtils.sleep(2);
		uiDriver.sendKey("enter");
		SleepUtils.sleep(2);

		//7. Click Payment_Plan
		uiDriver.click("CreatePolicyShell_NEP.txtPayment_Plan");
		SleepUtils.sleep(2);

		//8. Select $data from the Payment_Plan list
		uiDriver.setValue("CreatePolicyShell_NEP.lstPayment_Plan", input.get("Select@Payment_Plan"));
		uiDriver.sendKey("TAB");
		SleepUtils.sleep(2);

		//9. Type $data in Primary field
		uiDriver.setValue("CreatePolicyShell_NEP.txtPrimary", input.get("Type@Primary"));
		SleepUtils.sleep(1);

		//10. Select $data from the Rating_Source list
		uiDriver.clear("CreatePolicyShell_NEP.lstRating_Source");
		uiDriver.setValue("CreatePolicyShell_NEP.lstRating_Source", input.get("Select@Rating_Source"));
		uiDriver.sendKey("tab");
		SleepUtils.sleep(1);
		
		//11. Select $data from the Program list
		uiDriver.clear("CreatePolicyShell_NEP.lstProgram");
		uiDriver.setValue("CreatePolicyShell_NEP.lstProgram", input.get("Select@Program"));
		uiDriver.sendKey("tab");
		SleepUtils.sleep(1);

		//12. Select $data from the Policy_Type list
		uiDriver.clear("CreatePolicyShell_NEP.lstPolicy_Type");
		uiDriver.setValue("CreatePolicyShell_NEP.lstPolicy_Type", input.get("Select@Policy_Type"));
		uiDriver.sendKey("tab");
		SleepUtils.sleep(1);

		//13. Select $data from the Policy_Status list
		uiDriver.clear("CreatePolicyShell_NEP.lstPolicy_Status");
		uiDriver.setValue("CreatePolicyShell_NEP.lstPolicy_Status", input.get("Select@Policy_Status"));
		uiDriver.sendKey("tab");
		SleepUtils.sleep(1);

		//14. Select $data from the Region list
		uiDriver.clear("CreatePolicyShell_NEP.lstRegion");
		uiDriver.setValue("CreatePolicyShell_NEP.lstRegion", input.get("Select@Region"));
		uiDriver.sendKey("tab");

		//15. Click on Add button
		uiDriver.doubleclick("CreatePolicyShell_NEP.btnAdd");

		//16. Verify whether the Add_New_Person element present
		if (uiDriver.checkElementPresent("CreatePolicyShell_NEP.eltAdd_New_Person")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(2);

		//17. Verify whether the Add_New_Company element present
		if (uiDriver.checkElementPresent("CreatePolicyShell_NEP.eltAdd_New_Company")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(2);

		//18. Click on Add_New_Company WebElement
		uiDriver.click("CreatePolicyShell_NEP.eltAdd_New_Company_1");
		SleepUtils.sleep(2);

		//19. Type $data in Name field
		uiDriver.setValue("CreatePolicyShell_NEP.txtName", input.get("Type@Name"));
		SleepUtils.sleep(2);

		//20. Type $data in Address_1 field
		uiDriver.setValue("CreatePolicyShell_NEP.txtAddress_1", input.get("Type@Address_1"));
		SleepUtils.sleep(2);
		
		//21. Type $data in City field
		uiDriver.setValue("CreatePolicyShell_NEP.txtCity", input.get("Type@City"));
		uiDriver.sendKey("tab");
		SleepUtils.sleep(2);

		//22. Click State
		uiDriver.click("CreatePolicyShell_NEP.txtState");
		SleepUtils.sleep(2);

		//23. Select $data from the State list
		uiDriver.setValue("CreatePolicyShell_NEP.lstState", input.get("Select@State"));
		uiDriver.sendKey("tab");
		SleepUtils.sleep(2);
		
		//24. Type $data in Zipcode field
		uiDriver.setValue("CreatePolicyShell_NEP.txtZipcode", input.get("Type@Zipcode"));
		SleepUtils.sleep(2);

		//25. Type $data in Phone field
		uiDriver.setValue("CreatePolicyShell_NEP.txtPhone", input.get("Type@Phone"));
		SleepUtils.sleep(2);

		//26. Type $data in Email field
		uiDriver.setValue("CreatePolicyShell_NEP.txtEmail", input.get("Type@Email"));
		SleepUtils.sleep(2);

		//27. Click on Standardize_Address button
		uiDriver.click("CreatePolicyShell_NEP.btnStandardize_Address");
		SleepUtils.sleep(2);
		Boolean bStatus = uiDriver.getControl("CreatePolicyShell_NEP.btnOverRide").isEnabled();
		if (bStatus == true) {
			uiDriver.ElementPrestnclick("CreatePolicyShell_NEP.btnOverRide");
		}

		//28. Click on Add button
		SleepUtils.sleep(8);
		uiDriver.click("CreatePolicyShell_NEP.btnAdd_1");
		SleepUtils.sleep(8);

		//29. Click Role
		uiDriver.doubleclick("CreatePolicyShell_NEP.txtRole");
		SleepUtils.sleep(2);

		//30. Type $data in Role field
		SleepUtils.sleep(2);
		uiDriver.setValue("CreatePolicyShell_NEP.txtRole_Edit", input.get("Type@Role"));

		//31. Click on OK button
		uiDriver.click("CreatePolicyShell_NEP.btnOk");
		SleepUtils.sleep(2);

		//32. Click on Next button
		uiDriver.click("CreatePolicyShell_NEP.btnNext");
		SleepUtils.sleep(2);

		//33. Type $data in Write_percentage field
		uiDriver.setValue("CreatePolicyShell_NEP.txtWrite_percentage", input.get("Type@Write_percentage"));
		SleepUtils.sleep(2);

		//34. Click on Finish button
		uiDriver.click("CreatePolicyShell_NEP.btnFinish");
		SleepUtils.sleep(8);
	}
	public void Verify_Invoices_History_Event(DataRow input, DataRow output){
		//1. Click on Actions button
		uiDriver.click("CreatePolicyShell_NEP.btnActions");
		SleepUtils.sleep(2);
		
		//2.Verify the element is present
		if (uiDriver.checkElementPresent("NEP_Invoice_Conversion_Charges.eltInvoiceConversionCharges")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		
		//3.Click on invoice Conversion Charges
		uiDriver.click("NEP_Invoice_Conversion_Charges.eltInvoiceConversionCharges");
		
		//4.Verify the element is present
		if (uiDriver.checkElementPresent("NEP_Invoice_Conversion_Charges.eltBanner")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		
		//5.Verify the text presented 
		uiDriver.verifyTextActAndExp("NEP_Invoice_Conversion_Charges.eltReason", "Reason");
		
		//6. Click on Reason element
		uiDriver.click("NEP_Invoice_Conversion_Charges.eltReasonNonEditable");
		SleepUtils.sleep(2);
		
		//7.Verify the element is not present
		if (!uiDriver.checkElementPresent("NEP_Invoice_Conversion_Charges.eltPaymentPaln")) {
			passed("checkElementNotPresent","checkElementNotPresent should pass","checkElementNotPresent passed");
		} else {
			failed("checkElementNotPresent","checkElementNotPresent should pass","checkElementisPresent failed");
		}
		
		//8.Verify the concatenated with the appropriate policy suffix
		String PolicyNumber=uiDriver.th.getCellData("NEP_Invoice_Conversion_Charges.tblInvCovCharges", 0, 0);
		if(PolicyNumber.contains("-000")) {
			passed("suffixPresent","suffixPresent should pass","suffixPresent passed");
		} else {
			failed("suffixPresent","suffixPresent should pass","suffixNotPresent failed");
		}
		
		//9.Fetching the policy number from table
		String DirectBill=uiDriver.th.getCellData("NEP_Invoice_Conversion_Charges.tblInvCovCharges", 0, 0);
		String AgencyBill=uiDriver.th.getCellData("NEP_Invoice_Conversion_Charges.tblInvCovCharges", 1, 0);
		
		//10. Click on Direct bill cell in charges table
		uiDriver.click("NEP_Invoice_Conversion_Charges.tblDirectBill");
		SleepUtils.sleep(2);
		uiDriver.setValue("NEP_Invoice_Conversion_Charges.tblDirectBill_1", input.get("Type@DebitAmnt"));
		SleepUtils.sleep(4);
		
		//11. Click on Agency bill cell in charges table
		uiDriver.click("NEP_Invoice_Conversion_Charges.tblAgencyBill");
		SleepUtils.sleep(2);
		uiDriver.setValue("NEP_Invoice_Conversion_Charges.tblAgencyBill_1", input.get("Type@CreditAmnt"));
		SleepUtils.sleep(8);
		
		//12. Click on Next button
		uiDriver.click("NEP_Invoice_Conversion_Charges.btnNext");
		SleepUtils.sleep(6);
		
		//13. Click on Finish button
		uiDriver.click("NEP_Invoice_Conversion_Charges.btnFinish");
		SleepUtils.sleep(12);
		
		//14. Click on Transaction element
		uiDriver.click("US882_NEPModifyDistri.eltTransactions");
		SleepUtils.sleep(6);
		
		//15.Verify the transaction 
		String NEPTranAmnt="$"+input.get("Type@DebitAmnt")+".00";
		uiDriver.th.verfiygetCellDataOfColumn("US882_NEPModifyDistri.tblNEP_Transaction_Charged", NEPTranAmnt, 3);
		
		//16. Click on Transaction element
		uiDriver.click("US882_NEPModifyDistri.eltCharges");
		SleepUtils.sleep(6);
			
		//17.Verify the text presented in table
		uiDriver.th.getCellDataOfCol("US882_NEPModifyDistri.eltNEP_Transaction", input.get("Verify@ChargType"), 3);
			
		//18.Verify the text presented in table
		uiDriver.th.getCellDataOfCol("US882_NEPModifyDistri.eltNEP_Transaction", input.get("Verify@context"), 4);

		//19. Click on Account element
		uiDriver.click("NEP_Invoice_Conversion_Charges.eltAccount");
		SleepUtils.sleep(8);
		
		//20. Click on History element in Account level
		uiDriver.click("Negative_Write_Off_Reversal.eltHistory");
		SleepUtils.sleep(8);
			
		//21.verify debit event presented in history table
		uiDriver.th.getCellDataOfCol("US994_Write_Off_Reversal.eltDescription", input.get("Verify@AcclevDebitHistory"), 1);
			
		//22.verify credit event presented in history table
		uiDriver.th.getCellDataOfCol("US994_Write_Off_Reversal.eltDescription", input.get("Verify@AcclevCreditHistory"), 1);
		
		//23. Click on Policy element
		uiDriver.click("US1089_ViewPoliciesAccount.eltPolicies");
		SleepUtils.sleep(8);
			
		//24.Click on Selected policy 
		uiDriver.webDr.findElement(By.xpath("//*[text()='"+AgencyBill+"']")).click();
		SleepUtils.sleep(6);
			
		//25. Click on Charges element
		uiDriver.click("US1091_ViewChargesAccntAndPoli.eltCharges");
		SleepUtils.sleep(8);
		
		//26.select agency bill amount and click
		String NEPTranAmnt1="($"+input.get("Type@DebitAmnt")+".00)";
		uiDriver.th.findRelativeCellAndClick("HoldChar_History_AccLevlPoliLe.chkNot_Held", NEPTranAmnt1, 10, NEPTranAmnt1);
		SleepUtils.sleep(8);
			
		//27.Verify the Agency bill amount in charges table
		uiDriver.th.verfiygetCellDataOfColumn("NEP_Invoice_Conversion_Charges.tblCharges", input.get("Type@CreditAmnt"), 10);
		
		//28. Click on payment Payment Schedule element
		uiDriver.click("TC01_Pmnt_Pln_Chan_Error_Mes_2.eltPayment_Schedule");
		SleepUtils.sleep(4);
		
		//29.Verify the Agency bill amount in Payment Schedule table
		uiDriver.th.verfiygetCellDataOfColumn("NEP_Invoice_Conversion_Charges.tblPaymentSchedule", input.get("Type@CreditAmnt"), 10);
			
		//30. Click on History  element
		uiDriver.click("PolicyViewHistory_Validate.eltHistory");
		SleepUtils.sleep(4);
		
		//31.verify the policy level history event
		String Aghisevent="An NEP charge of "+NEPTranAmnt1+" was added for charge correction.";
		uiDriver.th.getCellDataOfCol("PolicyLevelHistory.tbwebelement", Aghisevent, 1);
		SleepUtils.sleep(6);

		//32. Click on Account number element
		uiDriver.click("PolicyLevelHistory.lnkAccount_Number");
		SleepUtils.sleep(4);

		//33. Click on Policy element
		uiDriver.click("US1089_ViewPoliciesAccount.eltPolicies");
		SleepUtils.sleep(6);
		
		//34.Click on Selected policy 
		uiDriver.webDr.findElement(By.xpath("//*[text()='"+DirectBill+"']")).click();
		SleepUtils.sleep(6);
			
		//35. Click on Policy element
		uiDriver.click("US1152ReverseCharges_ValidHist.eltCharges_1");
		SleepUtils.sleep(6);
			
		//36.select agency bill amount and click
		String ChargesDirectBill="($"+input.get("Type@CreditAmnt")+".00)";
		uiDriver.th.findRelativeCellAndClick("HoldChar_History_AccLevlPoliLe.chkNot_Held", ChargesDirectBill, 10, ChargesDirectBill);
			

		//37.Verify the Direct bill amount in charges table
		uiDriver.th.verfiygetCellDataOfColumn("NEP_Invoice_Conversion_Charges.tblCharges", input.get("Type@CreditAmnt"), 10);
		
		//38. Click on payment Payment Schedule element
		uiDriver.click("TC01_Pmnt_Pln_Chan_Error_Mes_2.eltPayment_Schedule");
		SleepUtils.sleep(4);
		
		//39.Verify the Agency bill amount in Payment Schedule table
		uiDriver.th.verfiygetCellDataOfColumn("NEP_Invoice_Conversion_Charges.tblPaymentSchedule", input.get("Type@CreditAmnt"), 10);
				
		//40. Click on History element in Account level
		uiDriver.click("PolicyViewHistory_Validate.eltHistory");
		SleepUtils.sleep(6);
		
		//41.verify the Direct bill  history event
		String CharDirBill="An NEP charge of "+ChargesDirectBill+" was added for charge correction.";
		uiDriver.th.getCellDataOfCol("PolicyLevelHistory.tbwebelement", CharDirBill, 1);
		SleepUtils.sleep(6);
		
		//42.Click on Account element
		uiDriver.click("Producer_View_History.eltPolicyAccount");
		SleepUtils.sleep(6);

		//42.Click on Invoice element
		uiDriver.click("US1212_NewCrditDistribution.eltInvoices");
		SleepUtils.sleep(6);
		
		//43.click sort ascending order element	
		uiDriver.click("Producer_View_History.eltInvoiceDate");
		SleepUtils.sleep(3);
		uiDriver.click("Producer_View_History.eltarrorw");
		SleepUtils.sleep(6);
		uiDriver.click("Producer_View_History.eltSortAscending");
		SleepUtils.sleep(10);
		
		//44.Click planned element in table
		uiDriver.th.findRelativeCellAndClick("AbleTocreateAndviewThenewInvcs.tblId", "Planned", 7, "Planned");
		SleepUtils.sleep(10);
		
		//45.Verify the credit item should present in Planned invoice.
		String CrdAmnt="$"+input.get("Type@CreditAmnt")+".00";
		uiDriver.th.verfiygetCellDataOfColumn("US882_NEPModifyDistri.tblStatus", CrdAmnt, 8);	
		SleepUtils.sleep(6);

	}

	/**
	 * Overriding toString() method of object class to print NEP format string
	 **/
	public String toString() {
		return "NEP_Invoice_Conversion_ChargesDriver";
	}
}
