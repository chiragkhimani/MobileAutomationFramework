package com.automation.pages.cucumber;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.automation.pages.base.DriverUtility;
import com.automation.pages.utilities.ConfigPropertyReader;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;

public class StepLib extends DriverUtility {
	public AppiumDriver<AndroidElement> driver;

	@Before
	public void setUp() throws Exception {
		ConfigPropertyReader config = new ConfigPropertyReader();
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", config.getDeviceName());
		System.out.println("Createing driver");
		driver = new AndroidDriver<>(new URL(config.getAppiumServerURL()
				+ "4723/wd/hub"), capabilities);
		initialize(driver);
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Given("^This is first behavior file$")
	public void am_on_the_admin_page_of_store_browser() {
		System.out.println("first File");
	}
}
