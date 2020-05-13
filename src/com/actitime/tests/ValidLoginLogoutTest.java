package com.actitime.tests;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.actitime.generic.BaseTest;
import com.actitime.generic.ExcelData;
import com.actitime.pages.EnterTimeTrackPage;
import com.actitime.pages.LoginPage;

public class ValidLoginLogoutTest extends BaseTest {
	@Test(priority = 1)
	public void testValidLogInLogout() {
		//To read the Excel Data
		String loginTitle = ExcelData.getData(file_path, "TC01", 1, 2);
		String un = ExcelData.getData(file_path, "TC01", 1, 0);
		String pw = ExcelData.getData(file_path, "TC01", 1, 1);
		String enterTitle = ExcelData.getData(file_path, "TC01", 1, 3);
		
		LoginPage lp = new LoginPage(driver);
		EnterTimeTrackPage ep = new EnterTimeTrackPage(driver);
		
		//Verify LogIn Title
		lp.verifyPageTitle(loginTitle);
		
		//Enter valid user name
		lp.enterUserName(un);
		Reporter.log("Valid Username is:" +un, true);
		
		//Enter valid password
		lp.enterPassword(pw);
		Reporter.log("Valid Password is:" +pw, true);
		
		//Click on login
		lp.clickOnLogin();
		
		//Verify Enter Title
		lp.verifyPageTitle(enterTitle);
		
		//Click on log out
		ep.clickOnLogout();
		
		//Verify LogIn Title
		lp.verifyPageTitle(loginTitle);
		
	}

}
