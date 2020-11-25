package com.actitime.tests;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.actitime.generic.BaseTest;
import com.actitime.generic.ExcelData;
import com.actitime.pages.LoginPage;

public class VerifyVersionTest extends BaseTest {
	@Test(priority = 3)
	public void testVerifyVersion() {
		String loginTitle = ExcelData.getData(file_path, "TC01", 1, 2);
		String eVersion = ExcelData.getData(file_path, "TC03", 1, 0);
		LoginPage lp = new LoginPage(driver);
		
		//Verify LogIn Title
		lp.verifyPageTitle(loginTitle);
		
		//Verify Version
		String aVersion = lp.verifyVersion();
		Reporter.log("Actual Version is:" +aVersion, true);
		Reporter.log("Expected Version is:" +eVersion, true);
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(aVersion, eVersion);
		Reporter.log("Both versions are matching...", true);
		sa.assertAll()
	}
	

}
