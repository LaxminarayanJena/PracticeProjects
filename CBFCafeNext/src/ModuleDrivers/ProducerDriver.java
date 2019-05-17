/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 1/29/2018 1:23:02 AM
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
 * Extends BaseModuleDriver class and performs application specific operations
 */
public class ProducerDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;

	public ProducerDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}

	public void Producer_Roles_Permission(DataRow input, DataRow output) {
		// 1. Click on Administration WebElement
		uiDriver.click("Producer_Roles_Permission.eltAdministration");

		// 2. Type $data in User_Name field
		uiDriver.setValue("Producer_Roles_Permission.txtUser_Name", System.getProperty("user.name"));

		// 3. Click on Search button
		uiDriver.click("Producer_Roles_Permission.btnSearch_Admin");

		// 4. Verify whether the Display_Name link is present
		if (uiDriver.checkElementPresent("Producer_Roles_Permission.lnkDisplay_Name")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 5. Click on Display_Name Link
		uiDriver.click("Producer_Roles_Permission.lnkDisplay_Name");
		SleepUtils.sleep(6);

		// 6. Click on Search_Producer WebElement
		uiDriver.click("Producer_Roles_Permission.eltSearch_Producer");

		// 7. Click on Producers WebElement
		uiDriver.click("Producer_Roles_Permission.eltProducers");

		// 8. Click on Agency_Type WebElement
		uiDriver.click("Producer_Roles_Permission.eltAgency_Type");

		// 9. Verify Commision_and_non_Com
		String Agency_Type = input.get("Verify@Agent_type");
		uiDriver.checkDropDownOptions("li", Agency_Type);

		// 10. Click on Administration WebElement
		uiDriver.click("Producer_Roles_Permission.eltAdministration");

		// 11. Type $data in User_Name field
		uiDriver.setValue("Producer_Roles_Permission.txtUser_Name", System.getProperty("user.name"));

		// 12. Click on Search_Admin button
		uiDriver.click("Producer_Roles_Permission.btnSearch_Admin");

		// 13. Verify whether the Display_Name link is present
		if (uiDriver.checkElementPresent("Producer_Roles_Permission.lnkDisplay_Name")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 14. Click on Display_Name Link
		uiDriver.click("Producer_Roles_Permission.lnkDisplay_Name");

		// 15. Click Edit_
		uiDriver.click("Producer_Roles_Permission.txtEdit_");
		SleepUtils.sleep(3);

		// 16. Select the Commissions_Manager ?checkbox
		uiDriver.th.findRelativeCellAndClickfirstCell("Producer_Roles_Permission.chkCommissions_Manager",
				"Commissions Manager", 1, "Commissions Manager");

		// 17. Click on Remove_Selected_Role button
		uiDriver.click("Producer_Roles_Permission.btnRemove_Selected_Role");

		// 18. Select the Commission ?checkbox
		uiDriver.th.findRelativeCellAndClickfirstCell("Producer_Roles_Permission.chkCommissions_Manager", "Commission",
				1, "Commission");

		// 19. Click on Remove_Selected_Role button
		uiDriver.click("Producer_Roles_Permission.btnRemove_Selected_Role");

		// 20. Select the Executive ?checkbox
		uiDriver.th.findRelativeCellAndClickfirstCell("Producer_Roles_Permission.chkCommissions_Manager", "Executive",
				1, "Executive");

		// 21. Click on Remove_Selected_Role button
		uiDriver.click("Producer_Roles_Permission.btnRemove_Selected_Role");

		// 22. Click on Update button
		uiDriver.click("Producer_Roles_Permission.btnUpdate");

		// 23. Click on Search_Producer WebElement
		uiDriver.click("Producer_Roles_Permission.eltSearch_Producer");

		// 24. Click on Producer WebElement
		uiDriver.click("Producer_Roles_Permission.eltProducers");

		// 25. Click on Agency_Type WebElement
		uiDriver.click("Producer_Roles_Permission.eltAgency_Type");
		SleepUtils.sleep(3);

		// 26. Verify Commision_and_Non_Comm
		String[] expectedValue = input.get("Verify@Agent_type").split(",");

		for (int i = 0; i < expectedValue.length; i++) {
			boolean verfiyval = uiDriver.getElementNameUsingTag("li", expectedValue[i]);
			if (!verfiyval) {
				passed("verify option from Agency Type list",
						expectedValue[i] + " option should not exist in Agency Type list",
						expectedValue[i] + " Option has not been exist in Agency Type lis");
			} else {
				failed("verify option from Agency Type list",
						expectedValue[i] + " option should not exist Agency Type list",
						expectedValue[i] + " Option has been exist in Agency Type lis");
			}
		}

		// 27. Type $data in Producer_Code field
		uiDriver.setValue("Producer_Roles_Permission.txtProducer_Code", input.get("Type@Producer_Code"));

		// 28. Click on Search image
		uiDriver.click("Producer_Roles_Permission.imgSearch");

		// 29. Verify Name
		if (uiDriver.checkElementPresent("Producer_Roles_Permission.eltName")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

	}

	public void Validate_Producer_Summ_Screen(DataRow input, DataRow output) {
		// 1. Click on Prod_Sum_Edit button
		uiDriver.click("Validate_Producer_Summ_Screen.btnProd_Sum_Edit");

		// 2. Click on Account_Rep_Search_ image
		uiDriver.click("Validate_Producer_Summ_Screen.imgAccount_Rep_Search_");

		// 3. Verify whether the User_Name field is present
		if (uiDriver.checkElementPresent("Validate_Producer_Summ_Screen.txtUser_Name")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 4. Click on Return_to_Summary Link
		uiDriver.click("Validate_Producer_Summ_Screen.lnkReturn_to_Summary");

		// 5. Verify Payment_Instrument
		uiDriver.click("Validate_Producer_Summ_Screen.eltProducer_tble");
		SleepUtils.sleep(3);
		String value = uiDriver.getControl("Validate_Producer_Summ_Screen.txtPayment_Instrument")
				.getAttribute("data-ref");
		if (value != "inputEl") {
			passed("Verfiy Payment Instrument", "Should not be editable  pass",
					"Verfiy Payment Instrument expected passed");
		} else {
			failed("Verfiy Payment Instrument", "Should not be editable  pass",
					"Verfiy Payment Instrument not expected failed");
		}

		// 6. Click on Producer_Code WebElement
		String searchName = input.get("Verify@producer_code");
		String expected = uiDriver.th.getRelativeCellData("Validate_Producer_Summ_Screen.eltProducer_Code", searchName,
				1);
		if (searchName.equalsIgnoreCase(expected)) {
			passed("Verfiy Actual and expected", "Both are same should pass", "Verfiy Actual and expected passed");
		} else {
			failed("Verfiy Actual and expected", "Both are same should pass", "Verfiy Actual and expected failed");
		}

		// 7.Verify Agency Type is displayed on search criteria and is a typelist
		uiDriver.click("Search_Producer_Code.eltProducer");
		uiDriver.click("Search_Producer_Code.eltProducer");
		uiDriver.click("Validate_Producer_Summ_Screen.btnReset");
		SleepUtils.sleep(3);
		String fieldTypelist = uiDriver.getControl("Validate_Producer_Summ_Screen.eltAgency_Type").getAttribute("role");
		if (fieldTypelist.equalsIgnoreCase("combobox")) {
			passed("Verfiy Agency Type", "Should be List type  pass", "Agency Type expected passed");
		} else {
			failed("Verfiy Agency Type", "Should be List type  pass", "Agency Type not expected failed");
		}

		// 8.Verify Region is displayed on search criteria and is a typelist
		String fieldTypelistRegion = uiDriver.getControl("Validate_Producer_Summ_Screen.lstRegion")
				.getAttribute("role");
		if (fieldTypelistRegion.equalsIgnoreCase("combobox")) {
			passed("Verfiy Region", "Should be List type  pass", "Region  expected passed");
		} else {
			failed("Verfiy Region", "Should be List type  pass", "Region  not expected failed");
		}

		// 9.Verify 'Status' is displayed on search criteria and is always defaulted to None
		String statusValue = uiDriver.getControl("Validate_Producer_Summ_Screen.lstStatus").getAttribute("value");
		if (statusValue.equalsIgnoreCase("<none>")) {
			passed("Verfiy Status", "field value should be <none>  pass", "Status  expected passed");
		} else {
			failed("Verfiy Status", "field value should be <none>  pass", "Status  not expected failed");
		}

		// 10.Verify radio button 'Starts with' is displayed in the search criteria section
		if (uiDriver.checkElementPresent("Validate_Producer_Summ_Screen.eltstartswith")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 11.Verify 'Starts with' should always be defaulted to 'Yes' on Producer Summary Screen
		String status = uiDriver.getControl("Validate_Producer_Summ_Screen.rdgStartswithyes").getAttribute("tabindex");
		if (status.equalsIgnoreCase("-1")) {
			passed("Verfiy radio button selected", "defeault as yes  pass", "Status  expected passed");
		} else {
			failed("Verfiy radio button selected", "defeault as yes  pass", "Status not expected failed");
		}

		// 12. Type $data in Producer Name field
		uiDriver.setValue("Validate_Producer_Summ_Screen.txtProducer_Name", input.get("Type@Producer_Name"));

		// 13. Click on Search button
		uiDriver.click("Validate_Producer_Summ_Screen.btnSearch");

		// 14.Verify table values
		int rcnt1 = uiDriver.th.getRowCount("Validate_Producer_Summ_Screen.tblProducer");
		for (int i = 0; i <= rcnt1; i++) {
			String cellValue = uiDriver.th.getCellData("Validate_Producer_Summ_Screen.tblProducer", 0, 3);
			if (cellValue.substring(0, 4).equalsIgnoreCase("PHLY")) {
				passed("Verfiy cell value", "should be value contains serach value  pass" + cellValue,
						"Verfiy element expected passed");
			}

		}

		// 15.Select No radio button
		uiDriver.click("Validate_Producer_Summ_Screen.rdgStartswithNo");

		// 16. Click on Search button
		uiDriver.click("Validate_Producer_Summ_Screen.btnSearch");

		// 17.Verify table values
		SleepUtils.sleep(8);
		int rcnt = uiDriver.th.getRowCount("Validate_Producer_Summ_Screen.tblProducer");
		for (int i = 0; i < rcnt; i++) {
			String cellValue1 = uiDriver.th.getCellData("Validate_Producer_Summ_Screen.tblProducer", i, 3);
			if (cellValue1.contains("PHLY")) {
				passed("verify String", cellValue1 + "exisisted in producer table",
						cellValue1 + " string has been exist in producer table ");
				break;
			}
		}

	}

	public void Search_Entities_Produ_summ_Scr(DataRow input, DataRow output) {

		// 1. Click on Producer_Code WebElement
		uiDriver.click("Validate_Producer_Summ_Screen.btnReset");

		// 2. Click on Producer WebElement
		uiDriver.click("Search_Entities_Produ_summ_Scr.eltProducer");

		// 3. Type $data in Producer_Name field
		SleepUtils.sleep(3);
		uiDriver.setValue("Search_Entities_Produ_summ_Scr.txtProducer_Name", input.get("Type@Producer_Name"));

		// 4. Click on Search button
		uiDriver.click("Search_Entities_Produ_summ_Scr.btnSearch");

		// 5. Verify whether the Prod_Name link is present
		if (uiDriver.checkElementPresent("Search_Entities_Produ_summ_Scr.lnkProd_Name")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 6. Click on Reset button
		uiDriver.click("Search_Entities_Produ_summ_Scr.btnReset");

		// 7. Type $data in Producer_Code field
		SleepUtils.sleep(3);
		uiDriver.setValue("Search_Entities_Produ_summ_Scr.txtProducer_Code", input.get("Type@Producer_Code"));

		// 8. Click on Search button
		uiDriver.click("Search_Entities_Produ_summ_Scr.btnSearch");
		SleepUtils.sleep(3);
		
		// 9. Verify whether the Pro_Code link is present
		if (uiDriver.checkElementPresent("Search_Entities_Produ_summ_Scr.lnkPro_Code")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		// 10. Click on Reset button
		uiDriver.click("Search_Entities_Produ_summ_Scr.btnReset");
		SleepUtils.sleep(3);
		
		// 11. Type $data in Company_name field
		SleepUtils.sleep(5);
		uiDriver.setValue("Search_Entities_Produ_summ_Scr.txtCompany_name", input.get("Type@Company_name"));

		// 12. Click on Search button
		uiDriver.click("Search_Entities_Produ_summ_Scr.btnSearch");
		SleepUtils.sleep(3);
		
		// 13. Verify whether the Pro_Company_Name link is present
		SleepUtils.sleep(5);
		if (uiDriver.checkElementPresent("Search_Entities_Produ_summ_Scr.lnkPro_Company_Name")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		// 14. Click on Reset button
		uiDriver.click("Search_Entities_Produ_summ_Scr.btnReset");
		SleepUtils.sleep(3);
		
		// 15. Click on Search WebElement
		uiDriver.click("Search_Entities_Produ_summ_Scr.eltSearch");
		SleepUtils.sleep(3);
		
		// 16. Click on Producers WebElement
		uiDriver.click("Search_Entities_Produ_summ_Scr.eltProducers");
		SleepUtils.sleep(3);
		
		//17. Click on Search_Accounts_Search WebElement
		uiDriver.click("Search_Entities_Produ_summ_Scr.eltSearch_Accounts_Search");
		SleepUtils.sleep(3);
		
		//18. Verify the text ?$data in the Err_Msg field
		if (uiDriver.verifyTextActAndExp("Search_Entities_Produ_summ_Scr.eltErr_Msg",
				input.get("VerifyText@Err_Msg"))) {
			passed("verifyText", "verifyText should pass", "verifyText passed");
		} else {
			failed("verifyText", "verifyText should pass", "verifyText failed");
		}

		// 19. Click on Producers WebElement
		uiDriver.click("Search_Entities_Produ_summ_Scr.eltProducer");
		SleepUtils.sleep(3);
		
		// 20. Click on Prod_Serach button
		uiDriver.click("Search_Entities_Produ_summ_Scr.btnProd_Serach");
		SleepUtils.sleep(3);
		
		// 21. Verify the text ?$data in the Erro_Msg_Prod field
		if (uiDriver.verifyTextActAndExp("Search_Entities_Produ_summ_Scr.eltErro_Msg_Prod",
				input.get("VerifyText@Erro_Msg_Prod"))) {
			passed("verifyText", "verifyText should pass", "verifyText passed");
		} else {
			failed("verifyText", "verifyText should pass", "verifyText failed");
		}
		SleepUtils.sleep(3);
		
		// 22. Type $data in Producer_Name field
		uiDriver.setValue("Search_Entities_Produ_summ_Scr.txtProducer_Name", input.get("Type@Producer_Name"));
		SleepUtils.sleep(3);
		
		// 23. Click on Search button
		uiDriver.click("Search_Entities_Produ_summ_Scr.btnProd_Serach");
		SleepUtils.sleep(3);
		
		// 24. Verify whether the Agency_Type element present
		SleepUtils.sleep(5);
		if (uiDriver.checkElementPresent("Search_Entities_Produ_summ_Scr.eltAgency_Type")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 25. Verify whether the Producer_Code element present
		if (uiDriver.checkElementPresent("Search_Entities_Produ_summ_Scr.eltProducer_Code")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		// 26. Type $data in Producer_Name field
		uiDriver.setValue("Search_Entities_Produ_summ_Scr.txtProducer_Name", input.get("Type@Producer_Name_Inactive"));
		SleepUtils.sleep(3);
		
		// 27. Click on Search button
		uiDriver.click("Search_Entities_Produ_summ_Scr.btnProd_Serach");
		SleepUtils.sleep(3);
		
		// 28. Verfiy status text color
		String tcolor = uiDriver.th.getCellDataofcolor("Search_Entities_Produ_summ_Scr.tblProducer", 0, 2);
		if (tcolor.equalsIgnoreCase("rgba(35, 35, 35, 1)")) {
			passed("verifyTextColor", "verifyTextColor should pass" + tcolor, "verifyTextColor passed");
		} else {
			failed("verifyTextColor", "verifyTextColor should pass" + tcolor, "verifyTextColor failed");

		}
		SleepUtils.sleep(3);
		// 29. Click on Reset button
		uiDriver.click("Search_Entities_Produ_summ_Scr.btnReset");

	}

	public void Search_Direct_Bill_Producer(DataRow input, DataRow output) {

		// 1. Click on Search WebElement
		uiDriver.click("Search_Direct_Bill_Producer.eltSearch");
		SleepUtils.sleep(3);
		
		// 2. Click on Direct_Bill_Commission_Payments WebElement
		uiDriver.click("Search_Direct_Bill_Producer.eltDirect_Bill_Commission_Payments");
		SleepUtils.sleep(3);

		// 3. Verify whether the Producer element present
		if (uiDriver.checkElementPresent("Search_Direct_Bill_Producer.eltProducer")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		// 4. Type $data in Producer field
		uiDriver.setValue("Search_Direct_Bill_Producer.txtProducer", input.get("Type@Producer"));
		SleepUtils.sleep(3);
		
		// 5. Click on Search_DBC button
		uiDriver.click("Search_Direct_Bill_Producer.btnSearch_DBC");
		SleepUtils.sleep(3);
		
		// 6. Verify whether the Producer_Code element present
		if (uiDriver.checkElementPresent("Search_Direct_Bill_Producer.eltProducer_Code")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		// 7. Click on Reset button
		uiDriver.click("Search_Direct_Bill_Producer.btnReset");
		SleepUtils.sleep(2);

		// 8. Click on Producer_Image image
		uiDriver.click("Search_Direct_Bill_Producer.imgProducer_Image");
		SleepUtils.sleep(3);

		// 9. Type $data in Producer_Name field
		uiDriver.setValue("Search_Direct_Bill_Producer.txtProducer_Name", input.get("Type@Producer_Name"));
		SleepUtils.sleep(3);
		
		// 10. Click on Search_Producer button
		uiDriver.click("Search_Direct_Bill_Producer.btnSearch_Producer");
		SleepUtils.sleep(3);
		
		// 11. Verify Agency_Type
		String NonCommissioned = input.get("Type@Producer_Name");
		uiDriver.th.getCellDataOfCol("Search_Direct_Bill_Producer.eltAgency_Type", NonCommissioned, 4);
		SleepUtils.sleep(3);
	}

	public void Validate_Transactions_prod_scr(DataRow input, DataRow output) {

		// 1. Click on Transactions WebElement
		uiDriver.click("Validate_Transactions_prod_scr.eltTransactions");
		SleepUtils.sleep(3);
		
		// 2. Click on Reserves WebElement
		uiDriver.click("Validate_Transactions_prod_scr.eltReserves");
		SleepUtils.sleep(3);
		
		// 3. Verify whether the Total element present
		if (uiDriver.checkElementNotPresent("Validate_Transactions_prod_scr.eltTotal")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		// 4. Click on Combined WebElement
		uiDriver.click("Validate_Transactions_prod_scr.eltCombined");
		SleepUtils.sleep(3);
		
		// 5. Verify whether the Payable element present
		if (uiDriver.checkElementNotPresent("Validate_Transactions_prod_scr.eltPayable")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(3);
	}

	public void Updat_Remov_Field_Prod_Sum_Scr(DataRow input, DataRow output) {

		// 1. Verify whether the Commission_Paid_Year_to_Date element present
		if (uiDriver.checkElementPresent("Updat_Remov_Field_Prod_Sum_Scr.eltCommission_Paid_Year_to_Date")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		// 2. Verify whether the Total_Commission_Payable element present
		if (uiDriver.checkElementPresent("Updat_Remov_Field_Prod_Sum_Scr.eltTotal_Commission_Payable")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		// 3. Verify whether the Total_Commission_Reserve element present
		if (uiDriver.checkElementPresent("Updat_Remov_Field_Prod_Sum_Scr.eltTotal_Commission_Reserve")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		// 4. Verify whether the Total_Commission_Expense element present
		if (uiDriver.checkElementPresent("Updat_Remov_Field_Prod_Sum_Scr.eltTotal_Commission_Expense")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		// 5. Verify whether the Advance_Balance element present
		if (uiDriver.checkElementPresent("Updat_Remov_Field_Prod_Sum_Scr.eltAdvance_Balance")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		// 6. Verify whether the Unapplied_Amount element present
		if (uiDriver.checkElementPresent("Updat_Remov_Field_Prod_Sum_Scr.eltUnapplied_Amount")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		// 7. Verify whether the Suspense_Amount element present
		if (uiDriver.checkElementPresent("Updat_Remov_Field_Prod_Sum_Scr.eltSuspense_Amount")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		// 8. Verify whether the Write_Off_Expense element present
		if (uiDriver.checkElementPresent("Updat_Remov_Field_Prod_Sum_Scr.eltWrite_Off_Expense")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(3);
	}

	public void Roles_CanEdt_AccRep_HoldSte_Fi(DataRow input, DataRow output) {

		// 1. Click on Account_Rep_Img image
		uiDriver.click("Roles_CanEdt_AccRep_HoldSte_Fi.imgAccount_Rep_Img");
		SleepUtils.sleep(3);
		
		// 2. Type $data in User_name field
		uiDriver.setValue("Roles_CanEdt_AccRep_HoldSte_Fi.txtUser_name", System.getProperty("user.name"));
		SleepUtils.sleep(3);
		
		// 3. Click on Search button
		uiDriver.click("Roles_CanEdt_AccRep_HoldSte_Fi.btnSearch");
		SleepUtils.sleep(3);
		
		// 4. Verify whether the Select field is present
		if (uiDriver.checkElementPresent("Roles_CanEdt_AccRep_HoldSte_Fi.btnSelect")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		// 5. Click on Select button
		uiDriver.click("Roles_CanEdt_AccRep_HoldSte_Fi.btnSelect");
		SleepUtils.sleep(3);
		
		// 6. Click on Update button
		uiDriver.click("Roles_CanEdt_AccRep_HoldSte_Fi.btnUpdate");
		SleepUtils.sleep(4);

		// 7. Verify the text ?$data in the Hold_Statement field
		if (uiDriver.verifyTextActAndExp("Roles_CanEdt_AccRep_HoldSte_Fi.eltHold_Statement",
				input.get("VerifyText@Hold_Statement"))) {
			passed("verifyText", "verifyText should pass", "verifyText passed");
		} else {
			failed("verifyText", "verifyText should pass", "verifyText failed");
		}
		SleepUtils.sleep(3);
		
		// 8. Click on Edit button
		uiDriver.click("Roles_CanEdt_AccRep_HoldSte_Fi.btnEdit");
		SleepUtils.sleep(4);
		
		// 9. Click on Cancel button
		uiDriver.click("Roles_CanEdt_AccRep_HoldSte_Fi.btncance");
		SleepUtils.sleep(3);
	}

	public void Verify_Functional_Requirements(DataRow input, DataRow output) {
		// 1. Click on Producer WebElement
		uiDriver.click("Verify_Functional_Requirements.eltProducer");
		SleepUtils.sleep(3);
		
		// 2. Type $data in Producer_Code field
		uiDriver.click("Search_Entities_Produ_summ_Scr.btnReset");
		SleepUtils.sleep(4);
		uiDriver.setValue("Verify_Functional_Requirements.txtProducer_Code", input.get("Type@Producer_Code"));
		SleepUtils.sleep(3);
		
		// 3. Click on Search button
		uiDriver.click("Verify_Functional_Requirements.btnSearch");
		SleepUtils.sleep(3);
		
		// 4. Verify whether the name element present
		if (uiDriver.checkElementPresent("Verify_Functional_Requirements.eltname")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
        SleepUtils.sleep(4);
         
		//5. Click on name WebElement
		uiDriver.click("Verify_Functional_Requirements.eltname_1");
		 SleepUtils.sleep(4);
		 
		//6. Verify whether the AgencyType element present
		if (uiDriver.checkElementPresent("Verify_Functional_Requirements.eltAgencyType")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		 SleepUtils.sleep(4);
		 
		// 15. Verify whether the Region_Summary element present
		if (uiDriver.checkElementPresent("Verify_Functional_Requirements.eltRegion_Summary")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		 SleepUtils.sleep(4);
		 
		// 16. Verify whether the FEIN element present
		if (uiDriver.checkElementPresent("Verify_Functional_Requirements.eltFEIN")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		 SleepUtils.sleep(4);
		 
		// 7. Verify whether the Fax element present
		if (uiDriver.checkElementPresent("Verify_Functional_Requirements.eltFax")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		 SleepUtils.sleep(4);
		 
		// 8. Verify whether the Phone element present
		if (uiDriver.checkElementPresent("Verify_Functional_Requirements.eltPhone")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		 SleepUtils.sleep(4);
		 
		//9. Verify Eligible
		String Eligible = uiDriver.getControl("Verify_Functional_Requirements.eltEligibleSumm").getText();
		if (Eligible.equals("Yes")) {
			passed("Verify", "elment present should pass", "Verify elment present passed");
		} else {
			failed("Verify", "elment present should pass", "Verifyelment present failed");
		}
		 SleepUtils.sleep(4);
		 
		// 10. Click on Edit button
		uiDriver.click("Verify_Functional_Requirements.btnEdit");
		 SleepUtils.sleep(4);
		 
		// 11. Verify Account_Rep
		String AccrepSumm = uiDriver.getControl("Verify_Functional_Requirements.txtAccount_Rep1").getAttribute("role");
		if (AccrepSumm.equals("textbox")) {
			passed("Verify textbox", "is editable should pass", "Verify textbox is editable passed");
		} else {
			failed("Verify textbox", "is editable should pass", "Verify textbox not editable failed");
		}
		 SleepUtils.sleep(4);
		 
		// 12. Click on Cancel button
		uiDriver.click("Verify_Functional_Requirements.btnCancelSumm");
		SleepUtils.sleep(5);

		// 13. Verify the text ?$data in the Payment_Frequency field
		if (uiDriver.verifyTextActAndExp("Verify_Functional_Requirements.eltPayment_Frequency",
				input.get("VerifyText@Payment_Frequency"))) {
			passed("verifyText", "verifyText should pass", "verifyText passed");
		} else {
			failed("verifyText", "verifyText should pass", "verifyText failed");
		}
		 SleepUtils.sleep(4);
		 
		// 14. Click on Producer_Code_Summ WebElement
		uiDriver.click("Verify_Functional_Requirements.eltProducer_Code_Summ");
		SleepUtils.sleep(3);

	}

	public void Verfiy_Producer_History(DataRow input, DataRow output) {

		// 1. Click on Edit button
		uiDriver.click("Verfiy_Producer_History.btnEdit");
		SleepUtils.sleep(2);
		uiDriver.click("Verfiy_Producer_History.imgAcc_Rep");
		SleepUtils.sleep(2);
		
		// 2. Fetching the users as per SSO
		if (!System.getProperty("user.name").equalsIgnoreCase("bgolla")) { 
			uiDriver.setValue("Verfiy_Producer_History.txtUser_name", "bgolla");
		}
		if (!System.getProperty("user.name").equalsIgnoreCase("rjuwadi")) {
			uiDriver.setValue("Verfiy_Producer_History.txtUser_name", "rjuwadi");
		}
		if (!System.getProperty("user.name").equalsIgnoreCase("gankumar")) {
			uiDriver.setValue("Verfiy_Producer_History.txtUser_name", "gankumar");
		}
		SleepUtils.sleep(2);
		
		// 3. Click on the Search button
		uiDriver.click("Verfiy_Producer_History.btnSearch");
		SleepUtils.sleep(2);
		
		// 4. Verify the select button
		if (uiDriver.checkElementPresent("Verfiy_Producer_History.btnSelect")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(2);
		
		//5. Click on Select button
		uiDriver.click("Verfiy_Producer_History.btnSelect");
		SleepUtils.sleep(2);
		
		//6. Click on Update button
		uiDriver.click("Verfiy_Producer_History.btnUpdate");
		SleepUtils.sleep(2);

		// 7. Click on Edit button
		uiDriver.click("Verfiy_Producer_History.btnEdit");
		SleepUtils.sleep(3);
		
		// 8. Click on Acc_Rep image
		uiDriver.click("Verfiy_Producer_History.imgAcc_Rep");
		SleepUtils.sleep(3);
		
		// 9. Type $data in User_name field
		uiDriver.setValue("Verfiy_Producer_History.txtUser_name", System.getProperty("user.name"));
		SleepUtils.sleep(3);
		
		// 10. Click on Search button
		uiDriver.click("Verfiy_Producer_History.btnSearch");
		SleepUtils.sleep(3);
		
		// 11. Verify whether the Select button is present
		if (uiDriver.checkElementPresent("Verfiy_Producer_History.btnSelect")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		// 12. Click on Select button
		uiDriver.click("Verfiy_Producer_History.btnSelect");
		SleepUtils.sleep(3);
		
		// 13. Click on Update button
		uiDriver.click("Verfiy_Producer_History.btnUpdate");
		SleepUtils.sleep(5);

		// 14. Click on History WebElement
		uiDriver.click("Verfiy_Producer_History.eltHistory");
		SleepUtils.sleep(5);
//
//		// 15. Click on Date WebElement
//		uiDriver.doubleclick("Verfiy_Producer_History.eltDate");
//		SleepUtils.sleep(6);

		// 16. Verify the text ?$data in the Description field
		String Actual = uiDriver.th.getCellData("Verfiy_Producer_History.eltDescription", 0, 1);
		if (Actual.contains(input.get("VerifyText@Description"))) {
			passed("verifyText", "verifyText should pass", "verifyText passed");
		} else {
			failed("verifyText", "verifyText should pass", "verifyText failed");
		}
		SleepUtils.sleep(3);
	}

	public void ViewPolicies_Producer(DataRow input, DataRow output) {
		// 1. Click on Policies WebElement
		uiDriver.click("ViewPolicies_Producer.eltPolicies");
		SleepUtils.sleep(3);
		
		// 2. Click on Print_Export WebElement
		uiDriver.click("ViewPolicies_Producer.eltPrint_Export");
		SleepUtils.sleep(3);
		
		// 3. Verify whether the Print_as_PDF_ element present
		if (uiDriver.checkElementPresent("ViewPolicies_Producer.eltPrint_as_PDF_")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		// 4. Verify whether the Export_as_CSV_ element present
		if (uiDriver.checkElementPresent("ViewPolicies_Producer.eltExport_as_CSV_")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		// 5. Verify whether the Custom_Export_as_CSV_ element present
		if (uiDriver.checkElementPresent("ViewPolicies_Producer.eltCustom_Export_as_CSV_")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		// 6. Click on Return_to_Policies Link
		uiDriver.click("ViewPolicies_Producer.lnkReturn_to_Policies");
		SleepUtils.sleep(3);

		// 7. Verify Billing_Method
		uiDriver.click("ViewPolicies_Producer.lstBilling_Method");
		SleepUtils.sleep(3);
		String listvalue = input.get("Verfiy@BillingMethod");
		uiDriver.checkDropDownOptions("li", listvalue);
		SleepUtils.sleep(2);
		uiDriver.sendKey("tab");
		SleepUtils.sleep(3);
		
		// 8. Select $data from the Billing_Method list
		uiDriver.click("ViewPolicies_Producer.lstBilling_Method");
		SleepUtils.sleep(2);
		uiDriver.setValue("ViewPolicies_Producer.lstBilling_Method", input.get("Select@BillingMethodDB"));
		SleepUtils.sleep(2);
		uiDriver.sendKey("tab");
		SleepUtils.sleep(3);
		
		// 9. Verify Exceptions
		String billingMethod = uiDriver.th.getCellData("ViewPolicies_Producer.tblExceptions", 0, 11);
		if (billingMethod.equals("Direct Bill")) {
			passed("verifyText", "verifyText should pass", "verifyText passed");
		} else {
			failed("verifyText", "verifyText should pass", "verifyText failed");
		}
		SleepUtils.sleep(3);
		
		String Exception = uiDriver.th.getCellData("ViewPolicies_Producer.tblExceptions", 0, 12);
		if (!Exception.equals("")) {
			passed("verifyText", "verifyText should pass", "verifyText passed");
		} else {
			failed("verifyText", "verifyText should pass", "verifyText failed");
		}
		SleepUtils.sleep(3);
		
		// 10. Select $data from the Billing_Method list
		uiDriver.click("ViewPolicies_Producer.lstBilling_Method");
		SleepUtils.sleep(2);
		uiDriver.setValue("ViewPolicies_Producer.lstBilling_Method", input.get("Select@BillingMethodAB"));
		SleepUtils.sleep(2);
		uiDriver.sendKey("tab");

		// 11. Verify Exceptions
		String billingMethodAb = uiDriver.th.getCellData("ViewPolicies_Producer.tblExceptions", 0, 11);
		if (billingMethodAb.equals("Agency Bill")) {
			passed("verifyText", "verifyText should pass", "verifyText passed");
		} else {
			failed("verifyText", "verifyText should pass", "verifyText failed");
		}
		
		
		String ExceptionAb = uiDriver.th.getCellData("ViewPolicies_Producer.tblExceptions", 0, 12);
		if (ExceptionAb.equals("No")) {
			passed("verifyText", "verifyText should pass", "verifyText passed");
		} else {
			failed("verifyText", "verifyText should pass", "verifyText failed");
		}
		SleepUtils.sleep(3);
		
		// 12. Verify whether the Account_ element present
		if (uiDriver.checkElementPresent("ViewPolicies_Producer.eltAccount_")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		// 13. Verify whether the Policy_ element present
		if (uiDriver.checkElementPresent("ViewPolicies_Producer.eltPolicy_")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		// 14. Verify whether the Insured element present
		if (uiDriver.checkElementPresent("ViewPolicies_Producer.eltInsured_")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		// 15. Verify whether the Eff_Date element present
		if (uiDriver.checkElementPresent("ViewPolicies_Producer.eltEff_Date")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		// 16. Verify whether the Exp_Date element present
		if (uiDriver.checkElementPresent("ViewPolicies_Producer.eltExp_Date")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		// 17. Verify whether the Product element present
		if (uiDriver.checkElementPresent("ViewPolicies_Producer.eltProduct")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		// 18. Verify whether the Producer_Code element present
		if (uiDriver.checkElementPresent("ViewPolicies_Producer.eltProducer_Code")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		// 19. Verify whether the Role element present
		if (uiDriver.checkElementPresent("ViewPolicies_Producer.eltRole")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		// 20. Verify whether the Premium element present
		if (uiDriver.checkElementPresent("ViewPolicies_Producer.eltPremium")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		// 21. Verify whether the Paid element present
		if (uiDriver.checkElementPresent("ViewPolicies_Producer.eltPaid")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		// 22. Verify whether the Balance element present
		if (uiDriver.checkElementPresent("ViewPolicies_Producer.eltBalance")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		// 23. Verify whether the Billing_Method element present
		if (uiDriver.checkElementPresent("ViewPolicies_Producer.eltBilling_Method")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		// 24. Verify whether the Exceptions element present
		if (uiDriver.checkElementPresent("ViewPolicies_Producer.eltExceptions")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		// 25. Select $data from the Billing_Method list
		uiDriver.click("ViewPolicies_Producer.lstBilling_Method");
		SleepUtils.sleep(2);
		uiDriver.setValue("ViewPolicies_Producer.lstBilling_Method", input.get("Select@BillingMethodDB"));
		SleepUtils.sleep(2);
		uiDriver.sendKey("tab");

		// 26. Verify Direct_Bill_Premium
		String Premium = uiDriver.th.getCellData("ViewPolicies_Producer.tblExceptions", 0, 8);
		if (!Premium.equals("")) {
			passed("verifyText", "verifyText should pass", "verifyText passed");
		} else {
			failed("verifyText", "verifyText should pass", "verifyText failed");
		}
		SleepUtils.sleep(3);
		
		// 27. Select $data from the Billing_Method list
		uiDriver.click("ViewPolicies_Producer.lstBilling_Method");
		SleepUtils.sleep(2);
		uiDriver.setValue("ViewPolicies_Producer.lstBilling_Method", input.get("Select@BillingMethodAB"));
		SleepUtils.sleep(2);
		uiDriver.sendKey("tab");

		// 28. Verify Agency_Bill_Premium
		String AgencyPremium = uiDriver.th.getCellData("ViewPolicies_Producer.tblExceptions", 0, 8);
		if (!AgencyPremium.equals("")) {
			passed("verifyText", "verifyText should pass", "verifyText passed");
		} else {
			failed("verifyText", "verifyText should pass", "verifyText failed");
		}
		SleepUtils.sleep(3);
		
		// 29. Read the value from Premium field and store in $data variable
		uiDriver.click("ViewPolicies_Producer.lstBilling_Method");
		SleepUtils.sleep(2);
		uiDriver.setValue("ViewPolicies_Producer.lstBilling_Method", input.get("Select@BillingMethodDB"));
		SleepUtils.sleep(2);
		uiDriver.sendKey("tab");

		// 30. Read the value from Paid field and store in $data variable
		String AgencyPremium1 = uiDriver.th.getCellData("ViewPolicies_Producer.tblExceptions", 0, 8);
		if (AgencyPremium1.contains(".00")) {
			String[] AgencyPremium2 = AgencyPremium1.split(".00");
			int Ap = Integer.parseInt(uiDriver.ConvertStringToInteger(AgencyPremium2[0], "$|,"));
			String Paid = uiDriver.th.getCellData("ViewPolicies_Producer.tblExceptions", 0, 9);
			int diff;
			if (Paid.contains("-")) {
				int Pd = 0;
				diff = Math.abs(Ap - Pd);
			} else {
				String[] Paid1 = Paid.split(".00");
				int Pd = Integer.parseInt(uiDriver.ConvertStringToInteger(Paid1[0], "$|,"));
				diff = Math.abs(Ap - Pd);
			}

			// 31. Verify Balance
			String Balance = uiDriver.th.getCellData("ViewPolicies_Producer.tblExceptions", 0, 10);
			if (Balance.substring(0).contains("(")) {
				String Balance1 = Balance.substring(2);
				String Balance2 = Balance1.replace(")", "");
				String Balance3 = Balance2.replace(".00", "");
				// String Bal1=uiDriver.ConvertStringToInteger(Balance1[0],"$|,");
				String Bal3 = Balance3.replace(",", "");
				int Bal = Integer.parseInt(Bal3);
				if (diff == Bal) {
					passed("verifyText::" + diff, "verifyText should pass::" + Bal, "verifyText passed");
				} else {
					failed("verifyText" + diff, "verifyText should pass" + Bal, "verifyText failed");
				}
			} else if (Balance.substring(0).contains("$")) {
				String[] Balance1 = Balance.split(".00");
				int Bal = Integer.parseInt(uiDriver.ConvertStringToInteger(Balance1[0], "$|,"));
				if (diff == Bal) {
					passed("verifyText::" + diff, "verifyText should pass::" + Bal, "verifyText passed");
				} else {
					failed("verifyText::" + diff, "verifyText should pass::" + Bal, "verifyText failed");
				}
			} else {
				passed("verify Balance::" + AgencyPremium1, "Equal of Premium subtraction of paid should pass::" + Paid,
						"Verify Balance passed");

			}
		}

		// 32. Click on Details WebElement
		uiDriver.click("ViewPolicies_Producer.eltDetails");
		SleepUtils.sleep(3);
		
		// 33. Verify whether the Account_ element present
		SleepUtils.sleep(3);
		if (uiDriver.checkElementPresent("ViewPolicies_Producer.eltAccount_")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		// 34. Verify whether the Policy_ element present
		if (uiDriver.checkElementPresent("ViewPolicies_Producer.eltPolicy_")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		// 35. Verify whether the Insured_ element present
		if (uiDriver.checkElementPresent("ViewPolicies_Producer.eltInsured_")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		// 36. Verify whether the Eff_Date element present
		if (uiDriver.checkElementPresent("ViewPolicies_Producer.eltEff_Date")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		// 37. Verify whether the Exp_Date element present
		if (uiDriver.checkElementPresent("ViewPolicies_Producer.eltExp_Date")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		// 38. Verify whether the Product element present
		if (uiDriver.checkElementPresent("ViewPolicies_Producer.eltProduct")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		// 39. Verify whether the Producer_Code element present
		if (uiDriver.checkElementPresent("ViewPolicies_Producer.eltProducer_Code")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		// 40. Verify whether the Pol_Value element present
		if (uiDriver.checkElementPresent("ViewPolicies_Producer.eltPol_Value")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		// 41. Verify whether the Comm_Basis element present
		if (uiDriver.checkElementPresent("ViewPolicies_Producer.eltComm_Basis")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		// 42. Verify whether the Comm_Rate element present
		if (uiDriver.checkElementPresent("ViewPolicies_Producer.eltComm_Rate")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		// 43. Verify whether the Total_Comm element present
		if (uiDriver.checkElementPresent("ViewPolicies_Producer.eltTotal_Comm")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		// 44. Verify whether the Commission_Rsv element present
		if (uiDriver.checkElementPresent("ViewPolicies_Producer.eltCommission_Rsv")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(3);
		
		// 45. Verify whether the Comm_Paid element present
		if (uiDriver.checkElementPresent("ViewPolicies_Producer.eltComm_Paid")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(3);
	}

	/**
	 * Overriding toString() method of object class to print Producer format string
	 **/
	public String toString() {
		return "ProducerDriver";
	}
}