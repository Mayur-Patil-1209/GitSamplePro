package SauceLab.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SauceLab.AbstractComponent.AbstractComponent;

public class CheckoutOverviewPage extends AbstractComponent {

		WebDriver driver;
		
		public CheckoutOverviewPage(WebDriver driver)
		{
			super(driver);
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		@FindBy (css =".summary_quantity")
		WebElement productCount;
		
		@FindBy (css =".inventory_item_name")
		WebElement productSelected;
		
		@FindBy (css =".btn_action.cart_button")
		WebElement finishBtn;
		
		
		
		public String getProductCount()
		{
			String count =productCount.getText();
			return count;
		}
		
		public String getProductSelected()
		{
			String prod = productSelected.getText();
			return prod;
		}
		
		public void finish()
		{
			finishBtn.click();
		}
		
}
