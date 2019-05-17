/******************************************************************************
$Id : AlmTestSetAccess.java 3/3/2016 7:07:29 PM
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

package cbf.testAccess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import cbf.harness.Harness;
import cbf.harness.ResourcePaths;
import cbf.model.TestCase;
import cbf.model.TestInstance;
import cbf.model.TestIteration;
import cbf.model.TestSet;
import cbf.utils.AlmAccess;
import cbf.utils.DTAccess;
import cbf.utils.LogUtils;
import cbf.utils.StringUtils;
import cbf.utils.Utils;

import com.mercury.qualitycenter.otaclient.IList;
import com.mercury.qualitycenter.otaclient.ITSTest;

import com4j.Com4jObject;

/**
 * 
 * Implements TestSet interface and makes TestInstance
 * 
 */
public class AlmTestSetAccess implements TestSet {
	private static Map<Integer, ArrayList<String>> testInstanceInfo = new HashMap<Integer, ArrayList<String>>();

	private static ArrayList<String> instanceList = new ArrayList<String>();
	ArrayList<String> almInstanceList = new ArrayList<String>();

	/**
	 * Constructor which makes a list map for instances as per the user
	 * selection
	 */

	public AlmTestSetAccess(Map params) {
		this.params = params;
		List<Map> testInstances = null;
		AlmAccess almaccess = new AlmAccess(params);

		almaccess.connect();
		logger.trace("Reading the test instances from alm...........");

		DTAccess dtAccess = new DTAccess((String) ResourcePaths.getInstance()
				.getSuiteResource("Lab", (String) params.get("testSetFile")));
		try {
			Harness.GCONFIG.put("testSet", (String) params.get("testSetSheet"));
			testInstances = dtAccess.readSheet((String) params
					.get("testSetSheet"));

		} catch (Exception e) {
			logger.handleError("Failed to read the test set sheet ",
					params.get("testSetSheet"), e);
		}

		

		for (int ix = 0; ix < testInstances.size(); ix++) {
			try {
				if (!Utils.string2Bool(((String) testInstances.get(ix).get(
						"SelectYN")))) {
					continue;
				}
				String testCaseName = (String) testInstances.get(ix).get(
						"TestCase Name");
				instanceList.add(testCaseName);
				
			

			} catch (Exception e) {
				logger.handleError("Failed to get instances", params, e);
			}
		}

		IList instanceInfo = almaccess.getTestCaseInstance(params);
		Iterator testCaseIterator = instanceInfo.iterator();
		try {
			while (testCaseIterator.hasNext()) {
				Com4jObject comOb = (Com4jObject) testCaseIterator.next();
				ITSTest testCase = comOb.queryInterface(ITSTest.class);
				String testCaseName = testCase.name().substring(3);

				almInstanceList.add(testCaseName);

			}
			getFinalInstances(instanceList, almInstanceList);

		} catch (Exception e) {
			logger.handleError("Failed to get instances", params, e);

		}

	}

	private void getFinalInstances(ArrayList<String> instanceList,
			ArrayList<String> almInstanceList) {
		int index = 0;

		for (int ix = 0; ix < instanceList.size(); ix++) {
			for (int jx = 0; jx < almInstanceList.size(); jx++) {
				if (instanceList.get(ix).equals(almInstanceList.get(jx))) {
					ArrayList<String> testList = new ArrayList<String>();
					testList.add(instanceList.get(ix).toString());
					testInstanceInfo.put(index, testList);
					index++;

				}

			}

		}

	}

	/**
	 * Returns test instance object specified at the given index in instance
	 * array
	 * 
	 * @param ix
	 *            index of TestInstance
	 * @return testInstance
	 */

	public TestInstance testInstance(final int ix) {
		final ArrayList<String> params = testInstanceInfo.get(ix);
		return new TestInstance() {

			public TestCase testCase() {
				return null;
			}

			public String description() {
				return null;
			}

			public String instanceName() {
				return params.get(0);
			}

			public TestIteration[] iterations() {
				return null;
			}

			public String folderPath() {
				return "";
			}
		};
	}

	/**
	 * Returns number of TestInstances
	 * 
	 * @return TestInsances count
	 */
	public int testInstanceCount() {
		return testInstanceInfo.size();
	}

	/**
	 * Returns AlmTestSetAccess format string
	 */
	public String toString() {
		return StringUtils.mapString(this, params);
	}

	private Map params;
	private LogUtils logger = new LogUtils(this);
}
