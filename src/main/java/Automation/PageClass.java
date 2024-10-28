package Automation;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
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
import org.openqa.selenium.TimeoutException;
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
	private WebElement url;
	
	@FindBy(xpath = "//div[contains(@class,\"pt-10px font-['Poppins-Regular', 'Poppins']\")]")
	private WebElement designation;
	
	@FindBy(xpath = "(//*[@class='content pl-5px'])[2]")
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
		else
		{
			System.out.println("");

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
		try {
	        // Wait for the element to be visible before checking if it is displayed
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
	        WebElement member_idElement = wait.until(ExpectedConditions.visibilityOf(member_id));
		if(member_idElement.isDisplayed()==true)
		{
		waitForElement(member_idElement);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", member_idElement);
		// Reporter.log("Member ID of Client :" + member_id.getText(), true); 
		String strmemberID = member_idElement.getText();
		System.out.println(strmemberID);
		return strmemberID;
		}
	   
	 } catch (TimeoutException e) {
	        System.out.println("Member ID Element was not found within the timeout period.");
	    } catch (NoSuchElementException e) {
	        System.out.println("Element not found: " + e.getMessage());
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
}
	
	public String address()
	{

		try {
	        // Wait for the element to be visible before checking if it is displayed
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
	        WebElement addressElement = wait.until(ExpectedConditions.visibilityOf(address));
		if(addressElement.isDisplayed()==true)
		{
		waitForElement(addressElement);
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", address);i
		String straddress = addressElement.getText();
		System.out.println(straddress);
		return straddress;
	  // Reporter.log("Address: " + address.getText(), true);
	}
	
	 } catch (TimeoutException e) {
	        System.out.println("Address Element was not found within the timeout period.");
	    } catch (NoSuchElementException e) {
	        System.out.println("Element not found: " + e.getMessage());
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
}
	
	
	public String cityandcountry()
	{
		try {
	        // Wait for the element to be visible before checking if it is displayed
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
	        WebElement cityandcountryElement = wait.until(ExpectedConditions.visibilityOf(cityandcountry));
		if(cityandcountryElement.isDisplayed()==true)
		{
		 waitForElement(cityandcountryElement);
		 //  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cityandcountry);
		   String  strcityandcountry = cityandcountryElement.getText();
		   System.out.println(strcityandcountry);
		   return strcityandcountry;
		 //  Reporter.log("City And Country: " + cityandcountry.getText(), true);
		}
	
	 } catch (TimeoutException e) {
	        System.out.println("City and Country Element was not found within the timeout period.");
	    } catch (NoSuchElementException e) {
	        System.out.println("Element not found: " + e.getMessage());
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
}
	
	public String uRL()
	{
		try {
	        // Wait for the element to be visible before checking if it is displayed
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
	        WebElement urlElement = wait.until(ExpectedConditions.visibilityOf(url));
		if(urlElement.isDisplayed())
		{
		waitForElement(urlElement);
	  // ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", emailID);
	   String URL = urlElement.getText();
	   System.out.println(URL);
	   return URL;
	  // Reporter.log("Email ID: " + emailID.getText(), true);
		}		    
	 } catch (TimeoutException e) {
	        System.out.println("URL Element was not found within the timeout period.");
	    } catch (NoSuchElementException e) {
	        System.out.println("Element not found: " + e.getMessage());
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
}
	
	public String contactname()
	{
		try {
	        // Wait for the element to be visible before checking if it is displayed
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
	        WebElement contactnameElement = wait.until(ExpectedConditions.visibilityOf(contactname));
		if(contactnameElement.isDisplayed()==true)
		{
		  waitForElement(contactnameElement);
		   //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", contactname);
		   String strcontactname = contactnameElement.getText();
		   System.out.println(strcontactname);
		   return strcontactname;
		  // Reporter.log("Contact Name: " + contactname.getText(), true);
		}
		 } catch (TimeoutException e) {
		        System.out.println("Designtion Element was not found within the timeout period.");
		    } catch (NoSuchElementException e) {
		        System.out.println("Element not found: " + e.getMessage());
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		    return null;
	}
	
	public String designation()
	{
		try {
	        // Wait for the element to be visible before checking if it is displayed
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
	        WebElement designationElement = wait.until(ExpectedConditions.visibilityOf(designation));

		if(designationElement.isDisplayed()==true)
		{
		  waitForElement(designationElement);
		   //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", contactname);
		   String designationname = designationElement.getText();
		   System.out.println(designationname);
		   return designationname;
		  // Reporter.log("Contact Name: " + contactname.getText(), true);
	
			    }
		 } catch (TimeoutException e) {
		        System.out.println("Designtion Element was not found within the timeout period.");
		    } catch (NoSuchElementException e) {
		        System.out.println("Element not found: " + e.getMessage());
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		    return null;
	}
	
	
	public String contactemail()
	{
		try {
	        // Wait for the element to be visible before checking if it is displayed
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
	        WebElement contactemailElement = wait.until(ExpectedConditions.visibilityOf(contactemail));
		
		if(contactemailElement.isDisplayed()==true)
		{
		waitForElement(contactemailElement);
	  // ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", contactemail);
	   String strcontactemail = contactemailElement.getText();
	   System.out.println(strcontactemail);
	   return strcontactemail;
	   // Reporter.log("Contact Email: " + contactemail.getText(), true);
	 }
		 } catch (TimeoutException e) {
		        System.out.println("Element was not found within the timeout period.");
		    } catch (NoSuchElementException e) {
		        System.out.println("Element not found: " + e.getMessage());
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		    return null;
	}
	
	public String mobilenumber()
	{
		try {
	        // Wait for the element to be visible before checking if it is displayed
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
	        WebElement mobileNumberElement = wait.until(ExpectedConditions.visibilityOf(mobileNumber));
		
		if(mobileNumberElement.isDisplayed()==true)
		{
			waitForElement(mobileNumberElement);
			  // ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", mobileNumber);
			   strmobilenumber = mobileNumberElement.getText();
			   System.out.println(strmobilenumber);
			   return strmobilenumber;
		}
	 } catch (TimeoutException e) {
	        System.out.println("Mobile Element was not found within the timeout period.");
	    } catch (NoSuchElementException e) {
	        System.out.println("Element not found: " + e.getMessage());
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
}
		//return strmobilenumber;
		
		  // return null;
		   //Reporter.log("Mobile Number: " + mobileNumber.getText(), true);
	
	

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
	    //data.put("Member ID", CopyMemberID());
	    data.put("Address", address());
	    data.put("City and Country", cityandcountry());
	   // data.put("URL", uRL());
	    data.put("Contact Name", contactname());
	    data.put("Designation", designation());
	    data.put("Company Email", contactemail());
	    data.put("Company Mobile", mobilenumber());

	    String[] columnNames = {"Company Name", "Address", "City and Country", "Contact Name","Designation", "Company Email","Company Mobile"};
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
		
		int totalRecords = 8000; // 
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
        	                address();
        	                cityandcountry();
        	                contactname();
        	                designation();
        	                contactemail();
        	                mobilenumber();
        	                
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
