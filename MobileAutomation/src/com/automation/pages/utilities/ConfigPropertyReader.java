package com.automation.pages.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * This class is used to read properties from config.properties
 * 
 * @author chirag.khimani
 * 
 */
public class ConfigPropertyReader {
	private String deviceName;
	private String appiumServerURL;
	private String retryCount;
	private String defaultTimeOut;

	public ConfigPropertyReader() {
		loadProperties("resources\\config.properties");
	}

	public void loadProperties(String propPath) {
		Properties properties = new Properties();
		InputStream input = null;

		try {
			input = new FileInputStream(propPath);
			properties.load(input);
			deviceName = properties.getProperty("automation.deviceName");
			appiumServerURL = properties.getProperty("appium.server");
			retryCount = properties.getProperty("retry.count");
			defaultTimeOut = properties.getProperty("selenium.defaultTimeOut");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public String getRetryCount() {
		return retryCount;
	}

	public String getDefaultTimeOut() {
		return defaultTimeOut;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public String getAppiumServerURL() {
		return appiumServerURL;
	}

}
