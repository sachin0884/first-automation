package com.qa.ecommerce.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.ecommerce.Utility.ExcelUtil;
import com.qa.ecommerce.base.BaseTest;
import com.qa.ecommerce.constants.AppConstants;

public class RegisterUserPageTest extends BaseTest {

	

	@BeforeClass
	public void RegisterUserPageSetUp() {
		registeruserpage = ecommerceloginpage.nevigateToRegistration();
	}

	@DataProvider
	public Object[][] getRegisterTestData() {
		Object regData[][] = ExcelUtil.getTestData(AppConstants.REGISTER_USER_SHEET);
		return regData;
	}

	@Test(dataProvider = "getRegisterTestData")
	public void registerUser(String firstName, String lastName, String emailId, String telephone, String password,
			String confirmpwd, String Subscribe) {

		Assert.assertTrue(registeruserpage.registerUser(firstName, lastName, emailId, telephone, password, confirmpwd,
				Subscribe));
	}

}
