package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.PageBase;

public class ProductsPage extends PageBase {

	public ProductsPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(id = "add-to-cart-sauce-labs-backpack")
	WebElement BackPackBtn;

	@FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
	WebElement JacketBtn;

	@FindBy(className = "shopping_cart_link")
	WebElement ShoppingCartIcon;

	@FindBy(className = "product_sort_container")
	WebElement sortList;

	public void addExpensiveProductsToCart() throws InterruptedException {
		selectitemFromList(sortList, "hilo");
		clickButton(BackPackBtn);

		clickButton(JacketBtn);

	}

	public void viewMyCartPage() throws InterruptedException {
		clickButton(ShoppingCartIcon);

	}

}
