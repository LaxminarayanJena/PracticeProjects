package Resources;


import Scripts.CV_NB;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;

import static Resources.GlobalVariables.POP_UP_TIME_OUT;


public class RSLibraryFile {

    /**
     * FUNCTION NAME        : waitForPopUpToOpen
     * DESCRIPTION          : waits for the pop up to open
     * INPUT PARAMETERS     : Driver
     * OUTPUT               : None
     */
    public static void waitForPopUpToOpen(WebDriver driver) {
        try {
            for (int itr = 1; itr < POP_UP_TIME_OUT; itr++) {
                WebElement webElement = driver.findElement(By.className("icePnlPop"));
                String styleWebElement = webElement.getAttribute("style");
                System.out.println("styleWebElement=" + styleWebElement);
                if (styleWebElement.contains("visibility: visible")) {
                    System.out.println("Pop up opened");
                    break;
                }
                System.out.println("Waiting for the pop up to Open");
                Thread.sleep(2000);
            }
        } catch (Exception e) {
            System.out.println("Exception occurred in waitForPopUpToOpen");
        }
    }

    /**
     * FUNCTION NAME        : waitForPopUpToClose
     * DESCRIPTION          : waits for the pop up to close
     * INPUT PARAMETERS     : Driver
     * OUTPUT               : None
     */
    public static void waitForPopUpToClose(WebDriver driver) {
        try {
            for (int itr = 1; itr < POP_UP_TIME_OUT; itr++) {
                List<WebElement> webElements = driver.findElements(By.className("icePnlPop"));
                if (webElements.size() != 0) {
                    String styleWebElement = webElements.get(0).getAttribute("style");
                    System.out.println("styleWebElement=" + styleWebElement);
                    if (!styleWebElement.contains("visibility: visible")) {
                        System.out.println("Pop up Closed");
                        break;
                    }
                } else {
                    break;
                }
                System.out.println("Waiting for the pop up to Closed");
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            System.out.println("Exception occurred in waitForPopUpToClose");
        }
        
       
    }
    /**
     * FUNCTION NAME        : stripping pdf
     * DESCRIPTION          : stripping pdf page wise
     * INPUT PARAMETERS     : document,FileName
     * OUTPUT               : None
     */
    public static void pdfstripping( PDDocument document ,String downloadedfilename) throws InvalidPasswordException, IOException 
	{

		document = PDDocument.load( new File(downloadedfilename) );
		PDFTextStripper stripper = new CV_NB();
        stripper.setSortByPosition( true );
        stripper.setStartPage(1 );
        stripper.setEndPage(1);                    
        Writer dummy = new OutputStreamWriter(new ByteArrayOutputStream());
        stripper.writeText(document, dummy);
	}
    
    /**
     * FUNCTION NAME        : validate pdf
     * DESCRIPTION          : validate pdf
     * INPUT PARAMETERS     : pdfqoute_number, Quote_Number, PdfAccount_Number,Account_Number,PdfBILLING_DATE,Date
     * OUTPUT               : Validation result
     * @return 
     */
    public static HashMap<String, String> validatePDF(String pdfqoute_number,String Quote_Number,String PdfAccount_Number,String Account_Number,String PdfBILLING_DATE,String Date) throws IOException, InterruptedException	{
    	boolean isFalse =false;
    	String vldmsg1 ="";
    	String vldmsg2 = "";
    	String vldmsg3 = "";
    	String result;
    	String finalvldmsg;
    	HashMap<String, String> mapResult= new HashMap<String, String>(); 
    	if (pdfqoute_number.contains(Quote_Number))
         {
         	System.out.println("A.Premium Quotation Number:"+Quote_Number+" text is present in page no-1 and line no 2");      
         }          
         else
         {
         	System.out.println("A.Premium Quotation Number:"+Quote_Number+" text is not present in page no-1 and line no 2");
         	 vldmsg1="A.Premium Quotation Number:"+Quote_Number+" text is not present in page no-1 and line no 2";
            isFalse=true;
         }                   
         if (PdfAccount_Number.contains(Account_Number))
         {
         	System.out.println("B.Account Number:"+Account_Number+" text is present in page no-1 and line no 28");
         }        
         else
         {
         	System.out.println("B.Account Number:"+Account_Number+" text is not present in page no-1 and line no 28");
         	vldmsg2="B.Account Number:"+Account_Number+" text is not present in page no-1 and line no 28";
         	isFalse=true;
         }        
         if (PdfBILLING_DATE.contains(Date))
         {       	
         	System.out.println("C.BILLING DATE:"+ Date +" text is present in page no-1 and line no 29");
         }
         
         else
         {
         	System.out.println("C.BILLING DATE:"+ Date +" text is not present in page no-1 and line no 29");
         	vldmsg3="C.BILLING DATE:"+ Date +" text is not present in page no-1 and line no 29";
         	isFalse=true;
         }         
         if(isFalse)
         {       	 
        	 result="Fail";
        	 finalvldmsg=vldmsg1+ vldmsg2 + vldmsg3;        	
        	 mapResult.put("result", result);
        	 mapResult.put("finalvldmsg", finalvldmsg);
         }
         else
         {
        	 //System.out.println("----PDF validation Passed----");
        	 result=" Pass";
        	 finalvldmsg="";
        	 mapResult.put("result", result);
        	 mapResult.put("finalvldmsg", finalvldmsg);
         }
		return mapResult;
          
    
         
              

    }

}
