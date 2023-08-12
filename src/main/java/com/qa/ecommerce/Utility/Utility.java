package com.qa.ecommerce.Utility;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.ecommerce.factory.DriverFactory;

public class Utility {

	WebDriver driver;

	public Utility(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getElement(By locator) {
		WebElement ele = driver.findElement(locator);
		if(Boolean.parseBoolean(DriverFactory.highlight)) {
			flash(ele);
		}
		return ele;
	}

	public void doClick(By locator) {
		driver.findElement(locator).click();
	}
	
	public List<WebElement> getElements(By locator) {
		List<WebElement>elements= driver.findElements(locator);
		return elements;
	}

	public void doClickWithWait(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.visibilityOf(getElement(locator))).click();
	}

	public WebElement getElementWithWait(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.visibilityOf(getElement(locator)));
	}

	public List<WebElement> getElementsWithWait(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.visibilityOfAllElements(getElement(locator)));
	}
	
	public List<WebElement> getLocatorSwithWait(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait (driver,Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	
	public WebElement getLocatorWithWait(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void doSendKeys(By locator, String Value) {
		driver.findElement(locator).clear();
		getElement(locator).sendKeys(Value);
	}
	
	public void doClickByAction(By locator) {
		Actions act = new Actions(driver);
		act.moveToElement(getElement(locator)).build().perform();
		act.click().build().perform();
	}

	public void changeColor(String color, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.backgroundColor= '"+color+"'", element);
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	public void flash(WebElement element) {
		String bgcolor= element.getCssValue("backgroundColor");
		for(int i = 0; i < 10; i++) {
			changeColor("rgb(255,165,0)", element);
			changeColor(bgcolor, element);
		}
	}
}
