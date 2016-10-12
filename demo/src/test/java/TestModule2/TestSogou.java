package TestModule2;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestSogou {
  private WebDriver driver;
  private String baseUrl;

  @BeforeClass
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
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
