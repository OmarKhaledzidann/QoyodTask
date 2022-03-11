package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.PageBase;

public class UserLoginPage extends PageBase
{

	public UserLoginPage(WebDriver driver) 
	{
		super(driver);
		
	}
	
	@FindBy(id = "user-name")
	WebElement userName;
	
	@FindBy(id = "password")
	WebElement passwordField;
	
	@FindBy(id = "login-button")
	WebElement loginBtn;
	
	
	public void userLogin(String username , String password) throws InterruptedException
	{
		setTextElement(userName, username);
		
//		Thread.sleep(500);
		
		setTextElement(passwordField, password);
		
//		Thread.sleep(500);

		
		clickButton(loginBtn);
	}
	
}
