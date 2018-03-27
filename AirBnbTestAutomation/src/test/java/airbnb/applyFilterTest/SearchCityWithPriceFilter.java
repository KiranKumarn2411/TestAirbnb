package airbnb.applyFilterTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import airbnb.pageObjects.LandingPage;
import airbnb.pageObjects.SearchAirbnbPage;
import airbnb.testAutomation.BaseTest;
import airbnb.testResourceRead.PropertyReader;


public class SearchCityWithPriceFilter {
	
	WebDriver driver;
	PropertyReader property;
	LandingPage landingPageActions;
	SearchAirbnbPage seachPageActions;
	Logger LOGGER;

	@BeforeSuite
	public void setup()
	{
		BaseTest.initializeDriver();
		property =new PropertyReader();
		driver= BaseTest.driver;
		driver.get(property.getProperty("url"));
		landingPageActions=new LandingPage();
		seachPageActions= new SearchAirbnbPage();
		LOGGER=Logger.getLogger(SearchCityWithPriceFilter.class);
	}
	
	
	@Test(dataProvider="PriceValue")
	public void searchCityHomeBasedOnPrice(int priceValue) throws InterruptedException
	{
		LOGGER.info("Airbnb automation assigment scenario");
		landingPageActions.searchCity(property.getProperty("city"));
		seachPageActions.selectMoreFilter();
		seachPageActions.selectPriceFiler();
		seachPageActions.validateSearchResultWithPrice(priceValue);
	}
	
	@AfterSuite
	public void closeBrowser()
	{
		LOGGER.info("Closing the driver");
		driver.quit();
	}
	

	@DataProvider(name="PriceValue")
	public Object[][] getPriceFilterValue()
	{
		return new Object[][] {{100}};
	}

	
}
