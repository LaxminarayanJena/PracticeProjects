import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.TextPosition;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class RapidsurePDF2 extends PDFTextStripper {
	
	static List<String> lines = new ArrayList<String>();
	//static WebDriver driver;
	public RapidsurePDF2() throws IOException {
	}

	public static void main( String[] args ) throws IOException, InterruptedException	{
		PDDocument document = null;		
		String fileName = "C://U749_62393981.pdf";
		
		
      FirefoxProfile profile = new FirefoxProfile();		
		
		profile.setPreference("browser.download.dir","C:\\");
		profile.setPreference("browser.download.folderList", 2);
		profile.setPreference("browser.download.manager.skipWinSecurityPolicyChecks", false);
		profile.setPreference("browser.download.manager.useWindow", false);
		profile.setPreference("browser.download.hide_plugins_without_extensions", true);
		profile.setPreference("pdfjs.disabled", true);
		profile.setPreference("pdfjs.enableWebGL", false);
		profile.setPreference("pdfjs.enabIedCache.initialized", true);
		profile.setPreference("pdfjs.enabIedCache.state", false);	
		profile.setPreference("pdfjs.previousHandler.alwaysAskBeforeHandling", true);
		profile.setPreference("pdfjs.renderer", false);
		profile.setPreference("pdfjs.enabledCache.initialized", true);
		profile.setPreference("pdfjs.enabledCache.state", false);		
		profile.setPreference("browser.download.useToolkitUI",false);
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/plain,application/octet-stream,application/pdf,application/x-pdf,application/vnd.pdf");
		profile.setPreference("browser.download.manager.showWhenStarting", false);
		profile.setPreference("browser.helperApps.neverAsk.openFile","text/plain,application/octet-stream,application/pdf,application/x-pdf,application/vnd.pdf");
		profile.setPreference("browser.helperApps.alwaysAsk.force", false);
		System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true");
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
		
		FirefoxOptions options = new FirefoxOptions();
		
		//To run in Headless mode (Downloads work even in headless mode)
		
		options.setHeadless(true); 
		FirefoxOptions profile1 = options.setProfile(profile);
		
		FirefoxDriver driver = new FirefoxDriver(profile1);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	
		driver.get("http://q01apprpds0298:8080/web/guest/home");
		//driver.get("http://mopas.phly.net:8080/web/guest/home");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver,120);
	
	    driver.findElement(By.xpath(".//*[@id='_58_login']")).clear();
	    driver.findElement(By.xpath(".//*[@id='_58_login']")).sendKeys("laxminarayan.jena@tmnas.com");
		driver.findElement(By.xpath(".//*[@id='_58_password']")).sendKeys("123tmnas@");
		driver.findElement(By.xpath(".//*[@id='_58_fm']/div/span/span/input")).click();
		System.out.println("1.Login to application");
			
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Policy Search']")));
			
		driver.findElement(By.xpath("//*[text()='Policy Search']")).click();	
		Thread.sleep(1500);
		WebElement element = driver.findElement(By.xpath("//*[text()='Policy Search']"));
			
		Thread.sleep(1000);
		
		WebElement dropdownPolicysearch=driver.findElement(By.xpath("//*[text()='Search By:']//following::td[1]//child::select"));	                                                           
		Select select =new Select(dropdownPolicysearch);	
		select.selectByValue("POLICY_NUM");
		Thread.sleep(1500);
		WebElement dropdownstyle=driver.findElement(By.xpath("//*[text()='Search By:']//following::td[2]//child::select"));
		Select select1 =new Select(dropdownstyle);
		select1.selectByValue("EXACT");
		
		driver.findElement(By.xpath("//*[text()='Search By:']//following::td[3]//input")).sendKeys("PHCV1780726");
		driver.findElement(By.xpath("//input[@value='Refresh']")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Policy Resources']")));
		
		System.out.println("2.Policy No displayed");
		

		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='_PHYLINSPortlet_WAR_PHYLINSPortlet_INSTANCE_o3P5_:form_CollapseNavPanel_UI2:historytree:n-0-0-0:j_id314']")).click();
			//driver.quit();
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/.//*[@id='_PHYLINSPortlet_WAR_PHYLINSPortlet_INSTANCE_o3P5_:form_PolicyContent_UI2:summ_Applicant_Info_label']")));
		
		
		
		driver.findElement(By.xpath("//*[text()='Documents']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='File Type']")));
		
		
		try
	    {
	        Files.deleteIfExists(Paths.get("C:\\Users\\ljena\\Downloads\\U749_62393981.pdf"));
	        System.out.println("3.exisiting file Deleted successful.");
	    }
	    catch(NoSuchFileException e)
	    {
	        System.out.println("No such file/directory exists");
	    }
	    catch(DirectoryNotEmptyException e)
	    {
	        System.out.println("Directory is not empty.");
	    }
	    catch(IOException e)
	    {
	        System.out.println("Invalid permissions.");
	    }
	     
		TakesScreenshot ts = (TakesScreenshot) driver;

		File source5 = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(source5, new File("C:\\Users\\ljena\\Downloads\\Download.png"));
		} catch (IOException e) {		
			e.printStackTrace();
		}
	    
		
		
		driver.findElement(By.xpath(".//*[@id='_PHYLINSPortlet_WAR_PHYLINSPortlet_INSTANCE_o3P5_:form_PolicyContent_UI2:documents_panelTabSet:0:docsTable:2:alone']")).click();
	   Thread.sleep(4000);
		driver.quit();			
	
		try {
			document = PDDocument.load( new File(fileName) );
			PDFTextStripper stripper = new RapidsurePDF2();
            stripper.setSortByPosition( true );
            stripper.setStartPage(1 );
            stripper.setEndPage(1);                    
            Writer dummy = new OutputStreamWriter(new ByteArrayOutputStream());
            stripper.writeText(document, dummy);
            
            String qoute_number=lines.get(2);
            String Account_Number=lines.get(49);                                
            String BILLING_DATE=lines.get(51);
            System.out.println("------------------------------VALIDATIONS-----------------------------------");
            if (qoute_number.contains("RS761124"))
            {
            	System.out.println("A.Premium Quotation Number: 'RS761124' text is present in page no-1 and line no 2");
            }          
            else
            {
            	System.out.println("A.Premium Quotation Number: 'RS761124' text is not present in page no1 or line no 2");
            }  
            
            
            if (Account_Number.contains("83166554"))
            {
            	System.out.println("B.Account Number: '83166554' text is present in page no-1 and line no 28");
            }
            
            else
            {
            	System.out.println("B.Account Number: '83166554' text is not present in page no1 and line no 28");
            }
            
            if (BILLING_DATE.contains("03/27/2018"))
            {
            	System.out.println("C.BILLING DATE: '03/27/2018' text is present in page no-1 and line no 29");
            }
            
            else
            {
            	System.out.println("C.BILLING DATE: '03/27/2018' text is not present in page no1 and line no 29");
            }
                    
		}
		       
		finally {
			if( document != null ) {
				document.close();
			}
		}
	}
	
	@Override
	protected void writeString(String str, List<TextPosition> textPositions) throws IOException {
		lines.add(str);	
		
	}
}