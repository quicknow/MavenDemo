package TestModule2;

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

public class TestSogou {
  private WebDriver driver;
  private String baseUrl;

  @BeforeClass
  public void setUp() throws Exception {
	Browsers browser= new Browsers(BrowsersType.chrome);  
    driver = browser.driver;
    baseUrl = "https://www.sogou.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testBaidu() throws Exception {
    driver.get(baseUrl + "/");    
    driver.findElement(By.id("query")).clear();
    driver.findElement(By.id("query")).sendKeys("maven");
    driver.findElement(By.id("stb")).click();
  }

  @AfterClass
  public void tearDown() throws Exception {
    driver.quit();
 
    }
 
  
}
