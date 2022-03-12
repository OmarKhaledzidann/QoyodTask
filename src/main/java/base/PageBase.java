package base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {
	protected WebDriver driver;
	JavascriptExecutor jse;
	WebDriverWait wait;
	Actions actions;

	// Create a parametrised constructor
	public PageBase(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 30);
//			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		actions = new Actions(driver);

	}

	protected void clickButton(WebElement button) {
		button.click();
	}

	protected void setTextElement(WebElement inputField, String value) {
		inputField.sendKeys(value);
	}

	public void WaitForElemeentVisibility(WebElement inputField) {
		wait.until(ExpectedConditions.visibilityOf(inputField));
	}

	public void scrolltoElement(WebElement element) {
		actions.moveToElement(element).build().perform();
	}

	public void selectitemFromList(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

}
