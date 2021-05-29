package com.htc.automating.util.seleniumutility.listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.htc.automating.base.BaseTest;
import com.htc.automating.util.javautility.Loggers;
import com.htc.automating.util.javautility.MyException;
import com.htc.automating.util.seleniumutility.screenshots.ScreenShots;

public class TestListener extends BaseTest implements ITestListener,ISuiteListener{
	
	public void onStart(ISuite suite) {
		try {
			System.out.println("*** Test Suite " + suite.getName() + " started ***");
			Loggers.info(suite.getName(), " Started");
		} catch (MyException e) {
			e.printStackTrace();
		}
	}
	
	public void onFinish(ISuite suite) {
		try {
			System.out.println(("*** Test Suite " + suite.getName() + " ending ***"));
			extent.flush();
			Loggers.info(suite.getName(), " Ended");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void onTestStart(ITestResult result) {
		try {
			System.out.println(("*** Running test method " + result.getName() + "..."));
			test=extent.createTest(result.getName());
			parent = test.createNode(result.getName());
			Loggers.info(result.getName(), "Test started");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void onTestSuccess(ITestResult result) {
		try {
			System.out.println("*** Executed " + result.getMethod().getMethodName() + " test successfully...");
			child= parent.createNode("Passed");
			child.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Passed", ExtentColor.GREEN));
			shot = new ScreenShots(driver);
			shot.capturingScreenShot();
			Loggers.info(result.getName(), "Test completed successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void onTestFailure(ITestResult result) { 
		try {
			System.out.println("*** Test execution " + result.getName() + " failed...");
			System.out.println(result.getName());
			child= parent.createNode(result.getName());
			child.log(Status.FAIL, result.getThrowable());
			child.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" Failed", ExtentColor.RED));
			//test.log(Status.FAIL, Reporter.getOutput().toString());
			//test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" Failed", ExtentColor.RED));
			shot = new ScreenShots(driver); 
			shot.addingScreenshotToReport(test);
			Loggers.info(result.getName(), "Test failed due to "+result.getThrowable());
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	public void onTestSkipped(ITestResult result) {
		try {
			System.out.println("*** Test " + result.getMethod().getMethodName() + " skipped...");
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" Skipped", ExtentColor.ORANGE));
			System.out.println(result.getSkipCausedBy());
			Loggers.info(result.getClass().getName(), "Test skipped due to "+result.getSkipCausedBy());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		try {
			System.out.println("*** Test failed but within percentage % " +ITestResult.SUCCESS_PERCENTAGE_FAILURE+" "+result.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}