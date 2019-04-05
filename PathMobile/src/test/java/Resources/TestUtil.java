package Resources;

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




/**
 * Created by ljena on 05/04/2019.
 */

public class TestUtil extends BaseTest {
	
	public static String mailscreenshotpath;
	public static String screenshotName;
	public  String TodayDate;
	
	
	
	
	
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

	

}


	

