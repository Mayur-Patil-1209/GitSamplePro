package SauceLab.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import SauceLab.TestComponents.BaseTest;
import SauceLab.pageobject.CheckoutCompletePage;
import SauceLab.pageobject.CheckoutOverviewPage;
import SauceLab.pageobject.CheckoutYourInfoPage;
import SauceLab.pageobject.LoginPage;
import SauceLab.pageobject.ProductsPage;
import SauceLab.pageobject.YourCartPage;

public class TestScript extends BaseTest {

	
	@Test
	public void sauceLabTest() throws IOException
	{
		String productName = "Sauce Labs Backpack";
		String username = "standard_user";
		String password = "secret_sauce";
		
		String firstName = "SauceLab";
		String lastName = "Automation";
		String postalCode = "1212";
		
		String productCount = "1";
		String successMessageExpected = "THANK YOU FOR YOUR ORDER";
		
		LoginPage login = launchApplication();
		login.goTo();
		login.loginToSauceLab(username, password);
		
		ProductsPage products = new ProductsPage(driver);
		products.selectProduct(productName);
		products.addToCart(productName);
		
		products.goToCart();
		
		YourCartPage yourcart = new YourCartPage(driver);
		yourcart.goToCheckout();
		
		CheckoutYourInfoPage checkoutinfo = new CheckoutYourInfoPage(driver);
		checkoutinfo.fillCheckoutInfo(firstName, lastName, postalCode);
		
		CheckoutOverviewPage checkoutfinish = new CheckoutOverviewPage(driver);
		String count = checkoutfinish.getProductCount();
		Assert.assertEquals(productCount, count);

		String productSelected = checkoutfinish.getProductSelected();
		Assert.assertEquals(productSelected, productName);
		
		checkoutfinish.finish();
		
		CheckoutCompletePage completeCheckout = new CheckoutCompletePage(driver);
		String successMessage = completeCheckout.getSuccessMessage();
		Assert.assertEquals(successMessage, successMessageExpected);
		System.out.println(completeCheckout.getSuccessMessage());
		
		checkoutfinish.teardown();

	}

}
