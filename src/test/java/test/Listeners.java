package test;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import utility.Reports;
import utility.Screenshot;

public class Listeners extends BaseTest implements ITestListener {

	public void onTestStart(ITestResult result) {
		System.out.println(result.getName()+"started");
	}
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getName());
	}
	public void onTestFaillure(ITestResult result) {
		test.log(Status.FAIL, result.getName() );
		try {
			Screenshot.clickScreenshot(driver, result.getName());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getName());
	}
	public void onFinish(ITestContext result) {
		reports.flush();
		driver.close();
	}
	public void onStart(ITestContext result) {
		reports=Reports.createReport();
	}
}
