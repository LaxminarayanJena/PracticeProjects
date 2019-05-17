/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 1/18/2018 1:27:32 AM
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
public class Create_ActivitiesDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;

	public Create_ActivitiesDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}

	public void Create_New_Manual_Activity(DataRow input, DataRow output) {

		// 1. Click on Desktop WebElement
		uiDriver.click("Create_New_Manual_Activity.eltDesktop");
		SleepUtils.sleep(4);
		
		// 2. Click on Actions WebElement
		uiDriver.click("Create_New_Manual_Activity.eltActions");
		SleepUtils.sleep(4);
		
		// 3. MouseOver on New_Assigned_Activity WebElement
		uiDriver.mouseOver("Create_New_Manual_Activity.eltNew_Assigned_Activity");
		SleepUtils.sleep(4);
		
		// 4. Click on Request WebElement
		uiDriver.mouseOver("Create_New_Manual_Activity.eltRequest");
		SleepUtils.sleep(4);
		
		// 5. Verify whether the Request_for_Direct_Bill_Team element present
		if (uiDriver.checkElementPresent("Create_New_Manual_Activity.eltRequest_for_Direct_Bill_Team")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(4);
		
		// 6. Click on Request_for_Direct_Bill_Team WebElement
		uiDriver.click("Create_New_Manual_Activity.eltRequest_for_Direct_Bill_Team");
		SleepUtils.sleep(4);

		// 7. Verify whether the New_Activity element present
		if (uiDriver.checkElementPresent("Create_New_Manual_Activity.eltNew_Activity")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(4);

		// 8. Click on SearchForAssignee WebElement
		uiDriver.click("Create_New_Manual_Activity.eltSearchForAssignee");
		SleepUtils.sleep(4);
		
		// 9. Type $data in User_Name field
		uiDriver.setValue("Create_New_Manual_Activity.txtUser_Name", System.getProperty("user.name"));
		SleepUtils.sleep(4);
		
		// 10. Click on Search button
		uiDriver.click("Create_New_Manual_Activity.btnSearch");
		SleepUtils.sleep(4);

		// 11. Verify whether the Assign element present
		if (uiDriver.checkElementPresent("Create_New_Manual_Activity.eltAssign")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(4);
		
		// 12. Click on Assign button
		uiDriver.click("Create_New_Manual_Activity.eltAssign");
		SleepUtils.sleep(3);

		// 13. Click on Update button
		uiDriver.click("Create_New_Manual_Activity.btnUpdate");
		SleepUtils.sleep(4);

		// 14. Verify whether the Request for Direct Bill Team present
		String Searchstring = input.get("Verify@User_Name");
		SleepUtils.sleep(4);
		
	}

	public void Create_New_Activity_Pattern(DataRow input, DataRow output) {

		// 1. Click on administration WebElement
		uiDriver.click("Create_New_Activity_Pattern.eltadministration");
		SleepUtils.sleep(4);

		// 2. Click on Business_Settings WebElement
		uiDriver.click("Create_New_Activity_Pattern.eltBusiness_Settings");
		SleepUtils.sleep(4);
		
		// 3. Select $data from the Category list
		uiDriver.click("Create_New_Activity_Pattern.lstCategory");
		SleepUtils.sleep(2);
		uiDriver.setValue("Create_New_Activity_Pattern.lstCategory", input.get("Select@Category"));
		SleepUtils.sleep(1);
		uiDriver.sendKey("tab");

		// 4. Click on Request_for_Direct_Bill_Team Link
		SleepUtils.sleep(4);
		String PageEnd=uiDriver.getControl("Create_New_Activity_Pattern.eltActivitypatterns").getText();
        String num=PageEnd.substring(2).trim();
        int PageLenth=Integer.parseInt(num);
        int i;
        for(i=0;i<=PageLenth-1;i++) {
               uiDriver.click("Create_New_Activity_Pattern.btnArrowforward");
               SleepUtils.sleep(4);
               if (uiDriver.checkElementPresent("Create_New_Activity_Pattern.lnkRequest_for_Direct_Bill_Team")) {
            	   uiDriver.th.findRelativeCellAndClick("Create_New_Activity_Pattern.lnkRequest_for_Direct_Bill_Team", "Request for Direct Bill Team",
           				1, "Request for Direct Bill Team");
                     SleepUtils.sleep(4);
                     break;
                     
               }
               
        }
       

		// 5. Click on Edit button
		uiDriver.click("Create_New_Activity_Pattern.btnEdit");
		SleepUtils.sleep(4);

		// 6. Verify the text $data in the Subject field
		if (uiDriver.verifyTextforWebEdit("Create_New_Activity_Pattern.txtSubject", input.get("VerifyText@Subject"))) {
			passed("verifyText", "verifyText should pass", "verifyText passed");
		} else {
			failed("verifyText", "verifyText should pass", "verifyText failed");
		}
		SleepUtils.sleep(4);
		
		// 7. Verify the text ?$data in the Category list
		uiDriver.click("Create_New_Activity_Pattern.ActivityPatternlstCategory");
		SleepUtils.sleep(4);
		uiDriver.checkDropDownOptions("li", input.get("VerifyText@Category"));
		uiDriver.sendKey("tab");
		SleepUtils.sleep(5);
        
		// 8. Verify the text ?$data in the Priority list
		uiDriver.click("Create_New_Activity_Pattern.lstPriority");
		SleepUtils.sleep(4);
		uiDriver.checkDropDownOptions("li", input.get("VerifyText@Priority"));
		uiDriver.sendKey("tab");
		SleepUtils.sleep(5);
		
		// 9. Verify the text ?$data in the Mandatory field
		String rdoMandatory = uiDriver.getControl("Create_New_Activity_Pattern.eltMandatory").getAttribute("tabindex");

		if (rdoMandatory.equalsIgnoreCase("-1")) {
			passed("verify radiogroup selectd", "verify radiogroup selectd should pass", "verify radiogroup passed");
		} else {
			failed("verify radiogroup selectd", "verify radiogroup selectd should pass", "verify radiogroup failed");
		}
       SleepUtils.sleep(3);
       
		// 10. Verify the text ?$data in the Is_Locked field
		String rdoLocked = uiDriver.getControl("Create_New_Activity_Pattern.eltIs_Locked").getAttribute("tabindex");

		if (rdoLocked.equalsIgnoreCase("-1")) {
			passed("verify radiogroup selectd", "verify radiogroup selectd should pass", "verify radiogroup passed");
		} else {
			failed("verify radiogroup selectd", "verify radiogroup selectd should pass", "verify radiogroup failed");
		}
		SleepUtils.sleep(3);
		
		// 11. Verify the text ?$data in the Description field
		if (uiDriver.verifyTextforWebEdit("Create_New_Activity_Pattern.eltDescription",
				input.get("VerifyText@Description"))) {
			passed("verifyText", "verifyText should pass", "verifyText passed");
		} else {
			failed("verifyText", "verifyText should pass", "verifyText failed");
		}
		SleepUtils.sleep(3);
		
		// 12. Verify the text $data in the Target_Days field
		if (uiDriver.verifyTextforWebEdit("Create_New_Activity_Pattern.txtTarget_Days",
				input.get("VerifyText@Target_Days"))) {
			passed("verifyText", "verifyText should pass", "verifyText passed");
		} else {
			failed("verifyText", "verifyText should pass", "verifyText failed");
		}
		SleepUtils.sleep(3);
		
		// 13. Verify the text $data in the Escalation_Days field
		if (uiDriver.verifyTextforWebEdit("Create_New_Activity_Pattern.txtEscalation_Days",
				input.get("VerifyText@Escalation_Days"))) {
			passed("verifyText", "verifyText should pass", "verifyText passed");
		} else {
			failed("verifyText", "verifyText should pass", "verifyText failed");
		}
		SleepUtils.sleep(4);
		
		// 14. Click on administration WebElement
		uiDriver.click("Create_New_Activity_Pattern.eltadministration");
		SleepUtils.sleep(4);

		// 15. Click on Business_Settings WebElement
		uiDriver.click("Create_New_Activity_Pattern.eltBusiness_Settings");
		SleepUtils.sleep(3);
		
		// 16. Select $data from the Category list
		uiDriver.click("Create_New_Activity_Pattern.lstCategory");
		SleepUtils.sleep(4);
		uiDriver.setValue("Create_New_Activity_Pattern.lstCategory", input.get("Select@Category"));
		SleepUtils.sleep(4);
		uiDriver.sendKey("tab");
		SleepUtils.sleep(2);

		// 17. Click on Request_for_Direct_Bill_Team Link
		String searchName1 = input.get("VerifyText@Subject1");
		uiDriver.th.getCellDataOfCol("Create_New_Activity_Pattern.lnkRequest_for_Direct_Bill_Team", searchName1, 1);
		SleepUtils.sleep(4);
		
		// 18. Click on administration WebElement
		uiDriver.click("Create_New_Activity_Pattern.eltadministration");
		SleepUtils.sleep(4);
		
		// 19. Click on Group WebElement
		uiDriver.click("Create_New_Activity_Pattern.eltGroup");
		SleepUtils.sleep(2);
		String searchName2 = input.get("VerifyText@Subject2");
		String text2 = input.get("VerifyText@Subject2");
		uiDriver.th.findRelativeCellAndClickSelectedCellInSubtext("Create_New_Activity_Pattern.tblGroup", searchName2,
				0, text2, text2, text2);
		SleepUtils.sleep(3);

		// 21. Click on Queues WebElement
		uiDriver.click("Create_New_Activity_Pattern.eltQueues");
		SleepUtils.sleep(2);

		// 22. Click on Request_for_Direct_Bill_Team Link
		String searchName3 = input.get("VerifyText@Subject3");
		uiDriver.th.getCellDataOfCol("Create_New_Activity_Pattern.tblGroupQueue", searchName3, 1);

	}

	public void Validte_Acti_Acc_Poli_Prod_Lev(DataRow input, DataRow output) {

		// 1. Click on Desktop WebElement
		uiDriver.click("Validte_Acti_Acc_Poli_Prod_Lev.eltDesktop");
		SleepUtils.sleep(4);
		
		// 2. Click on Actions WebElement
		uiDriver.click("Validte_Acti_Acc_Poli_Prod_Lev.eltActions");
		SleepUtils.sleep(4);

		// 3. Click on New_Assigned_Activity WebElement
		uiDriver.mouseOver("Validte_Acti_Acc_Poli_Prod_Lev.eltNew_Assigned_Activity");
		SleepUtils.sleep(4);

		// 4. Click on Reminder WebElement
		uiDriver.mouseOver("Validte_Acti_Acc_Poli_Prod_Lev.eltReminder");
		SleepUtils.sleep(4);

		// 5. Click on notification WebElement
		uiDriver.click("Validte_Acti_Acc_Poli_Prod_Lev.eltnotification");
		SleepUtils.sleep(4);

		// 6. Type $data in Subject field
		uiDriver.setValue("Validte_Acti_Acc_Poli_Prod_Lev.txtSubject", input.get("Type@Subject#1"));
		SleepUtils.sleep(4);
		
		// 7. Type $data in Description field
		uiDriver.setValue("Validte_Acti_Acc_Poli_Prod_Lev.txtDescription", input.get("Type@Description#1"));
		SleepUtils.sleep(4);

		// 8. Click on Producer_Image image
		uiDriver.click("Validte_Acti_Acc_Poli_Prod_Lev.imgProducer_Image");
		SleepUtils.sleep(4);
		
		// 9. Type $data in Producer_Code field
		uiDriver.setValue("Validte_Acti_Acc_Poli_Prod_Lev.txtProducer_Code", input.get("Type@Producer_Code#1"));
		SleepUtils.sleep(4);
		
		// 10. Click on Search button
		uiDriver.click("Validte_Acti_Acc_Poli_Prod_Lev.btnSearch_Producer");
		SleepUtils.sleep(4);

		// 11. Verify whether the Select button is present
		if (uiDriver.checkElementPresent("Validte_Acti_Acc_Poli_Prod_Lev.btnSelect")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(4);
		
		// 12. Click on Select button
		uiDriver.click("Validte_Acti_Acc_Poli_Prod_Lev.btnSelect");
		SleepUtils.sleep(4);
		
		// 13. Click on New_Activity_Update button
		uiDriver.click("Validte_Acti_Acc_Poli_Prod_Lev.btnNew_Activity_Update");
		SleepUtils.sleep(4);
		
		// 14. Click on Producer WebElement
		uiDriver.click("Validte_Acti_Acc_Poli_Prod_Lev.eltProducer");
		SleepUtils.sleep(4);

		// 15. Type Producer_Code $Parama1
		uiDriver.setValue("Validte_Acti_Acc_Poli_Prod_Lev.eltProducer_Code", input.get("Type@Producer_Code#1"));
		SleepUtils.sleep(4);
		
		// 16. Click on Search button
		uiDriver.click("Validte_Acti_Acc_Poli_Prod_Lev.btnSearch_Producer_Screen");
		SleepUtils.sleep(4);
		
		// 17. Click on Name WebElement
		uiDriver.click("Validte_Acti_Acc_Poli_Prod_Lev.eltName");
		SleepUtils.sleep(4);

		// 18. Click on Producer_Activities WebElement
		uiDriver.click("Validte_Acti_Acc_Poli_Prod_Lev.eltProducer_Activities");
		SleepUtils.sleep(4);

		// 19. Click on Producer_Subject_Link Link
//		String searchName = input.get("Type@Subject#1");
//		String text = input.get("Type@Subject#1");
//		String targettext = input.get("Type@Subject#1");
		uiDriver.th.findRelativeCellAndClickSelectedCell("Validte_Acti_Acc_Poli_Prod_Lev.lnkProducer_Subject_Link",
				"Producer Level", 6, "Producer Level", "Producer Level");
		SleepUtils.sleep(4);

		// 20. Verify whether the Producer_Create_Email_ button is present
		if (uiDriver.checkElementPresent("Validte_Acti_Acc_Poli_Prod_Lev.btnProducer_Create_Email")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(4);
		// 21. Click on Producer_Create_Email button
		uiDriver.click("Validte_Acti_Acc_Poli_Prod_Lev.btnProducer_Create_Email");
		uiDriver.sendKey("tab");
		uiDriver.sendKey("Enter");
		SleepUtils.sleep(3);

//		// 22. Type $data in New_Email_Name field
//		uiDriver.click("Validte_Acti_Acc_Poli_Prod_Lev.txtNew_Email_Name_1");
//		SleepUtils.sleep(4);
		
		uiDriver.setValue("Validte_Acti_Acc_Poli_Prod_Lev.txtNew_Email_Name", input.get("Type@New_Email_Name"));
		SleepUtils.sleep(4);
		
		// 23. Click on Find_contact button
		uiDriver.click("Validte_Acti_Acc_Poli_Prod_Lev.btnFind_contact");

		// 24. Verify whether the New_Email_Select_ button is present
		if (uiDriver.checkElementPresent("Validte_Acti_Acc_Poli_Prod_Lev.btnNew_Email_Select")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 25. Click on New_Email_Select button
		uiDriver.click("Validte_Acti_Acc_Poli_Prod_Lev.btnNew_Email_Select");
		SleepUtils.sleep(3);

		// 26. Type $data in New_Email_Subject field
		uiDriver.setValue("Validte_Acti_Acc_Poli_Prod_Lev.txtNew_Email_Subject", input.get("Type@New_Email_Subject"));
		SleepUtils.sleep(4);
		
		// 27. Type $data in New_Email_Body field
		uiDriver.setValue("Validte_Acti_Acc_Poli_Prod_Lev.txtNew_Email_Body", input.get("Type@New_Email_Body"));
		SleepUtils.sleep(4);
		
		// 28. Click on New_Email_Send_Email button
		uiDriver.click("Validte_Acti_Acc_Poli_Prod_Lev.btnNew_Email_Send_Email");
		SleepUtils.sleep(3);

		// 29. Click on Producer_Activity_Cancel button
		uiDriver.click("Validte_Acti_Acc_Poli_Prod_Lev.btnProducer_Activity_Cancel");
		SleepUtils.sleep(4);
		
		// 30. Click on Desktop WebElement
		uiDriver.click("Validte_Acti_Acc_Poli_Prod_Lev.eltDesktop");
		SleepUtils.sleep(4);
		
		// 31. Click on Actions WebElement
		uiDriver.click("Validte_Acti_Acc_Poli_Prod_Lev.eltActions");
		SleepUtils.sleep(1);

		// 32. Click on New_Assigned_Activity WebElement
		uiDriver.mouseOver("Validte_Acti_Acc_Poli_Prod_Lev.eltNew_Assigned_Activity");
		SleepUtils.sleep(1);

		// 33. Click on Reminder WebElement
		uiDriver.mouseOver("Validte_Acti_Acc_Poli_Prod_Lev.eltReminder");
		SleepUtils.sleep(4);
		
		// 34. Click on notification WebElement
		uiDriver.click("Validte_Acti_Acc_Poli_Prod_Lev.eltnotification");
		SleepUtils.sleep(4);
		
		// 35. Type $data in Subject field
		uiDriver.setValue("Validte_Acti_Acc_Poli_Prod_Lev.txtSubject", input.get("Type@Subject#2"));
		SleepUtils.sleep(4);
		
		// 36. Type $data in Description field
		uiDriver.setValue("Validte_Acti_Acc_Poli_Prod_Lev.txtDescription", input.get("Type@Description#2"));
		SleepUtils.sleep(4);
		
		// 37. Click on New_Activity_Account_Image WebElement
		uiDriver.click("Validte_Acti_Acc_Poli_Prod_Lev.eltNew_Activity_Account_Image");
		SleepUtils.sleep(4);
		
		// 38. Type $data in Account_Name field
		uiDriver.setValue("Validte_Acti_Acc_Poli_Prod_Lev.txtAccount_Name", input.get("Type@Account_Name"));
		SleepUtils.sleep(4);
		
		// 39. Click on Search button
		uiDriver.click("Validte_Acti_Acc_Poli_Prod_Lev.btnSearch_Account");
		SleepUtils.sleep(4);

		// 40. Verify whether the Account_Name link is present
		if (uiDriver.checkElementPresent("Validte_Acti_Acc_Poli_Prod_Lev.btnSelect")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(4);
		
		// 41. Click on Account_Name Link
		uiDriver.click("Validte_Acti_Acc_Poli_Prod_Lev.btnSelect");
		SleepUtils.sleep(4);

		// 42. Click on New_Activity_Update button
		uiDriver.click("Validte_Acti_Acc_Poli_Prod_Lev.btnNew_Activity_Update");
		SleepUtils.sleep(4);
		
		// 43. Click on Account WebElement
		uiDriver.click("Validte_Acti_Acc_Poli_Prod_Lev.eltAccount");
		SleepUtils.sleep(4);
		
		// 44. Type $data in Account_Name_in_Acc field
		uiDriver.setValue("Validte_Acti_Acc_Poli_Prod_Lev.txtAccount_Name_in_Acc",
				input.get("Type@Account_Name_in_Acc"));
		SleepUtils.sleep(3);

		// 45. Click on Search button
		uiDriver.click("Validte_Acti_Acc_Poli_Prod_Lev.btnSearch_Acc1");
		SleepUtils.sleep(3);

		// 46. Verify whether the Account_Name link is present
		if (uiDriver.checkElementPresent("Validte_Acti_Acc_Poli_Prod_Lev.lnkAccount_Name")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(4);
		
		// 47. Click on Account_Name Link
		uiDriver.click("Validte_Acti_Acc_Poli_Prod_Lev.lnkAccount_Name");
		SleepUtils.sleep(3);

		// 48. Click on Acc_Activites WebElement
		uiDriver.click("Validte_Acti_Acc_Poli_Prod_Lev.eltAcc_Activites");
		SleepUtils.sleep(3);
		uiDriver.click("Validte_Acti_Acc_Poli_Prod_Lev.eltAcc_Activites");
		SleepUtils.sleep(3);

		// 49. Click on Acc_Subject WebElement
		String searchName1 = input.get("Type@Subject#2");
		String text1 = input.get("Type@Subject#2");
		String targettext1 = input.get("Type@Subject#2");
		uiDriver.th.findRelativeCellAndClickSelectedCell("Validte_Acti_Acc_Poli_Prod_Lev.lnkAcc_Subject_Link",
				searchName1, 5, text1, targettext1);
		SleepUtils.sleep(4);
		
		// 50. Verify whether the Acc_Activity element present
		if (uiDriver.checkElementPresent("Validte_Acti_Acc_Poli_Prod_Lev.eltAcc_Activity")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(4);
		
		// 51. Click on Cancel button
		uiDriver.click("Validte_Acti_Acc_Poli_Prod_Lev.btnCancel");
		SleepUtils.sleep(4);

		// 52. Click on Desktop WebElement
		uiDriver.click("Validte_Acti_Acc_Poli_Prod_Lev.eltDesktop");
		SleepUtils.sleep(4);
		
		// 53. Click on Actions WebElement
		uiDriver.click("Validte_Acti_Acc_Poli_Prod_Lev.eltActions");
		SleepUtils.sleep(4);
		
		// 54. Click on New_Assigned_Activity WebElement
		uiDriver.mouseOver("Validte_Acti_Acc_Poli_Prod_Lev.eltNew_Assigned_Activity");
		SleepUtils.sleep(4);

		// 55. Click on Reminder WebElement
		uiDriver.mouseOver("Validte_Acti_Acc_Poli_Prod_Lev.eltReminder");
		SleepUtils.sleep(4);
		
		// 56. Click on notification WebElement
		uiDriver.click("Validte_Acti_Acc_Poli_Prod_Lev.eltnotification");
		SleepUtils.sleep(4);
		
		// 57. Type $data in Subject field
		uiDriver.setValue("Validte_Acti_Acc_Poli_Prod_Lev.txtSubject", input.get("Type@Subject#3"));
		SleepUtils.sleep(4);
		
		// 58. Type $data in Description field
		uiDriver.setValue("Validte_Acti_Acc_Poli_Prod_Lev.txtDescription", input.get("Type@Description#3"));
		SleepUtils.sleep(4);
		
		// 59. Click on Policy_Period_Image WebElement
		uiDriver.click("Validte_Acti_Acc_Poli_Prod_Lev.eltPolicy_Period_Image");

		// 60. Type $data in Policy field
		uiDriver.setValue("Validte_Acti_Acc_Poli_Prod_Lev.txtPolicy", input.get("Type@Policy"));

		// 61. Click on Search button
		uiDriver.click("Validte_Acti_Acc_Poli_Prod_Lev.btnSearch_Polic");
		SleepUtils.sleep(2);

		// 62. Verify whether the Policy_Number link is present
		if (uiDriver.checkElementPresent("Validte_Acti_Acc_Poli_Prod_Lev.lnkPolicy_Number")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 63. Click on Policy_Number Link
		uiDriver.click("Validte_Acti_Acc_Poli_Prod_Lev.lnkPolicy_Number");
		SleepUtils.sleep(3);

		// 64. Click on New_Activity_Update button
		uiDriver.click("Validte_Acti_Acc_Poli_Prod_Lev.btnNew_Activity_Update");

		// 65. Click on Policy WebElement
		uiDriver.click("Validte_Acti_Acc_Poli_Prod_Lev.eltPolicy");

		// 66. Type $data in Policy field
		uiDriver.setValue("Validte_Acti_Acc_Poli_Prod_Lev.txtPolicy1", input.get("Type@Policy"));

		// 67. Click on Search button
		uiDriver.click("Validte_Acti_Acc_Poli_Prod_Lev.btnSearch_Pol");

		// 68. Verify whether the Policy_Number link is present
		if (uiDriver.checkElementPresent("Validte_Acti_Acc_Poli_Prod_Lev.lnkPolicy_Number1")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 69. Click on Policy_Number Link
		uiDriver.click("Validte_Acti_Acc_Poli_Prod_Lev.lnkPolicy_Number1");
		SleepUtils.sleep(3);

		// 66. Click on Activities WebElement
		uiDriver.click("Validte_Acti_Acc_Poli_Prod_Lev.eltActivities");
		SleepUtils.sleep(3);

		// 67. Click on Policy_Subject Link
		String searchName2 = input.get("Type@Subject#3");
		String text2 = input.get("Type@Subject#3");
		String targettext2 = input.get("Type@Subject#3");
		uiDriver.th.findRelativeCellAndClickSelectedCellAndSubtext("Validte_Acti_Acc_Poli_Prod_Lev.lnkPolicy_Subject",
				searchName2, 5, targettext2, targettext2, text2);

		// 68. Verify whether the Policy_Activity element present
		if (uiDriver.checkElementPresent("Validte_Acti_Acc_Poli_Prod_Lev.eltPolicy_Activity")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 69. Click on Cancel button
		uiDriver.click("Validte_Acti_Acc_Poli_Prod_Lev.btnCancel");

	}

	public void Not_ReAss_Activitie_PrmPro_Can(DataRow input, DataRow output) {
		// 1. Click on Desktop WebElement
		uiDriver.click("Not_ReAss_Activitie_PrmPro_Can.eltDesktop");

		// 2. Click on Actions WebElement
		uiDriver.click("Not_ReAss_Activitie_PrmPro_Can.eltActions");
		SleepUtils.sleep(2);

		// 3. Click on New_Assigned_Activity WebElement
		uiDriver.mouseOver("Not_ReAss_Activitie_PrmPro_Can.eltNew_Assigned_Activity");
		SleepUtils.sleep(2);

		// 4. Click on Request WebElement
		uiDriver.mouseOver("Not_ReAss_Activitie_PrmPro_Can.eltRequest");

		// 5. Click on Request_for_Premium_Processing WebElement
		uiDriver.click("Not_ReAss_Activitie_PrmPro_Can.eltRequest_for_Premium_Processing");
		SleepUtils.sleep(2);

		// 6. Type $data in Subject field
		uiDriver.setValue("Not_ReAss_Activitie_PrmPro_Can.txtSubject", input.get("Type@Subject"));

		// 7. Type $data in Description field
		uiDriver.setValue("Not_ReAss_Activitie_PrmPro_Can.txtDescription", input.get("Type@Description"));

		// 8. Click on Assigned_To button
		uiDriver.click("Not_ReAss_Activitie_PrmPro_Can.btnAssigned_To");
		SleepUtils.sleep(2);

		// 9. Type $data in First_name field
		uiDriver.setValue("Not_ReAss_Activitie_PrmPro_Can.txtFirst_name", input.get("Type@First_name"));

		// 10. Click on Search button
		uiDriver.click("Not_ReAss_Activitie_PrmPro_Can.btnSearch");

		// 11. Click on Assign button
		uiDriver.click("Not_ReAss_Activitie_PrmPro_Can.btnAssign");

		// 12. Click on Update button
		uiDriver.click("Not_ReAss_Activitie_PrmPro_Can.btnUpdate");

		// 13. Select $data from the User_Desktop list
		uiDriver.click("Not_ReAss_Activitie_PrmPro_Can.lstUser_Desktop");
		SleepUtils.sleep(2);
		uiDriver.setValue("Not_ReAss_Activitie_PrmPro_Can.lstUser_Desktop", input.get("Select@User_Desktop"));
		uiDriver.sendKey("tab");

		// 14. Select the Premium_Processor_and_Cancellation_Roles ?checkbox
		String searchName = input.get("Type@Subject");
		uiDriver.th.findRelativeCellAndClickSelectedCell("Not_ReAss_Activitie_PrmPro_Can.tblActivity", searchName, 7,
				searchName, "");
		// 15. Verify Assign_disabled
		boolean flag = uiDriver.getControl("Not_ReAss_Activitie_PrmPro_Can.eltAssign_disabled").isEnabled();
		if (flag == true) {
			passed("Verify Assign Button read only", "Verify Assign Button read only should pass",
					"Verify Assign Button read only passed");
		} else {
			failed("Verify Assign Button read only", "Verify Assign Button read only should pass",
					"Verify Assign Button read only failed");
		}

	}

	public void Reass_own_Acti_owned_by_others(DataRow input, DataRow output) {

		// 1. Click on Desktop WebElement
		uiDriver.click("Reass_own_Acti_owned_by_others.eltDesktop");
		 SleepUtils.sleep(4 );
		 
		// 2. Click on Actions WebElement
		uiDriver.click("Reass_own_Acti_owned_by_others.eltActions");
		SleepUtils.sleep(2);

		// 3. Click on New_Assigned_Activity WebElement
		uiDriver.mouseOver("Reass_own_Acti_owned_by_others.eltNew_Assigned_Activity");
		SleepUtils.sleep(2);

		// 4. Click on Request WebElement
		uiDriver.mouseOver("Reass_own_Acti_owned_by_others.eltRequest");
		 SleepUtils.sleep(4 );
		 
		// 5. Click on Request_for_Premium_Processing WebElement
		uiDriver.click("Reass_own_Acti_owned_by_others.eltRequest_for_Premium_Processing");
	 SleepUtils.sleep(4 );
		 
		// 6. Type $data in Subject field
		uiDriver.setValue("Reass_own_Acti_owned_by_others.txtSubject", input.get("Type@Subject"));
		SleepUtils.sleep(4 );
		 
		// 7. Type $data in Description field
		uiDriver.setValue("Reass_own_Acti_owned_by_others.txtDescription", input.get("Type@Description"));
		SleepUtils.sleep(4 );
		// 8. Click on Assigned_To image
		uiDriver.click("Reass_own_Acti_owned_by_others.imgAssigned_To");
		 SleepUtils.sleep(4 );
		// 9. Type $data in User_Name field
		uiDriver.setValue("Reass_own_Acti_owned_by_others.txtUser_Name", System.getProperty("user.name"));
		 SleepUtils.sleep(4 );
		 
		// 10. Click on Search WebElement
		uiDriver.click("Reass_own_Acti_owned_by_others.eltSearch");
		 SleepUtils.sleep(4 );
		 
		// 11. Verify whether the Assign button is present
		if (uiDriver.checkElementPresent("Reass_own_Acti_owned_by_others.btnSelect")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		 SleepUtils.sleep(4 );
		 
		// 12. Click on Assign button
		uiDriver.click("Reass_own_Acti_owned_by_others.btnSelect");
		 SleepUtils.sleep(4 );
		 
		// 13. Click on Update button
		uiDriver.click("Reass_own_Acti_owned_by_others.btnUpdate");
        SleepUtils.sleep(4 );
        
        uiDriver.click("Reass_own_Acti_owned_by_others.eltSubject_1");
        SleepUtils.sleep(4);
        
		// 14. Click on Owned_Activity WebElement
		//String searchName = input.get("Type@Subject");
		uiDriver.th.findRelativeCellAndClickfirstCell("Reass_own_Acti_owned_by_others.eltOwned_Activity", "Owned Activity", 8, "Owned Activity");
		SleepUtils.sleep(8);

		// 15. Click on Assign button
		uiDriver.click("Reass_own_Acti_owned_by_others.btnAssign");
		SleepUtils.sleep(5);

		// 16. Select $data from the Select_from_list list
		uiDriver.click("Reass_own_Acti_owned_by_others.lstSelect_from_list_1");
		SleepUtils.sleep(3);
		uiDriver.setValue("Reass_own_Acti_owned_by_others.lstSelect_from_list", input.get("Select@Select_from_list"));
		uiDriver.sendKey("tab");
		SleepUtils.sleep(5);
		
		// 17. Click on Assign_Activity_Assign_ button
		uiDriver.click("Reass_own_Acti_owned_by_others.btnAssign_Activity_Assign_");
		SleepUtils.sleep(3);

		// 18. Select $data from the User_Desktop list
		uiDriver.setValue("Reass_own_Acti_owned_by_others.lstUser_Desktop", System.getProperty("user.name"));
		SleepUtils.sleep(3);
		
		
        
		// 19. Verify Owned_Activity
		String SearchString = input.get("Type@Subject");
		uiDriver.th.getCellDataOfCol("Reass_own_Acti_owned_by_others.eltOwned_Activity", SearchString, 8);
		
		
		// 20. Click on Owned_Activity WebElement
		//String searchName1 = input.get("Type@Subject");
		uiDriver.th.findRelativeCellAndClickSelectedCell("Reass_own_Acti_owned_by_others.eltOwned_Activity",
				"Owned Activity", 8, "Owned Activity", "");
SleepUtils.sleep(4);

		// 21. Click on Assign_Activity_Assign_ button
		uiDriver.click("Reass_own_Acti_owned_by_others.btnAssign");
		SleepUtils.sleep(3);

		// 22. Select $data from the Select_from_list list
		uiDriver.click("Reass_own_Acti_owned_by_others.lstSelect_from_list");
		SleepUtils.sleep(3);
		uiDriver.setValue("Reass_own_Acti_owned_by_others.lstSelect_from_list", input.get("Select@Select_from_list_1"));
		uiDriver.sendKey("tab");

		// 23. Click on Assign_Activity_Assign_ button
		uiDriver.click("Reass_own_Acti_owned_by_others.btnAssign_Activity_Assign_");
		SleepUtils.sleep(3);

		// 24. Select $data from the User_Desktop list
		uiDriver.setValue("Reass_own_Acti_owned_by_others.lstUser_Desktop", input.get("Select@User_Desktop_1"));
		uiDriver.sendKey("tab");
		SleepUtils.sleep(3);

		// 25. Verify Owned_Activity
		String SearchString1 = input.get("Type@Subject");
		uiDriver.th.getCellDataOfCol("Reass_own_Acti_owned_by_others.eltOwned_Activity", SearchString1, 8);
		SleepUtils.sleep(4);

	}

	public void Validate_Activities_Acc_Level(DataRow input, DataRow output) {
		// 1. Click on Desktop WebElement
		uiDriver.click("Validate_Activities_Acc_Level.eltDesktop");

		// 2. Click on Actions WebElement
		uiDriver.click("Validate_Activities_Acc_Level.eltActions");

		// 3. Click on New_Assigned_Activity WebElement
		uiDriver.click("Validate_Activities_Acc_Level.eltNew_Assigned_Activity");

		// 4. Click on Request WebElement
		uiDriver.click("Validate_Activities_Acc_Level.eltRequest");

		// 5. Click on Request_for_Premium_Processing WebElement
		uiDriver.click("Validate_Activities_Acc_Level.eltRequest_for_Premium_Processing");
		SleepUtils.sleep(3);

		// 6. Type $data in Subject field
		uiDriver.setValue("Validate_Activities_Acc_Level.txtSubject", input.get("Type@Subject"));

		// 7. Type $data in Description field
		uiDriver.setValue("Validate_Activities_Acc_Level.txtDescription", input.get("Type@Description"));

		// 8. Click on Account_Image WebElement
		uiDriver.click("Validate_Activities_Acc_Level.eltAccount_Image");

		// 9. Type $data in Account_Name field
		uiDriver.setValue("Validate_Activities_Acc_Level.txtAccount_Name", input.get("Type@Account_Name"));

		// 10. Click on Search_for_Accounts button
		uiDriver.click("Validate_Activities_Acc_Level.btnSearch_for_Accounts");

		// 11. Verify whether the Select button is present
		if (uiDriver.checkElementPresent("Validate_Activities_Acc_Level.btnSelect")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 12. Click on Select button
		uiDriver.click("Validate_Activities_Acc_Level.btnSelect");

		// 13. Click on Update button
		uiDriver.click("Validate_Activities_Acc_Level.btnUpdate");

		// 14. Click on Account WebElement
		uiDriver.click("Validate_Activities_Acc_Level.eltAccount");

		// 15. Type $data in Account_Name field
		uiDriver.setValue("Validate_Activities_Acc_Level.txtAccount_Name1", input.get("Type@Account_Name"));

		// 16. Click on Search button
		uiDriver.click("Validate_Activities_Acc_Level.btnSearch");

		// 17. Verify whether the Account_Name element present
		if (uiDriver.checkElementPresent("Validate_Activities_Acc_Level.eltAccount_Name")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 18. Click on Account_Name Link
		uiDriver.click("Validate_Activities_Acc_Level.lnkAccount_Name");

		// 19. Click on Activities WebElement
		uiDriver.click("Validate_Activities_Acc_Level.eltActivities");

		// 20. Select $data from the Activity_Status list
		uiDriver.click("Validate_Activities_Acc_Level.lstActivity_Status");
		SleepUtils.sleep(2);
		uiDriver.setValue("Validate_Activities_Acc_Level.lstActivity_Status", input.get("Select@Activity_Status"));
		uiDriver.sendKey("tab");

		// 21. Select $data from the Activity_Type list
		uiDriver.click("Validate_Activities_Acc_Level.lstActivity_Type");
		SleepUtils.sleep(2);
		uiDriver.setValue("Validate_Activities_Acc_Level.lstActivity_Type", input.get("Select@Activity_Type"));
		uiDriver.sendKey("tab");

		// 22. Select $data from the Transaction list
		uiDriver.click("Validate_Activities_Acc_Level.lstTransaction");
		SleepUtils.sleep(2);
		uiDriver.setValue("Validate_Activities_Acc_Level.lstTransaction", input.get("Select@Transaction"));
		uiDriver.sendKey("tab");

		// 23. Verify Status_Open
		uiDriver.th.getCellDataOfCol("Validate_Activities_Acc_Level.tblStatus_Open", "Open", 4);

		// 24. Click on Print_Export button
		uiDriver.click("Validate_Activities_Acc_Level.btnPrint_Export");

		// 25. Verify whether the Print_as_PDF_ element present
		if (uiDriver.checkElementPresent("Validate_Activities_Acc_Level.eltPrint_as_PDF_")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 26. Verify whether the Export_as_CSV_ element present
		if (uiDriver.checkElementPresent("Validate_Activities_Acc_Level.eltExport_as_CSV_")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 27. Verify whether the Custom_Export_as_CSV_ element present
		if (uiDriver.checkElementPresent("Validate_Activities_Acc_Level.eltCustom_Export_as_CSV_")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 28. Click on Print_Exprot_Cancel button
		uiDriver.click("Validate_Activities_Acc_Level.btnPrint_Exprot_Cancel");

		// 29. Verify whether the Service_Ticket_ element present
		if (uiDriver.checkElementPresent("Validate_Activities_Acc_Level.eltService_Ticket_")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 30. Verify whether the Requestor element present
		if (uiDriver.checkElementPresent("Validate_Activities_Acc_Level.eltRequestor")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 31. Verify whether the Assigned_To element present
		if (uiDriver.checkElementPresent("Validate_Activities_Acc_Level.eltAssigned_To")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 32. Click on Overview WebElement
		uiDriver.click("Validate_Activities_Acc_Level.eltOverview");
		SleepUtils.sleep(2);

		// 33. Click on Details WebElement
		uiDriver.click("Validate_Activities_Acc_Level.eltDetails");

		// 34. Verify whether the Service_Ticket_ element present
		uiDriver.click("Validate_Activities_Acc_Level.eltService_Ticket_Details");
		SleepUtils.sleep(2);
		if (uiDriver.checkElementPresent("Validate_Activities_Acc_Level.eltService_Ticket_Details")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 35. Verify whether the Requestor element present
		if (uiDriver.checkElementPresent("Validate_Activities_Acc_Level.eltRequestor_Details")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 36. Verify whether the Assigned_To element present
		if (uiDriver.checkElementPresent("Validate_Activities_Acc_Level.eltAssigned_To_Details")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

	}

	public void New_Edited_Fiedls_Account_360_(DataRow input, DataRow output) {
		// 1. Click on 360_Direct_Bill_View WebElement
		uiDriver.click("New_Edited_Fiedls_Account_360_.elt360_Direct_Bill_View");

		// 2. Click on Open_Activities WebElement
		uiDriver.click("New_Edited_Fiedls_Account_360_.eltOpen_Activities");

		// 3. Verify whether the Subject element present
		if (uiDriver.checkElementPresent("New_Edited_Fiedls_Account_360_.eltSubject")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 4. Verify whether the Service_Ticket_ element present
		uiDriver.click("New_Edited_Fiedls_Account_360_.eltService_Ticket_");
		SleepUtils.sleep(2);
		if (uiDriver.checkElementPresent("New_Edited_Fiedls_Account_360_.eltService_Ticket_")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 5. Verify whether the Requestor element present
		if (uiDriver.checkElementPresent("New_Edited_Fiedls_Account_360_.eltRequestor")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 6. Verify whether the Assigned_To element present
		if (uiDriver.checkElementPresent("New_Edited_Fiedls_Account_360_.eltAssigned_To")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

	}

	public void Search_Changes_Acc_Pol_Pro_Lev(DataRow input, DataRow output) {
		// 1. Click on Desktop WebElement
		uiDriver.click("Search_Changes_Acc_Pol_Pro_Lev.eltDesktop");

		// 2. Verify whether the Activity_Status element present
		if (uiDriver.checkElementPresent("Search_Changes_Acc_Pol_Pro_Lev.eltActivity_Status")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 3. Verify whether the Assigned_To element present
		uiDriver.click("Search_Changes_Acc_Pol_Pro_Lev.eltAssigned_To");
		SleepUtils.sleep(2);
		if (uiDriver.checkElementPresent("Search_Changes_Acc_Pol_Pro_Lev.eltAssigned_To")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 4. Click on Search WebElement
		uiDriver.click("Search_Changes_Acc_Pol_Pro_Lev.eltSearch");

		// 5. Click on Activities WebElement
		uiDriver.click("Search_Changes_Acc_Pol_Pro_Lev.eltActivities");

		// 6. Type $data in Requestor field
		uiDriver.setValue("Search_Changes_Acc_Pol_Pro_Lev.txtRequestor", input.get("Type@Requestor"));

		// 7. Click on Search_Activites_Search button
		uiDriver.click("Search_Changes_Acc_Pol_Pro_Lev.btnSearch_Activites_Search");

		// 8. Verify Requestor
		uiDriver.click("Search_Changes_Acc_Pol_Pro_Lev.eltRequestor");
		SleepUtils.sleep(2);
		if (uiDriver.checkElementPresent("Search_Changes_Acc_Pol_Pro_Lev.eltRequestor")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 9. Verify the text ?$data in the Requestor_Msg field
		if (uiDriver.verifyTextActAndExp("Search_Changes_Acc_Pol_Pro_Lev.eltRequestor_Msg",
				input.get("VerifyText@Requestor_Msg"))) {
			passed("verifyText", "verifyText should pass", "verifyText passed");
		} else {
			failed("verifyText", "verifyText should pass", "verifyText failed");
		}

		// 10. Click on Reset button
		uiDriver.click("Search_Changes_Acc_Pol_Pro_Lev.btnReset");

		// 11. Click on Search button
		uiDriver.click("Search_Changes_Acc_Pol_Pro_Lev.btnSearch_Activites_Search");

		// 12. Verify the text ?$data in the Insufficient_Error_Msg field
		if (uiDriver.verifyTextActAndExp("Search_Changes_Acc_Pol_Pro_Lev.eltInsufficient_Error_Msg",
				input.get("VerifyText@Insufficient_Error_Msg"))) {
			passed("verifyText", "verifyText should pass", "verifyText passed");
		} else {
			failed("verifyText", "verifyText should pass", "verifyText failed");
		}

	}

	public void Validate_Activities_Policy_Lev(DataRow input, DataRow output) {
		// 1. Click on Policies WebElement
		uiDriver.click("Validate_Activities_Policy_Lev.eltPolicies");

		// 2. Click on Policies_Link Link
		SleepUtils.sleep(2);
		uiDriver.th.findRelativeCellAndClickfirstCell("Validate_Activities_Policy_Lev.lnkPolicies_Link", "Active", 5,
				"Active");

		// 3. Click on Activites WebElement
		SleepUtils.sleep(2);
		uiDriver.click("Validate_Activities_Policy_Lev.eltActivites");

		// 4. Verify the text ?$data in the Activity_Status list
		if (uiDriver.verifyTextforWebEdit("Validate_Activities_Policy_Lev.lstActivity_Status",
				input.get("VerifyText@Activity_Status"))) {
			passed("verifyText", "verifyText should pass", "verifyText passed");
		} else {
			failed("verifyText", "verifyText should pass", "verifyText failed");
		}

		// 5. Verify the text ?$data in the Activity_Type list
		if (uiDriver.verifyTextforWebEdit("Validate_Activities_Policy_Lev.lstActivity_Type",
				input.get("VerifyText@Activity_Type"))) {
			passed("verifyText", "verifyText should pass", "verifyText passed");
		} else {
			failed("verifyText", "verifyText should pass", "verifyText failed");
		}

		// 6. Verify the text ?$data in the Transaction list
		if (uiDriver.verifyTextforWebEdit("Validate_Activities_Policy_Lev.lstTransaction",
				input.get("VerifyText@Transaction"))) {
			passed("verifyText", "verifyText should pass", "verifyText passed");
		} else {
			failed("verifyText", "verifyText should pass", "verifyText failed");
		}

		// 7. Select $data from the Activity_Type list
		uiDriver.setValue("Validate_Activities_Policy_Lev.lstActivity_Type", input.get("Select@Activity_Type"));

		// 8. Select $data from the Transaction list
		uiDriver.setValue("Validate_Activities_Policy_Lev.lstTransaction", input.get("Select@Transaction"));

		// 9. Click on Print_Export button
		uiDriver.click("Validate_Activities_Policy_Lev.btnPrint_Export");

		// 10. Verify whether the Print_as_PDF_ element present
		if (uiDriver.checkElementPresent("Validate_Activities_Policy_Lev.eltPrint_as_PDF_")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 11. Verify whether the Export_as_CSV_ element present
		if (uiDriver.checkElementPresent("Validate_Activities_Policy_Lev.eltExport_as_CSV_")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 12. Verify whether the Custom_Export_as_CSV_ element present
		if (uiDriver.checkElementPresent("Validate_Activities_Policy_Lev.eltCustom_Export_as_CSV_")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 13. Click on Print_Exprot_Cancel button
		uiDriver.click("Validate_Activities_Policy_Lev.btnPrint_Exprot_Cancel");

		// 14. Verify whether the Service_Ticket_ element present
		if (uiDriver.checkElementPresent("Validate_Activities_Policy_Lev.eltService_Ticket_")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 15. Verify whether the Requestor element present
		if (uiDriver.checkElementPresent("Validate_Activities_Policy_Lev.eltRequestor")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 16. Select $data from the Activity_Status list
		uiDriver.setValue("Validate_Activities_Policy_Lev.lstActivity_Status", input.get("Select@Activity_Status"));

		// 17. Verify whether the Assigned_To element present
		uiDriver.click("Validate_Activities_Policy_Lev.eltAssigned_To");
		SleepUtils.sleep(2);
		if (uiDriver.checkElementPresent("Validate_Activities_Policy_Lev.eltAssigned_To")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 18. Click on Overview WebElement
		uiDriver.click("Validate_Activities_Policy_Lev.eltOverview");

		// 19. Click on Details WebElement
		uiDriver.click("Validate_Activities_Policy_Lev.eltDetails");

		// 20. Verify whether the Details_Service_Ticket_ element present
		uiDriver.click("Validate_Activities_Policy_Lev.eltDetails_Service_Ticket_");
		SleepUtils.sleep(2);
		if (uiDriver.checkElementPresent("Validate_Activities_Policy_Lev.eltDetails_Service_Ticket_")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 21. Verify whether the Details_Requestor_ element present
		if (uiDriver.checkElementPresent("Validate_Activities_Policy_Lev.eltDetails_Requestor_")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 22. Verify whether the Details_Assigned_To element present
		if (uiDriver.checkElementPresent("Validate_Activities_Policy_Lev.eltDetails_Assigned_To")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

	}

	public void Validate_Producer_Level(DataRow input, DataRow output) {
		// 1. Click on Activites WebElement
		SleepUtils.sleep(2);
		uiDriver.click("Validate_Producer_Level.eltActivites");

		// 2. Verify the text ?$data in the Activity_Status list
		SleepUtils.sleep(2);
		if (uiDriver.verifyTextforWebEdit("Validate_Producer_Level.lstActivity_Status",
				input.get("VerifyText@Activity_Status"))) {
			passed("verifyText", "verifyText should pass", "verifyText passed");
		} else {
			failed("verifyText", "verifyText should pass", "verifyText failed");
		}

		// 3. Verify the text ?$data in the Activity_Type list
		if (uiDriver.verifyTextforWebEdit("Validate_Producer_Level.lstActivity_Type",
				input.get("VerifyText@Activity_Type"))) {
			passed("verifyText", "verifyText should pass", "verifyText passed");
		} else {
			failed("verifyText", "verifyText should pass", "verifyText failed");
		}

		// 4. Verify the text ?$data in the Transaction list
		if (uiDriver.verifyTextforWebEdit("Validate_Producer_Level.lstTransaction",
				input.get("VerifyText@Transaction"))) {
			passed("verifyText", "verifyText should pass", "verifyText passed");
		} else {
			failed("verifyText", "verifyText should pass", "verifyText failed");
		}

		// 5. Select $data from the Activity_Type list
		uiDriver.setValue("Validate_Producer_Level.lstActivity_Type", input.get("Select@Activity_Type"));

		// 6. Select $data from the Transaction list
		uiDriver.setValue("Validate_Producer_Level.lstTransaction", input.get("Select@Transaction"));

		// 7. Click on Print_Export button
		uiDriver.click("Validate_Producer_Level.btnPrint_Export");

		// 8. Verify whether the Print_as_PDF_ element present
		SleepUtils.sleep(2);
		if (uiDriver.checkElementPresent("Validate_Producer_Level.eltPrint_as_PDF_")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 9. Verify whether the Export_as_CSV_ element present
		if (uiDriver.checkElementPresent("Validate_Producer_Level.eltExport_as_CSV_")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 10. Verify whether the Custom_Export_as_CSV_ element present
		if (uiDriver.checkElementPresent("Validate_Producer_Level.eltCustom_Export_as_CSV_")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 11. Click on Cancel button
		uiDriver.click("Validate_Producer_Level.btnCancel");

		// 12. Verify whether the Service_Ticket_ element present
		SleepUtils.sleep(2);
		uiDriver.click("Validate_Producer_Level.eltService_Ticket_");
		SleepUtils.sleep(2);
		if (uiDriver.checkElementPresent("Validate_Producer_Level.eltService_Ticket_")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 13. Verify whether the Requestor_ element present
		if (uiDriver.checkElementPresent("Validate_Producer_Level.eltRequestor_")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 14. Select $data from the Activity_Status list
		uiDriver.setValue("Validate_Producer_Level.lstActivity_Status", input.get("Select@Activity_Status"));

		// 15. Verify whether the Assigned_To element present
		uiDriver.click("Validate_Producer_Level.eltAssigned_To");
		SleepUtils.sleep(2);
		if (uiDriver.checkElementPresent("Validate_Producer_Level.eltAssigned_To")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 16. Click on Summary WebElement
		uiDriver.click("Validate_Producer_Level.eltSummary");
		SleepUtils.sleep(2);

		// 17. Verify whether the Open_Activities_Service_Ticket_ element present
		uiDriver.click("Validate_Producer_Level.eltOpen_Activities_Service_Ticket_");
		SleepUtils.sleep(2);
		if (uiDriver.checkElementPresent("Validate_Producer_Level.eltOpen_Activities_Service_Ticket_")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 18. Verify whether the Open_Activities_Requestor_ element present
		if (uiDriver.checkElementPresent("Validate_Producer_Level.eltOpen_Activities_Requestor_")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 19. Verify whether the Open_Activities_Assigned_To element present
		uiDriver.click("Validate_Producer_Level.eltOpen_Activities_Assigned_To");
		SleepUtils.sleep(2);
		if (uiDriver.checkElementPresent("Validate_Producer_Level.eltOpen_Activities_Assigned_To")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

	}

	public void Activities_Desktop_Level(DataRow input, DataRow output) {
		// 1. Click on Desktop WebElement
		uiDriver.click("Activities_Desktop_Level.eltDesktop");

		// 2. Verify User_Desktop none fields shouldn't be their
		uiDriver.click("Activities_Desktop_Level.lstUser_Desktop");
		SleepUtils.sleep(2);
		String expectedValue = input.get("Verify@UserDesktop");

		boolean verfiyval = uiDriver.getElementNameUsingTag("li", expectedValue);
		if (!verfiyval) {
			passed("verify option from the User Desktop", expectedValue + " option should not exist on User Desktop",
					expectedValue + " Option has not been exist on User Desktop");
		} else {
			failed("verify option from the User Desktop", expectedValue + " option should not exist User Desktop",
					expectedValue + " Option has been exist on User Desktop");
		}

		// 3. Select $data from the User_Desktop list
		uiDriver.setValue("Activities_Desktop_Level.lstUser_Desktop", input.get("Select@User_Desktop"));

		// 4. Click on Requestor WebElement
		uiDriver.click("Activities_Desktop_Level.eltRequestor");
		SleepUtils.sleep(2);

		// 5. Verify Owned field disabled
		String sflag = uiDriver.getControl("Activities_Desktop_Level.lstOwned").getAttribute("disabled");
		if (sflag.equalsIgnoreCase("true")) {
			passed("Verify element", "element disabled should pass", "Verify element passed");
		} else {
			failed("Verify element", "element not disabled should pass", "Verify element failed");
		}

		// 6. Verify whether the Activity_Type element present
		if (uiDriver.checkElementPresent("Activities_Desktop_Level.eltActivity_Type")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 7. Verify whether the Transaction_ element present
		if (uiDriver.checkElementPresent("Activities_Desktop_Level.eltTransaction_")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 8. Verify whether the Print_Exprot button is present
		uiDriver.click("Activities_Desktop_Level.eltRequestor_");
		SleepUtils.sleep(2);
		if (uiDriver.checkElementPresent("Activities_Desktop_Level.btnPrint_Exprot")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 9. Verify whether the Service_Ticket_ element present
		if (uiDriver.checkElementPresent("Activities_Desktop_Level.eltService_Ticket_")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 10. Verify whether the Requestor_ element present
		if (uiDriver.checkElementPresent("Activities_Desktop_Level.eltRequestor_")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

	}

	/**
	 * Overriding toString() method of object class to print Create_Activities
	 * format string
	 **/
	public String toString() {
		return "Create_ActivitiesDriver";
	}
}
