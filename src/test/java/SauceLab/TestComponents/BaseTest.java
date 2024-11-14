package SauceLab.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import SauceLab.pageobject.LoginPage;

public class BaseTest {

	public WebDriver driver;
	
	public WebDriver InitializeDriver() throws IOException
	{
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\SauceLab\\Resources\\GlobalData.properties"); 
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/v1/");
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;
	}
	
	public LoginPage launchApplication() throws IOException
	{
		driver = InitializeDriver();
		LoginPage login = new LoginPage(driver);
		login.goTo();
		return login;
	}
	
}
