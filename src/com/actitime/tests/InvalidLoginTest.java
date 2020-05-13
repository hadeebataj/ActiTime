package com.actitime.tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.actitime.generic.BaseTest;
import com.actitime.generic.ExcelData;
import com.actitime.pages.LoginPage;

public class InvalidLoginTest extends BaseTest {
	@Test(priority = 2)
	public void testInvalidLogin() throws InterruptedException {
		String loginTitle = ExcelData.getData(file_path, "TC01", 1, 2);
		String eErrorMsg = ExcelData.getData(file_path, "TC02", 1, 2);
		int rc = ExcelData.getRowNum(file_path, "TC02");
		LoginPage lp = new LoginPage(driver);
		
		//Verify login title
		lp.verifyPageTitle(loginTitle);
		for (int i = 1; i<=rc; i++) {
			String un = ExcelData.getData(file_path, "TC02", i, 0);
			String pw = ExcelData.getData(file_path, "TC02", i, 1);
			
			//Enter invalid user name
			lp.enterUserName(un);
			Reporter.log("Invalid username:" +un, true);
			
			//Enter invalid password
			lp.enterPassword(pw);
			Reporter.log("Invalid password:" +pw, true);
			
			//Click on login
			lp.clickOnLogin();
			
			//Verify error message
			String aErrorMsg = lp.verifyErrorMsg();
			Reporter.log("Actual Error Msg:" +aErrorMsg, true);
			Reporter.log("Expected error Msg:" +eErrorMsg, true);
			Assert.assertEquals(aErrorMsg, eErrorMsg);
			Reporter.log("Both error messages are matching", true);
			Reporter.log("============================================", true);
			Thread.sleep(1000);
		}
	}

}
