package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReportManager implements ITestListener
{
		  public ExtentSparkReporter sparkReporter;
		  public ExtentReports extent;
		  public ExtentTest test;
		  
		  String repName;
		  
		  public void onStart(ITestContext testContext)
		  {
			  String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			  repName="Test-Report-"+timeStamp+".html";
			 sparkReporter=new ExtentSparkReporter(".\\reports\\"+repName);
			//  sparkReporter=new ExtentSparkReporter("C:\\Users\\Kishore kumar Reddy\\eclipse-workspace\\automationproject\\EReports\\repo.html");
			  sparkReporter.config().setDocumentTitle("Automation Report");
			  sparkReporter.config().setReportName("Functional Testing");
			  sparkReporter.config().setTheme(Theme.STANDARD);
			   
			  extent=new ExtentReports();
			  extent.attachReporter(sparkReporter);
			  
			  extent.setSystemInfo("Application","opencart");
			  extent.setSystemInfo("Module","Admin");
			  extent.setSystemInfo("SubModule","Customers");
			  extent.setSystemInfo("Operating System",System.getProperty("os.name"));
			  extent.setSystemInfo("User Name",System.getProperty("user.name"));
			  extent.setSystemInfo("Environment", "QA");
		  }
		  
		  public void onTestSuccess(ITestResult result)
		  {
			  test=extent.createTest(result.getName());
			  test.log(Status.PASS,"Test Passed");
		  }
		 public void onTestFailure(ITestResult result) 
		  {
			  test=extent.createTest(result.getName());
			  test.log(Status.FAIL,"Test Failed");
			  test.log(Status.FAIL, result.getThrowable().getMessage());
			  //u can put try catch block here for both statements
			  String imgPath=new BaseClass().captureScreen(result.getName());
			  test.addScreenCaptureFromPath(imgPath);
		  }
		  public void onTestSkipped(ITestResult result)
		  {
			  test=extent.createTest(result.getName());
			  test.log(Status.SKIP,"Test Skipped");
			  test.log(Status.SKIP,result.getThrowable().getMessage());
		  }
		  public void onFinish(ITestContext testContext)
		  {
			extent.flush();
		  }

}
