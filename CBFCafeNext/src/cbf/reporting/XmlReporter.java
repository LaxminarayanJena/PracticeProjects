package cbf.reporting;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringEscapeUtils;

import cbf.engine.TestResult;
import cbf.engine.TestResult.ResultType;
import cbf.harness.ResourcePaths;
import cbf.model.ResultReporter;
import cbf.utils.FileUtils;
import cbf.utils.LogUtils;
import cbf.utils.StringUtils;

public class XmlReporter  implements ResultReporter  {
	
	/**
	 * Constructor to initialize reporter related parameters
	 * 
	 * @param params
	 *            map containing parameters
	 */

	public XmlReporter(Map params) {

		try {

			//filePath = ResourcePaths.getInstance().getRunResourceJXML("junit-result.xml", "");
			filePath = ResourcePaths.getInstance().getRunResourceJXML("JUnitResults","junit-result.xml");
			String dummyfilePath = filePath.replace("/junit-result.xml", "");
			FileUtils.makeFolder(dummyfilePath);
			writer = new PrintWriter(filePath);
		} catch (FileNotFoundException e) {
			logger.handleError("Error in creating xml reporter", e.getCause());
		}

	}

	/**
	 * Reporter open method
	 * 
	 * @param headers
	 *            contains header info, like run name, config details etc
	 */
	public void open(Map headers) {
		
		writer.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		//writer.println("<Junit-report>");
		testStart=new Date();
		
	}
	

	/**
	 * Reporter close methods
	 */
	public void close() {
		
		
		writer.println("<testsuite tests=\""+count+"\" time=\""+calculateDuration(new Date(), testStart)+"\" failures=\""+failed+"\">");
		for (String string : str1) {
			if(!(string==null))
			writer.println(string);
			
		}
		
		writer.println("</testsuite>");
		writer.close();
	}
	
	public String calculateDuration(Date d2, Date d1) {

		if (d2 == null || d1 == null) {
			return null;
		} else {
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
				logger.handleError(
						"Error in calculating duration in HTML report", e);
				return null;
			}
		}
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

	private void report(String eventType, TestResult result, Object eventData) {
		try {
			switch (result.entityType) {
			case ITERATION:
				if(eventType.equals("START")){
					
				
				}
				if(eventType.equals("FINISH")){
					testFinish=result.finishTime;
					
				}
				
				break;
			case TESTSUITE :
				 if (eventType.equals("FINISH")){
						//writer.println("<testsuite " + "tests=  "    +count+   " " +   "time= "+ calculateDuration(result.finishTime,result.startTime) +  "  " +  "failures="+failed+ "/>");
						//writer.println(str);
						 }
				 break;
			case TESTCASE:
				 if (eventType.equals("FINISH")) {
					 count++;
					
					 str="<testcase name =\""+result.entityName+"\" time=\""+calculateDuration(result.finishTime,result.startTime)+"\"";
					 str1.add(str);
					 if(result.finalRsType.name.equals("PASSED")){
						 str="/>";
						 str1.add(str);
					 }
					 if(result.finalRsType.name.equals("FAILED")){
							failed++;
							str=">";
					        str1.add(str);
					        String actualMsg1 = "org.openqa.selenium.WebDriverException: unknown error: Element <  a class=\"btn btn-primary pull-left ng-binding ng-scope";
					        actualMsg1 = StringEscapeUtils.escapeXml(actualMsg1);
							str="<failure message="+actualMsg+">";
							str1.add(str);
							str="</failure>";
							str1.add(str);
							str="</testcase>";
							str1.add(str);
							duration=calculateDuration(result.finishTime,result.startTime);
						}
					 
					
				 }
					 
				 
				break;
			case COMPONENT:
				if (eventType.equals("DETAILS")) {
					Map detailsMap = (Map) eventData;
					if(result.finalRsType.name.equals("FAILED")){
							 actualMsg=detailsMap.get("actual").toString();
					}
				}
					
				

				break;
			
			}
		} catch (Exception e) {
			logger.handleError("Error in junit reporting", e);
		}
		

	}

	private String cal(String time) {
		while (time.length() != 2)
			time = "0" + time;
		return time;
	}

	
	public String toString() {
		return StringUtils.mapString(this, params);

	}
	
	
	private LogUtils logger = new LogUtils(this);

	private Map params;
	private PrintWriter writer;
	private String filePath;
	String tsName = null;
	private  int count=0,stepNo=0,totcount,failed=0;
	public int  testCaseNo=0;
	private Date testStart, testFinish, startTime = null;
	public List<String> str1=new ArrayList<String>();
	private String actualMsg,str,duration;
}
