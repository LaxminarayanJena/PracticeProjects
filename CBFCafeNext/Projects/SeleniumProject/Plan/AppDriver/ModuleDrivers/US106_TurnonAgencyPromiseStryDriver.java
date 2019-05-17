/******************************************************************************
Created by : Admin
Created\Updated on : 12/12/2017 9:59:35 AM
Module part of 'sample_1'
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
public class US106_TurnonAgencyPromiseStryDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public US106_TurnonAgencyPromiseStryDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void US106_TurnonAgencyPromiseStry(DataRow input, DataRow output) {
		//1. Click on ProducerTab WebElement
		uiDriver.click("US106_TurnonAgencyPromiseStry.eltProducerTab");
		
		//2. Type $data in ProducerCode field
		uiDriver.setValue("US106_TurnonAgencyPromiseStry.txtProducerCode", input.get("Type@ProducerCode#1"));
		
		//3. Click on Search button
		uiDriver.click("US106_TurnonAgencyPromiseStry.btnSearch");
		
		//4. Click on ProducerName Link
		uiDriver.click("US106_TurnonAgencyPromiseStry.lnkProducerName");
		
		//5. Click on Actions button
		uiDriver.click("US106_TurnonAgencyPromiseStry.btnActions");
		
		//6. Click on NewAgencyBillPromise WebElement
		uiDriver.click("US106_TurnonAgencyPromiseStry.eltNewAgencyBillPromise");
		
		//7. Verify Title
		uiDriver.Verify("US106_TurnonAgencyPromiseStry.pgeTitle");
		
		//8. Click on ProducerTab WebElement
		uiDriver.click("US106_TurnonAgencyPromiseStry.eltProducerTab");
		
		//9. Type $data in ProducerCode field
		uiDriver.setValue("US106_TurnonAgencyPromiseStry.txtProducerCode", input.get("Type@ProducerCode#2"));
		
		//10. Click on Search button
		uiDriver.click("US106_TurnonAgencyPromiseStry.btnSearch");
		
		//11. Click on ProducerName Link
		uiDriver.click("US106_TurnonAgencyPromiseStry.lnkProducerName");
		
		//12. Click on Agency_Bill_Promises_tab WebElement
		uiDriver.click("US106_TurnonAgencyPromiseStry.eltAgency_Bill_Promises_tab");
		
		//13. Click on Executed_Promises_hyperlink Link
		uiDriver.click("US106_TurnonAgencyPromiseStry.lnkExecuted_Promises_hyperlink");
		
		//14. Verify Executed_Promises
		uiDriver.Verify("US106_TurnonAgencyPromiseStry.pgeExecuted_Promises");
		
		//15. Click on Saved_Promises_hyperlink Link
		uiDriver.click("US106_TurnonAgencyPromiseStry.lnkSaved_Promises_hyperlink");
		
		//16. Verify Saved_Promises
		uiDriver.Verify("US106_TurnonAgencyPromiseStry.pgeSaved_Promises");
		
		//17. Click on Agency_Bill_Exceptions Link
		uiDriver.click("US106_TurnonAgencyPromiseStry.lnkAgency_Bill_Exceptions");
		
		//18. Verify Payment_Mismatch_Exceptions_tab
		uiDriver.Verify("US106_TurnonAgencyPromiseStry.eltPayment_Mismatch_Exceptions_tab");
		
		//19. Verify Late_Promises_tab
		uiDriver.Verify("US106_TurnonAgencyPromiseStry.eltLate_Promises_tab");
		
		//20. Click on Agency_Bill_Suspense_Items Link
		uiDriver.click("US106_TurnonAgencyPromiseStry.lnkAgency_Bill_Suspense_Items");
		
		//21. Verify Promise_Items_tab
		uiDriver.Verify("US106_TurnonAgencyPromiseStry.eltPromise_Items_tab");
		
		//22. Click on Desktop_tab WebElement
		uiDriver.click("US106_TurnonAgencyPromiseStry.eltDesktop_tab");
		
		//23. Click on My_Agency_Items_tab WebElement
		uiDriver.click("US106_TurnonAgencyPromiseStry.eltMy_Agency_Items_tab");
		
		//24. Verify Promise_Exceptions_tab
		uiDriver.Verify("US106_TurnonAgencyPromiseStry.eltPromise_Exceptions_tab");
		
		//25. Verify Late_Promises_tab
		uiDriver.Verify("US106_TurnonAgencyPromiseStry.eltLate_Promises_tab");
		
		//26. Verify Suspense_Promises_tab
		uiDriver.Verify("US106_TurnonAgencyPromiseStry.eltSuspense_Promises_tab");
		
	}
	

	/**
	*Overriding toString() method of object class to print US106_TurnonAgencyPromiseStry
	*format string
	**/
	public String toString(){
		return "US106_TurnonAgencyPromiseStryDriver";
	}
}
