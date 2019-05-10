import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestingAllure {
	
	WebDriver driver;
	@BeforeTest
	public void setup()
	{
		driver= new ChromeDriver();
	}
	
	
	@Test
	public void test1()
	{
		
		
		driver.get("https://stackoverflow.com");
		

	}
	
	@Test
	public void test2()
	{
		
		
		driver.get("https://google.com");
		

	}
	@Test
	public void test3()
	{
		
		
		driver.get("https://yahoo.com");
		throw new SkipException("Testing skip.");
		

	}
	
	@AfterTest
	public void fnl()
	{
		driver.quit();
	}

}
