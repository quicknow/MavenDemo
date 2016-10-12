package utils;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

//用来调测的类
public class Testselenium {
	WebDriver driver=null;
	@Test
	public void dosdf(){
		
		Browsers browser = new Browsers(BrowsersType.ie);
		driver = browser.driver;
		
		driver.get("http://www.baidu.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
}
