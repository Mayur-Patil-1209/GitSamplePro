package SauceLab.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class FirstClass {

	public static void main(String[] args) throws InterruptedException {

		String productName = "Sauce Labs Backpack";

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.saucedemo.com/v1/");
		driver.manage().window().maximize();

		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();

		List<WebElement> productsList = driver.findElements(By.cssSelector("div[class='inventory_item']"));
		WebElement product = productsList.stream().filter(prod -> prod
				.findElement(By.cssSelector("#item_4_title_link div")).getText().equalsIgnoreCase(productName))
				.findFirst().orElse(null);
		product.findElement(By.cssSelector("button")).click();

		// Cart
		driver.findElement(By.cssSelector(".fa-3x path")).click();

		// Checkout
		driver.findElement(By.cssSelector(".checkout_button")).click();

		// Checkout Page
		driver.findElement(By.id("first-name")).sendKeys("SauceLab");
		driver.findElement(By.id("last-name")).sendKeys("Automation");
		driver.findElement(By.id("postal-code")).sendKeys("1212");
		driver.findElement(By.cssSelector(".btn_primary.cart_button")).click();

		// Verify Selected Count
		String quantity = driver.findElement(By.cssSelector(".summary_quantity")).getText();
		Assert.assertEquals("1", quantity);

		// Verify selected product
		String selectedProduct = driver.findElement(By.cssSelector(".inventory_item_name")).getText();
		Assert.assertEquals(selectedProduct, productName);
		
		//Finish - Checkout Overview Page
		driver.findElement(By.cssSelector(".btn_action.cart_button")).click();
		
		//Success Message
		System.out.println(driver.findElement(By.cssSelector(".complete-header")).getText());
		
		//Close the Brower
		driver.close();

	}

}
