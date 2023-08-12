package com.qa.ecommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.ecommerce.Utility.Utility;
import com.qa.ecommerce.constants.AppConstants;

public class RegisterUserPage {
	
	
	private WebDriver driver;
	private Utility util;
	
	private By firstName = By.xpath("//input[@id='input-firstname']");
	private By lastName = By.id("input-lastname");
	private By emailId = By.id("input-email");
	private By telephone = By.id("input-telephone");
	private By password = By.id("input-password");
	private By confirmpwd= By.id("input-confirm");
	
	private By subscribeYes = By.xpath("//label[normalize-space()='Yes']/input[@type='radio']");
	private By subscribeNo = By.xpath("//label[normalize-space()='No']/input[@type='radio']");
	
	private By checkbox = By.xpath("//input[@type='checkbox']");
	private By continueBtn = By.xpath("//input[@type='submit']");
	
	private By successMsg= By.xpath("//div[@id='content']/h1");
	private By logOutLink = By.linkText("Logout");
	private By registerLink = By.linkText("Register");
	
	
	public RegisterUserPage(WebDriver driver) {
		this.driver= driver;
		util = new Utility(driver);
	}
	
	

	public boolean registerUser(String firstName, String lastName, String emailId, String telephone, 
			String password, String confirmpwd, String Subscribe ) {
		 util.getElementWithWait(this.firstName, AppConstants.DEFAULT_MEDIUM_TIME_OUT).sendKeys(firstName);
		 util.doSendKeys(this.lastName, lastName);
		 util.doSendKeys(this.emailId, emailId);
		 util.doSendKeys(this.telephone, telephone);
		 util.doSendKeys(this.password, password);
		 util.doSendKeys(this.confirmpwd, confirmpwd);
		 
		if(subscribeYes.equals("Yes")) {
			util.doClickByAction(subscribeYes);
		}
		else {
			util.doClickByAction(subscribeNo);
		}
		util.doClickByAction(checkbox);
		util.doClickByAction(continueBtn);
		
		String sucessMessage= util.getElementWithWait(successMsg, AppConstants.DEFAULT_MEDIUM_TIME_OUT).getText();
		System.out.println("User registration success message is::- "+ sucessMessage);
		
		if(sucessMessage.contains(AppConstants.USER_REGISTRATION_SUCCESS_MSG)) {
			util.doClickByAction(logOutLink);
			util.doClickByAction(registerLink);
			return true;
		}
		return false;
		
	}
	

}
