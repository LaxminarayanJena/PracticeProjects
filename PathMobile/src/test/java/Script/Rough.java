package Script;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Rough {

	public static void main(String[] args) {
		System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\src\\test\\java\\resources\\executables\\IEDriverServer.exe");
		
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		capabilities.setCapability("requireWindowFocus", true);  
		capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, false);
		capabilities.setCapability("ie.ensureCleanSession", true);
		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		//capabilities.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, true);
		WebDriver driver = new InternetExplorerDriver(capabilities);
		
		driver.get("https://qapas.phly.net/web/philadelphia-insurance/underwriting");
		

	}

}
