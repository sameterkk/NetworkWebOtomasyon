package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
	
	WebDriver driver;
	By cooky = By.id("onetrust-accept-btn-handler");
	
	public BasePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void cookies()
	{
		click(cooky);
	}
	
	public WebElement find(By locator)
	{
		return driver.findElement(locator);
	}
	
	public void click(By locator)
	{
		find(locator).click();
	}
	public void waitfor(double seconds)
	{
		try
		{
		Thread.sleep((long)(seconds * 1000));
		}
		catch(InterruptedException ignored)
		{
		
		}
	}

}
