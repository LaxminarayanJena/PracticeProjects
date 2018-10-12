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

	@Test(dataProvider = "getData")
	public void BillingCent(Hashtable<String, String> data)
			throws InterruptedException {
		HashMap<String, String> result = null;

		click("policy");
		Thread.sleep(2000);
		driver.findElement(By.xpath(OR.getProperty("policyNoText"))).clear();

		type("policyNoText", data.get("Policy Number"));
		click("Search");

		if (isElementPresent(OR.getProperty("errorMsg")))

		{
			String errorMsg=getText("errorMsg");
			System.out.println(errorMsg + "with policy no-" + data.get("Policy Number"));
			report.addColumn(data.get("Policy Number"), "StatusResult");
			report.setCellData(data.get("Policy Number"), "StatusResult", 2, errorMsg);
			
		} else {
			String policyno = getText("policyno");
			String Effective_Date = getText("Effective_Date");
			String Expiration_Date = getText("Expiration_Date");
			String accountNo = getText("accountNo");
			String Policy_Status = getText("Policy_Status");

			// printing out values

			System.out.println(policyno);
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

			

			// Scenario-2

			String pathid = data.get("PathID");
			String lastWord = pathid.substring(pathid.lastIndexOf(",") + 1);
			String transaction = lastWord.substring(0,
					Math.min(lastWord.length(), 2));

			if (transaction.equals("EN")) {

				TestUtil.Reporting(data, "Endorsements");

			} else if (transaction.equals("Sp")) {

				TestUtil.Reporting(data, "Split Renewal");

			} else if (transaction.equals("CN")) {

				TestUtil.Reporting(data, "Cancellation");
			}

			else if (transaction.equals("RI")) {
				TestUtil.Reporting(data, "Re-Instatement");
			}

			else if (transaction.equals("RN")) {

				TestUtil.Reporting(data, "Renewal");

			}
			
			else if (transaction.equals("NB")) {

				report.addColumn(data.get("Policy Number"), "StatusResult");
				report.addColumn(data.get("Policy Number"), Policy_Status);
				report.setCellData(data.get("Policy Number"), "StatusResult", 2,"Written_Premium");
				report.setCellData(data.get("Policy Number"), "StatusResult", 3,"Tax");
				report.setCellData(data.get("Policy Number"), Policy_Status, 2,Actual_Written_Premium);
				report.setCellData(data.get("Policy Number"), Policy_Status, 3,Actual_Other_Charges);

			}
		}

	}

	@DataProvider
	public static Object[][] getData() {

		return TestUtil.getData("Results");

	}

}
