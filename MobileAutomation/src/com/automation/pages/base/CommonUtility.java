package com.automation.pages.base;

public class CommonUtility {
	
	/**
	 * This method is used to convert xPath from ResourceId
	 * @param resourceId
	 * @return xPath
	 */
	public static String convertXpathFromResourceId(String resourceId) {
		String xpath = "//*[@resource-id=\"%s\"]";
		xpath = String.format(xpath, resourceId);
		return xpath;
	
	}
	
	/**
	 * This method is used to conver xPath from Text
	 * @param text
	 * @return xPath
	 */

	public static String convertXpathFromText(String text) {
		String xpath = "//*[@text=\"%s\"]";
		xpath = String.format(xpath, text);
		return xpath;
	}
	
	
	/**
	 * static wait for millisecond
	 * @param millis
	 */
	public static void wait(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
