package com.qa.ecommerce.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.aspectj.util.FileUtil;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

public class DriverFactory {

	public WebDriver driver;
	public Properties prop;
	public OptionsManager optionsmanager;
	public static String highlight;

	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

	public WebDriver initDriver(Properties prop) {
		optionsmanager = new OptionsManager(prop);
		highlight = prop.getProperty("highlight").trim();

		String browserName = prop.getProperty("browser").trim().toLowerCase();

		System.out.println("Browser name is::- " + browserName);

		if (browserName.equalsIgnoreCase("chrome")) {
			// driver = new ChromeDriver(optionsmanager.getChromeOptions());
			tlDriver.set(new ChromeDriver(optionsmanager.getChromeOptions()));
		}
		if (browserName.equalsIgnoreCase("firefox")) {
			// driver = new FirefoxDriver(optionsmanager.getFirefoxOptions());
			tlDriver.set(new FirefoxDriver(optionsmanager.getFirefoxOptions()));
		}
		if (browserName.equalsIgnoreCase("Edge")) {
			// driver = new EdgeDriver(optionsmanager.getEdgeOptions());
			tlDriver.set(new EdgeDriver(optionsmanager.getEdgeOptions()));
		} else {
			System.out.println("Please pass the correct browsername::-" + browserName);
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().get(prop.getProperty("url"));
		return getDriver();
	}

	public Properties initProperties() {
		prop = new Properties();

		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/properties/config.properties");
			try {
				prop.load(ip);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return prop;
	}

	public synchronized static WebDriver getDriver() {
		return tlDriver.get();
	}

	public static String getScreenshot() {
		File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtil.copyFile(destination, srcFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}

}
