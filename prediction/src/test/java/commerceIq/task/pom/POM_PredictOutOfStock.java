package commerceIq.task.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import commerceIq.task.ConfigDetails.BaseTestClass;


public class POM_PredictOutOfStock extends BaseTestClass {
	
	public POM_PredictOutOfStock(){
		this.driver = driver;
	}
	
	public static String WeeksToCheckForOutOfStock_WE = "";
	public static String Productname_WE = "";
	public static String currentUnitsInStockAtWarehouse_WE = "";
	public static String forecastedUnitsToBeSoldFromWarehouseInEachComingWeek = "";
	public static String unitsThatWillComeInWarehouseStockInComingEachWeek = "";
	
	public String GetText(String xpath) {
		return driver.findElement(By.xpath(xpath)).getText();
	}
	
	
}
