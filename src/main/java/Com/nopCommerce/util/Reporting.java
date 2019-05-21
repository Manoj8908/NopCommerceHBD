package Com.nopCommerce.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter{
	
	public ExtentHtmlReporter htmlreporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
	public void onStart(ITestContext textcontext) {
		
		String dateName = new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());
		String RepName = "Test-report-"+dateName+".html";
		htmlreporter = new ExtentHtmlReporter("./Reports/"+RepName);
		htmlreporter.loadXMLConfig(System.getProperty("user.dir")+ "/extent-config.xml");
		
		extent = new ExtentReports();
		extent.attachReporter(htmlreporter);
		extent.setSystemInfo("Hostname", "ManojSitu");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Tester", "Manoj");
		
		htmlreporter.config().setDocumentTitle("Automation Test");
		htmlreporter.config().setReportName("Functional Test");
		htmlreporter.config().setTheme(Theme.DARK);
		
		
	}
	public void onTestSuccess(ITestResult tr) {
		
		logger=extent.createTest(tr.getName());
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN));
		
	}
	public void onTestFailure(ITestResult tr) {
		
		logger=extent.createTest(tr.getName());
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(),ExtentColor.RED));
		
		String Screenshotpath=System.getProperty("user.dir")+"\\ScreenShots\\"+tr.getName()+".png";
		File f = new File(Screenshotpath);
		
		if(f.exists()) {
			
			try {
				logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(Screenshotpath));
				}
			catch (IOException e){
				System.out.println("The Exception is:"+e.getMessage());
			}
		}
	}
	public void onTestSkipped(ITestResult tr) {
		
		logger=extent.createTest(tr.getName());
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
	}
	public void onFinish(ITestContext textcontext) {
		
		extent.flush();
		
	}

}
