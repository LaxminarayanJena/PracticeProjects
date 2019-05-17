/******************************************************************************
3Created by : Capgemini Automation Team
Created\Updated on : 2/6/2018 2:06:48 AM
Module part of 'Guidewire_BillingCenter'
Module created using Cafenext Selenium Builder
 ******************************************************************************/
package ModuleDrivers;

import static cbf.engine.TestResultLogger.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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
public class NEPOtherTransactionsDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;

	public NEPOtherTransactionsDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}

	public void NEP_CreatPolicyShell(DataRow input, DataRow output) {

		// 1. Click on Actions button
		uiDriver.click("CreatePolicyShell_NEP.btnActions");
		SleepUtils.sleep(2);

		// 2. Click on NEP WebElement
		uiDriver.click("CreatePolicyShell_NEP.eltNEP");
		SleepUtils.sleep(2);

		// 3. Click on Create_Policy_Shell WebElement
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
		uiDriver.sendKey("tab");
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
		
		//24. Type $data in Zip code field
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
	public void NEP_Payment_Reversal(DataRow input, DataRow output){
			
		//1. Click on Actions button
		uiDriver.click("CreateAccountShell_NEP.btnActions");
		SleepUtils.sleep(2);
			
		//2.Click on NEP web element
		uiDriver.mouseOver("CreatePolicyShell_NEP.eltNEP");
		SleepUtils.sleep(2);
			
		//3.Click on Debt Adjustment web element
		uiDriver.mouseOver("TC01_NEPPaymentreversal.eltDebit_Adjustment");
		SleepUtils.sleep(2);
		
		//4.Click on NEP web element
		uiDriver.click("TC01_NEPPaymentreversal.eltPayment_Reversal");
		SleepUtils.sleep(2);
		
		//5.Verify the element is present
		uiDriver.verifyTextActAndExp("NEPOtherTransactions.eltHeaderDebitAdjustment", input.get("Verfiy@HeaderPayment_rev"));
		
		//6.Verify the element is present
		if (uiDriver.checkElementPresent("NEPOtherTransactions.eltPolicyNumber")) {
			passed("checkElementNotPresent","checkElementNotPresent should pass","checkElementNotPresent passed");
		} else {
			failed("checkElementNotPresent","checkElementNotPresent should pass","checkElementisPresent failed");
		}
		
		//7.Verify the element is present
		if (uiDriver.checkElementPresent("NEPOtherTransactions.eltEffectiveDate")) {
			passed("checkElementNotPresent","checkElementNotPresent should pass","checkElementNotPresent passed");
		} else {
			failed("checkElementNotPresent","checkElementNotPresent should pass","checkElementisPresent failed");
		}
		
		//8.Verify the element is present
		if (uiDriver.checkElementPresent("NEPOtherTransactions.eltExpirationDate")) {
			passed("checkElementNotPresent","checkElementNotPresent should pass","checkElementNotPresent passed");
		} else {
			failed("checkElementNotPresent","checkElementNotPresent should pass","checkElementisPresent failed");
		}
		
		//9.Verify the element is present
		if (uiDriver.checkElementPresent("NEPOtherTransactions.eltPolicyStatus")) {
			passed("checkElementNotPresent","checkElementNotPresent should pass","checkElementNotPresent passed");
		} else {
			failed("checkElementNotPresent","checkElementNotPresent should pass","checkElementisPresent failed");
		}
		
		//10.Verify the element is present
		if (uiDriver.checkElementPresent("NEPOtherTransactions.eltCurrentBalance")) {
			passed("checkElementNotPresent","checkElementNotPresent should pass","checkElementNotPresent passed");
		} else {
			failed("checkElementNotPresent","checkElementNotPresent should pass","checkElementisPresent failed");
		}
		
		//11.Click on Next button
		uiDriver.click("TC01_NEPPmntRevviewEditAddNew.btnPmnt_Reversal_Next");
		SleepUtils.sleep(4);
		
		//12.Verify the element is present
		if (uiDriver.checkElementPresent("NEPOtherTransactions.eltPaymentReversal")) {
			passed("checkElementNotPresent","checkElementNotPresent should pass","checkElementNotPresent passed");
		} else {
			failed("checkElementNotPresent","checkElementNotPresent should pass","checkElementisPresent failed");
		}
			
		//13. Type $data in Role field
		uiDriver.setValue("NEPOtherTransactions.txtPaymentAmount", input.get("Type@PaymentAmount"));
		SleepUtils.sleep(2);
			
		//14.Click on date picker element
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		String tday = dateFormat.format(calendar.getTime());
		uiDriver.setValue("NEPOtherTransactions.eltDatePicker", tday);
		SleepUtils.sleep(4);
		
		//15. Verify the list values 
		uiDriver.click("NEPOtherTransactions.lstReason");
		boolean sflag=uiDriver.getElementNameUsingTag("li", "Bank Error");
		if(!sflag) {
			uiDriver.click("NEPOtherTransactions.lstReason");
		}
		SleepUtils.sleep(5);
		uiDriver.checkDropDownOptions("li", input.get("Verfiy@NEPReason"));
		SleepUtils.sleep(5);
		
		//16. Select $data from the Reason list
		uiDriver.setValue("NEPOtherTransactions.lstReason", input.get("Select@Reason"));
		uiDriver.sendKey("enter");
		SleepUtils.sleep(2);
		
		//17.Type $data in Policy field
		uiDriver.setValue("NEPOtherTransactions.txtPolicyStartsWith", input.get("Type@Policy"));
		SleepUtils.sleep(2);
		
		//18.Click on Go Button
		uiDriver.click("NEPOtherTransactions.btnGo");
		SleepUtils.sleep(4);

		//19.Click on Clear Button
		uiDriver.click("NEPOtherTransactions.btnClear");
		SleepUtils.sleep(4);
		
		//20.Click on Go Button
		uiDriver.click("NEPOtherTransactions.btnGo");
		SleepUtils.sleep(4);
		
		//21.Select check box Related policy in table
		String PolicyNum=input.get("Type@Policy")+"-000";
		uiDriver.th.findRelativeCellAndClickfirstCell("NEPOtherTransactions.tblPolicy", PolicyNum, 1, PolicyNum);
		SleepUtils.sleep(4);
		
		//22.Click on Next button
		uiDriver.click("TC01_NEPPmntRevviewEditAddNew.btnPmnt_Reversal_Next");
		SleepUtils.sleep(4);
		
		//23.Verify the element is  present
		if (uiDriver.checkElementPresent("NEPOtherTransactions.eltPaymentReversal")) {
			passed("checkElementNotPresent","checkElementNotPresent should pass","checkElementNotPresent passed");
		} else {
			failed("checkElementNotPresent","checkElementNotPresent should pass","checkElementisPresent failed");
		}
		
		//24.Click on NEP web element
		uiDriver.click("NEPOtherTransactions.btnSelectPolicies");
		SleepUtils.sleep(4);
		
		//25.Click on Next button
		String dropdownvalue=uiDriver.getControl("NEPOtherTransactions.lstReason").getAttribute("value");
		SleepUtils.sleep(2);
		if(dropdownvalue.equalsIgnoreCase("<none>")) {
			uiDriver.setValue("NEPOtherTransactions.lstReason", input.get("Select@Reason"));
		}
		uiDriver.click("TC01_NEPPmntRevviewEditAddNew.btnPmnt_Reversal_Next");
		SleepUtils.sleep(4);
		
		//26.verify the  selected policy presented in confirmation page
		String PolicyNumber=uiDriver.th.getCellData("NEPOtherTransactions.tblDebit_2", 0, 0);
		if(PolicyNumber.contains(PolicyNum)) {
			passed("CheckPolicy","BothPolicices are same should pass","PolicyPresent passed");
		} else {
			failed("CheckPolicy","BothPolicices are same should pass","PolicyNotPresent failed");
		}
			
		
		//27.Verify the element is present
		if (uiDriver.checkElementPresent("NEPOtherTransactions.eltPolicyNumber")) {
			passed("checkElementNotPresent","checkElementNotPresent should pass","checkElementNotPresent passed");
		} else {
			failed("checkElementNotPresent","checkElementNotPresent should pass","checkElementisPresent failed");
		}
		
		//28.Verify the element is present
		if (uiDriver.checkElementPresent("NEPOtherTransactions.eltEffectiveDate")) {
			passed("checkElementNotPresent","checkElementNotPresent should pass","checkElementNotPresent passed");
		} else {
			failed("checkElementNotPresent","checkElementNotPresent should pass","checkElementisPresent failed");
		}
		
		//29.Verify the element is present
		if (uiDriver.checkElementPresent("NEPOtherTransactions.eltExpirationDate")) {
			passed("checkElementNotPresent","checkElementNotPresent should pass","checkElementNotPresent passed");
		} else {
			failed("checkElementNotPresent","checkElementNotPresent should pass","checkElementisPresent failed");
		}
		
		//30.Verify the element is present
		if (uiDriver.checkElementPresent("NEPOtherTransactions.eltPolicyStatus")) {
			passed("checkElementNotPresent","checkElementNotPresent should pass","checkElementNotPresent passed");
		} else {
			failed("checkElementNotPresent","checkElementNotPresent should pass","checkElementisPresent failed");
		}
		
		//29.Verify the element is present
		if (uiDriver.checkElementPresent("NEPOtherTransactions.eltCurrentBalance")) {
			passed("checkElementNotPresent","checkElementNotPresent should pass","checkElementNotPresent passed");
		} else {
			failed("checkElementNotPresent","checkElementNotPresent should pass","checkElementisPresent failed");
		}
		
		//31.Verify the element is present
		if (uiDriver.checkElementPresent("NEPOtherTransactions.eltDebit")) {
			passed("checkElementNotPresent","checkElementNotPresent should pass","checkElementNotPresent passed");
		} else {
			failed("checkElementNotPresent","checkElementNotPresent should pass","checkElementisPresent failed");
		}
		
		//32.Verify the element is present
		if (uiDriver.checkElementPresent("NEPOtherTransactions.eltNewBalance")) {
			passed("checkElementNotPresent","checkElementNotPresent should pass","checkElementNotPresent passed");
		} else {
			failed("checkElementNotPresent","checkElementNotPresent should pass","checkElementisPresent failed");
		}
		
		//33.Click on Finish button
		uiDriver.click("TC02_NEP_Debit_Adjustment.btnFinish");
		SleepUtils.sleep(10);
		
		//34.Click on OK button
		uiDriver.mouseOver("TC01_Validate_Newly_Added_Feat.btnOK");
		SleepUtils.sleep(2);
		uiDriver.click("TC01_Validate_Newly_Added_Feat.btnOK");
		SleepUtils.sleep(10);
		
		//35.Verify the element is not present
		if (uiDriver.checkElementPresent("NEPOtherTransactions.eltNEPerror")) {
			passed("checkElementNotPresent","checkElementNotPresent should pass","checkElementNotPresent passed");
		} else {
			failed("checkElementNotPresent","checkElementNotPresent should pass","checkElementisPresent failed");
		}
		SleepUtils.sleep(4);
		uiDriver.click("NEPOtherTransactions.btnBack");
		SleepUtils.sleep(2);
		uiDriver.click("TC01_NEPPmntRevviewEditAddNew.btnPmnt_Reversal_Next");
		SleepUtils.sleep(2);

		//36. Click and Type $data in Debt field
		uiDriver.doubleclick("NEPOtherTransactions.tblDebit");
		SleepUtils.sleep(2);
		uiDriver.doubleclick("NEPOtherTransactions.tblDebit");
		SleepUtils.sleep(2);
		uiDriver.setValue("NEPOtherTransactions.tblDebit_1", input.get("Type@PaymentAmount"));
		SleepUtils.sleep(6);
		
		
		//37.Click on Add button
		uiDriver.click("NEPOtherTransactions.btnAdd");
		SleepUtils.sleep(4);
		
		//38. Verify the list values 
		uiDriver.click("NEPOtherTransactions.tblCategory");
		SleepUtils.sleep(2);
		boolean sFlag=uiDriver.getElementNameUsingTag("li", "NEP Idea Fee");
		if(!sFlag) {
			uiDriver.click("NEPOtherTransactions.tblCategory");
		}
		SleepUtils.sleep(2);
		uiDriver.checkDropDownOptions("li", input.get("Verfiy@Category"));
		SleepUtils.sleep(2);
		
		
		//39. Click and Type $data in Category field
		//uiDriver.click("NEPOtherTransactions.tblCategory");
		SleepUtils.sleep(2);
		uiDriver.setValue("NEPOtherTransactions.tblCategory_1", input.get("Select@Category"));
		uiDriver.sendKey("enter");
		SleepUtils.sleep(2);
		
		//40. Click and Type $data in Amount field
		uiDriver.click("NEPOtherTransactions.txtAmount");
		SleepUtils.sleep(2);
		uiDriver.setValue("NEPOtherTransactions.txtAmount_1", input.get("Type@PaymentAmount"));
		uiDriver.sendKey("enter");
		SleepUtils.sleep(2);
		
		//41.Verify that the current balance column is summated on the Enter Debt Adjustment Details screen
		String currBalance=uiDriver.th.getCellData("NEPOtherTransactions.tblDebit_2", 0, 4);
		if(!currBalance.equals("-")) {
			String currBalance1=currBalance.substring(1, currBalance.length()-3);
			String Debit=uiDriver.th.getCellData("NEPOtherTransactions.tblDebit_2", 0, 5);
			String Debit1=Debit.substring(1, Debit.length()-3);
			int Sum=Integer.parseInt(currBalance1)+Integer.parseInt(Debit1);
			String NewBalence=uiDriver.th.getCellData("NEPOtherTransactions.tblDebit_2", 0, 6);
			String Sum1=Integer.toString(Sum);
			if(NewBalence.contains(Sum1)) {
				passed("SummatedAmount","SummatedAmountEqual should pass","SummatedAmountEqual passed");
			} else {
				failed("SummatedAmount","SummatedAmountEqual should pass","SummatedAmountNotEqual failed");
			}
		}
		if(currBalance.equals("-")) {
			String Debit=uiDriver.th.getCellData("NEPOtherTransactions.tblDebit_2", 0, 5);
			String NewBalence=uiDriver.th.getCellData("NEPOtherTransactions.tblDebit_2", 0, 6);
			if(NewBalence.contains(Debit)) {
				passed("SummatedAmount","SummatedAmountEqual should pass","SummatedAmountEqual passed");
			} else {
				failed("SummatedAmount","SummatedAmountEqual should pass","SummatedAmountNotEqual failed");
			}
		}
		SleepUtils.sleep(4);
		
		//42.Click on Finish button
		uiDriver.click("TC02_NEP_Debit_Adjustment.btnFinish");
		SleepUtils.sleep(10);
		
		//43.Click on OK button
		uiDriver.mouseOver("TC01_Validate_Newly_Added_Feat.btnOK");
		SleepUtils.sleep(2);
		uiDriver.click("TC01_Validate_Newly_Added_Feat.btnOK");
		SleepUtils.sleep(8);
		
		//44.verify the Actual and expected text
		uiDriver.verifyTextActAndExp("NEPOtherTransactions.eltDebitAdjustmentTransa", input.get("Verify@DebitAdjustment"));
			
		//45.Click on History element
		uiDriver.click("Accounts_View_History.eltHistory");
		SleepUtils.sleep(4);
		
		//46. Click and Type $data in Category field
		uiDriver.click("US1212_NewCrditDistribution.lstFilter_by_Type");
		SleepUtils.sleep(2);
		uiDriver.setValue("US1212_NewCrditDistribution.lstFilter_by_Type", input.get("Select@FilterBy_Type"));
		uiDriver.sendKey("enter");
		SleepUtils.sleep(2);
		
		//47.Verify the transaction history
		String SearchString="NEP Transaction totaling $"+input.get("Type@PaymentAmount") +"has been debited.";
		uiDriver.th.verfiygetCellDataOfColumn("Verify_Acc_Poli_History.tblDescription", SearchString, 1);
		SleepUtils.sleep(4);
		
		//48. Click on charges element
		uiDriver.click("HoldChar_History_AccLevlPoliLe.eltCharges");
		if (uiDriver.checkElementPresent("US882_NEPModifyDistri.eltNEP_Transaction")) {
			uiDriver.click("HoldChar_History_AccLevlPoliLe.eltCharges");
		}
		SleepUtils.sleep(10);
			
		//49. Click on charges element
		uiDriver.th.findRelativeCellAndClick("US882_NEPModifyDistri.eltNEP_Transaction", input.get("Select@Category"), 3, input.get("Select@Category"));
		SleepUtils.sleep(6);
		
		//50.verify the cell data
		uiDriver.th.verfiygetCellDataOfColumn("US882_NEPModifyDistri.eltNEP_Transaction", "General", 4);
		
		//51.verify the cell data
		String Amnt="$"+input.get("Type@PaymentAmount")+".00";
		uiDriver.th.verfiygetCellDataOfColumn("TC25_360DirectBill.tblCharges", Amnt, 10);
		
		//52. Click on Invoice element
		uiDriver.click("SubmitPolicy.Invoices");
		SleepUtils.sleep(6);
			
		//53. Sort invoice order
		uiDriver.click("NEPOtherTransactions.eltInvoiceDate");
		SleepUtils.sleep(2);
		uiDriver.click("TC03_Abilitytowaiveinstallment.btnInvoice_DateSort");
		SleepUtils.sleep(2);
		uiDriver.click("Producer_View_History.eltSortAscending");
		SleepUtils.sleep(2);
			
		//54. Click on charges element
		uiDriver.th.findRelativeCellAndClick("AbleTocreateAndviewThenewInvcs.tblId", "Planned", 7, "Planned");
		SleepUtils.sleep(2);
		
		//55.verify the cell data
		String Amnt1="$"+input.get("Type@PaymentAmount")+".00";
		uiDriver.th.verfiygetCellDataOfColumn("US882_NEPModifyDistri.tblStatus", Amnt1, 3);
		SleepUtils.sleep(2);
		
		//56.verify the cell data
		uiDriver.th.verfiygetCellDataOfColumn("US882_NEPModifyDistri.tblStatus", input.get("Select@Category"), 8);
		SleepUtils.sleep(2);

		//57.click on policy number
		uiDriver.th.findRelativeCellAndClickSelectedCellInlink("US882_NEPModifyDistri.tblStatus", Amnt1, 8, 2, Amnt1);
		SleepUtils.sleep(2);

		//58. Click on Policy level charges element
		uiDriver.click("TC01_NEPPmntRevviewEditAddNew.eltCharges");
		SleepUtils.sleep(2);
		
		//59. Click on charges element
		uiDriver.th.findRelativeCellAndClick("HoldChar_History_AccLevlPoliLe.chkCharges_Tble", input.get("Select@Category"), 3, input.get("Select@Category"));
		SleepUtils.sleep(2);

		//60.verify the cell data
		String Amnt2="$"+input.get("Type@PaymentAmount")+".00";
		uiDriver.th.verfiygetCellDataOfColumn("SRpermTomoveTheInvoiceitems.tblId", Amnt2, 10);
		SleepUtils.sleep(2);
		
		//61. Click on Activities element
		uiDriver.click("Validte_Acti_Acc_Poli_Prod_Lev.eltAcc_Activites");
		SleepUtils.sleep(6);
		
		//62. Click on Opened element
		uiDriver.click("NEPOtherTransactions.eltOpened");
		SleepUtils.sleep(6);
		uiDriver.click("NEPOtherTransactions.eltarrowActivites");
		SleepUtils.sleep(4);
		uiDriver.click("NEPOtherTransactions.eltSorDescending");
		SleepUtils.sleep(2);
		
		//63.Click on NEP - Commission Review link
		uiDriver.th.findRelativeCellAndClick("Validte_Acti_Acc_Poli_Prod_Lev.eltAcc_Subject", "NEP - Commission Review", 5, "NEP - Commission Review");
			
		//64. Click on Activities element
		uiDriver.click("TC03_NEPCommission_Activities.btnCancel");
		SleepUtils.sleep(6);
		
		//65. Click on Transactions element
		uiDriver.click("US882_NEPModifyDistri.eltTransactions");
		SleepUtils.sleep(6);
			
		//66. Click and Type $data in Category field
		uiDriver.click("NEPOtherTransactions.lstTransaction");
		SleepUtils.sleep(2);
		uiDriver.setValue("NEPOtherTransactions.lstTransaction", input.get("Select@ShowBy"));
		uiDriver.sendKey("enter");
		SleepUtils.sleep(4);
		
		//67. Sort the the transaction date wise
		uiDriver.click("Verfiy_Producer_History.eltDate");
		SleepUtils.sleep(2);
		uiDriver.click("NEPOtherTransactions.imageDesArrow");
		SleepUtils.sleep(2);
		uiDriver.click("NEPOtherTransactions.eltTransSortDescending");
		SleepUtils.sleep(2);
		
		//68.Verify the relative cell data existed or not
		String targettext="$"+input.get("Type@PaymentAmount")+".00";
		uiDriver.th.VerfiyRelativeCellData("US882_NEPModifyDistri.tblNEP_Transaction_Charged", input.get("Verfiy@Item"), 2, input.get("Verfiy@Item"), targettext);
		SleepUtils.sleep(4);	
		
	}
	
	public void NEP_Undistribute(DataRow input, DataRow output){
		
		//1. Click on Actions button
		uiDriver.click("CreateAccountShell_NEP.btnActions");
		SleepUtils.sleep(2);
			
		//2.Click on NEP web element
		uiDriver.mouseOver("CreatePolicyShell_NEP.eltNEP");
		SleepUtils.sleep(2);
			
		//3.Click on Debt Adjustment web element
		uiDriver.mouseOver("TC01_NEPPaymentreversal.eltDebit_Adjustment");
		SleepUtils.sleep(2);
		
		//4.Click on NEP web element
		uiDriver.click("NEPOtherTransactions.eltUndistribute");
		SleepUtils.sleep(2);
		
		//5.Verify the element is present
		uiDriver.verifyTextActAndExp("NEPOtherTransactions.eltHeaderDebitAdjustment", input.get("Verfiy@HeaderUndistribute"));
		
		//6.Verify the element is present
		if (uiDriver.checkElementPresent("NEPOtherTransactions.eltPolicyNumber")) {
			passed("checkElementNotPresent","checkElementNotPresent should pass","checkElementNotPresent passed");
		} else {
			failed("checkElementNotPresent","checkElementNotPresent should pass","checkElementisPresent failed");
		}
		
		//7.Verify the element is present
		if (uiDriver.checkElementPresent("NEPOtherTransactions.eltEffectiveDate")) {
			passed("checkElementNotPresent","checkElementNotPresent should pass","checkElementNotPresent passed");
		} else {
			failed("checkElementNotPresent","checkElementNotPresent should pass","checkElementisPresent failed");
		}
		
		//8.Verify the element is present
		if (uiDriver.checkElementPresent("NEPOtherTransactions.eltExpirationDate")) {
			passed("checkElementNotPresent","checkElementNotPresent should pass","checkElementNotPresent passed");
		} else {
			failed("checkElementNotPresent","checkElementNotPresent should pass","checkElementisPresent failed");
		}
		
		//9.Verify the element is present
		if (uiDriver.checkElementPresent("NEPOtherTransactions.eltPolicyStatus")) {
			passed("checkElementNotPresent","checkElementNotPresent should pass","checkElementNotPresent passed");
		} else {
			failed("checkElementNotPresent","checkElementNotPresent should pass","checkElementisPresent failed");
		}
		
		//10.Verify the element is present
		if (uiDriver.checkElementPresent("NEPOtherTransactions.eltCurrentBalance")) {
			passed("checkElementNotPresent","checkElementNotPresent should pass","checkElementNotPresent passed");
		} else {
			failed("checkElementNotPresent","checkElementNotPresent should pass","checkElementisPresent failed");
		}
		
		//11.Click on Next button
		uiDriver.click("TC01_NEPPmntRevviewEditAddNew.btnPmnt_Reversal_Next");
		SleepUtils.sleep(4);
		
		//12.Verify the element is present
		if (uiDriver.checkElementPresent("NEPOtherTransactions.eltPaymentReversal")) {
			passed("checkElementNotPresent","checkElementNotPresent should pass","checkElementNotPresent passed");
		} else {
			failed("checkElementNotPresent","checkElementNotPresent should pass","checkElementisPresent failed");
		}
			
		//13. Type $data in Role field
		uiDriver.setValue("NEPOtherTransactions.txtPaymentAmount", input.get("Type@PaymentAmount"));
		SleepUtils.sleep(2);
			
		//14.Click on date picker element
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		String tday = dateFormat.format(calendar.getTime());
		uiDriver.setValue("NEPOtherTransactions.eltDatePicker", tday);
		SleepUtils.sleep(4);
		
		//15. Verify the list values 
		uiDriver.click("NEPOtherTransactions.lstReason");
		boolean sflag=uiDriver.getElementNameUsingTag("li", "Bank Error");
		if(!sflag) {
			uiDriver.click("NEPOtherTransactions.lstReason");
		}
		SleepUtils.sleep(2);
		uiDriver.checkDropDownOptions("li", input.get("Verfiy@NEPReason"));
		SleepUtils.sleep(2);
		
		//16. Select $data from the Reason list
		uiDriver.setValue("NEPOtherTransactions.lstReason", input.get("Select@Reason"));
		uiDriver.sendKey("enter");
		SleepUtils.sleep(2);
		
		//17.Type $data in Policy field
		uiDriver.setValue("NEPOtherTransactions.txtPolicyStartsWith", input.get("Type@Policy"));
		SleepUtils.sleep(2);
		
		//18.Click on Go Button
		uiDriver.click("NEPOtherTransactions.btnGo");
		SleepUtils.sleep(4);

		//19.Click on Clear Button
		uiDriver.click("NEPOtherTransactions.btnClear");
		SleepUtils.sleep(4);
		
		//20.Click on Go Button
		uiDriver.click("NEPOtherTransactions.btnGo");
		SleepUtils.sleep(4);
		
		//21.Select check box Related policy in table
		String PolicyNum=input.get("Type@Policy")+"-000";
		uiDriver.th.findRelativeCellAndClickfirstCell("NEPOtherTransactions.tblPolicy", PolicyNum, 1, PolicyNum);
		SleepUtils.sleep(4);
		
		//22.Click on Next button
		uiDriver.click("TC01_NEPPmntRevviewEditAddNew.btnPmnt_Reversal_Next");
		SleepUtils.sleep(4);
		
		//23.Verify the element is  present
		if (uiDriver.checkElementPresent("NEPOtherTransactions.eltPaymentReversal")) {
			passed("checkElementNotPresent","checkElementNotPresent should pass","checkElementNotPresent passed");
		} else {
			failed("checkElementNotPresent","checkElementNotPresent should pass","checkElementisPresent failed");
		}
		
		//24.Click on NEP web element
		uiDriver.click("NEPOtherTransactions.btnSelectPolicies");
		SleepUtils.sleep(4);
		
		//25.Click on Next button
		String dropdownvalue=uiDriver.getControl("NEPOtherTransactions.lstReason").getAttribute("value");
		SleepUtils.sleep(2);
		if(dropdownvalue.equalsIgnoreCase("<none>")) {
			uiDriver.setValue("NEPOtherTransactions.lstReason", input.get("Select@Reason"));
		}
		uiDriver.click("TC01_NEPPmntRevviewEditAddNew.btnPmnt_Reversal_Next");
		SleepUtils.sleep(4);
		
		//26.verify the  selected policy presented in confirmation page
		String PolicyNumber=uiDriver.th.getCellData("NEPOtherTransactions.tblDebit_2", 0, 0);
		if(PolicyNumber.contains(PolicyNum)) {
			passed("CheckPolicy","BothPolicices are same should pass","PolicyPresent passed");
		} else {
			failed("CheckPolicy","BothPolicices are same should pass","PolicyNotPresent failed");
		}
			
		
		//27.Verify the element is present
		if (uiDriver.checkElementPresent("NEPOtherTransactions.eltPolicyNumber")) {
			passed("checkElementNotPresent","checkElementNotPresent should pass","checkElementNotPresent passed");
		} else {
			failed("checkElementNotPresent","checkElementNotPresent should pass","checkElementisPresent failed");
		}
		
		//28.Verify the element is present
		if (uiDriver.checkElementPresent("NEPOtherTransactions.eltEffectiveDate")) {
			passed("checkElementNotPresent","checkElementNotPresent should pass","checkElementNotPresent passed");
		} else {
			failed("checkElementNotPresent","checkElementNotPresent should pass","checkElementisPresent failed");
		}
		
		//29.Verify the element is present
		if (uiDriver.checkElementPresent("NEPOtherTransactions.eltExpirationDate")) {
			passed("checkElementNotPresent","checkElementNotPresent should pass","checkElementNotPresent passed");
		} else {
			failed("checkElementNotPresent","checkElementNotPresent should pass","checkElementisPresent failed");
		}
		
		//30.Verify the element is present
		if (uiDriver.checkElementPresent("NEPOtherTransactions.eltPolicyStatus")) {
			passed("checkElementNotPresent","checkElementNotPresent should pass","checkElementNotPresent passed");
		} else {
			failed("checkElementNotPresent","checkElementNotPresent should pass","checkElementisPresent failed");
		}
		
		//29.Verify the element is present
		if (uiDriver.checkElementPresent("NEPOtherTransactions.eltCurrentBalance")) {
			passed("checkElementNotPresent","checkElementNotPresent should pass","checkElementNotPresent passed");
		} else {
			failed("checkElementNotPresent","checkElementNotPresent should pass","checkElementisPresent failed");
		}
		
		//31.Verify the element is present
		if (uiDriver.checkElementPresent("NEPOtherTransactions.eltDebit")) {
			passed("checkElementNotPresent","checkElementNotPresent should pass","checkElementNotPresent passed");
		} else {
			failed("checkElementNotPresent","checkElementNotPresent should pass","checkElementisPresent failed");
		}
		
		//32.Verify the element is present
		if (uiDriver.checkElementPresent("NEPOtherTransactions.eltNewBalance")) {
			passed("checkElementNotPresent","checkElementNotPresent should pass","checkElementNotPresent passed");
		} else {
			failed("checkElementNotPresent","checkElementNotPresent should pass","checkElementisPresent failed");
		}
		
		//33.Click on Finish button
		uiDriver.click("TC02_NEP_Debit_Adjustment.btnFinish");
		SleepUtils.sleep(10);
		
		//34.Click on OK button
		uiDriver.mouseOver("TC01_Validate_Newly_Added_Feat.btnOK");
		SleepUtils.sleep(2);
		uiDriver.click("TC01_Validate_Newly_Added_Feat.btnOK");
		SleepUtils.sleep(10);
		
		//35.Verify the element is not present
		if (uiDriver.checkElementPresent("NEPOtherTransactions.eltNEPerror")) {
			passed("checkElementNotPresent","checkElementNotPresent should pass","checkElementNotPresent passed");
		} else {
			failed("checkElementNotPresent","checkElementNotPresent should pass","checkElementisPresent failed");
		}
		SleepUtils.sleep(4);
		uiDriver.click("NEPOtherTransactions.btnBack");
		SleepUtils.sleep(2);
		uiDriver.click("TC01_NEPPmntRevviewEditAddNew.btnPmnt_Reversal_Next");
		SleepUtils.sleep(2);

		//36. Click and Type $data in Debt field
		uiDriver.doubleclick("NEPOtherTransactions.tblDebit");
		SleepUtils.sleep(2);
		uiDriver.doubleclick("NEPOtherTransactions.tblDebit");
		SleepUtils.sleep(2);
		uiDriver.setValue("NEPOtherTransactions.tblDebit_1", input.get("Type@PaymentAmount"));
		SleepUtils.sleep(6);
		
		
		//37.Click on Add button
		uiDriver.click("NEPOtherTransactions.btnAdd");
		SleepUtils.sleep(4);
		
		//38. Verify the list values 
		uiDriver.click("NEPOtherTransactions.tblCategory");
		SleepUtils.sleep(2);
		boolean sFlag=uiDriver.getElementNameUsingTag("li", "NEP Idea Fee");
		if(!sFlag) {
			uiDriver.click("NEPOtherTransactions.tblCategory");
		}
		uiDriver.checkDropDownOptions("li", input.get("Verfiy@Category"));
		SleepUtils.sleep(2);
		
		
		//39. Click and Type $data in Category field
		//uiDriver.click("NEPOtherTransactions.tblCategory");
		SleepUtils.sleep(2);
		uiDriver.setValue("NEPOtherTransactions.tblCategory_1", input.get("Select@Category"));
		uiDriver.sendKey("enter");
		SleepUtils.sleep(2);
		
		//40. Click and Type $data in Amount field
		uiDriver.click("NEPOtherTransactions.txtAmount");
		SleepUtils.sleep(2);
		uiDriver.setValue("NEPOtherTransactions.txtAmount_1", input.get("Type@PaymentAmount"));
		uiDriver.sendKey("enter");
		SleepUtils.sleep(2);
		
		//41.Verify that the current balance column is summated on the Enter Debt Adjustment Details screen
		String currBalance=uiDriver.th.getCellData("NEPOtherTransactions.tblDebit_2", 0, 4);
		if(!currBalance.equals("-")) {
			String currBalance1=currBalance.substring(1, currBalance.length()-3);
			String Debit=uiDriver.th.getCellData("NEPOtherTransactions.tblDebit_2", 0, 5);
			String Debit1=Debit.substring(1, Debit.length()-3);
			int Sum=Integer.parseInt(currBalance1)+Integer.parseInt(Debit1);
			String NewBalence=uiDriver.th.getCellData("NEPOtherTransactions.tblDebit_2", 0, 6);
			String Sum1=Integer.toString(Sum);
			if(NewBalence.contains(Sum1)) {
				passed("SummatedAmount","SummatedAmountEqual should pass","SummatedAmountEqual passed");
			} else {
				failed("SummatedAmount","SummatedAmountEqual should pass","SummatedAmountNotEqual failed");
			}
		}
		if(currBalance.equals("-")) {
			String Debit=uiDriver.th.getCellData("NEPOtherTransactions.tblDebit_2", 0, 5);
			String NewBalence=uiDriver.th.getCellData("NEPOtherTransactions.tblDebit_2", 0, 6);
			if(NewBalence.contains(Debit)) {
				passed("SummatedAmount","SummatedAmountEqual should pass","SummatedAmountEqual passed");
			} else {
				failed("SummatedAmount","SummatedAmountEqual should pass","SummatedAmountNotEqual failed");
			}
		}
		SleepUtils.sleep(4);
		
		//42.Click on Finish button
		uiDriver.click("TC02_NEP_Debit_Adjustment.btnFinish");
		SleepUtils.sleep(10);
		
		//43.Click on OK button
		uiDriver.mouseOver("TC01_Validate_Newly_Added_Feat.btnOK");
		SleepUtils.sleep(2);
		uiDriver.click("TC01_Validate_Newly_Added_Feat.btnOK");
		SleepUtils.sleep(8);
		
		//44.verify the Actual and expected text
		uiDriver.verifyTextActAndExp("NEPOtherTransactions.eltDebitAdjustmentTransa", input.get("Verify@DebitAdjustment"));
			
		//45.Click on History element
		uiDriver.click("Accounts_View_History.eltHistory");
		SleepUtils.sleep(4);
		
		//46. Click and Type $data in Category field
		uiDriver.click("US1212_NewCrditDistribution.lstFilter_by_Type");
		SleepUtils.sleep(2);
		uiDriver.setValue("US1212_NewCrditDistribution.lstFilter_by_Type", input.get("Select@FilterBy_Type"));
		uiDriver.sendKey("enter");
		SleepUtils.sleep(2);
		
		//47.Verify the transaction history
		String SearchString="NEP Transaction totaling $"+input.get("Type@PaymentAmount") +"has been debited.";
		uiDriver.th.verfiygetCellDataOfColumn("Verify_Acc_Poli_History.tblDescription", SearchString, 1);
		SleepUtils.sleep(4);
		
		//48. Click on charges element
		uiDriver.click("HoldChar_History_AccLevlPoliLe.eltCharges");
		if (uiDriver.checkElementPresent("US882_NEPModifyDistri.eltNEP_Transaction")) {
			uiDriver.click("HoldChar_History_AccLevlPoliLe.eltCharges");
		}
		SleepUtils.sleep(10);
			
		//49. Click on charges element
		uiDriver.th.findRelativeCellAndClick("US882_NEPModifyDistri.eltNEP_Transaction", input.get("Select@Category"), 3, input.get("Select@Category"));
		SleepUtils.sleep(6);
		
		//50.verify the cell data
		uiDriver.th.verfiygetCellDataOfColumn("US882_NEPModifyDistri.eltNEP_Transaction", "General", 4);
		
		//51.verify the cell data
		String Amnt="$"+input.get("Type@PaymentAmount")+".00";
		uiDriver.th.verfiygetCellDataOfColumn("TC25_360DirectBill.tblCharges", Amnt, 10);
		
		//52. Click on Invoice element
		uiDriver.click("SubmitPolicy.Invoices");
		SleepUtils.sleep(6);
			
		//53. Sort invoice order
		uiDriver.click("NEPOtherTransactions.eltInvoiceDate");
		SleepUtils.sleep(2);
		uiDriver.click("TC03_Abilitytowaiveinstallment.btnInvoice_DateSort");
		SleepUtils.sleep(2);
		uiDriver.click("Producer_View_History.eltSortAscending");
		SleepUtils.sleep(2);
			
		//54. Click on charges element
		uiDriver.th.findRelativeCellAndClick("AbleTocreateAndviewThenewInvcs.tblId", "Planned", 7, "Planned");
		SleepUtils.sleep(2);
		
		//55.verify the cell data
		String Amnt1="$"+input.get("Type@PaymentAmount")+".00";
		uiDriver.th.verfiygetCellDataOfColumn("US882_NEPModifyDistri.tblStatus", Amnt1, 3);
		SleepUtils.sleep(2);
		
		//56.verify the cell data
		uiDriver.th.verfiygetCellDataOfColumn("US882_NEPModifyDistri.tblStatus", input.get("Select@Category"), 8);
		SleepUtils.sleep(2);

		//57.click on policy number
		uiDriver.th.findRelativeCellAndClickSelectedCellInlink("US882_NEPModifyDistri.tblStatus", Amnt1, 8, 2, Amnt1);
		SleepUtils.sleep(2);

		//58. Click on Policy level charges element
		uiDriver.click("TC01_NEPPmntRevviewEditAddNew.eltCharges");
		SleepUtils.sleep(2);
		
		//59. Click on charges element
		uiDriver.th.findRelativeCellAndClick("HoldChar_History_AccLevlPoliLe.chkCharges_Tble", input.get("Select@Category"), 3, input.get("Select@Category"));
		SleepUtils.sleep(2);

		//60.verify the cell data
		String Amnt2="$"+input.get("Type@PaymentAmount")+".00";
		uiDriver.th.verfiygetCellDataOfColumn("SRpermTomoveTheInvoiceitems.tblId", Amnt2, 10);
		SleepUtils.sleep(2);
		
		//61. Click on Activities element
		uiDriver.click("Validte_Acti_Acc_Poli_Prod_Lev.eltAcc_Activites");
		SleepUtils.sleep(6);
		
		//62. Click on Opened element
		uiDriver.click("NEPOtherTransactions.eltOpened");
		SleepUtils.sleep(6);
		uiDriver.click("NEPOtherTransactions.eltarrowActivites");
		SleepUtils.sleep(2);
		uiDriver.click("NEPOtherTransactions.eltSorDescending");
		SleepUtils.sleep(2);
		
		//63.Click on NEP - Commission Review link
		uiDriver.th.findRelativeCellAndClick("Validte_Acti_Acc_Poli_Prod_Lev.eltAcc_Subject", "NEP - Commission Review", 5, "NEP - Commission Review");
			
		//64. Click on Activities element
		uiDriver.click("TC03_NEPCommission_Activities.btnCancel");
		SleepUtils.sleep(6);
		
		//65. Click on Transactions element
		uiDriver.click("US882_NEPModifyDistri.eltTransactions");
		SleepUtils.sleep(6);
			
		//66. Click and Type $data in Category field
		uiDriver.click("NEPOtherTransactions.lstTransaction");
		SleepUtils.sleep(2);
		uiDriver.setValue("NEPOtherTransactions.lstTransaction", input.get("Select@ShowBy"));
		uiDriver.sendKey("enter");
		SleepUtils.sleep(4);
		
		//67. Sort the the transaction date wise
		uiDriver.click("Verfiy_Producer_History.eltDate");
		SleepUtils.sleep(6);
		uiDriver.click("NEPOtherTransactions.imageDesArrow");
		SleepUtils.sleep(6);
		uiDriver.click("NEPOtherTransactions.eltTransSortDescending");
		SleepUtils.sleep(2);
		
		//68.Verify the relative cell data existed or not
		String targettext="$"+input.get("Type@PaymentAmount")+".00";
		uiDriver.th.VerfiyRelativeCellData("US882_NEPModifyDistri.tblNEP_Transaction_Charged", input.get("Verfiy@Item"), 2, input.get("Verfiy@Item"), targettext);
		SleepUtils.sleep(4);	
		
	}

	/**
	 * Overriding toString() method of object class to print NEP format string
	 **/
	public String toString() {
		return "NEPOtherTransactions";
	}
}
