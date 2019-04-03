package Script;

/**
 * Created by ljena on 8/05/2018.
 */
import java.util.HashMap;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import UtilityFunction.TestUtil;

public class BillingCentre extends BaseTest {

	public String policyno;
	public String AccountName;

	@Test(dataProvider = "getData")
	public void BillingCent(Hashtable<String, String> data)
			throws InterruptedException {
		HashMap<String, String> result = null;
	
		
		if (currentdatasheet.contains("Surety"))
		{
			String Bondno = data.get("Bond Number") ;
			String AccountName=data.get("Account Name") ;
			 policyno = Bondno.substring(1);
			 this.policyno=policyno;
			 this.AccountName=AccountName;
		}
		
		else
		{
			 policyno = data.get("Policy Number") ;
			 this.policyno=policyno;
			 
		}

		System.out.println(policyno);

		if (policyno.equals("-") || policyno.equals("-NA-") ) {
			System.out.println("skipping the test as it is invalid policyno");

		}

		else {
			click("policy");
			Thread.sleep(3000);
			driver.findElement(By.xpath(OR.getProperty("policyNoText"))).clear();
			type("policyNoText", policyno);
			click("Search");

			if (isElementPresent(OR.getProperty("errorMsg")))

			{
				String errorMsg = getText("errorMsg");
				System.out.println(errorMsg + "with policy no-" + policyno);
				
				if (currentdatasheet.contains("Bordereau"))
						{
					
					//add Status Column
					
					int rowNum= report.getCellRowNum("Results", "Policy Number", policyno);
					report.setCellData("Results", "Status", rowNum, errorMsg);
						}
				else 
				{
					report.addColumn(data.get("Policy Number"), "StatusResult");
					report.setCellData(data.get("Policy Number"), "StatusResult", 2, errorMsg);
				}
							

			}

			else {
				String uipolicyno = getText("policyno");
				String Effective_Date = getText("Effective_Date");
				String Expiration_Date = getText("Expiration_Date");
				String accountNo = getText("accountNo");
				String Policy_Status = getText("Policy_Status");

				// printing out values

				System.out.println(uipolicyno);
				System.out.println(Policy_Status);
				System.out.println(Effective_Date);
				System.out.println(accountNo);
				System.out.println(Expiration_Date);
				click("DisplayedPolicyNo");
				Thread.sleep(2500);
				String Actual_Written_Premium = getText("Actual_Written_Premium");
				String Actual_Other_Charges = getText("Actual_Other_Charges");
				System.out.println(Actual_Written_Premium);
				System.out.println(Actual_Other_Charges);
				System.out.println("account name is -"+ AccountName);

				if (currentdatasheet.contains("AQS_CL")|| currentdatasheet.contains("AQS_SL")|| currentdatasheet.contains("Medmal")) {
					String pathid = data.get("PathID");
					String lastWord = pathid.substring(pathid.lastIndexOf(",") + 1);
					String transaction = lastWord.substring(0,Math.min(lastWord.length(), 2));
					System.out.println("transaction is" + transaction);

					if (transaction.equals("EN")) {

						TestUtil.Reporting(data, "Endorsements");

					} else if (transaction.equals("Sp")) {

						TestUtil.SplitRenewalTransaction(data, "Split Renewal");

					} else if (transaction.equals("CN")) {

						TestUtil.Reporting(data, "Cancellation");
					}

					else if (transaction.equals("RI")) {
						TestUtil.Reporting(data, "Re-Instatement");
					}

					else if (transaction.equals("RN")) {
																	

						TestUtil.RenewalTransaction(data, "Renewal");

					}

					else if (transaction.equals("NB")) {

				TestUtil.Reporting1(data, Policy_Status, Actual_Written_Premium, Actual_Other_Charges);
						

					}
				} 
				else if (currentdatasheet.contains("Rapidsure")|| currentdatasheet.contains("Umbrella"))
				{
					
					TestUtil.Reporting1(data, Policy_Status, Actual_Written_Premium, Actual_Other_Charges);
										

				}
				
				else if (currentdatasheet.contains("Surety"))
				{				
								
				TestUtil.ReportingSurety(data, AccountName,Policy_Status);
				
				}	
				
				
				
				else if (currentdatasheet.contains("Bordereau"))
				{
									
								
					int colNo= report.getColumnCount("Results");
					System.out.println("total cols are "+ colNo);
					if (colNo==4)
					{
						report.addColumn("Results","Actual Premium");
						report.addColumn("Results", "Status" );
					}
					
					
					int rowNum= report.getCellRowNum("Results", "Policy Number", policyno);
					System.out.println("current rowno is" + rowNum);				
					report.setCellData("Results", "Actual Premium", rowNum, Actual_Written_Premium);
					
				
					
				
					String AppsPremium=data.get("Apps Premium");
					int FormattedAppsPremium= new Double(AppsPremium).intValue();
					
					String s=Actual_Written_Premium;
					s=s.replaceAll("[^.a-zA-Z0-9]", "");				
					int FormattedmActtual_Written_Premium= new Double(s).intValue();
					
					System.out.println("the converted apps premium value is "+FormattedAppsPremium);
			        System.out.println("the converted written premium value is" + FormattedmActtual_Written_Premium);
					
					
					
					if(FormattedAppsPremium  == FormattedmActtual_Written_Premium)
					{
						report.setCellData("Results", "Status", rowNum, "Pass");
					}
					else
					{
						report.setCellData("Results", "Status", rowNum, "Fail");
					}
					
				
										

				}


			}

		}

	}

	@DataProvider
	public static Object[][] getData() {

		return TestUtil.getData("Results");

	}

}
