/******************************************************************************
$Id : AlmReporter.java 3/3/2016 7:07:25 PM
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

package cbf.reporting;

import java.io.File;
import java.util.Iterator;
import java.util.Map;

import cbf.engine.TestResult;
import cbf.engine.TestResult.EntityType;
import cbf.engine.TestResult.ResultType;
import cbf.harness.Harness;
import cbf.model.ResultReporter;
import cbf.utils.AlmAccess;
import cbf.utils.LogUtils;
import cbf.utils.StringUtils;

import com.mercury.qualitycenter.otaclient.IBaseFactory;
import com.mercury.qualitycenter.otaclient.IList;
import com.mercury.qualitycenter.otaclient.IRun;
import com.mercury.qualitycenter.otaclient.IRunFactory;
import com.mercury.qualitycenter.otaclient.ITSTest;
import com4j.Com4jObject;

/**
 * 
 * Implements ResultReporter and updates the status in ALM
 * 
 */

public class AlmReporter implements ResultReporter {

	/**
	 * Constructor to initialize parameters to get test set folder path and the
	 * test set name
	 * 
	 * @param params
	 *            map containing parameters
	 */

	public AlmReporter(Map params) {
		this.params = params;
		testsetfolderpath = (String) params.get("almTestFolderPath");
		testSet = (String) params.get("almTestSet");
		attach_level=(String) params.get("attach_level");
	}

	/**
	 * Updates the status back in the Alm
	 * 
	 */
	public void updateStatus(String tsFolderPath, String tsName,
			String instanceName, String exeStatus,int count) {

		AlmAccess almaccess = new AlmAccess(params);
		almaccess.connect();
		logger.trace("Updating result in Alm.......");

		IList instanceInfo = almaccess.getTestCaseInstance(params);
		Iterator testCaseIterator = instanceInfo.iterator();

		while (testCaseIterator.hasNext()) {
			Com4jObject comOb = (Com4jObject) testCaseIterator.next();
			testCaseName = comOb.queryInterface(ITSTest.class);
			String testCase = testCaseName.name();
			testCase = testCase.substring(testCase.indexOf("]") + 1);
			try {
				if (testCase.equalsIgnoreCase(instanceName)) {
					Com4jObject runfactory = testCaseName.runFactory()
							.queryInterface(IRunFactory.class);
					IRun run = (IRun) ((IBaseFactory) runfactory).addItem(
							testCase).queryInterface(IRun.class);
					run.status(exeStatus);
					String uploadFilePath = (String) Harness.GCONFIG
							.get("RunHome")
							+ "/HtmlEvents/"
							+ testCase
							+ ".html";

					String fileName = new File(uploadFilePath).getName();
					String folderName = new File(uploadFilePath).getParent()
							+ "";

					String screenShots = (String) (Harness.GCONFIG
							.get("RunHome") + "./" + "ScreenShots/"+instanceName);
					almaccess.deleteAttachments(attach_level,count);
					File folder = new File(screenShots);
					File[] listOfFiles = folder.listFiles();
					for (File file : listOfFiles) {
						if (file.isFile()) {
							String imgName = file.getName();
							String imgfolderName = file.getParent();

							almaccess.attachReport(imgName, imgfolderName,attach_level);
						}
					}
					almaccess.attachReport(fileName, folderName,attach_level);
					run.post();
					run.refresh();
					logger.trace("Result Updated");
				}
			} catch (Exception e) {

				logger.handleError("Failed to update result for", tsFolderPath,
						tsName, instanceName, e);

			}
		}
	}

	/**
	 * Reporter open method
	 * 
	 * @param headers
	 *            contains header info, like run name, config details etc
	 */

	public void open(Map headers) {
		logger.trace("Report: Open");
	}

	/**
	 * Reporter close method
	 */

	public void close() {
		logger.trace("Report: Close");

		AlmAccess almaccess = new AlmAccess(params);

		almaccess.disconnect();
	}

	/**
	 * Reports entity execution start details
	 * 
	 * @param result
	 *            entity object
	 */

	public void start(TestResult result) {
		report("START", result, result.entityDetails);
	}

	/**
	 * Logs execution details in report
	 * 
	 * @param result
	 *            entity details
	 * @param rsType
	 *            result type of the current executed entity
	 * @param details
	 *            execution details of the current executed entity
	 */

	public void log(TestResult result, ResultType rsType, Map details) {
		report("DETAILS", result, details);
	}

	/**
	 * Reports execution details along with result counts
	 * 
	 * @param result
	 *            execution details
	 * @param rsType
	 *            result type of the current executed entity
	 * @param details
	 *            execution details of the current executed entity
	 */

	public void finish(TestResult result, ResultType rsType, Object details) {
		report("FINISH", result, details);
	}

	private void report(String eventType, TestResult result, Object eventData) {
		if (result.entityType.equals(EntityType.ITERATION)) {
			if (eventType.equals("START")) {
				testInstance = result.parent.entityName;
			}

			try {
				switch (result.entityType) {
				case ITERATION:
					if (eventType.equals("FINISH")) {
						if (result.msRsType.equals(ResultType.PASSED)) {
							testResult = "Passed";
							notes = "Successfully Executed";
							

						} else if (result.msRsType.equals(ResultType.FAILED)
								|| result.msRsType.equals(ResultType.ERROR)) {
							testResult = "Failed";
							notes = "Execution failed";

						}
					}
					break;
				
				}
			} catch (Exception e) {

				logger.handleError("Error while updating result for ",
						testInstance, e);
			}
		}
		if (result.entityType.equals(EntityType.TESTCASE)) {
			switch (result.entityType) {
			case TESTCASE:
				if (eventType.equals("FINISH")) {
					
					if (result.msRsType.equals(ResultType.PASSED)) {
						testResult = "Passed";
						notes = "Successfully Executed";

						updateStatus(testsetfolderpath, testSet, testInstance,
								testResult,count);
						count++;

					} else if (result.msRsType.equals(ResultType.FAILED)
							|| result.msRsType.equals(ResultType.ERROR)) {
						testResult = "Failed";
						notes = "Execution failed";
						updateStatus(testsetfolderpath, testSet, testInstance,
								testResult,count);
								count++;

					}
				}
				break;
			}
		}
	}

	/**
	 * Returns AlmReporter format string
	 */
	public String toString() {
		return StringUtils.mapString(this, params);
	}

	private String testsetfolderpath, testSet, testInstance;
	private String attach_level;
	private Map params;
	String notes = null;
	String testResult = null;
	private LogUtils logger = new LogUtils(this);
	public static ITSTest testCaseName;
	int count=0;
}
