package airbnb.testAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Utilities {
	
	WebDriver driver;
	WebDriverWait wait;
	Actions action;
	public static final int TimeOut = 30;
	public Utilities()
	{
		this.driver=BaseTest.driver;
		 wait= new WebDriverWait(driver,TimeOut);
		 action = new Actions(driver);
	}
	public Utilities clickElement(WebElement element)
	{
		
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
		return this;
	}
	
	public Utilities setInput(WebElement element, String inputStr) {
		wait.until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(inputStr);
		return this;
		
	}
	
	public void waitForElement(WebElement element)
	{
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void actionMoveElement(WebElement element,int position)
	{
		Actions move = new Actions(driver);
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
        Action action = (Action) move.dragAndDropBy(element, position, 0).build();
        action.perform();
	}
	

}
