package SauceLab.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SauceLab.AbstractComponent.AbstractComponent;

public class CheckoutYourInfoPage extends AbstractComponent {

		WebDriver driver;
		
		public CheckoutYourInfoPage(WebDriver driver)
		{
			super(driver);
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		
		@FindBy (id ="first-name")
		WebElement firstName;
		
		@FindBy (id ="last-name")
		WebElement lastName;
		
		@FindBy (id ="postal-code")
		WebElement postalCode;
		
		@FindBy (css =".btn_primary.cart_button")
		WebElement continueBtn;
		
		
		
		public void fillCheckoutInfo(String firstname, String lastname, String postalcode)
		{
			firstName.sendKeys(firstname);
			lastName.sendKeys(lastname);
			postalCode.sendKeys(postalcode);
			continueBtn.click();
		}
		
}
