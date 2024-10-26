package Automation;

import org.testng.annotations.Test;

public class TestCases extends BaseClass{

	
	@Test(priority=1)
	public void VerifyLogin() throws InterruptedException
	{
		
		lp.ClickOnSignIn();
		lp.EnterUsername("nnn123");
		lp.EnterPassword("$$A*2024*na$$");
		lp.CheckedRememberMe();
		lp.SignIn();
		lp.ClickCompanyTab();
		lp.getalldata();
	//	lp.SelectCompany();
//		lp.Windowhandling(1);
		//lp.scrolling();
//		lp.CopyMemberID();
//		lp.CopyBasicDetailsSection();
	}
	
}
