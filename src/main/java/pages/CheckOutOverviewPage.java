package pages;

import java.text.DecimalFormat;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.PageBase;

public class CheckOutOverviewPage extends PageBase {

	public CheckOutOverviewPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(className = "summary_total_label")
	public WebElement totalPrice;

	@FindBy(id = "finish")
	WebElement finishBtn;

	private double totalPriceValue = 0;
	@FindBy(className = "inventory_item_price")
	List<WebElement> priceList;

	@FindBy(className = "summary_tax_label")
	WebElement taxValue;

	public void finishCheckout() throws InterruptedException {
		scrolltoElement(finishBtn);
		clickButton(finishBtn);
	}

	public void getTotalitemsPrice() {
		priceList.forEach(e -> addToTotal(Double.parseDouble(e.getText().split("\\$")[1])));
	}

	public void addToTotal(double price) {
		totalPriceValue += price;
	}

	public double getTotalPrice() {
		totalPriceValue = 0;
		getTotalitemsPrice();
		DecimalFormat format = new DecimalFormat("0.0#");
		return Double
				.parseDouble(format.format(totalPriceValue + Double.parseDouble(taxValue.getText().split("\\$")[1])));
	}

	public double getActualPrice() {
		return Double.parseDouble(totalPrice.getText().split("\\$")[1]);
	}
}
