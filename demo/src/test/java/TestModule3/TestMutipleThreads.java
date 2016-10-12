package TestModule3;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import utils.Browsers;
import utils.BrowsersType;


public class TestMutipleThreads {

  @Test
  public void testBaidu() throws Exception {
	System.out.println("Thread1"+" "+System.currentTimeMillis());  
	WebDriver driver;
	String baseUrl;  
	Browsers browser = new Browsers(BrowsersType.firefox);
	driver = browser.driver;
	baseUrl = "https://www.baidu.com/";  
    driver.get(baseUrl + "/");
    //driver.findElement(By.id("kw")).click();
    driver.findElement(By.id("kw")).clear();
    driver.findElement(By.id("kw")).sendKeys("maven");
    driver.findElement(By.id("su")).click();
    driver.quit();
  }

  
}