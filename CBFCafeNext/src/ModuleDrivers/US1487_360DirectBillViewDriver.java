/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 5/3/2018 2:34:41 AM
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
public class US1487_360DirectBillViewDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public US1487_360DirectBillViewDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void TC01_360DirectBill(DataRow input, DataRow output) {
		//1. Click on 360_Direct_Bill_View WebElement
		uiDriver.click("TC01_360DirectBill.elt360_Direct_Bill_View");
		SleepUtils.sleep(4);
		
		//2. Verify whether the Balance_Summary element present
		if (uiDriver.checkElementPresent("TC01_360DirectBill.eltBalance_Summary")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(4);
		
		//3. Verify whether the Policy element present
		if (uiDriver.checkElementPresent("TC01_360DirectBill.eltPolicy")) {	
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(4);
		
		//4. Verify whether the Search button is present
		if (uiDriver.checkElementPresent("TC01_360DirectBill.btnSearch")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(4);
		
		//5. Verify whether the Policy_Period element present
		if (uiDriver.checkElementPresent("TC01_360DirectBill.eltPolicy_Period")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(4);
		
		//6. Verify whether the Search_1 button is present
		if (uiDriver.checkElementPresent("TC01_360DirectBill.btnSearch_1")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(4);
		
		//7. Verify whether the Print_Export button is present
		if (uiDriver.checkElementPresent("TC01_360DirectBill.btnPrint_Export")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(4);
		
		//8. Verify whether the Add_Balance_Tran_test_ button is present
		if (uiDriver.checkElementPresent("TC01_360DirectBill.btnAdd_Balance_Tran_test_")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(4);
		
		//9. Verify whether the Transaction_Date element present
		if (uiDriver.checkElementPresent("TC01_360DirectBill.eltTransaction_Date")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(4);
		
		//10. Verify whether the Effective_Date element present
		if (uiDriver.checkElementPresent("TC01_360DirectBill.eltEffective_Date")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(4);
		
		//11. Verify whether the Policy_Number link is present
		if (uiDriver.checkElementPresent("TC01_360DirectBill.lnkPolicy_Number")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(4);
		
		//12. Verify whether the Product element present
		if (uiDriver.checkElementPresent("TC01_360DirectBill.eltProduct")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(4);
		
		//13. Verify whether the Jurisdiction element present
		if (uiDriver.checkElementPresent("TC01_360DirectBill.eltJurisdiction")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(4);
		
		//14. Verify whether the Description link is present
		if (uiDriver.checkElementPresent("TC01_360DirectBill.lnkDescription")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(4);
		
		//15. Verify whether the Amount link is present
		if (uiDriver.checkElementPresent("TC01_360DirectBill.lnkAmount")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(4);
		
		//16. Verify whether the Billed_Due_Balance element present
		if (uiDriver.checkElementPresent("TC01_360DirectBill.eltBilled_Due_Balance")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(4);
		
		//17. Verify whether the Total_Balance element present
		if (uiDriver.checkElementPresent("TC01_360DirectBill.eltTotal_Balance")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(4);
		
		//18. Click on Details WebElement
		uiDriver.click("TC01_360DirectBill.eltDetails");
		SleepUtils.sleep(4);
		
		//19. Click on Policy_Number_1 Link
		uiDriver.click("TC01_360DirectBill.lnkPolicy_Number_1");
		SleepUtils.sleep(4);
		
		//20. Click on 360_Direct_Bill_View_1 WebElement
		uiDriver.click("TC01_360DirectBill.elt360_Direct_Bill_View_1");
		SleepUtils.sleep(4);
		
		//21. Verify whether the Balance_Summary_1 element present
		if (uiDriver.checkElementPresent("TC01_360DirectBill.eltBalance_Summary_1")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(4);
		
		//22. Verify whether the Policy_Period_1 element present
		if (uiDriver.checkElementPresent("TC01_360DirectBill.eltPolicy_Period_1")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(4);
		
		//23. Verify whether the Search_2 button is present
		if (uiDriver.checkElementPresent("TC01_360DirectBill.btnSearch_2")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(4);
		
		//24. Verify whether the Print_Export_1 button is present
		if (uiDriver.checkElementPresent("TC01_360DirectBill.btnPrint_Export_1")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(4);
		
		//25. Verify whether the Add_Balance_Tran_test_1 button is present
		if (uiDriver.checkElementPresent("TC01_360DirectBill.btnAdd_Balance_Tran_test_1")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(4);
		
		//26. Verify whether the Transaction_Date_1 element present
		if (uiDriver.checkElementPresent("TC01_360DirectBill.eltTransaction_Date_1")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(4);
		
		//27. Verify whether the Effective_Date_1 element present
		if (uiDriver.checkElementPresent("TC01_360DirectBill.eltEffective_Date_1")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(4);
		
		//28. Verify whether the Policy_Number_2 link is present
		if (uiDriver.checkElementPresent("TC01_360DirectBill.lnkPolicy_Number_2")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(4);
		
		//29. Verify whether the Product_1 element present
		if (uiDriver.checkElementPresent("TC01_360DirectBill.eltProduct_1")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(4);
		
		//30. Verify whether the Jurisdiction_1 element present
		if (uiDriver.checkElementPresent("TC01_360DirectBill.eltJurisdiction_1")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(4);
		
		//31. Verify whether the Description_1 link is present
		if (uiDriver.checkElementPresent("TC01_360DirectBill.lnkDescription_1")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(4);
		
		//32. Verify whether the Amount_1 link is present
		if (uiDriver.checkElementPresent("TC01_360DirectBill.lnkAmount_1")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(4);
		
		//33. Verify whether the Billed_Due_Balance_1 element present
		if (uiDriver.checkElementPresent("TC01_360DirectBill.eltBilled_Due_Balance_1")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(4);
		
		//34. Verify whether the Total_Balance_1 element present
		if (uiDriver.checkElementPresent("TC01_360DirectBill.eltTotal_Balance_1")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(4);
	}
	public void TC06_360DirectBill(DataRow input, DataRow output) {
		//1.Click on the Invoices Web Element
		uiDriver.click("TC06_360DirectBill.eltInvoices");
		SleepUtils.sleep(5);
		
		//2.Click on Overview Web Element 
		uiDriver.click("TC06_360DirectBill.eltOverview");
		SleepUtils.sleep(5);
		
		//3.Click on 360_Direct_Bill_View WebElement
		uiDriver.click("TC06_360DirectBill.elt360_Direct_Bill_View");
		SleepUtils.sleep(5);
		
		//4. Click on HotKeys
		uiDriver.HotKeys("T");
	    SleepUtils.sleep(6);
	    uiDriver.th.findRelativeCellAndClickSelectedCellInSubtext("TC06_360DirectBill.tblInvoicebatch","Invoice", 0 ,"Invoice","RunStopDownload History","Run");
     	SleepUtils.sleep(6);
     	
        //5.Click on Actions button
     	uiDriver.click("TC06_360DirectBill.btnActions_1");
     	SleepUtils.sleep(5);

     	//6. Click on Return to BillingCenter WebElement
     	uiDriver.click("TC06_360DirectBill.eltReturn to BillingCenter");
     	SleepUtils.sleep(5);
     	
	}
	
	public void TC07_360DirectBill(DataRow input, DataRow output) {

		//1.Click on Overview Web Element 
		uiDriver.click("TC07_360DirectBill.eltOverview");
		SleepUtils.sleep(4);
		
		//2.Click on 360_Direct_Bill_View WebElement
		uiDriver.click("TC07_360DirectBill.elt360_Direct_Bill_View");
		SleepUtils.sleep(5);
		
		//3. Click on policy WebElement
		uiDriver.click("TC07_360DirectBill.eltpolicy");
		SleepUtils.sleep(4);

		//4. Type $data in Policy_ field
		uiDriver.setValue("TC07_360DirectBill.txtPolicy_", input.get("Type@Policy_"));
		SleepUtils.sleep(4);

		//5. Click on Search button
		uiDriver.click("TC07_360DirectBill.btnSearch");
		SleepUtils.sleep(4);

		//6. Verify whether the Policy_1 link is present
		if (uiDriver.checkElementPresent("TC07_360DirectBill.lnkPolicy_1")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(4);

		//7. Click on Policy_2 Link
		uiDriver.click("TC07_360DirectBill.lnkPolicy_2");
		SleepUtils.sleep(3);

		//8. Click on 360_Direct_Bill_View WebElement
		uiDriver.click("TC08_360DirectBill.elt360_Direct_Bill_View");
		SleepUtils.sleep(4);

		//9. Type $data in Policy_Period field
		uiDriver.setValue("TC07_360DirectBill.txtPolicy_Period", input.get("Type@Policy_Period"));
		SleepUtils.sleep(4);

		//10. Click on Search_1 button
		uiDriver.click("TC07_360DirectBill.btnSearch_1");
		SleepUtils.sleep(4);
	}
	public void TC08_360DirectBill(DataRow input, DataRow output) {
		//1. Click on policy WebElement
		uiDriver.click("TC08_360DirectBill.eltpolicy");
		SleepUtils.sleep(4);
		
		//2. Type $data in Policy_ field
		uiDriver.setValue("TC08_360DirectBill.txtPolicy_", input.get("Type@Policy_"));
		SleepUtils.sleep(4);
			
		//3. Click on Search button
		uiDriver.click("TC08_360DirectBill.btnSearch");
		SleepUtils.sleep(4);
		
		//4. Verify whether the Policy_1 link is present
		if (uiDriver.checkElementPresent("TC08_360DirectBill.lnkPolicy_1")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(4);
		
		//5. Click on Policy_2 Link
		uiDriver.click("TC08_360DirectBill.lnkPolicy_2");
		SleepUtils.sleep(4);
		
		//6. Click on 360_Direct_Bill_View WebElement
		uiDriver.click("TC08_360DirectBill.elt360_Direct_Bill_View");
		SleepUtils.sleep(4);
		
		//7. Type $data in Policy_Period field
		uiDriver.setValue("TC08_360DirectBill.txtPolicy_Period", input.get("Type@Policy_Period"));
		SleepUtils.sleep(4);
		
		//8. Click on Search_1 button
		uiDriver.click("TC08_360DirectBill.btnSearch_1");
		SleepUtils.sleep(4);
	}
	
	public void TC09_360DirectBill(DataRow input, DataRow output) {
		//1. Click on Summary WebElement
		uiDriver.click("TC09_360DirectBill.eltSummary");
		SleepUtils.sleep(4);
		
		//2. Click on 360_Direct_Bill_View WebElement
		uiDriver.click("TC09_360DirectBill.elt360_Direct_Bill_View");
		SleepUtils.sleep(4);
		
		//3. Type $data in Policy field
		uiDriver.setValue("TC09_360DirectBill.txtPolicy", input.get("Type@Policy"));
		SleepUtils.sleep(4);
		
		//4. Click on Search button
		uiDriver.click("TC09_360DirectBill.btnSearch");
		SleepUtils.sleep(4);
		
		//5. Type $data in Policy_Period field
		uiDriver.setValue("TC09_360DirectBill.txtPolicy_Period", input.get("Type@Policy_Period"));
		SleepUtils.sleep(4);
		
		//6. Click on Search_1 button
		uiDriver.click("TC09_360DirectBill.btnSearch_1");
		SleepUtils.sleep(4);
	}
	
	public void TC11_360DirectBill(DataRow input, DataRow output) {
		//1. Click on Details WebElement
		uiDriver.click("TC11_360DirectBill.eltDetails");
		SleepUtils.sleep(4);
		
		//2. Click on Actions button
		uiDriver.th.findRelativeCellAndClickSelectedCellInSubtext("TC11_360DirectBill.tblPayments", "Actions", 0, "Actions", "Actions", "Actions");
		SleepUtils.sleep(4);
	
		//3. Click on Reverse WebElement
		uiDriver.click("TC11_360DirectBill.eltReverse");
		SleepUtils.sleep(4);
		
		//4. Click Reason
		uiDriver.click("TC11_360DirectBill.txtReason");
		SleepUtils.sleep(4);
		
		//5. Select $data from the Reason list
		uiDriver.setValue("TC11_360DirectBill.lstReason", input.get("Select@Reason"));
		SleepUtils.sleep(4);
		
		//6. Click on Ok button
		uiDriver.click("TC11_360DirectBill.btnOk");
		SleepUtils.sleep(4);
		
		//7. Click on 360_Direct_Bill_View WebElement
		uiDriver.click("TC11_360DirectBill.elt360_Direct_Bill_View");
		SleepUtils.sleep(4);
		
		//8. Type $data in Policy field
		uiDriver.setValue("TC11_360DirectBill.txtPolicy", input.get("Type@Policy"));
		SleepUtils.sleep(4);
		
		//9. Click on Search button
		uiDriver.click("TC11_360DirectBill.btnSearch");
		SleepUtils.sleep(4);
		
	}
	
	public void TC12_360DirectBill(DataRow input, DataRow output) {
		
		//1. Click on 360_Direct_Bill_View WebElement
		uiDriver.click("TC14_360DirectBill.elt360_Direct_Bill_View");
		SleepUtils.sleep(4);
		
		//2. Click on Actions WebElement
		SleepUtils.sleep(3);
		uiDriver.click("TC05_DirBillPmnt_NewDirtCredit.eltActions");

		//3. Click on New_Transaction WebElement
		uiDriver.mouseOver("TC05_DirBillPmnt_NewDirtCredit.eltNew_Transaction");
		SleepUtils.sleep(3);
		
		//4. Click on Credit WebElement
		SleepUtils.sleep(2);
		uiDriver.click("TC05_DirBillPmnt_NewDirtCredit.eltCredit");
		SleepUtils.sleep(3);
		
		//5. Select $data from the Credit_Type list
		uiDriver.click("TC05_DirBillPmnt_NewDirtCredit.lstCredit_Type");
		SleepUtils.sleep(2);
		uiDriver.setValue("TC05_DirBillPmnt_NewDirtCredit.lstCredit_Type", input.get("Select@Credit_Type"));
		uiDriver.sendKey("tab");

		//6. Type $data in Amount field
		uiDriver.setValue("TC05_DirBillPmnt_NewDirtCredit.txtAmount", input.get("Type@Amount"));
		SleepUtils.sleep(3);
		
		//7. Click on Next button
		uiDriver.click("TC05_DirBillPmnt_NewDirtCredit.btnNext");
		SleepUtils.sleep(3);
		
		//8. Click on Finish button
		uiDriver.click("TC05_DirBillPmnt_NewDirtCredit.btnFinish");
		SleepUtils.sleep(3);
		
		//9. Click on Actions WebElement
		uiDriver.click("TC05_DirBillPmnt_NewDirtCredit.eltActions");
		SleepUtils.sleep(3);
		
		//10. Click on New_Payment WebElement
		SleepUtils.sleep(2);
		uiDriver.mouseOver("TC05_DirBillPmnt_NewDirtCredit.eltNew_Payment");

		//11. Click on New_Credit_Distribution WebElement
		SleepUtils.sleep(2);
		uiDriver.click("TC05_DirBillPmnt_NewDirtCredit.eltNew_Credit_Distribution");

		//12. Select the Use_Unapplied_Credit_Amount ?checkbox
		SleepUtils.sleep(2);
		uiDriver.click("TC05_DirBillPmnt_NewDirtCredit.chkUse_Unapplied_Credit_Amount");
		SleepUtils.sleep(3);
		
		//13. Click on Override_Distribution button
		uiDriver.click("TC05_DirBillPmnt_NewDirtCredit.btnOverride_Distribution");
		SleepUtils.sleep(3);
		//14. Select $data from the Select_Items_where_the list
		uiDriver.click("TC05_DirBillPmnt_NewDirtCredit.lstSelect_Items_where_the");
		SleepUtils.sleep(2);
		uiDriver.setValue("TC05_DirBillPmnt_NewDirtCredit.lstSelect_Items_where_the", input.get("Select@Select_Items_where_the"));
		SleepUtils.sleep(1);
		uiDriver.sendKey("tab");
        SleepUtils.sleep(4);
        
		//15. Type $data in Override_Amount field
		uiDriver.click("TC05_DirBillPmnt_NewDirtCredit.txtOverride_Amount");
		SleepUtils.sleep(4);
		uiDriver.setValue("TC05_DirBillPmnt_NewDirtCredit.txtOverride_Amount1", input.get("Type@Override_Amount"));

		//16. Click on Execute button
		uiDriver.click("TC05_DirBillPmnt_NewDirtCredit.btnExecute");
		
	}
	
	public void TC13_360DirectBill(DataRow input, DataRow output) {
		
		//1. Click on 360_Direct_Bill_View WebElement
		uiDriver.click("TC14_360DirectBill.elt360_Direct_Bill_View");
		SleepUtils.sleep(4);
				
		//2. Click on Policy WebElement
		uiDriver.click("TC16_360DirectBill.eltPolicy");
		SleepUtils.sleep(4);

		//3. Type $data in Policy_ field
		uiDriver.setValue("TC16_360DirectBill.txtPolicy_", input.get("Type@Policy_"));
		SleepUtils.sleep(4);

		//4. Click on Search button
		uiDriver.click("TC16_360DirectBill.btnSearch");
		SleepUtils.sleep(4);

		//5. Verify whether the Policy_1 link is present
		if (uiDriver.checkElementPresent("TC16_360DirectBill.lnkPolicy_1")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(4);

		//6. Click on Policy_2 image
		uiDriver.click("TC16_360DirectBill.lnkPolicy_2");
		SleepUtils.sleep(4);

		//7. Click on 360_Direct_Bill_View WebElement
		uiDriver.click("TC16_360DirectBill.elt360_Direct_Bill_View");
		SleepUtils.sleep(6);
	}
			
	
	public void TC14_360DirectBill(DataRow input, DataRow output) {
		//1. Click on 360_Direct_Bill_View WebElement
		SleepUtils.sleep(4);
		uiDriver.click("TC14_360DirectBill.elt360_Direct_Bill_View");
		SleepUtils.sleep(4);
		
		//2. Click on Actions button
		uiDriver.click("TC14_360DirectBill.btnActions");
		SleepUtils.sleep(4);
		
		//3. Click on New_Transaction WebElement
		uiDriver.click("TC14_360DirectBill.eltNew_Transaction");
		SleepUtils.sleep(4);
		
		//4. Click on Write_Off WebElement
		uiDriver.click("TC14_360DirectBill.eltWrite_Off");
		SleepUtils.sleep(4);
		
		//5. Verify whether the Select button is present
		if (uiDriver.checkElementPresent("TC14_360DirectBill.btnSelect")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(4);
		
		//6. Click on Select_ button
		uiDriver.th.findRelativeCellAndClickfirstCell("TC14_360DirectBill.tblWriteoffWizard","PHUB626078", 1, "PHUB626078");
		
		//uiDriver.click("TC14_360DirectBill.btnSelect_");
		SleepUtils.sleep(4);
		
		//7. Click on Next button
		uiDriver.click("TC14_360DirectBill.btnNext");
		SleepUtils.sleep(4);
		
		//8. Type $data in Amount field
		uiDriver.setValue("TC14_360DirectBill.txtAmount", input.get("Type@Amount"));
		SleepUtils.sleep(4);
		
		//9. Click Reason
		uiDriver.click("TC14_360DirectBill.txtReason");
		SleepUtils.sleep(4);
		
		//10. Select $data from the Reason list
		uiDriver.setValue("TC14_360DirectBill.lstReason", input.get("Select@Reason"));
		SleepUtils.sleep(4);
		
		//11. Click on Next_1 button
		uiDriver.click("TC14_360DirectBill.btnNext_1");
		SleepUtils.sleep(4);
		
		//12. Click on Finish button
		uiDriver.click("TC14_360DirectBill.btnFinish");
		SleepUtils.sleep(8);
		
		//13. Click on 360_Direct_Bill_View_1 WebElement
		uiDriver.click("TC14_360DirectBill.elt360_Direct_Bill_View_1");
		SleepUtils.sleep(8);
		
	}
	
	public void TC15_360DirectBill(DataRow input, DataRow output) {
		//1. Click on Summary WebElement
		uiDriver.click("TC15_360DirectBill.eltSummary");
		SleepUtils.sleep(4);
		
		//2. Click on 360_Direct_Bill_View WebElement
		uiDriver.click("TC15_360DirectBill.elt360_Direct_Bill_View");
		SleepUtils.sleep(4);
		
		//3. Click on Actions button
		uiDriver.click("TC15_360DirectBill.btnActions");
		SleepUtils.sleep(4);
		
		//4. Click on New_Transaction WebElement
		uiDriver.click("TC15_360DirectBill.eltNew_Transaction");
		SleepUtils.sleep(4);
		
		//5. Click on Write_Off_Reversal WebElement
		uiDriver.click("TC15_360DirectBill.eltWrite_Off_Reversal");
		SleepUtils.sleep(4);
		
		//6. Click Reason
		uiDriver.click("TC15_360DirectBill.txtReason");
		SleepUtils.sleep(4);
		
		//7. Select $data from the Reason list
		uiDriver.setValue("TC15_360DirectBill.lstReason", input.get("Select@Reason"));
		SleepUtils.sleep(4);
		
		//8. Click on Search button
		uiDriver.click("TC15_360DirectBill.btnSearch");
		SleepUtils.sleep(6);
		
		//9. Verify whether the Select button is present
		if (uiDriver.checkElementPresent("TC15_360DirectBill.btnSelect")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(7);
		
		//10. Click on Select_ button
		uiDriver.click("TC15_360DirectBill.btnSelect_");
		SleepUtils.sleep(4);
		
		//11. Click Reason_1
		uiDriver.click("TC15_360DirectBill.txtReason_1");
		SleepUtils.sleep(4);
		
		//12. Select $data from the Reason_2 list
		uiDriver.setValue("TC15_360DirectBill.lstReason_2", input.get("Select@Reason_2"));
		SleepUtils.sleep(4);
		
		//13. Click on Finish button
		uiDriver.click("TC15_360DirectBill.btnFinish");
		SleepUtils.sleep(4);
		
		//14. Click on 360_Direct_Bill_View_1 WebElement
		uiDriver.click("TC15_360DirectBill.elt360_Direct_Bill_View_1");
		
	}
	
	public void TC16_360DirectBill(DataRow input, DataRow output) {
		//1. Click on Policy WebElement
		uiDriver.click("TC16_360DirectBill.eltPolicy");
		SleepUtils.sleep(4);
		
		//2. Type $data in Policy_ field
		uiDriver.setValue("TC16_360DirectBill.txtPolicy_", input.get("Type@Policy_"));
		SleepUtils.sleep(4);
		
		//3. Click on Search button
		uiDriver.click("TC16_360DirectBill.btnSearch");
		SleepUtils.sleep(4);
		
		//4. Verify whether the Policy_1 link is present
		if (uiDriver.checkElementPresent("TC16_360DirectBill.lnkPolicy_1")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(4);
		
		//5. Click on Policy_2 image
		uiDriver.click("TC16_360DirectBill.lnkPolicy_2");
		SleepUtils.sleep(4);
		
		//6. Click on 360_Direct_Bill_View WebElement
		uiDriver.click("TC16_360DirectBill.elt360_Direct_Bill_View");
		SleepUtils.sleep(4);
	}
	
	public void TC21_360DirectBill(DataRow input, DataRow output) {
		//1. Click on 360_Direct_Bill_View WebElement
		uiDriver.click("TC21_360DirectBill.elt360_Direct_Bill_View");
		SleepUtils.sleep(4);
		
		//2. Click on policies WebElement
		uiDriver.click("TC21_360DirectBill.eltpolicies");
		SleepUtils.sleep(4);
		
		//3. Click on policy Link
		uiDriver.click("TC21_360DirectBill.lnkpolicy");
		SleepUtils.sleep(4);
		
		//4. Click on Overview WebElement
		uiDriver.click("TC21_360DirectBill.eltOverview");
		SleepUtils.sleep(4);
		
		//5. Click on 360_Direct_Bill_View_1 WebElement
		uiDriver.click("TC21_360DirectBill.elt360_Direct_Bill_View_1");
		SleepUtils.sleep(4);
		
		//6. Click on Payment_Schedule WebElement
		uiDriver.click("TC21_360DirectBill.eltPayment_Schedule");
		SleepUtils.sleep(4);
		
		//7. Click on Edit_Schedule button
		uiDriver.click("TC21_360DirectBill.btnEdit_Schedule");
		SleepUtils.sleep(4);
		
		//8. Click New_Payment_Plan
		uiDriver.click("TC21_360DirectBill.txtNew_Payment_Plan");
		SleepUtils.sleep(4);
		
		//9. Select $data from the New_Payment_Plan list
		uiDriver.setValue("TC21_360DirectBill.lstNew_Payment_Plan", input.get("Select@New_Payment_Plan"));
		SleepUtils.sleep(4);
		
		//10. Click on Execute button
		uiDriver.click("TC21_360DirectBill.btnExecute");
		SleepUtils.sleep(4);
		
		//11. Click on Overview_1 WebElement
		uiDriver.click("TC21_360DirectBill.eltOverview_1");
		SleepUtils.sleep(4);
		
		//12. Click on 360_Direct_Bill_View_2 WebElement
		uiDriver.click("TC21_360DirectBill.elt360_Direct_Bill_View_2");
		SleepUtils.sleep(4);
		
		//13. Click on Account Link
		uiDriver.click("TC21_360DirectBill.lnkAccount");
		SleepUtils.sleep(4);
		
		//14. Click on 360_Direct_Bill_View_3 WebElement
		uiDriver.click("TC21_360DirectBill.elt360_Direct_Bill_View_3");
		SleepUtils.sleep(4);
	}
	
	public void TC23_360DirectBill(DataRow input, DataRow output) {
		//1. Click on Policy WebElement
		uiDriver.click("TC23_360DirectBill.eltPolicy");
		SleepUtils.sleep(4);
		
		//2. Type $data in Policy_ field
		uiDriver.setValue("TC23_360DirectBill.txtPolicy_", input.get("Type@Policy_"));
		SleepUtils.sleep(4);
		
		//3. Click on Search button
		uiDriver.click("TC23_360DirectBill.btnSearch");
		SleepUtils.sleep(4);
		
		//4. Verify whether the Policy_1 link is present
		if (uiDriver.checkElementPresent("TC23_360DirectBill.lnkPolicy_1")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(4);
		
		//5. Click on Policy_2 Link
		uiDriver.click("TC23_360DirectBill.lnkPolicy_2");
		SleepUtils.sleep(4);
		
		//6. Click on Edit button
		uiDriver.click("TC23_360DirectBill.btnEdit");
		SleepUtils.sleep(4);
		
		//7. Click Billing_Method
		uiDriver.click("TC23_360DirectBill.eltBilling_Method");
		uiDriver.sendKey("Enter");
		SleepUtils.sleep(6);
		
		//8. Select $data from the Billing_Method list
		uiDriver.click("TC23_360DirectBill.btnOk");
     	SleepUtils.sleep(4);
		
		//9. Click on Update button
		uiDriver.click("TC23_360DirectBill.btnUpdate");
		SleepUtils.sleep(4);
		
		//10. Click on 360_Direct_Bill_View WebElement
		uiDriver.click("TC23_360DirectBill.elt360_Direct_Bill_View");
		SleepUtils.sleep(4);
		
		//11. Click Policy_Period
		uiDriver.click("TC23_360DirectBill.txtPolicy_Period");
		SleepUtils.sleep(4);
		
		//12. Type $data in Policy_Period_1 field
		uiDriver.setValue("TC23_360DirectBill.txtPolicy_Period_1", input.get("Type@Policy_Period_1"));
		SleepUtils.sleep(4);
		
		//13. Click on Search_1 button
		uiDriver.click("TC23_360DirectBill.btnSearch_1");
		SleepUtils.sleep(4);
		
		//14. Click on Account Link
		uiDriver.click("TC23_360DirectBill.lnkAccount");
		SleepUtils.sleep(4);
		
		//15. Click on 360_Direct_Bill_View WebElement
		uiDriver.click("TC23_360DirectBill.elt360_Direct_Bill_View_1");
		SleepUtils.sleep(4);
		
		//16. Type $data in Policy_3 field
		uiDriver.setValue("TC23_360DirectBill.txtPolicy_3", input.get("Type@Policy_3"));
		SleepUtils.sleep(4);
		
		//17. Click on Search_2 button
		uiDriver.click("TC23_360DirectBill.btnSearch_2");
		SleepUtils.sleep(4);
		
		//18. Type $data in Policy_Period_2 field
		uiDriver.setValue("TC23_360DirectBill.txtPolicy_Period_2", input.get("Type@Policy_Period_2"));
		SleepUtils.sleep(4);
		
		//19. Click on Search_3 button
		uiDriver.click("TC23_360DirectBill.btnSearch_3");
		SleepUtils.sleep(4);
	}
	
	public void TC24_360DirectBill(DataRow input, DataRow output) {
		//1. Click on Policy WebElement
		uiDriver.click("TC24_360DirectBill.eltPolicy");
		SleepUtils.sleep(4);
		
		//2. Type $data in Policy_ field
		uiDriver.setValue("TC24_360DirectBill.txtPolicy_", input.get("Type@Policy_"));
		SleepUtils.sleep(4);
		
		//3. Click on Search button
		uiDriver.click("TC24_360DirectBill.btnSearch");
		SleepUtils.sleep(4);
		
		//4. Click on Policy_1 Link
		uiDriver.click("TC24_360DirectBill.lnkPolicy_1");
		SleepUtils.sleep(4);
		
		//5. Click on Details WebElement
		uiDriver.click("TC24_360DirectBill.eltDetails");
		SleepUtils.sleep(4);
		
		//6. Click on Edit button
		uiDriver.click("TC24_360DirectBill.btnEdit");
		SleepUtils.sleep(4);
		
		//7. Click Billing_Method
		uiDriver.click("TC24_360DirectBill.eltBilling_Method");
		uiDriver.sendKey("Enter");
		SleepUtils.sleep(6);
		
		//8. Select $data from the Billing_Method list
		uiDriver.click("TC24_360DirectBill.btnOk");
		//uiDriver.setValue("TC24_360DirectBill.lstBilling_Method", input.get("Select@Billing_Method"));
		SleepUtils.sleep(4);
		
		//9. Click on Update button
		uiDriver.click("TC24_360DirectBill.btnUpdate");
		SleepUtils.sleep(4);
		
		//10. Click on 360_Direct_Bill_View WebElement
		uiDriver.click("TC24_360DirectBill.elt360_Direct_Bill_View");
		SleepUtils.sleep(4);
		
		//11. Click on Policy_Period WebElement
		uiDriver.click("TC24_360DirectBill.eltPolicy_Period");
		SleepUtils.sleep(4);
		
		//12. Type $data in Policy_Period_1 field
		uiDriver.setValue("TC24_360DirectBill.txtPolicy_Period_1", input.get("Type@Policy_Period_1"));
		SleepUtils.sleep(4);
		
		//13. Click on Search_1 button
		uiDriver.click("TC24_360DirectBill.btnSearch_1");
		SleepUtils.sleep(4);
		
		//14. Click on Account Link
		uiDriver.click("TC24_360DirectBill.lnkAccount");
		SleepUtils.sleep(4);
		
		//15. Click on 360_Direct_Bill_View_1 WebElement
		uiDriver.click("TC24_360DirectBill.elt360_Direct_Bill_View_1");
		SleepUtils.sleep(4);
		
		//16. Type $data in Policy_2 field
		uiDriver.setValue("TC24_360DirectBill.txtPolicy_2", input.get("Type@Policy_2"));
		SleepUtils.sleep(4);
		//17. Click on Search_2 button
		uiDriver.click("TC24_360DirectBill.btnSearch_2");
		SleepUtils.sleep(4);
	}
	
	public void TC25_360DirectBill(DataRow input, DataRow output) {
		//1. Click on Charges WebElement
		uiDriver.click("TC25_360DirectBill.eltCharges");
		SleepUtils.sleep(4);

		//2.Click on a Specific Charges to Assign payer
		uiDriver.th.findRelativeCellAndClickfirstCell("TC25_360DirectBill.tblCharges", "General", 7, "General");
		SleepUtils.sleep(4);
		
		//2. Click on Assign_Payer button
		uiDriver.click("TC25_360DirectBill.btnAssign_Payer");
		SleepUtils.sleep(4);
		
		//3. Click on Assign_to_Account WebElement
		uiDriver.sendKey("keysdown");
		uiDriver.sendKey("Enter");
		//uiDriver.click("TC25_360DirectBill.eltAssign_to_Account");
		SleepUtils.sleep(4);
		
		//4. Click New_Payer
		uiDriver.click("TC25_360DirectBill.txtNew_Payer");
		SleepUtils.sleep(4);
		
		//5. Click on Reset button
		uiDriver.click("TC25_360DirectBill.btnReset");
		SleepUtils.sleep(4);
		
		//6. Type $data in Account field
		uiDriver.setValue("TC25_360DirectBill.txtAccount", input.get("Type@Account"));
		SleepUtils.sleep(4);
		
		//7. Click on Search button
		uiDriver.click("TC25_360DirectBill.btnSearch");
		SleepUtils.sleep(4);
		
		//8. Verify whether the Select link is present
		if (uiDriver.checkElementPresent("TC25_360DirectBill.lnkSelect")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(4);
		
		//9. Click on Select_1 button
		uiDriver.click("TC25_360DirectBill.btnSelect_1");
		SleepUtils.sleep(4);
		
		//10. Click on What_To_Assign button
		uiDriver.click("TC25_360DirectBill.btnWhat_To_Assign");
		SleepUtils.sleep(4);
		
		//11. Click on Execute button
		uiDriver.click("TC25_360DirectBill.btnExecute");
		SleepUtils.sleep(4);
		
		//12. Click on Overview WebElement
		uiDriver.click("TC25_360DirectBill.eltOverview");
		SleepUtils.sleep(4);
		
		//13. Click on 360_Direct_Bill_View WebElement
		uiDriver.click("TC25_360DirectBill.elt360_Direct_Bill_View");
		SleepUtils.sleep(4);
	}
	
	/**
	*Overriding toString() method of object class to print US1487_360DirectBillView
	*format string
	**/
	public String toString(){
		return "US1487_360DirectBillViewDriver";
	}
}