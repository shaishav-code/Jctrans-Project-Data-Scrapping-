package Automation;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageClass {
	
	WebDriver driver;
	WebDriverWait wait;
	
	
	String parentHandle;
	String strmobilenumber;
	Set<String> handles;
	
	int rowCount = 1;

	public PageClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@class='login-btn']")
	private WebElement signin;
	
	@FindBy(xpath="//*[@id='pane-first']/form/div[1]/div/div[1]/div/div/div/input")
	private WebElement username;
	
	@FindBy(xpath="//*[@id=\"pane-first\"]/form/div[2]/div/div[1]/div/div/div/input")
	private WebElement password;
	
	@FindBy(xpath="//*[@class='el-checkbox__inner']")
	private WebElement remember_me;
	
	@FindBy(xpath="//*[@type='button']")
	private WebElement signin_btn;
	
	@FindBy(xpath = "//div[@class='el-message-box']")
	private WebElement confirmLoginPopup;
	
	@FindBy(xpath = "//div[@class='el-message-box__btns']/button[2]")
	private WebElement popupConfirmbutton;
	
	@FindBy(xpath="//div[@id='app']/div[1]/div[1]/div[3]/div[3]/div[3]/div")
	private WebElement companydirectory;
	
	@FindBy(xpath="//div[@class='membership-list-content-center']/div/div/ul/li/div[1]/div/div[2]/div[1]/p")
	private List<WebElement> companynames;
	
	@FindBy(xpath = "//*[@id='app']/div[1]/section/div/div/div[1]/div[3]/div[2]/div/div/ul/li[2]/div[1]/div/div[2]/div[1]/p")
	private WebElement companyname;

	@FindBy(xpath = "//*[@id='app']/div[1]/section/div/div/div[1]/div[1]/div[2]/div[2]/h1")
	private WebElement newtabcompanyname;
	
	@FindBy(xpath="(//*[contains(@class,'top_view top_')])[1]")
	private WebElement member_id;
	
//	@FindBy(xpath="//*[@id=\"app\"]/div[1]/section/div/div/div[1]/div[2]/div[2]/div[1]")
//	private WebElement basicdetails;
	
	@FindBy(xpath = "//*[@id='app']/div[1]/section/div/div/div[1]/div[2]/div[2]/div[1]/div[2]/div[2]/div[2]")
	private WebElement address;
	
	@FindBy(xpath = "//*[@id='app']/div[1]/section/div/div/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]")
	private WebElement cityandcountry;
	
	@FindBy(xpath = "(//div[@class='pt-5px desc_value'])[1]")
	private WebElement contactname;
	
	@FindBy(xpath = "(//div[@class='pt-5px desc_value'])[2]")
	private WebElement contactemail;
	
	@FindBy(xpath = "//*[@id='app']/div[1]/section/div/div/div[1]/div[2]/div[2]/div[1]/div[2]/div[5]/div[2]/a/span")
	private WebElement emailID;
	
	@FindBy(xpath = "(//div[@class='pt-5px desc_value'])[3]")
	private WebElement mobileNumber;
	
	
	public void waitForElement(WebElement ele)
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public void ClickOnSignIn()
	{
		waitForElement(signin);
		signin.click();
	}
	
	public void EnterUsername(String usrname) throws InterruptedException
	{
		waitForElement(username);
		username.click();
		Thread.sleep(2000);
		username.sendKeys(usrname);
	}
	
	public void EnterPassword(String pass) throws InterruptedException
	{
		waitForElement(password);
		password.click();
		Thread.sleep(2000);
		password.sendKeys(pass);
	}
	
	public void CheckedRememberMe()
	{
		waitForElement(remember_me);
		remember_me.click();
	}
	
	public void SignIn()
	{
		waitForElement(signin_btn);
		signin_btn.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(confirmLoginPopup.isDisplayed());
		//waitForElement(confirmLoginPopup);
		if(confirmLoginPopup.isDisplayed()== true)
		{
			waitForElement(popupConfirmbutton);
			popupConfirmbutton.click();
		}
	}
	
	public void ClickCompanyTab()
	{
		waitForElement(companydirectory);
		companydirectory.click();
	}
	
	public String SelectCompany() throws InterruptedException
	{
//		int recoredsperpage = 20;
//		int totalrecord = 8000;
//		int initialrecord = 0;
		waitForElement(companyname);
		String strcompanyname = companyname.getText();
		System.out.println(strcompanyname);
		
		companyname.click();
		//parentHandle = driver.getWindowHandle();
		Thread.sleep(4000);
		return strcompanyname;
//		for(WebElement companyName : companynames)
//		{
//			if(initialrecord >= totalrecord)
//			{
//				break;
//			}
//			else
//			{
//				//if(recoredsperpage >= 20)
//				waitForElement(companyName);
//				companyName.click();
//				Windowhandling(1);
//				initialrecord++;
//			}
//    	   
//		}
	}
	public String comapnyname()
	{
		waitForElement(newtabcompanyname);
		String strcompanyname = newtabcompanyname.getText();
		return strcompanyname;
	}
	//Scrolling from top to bottom
	public void scrolling() {
		
       JavascriptExecutor js = (JavascriptExecutor)driver;
	   js.executeScript("window.scrollBy(0, 500)");
	   //js.executeScript("window.scrollBy(0, -400)");
	}
	
	public String CopyMemberID()
	{
		waitForElement(member_id);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", member_id);
		// Reporter.log("Member ID of Client :" + member_id.getText(), true); 
		String strmemberID = member_id.getText();
		System.out.println(strmemberID);
		return strmemberID;
	}
	
	public String address()
	{
		waitForElement(address);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", address);
		String straddress = address.getText();
		System.out.println(straddress);
		return straddress;
	  // Reporter.log("Address: " + address.getText(), true);
	}
	
	public String cityandcountry()
	{
		 waitForElement(cityandcountry);
		   ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cityandcountry);
		   String  strcityandcountry = cityandcountry.getText();
		   System.out.println(strcityandcountry);
		   return strcityandcountry;
		 //  Reporter.log("City And Country: " + cityandcountry.getText(), true);
	}
	
	public String emailID()
	{
		waitForElement(emailID);
	   ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", emailID);
	   String stremailID = emailID.getText();
	   System.out.println(stremailID);
	   return stremailID;
	  // Reporter.log("Email ID: " + emailID.getText(), true);
	}
	
	public String contactname()
	{
		  waitForElement(contactname);
		   ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", contactname);
		   String strcontactname = contactname.getText();
		   System.out.println(strcontactname);
		   return strcontactname;
		  // Reporter.log("Contact Name: " + contactname.getText(), true);
	}
	
	public String contactemail()
	{
		waitForElement(contactemail);
	   ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", contactemail);
	   String strcontactemail = contactemail.getText();
	   System.out.println(strcontactemail);
	   return strcontactemail;
	   // Reporter.log("Contact Email: " + contactemail.getText(), true);
	 }
	
	public String mobilenumber()
	{
		
		if(mobileNumber.isDisplayed())
		{
			waitForElement(mobileNumber);
			   ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", mobileNumber);
			   strmobilenumber = mobileNumber.getText();
			   System.out.println(strmobilenumber);
			   return strmobilenumber;
		}
		else
		{
			return null;
		}
		//return strmobilenumber;
		
		  // return null;
		   //Reporter.log("Mobile Number: " + mobileNumber.getText(), true);
	}
	

	//Window handling
	public void Windowhandling(int j)
	{
		 
		
		 handles = driver.getWindowHandles();
		 
		 for (String handle : handles) {
	            if (!handle.equals(parentHandle)) {
	                driver.switchTo().window(handle); 
	                
	                storedataintoexcel();
	                driver.close();
	                break;
	            }
	        }
		 driver.switchTo().window(parentHandle);
		 
		 
//	    String parentid = driver.getWindowHandle();
//		System.out.println("Parent id is :"+parentid);
//		Set<String> allwinid = driver.getWindowHandles();
//	    System.out.println("All windows ID :" +driver.getWindowHandles());
//
//        int numberofid = allwinid.size();
//		
//		int i =0;
//		String [] winid = new String[numberofid];
//		
//		for(String id:allwinid)
//		{
//			winid[i]=id;
//			i++;
//		}
//		
//		driver.switchTo().window(winid[j]);//1
//		
//		scrolling();
//		storedataintoexcel();
//		//CopyMemberID();
////		Reporter.log("Member ID of Client :" + member_id.getText(), true);
////		Reporter.log("Basic Details of Client: " + basicdetails.getText(), true); 
////		driver.close();
////		driver.switchTo().window(parentid);
//		//driver.findElement(By.xpath("//div[@id='app']/div[1]/section/div/div/div[1]/div[3]/div[2]/div/div/ul/li[2]/div[1]/div/div[2]/div[1]/p")).click();
//		
	} 
	

	
	/* while (true) 
		
	 {
	    if (!pagination.isEnabled()) 
	    {
	    	System.out.println(pagination.isEnabled());
	        break;
	    }
	    
        pagination.click();

     }   */
	
		
	
	public void storedataintoexcel()
	{
	    Map<String, String> data = new HashMap<>();
	    data.put("Company Name", comapnyname());
	    data.put("Member ID", CopyMemberID());
	    data.put("Address", address());
	    data.put("City and Country", cityandcountry());
	    data.put("Email ID", emailID());
	    data.put("Contact Name", contactname());
	    data.put("Company Email", contactemail());

	    String[] columnNames = {"Company Name", "Member ID", "Address", "City and Country", "Email ID", "Contact Name", "Company Email"};
	    String filePath = "UserDetails.xlsx";

	    Workbook workbook;
	    Sheet sheet;
	    File file = new File(filePath);

	    try {
	        if (file.exists()) {
	            FileInputStream fis = new FileInputStream(file);
	            workbook = WorkbookFactory.create(fis);
	            sheet = workbook.getSheet("Details");
	            fis.close();
	        } else {
	            workbook = new XSSFWorkbook();
	            sheet = workbook.createSheet("Details");

	            Row headerRow = sheet.createRow(0);
	            for (int i = 0; i < columnNames.length; i++) {
	                Cell cell = headerRow.createCell(i);
	                cell.setCellValue(columnNames[i]);
	            }
	        }

	        int rowCount = sheet.getLastRowNum() + 1;
	        Row dataRow = sheet.createRow(rowCount);

	        for (int i = 0; i < columnNames.length; i++) {
	            Cell cell = dataRow.createCell(i);
	            String columnName = columnNames[i];
	            cell.setCellValue(data.getOrDefault(columnName, ""));
	        }

	        FileOutputStream fileOut = new FileOutputStream(filePath);
	        workbook.write(fileOut);
	        workbook.close();
	        fileOut.close();

	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	@FindBy(xpath = "//*[@id='app']/div[1]/section/div/div/div[1]/div[3]/div[2]/div/div/ul/li[20]")
	private WebElement lastelement;
	
	@FindBy(xpath = "//*[@id='app']/div[1]/section/div/div/div[1]/div[3]/div[2]/div/div/div/button[2]/i")
	private WebElement nextbutton;
	
	public void getalldata()
	{
		
		int totalRecords = 40;
        int recordsPerPage = 20;
        int totalPages = totalRecords / recordsPerPage;
        
        
        try {
            for (int currentPage = 1; currentPage <= totalPages; currentPage++) {
                for (WebElement companyname2 : companynames) {
                    companyname2.click();
                    String parentWindow = driver.getWindowHandle();
                    Set<String> allWindows = driver.getWindowHandles();
                    Iterator<String> windowIterator = allWindows.iterator();
                    
                    while (windowIterator.hasNext())
                    {
                    	String childWindow = windowIterator.next();
                    	if (!parentWindow.equalsIgnoreCase(childWindow))
                    	{
                    		driver.switchTo().window(childWindow); 
                    		
                    		scrolling();
        	                comapnyname();
        	                CopyMemberID();
        	                address();
        	                cityandcountry();
        	                emailID();
        	                contactname();
        	                contactemail();
        	               // mobilenumber();
        	                
        	                storedataintoexcel();
        	                
        	                driver.close();
        	                driver.switchTo().window(parentWindow);
                    	}
                    }
                    //storedataintoexcel();
//                    Windowhandling(1);
                }
                waitForElement(lastelement);
        		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", lastelement);
                if (nextbutton.isDisplayed() && nextbutton.isEnabled()) {
                	nextbutton.click();
                } else {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();}
		
		
		
	}
}
