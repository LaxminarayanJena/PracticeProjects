/******************************************************************************
$Id : HtmlEventReporter.java 12/23/2016 4:08:28 PM
Copyright © 2016 Capgemini Group of companies. All rights reserved
(Subject to Limited Distribution and Restricted Disclosure Only.)
THIS SOURCE FILE MAY CONTAIN INFORMATION WHICH IS THE PROPRIETARY
INFORMATION OF CAPGEMINI GROUP OF COMPANIES AND IS INTENDED FOR USE
ONLY BY THE ENTITY WHO IS ENTITLED TO AND MAY CONTAIN
INFORMATION THAT IS PRIVILEGED, CONFIDENTIAL, OR EXEMPT FROM
DISCLOSURE UNDER APPLICABLE LAW.
YOUR ACCESS TO THIS SOURCE FILE IS GOVERNED BY THE TERMS AND
CONDITIONS OF AN AGREEMENT BETWEEN YOU AND CAPGEMINI GROUP OF COMPANIES.
The USE, DISCLOSURE REPRODUCTION OR TRANSFER OF THIS PROGRAM IS
RESTRICTED AS SET FORTH THEREIN.
******************************************************************************/

package cbf.reporting;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import cbf.engine.TestResult;
import cbf.engine.TestResult.ResultType;
import cbf.harness.ResourcePaths;
import cbf.model.ResultReporter;
import cbf.model.TestCase;
import cbf.model.TestIteration;
import cbf.utils.FileUtils;
import cbf.utils.LogUtils;
import cbf.utils.StringUtils;

/**
 * 
 * Implements ResultReporter and generates HTML reports
 * 
 */
public class HtmlEventReporter implements ResultReporter {

	/**
	 * Constructor to initialize reporter related parameters
	 * 
	 * @param params
	 *            map containing parameters
	 */

	public HtmlEventReporter(Map params) {
		this.params = params;
		/*logoPath = ResourcePaths.getInstance().getRunResource(
				"Logo" + params.get("pattern") + ".png", "");
		File srcFile=new File(logoPath);*/
		summaryPath = (String) params.get("summaryPath");
		
		if (summaryPath.equals("")) {
			summaryPath = ResourcePaths.getInstance().getRunResource("", "");
		}
		if (!(FileUtils.makeFolder(summaryPath))) {
			logger.handleError("Cant create/access html reports folder; these will not be generated: "
					+ summaryPath);
		}
		
		/*File targetFile=new File(summaryPath);
		FileUtils.copyFile(srcFile,targetFile);*/
		detailsPath = (String) params.get("detailsPath");
		if (detailsPath.equals("")) {
			detailsPath = ResourcePaths.getInstance().getRunResource(
					"HtmlEvents", "");
		}
		if (!(FileUtils.makeFolder(detailsPath))) {
			logger.handleError("Cant create/access html reports folder; these will not be generated: "
					+ detailsPath);
		}
		logoPath = ResourcePaths.getInstance().getFrameworkResource(
				"Resources", "Logo.png");
		
		
	
		
	}

	/**
	 * Reporter open method
	 * 
	 * @param headers
	 *            contains header info, like run name, config details etc
	 */
	public void open(Map headers) {
	}

	/**
	 * Reporter close method
	 */
	public void close() {
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
		report("FINISH", result, result.entityDetails);
	}

	private void writeTestSet() {

		startSummaryFile("TestSet" + params.get("pattern") + ".html", "TestSet");
		String str = "";
		str = "<td>" + testCases + "</td><td>" + passed + "</td><td>" + failed + "</td><td>"
				+ testStart + "</td><td>" + testFinish + "</td><td>"
				+ calculateDuration(testFinish, testStart) + "</td><td>"
				+ eReportLink("ExecutionReport")+"</td><td>"+eReportLink("Trace")+"</td><td>"+eReportLink("Error");
		testSetArray.add(str);
		logSummary(testSetArray);
		testCaseSummaryTemplate();
		logSummary(testCasesArray);
		finishSummaryFile();
		testSetArray.clear();
		
		writeJUNITXml();
		
	}

	private void writeJUNITXml() {
		// TODO Auto-generated method stub
		
		String tempSTR = "<testsuite time="+calculateDuration(testFinish, testStart)+" failures="+failed+" tests="+testCases+">\n";
			   
		
		
	}

	private void report(String eventType, TestResult result, Object eventData) {
		String str1 = "";
		try {
			switch (result.entityType) {
			case ITERATION:
				if (eventType.equals("START")) {
					if (testStart == null)
						testStart = result.startTime;
					TestIteration iteration = (TestIteration) eventData;
					String iterName = "";
					Map iterParams = iteration.parameters();
					if (iterParams != null) {
						if (iterParams.containsKey("_rowId"))
							iterName = iterParams.get("_rowId").toString();
						if (iterName == null || iterName.equals("")) {
							iterName = "("
									+ result.parent.childCount
									+ " of "
									+ ((TestCase) result.parent.entityDetails)
											.iterationCount() + ")";
						}
					}
					tcName = result.parent.entityName;
					if (iterName != null) {
						tcName = tcName + " " + iterName;
					}

					detailsArray.add("<td colspan = 8 align = center>" + tcName
							+ "</td>");

				} else if (eventType.equals("FINISH")) {
					testCases++;
					testFinish = result.finishTime;
					String str = "";
					String status = "";
					if (result.msRsType.isPassed()){
						status = "Passed";
					    passed++;
					}
					else {
						status = "Failed";
						failed++;
					}
					str = "<td>"
							+ ((TestIteration) eventData).stepCount()
							+ "</td><td>"
							+ result.childCount
							+ "</td><td>"
							+ result.startTime
							+ "</td><td>"
							+ result.finishTime
							+ "</td><td>"
							+ calculateDuration(result.finishTime,
									result.startTime);

					str1 = "<td>" + tcName + "</td><td>" + status + "</td>"
							+ str;
					summaryArray.add(str1);
					str1 = "<td>"
							+ tcName
							+ "</td><td>"
							+ testCaseFileLink(
									entityName + params.get("pattern"), status)
							+ "</td>" + str;
					testCasesArray.add(str1);
				}
				break;
			case TESTCASE:
				if (eventType.equals("START")) {
					testCaseNo++;
					entityName = result.entityName;
					testSetPath = "../TestSet" + params.get("pattern")
							+ ".html";
					
				} else if (eventType.equals("FINISH")) {
					
					startDetailsFile(entityName + params.get("pattern")
							+ ".html", entityName);
					logDetails(summaryArray);
					componentsTemplate();
					logDetails(detailsArray);

					finishDetailsFile();
					writeTestSet();
					detailsArray.clear();
					summaryArray.clear();
				}
				break;
			case TESTSTEP:
				if (eventType.equals("START")) {
					String str = "<td colspan = 8 align = center >"
							+ result.entityName + "</td>";
					startTime = result.startTime;
					// detailsArray.add(str);
				} else if (eventType.equals("FINISH")
						&& !(result.finalRsType.equals(ResultType.DONE))) {

					String str = "<td + rightSpan + >"
							+ result.entityName.toString() + "</td><td/><td/>"
							+ "<td>";

					if (result.msRsType.isPassed()) {
						str = str + "PASSED";
					} else {
						str = str + "FAILED";
					}
					str = str + "</td><td>" + result.startTime + "</td>";
					str = str + "<td>" + result.finishTime + "</td>";
					str = str
							+ "<td>"
							+ calculateDuration(result.finishTime,
									result.startTime) + "</td>";

				}
				break;
			case COMPONENT:
				if (eventType.equals("DETAILS")) {

					Map detailsMap = (Map) eventData;

					String str = "<td + rightSpan + >"
							+ detailsMap.get("name").toString() + "</td>";

					str = str + "<td>" + result.finalRsType + "</td>";
					str = str + "<td>" + detailsMap.get("expected") + "</td>";
					str = str
							+ "<td>"
							+ screenDumpLink((String) detailsMap.get("actual"),
									result);
					str = str + "<td>" + startTime + "</td>";
					str = str + "<td>" + new Date() + "</td>";
					str = str + "<td>"
							+ calculateDuration(new Date(), startTime)
							+ "</td>";
					startDetailsFile(entityName + params.get("pattern")
							+ ".html", entityName);
					componentsTemplate();
					
					detailsArray.add(str);
					logDetails(detailsArray);
					//SleepUtils.sleep(TimeSlab.MEDIUM);
					closeDetailsFile();
					//SleepUtils.sleep(TimeSlab.LOW);
					
					
					
					
				}
			}
		} catch (Exception e) {
			logger.handleError("Error in HTML reporting", e);
		}

	}

	private String stylingTemplate() {
		String str = "body {background-color: #FFFFCC;}";
		str = str + "table {background-color: #DCDCDC; text-align: center;}";

		str += "th { background-color: #003399;text-align: center;  color: #FFFFFF; font-family:  Candara, Calibri, Segoe, 'Segoe UI', Optima, Arial, sans-serif;font-size: 15px;}";
		str += "tr { background-color: #E6E6E6; color: #1F1F7A;  font-family:  Candara, Calibri, Segoe, 'Segoe UI', Optima, Arial, sans-serif;font-size: 13px;}";
		str += "tr.d0 td { background-color: #01A9DB; }";
		str += "h1 { align=center; text-align: center; color: #003399; font-family:  Candara, Calibri, Segoe, 'Segoe UI', Optima, Arial, sans-serif;font-size: 25px; }";
		str += "h4 {text-align=right;font-family:  Candara, Calibri, Segoe, 'Segoe UI', Optima, Arial, sans-serif;font-size: 13px; }";
		return str;
	}

	private void startDetailsFile(String fileName, String title) {
		openDetailsFile(detailsPath + "/" + fileName);

		writeDetails("<html><head><style>");
		writeDetails(stylingTemplate());
		writeDetails("<title>" + title + "</title>");
		writeDetails("</style></head><body>");
		writeDetails("<img src=" + logoPath + " align=right>");
		writeDetails("<h1>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<u>TEST CASE REPORT</u></h1>");
		testCaseDetailsTemplate();

	}

	private void startSummaryFile(String fileName, String title) {
		openSummaryFile(summaryPath + "/" + fileName);

		writeSummary("<html><head><style>");

		writeSummary(stylingTemplate());
		writeSummary("<title>" + title + "</title>");

		writeSummary("</style>");
		writeSummary("<script>");
		writeSummary("function init(){");
		writeSummary("var canvas = document.getElementById('can'); "
				+ "var ctx = canvas.getContext('2d'); var lastend = 0;"
				+ "var data =[ "
				+ failed
				+ ","
				+ passed
				+ "]; ; var myTotal = 0; var labels= ['Fail','Pass']; "
				+ "var myColor = ['red', 'green'];"
				+ " for (var e = 0; e < data.length; e++) {  myTotal += data[e];} "
				+ "for (var i = 0; i < data.length; i++) { ctx.save();  "
				+ " ctx.fillStyle = myColor[i];   ctx.beginPath();  "
				+ " ctx.moveTo(canvas.width / 2, canvas.height / 2);  "
				+ " ctx.arc(canvas.width / 2, canvas.height / 2, canvas.height / 2, lastend, lastend + (Math.PI * 2 * (data[i] / myTotal)), false); "
				+ "  ctx.lineTo(canvas.width / 2, canvas.height / 2); "
				+ " ctx.fill();if(data[i]>0){"
				+ "var radius = (canvas.height / 2)/1.5;"
				+ " var endAngle = lastend + (Math.PI*(data[i]/myTotal ));"
				+ " var setX = (canvas.width / 2)+ Math.cos(endAngle) * radius;  "
				+ "var setY =(canvas.height / 2 )+ Math.sin(endAngle) * radius;ctx.fillStyle = '#ffffff'; "
				+ " ctx.font = '10px Calibri'; "
				+ "ctx.fillText(labels[i],setX,setY);}"
				+ "lastend += Math.PI * 2 * (data[i] / myTotal);  ctx.restore();");

		writeSummary("} }");
		writeSummary("</script>");

		
		writeSummary("</head><body onLoad=init()>");
		writeSummary("<img src=" + logoPath + " align=right>");
		writeSummary("<h1>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp"
		+ "&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<u>SPIRE Group1 GWBC Automation Results</u></h1>");
		testSetTemplate();	

	}

	private void finishDetailsFile() {
		writeDetails("</table><h4 align=right><a href='" + testSetPath
				+ "'>TestSetFile</a></h4></body></html>");

		closeDetailsFile();
	}

	private void finishSummaryFile() {
		writeSummary("</table></body></html>");

		closeSummaryFile();
	}

	private void testSetTemplate() {
		writeSummary("<table id='piechart' style='border-collapse: collapse;'><tr><td width='81%' bgcolor='#FFFFCC'cellpadding='10' align='right'><p>"
				+ "<b><font color='green'>Passed:</font></b>"+passed+"</p>"
				+ "<p><b><font color='red'>&nbspFailed:</font></b>"+failed+"</p>"
				+ "<p><b><font color='#004994'>&nbsp&nbsp&nbspTotal:</font></b>"+testCases+"</p>"
				+ "</td><td width='35%'  align='left' cellpadding='10' bgcolor='#FFFFCC'><canvas id='can' width='150' height='150'>"
				+ "</canvas></td></tr></table>");
		writeSummary("&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<table align=center  width=100%>");
		writeSummary("<th colspan=10>TEST SET SUMMARY</th>");
		writeSummary("<tr class=d0><td><b>Tests Executed</b></td><td><b>Tests Passed</b></td><td><b>Tests Failed</b></td><td><b>Start time</b></td><td><b>End time</b></td><td><b>Duration</b></td><td><b>Execution Report</b></td><td><b>Trace</b></td><td><b>Error</b></td></tr><br>");
	}

	private void testCaseDetailsTemplate() {
		writeDetails("&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<table align=center   width=100%>");
		writeDetails("<th colspan=7>TEST CASE SUMMARY</th>");
		writeDetails("<tr class=d0><td><b>TestCase Name</b></td><td><b>Status</b></td><td><b>No. of components</b></td><td><b>Components Run</b></td><td><b>Start time</b></td><td><b>End time</b></td><td><b>Duration</b></td></tr>");
	}

	private void testCaseSummaryTemplate() {
		writeSummary("<table align=center  width=100%>");
		writeSummary("<br><br><br>");
		writeSummary("<th colspan=7>TEST CASE SUMMARY</th>");
		writeSummary("<tr class=d0><td><b>TestCase Name</b></td><td><b>Status</b></td><td><b>No. of components</b></td><td><b>Components Run</b></td><td><b>Start time</b></td><td><b>End time</b></td><td><b>Duration</b></td></tr>");
	}

	private void componentsTemplate() {
		writeDetails("<table align=center  width=100%>");
		writeDetails("<br><br><br>");
		writeDetails("<th colspan=10>TEST CASE DETAILS</th>");
		writeDetails("<tr class=d0>"
				+ "<td><b>Step</b></td><td><b>Result</b></td><td><b>Expected Result</b></td><td><b>Actual Result</b></td><td><b>Start Time</b></td><td><b>End Time</b></td><td><b>Duration</b></td></tr>");
	}

	private void logDetails(ArrayList<String> strArray2) {
		for (String str : strArray2)

			writeDetails("<tr>" + str + "</tr>");
	}

	private void logSummary(ArrayList<String> strArray2) {
		for (String str : strArray2)

			writeSummary("<tr>" + str + "</tr>");
	}

	private String screenDumpLink(String name, TestResult eventData) {
		String sDumpFile;
		try {
			/*sDumpFile = "../ScreenShots/" + (String) ((Map) ((Map) eventData.miscInfo)
					.get("screenDump")).get("fileName");
			sDumpFile = sDumpFile.replaceAll(ResourcePaths.getInstance()
					.getRunResource("", ""), "..");*/
			sDumpFile = "../ScreenShots/"+entityName+"/"+ (String) ((Map) ((Map) eventData.miscInfo)
					.get("screenDump")).get("fileName");
			
			
		} catch (Exception e) {

			return name;
		}

		if (sDumpFile == null) {
			// return null;
			return name;
		}

		return "<a href='" + sDumpFile + "'>" + name + "</a>";
	}

	private String eReportLink(String name) {
		String filepath;
		try {
			if(name.equalsIgnoreCase("ExecutionReport"))
			{
			filepath = "./" + name + params.get("pattern") + ".xlsx";
			}
			else{
				filepath = "./" + name + params.get("pattern") + ".html";
			}
			

		} catch (Exception e) {
			logger.handleError(
					"Error in accesing excel report link in HTML report", name,
					e);
			return "";
		}

		if (filepath == null) {
			return "";
		}

		return "<a href='" + filepath + "'>" + name + "</a>";
	}
	

	private String testCaseFileLink(String name, String status) {
		String filepath;
		try {
			filepath = "./HtmlEvents/" + name + ".html";

		} catch (Exception e) {
			logger.handleError(
					"Error in accesing test Case link in HTML report", name, e);
			return "";
		}

		if (filepath == null) {
			return "";
		}

		return "<a href='" + filepath + "'>" + status + "</a>";
	}

	private String calculateDuration(Date d2, Date d1) {
		
		if(d2==null||d1==null)
		{
			return null;
		}
		else{
		long diff = d2.getTime() - d1.getTime();

		long diffSeconds = diff / 1000 % 60;
		long diffMinutes = diff / (60 * 1000) % 60;
		long diffHours = diff / (60 * 60 * 1000) % 24;
		try {
			String diffTime = cal(String.valueOf(diffHours)) + ":"
					+ cal(String.valueOf(diffMinutes)) + ":"
					+ cal(String.valueOf(diffSeconds));
			return diffTime;
		} catch (Exception e) {
			logger.handleError("Error in calculating duration in HTML report",
					e);
			return null;
		}
		}
	}

	private String cal(String time) {
		while (time.length() != 2)
			time = "0" + time;
		return time;
	}

	private void openDetailsFile(String filePath) {
		try {
			fileWriter = new FileWriter(filePath);
			bufWriter1 = new BufferedWriter(fileWriter);
		} catch (IOException e) {
			logger.handleError("Exception caught while trying to open a file ",
					filePath, e);
		}
	}

	private void openSummaryFile(String filePath) {
		try {
			fileWriter = new FileWriter(filePath);
			bufWriter2 = new BufferedWriter(fileWriter);
		} catch (IOException e) {
			logger.handleError(
					"Exception caught : When trying to open a file ", filePath,
					e);
		}
	}

	private void closeDetailsFile() {
		try {
			bufWriter1.close();
		} catch (IOException e) {
			logger.handleError("Exception caught while closing details file ",
					e);
		} finally {
			try {
				fileWriter.close();
			} catch (IOException e) {
				logger.handleError(
						"Exception caught while closing details file ", e);
			} finally {
				fileWriter = bufWriter1 = null;
			}
		}
	}

	private void closeSummaryFile() {
		try {
			bufWriter2.close();
		} catch (IOException e) {
			logger.handleError("Exception caught while closing summary file ",
					e);
		} finally {
			try {
				fileWriter.close();
			} catch (IOException e) {
				logger.handleError(
						"Exception caught while closing summary file ", e);
			} finally {
				fileWriter = bufWriter2 = null;
			}
		}
	}

	private void writeDetails(String lines) {
		try {
			bufWriter1.write(lines);
		} catch (IOException e) {
			logger.handleError(
					"Exception caught while writing details in HTML : ", e);
		}
	}

	private void writeSummary(String lines) {
		try {
			bufWriter2.write(lines);
		} catch (IOException e) {
			logger.handleError(
					"Exception caught while writing details in HTML : ", e);
		}
	}

	public static boolean makeFolder(String sFolderPath)
	{
		if(!new File(sFolderPath).isDirectory())
			return new File(sFolderPath).mkdirs();
		else
			return true;
	}
	/**
	 * Returns HtmlEventReporter along with html report folder path format
	 * string
	 */
	public String toString() {
		return StringUtils.mapString(this, params);

	}

	private Writer bufWriter1, bufWriter2, fileWriter;
	private LogUtils logger = new LogUtils(this);
	private String summaryPath, detailsPath, entityName, logoPath,ImgPath;
	private String tcName = "", testSetPath;
	private int failed = 0, testCases = 0,passed=0,testCaseNo=0;
	private Date testStart, testFinish, startTime = null;
	private ArrayList<String> detailsArray = new ArrayList<String>();
	private ArrayList<String> summaryArray = new ArrayList<String>();
	private ArrayList<String> testSetArray = new ArrayList<String>();
	private ArrayList<String> testCasesArray = new ArrayList<String>();
	private Map params;
}
