package com.qa.ecommerce.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.qa.ecommerce.factory.DriverFactory;
import com.qa.ecommerce.pages.AccountPage;
import com.qa.ecommerce.pages.EcommerceLoginPage;
import com.qa.ecommerce.pages.RegisterUserPage;
import com.qa.ecommerce.pages.SearchPage;
import com.qa.ecommerce.pages.productInfoPage;

public class BaseTest {

	WebDriver driver;
	DriverFactory df;
	protected Properties prop;
	protected EcommerceLoginPage ecommerceloginpage;
	protected AccountPage accountpage;
	protected SearchPage searchpage;
	protected productInfoPage productinfopage;
	protected SoftAssert softassert;
	protected RegisterUserPage registeruserpage;

	@BeforeTest
	public void setup() {
		df = new DriverFactory();
		prop= df.initProperties();
		driver = df.initDriver(prop);
		ecommerceloginpage = new EcommerceLoginPage(driver);
		softassert = new SoftAssert();
	}

//	@AfterTest
//	public void tearDown() {
//		driver.quit();
//	}
}
