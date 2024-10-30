package Automation;

import org.testng.annotations.Test;

public class TestCases extends BaseClass{

	
	@Test(priority=1)
	public void VerifyLogin() throws InterruptedException
	{
		
		lp2.ClickOnSignIn();
		lp2.EnterUsername("nnn123");
		lp2.EnterPassword("$$A*2024*na$$");
		lp2.CheckedRememberMe();
		lp2.SignIn();
		lp2.ClickCompanyTab();
		lp2.applyfilters();
		lp2.getalldata();
	//	lp.SelectCompany();
//		lp.Windowhandling(1);
		//lp.scrolling();
//		lp.CopyMemberID();
//		lp.CopyBasicDetailsSection();
	}
	
}
