/******************************************************************************
$Id : AppLoader.java 3/3/2016 7:07:22 PM
Copyright 2016-2017 IGATE GROUP OF COMPANIES. All rights reserved
(Subject to Limited Distribution and Restricted Disclosure Only.)
THIS SOURCE FILE MAY CONTAIN INFORMATION WHICH IS THE PROPRIETARY
INFORMATION OF IGATE GROUP OF COMPANIES AND IS INTENDED FOR USE
ONLY BY THE ENTITY WHO IS ENTITLED TO AND MAY CONTAIN
INFORMATION THAT IS PRIVILEGED, CONFIDENTIAL, OR EXEMPT FROM
DISCLOSURE UNDER APPLICABLE LAW.
YOUR ACCESS TO THIS SOURCE FILE IS GOVERNED BY THE TERMS AND
CONDITIONS OF AN AGREEMENT BETWEEN YOU AND IGATE GROUP OF COMPANIES.
The USE, DISCLOSURE REPRODUCTION OR TRANSFER OF THIS PROGRAM IS
RESTRICTED AS SET FORTH THEREIN.
******************************************************************************/

package cbf.harness;

import java.util.HashMap;
import java.util.Map;

import cbf.model.AppDriver;
import cbf.plugin.PluginManager;
import cbf.utils.Configuration;
import cbf.utils.LogUtils;

/**
 * 
 * Loads the application driver after bootstrap
 * 
 */
public class AppLoader {

	LogUtils logger = new LogUtils(this);

	/**
	 * Loads application driver and returns it's instance
	 * 
	 * @return object of AppDriver
	 */
	public AppDriver loadApp(Configuration CONFIG) {
		AppDriver driver = null;

		logger.trace("LoadApp()");
		String driverPlugin = null;
		try {
			Map params = new HashMap<String, Object>();

			params.put("UIDrivers", CONFIG.get("UIDrivers"));
			/*
			 * params.put("Browser", CONFIG.get("Browser")); params
			 * .put("BrowserDriverFolder", CONFIG .get("BrowserDriverFolder"));
			 */

			Map<String, Object> map = (Map<String, Object>) CONFIG
					.get("AppDriver");

			driverPlugin = (String) map.get("plugin");
			logger.debug("AppDriverBootStrap: " + driverPlugin);
			String className = (String) map.get("classname");
			Map param1 = (Map) map.get("parameters");
			if (param1 != null)
				params.putAll(param1);
			driver = (AppDriver) PluginManager.initializePlugin(className,
					params);

		} catch (Exception e) {

			logger.handleError("Error in loading AppDriver:", driverPlugin, e);
		}

		return driver;
	}

}
