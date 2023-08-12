package com.qa.ecommerce.pages;

import java.util.ArrayList;
 
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.ecommerce.Utility.Utility;
import com.qa.ecommerce.constants.AppConstants;

public class AccountPage {

	private WebDriver driver;
	private Utility util;
	
	private By headerList = By.xpath("//div[@id='content']/h2");
	private By search = By.xpath("//div[@id='search']/input[contains(@name,'search')]");
	private By logoutLink = By.linkText("Logout");
	private By searchBtn = By.cssSelector(".input-group-btn .btn.btn-default.btn-lg");

	public AccountPage(WebDriver driver) {
		this.driver = driver;
		util = new Utility(driver);
	}

	public String getAccountPageTitle() {
		String accountTitle = driver.getTitle();
		System.out.println("Account page title is ::-" + accountTitle);
		return accountTitle;
	}

	public String getAccountPageUrl() {
		String accountUrl = driver.getCurrentUrl();
		System.out.println("Account Url is ::- " + accountUrl);
		return accountUrl;
	}

	public List<String> getAccountHeaderList() {
		//List<WebElement> headList= driver.findElements(headerList);
		List<WebElement> headList = util.getLocatorSwithWait(headerList, AppConstants.DEFAULT_MEDIUM_TIME_OUT);
		List<String> headCount = new ArrayList<String>();
		for (WebElement e : headList) {
			String text = e.getText();
			headCount.add(text);
			//System.out.println("List of headers is ::- " + headCount);
		}
		return headCount;	
		
	}

	public boolean getLogoutLinkView() {
		return util.getElement(logoutLink).isDisplayed();
	}
	
	
	public SearchPage getSearch(String searchKey) {
		util.doSendKeys(search, searchKey);
		util.doClick(searchBtn);
		return new SearchPage(driver);
	}
}
