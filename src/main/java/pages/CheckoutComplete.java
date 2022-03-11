package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.PageBase;

public class CheckoutComplete extends PageBase 
{

	public CheckoutComplete(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(className = "complete-header")
	public WebElement SuccessfulOrderMessage;
	
	@FindBy(id = "back-to-products")
	WebElement backToProductsBtn;
	
	public void returnToProductsPage()
	{
		clickButton(backToProductsBtn);
	}

}
