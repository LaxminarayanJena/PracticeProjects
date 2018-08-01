package scripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import Resources.ExcelReader;

public class Utility {
	static DesiredCapabilities dcap;

	public static void nologs() {
		DesiredCapabilities dcap = new DesiredCapabilities();
		String[] phantomArgs = new String[] { "--webdriver-loglevel=NONE" };
		dcap.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, phantomArgs);
		Utility.dcap = dcap;

	}

	// private static WebDriver driver=new ChromeDriver();
	// private static WebDriver driver=new PhantomJSDriver(dcap);
	private static WebDriver driver = new PhantomJSDriver();
	// private static WebDriver driver=new FirefoxDriver();
	// private static WebDriver driver=new InternetExplorerDriver();
	// private static WebDriver driver = new HtmlUnitDriver(true);

	ExcelReader excel = new ExcelReader(System.getProperty("user.dir") + "\\src\\Reports\\Report.xlsx");
	String sheetname = "result";

	ExcelReader excel2 = new ExcelReader(System.getProperty("user.dir") + "\\src\\DataDriver\\DataDriver_CV.xlsx");
	String sheetname2 = "result";

	public static WebDriver getDriver() {
		return driver;
	}

	public void captureScreenshot() throws IOException {

		File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scr, new File(System.getProperty("user.dir") + "\\src\\screenshot\\error.jpg"));

	}

	public static Properties prop() throws IOException {
		// System.out.println("property method ---- "+dcap);
		Properties config = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\ObjectRepository\\Conf.Properties");
		config.load(fis);
		return config;

	}

}
