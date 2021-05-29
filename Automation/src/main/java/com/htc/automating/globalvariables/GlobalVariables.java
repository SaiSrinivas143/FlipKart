package com.htc.automating.globalvariables;

public class GlobalVariables {
	//<-------------chrome and firefox drivers path-------------------->
	public static final String CHROME_DRIVER="webdriver.chrome.driver";
	
	public static final String CHROME_DRIVER_PATH="./src/main/resources/chromedriver_win321/chromedriver.exe";
	
	public static final String GECKO_DRIVER = "webdriver.gecko.driver";
	
	public static final String GECKO_DRIVER_PATH ="./src/main/resources/geckodriver-v0.29.0-win64/geckodriver.exe";
	
	public static final String EDGE_DRIVER = "webdriver.edge.driver";
	
	public static final String EDGE_DRIVER_PATH = "./src/main/resources/edgedriver_win64 (1)/msedgedriver.exe";
	
	public static final String IE_DRIVER = "webdriver.ie.driver";
	
	public static final String IE_DRIVER_PATH = "./src/main/resources/IEDriverServer_x64_3.150.1 (1)/IEDriverServer.exe";
	
	public static final String Hub_Url="http://192.168.43.5:4444/wd/hub";
	
	//<--------------xlfile sheet_name and location--------------------->
	public static final String XL_INPUT_PATH="./src/main/resources/userlogindetails2.xlsx";
	
	public static final String SHEET_NAME="userlogs";
	
	//<---------------Paths for HTML Reports and Screenshots---------------->
	public static final String HTML_REPORT_PATH= "./src/test/resources";
	
	public static final String REPORT_SCREENSHOT_PATH1="./src/test/resources/screenshots/failedtestsscreenshots/";
	
	public static final String REPORT_SCREENSHOT_PATH2=System.getProperty("user.dir")+"\\git\\repository\\Automation\\src\\test\\resources\\screenshots\\failedtestsscreenshots";
	
	public static final String SCREENSHOT_PATH="./src/test/resources/screenshots/passedtestsscreenshots/";
	
	//<------------------Madison Island Website Url---------------------->
	public static final String URL="https://www.flipkart.com/";
	
	//<-----------------Default timeout for for all waits----------------------->
	public static final long TIMEOUT_TIME = 30;

	//<-----------------Database Connection Properties-------------------------->
	public static final String DB_PROPERTIES_FILE_PATH= "./src/main/resources/DbConnection.properties";
		
	//<-----------------User Number----------------------------------------->
	public static final String USERNAME = "";
	
}