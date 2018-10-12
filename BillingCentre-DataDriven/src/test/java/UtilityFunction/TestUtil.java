package UtilityFunction;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Hashtable;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import Script.BaseTest;


/**
 * Created by ljena on 8/05/2018.
 */

public class TestUtil extends BaseTest {
	
	public static String mailscreenshotpath;
	public static String screenshotName;
	public  String TodayDate;
	HashMap<String, Integer> result = null;
	
	
	@DataProvider
	public static Object[][] getData(String sheetName){
		
		
		int rows = report.getRowCount(sheetName);
		int cols = report.getColumnCount(sheetName);
		Object[][] data = new Object[rows - 1][1];		
		Hashtable<String,String> table = null;
		for (int rowNum = 2; rowNum <= rows; rowNum++) { 

			table = new Hashtable<String,String>();
			
			for (int colNum = 0; colNum < cols; colNum++) {
				table.put(report.getCellData(sheetName, colNum, 1), report.getCellData(sheetName, colNum, rowNum));
				data[rowNum - 2][0] = table;
			}

		}

		return data;

	}
	
	/**
     * FUNCTION NAME        : captureScreenShot
     * DESCRIPTION          : Capturing screenshot
     * INPUT PARAMETERS     : None
     * OUTPUT               : None
     * AUTHOR               : Laxminarayan Jena
     */
	public static void captureScreenShot() throws IOException{
		
		
		 Calendar cal = new GregorianCalendar();
		  int month = cal.get(Calendar.MONTH); //4
		  int year = cal.get(Calendar.YEAR); //2013
		  int sec =cal.get(Calendar.SECOND);
		  int min =cal.get(Calendar.MINUTE);
		  int date = cal.get(Calendar.DATE);
		  int day =cal.get(Calendar.HOUR_OF_DAY);
		  
		  
		 screenshotName=year+"_"+date+"_"+(month+1)+"_"+day+"_"+min+"_" +sec+".jpeg"; 
		 mailscreenshotpath = System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\"+year+"_"+date+"_"+(month+1)+"_"+day+"_"+min+"_" +sec+".jpeg"; 
		

		File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scr, new File(mailscreenshotpath));
		FileUtils.copyFile(scr, new File(System.getProperty("user.dir")+"\\src\\test\\java\\screenshot\\error.jpeg"));
		
		
		
	}

	/**
     * FUNCTION NAME        : Reporting
     * DESCRIPTION          : Reporting of transactions RN,RI,EN etc
     * INPUT PARAMETERS     : data,Transaction Name
     * OUTPUT               : None
     * AUTHOR               : Laxminarayan Jena
     */

	
public static void Reporting(Hashtable<String,String> data ,String txt)
{
	
	HashMap<String, Integer> result = null;
	
    String policyno=data.get("Policy Number") ;	
    
  //  String Actual_Written_Premium=getText("Actual_Written_Premium");
    String Actual_Written_Premium="19000";
	result=excel.FindPosition(policyno, txt); 
	
	int colno=result.get("colno1");
	int rowno=result.get("rowno1");
	System.out.println("colno is"+ colno);
	System.out.println("rowno is"+ rowno);
				
	
	int lastrowno=report.getRowCountofSpecificColumn(policyno, colno);
	System.out.println("last rowno " + policyno + "with column no" + colno +"is-"+lastrowno);
	

	String reportpremium=(report.getCellData(policyno, colno+1, rowno+2));
	System.out.println("report premium is "+reportpremium);
	
	if(reportpremium.equals(Actual_Written_Premium))
	{
		report.setCellData(policyno, colno+1, lastrowno+3, "Pass");
	}
	else
	{
		report.setCellData(policyno, colno+1, lastrowno+3, "Fail");
	}
		
				
	report.setCellData(policyno, colno, lastrowno+2 ,"Billing Center Premium");
	report.setCellData(policyno, colno+1, lastrowno+2 ,Actual_Written_Premium);
	report.setCellData(policyno, colno, lastrowno+3, "Billing Center Status");
}
	
	
	
}
