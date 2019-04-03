package UtilityFunction;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Hashtable;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
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
	
	
	/**
     * FUNCTION NAME        : GetData
     * DESCRIPTION          : Getting cellData
     * INPUT PARAMETERS     : SheetName
     * OUTPUT               : None
     * AUTHOR               : Laxminarayan Jena
     */
	
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
     * DESCRIPTION          : Reporting of transactions RI,EN etc
     * INPUT PARAMETERS     : data,Transaction Name
     * OUTPUT               : None
     * AUTHOR               : Laxminarayan Jena
     */

	
public static void Reporting(Hashtable<String,String> data ,String txt)
{
	
	HashMap<String, Integer> result = null;
	
    String policyno=data.get("Policy Number") ;	
    
    String Actual_Written_Premium=getText("Actual_Written_Premium");
    System.out.println("Actual_Written_Premium value is " + Actual_Written_Premium);
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



/**
 * FUNCTION NAME        : 2nd type Reporting
 * DESCRIPTION          : Reporting of transactions for umbrella and rapidsure
 * INPUT PARAMETERS     : data,Transaction Name
 * OUTPUT               : None
 * AUTHOR               : Laxminarayan Jena
 */	
public static void Reporting1(Hashtable<String,String> data ,String Policy_Status,String  Actual_Written_Premium ,String Actual_Other_Charges )
{
    HashMap<String, Integer> result = null;
    String policyno=data.get("Policy Number") ;	
    
    report.addColumn(policyno," ");
	report.addColumn(policyno,"StatusResult");
	report.addColumn(policyno, Policy_Status);
	report.setCellData(policyno,"StatusResult", 2, "Written_Premium");
	report.setCellData(policyno,"StatusResult", 3, "Tax");
	report.setCellData(policyno,Policy_Status, 2, Actual_Written_Premium);
	report.setCellData(policyno,Policy_Status, 3, Actual_Other_Charges);
	
}



/**
 * FUNCTION NAME        : Reporting
 * DESCRIPTION          : Reporting of transactions Surety
 * INPUT PARAMETERS     : data,AccountName
 * OUTPUT               : None
 * AUTHOR               : Laxminarayan Jena
 */

public static void ReportingSurety(Hashtable<String,String> data ,String AccountName,String PolicyStatus)
{
	
String ExpectedPolicyStatus = null;
HashMap<String, Integer> result = null;
report.addColumn(AccountName, AccountName);
int lastrowno=	report.getRowCountofSpecificColumn(AccountName, 1);								
String LastRepasStatus=report.getCellData(AccountName, 1, lastrowno+1);
System.out.println("my repas status is "+LastRepasStatus);

if(LastRepasStatus.equals("Cancel"))
{
	ExpectedPolicyStatus="Cancel";
}

else
{
	ExpectedPolicyStatus="Active";
}
System.out.println("Expected Policy Status is-"+ExpectedPolicyStatus );
System.out.println(" Policy Status in billing centre is-"+PolicyStatus );

if(AccountName.equals("TC02-TERM_Multi"))
	{
	 report.setCellData(AccountName, 3,24, "BILLING CENTRE STATUS");
	}

else if(AccountName.equals("TC08-Non-TERM_Short_Ext"))
{
 report.setCellData(AccountName, 3,24, "BILLING CENTRE STATUS");
}

else if(AccountName.equals("TC09-KY_TERM_12MO"))
{
 report.setCellData(AccountName, 3,27, "BILLING CENTRE STATUS");
}

else if(AccountName.equals("TC10-FL_Non-TERM_Multi"))
{
 report.setCellData(AccountName, 3,39, "BILLING CENTRE STATUS");
}

 else 
	{
	 report.setCellData(AccountName, 3,31, "BILLING CENTRE STATUS");
	}



int lastrownoBC=report.getRowCountofSpecificColumn(AccountName, 3);
report.setCellData(AccountName, 3, lastrownoBC+2, LastRepasStatus);

if(PolicyStatus.equals(ExpectedPolicyStatus))
{
	report.setCellData(AccountName, 4, lastrownoBC+2, "TRUE");
}
else
{
	report.setCellData(AccountName, 4, lastrownoBC+2, "FALSE");
}

}






/**
 * FUNCTION NAME        : RNReporting
 * DESCRIPTION          : Reporting of transactions Renewal
 * INPUT PARAMETERS     : data,Transaction Name
 * OUTPUT               : None
 * AUTHOR               : Laxminarayan Jena
 * @throws InterruptedException 
 */




public static void RenewalTransaction(Hashtable<String,String> data ,String txt) throws InterruptedException
{

HashMap<String, Integer> result = null;

String policyno=data.get("Policy Number") ;	

result=excel.FindPosition(policyno, txt); 

int colno=result.get("colno1");
int rowno=result.get("rowno1");
System.out.println("Renewal colno is"+ colno);
System.out.println("Renewal rowno is"+ rowno);
			

String RNPolicyNo=(report.getCellData(policyno, colno+1, rowno+7));
System.out.println("Renewal policy no is "+RNPolicyNo);


click("policy");
Thread.sleep(3000);
driver.findElement(By.xpath(OR.getProperty("policyNoText"))).clear();
type("policyNoText", RNPolicyNo);
click("Search");

if (isElementPresent(OR.getProperty("errorMsg")))

{
	String errorMsg = getText("errorMsg");
	System.out.println(errorMsg + "with policy no-" + policyno);
	
}

else
	
{
	
	click("policyno");
	String Actual_Written_Premium=getText("Actual_Written_Premium");
	
	String s=Actual_Written_Premium;
	String FormattedActual_Written_Premium=s.replaceAll("[^$.a-zA-Z0-9]", "");	
	
	
	int lastrowno=report.getRowCountofSpecificColumn(policyno, colno);
	System.out.println("last rowno " + policyno + "with column no" + colno +"is-"+lastrowno);
	

	String reportpremium=(report.getCellData(policyno, colno+1, rowno+2));	
	String Formattedreportpremium="$"+reportpremium+"0" ;
	
	System.out.println("report premium is "+Formattedreportpremium);
	System.out.println("actual written premium is "+ FormattedActual_Written_Premium);
	
	if(Formattedreportpremium.equals(FormattedActual_Written_Premium))
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



public static void SplitRenewalTransaction(Hashtable<String,String> data ,String txt) throws InterruptedException
{

	

String policyno=data.get("Policy Number") ;	

String RN_Policy1= report.getCellData(policyno, 5, 24);
System.out.println("split scenraio 1st policy no " + RN_Policy1);

String RN_Policy2= report.getCellData(policyno, 7, 24);
System.out.println("split scenraio 2nd policy no " + RN_Policy2);



click("policy");
Thread.sleep(3000);
driver.findElement(By.xpath(OR.getProperty("policyNoText"))).clear();
type("policyNoText", RN_Policy1);
click("Search");

if (isElementPresent(OR.getProperty("errorMsg")))

{
	String errorMsg = getText("errorMsg");
	System.out.println(errorMsg + "with policy no-" + policyno);
	
}

else
	
{
	
	click("policyno");
	String Actual_Written_Premium=getText("Actual_Written_Premium");
	
	String s=Actual_Written_Premium;
	String FormattedActual_Written_Premium=s.replaceAll("[^$.a-zA-Z0-9]", "");	
	
	String reportpremium=report.getCellData(policyno, 5, 18);	
	String Formattedreportpremium="$"+reportpremium+"0" ;
	
	System.out.println("report premium is "+Formattedreportpremium);
	System.out.println("actual written premium is "+ FormattedActual_Written_Premium);
	
	if(Formattedreportpremium.equals(FormattedActual_Written_Premium))
	{
		report.setCellData(policyno, 5, 28, "Pass");
	}
	else
	{
		report.setCellData(policyno, 5, 28, "Fail");
	}
		
				
	report.setCellData(policyno, 4, 27 ,"Billing Center Premium");
	report.setCellData(policyno, 5, 27 ,Actual_Written_Premium);
	report.setCellData(policyno, 4, 28, "Billing Center Status");
}

	







click("policy");
Thread.sleep(3000);
driver.findElement(By.xpath(OR.getProperty("policyNoText"))).clear();
type("policyNoText", RN_Policy2);
click("Search");

if (isElementPresent(OR.getProperty("errorMsg")))

{
	String errorMsg = getText("errorMsg");
	System.out.println(errorMsg + "with policy no-" + policyno);
	
}

else
	
{
	
	click("policyno");
	String Actual_Written_Premium=getText("Actual_Written_Premium");
	
	String s=Actual_Written_Premium;
	String FormattedActual_Written_Premium=s.replaceAll("[^$.a-zA-Z0-9]", "");	
	
	String reportpremium=report.getCellData(policyno, 7, 18);	
	String Formattedreportpremium="$"+reportpremium+"0" ;
	
	System.out.println("report premium is "+Formattedreportpremium);
	System.out.println("actual written premium is "+ FormattedActual_Written_Premium);
	
	if(Formattedreportpremium.equals(FormattedActual_Written_Premium))
	{
		report.setCellData(policyno, 7, 28, "Pass");
	}
	else
	{
		report.setCellData(policyno, 7, 28, "Fail");
	}
		
				
	report.setCellData(policyno, 6, 27 ,"Billing Center Premium");
	report.setCellData(policyno, 7, 27 ,Actual_Written_Premium);
	report.setCellData(policyno, 6, 28, "Billing Center Status");
}


}
}

	

