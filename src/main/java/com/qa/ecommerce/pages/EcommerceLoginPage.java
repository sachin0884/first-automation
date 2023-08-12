package com.qa.ecommerce.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import com.qa.ecommerce.Utility.Utility;
import com.qa.ecommerce.constants.AppConstants;

public class EcommerceLoginPage {

	private WebDriver driver;
	private Utility util;

	private By userName = By.id("input-email");
	private By password = By.id("input-password");
	private By forgotPwdLink = By.linkText("Forgotten Password");
	private By Loginbtn = By.xpath("//input[@class='btn btn-primary']");
	private By registerLink = By.xpath("//div[@class='list-group']/a[position()=2]");

	public EcommerceLoginPage(WebDriver driver) {
		this.driver = driver;
		util = new Utility(driver);
	}

	public String getLoginPageTitile() {
		String pageTitle = driver.getTitle();
		System.out.println("Title of the page is ::-" + pageTitle);
		return pageTitle;
	}

	public String getLoginPageUrl() {
		String pageUrl = driver.getCurrentUrl();
		System.out.println("current url is ::-" + pageUrl);
		return pageUrl;
	}

	public boolean getForgotPwdLinkVisible() {
		return util.getElementWithWait(forgotPwdLink, AppConstants.DEFAULT_MEDIUM_TIME_OUT).isDisplayed();
	}

	public AccountPage dologin(String username, String pwd) {
		util.getElement(userName).clear();
		util.getElementWithWait(userName, AppConstants.DEFAULT_MEDIUM_TIME_OUT).sendKeys(username);
		util.doSendKeys(password, pwd);
		util.doClick(Loginbtn);
		return new AccountPage(driver);
	}
	
	public RegisterUserPage nevigateToRegistration() {
		util.doClickByAction(registerLink);
		return new RegisterUserPage(driver);
	}
}
