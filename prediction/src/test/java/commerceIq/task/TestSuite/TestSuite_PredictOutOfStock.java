package commerceIq.task.TestSuite;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import commerceIq.task.ConfigDetails.BaseTestClass;
import commerceIq.task.pom.POM_PredictOutOfStock;

public class TestSuite_PredictOutOfStock extends BaseTestClass{

	POM_PredictOutOfStock pos;
	
	public TestSuite_PredictOutOfStock() throws IOException{
		super();
	}
	
	@BeforeMethod
	public void startDriver() throws IOException {
		Initialization();
		POM_PredictOutOfStock pos = new POM_PredictOutOfStock();
		System.out.println("in BeforeMethod");
		String url = prop.getProperty("url");
		System.out.println(url);
		driver.get(url);
		
	}
	
	@Test
	public void check() {
		System.out.println("in check");
	}
	
	
	@AfterMethod
	public void closeDriver() {
		driver.quit();
	}

}
