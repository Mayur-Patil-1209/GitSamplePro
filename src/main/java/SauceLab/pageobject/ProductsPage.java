package SauceLab.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SauceLab.AbstractComponent.AbstractComponent;

public class ProductsPage extends AbstractComponent {

		WebDriver driver;
		
		public ProductsPage(WebDriver driver)
		{
			super(driver);
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		
		@FindBy (css ="div[class='inventory_item']")
		List <WebElement> productsList;
		
		By prod = By.cssSelector("button");
		
		public WebElement selectProduct(String productName) 
		{
			WebElement product = productsList.stream().filter(prod -> prod
					.findElement(By.cssSelector("#item_4_title_link div")).getText().equalsIgnoreCase(productName))
					.findFirst().orElse(null);
			return product;
		}
		
		public void addToCart(String productName)
		{
			WebElement product = selectProduct(productName);
			product.findElement(prod).click();
		}
		
		

}
