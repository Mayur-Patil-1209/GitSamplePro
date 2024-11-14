package SauceLab.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SauceLab.AbstractComponent.AbstractComponent;

public class CheckoutCompletePage extends AbstractComponent {

		WebDriver driver;
		
		public CheckoutCompletePage(WebDriver driver)
		{
			super(driver);
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		@FindBy (css =".complete-header")
		WebElement completeMessage;
		
		@FindBy (id ="back-to-products")
		WebElement backToHome;
		
		
		public String getSuccessMessage()
		{
			String message =completeMessage.getText();
			return message;
			
		}
		
}
