package com.actitime.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.actitime.generic.BasePage;

public class LoginPage extends BasePage {
	//Declaration
	@FindBy(id = "username")
	private WebElement unTb;
	
	@FindBy(name = "pwd")
	private WebElement pwTb;
	
	@FindBy(id = "loginButton")
	private WebElement loginBtn;
	
	@FindBy(xpath = "//span[contains(., 'Username or Password')]")
	private WebElement errorMsg;
	
	@FindBy(xpath = "(//nobr[contains(., 'actiTIME')])[1]")
	private WebElement version;
	
	//Initialization
	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public void verifyPageTitle(String eTitle) {
		verifyTitle(eTitle);
	}
	
	public void enterUserName(String un) {
		unTb.sendKeys(un);
	}
	
	public void enterPassword(String pw) {
		pwTb.sendKeys(pw);
	}
	
	public void clickOnLogin() {
		loginBtn.click();
	}
	
	public String verifyErrorMsg() {
		verifyElement(errorMsg);
		String aErrorMsg = errorMsg.getText();
		return aErrorMsg;
	}
	
	public String verifyVersion() {
		verifyElement(version);
		String aVersion = version.getText();
		return aVersion;
	}

}
