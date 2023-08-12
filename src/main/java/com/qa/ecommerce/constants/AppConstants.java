package com.qa.ecommerce.constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppConstants {
	
	public static final List<String> EXPECTED_ACCOUNTS_PAGE_HEADERS_LIST = Arrays.asList("My Account, My Orders, My Affiliate Account, Newsletter");
	//public static final List<String> EXPECTE_PRODUCT_NAMES= Arrays.asList("MacBook, MacBook Air, MacBook Pro");
	
	public static final int DEFAULT_MEDIUM_TIME_OUT = 5;
	public static final int DEFAULT_LOW_TIME_OUT = 3;
	public static final int DEFAULT_HIGH_TIME_OUT =10;
	public static final int ACCOUNT_PAGE_HEADER_COUNT = 4;
	
	public static final String LOGIN_PAGE_TITLE = "Account Login";
	public static final String LOGING_PAGE_URL = "route=account/login";
	public static final String ACCOUNT_PAGE_TITLE ="My Account";
	public static final String ACCOUNT_PAGE_URL= "route=account/account";

	public static final String SEARCH_PAGE_TITLE = "Search -";
	public static final String SEARCH_PAGE_URL = "https://naveenautomationlabs.com/opencart/index.php?route=product/search&search=";
	public static final String USER_REGISTRATION_SUCCESS_MSG = "Your Account Has Been Created";
	
	
    //********************************excel sheet data************************************
	public static final String REGISTER_USER_SHEET = "register";
}
