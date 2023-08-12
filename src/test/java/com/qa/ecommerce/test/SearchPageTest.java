package com.qa.ecommerce.test;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.ecommerce.base.BaseTest;
import com.qa.ecommerce.constants.AppConstants;

public class SearchPageTest extends BaseTest{
	
	@BeforeClass
	public void searchPageSetUp() {
		accountpage= ecommerceloginpage.dologin(prop.getProperty("username"), prop.getProperty("password"));
		//accountpage.getSearch(null);
	}
	
	@DataProvider
	public Object[][] getSearchKeyTestData() {
		return new Object[][] {
			{"Macbook"},
			{"Samsung"},
			{"iMac"},
			{"Apple"}
		};
	}
	
	@DataProvider
	public Object[][] getProductKeyData() {
		return new Object[][] {
			{"Macbook","MacBook"},
			{"Macbook","MacBook Air"},
			{"Macbook","MacBook Pro"},
			{"Samsung","Samsung SyncMaster 941BW"},
			{"Samsung","Samsung Galaxy Tab 10.1"},
			{"iMac","iMac"},
			{"Apple", "Apple Cinema 30\""}
		};
	}
	
	@Test(priority=0, dataProvider= "getSearchKeyTestData")
	public void getSearchTest(String searchKey) {
		searchpage= accountpage.getSearch(searchKey);
		Assert.assertTrue(searchpage.getSearchPageTitle().contains("Search"));
	}
	
    @Test (priority=1)
	public void getSearchPageTitleTest() {
		String actualTitle= searchpage.getSearchPageTitle();
		Assert.assertTrue(actualTitle.contains(AppConstants.SEARCH_PAGE_TITLE));
	}
    @Test (priority=2)
    public void getSearchPageUrlTest() {
    	String actualUrl= searchpage.getSearchPageUrl();
    	Assert.assertTrue(actualUrl.contains(AppConstants.SEARCH_PAGE_URL));
    }
    @Test (priority=3)
    public void getSearchProductValueTest() {
    	List<String> actualValue= searchpage.getSearchProductValue();
    	//Assert.assertEquals(actualValue, AppConstants.EXPECTE_PRODUCT_NAMES);
    }
    @Test (priority=4, dataProvider="getProductKeyData")
    public void selecProductTest(String searchKey, String productName) {
    	searchpage= accountpage.getSearch(searchKey);
    	productinfopage = searchpage.selecProduct(productName);
    	String actualProdName= productinfopage.getProductText();
    	Assert.assertEquals(actualProdName, productName);
    }
}
