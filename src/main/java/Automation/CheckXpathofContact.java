package Automation;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckXpathofContact {

	
	
	@FindBy(xpath = "//*[@id='ContactCardShowFlag']/div/div[1]/div/div[2]/div[1]")
	private WebElement contactname;
	
	@FindBy(xpath = "/html/body/div[1]/div[1]/section/div/div/div[1]/div[1]/div[1]/div[2]/span")
	private WebElement companyNameclick;
	
	@FindBy(xpath = "/html/body/div[1]/div[1]/section/div/div/div[1]/div[2]/div/div[1]/div[2]/div/div/div/input")
	private WebElement searchbarcomapny;
	
	@FindBy(xpath = "/html/body/div[1]/div[1]/section/div/div/div[1]/div[2]/div/div[2]/div/svg")
	private WebElement searchicon;
	
	@FindBy(xpath = "/html/body/div[1]/div[1]/section/div/div/div[1]/div[3]/div[2]/div/div/ul/li/div[1]/div/div[2]/div[1]/p")
	private WebElement companyopen;
	
	public void getContactName() throws InterruptedException
	{
		Thread.sleep(4000);
		contactname.click();
		Thread.sleep(4000);
		
		
	}
}
