/******************************************************************************
Created by : Capgemini Automation Team 
Created\Updated on : 3/1/2018 2:52:12 AM
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
public class US1387_Recharge_FeeDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;

	public US1387_Recharge_FeeDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}

	public void TC02_newlyaddedfieldstodropdo(DataRow input, DataRow output) {
		// 1. Click on Account WebElement
		uiDriver.click("TC02_newlyaddedfieldstodropdo.eltAccount");
		SleepUtils.sleep(2);

		// 2. Type $data in Account_Name field
		uiDriver.setValue("TC02_newlyaddedfieldstodropdo.txtAccount_Name", input.get("Type@Account_Name"));
		SleepUtils.sleep(2);

		// 3. Click on Search button
		uiDriver.click("TC02_newlyaddedfieldstodropdo.btnSearch");
		SleepUtils.sleep(2);

		// 4. Verify whether the Account link is present
		if (uiDriver.checkElementPresent("TC02_newlyaddedfieldstodropdo.lnkAccount")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(2);

		// 5. Click on Account_ Link
		uiDriver.click("TC02_newlyaddedfieldstodropdo.lnkAccount_");
		SleepUtils.sleep(2);

		// 6. Click on Actions button
		uiDriver.click("TC02_newlyaddedfieldstodropdo.btnActions");
		SleepUtils.sleep(2);

		// 7. Click on New_Transaction WebElement
		uiDriver.click("TC02_newlyaddedfieldstodropdo.eltNew_Transaction");
		SleepUtils.sleep(2);

		// 8. Click on Recharge_Fee WebElement
		uiDriver.click("TC02_newlyaddedfieldstodropdo.eltRecharge_Fee");
		SleepUtils.sleep(2);

		// 9. Click on Next button
		uiDriver.click("TC02_newlyaddedfieldstodropdo.btnNext");
		SleepUtils.sleep(2);

		// 10. Click on Category WebElement
		uiDriver.click("TC02_newlyaddedfieldstodropdo.eltCategory");
		SleepUtils.sleep(2);

		// 11. Verify whether the Installment_Fee element present
		if (uiDriver.checkElementPresent("TC02_newlyaddedfieldstodropdo.eltInstallment_Fee")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(4);

		// 12. Verify whether the Payment_Reversal_Fee element present
		if (uiDriver.checkElementPresent("TC02_newlyaddedfieldstodropdo.eltPayment_Reversal_Fee")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 13. Click on Cancel button
		uiDriver.click("TC02_newlyaddedfieldstodropdo.btnCancel");

		// 14. Click on ok button
		uiDriver.click("TC02_newlyaddedfieldstodropdo.btnOk");

	}

	public void TC03_VerifytocreatetheRechar_(DataRow input, DataRow output) {
		// 1. Click on Account WebElement
		uiDriver.click("TC03_VerifytocreatetheRechar_.eltAccount");
		SleepUtils.sleep(3);

		// 2. Type $data in Account_Name field
		uiDriver.setValue("TC03_VerifytocreatetheRechar_.txtAccount_Name", input.get("Type@Account_Name"));
		SleepUtils.sleep(3);

		// 3. Click on Search button
		uiDriver.click("TC03_VerifytocreatetheRechar_.btnSearch");
		SleepUtils.sleep(3);

		// 4. Verify whether the Account link is present
		if (uiDriver.checkElementPresent("TC03_VerifytocreatetheRechar_.lnkAccount")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 5. Click on Account_ Link
		SleepUtils.sleep(3);
		uiDriver.click("TC03_VerifytocreatetheRechar_.lnkAccount_");
		SleepUtils.sleep(2);

		// 6. Click on Actions button
		uiDriver.click("TC03_VerifytocreatetheRechar_.btnActions");
		SleepUtils.sleep(2);

		// 7. Click on New_Transaction WebElement
		uiDriver.click("TC03_VerifytocreatetheRechar_.eltNew_Transaction");
		SleepUtils.sleep(3);

		// 8. Click on Recharge_Fee WebElement
		uiDriver.click("TC03_VerifytocreatetheRechar_.eltRecharge_Fee");
		SleepUtils.sleep(3);

		// 9. Click on Next button
		uiDriver.click("TC03_VerifytocreatetheRechar_.btnNext");
		SleepUtils.sleep(3);

		// 10. Click Category
		uiDriver.click("TC03_VerifytocreatetheRechar_.txtCategory");
		SleepUtils.sleep(3);

		// 11. Select $data from the Category list
		uiDriver.setValue("TC03_VerifytocreatetheRechar_.lstCategory", input.get("Select@Category#1"));
		SleepUtils.sleep(3);
		uiDriver.sendKey("tab");
		SleepUtils.sleep(3);

		// 12. Type $data in Amount field
		uiDriver.setValue("TC03_VerifytocreatetheRechar_.txtAmount", input.get("Type@Amount#1"));
		SleepUtils.sleep(3);

		// 13. Click on Finish button
		uiDriver.click("TC03_VerifytocreatetheRechar_.btnFinish");
		SleepUtils.sleep(10);
		if (!uiDriver.checkElementPresent("TC03_VerifytocreatetheRechar_.eltHistory")) {
			uiDriver.click("TC03_VerifytocreatetheRechar_.btnFinish");
		}
		SleepUtils.sleep(3);
		if (uiDriver.checkElementPresent("TC03_VerifytocreatetheRechar_.lstCategory")) {
			String lstCategory = uiDriver.getControl("TC03_VerifytocreatetheRechar_.lstCategory").getAttribute("value");
			if (lstCategory.equals("<none>")) {
				uiDriver.click("TC03_VerifytocreatetheRechar_.txtCategory");
				SleepUtils.sleep(3);
				uiDriver.setValue("TC03_VerifytocreatetheRechar_.lstCategory", input.get("Select@Category#1"));
				SleepUtils.sleep(3);
				uiDriver.sendKey("tab");
				SleepUtils.sleep(3);
				uiDriver.click("TC03_VerifytocreatetheRechar_.btnFinish");
			}
		}
		SleepUtils.sleep(3);

		// 14. Click on History WebElement
		uiDriver.click("TC03_VerifytocreatetheRechar_.eltHistory");
		SleepUtils.sleep(3);

		// 15. Click Filter_by_Type
		uiDriver.click("TC03_VerifytocreatetheRechar_.txtFilter_by_Type");
		SleepUtils.sleep(2);

		// 16. Select $data from the Filter_by_Type list
		uiDriver.setValue("TC03_VerifytocreatetheRechar_.lstFilter_by_Type", input.get("Select@Filter_by_Type#1"));
		SleepUtils.sleep(3);
		uiDriver.sendKey("tab");
		SleepUtils.sleep(3);

		// 17. Click on Actions button
		uiDriver.click("TC03_VerifytocreatetheRechar_.btnActions_1");

		// 18. Click on New_Transaction WebElement
		uiDriver.click("TC03_VerifytocreatetheRechar_.eltNew_Transaction_1");

		// 19. Click on Recharge_Fee WebElement
		uiDriver.click("TC03_VerifytocreatetheRechar_.eltRecharge_Fee_1");

		// 20. Click on Next button
		uiDriver.click("TC03_VerifytocreatetheRechar_.btnNext_1");

		// 21. Click Category
		uiDriver.click("TC03_VerifytocreatetheRechar_.txtCategory_1");

		// 22. Select $data from the Category list
		uiDriver.setValue("TC03_VerifytocreatetheRechar_.lstCategory_1", input.get("Select@Category#2"));
		SleepUtils.sleep(3);
		uiDriver.sendKey("tab");
		SleepUtils.sleep(3);

		// 23. Type $data in Amount field
		uiDriver.setValue("TC03_VerifytocreatetheRechar_.txtAmount_1", input.get("Type@Amount#2"));

		// 24. Click on Finish button
		uiDriver.click("TC03_VerifytocreatetheRechar_.btnFinish_1");
		SleepUtils.sleep(15);

		// 25. Click on History WebElement
		uiDriver.click("TC03_VerifytocreatetheRechar_.eltHistory_1");

		// 26. Click Filter_by_Type
		uiDriver.click("TC03_VerifytocreatetheRechar_.txtFilter_by_Type_1");

		// 27. Select $data from the Filter_by_Type list
		uiDriver.setValue("TC03_VerifytocreatetheRechar_.lstFilter_by_Type_1", input.get("Select@Filter_by_Type#2"));
		SleepUtils.sleep(3);
		uiDriver.sendKey("tab");
		SleepUtils.sleep(3);

	}

	public void TC04_Verifythegeneraltranext(DataRow input, DataRow output) {
		// 1. Click on Administration WebElement
		uiDriver.click("TC04_Verifythegeneraltranext.eltAdministration");
		SleepUtils.sleep(3);

		uiDriver.click("TC04_Verifythegeneraltranext.eltRoles");
		SleepUtils.sleep(3);

		// 2. Type $data in Paging field
		uiDriver.setValue("TC04_Verifythegeneraltranext.txtPaging", input.get("Type@Paging"));
		uiDriver.sendKey("Enter");
		SleepUtils.sleep(3);

		// 3. Click on Executive WebElement
		uiDriver.click("TC04_Verifythegeneraltranext.eltExecutive");
		SleepUtils.sleep(3);

		// 4. Type $data in Paging_1 field
		uiDriver.setValue("TC04_Verifythegeneraltranext.txtPaging_1", input.get("Type@Paging_1"));
		uiDriver.sendKey("Enter");
		SleepUtils.sleep(3);
		uiDriver.th.getCellDataOfCol("TC04_Verifythegeneraltranext.tblPermissions", "generaltranext", 1);
		SleepUtils.sleep(3);

		// 5. Click on Account WebElement
		uiDriver.click("TC04_Verifythegeneraltranext.eltAccount");
		SleepUtils.sleep(3);

		// 6. Type $data in Account_Name field
		uiDriver.setValue("TC04_Verifythegeneraltranext.txtAccount_Name", input.get("Type@Account_Name"));
		SleepUtils.sleep(3);

		// 7. Click on Search button
		uiDriver.click("TC04_Verifythegeneraltranext.btnSearch");
		SleepUtils.sleep(3);

		// 8. Verify whether the Account link is present
		if (uiDriver.checkElementPresent("TC04_Verifythegeneraltranext.lnkAccount")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 9. Click on Account_ Link
		SleepUtils.sleep(3);
		uiDriver.click("TC04_Verifythegeneraltranext.lnkAccount_");
		SleepUtils.sleep(3);

		// 10. Click on Actions button
		uiDriver.click("TC04_Verifythegeneraltranext.btnActions");
		SleepUtils.sleep(3);

		// 11. Click on New_Transaction WebElement
		uiDriver.click("TC04_Verifythegeneraltranext.eltNew_Transaction");
		SleepUtils.sleep(3);

		// 12. Click on Recharge_Fee WebElement
		uiDriver.click("TC04_Verifythegeneraltranext.eltRecharge_Fee");
		SleepUtils.sleep(3);

		// 13. Click on Next button
		uiDriver.click("TC04_Verifythegeneraltranext.btnNext");
		SleepUtils.sleep(3);

		// 14. Click Category
		uiDriver.click("TC04_Verifythegeneraltranext.txtCategory");
		SleepUtils.sleep(3);

		// 15. Select $data from the Category list
		uiDriver.setValue("TC04_Verifythegeneraltranext.lstCategory", input.get("Select@Category#1"));
		SleepUtils.sleep(3);
		uiDriver.sendKey("tab");
		SleepUtils.sleep(3);

		// 16. Type $data in Amount field
		uiDriver.setValue("TC04_Verifythegeneraltranext.txtAmount", input.get("Type@Amount#1"));
		SleepUtils.sleep(3);

		// 17. Click on Finish button
		uiDriver.click("TC04_Verifythegeneraltranext.btnFinish");
		SleepUtils.sleep(3);

		// 18. Click on Actions button
		uiDriver.click("TC04_Verifythegeneraltranext.btnActions");
		SleepUtils.sleep(3);

		// 19. Click on New_Transaction WebElement
		uiDriver.click("TC04_Verifythegeneraltranext.eltNew_Transaction");
		SleepUtils.sleep(3);

		// 20. Click on Recharge_Fee WebElement
		uiDriver.click("TC04_Verifythegeneraltranext.eltRecharge_Fee");
		SleepUtils.sleep(3);

		// 21. Click on Next button
		uiDriver.click("TC04_Verifythegeneraltranext.btnNext");
		SleepUtils.sleep(3);

		// 22. Click Category
		uiDriver.click("TC04_Verifythegeneraltranext.txtCategory");
		SleepUtils.sleep(3);

		// 23. Select $data from the Category list
		uiDriver.setValue("TC04_Verifythegeneraltranext.lstCategory", input.get("Select@Category#2"));
		SleepUtils.sleep(3);
		uiDriver.sendKey("tab");
		SleepUtils.sleep(3);

		// 24. Type $data in Amount field
		uiDriver.setValue("TC04_Verifythegeneraltranext.txtAmount", input.get("Type@Amount#2"));

		// 25. Click on Finish button
		uiDriver.click("TC04_Verifythegeneraltranext.btnFinish");
		SleepUtils.sleep(3);
	}

	public void TC11_VerifyAcceptanceCriter(DataRow input, DataRow output) {
		// 1. Click on Account WebElement
		uiDriver.click("TC11_VerifyAcceptanceCriter.eltAccount");
		SleepUtils.sleep(3);

		// 2. Type $data in Account_Name field
		uiDriver.setValue("TC11_VerifyAcceptanceCriter.txtAccount_Name", input.get("Type@Account_Name"));
		SleepUtils.sleep(3);

		// 3. Click on Search button
		uiDriver.click("TC11_VerifyAcceptanceCriter.btnSearch");
		SleepUtils.sleep(3);

		// 4. Verify whether the Account link is present
		if (uiDriver.checkElementPresent("TC11_VerifyAcceptanceCriter.lnkAccount")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 5. Click on Account_ Link
		SleepUtils.sleep(2);
		uiDriver.click("TC11_VerifyAcceptanceCriter.lnkAccount_");
		SleepUtils.sleep(3);

		// 6. Click on Actions button
		uiDriver.click("TC11_VerifyAcceptanceCriter.btnActions");
		SleepUtils.sleep(3);

		// 7. Click on New_Transaction WebElement
		uiDriver.click("TC11_VerifyAcceptanceCriter.eltNew_Transaction");
		SleepUtils.sleep(3);

		// 8. Click on Recharge_Fee WebElement
		uiDriver.click("TC11_VerifyAcceptanceCriter.eltRecharge_Fee");
		SleepUtils.sleep(3);

		// 9. Click on Set_Account_as_Transaction_Owner button
		uiDriver.click("TC11_VerifyAcceptanceCriter.btnSet_Account_as_Transaction_Owner");
		SleepUtils.sleep(3);

		// 10. Click on Next button
		uiDriver.click("TC11_VerifyAcceptanceCriter.btnNext");
		SleepUtils.sleep(3);

		// 11. Click Category
		uiDriver.click("TC11_VerifyAcceptanceCriter.txtCategory");
		SleepUtils.sleep(3);

		// 12. Select $data from the Category list
		uiDriver.setValue("TC11_VerifyAcceptanceCriter.lstCategory", input.get("Select@Category#1"));
		SleepUtils.sleep(3);
		uiDriver.sendKey("tab");
		SleepUtils.sleep(3);

		// 13. Type $data in Amount field
		uiDriver.setValue("TC11_VerifyAcceptanceCriter.txtAmount", input.get("Type@Amount#1"));
		SleepUtils.sleep(3);

		// 14. Click on Finish button
		uiDriver.click("TC11_VerifyAcceptanceCriter.btnFinish");
		SleepUtils.sleep(3);

		// 15. Verify whether the Warningmsg element present
		if (uiDriver.checkElementPresent("TC11_VerifyAcceptanceCriter.eltWarningmsg")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(2);

		// 16. Click on Cancel button
		uiDriver.click("TC11_VerifyAcceptanceCriter.btnCancel");
		SleepUtils.sleep(3);

		// 17. Click on Ok button
		uiDriver.click("TC11_VerifyAcceptanceCriter.btnOk");
		SleepUtils.sleep(3);

		// 18. Click on Actions_1 button
		uiDriver.click("TC11_VerifyAcceptanceCriter.btnActions_1");
		SleepUtils.sleep(3);

		// 19. Click on New_Transaction_1 WebElement
		uiDriver.click("TC11_VerifyAcceptanceCriter.eltNew_Transaction_1");
		SleepUtils.sleep(3);

		// 20. Click on Recharge_Fee_1 WebElement
		uiDriver.click("TC11_VerifyAcceptanceCriter.eltRecharge_Fee_1");
		SleepUtils.sleep(3);

		// 21. Click on Set_Account_as_Transaction_Owner_1 button
		uiDriver.click("TC11_VerifyAcceptanceCriter.btnSet_Account_as_Transaction_Owner_1");
		SleepUtils.sleep(3);

		// 22. Click on Next_1 button
		uiDriver.click("TC11_VerifyAcceptanceCriter.btnNext_1");
		SleepUtils.sleep(3);

		// 23. Click Category_1
		uiDriver.click("TC11_VerifyAcceptanceCriter.txtCategory_1");
		SleepUtils.sleep(3);

		// 24. Select $data from the Category_1 list
		uiDriver.setValue("TC11_VerifyAcceptanceCriter.lstCategory_1", input.get("Select@Category#2"));
		SleepUtils.sleep(3);
		uiDriver.sendKey("tab");
		SleepUtils.sleep(3);

		// 25. Type $data in Amount_1 field
		uiDriver.setValue("TC11_VerifyAcceptanceCriter.txtAmount_1", input.get("Type@Amount#2"));
		SleepUtils.sleep(3);

		// 26. Click on Finish_1 button
		uiDriver.click("TC11_VerifyAcceptanceCriter.btnFinish_1");
		SleepUtils.sleep(3);

		// 27. Verify whether the Warningmsg_1 element present
		if (uiDriver.checkElementPresent("TC11_VerifyAcceptanceCriter.eltWarningmsg_1")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(2);

		// 28. Click on Cancel_1 button
		uiDriver.click("TC11_VerifyAcceptanceCriter.btnCancel_1");
		SleepUtils.sleep(3);

		// 29.Click on Ok_1 button
		uiDriver.click("TC11_VerifyAcceptanceCriter.btnOk_1");
		SleepUtils.sleep(3);
	}

	/**
	 * Overriding toString() method of object class to print US1387_Recharge_Fee
	 * format string
	 **/
	public String toString() {
		return "US1387_Recharge_FeeDriver";
	}
}