package commerceIq.task.ConfigDetails;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BaseTestClass {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public BaseTestClass(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + 
					"/src/test/java/commerceIq/task/ConfigDetails/config.properties");
			prop.load(ip);
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void Initialization() {
		
		String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("Chrome")) {
			String path = System.getProperty("user.dir") + "\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", path );
//			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//			ChromeOptions options = new ChromeOptions();
//			options.setExperimentalOption("useAutomationExtension", Boolean.valueOf(false));
//			capabilities.setCapability("goog:chromeOptions", options);
//			capabilities.setCapability("acceptInsecureCerts", true);
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("FF")) {
			
			String path = System.getProperty("user.dir") + "\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", path );
			FirefoxProfile profile = new FirefoxProfile();
			profile.setAcceptUntrustedCertificates(true);
			profile.setAssumeUntrustedCertificateIssuer(false);
			FirefoxOptions options = new FirefoxOptions();
			options.setProfile(profile);
			options.addArguments(new String[]{"--window-size=1366,768"});
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability("marionette", true);
			capabilities.setCapability("moz:firefoxOptions", options);
			options.merge(capabilities);
			driver = new FirefoxDriver(capabilities);
			}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

}
