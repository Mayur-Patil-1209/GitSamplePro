package SauceLab.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SauceLab.AbstractComponent.AbstractComponent;

public class YourCartPage extends AbstractComponent {

		WebDriver driver;
		
		public YourCartPage(WebDriver driver)
		{
			super(driver);
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		@FindBy (css =".checkout_button")
		WebElement checkout;
		
		
		public void goToCheckout()
		{
			checkout.click();
		}
		
}
