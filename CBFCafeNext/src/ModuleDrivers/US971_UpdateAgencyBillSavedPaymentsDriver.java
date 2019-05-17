/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 3/28/2018 5:49:10 AM
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
public class US971_UpdateAgencyBillSavedPaymentsDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;

	public US971_UpdateAgencyBillSavedPaymentsDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}

	public void TC03_Editanddiscardagencybill(DataRow input, DataRow output) {
		//1. Click on Producer WebElement
		uiDriver.click("TC03_Editanddiscardagencybillp.eltProducer");
		SleepUtils.sleep(3);

		//2. Type $data in Producer_Code field
		uiDriver.setValue("TC03_Editanddiscardagencybillp.txtProducer_Name", input.get("Type@Producer_Name"));
		SleepUtils.sleep(3);

		//3. Click on Search button
		uiDriver.click("TC03_Editanddiscardagencybillp.btnSearch");
		SleepUtils.sleep(3);

		//4. Verify whether the Name link is present
		if (uiDriver.checkElementPresent("TC03_Editanddiscardagencybillp.lnkName")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(6);

		//5. Click on Name_1 Link
		uiDriver.click("TC03_Editanddiscardagencybillp.lnkName_1");
		uiDriver.sendKey("Enter");
		SleepUtils.sleep(3);

		//6. Click on Agency_Bill_Payments WebElement
		uiDriver.click("TC03_Editanddiscardagencybillp.eltAgency_Bill_Payments");
		SleepUtils.sleep(8);

		//7. Click on Payment_Received WebElement
		uiDriver.click("TC03_Editanddiscardagencybillp.eltPayment_Received");
		SleepUtils.sleep(3);

		//8. Select $data from the Payment_Received list
		uiDriver.setValue("TC03_Editanddiscardagencybillp.lstPayment_Received", input.get("Select@Payment_Received"));
		uiDriver.sendKey("Enter");
		SleepUtils.sleep(8);

		//9. Click on the CheckBox
		uiDriver.th.findRelativeCellAndClickfirstCell("TC03_Editanddiscardagencybillp.tblExecuted_Payments","$50,000.00", 3 ,"$50,000.00");
		SleepUtils.sleep(3);
		
		//10. Click on Edit button
		uiDriver.click("TC03_Editanddiscardagencybillp.btnEdit");
		SleepUtils.sleep(3);

		//11. Type $data in Payment_Description field
		uiDriver.setValue("TC03_Editanddiscardagencybillp.txtPayment_Description", input.get("Type@Payment_Description"));
		SleepUtils.sleep(3);

		//12. Click on AddStatements button
		uiDriver.click("TC03_Editanddiscardagencybillp.btnAddStatements");
		SleepUtils.sleep(3);

		//13. Click on Search_1 button
		uiDriver.click("TC03_Editanddiscardagencybillp.btnSearch_1");
		SleepUtils.sleep(3);

		//14. Click on the CheckBox
		uiDriver.th.findRelativeCellAndClickfirstCell("TC03_Editanddiscardagencybillp.tblAgencyDistribution","Open", 2 ,"Open");
		SleepUtils.sleep(3);

		//15. Click on AddStatements_1 button
		uiDriver.click("TC03_Editanddiscardagencybillp.btnAddStatements_1");
		SleepUtils.sleep(3);

		//16. Click on Next button
		uiDriver.click("TC03_Editanddiscardagencybillp.btnNext");
		SleepUtils.sleep(3);
		
		//17. Click on Distribute_By WebElement
		uiDriver.click("TC03_Editanddiscardagencybillp.eltDistribute_By");
		uiDriver.sendKey("keysdown");
		uiDriver.sendKey("Enter");
		
		//18. Click on Add_policies button
		uiDriver.click("TC03_Editanddiscardagencybillp.btnAdd_policies");
		SleepUtils.sleep(3);
		
		//19. Type $data in Policy field
		uiDriver.setValue("TC03_Editanddiscardagencybillp.txtPolicy", input.get("Type@Policy"));
		SleepUtils.sleep(3);

		//20. Click on Search_2 button
		uiDriver.click("TC03_Editanddiscardagencybillp.btnSearch_2");
		SleepUtils.sleep(5);

		//21.Click the First Element from the table Addpolicies
		uiDriver.th.findRelativeCellAndClickfirstCell("TC03_Editanddiscardagencybillp.tblAddPolicies","Past Due", 5 ,"Past Due");
		SleepUtils.sleep(4);
		
		//22. Click on Add_Policies_(All Items) button
		uiDriver.click("TC03_Editanddiscardagencybillp.btnAdd_Policies_(All Items)");

		//23. Click on Save button
		uiDriver.click("TC03_Editanddiscardagencybillp.btnSave");
		SleepUtils.sleep(3);

		//24. Type $data in Name_1 field
		uiDriver.setValue("TC03_Editanddiscardagencybillp.txtName_1", input.get("Type@Name_1"));
		SleepUtils.sleep(3);

		//25. Click on Ok button
		uiDriver.click("TC03_Editanddiscardagencybillp.btnOk");
		SleepUtils.sleep(3);

		//26. Click on Agency_Bill_Payments_1 WebElement
		uiDriver.click("TC03_Editanddiscardagencybillp.eltAgency_Bill_Payments_1");
		SleepUtils.sleep(5);


		//27. Click on Saved_Payments WebElement
		uiDriver.click("TC03_Editanddiscardagencybillp.eltSaved_Payments");
		SleepUtils.sleep(3);

		//28. Click on Payment_Received WebElement
		uiDriver.click("TC03_Editanddiscardagencybillp.eltPayment_Received_1");
		SleepUtils.sleep(3);

		//29. Select $data from the Payment_Received list
		uiDriver.setValue("TC03_Editanddiscardagencybillp.lstPayment_Received_1", input.get("Select@Payment_Received"));
		uiDriver.sendKey("Enter");
		SleepUtils.sleep(8);

		//30. Click on the CheckBox
		uiDriver.th.findRelativeCellAndClickfirstCell("TC03_Editanddiscardagencybillp.tblSaved_Payments","TestSaved Payment", 4 ,"TestSaved Payment");
		SleepUtils.sleep(3);

		//31. Click on Discard button
		uiDriver.click("TC03_Editanddiscardagencybillp.btnDiscard");
		SleepUtils.sleep(3);

		//32. Click on Ok button
		uiDriver.click("TC03_Editanddiscardagencybillp.btnOk_1");
		SleepUtils.sleep(3);

		//33. Click on Executed_Payments WebElement
		uiDriver.click("TC03_Editanddiscardagencybillp.eltExecuted_Payments");
		SleepUtils.sleep(3);

		//34. Click on Payment_Received WebElement
		uiDriver.click("TC03_Editanddiscardagencybillp.eltPayment_Received_2");
		SleepUtils.sleep(3);

		//35. Select $data from the Payment_Received list
		uiDriver.setValue("TC03_Editanddiscardagencybillp.lstPayment_Received_2", input.get("Select@Payment_Received"));
		uiDriver.sendKey("Enter");
		SleepUtils.sleep(8);

		//36. Click on the CheckBox
		uiDriver.th.findRelativeCellAndClickfirstCell("TC03_Editanddiscardagencybillp.tblExecuted_Payments","$50,000.00", 3 ,"$50,000.00");
		SleepUtils.sleep(3);

		//37. Click on Edit_1 button
		uiDriver.click("TC03_Editanddiscardagencybillp.btnEdit_1");
		SleepUtils.sleep(3);

		//38. Type $data in Payment_Description_1 field
		uiDriver.setValue("TC03_Editanddiscardagencybillp.txtPayment_Description_1", input.get("Type@Payment_Description_1"));
		SleepUtils.sleep(3);

		//39. Click on AddStatements_1 button
		uiDriver.click("TC03_Editanddiscardagencybillp.btnAddStatements_2");
		SleepUtils.sleep(3);

		//40. Click on Search_2 button
		uiDriver.click("TC03_Editanddiscardagencybillp.btnSearch_3");
		SleepUtils.sleep(3);

		//41. Click on the CheckBox
		uiDriver.th.findRelativeCellAndClickfirstCell("TC03_Editanddiscardagencybillp.tblAgencyDistribution","Open", 2 ,"Open");
		SleepUtils.sleep(3);

		//42. Click on AddStatements_2 button
		uiDriver.click("TC03_Editanddiscardagencybillp.btnAddStatements_3");
		SleepUtils.sleep(3);

		//43. Click on Next_1 button
		uiDriver.click("TC03_Editanddiscardagencybillp.btnNext_1");
		SleepUtils.sleep(3);

		//44. Click on Save_1 button
		uiDriver.click("TC03_Editanddiscardagencybillp.btnSave_1");
		SleepUtils.sleep(3);

		//45. Type $data in Name_2 field
		uiDriver.setValue("TC03_Editanddiscardagencybillp.txtName_2", input.get("Type@Name_2"));
		SleepUtils.sleep(3);

		//46. Click on Ok_1 button
		uiDriver.click("TC03_Editanddiscardagencybillp.btnOk_2");
		SleepUtils.sleep(3);

		//47. Click on History WebElement
		uiDriver.click("TC03_Editanddiscardagencybillp.eltHistory");
		SleepUtils.sleep(3);

		//48. Click Filter_by_Date
		uiDriver.click("TC03_Editanddiscardagencybillp.txtFilter_by_Date");
		SleepUtils.sleep(3);

		//49. Select $data from the Filter_by_Date list
		uiDriver.setValue("TC03_Editanddiscardagencybillp.lstFilter_by_Date", input.get("Select@Filter_by_Date"));
		SleepUtils.sleep(3);

		//50. Click Filter_by_Type
		uiDriver.click("TC03_Editanddiscardagencybillp.txtFilter_by_Type");
		SleepUtils.sleep(3);

		//51. Select $data from the Filter_by_Type list
		uiDriver.setValue("TC03_Editanddiscardagencybillp.lstFilter_by_Type", input.get("Select@Filter_by_Type"));
		SleepUtils.sleep(3);
	}


	/**
	 *Overriding toString() method of object class to print US971_UpdateAgencyBillSavedPayments
	 *format string
	 **/
	public String toString(){
		return "US971_UpdateAgencyBillSavedPaymentsDriver";
	}
}
