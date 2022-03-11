package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.PageBase;

public class YourCartPage extends PageBase 
{

	public YourCartPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(id = "checkout")
	WebElement checkoutBtn;
	
	public void proceedToCheckout() throws InterruptedException
	{
		clickButton(checkoutBtn);
		
//		Thread.sleep(500);
	}
	
}
