package com.qa.ecommerce.pages;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.ecommerce.Utility.Utility;
import com.qa.ecommerce.constants.AppConstants;

public class productInfoPage {
	
	private WebDriver driver;
	private Utility util;
	private Map<String,String> productInfo;
	
	private By productText= By.tagName("h1");
	private By productData= By.xpath("(//div[@class='col-sm-4']//ul[@class='list-unstyled'][position()=1])/li");
	private By productPrice= By.xpath("(//div[@class='col-sm-4']//ul[@class='list-unstyled'][position()=2])/li");
	private By productqty = By.id("input-quantity");
	private By addtocartBtn = By.id("button-cart");
	private By successMsg = By.cssSelector("div.alert.alert-success");

	public productInfoPage(WebDriver driver) {
		this.driver= driver;
		util= new Utility(driver);
	}

	public String getProductText() {
		String producHeader =driver.findElement(productText).getText();
		return producHeader;
	}
	
	public Map<String,String> getProductMetaData() {
		productInfo= new LinkedHashMap<String,String>();
		getProductHeader();
		getProductInfo();
		getProductPrice();
		return productInfo;
	}
	
	private void getProductInfo() {
		//productInfo= new LinkedHashMap<String,String>();
		List<WebElement> productInfoList= util.getElements(productData);
		for(WebElement e:productInfoList) {
			String meta= e.getText();
			String metainfo[]= meta.split(":");
			String key =metainfo[0].trim();
			String value =metainfo[1].trim();
			productInfo.put(key, value);	
		}
		
		
	}
	public void getProductPrice() {
	   // productInfo = new LinkedHashMap<String,String>();
		List<WebElement>productPriceData= util.getElements(productPrice);
		String price= productPriceData.get(0).getText();
		String taxPrice= productPriceData.get(1).getText();
		String taxVal= taxPrice.split(":")[0].trim();
		productInfo.put("priceData", price);
		productInfo.put("exTax", taxVal);
	}
	
	private void getProductHeader() {
	    productInfo = new LinkedHashMap<String,String>();
		productInfo.put("productheading", getProductText());
	}
	
	public void addProductQuantity(int quantity) {
		util.doSendKeys(productqty, String.valueOf(quantity));
	}
	
	public void addProductToCart() {
		util.doClick(addtocartBtn);
	}
	public String sucessMessage() {
		String SucessMsg= util.getElementWithWait(successMsg, AppConstants.DEFAULT_MEDIUM_TIME_OUT).getText();
		System.out.println(SucessMsg);
		return SucessMsg;
	}
}
