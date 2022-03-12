package tests;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import base.TestBase;
import io.ExcelParser;
import pages.CheckOutOverviewPage;
import pages.CheckoutComplete;
import pages.CheckoutInformationPage;
import pages.ProductsPage;
import pages.UserLoginPage;
import pages.YourCartPage;

public class UserLoginTest extends TestBase {
	UserLoginPage loginObject;
	ProductsPage productsObject;
	YourCartPage yourCartPageObject;
	CheckoutInformationPage checkoutInfoObject;
	CheckOutOverviewPage checkoutOverviewObject;
	CheckoutComplete checkoutCompleteObject;

	@Test
	public void userCanLoginSuccessfully() throws InterruptedException {
		ExtentTest test = report.startTest("Lgoin");
		loginObject = new UserLoginPage(driver);
		loginObject.userLogin(ExcelParser.getTestData().get("Username"), ExcelParser.getTestData().get("Password"));
		test.log(LogStatus.PASS, "Login Successful");
		report.endTest(test);
	}

	@Test(dependsOnMethods = { "userCanLoginSuccessfully" })
	public void addProductsToCartSuccessfully() throws InterruptedException {
		ExtentTest test = report.startTest("Add Expensive Products in Cart");
		productsObject = new ProductsPage(driver);

		productsObject.addExpensiveProductsToCart();
		test.log(LogStatus.PASS, "Products added successfully");
		report.endTest(test);
	}

	@Test(dependsOnMethods = { "addProductsToCartSuccessfully" })
	public void proceedToCheckoutPageAndPlaceOrder() throws InterruptedException {
		ExtentTest test = report.startTest("Proceed to Checkout");
		productsObject = new ProductsPage(driver);

		productsObject.viewMyCartPage();

		yourCartPageObject = new YourCartPage(driver);

		yourCartPageObject.proceedToCheckout();

		checkoutInfoObject = new CheckoutInformationPage(driver);

		checkoutInfoObject.submittingCheckoutInfo(ExcelParser.getTestData().get("First Name"),
				ExcelParser.getTestData().get("Last Name"), ExcelParser.getTestData().get("Zip Code"));

		checkoutOverviewObject = new CheckOutOverviewPage(driver);

//		assertTrue(checkoutOverviewObject.totalPrice.getText().contains("$86.38"));
		Assert.assertEquals(checkoutOverviewObject.getActualPrice(), checkoutOverviewObject.getTotalPrice());
		checkoutOverviewObject.finishCheckout();
		test.log(LogStatus.PASS, "Proceeded Successfully");
		report.endTest(test);
	}

	@Test(dependsOnMethods = { "proceedToCheckoutPageAndPlaceOrder" })
	public void validateOrderPlacedSuccessfully() throws InterruptedException {
		ExtentTest test = report.startTest("Validate Placing Order");
		checkoutCompleteObject = new CheckoutComplete(driver);

		assertTrue(checkoutCompleteObject.SuccessfulOrderMessage.getText().contains("THANK YOU"));

		checkoutCompleteObject.returnToProductsPage();
		test.log(LogStatus.PASS, "Order Placed Successfully");
		report.endTest(test);
	}
}
