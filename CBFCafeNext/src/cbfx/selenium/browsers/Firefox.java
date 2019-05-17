/******************************************************************************
$Id : Firefox.java 3/3/2016 7:07:42 PM
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

package cbfx.selenium.browsers;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cbf.utils.StringUtils;

public class Firefox implements Browser {

	/**
	 * Constructor to initialise browser related parameters
	 * 
	 * @param parameters
	 * 
	 */
	public Firefox(Map parameters) {
		this.params = parameters;
	}

	/**
	 * Loads Firefox driver
	 * 
	 * @return Firefox driver instance
	 */

	public WebDriver openDriver() {

		firefoxDriver = new FirefoxDriver();
		return firefoxDriver;
	}

	/**
	 * Quits Firefox driver
	 * 
	 */
	public void closeDriver() {
		firefoxDriver.quit();
	}

	/**
	 * Overriding toString() method to return Firefox format string
	 */
	public String toString() {
		return StringUtils.mapString(this);
	}

	private Map params;
	private WebDriver firefoxDriver;
}
