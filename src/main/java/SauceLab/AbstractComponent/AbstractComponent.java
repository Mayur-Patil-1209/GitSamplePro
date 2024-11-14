package SauceLab.AbstractComponent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AbstractComponent {

	WebDriver driver;

	public AbstractComponent(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (css = ".fa-3x path")
	WebElement cart;
	
	public void goToCart()
	{
		cart.click();
	}
	
	public void waitForElement() throws InterruptedException
	{
		Thread.sleep(1000);
	}
	
	public void teardown()
	{
		driver.quit();
	}
}
