package com.qmetry.qaf.example.pages;

import java.net.MalformedURLException;

import com.qmetry.qaf.automation.ui.WebDriverTestBase;

import io.appium.java_client.android.AndroidDriver;

public class DriverUtils {

	@SuppressWarnings("rawtypes")
	private static AndroidDriver driver;

	@SuppressWarnings("rawtypes")
	public static AndroidDriver getAndroidDriver() throws MalformedURLException, InterruptedException {

		driver = (AndroidDriver) new WebDriverTestBase().getDriver().getUnderLayingDriver();
		return driver;
	}

}
