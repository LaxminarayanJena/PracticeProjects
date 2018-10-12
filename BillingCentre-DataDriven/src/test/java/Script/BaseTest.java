package Script;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;





import UtilityFunction.ExcelReader;
/**
 * Created by ljena on 8/05/2018.
 */
public class BaseTest {
	
	public static WebDriver driver;
	public static Properties OR = new Properties();
	public static Properties Config = new Properties();
	public static FileInputStream fis;
	//public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\java\\Reports\\Report.XLSX");
	//public static ExcelReader report = new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\java\\Reports\\Report.XLSX");
	
	public static ExcelReader excel = null;
	public static ExcelReader report = null;
	
	
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static WebDriverWait wait;
	
	
	
	@BeforeSuite
	public void setUp(){
				
		if(driver==null){
			
			//Config properties file
			try {
				fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\Resources\\Config.properties");
				
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				Config.load(fis);
				String a=Config.getProperty("ResultDriver");
				excel=new ExcelReader(a);
				report=new ExcelReader(a);
				
				
				log.debug("Config file loaded");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//OR Properties File
			try {
				fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\ObjectRepository\\OR.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				OR.load(fis);
				log.debug("OR file loaded");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			if(Config.getProperty("browser").equals("firefox")){
								
				driver = new FirefoxDriver();
				
			}else if(Config.getProperty("browser").equals("chrome")){
				
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\java\\resources\\executables\\chromedriver.exe");				
				driver = new ChromeDriver();
				
			}else if(Config.getProperty("browser").equals("ie")){
				
				System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\src\\test\\java\\resources\\executables\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
			
         else if(Config.getProperty("browser").equals("headless")){
				
        	 File file = new File(System.getProperty("user.dir")+"\\src\\test\\java\\resources\\executables\\phantomjs.exe");				
             System.setProperty("phantomjs.binary.path", file.getAbsolutePath());		
            DesiredCapabilities dcap = new DesiredCapabilities();
     		String[] phantomArgs = new  String[] {
     		    "--webdriver-loglevel=NONE"
     		};
     		Logger.getLogger(PhantomJSDriverService.class.getName()).setLevel(Level.OFF);
     		
     		dcap.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, phantomArgs);
     		 driver = new PhantomJSDriver(dcap);
			}
			
			driver.navigate().to(Config.getProperty("testsiteurl"));
			log.debug("Navigated to : "+Config.getProperty("testsiteurl"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
			wait = new WebDriverWait(driver, 300);											
		}						
	}
		
	public static boolean isElementPresent(String path){
		
		try{
			
			driver.findElement(By.xpath(path));
			return true;
			
		}catch(Throwable t){
			
			return false;
		}		
	}
	public void type(String locator, String value)
	{
		driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);
		
	}	
	
public void click(String locator)
	
	{
		driver.findElement(By.xpath(OR.getProperty(locator))).click();
		
	}

public static String getText(String locator)

{
	return driver.findElement(By.xpath(OR.getProperty(locator))).getText();
	
}
	@AfterSuite
	public void tearDown(){
				
		driver.quit();
		
	}
}
