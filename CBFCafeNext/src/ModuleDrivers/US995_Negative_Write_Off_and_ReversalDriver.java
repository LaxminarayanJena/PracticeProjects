/******************************************************************************
Created by : CapGemini Automation Team
Created\Updated on : 3/2/2018 10:53:53 AM
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
public class US995_Negative_Write_Off_and_ReversalDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public US995_Negative_Write_Off_and_ReversalDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void Negative_Write_Off_Reversal(DataRow input, DataRow output) {
		
		//1. Read the value from Default_Unapplied field and store in $data variable
		SleepUtils.sleep(10);
		String amnt=uiDriver.getControl("Negative_Write_Off_Reversal.eltDefault_Unapplied").getText();
		String s=amnt.substring(0);
		if(amnt.equalsIgnoreCase("-") || s.equalsIgnoreCase("(")) {
			//1. Click on Desktop WebElement
			uiDriver.click("MakePaymentMulAccPoliProd.eltDesktop");
			
			//2. Click on Actions WebElement
			uiDriver.click("MakePaymentMulAccPoliProd.eltActions");
			
			//3. Click on Batch_Payment_Entry WebElement
			uiDriver.mouseOver("MakePaymentMulAccPoliProd.eltNewPayment");
			SleepUtils.sleep(3);
			uiDriver.click("MakePaymentMulAccPoliProd.eltBatch_Payment_Entry");
			
			//4. Type $data in Batch_Amount field
			uiDriver.setValue("MakePaymentMulAccPoliProd.txtBatch_Amount", input.get("Type@Batch_Amount"));
			SleepUtils.sleep(2);
			uiDriver.sendKey("tab");
			SleepUtils.sleep(5);
			
			//5. Select check box 
			uiDriver.click("MakePaymentMulAccPoliProd.lstPaymentInstrument");
			SleepUtils.sleep(2);
			uiDriver.sendKey("keysdown");
			SleepUtils.sleep(2);
			uiDriver.sendKey("enter");
			SleepUtils.sleep(2);
			
			//6. Select $data from the Type list
			uiDriver.doubleclick("MakePaymentMulAccPoliProd.eltdatepick");
			SleepUtils.sleep(2);
			uiDriver.sendKey("enter");
			
			//7. Select $data from the Type list
			uiDriver.click("TC02ModifyDistribution.lstPayment_Source");
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
			uiDriver.setValue("MakePaymentMulAccPoliProd.txtAmount1", input.get("Type@Batch_Amount"));
			
			
			//10. Type $data in Amount field
			uiDriver.click("MakePaymentMulAccPoliProd.eltaAccount");
			uiDriver.click("MakePaymentMulAccPoliProd.eltaAccount");
			SleepUtils.sleep(2);
			uiDriver.click("MakePaymentMulAccPoliProd.eltaAccountimag");
			SleepUtils.sleep(5);
			
			//11. Type $data in Amount field
			uiDriver.setValue("Validte_Acti_Acc_Poli_Prod_Lev.txtAccount_Name", input.get("Type@AccountName"));
			SleepUtils.sleep(2);
			
			//12. Type $data in Amount field
			uiDriver.click("Validte_Acti_Acc_Poli_Prod_Lev.btnSearch_Account");
			
			//13. Type $data in Amount field
			uiDriver.click("Validte_Acti_Acc_Poli_Prod_Lev.btnSelect");
			SleepUtils.sleep(6);
			
			//14. Click on Split button
			uiDriver.click("TC02ModifyDistribution.btnConfirm_Payment_Next");
			SleepUtils.sleep(2);
			if(uiDriver.checkElementPresent("TC02ModifyDistribution.eltErrorMsgPaymentSource")) {
				String Actual1=uiDriver.getControl("TC02ModifyDistribution.eltErrorMsgPaymentSource").getText();
				if(Actual1.equalsIgnoreCase("Payment Source : Missing required field \"Payment Source\"")){
					uiDriver.click("TC02ModifyDistribution.lstPayment_Source");
					SleepUtils.sleep(2);
					uiDriver.sendKey("keysdown");
					SleepUtils.sleep(2);
					uiDriver.sendKey("keysdown");
					SleepUtils.sleep(2);
					uiDriver.sendKey("enter");
					SleepUtils.sleep(2);	
				}
			}
			
			//15. Click on Split button
			uiDriver.click("TC02ModifyDistribution.btnPost_Batch");
			SleepUtils.sleep(6);
			
			//16. Click on Account_tab WebElement
			uiDriver.click("Account_Search.eltAccount");
			
			//17. Click on Account_tab WebElement
			uiDriver.click("Account_Search.txtAccount");
					
			//18. Type Account_Name $Parama1
			 uiDriver.setValue("Account_Search.txtAccountName", input.get("Type@AccountName"));
		
			//19. Click on Search button
			uiDriver.click("Account_Search.btnSearch");
			SleepUtils.sleep(5);
			
			//20. Select the account
			uiDriver.click("Account_Search.lnkAccount");
			SleepUtils.sleep(5);
		}
		
		//2. Click on Actions WebElement
		uiDriver.click("Negative_Write_Off_Reversal.eltActions");
		
		//3. Click on New_Transaction WebElement
		uiDriver.mouseOver("Negative_Write_Off_Reversal.eltNew_Transaction");
		SleepUtils.sleep(3);
		
		//4. Click on Negative_Write_Off WebElement
		uiDriver.click("Negative_Write_Off_Reversal.eltNegative_Write_Off");
		
		//5. Click on Next_ button
		uiDriver.click("Negative_Write_Off_Reversal.btnNext_");
		SleepUtils.sleep(6);
		
		//6. Click on Full_Amount WebElement
		uiDriver.click("Negative_Write_Off_Reversal.eltFull_Amount");
		SleepUtils.sleep(6);

		
		//7. Type $data in Amount field
		uiDriver.setValue("Negative_Write_Off_Reversal.txtAmount", input.get("Type@Amount"));
		SleepUtils.sleep(3);
		
		//8. Select $data from the Reason list
		uiDriver.click("Negative_Write_Off_Reversal.lstReason");
		SleepUtils.sleep(3);
		uiDriver.setValue("Negative_Write_Off_Reversal.lstReason", input.get("Select@Reason"));
		SleepUtils.sleep(2);
		uiDriver.sendKey("tab");
		SleepUtils.sleep(4);
		
		//9. Click on Next_ button
		uiDriver.click("Negative_Write_Off_Reversal.btnNext_1");
		SleepUtils.sleep(8);
		if(uiDriver.checkElementPresent("Negative_Write_Off_Reversal.eltReasonerrmsg")) {
			String Actual=uiDriver.getControl("Negative_Write_Off_Reversal.eltReasonerrmsg").getText();
			if(Actual.equalsIgnoreCase("Reason : Missing required field \"Reason\"")){
				uiDriver.click("Negative_Write_Off_Reversal.lstReason");
				SleepUtils.sleep(3);
				uiDriver.setValue("Negative_Write_Off_Reversal.lstReason", input.get("Select@Reason"));
				SleepUtils.sleep(2);
				uiDriver.sendKey("tab");
				SleepUtils.sleep(2);
				uiDriver.click("Negative_Write_Off_Reversal.btnNext_1");
			}
		}
		SleepUtils.sleep(2);
		
		//10. Click on Finish button
		uiDriver.click("Negative_Write_Off_Reversal.btnFinish");
		SleepUtils.sleep(3);
		
		//11. Click on History WebElement
		uiDriver.click("Negative_Write_Off_Reversal.eltHistory");
		SleepUtils.sleep(3);
		
		//12. Select $data from the Filter_by_Date list
		uiDriver.click("Negative_Write_Off_Reversal.lstFilter_by_Date");
		SleepUtils.sleep(3);
		uiDriver.setValue("Negative_Write_Off_Reversal.lstFilter_by_Date", input.get("Select@Filter_by_Date"));
		SleepUtils.sleep(1);
		uiDriver.sendKey("tab");
		SleepUtils.sleep(2);
		
		//13. Select $data from the Filter_by_Type list
		uiDriver.click("Negative_Write_Off_Reversal.lstFilter_by_Type");
		SleepUtils.sleep(3);
		uiDriver.setValue("Negative_Write_Off_Reversal.lstFilter_by_Type", input.get("Select@Filter_by_Type#1"));
		SleepUtils.sleep(1);
		uiDriver.sendKey("tab");
		SleepUtils.sleep(4);
		uiDriver.th.getCellDataOfCol("Negative_Write_Off_Reversal.tblHistory", input.get("Verify@Negtivewriteoff"), 1);
		SleepUtils.sleep(4);
		uiDriver.th.VerifyTextNotPresentInTable("Negative_Write_Off_Reversal.tblHistory", input.get("Verify@Negtivewriteoff_NotPresnet"), 1);
		
		//14. Click on Actions WebElement
		uiDriver.click("Negative_Write_Off_Reversal.eltActions");
		
		//15. Click on New_Transaction WebElement
		uiDriver.mouseOver("Negative_Write_Off_Reversal.eltNew_Transaction");
		SleepUtils.sleep(3);
		
		//16. Click on Negative_Write_Off_Reversal WebElement
		uiDriver.click("Negative_Write_Off_Reversal.eltNegative_Write_Off_Reversal");
		
		//17. Click on Search button
		uiDriver.click("Negative_Write_Off_Reversal.btnSearch");
		SleepUtils.sleep(2);
		
		//18. Verify whether the Select button is present
		if (uiDriver.checkElementPresent("Negative_Write_Off_Reversal.btnSelect")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		
		//19. Click on Select button
		uiDriver.click("Negative_Write_Off_Reversal.btnSelect");
		SleepUtils.sleep(2);
		
		//20. Click on Finish button
		uiDriver.click("Negative_Write_Off_Reversal.btnFinish1");
		SleepUtils.sleep(2);
		
		//21. Click on History WebElement
		uiDriver.click("Negative_Write_Off_Reversal.eltHistory");
		SleepUtils.sleep(2);
		
		//22. Select $data from the Filter_by_Date list
		uiDriver.click("Negative_Write_Off_Reversal.lstFilter_by_Date");
		SleepUtils.sleep(2);
		uiDriver.setValue("Negative_Write_Off_Reversal.lstFilter_by_Date", input.get("Select@Filter_by_Date"));
		SleepUtils.sleep(2);
		uiDriver.sendKey("tab");
		SleepUtils.sleep(4);
		
		//23. Select $data from the Filter_by_Type list
		uiDriver.click("Negative_Write_Off_Reversal.lstFilter_by_Type");
		SleepUtils.sleep(4);
		uiDriver.setValue("Negative_Write_Off_Reversal.lstFilter_by_Type", input.get("Select@Filter_by_Type#2"));
		SleepUtils.sleep(2);
		uiDriver.sendKey("tab");
		SleepUtils.sleep(4);
		uiDriver.th.getCellDataOfCol("Negative_Write_Off_Reversal.tblHistory", input.get("Verify@NegtiveReversal"), 1);
		SleepUtils.sleep(4);
		uiDriver.th.VerifyTextNotPresentInTable("Negative_Write_Off_Reversal.tblHistory", input.get("Verify@NegtiveReversal_NotPresnet"), 1);
	}
	
	public void Negative_Write_off_Rever_desk(DataRow input, DataRow output) {
		
		//1. Click on Desktop WebElement
		uiDriver.click("MakePaymentMulAccPoliProd.eltDesktop");
		
		//2. Click on Actions WebElement
		uiDriver.click("MakePaymentMulAccPoliProd.eltActions");
		
		//3. Click on Batch_Payment_Entry WebElement
		uiDriver.mouseOver("MakePaymentMulAccPoliProd.eltNewPayment");
		SleepUtils.sleep(3);
		uiDriver.click("MakePaymentMulAccPoliProd.eltBatch_Payment_Entry");
		
		//4. Type $data in Batch_Amount field
		uiDriver.setValue("MakePaymentMulAccPoliProd.txtBatch_Amount", input.get("Type@Batch_Amount"));
		SleepUtils.sleep(2);
		uiDriver.sendKey("tab");
		SleepUtils.sleep(5);
		
		//5. Select check box 
		uiDriver.click("MakePaymentMulAccPoliProd.lstPaymentInstrument");
		SleepUtils.sleep(2);
		uiDriver.sendKey("keysdown");
		SleepUtils.sleep(2);
		uiDriver.sendKey("enter");
		SleepUtils.sleep(2);
		
		//6. Select $data from the Type list
		uiDriver.doubleclick("MakePaymentMulAccPoliProd.eltdatepick");
		SleepUtils.sleep(2);
		uiDriver.sendKey("enter");
		
		//7. Select $data from the Type list
		uiDriver.doubleclick("TC02ModifyDistribution.lstPayment_Source");
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
		uiDriver.setValue("MakePaymentMulAccPoliProd.txtAmount1", input.get("Type@Batch_Amount"));
		
		
		//10. Type $data in Amount field
		uiDriver.click("MakePaymentMulAccPoliProd.eltaAccount");
		uiDriver.click("MakePaymentMulAccPoliProd.eltaAccount");
		SleepUtils.sleep(2);
		uiDriver.click("MakePaymentMulAccPoliProd.eltaAccountimag");
		SleepUtils.sleep(5);
		
		//11. Type $data in Amount field
		uiDriver.setValue("Validte_Acti_Acc_Poli_Prod_Lev.txtAccount_Name", input.get("Type@AccountName"));
		SleepUtils.sleep(2);
		
		//12. Type $data in Amount field
		uiDriver.click("Validte_Acti_Acc_Poli_Prod_Lev.btnSearch_Account");
		
		//13. Type $data in Amount field
		uiDriver.click("Validte_Acti_Acc_Poli_Prod_Lev.btnSelect");
		SleepUtils.sleep(6);
		
		//14. Click on Split button
		uiDriver.click("TC02ModifyDistribution.btnConfirm_Payment_Next");
		SleepUtils.sleep(6);
		if(uiDriver.checkElementPresent("TC02ModifyDistribution.eltErrorMsgPaymentSource")) {
			uiDriver.doubleclick("TC02ModifyDistribution.lstPayment_Source");
			SleepUtils.sleep(2);
			uiDriver.sendKey("keysdown");
			SleepUtils.sleep(2);
			uiDriver.sendKey("enter");
			SleepUtils.sleep(2);
		}
		SleepUtils.sleep(4);
		
		//15. Click on Split button
		uiDriver.click("TC02ModifyDistribution.btnPost_Batch");
		SleepUtils.sleep(6);

		
		//16. Click on Desktop WebElement
		uiDriver.click("Negative_Write_off_Rever_desk.eltDesktop");
		
		//17. Click on Actions WebElement
		uiDriver.click("Negative_Write_off_Rever_desk.eltActions");
		
		//18. Click on NewTransaction WebElement
		uiDriver.mouseOver("Negative_Write_off_Rever_desk.eltNewTransaction");
		SleepUtils.sleep(3);
		
		//19. Click on Negative_Write_Off WebElement
		uiDriver.click("Negative_Write_off_Rever_desk.eltNegative_Write_Off");
		SleepUtils.sleep(3);
		
		//20. Verify the text ?$data in the Dsk_Msg field
		if (uiDriver.verifyTextActAndExp("Negative_Write_off_Rever_desk.eltDsk_Msg", input.get("VerifyText@Dsk_Msg"))) {
			passed("verifyText","verifyText should pass","verifyText passed");
		} else {
			failed("verifyText","verifyText should pass","verifyText failed");
		}
		
		//21. Type $data in Account_Name field
		uiDriver.setValue("Negative_Write_off_Rever_desk.txtAccount_Name", input.get("Type@Account_Name"));
		
		//22. Click on Search button
		uiDriver.click("Negative_Write_off_Rever_desk.btnSearch");
		
		//23. Verify whether the Select button is present
		if (uiDriver.checkElementPresent("Negative_Write_off_Rever_desk.btnSelect")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		
		//24. Click on Select button
		uiDriver.click("Negative_Write_off_Rever_desk.btnSelect");
		
		//25. Click on Full_Amount WebElement
		uiDriver.click("Negative_Write_off_Rever_desk.eltFull_Amount");
		SleepUtils.sleep(3);
		
		//26. Type $data in Amount field
		uiDriver.setValue("Negative_Write_off_Rever_desk.txtAmount", input.get("Type@Amount"));
		
		//27. Select $data from the Reason list
		uiDriver.click("Negative_Write_off_Rever_desk.lstReason");
		SleepUtils.sleep(2);
		uiDriver.setValue("Negative_Write_off_Rever_desk.lstReason", input.get("Select@Reason"));
		SleepUtils.sleep(2);
		uiDriver.sendKey("tab");
		SleepUtils.sleep(1);
		uiDriver.click("Negative_Write_off_Rever_desk.btnNext");
		SleepUtils.sleep(2);
		
		
		//28. Verify Default
		String Actualvalue=uiDriver.getControl("Negative_Write_off_Rever_desk.eltDefault").getText();
		if(!Actualvalue.contains("Default")) {
			passed("verifyText","verifyText should pass","verifyText passed");
		} else {
			failed("verifyText","verifyText should pass","verifyText failed");
			
		}
		
		//29. Click on Finish button
		uiDriver.click("Negative_Write_off_Rever_desk.btnFinish");
		
		//30. Click on Actions WebElement
		uiDriver.click("Negative_Write_off_Rever_desk.eltActions");
		
		//31. Click on NewTransaction WebElement
		uiDriver.mouseOver("Negative_Write_off_Rever_desk.eltNewTransaction");
		SleepUtils.sleep(3);
		
		//32. Click on Negative_Write_Off_Reversal WebElement
		uiDriver.click("Negative_Write_off_Rever_desk.eltNegative_Write_Off_Reversal");
		SleepUtils.sleep(3);
		
		//33. Verify the text ?$data in the Negative_Wirte_Off_Rever_msg field
		if (uiDriver.verifyTextActAndExp("Negative_Write_off_Rever_desk.eltNegative_Wirte_Off_Rever_msg", input.get("VerifyText@Negative_Wirte_Off_Rever_msg"))) {
			passed("verifyText","verifyText should pass","verifyText passed");
		} else {
			failed("verifyText","verifyText should pass","verifyText failed");
		}
		
		//34. Verify the text ?$data in the Account_ field
		if (uiDriver.verifyTextActAndExp("Negative_Write_off_Rever_desk.eltAccount_", input.get("VerifyText@Account_"))) {
			passed("verifyText","verifyText should pass","verifyText passed");
		} else {
			failed("verifyText","verifyText should pass","verifyText failed");
		}
		SleepUtils.sleep(2);
		
		//35. Click on Search button
		uiDriver.click("Negative_Write_off_Rever_desk.btnSearch1");
		SleepUtils.sleep(2);
		
		//36. Verify the text ?$data in the Negative_Wirte_Off_Rever_msg1 field
		if (uiDriver.verifyTextActAndExp("Negative_Write_off_Rever_desk.eltNegative_Wirte_Off_Rever_msg1", input.get("VerifyText@Negative_Wirte_Off_Rever_msg1"))) {
			passed("verifyText","verifyText should pass","verifyText passed");
		} else {
			failed("verifyText","verifyText should pass","verifyText failed");
		}
		SleepUtils.sleep(4);
		
		//37. Verify the unapplied fund test
		if (!uiDriver.checkElementPresent("Negative_Write_off_Rever_desk.eltUnappliedfund")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		
	}
	
	public void Not_Have_Negat_WriteOff_Rever(DataRow input, DataRow output) {
		
		//1. Click on Desktop WebElement
		uiDriver.click("MakePaymentMulAccPoliProd.eltDesktop");
		
		//2. Click on Actions WebElement
		uiDriver.click("Negative_Write_off_Rever_desk.eltActions");
		
		//3. Click on NewTransaction WebElement
		uiDriver.mouseOver("Negative_Write_off_Rever_desk.eltNewTransaction");
		SleepUtils.sleep(3);
		
		//4. Click on Negative_Write_Off WebElement
		if (!uiDriver.checkElementPresent("Negative_Write_off_Rever_desk.eltNegative_Write_Off")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		
		//5. Click on Negative_Write_Off_Reversal WebElement
		if (!uiDriver.checkElementPresent("Negative_Write_off_Rever_desk.eltNegative_Write_Off_Reversal")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
	}

	/**
	*Overriding toString() method of object class to print US995_Negative_Write_Off_and_Reversal
	*format string
	**/
	public String toString(){
		return "US995_Negative_Write_Off_and_ReversalDriver";
	}
}
