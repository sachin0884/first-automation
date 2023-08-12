package com.qa.ecommerce.test;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.ecommerce.base.BaseTest;

public class productInfoPageTest extends BaseTest {

	@BeforeClass
	public void productInfoPageSetUp() {
		accountpage = ecommerceloginpage.dologin(prop.getProperty("username"), prop.getProperty("password"));
//		searchpage= accountpage.getSearch(searchKey);
//    	productinfopage = searchpage.selecProduct(productName);
	}

	@DataProvider
	public Object[][] getProductKeyData() {
		return new Object[][] { { "Macbook", "MacBook" }, { "Macbook", "MacBook Air" }, { "Macbook", "MacBook Pro" },
				{ "Samsung", "Samsung SyncMaster 941BW" }, { "Samsung", "Samsung Galaxy Tab 10.1" }, { "iMac", "iMac" },
				{ "Apple", "Apple Cinema 30\"" } };
	}

	@Test(dataProvider = "getProductKeyData", priority = 1)
	public void getProductMetaDataTest(String searchKey, String productName) {
		searchpage = accountpage.getSearch(searchKey);
		productinfopage = searchpage.selecProduct(productName);
		Map<String, String> prodInfo = productinfopage.getProductMetaData();
		System.out.println(prodInfo);
	}

	//Success: You have added MacBook Air to your shopping cart!
	@Test (priority=2)
	public void addProductToCart() {
		searchpage = accountpage.getSearch("Macbook");
		productinfopage = searchpage.selecProduct("MacBook Air");
		productinfopage.addProductQuantity(2);
		productinfopage.addProductToCart();
		String actualMsg= productinfopage.sucessMessage();
		softassert.assertTrue(actualMsg.contains("Success"));
		softassert.assertTrue(actualMsg.contains("MacBook Air"));
		
		softassert.assertEquals(actualMsg, "Success: You have added MacBook Air to your shopping cart!");
		softassert.assertAll();
	}
}
