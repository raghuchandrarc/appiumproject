package reusableComponents;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.nativeapp.demo.BaseTest;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
public class TestListener extends BaseTest implements ITestListener {
	 
    //Extent Report Declarations
    public  ExtentReports extent = ExtentManager.createInstance();
   // public  ThreadLocal<ExtentTest> test = new ThreadLocal<>();
 
    @Override
    public synchronized void onStart(ITestContext context) {
        System.out.println(" Test Suite started!");
    }
 
    @Override
    public synchronized void onFinish(ITestContext context) {
        System.out.println((" Test Suite is ending!"));
        extent.flush();
    }
 
    @Override
    public synchronized void onTestStart(ITestResult result) {
        System.out.println((result.getMethod().getMethodName() + " started!"));
        //ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName(),result.getMethod().getDescription());
       //test.set(extentTest);
    }
 
    @Override
    public synchronized void onTestSuccess(ITestResult result) {
        System.out.println((result.getMethod().getMethodName() + " passed!"));
        //test.get().pass("Test passed");
    }
 
    @Override
    public synchronized void onTestFailure(ITestResult result) {
        System.out.println((result.getMethod().getMethodName() + " failed!"));
       // test.get().fail(result.getThrowable());
    }
 
    @Override
    public synchronized void onTestSkipped(ITestResult result) {
        System.out.println((result.getMethod().getMethodName() + " skipped!"));
        //test.get().skip(result.getThrowable());
    }
 
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println(("onTestFailedButWithinSuccessPercentage for " + result.getMethod().getMethodName()));
    }
}
