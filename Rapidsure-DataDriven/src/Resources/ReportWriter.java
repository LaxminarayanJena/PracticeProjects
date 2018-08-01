package Resources;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

import Scripts.*;

/**
 * Created by agarwalp on 5/28/2017.
 */

public class ReportWriter {

    private static volatile ReportWriter instance;

    private ReportWriter() {
    }

    public static ReportWriter getInstance() {
        if (instance == null) {
            synchronized (ReportWriter.class) {
                if (instance == null) {
                    instance = new ReportWriter();
                }
            }
        }
        return instance;
    }

    /**
     * FUNCTION NAME        : updateReportFile
     * DESCRIPTION          : adds New Business results to  Report File
     * INPUT PARAMETERS     : reportPath   ;   resultMap
     * OUTPUT               : None
     * AUTHOR               : Priyal Agarwal
     */
    public synchronized void updateReportFile(String reportPath, HashMap<String, String> resultMap) {
        try {
            FileInputStream file = new FileInputStream(new File(reportPath));
            HSSFWorkbook workbook = new HSSFWorkbook(file);
            DataFormatter objDefaultFormat = new DataFormatter();
            FormulaEvaluator objFormulaEvaluator = new HSSFFormulaEvaluator((HSSFWorkbook) workbook);
            String sheetName = resultMap.get("Policy_Number");
            // Delete a sheet if already present with same name
            if (workbook.getSheetIndex(sheetName) > -1) {
                workbook.removeSheetAt(workbook.getSheetIndex(sheetName));
            }
            Sheet resultsSheet = workbook.getSheet("Results");
            // Reading Header Row Information
            Row resultsSheetHeaderRow = resultsSheet.getRow(0);
            HashMap<String, Integer> resultsSheetHeaderMap = new HashMap<>();
            for (int itColNum = 0; itColNum <= resultsSheetHeaderRow.getLastCellNum(); itColNum++) {
                Cell cellValue = resultsSheetHeaderRow.getCell(itColNum);
                objFormulaEvaluator.evaluate(cellValue);
                String cellValueStr = objDefaultFormat.formatCellValue(cellValue, objFormulaEvaluator);
                resultsSheetHeaderMap.put(cellValueStr, itColNum);
            }
            int resultsSheetLastRowNum = resultsSheet.getLastRowNum();
            Row resultNewRow = resultsSheet.createRow(resultsSheetLastRowNum + 1);
            // Adding values to result sheet
            for (Map.Entry<String, String> entry : resultMap.entrySet()) {
                String resultKey = entry.getKey();
                String resultValue = entry.getValue();
                if (resultsSheetHeaderMap.containsKey(resultKey)) {
                    Cell resultNewCell = resultNewRow.createCell(resultsSheetHeaderMap.get(resultKey));
                    resultNewCell.setCellValue(resultValue);
                }
            }
            int resultsSheetIndex = workbook.getSheetIndex("Results");
            Sheet newSheet = workbook.createSheet(sheetName);
            workbook.setSheetOrder(newSheet.getSheetName(), resultsSheetIndex);
            Row accountNumberRow = newSheet.createRow(0);
            accountNumberRow.createCell(0).setCellValue("Account Number");
            accountNumberRow.createCell(1).setCellValue(resultMap.get("Account_Number"));
            
            Row policyNumberRow = newSheet.createRow(1);
            policyNumberRow.createCell(0).setCellValue("Policy Number");
            policyNumberRow.createCell(1).setCellValue(resultMap.get("Policy_Number"));
            
            
            
            Row poltuRow = newSheet.createRow(1);
            poltuRow.createCell(5).setCellValue("Poltubirlasoft");
            poltuRow.createCell(6).setCellValue(resultMap.get("poltu"));
            
            
            
            
            Row policyAmountRow = newSheet.createRow(2);
            policyAmountRow.createCell(0).setCellValue("Policy Amount");
            policyAmountRow.createCell(1).setCellValue(resultMap.get("Policy_Amount"));
            Row premiumMatchStatus = newSheet.createRow(3);
            premiumMatchStatus.createCell(0).setCellValue("PremiumMatch_Status");
            premiumMatchStatus.createCell(1).setCellValue(resultMap.get("PremiumMatch_Status"));
//          Vehicle1 Verifications
            Row vehicle1CheckPoints = newSheet.createRow(8);
            vehicle1CheckPoints.createCell(0).setCellValue("NB_Vehicle1_Checkpoints");
            Row vehicle1CollisionRow = newSheet.createRow(9);
            vehicle1CollisionRow.createCell(0).setCellValue("Vehicle1Collision");
            vehicle1CollisionRow.createCell(1).setCellValue(resultMap.get("CollisionVehicle1"));
            vehicle1CollisionRow.createCell(2).setCellValue(resultMap.get("statusCollisionVehicle1"));
            Row vehicle1ComprehensiveRow = newSheet.createRow(10);
            vehicle1ComprehensiveRow.createCell(0).setCellValue("Vehicle1Comprehensive");
            vehicle1ComprehensiveRow.createCell(1).setCellValue(resultMap.get("ComprehensiveVehicle1"));
            vehicle1ComprehensiveRow.createCell(2).setCellValue(resultMap.get("statusComprehensiveVehicle1"));
//          Vehicle2 Verifications
            Row vehicle2CheckPoints = newSheet.createRow(11);
            vehicle2CheckPoints.createCell(0).setCellValue("NB_Vehicle2_Checkpoints");
            Row vehicle2CollisionRow = newSheet.createRow(12);
            vehicle2CollisionRow.createCell(0).setCellValue("Vehicle2Collision");
            vehicle2CollisionRow.createCell(1).setCellValue(resultMap.get("CollisionVehicle2"));
            vehicle2CollisionRow.createCell(2).setCellValue(resultMap.get("statusCollisionVehicle2"));
            Row vehicle2ComprehensiveRow = newSheet.createRow(13);
            vehicle2ComprehensiveRow.createCell(0).setCellValue("Vehicle2Comprehensive");
            vehicle2ComprehensiveRow.createCell(1).setCellValue(resultMap.get("ComprehensiveVehicle2"));
            vehicle2ComprehensiveRow.createCell(2).setCellValue(resultMap.get("statusComprehensiveVehicle2"));
//          Vehicle3 Verifications
            Row vehicle3CheckPoints = newSheet.createRow(14);
            vehicle3CheckPoints.createCell(0).setCellValue("NB_Vehicle3_Checkpoints");
            Row vehicle3CollisionRow = newSheet.createRow(15);
            vehicle3CollisionRow.createCell(0).setCellValue("Vehicle3Collision");
            vehicle3CollisionRow.createCell(1).setCellValue(resultMap.get("CollisionVehicle3"));
            vehicle3CollisionRow.createCell(2).setCellValue(resultMap.get("statusComprehensiveVehicle3"));
            Row vehicle3ComprehensiveRow = newSheet.createRow(16);
            vehicle3ComprehensiveRow.createCell(0).setCellValue("Vehicle3Comprehensive");
            vehicle3ComprehensiveRow.createCell(1).setCellValue(resultMap.get("ComprehensiveVehicle3"));
            vehicle3ComprehensiveRow.createCell(2).setCellValue(resultMap.get("statusComprehensiveVehicle3"));
            file.close();
            // Updating XLS file
            FileOutputStream outFile = new FileOutputStream(new File(reportPath));
            workbook.write(outFile);
            outFile.close();
        } catch (Exception e) {
            System.out.println("Exception while writing the Report Excel File" + e.getMessage());
        }
    }

    /**
     * FUNCTION NAME        : updateEndorsementReportFile
     * DESCRIPTION          : adds Endorsement results to  Report File
     * INPUT PARAMETERS     : reportPath   ;   resultMap
     * OUTPUT               : None
     * AUTHOR               : Priyal Agarwal
     */
    public synchronized void updateEndorsementReportFile(String reportPath, HashMap<String, String> resultMap) {
        try {
            FileInputStream file = new FileInputStream(new File(reportPath));
            HSSFWorkbook workbook = new HSSFWorkbook(file);
            DataFormatter objDefaultFormat = new DataFormatter();
            FormulaEvaluator objFormulaEvaluator = new HSSFFormulaEvaluator((HSSFWorkbook) workbook);
            String sheetName = resultMap.get("Policy_Number");
            // Check sheet if already present
            if (workbook.getSheetIndex(sheetName) < 0) {
                System.out.println("SheetIndex=" + workbook.getSheetIndex(sheetName));
                throw new IllegalArgumentException("Report file do not have sheet =" + sheetName);
            }
            // Updating Result Sheet
            Sheet endorsementSheet = workbook.getSheet(sheetName);
            Row endorsementRow = endorsementSheet.getRow(8);
            endorsementRow.createCell(5).setCellValue("ENDORSEMENT RESULT:");
            Row totalPremiumRow = endorsementSheet.getRow(9);
            totalPremiumRow.createCell(5).setCellValue("Total Premium");
            totalPremiumRow.createCell(6).setCellValue(resultMap.get("Total_Premium"));
            Row transactionEffectiveDateRow = endorsementSheet.getRow(10);
            transactionEffectiveDateRow.createCell(5).setCellValue("Transaction Effective Date");
            transactionEffectiveDateRow.createCell(6).setCellValue(resultMap.get("Transaction_Effective_Date"));
            Row policyEffectiveDateRow = endorsementSheet.getRow(11);
            policyEffectiveDateRow.createCell(5).setCellValue("Policy Effective Date");
            policyEffectiveDateRow.createCell(6).setCellValue(resultMap.get("Policy_Effective_Date"));
            Row policyExpirationDateRow = endorsementSheet.getRow(12);
            policyExpirationDateRow.createCell(5).setCellValue("Policy Expiration Date");
            policyExpirationDateRow.createCell(6).setCellValue(resultMap.get("Policy_Expiration_Date"));
            Row endorsementStatusRow = endorsementSheet.getRow(13);
            endorsementStatusRow.createCell(5).setCellValue("Status");
            endorsementStatusRow.createCell(6).setCellValue(resultMap.get("End_Status"));
            Row endorsementCommentsRow = endorsementSheet.getRow(14);
            endorsementCommentsRow.createCell(5).setCellValue("Endorsement Comments");
            endorsementCommentsRow.createCell(6).setCellValue(resultMap.get("Endorsement_Comments"));
            Row premiumMatchStatus = endorsementSheet.getRow(15);
            premiumMatchStatus.createCell(5).setCellValue("PremiumMatch_Status");
            premiumMatchStatus.createCell(6).setCellValue(resultMap.get("PremiumMatch_Status"));
            file.close();
            // Updating XLS file
            FileOutputStream outFile = new FileOutputStream(new File(reportPath));
            workbook.write(outFile);
            outFile.close();
        } catch (Exception e) {
            System.out.println("Exception while writing the Report Excel File" + e.getMessage());
        }
    }

    /**
     * FUNCTION NAME        : updateRenewalReportFile
     * DESCRIPTION          : adds Renewal results to  Report File
     * INPUT PARAMETERS     : reportPath   ;   resultMap
     * OUTPUT               : None
     * AUTHOR               : Priyal Agarwal
     */
    public synchronized void updateRenewalReportFile(String reportPath, HashMap<String, String> resultMap) {
        try {
            FileInputStream file = new FileInputStream(new File(reportPath));
            HSSFWorkbook workbook = new HSSFWorkbook(file);
            DataFormatter objDefaultFormat = new DataFormatter();
            FormulaEvaluator objFormulaEvaluator = new HSSFFormulaEvaluator((HSSFWorkbook) workbook);
            String sheetName = resultMap.get("Policy_Number");
            // Check sheet if already present
            if (workbook.getSheetIndex(sheetName) < 0) {
                System.out.println("SheetIndex=" + workbook.getSheetIndex(sheetName));
                throw new IllegalArgumentException("Report file do not have sheet =" + sheetName);
            }
            // Updating Result Sheet
            Sheet renewalSheet = workbook.getSheet(sheetName);
            Row renewalRow = renewalSheet.getRow(8);
            renewalRow.createCell(8).setCellValue("RENEWAL RESULT:");
            Row totalPremiumRow = renewalSheet.getRow(9);
            totalPremiumRow.createCell(8).setCellValue("Total Premium");
            totalPremiumRow.createCell(9).setCellValue(resultMap.get("Total_Premium"));
            Row transactionEffectiveDateRow = renewalSheet.getRow(10);
            transactionEffectiveDateRow.createCell(8).setCellValue("Transaction Effective Date");
            transactionEffectiveDateRow.createCell(9).setCellValue(resultMap.get("Transaction_Effective_Date"));
            Row policyEffectiveDateRow = renewalSheet.getRow(11);
            policyEffectiveDateRow.createCell(8).setCellValue("Policy Effective Date");
            policyEffectiveDateRow.createCell(9).setCellValue(resultMap.get("Policy_Effective_Date"));
            Row policyExpirationDateRow = renewalSheet.getRow(12);
            policyExpirationDateRow.createCell(8).setCellValue("Policy Expiration Date");
            policyExpirationDateRow.createCell(9).setCellValue(resultMap.get("Policy_Expiration_Date"));
            Row renewalStatusRow = renewalSheet.getRow(13);
            renewalStatusRow.createCell(8).setCellValue("Status");
            renewalStatusRow.createCell(9).setCellValue(resultMap.get("Renew_Status"));
            Row premiumMatchStatus = renewalSheet.getRow(14);
            premiumMatchStatus.createCell(8).setCellValue("PremiumMatch_Status");
            premiumMatchStatus.createCell(9).setCellValue(resultMap.get("PremiumMatch_Status"));
            file.close();
            // Updating XLS file
            FileOutputStream outFile = new FileOutputStream(new File(reportPath));
            workbook.write(outFile);
            outFile.close();
        } catch (Exception e) {
            System.out.println("Exception while writing the Report Excel File" + e.getMessage());
        }
    }

    /**
     * FUNCTION NAME        : updateCancellationReportFile
     * DESCRIPTION          : adds Cancellation results to  Report File
     * INPUT PARAMETERS     : reportPath   ;   resultMap
     * OUTPUT               : None
     * AUTHOR               : Priyal Agarwal
     */
    public synchronized void updateCancellationReportFile(String reportPath, HashMap<String, String> resultMap) {
        try {
            FileInputStream file = new FileInputStream(new File(reportPath));
            HSSFWorkbook workbook = new HSSFWorkbook(file);
            DataFormatter objDefaultFormat = new DataFormatter();
            FormulaEvaluator objFormulaEvaluator = new HSSFFormulaEvaluator((HSSFWorkbook) workbook);
            String sheetName = resultMap.get("Policy_Number");
            // Check sheet if already present
            if (workbook.getSheetIndex(sheetName) < 0) {
                System.out.println("SheetIndex=" + workbook.getSheetIndex(sheetName));
                throw new IllegalArgumentException("Report file do not have sheet =" + sheetName);
            }
            // Updating Result Sheet
            Sheet cancelSheet = workbook.getSheet(sheetName);
            Row cancelRow = cancelSheet.getRow(8);
            cancelRow.createCell(11).setCellValue("CANCELLATION RESULT:");
            Row totalPremiumRow = cancelSheet.getRow(9);
            totalPremiumRow.createCell(11).setCellValue("Total Premium");
            totalPremiumRow.createCell(12).setCellValue(resultMap.get("Total_Premium"));
            Row transactionEffectiveDateRow = cancelSheet.getRow(10);
            transactionEffectiveDateRow.createCell(11).setCellValue("Transaction Effective Date");
            transactionEffectiveDateRow.createCell(12).setCellValue(resultMap.get("Transaction_Effective_Date"));
            Row policyEffectiveDateRow = cancelSheet.getRow(11);
            policyEffectiveDateRow.createCell(11).setCellValue("Policy Effective Date");
            policyEffectiveDateRow.createCell(12).setCellValue(resultMap.get("Policy_Effective_Date"));
            Row policyExpirationDateRow = cancelSheet.getRow(12);
            policyExpirationDateRow.createCell(11).setCellValue("Policy Expiration Date");
            policyExpirationDateRow.createCell(12).setCellValue(resultMap.get("Policy_Expiration_Date"));
            Row cancelStatusRow = cancelSheet.getRow(13);
            cancelStatusRow.createCell(11).setCellValue("Status");
            cancelStatusRow.createCell(12).setCellValue(resultMap.get("Cancel_Status"));
            Row cancelCommentsRow = cancelSheet.getRow(14);
            cancelCommentsRow.createCell(11).setCellValue("Cancellation Comments");
            cancelCommentsRow.createCell(12).setCellValue(resultMap.get("Cancel_Comments"));
            Row premiumMatchStatus = cancelSheet.getRow(15);
            premiumMatchStatus.createCell(11).setCellValue("PremiumMatch_Status");
            premiumMatchStatus.createCell(12).setCellValue(resultMap.get("PremiumMatch_Status"));
            file.close();
            // Updating XLS file
            FileOutputStream outFile = new FileOutputStream(new File(reportPath));
            workbook.write(outFile);
            outFile.close();
        } catch (Exception e) {
            System.out.println("Exception while writing the Report Excel File" + e.getMessage());
        }
    }

    /**
     * FUNCTION NAME        : updateReinstateReportFile
     * DESCRIPTION          : adds Reinstate results to  Report File
     * INPUT PARAMETERS     : reportPath   ;   resultMap
     * OUTPUT               : None
     * AUTHOR               : Priyal Agarwal
     */
    public synchronized void updateReinstateReportFile(String reportPath, HashMap<String, String> resultMap) {
        try {
            FileInputStream file = new FileInputStream(new File(reportPath));
            HSSFWorkbook workbook = new HSSFWorkbook(file);
            DataFormatter objDefaultFormat = new DataFormatter();
            FormulaEvaluator objFormulaEvaluator = new HSSFFormulaEvaluator((HSSFWorkbook) workbook);
            String sheetName = resultMap.get("Policy_Number");
            // Check sheet if already present
            if (workbook.getSheetIndex(sheetName) < 0) {
                System.out.println("SheetIndex=" + workbook.getSheetIndex(sheetName));
                throw new IllegalArgumentException("Report file do not have sheet =" + sheetName);
            }
            // Updating Result Sheet
            Sheet reinstatementSheet = workbook.getSheet(sheetName);
            Row reinstateRow = reinstatementSheet.getRow(8);
            reinstateRow.createCell(14).setCellValue("REINSTATE RESULT:");
            Row totalPremiumRow = reinstatementSheet.getRow(9);
            totalPremiumRow.createCell(14).setCellValue("Total Premium");
            totalPremiumRow.createCell(15).setCellValue(resultMap.get("Total_Premium"));
            Row transactionEffectiveDateRow = reinstatementSheet.getRow(10);
            transactionEffectiveDateRow.createCell(14).setCellValue("Transaction Effective Date");
            transactionEffectiveDateRow.createCell(15).setCellValue(resultMap.get("Transaction_Effective_Date"));
            Row policyEffectiveDateRow = reinstatementSheet.getRow(11);
            policyEffectiveDateRow.createCell(14).setCellValue("Policy Effective Date");
            policyEffectiveDateRow.createCell(15).setCellValue(resultMap.get("Policy_Effective_Date"));
            Row policyExpirationDateRow = reinstatementSheet.getRow(12);
            policyExpirationDateRow.createCell(14).setCellValue("Policy Expiration Date");
            policyExpirationDateRow.createCell(15).setCellValue(resultMap.get("Policy_Expiration_Date"));
            Row reinstateStatusRow = reinstatementSheet.getRow(13);
            reinstateStatusRow.createCell(14).setCellValue("Status");
            reinstateStatusRow.createCell(15).setCellValue(resultMap.get("Reinstate_Status"));
            Row premiumMatchStatus = reinstatementSheet.getRow(14);
            premiumMatchStatus.createCell(14).setCellValue("PremiumMatch_Status");
            premiumMatchStatus.createCell(15).setCellValue(resultMap.get("PremiumMatch_Status"));
            file.close();
            // Updating XLS file
            FileOutputStream outFile = new FileOutputStream(new File(reportPath));
            workbook.write(outFile);
            outFile.close();
        } catch (Exception e) {
            System.out.println("Exception while writing the Report Excel File" + e.getMessage());
        }
    }

    /**
     * FUNCTION NAME        : updateRenewalPaymentReportFile
     * DESCRIPTION          : adds Renewal Payment Portal results to  Report File
     * INPUT PARAMETERS     : reportPath   ;   resultMap
     * OUTPUT               : None
     * AUTHOR               : Priyal Agarwal
     */
    public synchronized void updateRenewalPaymentReportFile(String reportPath, HashMap<String, String> resultMap) {
        try {
            FileInputStream file = new FileInputStream(new File(reportPath));
            HSSFWorkbook workbook = new HSSFWorkbook(file);
            DataFormatter objDefaultFormat = new DataFormatter();
            FormulaEvaluator objFormulaEvaluator = new HSSFFormulaEvaluator((HSSFWorkbook) workbook);
            Sheet resultsSheet = workbook.getSheet("RenewalPaymentPortal");
//          Reading Header Row Information
            Row resultsSheetHeaderRow = resultsSheet.getRow(0);
            HashMap<String, Integer> resultsSheetHeaderMap = new HashMap<>();
            for (int itColNum = 0; itColNum <= resultsSheetHeaderRow.getLastCellNum(); itColNum++) {
                Cell cellValue = resultsSheetHeaderRow.getCell(itColNum);
                objFormulaEvaluator.evaluate(cellValue);
                String cellValueStr = objDefaultFormat.formatCellValue(cellValue, objFormulaEvaluator);
                resultsSheetHeaderMap.put(cellValueStr, itColNum);
            }
            int resultsSheetLastRowNum = resultsSheet.getLastRowNum();
            Row resultNewRow = resultsSheet.createRow(resultsSheetLastRowNum + 1);
//          Adding values to result sheet
            for (Map.Entry<String, String> entry : resultMap.entrySet()) {
                String resultKey = entry.getKey();
                String resultValue = entry.getValue();
                if (resultsSheetHeaderMap.containsKey(resultKey)) {
                    Cell resultNewCell = resultNewRow.createCell(resultsSheetHeaderMap.get(resultKey));
                    resultNewCell.setCellValue(resultValue);
                }
            }
            file.close();
//          Updating XLS file
            FileOutputStream outFile = new FileOutputStream(new File(reportPath));
            workbook.write(outFile);
            outFile.close();
        } catch (Exception e) {
            System.out.println("Exception while writing the Report Excel File" + e.getMessage());
        }
    }

}
