/******************************************************************************
Created by : at1
Created\Updated on : 10/3/2017 2:42:46 PM
Created using Cafenext Selenium Builder
******************************************************************************/

package ModuleDrivers;

import java.util.HashMap;
import java.util.Map;

import cbf.harness.ParameterAccess;
import cbf.model.ModuleDriver;
import cbfx.selenium.BaseWebAppDriver;

/**
 * Extends BaseWebAppDriver class and starts execution
**/
public class CompositeAppDriver extends BaseWebAppDriver {
	public CompositeAppDriver(Map params) {
		super(params);
	}

	/**
	* Initializes the modules specific to the application to be automated
	* @param resultLogger
		 TestResultLogger object with methods like passed, failed,
		 error etc available for reporting runtime results
	* @return Map of modules
	**/
	public Map<String, ModuleDriver> loadModuleDrivers(ParameterAccess paramAccess) {
		HashMap<String, ModuleDriver> moduleDrivers = new HashMap<String, ModuleDriver>();

		moduleDrivers.put("login", new loginDriver(paramAccess));
	//	moduleDrivers.put("NewAccount", new NewAccountDriver(paramAccess));
	//	moduleDrivers.put("Policy", new PolicyDriver(paramAccess));
		return moduleDrivers;
	}

	public void recover(){
		super.recover();
	}
}
