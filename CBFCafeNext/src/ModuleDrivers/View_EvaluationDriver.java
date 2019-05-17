/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 12/26/2017 5:51:54 AM
Module part of 'Guidewire_BillingCenter'
Module created using Cafenext Selenium Builder
******************************************************************************/
package ModuleDrivers;
import static cbf.engine.TestResultLogger.*;
import java.io.IOException;

import org.openqa.selenium.By;

import cbf.engine.TestResult.ResultType;
import cbf.harness.ParameterAccess;
import cbf.utils.DataRow;
import cbf.utils.SleepUtils;
import cbf.utils.SleepUtils.TimeSlab;
import cbfx.selenium.BaseWebModuleDriver;

/**
Extends BaseModuleDriver class and performs application specific operations
*/
public class View_EvaluationDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public View_EvaluationDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void TC01_03_Acc_Eval_Screen(DataRow input, DataRow output) {
		
		//1. Click on Evaluation WebElement
		SleepUtils.sleep(4);
		uiDriver.click("TC01_03_Acc_Eval_Screen.eltEvaluation");
		SleepUtils.sleep(8);
		
		//2. Verify whether the Selected element is present
		if (uiDriver.checkElementPresent("TC01_03_Acc_Eval_Screen.eltPolicy")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(8);
		
		//3.Click on the Policy cell in Evaluation table
		String PoliycNumber=uiDriver.th.getCellData("TC01_03_Acc_Eval_Screen.tblEvalution", 0, 1);
		SleepUtils.sleep(8);
		uiDriver.webDr.findElement(By.xpath("//*[(text()='"+PoliycNumber+"')]")).click();
		SleepUtils.sleep(6);
		uiDriver.click("TC01_03_Acc_Eval_Screen.lstclosed");
		SleepUtils.sleep(6);
		uiDriver.setValue("TC01_03_Acc_Eval_Screen.lstclosed", "Closed");
		uiDriver.sendKey("enter");
		SleepUtils.sleep(6);
		
		//4. Verify whether the Selected element is present
		if (uiDriver.checkElementPresent("TC01_03_Acc_Eval_Screen.tblDelinquency")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(4);
		
		//5.Get the cell data of Delinquency reason
		String DelReason = uiDriver.th.getCellData("TC01_03_Acc_Eval_Screen.tblDelinquency", 0, 2);
		
		if(DelReason.equalsIgnoreCase("Past Due")) {
			passed("check Reason","Reason Presented As expected should pass"+DelReason,"Reason Presented passed");
		} else {
			failed("check Reason","Reason Presented As expected should pass"+DelReason,"Reason not Presented  failed");		
		}
		
	}
	/**
	*Overriding toString() method of object class to print TC01_03_Acc_Eval_Screen
	*format string
	**/
	public String toString(){
		return "View_EvaluationDriver";
	}
}
