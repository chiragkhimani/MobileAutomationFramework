package com.automation.pages.base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import com.automation.pages.utilities.ConfigPropertyReader;

public class DriverUtility {
	public static AppiumDriver<AndroidElement> driver;
	ConfigPropertyReader config = new ConfigPropertyReader();

	/**
	 * This method is used to get driver of Appium
	 * 
	 * @return driver
	 */

	public AppiumDriver<AndroidElement> getDriver() {
		return driver;
	}

	public void initialize(AppiumDriver<AndroidElement> driver) {
		DriverUtility.driver = driver;
	}

	public List<AndroidElement> getElementListByResourceId(String resource_id) {
		String xpath = "//*[@resource-id=\"%s\"]";
		xpath = String.format(xpath, resource_id);
		waitForElementPresent(xpath);
		List<AndroidElement> ele = driver.findElements(By.xpath(xpath));
		return ele;
	}

	public void waitForElementPresent(String locator) {
		WebDriverWait wait = new WebDriverWait(getDriver(),
				Long.parseLong(config.getDefaultTimeOut()));
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By
					.xpath(locator)));
		} catch (Exception e) {

		}

	}

	public WebElement getElementByResourceId(String resource_id) {
		waitForElementPresent(CommonUtility
				.convertXpathFromResourceId(resource_id));
		return driver.findElement(By.xpath(CommonUtility
				.convertXpathFromResourceId(resource_id)));
	}

	public WebElement getElementByText(String text) {
		waitForElementPresent(CommonUtility.convertXpathFromText(text));
		return driver.findElement(By.xpath(CommonUtility
				.convertXpathFromText(text)));
	}

	public void verifyPresent(WebElement element) {
		Assert.assertEquals(element.isDisplayed(), true);
	}

}
