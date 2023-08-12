package com.qa.ecommerce.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.ecommerce.base.BaseTest;
import com.qa.ecommerce.constants.AppConstants;
import com.qa.ecommerce.pages.AccountPage;

public class LoginPageTest extends BaseTest {

	@Test(priority = 1)
	public void getLoginPageTitileTest() {
		String actualtitle = ecommerceloginpage.getLoginPageTitile();
		Assert.assertEquals(actualtitle, AppConstants.LOGIN_PAGE_TITLE);
	}

	@Test(priority = 2)
	public void getLoginPageUrlTest() {
		String currentUrl = ecommerceloginpage.getLoginPageUrl();
		Assert.assertTrue(currentUrl.contains(AppConstants.LOGING_PAGE_URL));
	}

	@Test(priority = 3)
	public void getForgotPwdLinkVisibleTest() {
		Assert.assertTrue(ecommerceloginpage.getForgotPwdLinkVisible());
	}

	@Test(priority = 4)
	public void dologinTest() {
		accountpage= ecommerceloginpage.dologin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(accountpage.getAccountPageTitle(), AppConstants.ACCOUNT_PAGE_TITLE);
	}
}
