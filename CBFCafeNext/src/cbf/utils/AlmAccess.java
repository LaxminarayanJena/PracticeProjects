/******************************************************************************
$Id : AlmAccess.java 3/3/2016 7:07:31 PM
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

package cbf.utils;

import java.util.Iterator;
import java.util.Map;

import cbf.reporting.AlmReporter;

import com.mercury.qualitycenter.otaclient.ClassFactory;
import com.mercury.qualitycenter.otaclient.IAttachment;
import com.mercury.qualitycenter.otaclient.IAttachmentFactory;
import com.mercury.qualitycenter.otaclient.IBaseFactory;
import com.mercury.qualitycenter.otaclient.IBaseFieldEx;
import com.mercury.qualitycenter.otaclient.IExtendedStorage;
import com.mercury.qualitycenter.otaclient.IList;
import com.mercury.qualitycenter.otaclient.ITDConnection;
import com.mercury.qualitycenter.otaclient.ITSTest;
import com.mercury.qualitycenter.otaclient.ITestSet;
import com.mercury.qualitycenter.otaclient.ITestSetFolder;
import com.mercury.qualitycenter.otaclient.ITestSetTreeManager;

import com4j.Com4jObject;

/**
 * Makes and manages the connection with ALM
 *
 */
public class AlmAccess {

	/**
	 * Constructor to initialize Alm connection related parameters
	 * 
	 * @param params
	 *            connection params
	 * 
	 */
	public AlmAccess(Map params) {
		this.params = params;
	}

	/**
	 * Makes connection to the Alm ,sets the member variable connection.
	 * Multiple calls will reuse the member variable
	 */
	public void connect() {
		if (connection != null) {
			return;
		}

		connection = intConnect();
	}

	private ITDConnection intConnect() {
		logger.trace("Connecting");

		ITDConnection connection = ClassFactory.createTDConnection();
		connection.initConnectionEx(parameter("url"));

		try {
			connection.connectProjectEx(parameter("domain"),
					parameter("project"), parameter("login_name"),
					parameter("password"));
			logger.trace("Connected");
		} catch (Exception e) {
			logger.handleError("Error while connecting to Alm");
			return null;
		}

		return connection;
	}

	private String parameter(String key) {
		String tmp = null;
		try {
			tmp = (String) params.get(key);
		} catch (Exception e) {
			logger.handleError("Invalid parameter for ", key);
		}
		if (tmp == null || (tmp = tmp.trim()).equals("")) {
			logger.handleError("Parameter is not defined", key, tmp);
		}
		return tmp;
	}

	/**
	 * Disconnects from the established connection
	 */
	public void disconnect() {
		if (connection == null)
			return;

		try {
			connection.disconnectProject();
			logger.trace("disconnected");
		} catch (Exception e) {
			logger.handleError("Error in disconnect", e);
		} finally {
			connection = null;
		}
	}

	/**
	 * 
	 * returns Test case insatnces from ALM
	 * 
	 * @param params
	 *            params containing test instance folder path in ALM, test set
	 *            etc..
	 * @return list of test instances
	 * 
	 */
	public IList getTestCaseInstance(Map params) {
		String folderpath = (String) params.get("almTestFolderPath");
		ITestSetTreeManager treeManager = (connection.testSetTreeManager())
				.queryInterface(ITestSetTreeManager.class);
		ITestSetFolder testFolder = (treeManager.nodeByPath(folderpath))
				.queryInterface(ITestSetFolder.class);

		IList testFolderInstances = testFolder.findTestSets(
				(String) params.get("almTestSet"), false, "");
		Iterator testSetIterator = testFolderInstances.iterator();
		IList testCaseInstances = null;
		try {
			while (testSetIterator.hasNext()) {
				Com4jObject comObject = (Com4jObject) testSetIterator.next();
				testSet = comObject.queryInterface(ITestSet.class);
				IBaseFactory testCaseFactory = testSet.tsTestFactory()
						.queryInterface(IBaseFactory.class);
				testCaseInstances = testCaseFactory.newList("");
			}
		} catch (Exception e) {
			logger.handleError(
					"Exception caught while getting test case from ALM",
					params, e);
		}
		return testCaseInstances;
	}

	public void deleteAttachments(String attach_level,int count) {
		try {
			
			if(attach_level.equals("testset")){
		      attachfac = (IAttachmentFactory) testSet.attachments()
					.queryInterface(IAttachmentFactory.class);
		      if(count==0){
		       IList s = attachfac.newList("");
              Iterator iterator = s.iterator();
			    while (iterator.hasNext()) {
				Com4jObject comOb = (Com4jObject) iterator.next();
				attachfac.removeItem(comOb);
			}}}
			else{
				 attachfac = (IAttachmentFactory) AlmReporter
						.testCaseName.attachments()
						.queryInterface(IAttachmentFactory.class);
			
				IList s = attachfac.newList("");
                Iterator iterator = s.iterator();
			    while (iterator.hasNext()) {
				Com4jObject comOb = (Com4jObject) iterator.next();
				attachfac.removeItem(comOb);

			}}
		} catch (Exception e) {
			System.out.println("Error:Failed to delete report from QC : "
					+ e.getMessage());
		}

	}

	/**
	 * Uploads report in ALM
	 * 
	 * @param fileName
	 *            reportfile to be uploaded
	 * @param folderName
	 *            path of the folder containing the report
	 */

	public void attachReport(String fileName, String folderName,String attach_level) {
		try {
		    if(attach_level.equals("testset")){
			 attachfac = (IAttachmentFactory) testSet.attachments()
					.queryInterface(IAttachmentFactory.class);
			}
		    else{
		    attachfac = (IAttachmentFactory) AlmReporter.testCaseName.attachments()
					.queryInterface(IAttachmentFactory.class);
		    }
			IAttachment attach = (IAttachment) attachfac.addItem(fileName)
					.queryInterface(IAttachment.class);
			IExtendedStorage extAttach = (IExtendedStorage) attach
					.attachmentStorage().queryInterface(IExtendedStorage.class);
			String folderN = folderName.replace("\\", "\\\\");
			extAttach.clientPath(folderN);
			extAttach.save(fileName, true);
			attach.description("Uploading.........");
			attach.post();
			attach.refresh();

		} catch (Exception e) {
			System.out.println("Error:Failed to attach report to QC : "
					+ e.getMessage());
		}

	}

	/**
	 * Returns ALMAccess with format string
	 */
	public String toString() {
		return StringUtils.mapString(this, params);
	}

	private ITDConnection connection = null;
	private ITestSet testSet;
	private IAttachmentFactory attachfac;
	private Map params;
	private LogUtils logger = new LogUtils(this);
	private int count=0;
}
