/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 3/26/2018 4:44:28 AM
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
Extends BaseModuleDriver class and performs application specific operations
*/
public class Producer_View_HistoryDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public Producer_View_HistoryDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void Validate_Prod_Hist_Scre(DataRow input, DataRow output) {
		//1. Click on History WebElement
		uiDriver.click("Verfiy_Producer_History.eltHistory");
		SleepUtils.sleep(4);			
		
		//2. Verify whether the Contact First Name not Present
		if (!uiDriver.checkElementPresent("Producer_View_History.eltFirstName")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		
		//3. Verify whether the Contact Last Name not Present 
		if (!uiDriver.checkElementPresent("Producer_View_History.eltLastName")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		
		//4. Verify whether the Phone not Present 
		if (!uiDriver.checkElementPresent("Producer_View_History.eltPhone")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		
		//5. Verify whether the Email not Present 
		if (!uiDriver.checkElementPresent("Producer_View_History.eltEmail")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		
		//6.Verify whether the Type not Present 
		if (!uiDriver.checkElementPresent("Producer_View_History.eltType")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		
		//7. Verify whether the Medium not Present
		if (!uiDriver.checkElementPresent("Producer_View_History.eltMedium")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		
		//8. Verify whether the Footprint ticket not Present 
		if (!uiDriver.checkElementPresent("Producer_View_History.eltFootprintTicket")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		
		//9.Verify Funds Transfer value not present in drop down
		uiDriver.click("Change_Charge_Commissions.lstFilter_by_Type");
		SleepUtils.sleep(2);
		uiDriver.getElementNameUsingTag("li", "Funds Transfer");
		SleepUtils.sleep(6);	

	}
	
	public void Validate_Acc_Hist_Screen(DataRow input, DataRow output) {
		//1. Click on History WebElement
		uiDriver.click("CreateAccountShell_NEP.eltHistory");
		SleepUtils.sleep(6);			

		//2. Verify whether the Contact First Name not Present
		if (!uiDriver.checkElementPresent("Producer_View_History.eltFirstName")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		
		//3. Verify whether the Contact Last Name not Present 
		if (!uiDriver.checkElementPresent("Producer_View_History.eltLastName")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		
		//4. Verify whether the Phone not Present 
		if (!uiDriver.checkElementPresent("Producer_View_History.eltPhone")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		
		//5. Verify whether the Email not Present 
		if (!uiDriver.checkElementPresent("Producer_View_History.eltEmail")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		//6.Verify whether the Type not Present 
		if (!uiDriver.checkElementPresent("Producer_View_History.eltType")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		
		//7. Verify whether the Medium not Present
		if (!uiDriver.checkElementPresent("Producer_View_History.eltMedium")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		//8. Verify whether the Footprint ticket not Present 
		if (!uiDriver.checkElementPresent("Producer_View_History.eltFootprintTicket")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		
		//9.Verify Funds Transfer value not present in drop down
		uiDriver.click("CreatePolicyShell_NEP.eltFilter_by_Type");
		SleepUtils.sleep(2);
		uiDriver.getElementNameUsingTag("li", "Funds Transfer");
		SleepUtils.sleep(6);
		uiDriver.sendKey("Esc");
		SleepUtils.sleep(6);		
		
		//10. Click on Policies WebElement
		uiDriver.click("HoldChar_History_AccLevlPoliLe.eltPolicies");
		SleepUtils.sleep(4);
		
		//11.Click on policy link
		uiDriver.click("US1091_ViewChargesAccntAndPoli.lnkPolicy");
		SleepUtils.sleep(4);
		
		//12.Click on History link
		uiDriver.click("PolicyViewHistory_Validate.eltHistory");
		SleepUtils.sleep(4);	
			
		//13. Verify whether the Contact First Name not Present
		if (!uiDriver.checkElementPresent("Producer_View_History.eltFirstName")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		
		//14. Verify whether the Contact Last Name not Present 
		if (!uiDriver.checkElementPresent("Producer_View_History.eltLastName")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		
		//15. Verify whether the Phone not Present 
		if (!uiDriver.checkElementPresent("Producer_View_History.eltPhone")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		
		//16. Verify whether the Email not Present 
		if (!uiDriver.checkElementPresent("Producer_View_History.eltEmail")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		
		//17.Verify whether the Type not Present 
		if (!uiDriver.checkElementPresent("Producer_View_History.eltType")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		
		//18. Verify whether the Medium not Present
		if (!uiDriver.checkElementPresent("Producer_View_History.eltMedium")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		
		//19. Verify whether the Footprint ticket not Present 
		if (!uiDriver.checkElementPresent("Producer_View_History.eltFootprintTicket")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		
		//20.Verify Funds Transfer value not present in drop down
		uiDriver.click("PolicyContacts_Editadd_roleupd.lstFilter_by_Type");
		SleepUtils.sleep(2);
		uiDriver.getElementNameUsingTag("li", "Funds Transfer");
		SleepUtils.sleep(6);
	}
		
	/**
	*Overriding toString() method of object class to print Update_Agency_Bill_Executed_Promises
	*format string
	**/
	public String toString(){
		return "Producer_View_HistoryDriver";
	}
}
