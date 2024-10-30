package Automation;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass 
{
	   public WebDriver driver;
	   public PageClass lp;
	   public PageClass2 lp2;
	  // public WebDriverWait wait;
		
		@BeforeSuite
		public void initBrowser() {
			//WebDriverManager.chromedriver().setup();
			WebDriverManager.firefoxdriver().setup();
			
			//ChromeOptions options = new ChromeOptions();
		FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless");
			options.addArguments("--disable-gpu");
			//driver=new ChromeDriver(options);
			driver = new FirefoxDriver(options); 
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.get("https://www.jctrans.com/en/inquiry");
			
		}
		
		//@AfterSuite
		public void tearDown()
		{
			driver.quit();
		}
		
		@BeforeClass
		public void objectCreation()
		{
			 lp = new PageClass(driver);
			 lp2 = new PageClass2(driver);
		}
		

}
