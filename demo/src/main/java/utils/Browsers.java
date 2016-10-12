package utils;
import java.io.*;
import java.util.Arrays;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
public class Browsers {
	public WebDriver driver=null;
	public DesiredCapabilities caps=null;
	String projectpath=System.getProperty("user.dir"); //获取项目工程跟路径
	
	public Browsers(BrowsersType browserstype){
		switch(browserstype) {
			case firefox:
				File firebug= new File(projectpath+"/tool/firebug@software.joehewitt.com.xpi");
				File firepath= new File(projectpath+"/tool/FireXPath@pierre.tholence.com.xpi");
				FirefoxProfile firefoxprofile = new FirefoxProfile();				
				try{
					firefoxprofile.addExtension(firebug);
					firefoxprofile.addExtension(firepath);
					firefoxprofile.setPreference("webdriver.accept.untrusted.certs","true");
					firefoxprofile.setPreference("extensions.firebug.currentVersion","1.9.2.1");
				} catch(Exception e){
					e.printStackTrace();
				}
				driver = new FirefoxDriver(firefoxprofile);
				driver.manage().window().maximize();
				break;
			case ie:
				System.setProperty("webdriver.ie.driver",projectpath+"/tool/IEDriverServer.exe");				
				caps = DesiredCapabilities.internetExplorer();				
				caps.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS,false);
				caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
				caps.setCapability(InternetExplorerDriver.IE_SWITCHES,"-private");
				caps.setCapability("ignoreZoomSetting",true);
				driver = new InternetExplorerDriver(caps);
				driver.manage().window().maximize();
				break;
			case chrome:				
				System.setProperty("webdriver.chrome.driver",projectpath+"/tool/chromedriver.exe");
				caps = DesiredCapabilities.chrome();
				//caps.setCapability("chrome.switches",Arrays.asList("--start-maximized")); //最大化browser				
				//caps.setCapability("chrome.switches",Arrays.asList("--proxy-server=http://your-proxy-domain:4443")); //设置代理				
				driver = new ChromeDriver(caps);
				break;
		}	

	}
}
