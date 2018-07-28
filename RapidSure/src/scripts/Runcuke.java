package scripts;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.ExtentCucumberFormatter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import scripts.CV_NB;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/features" }, glue = { "scripts" }, monochrome = true,

		plugin = { "pretty", "html:target/cucumber", "com.cucumber.listener.ExtentCucumberFormatter" })
public class Runcuke {

	@BeforeClass
	public static void setup() throws Exception {

		CV_NB configcall = new CV_NB();
		configcall.configSetup();

		ExtentCucumberFormatter.initiateExtentCucumberFormatter();

		ExtentCucumberFormatter.loadConfig(new File("src/Resources/extent-config.xml"));

		ExtentCucumberFormatter.addSystemInfo("Browser Name", "HEADLESS");
		ExtentCucumberFormatter.addSystemInfo("Browser version", "NA");
		ExtentCucumberFormatter.addSystemInfo("Selenium version", "v2.53.1");

	}

	@AfterClass

	public static void tearDown() {

	}

}
