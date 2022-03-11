package base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;

import io.ExcelParser;
import utils.Constants;

public class TestBase {
	public static WebDriver driver;
	protected ExtentReports report;

	@BeforeSuite
	public void startDrvier() throws InterruptedException {
		report = new ExtentReports(System.getProperty("user.dir") + "/ExtentReportResults.html");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.navigate().to("https://www.saucedemo.com/");
		ExcelParser.setExcelFile(Constants.TESTDATA, Constants.TESTDATASHEET);
	}

	@AfterSuite
	public void closeDriver() {
		driver.quit();
		report.flush();
	}
}
