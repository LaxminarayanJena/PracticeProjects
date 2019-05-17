/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 12/26/2017 5:51:54 AM
Module part of 'Guidewire_BillingCenter'
Module created using Cafenext Selenium Builder
******************************************************************************/
package ModuleDrivers;
import static cbf.engine.TestResultLogger.*;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;

import cbf.engine.TestResult.ResultType;
import cbf.harness.ParameterAccess;
import cbf.utils.DataRow;
import cbf.utils.SleepUtils;
import cbf.utils.SleepUtils.TimeSlab;
import cbfx.selenium.BaseWebModuleDriver;
import sun.util.calendar.BaseCalendar.Date;

/**
Extends BaseModuleDriver class and performs application specific operations
*/
public class Advance_Commission_PaymentDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public Advance_Commission_PaymentDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void TC01_Advance_Commi_Paymnt(DataRow input, DataRow output) {
		
		//1. Click on Actions WebElement
		SleepUtils.sleep(8);
		uiDriver.click("VerifyField_ProdLevel.eltActions");
			

		//2. Click on New Commission payment WebElement
		uiDriver.mouseOver("New_Commission_Payments.eltNew_Comm_Payment");
		SleepUtils.sleep(4);
		
		//3. Click on Advance WebElement
		uiDriver.click("TC01_Advance_Commi_Paymnt.eltAdvanc");
		SleepUtils.sleep(4);
		
		//4. Type $data In Amount
		uiDriver.setValue("TC01_Advance_Commi_Paymnt.txtAmount", input.get("Type@Amount"));
		SleepUtils.sleep(4);
		
		//5. Click on Advance WebElement
		String sDate=uiDriver.getControl("TC01_Advance_Commi_Paymnt.eltCurrentTime").getText();
		SleepUtils.sleep(4);
		DateFormat originalFormat = new SimpleDateFormat("MMM dd, yyyy");
		DateFormat targetFormat = new SimpleDateFormat("MM/dd/yyyy");
		java.util.Date date = null;
		try {
			 date = originalFormat.parse(sDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String formattedDate = targetFormat.format(date);
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Calendar c = Calendar.getInstance();
		try{
		   c.setTime(sdf.parse(formattedDate));
		}catch(ParseException e){
		   e.printStackTrace();
		 }
		//6. Incrementing the date by 1 day
		c.add(Calendar.DAY_OF_MONTH, 1);  
		String newDate = sdf.format(c.getTime()); 
		
		//7. Click on Maintain until WebElement
		uiDriver.setValue("TC01_Advance_Commi_Paymnt.eltMaintainUntil", newDate);
		SleepUtils.sleep(2);
		
		//8. Verify whether the Select element is present
		if (uiDriver.checkElementPresent("TC01_Advance_Commi_Paymnt.eltNewNoteProducer")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		
		//9.verify not present funds transfer value in list
		uiDriver.click("TC01_Advance_Commi_Paymnt.lstTopic");
		SleepUtils.sleep(4);
		boolean sflag=uiDriver.getElementNameUsingTag("li", "Advance Commission Payment");
		if(sflag) {
			passed("checkElementPresent","checkElemenotPresent should pass"+"Advance Commission Payment","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass"+"Advance Commission Payment","checkElementnotPresent failed");
		}
		SleepUtils.sleep(4);
		uiDriver.click("TC01_Advance_Commi_Paymnt.lstTopic");
		SleepUtils.sleep(4);
		
		//10. Type $data In Subject
		uiDriver.setValue("TC01_Advance_Commi_Paymnt.txtSubject", input.get("Type@Subject"));
		SleepUtils.sleep(4);
		
		//11. Type $data In Text
		uiDriver.setValue("TC01_Advance_Commi_Paymnt.txtText", input.get("Type@Text"));
		SleepUtils.sleep(4);
		
		//12. Click on button Next
		uiDriver.click("TC01_Advance_Commi_Paymnt.btnNext");
		SleepUtils.sleep(4);
		
		//13. Click on button Finish
		uiDriver.click("TC01_Advance_Commi_Paymnt.btnFinish");
		SleepUtils.sleep(4);
		
		//14. Click on Transactions element
		uiDriver.click("Validate_Transactions_prod_scr.eltTransactions");
		SleepUtils.sleep(4);
			
		//15.verify the trasaction presented in the table
		String  searchName="$"+input.get("Type@Amount")+".00";
		uiDriver.th.findRelativeCellAndClickSelectedCellInSubtext("TC01_Advance_Commi_Paymnt.tblProducerTransaction", searchName, 8, searchName, "ReverseDetails", "Details");
		SleepUtils.sleep(4);	
		
		//16. verify the note 
		String Subject=uiDriver.getControl("TC01_Advance_Commi_Paymnt.eltSubject").getText();
		if(Subject.equalsIgnoreCase(input.get("Type@Subject"))) {
			passed("checkElementPresent","checkElemePresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementnotPresented failed");
		}
			
		//17. Click on Return to Transactions link
		uiDriver.click("TC01_Advance_Commi_Paymnt.lnkReturntoTransaction");
		SleepUtils.sleep(4);
					
	}
	public void TC_08_Verify_Pay_Error_Mess(DataRow input, DataRow output) {
		
		//1. Click on Actions WebElement
		SleepUtils.sleep(8);
		uiDriver.click("VerifyField_ProdLevel.eltActions");
			
		//2. Click on New Commission payment WebElement
		uiDriver.mouseOver("New_Commission_Payments.eltNew_Comm_Payment");
		SleepUtils.sleep(4);
		
		//3. Click on Advance WebElement
		uiDriver.click("TC01_Advance_Commi_Paymnt.eltAdvanc");
		SleepUtils.sleep(4);
		
		//4. Type $data In Amount
		uiDriver.setValue("TC01_Advance_Commi_Paymnt.txtAmount", input.get("Type@Amount"));
		SleepUtils.sleep(4);
		
		//5. Click on Advance WebElement
		String sDate=uiDriver.getControl("TC01_Advance_Commi_Paymnt.eltCurrentTime").getText();
		SleepUtils.sleep(4);
		DateFormat originalFormat = new SimpleDateFormat("MMM dd, yyyy");
		DateFormat targetFormat = new SimpleDateFormat("MM/dd/yyyy");
		java.util.Date date = null;
		try {
			 date = originalFormat.parse(sDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String formattedDate = targetFormat.format(date);
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Calendar c = Calendar.getInstance();
		try{
		   c.setTime(sdf.parse(formattedDate));
		}catch(ParseException e){
		   e.printStackTrace();
		 }
		 
		//6. Incrementing the date by 1 day
		c.add(Calendar.DAY_OF_MONTH, 1);  
		String newDate = sdf.format(c.getTime()); 
		
		//7. Click on Maintain until WebElement
		uiDriver.setValue("TC01_Advance_Commi_Paymnt.eltMaintainUntil", newDate);
		SleepUtils.sleep(2);
		
		//8. Type $data In Subject
		uiDriver.setValue("TC01_Advance_Commi_Paymnt.txtSubject", input.get("Type@Subject"));
		SleepUtils.sleep(4);
		
		//9. Type $data In Text
		uiDriver.setValue("TC01_Advance_Commi_Paymnt.txtText", input.get("Type@Text"));
		SleepUtils.sleep(4);
		
		//10. Click on pay on date radio button
		uiDriver.click("TC01_Advance_Commi_Paymnt.rdgPayondate");
		SleepUtils.sleep(4);
		
		//11. Type $data In Subject
		uiDriver.setValue("TC01_Advance_Commi_Paymnt.txtPayonDate", input.get("Type@today_date"));
		
		//12. Click on button Next
		uiDriver.click("TC01_Advance_Commi_Paymnt.btnNext");
		SleepUtils.sleep(4);
		
		//13.verifiy the pay on date error msg
		String payonDatemsg=uiDriver.getControl("TC01_Advance_Commi_Paymnt.txtPayonDateerrormsg").getText();
		if(payonDatemsg.equalsIgnoreCase("Pay On Date : You cannot select a date in the past")) {
			passed("checkerrmessagePresent","checkerrmessagePresent should pass","checkerrmessagePresent passed");
		} else {
			failed("checkerrmessagePresent","checkerrmessagePresent should pass","\"checkerrmessagenotPresent failed");
			
		}
		
	}
	

	/**
	*Overriding toString() method of object class to print TC02_03_04_ChkStubDet_FundTra
	*format string
	**/
	public String toString(){
		return "Advance_Commission_PaymentDriver";
	}
}
