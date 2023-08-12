package com.qa.ecommerce.test;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.ecommerce.base.BaseTest;
import com.qa.ecommerce.constants.AppConstants;

import bsh.util.Util;

public class AccountPageTest extends BaseTest{
	
	@BeforeClass
	public void accountPageSetup() {
		accountpage= ecommerceloginpage.dologin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test (priority=1)
	public void getAccountPageTitleTest() {
		String actTitle= accountpage.getAccountPageTitle();
		Assert.assertEquals(actTitle, AppConstants.ACCOUNT_PAGE_TITLE);
	}
	
	@Test (priority=2)
	public void getAccountPageUrlTest() {
		String actUrl= accountpage.getAccountPageUrl();
		Assert.assertTrue(actUrl.contains(AppConstants.ACCOUNT_PAGE_URL));
	}
	@Test (priority=3)
	public void getAccountHeaderListTest() {		
		List<String> accountheadList= accountpage.getAccountHeaderList();
		System.out.println("List of headers is ::- " + accountheadList);
		Assert.assertEquals(accountheadList.size(), AppConstants.ACCOUNT_PAGE_HEADER_COUNT);
	}
	@Test (priority=4)
	public void getAccountHeaderValueTest() {		
		List<String> accountheadList= accountpage.getAccountHeaderList();
		System.out.println("Actual List of headers is ::- " + accountheadList);
		System.out.println("Expected list of headers is::- "+ AppConstants.EXPECTED_ACCOUNTS_PAGE_HEADERS_LIST);
	   // Assert.assertEquals(accountheadList, AppConstants.EXPECTED_ACCOUNTS_PAGE_HEADERS_LIST);
	}
	
//	@Test(priority=5)
//	public void getSearch() {
//		searchpage= accountpage.getSearch("samsung");
//		Assert.assertTrue(searchpage.getSearchPageTitle().contains("Search"));
//	}
	
}
