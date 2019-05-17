/******************************************************************************
$Id : BaseWebAppDriver.java 3/3/2016 7:07:40 PM
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

package cbfx.selenium;

import java.util.ArrayList;
import java.util.Map;

import cbf.engine.BaseAppDriver;
import cbf.harness.ParameterAccess;

abstract public class BaseWebAppDriver extends BaseAppDriver {

	public static WebUIDriver uiDriver;

	/**
	 * initialize WebDriver
	 */
	public BaseWebAppDriver(Map params) {
		loadDrivers(params);
	}

	private void loadDrivers(Map params) {
		Object obj = params.get("UIDrivers");
		ArrayList<Map<String, Object>> list = (ArrayList<Map<String, Object>>) obj;
		for (Map<String, Object> map : list) {

			String plugin = (String) map.get("plugin");

			if (plugin.equals("Selenium")) {
				Map browserparams = (Map) map.get("value");
				try {
					uiDriver = new WebUIDriver(browserparams);
				} catch (Exception e) {

					System.out.println(e);
				}
			}

		}

	}

	/**
	 * close browsers
	 */
	public void recover() {
		if (uiDriver != null)
			uiDriver.closeBrowsers();
	}
}
