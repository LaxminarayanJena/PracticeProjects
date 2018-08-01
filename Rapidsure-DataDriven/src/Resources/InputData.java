package Resources;

import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
//import org.testng.Reporter;

/**
 * Created by agarwalp on 5/28/2017.
 */

public class InputData {
    private HashMap<String, String> tableData;

    public InputData(String inputDataPath, String sheetName, int rowNumber) {
        tableData = readInputData(inputDataPath, sheetName, rowNumber);
    }

    public InputData(String inputDataPath, String sheetName, String columnName, String columnValue) {
        tableData = readInputDataWithColumnValue(inputDataPath, sheetName, columnName, columnValue);
    }

    /**
     * FUNCTION NAME        : getColumnData
     * DESCRIPTION          : returns the value for String passed
     * INPUT PARAMETERS     : columnName
     * OUTPUT               : String value
     * AUTHOR               : Priyal Agarwal
     */
    public String getColumnData(String columnName) {
        return tableData.get(columnName);
    }

    /**
     * FUNCTION NAME        : readInputData
     * DESCRIPTION          : reads data from input file
     * INPUT PARAMETERS     : inputDataPath ;   sheetName   ;   rowNumber
     * OUTPUT               : HashMap<String,String>
     * AUTHOR               : Priyal Agarwal
     */
    private HashMap<String, String> readInputData(String inputDataPath, String sheetName, int rowNumber) {
        HashMap<String, String> hmInputData = new HashMap<>();
        try {
            FileInputStream ExcelFile = new FileInputStream(inputDataPath);
            Workbook wb = WorkbookFactory.create(ExcelFile);
            DataFormatter objDefaultFormat = new DataFormatter();
            FormulaEvaluator objFormulaEvaluator = new HSSFFormulaEvaluator((HSSFWorkbook) wb);
            Sheet sheet = wb.getSheet(sheetName);
            Row headerRow = sheet.getRow(0);
            Row dataRow = sheet.getRow(rowNumber);
            int lastColumnNumber = headerRow.getLastCellNum();
            for (int iterator1 = 0; iterator1 < lastColumnNumber; iterator1++) {
                String headerCellData = objDefaultFormat.formatCellValue(headerRow.getCell(iterator1), objFormulaEvaluator);
                String dataCellData = objDefaultFormat.formatCellValue(dataRow.getCell(iterator1), objFormulaEvaluator);
                if (!headerCellData.isEmpty() && !dataCellData.isEmpty()) {
                    hmInputData.put(headerCellData, dataCellData);
                }
            }
            //Close the Excel File
            ExcelFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("Not able to read Input Data");
        } catch (InvalidFormatException e) {
            System.out.println("Wrong file format");
        } catch (IOException e) {
            System.out.println("Input Output Exception");
        }
        return hmInputData;
    }

    /**
     * FUNCTION NAME        : readInputDataWithColumnValue
     * DESCRIPTION          : reads data from input file for respective state
     * INPUT PARAMETERS     : inputDataPath ;   sheetName   ;   rowNumber   ;   columnValue
     * OUTPUT               : HashMap<String,String>
     * AUTHOR               : Priyal Agarwal
     */
    private HashMap<String, String> readInputDataWithColumnValue(String inputDataPath, String sheetName, String columnName, String columnValue) {
        HashMap<String, String> hmInputData = new HashMap<>();
        try {
            FileInputStream ExcelFile = new FileInputStream(inputDataPath);
            Workbook wb = WorkbookFactory.create(ExcelFile);
            DataFormatter objDefaultFormat = new DataFormatter();
            FormulaEvaluator objFormulaEvaluator = new HSSFFormulaEvaluator((HSSFWorkbook) wb);
            Sheet sheet = wb.getSheet(sheetName);
            Row headerRow = sheet.getRow(0);
            int requiredColumnNumber = -1;
            int lastColumnNumber = headerRow.getLastCellNum();
            for (int iterator1 = 0; iterator1 < lastColumnNumber; iterator1++) {
                String headerCellData = objDefaultFormat.formatCellValue(headerRow.getCell(iterator1), objFormulaEvaluator);
                if (headerCellData.equalsIgnoreCase(columnName)) {
                    requiredColumnNumber = iterator1;
                    break;
                }
            }
            if (requiredColumnNumber < 0) {
                throw new IllegalArgumentException("Sheet=" + sheetName + " does not contain required column=" + columnName);
            }
            int lastRowNumber = sheet.getPhysicalNumberOfRows();
            int requiredRowNumber = -1;
            for (int rowNumber = 0; rowNumber < lastRowNumber; rowNumber++) {
                Row dataRow = sheet.getRow(rowNumber);
                String dataCellData = objDefaultFormat.formatCellValue(dataRow.getCell(requiredColumnNumber), objFormulaEvaluator);
                if (!dataCellData.isEmpty() && dataCellData.equalsIgnoreCase(columnValue)) {
                    requiredRowNumber = rowNumber;
                    break;
                }
            }
            if (requiredRowNumber < 0) {
                throw new IllegalArgumentException("Sheet=" + sheetName + " and column" + columnName + " does not contain required Value=" + columnValue);
            }
            Row requiredDataRow = sheet.getRow(requiredRowNumber);
            for (int iterator1 = 0; iterator1 < lastColumnNumber; iterator1++) {
                String headerCellData = objDefaultFormat.formatCellValue(headerRow.getCell(iterator1), objFormulaEvaluator);
                String dataCellData = objDefaultFormat.formatCellValue(requiredDataRow.getCell(iterator1), objFormulaEvaluator);
                if (!headerCellData.isEmpty() && !dataCellData.isEmpty()) {
                    hmInputData.put(headerCellData, dataCellData);
                }
            }
            //Close the Excel File
            ExcelFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("Not able to read Input Data");
        } catch (InvalidFormatException e) {
            System.out.println("Wrong file format");
        } catch (IOException e) {
            System.out.println("Input Output Exception");
        }
        return hmInputData;
    }

}
