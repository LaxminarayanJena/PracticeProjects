package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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

import Resources.ExcelReader;






/**
 * Created by ljena on 05/04/2019.
 */
public class BaseTest {
	
	public static WebDriver driver;
	public static Properties OR = new Properties();
	public static Properties Config = new Properties();
	public static FileInputStream fis;
	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\java\\DataDriver\\Driver_PathMobile.XLSX");
	public static ExcelReader report = new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\java\\Reports\\Report.XLSX");
	
	
	
	
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static WebDriverWait wait;
	
	public static String currentdatasheet=null;
	
	@BeforeSuite
	public void setUp(){
				
		if(driver==null){
			
			//Config properties file
			try {
				fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\Resources\\Config.properties");				
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				Config.load(fis);											
				log.debug("Config file loaded");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			//OR Properties File
			try {
				fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\ObjectRepository\\OR.properties");
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}
			try {
				OR.load(fis);
				log.debug("OR file loaded");
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
					
			
			
			if(Config.getProperty("browser").equals("firefox")){
								
				driver = new FirefoxDriver();
				
			}else if(Config.getProperty("browser").equals("chrome")){
				
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\java\\Resources\\Executables\\chromedriver.exe");				
				driver = new ChromeDriver();
				
			}else if(Config.getProperty("browser").equals("ie")){
				
				System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\src\\test\\java\\Resources\\Executables\\IEDriverServer.exe");
				//driver = new InternetExplorerDriver();
				
				DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
				capabilities.setCapability("requireWindowFocus", true);  
				capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, false);
				capabilities.setCapability("ie.ensureCleanSession", true);
				capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				//capabilities.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, true);
				driver = new InternetExplorerDriver(capabilities);
								
			}
			
         else if(Config.getProperty("browser").equals("headless")){
				
        	 File file = new File(System.getProperty("user.dir")+"\\src\\test\\java\\Resources\\Executables\\phantomjs.exe");				
             System.setProperty("phantomjs.binary.path", file.getAbsolutePath());		
            DesiredCapabilities dcap = new DesiredCapabilities();
     		String[] phantomArgs = new  String[] {
     		    "--webdriver-loglevel=NONE"
     		};
     		Logger.getLogger(PhantomJSDriverService.class.getName()).setLevel(Level.OFF);
     		
     		dcap.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, phantomArgs);
     		 driver = new PhantomJSDriver(dcap);
			}
			
			
			String URL = "https://" + Config.getProperty("username") + ":" + Config.getProperty("password") + "@" + Config.getProperty("testsiteurl");
			driver.get(URL);
						
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
	public static void type(String locator, String value)
	{
		driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);
		
	}	
	
public static void click(String locator)
	
	{
		driver.findElement(By.xpath(OR.getProperty(locator))).click();
		
	}

public static String getText(String locator)

{
	return driver.findElement(By.xpath(OR.getProperty(locator))).getText();
	
}

	@AfterSuite
	public void tearDown(){
		
		if(driver!=null)
		{
				
		driver.quit();
		}
		
	}
}
