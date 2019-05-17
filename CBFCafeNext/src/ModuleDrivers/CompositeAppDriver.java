/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 9/1/2017 3:54:59 PM
Created using Cafenext Selenium Builder
******************************************************************************/

package ModuleDrivers;

import java.util.HashMap;
import java.util.Map;

import cbf.harness.ParameterAccess;
import cbf.model.ModuleDriver;
import cbfx.selenium.BaseWebAppDriver;

/**
 * Extends BaseWebAppDriver class and starts execution
 **/
public class CompositeAppDriver extends BaseWebAppDriver {
	public CompositeAppDriver(Map params) {
		super(params);
	}

	/**
	 * Initializes the modules specific to the application to be automated
	 * 
	 * @param resultLogger
	 *            TestResultLogger object with methods like passed, failed, error
	 *            etc available for reporting runtime results
	 * @return Map of modules
	 **/
	public Map<String, ModuleDriver> loadModuleDrivers(ParameterAccess paramAccess) {
		HashMap<String, ModuleDriver> moduleDrivers = new HashMap<String, ModuleDriver>();
		moduleDrivers.put("login", new loginDriver(paramAccess));
		moduleDrivers.put("NewAccount", new NewAccountDriver(paramAccess));
		moduleDrivers.put("Policy", new PolicyDriver(paramAccess));
		moduleDrivers.put("CreateNewAccount", new US1116_CreateNewAccountDriver(paramAccess));
		moduleDrivers.put("ChargesForThePolicy", new US1091_ChargesForThePolicyDriver(paramAccess));
		moduleDrivers.put("US1086_CloseAccount", new US1086_CloseAccountDriver(paramAccess));
		moduleDrivers.put("US1086NonITAdmNotAbleToCloseAn", new US1086_NonITAdmNotAbleToCloseAnDriver(paramAccess));
		moduleDrivers.put("US1089_ViewPoliciesAccount", new US1089_ViewPoliciesAccountDriver(paramAccess));
		moduleDrivers.put("US1091_ViewChargesAccntAndPoli", new US1091_ViewChargesAccntAndPoliDriver(paramAccess));
		moduleDrivers.put("SearchAccounts", new US84_SearchAccountsDriver(paramAccess));
		moduleDrivers.put("SearchBCUsers", new US104_SearchBCUsersDriver(paramAccess));
		moduleDrivers.put("SearchInvoices", new US86_SearchInvoicesDriver(paramAccess));
		moduleDrivers.put("MaintainNotes", new US1088_MaintainNotesDriver(paramAccess));
		moduleDrivers.put("MaintainAccntSumryInf", new US1102_MaintainAccntSumryInfDriver(paramAccess));
		moduleDrivers.put("Accounts_View_History", new US1087_Accounts_View_HistoryDriver(paramAccess));
		moduleDrivers.put("Search_Policies", new US1100_Search_PoliciesDriver(paramAccess));
		moduleDrivers.put("MaintainPolicySumryInf", new US1103_MaintainPolicySumryInfDriver(paramAccess));
		moduleDrivers.put("ManageInvoice", new US1110_ManageInvoiceDriver(paramAccess));
		moduleDrivers.put("ModifyChargInvItems", new US1093_ModifyChargInvItemsDriver(paramAccess));
		moduleDrivers.put("MaintainAccountContacts", new US1116_MaintainAccountContactsDriver(paramAccess));
		moduleDrivers.put("MaintainAccount_RecHistory", new US1116_MaintainAccount_RecHistoryDriver(paramAccess));
		moduleDrivers.put("PolicyViewHistory_Validate", new US1090_PolicyViewHistory_ValidateDriver(paramAccess));
		moduleDrivers.put("ProducerContacts_validateAddr", new US118_ProducerContacts_validateAddrDriver(paramAccess));
		moduleDrivers.put("ProducerContacts_Record_Hist", new US118_ProducerContacts_Record_HistDriver(paramAccess));
		moduleDrivers.put("ProducerContacts_Addandremove", new US118_ProducerContacts_AddandremoveDriver(paramAccess));
		moduleDrivers.put("Policy_Contacts_Externalcontac", new US1117_Policy_Contacts_ExternalcontacDriver(paramAccess));
		moduleDrivers.put("PolicyContacts_AddExistingCont", new US1117_PolicyContacts_AddExistingContDriver(paramAccess));
		moduleDrivers.put("PolicyContacts_Validateaddress",	new US1117_PolicyContacts_ValidateaddressDriver(paramAccess));
		moduleDrivers.put("PolicyContacts_Editadd_roleupd",	new US1117_PolicyContacts_Editadd_roleupdDriver(paramAccess));
		moduleDrivers.put("AssignPayertoChargeorInvoice", new US1094_AssignPayertoChargeorInvoiceDriver(paramAccess));
		moduleDrivers.put("Assign_payerto_verifthereverse",	new US1094_Assign_payerto_verifthereverseDriver(paramAccess));
		moduleDrivers.put("NewEmailVerification", new US126_NewEmailVerificationDriver(paramAccess));
		moduleDrivers.put("PolicyLevelHistory", new US723_126_PolicyLevelHistoryDriver(paramAccess));
		moduleDrivers.put("US106_TurnonAgencyPromiseStry", new US106_TurnonAgencyPromiseStryDriver(paramAccess));
		moduleDrivers.put("Account_Search", new Account_SearchDriver(paramAccess));
		moduleDrivers.put("US1215_SendEmail", new US1215_SendEmailDriver(paramAccess));
		moduleDrivers.put("US_1208", new US1208Driver(paramAccess));
		moduleDrivers.put("US1208_PolicyDocuments", new US1208_PolicyDocumentsDriver(paramAccess));
		moduleDrivers.put("US1208_ProducerDocuments", new US1208_ProducerDocumentsDriver(paramAccess));
		moduleDrivers.put("US1154_Upload_Documents", new US1154_Upload_DocumentsDriver(paramAccess));
		moduleDrivers.put("US1213_DefineAgncyBillPlans", new US1213_DefineAgncyBillPlansDriver(paramAccess));	
		moduleDrivers.put("DirectBillPaymentAllocation", new DirectBillPaymentAllocationDriver(paramAccess));
		moduleDrivers.put("MultiplePaymentsWizard", new US1256_MultiplePaymentWizard(paramAccess));
		moduleDrivers.put("SearchContacts_verifytheabilit", new US1153_SearchContacts_verifytheabilitDriver(paramAccess));
		moduleDrivers.put("TC03SearchContacts_Verifyfiel_", new US1153_SearchContacts_Verifyfiel_Driver(paramAccess));
		moduleDrivers.put("TC10_Searchpayments_validlist", new US1193_Searchpayments_validlistDriver(paramAccess));
		moduleDrivers.put("US1152ReverseCharges_ValidHist", new US1152_ReverseCharges_ValidHistDriver(paramAccess));
		moduleDrivers.put("US1152Reversel_Validfuncreq", new US1152_Reversel_ValidfuncreqDriver(paramAccess));
		moduleDrivers.put("US1153SearchanExistingContact", new US1153_SearchanExistingContactDriver(paramAccess));
		moduleDrivers.put("US1153SearchPolicyExistingCont", new US1153_SearchPolicyExistingContDriver(paramAccess));
		moduleDrivers.put("US1153TC06_SearchProducer_Tick", new US1153_SearchProducer_TickDriver(paramAccess));
		moduleDrivers.put("US1189TC04_viewandmanagesuspay", new US1189_viewandmanagesuspayDriver(paramAccess));
		moduleDrivers.put("US1191_TC02_Validate", new US1191_Validate_NewDirectBillPaymentscreenDriver(paramAccess));
		moduleDrivers.put("US1191_TC05_DriBillPmnt_NewDirtCredit", new US1191_DriBillPmnt_NewDirtCreditDriver(paramAccess));
		moduleDrivers.put("US1191TC06_Direct_Bill_Payment", new US1191_Direct_Bill_PaymentDriver(paramAccess));
		moduleDrivers.put("US1212_NewCrditDistribution", new US1212_NewCrditDistributionDriver(paramAccess));
		moduleDrivers.put("US1214TC01_TC02MaintainAgencyB", new US1214_MaintainAgencyBDriver(paramAccess));
		moduleDrivers.put("US1214TC03_MaintainAgencyBill", new US1214_MaintainAgencyBillDriver(paramAccess));
		moduleDrivers.put("US1215TC01_SendEmail", new US1215_SendEmailPDriver(paramAccess));
		moduleDrivers.put("US1246ModifyDistribution", new US1246_ModifyDistributionDriver(paramAccess));
		moduleDrivers.put("US1247TC03_MoveDirectBillPayme", new US1247_MoveDirectBillPaymeDriver(paramAccess));
		moduleDrivers.put("US1248ViewLedgerandJournalPRO", new US1248_ViewLedgerandJournalPRODriver(paramAccess));
		moduleDrivers.put("US1251ViewLedgerandJournalAcc", new US1251_ViewLedgerandJournalAccDriver(paramAccess));
		moduleDrivers.put("US1253ViewLedgerandJournalPoli", new US1253_ViewLedgerandJournalPoliDriver(paramAccess));
		moduleDrivers.put("US1254SearchTransactions", new US1254_SearchTransactionsDriver(paramAccess));
		moduleDrivers.put("US1257TC03ReverseDirectBill_", new US1257_ReverseDirectBill_Driver(paramAccess));
		moduleDrivers.put("US1257TC04_ReverseDirectBillPa", new US1257_ReverseDirectBillPaDriver(paramAccess));
		moduleDrivers.put("US1257TC11_ReverseDirectBillPa", new US1257_ReverseDirectBillPayDriver(paramAccess));
		moduleDrivers.put("US1268_NEPPmntReversal", new US1268_NEPPmntReversalDriver(paramAccess));
		moduleDrivers.put("US479_FPOAPOCodesForStates", new US479_FPOAPOCodesForStatesDriver(paramAccess));
		moduleDrivers.put("US882_NEPModifyDistri", new US882_NEPModifyDistriDriver(paramAccess));
		moduleDrivers.put("Searchpayments_TypelistValidat", new US1193_SearchPaymentsTypeListValidation(paramAccess));
		moduleDrivers.put("US1188Createsuspensepayments", new US1188_CreatesuspensepaymentsDriver(paramAccess));
		moduleDrivers.put("US1188TC04_EvaluateSuspensePay", new US1188_EvaluateSuspensePayDriver(paramAccess));
		moduleDrivers.put("US1247_TC02MoveDirectBilltosus", new US1247_MoveDirectBilltosusDriver(paramAccess));
		moduleDrivers.put("Create_Activities", new Create_ActivitiesDriver(paramAccess));
        moduleDrivers.put("Account_Search", new Account_SearchDriver(paramAccess));
        moduleDrivers.put("Search_Producer_Code", new Search_Producer_CodeDriver(paramAccess));
        moduleDrivers.put("Producer", new ProducerDriver(paramAccess));
        moduleDrivers.put("Create_New_Producer_Wizard", new Create_New_Producer_WizardDriver(paramAccess));
        moduleDrivers.put("Admin_UserSearch", new Admin_UserSearchDriver(paramAccess));
        moduleDrivers.put("Service_Tickets", new Service_TicketsDriver(paramAccess));
    	moduleDrivers.put("Payment_Plan", new Payment_PlanDriver(paramAccess));
    	moduleDrivers.put("Commissions", new CommissionsDriver(paramAccess));
    	moduleDrivers.put("NEP", new NEPDriver(paramAccess));
    	moduleDrivers.put("Adminuser_Addrole", new Adminuser_AddroleDriver(paramAccess));
    	moduleDrivers.put("US_1055_TC_BC_360_Account_Summary", new US_1055_TC_BC_360_Account_SummaryDriver(paramAccess));
    	moduleDrivers.put("US1005_Hold_Charges_Account_and_Policy", new US1005_Hold_Charges_Account_and_PolicyDriver(paramAccess));
    	moduleDrivers.put("Remove_Adminuserrole", new Remove_AdminuserroleDriver(paramAccess));
    	moduleDrivers.put("LoginUserAsSupervisorforDefault", new LoginUserAsSupervisorforDefaultDriver(paramAccess));
    	moduleDrivers.put("US1006_Review_Existing_Holds", new US1006_Review_Existing_HoldsDriver(paramAccess));
    	moduleDrivers.put("US999_Transfer_Funds_Producer_Level", new US999_Transfer_Funds_Producer_LevelDriver(paramAccess));
    	moduleDrivers.put("US995_Negative_Write_Off_and_Reversal", new US995_Negative_Write_Off_and_ReversalDriver(paramAccess));
    	moduleDrivers.put("US1390_Configuration_Invoice_Processing", new US1390_Configuration_Invoice_ProcessingDriver(paramAccess));
    	moduleDrivers.put("US940_Manage_Account_Disbursement", new US940_Manage_Account_DisbursementDriver(paramAccess));
    	moduleDrivers.put("US994_Write_Off_And_Write_Off_Reversal", new US994_Write_Off_And_Write_Off_ReversalDriver(paramAccess));
    	moduleDrivers.put("Authority_Limits_Profile", new Authority_Limits_ProfileDriver(paramAccess));
    	moduleDrivers.put("US1393_Config_Support_Story_for_Billing", new US1393_Config_Support_Story_for_BillingDriver(paramAccess));
        moduleDrivers.put("US1074_TransferPoliciestoNewAc", new US1074_TransferPoliciestoNewAcDriver(paramAccess));
        moduleDrivers.put("US1383_Transfer_Funds_Account", new US1383_Transfer_Funds_AccountDriver(paramAccess));
        moduleDrivers.put("US1387_Recharge_Fee", new US1387_Recharge_FeeDriver(paramAccess));
        moduleDrivers.put("LoginUserAsSupervisorforDefault", new LoginUserAsSupervisorforDefaultDriver(paramAccess));
        moduleDrivers.put("US1389_PolicySummaryScreen", new US1389_PolicySummaryScreenDriver(paramAccess));
        moduleDrivers.put("US1402_LoadPlansandChargepat", new US1402_LoadPlansandChargepatDriver(paramAccess));
        moduleDrivers.put("US1388_NEP_Debit_Adjustment", new US1388_NEP_Debit_AdjustmentDriver(paramAccess));
        moduleDrivers.put("US956_TransferPoliciestoNewProducer", new US956_TransferPoliciestoNewProducerDriver(paramAccess));
        moduleDrivers.put("US1081_IssueandReverseAdHocCredit", new US1081_IssueandReverseAdHocCreditDriver(paramAccess));
        moduleDrivers.put("Batchpaymententry", new BatchpaymententryDriver(paramAccess));
        moduleDrivers.put("Disbursmentunappliedbatch", new DisbursmentunappliedbatchDriver(paramAccess)); 
        moduleDrivers.put("US997_Recapture", new US997_RecaptureDriver(paramAccess));
        moduleDrivers.put("US907_TC_BC_NEPCommissonAdjustment", new US907_TC_BC_NEPCommissonAdjustmentDriver(paramAccess));
        moduleDrivers.put("US938_ViewAccountDisbursements", new  US938_ViewAccountDisbursementsDriver(paramAccess));
        moduleDrivers.put("Equity_Warning_Parameters_On_Payment_Plan", new  Equity_Warning_Parameters_On_Payment_PlanDriver(paramAccess));
        moduleDrivers.put("Update_Agency_Bill_Executed_Promises", new  Update_Agency_Bill_Executed_PromisesDriver(paramAccess));
        moduleDrivers.put("Update_Agency_Bill_Saved_Promises", new  Update_Agency_Bill_Saved_PromisesDriver(paramAccess));
        moduleDrivers.put("Make_Agency_Bill_Promise", new  Make_Agency_Bill_PromiseDriver(paramAccess));
        moduleDrivers.put("BatchPayment_Producer", new  BatchPayment_ProducerDriver(paramAccess));
        moduleDrivers.put("Create_Credit_Item_Disbursements", new  Create_Credit_Item_DisbursementsDriver(paramAccess));
        moduleDrivers.put("Make_Agency_Bill_Payment", new  Make_Agency_Bill_PaymentDriver(paramAccess));
        moduleDrivers.put("Manage_Agency_Bill_Suspense_Items", new  Manage_Agency_Bill_Suspense_ItemsDriver(paramAccess));
        moduleDrivers.put("Batchpaymententry", new BatchpaymententryDriver(paramAccess));
        moduleDrivers.put("Disbursmentunappliedbatch", new DisbursmentunappliedbatchDriver(paramAccess)); 
        moduleDrivers.put("US907_TC_BC_NEPCommissonAdjustment", new US907_TC_BC_NEPCommissonAdjustmentDriver(paramAccess));
        moduleDrivers.put("Authority_Limits_Profile", new  Authority_Limits_ProfileDriver(paramAccess));
        moduleDrivers.put("US938_ViewAccountDisbursements", new  US938_ViewAccountDisbursementsDriver(paramAccess));
        moduleDrivers.put("BatchPayment_Producer", new BatchPayment_ProducerDriver(paramAccess));
        moduleDrivers.put("US980_MoveAgencyBillPayment", new US980_MoveAgencyBillPaymentDriver(paramAccess));
        moduleDrivers.put("US1437_ReverseAgencyBillPayment", new US1437_ReverseAgencyBillPaymentDriver(paramAccess));
        moduleDrivers.put("US921_MaintainPolicyPaymentSchedule", new US921_MaintainPolicyPaymentScheduleDriver(paramAccess));
        moduleDrivers.put("US971_UpdateAgencyBillSavedPayments", new US971_UpdateAgencyBillSavedPaymentsDriver(paramAccess));
        moduleDrivers.put("US964_ViewAgencyBillCycles", new US964_ViewAgencyBillCyclesDriver(paramAccess));
        moduleDrivers.put("US970_UpdateAgencybillExecutedPayments", new US970_UpdateAgencybillExecutedPaymentsDriver(paramAccess));
        moduleDrivers.put("US1438_SplitAgencyBillPayment", new US1438_SplitAgencyBillPaymentDriver(paramAccess));
        moduleDrivers.put("US1485_Abilitytowaiveinstallmentfee", new US1485_AbilitytowaiveinstallmentfeeDriver(paramAccess));
        moduleDrivers.put("US1471_DisablingTransactions", new US1471_DisablingTransactionsDriver(paramAccess));
        moduleDrivers.put("US978_ManageAccountBillPayment", new US978_ManageAccountBillPaymentDriver(paramAccess));
        moduleDrivers.put("US1486_AddCollateralLevelCharges", new US1486_AddCollateralLevelChargesDriver(paramAccess));
        moduleDrivers.put("US979_ManageAccountBillDiscrepancy", new US979_ManageAccountBillDiscrepancyDriver(paramAccess));
        moduleDrivers.put("US944_StartManualDelinquency", new US944_StartManualDelinquencyDriver(paramAccess));
        moduleDrivers.put("US1487_360DirectBillView", new US1487_360DirectBillViewDriver(paramAccess));
        moduleDrivers.put("Transfer_Funds_To_Collateral", new Transfer_Funds_To_CollateralDriver(paramAccess));
        moduleDrivers.put("Maintain_Producer_Disbursements", new Maintain_Producer_DisbursementsDriver(paramAccess));
        moduleDrivers.put("Create_Producer_Disbursements", new Create_Producer_DisbursementsDriver(paramAccess));
        moduleDrivers.put("Search_Delinquency_Processes", new Search_Delinquency_ProcessesDriver(paramAccess));
        moduleDrivers.put("View_Evaluation", new View_EvaluationDriver(paramAccess));
        moduleDrivers.put("Advance_Commission_Payment", new Advance_Commission_PaymentDriver(paramAccess));
        moduleDrivers.put("Commission_Adjustment_PHLY_Specific", new Commission_Adjustment_PHLY_SpecificDriver(paramAccess));
        moduleDrivers.put("Refactor_Multiple_Paymnt_Batch_Entry_Screen", new Refactor_Multiple_Paymnt_Batch_Entry_ScreenDriver(paramAccess));
        moduleDrivers.put("Manage_Collateral_Requirements", new Manage_Collateral_RequirementsDriver(paramAccess));
        moduleDrivers.put("Manage_Collateral_Cash_Held", new Manage_Collateral_Cash_HeldDriver(paramAccess));
        moduleDrivers.put("PHLY_Specific_Change_Billing_Method", new PHLY_Specific_Change_Billing_MethodDriver(paramAccess));
        moduleDrivers.put("NEP_Invoice_Conversion_Charges", new NEP_Invoice_Conversion_ChargesDriver(paramAccess));
        moduleDrivers.put("Producer_View_History", new Producer_View_HistoryDriver(paramAccess));
        moduleDrivers.put("MaintainDelinquencyPlans", new MaintainDelinquencyPlansDriver(paramAccess));
        moduleDrivers.put("DefineBCAuthorityLimits", new DefineBCAuthorityLimitsDriver(paramAccess));
        moduleDrivers.put("MaintainBCAuthorityLimits", new MaintainBCAuthorityLimitsDriver(paramAccess));
        moduleDrivers.put("MyDesktopScreens", new MyDesktopScreensDriver(paramAccess));
        moduleDrivers.put("MaintainBCGroups", new MaintainBCGroupsDriver(paramAccess));
        moduleDrivers.put("NEPOtherTransactions", new NEPOtherTransactionsDriver(paramAccess));
        moduleDrivers.put("US941_AssignAccountDisbursment", new US941_AssignAccountDisbursmentDriver(paramAccess));
        moduleDrivers.put("US1035_MaintainBCRolesandPerm", new US1035_MaintainBCRolesandPermDriver(paramAccess));
        moduleDrivers.put("US1018_ViewTransactionApproval", new US1018_ViewTransactionApprovalDriver(paramAccess));
        moduleDrivers.put("US1024_DefineBCRoles", new US1024_DefineBCRolesDriver(paramAccess));
        moduleDrivers.put("US1028_DefineBCUsers", new US1028_DefineBCUsersDriver(paramAccess));
        moduleDrivers.put("US1030_MaintainBCusers", new US1030_MaintainBCusersDriver(paramAccess));
        moduleDrivers.put("US1027_BCGroupStructure", new US1027_BCGroupStructureDriver(paramAccess));
        moduleDrivers.put("US1046_ConfigAgencyBill", new US1046_ConfigAgencyBillDriver(paramAccess));
        moduleDrivers.put("US1615_AutomatedDisbursement", new US1615_AutomatedDisbursementDriver(paramAccess));
        moduleDrivers.put("US1570_removeallfundstransfer", new US1570_removeallfundstransferDriver(paramAccess));
        moduleDrivers.put("US1025_BCPermissions", new US1025_BCPermissionsDriver(paramAccess));

        
		return moduleDrivers;
	}

	public void recover() {
		super.recover();
	}
}