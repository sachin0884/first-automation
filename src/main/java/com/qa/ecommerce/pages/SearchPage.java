package com.qa.ecommerce.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.ecommerce.Utility.Utility;
import com.qa.ecommerce.constants.AppConstants;

public class SearchPage {
	private WebDriver driver;
	private Utility util;
	
	private By searchProductCount= By.xpath("//div[@id='content']//div[contains(@class,'product-layout product')]//div[@class='caption']//a");
    
	public SearchPage(WebDriver driver) {
		this.driver = driver;
		util= new Utility(driver);
	}

	public String getSearchPageTitle() {
		String pageTitle= driver.getTitle();
		System.out.println("search page title is::- "+ pageTitle);
		return pageTitle;
	}
	
	public String getSearchPageUrl() {
		String pageUrl= driver.getCurrentUrl();
		System.out.println("search page url is ::- "+ pageUrl);
		return pageUrl;
	}
	
	public List<String> getSearchProductValue() {
		List<WebElement> productCount= util.getLocatorSwithWait(searchProductCount, AppConstants.DEFAULT_MEDIUM_TIME_OUT);
		List<String> productsCount= new ArrayList<String>();
		for(WebElement e:productCount) {
			String text= e.getText();
			System.out.println("product names are ::- " +text);
			productsCount.add(text);
		}return productsCount;
	}
	
	public productInfoPage selecProduct(String productName) {
	By productLocator= By.linkText(productName);
	util.getLocatorWithWait(productLocator, AppConstants.DEFAULT_MEDIUM_TIME_OUT).click();
	return new productInfoPage(driver);
	}
}
