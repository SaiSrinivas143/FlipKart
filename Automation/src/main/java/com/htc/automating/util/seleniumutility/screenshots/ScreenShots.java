package com.htc.automating.util.seleniumutility.screenshots;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import com.htc.automating.globalvariables.GlobalVariables;
import com.htc.automating.util.javautility.MyException;

public class ScreenShots {
	private WebDriver driver;
	TakesScreenshot tss;
	File srcfile,destfile;
	String timestamp= new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date());
	String destination;
	
	public ScreenShots(WebDriver driver) {
		this.driver=driver;
	}
	
	public void capturingScreenShot() throws MyException {		
		try {
			tss=(TakesScreenshot)driver;
			srcfile=tss.getScreenshotAs(OutputType.FILE);
			destfile= new File(GlobalVariables.SCREENSHOT_PATH+"Test "+timestamp+".png");
			Thread.sleep(5000);
			FileUtils.copyFile(srcfile, destfile);
		} catch (Exception e) {
			throw new MyException(e.getMessage());
		} 
	}

	public void addingScreenshotToReport(ExtentTest test) throws MyException{
		try {
			tss=(TakesScreenshot)driver;
			srcfile=tss.getScreenshotAs(OutputType.FILE);
			String pic="Test "+timestamp+".png";
			destination=GlobalVariables.REPORT_SCREENSHOT_PATH1+pic;
			destfile= new File(destination);
			Thread.sleep(5000);
			FileUtils.copyFile(srcfile, destfile);
			//test.fail("Screenshot",MediaEntityBuilder.createScreenCaptureFromPath(GlobalVariables.HTML_REPORT_PATH).build());
			test.fail("failed "+test.addScreenCaptureFromPath(GlobalVariables.REPORT_SCREENSHOT_PATH2+pic));
		} catch (Exception e) {
			throw new MyException(e.getMessage());
		} 
	}
}