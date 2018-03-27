package airbnb.testAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
	
public static WebDriver driver;
	
	public static void initializeDriver()
	{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		
	}

}
