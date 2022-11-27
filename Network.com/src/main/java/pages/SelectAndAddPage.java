package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.io.IOException;

public class SelectAndAddPage extends BasePage {
	
	SelectAndAddPage selectAndAddPage;
	ReadUsernamePassword readUsernamePassword;
	
	Logs log;
	
	public SelectAndAddPage(WebDriver driver)
	{
		super(driver);
		
	}
	
	public void hoverToFirstDiscountProduct()
	{
		Actions action = new Actions(driver);
		
		WebElement we = driver.findElement(By.xpath("(//a[@data-id=\"1073542-170\"])[1]"));
		action.moveToElement(we).build().perform();	
		
		driver.findElement(By.xpath("//label[@extcode=\"1073542007\"]")).click();
		
		driver.findElement(By.xpath("//button[@class='product__button -addToCart btn -black']")).click();
		
		
		
	}
	
	public void goToShoppingBox()
	
	{
		selectAndAddPage = new SelectAndAddPage(driver);
		waitfor(2);
		driver.findElement(By.xpath("//a[@class='button -primary header__basket--checkout header__basketModal -checkout']")).click();	
		
	}
	
	public String checkBoxSize() {
		waitfor(1);
		return driver.findElement(By.xpath("//div[@class='cartItem__attr -size']")).getText();
	}
	
	public String checkBoxPrice()
	{
		waitfor(1);
		return driver.findElement(By.xpath("//span[@class='cartItem__price -sale']")).getText();
	}
	
	public boolean checkTheDiscountPrice()
	{
		String actualValue = driver.findElement(By.xpath("//span[@class='cartItem__price -old -labelPrice']")).getText();
		
		log.info(actualValue);
		
		String discountedValue = driver.findElement(By.xpath("//span[@class=\"cartItem__price -sale\"]")).getText();
		
		double actualPrice = Double.parseDouble(actualValue.substring(0, actualValue.length() - 3).replace(".", "").replace(",", "."));
        double discountedPrice = Double.parseDouble(discountedValue.substring(0, discountedValue.length() - 3).replace(".", "").replace(",", "."));
        
        if (actualPrice>discountedPrice) 
        	return true;
        else
        	return false;
	}
	
	public void clickToMoveOnButton()
	{
		driver.findElement(By.xpath("//button[@class=\"continueButton n-button large block text-center -primary\"]")).click();
	}
	
	public void fillTheUsernameInfo() throws IOException {
        waitfor(1);
        readUsernamePassword = new ReadUsernamePassword(driver);
        WebElement weUsername = driver.findElement(By.xpath("bos"));
        weUsername.sendKeys(readUsernamePassword.username());
    }
	 
	public void fillThePasswordInfo() throws IOException {
	    waitfor(1);
	    readUsernamePassword = new ReadUsernamePassword(driver);
	    WebElement wePassword = driver.findElement(By.xpath("//input[@id='n-input-password']"));
	    wePassword.sendKeys(readUsernamePassword.password());
	 }
	
	public void clickToNetworkLogo()
	{
		waitfor(1);
		driver.findElement(By.xpath("//a[@class='headerCheckout__logo']")).click();
	}
	
	public void clickShoppingBoxLogo()
	{
		waitfor(1);
		driver.findElement(By.xpath("//button[@class='header__basketTrigger js-basket-trigger -desktop']")).click();
	}
	
	public void clickRemoveItem()
	{
		waitfor(1);
		driver.findElement(By.xpath("//span[@class=\"cartItem__buttonText -remove\"]")).click();
		waitfor(1);
		driver.findElement(By.xpath("//button[@class=\"-modal n-button large block text-center -primary\"]")).click();
		waitfor(3);
	}
	
	public void isItEmpty()
	{
		WebElement isItEmpty = driver.findElement(By.xpath("//span[@class='header__emptyBasketText']"));
		if (isItEmpty.isDisplayed()) 
			System.out.println("Sepet Boştur");
		else
			System.out.println("Sepet Doludur");
		
	}

}
