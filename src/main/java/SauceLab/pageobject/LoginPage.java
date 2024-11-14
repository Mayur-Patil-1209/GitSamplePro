package SauceLab.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SauceLab.AbstractComponent.AbstractComponent;

public class LoginPage extends AbstractComponent {

		WebDriver driver;
		
		public LoginPage(WebDriver driver)
		{
			super(driver);
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		@FindBy (id="user-name")
		WebElement usernameEle;
		
		@FindBy (id="password")
		WebElement passwordEle;
		
		@FindBy (id="login-button")
		WebElement loginButtonEle;
		
		
		public void loginToSauceLab(String username, String Password) 
		{
			usernameEle.sendKeys(username);
			passwordEle.sendKeys(Password);
			loginButtonEle.click();
		}
		
		public void goTo()
		{
			driver.get("https://www.saucedemo.com/v1/");
		}

}
