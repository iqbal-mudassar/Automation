package utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener{

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		screenshot.takeScreenshot();
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		screenshot.takeScreenshot();
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		screenshot.takeScreenshot();
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		screenshot.takeScreenshot();
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		//screenshot.takeScreenshot();
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
