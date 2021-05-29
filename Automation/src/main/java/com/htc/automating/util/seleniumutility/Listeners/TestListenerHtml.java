package com.htc.reports;
import java.util.concurrent.TimeUnit;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.htc.automating.base.BaseTest;
import com.htc.automating.util.ScreenShots;

public class TestListenerHtml extends BaseTest implements ITestListener{
	private long start_time;
	
	public void onStart(ITestContext context) {
		long start_time =TimeUnit.MILLISECONDS.toMinutes(System.currentTimeMillis());
		System.out.println("*** Test Suite " + context.getName() + " started ***");
	}
	
	public void onFinish(ITestContext context) {
		System.out.println(("*** Test Suite " + context.getName() + " ending ***"));
		ExtentTestReport.endTest();
		long end_time=TimeUnit.MILLISECONDS.toMinutes(System.currentTimeMillis());
		long totaltime =end_time-start_time;
		System.out.println("Time taken to run the test is "+totaltime);
	}

	public void onTestStart(ITestResult result) {
		System.out.println(("*** Running test method " + result.getMethod().getMethodName() + "..."));
		System.out.println("*** Test Suite " + result.getName() + " started ***");
		ExtentTestReport.startTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("*** Executed " + result.getMethod().getMethodName() + " test successfully...");
		ExtentTestReport.getTest().log(Status.PASS, "Test passed");
		ScreenShots shot = new ScreenShots(driver);
		shot.capturingScreenShot();
	}
	
	public void onTestFailure(ITestResult result) {
		System.out.println("*** Test execution " + result.getMethod().getMethodName() + " failed...");
		System.out.println(result.getName());
		//ExtentTestReport.getTest().log(Status.FAIL, "Test Failed");
		ScreenShots shot = new ScreenShots(driver);  
		shot.addingScreenshotToReport();
		ExtentTestReport.getTest().log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable().getMessage(), ExtentColor.BLUE));
		
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("*** Test " + result.getMethod().getMethodName() + " skipped...");
		ExtentTestReport.getTest().log(Status.SKIP, "Test Skipped");
		System.out.println(result.getSkipCausedBy());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("*** Test failed but within percentage % " + result.getMethod().getMethodName());
	}
}
