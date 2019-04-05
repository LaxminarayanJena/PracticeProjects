package Script;

/**
 * Created by ljena on 05/04/2019.
 */
import java.util.HashMap;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resources.BaseTest;
import Resources.TestUtil;


public class PathMobile_AccountCall extends BaseTest {
	
	
	@Test
	public void accountcall()
	{
		driver.get("https://pathqa.corp.tmnas.com/path/");
		
	}

	
}
