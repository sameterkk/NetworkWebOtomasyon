import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class Test_Base {
	WebDriver driver;
	
	@BeforeAll
	public void setUp()
	{
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		
		driver.get("https://www.network.com.tr");
		driver.manage().window().maximize();
		Assertions.assertEquals("https://www.network.com.tr/", driver.getCurrentUrl());
	}
	
	@AfterAll
	public void shutDown()
	{
		driver.quit();
	}
}
